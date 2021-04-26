package d.a.j0.q0.h2;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.e.p.l;
import d.a.j0.q0.d1;
import d.a.j0.q0.r;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f57781a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f57782b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57783c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57784d;

    /* renamed from: e  reason: collision with root package name */
    public int f57785e = -1;

    public a(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f57781a = frsFragment;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.getStatusBarHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("FrsFragment is null");
    }

    public void a(int i2) {
        if (i2 >= 0) {
            d(true);
            e(i2);
            return;
        }
        d(false);
        e(i2);
    }

    public void b() {
        int i2;
        if (this.f57784d && (i2 = this.f57785e) >= 0) {
            f(i2);
        }
        this.f57784d = false;
    }

    public void c() {
        d1 d1Var = this.f57782b;
        if (d1Var != null) {
            d1Var.e();
        }
    }

    public void d(boolean z) {
        this.f57784d = z;
    }

    public void e(int i2) {
        this.f57785e = i2;
    }

    public final void f(int i2) {
        FrameLayout frameLayout;
        String string;
        r z0 = this.f57781a.z0();
        if (z0 == null || z0.Z() == null || (frameLayout = (FrameLayout) z0.S()) == null) {
            return;
        }
        if (this.f57783c == null && this.f57781a.getPageContext() != null) {
            TextView textView = new TextView(this.f57781a.getPageContext().getPageActivity());
            this.f57783c = textView;
            textView.setTextSize(0, this.f57781a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f57783c.setGravity(17);
        }
        if (this.f57783c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f57783c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f57783c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f57783c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f57782b == null) {
            this.f57782b = new d1();
        }
        this.f57782b.h(this.f57783c, frameLayout, layoutParams, 2000);
        this.f57785e = -1;
    }
}
