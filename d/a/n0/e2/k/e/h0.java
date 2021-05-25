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
    public d.a.c.a.f f53346a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f53347b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53348c;

    /* renamed from: d  reason: collision with root package name */
    public int f53349d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f53346a = fVar;
        this.f53347b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f53347b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f53349d <= 0) {
            this.f53347b.setVisibility(0);
            this.f53349d++;
            this.f53348c.setText(str);
            SkinManager.setViewTextColor(this.f53348c, R.color.CAM_X0101);
            this.f53347b.removeAllViews();
            this.f53347b.addView(this.f53348c);
            this.f53347b.k(this.f53346a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f53347b.setVisibility(8);
    }

    public final void b() {
        this.f53348c = new TextView(this.f53346a.getPageActivity());
        this.f53348c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f53348c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f53348c.setPadding(this.f53346a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f53346a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f53348c.setGravity(19);
        this.f53348c.setTextSize(0, this.f53346a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f53348c.setLineSpacing(this.f53346a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f53347b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
