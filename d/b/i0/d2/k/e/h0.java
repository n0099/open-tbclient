package d.b.i0.d2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f54163a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f54164b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54165c;

    /* renamed from: d  reason: collision with root package name */
    public int f54166d;

    public h0(d.b.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f54163a = fVar;
        this.f54164b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f54164b == null) {
            return;
        }
        if (!d.b.c.e.p.k.isEmpty(str) && this.f54166d <= 0) {
            this.f54164b.setVisibility(0);
            this.f54166d++;
            this.f54165c.setText(str);
            SkinManager.setViewTextColor(this.f54165c, R.color.CAM_X0101);
            this.f54164b.removeAllViews();
            this.f54164b.addView(this.f54165c);
            this.f54164b.k(this.f54163a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f54164b.setVisibility(8);
    }

    public final void b() {
        this.f54165c = new TextView(this.f54163a.getPageActivity());
        this.f54165c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f54165c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f54165c.setPadding(this.f54163a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f54163a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f54165c.setGravity(19);
        this.f54165c.setTextSize(0, this.f54163a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f54165c.setLineSpacing(this.f54163a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f54164b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
