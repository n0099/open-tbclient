package d.a.h0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.a.h0.a.r1.e.x;

    /* renamed from: a  reason: collision with root package name */
    public String f42449a;

    /* renamed from: b  reason: collision with root package name */
    public String f42450b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42451c;

    /* renamed from: f  reason: collision with root package name */
    public long f42454f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f42456h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42457i;

    /* renamed from: g  reason: collision with root package name */
    public int f42455g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f42453e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f42452d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f42449a = str;
        this.f42450b = str2;
        this.f42454f = j2;
        this.f42457i = z;
    }

    public void a() {
        this.f42452d = 2;
    }

    public long b() {
        long j2 = this.f42454f;
        if (j2 > 0) {
            this.f42454f = j2 - (System.currentTimeMillis() - this.f42453e);
        }
        return this.f42454f;
    }

    public boolean c() {
        return this.f42452d == 2;
    }

    public void d() {
        long j2 = this.f42454f;
        if (j2 > 0) {
            this.f42454f = j2 - (System.currentTimeMillis() - this.f42453e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f42454f + "ms");
            }
        }
    }

    public void e() {
        this.f42453e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f42452d = 1;
    }
}
