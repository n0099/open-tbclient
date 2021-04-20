package d.b.i0.g1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.b.i0.s2.k;
import d.b.i0.s2.v;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56085a;

    /* renamed from: b  reason: collision with root package name */
    public String f56086b;

    /* renamed from: c  reason: collision with root package name */
    public String f56087c;

    /* renamed from: d  reason: collision with root package name */
    public int f56088d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f56089e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56090f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56091g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f56092h;
    public k i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f56085a = false;
        this.f56091g = false;
        this.f56085a = z;
        this.f56091g = z2;
        this.f56090f = tbPageContext;
        this.f56086b = str;
        this.f56087c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f56090f == null || this.f56089e == null || !b(i)) {
            return null;
        }
        k h2 = v.p().h(this.f56090f, this.f56089e.W3, 99, this.f56085a, this.f56086b, this.f56087c);
        this.i = h2;
        if (h2 == null) {
            return null;
        }
        h2.a(this.f56092h);
        View b2 = this.i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i) {
        int i2;
        return d() && (i2 = this.f56088d) != 0 && i == i2;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f56089e;
        if (advertAppInfo != null) {
            return advertAppInfo.E3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f56091g || (advertAppInfo = this.f56089e) == null) {
            return false;
        }
        return advertAppInfo.D4() || this.f56089e.B4();
    }

    public void e() {
        k kVar = this.i;
        if (kVar != null) {
            kVar.onAdShow();
        }
    }

    public void f() {
        k kVar = this.i;
        if (kVar != null) {
            kVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f56092h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i) {
        this.f56089e = advertAppInfo;
        advertAppInfo.c4 = "PIC_PAGE";
        this.f56088d = i;
    }
}
