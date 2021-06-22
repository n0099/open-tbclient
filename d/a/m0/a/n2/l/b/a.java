package d.a.m0.a.n2.l.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.k;
import d.a.m0.a.s1.g;
import d.a.m0.a.v2.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47640d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public long f47641a;

    /* renamed from: b  reason: collision with root package name */
    public c f47642b;

    /* renamed from: c  reason: collision with root package name */
    public final g.a f47643c;

    /* renamed from: d.a.m0.a.n2.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0838a implements g.a {
        public C0838a() {
        }

        @Override // d.a.m0.a.s1.g.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f47642b == null) {
                return;
            }
            a.this.f47642b.a(a.this.f47641a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f47645a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f47646a;

        public c(@NonNull Vibrator vibrator) {
            this.f47646a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.j()) {
                    this.f47646a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f47646a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0838a c0838a) {
        this();
    }

    public static a d() {
        return b.f47645a;
    }

    public final boolean c() {
        if (d.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f47641a = j;
        if (this.f47642b == null) {
            if (f47640d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f47642b.a(this.f47641a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity x = d.a.m0.a.a2.d.g().x();
            if (x != null) {
                x.requestPermissionsExt(700, strArr, this.f47643c);
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
        this.f47641a = 0L;
        this.f47643c = new C0838a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f47642b = new c(vibrator);
        }
    }
}
