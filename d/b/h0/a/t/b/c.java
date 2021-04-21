package d.b.h0.a.t.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46645c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f46646a;

    /* renamed from: b  reason: collision with root package name */
    public d f46647b;

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46648a;

        public a(String str) {
            this.f46648a = str;
        }

        @Override // d.b.h0.a.t.b.c.b
        public void a(d.b.h0.a.t.e.b bVar) {
            if (c.f46645c) {
                Log.d("SwanAutoSyncApiHandler", c.this.f46646a + " async callback: " + bVar.toString());
            }
            c.this.f46647b.c(this.f46648a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.b.h0.a.t.e.b bVar);
    }

    public c(@NonNull String str) {
        this.f46646a = str;
    }

    @NonNull
    public abstract d.b.h0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.b.h0.a.t.e.b e(@NonNull JSONObject jSONObject);

    public d.b.h0.a.t.e.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.f46647b = dVar;
        if (f46645c) {
            Log.d("SwanAutoSyncApiHandler", this.f46646a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return i() ? h(jSONObject) : g(jSONObject, str);
    }

    public final d.b.h0.a.t.e.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        if (f46645c) {
            Log.d("SwanAutoSyncApiHandler", this.f46646a + " start handle async");
        }
        d.b.h0.a.t.e.b d2 = d(jSONObject, new a(str));
        if (!d2.d("isSync", Boolean.FALSE)) {
            if (f46645c) {
                Log.e("SwanAutoSyncApiHandler", this.f46646a + " handleAsync encounter error, json exception");
            }
            return new d.b.h0.a.t.e.b(1001, "make result json error");
        }
        if (f46645c) {
            Log.d("SwanAutoSyncApiHandler", this.f46646a + " end handle async, processing in other thread, sync result: " + d2.toString());
        }
        return d2;
    }

    public final d.b.h0.a.t.e.b h(@NonNull JSONObject jSONObject) {
        if (f46645c) {
            Log.d("SwanAutoSyncApiHandler", this.f46646a + " start handle sync");
        }
        d.b.h0.a.t.e.b e2 = e(jSONObject);
        if (!e2.d("isSync", Boolean.TRUE)) {
            if (f46645c) {
                Log.e("SwanAutoSyncApiHandler", this.f46646a + " handleSync encounter error, json exception");
            }
            return new d.b.h0.a.t.e.b(1001, "make result json error");
        }
        if (f46645c) {
            Log.d("SwanAutoSyncApiHandler", this.f46646a + " end handle sync, result: " + e2.toString());
        }
        return e2;
    }

    public abstract boolean i();
}
