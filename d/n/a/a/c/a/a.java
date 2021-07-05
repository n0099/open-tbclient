package d.n.a.a.c.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f75134a;

    /* renamed from: b  reason: collision with root package name */
    public String f75135b;

    /* renamed from: c  reason: collision with root package name */
    public ReentrantLock f75136c;

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
                return;
            }
        }
        this.f75135b = "";
        this.f75136c = new ReentrantLock();
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f75137a : (a) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (!h()) {
                    String g2 = g();
                    if (!TextUtils.isEmpty(g2)) {
                        return g2;
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
                    String e2 = Orange.a().e();
                    if (!TextUtils.isEmpty(e2) && !e2.startsWith("KWE")) {
                        return e2;
                    }
                }
                if (d.n.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String serial = Build.getSerial();
                    if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                        return serial;
                    }
                }
                String str2 = Build.SERIAL;
                return !TextUtils.isEmpty(str2) ? !str2.equals("unknown") ? str2 : "KWE_N" : "KWE_N";
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "KWE_N";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            } catch (Throwable unused) {
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
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
                                    d.n.a.a.c.b.b.c(th);
                                }
                                return trim;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                d.n.a.a.c.b.b.c(th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th4) {
                                        d.n.a.a.c.b.b.c(th4);
                                    }
                                }
                                throw th3;
                            }
                        }
                    } else {
                        bufferedReader = null;
                    }
                } catch (Throwable th5) {
                    d.n.a.a.c.b.b.c(th5);
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

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 26;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                return System.currentTimeMillis() - SystemClock.elapsedRealtime();
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, IPUT, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f75136c.lock();
            } finally {
                try {
                    this.f75136c.unlock();
                    if (TextUtils.isEmpty(this.f75135b)) {
                    }
                    d.n.a.a.c.b.b.e("mini cost : " + (System.currentTimeMillis() - currentTimeMillis));
                    return this.f75135b;
                } finally {
                }
            }
            if (TextUtils.isEmpty(this.f75135b)) {
                JSONObject jSONObject = new JSONObject();
                String str = Build.MODEL;
                jSONObject.put("k27", d.n.a.a.c.b.e.f(TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "")));
                jSONObject.put("k64", d.n.a.a.c.b.e.f(b(context)));
                jSONObject.put("k31", d.n.a.a.c.b.e.f(z ? d.d(context, true) : d.a()));
                jSONObject.put("k66", d.n.a.a.c.b.e.f(f(context)));
                jSONObject.put("k39", d.n.a.a.c.b.e.f(Long.toString(i())));
                jSONObject.put("k101", d.n.a.a.c.b.e.f(d.n.a.a.c.b.e.c(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
                jSONObject.put("k102", d.n.a.a.c.b.e.f(d.n.a.a.c.b.e.c(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
                jSONObject.put("k57", d.n.a.a.c.b.e.f(d.h(context)));
                jSONObject.put("k68", d.n.a.a.c.b.e.f(d.b(context)));
                jSONObject.put("k105", d.n.a.a.c.b.e.f(Orange.a().c()));
                jSONObject.put("k83", d.n.a.a.c.b.e.f(d.k(context)));
                jSONObject.put("k86", d.n.a.a.c.b.e.f(d.n(context)));
                jSONObject.put("k3", d.n.a.a.c.b.e.f(d.j(context)));
                if (z2) {
                    d.n.a.a.a.a.b.c().i();
                }
                String str2 = d.n.a.a.b.f75127h;
                if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                    str2 = new e(context).e();
                }
                jSONObject.put("k97", d.n.a.a.c.b.e.f(str2));
                jSONObject.put("k36", d.n.a.a.c.b.e.f(d.n.a.a.c.b.b.a()));
                jSONObject.put("k14", d.n.a.a.c.b.e.f(d.n.a.a.c.b.b.d()));
                CRC32 crc32 = new CRC32();
                for (int i2 = 1; i2 <= 106; i2++) {
                    String str3 = Config.APP_KEY + i2;
                    if (jSONObject.has(str3)) {
                        crc32.update(jSONObject.optString(str3).getBytes());
                    }
                }
                jSONObject.put("k14", d.n.a.a.c.b.e.f(d.n.a.a.c.b.b.d() + ":" + String.valueOf(crc32.getValue())));
                d.n.a.a.c.b.b.e("mimi :" + jSONObject.toString() + " " + jSONObject.toString().getBytes().length + " " + (System.currentTimeMillis() - currentTimeMillis));
                byte[] d2 = Orange.a().d(context, jSONObject.toString().getBytes(), 0);
                StringBuilder sb = new StringBuilder("get mini lenth ");
                sb.append(d2.length);
                d.n.a.a.c.b.b.b(sb.toString());
                this.f75135b = URLEncoder.encode(Base64.encodeToString(d2, 0), "utf-8");
                this.f75136c.unlock();
                if (TextUtils.isEmpty(this.f75135b)) {
                    this.f75135b = "KWE_N";
                }
                d.n.a.a.c.b.b.e("mini cost : " + (System.currentTimeMillis() - currentTimeMillis));
                return this.f75135b;
            }
            return this.f75135b;
        }
        return (String) invokeCommon.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f75134a = str;
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return !TextUtils.isEmpty(this.f75134a) ? this.f75134a : "KWE_N";
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "KWE_N";
            }
        }
        return (String) invokeV.objValue;
    }
}
