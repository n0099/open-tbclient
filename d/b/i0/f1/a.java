package d.b.i0.f1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.b.i0.r2.s;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54621a;

    /* renamed from: b  reason: collision with root package name */
    public String f54622b;

    /* renamed from: c  reason: collision with root package name */
    public String f54623c;

    /* renamed from: d  reason: collision with root package name */
    public int f54624d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f54625e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f54626f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54627g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f54628h;
    public d.b.i0.r2.i i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f54621a = false;
        this.f54627g = false;
        this.f54621a = z;
        this.f54627g = z2;
        this.f54626f = tbPageContext;
        this.f54622b = str;
        this.f54623c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f54626f == null || this.f54625e == null || !b(i)) {
            return null;
        }
        d.b.i0.r2.i g2 = s.o().g(this.f54626f, this.f54625e.W3, 99, this.f54621a, this.f54622b, this.f54623c);
        this.i = g2;
        if (g2 == null) {
            return null;
        }
        g2.a(this.f54628h);
        View b2 = this.i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i) {
        int i2;
        return d() && (i2 = this.f54624d) != 0 && i == i2;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f54625e;
        if (advertAppInfo != null) {
            return advertAppInfo.E3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f54627g || (advertAppInfo = this.f54625e) == null) {
            return false;
        }
        return advertAppInfo.C4() || this.f54625e.A4();
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
        this.f54628h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i) {
        this.f54625e = advertAppInfo;
        advertAppInfo.c4 = "PIC_PAGE";
        this.f54624d = i;
    }
}
