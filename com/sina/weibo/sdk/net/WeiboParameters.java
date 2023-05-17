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
/* loaded from: classes9.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mParams = new LinkedHashMap<>();
        this.mAppKey = str;
    }

    @Deprecated
    public void add(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            this.mParams.put(str, String.valueOf(i));
        }
    }

    public void put(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i) == null) {
            this.mParams.put(str, String.valueOf(i));
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

    @Deprecated
    public void add(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.mParams.put(str, str2);
        }
    }

    public void put(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, obj) == null) {
            this.mParams.put(str, obj.toString());
        }
    }

    public boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.mParams.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public boolean containsValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.mParams.containsValue(str);
        }
        return invokeL.booleanValue;
    }

    public Object get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return this.mParams.get(str);
        }
        return invokeL.objValue;
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
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getAnonymousCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAnonymousCookie;
        }
        return (String) invokeV.objValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mAppKey;
        }
        return (String) invokeV.objValue;
    }

    public LinkedHashMap<String, Object> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mParams;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mParams.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mParams.size();
        }
        return invokeV.intValue;
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

    public void put(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            this.mParams.put(str, str2);
        }
    }
}
