package d.b.g0.r;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, List<VeloceIpcResult.a>> f49741a = new HashMap<>();

    public static synchronized Bundle a(String str, Bundle bundle) {
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<VeloceIpcResult.a> list = f49741a.get(str);
            if (list == null) {
                return null;
            }
            for (VeloceIpcResult.a aVar : list) {
                aVar.a(VeloceIpcResult.a(0, bundle));
            }
            f49741a.remove(list);
            return b(0);
        }
    }

    public static Bundle b(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }
}
