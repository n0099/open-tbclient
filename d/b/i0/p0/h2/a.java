package d.b.i0.p0.h2;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import d.b.b.e.p.l;
import d.b.i0.p0.d1;
import d.b.i0.p0.r;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f57595a;

    /* renamed from: b  reason: collision with root package name */
    public d1 f57596b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57598d;

    /* renamed from: e  reason: collision with root package name */
    public int f57599e = -1;

    public a(FrsFragment frsFragment) {
        if (frsFragment != null) {
            this.f57595a = frsFragment;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.getStatusBarHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("FrsFragment is null");
    }

    public void a(int i) {
        if (i >= 0) {
            d(true);
            e(i);
            return;
        }
        d(false);
        e(i);
    }

    public void b() {
        int i;
        if (this.f57598d && (i = this.f57599e) >= 0) {
            f(i);
        }
        this.f57598d = false;
    }

    public void c() {
        d1 d1Var = this.f57596b;
        if (d1Var != null) {
            d1Var.e();
        }
    }

    public void d(boolean z) {
        this.f57598d = z;
    }

    public void e(int i) {
        this.f57599e = i;
    }

    public final void f(int i) {
        FrameLayout frameLayout;
        String string;
        r x0 = this.f57595a.x0();
        if (x0 == null || x0.Z() == null || (frameLayout = (FrameLayout) x0.S()) == null) {
            return;
        }
        if (this.f57597c == null && this.f57595a.getPageContext() != null) {
            TextView textView = new TextView(this.f57595a.getPageContext().getPageActivity());
            this.f57597c = textView;
            textView.setTextSize(0, this.f57595a.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            this.f57597c.setGravity(17);
        }
        if (this.f57597c != null) {
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.smart_frs_refresh_nodata);
            }
            this.f57597c.setText(string);
        }
        SkinManager.setBackgroundResource(this.f57597c, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f57597c, R.color.CAM_X0112);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f57596b == null) {
            this.f57596b = new d1();
        }
        this.f57596b.h(this.f57597c, frameLayout, layoutParams, 2000);
        this.f57599e = -1;
    }
}
