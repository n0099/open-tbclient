package d.b.h0.m0.o;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import d.b.b.e.p.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f50357a;

    /* renamed from: b  reason: collision with root package name */
    public String f50358b;

    public a(String str) {
        this.f50358b = str;
    }

    public final void a(String str, int i) {
        int intValue;
        if (k.isEmpty(str) || i <= 0 || TbSingleton.getInstance().isAnimFpsComputed(str) || (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) >= 5) {
            return;
        }
        int i2 = intValue + 1;
        int intValue2 = TbSingleton.getInstance().getAnimAvgFps(str).intValue();
        if (intValue2 > 0) {
            i = (i + (intValue2 * (i2 - 1))) / i2;
        }
        TbSingleton.getInstance().setAnimAvgFps(str, i);
        TbSingleton.getInstance().setAnimAvgFpsCount(str, i2);
        if (i2 >= 5) {
            TbSingleton.getInstance().setAnimComputedFps(str, i);
            b.a();
        }
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f50357a == null) {
                this.f50357a = new c();
            }
            this.f50357a.c();
        }
    }

    public void c() {
        c cVar = this.f50357a;
        if (cVar != null && Build.VERSION.SDK_INT >= 16) {
            cVar.d();
            a(this.f50358b, this.f50357a.b());
        }
    }
}
