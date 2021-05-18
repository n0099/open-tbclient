package d.a.i0.a.s.a.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.u.c.d;
import d.a.i0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.i0.a.s.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0803a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44418e;

        public C0803a(String str) {
            this.f44418e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                a.this.t(this.f44418e);
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.i0.a.e2.c.d.f(b2);
            if (d.f44636c) {
                Log.e("AllianceAccountApi", "getUnionBDUSS failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.this.d(this.f44418e, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.f44636c) {
            Log.d("AllianceAccountApi", "getUnionBduss start: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            if (d.f44636c) {
                Log.e("AllianceAccountApi", "getUnionBduss failed: null swan runtime");
            }
            return new d.a.i0.a.u.h.b(1001, "null swan runtime");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("AllianceAccountApi", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.f44636c) {
                d.a.i0.a.e0.d.b("AllianceAccountApi", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.i0.a.u.h.b(201, "empty cb");
        }
        Q.T().g(d.a.i0.a.a2.d.g(), "account_get_union_bduss", new C0803a(optString));
        return new d.a.i0.a.u.h.b(0);
    }

    public final void t(String str) {
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "bduss", d.a.i0.a.s.a.d.f44401a.a());
        d(str, new d.a.i0.a.u.h.b(0, jSONObject));
    }
}
