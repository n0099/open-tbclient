package d.b.g0.a.f1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class d {
    public static final boolean j = d.b.g0.a.r1.e.x;

    /* renamed from: a  reason: collision with root package name */
    public String f44418a;

    /* renamed from: b  reason: collision with root package name */
    public String f44419b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44420c;

    /* renamed from: f  reason: collision with root package name */
    public long f44423f;

    /* renamed from: h  reason: collision with root package name */
    public Rect f44425h;
    public boolean i;

    /* renamed from: g  reason: collision with root package name */
    public int f44424g = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f44422e = System.currentTimeMillis();

    /* renamed from: d  reason: collision with root package name */
    public int f44421d = 0;

    public d(String str, String str2, long j2, boolean z) {
        this.f44418a = str;
        this.f44419b = str2;
        this.f44423f = j2;
        this.i = z;
    }

    public void a() {
        this.f44421d = 2;
    }

    public long b() {
        long j2 = this.f44423f;
        if (j2 > 0) {
            this.f44423f = j2 - (System.currentTimeMillis() - this.f44422e);
        }
        return this.f44423f;
    }

    public boolean c() {
        return this.f44421d == 2;
    }

    public void d() {
        long j2 = this.f44423f;
        if (j2 > 0) {
            this.f44423f = j2 - (System.currentTimeMillis() - this.f44422e);
            if (j) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.f44423f + "ms");
            }
        }
    }

    public void e() {
        this.f44422e = System.currentTimeMillis();
    }

    public void f(Bitmap bitmap) {
        new WeakReference(bitmap);
    }

    public void g() {
        this.f44421d = 1;
    }
}
