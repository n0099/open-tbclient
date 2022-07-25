package com.repackage;

import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ph4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final SparseArray<Integer> b;
    public static final SparseArray<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755409931, "Lcom/repackage/ph4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755409931, "Lcom/repackage/ph4;");
                return;
            }
        }
        a = sg1.a;
        SparseArray<Integer> sparseArray = new SparseArray<>(32);
        b = sparseArray;
        sparseArray.put(10015, 2001);
        b.put(10013, 2002);
        b.put(904, 2003);
        b.put(10012, 2004);
        b.put(10004, 2006);
        b.put(701, 2007);
        b.put(10005, 2008);
        b.put(10006, Integer.valueOf((int) UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE));
        b.put(10007, -2301);
        b.put(10008, 2101);
        b.put(923, 2103);
        b.put(10009, 2105);
        b.put(10010, 2106);
        b.put(10003, 2107);
        b.put(10011, 2108);
        b.put(10014, 3001);
        b.put(3002, 3002);
        b.put(3003, 3003);
        b.put(3004, 3005);
        SparseArray<String> sparseArray2 = new SparseArray<>();
        c = sparseArray2;
        sparseArray2.put(10007, "MEDIA_ERR_NETWORK");
        c.put(10014, "MEDIA_ERR_NETWORK");
        c.put(3002, "MEDIA_ERR_NETWORK");
        c.put(3003, "MEDIA_ERR_NETWORK");
        c.put(3004, "MEDIA_ERR_NETWORK");
        c.put(-2022, "MEDIA_ERR_NETWORK");
        c.put(-111, "MEDIA_ERR_NETWORK");
        c.put(10008, "MEDIA_ERR_DECODE");
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? c.get(i, "MEDIA_ERR_SRC_NOT_SUPPORTED") : (String) invokeI.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (b.indexOfKey(i) < 0) {
                if (a) {
                    Log.e("LiveStatusCodeAdapter", "Please check sStatusCodeMap already putted correct K,V pair. what: " + i);
                    return 100;
                }
                return 100;
            }
            return b.get(i).intValue();
        }
        return invokeI.intValue;
    }

    public static JSONObject c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? d(StatConstants.KEY_EXT_ERR_MSG, a(i)) : (JSONObject) invokeI.objValue;
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
