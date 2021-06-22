package d.a.o0.h1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import d.a.o0.t2.l;
import d.a.o0.t2.x;
/* loaded from: classes4.dex */
public class a implements ImagePagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f59191a;

    /* renamed from: b  reason: collision with root package name */
    public String f59192b;

    /* renamed from: c  reason: collision with root package name */
    public String f59193c;

    /* renamed from: d  reason: collision with root package name */
    public int f59194d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f59195e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f59196f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59197g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f59198h;

    /* renamed from: i  reason: collision with root package name */
    public l f59199i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f59191a = false;
        this.f59197g = false;
        this.f59191a = z;
        this.f59197g = z2;
        this.f59196f = tbPageContext;
        this.f59192b = str;
        this.f59193c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f59196f == null || this.f59195e == null || !b(i2)) {
            return null;
        }
        l f2 = x.p().f(this.f59196f, this.f59195e.R3, 99, this.f59191a, this.f59192b, this.f59193c);
        this.f59199i = f2;
        if (f2 == null) {
            return null;
        }
        f2.a(this.f59198h);
        View b2 = this.f59199i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i2) {
        int i3;
        return d() && (i3 = this.f59194d) != 0 && i2 == i3;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f59195e;
        if (advertAppInfo != null) {
            return advertAppInfo.J3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f59197g || (advertAppInfo = this.f59195e) == null) {
            return false;
        }
        return advertAppInfo.H4() || this.f59195e.F4();
    }

    public void e() {
        l lVar = this.f59199i;
        if (lVar != null) {
            lVar.onAdShow();
        }
    }

    public void f() {
        l lVar = this.f59199i;
        if (lVar != null) {
            lVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f59198h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        this.f59195e = advertAppInfo;
        advertAppInfo.T3 = "PIC_PAGE";
        this.f59194d = i2;
    }
}
