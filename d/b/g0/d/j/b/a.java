package d.b.g0.d.j.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.n.e;
import d.b.g0.n.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47526a = k.f45051a;

    @Override // d.b.g0.n.m
    public boolean a(JSONArray jSONArray) {
        if (f47526a) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        d.b.g0.d.j.b.d.c cVar = new d.b.g0.d.j.b.d.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", e.g().getDeviceId(AppRuntime.getApplication()));
        hashMap.put("uuid", e.g().n(AppRuntime.getApplication()));
        d.b.g0.d.j.b.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
        if (f47526a) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.f47531a);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f47532b);
        }
        int i = cVar.f47531a;
        if (i == 1 || i == 2 || i == 4) {
            d.b.g0.o.c.a();
            return false;
        }
        return true;
    }
}
