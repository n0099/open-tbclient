package d.a.i0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import d.a.i0.a.n2.a.a;
import d.a.i0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.u.c.d {

    /* renamed from: d.a.i0.a.u.e.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0853a implements d.b {

        /* renamed from: d.a.i0.a.u.e.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0854a implements a.InterfaceC0757a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f44975a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f44976b;

            public C0854a(String str, l lVar) {
                this.f44975a = str;
                this.f44976b = lVar;
            }

            @Override // d.a.i0.a.n2.a.a.InterfaceC0757a
            public void a(double[] dArr) {
                if (dArr != null && dArr.length == 3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.f44976b.d(a.this, jSONObject);
                        return;
                    } catch (JSONException e2) {
                        d.a.i0.a.e0.d.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                        this.f44976b.f(a.this, "Json error");
                        return;
                    }
                }
                d.a.i0.a.e0.d.b("Api-Accelerometer", "illegal accelerometers");
                a.this.d(this.f44975a, new d.a.i0.a.u.h.b(1001));
            }
        }

        public C0853a() {
        }

        @Override // d.a.i0.a.u.c.d.b
        public d.a.i0.a.u.h.b a(d.a.i0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.a.i0.a.e0.d.g("Api-Accelerometer", " init ");
            l lVar = new l("accelerometerChange", jSONObject, str);
            d.a.i0.a.n2.a.a a2 = d.a.i0.a.n2.a.a.a();
            a2.b(a.this.i(), b.a(jSONObject.optString("interval")));
            a2.e(new C0854a(str, lVar));
            a2.f();
            lVar.b(a.this);
            return new d.a.i0.a.u.h.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f44978a;

        static {
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f44978a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f44978a.put("game", 20);
            f44978a.put("normal", 200);
        }

        public static int a(String str) {
            Integer num = f44978a.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return j(str, true, new C0853a());
    }

    public d.a.i0.a.u.h.b t() {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        d.a.i0.a.e0.d.g("Api-Accelerometer", "stop listen accelerometer");
        d.a.i0.a.n2.a.a.a().g();
        return new d.a.i0.a.u.h.b(0);
    }
}
