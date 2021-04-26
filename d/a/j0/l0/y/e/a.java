package d.a.j0.l0.y.e;

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
import d.a.i0.d0.g;
import d.a.i0.r.f0.f;
import d.a.i0.r.s.a;
import d.a.j0.l0.y.d.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, c {
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f56527e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56528f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.f0.g f56529g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f56530h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f56531i;
    public PbListView j;
    public View k;
    public RelativeLayout l;
    public TextView m;
    public ImageView n;
    public d.a.j0.l0.y.a o;
    public EmotionCenterForumView p;
    public EmotionCenterChangeView q;
    public d.a.j0.l0.y.b.a r;
    public EmotionCenterData s;
    public d.a.j0.l0.y.d.a t;
    public LinearLayout u;
    public ImageView v;
    public TextView w;
    public Animation x = null;
    public boolean y = true;
    public int z = 0;
    public String A = "";

    /* renamed from: d.a.j0.l0.y.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1346a implements a.e {
        public C1346a(a aVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(a aVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56527e = tbPageContext;
        this.f56530h = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.f56531i = new NoNetworkView(tbPageContext.getPageActivity());
        this.f56531i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.z()) {
            this.f56531i.setVisibility(8);
        }
        this.f56530h.addView(this.f56531i);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f56530h.findViewById(R.id.emotion_center_list);
        this.f56528f = bdTypeListView;
        bdTypeListView.setDivider(null);
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(this.f56527e);
        this.f56529g = gVar;
        gVar.Z(bdUniqueId);
        this.f56528f.setPullRefresh(this.f56529g);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.j = pbListView;
        pbListView.a();
        d.a.j0.l0.y.a aVar = new d.a.j0.l0.y.a(this.f56527e);
        this.o = aVar;
        aVar.c().setVisibility(8);
        EmotionCenterForumView emotionCenterForumView = new EmotionCenterForumView(this.f56527e);
        this.p = emotionCenterForumView;
        emotionCenterForumView.setVisibility(8);
        this.r = new d.a.j0.l0.y.b.a(this.f56527e, this.f56528f);
        EmotionCenterChangeView emotionCenterChangeView = new EmotionCenterChangeView(this.f56527e);
        this.q = emotionCenterChangeView;
        emotionCenterChangeView.setVisibility(8);
        this.f56528f.addHeaderView(this.o.c());
        this.f56528f.addHeaderView(this.p);
        this.f56528f.addHeaderView(this.q);
        this.k = this.f56530h.findViewById(R.id.emotion_add_layout);
        this.l = (RelativeLayout) this.f56530h.findViewById(R.id.emotion_add_layout);
        this.m = (TextView) this.f56530h.findViewById(R.id.add_emotion_tv);
        this.n = (ImageView) this.f56530h.findViewById(R.id.icon_add);
        this.k.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f56530h.findViewById(R.id.emotion_upload_status);
        this.u = linearLayout;
        linearLayout.setClickable(false);
        this.u.setOnClickListener(this);
        this.u.setVisibility(8);
        this.v = (ImageView) this.f56530h.findViewById(R.id.uploading_status_img);
        this.w = (TextView) this.f56530h.findViewById(R.id.add_emotion_upload_status);
        t();
    }

    @Override // d.a.j0.l0.y.d.c
    public void a() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56527e.getPageActivity(), 25021)));
    }

    @Override // d.a.j0.l0.y.d.c
    public void b() {
        if (this.z == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56527e.getPageActivity(), true, 25021)));
        } else if (TextUtils.isEmpty(this.A)) {
        } else {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f56527e.getPageActivity());
            aVar.setMessage(this.A);
            aVar.setPositiveButton(R.string.confirm, new C1346a(this));
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(this.f56527e).show();
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
                d.a.j0.l0.y.c.b bVar = new d.a.j0.l0.y.c.b();
                bVar.f56517e = emotionPackageData;
                arrayList.add(bVar);
            }
            this.r.a(arrayList);
        }
        this.r.c();
    }

    public void d() {
        this.f56528f.z();
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
            this.x = AnimationUtils.loadAnimation(this.f56527e.getPageActivity(), R.anim.refresh_rotate);
            this.x.setInterpolator(new LinearInterpolator());
            this.x.setFillAfter(true);
        }
        return this.x;
    }

    public View h() {
        return this.f56531i;
    }

    public ViewGroup i() {
        return this.f56530h;
    }

    public EmotionCenterChangeView j() {
        return this.q;
    }

    public void k() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f56528f.setNextPage(null);
    }

    public void l() {
        g gVar = this.B;
        if (gVar != null) {
            gVar.dettachView(this.f56530h);
            this.B = null;
        }
    }

    public void m(int i2) {
        this.j.o(R.color.CAM_X0204);
        this.j.d(i2);
        this.f56529g.I(i2);
        this.r.c();
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        this.f56528f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f56530h, R.color.CAM_X0201);
        this.f56531i.c(this.f56527e, i2);
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
        d.a.j0.l0.y.d.a aVar = this.t;
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
            this.o.f(this.f56527e.getUniqueId());
            this.o.e(new d.a.j0.l0.y.c.c(emotionCenterData.banner));
            this.o.g();
        }
        if (emotionCenterData.forum != null) {
            this.p.setVisibility(0);
            this.p.setData(emotionCenterData.forum);
        }
        if (!ListUtils.isEmpty(emotionCenterData.package_list)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.a.j0.l0.y.c.a());
            for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                d.a.j0.l0.y.c.b bVar = new d.a.j0.l0.y.c.b();
                bVar.f56517e = emotionPackageData;
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
                    d.a.j0.l0.y.d.a aVar = new d.a.j0.l0.y.d.a(this.f56527e.getPageActivity(), this.z);
                    this.t = aVar;
                    aVar.d(this);
                }
                this.t.c(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.f56527e.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.t.showAtLocation(this.f56530h, 81, 0, this.f56527e.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                return;
            }
            a();
        } else if (view == this.u) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f56527e.getPageActivity(), this.z == 1, 25021)));
        }
    }

    public void p(f.g gVar) {
        this.f56529g.a(gVar);
    }

    public void q(BdListView.p pVar) {
        this.f56528f.setOnSrollToBottomListener(pVar);
    }

    public void r() {
        d.a.j0.l0.y.d.a aVar = this.t;
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
                this.f56528f.setNextPage(this.j);
            }
            this.j.M();
            this.j.O();
        }
    }

    public void t() {
        TbPageContext tbPageContext = this.f56527e;
        if (tbPageContext == null || this.f56530h == null) {
            return;
        }
        g gVar = new g(tbPageContext.getPageActivity());
        this.B = gVar;
        gVar.attachView(this.f56530h, false);
        this.B.onChangeSkinType();
    }

    public void u() {
        PbListView pbListView = this.j;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56528f.setNextPage(this.j);
            }
            this.j.A(this.f56527e.getResources().getString(R.string.list_no_more));
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
        d.a.j0.l0.y.d.a aVar = this.t;
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
        d.a.j0.l0.y.b.a aVar = this.r;
        if (aVar != null) {
            aVar.e(emotionPackageData);
        }
    }
}
