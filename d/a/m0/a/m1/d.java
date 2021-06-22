package d.a.m0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.a.m0.a.a2.e.y;

    /* renamed from: a  reason: collision with root package name */
    public String f47243a;

    /* renamed from: b  reason: collision with root package name */
    public String f47244b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47245c;

    /* renamed from: f  reason: collision with root package name */
    public long f47248f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f47250h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47251i;

    /* renamed from: g  reason: collision with root package name */
    public int f47249g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f47247e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f47246d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f47243a = str;
        this.f47244b = str2;
        this.f47248f = j2;
        this.f47251i = z;
    }

    public void a() {
        this.f47246d = 2;
    }

    public long b() {
        long j2 = this.f47248f;
        if (j2 > 0) {
            this.f47248f = j2 - (System.currentTimeMillis() - this.f47247e);
        }
        return this.f47248f;
    }

    public boolean c() {
        return this.f47246d == 2;
    }

    public void d() {
        long j2 = this.f47248f;
        if (j2 > 0) {
            this.f47248f = j2 - (System.currentTimeMillis() - this.f47247e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f47248f + "ms");
            }
        }
    }

    public void e() {
        this.f47247e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f47246d = 1;
    }
}
