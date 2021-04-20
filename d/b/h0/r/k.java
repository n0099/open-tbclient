package d.b.h0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f51029f;

    /* renamed from: a  reason: collision with root package name */
    public int f51030a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f51031b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51032c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51033d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f51034e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f51029f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f51029f == null) {
                    f51029f = new k();
                }
                kVar = f51029f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f51032c;
    }

    public int b() {
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        int k = j.k(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f51031b = k;
        return k;
    }

    public int d() {
        int k = d.b.h0.r.d0.b.j().k("image_quality", 0);
        this.f51030a = k;
        return k;
    }

    public int e() {
        return this.f51034e;
    }

    public void f() {
        this.f51030a = d.b.h0.r.d0.b.j().k("image_quality", 0);
        d.b.h0.r.d0.b.j().k("new_abstract_state", 0);
        this.f51034e = d.b.h0.r.d0.b.j().k("view_image_quality", 0);
        boolean g2 = d.b.h0.r.d0.b.j().g("show_images", true);
        this.f51033d = g2;
        if (g2) {
            return;
        }
        this.f51033d = true;
        d.b.h0.r.d0.b.j().C("show_images");
        d.b.h0.r.d0.b.j().v("view_image_quality", 0);
        this.f51034e = 0;
    }

    public boolean g() {
        return this.f51033d;
    }

    public void h(String str) {
        this.f51032c = str;
    }

    public void i(int i) {
        if (this.f51031b == i) {
            return;
        }
        this.f51031b = i;
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        j.v(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
    }

    public void j(boolean z) {
    }

    public void k(int i) {
        if (this.f51034e == i) {
            return;
        }
        this.f51034e = i;
        d.b.h0.r.d0.b.j().v("view_image_quality", i);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
