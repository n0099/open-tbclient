package ms.bd.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import ms.bd.c.b;
/* loaded from: classes2.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b.a(65537, new c());
            b.a(65538, new d());
            b.a(65539, new e());
            b.a((int) InputDeviceCompat.SOURCE_TRACKBALL, new f());
            b.a aVar = b0.c() ? new c.b.b.a.a.a() : new c.b.b.a.a.c();
            b.a(196609, aVar);
            b.a(196610, aVar);
            b.a(196611, aVar);
            j kVar = b0.a() ? new k() : new i();
            j.f(kVar);
            b.a(131073, kVar);
            b.a(131074, kVar);
        }
    }

    public static boolean c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) != null) {
            return invokeLLL.booleanValue;
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append((String) h.a(16777217, 0, 0L, "3ed9fb", new byte[]{109}));
                    sb.append(str3);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append((String) h.a(16777217, 0, 0L, "cd136d", new byte[]{61}));
                    sb3.append(str3);
                    c(context, sb2, sb3.toString());
                }
                return true;
            }
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            String str4 = (String) h.a(16777217, 0, 0L, "10d524", new byte[]{Base64.INTERNAL_PADDING, 51, 17});
            return false;
        }
    }
}
