package d.a.i0.b.l;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.u.c.c;
import d.a.i0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.a.i0.b.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0932a extends d.a.i0.a.u.c.c {

        /* renamed from: d.a.i0.b.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0933a implements d.a.i0.a.v2.e1.b<i<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f46098e;

            public C0933a(c.b bVar) {
                this.f46098e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                if (d.a.i0.a.e2.c.d.h(iVar)) {
                    this.f46098e.a(a.this.t());
                    return;
                }
                int b2 = iVar.b();
                String f2 = d.a.i0.a.e2.c.d.f(b2);
                if (d.f44636c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.f46098e.a(new d.a.i0.a.u.h.b(b2, f2));
            }
        }

        public C0932a(String str) {
            super(str);
        }

        @Override // d.a.i0.a.u.c.c
        @NonNull
        public d.a.i0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            e Q = e.Q();
            if (Q == null) {
                if (d.f44636c) {
                    Log.e("Api-Base-getBduss", "getBduss failed: null swan runtime");
                }
                return new d.a.i0.a.u.h.b(1001, "null swan runtime");
            }
            Q.T().g(d.a.i0.a.a2.d.g(), "mapp_i_get_bduss", new C0933a(bVar));
            return new d.a.i0.a.u.h.b(0);
        }

        @Override // d.a.i0.a.u.c.c
        @NonNull
        public d.a.i0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            return a.this.t();
        }

        @Override // d.a.i0.a.u.c.c
        public boolean i() {
            return d.a.i0.a.a2.d.g().C() && d.a.i0.a.a2.d.g().r().T().f("mapp_i_get_bduss");
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    @SuppressLint({"SwanBindApiNote"})
    public d.a.i0.a.u.h.b s(String str) {
        return k(str, new C0932a("getBDUSS"));
    }

    @NonNull
    public final d.a.i0.a.u.h.b t() {
        String i2 = d.a.i0.b.j.a.i(d.a.i0.a.a2.d.g());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", i2);
            if (d.f44636c) {
                Log.d("Api-Base-getBduss", "getBduss success: " + jSONObject.toString());
            }
            return new d.a.i0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.f44636c) {
                Log.e("Api-Base-getBduss", "getBduss failed: JsonException");
                e2.printStackTrace();
            }
            return new d.a.i0.a.u.h.b(1001, "result JSONException");
        }
    }
}
