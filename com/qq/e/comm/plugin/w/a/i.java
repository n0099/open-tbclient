package com.qq.e.comm.plugin.w.a;

import android.util.Pair;
import com.qq.e.comm.plugin.util.j;
import com.qq.e.comm.plugin.w.a.d;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: com.qq.e.comm.plugin.w.a.i$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements j<Pair<Integer, JSONObject>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f12666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12667b;
        final /* synthetic */ a c;

        AnonymousClass1(boolean z, boolean z2, a aVar) {
            this.f12666a = z;
            this.f12667b = z2;
            this.c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.qq.e.comm.plugin.util.j
        public void a(Pair<Integer, JSONObject> pair) {
            if (((Integer) pair.first).intValue() != 200 || pair.second == null) {
                return;
            }
            String optString = ((JSONObject) pair.second).optString("clickid");
            com.qq.e.comm.plugin.w.a.a(this.f12666a, this.f12667b, optString);
            if (this.c != null) {
                this.c.a(optString, this.f12667b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, boolean z);
    }

    public static <T> Pair<Boolean, Boolean> a(T t, d.a aVar, d.b bVar, d.e eVar, a aVar2) {
        return (Pair) gdtadv.getobjresult(60, 1, t, aVar, bVar, eVar, aVar2);
    }

    public static <T> Pair<Boolean, Boolean> a(T t, d.a aVar, d.b bVar, d.e eVar, boolean z) {
        return (Pair) gdtadv.getobjresult(61, 1, t, aVar, bVar, eVar, Boolean.valueOf(z));
    }

    private static <T> Pair<Boolean, Boolean> a(T t, d.a aVar, d.b bVar, d.e eVar, boolean z, a aVar2) {
        return (Pair) gdtadv.getobjresult(62, 1, t, aVar, bVar, eVar, Boolean.valueOf(z), aVar2);
    }
}
