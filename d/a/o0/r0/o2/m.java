package d.a.o0.r0.o2;

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
    public FrsFragment f63146a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f63147b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63148c;

    /* renamed from: d  reason: collision with root package name */
    public int f63149d;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.f63146a = frsFragment;
        this.f63147b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        int i2;
        String str2;
        if (d.a.c.e.p.k.isEmpty(str) || this.f63147b == null || !this.f63146a.isPrimary() || (i2 = this.f63149d) > 0) {
            return;
        }
        this.f63149d = i2 + 1;
        if (str.length() < 20) {
            str2 = this.f63146a.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
        } else if (str.length() < 34) {
            str2 = this.f63146a.getResources().getString(R.string.forum_ueg_tip) + str;
        } else {
            str2 = this.f63146a.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
        }
        this.f63148c.setText(str2);
        SkinManager.setViewTextColor(this.f63148c, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.f63147b, R.color.cp_link_tip_a_alpha95);
        this.f63147b.m(this.f63146a.getActivity(), this.f63148c, 5000);
    }

    public final void b() {
        this.f63149d = 0;
        this.f63148c = new TextView(this.f63146a.getActivity());
        this.f63148c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f63146a.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f63148c.setPadding(this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds34), this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds1), this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f63148c.setGravity(3);
        } else {
            this.f63148c.setPadding(this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f63148c.setGravity(19);
        }
        this.f63148c.setTextSize(0, this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f63148c.setLineSpacing(this.f63146a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.f63148c.setMaxLines(2);
        this.f63148c.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f63147b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
