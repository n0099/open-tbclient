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
public class b extends d.a.c.k.e.a<d.a.n0.b2.d.b, C1276b> {
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
    public static class C1276b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f55757a;

        public C1276b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f55757a = hotTopicListInfoItem;
        }

        public void b(d.a.n0.b2.d.b bVar) {
            if (bVar != null) {
                this.f55757a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f55757a.d(i2);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.b2.d.a.f55758a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public C1276b Q(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1276b c1276b = new C1276b(hotTopicListInfoItem);
        c1276b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1276b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b2.d.b bVar, C1276b c1276b) {
        if (bVar == null || c1276b == null) {
            return null;
        }
        c1276b.b(bVar);
        c1276b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1276b.a();
    }
}
