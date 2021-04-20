package d.b.i0.t.i.b;

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
import d.b.h0.r.q.a2;
import d.b.i0.t.i.d.c;
import d.b.i0.x.m;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f62348e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f62349f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f62350g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62351h;
    public ThreadCommentAndPraiseInfoLayout i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1616a();

    /* renamed from: d.b.i0.t.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1616a implements View.OnClickListener {
        public View$OnClickListenerC1616a() {
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
        this.f62348e = inflate;
        this.f62349f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f62348e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f62350g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f62351h = (TextView) this.f62348e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f62348e.findViewById(R.id.ala_video_container);
        this.j = this.f62348e.findViewById(R.id.divider_below_reply_number_layout);
        this.i = (ThreadCommentAndPraiseInfoLayout) this.f62348e.findViewById(R.id.text_bottom);
        this.l = this.f62348e.findViewById(R.id.divider_line);
        this.f62349f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f62348e;
    }

    public final void d(a2 a2Var) {
        this.i.onChangeSkinType();
        this.f62350g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f62349f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f62351h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f62351h, R.color.CAM_X0105);
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
        this.f62349f.setVisibility(0);
        this.f62350g.j(a2Var);
        if (this.f62350g.getHeaderImg() != null) {
            this.f62350g.getHeaderImg().setData(a2Var);
        }
        this.f62350g.setUserAfterClickListener(this.p);
        a2Var.S2(false, true);
        this.f62351h.setText(a2Var.l1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.i.setReplyTimeVisible(false);
        this.i.setNeedAddReplyIcon(true);
        this.i.setIsBarViewVisible(false);
        this.i.setCommentNumEnable(false);
        this.i.setOnClickListener(this);
        this.i.setLiveShareEnable(false);
        this.i.setShareVisible(true);
        this.i.setShowPraiseNum(true);
        this.i.setNeedAddPraiseIcon(true);
        this.i.setFrom(2);
        if (this.i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.i == null || (threadUserInfoLayout = this.f62350g) == null) {
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
        if (view != this.f62349f && view != this.i.getCommentContainer()) {
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
