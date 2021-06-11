package d.a.n0.y1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
import d.a.m0.m.f;
import d.a.n0.y1.c;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.n0.y1.e.b, b> {
    public f<d.a.n0.y1.e.b> m;

    /* renamed from: d.a.n0.y1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1803a implements f<d.a.n0.y1.e.b> {
        public C1803a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, d.a.n0.y1.e.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, d.a.n0.y1.e.b bVar, int i2, long j) {
            if (bVar == null) {
                return;
            }
            c.a("c13820", bVar, i2);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public HotTopicDetailSpecialItem f67071a;

        public b(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            this.f67071a = hotTopicDetailSpecialItem;
        }

        public void b(d.a.n0.y1.e.b bVar) {
            if (bVar != null) {
                this.f67071a.a(bVar);
            }
        }

        public void c(int i2) {
            this.f67071a.c(i2);
        }

        public void d(f<d.a.n0.y1.e.b> fVar) {
            this.f67071a.setOnItemCoverListener(fVar);
        }
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.y1.e.a.f67114a);
        this.m = new C1803a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public b Q(ViewGroup viewGroup) {
        b bVar = new b(new HotTopicDetailSpecialItem(viewGroup.getContext()));
        bVar.d(this.m);
        bVar.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.y1.e.b bVar, b bVar2) {
        if (bVar == null || bVar2 == null) {
            return null;
        }
        bVar2.b(bVar);
        bVar2.c(TbadkCoreApplication.getInst().getSkinType());
        return bVar2.a();
    }
}
