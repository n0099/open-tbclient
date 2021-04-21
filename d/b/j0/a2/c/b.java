package d.b.j0.a2.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newlist.view.HotTopicListInfoItem;
import d.b.i0.m.f;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<d.b.j0.a2.d.b, C1192b> {
    public f<d.b.j0.a2.d.b> m;

    /* loaded from: classes3.dex */
    public class a implements f<d.b.j0.a2.d.b> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, d.b.j0.a2.d.b bVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, d.b.j0.a2.d.b bVar, int i, long j) {
            if (bVar == null) {
                return;
            }
            d.b.j0.a2.a.a("c13737", bVar, i);
        }
    }

    /* renamed from: d.b.j0.a2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1192b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicListInfoItem f53473a;

        public C1192b(HotTopicListInfoItem hotTopicListInfoItem) {
            super(hotTopicListInfoItem);
            this.f53473a = hotTopicListInfoItem;
        }

        public void b(d.b.j0.a2.d.b bVar) {
            if (bVar != null) {
                this.f53473a.a(bVar);
            }
        }

        public void c(int i) {
            this.f53473a.d(i);
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.a2.d.a.f53474a);
        this.m = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public C1192b R(ViewGroup viewGroup) {
        HotTopicListInfoItem hotTopicListInfoItem = new HotTopicListInfoItem(viewGroup.getContext());
        hotTopicListInfoItem.setOnItemCoverListener(this.m);
        hotTopicListInfoItem.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        C1192b c1192b = new C1192b(hotTopicListInfoItem);
        c1192b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1192b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.a2.d.b bVar, C1192b c1192b) {
        if (bVar == null || c1192b == null) {
            return null;
        }
        c1192b.b(bVar);
        c1192b.c(TbadkCoreApplication.getInst().getSkinType());
        return c1192b.a();
    }
}
