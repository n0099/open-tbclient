package d.a.k0.g1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.a.k0.s2.l;
import d.a.k0.s2.x;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55103a;

    /* renamed from: b  reason: collision with root package name */
    public String f55104b;

    /* renamed from: c  reason: collision with root package name */
    public String f55105c;

    /* renamed from: d  reason: collision with root package name */
    public int f55106d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f55107e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f55108f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55109g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f55110h;

    /* renamed from: i  reason: collision with root package name */
    public l f55111i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f55103a = false;
        this.f55109g = false;
        this.f55103a = z;
        this.f55109g = z2;
        this.f55108f = tbPageContext;
        this.f55104b = str;
        this.f55105c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f55108f == null || this.f55107e == null || !b(i2)) {
            return null;
        }
        l f2 = x.p().f(this.f55108f, this.f55107e.N3, 99, this.f55103a, this.f55104b, this.f55105c);
        this.f55111i = f2;
        if (f2 == null) {
            return null;
        }
        f2.a(this.f55110h);
        View b2 = this.f55111i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i2) {
        int i3;
        return d() && (i3 = this.f55106d) != 0 && i2 == i3;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f55107e;
        if (advertAppInfo != null) {
            return advertAppInfo.F3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f55109g || (advertAppInfo = this.f55107e) == null) {
            return false;
        }
        return advertAppInfo.F4() || this.f55107e.D4();
    }

    public void e() {
        l lVar = this.f55111i;
        if (lVar != null) {
            lVar.onAdShow();
        }
    }

    public void f() {
        l lVar = this.f55111i;
        if (lVar != null) {
            lVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f55110h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        this.f55107e = advertAppInfo;
        advertAppInfo.P3 = "PIC_PAGE";
        this.f55106d = i2;
    }
}
