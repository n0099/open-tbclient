package d.a.j0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f49812f;

    /* renamed from: a  reason: collision with root package name */
    public int f49813a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f49814b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f49815c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49816d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f49817e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f49812f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f49812f == null) {
                    f49812f = new k();
                }
                kVar = f49812f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f49815c;
    }

    public int b() {
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f49814b = k;
        return k;
    }

    public int d() {
        int k = d.a.j0.r.d0.b.j().k("image_quality", 0);
        this.f49813a = k;
        return k;
    }

    public int e() {
        return this.f49817e;
    }

    public void f() {
        this.f49813a = d.a.j0.r.d0.b.j().k("image_quality", 0);
        d.a.j0.r.d0.b.j().k("new_abstract_state", 0);
        this.f49817e = d.a.j0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.a.j0.r.d0.b.j().g("show_images", true);
        this.f49816d = g2;
        if (g2) {
            return;
        }
        this.f49816d = true;
        d.a.j0.r.d0.b.j().C("show_images");
        d.a.j0.r.d0.b.j().v("view_image_quality", 0);
        this.f49817e = 0;
    }

    public boolean g() {
        return this.f49816d;
    }

    public void h(String str) {
        this.f49815c = str;
    }

    public void i(int i2) {
        if (this.f49814b == i2) {
            return;
        }
        this.f49814b = i2;
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
    }

    public void k(int i2) {
        if (this.f49817e == i2) {
            return;
        }
        this.f49817e = i2;
        d.a.j0.r.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
