package d.a.m0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import d.a.m0.a.n2.a.a;
import d.a.m0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.m0.a.u.c.d {

    /* renamed from: d.a.m0.a.u.e.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0923a implements d.b {

        /* renamed from: d.a.m0.a.u.e.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0924a implements a.InterfaceC0827a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48933a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f48934b;

            public C0924a(String str, l lVar) {
                this.f48933a = str;
                this.f48934b = lVar;
            }

            @Override // d.a.m0.a.n2.a.a.InterfaceC0827a
            public void a(double[] dArr) {
                if (dArr != null && dArr.length == 3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.f48934b.d(a.this, jSONObject);
                        return;
                    } catch (JSONException e2) {
                        d.a.m0.a.e0.d.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                        this.f48934b.f(a.this, "Json error");
                        return;
                    }
                }
                d.a.m0.a.e0.d.b("Api-Accelerometer", "illegal accelerometers");
                a.this.d(this.f48933a, new d.a.m0.a.u.h.b(1001));
            }
        }

        public C0923a() {
        }

        @Override // d.a.m0.a.u.c.d.b
        public d.a.m0.a.u.h.b a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.a.m0.a.e0.d.g("Api-Accelerometer", " init ");
            l lVar = new l("accelerometerChange", jSONObject, str);
            d.a.m0.a.n2.a.a a2 = d.a.m0.a.n2.a.a.a();
            a2.b(a.this.i(), b.a(jSONObject.optString("interval")));
            a2.e(new C0924a(str, lVar));
            a2.f();
            lVar.b(a.this);
            return new d.a.m0.a.u.h.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f48936a;

        static {
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f48936a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f48936a.put("game", 20);
            f48936a.put("normal", 200);
        }

        public static int a(String str) {
            Integer num = f48936a.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }

    public a(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b s(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return j(str, true, new C0923a());
    }

    public d.a.m0.a.u.h.b t() {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        d.a.m0.a.e0.d.g("Api-Accelerometer", "stop listen accelerometer");
        d.a.m0.a.n2.a.a.a().g();
        return new d.a.m0.a.u.h.b(0);
    }
}
