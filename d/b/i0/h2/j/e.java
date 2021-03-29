package d.b.i0.h2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.b.i0.x.b<d.b.i0.h2.e.g> {
    public TbPageContext m;
    public View n;
    public View o;
    public TextView p;
    public HTypeListView q;
    public d.b.i0.h2.c.o r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.h2.e.g f55394e;

        public a(d.b.i0.h2.e.g gVar) {
            this.f55394e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.v(this.f55394e);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.m = tbPageContext;
        View m = m();
        this.n = m;
        this.o = m.findViewById(R.id.divider_view);
        this.p = (TextView) this.n.findViewById(R.id.gift_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.gift_horizontal_list);
        this.q = hTypeListView;
        this.r = new d.b.i0.h2.c.o(this.m, hTypeListView);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_gift_list;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void v(d.b.i0.h2.e.g gVar) {
        if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.m.showToast(R.string.gift_load_fail);
        } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.m.getPageActivity(), gVar.f55289g, gVar.f55290h, gVar.i, gVar.j)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: w */
    public void n(d.b.i0.h2.e.g gVar) {
        if (gVar != null && gVar.isValid()) {
            a aVar = new a(gVar);
            this.r.a(aVar);
            this.n.setOnClickListener(aVar);
            this.r.b(aVar);
            this.q.setData(x(gVar.k));
            if (gVar.f55287e) {
                this.p.setText(R.string.gift_received_by_me);
            } else if (gVar.f55288f) {
                this.p.setText(R.string.gift_received_by_him);
            } else {
                this.p.setText(R.string.gift_received_by_her);
            }
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        this.n.setVisibility(8);
    }

    public final List<d.b.b.j.e.n> x(List<d.b.b.j.e.n> list) {
        int count = ListUtils.getCount(list);
        if (count <= 0) {
            return list;
        }
        List<d.b.b.j.e.n> arrayList = new ArrayList<>(list);
        int g2 = d.b.b.e.p.l.g(this.f62181f.getPageActivity(), R.dimen.ds100);
        int g3 = d.b.b.e.p.l.g(this.f62181f.getPageActivity(), R.dimen.ds32);
        if (count > 7) {
            arrayList = arrayList.subList(0, 7);
            d.b.i0.h2.e.h hVar = new d.b.i0.h2.e.h();
            hVar.f55293f = g2;
            hVar.f55292e = g2;
            ListUtils.add(arrayList, hVar);
        }
        d.b.i0.e2.d dVar = new d.b.i0.e2.d(g3, g2);
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
