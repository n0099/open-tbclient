package d.b.g0.b.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47315f;

        public a(String str, JSONObject jSONObject) {
            this.f47314e = str;
            this.f47315f = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                int b2 = hVar.b();
                String f2 = d.b.g0.a.v1.c.c.f(b2);
                if (d.f45929c) {
                    Log.e("getOpenBduss", "getOpenBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                b.this.c(this.f47314e, new d.b.g0.a.t.e.b(b2, d.b.g0.a.v1.c.c.f(b2)));
                return;
            }
            JSONArray optJSONArray = this.f47315f.optJSONArray("tpls");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            b.this.s(this.f47315f.optString("clientId"), arrayList, this.f47314e);
        }
    }

    /* renamed from: d.b.g0.b.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0902b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47317a;

        public C0902b(String str) {
            this.f47317a = str;
        }

        @Override // d.b.g0.b.k.b.c
        public void a(String str) {
            try {
                b.this.c(this.f47317a, new d.b.g0.a.t.e.b(0, new JSONObject(str)));
            } catch (JSONException e2) {
                b.this.c(this.f47317a, new d.b.g0.a.t.e.b(10001, "internal error"));
                if (d.f45929c) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.b.g0.a.t.e.b r(String str) {
        e O = e.O();
        if (O == null) {
            if (d.f45929c) {
                Log.e("getOpenBduss", "getOpenBduss failed: null swan runtime");
            }
            return new d.b.g0.a.t.e.b(1001, "null swan runtime");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.f45929c) {
                d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(201, "empty cb");
        }
        O.R().g(d.b.g0.a.r1.d.e(), "scope_get_open_bduss", new a(optString, jSONObject));
        return new d.b.g0.a.t.e.b(0);
    }

    public final void s(String str, ArrayList<String> arrayList, String str2) {
        if (!d.b.g0.b.i.a.I(d.b.g0.a.r1.d.e())) {
            c(str2, new d.b.g0.a.t.e.b(202, "user is not logged in or the params are invalid"));
        } else {
            d.b.g0.b.i.a.o(d.b.g0.a.r1.d.e(), str, arrayList, new C0902b(str2));
        }
    }
}
