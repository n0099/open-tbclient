package d.a.j0.a2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.a.i0.m.f;
/* loaded from: classes3.dex */
public class b extends d.a.c.j.e.a<d.a.j0.a2.d.b, C1131b> {
    public f<d.a.j0.a2.d.b> m;

    /* loaded from: classes3.dex */
    public class a implements f<d.a.j0.a2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: b */
        public void c(View view, d.a.j0.a2.d.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: d */
        public void a(View view, d.a.j0.a2.d.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            d.a.j0.a2.a.a("c13737", bVar, i2);
        }
    }

    /* renamed from: d.a.j0.a2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1131b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f51202a;

        public C1131b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f51202a = hotTopicListInfoItem;
        }

        public void b(d.a.j0.a2.d.b bVar) {
            if (bVar != null) {
                this.f51202a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f51202a.d(i2);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.a2.d.a.f51203a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public C1131b P(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1131b c1131b = new C1131b(hotTopicListInfoItem);
        c1131b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1131b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.a2.d.b bVar, C1131b c1131b) {
        if (bVar == null || c1131b == null) {
            return null;
        }
        c1131b.b(bVar);
        c1131b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1131b.a();
    }
}
