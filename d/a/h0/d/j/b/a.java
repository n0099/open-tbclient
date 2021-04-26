package d.a.h0.d.j.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import d.a.h0.n.e;
import d.a.h0.n.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45697a = k.f43101a;

    @Override // d.a.h0.n.m
    public boolean a(JSONArray jSONArray) {
        if (f45697a) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        d.a.h0.d.j.b.d.c cVar = new d.a.h0.d.j.b.d.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", e.g().r(AppRuntime.getApplication()));
        hashMap.put("uuid", e.g().n(AppRuntime.getApplication()));
        d.a.h0.d.j.b.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
        if (f45697a) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.f45702a);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f45703b);
        }
        int i2 = cVar.f45702a;
        if (i2 == 1 || i2 == 2 || i2 == 4) {
            d.a.h0.o.c.a();
            return false;
        }
        return true;
    }
}
