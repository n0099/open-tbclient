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
    public static final boolean f44202d = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public long f44203a;

    /* renamed from: b  reason: collision with root package name */
    public c f44204b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f44205c;

    /* renamed from: d.b.g0.a.c2.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0654a implements c.a {
        public C0654a() {
        }

        @Override // d.b.g0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f44204b == null) {
                return;
            }
            a.this.f44204b.a(a.this.f44203a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44207a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f44208a;

        public c(@NonNull Vibrator vibrator) {
            this.f44208a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.b.g0.a.i2.c.j()) {
                    this.f44208a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f44208a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0654a c0654a) {
        this();
    }

    public static a d() {
        return b.f44207a;
    }

    public final boolean c() {
        if (d.b.g0.a.i2.c.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f44203a = j;
        if (this.f44204b == null) {
            if (f44202d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f44204b.a(this.f44203a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity n = d.e().n();
            if (n != null) {
                n.requestPermissionsExt(700, strArr, this.f44205c);
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
        this.f44203a = 0L;
        this.f44205c = new C0654a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f44204b = new c(vibrator);
        }
    }
}
