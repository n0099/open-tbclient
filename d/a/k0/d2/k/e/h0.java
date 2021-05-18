package d.a.k0.d2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f53090a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f53091b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53092c;

    /* renamed from: d  reason: collision with root package name */
    public int f53093d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.f53090a = fVar;
        this.f53091b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        if (this.f53091b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f53093d <= 0) {
            this.f53091b.setVisibility(0);
            this.f53093d++;
            this.f53092c.setText(str);
            SkinManager.setViewTextColor(this.f53092c, R.color.CAM_X0101);
            this.f53091b.removeAllViews();
            this.f53091b.addView(this.f53092c);
            this.f53091b.k(this.f53090a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f53091b.setVisibility(8);
    }

    public final void b() {
        this.f53092c = new TextView(this.f53090a.getPageActivity());
        this.f53092c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f53092c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
        this.f53092c.setPadding(this.f53090a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f53090a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
        this.f53092c.setGravity(19);
        this.f53092c.setTextSize(0, this.f53090a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.f53092c.setLineSpacing(this.f53090a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip = this.f53091b;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
    }
}
