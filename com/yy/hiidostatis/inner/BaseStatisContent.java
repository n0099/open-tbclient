package com.yy.hiidostatis.inner;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class BaseStatisContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACT = "act";
    public static final String APPID = "app";
    public static final String APPKEY = "appkey";
    public static final String ARID = "arid";
    public static final String AUTOID = "hd_autoid";
    public static final String BDCUID = "bdcuid";
    public static final String CHANNEL = "chn";
    public static final Comparator<String> COMPARATOR;
    public static final String CREPID = "hd_crepid";
    public static final String CURPID = "hd_curpid";
    public static final String FROM = "from";
    public static final String GUID = "guid";
    public static final String HDID = "hdid";
    public static final String IDFV = "idfv";
    public static final String IMC = "imc";
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String KEY = "key";
    public static final String MAC = "mac";
    public static final String MBL = "mbl";
    public static final String MBOS = "mbos";
    public static final String MDSR = "mdsr";
    public static final String NET = "net";
    public static final String NTM = "ntm";
    public static final String OAID = "oaid";
    public static final String OPID = "opid";
    public static final String PACKID = "hd_packid";
    public static final String REMAIN = "hd_remain";
    public static final String SDKVER = "sdkver";
    public static final String SESSIONID = "sessionid";
    public static final String SJM = "sjm";
    public static final String SJP = "sjp";
    public static final String SR = "sr";
    public static final String SYS = "sys";
    public static final String TIME = "time";
    public static final String TIMEZONE = "timezone";
    public static final String VER = "ver";
    public transient /* synthetic */ FieldHolder $fh;
    public TreeMap<String, String> raw;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1292266077, "Lcom/yy/hiidostatis/inner/BaseStatisContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1292266077, "Lcom/yy/hiidostatis/inner/BaseStatisContent;");
                return;
            }
        }
        COMPARATOR = new Comparator<String>() { // from class: com.yy.hiidostatis.inner.BaseStatisContent.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    boolean equals = "act".equals(str);
                    boolean equals2 = "act".equals(str2);
                    if (equals || equals2) {
                        if (equals || !equals2) {
                            if (!equals || equals2) {
                                if (!equals || equals2) {
                                }
                                return 0;
                            }
                            return -1;
                        }
                        return 1;
                    }
                    return str.compareTo(str2);
                }
                return invokeLL.intValue;
            }
        };
    }

    public BaseStatisContent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.raw = new TreeMap<>(COMPARATOR);
    }

    public boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.raw.containsKey(str) : invokeL.booleanValue;
    }

    public BaseStatisContent copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseStatisContent baseStatisContent = new BaseStatisContent();
            TreeMap<String, String> treeMap = new TreeMap<>(COMPARATOR);
            baseStatisContent.raw = treeMap;
            treeMap.putAll(this.raw);
            return baseStatisContent;
        }
        return (BaseStatisContent) invokeV.objValue;
    }

    public String get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.raw.get(str) : (String) invokeL.objValue;
    }

    public synchronized String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.raw.entrySet()) {
                    String value = entry.getValue();
                    if (Util.empty(value)) {
                        L.verbose(this, "No value for key %s", entry.getKey());
                    } else {
                        sb.append(entry.getKey());
                        sb.append("=");
                        try {
                            sb.append(URLEncoder.encode(value, "UTF-8"));
                        } catch (UnsupportedEncodingException unused) {
                            L.debug(this, "encoding fail for key %s", entry.getKey());
                        }
                        sb.append("&");
                    }
                }
                if (sb.length() == 0) {
                    L.debug(this, "Warn : http content may be null?", new Object[0]);
                    return null;
                }
                if (sb.length() > 0) {
                    sb.append("hd_p=E&");
                }
                sb.replace(sb.length() - 1, sb.length(), "");
                String sb2 = sb.toString();
                sb.setLength(0);
                return sb2;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.raw.isEmpty() : invokeV.booleanValue;
    }

    public String put(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) ? put(str, String.valueOf(i2)) : (String) invokeLI.objValue;
    }

    public synchronized void putContent(BaseStatisContent baseStatisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, baseStatisContent, z) == null) {
            synchronized (this) {
                if (baseStatisContent != null) {
                    if (!baseStatisContent.isEmpty()) {
                        for (Map.Entry<String, String> entry : baseStatisContent.raw.entrySet()) {
                            if (z) {
                                String put = put(entry.getKey(), entry.getValue());
                                if (put != null) {
                                    L.brief("value-cover:isCover=%b,key=%s,old-value=%s,new-value=%s", Boolean.valueOf(z), entry.getKey(), put, entry.getValue());
                                }
                            } else if (containsKey(entry.getKey())) {
                                L.brief("value-cover:isCover=%b,key=%s,old-value=%s,new-value=%s,ignore-value=%s", Boolean.valueOf(z), entry.getKey(), get(entry.getKey()), get(entry.getKey()), entry.getValue());
                            } else {
                                put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getContent() : (String) invokeV.objValue;
    }

    public String put(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) ? put(str, String.valueOf(j)) : (String) invokeLJ.objValue;
    }

    public String put(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Double.valueOf(d2)})) == null) ? put(str, String.valueOf(d2)) : (String) invokeCommon.objValue;
    }

    public synchronized String put(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            synchronized (this) {
                if (Util.empty(str)) {
                    L.debug("BaseStatisContent", "key is invalid for value %s", str2);
                    return null;
                }
                return this.raw.put(str, Util.asEmptyOnNull(str2));
            }
        }
        return (String) invokeLL.objValue;
    }

    public synchronized String put(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048585, this, str, str2, z)) == null) {
            synchronized (this) {
                if (Util.empty(str)) {
                    L.debug("BaseStatisContent", "key is invalid for value %s", str2);
                    return null;
                }
                String asEmptyOnNull = Util.asEmptyOnNull(str2);
                if (z) {
                    return this.raw.put(str, asEmptyOnNull);
                }
                if (this.raw.containsKey(str)) {
                    return this.raw.get(str);
                }
                return this.raw.put(str, asEmptyOnNull);
            }
        }
        return (String) invokeLLZ.objValue;
    }
}
