package com.google.android.exoplayer2.drm;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ClearKeyUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern REQUEST_KIDS_PATTERN;
    public static final String TAG = "ClearKeyUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1057585881, "Lcom/google/android/exoplayer2/drm/ClearKeyUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1057585881, "Lcom/google/android/exoplayer2/drm/ClearKeyUtil;");
                return;
            }
        }
        REQUEST_KIDS_PATTERN = Pattern.compile("\"kids\":\\[\"(.*?)\"]");
    }

    public ClearKeyUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] adjustRequestData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (Util.SDK_INT >= 27) {
                return bArr;
            }
            String fromUtf8Bytes = Util.fromUtf8Bytes(bArr);
            Matcher matcher = REQUEST_KIDS_PATTERN.matcher(fromUtf8Bytes);
            if (!matcher.find()) {
                String str = "Failed to adjust request data: " + fromUtf8Bytes;
                return bArr;
            }
            int start = matcher.start(1);
            int end = matcher.end(1);
            StringBuilder sb = new StringBuilder(fromUtf8Bytes);
            base64ToBase64Url(sb, start, end);
            return Util.getUtf8Bytes(sb.toString());
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] adjustResponseData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (Util.SDK_INT >= 27) {
                return bArr;
            }
            try {
                JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr));
                JSONArray jSONArray = jSONObject.getJSONArray(SavedStateHandle.KEYS);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    jSONObject2.put("k", base64UrlToBase64(jSONObject2.getString("k")));
                    jSONObject2.put("kid", base64UrlToBase64(jSONObject2.getString("kid")));
                }
                return Util.getUtf8Bytes(jSONObject.toString());
            } catch (JSONException unused) {
                String str = "Failed to adjust response data: " + Util.fromUtf8Bytes(bArr);
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static void base64ToBase64Url(StringBuilder sb, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, sb, i2, i3) == null) {
            while (i2 < i3) {
                char charAt = sb.charAt(i2);
                if (charAt == '+') {
                    sb.setCharAt(i2, SignatureImpl.SEP);
                } else if (charAt == '/') {
                    sb.setCharAt(i2, '_');
                }
                i2++;
            }
        }
    }

    public static String base64UrlToBase64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? str.replace(SignatureImpl.SEP, '+').replace('_', WebvttCueParser.CHAR_SLASH) : (String) invokeL.objValue;
    }
}
