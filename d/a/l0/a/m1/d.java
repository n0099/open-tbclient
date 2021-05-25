package d.a.l0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.a.l0.a.a2.e.y;

    /* renamed from: a  reason: collision with root package name */
    public String f43459a;

    /* renamed from: b  reason: collision with root package name */
    public String f43460b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43461c;

    /* renamed from: f  reason: collision with root package name */
    public long f43464f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f43466h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43467i;

    /* renamed from: g  reason: collision with root package name */
    public int f43465g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f43463e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f43462d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f43459a = str;
        this.f43460b = str2;
        this.f43464f = j2;
        this.f43467i = z;
    }

    public void a() {
        this.f43462d = 2;
    }

    public long b() {
        long j2 = this.f43464f;
        if (j2 > 0) {
            this.f43464f = j2 - (System.currentTimeMillis() - this.f43463e);
        }
        return this.f43464f;
    }

    public boolean c() {
        return this.f43462d == 2;
    }

    public void d() {
        long j2 = this.f43464f;
        if (j2 > 0) {
            this.f43464f = j2 - (System.currentTimeMillis() - this.f43463e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f43464f + "ms");
            }
        }
    }

    public void e() {
        this.f43463e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f43462d = 1;
    }
}
