package d.a.o0.b2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.a.n0.m.f;
/* loaded from: classes5.dex */
public class b extends d.a.c.k.e.a<d.a.o0.b2.d.b, C1280b> {
    public f<d.a.o0.b2.d.b> m;

    /* loaded from: classes5.dex */
    public class a implements f<d.a.o0.b2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, d.a.o0.b2.d.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, d.a.o0.b2.d.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            d.a.o0.b2.a.a("c13737", bVar, i2);
        }
    }

    /* renamed from: d.a.o0.b2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1280b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f55882a;

        public C1280b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f55882a = hotTopicListInfoItem;
        }

        public void b(d.a.o0.b2.d.b bVar) {
            if (bVar != null) {
                this.f55882a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f55882a.d(i2);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.b2.d.a.f55883a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public C1280b Q(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1280b c1280b = new C1280b(hotTopicListInfoItem);
        c1280b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1280b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.b2.d.b bVar, C1280b c1280b) {
        if (bVar == null || c1280b == null) {
            return null;
        }
        c1280b.b(bVar);
        c1280b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1280b.a();
    }
}
