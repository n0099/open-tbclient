package d.b.i0.a2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.b.h0.m.f;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<d.b.i0.a2.d.b, C1169b> {
    public f<d.b.i0.a2.d.b> m;

    /* loaded from: classes3.dex */
    public class a implements f<d.b.i0.a2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, d.b.i0.a2.d.b bVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, d.b.i0.a2.d.b bVar, int i, long j) {
            if (bVar == null) {
                return;
            }
            d.b.i0.a2.a.a("c13737", bVar, i);
        }
    }

    /* renamed from: d.b.i0.a2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1169b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f53052a;

        public C1169b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f53052a = hotTopicListInfoItem;
        }

        public void b(d.b.i0.a2.d.b bVar) {
            if (bVar != null) {
                this.f53052a.a(bVar);
            }
        }

        public void c(int i) {
            this.f53052a.d(i);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.a2.d.a.f53053a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public C1169b R(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1169b c1169b = new C1169b(hotTopicListInfoItem);
        c1169b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1169b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.a2.d.b bVar, C1169b c1169b) {
        if (bVar == null || c1169b == null) {
            return null;
        }
        c1169b.b(bVar);
        c1169b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1169b.a();
    }
}
