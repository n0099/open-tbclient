package d.a.n0.r0.h2;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.e.p.l;
import d.a.n0.r0.d1;
import d.a.n0.r0.r;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f62355a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f62356b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62357c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62358d;

    /* renamed from: e  reason: collision with root package name */
    public int f62359e = -1;

    public a(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f62355a = frsFragment;
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
        if (this.f62358d && (i2 = this.f62359e) >= 0) {
            f(i2);
        }
        this.f62358d = false;
    }

    public void c() {
        d1 d1Var = this.f62356b;
        if (d1Var != null) {
            d1Var.e();
        }
    }

    public void d(boolean z) {
        this.f62358d = z;
    }

    public void e(int i2) {
        this.f62359e = i2;
    }

    public final void f(int i2) {
        FrameLayout frameLayout;
        String string;
        r B0 = this.f62355a.B0();
        if (B0 == null || B0.Z() == null || (frameLayout = (FrameLayout) B0.S()) == null) {
            return;
        }
        if (this.f62357c == null && this.f62355a.getPageContext() != null) {
            TextView textView = new TextView(this.f62355a.getPageContext().getPageActivity());
            this.f62357c = textView;
            textView.setTextSize(0, this.f62355a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f62357c.setGravity(17);
        }
        if (this.f62357c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f62357c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f62357c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f62357c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f62356b == null) {
            this.f62356b = new d1();
        }
        this.f62356b.h(this.f62357c, frameLayout, layoutParams, 2000);
        this.f62359e = -1;
    }
}
