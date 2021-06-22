package d.a.o0.e2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f57160a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f57161b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57162c;

    /* renamed from: d  reason: collision with root package name */
    public int f57163d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f57160a = fVar;
        this.f57161b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f57161b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f57163d <= 0) {
            this.f57161b.setVisibility(0);
            this.f57163d++;
            this.f57162c.setText(str);
            SkinManager.setViewTextColor(this.f57162c, R.color.CAM_X0101);
            this.f57161b.removeAllViews();
            this.f57161b.addView(this.f57162c);
            this.f57161b.k(this.f57160a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f57161b.setVisibility(8);
    }

    public final void b() {
        this.f57162c = new TextView(this.f57160a.getPageActivity());
        this.f57162c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f57162c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f57162c.setPadding(this.f57160a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f57160a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f57162c.setGravity(19);
        this.f57162c.setTextSize(0, this.f57160a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f57162c.setLineSpacing(this.f57160a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f57161b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
