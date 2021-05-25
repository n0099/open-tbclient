package d.a.l0.b.l;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.u.c.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46277f;

        public a(String str, JSONObject jSONObject) {
            this.f46276e = str;
            this.f46277f = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                int b2 = iVar.b();
                String f2 = d.a.l0.a.e2.c.d.f(b2);
                if (d.f44812c) {
                    Log.e("getOpenBduss", "getOpenBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                b.this.d(this.f46276e, new d.a.l0.a.u.h.b(b2, d.a.l0.a.e2.c.d.f(b2)));
                return;
            }
            JSONArray optJSONArray = this.f46277f.optJSONArray("tpls");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(optJSONArray.optString(i2));
            }
            b.this.t(this.f46277f.optString("clientId"), arrayList, this.f46276e);
        }
    }

    /* renamed from: d.a.l0.b.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0945b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46279a;

        public C0945b(String str) {
            this.f46279a = str;
        }

        @Override // d.a.l0.b.l.b.c
        public void a(String str) {
            try {
                b.this.d(this.f46279a, new d.a.l0.a.u.h.b(0, new JSONObject(str)));
            } catch (JSONException e2) {
                b.this.d(this.f46279a, new d.a.l0.a.u.h.b(10001, "internal error"));
                if (d.f44812c) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.l0.a.u.h.b s(String str) {
        e Q = e.Q();
        if (Q == null) {
            if (d.f44812c) {
                Log.e("getOpenBduss", "getOpenBduss failed: null swan runtime");
            }
            return new d.a.l0.a.u.h.b(1001, "null swan runtime");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.f44812c) {
                d.a.l0.a.e0.d.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(201, "empty cb");
        }
        Q.T().g(d.a.l0.a.a2.d.g(), "scope_get_open_bduss", new a(optString, jSONObject));
        return new d.a.l0.a.u.h.b(0);
    }

    public final void t(String str, ArrayList<String> arrayList, String str2) {
        if (!d.a.l0.b.j.a.G(d.a.l0.a.a2.d.g())) {
            d(str2, new d.a.l0.a.u.h.b(202, "user is not logged in or the params are invalid"));
        } else {
            d.a.l0.b.j.a.o(d.a.l0.a.a2.d.g(), str, arrayList, new C0945b(str2));
        }
    }
}
