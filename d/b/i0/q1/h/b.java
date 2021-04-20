package d.b.i0.q1.h;

import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.LiveConstants;
import com.baidu.searchbox.live.interfaces.service.EventDispatcherService;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements EventDispatcherService {
    public static void e(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
        }
    }

    public final void a(Map<String, ?> map) {
    }

    public final void b() {
    }

    public void c(String str, Map<String, String> map) {
        if (k.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                statisticItem.param(str2, map.get(str2));
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void d(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String obj = map.remove("key").toString();
        for (String str : map.keySet()) {
            hashMap.put(str, map.get(str).toString());
        }
        c(obj, hashMap);
    }

    public final void f() {
    }

    public final void g(Map<String, ?> map) {
        String str = (String) map.get("data");
        if (TextUtils.isEmpty(str) || str == null) {
            return;
        }
        try {
            d.b.i0.m1.a.n(new JSONObject(str));
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.live.interfaces.service.EventDispatcherService
    public void onEvent(String str, Map<String, ?> map) {
        char c2;
        switch (str.hashCode()) {
            case -2147386482:
                if (str.equals("sync_webview_cookie")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1326603888:
                if (str.equals(LiveConstants.SdkToHostEvents.DO_LOG)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -841542404:
                if (str.equals(LiveConstants.SdkToHostEvents.GO_FEEDBACK)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 152519529:
                if (str.equals("live_show_close")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1766660371:
                if (str.equals(LiveConstants.SdkToHostEvents.BUY_TBEAN_RESULT)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1785162541:
                if (str.equals(LiveConstants.SdkToHostEvents.KEY_PRE_DOWANLOAD_SWAN)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            f();
        } else if (c2 == 1) {
            b();
        } else if (c2 == 2) {
            d(map);
        } else if (c2 == 3) {
            e((ArrayList) map.get(str));
        } else if (c2 == 4) {
            a(map);
        } else if (c2 != 5) {
        } else {
            g(map);
        }
    }
}
