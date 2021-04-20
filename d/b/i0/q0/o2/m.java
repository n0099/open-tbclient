package d.b.i0.q0.o2;

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
    public FrsFragment f59934a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f59935b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59936c;

    /* renamed from: d  reason: collision with root package name */
    public int f59937d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f59934a = frsFragment;
        this.f59935b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i;
        String str2;
        if (d.b.c.e.p.k.isEmpty(str) || this.f59935b == null || !this.f59934a.isPrimary() || (i = this.f59937d) > 0) {
            return;
        }
        this.f59937d = i + 1;
        if (str.length() < 20) {
            str2 = this.f59934a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f59934a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f59934a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f59936c.setText(str2);
        SkinManager.setViewTextColor(this.f59936c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f59935b, R.color.cp_link_tip_a_alpha95);
        this.f59935b.m(this.f59934a.getActivity(), this.f59936c, 5000);
    }

    public final void b() {
        this.f59937d = 0;
        this.f59936c = new TextView(this.f59934a.getActivity());
        this.f59936c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f59934a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f59936c.setPadding(this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f59936c.setGravity(3);
        } else {
            this.f59936c.setPadding(this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f59936c.setGravity(19);
        }
        this.f59936c.setTextSize(0, this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f59936c.setLineSpacing(this.f59934a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f59936c.setMaxLines(2);
        this.f59936c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f59935b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
