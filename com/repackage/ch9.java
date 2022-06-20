package com.repackage;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.http.GetRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ch9 {
    public static /* synthetic */ Interceptable $ic;
    public static final jh9 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:51:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            boolean z;
            long j;
            long j2;
            Response perform;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                int i2 = 101;
                double d = 0.0d;
                boolean z2 = false;
                if (i == 100) {
                    HashMap hashMap = new HashMap();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        HostAppInfo.fillReqParams(jSONObject);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException unused) {
                    }
                    try {
                        perform = new GetRequest("https://cd.xdplt.com/v2/pr", new RequestParams(hashMap)).perform();
                    } catch (IOException | JSONException e) {
                        LogPrinter.d("cpm exception:" + e, new Object[0]);
                        LogPrinter.e(e);
                    }
                    if (perform != null && perform.getResponseCode() == 200) {
                        JSONObject jSONObject2 = new JSONObject(perform.getContent());
                        if (jSONObject2.getInt(Constants.KEYS.RET) == 200) {
                            vb9.a.edit().putLong("key_cpm_update_date", Calendar.getInstance().getTimeInMillis()).putString("key_ad_cpmcfg", jSONObject2.getJSONObject("data").getJSONArray("cpm").toString()).apply();
                            z = true;
                            if (!z) {
                            }
                        } else {
                            z = false;
                            if (!z) {
                                int i3 = message.arg1;
                                LogPrinter.d("ad cpm config pull times = %1s", Integer.valueOf(i3));
                                int i4 = i3 == 0 ? 10 : i3 <= 2 ? i3 * 5 * 60 : 3600;
                                Message obtainMessage = obtainMessage(100);
                                obtainMessage.arg1 = i3 + 1;
                                sendMessageDelayed(obtainMessage, i4 * 1000);
                                return;
                            }
                            jh9 jh9Var = ch9.a;
                            synchronized (jh9Var) {
                                jh9Var.a.clear();
                                try {
                                    JSONArray jSONArray = new JSONArray(vb9.a.getString("key_ad_cpmcfg", ""));
                                    if (jSONArray.length() >= 1) {
                                        double i5 = tb9.i();
                                        double a = vb9.a();
                                        HashMap hashMap2 = new HashMap();
                                        boolean z3 = false;
                                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                            JSONObject jSONObject3 = jSONArray.getJSONObject(i6);
                                            String string = jSONObject3.getString("aid");
                                            double d2 = jSONObject3.getDouble("cpm");
                                            LogPrinter.d("update Cpm:" + string, new Object[0]);
                                            hashMap2.put(string, Double.valueOf(d2));
                                            int i7 = vb9.a.getInt(string, 0);
                                            LogPrinter.d("need adjust aid count:" + i7, new Object[0]);
                                            if (i7 != 0) {
                                                a -= vb9.b(string);
                                                i5 += i7 * d2;
                                                vb9.b.remove(string).remove(string + "_");
                                                z3 = true;
                                            }
                                        }
                                        jh9Var.a.putAll(hashMap2);
                                        if (z3) {
                                            LogPrinter.d("update totalPrice&totalPriceByBasePrice", new Object[0]);
                                            if (a >= 0.0d) {
                                                d = a;
                                            }
                                            SharedPreferences.Editor editor = vb9.b;
                                            editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(d));
                                            editor.apply();
                                            tb9.c(i5);
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    jh9Var.a.clear();
                                }
                            }
                            Calendar calendar = Calendar.getInstance();
                            Random random = new Random();
                            long timeInMillis = calendar.getTimeInMillis();
                            int nextInt = random.nextInt(15);
                            calendar.set(11, 1);
                            calendar.set(12, nextInt);
                            Calendar calendar2 = Calendar.getInstance();
                            int i8 = calendar2.get(6);
                            int i9 = calendar2.get(1);
                            calendar2.setTimeInMillis(vb9.a.getLong("key_cpm_update_date", 0L));
                            int i10 = calendar2.get(6);
                            if (i9 == calendar2.get(1) && i8 == i10) {
                                z2 = true;
                            }
                            if (z2) {
                                calendar.add(6, 1);
                            }
                            long timeInMillis2 = calendar.getTimeInMillis() - timeInMillis;
                            j = 0;
                            if (timeInMillis2 >= 0) {
                                j2 = timeInMillis2;
                                i2 = 100;
                                sendEmptyMessageDelayed(i2, j2);
                            }
                            i2 = 100;
                        }
                    }
                    LogPrinter.d("cpm fail:", new Object[0]);
                    z = false;
                    if (!z) {
                    }
                } else if (i != 101) {
                    return;
                } else {
                    jh9 jh9Var2 = ch9.a;
                    synchronized (jh9Var2) {
                        LogPrinter.d("new dey", new Object[0]);
                        double a2 = vb9.a();
                        vb9.b.clear().apply();
                        jh9Var2.a.clear();
                        if (a2 > 0.0d) {
                            tb9.c(tb9.i() + a2);
                        }
                    }
                    Calendar calendar3 = Calendar.getInstance();
                    long timeInMillis3 = calendar3.getTimeInMillis();
                    calendar3.add(6, 1);
                    calendar3.set(11, 0);
                    calendar3.set(12, 0);
                    calendar3.set(13, 0);
                    j = calendar3.getTimeInMillis() - timeInMillis3;
                    if (j < 0) {
                        j = 0;
                    }
                }
                j2 = j;
                sendEmptyMessageDelayed(i2, j2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755797059, "Lcom/repackage/ch9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755797059, "Lcom/repackage/ch9;");
                return;
            }
        }
        a = new jh9();
        HandlerThread handlerThread = new HandlerThread("pull_pid_cpm");
        handlerThread.start();
        new a(handlerThread.getLooper());
    }
}
