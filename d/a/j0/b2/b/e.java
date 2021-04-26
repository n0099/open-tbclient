package d.a.j0.b2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class e extends b {
    public ViewStub o;
    public ViewStub p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;

    public e(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_number);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((l.i(tbPageContext.getPageActivity()) / 2) + l.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - l.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view.findViewById(R.id.user_number);
        ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.viewstub_login_tip);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view.findViewById(R.id.tip_1);
        this.s = (TextView) view.findViewById(R.id.operator_text);
        this.t = (TextView) view.findViewById(R.id.tip_2);
        this.u = (TextView) view.findViewById(R.id.agreement_text);
        this.v = (TextView) view.findViewById(R.id.tip_3);
        this.w = (TextView) view.findViewById(R.id.privacy_text);
    }

    @Override // d.a.j0.b2.b.b
    public void a(int i2) {
        super.a(i2);
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.q);
        d2.q(R.color.CAM_X0105);
        d2.u(R.dimen.T_X03);
        d2.v(R.string.F_X02);
        d.a.i0.r.u.c d3 = d.a.i0.r.u.c.d(this.r);
        d3.q(R.color.CAM_X0108);
        d3.u(R.dimen.tbds29);
        d3.v(R.string.F_X01);
        d.a.i0.r.u.c d4 = d.a.i0.r.u.c.d(this.t);
        d4.q(R.color.CAM_X0108);
        d4.u(R.dimen.tbds29);
        d4.v(R.string.F_X01);
        d.a.i0.r.u.c d5 = d.a.i0.r.u.c.d(this.v);
        d5.q(R.color.CAM_X0108);
        d5.u(R.dimen.tbds29);
        d5.v(R.string.F_X01);
        d.a.i0.r.u.c d6 = d.a.i0.r.u.c.d(this.s);
        d6.q(R.color.CAM_X0302);
        d6.u(R.dimen.tbds29);
        d6.v(R.string.F_X01);
        d.a.i0.r.u.c d7 = d.a.i0.r.u.c.d(this.u);
        d7.q(R.color.CAM_X0302);
        d7.u(R.dimen.tbds29);
        d7.v(R.string.F_X01);
        d.a.i0.r.u.c d8 = d.a.i0.r.u.c.d(this.w);
        d8.q(R.color.CAM_X0302);
        d8.u(R.dimen.tbds29);
        d8.v(R.string.F_X01);
    }

    @Override // d.a.j0.b2.b.b
    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        this.q.setText(cVar.f51513a);
        f(cVar.a());
    }

    @Override // d.a.j0.b2.b.b
    public void d(View.OnClickListener onClickListener) {
        super.d(onClickListener);
        this.s.setOnClickListener(onClickListener);
        this.u.setOnClickListener(onClickListener);
        this.w.setOnClickListener(onClickListener);
    }

    public final void f(int i2) {
        if (i2 == 1) {
            this.s.setText(R.string.onekey_login_dialog_activity_operator_1);
        } else if (i2 == 2) {
            this.s.setText(R.string.onekey_login_dialog_activity_operator_2);
        } else if (i2 != 3) {
        } else {
            this.s.setText(R.string.onekey_login_dialog_activity_operator_3);
        }
    }
}
