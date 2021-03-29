package d.b.i0.p0.g1;

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
    public View f57539a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57540b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57541c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57542d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57543e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f57544f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f57545g;

    /* renamed from: h  reason: collision with root package name */
    public View f57546h;
    public b i;
    public View.OnClickListener j;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.f57544f.getId()) {
                if (c.this.f57540b.getPageActivity() != null) {
                    c.this.f57540b.getPageActivity().finish();
                }
                c.this.f(2);
            } else if (view.getId() == c.this.f57545g.getId()) {
                if (c.this.j != null) {
                    c.this.j.onClick(view);
                }
                c.this.f(1);
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f57540b = tbPageContext;
        this.f57539a = view;
        this.f57541c = (TextView) view.findViewById(R.id.to_user_name);
        this.f57542d = (TextView) view.findViewById(R.id.content);
        this.f57543e = (TextView) view.findViewById(R.id.sender);
        this.f57544f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.b.h0.r.f0.m.c cVar = new d.b.h0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f57544f.setConfig(cVar);
        this.f57544f.setTextSize(R.dimen.tbds42);
        this.f57544f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f57544f.setOnClickListener(this.k);
        this.f57545g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f57545g.setConfig(bVar);
        this.f57545g.setTextSize(R.dimen.tbds42);
        this.f57545g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f57545g.setOnClickListener(this.k);
        this.f57546h = view.findViewById(R.id.bottom_layout);
        int i = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f57546h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.i = bVar2;
        bVar2.k();
        i();
        String str = this.i.m;
        if (str != null && str.equals("bazhu")) {
            i = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i).param("fid", this.i.f57535e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i) {
        String str = this.i.m;
        TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.i.f57535e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i) {
        SkinManager.setViewTextColor(this.f57541c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f57542d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f57543e, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f57539a.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        TextView textView = this.f57541c;
        textView.setText(this.i.f57534d + ":");
        this.f57542d.setText(this.i.j());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView2 = this.f57543e;
        textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
    }

    public void j(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
