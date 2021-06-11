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
    public boolean f59066a;

    /* renamed from: b  reason: collision with root package name */
    public String f59067b;

    /* renamed from: c  reason: collision with root package name */
    public String f59068c;

    /* renamed from: d  reason: collision with root package name */
    public int f59069d = 0;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f59070e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f59071f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59072g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f59073h;

    /* renamed from: i  reason: collision with root package name */
    public l f59074i;

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.f59066a = false;
        this.f59072g = false;
        this.f59066a = z;
        this.f59072g = z2;
        this.f59071f = tbPageContext;
        this.f59067b = str;
        this.f59068c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f59071f == null || this.f59070e == null || !b(i2)) {
            return null;
        }
        l f2 = x.p().f(this.f59071f, this.f59070e.R3, 99, this.f59066a, this.f59067b, this.f59068c);
        this.f59074i = f2;
        if (f2 == null) {
            return null;
        }
        f2.a(this.f59073h);
        View b2 = this.f59074i.b();
        viewGroup.addView(b2);
        return b2;
    }

    public final boolean b(int i2) {
        int i3;
        return d() && (i3 = this.f59069d) != 0 && i2 == i3;
    }

    public String c() {
        AdvertAppInfo advertAppInfo = this.f59070e;
        if (advertAppInfo != null) {
            return advertAppInfo.J3;
        }
        return null;
    }

    public boolean d() {
        AdvertAppInfo advertAppInfo;
        if (!this.f59072g || (advertAppInfo = this.f59070e) == null) {
            return false;
        }
        return advertAppInfo.H4() || this.f59070e.F4();
    }

    public void e() {
        l lVar = this.f59074i;
        if (lVar != null) {
            lVar.onAdShow();
        }
    }

    public void f() {
        l lVar = this.f59074i;
        if (lVar != null) {
            lVar.onDestroy();
        }
    }

    public void g(DragImageView.h hVar) {
        this.f59073h = hVar;
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        this.f59070e = advertAppInfo;
        advertAppInfo.T3 = "PIC_PAGE";
        this.f59069d = i2;
    }
}
