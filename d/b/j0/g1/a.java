package d.b.j0.g1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.b.j0.s2.k;
import d.b.j0.s2.v;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56506a;

    /* renamed from: b  reason: collision with root package name */
    public String f56507b;

    /* renamed from: c  reason: collision with root package name */
    public String f56508c;

    /* renamed from: d  reason: collision with root package name */
    public int f56509d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f56510e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f56511f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56512g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f56513h;
    public k i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f56506a = false;
        this.f56512g = false;
        this.f56506a = z;
        this.f56512g = z2;
        this.f56511f = tbPageContext;
        this.f56507b = str;
        this.f56508c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f56511f == null || this.f56510e == null || !b(i)) {
            return null;
        }
        k h2 = v.p().h(this.f56511f, this.f56510e.W3, 99, this.f56506a, this.f56507b, this.f56508c);
        this.i = h2;
        if (h2 == null) {
            return null;
        }
        h2.a(this.f56513h);
        View b2 = this.i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i) {
        int i2;
        return d() && (i2 = this.f56509d) != 0 && i == i2;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f56510e;
        if (advertAppInfo != null) {
            return advertAppInfo.E3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f56512g || (advertAppInfo = this.f56510e) == null) {
            return false;
        }
        return advertAppInfo.D4() || this.f56510e.B4();
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
        this.f56513h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i) {
        this.f56510e = advertAppInfo;
        advertAppInfo.c4 = "PIC_PAGE";
        this.f56509d = i;
    }
}
