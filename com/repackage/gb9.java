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
import com.repackage.mb9;
import com.repackage.vg9;
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
/* loaded from: classes6.dex */
public final class gb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;
    public static final Handler b;
    public static FunAdSdk.SdkInitializeCallback c;
    public static final Handler d;
    public static final mg9 e;
    public static final vg9 f;
    public static boolean g;
    public static volatile boolean h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                gb9.e(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        fb9 fb9Var = new fb9();
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
                                str2 = jb9.a(stringWriter2, str);
                                LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                            }
                        } catch (Exception e) {
                            LogPrinter.e(e, "The initialized config from assets cannot be loaded.", new Object[0]);
                        }
                        if (fb9Var.b(str2)) {
                            LogPrinter.v("Config from assets parsed over with succeed", new Object[0]);
                        } else {
                            LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                            if (FunAdSdk.isLogEnabled()) {
                                throw new RuntimeException("Config from assets parsed failed");
                            }
                        }
                        gb9.b.obtainMessage(200).sendToTarget();
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
                        a = pb9.a();
                    }
                    if (i == 200) {
                        try {
                        } catch (Exception e4) {
                            LogPrinter.e(e4);
                            a = pb9.a();
                            i3 = -2;
                        }
                        if (new fb9().b(jb9.a(jSONObject.getJSONObject("data").getString("content"), FunAdSdk.getFunAdConfig().appId))) {
                            gb9.a.clear();
                            z = true;
                        } else {
                            a = pb9.a();
                            i3 = -3;
                            a.logEvent("k_ppcfg", "st", Integer.valueOf(i3));
                        }
                    }
                    lb9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                    if (z) {
                        gb9.b.sendEmptyMessage(200);
                    }
                    gb9.c();
                }
                LogPrinter.e("Pull ad config failed.", new Object[0]);
                lb9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                if (z) {
                }
                gb9.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755683661, "Lcom/repackage/gb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755683661, "Lcom/repackage/gb9;");
                return;
            }
        }
        a = new HashMap();
        b = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        d = new b(handlerThread.getLooper());
        e = new mg9();
        f = new vg9();
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            mb9 mb9Var = e.b;
            synchronized (mb9Var.a) {
                Deque<mb9.c> deque = mb9Var.a.get(str);
                i = 0;
                if (deque != null) {
                    Iterator<mb9.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        mb9.c next = descendingIterator.next();
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

    public static ob9 b(String str) {
        InterceptResult invokeL;
        ob9 ob9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            mg9 mg9Var = e;
            synchronized (mg9Var) {
                if (mg9Var.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    ob9Var = null;
                } else {
                    ob9Var = mg9Var.c.get(str);
                }
            }
            return ob9Var;
        }
        return (ob9) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = lb9.b;
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

    public static void d(ah9 ah9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ah9Var) == null) {
            h = true;
            vg9 vg9Var = f;
            synchronized (vg9Var.b) {
                vg9Var.e = ah9Var;
                vg9Var.d = 1;
                while (!vg9Var.c.isEmpty()) {
                    vg9.a pollFirst = vg9Var.c.pollFirst();
                    if (!vg9.f && pollFirst == null) {
                        throw new AssertionError();
                    }
                    vg9Var.loadAd(pollFirst.a, pollFirst.b, pollFirst.c);
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
        za9 za9Var;
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
        Set<ib9> set = null;
        String string = lb9.b.getString("key_adcfg", null);
        if (string != null && (decode = Base64.decode(string, 0)) != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(decode));
                za9Var = new za9(objectInputStream.readInt(), objectInputStream);
            } catch (IOException e2) {
                LogPrinter.e(e2);
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(za9Var == null);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (za9Var != null) {
                if (z) {
                    d.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                vg9 vg9Var = f;
                synchronized (vg9Var.b) {
                    vg9Var.d = -1;
                    while (!vg9Var.c.isEmpty()) {
                        vg9.a pollFirst = vg9Var.c.pollFirst();
                        if (!vg9.f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.c.onError(pollFirst.b.getSid());
                    }
                }
                return;
            }
            mg9 mg9Var = e;
            synchronized (mg9Var) {
                za9 za9Var2 = mg9Var.a;
                if (za9Var2 != null) {
                    if (za9Var2.equals(za9Var)) {
                        LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        za9 za9Var3 = mg9Var.a;
                        if (za9Var3.a.size() == za9Var.a.size()) {
                            HashSet hashSet = new HashSet(za9Var.a);
                            for (Ssp ssp : za9Var3.a) {
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
                za9 za9Var4 = mg9Var.a;
                mg9Var.a(za9Var4 == null ? null : za9Var4.b, za9Var.b, new sb9(mg9Var));
                za9 za9Var5 = mg9Var.a;
                if (za9Var5 != null) {
                    set = za9Var5.c;
                }
                mg9Var.a(set, za9Var.c, new wb9(mg9Var));
                mg9Var.a = za9Var;
                z2 = true;
            }
            if (!z2) {
                LogPrinter.d("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            HostAppInfo.updateCfgv(lb9.b.getLong("key_config_v", 0L));
            if (g) {
                return;
            }
            g = true;
            xa9 xa9Var = xa9.a;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (Ssp ssp3 : za9Var.a) {
                if (!TextUtils.isEmpty(ssp3.sspId)) {
                    if (FunAdSdk.PLATFORM_CJ.equals(ssp3.type)) {
                        if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                            LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                        } else {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            LogPrinter.d("sdk for %s init start", ssp3.type);
                            cb9.c(ssp3.type, "com.fun.ad.sdk.channel.CjModule", funAdConfig, hashMap, ssp3.sspId);
                            LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        }
                    } else if (!FunAdSdk.PLATFORM_CSJ.equals(ssp3.type)) {
                        arrayList.add(ssp3);
                    } else if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", ssp3.type);
                    } else {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        LogPrinter.d("sdk for %s init start", ssp3.type);
                        cb9.c(ssp3.type, "com.fun.ad.sdk.channel.CsjModule", funAdConfig, hashMap, ssp3.sspId);
                        LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                cb9.b(currentTimeMillis, xa9Var, hashMap);
                return;
            } else {
                new Thread(new bb9(arrayList, funAdConfig, hashMap, currentTimeMillis, xa9Var)).start();
                return;
            }
        }
        za9Var = null;
        Object[] objArr2 = new Object[2];
        objArr2[0] = Boolean.valueOf(za9Var == null);
        objArr2[1] = Boolean.valueOf(z);
        LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr2);
        if (za9Var != null) {
        }
    }
}
