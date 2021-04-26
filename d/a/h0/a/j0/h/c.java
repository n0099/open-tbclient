package d.a.h0.a.j0.h;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {
    @Override // d.a.h0.a.j0.h.a
    @Nullable
    public List<String> a(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        List<SwanFavorItemData> j = SwanFavorDataManager.i().j();
        if (j.size() == 0) {
            return list;
        }
        HashSet hashSet = new HashSet();
        for (SwanFavorItemData swanFavorItemData : j) {
            hashSet.add(swanFavorItemData.getAppKey());
        }
        list.removeAll(hashSet);
        if (a.f42855a) {
            Log.d("IDiskCleanStrategy", "共" + hashSet.size() + "条收藏，尝试过滤");
        }
        return list;
    }
}
