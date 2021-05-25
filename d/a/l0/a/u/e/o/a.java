package d.a.l0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import d.a.l0.a.n2.a.a;
import d.a.l0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.u.c.d {

    /* renamed from: d.a.l0.a.u.e.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0864a implements d.b {

        /* renamed from: d.a.l0.a.u.e.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0865a implements a.InterfaceC0768a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f45151a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f45152b;

            public C0865a(String str, l lVar) {
                this.f45151a = str;
                this.f45152b = lVar;
            }

            @Override // d.a.l0.a.n2.a.a.InterfaceC0768a
            public void a(double[] dArr) {
                if (dArr != null && dArr.length == 3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("x", dArr[0]);
                        jSONObject.put("y", dArr[1]);
                        jSONObject.put("z", dArr[2]);
                        this.f45152b.d(a.this, jSONObject);
                        return;
                    } catch (JSONException e2) {
                        d.a.l0.a.e0.d.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                        this.f45152b.f(a.this, "Json error");
                        return;
                    }
                }
                d.a.l0.a.e0.d.b("Api-Accelerometer", "illegal accelerometers");
                a.this.d(this.f45151a, new d.a.l0.a.u.h.b(1001));
            }
        }

        public C0864a() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.a.l0.a.e0.d.g("Api-Accelerometer", " init ");
            l lVar = new l("accelerometerChange", jSONObject, str);
            d.a.l0.a.n2.a.a a2 = d.a.l0.a.n2.a.a.a();
            a2.b(a.this.i(), b.a(jSONObject.optString("interval")));
            a2.e(new C0865a(str, lVar));
            a2.f();
            lVar.b(a.this);
            return new d.a.l0.a.u.h.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f45154a;

        static {
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f45154a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f45154a.put("game", 20);
            f45154a.put("normal", 200);
        }

        public static int a(String str) {
            Integer num = f45154a.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return j(str, true, new C0864a());
    }

    public d.a.l0.a.u.h.b t() {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        d.a.l0.a.e0.d.g("Api-Accelerometer", "stop listen accelerometer");
        d.a.l0.a.n2.a.a.a().g();
        return new d.a.l0.a.u.h.b(0);
    }
}
