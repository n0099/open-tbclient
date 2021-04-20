package d.b.h0.d0;

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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class h extends a {
    public static final int i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    public static final int l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    public static final int m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    /* renamed from: a  reason: collision with root package name */
    public ImageView f50505a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f50506b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50507c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f50508d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50509e;

    /* renamed from: f  reason: collision with root package name */
    public int f50510f;

    /* renamed from: g  reason: collision with root package name */
    public int f50511g;

    /* renamed from: h  reason: collision with root package name */
    public int f50512h;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.f50505a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f50506b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f50507c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f50509e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f50508d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        this.f50508d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f50508d.setTextSize(R.dimen.T_X05);
        this.f50508d.setConfig(aVar);
        this.f50510f = R.drawable.new_pic_emotion_08;
        this.f50511g = R.color.CAM_X0107;
        this.f50512h = R.color.CAM_X0109;
        this.f50508d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        if (this.f50508d.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.f50509e.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = j;
                this.f50509e.setLayoutParams(marginLayoutParams);
            }
            this.f50506b.setVisibility(8);
            this.f50511g = R.color.CAM_X0107;
        } else if (this.f50506b.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.f50509e.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = j;
                this.f50509e.setLayoutParams(marginLayoutParams2);
            }
            this.f50511g = R.color.CAM_X0107;
        } else if (this.f50507c.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.f50509e.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = l;
                this.f50509e.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.f50507c.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = m;
                this.f50507c.setLayoutParams(marginLayoutParams4);
            }
            this.f50511g = R.color.CAM_X0107;
            this.f50512h = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.f50505a.getLayoutParams();
            int i2 = i;
            layoutParams5.width = i2;
            layoutParams5.height = i2;
            this.f50505a.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.f50509e.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = k;
                this.f50509e.setLayoutParams(marginLayoutParams5);
            }
            this.f50512h = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public View b() {
        return this.attachedView;
    }

    public View c() {
        return this.f50508d;
    }

    public TextView d() {
        return this.f50507c;
    }

    public void e() {
        this.f50508d.setVisibility(8);
        this.f50507c.setVisibility(8);
        SkinManager.setViewTextColor(this.f50506b, R.color.CAM_X0109, 1);
        a();
    }

    public void f(int i2) {
        SkinManager.setBackgroundColor(this.attachedView, i2);
    }

    public void g(String str) {
        if (str == null) {
            return;
        }
        this.f50508d.setText(str);
    }

    public void h(int i2) {
        this.f50510f = i2;
        SkinManager.setImageResource(this.f50505a, i2);
    }

    public void i(int i2) {
        this.f50510f = i2;
    }

    public void j(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f50505a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2;
            this.f50505a.setLayoutParams(marginLayoutParams);
        }
    }

    public void k(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = l.i(TbadkCoreApplication.getInst());
        int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
        ViewGroup.LayoutParams layoutParams = this.f50505a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize + i2;
            this.f50505a.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(String str) {
        if (str == null) {
            this.f50506b.setVisibility(8);
        } else {
            this.f50506b.setVisibility(0);
            this.f50506b.setText(str);
        }
        a();
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        this.f50507c.setText(str);
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        this.f50507c.setText(str);
        this.f50507c.setVisibility(0);
        a();
    }

    public void o() {
        this.f50508d.setVisibility(0);
        this.f50507c.setVisibility(0);
        SkinManager.setViewTextColor(this.f50506b, R.color.CAM_X0109, 1);
        a();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource(this.f50505a, this.f50510f);
        SkinManager.setViewTextColor(this.f50506b, this.f50512h, 1, skinType);
        SkinManager.setViewTextColor(this.f50507c, this.f50511g, 1, skinType);
        TBSpecificationBtn tBSpecificationBtn = this.f50508d;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
    }

    @Override // d.b.h0.d0.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    @Override // d.b.h0.d0.a
    public void onViewDettached() {
        super.onViewDettached();
        this.f50505a.setImageResource(0);
    }
}
