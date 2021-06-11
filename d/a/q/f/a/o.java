package d.a.q.f.a;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.common.param.CommonUrlParamManager;
import d.a.q.g.d.a;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o implements j {

    /* renamed from: a  reason: collision with root package name */
    public a f67885a;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f67886a;

        /* renamed from: b  reason: collision with root package name */
        public a.C1846a f67887b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67888c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67889d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f67890e;

        /* renamed from: f  reason: collision with root package name */
        public long f67891f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f67892g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f67893h;

        /* renamed from: i  reason: collision with root package name */
        public long f67894i;

        public a(o oVar, Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            this.f67887b = new d.a.q.g.d.a(context.getApplicationContext()).d().f("cloud").f("cstore");
        }

        public void a(JSONObject jSONObject) {
            this.f67893h = jSONObject;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
            if (e() != false) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean b() {
            n();
            o();
            boolean g2 = d.a.q.b.d(this.f67886a).g();
            boolean z = false;
            if (this.f67888c && g2) {
                if (this.f67892g == null) {
                    return true;
                }
                if (!f()) {
                }
                z = true;
                return z;
            }
            return false;
        }

        public final boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            try {
                jSONArray = m.a(jSONObject.optJSONArray("sids"), "pkg");
                try {
                    jSONArray2 = m.a(jSONObject2.optJSONArray("sids"), "pkg");
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONArray = null;
            }
            return o.b(jSONArray, jSONArray2) || m.b(jSONObject, jSONObject2, "oid") || m.b(jSONObject, jSONObject2, "gaid") || m.b(jSONObject, jSONObject2, CommonUrlParamManager.PARAM_IID) || m.b(jSONObject, jSONObject2, "adrid") || m.b(jSONObject, jSONObject2, "aid");
        }

        public void d(JSONObject jSONObject) {
            this.f67892g = jSONObject;
            k();
        }

        public final synchronized boolean e() {
            if (this.f67892g == null) {
                return true;
            }
            if (this.f67893h != null) {
                return c(this.f67892g, this.f67893h);
            }
            throw new IllegalArgumentException("you forgot invoke methond :IMatchConditions.setComparedCStoreParams before ");
        }

        public final boolean f() {
            return Math.abs(System.currentTimeMillis() - this.f67894i) / 1000 > this.f67891f;
        }

        public final long g() {
            JSONObject jSONObject = this.f67892g;
            if (jSONObject == null) {
                return 0L;
            }
            return jSONObject.optLong("ctime", 0L);
        }

        public final void h() {
            try {
                this.f67892g = n.a(this.f67887b.g("cs.dat", true));
                this.f67894i = g();
            } catch (Exception unused) {
                this.f67894i = 0L;
            }
        }

        public final void i() {
            try {
                JSONObject a2 = n.a(this.f67887b.g("ct.dat", true));
                if (a2 == null) {
                    this.f67891f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
                } else {
                    this.f67891f = a2.optLong("TIME_OUT", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME);
                }
            } catch (Exception unused) {
                this.f67891f = ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME;
            }
        }

        public final void j() {
            try {
                JSONObject a2 = n.a(this.f67887b.g("ci.dat", true));
                if (a2 == null) {
                    this.f67888c = true;
                } else {
                    this.f67888c = a2.optBoolean("isOn", true);
                }
            } catch (Exception unused) {
                this.f67888c = true;
            }
        }

        public final boolean k() {
            try {
                this.f67887b.i("cs.dat", this.f67892g.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean l() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isOn", this.f67888c);
                this.f67887b.i("ci.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean m() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("TIME_OUT", this.f67891f);
                this.f67887b.i("ct.dat", jSONObject.toString(), true);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final synchronized void n() {
            boolean z = true;
            if (this.f67889d) {
                this.f67889d = !l();
            }
            if (this.f67890e) {
                if (m()) {
                    z = false;
                }
                this.f67890e = z;
            }
        }

        public final void o() {
            h();
            i();
            j();
        }
    }

    public o(Context context) {
        if (context == null) {
            throw new NullPointerException("context should not be null");
        }
        if (this.f67885a == null) {
            this.f67885a = new a(this, context.getApplicationContext());
        }
    }

    public static boolean b(JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray == null ? 0 : jSONArray.length();
        if (length != (jSONArray2 == null ? 0 : jSONArray2.length())) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            JSONObject optJSONObject2 = jSONArray2.optJSONObject(i2);
            if (m.b(optJSONObject, optJSONObject2, "pkg") || m.b(optJSONObject, optJSONObject2, "aid") || m.c(optJSONObject, optJSONObject2, "priority")) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.q.f.a.j
    public j a(JSONObject jSONObject) {
        this.f67885a.a(jSONObject);
        return this;
    }

    @Override // d.a.q.f.a.j
    public boolean a() {
        return this.f67885a.b();
    }

    @Override // d.a.q.f.a.j
    public void b(JSONObject jSONObject) {
        this.f67885a.d(jSONObject);
    }
}
