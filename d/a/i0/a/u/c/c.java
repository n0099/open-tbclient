package d.a.i0.a.u.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44631c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f44632a;

    /* renamed from: b  reason: collision with root package name */
    public d f44633b;

    /* loaded from: classes2.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44634a;

        public a(String str) {
            this.f44634a = str;
        }

        @Override // d.a.i0.a.u.c.c.b
        public void a(d.a.i0.a.u.h.b bVar) {
            if (c.f44631c) {
                Log.d("SwanAutoSyncApiHandler", c.this.f44632a + " async callback: " + bVar.toString());
            }
            c.this.f44633b.d(this.f44634a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(d.a.i0.a.u.h.b bVar);
    }

    public c(@NonNull String str) {
        this.f44632a = str;
    }

    @NonNull
    public abstract d.a.i0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull b bVar);

    @NonNull
    public abstract d.a.i0.a.u.h.b e(@NonNull JSONObject jSONObject);

    public d.a.i0.a.u.h.b f(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.f44633b = dVar;
        if (f44631c) {
            Log.d("SwanAutoSyncApiHandler", this.f44632a + " is called, can use sync mode: " + i() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return i() ? h(jSONObject) : g(jSONObject, str);
    }

    public final d.a.i0.a.u.h.b g(@NonNull JSONObject jSONObject, @Nullable String str) {
        if (f44631c) {
            Log.d("SwanAutoSyncApiHandler", this.f44632a + " start handle async");
        }
        d.a.i0.a.u.h.b d2 = d(jSONObject, new a(str));
        if (!d2.e("isSync", Boolean.FALSE)) {
            if (f44631c) {
                Log.e("SwanAutoSyncApiHandler", this.f44632a + " handleAsync encounter error, json exception");
            }
            return new d.a.i0.a.u.h.b(1001, "make result json error");
        }
        if (f44631c) {
            Log.d("SwanAutoSyncApiHandler", this.f44632a + " end handle async, processing in other thread, sync result: " + d2.toString());
        }
        return d2;
    }

    public final d.a.i0.a.u.h.b h(@NonNull JSONObject jSONObject) {
        if (f44631c) {
            Log.d("SwanAutoSyncApiHandler", this.f44632a + " start handle sync");
        }
        d.a.i0.a.u.h.b e2 = e(jSONObject);
        if (!e2.e("isSync", Boolean.TRUE)) {
            if (f44631c) {
                Log.e("SwanAutoSyncApiHandler", this.f44632a + " handleSync encounter error, json exception");
            }
            return new d.a.i0.a.u.h.b(1001, "make result json error");
        }
        if (f44631c) {
            Log.d("SwanAutoSyncApiHandler", this.f44632a + " end handle sync, result: " + e2.toString());
        }
        return e2;
    }

    public abstract boolean i();
}
