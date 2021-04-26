package d.a.j0.t.i.b;

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
import d.a.i0.r.q.a2;
import d.a.j0.t.i.d.c;
import d.a.j0.x.m;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f60965e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f60966f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f60967g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60968h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f60969i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1579a();

    /* renamed from: d.a.j0.t.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1579a implements View.OnClickListener {
        public View$OnClickListenerC1579a() {
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
        this.f60965e = inflate;
        this.f60966f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f60965e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f60967g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f60968h = (TextView) this.f60965e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f60965e.findViewById(R.id.ala_video_container);
        this.j = this.f60965e.findViewById(R.id.divider_below_reply_number_layout);
        this.f60969i = (ThreadCommentAndPraiseInfoLayout) this.f60965e.findViewById(R.id.text_bottom);
        this.l = this.f60965e.findViewById(R.id.divider_line);
        this.f60966f.setOnClickListener(this);
        this.f60969i.setOnClickListener(this);
        this.f60969i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f60965e;
    }

    public final void d(a2 a2Var) {
        this.f60969i.onChangeSkinType();
        this.f60967g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f60966f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f60968h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f60968h, R.color.CAM_X0105);
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
        this.f60966f.setVisibility(0);
        this.f60967g.j(a2Var);
        if (this.f60967g.getHeaderImg() != null) {
            this.f60967g.getHeaderImg().setData(a2Var);
        }
        this.f60967g.setUserAfterClickListener(this.p);
        a2Var.S2(false, true);
        this.f60968h.setText(a2Var.l1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.f60969i.setReplyTimeVisible(false);
        this.f60969i.setNeedAddReplyIcon(true);
        this.f60969i.setIsBarViewVisible(false);
        this.f60969i.setCommentNumEnable(false);
        this.f60969i.setOnClickListener(this);
        this.f60969i.setLiveShareEnable(false);
        this.f60969i.setShareVisible(true);
        this.f60969i.setShowPraiseNum(true);
        this.f60969i.setNeedAddPraiseIcon(true);
        this.f60969i.setFrom(2);
        if (this.f60969i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.f60969i == null || (threadUserInfoLayout = this.f60967g) == null) {
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
        if (view != this.f60966f && view != this.f60969i.getCommentContainer()) {
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
