package d.a.n0.b1.f.a.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem;
/* loaded from: classes4.dex */
public class j extends d.a.n0.b1.f.a.d.a<d.a.n0.b1.f.a.e.e, a> {

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicTabThreadItem f55246a;

        public a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            super(hotTopicTabThreadItem);
            this.f55246a = hotTopicTabThreadItem;
        }

        public void b(d.a.n0.b1.f.a.e.e eVar) {
            if (eVar != null) {
                this.f55246a.c(eVar);
            }
        }

        public void c(int i2) {
            this.f55246a.f(i2);
        }
    }

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b1.f.a.e.a.f55253b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public a Q(ViewGroup viewGroup) {
        HotTopicTabThreadItem hotTopicTabThreadItem = new HotTopicTabThreadItem(viewGroup.getContext());
        hotTopicTabThreadItem.setOnItemCoverListener(this.p);
        hotTopicTabThreadItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicTabThreadItem);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.b1.f.a.d.a, d.a.c.k.e.a
    /* renamed from: l0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.f.a.e.e eVar, a aVar) {
        if (eVar == null || aVar == null) {
            return null;
        }
        aVar.b(eVar);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar.a();
    }
}
