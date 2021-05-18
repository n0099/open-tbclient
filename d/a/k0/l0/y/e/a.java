package d.a.k0.l0.y.e;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterChangeView;
import com.baidu.tieba.faceshop.emotioncenter.view.EmotionCenterForumView;
import d.a.c.e.p.j;
import d.a.j0.d0.g;
import d.a.j0.r.f0.f;
import d.a.j0.r.s.a;
import d.a.k0.l0.y.d.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, c {
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f57234e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f57235f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.f0.g f57236g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f57237h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f57238i;
    public PbListView j;
    public View k;
    public RelativeLayout l;
    public TextView m;
    public ImageView n;
    public d.a.k0.l0.y.a o;
    public EmotionCenterForumView p;
    public EmotionCenterChangeView q;
    public d.a.k0.l0.y.b.a r;
    public EmotionCenterData s;
    public d.a.k0.l0.y.d.a t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public Animation x = null;
    public boolean y = true;
    public int z = 0;
    public String A = "";

    /* renamed from: d.a.k0.l0.y.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1418a implements a.e {
        public C1418a(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f57234e = tbPageContext;
        this.f57237h = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.f57238i = new NoNetworkView(tbPageContext.getPageActivity());
        this.f57238i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.z()) {
            this.f57238i.setVisibility(8);
        }
        this.f57237h.addView(this.f57238i);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f57237h.findViewById(R.id.emotion_center_list);
        this.f57235f = bdTypeListView;
        bdTypeListView.setDivider(null);
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(this.f57234e);
        this.f57236g = gVar;
        gVar.Z(bdUniqueId);
        this.f57235f.setPullRefresh(this.f57236g);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.j = pbListView;
        pbListView.a();
        d.a.k0.l0.y.a aVar = new d.a.k0.l0.y.a(this.f57234e);
        this.o = aVar;
        aVar.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.f57234e);
        this.p = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.r = new d.a.k0.l0.y.b.a(this.f57234e, this.f57235f);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.f57234e);
        this.q = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.f57235f.addHeaderView(this.o.c());
        this.f57235f.addHeaderView(this.p);
        this.f57235f.addHeaderView(this.q);
        this.k = this.f57237h.findViewById(R.id.emotion_add_layout);
        this.l = (RelativeLayout) this.f57237h.findViewById(R.id.emotion_add_layout);
        this.m = (TextView) this.f57237h.findViewById(R.id.add_emotion_tv);
        this.n = (ImageView) this.f57237h.findViewById(R.id.icon_add);
        this.k.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f57237h.findViewById(R.id.emotion_upload_status);
        this.u = linearLayout;
        linearLayout.setClickable(false);
        this.u.setOnClickListener(this);
        this.u.setVisibility(8);
        this.v = (ImageView) this.f57237h.findViewById(R.id.uploading_status_img);
        this.w = (TextView) this.f57237h.findViewById(R.id.add_emotion_upload_status);
        t();
    }

    @Override // d.a.k0.l0.y.d.c
    public void a() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f57234e.getPageActivity(), 25021)));
    }

    @Override // d.a.k0.l0.y.d.c
    public void b() {
        if (this.z == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f57234e.getPageActivity(), true, 25021)));
        } else if (TextUtils.isEmpty(this.A)) {
        } else {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f57234e.getPageActivity());
            aVar.setMessage(this.A);
            aVar.setPositiveButton(R.string.confirm, new C1418a(this));
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(this.f57234e).show();
        }
    }

    public void c(EmotionCenterData emotionCenterData) {
        if (emotionCenterData == null) {
            return;
        }
        this.s = emotionCenterData;
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                d.a.k0.l0.y.c.b bVar = new d.a.k0.l0.y.c.b();
                bVar.f57224e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.a(arrayList);
        }
        this.r.c();
    }

    public void d() {
        this.f57235f.z();
    }

    public void e() {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public int f() {
        return this.z;
    }

    public final Animation g() {
        if (this.x == null) {
            this.x = AnimationUtils.loadAnimation(this.f57234e.getPageActivity(), R.anim.refresh_rotate);
            this.x.setInterpolator(new LinearInterpolator());
            this.x.setFillAfter(true);
        }
        return this.x;
    }

    public View h() {
        return this.f57238i;
    }

    public ViewGroup i() {
        return this.f57237h;
    }

    public EmotionCenterChangeView j() {
        return this.q;
    }

    public void k() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f57235f.setNextPage(null);
    }

    public void l() {
        g gVar = this.B;
        if (gVar != null) {
            gVar.dettachView(this.f57237h);
            this.B = null;
        }
    }

    public void m(int i2) {
        this.j.o(R.color.CAM_X0204);
        this.j.d(i2);
        this.f57236g.I(i2);
        this.r.c();
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        this.f57235f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f57237h, R.color.CAM_X0201);
        this.f57238i.c(this.f57234e, i2);
        EmotionCenterForumView emotionCenterForumView = this.p;
        if (emotionCenterForumView != null) {
            emotionCenterForumView.b(i2);
        }
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i2);
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i2);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
        }
        if (this.u != null) {
            SkinManager.setBackgroundColor(this.l, R.color.cp_bg_line_d_alpha90, i2);
        }
        ImageView imageView2 = this.v;
        if (imageView2 != null) {
            SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void n() {
        d.a.k0.l0.y.d.a aVar = this.t;
        if (aVar != null) {
            aVar.dismiss();
        }
        e();
        this.u.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void o(EmotionCenterData emotionCenterData) {
        if (emotionCenterData == null) {
            return;
        }
        l();
        if (ListUtils.isEmpty(this.q.getDataList())) {
            this.q.d();
            this.q.setVisibility(0);
        }
        this.s = emotionCenterData;
        if (this.y) {
            this.z = d.a.c.e.m.b.d(emotionCenterData.is_bazhu, 0);
            this.A = emotionCenterData.bazhu_message;
            this.y = false;
        }
        if (emotionCenterData.banner != null) {
            this.o.c().setVisibility(0);
            this.o.f(this.f57234e.getUniqueId());
            this.o.e(new d.a.k0.l0.y.c.c(emotionCenterData.banner));
            this.o.g();
        }
        if (emotionCenterData.forum != null) {
            this.p.setVisibility(0);
            this.p.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.a.k0.l0.y.c.a());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                d.a.k0.l0.y.c.b bVar = new d.a.k0.l0.y.c.b();
                bVar.f57224e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.d(arrayList);
        }
        this.r.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            if (this.s == null) {
                return;
            }
            if (this.z != 0) {
                if (this.t == null) {
                    d.a.k0.l0.y.d.a aVar = new d.a.k0.l0.y.d.a(this.f57234e.getPageActivity(), this.z);
                    this.t = aVar;
                    aVar.d(this);
                }
                this.t.c(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.f57234e.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.t.showAtLocation(this.f57237h, 81, 0, this.f57234e.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                return;
            }
            a();
        } else if (view == this.u) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f57234e.getPageActivity(), this.z == 1, 25021)));
        }
    }

    public void p(f.g gVar) {
        this.f57236g.a(gVar);
    }

    public void q(BdListView.p pVar) {
        this.f57235f.setOnSrollToBottomListener(pVar);
    }

    public void r() {
        d.a.k0.l0.y.d.a aVar = this.t;
        if (aVar != null) {
            aVar.dismiss();
        }
        v();
        this.u.setVisibility(0);
        this.k.setVisibility(8);
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        SkinManager.setImageResource(this.v, R.drawable.emotion_uploading_bar_refresh);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
        this.w.setText(R.string.emotion_uploading);
        this.u.setClickable(false);
    }

    public void s() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57235f.setNextPage(this.j);
            }
            this.j.M();
            this.j.O();
        }
    }

    public void t() {
        TbPageContext tbPageContext = this.f57234e;
        if (tbPageContext == null || this.f57237h == null) {
            return;
        }
        g gVar = new g(tbPageContext.getPageActivity());
        this.B = gVar;
        gVar.attachView(this.f57237h, false);
        this.B.onChangeSkinType();
    }

    public void u() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57235f.setNextPage(this.j);
            }
            this.j.A(this.f57234e.getResources().getString(R.string.list_no_more));
            this.j.f();
        }
    }

    public void v() {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(g());
        }
    }

    public void w() {
        d.a.k0.l0.y.d.a aVar = this.t;
        if (aVar != null) {
            aVar.dismiss();
        }
        e();
        this.u.setVisibility(0);
        this.k.setVisibility(8);
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        SkinManager.setImageResource(this.v, R.drawable.emotion_update_fail);
        SkinManager.setViewTextColor(this.w, R.color.common_color_10037);
        this.w.setText(R.string.emotion_center_upload_failed);
        this.u.setClickable(true);
    }

    public void x(EmotionPackageData emotionPackageData) {
        if (emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.q;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.f(emotionPackageData);
        }
        d.a.k0.l0.y.b.a aVar = this.r;
        if (aVar != null) {
            aVar.e(emotionPackageData);
        }
    }
}
