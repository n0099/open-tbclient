package d.a.m0.a.r0;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f48190a = "/aigames/sandbox/";

    /* renamed from: b  reason: collision with root package name */
    public static String f48191b;

    /* renamed from: c  reason: collision with root package name */
    public static String f48192c;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48193a;

        static {
            int[] iArr = new int[PathType.values().length];
            f48193a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48193a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static JsFunction A(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            Object obj = map.get(str);
            if (obj instanceof JsFunction) {
                return (JsFunction) obj;
            }
        }
        return null;
    }

    public static Map<String, JsFunction> B(JsObject jsObject) {
        if (jsObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            if (jsObject.getPropertyType(i2) == 8) {
                hashMap.put(jsObject.getPropertyName(i2), jsObject.toJsFunction(i2));
            }
        }
        return hashMap;
    }

    public static String C(String str, String str2, String str3, String str4) {
        return D(str, str2, str3, str4, false);
    }

    public static String D(String str, String str2, String str3, String str4, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return com.baidu.pass.biometrics.face.liveness.b.a.g0;
        }
        if (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str3 == null) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return String.format("%s \"%s\"", str, str3);
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        if (!z && TextUtils.isEmpty(str4)) {
            return String.format("%s, %s \"%s\"", str, str2, str3);
        }
        return String.format("%s, %s \"%s\" -> \"%s\"", str, str2, str3, str4);
    }

    @NonNull
    public static <T> T E(String str, Map<String, Object> map, @NonNull T t) {
        T t2;
        return (TextUtils.isEmpty(str) || map == null || (t2 = (T) map.get(str)) == null) ? t : t2;
    }

    public static String F(String str, Map<String, Object> map) {
        Object obj;
        if (TextUtils.isEmpty(str) || map == null || (obj = map.get(str)) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public static Map<String, Object> G(f fVar, JsObject jsObject, d.a.m0.a.r0.o.b bVar, String str) {
        if (jsObject != null && fVar != null && bVar != null) {
            Map<String, JsFunction> B = B(jsObject);
            if (B == null) {
                X(jsObject);
                return null;
            }
            Map<String, Object> j = j(jsObject);
            if (j == null) {
                X(jsObject);
                bVar.errMsg = str;
                k(B.get(com.baidu.pass.biometrics.face.liveness.b.a.g0), B.get(XAdRemoteEvent.COMPLETE), bVar, B.get("success"));
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str2 : B.keySet()) {
                hashMap.put(str2, B.get(str2));
            }
            for (String str3 : j.keySet()) {
                hashMap.put(str3, j.get(str3));
            }
            X(jsObject);
            return hashMap;
        }
        X(jsObject);
        return null;
    }

    public static String H(String str, int i2) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = "path";
        }
        switch (i2) {
            case 1:
                str2 = "Boolean;";
                break;
            case 2:
            case 3:
            case 5:
                str2 = "Number;";
                break;
            case 4:
            case 7:
            case 11:
            default:
                str2 = "NoSupport;";
                break;
            case 6:
                str2 = "Array;";
                break;
            case 8:
                str2 = "Function;";
                break;
            case 9:
                str2 = "Object;";
                break;
            case 10:
                str2 = "ArrayBuffer;";
                break;
            case 12:
                str2 = "Undefined;";
                break;
        }
        return "fail parameter error: parameter." + str + " should be String instead of " + str2;
    }

    public static String I(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(WebGLImageLoader.BDFILE)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bdfile://code");
        if (!str.startsWith(File.separator)) {
            str = File.separator + str;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String J(String str, String str2) {
        String w = w(AppRuntime.getAppContext());
        return w + File.separator + str + f48190a + str2;
    }

    public static String K(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                String n = n();
                if (TextUtils.isEmpty(n)) {
                    return null;
                }
                String substring = str.substring(9);
                if (substring.startsWith(File.separator)) {
                    return n + substring;
                }
                return n + File.separator + substring;
            }
        }
        return null;
    }

    public static int L(String str, JsObject jsObject) {
        if (jsObject != null && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                if (str.equals(jsObject.getPropertyName(i2))) {
                    return jsObject.getPropertyType(i2);
                }
            }
        }
        return 12;
    }

    public static String M(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(d.a.m0.a.r0.a.USER_DATA_PATH + File.separator) || d.a.m0.a.r0.a.USER_DATA_PATH.equals(str)) {
                String n = n();
                if (TextUtils.isEmpty(n)) {
                    return null;
                }
                String substring = str.substring(9);
                if (substring.startsWith(File.separator)) {
                    return n + substring;
                }
                return n + File.separator + substring;
            }
        }
        return null;
    }

    public static byte[] N(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4));
        }
        return bArr;
    }

    public static boolean O(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(Constants.PATH_PARENT);
        if (indexOf != 0) {
            return indexOf > 0;
        }
        String substring = str.substring(3);
        return !TextUtils.isEmpty(substring) && substring.contains(Constants.PATH_PARENT);
    }

    public static boolean P(f fVar, d.a.m0.a.l0.a aVar, JsObject jsObject, String str) {
        if (fVar == null || aVar == null) {
            if (jsObject == null && !TextUtils.isEmpty(str)) {
                d(aVar, str + "Object;");
            }
            X(jsObject);
            return false;
        }
        return true;
    }

    public static boolean Q(File file, File file2) {
        if (file == null || file2 == null) {
            return true;
        }
        if (file.isDirectory() && file2.isFile()) {
            return false;
        }
        return (file.isFile() && file2.isDirectory()) ? false : true;
    }

    public static boolean R(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bdfile://tmp");
        sb.append(File.separator);
        boolean z = str.startsWith(sb.toString()) || "bdfile://tmp".equals(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d.a.m0.a.r0.a.USER_DATA_PATH);
        sb2.append(File.separator);
        boolean z2 = str.startsWith(sb2.toString()) || d.a.m0.a.r0.a.USER_DATA_PATH.equals(str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("bdfile://code");
        sb3.append(File.separator);
        return (z || z2 || (str.startsWith(sb3.toString()) || "bdfile://code".equals(str))) && !O(str);
    }

    public static boolean S(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.m0.a.r0.a.USER_DATA_PATH);
        sb.append(File.separator);
        return (str.startsWith(sb.toString()) || d.a.m0.a.r0.a.USER_DATA_PATH.equals(str)) && !O(str);
    }

    public static void T(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str + "/tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str + "/usr");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(str + File.separator + "record.pro");
            if (!file3.exists()) {
                try {
                    file3.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            File file4 = new File(str2);
            if (file4.exists()) {
                return;
            }
            file4.mkdirs();
        }
    }

    public static String U(String str) {
        String y;
        int i2 = a.f48193a[d.a.m0.a.k2.b.s(str).ordinal()];
        if (i2 == 1) {
            y = y(str);
        } else if (i2 != 2) {
            y = str;
        } else {
            y = d.a.m0.a.g1.f.V().A() + str;
        }
        return TextUtils.isEmpty(y) ? str : y;
    }

    public static String V(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String n = n();
        if (TextUtils.isEmpty(n)) {
            return null;
        }
        String str2 = n + File.separator;
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return WebGLImageLoader.BDFILE + str.substring(str2.length());
        }
        return null;
    }

    public static void W(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }

    public static void X(JsObject jsObject) {
        if (jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public static void Y(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        W(jsFunction3);
    }

    public static void Z(d.a.m0.a.l0.a aVar, c cVar, JSExceptionType jSExceptionType, String str, String str2) {
        if (aVar == null) {
            return;
        }
        if (cVar == null) {
            aVar.throwJSException(jSExceptionType, str2 + str);
            return;
        }
        int i2 = cVar.f48050a;
        if (i2 != 0) {
            JSExceptionType z = z(i2);
            aVar.throwJSException(z, str2 + cVar.f48051b);
        }
    }

    public static boolean a(b bVar, d.a.m0.a.r0.o.b bVar2, Map<Integer, String> map, d.a.m0.a.l0.a aVar) {
        String str;
        Map<String, Object> map2;
        if (map != null) {
            for (Integer num : map.keySet()) {
                if (num.intValue() != 7) {
                    str = H(map.get(num), num.intValue());
                    break;
                }
            }
        }
        str = null;
        if (bVar2 == null || bVar == null || (map2 = bVar.f48049c) == null) {
            return false;
        }
        c cVar = bVar.f48047a;
        JsFunction A = A(com.baidu.pass.biometrics.face.liveness.b.a.g0, map2);
        JsFunction A2 = A(XAdRemoteEvent.COMPLETE, map2);
        JsFunction A3 = A("success", map2);
        if (!TextUtils.isEmpty(str)) {
            String str2 = bVar.f48048b + str;
            bVar2.errMsg = str2;
            d(aVar, str2);
            k(A, A2, bVar2, A3);
            return false;
        } else if (cVar == null) {
            bVar2.errMsg = bVar.f48048b + "unknown error";
            k(A, A2, bVar2, A3);
            return false;
        } else {
            bVar2.errMsg = bVar.f48048b + cVar.f48051b;
            if (cVar.f48050a != 0) {
                k(A, A2, bVar2, A3);
                return false;
            }
            return true;
        }
    }

    public static void b(Object obj, Map<String, Object> map) {
        Y(A("success", map), A(XAdRemoteEvent.COMPLETE, map), obj, A(com.baidu.pass.biometrics.face.liveness.b.a.g0, map));
    }

    public static void c() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        String w = w(appContext);
        String str = w + File.separator + "swangame/anonymous/sandbox";
        if (!TextUtils.isEmpty(str)) {
            d.a.m0.t.d.L(str);
        }
        String str2 = w + File.separator + f48192c + f48190a;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        d.a.m0.t.d.L(str2);
    }

    public static void d(d.a.m0.a.l0.a aVar, String str) {
        if (aVar == null || aVar.A() == null || TextUtils.isEmpty(str)) {
            return;
        }
        aVar.A().b(str);
    }

    public static void e(String str, String str2) {
        File file;
        try {
            new File(str2).mkdirs();
            String[] list = new File(str).list();
            for (int i2 = 0; i2 < list.length; i2++) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + list[i2]);
                } else {
                    file = new File(str + File.separator + list[i2]);
                }
                if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName());
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    d.a.m0.t.d.d(fileOutputStream);
                    d.a.m0.t.d.d(fileInputStream);
                }
                if (file.isDirectory()) {
                    e(str + "/" + list[i2], str2 + "/" + list[i2]);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean f(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void g(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            File file = new File(str);
            if (file.exists()) {
                d.a.m0.t.d.i(file);
            }
        }
    }

    public static boolean h(String str) {
        File[] listFiles;
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            boolean z = true;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile()) {
                    z = f(listFiles[i2].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = h(listFiles[i2].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                }
            }
            if (z) {
                return file.delete();
            }
            return false;
        }
        return false;
    }

    public static void i(String str) {
        String h2 = d.a.m0.a.c1.a.a0().h(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(h2)) {
            d.a.m0.t.d.L(J(h2, str));
            d.a.m0.t.d.L(J(d.a.m0.t.f.d(h2.getBytes(), false), str));
        }
        String i2 = d.a.m0.a.c1.a.a0().i(AppRuntime.getAppContext());
        if (!TextUtils.isEmpty(i2)) {
            d.a.m0.t.d.L(J(i2, str));
            d.a.m0.t.d.L(J(d.a.m0.t.f.d(i2.replace("|", "").getBytes(), false), str));
        }
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        String str2 = w(appContext) + File.separator + "swangame/anonymous/sandbox" + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        d.a.m0.t.d.L(str2);
    }

    public static Map<String, Object> j(JsObject jsObject) {
        Object valueOf;
        if (jsObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            int propertyType = jsObject.getPropertyType(i2);
            if (propertyType == 1) {
                valueOf = Boolean.valueOf(jsObject.toBoolean(i2));
            } else if (propertyType == 2) {
                valueOf = Integer.valueOf(jsObject.toInteger(i2));
            } else if (propertyType == 3) {
                valueOf = Long.valueOf(jsObject.toLong(i2));
            } else if (propertyType != 5) {
                valueOf = propertyType != 7 ? null : jsObject.toString(i2);
            } else {
                valueOf = Double.valueOf(jsObject.toDouble(i2));
            }
            if (valueOf != null) {
                hashMap.put(jsObject.getPropertyName(i2), valueOf);
            }
        }
        return hashMap;
    }

    public static void k(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        if (jsFunction != null) {
            jsFunction.call(obj);
        }
        if (jsFunction2 != null) {
            jsFunction2.call(obj);
        }
        W(jsFunction3);
        if (obj instanceof d.a.m0.a.r0.o.b) {
            d.a.m0.a.c1.b.j().b(((d.a.m0.a.r0.o.b) obj).errMsg);
        }
    }

    public static String l(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(new File(str));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr);
            for (int i2 = 0; i2 < available; i2++) {
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            d.a.m0.t.d.d(fileInputStream);
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            if (d.a.m0.a.k.f46983a) {
                e.printStackTrace();
            }
            d.a.m0.t.d.d(fileInputStream2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.m0.t.d.d(fileInputStream2);
            throw th;
        }
        return sb.toString();
    }

    public static List<String> m(String str, boolean z) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                arrayList.add(file.getAbsolutePath());
                return arrayList;
            }
            LinkedList linkedList = new LinkedList();
            File[] listFiles2 = file.listFiles();
            for (int i2 = 0; i2 < listFiles2.length; i2++) {
                if (listFiles2[i2] != null) {
                    if (listFiles2[i2].isDirectory()) {
                        linkedList.add(listFiles2[i2]);
                    }
                    if (z || listFiles2[i2].isFile()) {
                        arrayList.add(listFiles2[i2].getAbsolutePath());
                    }
                }
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.removeFirst();
                if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        if (listFiles[i3].isDirectory()) {
                            linkedList.add(listFiles[i3]);
                        }
                        if (z || listFiles[i3].isFile()) {
                            arrayList.add(listFiles[i3].getAbsolutePath());
                        }
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static String n() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String w = w(appContext);
        if (d.a.m0.a.a2.e.i() == null) {
            return w;
        }
        String V = d.a.m0.a.a2.e.V();
        return w + File.separator + "swangame/anonymous/sandbox" + File.separator + V;
    }

    public static byte[] o(String str) {
        BufferedInputStream bufferedInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 1024);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    d.a.m0.t.d.d(bufferedInputStream);
                    d.a.m0.t.d.d(byteArrayOutputStream);
                    return byteArray;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            d.a.m0.t.d.d(bufferedInputStream2);
            d.a.m0.t.d.d(byteArrayOutputStream);
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            d.a.m0.t.d.d(bufferedInputStream2);
            d.a.m0.t.d.d(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] p(JsObject jsObject) {
        if (jsObject == null) {
            return null;
        }
        for (int i2 = 0; i2 < jsObject.length(); i2++) {
            if (jsObject.getPropertyType(i2) == 10) {
                JsArrayBuffer jsArrayBuffer = jsObject.toJsArrayBuffer(i2);
                if (jsArrayBuffer != null) {
                    return jsArrayBuffer.buffer();
                }
                return null;
            }
        }
        return null;
    }

    public static String q(Context context) {
        return context == null ? "" : context.getCacheDir().getAbsolutePath();
    }

    public static String r() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return "";
        }
        String q = q(appContext);
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return q;
        }
        String V = d.a.m0.a.a2.e.V();
        String Z = i2.Z();
        String d2 = i2.j() != null ? i2.j().d() : "";
        String i3 = d.a.m0.a.c1.a.a0().i(appContext);
        StringBuilder sb = new StringBuilder();
        sb.append(q(appContext));
        sb.append(File.separator);
        if (TextUtils.isEmpty(d2)) {
            d2 = i3;
        }
        sb.append(d2);
        sb.append("/aigames/swancache/");
        sb.append(V);
        sb.append(File.separator);
        sb.append(Z);
        sb.append(File.separator);
        sb.append("code");
        return sb.toString();
    }

    @NonNull
    public static String[] s(String str, String str2) throws Exception {
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(str)) {
            strArr[0] = "";
            strArr[1] = str2;
            return strArr;
        }
        if (TextUtils.equals(str2, "hex")) {
            byte[] N = N(str);
            str = N == null ? "" : new String(N, "utf-8");
            str2 = "";
        }
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public static b t(c cVar, String str, Map<String, Object> map) {
        b bVar = new b();
        bVar.f48047a = cVar;
        bVar.f48048b = str;
        bVar.f48049c = map;
        return bVar;
    }

    public static String u(int i2) {
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3 || i2 == 5) {
                return "fail TypeError: data argument must not be a " + "Number;".toLowerCase();
            } else if (i2 == 6) {
                return "fail TypeError: data argument must not be a " + "Array;".toLowerCase();
            } else if (i2 == 8) {
                return "fail TypeError: data argument must not be a " + "Function;".toLowerCase();
            } else if (i2 != 9) {
                if (i2 != 12) {
                    return "";
                }
                return "fail TypeError: data argument must not be a " + "Undefined;".toLowerCase();
            }
        }
        return "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object";
    }

    public static c v(String str, String str2, String str3) {
        c cVar = new c();
        if (str == null) {
            cVar.f48051b = str3;
            cVar.f48050a = -2;
            return cVar;
        } else if ("".equals(str)) {
            cVar.f48051b = str2;
            cVar.f48050a = -1;
            return cVar;
        } else {
            return null;
        }
    }

    public static String w(Context context) {
        File externalFilesDir;
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(f48191b) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            f48191b = externalFilesDir.getAbsolutePath();
        }
        return f48191b;
    }

    public static long x(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0L;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long available = fileInputStream.available();
                d.a.m0.t.d.d(fileInputStream);
                return available;
            } catch (Exception unused) {
                fileInputStream2 = fileInputStream;
                d.a.m0.t.d.d(fileInputStream2);
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                d.a.m0.t.d.d(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(d.a.m0.a.r0.a.USER_DATA_PATH)) {
            return M(str);
        }
        return str.startsWith("bdfile://tmp") ? K(str) : "";
    }

    public static JSExceptionType z(int i2) {
        if (i2 != -5) {
            if (i2 != -4) {
                if (i2 != -3) {
                    if (i2 != -2) {
                        if (i2 != -1) {
                            return JSExceptionType.Error;
                        }
                        return JSExceptionType.Error;
                    }
                    return JSExceptionType.TypeError;
                }
                return JSExceptionType.SyntaxError;
            }
            return JSExceptionType.ReferenceError;
        }
        return JSExceptionType.RangeError;
    }
}
