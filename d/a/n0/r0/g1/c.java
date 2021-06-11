package d.a.n0.r0.g1;

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
    public View f62295a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62296b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62297c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62298d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62299e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f62300f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f62301g;

    /* renamed from: h  reason: collision with root package name */
    public View f62302h;

    /* renamed from: i  reason: collision with root package name */
    public b f62303i;
    public View.OnClickListener j;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.f62300f.getId()) {
                if (c.this.f62296b.getPageActivity() != null) {
                    c.this.f62296b.getPageActivity().finish();
                }
                c.this.f(2);
            } else if (view.getId() == c.this.f62301g.getId()) {
                if (c.this.j != null) {
                    c.this.j.onClick(view);
                }
                c.this.f(1);
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f62296b = tbPageContext;
        this.f62295a = view;
        this.f62297c = (TextView) view.findViewById(R.id.to_user_name);
        this.f62298d = (TextView) view.findViewById(R.id.content);
        this.f62299e = (TextView) view.findViewById(R.id.sender);
        this.f62300f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.m0.r.f0.m.c cVar = new d.a.m0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f62300f.setConfig(cVar);
        this.f62300f.setTextSize(R.dimen.tbds42);
        this.f62300f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f62300f.setOnClickListener(this.k);
        this.f62301g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f62301g.setConfig(bVar);
        this.f62301g.setTextSize(R.dimen.tbds42);
        this.f62301g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f62301g.setOnClickListener(this.k);
        this.f62302h = view.findViewById(R.id.bottom_layout);
        int i2 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f62302h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f62303i = bVar2;
        bVar2.k();
        i();
        String str = this.f62303i.m;
        if (str != null && str.equals("bazhu")) {
            i2 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i2).param("fid", this.f62303i.f62290e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        String str = this.f62303i.m;
        TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f62303i.f62290e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i2) {
        SkinManager.setViewTextColor(this.f62297c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f62298d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f62299e, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f62295a.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        TextView textView = this.f62297c;
        textView.setText(this.f62303i.f62289d + ":");
        this.f62298d.setText(this.f62303i.j());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView2 = this.f62299e;
        textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
    }

    public void j(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
