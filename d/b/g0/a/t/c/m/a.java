package d.b.g0.a.t.c.m;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import d.b.g0.a.c2.a.a;
import d.b.g0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.t.b.d {

    /* renamed from: d.b.g0.a.t.c.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0826a implements d.b {

        /* renamed from: d.b.g0.a.t.c.m.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0827a implements a.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f46165a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ k f46166b;

            public C0827a(String str, k kVar) {
                this.f46165a = str;
                this.f46166b = kVar;
            }

            @Override // d.b.g0.a.c2.a.a.b
            public void a(double[] dArr) {
                if (dArr != null && dArr.length == 3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.f46166b.d(a.this, jSONObject);
                        return;
                    } catch (JSONException e2) {
                        d.b.g0.a.c0.c.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                        this.f46166b.f(a.this, "Json error");
                        return;
                    }
                }
                d.b.g0.a.c0.c.b("Api-Accelerometer", "illegal accelerometers");
                a.this.c(this.f46165a, new d.b.g0.a.t.e.b(1001));
            }
        }

        public C0826a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.b.g0.a.c0.c.g("Api-Accelerometer", " init ");
            k kVar = new k("accelerometerChange", jSONObject, str);
            d.b.g0.a.c2.a.a g2 = d.b.g0.a.c2.a.a.g();
            g2.h(a.this.h(), b.a(jSONObject.optString("interval")));
            g2.k(new C0827a(str, kVar));
            g2.l();
            kVar.b(a.this);
            return new d.b.g0.a.t.e.b(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f46168a;

        static {
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f46168a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f46168a.put("game", 20);
            f46168a.put("normal", 200);
        }

        public static int a(String str) {
            Integer num = f46168a.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return i(str, true, new C0826a());
    }

    public d.b.g0.a.t.e.b s() {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        d.b.g0.a.c0.c.g("Api-Accelerometer", "stop listen accelerometer");
        d.b.g0.a.c2.a.a.g().m();
        return new d.b.g0.a.t.e.b(0);
    }
}
