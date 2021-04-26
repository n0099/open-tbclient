package d.a.j0.q0.g1;

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
    public View f57721a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57722b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57723c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57724d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57725e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f57726f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f57727g;

    /* renamed from: h  reason: collision with root package name */
    public View f57728h;

    /* renamed from: i  reason: collision with root package name */
    public b f57729i;
    public View.OnClickListener j;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.f57726f.getId()) {
                if (c.this.f57722b.getPageActivity() != null) {
                    c.this.f57722b.getPageActivity().finish();
                }
                c.this.f(2);
            } else if (view.getId() == c.this.f57727g.getId()) {
                if (c.this.j != null) {
                    c.this.j.onClick(view);
                }
                c.this.f(1);
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f57722b = tbPageContext;
        this.f57721a = view;
        this.f57723c = (TextView) view.findViewById(R.id.to_user_name);
        this.f57724d = (TextView) view.findViewById(R.id.content);
        this.f57725e = (TextView) view.findViewById(R.id.sender);
        this.f57726f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.i0.r.f0.m.c cVar = new d.a.i0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f57726f.setConfig(cVar);
        this.f57726f.setTextSize(R.dimen.tbds42);
        this.f57726f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f57726f.setOnClickListener(this.k);
        this.f57727g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f57727g.setConfig(bVar);
        this.f57727g.setTextSize(R.dimen.tbds42);
        this.f57727g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f57727g.setOnClickListener(this.k);
        this.f57728h = view.findViewById(R.id.bottom_layout);
        int i2 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f57728h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f57729i = bVar2;
        bVar2.k();
        i();
        String str = this.f57729i.m;
        if (str != null && str.equals("bazhu")) {
            i2 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i2).param("fid", this.f57729i.f57716e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        String str = this.f57729i.m;
        TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f57729i.f57716e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i2) {
        SkinManager.setViewTextColor(this.f57723c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f57724d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f57725e, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f57721a.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        TextView textView = this.f57723c;
        textView.setText(this.f57729i.f57715d + ":");
        this.f57724d.setText(this.f57729i.j());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView2 = this.f57725e;
        textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
    }

    public void j(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
