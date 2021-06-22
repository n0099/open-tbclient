package d.a.n0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f53639f;

    /* renamed from: a  reason: collision with root package name */
    public int f53640a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f53641b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f53642c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53643d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f53644e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f53639f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f53639f == null) {
                    f53639f = new k();
                }
                kVar = f53639f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f53642c;
    }

    public int b() {
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f53641b = k;
        return k;
    }

    public int d() {
        int k = d.a.n0.r.d0.b.j().k("image_quality", 0);
        this.f53640a = k;
        return k;
    }

    public int e() {
        return this.f53644e;
    }

    public void f() {
        this.f53640a = d.a.n0.r.d0.b.j().k("image_quality", 0);
        d.a.n0.r.d0.b.j().k("new_abstract_state", 0);
        this.f53644e = d.a.n0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.a.n0.r.d0.b.j().g("show_images", true);
        this.f53643d = g2;
        if (g2) {
            return;
        }
        this.f53643d = true;
        d.a.n0.r.d0.b.j().C("show_images");
        d.a.n0.r.d0.b.j().v("view_image_quality", 0);
        this.f53644e = 0;
    }

    public boolean g() {
        return this.f53643d;
    }

    public void h(String str) {
        this.f53642c = str;
    }

    public void i(int i2) {
        if (this.f53641b == i2) {
            return;
        }
        this.f53641b = i2;
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i2);
    }

    public void j(boolean z) {
    }

    public void k(int i2) {
        if (this.f53644e == i2) {
            return;
        }
        this.f53644e = i2;
        d.a.n0.r.d0.b.j().v("view_image_quality", i2);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
