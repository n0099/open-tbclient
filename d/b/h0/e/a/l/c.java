package d.b.h0.e.a.l;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull d.b.h0.a.q.g.a.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("type", swanAppDownloadType.getTypeName());
        bundle.putString(PushConstants.PARAMS, jSONObject != null ? jSONObject.toString() : "");
        d.b.h0.a.n1.c.e.a C = d.b.h0.a.n1.c.e.a.C();
        if (C != null) {
            C.J(bundle, b.class, new d(aVar, swanAppDownloadType));
            return true;
        }
        return true;
    }
}
