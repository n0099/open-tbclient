package d.b.g0.a.j0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import d.b.g0.a.j0.i.d;
import d.b.g0.a.k;
import d.b.g0.l.k.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e implements d.b.g0.l.m.c<JSONArray> {
    public static final boolean k = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public final f f44844a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44845b;

    /* renamed from: c  reason: collision with root package name */
    public i f44846c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f44847d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.f2.a f44848e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44849f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44850g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.b.g0.a.i2.u0.b<e>> f44851h = new HashSet();
    public final Collection<d.b.g0.a.i2.u0.b<e>> i = new HashSet();
    public d.b j = null;

    /* loaded from: classes2.dex */
    public class a implements Function1<d.b.g0.a.f2.a, Unit> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.b.g0.a.f2.a aVar) {
            if (e.k) {
                Log.i("SoUpdating", "install: " + e.this.k() + " onCallback");
            }
            e.this.i(aVar);
            e.this.f44849f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f44844a = fVar;
        this.f44845b = str;
    }

    public final synchronized void e() {
        this.f44851h.clear();
        this.i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.m.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f44845b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.b.g0.l.o.a d2 = d.b.g0.l.o.a.d(this.f44845b, next);
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                    }
                    if (d2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = l != null && next == l.q;
                        long j = (l == null || !z) ? 0L : l.i;
                        String str = "0";
                        String str2 = (l == null || !z) ? "0" : l.j;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", d2.f49058b);
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

    public synchronized e g(d.b.g0.a.i2.u0.b<e> bVar) {
        this.f44851h.remove(bVar);
        return this;
    }

    public synchronized e h(d.b.g0.a.i2.u0.b<e> bVar) {
        this.i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.b.g0.a.f2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f44850g + " error=" + aVar);
        }
        if (this.f44850g) {
            return this;
        }
        this.f44850g = true;
        this.f44848e = aVar;
        if (aVar == null) {
            c.f44832d.r(k(), System.currentTimeMillis());
        }
        c.f44832d.e(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f44847d;
    }

    public String k() {
        return this.f44845b;
    }

    public i l() {
        if (this.f44846c == null && !TextUtils.isEmpty(this.f44845b)) {
            this.f44846c = d.b.g0.l.i.a.h().q(this.f44845b);
        }
        return this.f44846c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f44850g;
    }

    public boolean o() {
        return n() && (this.f44848e == null || c.f44832d.j(k()));
    }

    public boolean p() {
        i iVar = this.f44847d;
        return (iVar == null || iVar == this.f44846c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f44850g + " installing=" + this.f44849f);
        }
        if (!this.f44850g && !this.f44849f) {
            this.f44849f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f44832d.s(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f44844a;
    }

    public boolean s() {
        return !n() && this.f44849f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f44851h.size());
        }
        this.f44850g = true;
        for (d.b.g0.a.i2.u0.b<e> bVar : this.f44851h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.b.g0.a.i2.u0.b<e> bVar) {
        this.f44851h.add(bVar);
        return this;
    }

    public synchronized e v(d.b.g0.a.i2.u0.b<e> bVar) {
        this.i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f44847d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f44850g && bVar != null && 0 != bVar.f44843b) {
            this.j = bVar;
            for (d.b.g0.a.i2.u0.b<e> bVar2 : this.i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
