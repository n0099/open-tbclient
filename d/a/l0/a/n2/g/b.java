package d.a.l0.a.n2.g;

import android.os.FileObserver;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.a2.d;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import java.io.File;
/* loaded from: classes3.dex */
public final class b extends FileObserver {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47494d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47495a;

    /* renamed from: b  reason: collision with root package name */
    public int f47496b;

    /* renamed from: c  reason: collision with root package name */
    public int f47497c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47498e;

        public a(String str) {
            this.f47498e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10019);
            bVar.l(String.valueOf(b.this.f47497c));
            bVar.j(this.f47498e);
            bVar.h(d.g().getAppId());
            bVar.m();
        }
    }

    public b(@NonNull String str) {
        super(str, 1792);
        this.f47497c = 0;
        this.f47496b = 0;
        this.f47495a = str;
    }

    public void b(@Nullable String str) {
        q.e().execute(new a(this.f47495a + File.separator + str));
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, @Nullable String str) {
        if ((i2 & 256) == 256) {
            this.f47496b++;
            if (f47494d) {
                Log.i("SwanPkgFileObserver", "onEvent: create " + this.f47496b + " " + str);
                return;
            }
            return;
        }
        this.f47497c++;
        if (f47494d) {
            Log.i("SwanPkgFileObserver", "onEvent: delete " + this.f47496b + " " + str);
        }
        b(str);
    }
}
