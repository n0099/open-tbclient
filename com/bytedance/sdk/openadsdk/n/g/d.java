package com.bytedance.sdk.openadsdk.n.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.openadsdk.n.e;
import com.bytedance.sdk.openadsdk.n.e.f;
import com.bytedance.sdk.openadsdk.n.i;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f68613a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f68614b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291967019, "Lcom/bytedance/sdk/openadsdk/n/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-291967019, "Lcom/bytedance/sdk/openadsdk/n/g/d;");
                return;
            }
        }
        f68614b = new Handler(Looper.getMainLooper());
        f68613a = Charset.forName("UTF-8");
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) ? a(str, 0) : invokeL.intValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? str != null && (str.startsWith(FileUtils.VIDEO_FILE_START) || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str)) : invokeL.booleanValue;
    }

    public static int[] d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new int[0];
            }
            String[] split = str.split(",");
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    iArr[i2] = Integer.parseInt(split[i2]);
                } catch (Exception unused) {
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static void a(ServerSocket serverSocket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, serverSocket) == null) || serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (Throwable unused) {
        }
    }

    public static String b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65557, null, i2, i3)) == null) {
            if (i2 >= 0 && i3 > 0) {
                return i2 + "-" + i3;
            } else if (i2 > 0) {
                return i2 + "-";
            } else if (i2 >= 0 || i3 <= 0) {
                return null;
            } else {
                return "-" + i3;
            }
        }
        return (String) invokeII.objValue;
    }

    public static void a(Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, socket) == null) || socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, randomAccessFile) == null) || randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? Thread.currentThread() == Looper.getMainLooper().getThread() : invokeV.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? str != null && (str.startsWith("http://") || str.startsWith("https://")) : invokeL.booleanValue;
    }

    public static String b(List<i.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                i.b bVar = list.get(0);
                if (bVar != null) {
                    sb.append(bVar.f68627a);
                    sb.append(": ");
                    sb.append(bVar.f68628b);
                    sb.append(Part.CRLF);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static String a(com.bytedance.sdk.openadsdk.n.e.a aVar, int i2) {
        InterceptResult invokeLI;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, aVar, i2)) == null) {
            if (aVar == null || !aVar.b()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.e().toUpperCase());
            sb.append(' ');
            sb.append(aVar.a());
            sb.append(' ');
            sb.append(aVar.f());
            sb.append(Part.CRLF);
            if (e.f68533c) {
                String str = aVar.e().toUpperCase() + " " + aVar.a() + " " + aVar.f();
            }
            List<i.b> a3 = a(aVar.c());
            boolean z = true;
            if (a3 != null) {
                int size = a3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    i.b bVar = a3.get(i3);
                    if (bVar != null) {
                        String str2 = bVar.f68627a;
                        String str3 = bVar.f68628b;
                        sb.append(str2);
                        sb.append(": ");
                        sb.append(str3);
                        sb.append(Part.CRLF);
                        if ("Content-Range".equalsIgnoreCase(str2) || (Util.ACCEPT_RANGES.equalsIgnoreCase(str2) && "bytes".equalsIgnoreCase(str3))) {
                            z = false;
                        }
                    }
                }
            }
            if (z && (a2 = a(aVar)) > 0) {
                sb.append("Content-Range: bytes ");
                sb.append(Math.max(i2, 0));
                sb.append("-");
                sb.append(a2 - 1);
                sb.append("/");
                sb.append(a2);
                sb.append(Part.CRLF);
            }
            sb.append("Connection: close");
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            String sb2 = sb.toString();
            boolean z2 = e.f68533c;
            return sb2;
        }
        return (String) invokeLI.objValue;
    }

    public static String b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, map)) == null) {
            if (map == null || map.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append(": ");
                sb.append((Object) entry.getValue());
                sb.append(Part.CRLF);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            String b2 = b(i2, i3);
            if (b2 == null) {
                return null;
            }
            return "bytes=" + b2;
        }
        return (String) invokeII.objValue;
    }

    public static List<String> a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, strArr)) == null) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (a(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String a(com.bytedance.sdk.openadsdk.n.b.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, aVar, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (i2 <= 0) {
                sb.append("HTTP/1.1 200 OK");
                sb.append(Part.CRLF);
            } else {
                sb.append("HTTP/1.1 206 Partial Content");
                sb.append(Part.CRLF);
            }
            sb.append("Accept-Ranges: bytes");
            sb.append(Part.CRLF);
            sb.append(Part.CONTENT_TYPE);
            sb.append(aVar.f68480b);
            sb.append(Part.CRLF);
            if (i2 <= 0) {
                sb.append("Content-Length: ");
                sb.append(aVar.f68481c);
                sb.append(Part.CRLF);
            } else {
                sb.append("Content-Range: bytes ");
                sb.append(i2);
                sb.append("-");
                sb.append(aVar.f68481c - 1);
                sb.append("/");
                sb.append(aVar.f68481c);
                sb.append(Part.CRLF);
                sb.append("Content-Length: ");
                sb.append(aVar.f68481c - i2);
                sb.append(Part.CRLF);
            }
            sb.append("Connection: close");
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            String sb2 = sb.toString();
            boolean z = e.f68533c;
            return sb2;
        }
        return (String) invokeLI.objValue;
    }

    public static int a() {
        InterceptResult invokeV;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            try {
                File file = new File("/sys/devices/system/cpu/");
                if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.n.g.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public Pattern f68615a;

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
                                return;
                            }
                        }
                        this.f68615a = Pattern.compile("^cpu[0-9]+$");
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str)) == null) ? this.f68615a.matcher(str).matches() : invokeLL.booleanValue;
                    }
                })) == null) {
                    return 1;
                }
                return Math.max(listFiles.length, 1);
            } catch (Throwable unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static int a(com.bytedance.sdk.openadsdk.n.e.a aVar) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar == null) {
                return -1;
            }
            if (aVar.a() == 200) {
                return a(aVar.a("Content-Length", null), -1);
            }
            if (aVar.a() == 206) {
                String a2 = aVar.a("Content-Range", null);
                if (!TextUtils.isEmpty(a2) && (lastIndexOf = a2.lastIndexOf("/")) >= 0 && lastIndexOf < a2.length() - 1) {
                    return a(a2.substring(lastIndexOf + 1), -1);
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String a(com.bytedance.sdk.openadsdk.n.e.a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null) {
                boolean z3 = e.f68533c;
                return "response null";
            } else if (!aVar.b()) {
                if (e.f68533c) {
                    String str = "response code: " + aVar.a();
                }
                return "response code: " + aVar.a();
            } else {
                String a3 = aVar.a("Content-Type", null);
                if (!c(a3)) {
                    if (e.f68533c) {
                        String str2 = Part.CONTENT_TYPE + a3;
                    }
                    return Part.CONTENT_TYPE + a3;
                }
                int a4 = a(aVar);
                if (a4 <= 0) {
                    if (e.f68533c) {
                        String str3 = "Content-Length: " + a4;
                    }
                    return "Content-Length: " + a4;
                } else if (z && ((a2 = aVar.a(Util.ACCEPT_RANGES, null)) == null || !a2.contains("bytes"))) {
                    if (e.f68533c) {
                        String str4 = "Accept-Ranges: " + a2;
                    }
                    return "Accept-Ranges: " + a2;
                } else if (z2 && aVar.d() == null) {
                    boolean z4 = e.f68533c;
                    return "response body null";
                } else {
                    return null;
                }
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, gVar) == null) || gVar == null) {
            return;
        }
        if (b()) {
            com.bytedance.sdk.component.d.e.a(gVar);
            boolean z = e.f68533c;
            return;
        }
        gVar.run();
        boolean z2 = e.f68533c;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, runnable) == null) || runnable == null) {
            return;
        }
        if (b()) {
            runnable.run();
        } else {
            f68614b.post(runnable);
        }
    }

    public static List<i.b> a(List<i.b> list) {
        InterceptResult invokeL;
        i.b bVar;
        i.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return null;
            }
            if (e.f68533c) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) != null) {
                        String str = bVar2.f68627a + ": " + bVar2.f68627a;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (i.b bVar3 : list) {
                if ("Host".equals(bVar3.f68627a) || HTTP.CONN_KEEP_ALIVE.equals(bVar3.f68627a) || HTTP.CONN_DIRECTIVE.equals(bVar3.f68627a) || "Proxy-Connection".equals(bVar3.f68627a)) {
                    arrayList.add(bVar3);
                }
            }
            list.removeAll(arrayList);
            if (e.f68533c) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (list.get(i3) != null) {
                        String str2 = bVar.f68627a + ": " + bVar.f68628b;
                    }
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static List<i.b> a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
            if (map != null && !map.isEmpty()) {
                try {
                    Set<Map.Entry<String, String>> entrySet = map.entrySet();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : entrySet) {
                        arrayList.add(new i.b(entry.getKey(), entry.getValue()));
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.n.b.a a(com.bytedance.sdk.openadsdk.n.e.a aVar, com.bytedance.sdk.openadsdk.n.b.c cVar, String str, int i2) {
        InterceptResult invokeLLLI;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, cVar, str, i2)) == null) {
            com.bytedance.sdk.openadsdk.n.b.a a2 = cVar.a(str, i2);
            if (a2 == null) {
                int a3 = a(aVar);
                String a4 = aVar.a("Content-Type", null);
                if (a3 <= 0 || TextUtils.isEmpty(a4)) {
                    return a2;
                }
                f g2 = aVar.g();
                if (g2 != null) {
                    str3 = g2.f68546b;
                    str2 = b(g2.f68549e);
                } else {
                    str2 = "";
                    str3 = str2;
                }
                String b2 = b(aVar.c());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str3);
                    jSONObject.put("requestHeaders", str2);
                    jSONObject.put("responseHeaders", b2);
                    str4 = jSONObject.toString();
                } catch (Throwable unused) {
                    str4 = "";
                }
                com.bytedance.sdk.openadsdk.n.b.a aVar2 = new com.bytedance.sdk.openadsdk.n.b.a(str, a4, a3, i2, str4);
                cVar.a(aVar2);
                return aVar2;
            }
            return a2;
        }
        return (com.bytedance.sdk.openadsdk.n.b.a) invokeLLLI.objValue;
    }

    public static String a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iArr)) == null) {
            if (iArr == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 < iArr.length - 1) {
                    stringBuffer.append(iArr[i2] + ",");
                } else {
                    stringBuffer.append(iArr[i2]);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
