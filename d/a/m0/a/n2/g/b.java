package d.a.m0.a.n2.g;

import android.os.FileObserver;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.a2.d;
import d.a.m0.a.j2.c;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
import java.io.File;
/* loaded from: classes3.dex */
public final class b extends FileObserver {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47602d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47603a;

    /* renamed from: b  reason: collision with root package name */
    public int f47604b;

    /* renamed from: c  reason: collision with root package name */
    public int f47605c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47606e;

        public a(String str) {
            this.f47606e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b bVar = new c.b(10019);
            bVar.l(String.valueOf(b.this.f47605c));
            bVar.j(this.f47606e);
            bVar.h(d.g().getAppId());
            bVar.m();
        }
    }

    public b(@NonNull String str) {
        super(str, 1792);
        this.f47605c = 0;
        this.f47604b = 0;
        this.f47603a = str;
    }

    public void b(@Nullable String str) {
        q.e().execute(new a(this.f47603a + File.separator + str));
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, @Nullable String str) {
        if ((i2 & 256) == 256) {
            this.f47604b++;
            if (f47602d) {
                Log.i("SwanPkgFileObserver", "onEvent: create " + this.f47604b + " " + str);
                return;
            }
            return;
        }
        this.f47605c++;
        if (f47602d) {
            Log.i("SwanPkgFileObserver", "onEvent: delete " + this.f47604b + " " + str);
        }
        b(str);
    }
}
