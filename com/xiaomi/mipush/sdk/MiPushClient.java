package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ax;
import com.xiaomi.push.bm;
import com.xiaomi.push.dj;
import com.xiaomi.push.dk;
import com.xiaomi.push.ei;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import com.xiaomi.push.ev;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public abstract class MiPushClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    public static Context sContext;
    public static long sCurMsgId;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class CodeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long resultCode;

        public CodeResult() {
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
            this.resultCode = -1L;
        }

        public long getResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resultCode : invokeV.longValue;
        }

        public void setResultCode(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.resultCode = j;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public static abstract class MiPushClientCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String category;

        public MiPushClientCallback() {
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

        public String getCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.category : (String) invokeV.objValue;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), str2, list}) == null) {
            }
        }

        public void onInitializeResult(long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            }
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, miPushMessage) == null) {
            }
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            }
        }

        public void onSubscribeResult(long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            }
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            }
        }

        public void setCategory(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.category = str;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TokenResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long resultCode;
        public String token;

        public TokenResult() {
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
            this.token = null;
            this.resultCode = -1L;
        }

        public long getResultCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resultCode : invokeV.longValue;
        }

        public String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.token : (String) invokeV.objValue;
        }

        public void setResultCode(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.resultCode = j;
            }
        }

        public void setToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.token = str;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes2.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes2.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-749630394, "Lcom/xiaomi/mipush/sdk/MiPushClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-749630394, "Lcom/xiaomi/mipush/sdk/MiPushClient;");
                return;
            }
        }
        sCurMsgId = System.currentTimeMillis();
    }

    public MiPushClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean acceptTimeSet(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            String acceptTime = getAcceptTime(context);
            return TextUtils.equals(acceptTime, str + "," + str2);
        }
        return invokeLLL.booleanValue;
    }

    public static long accountSetTime(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            return sharedPreferences.getLong("account_" + str, -1L);
        }
        return invokeLL.longValue;
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, str2) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
                com.xiaomi.push.r.a(edit);
            }
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putLong("account_" + str, System.currentTimeMillis()).commit();
            }
        }
    }

    public static synchronized void addAlias(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
            }
        }
    }

    public static void addPullNotificationTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("last_pull_notification", System.currentTimeMillis());
            com.xiaomi.push.r.a(edit);
        }
    }

    public static void addRegRequestTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("last_reg_request", System.currentTimeMillis());
            com.xiaomi.push.r.a(edit);
        }
    }

    public static synchronized void addTopic(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
            }
        }
    }

    public static long aliasSetTime(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            return sharedPreferences.getLong("alias_" + str, -1L);
        }
        return invokeLL.longValue;
    }

    public static void awakeApps(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, strArr) == null) {
            com.xiaomi.push.ai.a(context).a(new Runnable(strArr, context) { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String[] val$packageNames;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {strArr, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$packageNames = strArr;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String[] strArr2;
                    PackageInfo packageInfo;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            for (String str : this.val$packageNames) {
                                if (!TextUtils.isEmpty(str) && (packageInfo = this.val$context.getPackageManager().getPackageInfo(str, 4)) != null) {
                                    MiPushClient.awakePushServiceByPackageInfo(this.val$context, packageInfo);
                                }
                            }
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.a(th);
                        }
                    }
                }
            });
        }
    }

    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, context, packageInfo) == null) || (serviceInfoArr = packageInfo.services) == null) {
            return;
        }
        for (ServiceInfo serviceInfo : serviceInfoArr) {
            if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                try {
                    Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    Intent intent = new Intent();
                    intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                    intent.putExtra("waker_pkgname", context.getPackageName());
                    PushMessageHandler.a(context, intent);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
        }
    }

    public static void checkNotNull(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, obj, str) == null) && obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    public static void clearExtras(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.clear();
            edit.commit();
        }
    }

    public static void clearLocalNotificationType(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            an.a(context).m113e();
        }
    }

    public static void clearNotification(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            an.a(context).a(-1);
        }
    }

    public static void clearNotification(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, context, i2) == null) {
            an.a(context).a(i2);
        }
    }

    public static void clearNotification(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, context, str, str2) == null) {
            an.a(context).a(str, str2);
        }
    }

    public static void disablePush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, context) == null) {
            an.a(context).a(true);
        }
    }

    public static void enablePush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, context) == null) {
            an.a(context).a(false);
        }
    }

    public static String getAcceptTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59") : (String) invokeL.objValue;
    }

    public static List<String> getAllAlias(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
                if (str.startsWith("alias_")) {
                    arrayList.add(str.substring(6));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> getAllTopic(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
                if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                    arrayList.add(str.substring(6));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> getAllUserAccount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
                if (str.startsWith("account_")) {
                    arrayList.add(str.substring(8));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String getAppRegion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (b.m114a(context).m123c()) {
                return b.m114a(context).f();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean getDefaultSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? com.xiaomi.push.l.m541b() : invokeV.booleanValue;
    }

    public static boolean getOpenFCMPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.f71542b);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenHmsPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.f71541a);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenOPPOPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.f71543c);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenVIVOPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? f.a(context).b(e.f71544d) : invokeL.booleanValue;
    }

    public static String getRegId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (b.m114a(context).m123c()) {
                return b.m114a(context).m122c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void initEventPerfLogic(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, context) == null) {
            ek.a(new ek.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

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
                        }
                    }
                }

                @Override // com.xiaomi.push.ek.a
                public void uploader(Context context2, hj hjVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, hjVar) == null) {
                        MiTinyDataClient.upload(context2, hjVar);
                    }
                }
            });
            Config a2 = ek.a(context);
            com.xiaomi.clientreport.manager.a.a(context).a("3_8_5");
            ClientReportClient.init(context, a2, new ei(context), new ej(context));
            a.a(context);
            s.a(context, a2);
            com.xiaomi.push.service.aq.a(context).a(new aq.a(100, "perf event job update", context) { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8, r9);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r8), r9, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.xiaomi.push.service.aq.a
                public void onCallback() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ek.m290a(this.val$context);
                    }
                }
            });
        }
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65572, null, context, str, str2, miPushClientCallback) == null) {
            initialize(context, str, str2, miPushClientCallback, null, null);
        }
    }

    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{context, str, str2, miPushClientCallback, str3, iCallbackResult}) == null) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
                com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 3_8_5");
                if (miPushClientCallback != null) {
                    PushMessageHandler.a(miPushClientCallback);
                }
                if (iCallbackResult != null) {
                    PushMessageHandler.a(iCallbackResult);
                }
                if (com.xiaomi.push.t.m643a(sContext)) {
                    u.a(sContext);
                }
                boolean z = b.m114a(sContext).a() != Constants.a();
                if (!z && !shouldSendRegRequest(sContext)) {
                    an.a(sContext).m105a();
                    com.xiaomi.channel.commonutils.logger.b.m73a("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z || !b.m114a(sContext).a(str, str2) || b.m114a(sContext).m126f()) {
                    String a2 = bm.a(6);
                    b.m114a(sContext).m116a();
                    b.m114a(sContext).a(Constants.a());
                    b.m114a(sContext).a(str, str2, a2);
                    MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    clearNotification(context);
                    Cif cif = new Cif();
                    cif.a(com.xiaomi.push.service.at.a());
                    cif.b(str);
                    cif.e(str2);
                    cif.d(sContext.getPackageName());
                    cif.f(a2);
                    cif.c(com.xiaomi.push.g.m341a(sContext, sContext.getPackageName()));
                    cif.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                    cif.h("3_8_5");
                    cif.a(30805);
                    cif.a(ht.f72077c);
                    if (!TextUtils.isEmpty(str3)) {
                        cif.g(str3);
                    }
                    if (!com.xiaomi.push.l.d()) {
                        String g2 = com.xiaomi.push.i.g(sContext);
                        if (!TextUtils.isEmpty(g2)) {
                            cif.i(bm.a(g2) + "," + com.xiaomi.push.i.j(sContext));
                        }
                    }
                    int a3 = com.xiaomi.push.i.a();
                    if (a3 >= 0) {
                        cif.c(a3);
                    }
                    an.a(sContext).a(cif, z);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, "callback");
                        miPushClientCallback.onInitializeResult(0L, null, b.m114a(sContext).m122c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.m114a(sContext).m122c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ev.f71816a.f345a, arrayList, 0L, null, null));
                    }
                    an.a(sContext).m105a();
                    if (b.m114a(sContext).m118a()) {
                        ie ieVar = new ie();
                        ieVar.b(b.m114a(sContext).m115a());
                        ieVar.c(hp.f72047g.f514a);
                        ieVar.a(com.xiaomi.push.service.at.a());
                        HashMap hashMap = new HashMap();
                        ieVar.f655a = hashMap;
                        hashMap.put("app_version", com.xiaomi.push.g.m341a(sContext, sContext.getPackageName()));
                        ieVar.f655a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                        ieVar.f655a.put("push_sdk_vn", "3_8_5");
                        ieVar.f655a.put("push_sdk_vc", Integer.toString(30805));
                        com.xiaomi.push.i.a(sContext, ieVar.f655a);
                        String e2 = b.m114a(sContext).e();
                        if (!TextUtils.isEmpty(e2)) {
                            ieVar.f655a.put(DeviceUtils.KEY_OLD_NAME_STRING, e2);
                        }
                        an.a(sContext).a((an) ieVar, hf.f71998i, false, (hs) null);
                    }
                    if (!com.xiaomi.push.n.m542a(sContext, "update_devId", false)) {
                        updateImeiOrOaid();
                        com.xiaomi.push.n.a(sContext, "update_devId", true);
                    }
                    String c2 = com.xiaomi.push.i.c(sContext);
                    if (!TextUtils.isEmpty(c2)) {
                        hz hzVar = new hz();
                        hzVar.a(com.xiaomi.push.service.at.a());
                        hzVar.b(str);
                        hzVar.c(ev.j.f345a);
                        ArrayList arrayList2 = new ArrayList();
                        String b2 = com.xiaomi.push.i.b(sContext);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList2.add(b2);
                        }
                        if (c2 == null) {
                            c2 = "";
                        }
                        arrayList2.add(c2);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                        arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                        hzVar.a(arrayList2);
                        an.a(sContext).a((an) hzVar, hf.j, false, (hs) null);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        ie ieVar2 = new ie();
                        ieVar2.b(b.m114a(sContext).m115a());
                        ieVar2.c(hp.j.f514a);
                        ieVar2.a(com.xiaomi.push.service.at.a());
                        ieVar2.a(false);
                        an.a(sContext).a((an) ieVar2, hf.f71998i, false, (hs) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                au.a(sContext);
                if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (Logger.getUserLogger() != null) {
                        Logger.setLogger(sContext, Logger.getUserLogger());
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(2);
                }
                operateSyncAction(context);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            }
        }
    }

    public static void operateSyncAction(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, context) == null) {
            if ("syncing".equals(ae.a(sContext).a(at.f71525a))) {
                disablePush(sContext);
            }
            if ("syncing".equals(ae.a(sContext).a(at.f71526b))) {
                enablePush(sContext);
            }
            if ("syncing".equals(ae.a(sContext).a(at.f71527c))) {
                syncAssemblePushToken(sContext);
            }
            if ("syncing".equals(ae.a(sContext).a(at.f71528d))) {
                syncAssembleFCMPushToken(sContext);
            }
            if ("syncing".equals(ae.a(sContext).a(at.f71529e))) {
                syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(ae.a(sContext).a(at.f71530f))) {
                syncAssembleFTOSPushToken(context);
            }
        }
    }

    public static void pausePush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, context, str) == null) {
            setAcceptTime(context, 0, 0, 0, 0, str);
        }
    }

    public static void reInitialize(Context context, ht htVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, context, htVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + htVar);
            String a2 = bm.a(6);
            String m115a = b.m114a(context).m115a();
            String b2 = b.m114a(context).b();
            b.m114a(context).m116a();
            clearNotification(context);
            b.m114a(context).a(Constants.a());
            b.m114a(context).a(m115a, b2, a2);
            Cif cif = new Cif();
            cif.a(com.xiaomi.push.service.at.a());
            cif.b(m115a);
            cif.e(b2);
            cif.f(a2);
            cif.d(context.getPackageName());
            cif.c(com.xiaomi.push.g.m341a(context, context.getPackageName()));
            cif.b(com.xiaomi.push.g.a(context, context.getPackageName()));
            cif.h("3_8_5");
            cif.a(30805);
            cif.a(htVar);
            int a3 = com.xiaomi.push.i.a();
            if (a3 >= 0) {
                cif.c(a3);
            }
            an.a(context).a(cif, false);
        }
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, uncaughtExceptionHandler) == null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public static void registerNetworkReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, context) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            }
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65579, null, context, str, str2) == null) {
            registerPush(context, str, str2, new PushConfiguration());
        }
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65580, null, context, str, str2, pushConfiguration) == null) {
            registerPush(context, str, str2, pushConfiguration, null, null);
        }
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration, String str3, ICallbackResult iCallbackResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{context, str, str2, pushConfiguration, str3, iCallbackResult}) == null) {
            checkNotNull(context, "context");
            checkNotNull(str, Message.APP_ID);
            checkNotNull(str2, "appToken");
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            if (applicationContext == null) {
                sContext = context;
            }
            Context context2 = sContext;
            com.xiaomi.push.t.m641a(context2);
            if (!NetworkStatusReceiver.a()) {
                registerNetworkReceiver(sContext);
            }
            f.a(sContext).a(pushConfiguration);
            com.xiaomi.push.ai.a(context2).a(new Runnable(str, str2, str3, iCallbackResult) { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$alias;
                public final /* synthetic */ String val$appID;
                public final /* synthetic */ String val$appToken;
                public final /* synthetic */ ICallbackResult val$iCallbackResult;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, str2, str3, iCallbackResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$appID = str;
                    this.val$appToken = str2;
                    this.val$alias = str3;
                    this.val$iCallbackResult = iCallbackResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MiPushClient.initialize(MiPushClient.sContext, this.val$appID, this.val$appToken, null, this.val$alias, this.val$iCallbackResult);
                    }
                }
            });
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65582, null, context, str, str2, str3) == null) {
            registerPush(context, str, str2, new PushConfiguration(), str3, null);
        }
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65583, null, context, str, str2, str3, uPSRegisterCallBack) == null) {
            registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
        }
    }

    public static synchronized void removeAcceptTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, context) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
                com.xiaomi.push.r.a(edit);
            }
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("account_" + str).commit();
            }
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("alias_" + str).commit();
            }
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllUserAccount(context)) {
                    removeAccount(context, str);
                }
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllAlias(context)) {
                    removeAlias(context, str);
                }
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllTopic(context)) {
                    removeTopic(context, str);
                }
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65590, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("topic_" + str).commit();
            }
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65591, null, context, z) == null) && b.m114a(context).m121b()) {
            hp hpVar = z ? hp.R : hp.Q;
            ie ieVar = new ie();
            ieVar.b(b.m114a(context).m115a());
            ieVar.c(hpVar.f514a);
            ieVar.d(context.getPackageName());
            ieVar.a(com.xiaomi.push.service.at.a());
            ieVar.a(false);
            an.a(context).a((an) ieVar, hf.f71998i, false, (hs) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, hs hsVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65592, null, context, str, hsVar, str2, str3) == null) {
            ie ieVar = new ie();
            if (TextUtils.isEmpty(str3)) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            ieVar.b(str3);
            ieVar.c("bar:click");
            ieVar.a(str);
            ieVar.a(false);
            an.a(context).a(ieVar, hf.f71998i, false, true, hsVar, true, str2, str3);
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, context, miPushMessage) == null) {
            hs hsVar = new hs();
            hsVar.a(miPushMessage.getMessageId());
            hsVar.b(miPushMessage.getTopic());
            hsVar.d(miPushMessage.getDescription());
            hsVar.c(miPushMessage.getTitle());
            hsVar.c(miPushMessage.getNotifyId());
            hsVar.a(miPushMessage.getNotifyType());
            hsVar.b(miPushMessage.getPassThrough());
            hsVar.a(miPushMessage.getExtra());
            reportMessageClicked(context, miPushMessage.getMessageId(), hsVar, null);
        }
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65594, null, context, str) == null) {
            reportMessageClicked(context, str, null, null);
        }
    }

    public static void reportMessageClicked(Context context, String str, hs hsVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65595, null, context, str, hsVar, str2) == null) {
            ie ieVar = new ie();
            if (TextUtils.isEmpty(str2)) {
                if (!b.m114a(context).m121b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                    return;
                }
                str2 = b.m114a(context).m115a();
            }
            ieVar.b(str2);
            ieVar.c("bar:click");
            ieVar.a(str);
            ieVar.a(false);
            an.a(context).a((an) ieVar, hf.f71998i, false, hsVar);
        }
    }

    public static void resumePush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65596, null, context, str) == null) {
            setAcceptTime(context, 0, 0, 23, 59, str);
        }
    }

    public static void scheduleDataCollectionJobs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, context) == null) {
            if (com.xiaomi.push.service.aq.a(sContext).a(hk.z.a(), getDefaultSwitch())) {
                dj.a().a(new r(context));
                com.xiaomi.push.ai.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

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
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            dk.a(MiPushClient.sContext);
                        }
                    }
                }, 10);
            }
        }
    }

    public static void scheduleOcVersionCheckJob() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, null) == null) {
            com.xiaomi.push.ai.a(sContext).a(new ad(sContext), com.xiaomi.push.service.aq.a(sContext).a(hk.A.a(), 86400), 5);
        }
    }

    public static void setAcceptTime(Context context, int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65599, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            if (i2 < 0 || i2 >= 24 || i4 < 0 || i4 >= 24 || i3 < 0 || i3 >= 60 || i5 < 0 || i5 >= 60) {
                throw new IllegalArgumentException("the input parameter is not valid.");
            }
            long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
            long j = ((((i2 * 60) + i3) + rawOffset) + 1440) % 1440;
            long j2 = ((((i4 * 60) + i5) + rawOffset) + 1440) % 1440;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i2), Integer.valueOf(i3)));
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i4), Integer.valueOf(i5)));
            if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
                setCommand(context, ev.f71824i.f345a, arrayList, str);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str, ev.f71824i.f345a, 0L, null, arrayList2);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ev.f71824i.f345a, arrayList2, 0L, null, null));
            }
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65600, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ev.f71818c.f345a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ev evVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65601, null, context, str, str2, str3) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            if (ev.f71818c.f345a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
                if (1 != PushMessageHelper.getPushMode(context)) {
                    evVar = ev.f71818c;
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(evVar.f345a, arrayList, 0L, null, str3));
                    return;
                }
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            }
            if (ev.f71819d.f345a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (ev.f71820e.f345a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
                if (1 != PushMessageHelper.getPushMode(context)) {
                    evVar = ev.f71820e;
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(evVar.f345a, arrayList, 0L, null, str3));
                    return;
                }
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else if (!ev.f71821f.f345a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                setCommand(context, str, arrayList, str3);
                return;
            } else {
                sb = new StringBuilder();
                str4 = "Don't cancel account for ";
            }
            sb.append(str4);
            sb.append(bm.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
        }
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65602, null, context, str, arrayList, str2) == null) || TextUtils.isEmpty(b.m114a(context).m115a())) {
            return;
        }
        hz hzVar = new hz();
        String a2 = com.xiaomi.push.service.at.a();
        hzVar.a(a2);
        hzVar.b(b.m114a(context).m115a());
        hzVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            hzVar.m435a(it.next());
        }
        hzVar.e(str2);
        hzVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
        an.a(context).a((an) hzVar, hf.j, (hs) null);
    }

    public static void setLocalNotificationType(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65603, null, context, i2) == null) {
            an.a(context).b(i2 & (-1));
        }
    }

    public static void setUserAccount(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65604, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ev.f71820e.f345a, str, str2);
    }

    public static boolean shouldPullNotification(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65605, null, context)) == null) ? Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000 : invokeL.booleanValue;
    }

    public static boolean shouldSendRegRequest(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65606, null, context)) == null) ? Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000 : invokeL.booleanValue;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65607, null, context)) == null) ? an.a(context).m107a() : invokeL.booleanValue;
    }

    public static void subscribe(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65608, null, context, str, str2) == null) || TextUtils.isEmpty(b.m114a(context).m115a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ev.f71822g.f345a, arrayList, 0L, null, null));
            return;
        }
        ij ijVar = new ij();
        String a2 = com.xiaomi.push.service.at.a();
        ijVar.a(a2);
        ijVar.b(b.m114a(context).m115a());
        ijVar.c(str);
        ijVar.d(context.getPackageName());
        ijVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ev.f71822g + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
        an.a(context).a((an) ijVar, hf.f71992c, (hs) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, context) == null) {
            an.a(context).a((String) null, at.f71529e, e.f71543c);
        }
    }

    public static void syncAssembleFCMPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, context) == null) {
            an.a(context).a((String) null, at.f71528d, e.f71542b);
        }
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, context) == null) {
            an.a(context).a((String) null, at.f71530f, e.f71544d);
        }
    }

    public static void syncAssemblePushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, null, context) == null) {
            an.a(context).a((String) null, at.f71527c, e.f71541a);
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65613, null, context, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            return sharedPreferences.getLong("topic_" + str, -1L);
        }
        return invokeLL.longValue;
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65614, null, context, uPSTurnCallBack) == null) {
            disablePush(context);
            if (uPSTurnCallBack != null) {
                CodeResult codeResult = new CodeResult();
                codeResult.setResultCode(0L);
                codeResult.getResultCode();
                uPSTurnCallBack.onResult(codeResult);
            }
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65615, null, context, uPSTurnCallBack) == null) {
            enablePush(context);
            if (uPSTurnCallBack != null) {
                CodeResult codeResult = new CodeResult();
                codeResult.setResultCode(0L);
                codeResult.getResultCode();
                uPSTurnCallBack.onResult(codeResult);
            }
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65616, null, context, uPSUnRegisterCallBack) == null) {
            unregisterPush(context);
            if (uPSUnRegisterCallBack != null) {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(null);
                tokenResult.getToken();
                tokenResult.setResultCode(0L);
                tokenResult.getResultCode();
                uPSUnRegisterCallBack.onResult(tokenResult);
            }
        }
    }

    public static void unregisterPush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65617, null, context) == null) {
            i.c(context);
            com.xiaomi.push.service.aq.a(context).a();
            if (b.m114a(context).m121b()) {
                il ilVar = new il();
                ilVar.a(com.xiaomi.push.service.at.a());
                ilVar.b(b.m114a(context).m115a());
                ilVar.c(b.m114a(context).m122c());
                ilVar.e(b.m114a(context).b());
                ilVar.d(context.getPackageName());
                an.a(context).a(ilVar);
                PushMessageHandler.a();
                PushMessageHandler.b();
                b.m114a(context).m120b();
                clearLocalNotificationType(context);
                clearNotification(context);
                clearExtras(context);
            }
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65618, null, context, str, str2) == null) {
            setCommand(context, ev.f71819d.f345a, str, str2);
        }
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65619, null, context, str, str2) == null) {
            setCommand(context, ev.f71821f.f345a, str, str2);
        }
    }

    public static void unsubscribe(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65620, null, context, str, str2) == null) && b.m114a(context).m121b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            in inVar = new in();
            String a2 = com.xiaomi.push.service.at.a();
            inVar.a(a2);
            inVar.b(b.m114a(context).m115a());
            inVar.c(str);
            inVar.d(context.getPackageName());
            inVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ev.f71823h + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
            an.a(context).a((an) inVar, hf.f71993d, (hs) null);
        }
    }

    public static void updateImeiOrOaid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65621, null) == null) {
            new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

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
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String f2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.xiaomi.push.l.d()) {
                        return;
                    }
                    if (com.xiaomi.push.i.f(MiPushClient.sContext) != null || ax.a(MiPushClient.sContext).a()) {
                        ie ieVar = new ie();
                        ieVar.b(b.m114a(MiPushClient.sContext).m115a());
                        ieVar.c(hp.f72047g.f514a);
                        ieVar.a(com.xiaomi.push.service.at.a());
                        ieVar.a(new HashMap());
                        String str = "";
                        if (!TextUtils.isEmpty(com.xiaomi.push.i.f(MiPushClient.sContext))) {
                            str = "" + bm.a(f2);
                        }
                        String h2 = com.xiaomi.push.i.h(MiPushClient.sContext);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h2)) {
                            str = str + "," + h2;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            ieVar.m469a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                        }
                        ax.a(MiPushClient.sContext).a(ieVar.m469a());
                        com.xiaomi.push.i.a(MiPushClient.sContext, ieVar.f655a);
                        int a2 = com.xiaomi.push.i.a();
                        if (a2 >= 0) {
                            ieVar.m469a().put("space_id", Integer.toString(a2));
                        }
                        an.a(MiPushClient.sContext).a((an) ieVar, hf.f71998i, false, (hs) null);
                    }
                }
            }).start();
        }
    }
}
