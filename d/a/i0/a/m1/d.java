package d.a.i0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {
    public static final boolean j = d.a.i0.a.a2.e.y;

    /* renamed from: a  reason: collision with root package name */
    public String f43285a;

    /* renamed from: b  reason: collision with root package name */
    public String f43286b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43287c;

    /* renamed from: f  reason: collision with root package name */
    public long f43290f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f43292h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43293i;

    /* renamed from: g  reason: collision with root package name */
    public int f43291g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f43289e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f43288d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f43285a = str;
        this.f43286b = str2;
        this.f43290f = j2;
        this.f43293i = z;
    }

    public void a() {
        this.f43288d = 2;
    }

    public long b() {
        long j2 = this.f43290f;
        if (j2 > 0) {
            this.f43290f = j2 - (System.currentTimeMillis() - this.f43289e);
        }
        return this.f43290f;
    }

    public boolean c() {
        return this.f43288d == 2;
    }

    public void d() {
        long j2 = this.f43290f;
        if (j2 > 0) {
            this.f43290f = j2 - (System.currentTimeMillis() - this.f43289e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f43290f + "ms");
            }
        }
    }

    public void e() {
        this.f43289e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f43288d = 1;
    }
}
