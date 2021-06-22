package d.a.o0.v.i.b;

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
import d.a.n0.r.q.a2;
import d.a.o0.v.i.d.c;
import d.a.o0.z.m;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f65817e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f65818f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f65819g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65820h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f65821i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public a2 m;
    public String n;
    public c o;
    public final View.OnClickListener p = new View$OnClickListenerC1725a();

    /* renamed from: d.a.o0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1725a implements View.OnClickListener {
        public View$OnClickListenerC1725a() {
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
        this.f65817e = inflate;
        this.f65818f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f65817e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f65819g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f65820h = (TextView) this.f65817e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f65817e.findViewById(R.id.ala_video_container);
        this.j = this.f65817e.findViewById(R.id.divider_below_reply_number_layout);
        this.f65821i = (ThreadCommentAndPraiseInfoLayout) this.f65817e.findViewById(R.id.text_bottom);
        this.l = this.f65817e.findViewById(R.id.divider_line);
        this.f65818f.setOnClickListener(this);
        this.f65821i.setOnClickListener(this);
        this.f65821i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        return this.f65817e;
    }

    public final void d(a2 a2Var) {
        this.f65821i.onChangeSkinType();
        this.f65819g.h();
        this.k.o(TbadkCoreApplication.getInst().getSkinType());
        this.f65818f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        if (a2Var != null && m.k(a2Var.o0())) {
            SkinManager.setViewTextColor(this.f65820h, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.f65820h, R.color.CAM_X0105);
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
        this.f65818f.setVisibility(0);
        this.f65819g.j(a2Var);
        if (this.f65819g.getHeaderImg() != null) {
            this.f65819g.getHeaderImg().setData(a2Var);
        }
        this.f65819g.setUserAfterClickListener(this.p);
        a2Var.W2(false, true);
        this.f65820h.setText(a2Var.n1());
        this.k.getController().d(a2Var, str, "", false);
        this.k.getController().c();
        this.f65821i.setReplyTimeVisible(false);
        this.f65821i.setNeedAddReplyIcon(true);
        this.f65821i.setIsBarViewVisible(false);
        this.f65821i.setCommentNumEnable(false);
        this.f65821i.setOnClickListener(this);
        this.f65821i.setLiveShareEnable(false);
        this.f65821i.setShareVisible(true);
        this.f65821i.setShowPraiseNum(true);
        this.f65821i.setNeedAddPraiseIcon(true);
        this.f65821i.setFrom(2);
        if (this.f65821i.setData(a2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(a2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.f65821i == null || (threadUserInfoLayout = this.f65819g) == null) {
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
        if (view != this.f65818f && view != this.f65821i.getCommentContainer()) {
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
