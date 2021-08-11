package ms.bd.c;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.bytedance.JProtect;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes2.dex */
public class x1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f78904a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737210726, "Lms/bd/c/x1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737210726, "Lms/bd/c/x1;");
                return;
            }
        }
        String str = (String) h.a(16777217, 0, 0L, "fbd40a", new byte[]{76, 60, 86, 30, 50});
        f78904a = (String) h.a(16777217, 0, 0L, "85f2a9", new byte[]{39, 51});
    }

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (x1.class) {
                try {
                    String str = context.getFilesDir().getAbsolutePath() + ((String) h.a(16777217, 0, 0L, "a9cb55", new byte[]{63})) + f78904a;
                    if (!new File(str).exists() || (a2 = a(str)) == null || a2.length() <= 0) {
                        InputStream open = context.getResources().getAssets().open(f78904a);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = open.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.close();
                        a(((String) h.a(16777217, 0, 0L, "7f1b54", new byte[]{37, 108, 79, 25, 14, 99, 99, 16, 55, 114})) + str);
                        String a3 = a(str);
                        if (a3 == null || a3.length() == 0) {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(str, (String) h.a(16777217, 0, 0L, "6c7458", new byte[]{53, 118}));
                            randomAccessFile.seek(16L);
                            randomAccessFile.write(new byte[]{2});
                            randomAccessFile.close();
                            a3 = a(str);
                        }
                        if (a3 == null || a3.length() == 0) {
                            a3 = (String) h.a(16777217, 0, 0L, "8811bd", new byte[]{121, 1, 30, 4, 3, 78, 30, 43, 82, 78, 27, 1, 30, 4, 3, 78});
                        }
                        return a3;
                    }
                    return a2;
                }
            }
        }
        return (String) invokeL.objValue;
    }

    @Keep
    @JProtect
    public static String a(BufferedInputStream bufferedInputStream) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bufferedInputStream)) == null) {
            if (bufferedInputStream == null) {
                return "";
            }
            byte[] bArr = new byte[4096];
            StringBuilder sb = new StringBuilder();
            do {
                try {
                    read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                        continue;
                    }
                } catch (Exception unused) {
                    String str = (String) h.a(16777217, 0, 0L, "afc3cf", new byte[]{LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 109, 19});
                }
            } while (read >= 4096);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0094 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0101 */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0101, code lost:
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.BufferedInputStream] */
    @Keep
    @JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        Process process;
        ?? r0;
        ?? r14;
        ?? r7;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        char c2 = 'R';
        while (true) {
            switch (c2) {
                case 'P':
                case 'Q':
                    BufferedOutputStream bufferedOutputStream3 = null;
                    try {
                        process = Runtime.getRuntime().exec((String) h.a(16777217, 0, 0L, "5898c6", new byte[]{55, 50}));
                        try {
                            bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                        } catch (Exception unused) {
                            r14 = 0;
                            r7 = 0;
                            try {
                                String str2 = (String) h.a(16777217, 0, 0L, "5708e4", new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 60, 64, 115, 95});
                                if (bufferedOutputStream3 != null) {
                                }
                                if (r7 != 0) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream3;
                                bufferedOutputStream3 = r7;
                                r0 = bufferedOutputStream3;
                                bufferedOutputStream3 = bufferedOutputStream;
                                if (bufferedOutputStream3 != null) {
                                    try {
                                        bufferedOutputStream3.close();
                                    } catch (IOException unused2) {
                                        String str3 = (String) h.a(16777217, 0, 0L, "cfdef3", new byte[]{119, 109, 20, 46, 92});
                                    }
                                }
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException unused3) {
                                        String str4 = (String) h.a(16777217, 0, 0L, "9349d6", new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 56, 68, 114, 94});
                                    }
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r0 = 0;
                            if (bufferedOutputStream3 != null) {
                            }
                            if (r0 != 0) {
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    } catch (Exception unused4) {
                        process = null;
                    } catch (Throwable th3) {
                        th = th3;
                        process = null;
                    }
                    try {
                        r7 = new BufferedInputStream(process.getInputStream());
                        try {
                            try {
                                bufferedOutputStream.write(str.getBytes());
                                bufferedOutputStream.write(10);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                process.waitFor();
                                r14 = a((BufferedInputStream) r7);
                                if (r14 != 0) {
                                    try {
                                        r14.length();
                                    } catch (Exception unused5) {
                                        bufferedOutputStream3 = r14;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        obj = r7;
                                        bufferedOutputStream3 = bufferedOutputStream;
                                        r7 = obj;
                                        r14 = bufferedOutputStream2;
                                        String str22 = (String) h.a(16777217, 0, 0L, "5708e4", new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 60, 64, 115, 95});
                                        if (bufferedOutputStream3 != null) {
                                            try {
                                                bufferedOutputStream3.close();
                                            } catch (IOException unused6) {
                                                String str5 = (String) h.a(16777217, 0, 0L, "454815", new byte[]{32, 62, 68, 115, 11});
                                            }
                                        }
                                        if (r7 != 0) {
                                            try {
                                                r7.close();
                                                break;
                                            } catch (IOException unused7) {
                                                String str6 = (String) h.a(16777217, 0, 0L, "e866a8", new byte[]{113, 51, 70, 125, 91});
                                                break;
                                            }
                                        }
                                    }
                                }
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused8) {
                                    String str7 = (String) h.a(16777217, 0, 0L, "891070", new byte[]{44, 50, 65, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 13});
                                }
                                try {
                                    r7.close();
                                } catch (IOException unused9) {
                                    String str8 = (String) h.a(16777217, 0, 0L, "18b2b3", new byte[]{37, 51, 18, 121, 88});
                                }
                            } catch (Exception unused10) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream3 = r7;
                            r0 = bufferedOutputStream3;
                            bufferedOutputStream3 = bufferedOutputStream;
                            if (bufferedOutputStream3 != null) {
                            }
                            if (r0 != 0) {
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    } catch (Exception unused11) {
                        bufferedOutputStream2 = null;
                        obj = null;
                    } catch (Throwable th5) {
                        th = th5;
                        r0 = bufferedOutputStream3;
                        bufferedOutputStream3 = bufferedOutputStream;
                        if (bufferedOutputStream3 != null) {
                        }
                        if (r0 != 0) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                    process.destroy();
                    return r14;
                case 'R':
                default:
                    c2 = 'P';
            }
        }
    }
}
