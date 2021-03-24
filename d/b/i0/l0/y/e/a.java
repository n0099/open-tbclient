package d.b.i0.l0.y.e;

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
import d.b.b.e.p.j;
import d.b.h0.d0.g;
import d.b.h0.r.f0.f;
import d.b.h0.r.s.a;
import d.b.i0.l0.y.d.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, c {
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f56692e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56693f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f56694g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f56695h;
    public NoNetworkView i;
    public PbListView j;
    public View k;
    public RelativeLayout l;
    public TextView m;
    public ImageView n;
    public d.b.i0.l0.y.a o;
    public EmotionCenterForumView p;
    public EmotionCenterChangeView q;
    public d.b.i0.l0.y.b.a r;
    public EmotionCenterData s;
    public d.b.i0.l0.y.d.a t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public Animation x = null;
    public boolean y = true;
    public int z = 0;
    public String A = "";

    /* renamed from: d.b.i0.l0.y.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1330a implements a.e {
        public C1330a(a aVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(a aVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56692e = tbPageContext;
        this.f56695h = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.i = new NoNetworkView(tbPageContext.getPageActivity());
        this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.z()) {
            this.i.setVisibility(8);
        }
        this.f56695h.addView(this.i);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f56695h.findViewById(R.id.emotion_center_list);
        this.f56693f = bdTypeListView;
        bdTypeListView.setDivider(null);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f56692e);
        this.f56694g = gVar;
        gVar.Z(bdUniqueId);
        this.f56693f.setPullRefresh(this.f56694g);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.j = pbListView;
        pbListView.a();
        d.b.i0.l0.y.a aVar = new d.b.i0.l0.y.a(this.f56692e);
        this.o = aVar;
        aVar.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.f56692e);
        this.p = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.r = new d.b.i0.l0.y.b.a(this.f56692e, this.f56693f);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.f56692e);
        this.q = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.f56693f.addHeaderView(this.o.c());
        this.f56693f.addHeaderView(this.p);
        this.f56693f.addHeaderView(this.q);
        this.k = this.f56695h.findViewById(R.id.emotion_add_layout);
        this.l = (RelativeLayout) this.f56695h.findViewById(R.id.emotion_add_layout);
        this.m = (TextView) this.f56695h.findViewById(R.id.add_emotion_tv);
        this.n = (ImageView) this.f56695h.findViewById(R.id.icon_add);
        this.k.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f56695h.findViewById(R.id.emotion_upload_status);
        this.u = linearLayout;
        linearLayout.setClickable(false);
        this.u.setOnClickListener(this);
        this.u.setVisibility(8);
        this.v = (ImageView) this.f56695h.findViewById(R.id.uploading_status_img);
        this.w = (TextView) this.f56695h.findViewById(R.id.add_emotion_upload_status);
        v();
    }

    @Override // d.b.i0.l0.y.d.c
    public void a() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56692e.getPageActivity(), 25021)));
    }

    @Override // d.b.i0.l0.y.d.c
    public void b() {
        if (this.z == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56692e.getPageActivity(), true, 25021)));
        } else if (TextUtils.isEmpty(this.A)) {
        } else {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f56692e.getPageActivity());
            aVar.setMessage(this.A);
            aVar.setPositiveButton(R.string.confirm, new C1330a(this));
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(this.f56692e).show();
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
                d.b.i0.l0.y.c.b bVar = new d.b.i0.l0.y.c.b();
                bVar.f56683e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.a(arrayList);
        }
        this.r.c();
    }

    public void d() {
        this.f56693f.z();
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

    public final Animation h() {
        if (this.x == null) {
            this.x = AnimationUtils.loadAnimation(this.f56692e.getPageActivity(), R.anim.refresh_rotate);
            this.x.setInterpolator(new LinearInterpolator());
            this.x.setFillAfter(true);
        }
        return this.x;
    }

    public View i() {
        return this.i;
    }

    public ViewGroup j() {
        return this.f56695h;
    }

    public EmotionCenterChangeView k() {
        return this.q;
    }

    public void l() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f56693f.setNextPage(null);
    }

    public void m() {
        g gVar = this.B;
        if (gVar != null) {
            gVar.dettachView(this.f56695h);
            this.B = null;
        }
    }

    public void n(int i) {
        this.j.o(R.color.CAM_X0204);
        this.j.d(i);
        this.f56694g.I(i);
        this.r.c();
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        this.f56693f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f56695h, R.color.CAM_X0201);
        this.i.c(this.f56692e, i);
        EmotionCenterForumView emotionCenterForumView = this.p;
        if (emotionCenterForumView != null) {
            emotionCenterForumView.b(i);
        }
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            SkinManager.setBackgroundColor(relativeLayout, R.color.cp_bg_line_d_alpha90, i);
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302, i);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.emotion_bar_add_icon);
        }
        if (this.u != null) {
            SkinManager.setBackgroundColor(this.l, R.color.cp_bg_line_d_alpha90, i);
        }
        ImageView imageView2 = this.v;
        if (imageView2 != null) {
            SkinManager.setImageResource(imageView2, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void o() {
        d.b.i0.l0.y.d.a aVar = this.t;
        if (aVar != null) {
            aVar.dismiss();
        }
        e();
        this.u.setVisibility(8);
        this.k.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            if (this.s == null) {
                return;
            }
            if (this.z != 0) {
                if (this.t == null) {
                    d.b.i0.l0.y.d.a aVar = new d.b.i0.l0.y.d.a(this.f56692e.getPageActivity(), this.z);
                    this.t = aVar;
                    aVar.d(this);
                }
                this.t.c(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.f56692e.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.t.showAtLocation(this.f56695h, 81, 0, this.f56692e.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                return;
            }
            a();
        } else if (view == this.u) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56692e.getPageActivity(), this.z == 1, 25021)));
        }
    }

    public void p(EmotionCenterData emotionCenterData) {
        if (emotionCenterData == null) {
            return;
        }
        m();
        if (ListUtils.isEmpty(this.q.getDataList())) {
            this.q.d();
            this.q.setVisibility(0);
        }
        this.s = emotionCenterData;
        if (this.y) {
            this.z = d.b.b.e.m.b.d(emotionCenterData.is_bazhu, 0);
            this.A = emotionCenterData.bazhu_message;
            this.y = false;
        }
        if (emotionCenterData.banner != null) {
            this.o.c().setVisibility(0);
            this.o.f(this.f56692e.getUniqueId());
            this.o.e(new d.b.i0.l0.y.c.c(emotionCenterData.banner));
            this.o.g();
        }
        if (emotionCenterData.forum != null) {
            this.p.setVisibility(0);
            this.p.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.b.i0.l0.y.c.a());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                d.b.i0.l0.y.c.b bVar = new d.b.i0.l0.y.c.b();
                bVar.f56683e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.d(arrayList);
        }
        this.r.c();
    }

    public void q(f.g gVar) {
        this.f56694g.b(gVar);
    }

    public void r(BdListView.p pVar) {
        this.f56693f.setOnSrollToBottomListener(pVar);
    }

    public void s() {
        d.b.i0.l0.y.d.a aVar = this.t;
        if (aVar != null) {
            aVar.dismiss();
        }
        x();
        this.u.setVisibility(0);
        this.k.setVisibility(8);
        SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
        SkinManager.setImageResource(this.v, R.drawable.emotion_uploading_bar_refresh);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
        this.w.setText(R.string.emotion_uploading);
        this.u.setClickable(false);
    }

    public void u() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56693f.setNextPage(this.j);
            }
            this.j.M();
            this.j.O();
        }
    }

    public void v() {
        TbPageContext tbPageContext = this.f56692e;
        if (tbPageContext == null || this.f56695h == null) {
            return;
        }
        g gVar = new g(tbPageContext.getPageActivity());
        this.B = gVar;
        gVar.attachView(this.f56695h, false);
        this.B.onChangeSkinType();
    }

    public void w() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56693f.setNextPage(this.j);
            }
            this.j.A(this.f56692e.getResources().getString(R.string.list_no_more));
            this.j.f();
        }
    }

    public void x() {
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(h());
        }
    }

    public void y() {
        d.b.i0.l0.y.d.a aVar = this.t;
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

    public void z(EmotionPackageData emotionPackageData) {
        if (emotionPackageData == null) {
            return;
        }
        EmotionCenterChangeView emotionCenterChangeView = this.q;
        if (emotionCenterChangeView != null) {
            emotionCenterChangeView.g(emotionPackageData);
        }
        d.b.i0.l0.y.b.a aVar = this.r;
        if (aVar != null) {
            aVar.e(emotionPackageData);
        }
    }
}
