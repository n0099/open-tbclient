package d.b.g0.a.g1.o.c;

import d.b.g0.a.r1.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d {

    /* loaded from: classes2.dex */
    public static final class a implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Function1 f44969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44970b;

        public a(Function1 function1, String str) {
            this.f44969a = function1;
            this.f44970b = str;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public final void a() {
            JSONArray c2 = d.c();
            if (c2 != null && c2.length() != 0) {
                int length = c2.length();
                for (int i = 0; i < length; i++) {
                    if (Intrinsics.areEqual(this.f44970b, c2.get(i))) {
                        Function1 function1 = this.f44969a;
                        if (function1 != null) {
                            Unit unit = (Unit) function1.invoke(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                }
                Function1 function12 = this.f44969a;
                if (function12 != null) {
                    Unit unit2 = (Unit) function12.invoke(Boolean.FALSE);
                    return;
                }
                return;
            }
            Function1 function13 = this.f44969a;
            if (function13 != null) {
                Unit unit3 = (Unit) function13.invoke(Boolean.TRUE);
            }
        }
    }

    public static final void b(String str, Function1<? super Boolean, Unit> function1) {
        d.b.g0.a.g1.o.a.h().z(new a(function1, str));
    }

    public static final JSONArray c() {
        e O = e.O();
        if (O != null) {
            String p = O.R().p("note_data_pay_check_list", "");
            if (p == null || StringsKt__StringsJVMKt.isBlank(p)) {
                return null;
            }
            return new JSONObject(p).optJSONArray("pay_keys");
        }
        return null;
    }
}
