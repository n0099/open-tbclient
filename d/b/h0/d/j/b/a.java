package d.b.h0.d.j.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
import d.b.h0.n.e;
import d.b.h0.n.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a implements m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48247a = k.f45772a;

    @Override // d.b.h0.n.m
    public boolean a(JSONArray jSONArray) {
        if (f48247a) {
            Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
        }
        d.b.h0.d.j.b.d.c cVar = new d.b.h0.d.j.b.d.c();
        HashMap hashMap = new HashMap(2);
        hashMap.put("cuid", e.g().n(AppRuntime.getApplication()));
        hashMap.put("uuid", e.g().o(AppRuntime.getApplication()));
        d.b.h0.d.j.b.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
        if (f48247a) {
            Log.d("OpenBehaviorUploader", "errorCode : " + cVar.f48252a);
            Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f48253b);
        }
        int i = cVar.f48252a;
        if (i == 1 || i == 2 || i == 4) {
            d.b.h0.o.c.a();
            return false;
        }
        return true;
    }
}
