package d.a.o0.j2.j;

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
/* loaded from: classes5.dex */
public class j extends d.a.o0.z.b<d.a.o0.j2.e.m> {
    public long m;
    public View n;
    public TextView o;
    public HTypeListView p;
    public d.a.o0.j2.c.o q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.u();
        }
    }

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.r = new a();
        this.l = 4;
        View m = m();
        this.n = m;
        this.o = (TextView) m.findViewById(R.id.card_person_vedio_list_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.card_person_vedio_view_pager);
        this.p = hTypeListView;
        this.q = new d.a.o0.j2.c.o(this.f67284f, hTypeListView);
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.card_person_vedio_list_view;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (i2 == this.f67283e) {
            return;
        }
        this.f67283e = i2;
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void u() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.f67285g).createNormalCfg(this.m, BaiduWalletServiceProviderMap.PLUGIN_PERSONAL)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: v */
    public void n(d.a.o0.j2.e.m mVar) {
        if (mVar != null && !ListUtils.isEmpty(mVar.f60248f)) {
            this.m = mVar.f60247e;
            this.o.setText(R.string.video_title_str);
            this.p.setData(w(mVar.f60248f));
            this.q.b(this.r);
            return;
        }
        this.n.setVisibility(8);
    }

    public final List<d.a.c.k.e.n> w(List<d.a.c.k.e.n> list) {
        int count = ListUtils.getCount(list);
        if (count <= 0) {
            return list;
        }
        List<d.a.c.k.e.n> arrayList = new ArrayList<>(list);
        int g2 = d.a.c.e.p.l.g(this.f67284f.getPageActivity(), R.dimen.ds490);
        int g3 = d.a.c.e.p.l.g(this.f67284f.getPageActivity(), R.dimen.ds32);
        if (count > 3) {
            arrayList = arrayList.subList(0, 3);
            d.a.o0.j2.e.h hVar = new d.a.o0.j2.e.h();
            hVar.f60229e = d.a.c.e.p.l.g(this.f67284f.getPageActivity(), R.dimen.ds120);
            hVar.f60230f = d.a.c.e.p.l.g(this.f67284f.getPageActivity(), R.dimen.ds396);
            ListUtils.add(arrayList, hVar);
        }
        d.a.o0.g2.d dVar = new d.a.o0.g2.d(g3, g2);
        ListUtils.add(arrayList, 0, dVar);
        ListUtils.add(arrayList, dVar);
        return arrayList;
    }
}
