package d.a.m0.d0;

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
    public static final int f52964i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: a  reason: collision with root package name */
    public ImageView f52965a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52966b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52967c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f52968d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52969e;

    /* renamed from: f  reason: collision with root package name */
    public int f52970f;

    /* renamed from: g  reason: collision with root package name */
    public int f52971g;

    /* renamed from: h  reason: collision with root package name */
    public int f52972h;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.f52965a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f52966b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f52967c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f52969e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f52968d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.m0.r.f0.m.a aVar = new d.a.m0.r.f0.m.a();
        this.f52968d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f52968d.setTextSize(R.dimen.T_X05);
        this.f52968d.setConfig(aVar);
        this.f52970f = R.drawable.new_pic_emotion_08;
        this.f52971g = R.color.CAM_X0107;
        this.f52972h = R.color.CAM_X0109;
        this.f52968d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        if (this.f52968d.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f52969e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = j;
                this.f52969e.setLayoutParams(marginLayoutParams);
            }
            this.f52966b.setVisibility(8);
            this.f52971g = R.color.CAM_X0107;
        } else if (this.f52966b.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f52969e.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = j;
                this.f52969e.setLayoutParams(marginLayoutParams2);
            }
            this.f52971g = R.color.CAM_X0107;
        } else if (this.f52967c.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f52969e.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = l;
                this.f52969e.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.f52967c.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = m;
                this.f52967c.setLayoutParams(marginLayoutParams4);
            }
            this.f52971g = R.color.CAM_X0107;
            this.f52972h = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f52965a.getLayoutParams();
            int i2 = f52964i;
            layoutParams5.width = i2;
            layoutParams5.height = i2;
            this.f52965a.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f52969e.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = k;
                this.f52969e.setLayoutParams(marginLayoutParams5);
            }
            this.f52972h = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public View b() {
        return this.attachedView;
    }

    public View c() {
        return this.f52968d;
    }

    public TextView d() {
        return this.f52967c;
    }

    public void e() {
        this.f52968d.setVisibility(8);
        this.f52967c.setVisibility(8);
        SkinManager.setViewTextColor(this.f52966b, R.color.CAM_X0109, 1);
        a();
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.attachedView, i2);
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f52968d.setText(str);
    }

    public void h(int i2) {
        this.f52970f = i2;
        SkinManager.setImageResource(this.f52965a, i2);
    }

    public void i(int i2) {
        this.f52970f = i2;
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f52965a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f52965a.setLayoutParams(marginLayoutParams);
        }
    }

    public void k(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f52965a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize + i2;
            this.f52965a.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(String str) {
        if (str == null) {
            this.f52966b.setVisibility(8);
        } else {
            this.f52966b.setVisibility(0);
            this.f52966b.setText(str);
        }
        a();
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        this.f52967c.setText(str);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        this.f52967c.setText(str);
        this.f52967c.setVisibility(0);
        a();
    }

    public void o() {
        this.f52968d.setVisibility(0);
        this.f52967c.setVisibility(0);
        SkinManager.setViewTextColor(this.f52966b, R.color.CAM_X0109, 1);
        a();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f52965a, this.f52970f);
        SkinManager.setViewTextColor(this.f52966b, this.f52972h, 1, skinType);
        SkinManager.setViewTextColor(this.f52967c, this.f52971g, 1, skinType);
        TBSpecificationBtn tBSpecificationBtn = this.f52968d;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.a.m0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.a.m0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f52965a.setImageResource(0);
    }
}
