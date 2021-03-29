package d.b.i0.a2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class e extends b {
    public ViewStub n;
    public ViewStub o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;

    public e(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_number);
        this.n = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.topMargin = ((l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - l.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.n.setLayoutParams(layoutParams);
        this.p = (TextView) view.findViewById(R.id.user_number);
        ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.viewstub_login_tip);
        this.o = viewStub2;
        viewStub2.inflate();
        this.q = (TextView) view.findViewById(R.id.tip_1);
        this.r = (TextView) view.findViewById(R.id.operator_text);
        this.s = (TextView) view.findViewById(R.id.tip_2);
        this.t = (TextView) view.findViewById(R.id.agreement_text);
        this.u = (TextView) view.findViewById(R.id.tip_3);
        this.v = (TextView) view.findViewById(R.id.privacy_text);
    }

    @Override // d.b.i0.a2.b.b
    public void a(int i) {
        super.a(i);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.p);
        a2.n(R.color.CAM_X0105);
        a2.r(R.dimen.T_X03);
        a2.s(R.string.F_X02);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.q);
        a3.n(R.color.CAM_X0108);
        a3.r(R.dimen.tbds29);
        a3.s(R.string.F_X01);
        d.b.h0.r.u.c a4 = d.b.h0.r.u.c.a(this.s);
        a4.n(R.color.CAM_X0108);
        a4.r(R.dimen.tbds29);
        a4.s(R.string.F_X01);
        d.b.h0.r.u.c a5 = d.b.h0.r.u.c.a(this.u);
        a5.n(R.color.CAM_X0108);
        a5.r(R.dimen.tbds29);
        a5.s(R.string.F_X01);
        d.b.h0.r.u.c a6 = d.b.h0.r.u.c.a(this.r);
        a6.n(R.color.CAM_X0302);
        a6.r(R.dimen.tbds29);
        a6.s(R.string.F_X01);
        d.b.h0.r.u.c a7 = d.b.h0.r.u.c.a(this.t);
        a7.n(R.color.CAM_X0302);
        a7.r(R.dimen.tbds29);
        a7.s(R.string.F_X01);
        d.b.h0.r.u.c a8 = d.b.h0.r.u.c.a(this.v);
        a8.n(R.color.CAM_X0302);
        a8.r(R.dimen.tbds29);
        a8.s(R.string.F_X01);
    }

    @Override // d.b.i0.a2.b.b
    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        this.p.setText(cVar.f51922a);
        f(cVar.a());
    }

    @Override // d.b.i0.a2.b.b
    public void d(View.OnClickListener onClickListener) {
        super.d(onClickListener);
        this.r.setOnClickListener(onClickListener);
        this.t.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
    }

    public final void f(int i) {
        if (i == 1) {
            this.r.setText(R.string.onekey_login_dialog_activity_operator_1);
        } else if (i == 2) {
            this.r.setText(R.string.onekey_login_dialog_activity_operator_2);
        } else if (i != 3) {
        } else {
            this.r.setText(R.string.onekey_login_dialog_activity_operator_3);
        }
    }
}
