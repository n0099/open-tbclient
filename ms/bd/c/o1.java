package ms.bd.c;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.bytedance.JProtect;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONObject;
@Keep
@JProtect
/* loaded from: classes2.dex */
public class o1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f79629a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f79630b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f79631c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f79632d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f79633e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f79634f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f79635g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f79636h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f79637i;

    /* renamed from: j  reason: collision with root package name */
    public static final FileFilter f79638j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? Pattern.matches((String) h.a(16777217, 0, 0L, "c6c6be", new byte[]{113, 36, 5, 121, 13, 63, 57, 42}), file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737202077, "Lms/bd/c/o1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737202077, "Lms/bd/c/o1;");
                return;
            }
        }
        f79629a = (String) h.a(16777217, 0, 0L, "27887c", new byte[]{19, 39, 68, 79, 13, 103, 34, 25, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2});
        f79630b = (String) h.a(16777217, 0, 0L, "fa7e14", new byte[]{95, 98, 86, 21, 25, 34, 119, 69});
        f79631c = (String) h.a(16777217, 0, 0L, "c4836c", new byte[]{84, 51, 74, 83, 28, 102, Constants.SHORT_PING_CMD_TYPE, 6});
        f79632d = (String) h.a(16777217, 0, 0L, "e24a88", new byte[]{100, 51});
        f79633e = (String) h.a(16777217, 0, 0L, "e94488", new byte[]{124, 44});
        f79634f = (String) h.a(16777217, 0, 0L, "74bb76", new byte[]{32, 34});
        f79635g = (String) h.a(16777217, 0, 0L, "4b9153", new byte[]{40, 97, 82});
        f79636h = (String) h.a(16777217, 0, 0L, "15bfea", new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 62, 31});
        f79637i = (String) h.a(16777217, 0, 0L, "2906a3", new byte[]{32, 52, 81, 71});
        f79638j = new a();
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return new File((String) h.a(16777217, 0, 0L, "54f4d7", new byte[]{107, 37, StandardMessageCodec.LIST, 83, 20, 36, 51, 3, 62, 103, PublicSuffixDatabase.EXCEPTION_MARKER, 37, 90, 83, 66, 51, 34, 16, 58, 43, 39, 38, 0, 15})).listFiles(f79638j).length;
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r10 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = null;
            try {
                file = new File(str);
            } catch (Throwable unused) {
                fileReader = null;
                bufferedReader = null;
            }
            if (file.exists()) {
                fileReader = new FileReader(file);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        str2 = bufferedReader.readLine();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable unused3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                } catch (Throwable unused5) {
                    bufferedReader = null;
                }
                try {
                    fileReader.close();
                } catch (Throwable unused6) {
                }
                return str2 == null ? (String) h.a(16777217, 0, 0L, "461d55", new byte[]{LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1}) : str2.trim();
            }
            return (String) h.a(16777217, 0, 0L, "0c4cb3", new byte[]{113});
        }
        return (String) invokeL.objValue;
    }

    public static String a(HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hashMap, str)) == null) {
            String str2 = null;
            try {
                str2 = hashMap.get(str);
            } catch (Throwable unused) {
            }
            return str2 == null ? "" : str2.trim();
        }
        return (String) invokeLL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static java.util.HashMap<java.lang.String, java.lang.String> b() {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = ms.bd.c.o1.$ic
            if (r0 != 0) goto Ld2
        L4:
            r0 = 55
            r1 = 0
            r2 = 0
            r3 = 55
        La:
            r4 = 72
        Lc:
            r5 = 30
            switch(r4) {
                case 72: goto Lcc;
                case 73: goto L1c;
                case 74: goto L12;
                default: goto L11;
            }
        L11:
            goto La
        L12:
            switch(r2) {
                case 52: goto La;
                case 53: goto L16;
                case 54: goto Lcc;
                default: goto L15;
            }
        L15:
            goto La
        L16:
            switch(r3) {
                case 29: goto La;
                case 30: goto La;
                case 31: goto L12;
                default: goto L19;
            }
        L19:
            r3 = 30
            goto L16
        L1c:
            r4 = 57
            if (r2 > r4) goto La
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lbe
            r6 = 13
            byte[] r12 = new byte[r6]     // Catch: java.lang.Throwable -> Lbe
            r6 = 105(0x69, float:1.47E-43)
            r12[r1] = r6     // Catch: java.lang.Throwable -> Lbe
            r6 = 42
            r13 = 1
            r12[r13] = r6     // Catch: java.lang.Throwable -> Lbe
            r6 = 83
            r14 = 2
            r12[r14] = r6     // Catch: java.lang.Throwable -> Lbe
            r6 = 3
            r12[r6] = r5     // Catch: java.lang.Throwable -> Lbe
            r5 = 4
            r6 = 11
            r12[r5] = r6     // Catch: java.lang.Throwable -> Lbe
            r5 = 5
            r7 = 62
            r12[r5] = r7     // Catch: java.lang.Throwable -> Lbe
            r5 = 6
            r12[r5] = r0     // Catch: java.lang.Throwable -> Lbe
            r0 = 7
            r5 = 9
            r12[r0] = r5     // Catch: java.lang.Throwable -> Lbe
            r0 = 8
            r7 = 118(0x76, float:1.65E-43)
            r12[r0] = r7     // Catch: java.lang.Throwable -> Lbe
            r0 = 60
            r12[r5] = r0     // Catch: java.lang.Throwable -> Lbe
            r5 = 10
            r7 = 40
            r12[r5] = r7     // Catch: java.lang.Throwable -> Lbe
            r12[r6] = r0     // Catch: java.lang.Throwable -> Lbe
            r0 = 12
            r5 = 78
            r12[r0] = r5     // Catch: java.lang.Throwable -> Lbe
            r7 = 16777217(0x1000001, float:2.350989E-38)
            r8 = 0
            r9 = 0
            java.lang.String r11 = "782e7f"
            java.lang.Object r0 = ms.bd.c.h.a(r7, r8, r9, r11, r12)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lbe
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lbe
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lbc
            r0.<init>(r4)     // Catch: java.lang.Throwable -> Lbc
        L7d:
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> Lba
            if (r3 != 0) goto L87
            r0.close()     // Catch: java.lang.Throwable -> Lc8
            goto Lc8
        L87:
            r5 = 16777217(0x1000001, float:2.350989E-38)
            r6 = 0
            r7 = 0
            java.lang.String r9 = "f0b4e2"
            byte[] r10 = new byte[r13]     // Catch: java.lang.Throwable -> Lba
            r11 = 45
            r10[r1] = r11     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r5 = ms.bd.c.h.a(r5, r6, r7, r9, r10)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lba
            java.lang.String[] r3 = r3.split(r5, r14)     // Catch: java.lang.Throwable -> Lba
            int r5 = r3.length     // Catch: java.lang.Throwable -> Lba
            if (r5 >= r14) goto La3
            goto L7d
        La3:
            r5 = r3[r1]     // Catch: java.lang.Throwable -> Lba
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> Lba
            r3 = r3[r13]     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> Lba
            if (r6 == 0) goto Lb6
            goto L7d
        Lb6:
            r2.put(r5, r3)     // Catch: java.lang.Throwable -> Lba
            goto L7d
        Lba:
            r3 = r0
            goto Lbf
        Lbc:
            goto Lbf
        Lbe:
            r4 = r3
        Lbf:
            if (r3 == 0) goto Lc6
            r3.close()     // Catch: java.lang.Throwable -> Lc5
            goto Lc6
        Lc5:
        Lc6:
            if (r4 == 0) goto Lcb
        Lc8:
            r4.close()     // Catch: java.lang.Throwable -> Lcb
        Lcb:
            return r2
        Lcc:
            r4 = 73
            r2 = 16
            goto Lc
        Ld2:
            r12 = r0
            r13 = 65540(0x10004, float:9.1841E-41)
            r14 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r12.invokeV(r13, r14)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.util.HashMap r1 = (java.util.HashMap) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.c.o1.b():java.util.HashMap");
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                HashMap<String, String> b2 = b();
                jSONObject.put(f79637i, a());
                jSONObject.put(f79632d, a(b2, f79629a));
                jSONObject.put(f79633e, a(b2, f79630b));
                jSONObject.put(f79635g, a((String) h.a(16777217, 0, 0L, "cee379", new byte[]{61, 116, 15, 84, 71, 42, Constants.SHORT_PING_CMD_TYPE, 82, 61, 96, 119, 116, 89, 84, 17, 61, 116, 65, 57, 44, 113, 119, 3, 8, 11, 62, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 20, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 96, 98, 114, 16, 85, 13, 63, 47, 71, 36, 118, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 105, 16, 72, 55, Base64.INTERNAL_PADDING, 97, 92, 11, Constants.SHORT_PING_CMD_TYPE, 96, 98, 7})));
                jSONObject.put(f79636h, a((String) h.a(16777217, 0, 0L, "6a8225", new byte[]{104, 112, 82, 85, 66, 38, 48, 86, 96, 97, 34, 112, 4, 85, 20, 49, PublicSuffixDatabase.EXCEPTION_MARKER, 69, 100, UtilsBlink.VER_TYPE_SEPARATOR, 36, 115, 94, 9, 14, 50, 32, 16, 38, 97, 55, 118, 77, 84, 8, 51, 122, 67, 121, 119, 46, 109, 77, 73, 50, 47, 60, 78, 86, 100, 53, 102, 90})));
                jSONObject.put(f79634f, a(b2, f79631c));
            } catch (Throwable unused) {
            }
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? (String) h.a(16777217, 0, 0L, "d7299d", new byte[]{110, 40}) : jSONObject2.trim();
        }
        return (String) invokeV.objValue;
    }
}
