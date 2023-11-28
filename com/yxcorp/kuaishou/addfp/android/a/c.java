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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.kuaishou.weapon.p0.g;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean d = true;
    public static int e;
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

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "") : (String) invokeL.objValue;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                        d = false;
                    }
                    if ("64_level".equals(next)) {
                        e = jSONObject.optInt(next, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
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
        if (interceptable != null && (invokeV = interceptable.invokeV(65541, null)) != null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b.a : (c) invokeV.objValue;
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

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x006a A[Catch: all -> 0x00f5, TryCatch #3 {all -> 0x00f5, blocks: (B:4:0x0004, B:17:0x001c, B:20:0x0027, B:23:0x002d, B:27:0x0037, B:29:0x003f, B:31:0x004b, B:35:0x005a, B:41:0x006a, B:43:0x0078, B:58:0x00b3, B:68:0x00d5, B:70:0x00df, B:73:0x00e6, B:75:0x00ee, B:53:0x00a6, B:55:0x00ac, B:47:0x0084, B:49:0x008c, B:9:0x000d), top: B:88:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        boolean z;
        boolean z2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (!d) {
                    return "KWE_NPN";
                }
                boolean z3 = false;
                if (Build.VERSION.SDK_INT >= 26) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String b = b();
                    if (!TextUtils.isEmpty(b)) {
                        return b;
                    }
                }
                if (e == 0) {
                    int i = Build.VERSION.SDK_INT;
                    if (i < 33) {
                        if (i >= 29) {
                            String str = Build.MODEL;
                            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                            }
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            String gSer = Orange.getInstance().gSer();
                            if (!TextUtils.isEmpty(gSer) && !gSer.startsWith("KWE")) {
                                return gSer;
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                } else {
                    Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    String str2 = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "ro.serialno");
                    if (!TextUtils.isEmpty(str2) && !str2.equals("unknown")) {
                        return str2;
                    }
                }
                String[] strArr = {g.c};
                int i2 = 0;
                while (true) {
                    if (i2 <= 0) {
                        try {
                            if (context.checkPermission(strArr[i2], Process.myPid(), Process.myUid()) == -1) {
                                break;
                            }
                            i2++;
                        } catch (Throwable unused) {
                        }
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    String serial = Build.getSerial();
                    if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                        return serial;
                    }
                }
                String str3 = Build.SERIAL;
                if (!TextUtils.isEmpty(str3)) {
                    if (!str3.equals("unknown")) {
                        return str3;
                    }
                    return "KWE_N";
                }
                return "KWE_N";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_N";
            }
        }
        return (String) invokeL.objValue;
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
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k23", com.yxcorp.kuaishou.addfp.android.b.g.a(a(Build.MANUFACTURER)));
            jSONObject.put("k61", com.yxcorp.kuaishou.addfp.android.b.g.a(a(Build.BRAND)));
            jSONObject.put("k27", com.yxcorp.kuaishou.addfp.android.b.g.a(a(Build.MODEL)));
            jSONObject.put("k64", com.yxcorp.kuaishou.addfp.android.b.g.a(a(context)));
            jSONObject.put("k31", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.c(false)));
            jSONObject.put("k117", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.c(true)));
            jSONObject.put("k66", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.a(false)));
            jSONObject.put("k116", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.a(true)));
            long j2 = 0;
            jSONObject.put("k39", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime())));
            jSONObject.put("k101", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.g.b(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
            jSONObject.put("k102", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.g.b(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
            jSONObject.put("k57", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.b(false)));
            jSONObject.put("k118", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.b(true)));
            jSONObject.put("k68", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.e(false)));
            jSONObject.put("k120", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.e(true)));
            jSONObject.put("k105", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gRdi()));
            String eGidLocal = KWEGIDDFP.instance().getEGidLocal(context, c().a(), false);
            if (TextUtils.isEmpty(eGidLocal)) {
                eGidLocal = "KWE_N";
            }
            jSONObject.put("k83", com.yxcorp.kuaishou.addfp.android.b.g.a(eGidLocal));
            jSONObject.put("k86", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.c.a.a.a(context)));
            jSONObject.put("k3", com.yxcorp.kuaishou.addfp.android.b.g.a(context.getPackageName().replace("=", "").replace("&", "")));
            jSONObject.put("k109", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gProps()));
            jSONObject.put("k36", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.sdkVersion));
            jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.g.a("AD_AND"));
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
                jSONObject.put("k5", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(j)));
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
                        jSONObject.put("k46", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(j2)));
                        jSONObject.put("k110", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gKpsd()));
                        jSONObject.put("k111", com.yxcorp.kuaishou.addfp.android.b.g.a("KWE_NPN"));
                        jSONObject.put("k113", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                        jSONObject.put("k115", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                        String d2 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                        if (!z) {
                        }
                        jSONObject.put("k97", com.yxcorp.kuaishou.addfp.android.b.g.a(d2));
                        CRC32 crc32 = new CRC32();
                        while (i <= 120) {
                        }
                        jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.g.a("AD_AND:" + String.valueOf(crc32.getValue())));
                        StringBuilder sb = new StringBuilder("mimi :");
                        sb.append(jSONObject.toString());
                        sb.append(" ");
                        sb.append(jSONObject.toString().getBytes().length);
                        sb.append(" ");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        byte[] magicWrapper = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                        new StringBuilder("get mini lenth ").append(magicWrapper.length);
                        this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper, 0), "utf-8");
                        this.c.unlock();
                        if (TextUtils.isEmpty(this.b)) {
                        }
                        return this.b;
                    }
                } catch (IOException unused3) {
                }
                jSONObject.put("k46", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(j2)));
                jSONObject.put("k110", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gKpsd()));
                jSONObject.put("k111", com.yxcorp.kuaishou.addfp.android.b.g.a("KWE_NPN"));
                jSONObject.put("k113", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                jSONObject.put("k115", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                String d22 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                if (!z) {
                }
                jSONObject.put("k97", com.yxcorp.kuaishou.addfp.android.b.g.a(d22));
                CRC32 crc322 = new CRC32();
                while (i <= 120) {
                }
                jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.g.a("AD_AND:" + String.valueOf(crc322.getValue())));
                StringBuilder sb2 = new StringBuilder("mimi :");
                sb2.append(jSONObject.toString());
                sb2.append(" ");
                sb2.append(jSONObject.toString().getBytes().length);
                sb2.append(" ");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                byte[] magicWrapper2 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                new StringBuilder("get mini lenth ").append(magicWrapper2.length);
                this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper2, 0), "utf-8");
                this.c.unlock();
                if (TextUtils.isEmpty(this.b)) {
                }
                return this.b;
            }
            try {
                jSONObject.put("k5", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(j)));
                BufferedReader bufferedReader22 = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                    j2 = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) * 1024;
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th = th3;
                }
                jSONObject.put("k46", com.yxcorp.kuaishou.addfp.android.b.g.a(Long.toString(j2)));
                jSONObject.put("k110", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gKpsd()));
                jSONObject.put("k111", com.yxcorp.kuaishou.addfp.android.b.g.a("KWE_NPN"));
                jSONObject.put("k113", com.yxcorp.kuaishou.addfp.android.b.g.a(Orange.getInstance().gManu(context, com.yxcorp.kuaishou.addfp.c.a.a.a())));
                jSONObject.put("k115", com.yxcorp.kuaishou.addfp.android.b.g.a(com.yxcorp.kuaishou.addfp.android.b.d.d(true)));
                String d222 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                if (!z && !d222.equals("KWE_NPN") && d222.startsWith("KWE")) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            new CountDownLatch(1).await(1000L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    d222 = com.yxcorp.kuaishou.addfp.android.b.d.d(false);
                }
                jSONObject.put("k97", com.yxcorp.kuaishou.addfp.android.b.g.a(d222));
                CRC32 crc3222 = new CRC32();
                for (i = 1; i <= 120; i++) {
                    String str2 = "k" + i;
                    if (jSONObject.has(str2)) {
                        crc3222.update(jSONObject.optString(str2).getBytes());
                    }
                }
                jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.g.a("AD_AND:" + String.valueOf(crc3222.getValue())));
                StringBuilder sb22 = new StringBuilder("mimi :");
                sb22.append(jSONObject.toString());
                sb22.append(" ");
                sb22.append(jSONObject.toString().getBytes().length);
                sb22.append(" ");
                sb22.append(System.currentTimeMillis() - currentTimeMillis);
                byte[] magicWrapper22 = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                new StringBuilder("get mini lenth ").append(magicWrapper22.length);
                this.b = URLEncoder.encode(Base64.encodeToString(magicWrapper22, 0), "utf-8");
            } catch (Throwable th4) {
                th = th4;
                try {
                    th.printStackTrace();
                    this.b = "KWE_PE";
                    responseDfpCallback.onFailed(-1, com.yxcorp.kuaishou.addfp.android.b.g.a(th));
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
        return (String) invokeLLZ.objValue;
    }
}
