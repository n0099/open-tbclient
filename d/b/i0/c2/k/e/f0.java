package d.b.i0.c2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f f52678a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f52679b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52680c;

    /* renamed from: d  reason: collision with root package name */
    public int f52681d;

    public f0(d.b.b.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f52678a = fVar;
        this.f52679b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f52679b == null) {
            return;
        }
        if (!d.b.b.e.p.k.isEmpty(str) && this.f52681d <= 0) {
            this.f52679b.setVisibility(0);
            this.f52681d++;
            this.f52680c.setText(str);
            SkinManager.setViewTextColor(this.f52680c, R.color.CAM_X0101);
            this.f52679b.removeAllViews();
            this.f52679b.addView(this.f52680c);
            this.f52679b.k(this.f52678a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f52679b.setVisibility(8);
    }

    public final void b() {
        this.f52680c = new TextView(this.f52678a.getPageActivity());
        this.f52680c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f52680c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f52680c.setPadding(this.f52678a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f52678a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f52680c.setGravity(19);
        this.f52680c.setTextSize(0, this.f52678a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f52680c.setLineSpacing(this.f52678a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f52679b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
