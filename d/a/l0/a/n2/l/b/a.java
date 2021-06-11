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
    public static final boolean f47532d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public long f47533a;

    /* renamed from: b  reason: collision with root package name */
    public c f47534b;

    /* renamed from: c  reason: collision with root package name */
    public final g.a f47535c;

    /* renamed from: d.a.l0.a.n2.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0835a implements g.a {
        public C0835a() {
        }

        @Override // d.a.l0.a.s1.g.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f47534b == null) {
                return;
            }
            a.this.f47534b.a(a.this.f47533a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f47537a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f47538a;

        public c(@NonNull Vibrator vibrator) {
            this.f47538a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.j()) {
                    this.f47538a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f47538a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0835a c0835a) {
        this();
    }

    public static a d() {
        return b.f47537a;
    }

    public final boolean c() {
        if (d.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f47533a = j;
        if (this.f47534b == null) {
            if (f47532d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f47534b.a(this.f47533a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity x = d.a.l0.a.a2.d.g().x();
            if (x != null) {
                x.requestPermissionsExt(700, strArr, this.f47535c);
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
        this.f47533a = 0L;
        this.f47535c = new C0835a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f47534b = new c(vibrator);
        }
    }
}
