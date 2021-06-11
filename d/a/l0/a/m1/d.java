package d.a.l0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.a.l0.a.a2.e.y;

    /* renamed from: a  reason: collision with root package name */
    public String f47135a;

    /* renamed from: b  reason: collision with root package name */
    public String f47136b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47137c;

    /* renamed from: f  reason: collision with root package name */
    public long f47140f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f47142h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47143i;

    /* renamed from: g  reason: collision with root package name */
    public int f47141g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f47139e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f47138d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f47135a = str;
        this.f47136b = str2;
        this.f47140f = j2;
        this.f47143i = z;
    }

    public void a() {
        this.f47138d = 2;
    }

    public long b() {
        long j2 = this.f47140f;
        if (j2 > 0) {
            this.f47140f = j2 - (System.currentTimeMillis() - this.f47139e);
        }
        return this.f47140f;
    }

    public boolean c() {
        return this.f47138d == 2;
    }

    public void d() {
        long j2 = this.f47140f;
        if (j2 > 0) {
            this.f47140f = j2 - (System.currentTimeMillis() - this.f47139e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f47140f + "ms");
            }
        }
    }

    public void e() {
        this.f47139e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f47138d = 1;
    }
}
