package d.a.h0.a.t.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44016c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f44017a;

    /* renamed from: b  reason: collision with root package name */
    public d f44018b;

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44019a;

        public a(String str) {
            this.f44019a = str;
        }

        @Override // d.a.h0.a.t.b.c.b
        public void a(d.a.h0.a.t.e.b bVar) {
            if (c.f44016c) {
                Log.d("SwanAutoSyncApiHandler", c.this.f44017a + " async callback: " + bVar.toString());
            }
            c.this.f44018b.c(this.f44019a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.a.h0.a.t.e.b bVar);
    }

    public c(@NonNull String str) {
        this.f44017a = str;
    }

    @NonNull
    public abstract d.a.h0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.a.h0.a.t.e.b e(@NonNull JSONObject jSONObject);

    public d.a.h0.a.t.e.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.f44018b = dVar;
        if (f44016c) {
            Log.d("SwanAutoSyncApiHandler", this.f44017a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return i() ? h(jSONObject) : g(jSONObject, str);
    }

    public final d.a.h0.a.t.e.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        if (f44016c) {
            Log.d("SwanAutoSyncApiHandler", this.f44017a + " start handle async");
        }
        d.a.h0.a.t.e.b d2 = d(jSONObject, new a(str));
        if (!d2.d("isSync", Boolean.FALSE)) {
            if (f44016c) {
                Log.e("SwanAutoSyncApiHandler", this.f44017a + " handleAsync encounter error, json exception");
            }
            return new d.a.h0.a.t.e.b(1001, "make result json error");
        }
        if (f44016c) {
            Log.d("SwanAutoSyncApiHandler", this.f44017a + " end handle async, processing in other thread, sync result: " + d2.toString());
        }
        return d2;
    }

    public final d.a.h0.a.t.e.b h(@NonNull JSONObject jSONObject) {
        if (f44016c) {
            Log.d("SwanAutoSyncApiHandler", this.f44017a + " start handle sync");
        }
        d.a.h0.a.t.e.b e2 = e(jSONObject);
        if (!e2.d("isSync", Boolean.TRUE)) {
            if (f44016c) {
                Log.e("SwanAutoSyncApiHandler", this.f44017a + " handleSync encounter error, json exception");
            }
            return new d.a.h0.a.t.e.b(1001, "make result json error");
        }
        if (f44016c) {
            Log.d("SwanAutoSyncApiHandler", this.f44017a + " end handle sync, result: " + e2.toString());
        }
        return e2;
    }

    public abstract boolean i();
}
