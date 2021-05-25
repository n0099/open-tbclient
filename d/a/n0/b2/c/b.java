package d.a.n0.b2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.a.m0.m.f;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.n0.b2.d.b, C1220b> {
    public f<d.a.n0.b2.d.b> m;

    /* loaded from: classes4.dex */
    public class a implements f<d.a.n0.b2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, d.a.n0.b2.d.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, d.a.n0.b2.d.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            d.a.n0.b2.a.a("c13737", bVar, i2);
        }
    }

    /* renamed from: d.a.n0.b2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1220b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f52068a;

        public C1220b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f52068a = hotTopicListInfoItem;
        }

        public void b(d.a.n0.b2.d.b bVar) {
            if (bVar != null) {
                this.f52068a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f52068a.d(i2);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b2.d.a.f52069a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public C1220b P(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1220b c1220b = new C1220b(hotTopicListInfoItem);
        c1220b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1220b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.b2.d.b bVar, C1220b c1220b) {
        if (bVar == null || c1220b == null) {
            return null;
        }
        c1220b.b(bVar);
        c1220b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1220b.a();
    }
}
