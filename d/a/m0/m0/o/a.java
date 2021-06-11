package d.a.m0.m0.o;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import d.a.c.e.p.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f53251a;

    /* renamed from: b  reason: collision with root package name */
    public String f53252b;

    public a(String str) {
        this.f53252b = str;
    }

    public final void a(String str, int i2) {
        int intValue;
        if (k.isEmpty(str) || i2 <= 0 || TbSingleton.getInstance().isAnimFpsComputed(str) || (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) >= 5) {
            return;
        }
        int i3 = intValue + 1;
        int intValue2 = TbSingleton.getInstance().getAnimAvgFps(str).intValue();
        if (intValue2 > 0) {
            i2 = (i2 + (intValue2 * (i3 - 1))) / i3;
        }
        TbSingleton.getInstance().setAnimAvgFps(str, i2);
        TbSingleton.getInstance().setAnimAvgFpsCount(str, i3);
        if (i3 >= 5) {
            TbSingleton.getInstance().setAnimComputedFps(str, i2);
            b.a();
        }
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f53251a == null) {
                this.f53251a = new c();
            }
            this.f53251a.c();
        }
    }

    public void c() {
        c cVar = this.f53251a;
        if (cVar != null && Build.VERSION.SDK_INT >= 16) {
            cVar.d();
            a(this.f53252b, this.f53251a.b());
        }
    }
}
