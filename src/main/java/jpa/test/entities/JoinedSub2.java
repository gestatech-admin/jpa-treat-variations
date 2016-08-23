package jpa.test.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "joined_sub_2")
public class JoinedSub2 extends JoinedBase implements Sub2<JoinedBase, JoinedEmbeddable, JoinedEmbeddableSub2> {
    private static final long serialVersionUID = 1L;

    private IntIdEntity relation2;
    private JoinedBase parent2;
    private Integer sub2Value;
    private IntValueEmbeddable sub2Embeddable = new IntValueEmbeddable();
    private JoinedEmbeddableSub2 embeddable2 = new JoinedEmbeddableSub2();
    private List<JoinedBase> list2 = new ArrayList<>();
    private Set<JoinedSub2> children2 = new HashSet<>();
    private Map<JoinedBase, JoinedBase> map2 = new HashMap<>();

    public JoinedSub2() {
    }

    public JoinedSub2(String name) {
        super(name);
    }

    @Override
    @ManyToOne(fetch = FetchType.LAZY)
    public IntIdEntity getRelation2() {
        return relation2;
    }

    @Override
    public void setRelation2(IntIdEntity relation2) {
        this.relation2 = relation2;
    }
    
    @Override
    @ManyToOne(fetch = FetchType.LAZY)
    public JoinedBase getParent2() {
        return parent2;
    }

    @Override
    public void setParent2(JoinedBase parent2) {
        this.parent2 = parent2;
    }

    @Override
    public Integer getSub2Value() {
        return sub2Value;
    }

    @Override
    public void setSub2Value(Integer sub2Value) {
        this.sub2Value = sub2Value;
    }

    @Override
    @Embedded
    public IntValueEmbeddable getSub2Embeddable() {
        return sub2Embeddable;
    }

    @Override
    public void setSub2Embeddable(IntValueEmbeddable sub2Embeddable) {
        this.sub2Embeddable = sub2Embeddable;
    }

    @Override
    @Embedded
    public JoinedEmbeddableSub2 getEmbeddable2() {
        return embeddable2;
    }

    @Override
    public void setEmbeddable2(JoinedEmbeddableSub2 embeddable2) {
        this.embeddable2 = embeddable2;
    }

    @Override
    @ManyToMany
    @OrderColumn(name = "list_idx", nullable = false)
    @JoinTable(name = "joined_list_2")
    public List<JoinedBase> getList2() {
        return list2;
    }

    @Override
    public void setList2(List<? extends JoinedBase> list2) {
        this.list2 = (List<JoinedBase>) list2;
    }

    @Override
    @OneToMany(mappedBy = "parent2")
    public Set<JoinedSub2> getChildren2() {
        return children2;
    }

    @Override
    public void setChildren2(Set<? extends JoinedBase> children2) {
        this.children2 = (Set<JoinedSub2>) children2;
    }

    @Override
    @ManyToMany
    @JoinTable(name = "joined_map_2")
    @MapKeyColumn(name = "jm2_map_key", nullable = false, length = 20)
    public Map<JoinedBase, JoinedBase> getMap2() {
        return map2;
    }

    @Override
    public void setMap2(Map<? extends JoinedBase, ? extends JoinedBase> map2) {
        this.map2 = (Map<JoinedBase, JoinedBase>) map2;
    }
}
