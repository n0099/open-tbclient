package d.a.m0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f53532f;

    /* renamed from: a  reason: collision with root package name */
    public int f53533a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f53534b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f53535c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53536d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f53537e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f53532f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f53532f == null) {
                    f53532f = new k();
                }
                kVar = f53532f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f53535c;
    }

    public int b() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f53534b = k;
        return k;
    }

    public int d() {
        int k = d.a.m0.r.d0.b.j().k("image_quality", 0);
        this.f53533a = k;
        return k;
    }

    public int e() {
        return this.f53537e;
    }

    public void f() {
        this.f53533a = d.a.m0.r.d0.b.j().k("image_quality", 0);
        d.a.m0.r.d0.b.j().k("new_abstract_state", 0);
        this.f53537e = d.a.m0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.a.m0.r.d0.b.j().g("show_images", true);
        this.f53536d = g2;
        if (g2) {
            return;
        }
        this.f53536d = true;
        d.a.m0.r.d0.b.j().C("show_images");
        d.a.m0.r.d0.b.j().v("view_image_quality", 0);
        this.f53537e = 0;
    }

    public boolean g() {
        return this.f53536d;
    }

    public void h(String str) {
        this.f53535c = str;
    }

    public void i(int i2) {
        if (this.f53534b == i2) {
            return;
        }
        this.f53534b = i2;
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
    }

    public void k(int i2) {
        if (this.f53537e == i2) {
            return;
        }
        this.f53537e = i2;
        d.a.m0.r.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
