package ms.bd.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.util.ArrayMap;
import androidx.annotation.Keep;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.bytedance.JProtect;
import io.flutter.plugin.common.StandardMessageCodec;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes10.dex */
public final class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    @SuppressLint({"PrivateApi"})
    @JProtect
    public static Activity a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65536, null)) != null) {
            return (Activity) invokeV.objValue;
        }
        while (true) {
            char c2 = '`';
            while (true) {
                switch (c2) {
                    case '^':
                        try {
                            Class<?> cls = Class.forName((String) h.a(16777217, 0, 0L, "4fe283", new byte[]{36, 106, 18, 84, 8, UtilsBlink.VER_TYPE_SEPARATOR, 51, 9, 53, 114, 53, 42, 55, 69, 19, UtilsBlink.VER_TYPE_SEPARATOR, PublicSuffixDatabase.EXCEPTION_MARKER, 78, 32, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 17, 108, 4, 67, 6, 32}));
                            Object invoke = cls.getMethod((String) h.a(16777217, 0, 0L, "bfaa67", new byte[]{112, 113, 0, 7, StandardMessageCodec.LIST, 46, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 102, 51, 37, 122, 114, 27, 1, 16, 20, 105, 85, 53, 48, 119}), new Class[0]).invoke(null, new Object[0]);
                            Field declaredField = cls.getDeclaredField((String) h.a(16777217, 0, 0L, "f78c7f", new byte[]{122, 20, 72, 3, 1, 103, 108, 2, 96, 54, 100}));
                            declaredField.setAccessible(true);
                            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke);
                            if (map.size() < 1) {
                                return null;
                            }
                            for (Object obj : map.values()) {
                                Class<?> cls2 = obj.getClass();
                                Field declaredField2 = cls2.getDeclaredField((String) h.a(16777217, 0, 0L, "7c2557", new byte[]{54, 96, 84, 82, 15, 36}));
                                declaredField2.setAccessible(true);
                                if (!declaredField2.getBoolean(obj)) {
                                    Field declaredField3 = cls2.getDeclaredField((String) h.a(16777217, 0, 0L, "521641", new byte[]{37, 51, 86, 75, 29, 47, 34, 10}));
                                    declaredField3.setAccessible(true);
                                    return (Activity) declaredField3.get(obj);
                                }
                            }
                            return null;
                        } catch (Exception unused) {
                            String str = (String) h.a(16777217, 0, 0L, "7a3ed2", new byte[]{39, 106, ByteCompanionObject.MAX_VALUE, 22});
                            return null;
                        }
                    case '`':
                        c2 = '^';
                }
            }
        }
    }

    @Keep
    @JProtect
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return a() != null ? 1 : 0;
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i2 = 0; i2 < length; i2 += 2) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
