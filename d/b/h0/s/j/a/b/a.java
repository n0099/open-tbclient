package d.b.h0.s.j.a.b;

import android.util.Log;
import android.util.SparseArray;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50106a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f50107b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f50108c;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f50107b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f50107b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f50107b.put(904, 2003);
        f50107b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f50107b.put(10004, 2006);
        f50107b.put(701, 2007);
        f50107b.put(10005, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_FORCE_NAV_MODULE));
        f50107b.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        f50107b.put(10007, -2301);
        f50107b.put(10008, 2101);
        f50107b.put(923, 2103);
        f50107b.put(10009, 2105);
        f50107b.put(10010, 2106);
        f50107b.put(10003, 2107);
        f50107b.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        f50107b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f50107b.put(3002, 3002);
        f50107b.put(3003, 3003);
        f50107b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f50108c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f50108c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f50108c.put(3002, "MEDIA_ERR_NETWORK");
        f50108c.put(3003, "MEDIA_ERR_NETWORK");
        f50108c.put(3004, "MEDIA_ERR_NETWORK");
        f50108c.put(-2022, "MEDIA_ERR_NETWORK");
        f50108c.put(-111, "MEDIA_ERR_NETWORK");
        f50108c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i) {
        return f50108c.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED");
    }

    public static int b(int i) {
        if (f50107b.indexOfKey(i) < 0) {
            if (f50106a) {
                Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
                return 100;
            }
            return 100;
        }
        return f50107b.get(i).intValue();
    }

    public static JSONObject c(int i) {
        return d("errMsg", a(i));
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
