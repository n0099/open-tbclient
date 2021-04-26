package d.a.i0.r.f0.m;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends TBSpecificationButtonConfig {
    public a() {
        this.f13236b = R.color.CAM_X0101;
        this.f13238d = R.color.CAM_X0302;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        return p(f2);
    }

    public void o(@ColorRes int i2) {
        this.f13238d = i2;
        this.f13236b = R.color.CAM_X0101;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final Drawable p(float f2) {
        GradientDrawable gradientDrawable;
        if (!this.p) {
            this.f13236b = SkinManager.getColor(this.q, R.color.CAM_X0101);
        }
        int color = this.p ? SkinManager.getColor(this.q, this.f13238d) : this.f13238d;
        int[] iArr = {d.a.j0.d3.c.b(color), color};
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
}
