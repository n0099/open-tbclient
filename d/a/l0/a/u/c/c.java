package d.a.l0.a.u.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48481c = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f48482a;

    /* renamed from: b  reason: collision with root package name */
    public d f48483b;

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48484a;

        public a(String str) {
            this.f48484a = str;
        }

        @Override // d.a.l0.a.u.c.c.b
        public void a(d.a.l0.a.u.h.b bVar) {
            if (c.f48481c) {
                Log.d("SwanAutoSyncApiHandler", c.this.f48482a + " async callback: " + bVar.toString());
            }
            c.this.f48483b.d(this.f48484a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.a.l0.a.u.h.b bVar);
    }

    public c(@NonNull String str) {
        this.f48482a = str;
    }

    @NonNull
    public abstract d.a.l0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.a.l0.a.u.h.b e(@NonNull JSONObject jSONObject);

    public d.a.l0.a.u.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.f48483b = dVar;
        if (f48481c) {
            Log.d("SwanAutoSyncApiHandler", this.f48482a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return i() ? h(jSONObject) : g(jSONObject, str);
    }

    public final d.a.l0.a.u.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        if (f48481c) {
            Log.d("SwanAutoSyncApiHandler", this.f48482a + " start handle async");
        }
        d.a.l0.a.u.h.b d2 = d(jSONObject, new a(str));
        if (!d2.d("isSync", Boolean.FALSE)) {
            if (f48481c) {
                Log.e("SwanAutoSyncApiHandler", this.f48482a + " handleAsync encounter error, json exception");
            }
            return new d.a.l0.a.u.h.b(1001, "make result json error");
        }
        if (f48481c) {
            Log.d("SwanAutoSyncApiHandler", this.f48482a + " end handle async, processing in other thread, sync result: " + d2.toString());
        }
        return d2;
    }

    public final d.a.l0.a.u.h.b h(@NonNull JSONObject jSONObject) {
        if (f48481c) {
            Log.d("SwanAutoSyncApiHandler", this.f48482a + " start handle sync");
        }
        d.a.l0.a.u.h.b e2 = e(jSONObject);
        if (!e2.d("isSync", Boolean.TRUE)) {
            if (f48481c) {
                Log.e("SwanAutoSyncApiHandler", this.f48482a + " handleSync encounter error, json exception");
            }
            return new d.a.l0.a.u.h.b(1001, "make result json error");
        }
        if (f48481c) {
            Log.d("SwanAutoSyncApiHandler", this.f48482a + " end handle sync, result: " + e2.toString());
        }
        return e2;
    }

    public abstract boolean i();
}
