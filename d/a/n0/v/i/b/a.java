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
    public View f65692e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f65693f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f65694g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65695h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f65696i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1721a();

    /* renamed from: d.a.n0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1721a implements View.OnClickListener {
        public View$OnClickListenerC1721a() {
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
        this.f65692e = inflate;
        this.f65693f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f65692e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f65694g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f65695h = (TextView) this.f65692e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f65692e.findViewById(R.id.ala_video_container);
        this.j = this.f65692e.findViewById(R.id.divider_below_reply_number_layout);
        this.f65696i = (ThreadCommentAndPraiseInfoLayout) this.f65692e.findViewById(R.id.text_bottom);
        this.l = this.f65692e.findViewById(R.id.divider_line);
        this.f65693f.setOnClickListener(this);
        this.f65696i.setOnClickListener(this);
        this.f65696i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f65692e;
    }

    public final void d(a2 a2Var) {
        this.f65696i.onChangeSkinType();
        this.f65694g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f65693f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f65695h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f65695h, R.color.CAM_X0105);
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
        this.f65693f.setVisibility(0);
        this.f65694g.j(a2Var);
        if (this.f65694g.getHeaderImg() != null) {
            this.f65694g.getHeaderImg().setData(a2Var);
        }
        this.f65694g.setUserAfterClickListener(this.p);
        a2Var.W2(false, true);
        this.f65695h.setText(a2Var.n1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.f65696i.setReplyTimeVisible(false);
        this.f65696i.setNeedAddReplyIcon(true);
        this.f65696i.setIsBarViewVisible(false);
        this.f65696i.setCommentNumEnable(false);
        this.f65696i.setOnClickListener(this);
        this.f65696i.setLiveShareEnable(false);
        this.f65696i.setShareVisible(true);
        this.f65696i.setShowPraiseNum(true);
        this.f65696i.setNeedAddPraiseIcon(true);
        this.f65696i.setFrom(2);
        if (this.f65696i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.f65696i == null || (threadUserInfoLayout = this.f65694g) == null) {
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
        if (view != this.f65693f && view != this.f65696i.getCommentContainer()) {
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
