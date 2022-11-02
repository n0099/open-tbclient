package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@VisibleForTesting
@KeepForSdk
/* loaded from: classes7.dex */
public final class JsonUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern zza;
    public static final Pattern zzb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-594303943, "Lcom/google/android/gms/common/util/JsonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-594303943, "Lcom/google/android/gms/common/util/JsonUtils;");
                return;
            }
        }
        zza = Pattern.compile("\\\\.");
        zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }

    public JsonUtils() {
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

    @KeepForSdk
    public static boolean areJsonValuesEquivalent(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, obj2)) == null) {
            if (obj == null && obj2 == null) {
                return true;
            }
            if (obj == null || obj2 == null) {
                return false;
            }
            if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) obj;
                JSONObject jSONObject2 = (JSONObject) obj2;
                if (jSONObject.length() != jSONObject2.length()) {
                    return false;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject2.has(next)) {
                        return false;
                    }
                    try {
                        Preconditions.checkNotNull(next);
                    } catch (JSONException unused) {
                    }
                    if (!areJsonValuesEquivalent(jSONObject.get(next), jSONObject2.get(next))) {
                        return false;
                    }
                }
                return true;
            } else if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) obj;
                JSONArray jSONArray2 = (JSONArray) obj2;
                if (jSONArray.length() != jSONArray2.length()) {
                    return false;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                return obj.equals(obj2);
            }
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    @KeepForSdk
    public static String escapeString(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = zzb.matcher(str);
                StringBuffer stringBuffer = null;
                while (matcher.find()) {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer();
                    }
                    char charAt = matcher.group().charAt(0);
                    if (charAt != '\f') {
                        if (charAt != '\r') {
                            if (charAt != '\"') {
                                if (charAt != '/') {
                                    if (charAt != '\\') {
                                        switch (charAt) {
                                            case '\b':
                                                matcher.appendReplacement(stringBuffer, "\\\\b");
                                                continue;
                                            case '\t':
                                                matcher.appendReplacement(stringBuffer, "\\\\t");
                                                continue;
                                            case '\n':
                                                matcher.appendReplacement(stringBuffer, "\\\\n");
                                                continue;
                                        }
                                    } else {
                                        matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                                    }
                                } else {
                                    matcher.appendReplacement(stringBuffer, "\\\\/");
                                }
                            } else {
                                matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                            }
                        } else {
                            matcher.appendReplacement(stringBuffer, "\\\\r");
                        }
                    } else {
                        matcher.appendReplacement(stringBuffer, "\\\\f");
                    }
                }
                if (stringBuffer == null) {
                    return str;
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static String unescapeString(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String zza2 = zzc.zza(str);
                Matcher matcher = zza.matcher(zza2);
                StringBuffer stringBuffer = null;
                while (matcher.find()) {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer();
                    }
                    char charAt = matcher.group().charAt(1);
                    if (charAt != '\"') {
                        if (charAt != '/') {
                            if (charAt != '\\') {
                                if (charAt != 'b') {
                                    if (charAt != 'f') {
                                        if (charAt != 'n') {
                                            if (charAt != 'r') {
                                                if (charAt == 't') {
                                                    matcher.appendReplacement(stringBuffer, "\t");
                                                } else {
                                                    throw new IllegalStateException("Found an escaped character that should never be.");
                                                }
                                            } else {
                                                matcher.appendReplacement(stringBuffer, "\r");
                                            }
                                        } else {
                                            matcher.appendReplacement(stringBuffer, "\n");
                                        }
                                    } else {
                                        matcher.appendReplacement(stringBuffer, "\f");
                                    }
                                } else {
                                    matcher.appendReplacement(stringBuffer, "\b");
                                }
                            } else {
                                matcher.appendReplacement(stringBuffer, "\\\\");
                            }
                        } else {
                            matcher.appendReplacement(stringBuffer, "/");
                        }
                    } else {
                        matcher.appendReplacement(stringBuffer, "\"");
                    }
                }
                if (stringBuffer == null) {
                    return zza2;
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
