package d.a.i0.v.j.a.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48370a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f48371b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f48372c;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f48371b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f48371b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f48371b.put(904, 2003);
        f48371b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f48371b.put(10004, 2006);
        f48371b.put(701, 2007);
        f48371b.put(10005, 2008);
        f48371b.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        f48371b.put(10007, -2301);
        f48371b.put(10008, 2101);
        f48371b.put(923, 2103);
        f48371b.put(10009, 2105);
        f48371b.put(10010, 2106);
        f48371b.put(10003, 2107);
        f48371b.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        f48371b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f48371b.put(3002, 3002);
        f48371b.put(3003, 3003);
        f48371b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f48372c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f48372c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f48372c.put(3002, "MEDIA_ERR_NETWORK");
        f48372c.put(3003, "MEDIA_ERR_NETWORK");
        f48372c.put(3004, "MEDIA_ERR_NETWORK");
        f48372c.put(-2022, "MEDIA_ERR_NETWORK");
        f48372c.put(-111, "MEDIA_ERR_NETWORK");
        f48372c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i2) {
        return f48372c.get(i2, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }

    public static int b(int i2) {
        if (f48371b.indexOfKey(i2) < 0) {
            if (f48370a) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i2);
                return 100;
            }
            return 100;
        }
        return f48371b.get(i2).intValue();
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
