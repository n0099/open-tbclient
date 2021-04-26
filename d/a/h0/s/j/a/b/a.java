package d.a.h0.s.j.a.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47639a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f47640b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f47641c;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f47640b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f47640b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f47640b.put(904, 2003);
        f47640b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f47640b.put(10004, 2006);
        f47640b.put(701, 2007);
        f47640b.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        f47640b.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        f47640b.put(10007, -2301);
        f47640b.put(10008, 2101);
        f47640b.put(923, 2103);
        f47640b.put(10009, 2105);
        f47640b.put(10010, 2106);
        f47640b.put(10003, 2107);
        f47640b.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        f47640b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f47640b.put(3002, 3002);
        f47640b.put(3003, 3003);
        f47640b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f47641c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f47641c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f47641c.put(3002, "MEDIA_ERR_NETWORK");
        f47641c.put(3003, "MEDIA_ERR_NETWORK");
        f47641c.put(3004, "MEDIA_ERR_NETWORK");
        f47641c.put(-2022, "MEDIA_ERR_NETWORK");
        f47641c.put(-111, "MEDIA_ERR_NETWORK");
        f47641c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i2) {
        return f47641c.get(i2, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }

    public static int b(int i2) {
        if (f47640b.indexOfKey(i2) < 0) {
            if (f47639a) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i2);
                return 100;
            }
            return 100;
        }
        return f47640b.get(i2).intValue();
    }

    public static JSONObject c(int i2) {
        return d("errMsg", a(i2));
    }

    public static JSONObject d(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                jSONObject.put(str, obj);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
