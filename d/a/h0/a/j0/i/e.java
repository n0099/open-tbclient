package d.a.h0.a.j0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import d.a.h0.a.j0.i.d;
import d.a.h0.a.k;
import d.a.h0.l.k.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e implements d.a.h0.l.m.c<JSONArray> {
    public static final boolean k = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final f f42886a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42887b;

    /* renamed from: c  reason: collision with root package name */
    public i f42888c = null;

    /* renamed from: d  reason: collision with root package name */
    public i f42889d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.f2.a f42890e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42891f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42892g = false;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.h0.a.i2.u0.b<e>> f42893h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Collection<d.a.h0.a.i2.u0.b<e>> f42894i = new HashSet();
    public d.b j = null;

    /* loaded from: classes2.dex */
    public class a implements Function1<d.a.h0.a.f2.a, Unit> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.a.h0.a.f2.a aVar) {
            if (e.k) {
                Log.i("SoUpdating", "install: " + e.this.k() + " onCallback");
            }
            e.this.i(aVar);
            e.this.f42891f = false;
            return null;
        }
    }

    public e(@NonNull f fVar, String str) {
        this.f42886a = fVar;
        this.f42887b = str;
    }

    public final synchronized void e() {
        this.f42893h.clear();
        this.f42894i.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.m.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        i l = l();
        if (k) {
            Log.i("SoUpdating", "decorateParams libName=" + this.f42887b + " localSo=" + l);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (k) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    d.a.h0.l.o.a d2 = d.a.h0.l.o.a.d(this.f42887b, next);
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                    }
                    if (d2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = l != null && next == l.q;
                        long j = (l == null || !z) ? 0L : l.f47155i;
                        String str = "0";
                        String str2 = (l == null || !z) ? "0" : l.j;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", d2.f47293b);
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

    public synchronized e g(d.a.h0.a.i2.u0.b<e> bVar) {
        this.f42893h.remove(bVar);
        return this;
    }

    public synchronized e h(d.a.h0.a.i2.u0.b<e> bVar) {
        this.f42894i.remove(bVar);
        return this;
    }

    public final synchronized e i(d.a.h0.a.f2.a aVar) {
        if (k) {
            Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f42892g + " error=" + aVar);
        }
        if (this.f42892g) {
            return this;
        }
        this.f42892g = true;
        this.f42890e = aVar;
        if (aVar == null) {
            c.f42874d.r(k(), System.currentTimeMillis());
        }
        c.f42874d.e(k());
        t();
        e();
        return this;
    }

    public i j() {
        return this.f42889d;
    }

    public String k() {
        return this.f42887b;
    }

    public i l() {
        if (this.f42888c == null && !TextUtils.isEmpty(this.f42887b)) {
            this.f42888c = d.a.h0.l.i.a.h().q(this.f42887b);
        }
        return this.f42888c;
    }

    public d.b m() {
        return this.j;
    }

    public boolean n() {
        return this.f42892g;
    }

    public boolean o() {
        return n() && (this.f42890e == null || c.f42874d.j(k()));
    }

    public boolean p() {
        i iVar = this.f42889d;
        return (iVar == null || iVar == this.f42888c) ? false : true;
    }

    public synchronized void q() {
        if (k) {
            Log.i("SoUpdating", "install: " + k() + " finished=" + this.f42892g + " installing=" + this.f42891f);
        }
        if (!this.f42892g && !this.f42891f) {
            this.f42891f = true;
            if (k) {
                Log.i("SoUpdating", "install: " + k());
            }
            c.f42874d.s(k(), new a());
        }
    }

    public boolean r(f fVar) {
        return fVar != null && fVar == this.f42886a;
    }

    public boolean s() {
        return !n() && this.f42891f;
    }

    public final synchronized void t() {
        if (k) {
            Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f42893h.size());
        }
        this.f42892g = true;
        for (d.a.h0.a.i2.u0.b<e> bVar : this.f42893h) {
            if (bVar != null) {
                bVar.onCallback(this);
            }
        }
    }

    public synchronized e u(d.a.h0.a.i2.u0.b<e> bVar) {
        this.f42893h.add(bVar);
        return this;
    }

    public synchronized e v(d.a.h0.a.i2.u0.b<e> bVar) {
        this.f42894i.add(bVar);
        return this;
    }

    public e w(f fVar, i iVar) {
        if (r(fVar)) {
            this.f42889d = iVar;
        }
        return this;
    }

    public synchronized void x(d.b bVar) {
        if (!this.f42892g && bVar != null && 0 != bVar.f42885b) {
            this.j = bVar;
            for (d.a.h0.a.i2.u0.b<e> bVar2 : this.f42894i) {
                if (bVar2 != null) {
                    bVar2.onCallback(this);
                }
            }
        }
    }
}
