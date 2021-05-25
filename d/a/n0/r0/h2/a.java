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
    public final FrsFragment f58664a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f58665b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58666c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58667d;

    /* renamed from: e  reason: collision with root package name */
    public int f58668e = -1;

    public a(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f58664a = frsFragment;
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
        if (this.f58667d && (i2 = this.f58668e) >= 0) {
            f(i2);
        }
        this.f58667d = false;
    }

    public void c() {
        d1 d1Var = this.f58665b;
        if (d1Var != null) {
            d1Var.e();
        }
    }

    public void d(boolean z) {
        this.f58667d = z;
    }

    public void e(int i2) {
        this.f58668e = i2;
    }

    public final void f(int i2) {
        FrameLayout frameLayout;
        String string;
        r y0 = this.f58664a.y0();
        if (y0 == null || y0.Z() == null || (frameLayout = (FrameLayout) y0.S()) == null) {
            return;
        }
        if (this.f58666c == null && this.f58664a.getPageContext() != null) {
            TextView textView = new TextView(this.f58664a.getPageContext().getPageActivity());
            this.f58666c = textView;
            textView.setTextSize(0, this.f58664a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f58666c.setGravity(17);
        }
        if (this.f58666c != null) {
            if (i2 > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f58666c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f58666c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f58666c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f58665b == null) {
            this.f58665b = new d1();
        }
        this.f58665b.h(this.f58666c, frameLayout, layoutParams, 2000);
        this.f58668e = -1;
    }
}
