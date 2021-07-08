package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: classes6.dex */
public class WeiboParameters {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHARSET = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAnonymousCookie;
    public String mAppKey;
    public LinkedHashMap<String, Object> mParams;

    public WeiboParameters(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mParams = new LinkedHashMap<>();
        this.mAppKey = str;
    }

    @Deprecated
    public void add(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.mParams.put(str, str2);
        }
    }

    public boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mParams.containsKey(str) : invokeL.booleanValue;
    }

    public boolean containsValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.mParams.containsValue(str) : invokeL.booleanValue;
    }

    public String encodeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : this.mParams.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                Object obj = this.mParams.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            sb.append(URLEncoder.encode(str, "UTF-8") + "=" + URLEncoder.encode(str2, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.mParams.get(str) : invokeL.objValue;
    }

    public String getAnonymousCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAnonymousCookie : (String) invokeV.objValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAppKey : (String) invokeV.objValue;
    }

    public LinkedHashMap<String, Object> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mParams : (LinkedHashMap) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasBinaryData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (String str : this.mParams.keySet()) {
                Object obj = this.mParams.get(str);
                if ((obj instanceof ByteArrayOutputStream) || (obj instanceof Bitmap)) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mParams.keySet() : (Set) invokeV.objValue;
    }

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            this.mParams.put(str, str2);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && this.mParams.containsKey(str)) {
            this.mParams.remove(str);
            LinkedHashMap<String, Object> linkedHashMap = this.mParams;
            linkedHashMap.remove(linkedHashMap.get(str));
        }
    }

    public void setAnonymousCookie(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mAnonymousCookie = str;
        }
    }

    public void setParams(LinkedHashMap<String, Object> linkedHashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, linkedHashMap) == null) {
            this.mParams = linkedHashMap;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mParams.size() : invokeV.intValue;
    }

    @Deprecated
    public void add(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.mParams.put(str, String.valueOf(i2));
        }
    }

    public void put(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            this.mParams.put(str, String.valueOf(i2));
        }
    }

    @Deprecated
    public void add(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            this.mParams.put(str, String.valueOf(j));
        }
    }

    public void put(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j) == null) {
            this.mParams.put(str, String.valueOf(j));
        }
    }

    @Deprecated
    public void add(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            this.mParams.put(str, obj.toString());
        }
    }

    public void put(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, bitmap) == null) {
            this.mParams.put(str, bitmap);
        }
    }

    public void put(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, obj) == null) {
            this.mParams.put(str, obj.toString());
        }
    }
}
