package d.b.h0.r.f0.m;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends TBSpecificationButtonConfig {
    public boolean t;

    public b() {
        this.f13607b = R.color.CAM_X0302;
        this.t = true;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        return t(f2);
    }

    public void o(@ColorRes int i, @ColorRes int i2) {
        this.f13609d = i;
        this.f13607b = i2;
        this.t = false;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void p() {
        this.f13607b = R.color.CAM_X0101;
        this.f13609d = R.color.CAM_X0904;
        this.t = false;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void q(@ColorRes int i) {
        this.f13607b = i;
        this.t = true;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void r(@ColorRes int i) {
        this.f13607b = i;
        this.f13609d = R.color.CAM_X0903;
        this.t = false;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void s(@ColorRes int i) {
        this.f13607b = i;
        this.f13609d = R.color.CAM_X0211;
        this.t = false;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final Drawable t(float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.t) {
            gradientDrawable.setColor(d.b.i0.c3.c.a(this.p ? SkinManager.getColor(this.q, this.f13607b) : this.f13607b, 0.08f));
        } else {
            gradientDrawable.setColor(SkinManager.getColor(this.q, this.f13609d));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }
}
