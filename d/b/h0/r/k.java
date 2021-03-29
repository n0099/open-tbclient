package d.b.h0.r;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbImageHelper;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static k f50622f;

    /* renamed from: a  reason: collision with root package name */
    public int f50623a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f50624b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f50625c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50626d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f50627e = 0;

    public static k c() {
        k kVar;
        k kVar2 = f50622f;
        if (kVar2 == null) {
            synchronized (k.class) {
                if (f50622f == null) {
                    f50622f = new k();
                }
                kVar = f50622f;
            }
            return kVar;
        }
        return kVar2;
    }

    public String a() {
        return this.f50625c;
    }

    public int b() {
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        int j = i.j(TbadkCoreApplication.getCurrentAccount() + "add_image_water", 2);
        this.f50624b = j;
        return j;
    }

    public int d() {
        int j = d.b.h0.r.d0.b.i().j("image_quality", 0);
        this.f50623a = j;
        return j;
    }

    public int e() {
        return this.f50627e;
    }

    public void f() {
        this.f50623a = d.b.h0.r.d0.b.i().j("image_quality", 0);
        d.b.h0.r.d0.b.i().j("new_abstract_state", 0);
        this.f50627e = d.b.h0.r.d0.b.i().j("view_image_quality", 0);
        boolean g2 = d.b.h0.r.d0.b.i().g("show_images", true);
        this.f50626d = g2;
        if (g2) {
            return;
        }
        this.f50626d = true;
        d.b.h0.r.d0.b.i().B("show_images");
        d.b.h0.r.d0.b.i().u("view_image_quality", 0);
        this.f50627e = 0;
    }

    public boolean g() {
        return this.f50626d;
    }

    public void h(String str) {
        this.f50625c = str;
    }

    public void i(int i) {
        if (this.f50624b == i) {
            return;
        }
        this.f50624b = i;
        d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
        i2.u(TbadkCoreApplication.getCurrentAccount() + "add_image_water", i);
    }

    public void j(boolean z) {
    }

    public void k(int i) {
        if (this.f50627e == i) {
            return;
        }
        this.f50627e = i;
        d.b.h0.r.d0.b.i().u("view_image_quality", i);
        TbImageHelper.getInstance().updateFrsShowBigImage();
        TbImageHelper.getInstance().updateUrlQuality();
    }
}
