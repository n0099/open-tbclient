package d.b.g0.a.t.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45924c = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f45925a;

    /* renamed from: b  reason: collision with root package name */
    public d f45926b;

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45927a;

        public a(String str) {
            this.f45927a = str;
        }

        @Override // d.b.g0.a.t.b.c.b
        public void a(d.b.g0.a.t.e.b bVar) {
            if (c.f45924c) {
                Log.d("SwanAutoSyncApiHandler", c.this.f45925a + " async callback: " + bVar.toString());
            }
            c.this.f45926b.c(this.f45927a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.b.g0.a.t.e.b bVar);
    }

    public c(@NonNull String str) {
        this.f45925a = str;
    }

    @NonNull
    public abstract d.b.g0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.b.g0.a.t.e.b e(@NonNull JSONObject jSONObject);

    public d.b.g0.a.t.e.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.f45926b = dVar;
        if (f45924c) {
            Log.d("SwanAutoSyncApiHandler", this.f45925a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return i() ? h(jSONObject) : g(jSONObject, str);
    }

    public final d.b.g0.a.t.e.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        if (f45924c) {
            Log.d("SwanAutoSyncApiHandler", this.f45925a + " start handle async");
        }
        d.b.g0.a.t.e.b d2 = d(jSONObject, new a(str));
        if (!d2.d("isSync", Boolean.FALSE)) {
            if (f45924c) {
                Log.e("SwanAutoSyncApiHandler", this.f45925a + " handleAsync encounter error, json exception");
            }
            return new d.b.g0.a.t.e.b(1001, "make result json error");
        }
        if (f45924c) {
            Log.d("SwanAutoSyncApiHandler", this.f45925a + " end handle async, processing in other thread, sync result: " + d2.toString());
        }
        return d2;
    }

    public final d.b.g0.a.t.e.b h(@NonNull JSONObject jSONObject) {
        if (f45924c) {
            Log.d("SwanAutoSyncApiHandler", this.f45925a + " start handle sync");
        }
        d.b.g0.a.t.e.b e2 = e(jSONObject);
        if (!e2.d("isSync", Boolean.TRUE)) {
            if (f45924c) {
                Log.e("SwanAutoSyncApiHandler", this.f45925a + " handleSync encounter error, json exception");
            }
            return new d.b.g0.a.t.e.b(1001, "make result json error");
        }
        if (f45924c) {
            Log.d("SwanAutoSyncApiHandler", this.f45925a + " end handle sync, result: " + e2.toString());
        }
        return e2;
    }

    public abstract boolean i();
}
