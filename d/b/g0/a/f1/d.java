package d.b.g0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.b.g0.a.r1.e.x;

    /* renamed from: a  reason: collision with root package name */
    public String f44417a;

    /* renamed from: b  reason: collision with root package name */
    public String f44418b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44419c;

    /* renamed from: f  reason: collision with root package name */
    public long f44422f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f44424h;
    public boolean i;

    /* renamed from: g  reason: collision with root package name */
    public int f44423g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f44421e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f44420d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f44417a = str;
        this.f44418b = str2;
        this.f44422f = j2;
        this.i = z;
    }

    public void a() {
        this.f44420d = 2;
    }

    public long b() {
        long j2 = this.f44422f;
        if (j2 > 0) {
            this.f44422f = j2 - (System.currentTimeMillis() - this.f44421e);
        }
        return this.f44422f;
    }

    public boolean c() {
        return this.f44420d == 2;
    }

    public void d() {
        long j2 = this.f44422f;
        if (j2 > 0) {
            this.f44422f = j2 - (System.currentTimeMillis() - this.f44421e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f44422f + "ms");
            }
        }
    }

    public void e() {
        this.f44421e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f44420d = 1;
    }
}
