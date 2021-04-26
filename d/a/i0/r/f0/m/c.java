package d.a.i0.r.f0.m;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class c extends TBSpecificationButtonConfig {
    public boolean t;

    public c() {
        this.f13236b = R.color.CAM_X0302;
        this.t = false;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f2) {
        return s(f2);
    }

    public void o(@ColorRes int i2) {
        this.f13236b = i2;
        this.t = false;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void p(@ColorInt int i2) {
        this.f13236b = i2;
        this.t = false;
        this.p = false;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void q(@ColorRes int i2) {
        this.f13236b = i2;
        this.f13237c = R.color.CAM_X0902;
        this.t = true;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void r() {
        this.f13236b = R.color.CAM_X0101;
        this.t = false;
        this.p = true;
        TBSpecificationButtonConfig.a aVar = this.s;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final Drawable s(float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.t) {
            gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), SkinManager.getColor(this.q, this.f13237c));
        } else {
            gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), d.a.j0.d3.c.a(this.p ? SkinManager.getColor(this.q, this.f13236b) : this.f13236b, d.a.i0.r.u.a.a(R.string.A_X07)));
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }
}
