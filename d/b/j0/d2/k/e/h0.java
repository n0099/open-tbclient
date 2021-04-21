package d.b.j0.d2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f f54584a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f54585b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54586c;

    /* renamed from: d  reason: collision with root package name */
    public int f54587d;

    public h0(d.b.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f54584a = fVar;
        this.f54585b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f54585b == null) {
            return;
        }
        if (!d.b.c.e.p.k.isEmpty(str) && this.f54587d <= 0) {
            this.f54585b.setVisibility(0);
            this.f54587d++;
            this.f54586c.setText(str);
            SkinManager.setViewTextColor(this.f54586c, R.color.CAM_X0101);
            this.f54585b.removeAllViews();
            this.f54585b.addView(this.f54586c);
            this.f54585b.k(this.f54584a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f54585b.setVisibility(8);
    }

    public final void b() {
        this.f54586c = new TextView(this.f54584a.getPageActivity());
        this.f54586c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f54586c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f54586c.setPadding(this.f54584a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f54584a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f54586c.setGravity(19);
        this.f54586c.setTextSize(0, this.f54584a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f54586c.setLineSpacing(this.f54584a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f54585b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
