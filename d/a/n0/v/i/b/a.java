package d.a.n0.v.i.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.a.m0.r.q.a2;
import d.a.n0.v.i.d.c;
import d.a.n0.z.m;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f61977e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f61978f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f61979g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61980h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f61981i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1664a();

    /* renamed from: d.a.n0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1664a implements View.OnClickListener {
        public View$OnClickListenerC1664a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.o != null) {
                a.this.o.b(view, a.this.m);
            }
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f61977e = inflate;
        this.f61978f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f61977e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f61979g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f61980h = (TextView) this.f61977e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f61977e.findViewById(R.id.ala_video_container);
        this.j = this.f61977e.findViewById(R.id.divider_below_reply_number_layout);
        this.f61981i = (ThreadCommentAndPraiseInfoLayout) this.f61977e.findViewById(R.id.text_bottom);
        this.l = this.f61977e.findViewById(R.id.divider_line);
        this.f61978f.setOnClickListener(this);
        this.f61981i.setOnClickListener(this);
        this.f61981i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f61977e;
    }

    public final void d(a2 a2Var) {
        this.f61981i.onChangeSkinType();
        this.f61979g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f61978f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f61980h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f61980h, R.color.CAM_X0105);
        }
    }

    public void e() {
        a2 a2Var = this.m;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        f(this.m, this.n);
    }

    public void f(a2 a2Var, String str) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        this.m = a2Var;
        this.n = str;
        this.f61978f.setVisibility(0);
        this.f61979g.j(a2Var);
        if (this.f61979g.getHeaderImg() != null) {
            this.f61979g.getHeaderImg().setData(a2Var);
        }
        this.f61979g.setUserAfterClickListener(this.p);
        a2Var.V2(false, true);
        this.f61980h.setText(a2Var.m1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.f61981i.setReplyTimeVisible(false);
        this.f61981i.setNeedAddReplyIcon(true);
        this.f61981i.setIsBarViewVisible(false);
        this.f61981i.setCommentNumEnable(false);
        this.f61981i.setOnClickListener(this);
        this.f61981i.setLiveShareEnable(false);
        this.f61981i.setShareVisible(true);
        this.f61981i.setShowPraiseNum(true);
        this.f61981i.setNeedAddPraiseIcon(true);
        this.f61981i.setFrom(2);
        if (this.f61981i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.f61981i == null || (threadUserInfoLayout = this.f61979g) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public void h(c cVar) {
        this.o = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        if (view != this.f61978f && view != this.f61981i.getCommentContainer()) {
            if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                return;
            }
            cVar.a(view, this.m);
            return;
        }
        a2 a2Var = this.m;
        if (a2Var != null) {
            m.a(a2Var.o0());
        }
        c cVar2 = this.o;
        if (cVar2 != null) {
            cVar2.a(view, this.m);
        }
    }
}
