package d.a.k0.q0.g1;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f58463a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58464b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58465c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58466d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58467e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f58468f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f58469g;

    /* renamed from: h  reason: collision with root package name */
    public View f58470h;

    /* renamed from: i  reason: collision with root package name */
    public b f58471i;
    public View.OnClickListener j;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.f58468f.getId()) {
                if (c.this.f58464b.getPageActivity() != null) {
                    c.this.f58464b.getPageActivity().finish();
                }
                c.this.f(2);
            } else if (view.getId() == c.this.f58469g.getId()) {
                if (c.this.j != null) {
                    c.this.j.onClick(view);
                }
                c.this.f(1);
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f58464b = tbPageContext;
        this.f58463a = view;
        this.f58465c = (TextView) view.findViewById(R.id.to_user_name);
        this.f58466d = (TextView) view.findViewById(R.id.content);
        this.f58467e = (TextView) view.findViewById(R.id.sender);
        this.f58468f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.j0.r.f0.m.c cVar = new d.a.j0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f58468f.setConfig(cVar);
        this.f58468f.setTextSize(R.dimen.tbds42);
        this.f58468f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f58468f.setOnClickListener(this.k);
        this.f58469g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f58469g.setConfig(bVar);
        this.f58469g.setTextSize(R.dimen.tbds42);
        this.f58469g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f58469g.setOnClickListener(this.k);
        this.f58470h = view.findViewById(R.id.bottom_layout);
        int i2 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f58470h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f58471i = bVar2;
        bVar2.k();
        i();
        String str = this.f58471i.m;
        if (str != null && str.equals("bazhu")) {
            i2 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i2).param("fid", this.f58471i.f58458e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        String str = this.f58471i.m;
        TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f58471i.f58458e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i2) {
        SkinManager.setViewTextColor(this.f58465c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58466d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58467e, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f58463a.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        TextView textView = this.f58465c;
        textView.setText(this.f58471i.f58457d + ":");
        this.f58466d.setText(this.f58471i.j());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView2 = this.f58467e;
        textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
    }

    public void j(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
