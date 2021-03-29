package d.b.i0.f1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.b.i0.r2.s;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54622a;

    /* renamed from: b  reason: collision with root package name */
    public String f54623b;

    /* renamed from: c  reason: collision with root package name */
    public String f54624c;

    /* renamed from: d  reason: collision with root package name */
    public int f54625d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f54626e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f54627f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54628g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f54629h;
    public d.b.i0.r2.i i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f54622a = false;
        this.f54628g = false;
        this.f54622a = z;
        this.f54628g = z2;
        this.f54627f = tbPageContext;
        this.f54623b = str;
        this.f54624c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f54627f == null || this.f54626e == null || !b(i)) {
            return null;
        }
        d.b.i0.r2.i g2 = s.o().g(this.f54627f, this.f54626e.W3, 99, this.f54622a, this.f54623b, this.f54624c);
        this.i = g2;
        if (g2 == null) {
            return null;
        }
        g2.a(this.f54629h);
        View b2 = this.i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i) {
        int i2;
        return d() && (i2 = this.f54625d) != 0 && i == i2;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f54626e;
        if (advertAppInfo != null) {
            return advertAppInfo.E3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f54628g || (advertAppInfo = this.f54626e) == null) {
            return false;
        }
        return advertAppInfo.C4() || this.f54626e.A4();
    }

    public void e() {
        d.b.i0.r2.i iVar = this.i;
        if (iVar != null) {
            iVar.onAdShow();
        }
    }

    public void f() {
        d.b.i0.r2.i iVar = this.i;
        if (iVar != null) {
            iVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f54629h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i) {
        this.f54626e = advertAppInfo;
        advertAppInfo.c4 = "PIC_PAGE";
        this.f54625d = i;
    }
}
