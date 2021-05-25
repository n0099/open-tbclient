package d.a.l0.a.n1.q.c;

import d.a.l0.a.a2.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* loaded from: classes3.dex */
    public static final class a implements d.a.l0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Function1 f43754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43755b;

        public a(Function1 function1, String str) {
            this.f43754a = function1;
            this.f43755b = str;
        }

        @Override // d.a.l0.a.n1.q.b.a
        public final void a() {
            JSONArray c2 = d.c();
            if (c2 != null && c2.length() != 0) {
                int length = c2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (Intrinsics.areEqual(this.f43755b, c2.get(i2))) {
                        Function1 function1 = this.f43754a;
                        if (function1 != null) {
                            Unit unit = (Unit) function1.invoke(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                }
                Function1 function12 = this.f43754a;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            Function1 function13 = this.f43754a;
            if (function13 != null) {
                Unit unit3 = (Unit) function13.invoke(Boolean.TRUE);
            }
        }
    }

    public static final void b(String str, Function1<? super Boolean, Unit> function1) {
        d.a.l0.a.n1.q.a.g().z(new a(function1, str));
    }

    public static final JSONArray c() {
        e Q = e.Q();
        if (Q != null) {
            String q = Q.T().q("note_data_pay_check_list", "");
            if (q == null || StringsKt__StringsJVMKt.isBlank(q)) {
                return null;
            }
            return new JSONObject(q).optJSONArray("pay_keys");
        }
        return null;
    }
}
