package d.a.l0.e.o.a;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import d.a.l0.r.e;
import d.a.l0.r.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46560a = k.f43199a;

    @Override // d.a.l0.r.m
    public boolean a(JSONArray jSONArray) {
        if (f46560a) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        d.a.l0.e.o.a.d.c cVar = new d.a.l0.e.o.a.d.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", e.h().t(AppRuntime.getApplication()));
        hashMap.put("uuid", e.h().p(AppRuntime.getApplication()));
        d.a.l0.e.o.a.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
        if (f46560a) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.f46565a);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f46566b);
        }
        int i2 = cVar.f46565a;
        if (i2 == 1 || i2 == 2 || i2 == 4) {
            d.a.l0.s.c.a();
            return false;
        }
        return true;
    }
}
