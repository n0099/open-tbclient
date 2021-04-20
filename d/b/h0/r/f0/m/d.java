package d.b.h0.r.f0.m;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d extends TBSpecificationButtonConfig {
    public boolean t;

    public d() {
        this.i = true;
        this.f13268b = R.color.CAM_X0101;
        this.f13270d = R.color.CAM_X0302;
        this.t = false;
        this.n = this.o;
        this.m = this.l;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        return p(f2);
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void i(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        s(i, iconType);
    }

    public void o(@ColorRes int i) {
        this.f13268b = i;
        this.f13270d = R.color.CAM_X0904;
        this.t = false;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final Drawable p(float f2) {
        if (this.t) {
            return q(f2);
        }
        return r(f2);
    }

    public final Drawable q(float f2) {
        GradientDrawable gradientDrawable;
        int color = SkinManager.getColor(this.q, this.f13270d);
        int[] iArr = {d.b.i0.d3.c.b(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(this.r);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(this.r, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }

    public final Drawable r(float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(SkinManager.getColor(this.q, this.f13270d));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }

    public void s(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        this.f13271e[0] = i;
        this.f13272f = iconType;
    }
}
