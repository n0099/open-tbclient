package d.b.h0.a.j0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import d.b.h0.a.j0.i.d;
import d.b.h0.a.k;
import d.b.h0.l.k.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e implements d.b.h0.l.m.c<JSONArray> {
    public static final boolean k = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final f f45565a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45566b;

    /* renamed from: c  reason: collision with root package name */
    public i f45567c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f45568d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.f2.a f45569e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45570f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45571g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.b.h0.a.i2.u0.b<e>> f45572h = new HashSet();
    public final Collection<d.b.h0.a.i2.u0.b<e>> i = new HashSet();
    public d.b j = null;

    /* loaded from: classes2.dex */
    public class a implements Function1<d.b.h0.a.f2.a, Unit> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.b.h0.a.f2.a aVar) {
            if (e.k) {
                Log.i("SoUpdating", "install: " + e.this.k() + " onCallback");
            }
            e.this.i(aVar);
            e.this.f45570f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f45565a = fVar;
        this.f45566b = str;
    }

    public final synchronized void e() {
        this.f45572h.clear();
        this.i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.l.m.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f45566b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.b.h0.l.o.a d2 = d.b.h0.l.o.a.d(this.f45566b, next);
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
                        jSONObject.put("bundle_id", d2.f49779b);
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

    public synchronized e g(d.b.h0.a.i2.u0.b<e> bVar) {
        this.f45572h.remove(bVar);
        return this;
    }

    public synchronized e h(d.b.h0.a.i2.u0.b<e> bVar) {
        this.i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.b.h0.a.f2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f45571g + " error=" + aVar);
        }
        if (this.f45571g) {
            return this;
        }
        this.f45571g = true;
        this.f45569e = aVar;
        if (aVar == null) {
            c.f45553d.r(k(), System.currentTimeMillis());
        }
        c.f45553d.e(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f45568d;
    }

    public String k() {
        return this.f45566b;
    }

    public i l() {
        if (this.f45567c == null && !TextUtils.isEmpty(this.f45566b)) {
            this.f45567c = d.b.h0.l.i.a.h().q(this.f45566b);
        }
        return this.f45567c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f45571g;
    }

    public boolean o() {
        return n() && (this.f45569e == null || c.f45553d.j(k()));
    }

    public boolean p() {
        i iVar = this.f45568d;
        return (iVar == null || iVar == this.f45567c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f45571g + " installing=" + this.f45570f);
        }
        if (!this.f45571g && !this.f45570f) {
            this.f45570f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f45553d.s(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f45565a;
    }

    public boolean s() {
        return !n() && this.f45570f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f45572h.size());
        }
        this.f45571g = true;
        for (d.b.h0.a.i2.u0.b<e> bVar : this.f45572h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.b.h0.a.i2.u0.b<e> bVar) {
        this.f45572h.add(bVar);
        return this;
    }

    public synchronized e v(d.b.h0.a.i2.u0.b<e> bVar) {
        this.i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f45568d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f45571g && bVar != null && 0 != bVar.f45564b) {
            this.j = bVar;
            for (d.b.h0.a.i2.u0.b<e> bVar2 : this.i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
