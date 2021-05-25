package d.a.l0.a.n0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import d.a.l0.a.k;
import d.a.l0.a.n0.k.d;
import d.a.l0.n.h.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e implements d.a.l0.n.j.c<JSONArray> {
    public static final boolean k = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final f f43657a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43658b;

    /* renamed from: c  reason: collision with root package name */
    public i f43659c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f43660d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.q2.a f43661e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43662f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43663g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.l0.a.v2.e1.b<e>> f43664h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Collection<d.a.l0.a.v2.e1.b<e>> f43665i = new HashSet();
    public d.b j = null;

    /* loaded from: classes2.dex */
    public class a implements Function1<d.a.l0.a.q2.a, Unit> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.a.l0.a.q2.a aVar) {
            if (e.k) {
                Log.i("SoUpdating", "install: " + e.this.k() + " onCallback");
            }
            e.this.i(aVar);
            e.this.f43662f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f43657a = fVar;
        this.f43658b = str;
    }

    public final synchronized void e() {
        this.f43664h.clear();
        this.f43665i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.j.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f43658b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.a.l0.n.l.a d2 = d.a.l0.n.l.a.d(this.f43658b, next);
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                    }
                    if (d2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = l != null && next == l.q;
                        long j = (l == null || !z) ? 0L : l.f48014i;
                        String str = "0";
                        String str2 = (l == null || !z) ? "0" : l.j;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", d2.f48184b);
                        jSONObject.put("version_code", j);
                        jSONObject.put("version_name", str);
                        if (k) {
                            Log.i("SoUpdating", "decorate abi=" + next + " jo=" + jSONObject);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
        } catch (JSONException e2) {
            if (k) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized e g(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f43664h.remove(bVar);
        return this;
    }

    public synchronized e h(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f43665i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.a.l0.a.q2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f43663g + " error=" + aVar);
        }
        if (this.f43663g) {
            return this;
        }
        this.f43663g = true;
        this.f43661e = aVar;
        if (aVar == null) {
            c.f43645d.v(k(), System.currentTimeMillis());
        }
        c.f43645d.f(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f43660d;
    }

    public String k() {
        return this.f43658b;
    }

    public i l() {
        if (this.f43659c == null && !TextUtils.isEmpty(this.f43658b)) {
            this.f43659c = d.a.l0.n.g.a.h().r(this.f43658b);
        }
        return this.f43659c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f43663g;
    }

    public boolean o() {
        return n() && (this.f43661e == null || c.f43645d.k(k()));
    }

    public boolean p() {
        i iVar = this.f43660d;
        return (iVar == null || iVar == this.f43659c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f43663g + " installing=" + this.f43662f);
        }
        if (!this.f43663g && !this.f43662f) {
            this.f43662f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f43645d.x(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f43657a;
    }

    public boolean s() {
        return !n() && this.f43662f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f43664h.size());
        }
        this.f43663g = true;
        for (d.a.l0.a.v2.e1.b<e> bVar : this.f43664h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f43664h.add(bVar);
        return this;
    }

    public synchronized e v(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f43665i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f43660d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f43663g && bVar != null && 0 != bVar.f43656b) {
            this.j = bVar;
            for (d.a.l0.a.v2.e1.b<e> bVar2 : this.f43665i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
