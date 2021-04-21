package d.b.i0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f51365f;

    /* renamed from: a  reason: collision with root package name */
    public int f51366a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f51367b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51368c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51369d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f51370e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f51365f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f51365f == null) {
                    f51365f = new k();
                }
                kVar = f51365f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f51368c;
    }

    public int b() {
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f51367b = k;
        return k;
    }

    public int d() {
        int k = d.b.i0.r.d0.b.j().k("image_quality", 0);
        this.f51366a = k;
        return k;
    }

    public int e() {
        return this.f51370e;
    }

    public void f() {
        this.f51366a = d.b.i0.r.d0.b.j().k("image_quality", 0);
        d.b.i0.r.d0.b.j().k("new_abstract_state", 0);
        this.f51370e = d.b.i0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.b.i0.r.d0.b.j().g("show_images", true);
        this.f51369d = g2;
        if (g2) {
            return;
        }
        this.f51369d = true;
        d.b.i0.r.d0.b.j().C("show_images");
        d.b.i0.r.d0.b.j().v("view_image_quality", 0);
        this.f51370e = 0;
    }

    public boolean g() {
        return this.f51369d;
    }

    public void h(String str) {
        this.f51368c = str;
    }

    public void i(int i) {
        if (this.f51367b == i) {
            return;
        }
        this.f51367b = i;
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
    }

    public void j(boolean z) {
    }

    public void k(int i) {
        if (this.f51370e == i) {
            return;
        }
        this.f51370e = i;
        d.b.i0.r.d0.b.j().v("view_image_quality", i);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
