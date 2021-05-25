package d.a.n0.r0.o2;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59330a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f59331b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59332c;

    /* renamed from: d  reason: collision with root package name */
    public int f59333d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f59330a = frsFragment;
        this.f59331b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        if (d.a.c.e.p.k.isEmpty(str) || this.f59331b == null || !this.f59330a.isPrimary() || (i2 = this.f59333d) > 0) {
            return;
        }
        this.f59333d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.f59330a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f59330a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f59330a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f59332c.setText(str2);
        SkinManager.setViewTextColor(this.f59332c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f59331b, R.color.cp_link_tip_a_alpha95);
        this.f59331b.m(this.f59330a.getActivity(), this.f59332c, 5000);
    }

    public final void b() {
        this.f59333d = 0;
        this.f59332c = new TextView(this.f59330a.getActivity());
        this.f59332c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f59330a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f59332c.setPadding(this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f59332c.setGravity(3);
        } else {
            this.f59332c.setPadding(this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f59332c.setGravity(19);
        }
        this.f59332c.setTextSize(0, this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f59332c.setLineSpacing(this.f59330a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f59332c.setMaxLines(2);
        this.f59332c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f59331b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
