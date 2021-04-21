package d.b.h0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class d {
    public static final boolean j = d.b.h0.a.r1.e.x;

    /* renamed from: a  reason: collision with root package name */
    public String f45139a;

    /* renamed from: b  reason: collision with root package name */
    public String f45140b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45141c;

    /* renamed from: f  reason: collision with root package name */
    public long f45144f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f45146h;
    public boolean i;

    /* renamed from: g  reason: collision with root package name */
    public int f45145g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f45143e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f45142d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f45139a = str;
        this.f45140b = str2;
        this.f45144f = j2;
        this.i = z;
    }

    public void a() {
        this.f45142d = 2;
    }

    public long b() {
        long j2 = this.f45144f;
        if (j2 > 0) {
            this.f45144f = j2 - (System.currentTimeMillis() - this.f45143e);
        }
        return this.f45144f;
    }

    public boolean c() {
        return this.f45142d == 2;
    }

    public void d() {
        long j2 = this.f45144f;
        if (j2 > 0) {
            this.f45144f = j2 - (System.currentTimeMillis() - this.f45143e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f45144f + "ms");
            }
        }
    }

    public void e() {
        this.f45143e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f45142d = 1;
    }
}
