package d.a.o0.v.j.a.b;

import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51674a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f51675b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseArray<String> f51676c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832449020, "Ld/a/o0/v/j/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832449020, "Ld/a/o0/v/j/a/b/a;");
                return;
            }
        }
        f51674a = k.f46335a;
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        f51675b = sparseArray;
        sparseArray.put(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER, 2001);
        f51675b.put(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM, 2002);
        f51675b.put(904, 2003);
        f51675b.put(CyberPlayerManager.MEDIA_INFO_START_PLAY, 2004);
        f51675b.put(10004, 2006);
        f51675b.put(701, 2007);
        f51675b.put(10005, 2008);
        f51675b.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        f51675b.put(10007, -2301);
        f51675b.put(10008, 2101);
        f51675b.put(923, 2103);
        f51675b.put(10009, 2105);
        f51675b.put(10010, 2106);
        f51675b.put(10003, 2107);
        f51675b.put(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE, 2108);
        f51675b.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, 3001);
        f51675b.put(3002, 3002);
        f51675b.put(3003, 3003);
        f51675b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        f51676c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        f51676c.put(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION, "MEDIA_ERR_NETWORK");
        f51676c.put(3002, "MEDIA_ERR_NETWORK");
        f51676c.put(3003, "MEDIA_ERR_NETWORK");
        f51676c.put(3004, "MEDIA_ERR_NETWORK");
        f51676c.put(-2022, "MEDIA_ERR_NETWORK");
        f51676c.put(-111, "MEDIA_ERR_NETWORK");
        f51676c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? f51676c.get(i2, "MEDIA_ERR_SRC_NOT_SUPPORTED") : (String) invokeI.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (f51675b.indexOfKey(i2) < 0) {
                if (f51674a) {
                    Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i2);
                    return 100;
                }
                return 100;
            }
            return f51675b.get(i2).intValue();
        }
        return invokeI.intValue;
    }

    public static JSONObject c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? d("errMsg", a(i2)) : (JSONObject) invokeI.objValue;
    }

    public static JSONObject d(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj)) == null) {
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
        return (JSONObject) invokeLL.objValue;
    }
}
