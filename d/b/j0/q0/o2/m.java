package d.b.j0.q0.o2;

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
    public FrsFragment f60355a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f60356b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60357c;

    /* renamed from: d  reason: collision with root package name */
    public int f60358d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f60355a = frsFragment;
        this.f60356b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i;
        String str2;
        if (d.b.c.e.p.k.isEmpty(str) || this.f60356b == null || !this.f60355a.isPrimary() || (i = this.f60358d) > 0) {
            return;
        }
        this.f60358d = i + 1;
        if (str.length() < 20) {
            str2 = this.f60355a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f60355a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f60355a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f60357c.setText(str2);
        SkinManager.setViewTextColor(this.f60357c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f60356b, R.color.cp_link_tip_a_alpha95);
        this.f60356b.m(this.f60355a.getActivity(), this.f60357c, 5000);
    }

    public final void b() {
        this.f60358d = 0;
        this.f60357c = new TextView(this.f60355a.getActivity());
        this.f60357c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f60355a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f60357c.setPadding(this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f60357c.setGravity(3);
        } else {
            this.f60357c.setPadding(this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f60357c.setGravity(19);
        }
        this.f60357c.setTextSize(0, this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f60357c.setLineSpacing(this.f60355a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f60357c.setMaxLines(2);
        this.f60357c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f60356b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
