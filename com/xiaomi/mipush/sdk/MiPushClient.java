package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.heytap.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.bp;
import com.xiaomi.push.dd;
import com.xiaomi.push.dn;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.id;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class CodeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long resultCode;

        public CodeResult() {
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

    /* loaded from: classes8.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: classes8.dex */
    public static abstract class MiPushClientCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String category;

        public MiPushClientCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes8.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes8.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
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
                com.xiaomi.push.t.a(edit);
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
            com.xiaomi.push.t.a(edit);
        }
    }

    public static void addRegRequestTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("last_reg_request", System.currentTimeMillis());
            com.xiaomi.push.t.a(edit);
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
            com.xiaomi.push.al.a(context).a(new Runnable(strArr, context) { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    public static void clearExtrasForInitialize(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            Iterator<String> it = getAllAlias(context).iterator();
            while (it.hasNext()) {
                edit.remove("alias_" + it.next());
            }
            Iterator<String> it2 = getAllUserAccount(context).iterator();
            while (it2.hasNext()) {
                edit.remove("account_" + it2.next());
            }
            Iterator<String> it3 = getAllTopic(context).iterator();
            while (it3.hasNext()) {
                edit.remove("topic_" + it3.next());
            }
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            edit.commit();
        }
    }

    public static void clearLocalNotificationType(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            ao.a(context).f();
        }
    }

    public static void clearNotification(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, context) == null) {
            ao.a(context).a(-1);
        }
    }

    public static void clearNotification(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65557, null, context, i) == null) {
            ao.a(context).a(i);
        }
    }

    public static void clearNotification(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, str, str2) == null) {
            ao.a(context).a(str, str2);
        }
    }

    public static void disablePush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, context) == null) {
            ao.a(context).a(true);
        }
    }

    public static void enablePush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            ao.a(context).a(false);
        }
    }

    public static String getAcceptTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59") : (String) invokeL.objValue;
    }

    public static List<String> getAllAlias(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (b.m141a(context).m150c()) {
                return b.m141a(context).f();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean getDefaultSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? com.xiaomi.push.m.m574b() : invokeV.booleanValue;
    }

    public static boolean getOpenFCMPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.b);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenHmsPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.a);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenOPPOPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            checkNotNull(context, "context");
            return f.a(context).b(e.c);
        }
        return invokeL.booleanValue;
    }

    public static boolean getOpenVIVOPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? f.a(context).b(e.d) : invokeL.booleanValue;
    }

    public static String getRegId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (b.m141a(context).m150c()) {
                return b.m141a(context).m149c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void initEventPerfLogic(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, context) == null) {
            en.a(new en.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.xiaomi.push.en.a
                public void uploader(Context context2, hn hnVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, hnVar) == null) {
                        MiTinyDataClient.upload(context2, hnVar);
                    }
                }
            });
            Config a = en.a(context);
            com.xiaomi.clientreport.manager.a.a(context).a("4_9_0");
            ClientReportClient.init(context, a, new el(context), new em(context));
            a.a(context);
            t.a(context, a);
            ba.a(context).a(new ba.a(100, "perf event job update", context) { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.xiaomi.push.service.ba.a
                public void onCallback() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        en.m320a(this.val$context);
                    }
                }
            });
        }
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65573, null, context, str, str2, miPushClientCallback) == null) {
            initialize(context, str, str2, miPushClientCallback, null, null);
        }
    }

    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{context, str, str2, miPushClientCallback, str3, iCallbackResult}) == null) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
                com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 4_9_0");
                com.xiaomi.push.ba.a(context).a();
                dd.a(context);
                if (miPushClientCallback != null) {
                    PushMessageHandler.a(miPushClientCallback);
                }
                if (iCallbackResult != null) {
                    PushMessageHandler.a(iCallbackResult);
                }
                if (com.xiaomi.push.v.m700a(sContext)) {
                    v.a(sContext);
                }
                boolean z = b.m141a(sContext).a() != Constants.a();
                if (!z && !shouldSendRegRequest(sContext)) {
                    ao.a(sContext).m132a();
                    com.xiaomi.channel.commonutils.logger.b.m99a("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z || !b.m141a(sContext).a(str, str2) || b.m141a(sContext).m153f()) {
                    String a = bp.a(6);
                    b.m141a(sContext).m143a();
                    b.m141a(sContext).a(Constants.a());
                    b.m141a(sContext).a(str, str2, a);
                    MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    clearNotification(context);
                    ij ijVar = new ij();
                    ijVar.a(bd.a());
                    ijVar.b(str);
                    ijVar.e(str2);
                    ijVar.d(sContext.getPackageName());
                    ijVar.f(a);
                    ijVar.c(com.xiaomi.push.h.m394a(sContext, sContext.getPackageName()));
                    ijVar.b(com.xiaomi.push.h.a(sContext, sContext.getPackageName()));
                    ijVar.h("4_9_0");
                    ijVar.a(40090);
                    ijVar.a(hx.c);
                    if (!TextUtils.isEmpty(str3)) {
                        ijVar.g(str3);
                    }
                    if (!com.xiaomi.push.m.m576d()) {
                        String e = com.xiaomi.push.j.e(sContext);
                        if (!TextUtils.isEmpty(e)) {
                            ijVar.i(bp.a(e) + "," + com.xiaomi.push.j.h(sContext));
                        }
                    }
                    int a2 = com.xiaomi.push.j.a();
                    if (a2 >= 0) {
                        ijVar.c(a2);
                    }
                    ao.a(sContext).a(ijVar, z);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, WebChromeClient.KEY_ARG_CALLBACK);
                        miPushClientCallback.onInitializeResult(0L, null, b.m141a(sContext).m149c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.m141a(sContext).m149c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ey.a.f357a, arrayList, 0L, null, null, null));
                    }
                    ao.a(sContext).m132a();
                    if (b.m141a(sContext).m145a()) {
                        ii iiVar = new ii();
                        iiVar.b(b.m141a(sContext).m142a());
                        iiVar.c(ht.g.f529a);
                        iiVar.a(bd.a());
                        HashMap hashMap = new HashMap();
                        iiVar.f668a = hashMap;
                        hashMap.put("app_version", com.xiaomi.push.h.m394a(sContext, sContext.getPackageName()));
                        iiVar.f668a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.h.a(sContext, sContext.getPackageName())));
                        iiVar.f668a.put("push_sdk_vn", "4_9_0");
                        iiVar.f668a.put("push_sdk_vc", Integer.toString(40090));
                        String e2 = b.m141a(sContext).e();
                        if (!TextUtils.isEmpty(e2)) {
                            iiVar.f668a.put("deviceid", e2);
                        }
                        ao.a(sContext).a((ao) iiVar, hj.i, false, (hw) null);
                    }
                    if (!com.xiaomi.push.n.m578a(sContext, "update_devId", false)) {
                        updateImeiOrOaid();
                        com.xiaomi.push.n.a(sContext, "update_devId", true);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        ii iiVar2 = new ii();
                        iiVar2.b(b.m141a(sContext).m142a());
                        iiVar2.c(ht.j.f529a);
                        iiVar2.a(bd.a());
                        iiVar2.a(false);
                        ao.a(sContext).a((ao) iiVar2, hj.i, false, (hw) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                av.a(sContext);
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
        if (interceptable == null || interceptable.invokeL(65575, null, context) == null) {
            if ("syncing".equals(af.a(sContext).a(au.a))) {
                disablePush(sContext);
            }
            if ("syncing".equals(af.a(sContext).a(au.b))) {
                enablePush(sContext);
            }
            if ("syncing".equals(af.a(sContext).a(au.c))) {
                syncAssemblePushToken(sContext);
            }
            if ("syncing".equals(af.a(sContext).a(au.d))) {
                syncAssembleFCMPushToken(sContext);
            }
            if ("syncing".equals(af.a(sContext).a(au.e))) {
                syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(af.a(sContext).a(au.f))) {
                syncAssembleFTOSPushToken(context);
            }
        }
    }

    public static void pausePush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, context, str) == null) {
            setAcceptTime(context, 0, 0, 0, 0, str);
        }
    }

    public static void reInitialize(Context context, hx hxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65577, null, context, hxVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + hxVar);
            String a = bp.a(6);
            String m142a = b.m141a(context).m142a();
            String b = b.m141a(context).b();
            b.m141a(context).m143a();
            clearExtrasForInitialize(context);
            clearNotification(context);
            b.m141a(context).a(Constants.a());
            b.m141a(context).a(m142a, b, a);
            ij ijVar = new ij();
            ijVar.a(bd.a());
            ijVar.b(m142a);
            ijVar.e(b);
            ijVar.f(a);
            ijVar.d(context.getPackageName());
            ijVar.c(com.xiaomi.push.h.m394a(context, context.getPackageName()));
            ijVar.b(com.xiaomi.push.h.a(context, context.getPackageName()));
            ijVar.h("4_9_0");
            ijVar.a(40090);
            ijVar.a(hxVar);
            int a2 = com.xiaomi.push.j.a();
            if (a2 >= 0) {
                ijVar.c(a2);
            }
            ao.a(context).a(ijVar, false);
        }
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, uncaughtExceptionHandler) == null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    public static void registerNetworkReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, context) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                com.xiaomi.push.o.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
                com.xiaomi.push.o.a(context, NetworkStatusReceiver.class);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m99a("dynamic register network status receiver failed:" + th);
            }
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65580, null, context, str, str2) == null) {
            registerPush(context, str, str2, new PushConfiguration());
        }
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65581, null, context, str, str2, pushConfiguration) == null) {
            registerPush(context, str, str2, pushConfiguration, null, null);
        }
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration, String str3, ICallbackResult iCallbackResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{context, str, str2, pushConfiguration, str3, iCallbackResult}) == null) {
            checkNotNull(context, "context");
            checkNotNull(str, Message.APP_ID);
            checkNotNull(str2, "appToken");
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            if (applicationContext == null) {
                sContext = context;
            }
            Context context2 = sContext;
            com.xiaomi.push.v.a(context2);
            if (!NetworkStatusReceiver.a()) {
                registerNetworkReceiver(sContext);
            }
            f.a(sContext).a(pushConfiguration);
            com.xiaomi.push.al.a(context2).a(new Runnable(str, str2, str3, iCallbackResult) { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
        if (interceptable == null || interceptable.invokeLLLL(65583, null, context, str, str2, str3) == null) {
            registerPush(context, str, str2, new PushConfiguration(), str3, null);
        }
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65584, null, context, str, str2, str3, uPSRegisterCallBack) == null) {
            registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
        }
    }

    public static synchronized void removeAcceptTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, null, context) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
                com.xiaomi.push.t.a(edit);
            }
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("account_" + str).commit();
            }
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65587, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("alias_" + str).commit();
            }
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllUserAccount(context)) {
                    removeAccount(context, str);
                }
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllAlias(context)) {
                    removeAlias(context, str);
                }
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, null, context) == null) {
            synchronized (MiPushClient.class) {
                for (String str : getAllTopic(context)) {
                    removeTopic(context, str);
                }
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65591, null, context, str) == null) {
            synchronized (MiPushClient.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
                edit.remove("topic_" + str).commit();
            }
        }
    }

    public static void removeWindow(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, context) == null) {
            ao.a(context).m140e();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65593, null, context, z) == null) && b.m141a(context).m148b()) {
            ht htVar = z ? ht.R : ht.Q;
            ii iiVar = new ii();
            iiVar.b(b.m141a(context).m142a());
            iiVar.c(htVar.f529a);
            iiVar.d(context.getPackageName());
            iiVar.a(bd.a());
            iiVar.a(false);
            ao.a(context).a((ao) iiVar, hj.i, false, (hw) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, hw hwVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65594, null, context, str, hwVar, str2, str3) == null) {
            ii iiVar = new ii();
            if (TextUtils.isEmpty(str3)) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            iiVar.b(str3);
            iiVar.c("bar:click");
            iiVar.a(str);
            iiVar.a(false);
            ao.a(context).a(iiVar, hj.i, false, true, hwVar, true, str2, str3);
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, null, context, miPushMessage) == null) {
            hw hwVar = new hw();
            hwVar.a(miPushMessage.getMessageId());
            hwVar.b(miPushMessage.getTopic());
            hwVar.d(miPushMessage.getDescription());
            hwVar.c(miPushMessage.getTitle());
            hwVar.c(miPushMessage.getNotifyId());
            hwVar.a(miPushMessage.getNotifyType());
            hwVar.b(miPushMessage.getPassThrough());
            hwVar.a(miPushMessage.getExtra());
            reportMessageClicked(context, miPushMessage.getMessageId(), hwVar, null);
        }
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65596, null, context, str) == null) {
            reportMessageClicked(context, str, null, null);
        }
    }

    public static void reportMessageClicked(Context context, String str, hw hwVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65597, null, context, str, hwVar, str2) == null) {
            ii iiVar = new ii();
            if (TextUtils.isEmpty(str2)) {
                if (!b.m141a(context).m148b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                    return;
                }
                str2 = b.m141a(context).m142a();
            }
            iiVar.b(str2);
            iiVar.c("bar:click");
            iiVar.a(str);
            iiVar.a(false);
            ao.a(context).a((ao) iiVar, hj.i, false, hwVar);
        }
    }

    public static void resumePush(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65598, null, context, str) == null) {
            setAcceptTime(context, 0, 0, 23, 59, str);
        }
    }

    public static void scheduleDataCollectionJobs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, null, context) == null) {
            if (ba.a(sContext).a(ho.z.a(), getDefaultSwitch())) {
                dn.a().a(new r(context));
                com.xiaomi.push.al.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Cdo.a(MiPushClient.sContext);
                        }
                    }
                }, 10);
            }
        }
    }

    public static void scheduleOcVersionCheckJob() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, null) == null) {
            com.xiaomi.push.al.a(sContext).a(new ae(sContext), ba.a(sContext).a(ho.A.a(), 86400), 5);
        }
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
                throw new IllegalArgumentException("the input parameter is not valid.");
            }
            long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
            long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
            long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
            arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
            if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
                setCommand(context, ey.i.f357a, arrayList, str);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str, ey.i.f357a, 0L, null, arrayList2);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.i.f357a, arrayList2, 0L, null, null, null));
            }
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65602, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ey.c.f357a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ey eyVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65603, null, context, str, str2, str3) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            if (ey.c.f357a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
                if (1 != PushMessageHelper.getPushMode(context)) {
                    eyVar = ey.c;
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eyVar.f357a, arrayList, 0L, null, str3, null));
                    return;
                }
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            }
            if (ey.d.f357a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (ey.e.f357a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
                if (1 != PushMessageHelper.getPushMode(context)) {
                    eyVar = ey.e;
                    PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(eyVar.f357a, arrayList, 0L, null, str3, null));
                    return;
                }
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else if (!ey.f.f357a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                setCommand(context, str, arrayList, str3);
                return;
            } else {
                sb = new StringBuilder();
                str4 = "Don't cancel account for ";
            }
            sb.append(str4);
            sb.append(bp.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
        }
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65604, null, context, str, arrayList, str2) == null) || TextUtils.isEmpty(b.m141a(context).m142a())) {
            return;
        }
        id idVar = new id();
        String a = bd.a();
        idVar.a(a);
        idVar.b(b.m141a(context).m142a());
        idVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            idVar.m466a(it.next());
        }
        idVar.e(str2);
        idVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
        ao.a(context).a((ao) idVar, hj.j, (hw) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65605, null, context, i) == null) {
            ao.a(context).b(i & (-1));
        }
    }

    public static void setUserAccount(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65606, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ey.e.f357a, str, str2);
    }

    public static boolean shouldPullNotification(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65607, null, context)) == null) ? Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000 : invokeL.booleanValue;
    }

    public static boolean shouldSendRegRequest(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65608, null, context)) == null) ? Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000 : invokeL.booleanValue;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65609, null, context)) == null) ? ao.a(context).m134a() : invokeL.booleanValue;
    }

    public static void subscribe(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65610, null, context, str, str2) == null) || TextUtils.isEmpty(b.m141a(context).m142a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ey.g.f357a, arrayList, 0L, null, null, null));
            return;
        }
        in inVar = new in();
        String a = bd.a();
        inVar.a(a);
        inVar.b(b.m141a(context).m142a());
        inVar.c(str);
        inVar.d(context.getPackageName());
        inVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ey.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
        ao.a(context).a((ao) inVar, hj.c, (hw) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, context) == null) {
            ao.a(context).a((String) null, au.e, e.c);
        }
    }

    public static void syncAssembleFCMPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, null, context) == null) {
            ao.a(context).a((String) null, au.d, e.b);
        }
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65613, null, context) == null) {
            ao.a(context).a((String) null, au.f, e.d);
        }
    }

    public static void syncAssemblePushToken(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65614, null, context) == null) {
            ao.a(context).a((String) null, au.c, e.a);
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65615, null, context, str)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            return sharedPreferences.getLong("topic_" + str, -1L);
        }
        return invokeLL.longValue;
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65616, null, context, uPSTurnCallBack) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65617, null, context, uPSTurnCallBack) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65618, null, context, uPSUnRegisterCallBack) == null) {
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
        if (interceptable == null || interceptable.invokeL(65619, null, context) == null) {
            i.c(context);
            ba.a(context).a();
            if (b.m141a(context).m148b()) {
                ip ipVar = new ip();
                ipVar.a(bd.a());
                ipVar.b(b.m141a(context).m142a());
                ipVar.c(b.m141a(context).m149c());
                ipVar.e(b.m141a(context).b());
                ipVar.d(context.getPackageName());
                ao.a(context).a(ipVar);
                PushMessageHandler.a();
                PushMessageHandler.b();
                b.m141a(context).m147b();
                clearLocalNotificationType(context);
                clearNotification(context);
                clearExtras(context);
            }
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65620, null, context, str, str2) == null) {
            setCommand(context, ey.d.f357a, str, str2);
        }
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65621, null, context, str, str2) == null) {
            setCommand(context, ey.f.f357a, str, str2);
        }
    }

    public static void unsubscribe(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65622, null, context, str, str2) == null) && b.m141a(context).m148b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m99a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ir irVar = new ir();
            String a = bd.a();
            irVar.a(a);
            irVar.b(b.m141a(context).m142a());
            irVar.c(str);
            irVar.d(context.getPackageName());
            irVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ey.h + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
            ao.a(context).a((ao) irVar, hj.d, (hw) null);
        }
    }

    public static void updateImeiOrOaid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65623, null) == null) {
            new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String d;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.xiaomi.push.m.m576d()) {
                        return;
                    }
                    if (com.xiaomi.push.j.d(MiPushClient.sContext) != null || com.xiaomi.push.ba.a(MiPushClient.sContext).a()) {
                        ii iiVar = new ii();
                        iiVar.b(b.m141a(MiPushClient.sContext).m142a());
                        iiVar.c(ht.g.f529a);
                        iiVar.a(bd.a());
                        iiVar.a(new HashMap());
                        String str = "";
                        if (!TextUtils.isEmpty(com.xiaomi.push.j.d(MiPushClient.sContext))) {
                            str = "" + bp.a(d);
                        }
                        String f = com.xiaomi.push.j.f(MiPushClient.sContext);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f)) {
                            str = str + "," + f;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            iiVar.m491a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                        }
                        com.xiaomi.push.ba.a(MiPushClient.sContext).a(iiVar.m491a());
                        int a = com.xiaomi.push.j.a();
                        if (a >= 0) {
                            iiVar.m491a().put("space_id", Integer.toString(a));
                        }
                        ao.a(MiPushClient.sContext).a((ao) iiVar, hj.i, false, (hw) null);
                    }
                }
            }).start();
        }
    }
}
