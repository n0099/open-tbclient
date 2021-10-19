package ms.bd.c;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.JProtect;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
@Keep
@JProtect
/* loaded from: classes2.dex */
public class v1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f79694a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737208804, "Lms/bd/c/v1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737208804, "Lms/bd/c/v1;");
                return;
            }
        }
        f79694a = (String) h.a(16777217, 0, 0L, "ac2d00", new byte[]{126, 96, 15, 19, 21, 43});
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context) {
        InterceptResult invokeL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return invokeL.intValue;
        }
        int i2 = 255;
        int i3 = 3;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            String str = context.getFilesDir().getAbsolutePath() + ((String) h.a(16777217, 0, 0L, "eacb92", new byte[]{59})) + f79694a;
            File file = new File(str);
            if (file.exists()) {
                try {
                    file.delete();
                    i2 = 2;
                } catch (Throwable unused) {
                    inputStream = null;
                    i2 = 2;
                    try {
                        String str2 = (String) h.a(16777217, 0, 0L, "d8d197", new byte[]{116, 57, 40, 66});
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
            }
            inputStream = context.getResources().getAssets().open(f79694a);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                    fileOutputStream.close();
                    if (byteArrayOutputStream2.size() > 0) {
                        i3 = new File(str).exists() ? 0 : i2;
                    }
                    try {
                        inputStream.close();
                    } catch (Throwable unused4) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Throwable unused5) {
                        }
                        return i3;
                    }
                } catch (Throwable unused6) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    String str22 = (String) h.a(16777217, 0, 0L, "d8d197", new byte[]{116, 57, 40, 66});
                    if (byteArrayOutputStream == null) {
                        i3 = i2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        byteArrayOutputStream2.close();
                        return i3;
                    }
                    return i2;
                }
            } catch (Throwable unused7) {
            }
        } catch (Throwable unused8) {
            inputStream = null;
        }
    }
}
