package d.a.j0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
import d.a.i0.m.f;
import d.a.j0.x1.c;
/* loaded from: classes3.dex */
public class a extends d.a.c.j.e.a<d.a.j0.x1.e.b, b> {
    public f<d.a.j0.x1.e.b> m;

    /* renamed from: d.a.j0.x1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1665a implements f<d.a.j0.x1.e.b> {
        public C1665a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: b */
        public void c(View view, d.a.j0.x1.e.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: d */
        public void a(View view, d.a.j0.x1.e.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            c.a("c13820", bVar, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicDetailSpecialItem f62585a;

        public b(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.f62585a = hotTopicDetailSpecialItem;
        }

        public void b(d.a.j0.x1.e.b bVar) {
            if (bVar != null) {
                this.f62585a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f62585a.c(i2);
        }

        public void d(f<d.a.j0.x1.e.b> fVar) {
            this.f62585a.setOnItemCoverListener(fVar);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.x1.e.a.f62628a);
        this.m = new C1665a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public b P(ViewGroup viewGroup) {
        b bVar = new b(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        bVar.d(this.m);
        bVar.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x1.e.b bVar, b bVar2) {
        if (bVar == null || bVar2 == null) {
            return null;
        }
        bVar2.b(bVar);
        bVar2.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar2.a();
    }
}
