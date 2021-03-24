package d.b.g0.b.k;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.c;
import d.b.g0.a.t.b.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.b.g0.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0899a extends d.b.g0.a.t.b.c {

        /* renamed from: d.b.g0.b.k.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0900a implements d.b.g0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f47311e;

            public C0900a(c.b bVar) {
                this.f47311e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.b.g0.a.v1.c.c.h(hVar)) {
                    this.f47311e.a(a.this.s());
                    return;
                }
                int b2 = hVar.b();
                String f2 = d.b.g0.a.v1.c.c.f(b2);
                if (d.f45928c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f47311e.a(new d.b.g0.a.t.e.b(b2, f2));
            }
        }

        public C0899a(String str) {
            super(str);
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e O = e.O();
            if (O == null) {
                if (d.f45928c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                }
                return new d.b.g0.a.t.e.b(1001, "null swan runtime");
            }
            O.R().g(d.b.g0.a.r1.d.e(), "mapp_i_get_bduss", new C0900a(bVar));
            return new d.b.g0.a.t.e.b(0);
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return a.this.s();
        }

        @Override // d.b.g0.a.t.b.c
        public boolean i() {
            return d.b.g0.a.r1.d.e().x() && d.b.g0.a.r1.d.e().s().R().f("mapp_i_get_bduss");
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.b.g0.a.t.e.b r(String str) {
        return j(str, new C0899a("getBDUSS"));
    }

    @NonNull
    public final d.b.g0.a.t.e.b s() {
        String i = d.b.g0.b.i.a.i(d.b.g0.a.r1.d.e());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", i);
            if (d.f45928c) {
                Log.d("Api-Base-getBduss", "getBduss success: " + jSONObject.toString());
            }
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f45928c) {
                Log.e("Api-Base-getBduss", "getBduss failed: JsonException");
                e2.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(1001, "result JSONException");
        }
    }
}
