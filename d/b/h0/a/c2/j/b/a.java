package d.b.h0.a.c2.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.k;
import d.b.h0.a.k1.c;
import d.b.h0.a.r1.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44531d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public long f44532a;

    /* renamed from: b  reason: collision with root package name */
    public c f44533b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f44534c;

    /* renamed from: d.b.h0.a.c2.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0674a implements c.a {
        public C0674a() {
        }

        @Override // d.b.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f44533b == null) {
                return;
            }
            a.this.f44533b.a(a.this.f44532a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44536a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f44537a;

        public c(@NonNull Vibrator vibrator) {
            this.f44537a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.b.h0.a.i2.c.j()) {
                    this.f44537a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f44537a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0674a c0674a) {
        this();
    }

    public static a d() {
        return b.f44536a;
    }

    public final boolean c() {
        if (d.b.h0.a.i2.c.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f44532a = j;
        if (this.f44533b == null) {
            if (f44531d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f44533b.a(this.f44532a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity n = d.e().n();
            if (n != null) {
                n.requestPermissionsExt(700, strArr, this.f44534c);
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
        this.f44532a = 0L;
        this.f44534c = new C0674a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f44533b = new c(vibrator);
        }
    }
}
