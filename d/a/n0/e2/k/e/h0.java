package d.a.n0.e2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f57035a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f57036b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57037c;

    /* renamed from: d  reason: collision with root package name */
    public int f57038d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f57035a = fVar;
        this.f57036b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f57036b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f57038d <= 0) {
            this.f57036b.setVisibility(0);
            this.f57038d++;
            this.f57037c.setText(str);
            SkinManager.setViewTextColor(this.f57037c, R.color.CAM_X0101);
            this.f57036b.removeAllViews();
            this.f57036b.addView(this.f57037c);
            this.f57036b.k(this.f57035a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f57036b.setVisibility(8);
    }

    public final void b() {
        this.f57037c = new TextView(this.f57035a.getPageActivity());
        this.f57037c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f57037c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f57037c.setPadding(this.f57035a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f57035a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f57037c.setGravity(19);
        this.f57037c.setTextSize(0, this.f57035a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f57037c.setLineSpacing(this.f57035a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f57036b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
