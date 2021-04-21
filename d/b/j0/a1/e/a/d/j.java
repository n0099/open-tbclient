package d.b.j0.a1.e.a.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabThreadItem;
/* loaded from: classes4.dex */
public class j extends d.b.j0.a1.e.a.d.a<d.b.j0.a1.e.a.e.e, a> {

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicTabThreadItem f52998a;

        public a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            super(hotTopicTabThreadItem);
            this.f52998a = hotTopicTabThreadItem;
        }

        public void b(d.b.j0.a1.e.a.e.e eVar) {
            if (eVar != null) {
                this.f52998a.c(eVar);
            }
        }

        public void c(int i) {
            this.f52998a.f(i);
        }
    }

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.a1.e.a.e.a.f53005b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public a R(ViewGroup viewGroup) {
        HotTopicTabThreadItem hotTopicTabThreadItem = new HotTopicTabThreadItem(viewGroup.getContext());
        hotTopicTabThreadItem.setOnItemCoverListener(this.p);
        hotTopicTabThreadItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a aVar = new a(hotTopicTabThreadItem);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.a1.e.a.d.a, d.b.c.j.e.a
    /* renamed from: o0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.a1.e.a.e.e eVar, a aVar) {
        if (eVar == null || aVar == null) {
            return null;
        }
        aVar.b(eVar);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar.a();
    }
}
