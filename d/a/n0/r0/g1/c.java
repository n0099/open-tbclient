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
    public View f58604a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58605b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58606c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58607d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58608e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f58609f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f58610g;

    /* renamed from: h  reason: collision with root package name */
    public View f58611h;

    /* renamed from: i  reason: collision with root package name */
    public b f58612i;
    public View.OnClickListener j;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == c.this.f58609f.getId()) {
                if (c.this.f58605b.getPageActivity() != null) {
                    c.this.f58605b.getPageActivity().finish();
                }
                c.this.f(2);
            } else if (view.getId() == c.this.f58610g.getId()) {
                if (c.this.j != null) {
                    c.this.j.onClick(view);
                }
                c.this.f(1);
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
        this.f58605b = tbPageContext;
        this.f58604a = view;
        this.f58606c = (TextView) view.findViewById(R.id.to_user_name);
        this.f58607d = (TextView) view.findViewById(R.id.content);
        this.f58608e = (TextView) view.findViewById(R.id.sender);
        this.f58609f = (TBSpecificationBtn) view.findViewById(R.id.btn_known);
        d.a.m0.r.f0.m.c cVar = new d.a.m0.r.f0.m.c();
        cVar.o(R.color.CAM_X0618);
        this.f58609f.setConfig(cVar);
        this.f58609f.setTextSize(R.dimen.tbds42);
        this.f58609f.setText(tbPageContext.getString(R.string.guide_popup_window_known));
        this.f58609f.setOnClickListener(this.k);
        this.f58610g = (TBSpecificationBtn) view.findViewById(R.id.btn_share);
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f58610g.setConfig(bVar);
        this.f58610g.setTextSize(R.dimen.tbds42);
        this.f58610g.setText(tbPageContext.getString(R.string.go_to_share));
        this.f58610g.setOnClickListener(this.k);
        this.f58611h = view.findViewById(R.id.bottom_layout);
        int i2 = 2;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{tbPageContext.getResources().getColor(R.color.black_alpha100), tbPageContext.getResources().getColor(R.color.black_alpha0)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        this.f58611h.setBackground(gradientDrawable);
        b bVar2 = new b(tbPageContext);
        this.f58612i = bVar2;
        bVar2.k();
        i();
        String str = this.f58612i.m;
        if (str != null && str.equals("bazhu")) {
            i2 = 1;
        }
        TiebaStatic.log(new StatisticItem("c13893").param("obj_source", i2).param("fid", this.f58612i.f58599e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void f(int i2) {
        String str = this.f58612i.m;
        TiebaStatic.log(new StatisticItem("c13892").param("obj_type", i2).param("obj_source", (str == null || !str.equals("bazhu")) ? 2 : 1).param("fid", this.f58612i.f58599e).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public void g(int i2) {
        SkinManager.setViewTextColor(this.f58606c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58607d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f58608e, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f58604a.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        TextView textView = this.f58606c;
        textView.setText(this.f58612i.f58598d + ":");
        this.f58607d.setText(this.f58612i.j());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView2 = this.f58608e;
        textView2.setText("百度贴吧\n" + simpleDateFormat.format(date));
    }

    public void j(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
