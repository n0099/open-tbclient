package com.repackage;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.http.GetRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import com.repackage.gl9;
import com.repackage.xf9;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rf9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;
    public static final Handler b;
    public static FunAdSdk.SdkInitializeCallback c;
    public static final Handler d;
    public static final xk9 e;
    public static final gl9 f;
    public static boolean g;
    public static volatile boolean h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
                rf9.e(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            Response perform;
            Reporter a;
            JSONObject jSONObject;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                int i3 = -1;
                boolean z = false;
                if (i2 != 100) {
                    if (i2 == 101) {
                        qf9 qf9Var = new qf9();
                        String str = FunAdSdk.getFunAdConfig().appId;
                        String str2 = null;
                        try {
                            LogPrinter.v("Start load config from assets.", new Object[0]);
                            AssetManager assets = FunAdSdk.getAppContext().getAssets();
                            InputStream open = assets.open(str + ".json");
                            StringWriter stringWriter = new StringWriter();
                            InputStreamReader inputStreamReader = new InputStreamReader(open);
                            char[] cArr = new char[4096];
                            while (true) {
                                int read = inputStreamReader.read(cArr);
                                if (-1 == read) {
                                    break;
                                }
                                stringWriter.write(cArr, 0, read);
                            }
                            String stringWriter2 = stringWriter.toString();
                            LogPrinter.v("Config from assets load over.", new Object[0]);
                            open.close();
                            if (!TextUtils.isEmpty(stringWriter2)) {
                                str2 = uf9.a(stringWriter2, str);
                                LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e) {
                            LogPrinter.e(e, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (qf9Var.b(str2)) {
                            LogPrinter.v("Config from assets parsed over with succeed", new Object[0]);
                        } else {
                            LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                            if (FunAdSdk.isLogEnabled()) {
                                throw new RuntimeException("Config from assets parsed failed");
                            }
                        }
                        rf9.b.obtainMessage(200).sendToTarget();
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    HostAppInfo.fillReqParams(jSONObject2);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.get(next));
                    }
                } catch (JSONException unused) {
                }
                try {
                    perform = new GetRequest("https://cd.xdplt.com/v2/z", new RequestParams(hashMap)).perform();
                } catch (IOException e2) {
                    LogPrinter.e(e2);
                }
                if (perform != null && perform.getResponseCode() == 200) {
                    try {
                        jSONObject = new JSONObject(perform.getContent());
                        i = jSONObject.getInt(Constants.KEYS.RET);
                        LogPrinter.d("Download online ad config response ret: " + i, new Object[0]);
                    } catch (JSONException e3) {
                        LogPrinter.e(e3);
                        a = ag9.a();
                    }
                    if (i == 200) {
                        try {
                        } catch (Exception e4) {
                            LogPrinter.e(e4);
                            a = ag9.a();
                            i3 = -2;
                        }
                        if (new qf9().b(uf9.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                            rf9.a.clear();
                            z = true;
                        } else {
                            a = ag9.a();
                            i3 = -3;
                            a.logEvent("k_ppcfg", "st", Integer.valueOf(i3));
                        }
                    }
                    wf9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                    if (z) {
                        rf9.b.sendEmptyMessage(200);
                    }
                    rf9.c();
                }
                LogPrinter.e("Pull ad config failed.", new Object[0]);
                wf9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                }
                rf9.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755352116, "Lcom/repackage/rf9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755352116, "Lcom/repackage/rf9;");
                return;
            }
        }
        a = new HashMap();
        b = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        d = new b(handlerThread.getLooper());
        e = new xk9();
        f = new gl9();
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            xf9 xf9Var = e.b;
            synchronized (xf9Var.a) {
                Deque<xf9.c> deque = xf9Var.a.get(str);
                i = 0;
                if (deque != null) {
                    Iterator<xf9.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        xf9.c next = descendingIterator.next();
                        if (next.a().contains(pid)) {
                            i = next.b();
                            break;
                        }
                    }
                }
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static zf9 b(String str) {
        InterceptResult invokeL;
        zf9 zf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            xk9 xk9Var = e;
            synchronized (xk9Var) {
                if (xk9Var.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    zf9Var = null;
                } else {
                    zf9Var = xk9Var.c.get(str);
                }
            }
            return zf9Var;
        }
        return (zf9) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = wf9.b;
            long j = 0;
            long j2 = sharedPreferences.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = sharedPreferences.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            LogPrinter.v("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            Handler handler = d;
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100, max);
        }
    }

    public static void d(ll9 ll9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ll9Var) == null) {
            h = true;
            gl9 gl9Var = f;
            synchronized (gl9Var.b) {
                gl9Var.e = ll9Var;
                gl9Var.d = 1;
                while (!gl9Var.c.isEmpty()) {
                    gl9.a pollFirst = gl9Var.c.pollFirst();
                    if (!gl9.f && pollFirst == null) {
                        throw new AssertionError();
                    }
                    gl9Var.loadAd(pollFirst.a, pollFirst.b, pollFirst.c);
                }
            }
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = c;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0114 A[Catch: all -> 0x0260, TRY_LEAVE, TryCatch #0 {, blocks: (B:41:0x00a7, B:43:0x00ab, B:45:0x00b1, B:46:0x00b9, B:65:0x0114, B:49:0x00ca, B:50:0x00d7, B:52:0x00dd, B:53:0x00e7, B:55:0x00ed, B:57:0x00fd, B:59:0x0107, B:68:0x011e, B:72:0x0126, B:76:0x0137, B:75:0x0135, B:71:0x0124), top: B:118:0x00a7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(boolean z) {
        kf9 kf9Var;
        boolean z2;
        boolean z3;
        boolean z4;
        byte[] decode;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(65541, null, z) != null) {
            return;
        }
        LogPrinter.v("tryInitialize", new Object[0]);
        c();
        FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
        Set<tf9> set = null;
        String string = wf9.b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                kf9Var = new kf9(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                LogPrinter.e(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(kf9Var == null);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (kf9Var != null) {
                if (z) {
                    d.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                gl9 gl9Var = f;
                synchronized (gl9Var.b) {
                    gl9Var.d = -1;
                    while (!gl9Var.c.isEmpty()) {
                        gl9.a pollFirst = gl9Var.c.pollFirst();
                        if (!gl9.f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.c.onError(pollFirst.b.getSid());
                    }
                }
                return;
            }
            xk9 xk9Var = e;
            synchronized (xk9Var) {
                kf9 kf9Var2 = xk9Var.a;
                if (kf9Var2 != null) {
                    if (kf9Var2.equals(kf9Var)) {
                        LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        kf9 kf9Var3 = xk9Var.a;
                        if (kf9Var3.a.size() == kf9Var.a.size()) {
                            HashSet hashSet = new HashSet(kf9Var.a);
                            for (Ssp ssp : kf9Var3.a) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    Ssp ssp2 = (Ssp) it.next();
                                    if (ssp.type.equals(ssp2.type) && ssp.sspId.equals(ssp2.sspId)) {
                                        it.remove();
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z4) {
                                }
                            }
                            z3 = true;
                            if (!z3) {
                                LogPrinter.d("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                kf9 kf9Var4 = xk9Var.a;
                xk9Var.a(kf9Var4 == null ? null : kf9Var4.b, kf9Var.b, new dg9(xk9Var));
                kf9 kf9Var5 = xk9Var.a;
                if (kf9Var5 != null) {
                    set = kf9Var5.c;
                }
                xk9Var.a(set, kf9Var.c, new hg9(xk9Var));
                xk9Var.a = kf9Var;
                z2 = true;
            }
            if (!z2) {
                LogPrinter.d("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            HostAppInfo.updateCfgv(wf9.b.getLong("key_config_v", 0L));
            if (g) {
                return;
            }
            g = true;
            if9 if9Var = if9.a;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (Ssp ssp3 : kf9Var.a) {
                if (!TextUtils.isEmpty(ssp3.sspId)) {
                    if (FunAdSdk.PLATFORM_CJ.equals(ssp3.type)) {
                        if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                            LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            LogPrinter.d("sdk for %s init start", ssp3.type);
                            nf9.c(ssp3.type, "com.fun.ad.sdk.channel.CjModule", funAdConfig, hashMap, ssp3.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                    } else if (!FunAdSdk.PLATFORM_CSJ.equals(ssp3.type)) {
                        arrayList.add(ssp3);
                    } else if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                    } else {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        LogPrinter.d("sdk for %s init start", ssp3.type);
                        nf9.c(ssp3.type, "com.fun.ad.sdk.channel.CsjModule", funAdConfig, hashMap, ssp3.sspId);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                nf9.b(currentTimeMillis, if9Var, hashMap);
                return;
            } else {
                new Thread(new mf9(arrayList, funAdConfig, hashMap, currentTimeMillis, if9Var)).start();
                return;
            }
        }
        kf9Var = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(kf9Var == null);
        objArr2[1] = Boolean.valueOf(z);
        LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (kf9Var != null) {
        }
    }
}
