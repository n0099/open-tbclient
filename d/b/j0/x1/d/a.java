package d.b.j0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
import d.b.i0.m.f;
import d.b.j0.x1.c;
/* loaded from: classes3.dex */
public class a extends d.b.c.j.e.a<d.b.j0.x1.e.b, b> {
    public f<d.b.j0.x1.e.b> m;

    /* renamed from: d.b.j0.x1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1728a implements f<d.b.j0.x1.e.b> {
        public C1728a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, d.b.j0.x1.e.b bVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, d.b.j0.x1.e.b bVar, int i, long j) {
            if (bVar == null) {
                return;
            }
            c.a("c13820", bVar, i);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicDetailSpecialItem f64317a;

        public b(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.f64317a = hotTopicDetailSpecialItem;
        }

        public void b(d.b.j0.x1.e.b bVar) {
            if (bVar != null) {
                this.f64317a.a(bVar);
            }
        }

        public void c(int i) {
            this.f64317a.c(i);
        }

        public void d(f<d.b.j0.x1.e.b> fVar) {
            this.f64317a.setOnItemCoverListener(fVar);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.x1.e.a.f64359a);
        this.m = new C1728a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public b R(ViewGroup viewGroup) {
        b bVar = new b(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        bVar.d(this.m);
        bVar.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x1.e.b bVar, b bVar2) {
        if (bVar == null || bVar2 == null) {
            return null;
        }
        bVar2.b(bVar);
        bVar2.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar2.a();
    }
}
