package d.a.h0.a.c2.j.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.k;
import d.a.h0.a.k1.c;
import d.a.h0.a.r1.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f41825d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public long f41826a;

    /* renamed from: b  reason: collision with root package name */
    public c f41827b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f41828c;

    /* renamed from: d.a.h0.a.c2.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0613a implements c.a {
        public C0613a() {
        }

        @Override // d.a.h0.a.k1.c.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            if (i2 != 700 || iArr.length <= 0 || iArr[0] != 0 || a.this.f41827b == null) {
                return;
            }
            a.this.f41827b.a(a.this.f41826a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f41830a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Vibrator f41831a;

        public c(@NonNull Vibrator vibrator) {
            this.f41831a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            try {
                if (d.a.h0.a.i2.c.j()) {
                    this.f41831a.vibrate(VibrationEffect.createOneShot(j, -1));
                } else {
                    this.f41831a.vibrate(j);
                }
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ a(C0613a c0613a) {
        this();
    }

    public static a d() {
        return b.f41830a;
    }

    public final boolean c() {
        if (d.a.h0.a.i2.c.h()) {
            Context appContext = AppRuntime.getAppContext();
            return appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void e(long j) {
        this.f41826a = j;
        if (this.f41827b == null) {
            if (f41825d) {
                throw new RuntimeException("not support vibration");
            }
        } else if (c()) {
            this.f41827b.a(this.f41826a);
        } else {
            String[] strArr = {"android.permission.VIBRATE"};
            SwanAppActivity v = d.e().v();
            if (v != null) {
                v.requestPermissionsExt(700, strArr, this.f41828c);
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
        this.f41826a = 0L;
        this.f41828c = new C0613a();
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.f41827b = new c(vibrator);
        }
    }
}
