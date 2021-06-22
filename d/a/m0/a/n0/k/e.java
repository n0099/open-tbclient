package d.a.m0.a.n0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import d.a.m0.a.k;
import d.a.m0.a.n0.k.d;
import d.a.m0.n.h.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e implements d.a.m0.n.j.c<JSONArray> {
    public static final boolean k = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final f f47441a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47442b;

    /* renamed from: c  reason: collision with root package name */
    public i f47443c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f47444d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.q2.a f47445e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47446f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47447g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.m0.a.v2.e1.b<e>> f47448h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Collection<d.a.m0.a.v2.e1.b<e>> f47449i = new HashSet();
    public d.b j = null;

    /* loaded from: classes3.dex */
    public class a implements Function1<d.a.m0.a.q2.a, Unit> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.a.m0.a.q2.a aVar) {
            if (e.k) {
                Log.i("SoUpdating", "install: " + e.this.k() + " onCallback");
            }
            e.this.i(aVar);
            e.this.f47446f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f47441a = fVar;
        this.f47442b = str;
    }

    public final synchronized void e() {
        this.f47448h.clear();
        this.f47449i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.j.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f47442b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.a.m0.n.l.a d2 = d.a.m0.n.l.a.d(this.f47442b, next);
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                    }
                    if (d2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = l != null && next == l.q;
                        long j = (l == null || !z) ? 0L : l.f51796i;
                        String str = "0";
                        String str2 = (l == null || !z) ? "0" : l.j;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", d2.f51966b);
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

    public synchronized e g(d.a.m0.a.v2.e1.b<e> bVar) {
        this.f47448h.remove(bVar);
        return this;
    }

    public synchronized e h(d.a.m0.a.v2.e1.b<e> bVar) {
        this.f47449i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.a.m0.a.q2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f47447g + " error=" + aVar);
        }
        if (this.f47447g) {
            return this;
        }
        this.f47447g = true;
        this.f47445e = aVar;
        if (aVar == null) {
            c.f47429d.v(k(), System.currentTimeMillis());
        }
        c.f47429d.f(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f47444d;
    }

    public String k() {
        return this.f47442b;
    }

    public i l() {
        if (this.f47443c == null && !TextUtils.isEmpty(this.f47442b)) {
            this.f47443c = d.a.m0.n.g.a.h().r(this.f47442b);
        }
        return this.f47443c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f47447g;
    }

    public boolean o() {
        return n() && (this.f47445e == null || c.f47429d.k(k()));
    }

    public boolean p() {
        i iVar = this.f47444d;
        return (iVar == null || iVar == this.f47443c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f47447g + " installing=" + this.f47446f);
        }
        if (!this.f47447g && !this.f47446f) {
            this.f47446f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f47429d.x(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f47441a;
    }

    public boolean s() {
        return !n() && this.f47446f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f47448h.size());
        }
        this.f47447g = true;
        for (d.a.m0.a.v2.e1.b<e> bVar : this.f47448h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.a.m0.a.v2.e1.b<e> bVar) {
        this.f47448h.add(bVar);
        return this;
    }

    public synchronized e v(d.a.m0.a.v2.e1.b<e> bVar) {
        this.f47449i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f47444d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f47447g && bVar != null && 0 != bVar.f47440b) {
            this.j = bVar;
            for (d.a.m0.a.v2.e1.b<e> bVar2 : this.f47449i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
