package d.a.c0.a.j;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            c(file, true);
        }
    }

    public static void c(File file, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65538, null, file, z) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        c(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file != null && file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, file) == null) {
            if (file.isDirectory()) {
                b(file);
            } else {
                d(file);
            }
        }
    }

    public static boolean f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) ? file != null && file.exists() && file.isFile() : invokeL.booleanValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                inputStreamReader = new InputStreamReader(context.getAssets().open(str));
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                a(bufferedReader);
                                a(inputStreamReader);
                                return sb.toString();
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                a(bufferedReader);
                                a(inputStreamReader);
                                throw th;
                            }
                        }
                        a(bufferedReader2);
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
            a(inputStreamReader);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    public static String h(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        ?? f2 = f(file);
        FileInputStream fileInputStream2 = null;
        try {
            if (f2 != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String b2 = g.b(fileInputStream);
                        g.a(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return b2;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        g.a(fileInputStream);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    g.a(fileInputStream2);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = f2;
        }
    }
}
