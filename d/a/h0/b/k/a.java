package d.a.h0.b.k;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.b.c;
import d.a.h0.a.t.b.d;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.a.h0.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0871a extends d.a.h0.a.t.b.c {

        /* renamed from: d.a.h0.b.k.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0872a implements d.a.h0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f45473e;

            public C0872a(c.b bVar) {
                this.f45473e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.a.h0.a.v1.c.c.h(hVar)) {
                    this.f45473e.a(a.this.s());
                    return;
                }
                int b2 = hVar.b();
                String f2 = d.a.h0.a.v1.c.c.f(b2);
                if (d.f44021c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f45473e.a(new d.a.h0.a.t.e.b(b2, f2));
            }
        }

        public C0871a(String str) {
            super(str);
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e O = e.O();
            if (O == null) {
                if (d.f44021c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                }
                return new d.a.h0.a.t.e.b(1001, "null swan runtime");
            }
            O.R().g(d.a.h0.a.r1.d.e(), "mapp_i_get_bduss", new C0872a(bVar));
            return new d.a.h0.a.t.e.b(0);
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return a.this.s();
        }

        @Override // d.a.h0.a.t.b.c
        public boolean i() {
            return d.a.h0.a.r1.d.e().z() && d.a.h0.a.r1.d.e().p().R().f("mapp_i_get_bduss");
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.h0.a.t.e.b r(String str) {
        return j(str, new C0871a("getBDUSS"));
    }

    @NonNull
    public final d.a.h0.a.t.e.b s() {
        String i2 = d.a.h0.b.i.a.i(d.a.h0.a.r1.d.e());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", i2);
            if (d.f44021c) {
                Log.d("Api-Base-getBduss", "getBduss success: " + jSONObject.toString());
            }
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f44021c) {
                Log.e("Api-Base-getBduss", "getBduss failed: JsonException");
                e2.printStackTrace();
            }
            return new d.a.h0.a.t.e.b(1001, "result JSONException");
        }
    }
}
