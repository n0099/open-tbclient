package d.a.k0.a1.e.a.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem;
/* loaded from: classes4.dex */
public class j extends d.a.k0.a1.e.a.d.a<d.a.k0.a1.e.a.e.e, a> {

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicTabThreadItem f51398a;

        public a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            super(hotTopicTabThreadItem);
            this.f51398a = hotTopicTabThreadItem;
        }

        public void b(d.a.k0.a1.e.a.e.e eVar) {
            if (eVar != null) {
                this.f51398a.c(eVar);
            }
        }

        public void c(int i2) {
            this.f51398a.f(i2);
        }
    }

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.a1.e.a.e.a.f51405b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public a P(ViewGroup viewGroup) {
        HotTopicTabThreadItem hotTopicTabThreadItem = new HotTopicTabThreadItem(viewGroup.getContext());
        hotTopicTabThreadItem.setOnItemCoverListener(this.p);
        hotTopicTabThreadItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicTabThreadItem);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.a1.e.a.d.a, d.a.c.j.e.a
    /* renamed from: m0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.a1.e.a.e.e eVar, a aVar) {
        if (eVar == null || aVar == null) {
            return null;
        }
        aVar.b(eVar);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar.a();
    }
}
