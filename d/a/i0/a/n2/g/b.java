package d.a.i0.a.n2.g;

import android.os.FileObserver;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.a2.d;
import d.a.i0.a.j2.c;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import java.io.File;
/* loaded from: classes3.dex */
public final class b extends FileObserver {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43644d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43645a;

    /* renamed from: b  reason: collision with root package name */
    public int f43646b;

    /* renamed from: c  reason: collision with root package name */
    public int f43647c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43648e;

        public a(String str) {
            this.f43648e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10019);
            bVar.l(String.valueOf(b.this.f43647c));
            bVar.j(this.f43648e);
            bVar.h(d.g().getAppId());
            bVar.m();
        }
    }

    public b(@NonNull String str) {
        super(str, 1792);
        this.f43647c = 0;
        this.f43646b = 0;
        this.f43645a = str;
    }

    public void b(@Nullable String str) {
        q.e().execute(new a(this.f43645a + File.separator + str));
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, @Nullable String str) {
        if ((i2 & 256) == 256) {
            this.f43646b++;
            if (f43644d) {
                Log.i("SwanPkgFileObserver", "onEvent: create " + this.f43646b + " " + str);
                return;
            }
            return;
        }
        this.f43647c++;
        if (f43644d) {
            Log.i("SwanPkgFileObserver", "onEvent: delete " + this.f43646b + " " + str);
        }
        b(str);
    }
}
