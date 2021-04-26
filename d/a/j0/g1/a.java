package d.a.j0.g1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.a.j0.s2.k;
import d.a.j0.s2.w;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54396a;

    /* renamed from: b  reason: collision with root package name */
    public String f54397b;

    /* renamed from: c  reason: collision with root package name */
    public String f54398c;

    /* renamed from: d  reason: collision with root package name */
    public int f54399d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f54400e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f54401f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54402g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f54403h;

    /* renamed from: i  reason: collision with root package name */
    public k f54404i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f54396a = false;
        this.f54402g = false;
        this.f54396a = z;
        this.f54402g = z2;
        this.f54401f = tbPageContext;
        this.f54397b = str;
        this.f54398c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f54401f == null || this.f54400e == null || !b(i2)) {
            return null;
        }
        k f2 = w.p().f(this.f54401f, this.f54400e.W3, 99, this.f54396a, this.f54397b, this.f54398c);
        this.f54404i = f2;
        if (f2 == null) {
            return null;
        }
        f2.a(this.f54403h);
        View b2 = this.f54404i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i2) {
        int i3;
        return d() && (i3 = this.f54399d) != 0 && i2 == i3;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f54400e;
        if (advertAppInfo != null) {
            return advertAppInfo.E3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f54402g || (advertAppInfo = this.f54400e) == null) {
            return false;
        }
        return advertAppInfo.D4() || this.f54400e.B4();
    }

    public void e() {
        k kVar = this.f54404i;
        if (kVar != null) {
            kVar.onAdShow();
        }
    }

    public void f() {
        k kVar = this.f54404i;
        if (kVar != null) {
            kVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f54403h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        this.f54400e = advertAppInfo;
        advertAppInfo.c4 = "PIC_PAGE";
        this.f54399d = i2;
    }
}
