package com.google.android.gms.common.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class HttpUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern zza;
    public static final Pattern zzb;
    public static final Pattern zzc;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109606951, "Lcom/google/android/gms/common/util/HttpUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-109606951, "Lcom/google/android/gms/common/util/HttpUtils;");
                return;
            }
        }
        zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public HttpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Map parse(URI uri, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uri, str)) == null) {
            Map emptyMap = Collections.emptyMap();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null && rawQuery.length() > 0) {
                emptyMap = new HashMap();
                zzx zzc2 = zzx.zzc(zzo.zzb('='));
                for (String str3 : zzx.zzc(zzo.zzb('&')).zzb().zzd(rawQuery)) {
                    List zzf = zzc2.zzf(str3);
                    if (!zzf.isEmpty() && zzf.size() <= 2) {
                        String zza2 = zza((String) zzf.get(0), str);
                        if (zzf.size() == 2) {
                            str2 = zza((String) zzf.get(1), str);
                        } else {
                            str2 = null;
                        }
                        emptyMap.put(zza2, str2);
                    } else {
                        throw new IllegalArgumentException("bad parameter");
                    }
                }
            }
            return emptyMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static String zza(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "ISO-8859-1";
            }
            try {
                return URLDecoder.decode(str, str2);
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return (String) invokeLL.objValue;
    }
}
