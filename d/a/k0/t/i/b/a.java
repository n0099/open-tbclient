package d.a.k0.t.i.b;

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
import d.a.j0.r.q.a2;
import d.a.k0.t.i.d.c;
import d.a.k0.x.m;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f61689e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f61690f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f61691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61692h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f61693i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1644a();

    /* renamed from: d.a.k0.t.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1644a implements View.OnClickListener {
        public View$OnClickListenerC1644a() {
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
        this.f61689e = inflate;
        this.f61690f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f61689e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f61691g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f61692h = (TextView) this.f61689e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f61689e.findViewById(R.id.ala_video_container);
        this.j = this.f61689e.findViewById(R.id.divider_below_reply_number_layout);
        this.f61693i = (ThreadCommentAndPraiseInfoLayout) this.f61689e.findViewById(R.id.text_bottom);
        this.l = this.f61689e.findViewById(R.id.divider_line);
        this.f61690f.setOnClickListener(this);
        this.f61693i.setOnClickListener(this);
        this.f61693i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f61689e;
    }

    public final void d(a2 a2Var) {
        this.f61693i.onChangeSkinType();
        this.f61691g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f61690f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f61692h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f61692h, R.color.CAM_X0105);
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
        this.f61690f.setVisibility(0);
        this.f61691g.j(a2Var);
        if (this.f61691g.getHeaderImg() != null) {
            this.f61691g.getHeaderImg().setData(a2Var);
        }
        this.f61691g.setUserAfterClickListener(this.p);
        a2Var.U2(false, true);
        this.f61692h.setText(a2Var.l1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.f61693i.setReplyTimeVisible(false);
        this.f61693i.setNeedAddReplyIcon(true);
        this.f61693i.setIsBarViewVisible(false);
        this.f61693i.setCommentNumEnable(false);
        this.f61693i.setOnClickListener(this);
        this.f61693i.setLiveShareEnable(false);
        this.f61693i.setShareVisible(true);
        this.f61693i.setShowPraiseNum(true);
        this.f61693i.setNeedAddPraiseIcon(true);
        this.f61693i.setFrom(2);
        if (this.f61693i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.f61693i == null || (threadUserInfoLayout = this.f61691g) == null) {
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
        if (view != this.f61690f && view != this.f61693i.getCommentContainer()) {
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
