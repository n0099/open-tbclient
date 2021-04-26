package d.a.j0.d2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f52391a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f52392b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52393c;

    /* renamed from: d  reason: collision with root package name */
    public int f52394d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f52391a = fVar;
        this.f52392b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f52392b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f52394d <= 0) {
            this.f52392b.setVisibility(0);
            this.f52394d++;
            this.f52393c.setText(str);
            SkinManager.setViewTextColor(this.f52393c, R.color.CAM_X0101);
            this.f52392b.removeAllViews();
            this.f52392b.addView(this.f52393c);
            this.f52392b.k(this.f52391a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f52392b.setVisibility(8);
    }

    public final void b() {
        this.f52393c = new TextView(this.f52391a.getPageActivity());
        this.f52393c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f52393c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f52393c.setPadding(this.f52391a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f52391a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f52393c.setGravity(19);
        this.f52393c.setTextSize(0, this.f52391a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f52393c.setLineSpacing(this.f52391a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f52392b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
