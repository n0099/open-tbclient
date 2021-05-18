package d.a.k0.a2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.a.j0.m.f;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.k0.a2.d.b, C1203b> {
    public f<d.a.k0.a2.d.b> m;

    /* loaded from: classes4.dex */
    public class a implements f<d.a.k0.a2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: b */
        public void c(View view, d.a.k0.a2.d.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: d */
        public void a(View view, d.a.k0.a2.d.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            d.a.k0.a2.a.a("c13737", bVar, i2);
        }
    }

    /* renamed from: d.a.k0.a2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1203b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f51901a;

        public C1203b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f51901a = hotTopicListInfoItem;
        }

        public void b(d.a.k0.a2.d.b bVar) {
            if (bVar != null) {
                this.f51901a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f51901a.d(i2);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.a2.d.a.f51902a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public C1203b P(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1203b c1203b = new C1203b(hotTopicListInfoItem);
        c1203b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1203b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.a2.d.b bVar, C1203b c1203b) {
        if (bVar == null || c1203b == null) {
            return null;
        }
        c1203b.b(bVar);
        c1203b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1203b.a();
    }
}
