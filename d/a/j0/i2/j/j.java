package d.a.j0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends d.a.j0.x.b<d.a.j0.i2.e.m> {
    public long m;
    public View n;
    public TextView o;
    public HTypeListView p;
    public d.a.j0.i2.c.o q;
    public View.OnClickListener r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.t();
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.r = new a();
        this.l = 4;
        View l = l();
        this.n = l;
        this.o = (TextView) l.findViewById(R.id.card_person_vedio_list_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.card_person_vedio_view_pager);
        this.p = hTypeListView;
        this.q = new d.a.j0.i2.c.o(this.f62437f, hTypeListView);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_person_vedio_list_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == this.f62436e) {
            return;
        }
        this.f62436e = i2;
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void t() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.f62438g).createNormalCfg(this.m, BaiduWalletServiceProviderMap.PLUGIN_PERSONAL)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: u */
    public void m(d.a.j0.i2.e.m mVar) {
        if (mVar != null && !ListUtils.isEmpty(mVar.f55543f)) {
            this.m = mVar.f55542e;
            this.o.setText(R.string.video_title_str);
            this.p.setData(v(mVar.f55543f));
            this.q.b(this.r);
            return;
        }
        this.n.setVisibility(8);
    }

    public final List<d.a.c.j.e.n> v(List<d.a.c.j.e.n> list) {
        int count = ListUtils.getCount(list);
        if (count <= 0) {
            return list;
        }
        List<d.a.c.j.e.n> arrayList = new ArrayList<>(list);
        int g2 = d.a.c.e.p.l.g(this.f62437f.getPageActivity(), R.dimen.ds490);
        int g3 = d.a.c.e.p.l.g(this.f62437f.getPageActivity(), R.dimen.ds32);
        if (count > 3) {
            arrayList = arrayList.subList(0, 3);
            d.a.j0.i2.e.h hVar = new d.a.j0.i2.e.h();
            hVar.f55524e = d.a.c.e.p.l.g(this.f62437f.getPageActivity(), R.dimen.ds120);
            hVar.f55525f = d.a.c.e.p.l.g(this.f62437f.getPageActivity(), R.dimen.ds396);
            ListUtils.add(arrayList, hVar);
        }
        d.a.j0.f2.d dVar = new d.a.j0.f2.d(g3, g2);
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
