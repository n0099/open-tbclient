package d.b.i0.p0.n2;

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
    public FrsFragment f58238a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f58239b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58240c;

    /* renamed from: d  reason: collision with root package name */
    public int f58241d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f58238a = frsFragment;
        this.f58239b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i;
        String str2;
        if (d.b.b.e.p.k.isEmpty(str) || this.f58239b == null || !this.f58238a.isPrimary() || (i = this.f58241d) > 0) {
            return;
        }
        this.f58241d = i + 1;
        if (str.length() < 20) {
            str2 = this.f58238a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f58238a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f58238a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f58240c.setText(str2);
        SkinManager.setViewTextColor(this.f58240c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f58239b, R.color.cp_link_tip_a_alpha95);
        this.f58239b.m(this.f58238a.getActivity(), this.f58240c, 5000);
    }

    public final void b() {
        this.f58241d = 0;
        this.f58240c = new TextView(this.f58238a.getActivity());
        this.f58240c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f58238a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f58240c.setPadding(this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f58240c.setGravity(3);
        } else {
            this.f58240c.setPadding(this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f58240c.setGravity(19);
        }
        this.f58240c.setTextSize(0, this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f58240c.setLineSpacing(this.f58238a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f58240c.setMaxLines(2);
        this.f58240c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f58239b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
