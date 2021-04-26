package d.a.i0.d0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final int f48418i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: a  reason: collision with root package name */
    public ImageView f48419a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f48420b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f48421c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f48422d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f48423e;

    /* renamed from: f  reason: collision with root package name */
    public int f48424f;

    /* renamed from: g  reason: collision with root package name */
    public int f48425g;

    /* renamed from: h  reason: collision with root package name */
    public int f48426h;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.f48419a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f48420b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f48421c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f48423e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f48422d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.i0.r.f0.m.a aVar = new d.a.i0.r.f0.m.a();
        this.f48422d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f48422d.setTextSize(R.dimen.T_X05);
        this.f48422d.setConfig(aVar);
        this.f48424f = R.drawable.new_pic_emotion_08;
        this.f48425g = R.color.CAM_X0107;
        this.f48426h = R.color.CAM_X0109;
        this.f48422d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        if (this.f48422d.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f48423e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = j;
                this.f48423e.setLayoutParams(marginLayoutParams);
            }
            this.f48420b.setVisibility(8);
            this.f48425g = R.color.CAM_X0107;
        } else if (this.f48420b.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f48423e.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = j;
                this.f48423e.setLayoutParams(marginLayoutParams2);
            }
            this.f48425g = R.color.CAM_X0107;
        } else if (this.f48421c.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f48423e.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = l;
                this.f48423e.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.f48421c.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = m;
                this.f48421c.setLayoutParams(marginLayoutParams4);
            }
            this.f48425g = R.color.CAM_X0107;
            this.f48426h = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f48419a.getLayoutParams();
            int i2 = f48418i;
            layoutParams5.width = i2;
            layoutParams5.height = i2;
            this.f48419a.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f48423e.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = k;
                this.f48423e.setLayoutParams(marginLayoutParams5);
            }
            this.f48426h = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public View b() {
        return this.attachedView;
    }

    public View c() {
        return this.f48422d;
    }

    public TextView d() {
        return this.f48421c;
    }

    public void e() {
        this.f48422d.setVisibility(8);
        this.f48421c.setVisibility(8);
        SkinManager.setViewTextColor(this.f48420b, R.color.CAM_X0109, 1);
        a();
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.attachedView, i2);
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f48422d.setText(str);
    }

    public void h(int i2) {
        this.f48424f = i2;
        SkinManager.setImageResource(this.f48419a, i2);
    }

    public void i(int i2) {
        this.f48424f = i2;
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f48419a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f48419a.setLayoutParams(marginLayoutParams);
        }
    }

    public void k(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f48419a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize + i2;
            this.f48419a.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(String str) {
        if (str == null) {
            this.f48420b.setVisibility(8);
        } else {
            this.f48420b.setVisibility(0);
            this.f48420b.setText(str);
        }
        a();
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        this.f48421c.setText(str);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        this.f48421c.setText(str);
        this.f48421c.setVisibility(0);
        a();
    }

    public void o() {
        this.f48422d.setVisibility(0);
        this.f48421c.setVisibility(0);
        SkinManager.setViewTextColor(this.f48420b, R.color.CAM_X0109, 1);
        a();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f48419a, this.f48424f);
        SkinManager.setViewTextColor(this.f48420b, this.f48426h, 1, skinType);
        SkinManager.setViewTextColor(this.f48421c, this.f48425g, 1, skinType);
        TBSpecificationBtn tBSpecificationBtn = this.f48422d;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.i0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.i0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f48419a.setImageResource(0);
    }
}
