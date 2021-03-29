package d.b.g0.a.c2.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.k;
import d.b.g0.a.k1.c;
import d.b.g0.a.r1.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43810d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public long f43811a;

    /* renamed from: b  reason: collision with root package name */
    public c f43812b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f43813c;

    /* renamed from: d.b.g0.a.c2.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0642a implements c.a {
        public C0642a() {
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f43812b == null) {
                return;
            }
            a.this.f43812b.a(a.this.f43811a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f43815a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f43816a;

        public c(@NonNull Vibrator vibrator) {
            this.f43816a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.b.g0.a.i2.c.j()) {
                    this.f43816a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f43816a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0642a c0642a) {
        this();
    }

    public static a d() {
        return b.f43815a;
    }

    public final boolean c() {
        if (d.b.g0.a.i2.c.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f43811a = j;
        if (this.f43812b == null) {
            if (f43810d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f43812b.a(this.f43811a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity n = d.e().n();
            if (n != null) {
                n.requestPermissionsExt(700, strArr, this.f43813c);
            }
        }
    }

    public void f() {
        e(400L);
    }

    public void g() {
        e(15L);
    }

    public a() {
        this.f43811a = 0L;
        this.f43813c = new C0642a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f43812b = new c(vibrator);
        }
    }
}
