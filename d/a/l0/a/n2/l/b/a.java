package d.a.l0.a.n2.l.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.k;
import d.a.l0.a.s1.g;
import d.a.l0.a.v2.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43856d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public long f43857a;

    /* renamed from: b  reason: collision with root package name */
    public c f43858b;

    /* renamed from: c  reason: collision with root package name */
    public final g.a f43859c;

    /* renamed from: d.a.l0.a.n2.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0779a implements g.a {
        public C0779a() {
        }

        @Override // d.a.l0.a.s1.g.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f43858b == null) {
                return;
            }
            a.this.f43858b.a(a.this.f43857a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f43861a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f43862a;

        public c(@NonNull Vibrator vibrator) {
            this.f43862a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.j()) {
                    this.f43862a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f43862a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0779a c0779a) {
        this();
    }

    public static a d() {
        return b.f43861a;
    }

    public final boolean c() {
        if (d.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f43857a = j;
        if (this.f43858b == null) {
            if (f43856d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f43858b.a(this.f43857a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity x = d.a.l0.a.a2.d.g().x();
            if (x != null) {
                x.requestPermissionsExt(700, strArr, this.f43859c);
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
        this.f43857a = 0L;
        this.f43859c = new C0779a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f43858b = new c(vibrator);
        }
    }
}
