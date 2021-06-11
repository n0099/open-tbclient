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
/* loaded from: classes3.dex */
public final class e implements d.a.l0.n.j.c<JSONArray> {
    public static final boolean k = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final f f47333a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47334b;

    /* renamed from: c  reason: collision with root package name */
    public i f47335c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f47336d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.q2.a f47337e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47338f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47339g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.l0.a.v2.e1.b<e>> f47340h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Collection<d.a.l0.a.v2.e1.b<e>> f47341i = new HashSet();
    public d.b j = null;

    /* loaded from: classes3.dex */
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
            e.this.f47338f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f47333a = fVar;
        this.f47334b = str;
    }

    public final synchronized void e() {
        this.f47340h.clear();
        this.f47341i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.j.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f47334b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.a.l0.n.l.a d2 = d.a.l0.n.l.a.d(this.f47334b, next);
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                    }
                    if (d2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = l != null && next == l.q;
                        long j = (l == null || !z) ? 0L : l.f51688i;
                        String str = "0";
                        String str2 = (l == null || !z) ? "0" : l.j;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", d2.f51858b);
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
        this.f47340h.remove(bVar);
        return this;
    }

    public synchronized e h(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f47341i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.a.l0.a.q2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f47339g + " error=" + aVar);
        }
        if (this.f47339g) {
            return this;
        }
        this.f47339g = true;
        this.f47337e = aVar;
        if (aVar == null) {
            c.f47321d.v(k(), System.currentTimeMillis());
        }
        c.f47321d.f(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f47336d;
    }

    public String k() {
        return this.f47334b;
    }

    public i l() {
        if (this.f47335c == null && !TextUtils.isEmpty(this.f47334b)) {
            this.f47335c = d.a.l0.n.g.a.h().r(this.f47334b);
        }
        return this.f47335c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f47339g;
    }

    public boolean o() {
        return n() && (this.f47337e == null || c.f47321d.k(k()));
    }

    public boolean p() {
        i iVar = this.f47336d;
        return (iVar == null || iVar == this.f47335c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f47339g + " installing=" + this.f47338f);
        }
        if (!this.f47339g && !this.f47338f) {
            this.f47338f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f47321d.x(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f47333a;
    }

    public boolean s() {
        return !n() && this.f47338f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f47340h.size());
        }
        this.f47339g = true;
        for (d.a.l0.a.v2.e1.b<e> bVar : this.f47340h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f47340h.add(bVar);
        return this;
    }

    public synchronized e v(d.a.l0.a.v2.e1.b<e> bVar) {
        this.f47341i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f47336d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f47339g && bVar != null && 0 != bVar.f47332b) {
            this.j = bVar;
            for (d.a.l0.a.v2.e1.b<e> bVar2 : this.f47341i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
