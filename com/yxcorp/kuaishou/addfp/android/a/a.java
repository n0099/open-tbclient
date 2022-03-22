package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f44661b;

    /* renamed from: c  reason: collision with root package name */
    public ReentrantLock f44662c;

    public a() {
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
        this.f44661b = "";
        this.f44662c = new ReentrantLock();
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (!d()) {
                    String c2 = c();
                    if (!TextUtils.isEmpty(c2)) {
                        return c2;
                    }
                }
                boolean z = false;
                if (Build.VERSION.SDK_INT >= 29) {
                    String str = Build.MODEL;
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                        z = true;
                    }
                }
                if (!z) {
                    String gSer = Orange.getInstance().gSer();
                    if (!TextUtils.isEmpty(gSer) && !gSer.startsWith("KWE")) {
                        return gSer;
                    }
                }
                if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String serial = Build.getSerial();
                    if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                        return serial;
                    }
                }
                String str2 = Build.SERIAL;
                return !TextUtils.isEmpty(str2) ? !str2.equals("unknown") ? str2 : "KWE_N" : "KWE_N";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_N";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
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
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        }
                    } else {
                        bufferedReader = null;
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 26;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                return System.currentTimeMillis() - SystemClock.elapsedRealtime();
            } catch (Throwable th) {
                th.printStackTrace();
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, IPUT, CONST, INVOKE, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0257  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, ResponseDfpCallback responseDfpCallback, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, responseDfpCallback, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f44662c.lock();
            } finally {
                try {
                    this.f44662c.unlock();
                    if (TextUtils.isEmpty(this.f44661b)) {
                    }
                    return this.f44661b;
                } finally {
                }
            }
            if (TextUtils.isEmpty(this.f44661b)) {
                JSONObject jSONObject = new JSONObject();
                String str = Build.MODEL;
                jSONObject.put("k27", com.yxcorp.kuaishou.addfp.android.b.e.b(TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "")));
                jSONObject.put("k64", com.yxcorp.kuaishou.addfp.android.b.e.b(a(context)));
                jSONObject.put("k31", com.yxcorp.kuaishou.addfp.android.b.e.b(z ? d.c() : d.d()));
                jSONObject.put("k66", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.a.a(context)));
                jSONObject.put("k39", com.yxcorp.kuaishou.addfp.android.b.e.b(Long.toString(e())));
                jSONObject.put("k101", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.e.a(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
                jSONObject.put("k102", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.e.a(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
                jSONObject.put("k57", com.yxcorp.kuaishou.addfp.android.b.e.b(d.b(context)));
                jSONObject.put("k68", com.yxcorp.kuaishou.addfp.android.b.e.b(d.a(context)));
                jSONObject.put("k105", com.yxcorp.kuaishou.addfp.android.b.e.b(Orange.getInstance().gRdi()));
                jSONObject.put("k83", com.yxcorp.kuaishou.addfp.android.b.e.b(d.d(context)));
                jSONObject.put("k86", com.yxcorp.kuaishou.addfp.android.b.e.b(d.e(context)));
                jSONObject.put("k3", com.yxcorp.kuaishou.addfp.android.b.e.b(d.c(context)));
                jSONObject.put("k109", com.yxcorp.kuaishou.addfp.android.b.e.b(Orange.getInstance().gProps()));
                jSONObject.put("k36", com.yxcorp.kuaishou.addfp.android.b.e.b("1.3.4.32.7230603b"));
                jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.e.b("AD_AND"));
                jSONObject.put("k5", com.yxcorp.kuaishou.addfp.android.b.e.b(Long.toString(d.a())));
                jSONObject.put("k46", com.yxcorp.kuaishou.addfp.android.b.e.b(Long.toString(d.b())));
                jSONObject.put("k110", com.yxcorp.kuaishou.addfp.android.b.e.b(Orange.getInstance().gKpsd()));
                jSONObject.put("k111", com.yxcorp.kuaishou.addfp.android.b.e.b("KWE_NPN"));
                if (z2) {
                    com.yxcorp.kuaishou.addfp.a.a.b.a().c();
                }
                String str2 = KWEGIDDFP.mOAID;
                if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                    str2 = new e(context).c();
                }
                jSONObject.put("k97", com.yxcorp.kuaishou.addfp.android.b.e.b(str2));
                CRC32 crc32 = new CRC32();
                for (int i = 1; i <= 111; i++) {
                    String str3 = "k" + i;
                    if (jSONObject.has(str3)) {
                        crc32.update(jSONObject.optString(str3).getBytes());
                    }
                }
                jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.e.b("AD_AND:" + String.valueOf(crc32.getValue())));
                StringBuilder sb = new StringBuilder("mimi :");
                sb.append(jSONObject.toString());
                sb.append(" ");
                sb.append(jSONObject.toString().getBytes().length);
                sb.append(" ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                byte[] magicWrapper = Orange.getInstance().getMagicWrapper(context, jSONObject.toString().getBytes(), 0);
                new StringBuilder("get mini lenth ").append(magicWrapper.length);
                this.f44661b = URLEncoder.encode(Base64.encodeToString(magicWrapper, 0), IMAudioTransRequest.CHARSET);
                this.f44662c.unlock();
                if (TextUtils.isEmpty(this.f44661b)) {
                    this.f44661b = "KWE_N";
                }
                return this.f44661b;
            }
            return this.f44661b;
        }
        return (String) invokeCommon.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.a = str;
        }
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return !TextUtils.isEmpty(this.a) ? this.a : "KWE_N";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_N";
            }
        }
        return (String) invokeV.objValue;
    }
}
