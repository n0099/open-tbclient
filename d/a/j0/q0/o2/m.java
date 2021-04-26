package d.a.j0.q0.o2;

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
    public FrsFragment f58447a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f58448b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58449c;

    /* renamed from: d  reason: collision with root package name */
    public int f58450d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f58447a = frsFragment;
        this.f58448b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        if (d.a.c.e.p.k.isEmpty(str) || this.f58448b == null || !this.f58447a.isPrimary() || (i2 = this.f58450d) > 0) {
            return;
        }
        this.f58450d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.f58447a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f58447a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f58447a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f58449c.setText(str2);
        SkinManager.setViewTextColor(this.f58449c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f58448b, R.color.cp_link_tip_a_alpha95);
        this.f58448b.m(this.f58447a.getActivity(), this.f58449c, 5000);
    }

    public final void b() {
        this.f58450d = 0;
        this.f58449c = new TextView(this.f58447a.getActivity());
        this.f58449c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f58447a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f58449c.setPadding(this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f58449c.setGravity(3);
        } else {
            this.f58449c.setPadding(this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f58449c.setGravity(19);
        }
        this.f58449c.setTextSize(0, this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f58449c.setLineSpacing(this.f58447a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f58449c.setMaxLines(2);
        this.f58449c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f58448b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
