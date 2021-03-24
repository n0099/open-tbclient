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
    public d.b.b.a.f f52677a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f52678b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52679c;

    /* renamed from: d  reason: collision with root package name */
    public int f52680d;

    public f0(d.b.b.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f52677a = fVar;
        this.f52678b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f52678b == null) {
            return;
        }
        if (!d.b.b.e.p.k.isEmpty(str) && this.f52680d <= 0) {
            this.f52678b.setVisibility(0);
            this.f52680d++;
            this.f52679c.setText(str);
            SkinManager.setViewTextColor(this.f52679c, R.color.CAM_X0101);
            this.f52678b.removeAllViews();
            this.f52678b.addView(this.f52679c);
            this.f52678b.k(this.f52677a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f52678b.setVisibility(8);
    }

    public final void b() {
        this.f52679c = new TextView(this.f52677a.getPageActivity());
        this.f52679c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f52679c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f52679c.setPadding(this.f52677a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f52677a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f52679c.setGravity(19);
        this.f52679c.setTextSize(0, this.f52677a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f52679c.setLineSpacing(this.f52677a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f52678b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
