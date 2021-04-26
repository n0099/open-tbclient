package d.a.i0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f48982f;

    /* renamed from: a  reason: collision with root package name */
    public int f48983a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f48984b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f48985c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48986d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f48987e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f48982f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f48982f == null) {
                    f48982f = new k();
                }
                kVar = f48982f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f48985c;
    }

    public int b() {
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f48984b = k;
        return k;
    }

    public int d() {
        int k = d.a.i0.r.d0.b.j().k("image_quality", 0);
        this.f48983a = k;
        return k;
    }

    public int e() {
        return this.f48987e;
    }

    public void f() {
        this.f48983a = d.a.i0.r.d0.b.j().k("image_quality", 0);
        d.a.i0.r.d0.b.j().k("new_abstract_state", 0);
        this.f48987e = d.a.i0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.a.i0.r.d0.b.j().g("show_images", true);
        this.f48986d = g2;
        if (g2) {
            return;
        }
        this.f48986d = true;
        d.a.i0.r.d0.b.j().C("show_images");
        d.a.i0.r.d0.b.j().v("view_image_quality", 0);
        this.f48987e = 0;
    }

    public boolean g() {
        return this.f48986d;
    }

    public void h(String str) {
        this.f48985c = str;
    }

    public void i(int i2) {
        if (this.f48984b == i2) {
            return;
        }
        this.f48984b = i2;
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
    }

    public void k(int i2) {
        if (this.f48987e == i2) {
            return;
        }
        this.f48987e = i2;
        d.a.i0.r.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
