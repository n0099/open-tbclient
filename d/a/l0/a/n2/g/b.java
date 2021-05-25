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
    public static final boolean f43818d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43819a;

    /* renamed from: b  reason: collision with root package name */
    public int f43820b;

    /* renamed from: c  reason: collision with root package name */
    public int f43821c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43822e;

        public a(String str) {
            this.f43822e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10019);
            bVar.l(String.valueOf(b.this.f43821c));
            bVar.j(this.f43822e);
            bVar.h(d.g().getAppId());
            bVar.m();
        }
    }

    public b(@NonNull String str) {
        super(str, 1792);
        this.f43821c = 0;
        this.f43820b = 0;
        this.f43819a = str;
    }

    public void b(@Nullable String str) {
        q.e().execute(new a(this.f43819a + File.separator + str));
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, @Nullable String str) {
        if ((i2 & 256) == 256) {
            this.f43820b++;
            if (f43818d) {
                Log.i("SwanPkgFileObserver", "onEvent: create " + this.f43820b + " " + str);
                return;
            }
            return;
        }
        this.f43821c++;
        if (f43818d) {
            Log.i("SwanPkgFileObserver", "onEvent: delete " + this.f43820b + " " + str);
        }
        b(str);
    }
}
