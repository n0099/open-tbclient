package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ReentrantLock c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = new ReentrantLock();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004b A[Catch: all -> 0x00a4, TryCatch #3 {all -> 0x00a4, blocks: (B:13:0x0015, B:16:0x0020, B:18:0x0026, B:20:0x002e, B:22:0x003a, B:27:0x004b, B:29:0x0059, B:32:0x0062, B:42:0x0084, B:44:0x008e, B:47:0x0095, B:49:0x009d, B:5:0x0006), top: B:63:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084 A[Catch: all -> 0x00a4, TRY_ENTER, TryCatch #3 {all -> 0x00a4, blocks: (B:13:0x0015, B:16:0x0020, B:18:0x0026, B:20:0x002e, B:22:0x003a, B:27:0x004b, B:29:0x0059, B:32:0x0062, B:42:0x0084, B:44:0x008e, B:47:0x0095, B:49:0x009d, B:5:0x0006), top: B:63:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #3 {all -> 0x00a4, blocks: (B:13:0x0015, B:16:0x0020, B:18:0x0026, B:20:0x002e, B:22:0x003a, B:27:0x004b, B:29:0x0059, B:32:0x0062, B:42:0x0084, B:44:0x008e, B:47:0x0095, B:49:0x009d, B:5:0x0006), top: B:63:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        boolean z2 = true;
        try {
            if (!(Build.VERSION.SDK_INT >= 26)) {
                String b = b();
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                String str = Build.MODEL;
                if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                    z = true;
                    if (!z) {
                        String gSer = Orange.getInstance().gSer();
                        if (!TextUtils.isEmpty(gSer) && !gSer.startsWith("KWE")) {
                            return gSer;
                        }
                    }
                    String[] strArr = {h.c};
                    for (i = 0; i <= 0; i++) {
                        if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        String serial = Build.getSerial();
                        if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                            return serial;
                        }
                    }
                    String str2 = Build.SERIAL;
                    return TextUtils.isEmpty(str2) ? !str2.equals("unknown") ? str2 : "KWE_N" : "KWE_N";
                }
            }
            z = false;
            if (!z) {
            }
            String[] strArr2 = {h.c};
            while (i <= 0) {
            }
            if (z2) {
            }
            String str22 = Build.SERIAL;
            if (TextUtils.isEmpty(str22)) {
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "") : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r2 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            File file = new File("/sys/class/android_usb/android0/iSerial");
            if (file.exists()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        String trim = readLine.trim();
                        try {
                            bufferedReader.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return trim;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        return null;
    }

    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b.a : (c) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return !TextUtils.isEmpty(this.a) ? this.a : "KWE_N";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_N";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02a2 A[Catch: all -> 0x02e8, TryCatch #13 {all -> 0x0346, blocks: (B:71:0x01d0, B:76:0x0201, B:84:0x0211, B:86:0x021e, B:88:0x022f, B:90:0x0244, B:92:0x0252, B:94:0x0260, B:96:0x0266, B:98:0x026e, B:100:0x0274, B:102:0x027c, B:107:0x0288, B:111:0x0291, B:123:0x02ec, B:105:0x0283, B:83:0x020e, B:112:0x0298, B:115:0x02a2, B:117:0x02b6, B:118:0x02c1, B:119:0x02c4, B:81:0x0209), top: B:161:0x01d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0260 A[Catch: all -> 0x0346, TryCatch #13 {all -> 0x0346, blocks: (B:71:0x01d0, B:76:0x0201, B:84:0x0211, B:86:0x021e, B:88:0x022f, B:90:0x0244, B:92:0x0252, B:94:0x0260, B:96:0x0266, B:98:0x026e, B:100:0x0274, B:102:0x027c, B:107:0x0288, B:111:0x0291, B:123:0x02ec, B:105:0x0283, B:83:0x020e, B:112:0x0298, B:115:0x02a2, B:117:0x02b6, B:118:0x02c1, B:119:0x02c4, B:81:0x0209), top: B:161:0x01d0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Context context, ResponseDfpCallback responseDfpCallback, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        long j;
        int i;
        BufferedReader bufferedReader;
        StatFs statFs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, responseDfpCallback, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.c.lock();
            } catch (Throwable th) {
                th = th;
                str = "KWE_N";
            }
            if (TextUtils.isEmpty(this.b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k23", g.a(a(Build.MANUFACTURER)));
                jSONObject.put("k61", g.a(a(Build.BRAND)));
                jSONObject.put("k27", g.a(a(Build.MODEL)));
                jSONObject.put("k64", g.a(a(context)));
                jSONObject.put("k31", g.a(com.yxcorp.kuaishou.addfp.android.b.d.c(false)));
                jSONObject.put("k117", g.a(com.yxcorp.kuaishou.addfp.android.b.d.c(true)));
                jSONObject.put("k66", g.a(com.yxcorp.kuaishou.addfp.android.b.d.a(false)));
                jSONObject.put("k116", g.a(com.yxcorp.kuaishou.addfp.android.b.d.a(true)));
                long j2 = 0;
                jSONObject.put("k39", g.a(Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime())));
                jSONObject.put("k101", g.a(g.b(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
                jSONObject.put("k102", g.a(g.b(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
                jSONObject.put("k57", g.a(com.yxcorp.kuaishou.addfp.android.b.d.b(false)));
                jSONObject.put("k118", g.a(com.yxcorp.kuaishou.addfp.android.b.d.b(true)));
                jSONObject.put("k68", g.a(com.yxcorp.kuaishou.addfp.android.b.d.e(false)));
                jSONObject.put("k120", g.a(com.yxcorp.kuaishou.addfp.android.b.d.e(true)));
                jSONObject.put("k105", g.a(Orange.getInstance().gRdi()));
                String eGidLocal = KWEGIDDFP.instance().getEGidLocal(context, c().a(), false);
                if (TextUtils.isEmpty(eGidLocal)) {
                    eGidLocal = "KWE_N";
                }
                jSONObject.put("k83", g.a(eGidLocal));
                jSONObject.put("k86", g.a(com.yxcorp.kuaishou.addfp.c.a.a.a(context)));
                jSONObject.put("k3", g.a(context.getPackageName().replace("=", "").replace("&", "")));
                jSONObject.put("k109", g.a(Orange.getInstance().gProps()));
                jSONObject.put("k36", g.a(Orange.sdkVersion));
                jSONObject.put("k14", g.a("AD_AND"));
                try {
                    statFs = new StatFs(Environment.getDataDirectory().getPath());
                    str = "KWE_N";
                } catch (Throwable unused) {
                    str = "KWE_N";
                }
                try {
                    j = statFs.getBlockCount() * statFs.getBlockSize();
                } catch (Throwable unused2) {
                    j = 0;
                    jSONObject.put("k5", g.a(Long.toString(j)));
                    BufferedReader bufferedReader2 = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                        try {
                            j2 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * 1024;
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            th.printStackTrace();
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            jSONObject.put("k46", g.a(Long.toString(j2)));
                            jSONObject.put("k110", g.a(Orange.getInstance().gKpsd()));
                            jSONObject.put("k111", g.a("KWE_NPN"));
                            jSONObject.put("k113", g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                            jSONObject.put("k115", g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                            String d = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                            if (!z) {
                            }
                            jSONObject.put("k97", g.a(d));
                            CRC32 crc32 = new CRC32();
                            while (i <= 120) {
                            }
                            jSONObject.put("k14", g.a("AD_AND:" + String.valueOf(crc32.getValue())));
                            StringBuilder sb = new StringBuilder("mimi :");
                            sb.append(jSONObject.toString());
                            sb.append(" ");
                            sb.append(jSONObject.toString().getBytes().length);
                            sb.append(" ");
                            sb.append(System.currentTimeMillis() - currentTimeMillis);
                            byte[] magicWrapper = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                            new StringBuilder("get mini lenth ").append(magicWrapper.length);
                            this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper, 0), IMAudioTransRequest.CHARSET);
                            this.c.unlock();
                            if (TextUtils.isEmpty(this.b)) {
                            }
                            return this.b;
                        }
                    } catch (IOException unused3) {
                    }
                    jSONObject.put("k46", g.a(Long.toString(j2)));
                    jSONObject.put("k110", g.a(Orange.getInstance().gKpsd()));
                    jSONObject.put("k111", g.a("KWE_NPN"));
                    jSONObject.put("k113", g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                    jSONObject.put("k115", g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                    String d2 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                    if (!z) {
                    }
                    jSONObject.put("k97", g.a(d2));
                    CRC32 crc322 = new CRC32();
                    while (i <= 120) {
                    }
                    jSONObject.put("k14", g.a("AD_AND:" + String.valueOf(crc322.getValue())));
                    StringBuilder sb2 = new StringBuilder("mimi :");
                    sb2.append(jSONObject.toString());
                    sb2.append(" ");
                    sb2.append(jSONObject.toString().getBytes().length);
                    sb2.append(" ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    byte[] magicWrapper2 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                    new StringBuilder("get mini lenth ").append(magicWrapper2.length);
                    this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper2, 0), IMAudioTransRequest.CHARSET);
                    this.c.unlock();
                    if (TextUtils.isEmpty(this.b)) {
                    }
                    return this.b;
                }
                try {
                    jSONObject.put("k5", g.a(Long.toString(j)));
                    BufferedReader bufferedReader22 = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                        j2 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * 1024;
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    jSONObject.put("k46", g.a(Long.toString(j2)));
                    jSONObject.put("k110", g.a(Orange.getInstance().gKpsd()));
                    jSONObject.put("k111", g.a("KWE_NPN"));
                    jSONObject.put("k113", g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                    jSONObject.put("k115", g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                    String d22 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                    if (!z && !d22.equals("KWE_NPN") && d22.startsWith("KWE")) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            try {
                                new CountDownLatch(1).await(1000L, TimeUnit.MILLISECONDS);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        d22 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                    }
                    jSONObject.put("k97", g.a(d22));
                    CRC32 crc3222 = new CRC32();
                    for (i = 1; i <= 120; i++) {
                        String str2 = "k" + i;
                        if (jSONObject.has(str2)) {
                            crc3222.update(jSONObject.optString(str2).getBytes());
                        }
                    }
                    jSONObject.put("k14", g.a("AD_AND:" + String.valueOf(crc3222.getValue())));
                    StringBuilder sb22 = new StringBuilder("mimi :");
                    sb22.append(jSONObject.toString());
                    sb22.append(" ");
                    sb22.append(jSONObject.toString().getBytes().length);
                    sb22.append(" ");
                    sb22.append(System.currentTimeMillis() - currentTimeMillis);
                    byte[] magicWrapper22 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                    new StringBuilder("get mini lenth ").append(magicWrapper22.length);
                    this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper22, 0), IMAudioTransRequest.CHARSET);
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        th.printStackTrace();
                        this.b = "KWE_PE";
                        responseDfpCallback.onFailed(-1, g.a(th));
                        this.c.unlock();
                        if (TextUtils.isEmpty(this.b)) {
                        }
                        return this.b;
                    } finally {
                        this.c.unlock();
                    }
                }
                this.c.unlock();
                if (TextUtils.isEmpty(this.b)) {
                    this.b = str;
                }
                return this.b;
            }
            return this.b;
        }
        return (String) invokeLLZ.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }
}
