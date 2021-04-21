package d.b.j0.b2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
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

    @Override // d.b.j0.b2.b.b
    public void a(int i) {
        super.a(i);
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.p);
        d2.q(R.color.CAM_X0105);
        d2.u(R.dimen.T_X03);
        d2.v(R.string.F_X02);
        d.b.i0.r.u.c d3 = d.b.i0.r.u.c.d(this.q);
        d3.q(R.color.CAM_X0108);
        d3.u(R.dimen.tbds29);
        d3.v(R.string.F_X01);
        d.b.i0.r.u.c d4 = d.b.i0.r.u.c.d(this.s);
        d4.q(R.color.CAM_X0108);
        d4.u(R.dimen.tbds29);
        d4.v(R.string.F_X01);
        d.b.i0.r.u.c d5 = d.b.i0.r.u.c.d(this.u);
        d5.q(R.color.CAM_X0108);
        d5.u(R.dimen.tbds29);
        d5.v(R.string.F_X01);
        d.b.i0.r.u.c d6 = d.b.i0.r.u.c.d(this.r);
        d6.q(R.color.CAM_X0302);
        d6.u(R.dimen.tbds29);
        d6.v(R.string.F_X01);
        d.b.i0.r.u.c d7 = d.b.i0.r.u.c.d(this.t);
        d7.q(R.color.CAM_X0302);
        d7.u(R.dimen.tbds29);
        d7.v(R.string.F_X01);
        d.b.i0.r.u.c d8 = d.b.i0.r.u.c.d(this.v);
        d8.q(R.color.CAM_X0302);
        d8.u(R.dimen.tbds29);
        d8.v(R.string.F_X01);
    }

    @Override // d.b.j0.b2.b.b
    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        this.p.setText(cVar.f53763a);
        f(cVar.a());
    }

    @Override // d.b.j0.b2.b.b
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
