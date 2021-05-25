package d.a.n0.h1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.a.n0.t2.l;
import d.a.n0.t2.x;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55377a;

    /* renamed from: b  reason: collision with root package name */
    public String f55378b;

    /* renamed from: c  reason: collision with root package name */
    public String f55379c;

    /* renamed from: d  reason: collision with root package name */
    public int f55380d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f55381e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f55382f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55383g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f55384h;

    /* renamed from: i  reason: collision with root package name */
    public l f55385i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f55377a = false;
        this.f55383g = false;
        this.f55377a = z;
        this.f55383g = z2;
        this.f55382f = tbPageContext;
        this.f55378b = str;
        this.f55379c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f55382f == null || this.f55381e == null || !b(i2)) {
            return null;
        }
        l f2 = x.p().f(this.f55382f, this.f55381e.O3, 99, this.f55377a, this.f55378b, this.f55379c);
        this.f55385i = f2;
        if (f2 == null) {
            return null;
        }
        f2.a(this.f55384h);
        View b2 = this.f55385i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i2) {
        int i3;
        return d() && (i3 = this.f55380d) != 0 && i2 == i3;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f55381e;
        if (advertAppInfo != null) {
            return advertAppInfo.G3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f55383g || (advertAppInfo = this.f55381e) == null) {
            return false;
        }
        return advertAppInfo.G4() || this.f55381e.E4();
    }

    public void e() {
        l lVar = this.f55385i;
        if (lVar != null) {
            lVar.onAdShow();
        }
    }

    public void f() {
        l lVar = this.f55385i;
        if (lVar != null) {
            lVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f55384h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        this.f55381e = advertAppInfo;
        advertAppInfo.Q3 = "PIC_PAGE";
        this.f55380d = i2;
    }
}
