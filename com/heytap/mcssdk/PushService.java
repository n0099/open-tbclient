package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.d.d;
import com.heytap.mcssdk.e.c;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.mcs.aidl.IMcsSdkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PushService implements com.heytap.mcssdk.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_PACKAGE = "appPackage";
    public static final String APP_VERSION_CODE = "versionCode";
    public static final String APP_VERSION_NAME = "versionName";
    public static final int DEFAULT_API_MAX_COUNT = 2;
    public static final String EVENT_ID = "eventID";
    public static final String EXTRA = "extra";
    public static final String GLOBAL_ID = "globalID";
    public static final int MAX_HOUR_IN_DAY = 23;
    public static final int MAX_MIN_IN_HOUR = 59;
    public static final int MCS_SUPPORT_VERSION = 1019;
    public static final String MESSAGE_ID = "messageID";
    public static final String MESSAGE_TYPE = "messageType";
    public static String NEW_MCS_RECEIVE_SDK_ACTION = null;
    public static final String NEW_MCS_RECEIVE_SDK_ACTION_Base64 = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    public static final int[] OLD_MCS_PACKAGE;
    public static final int[] OLD_MCS_RECEIVE_SDK_ACTION;
    public static final String PUSH_SDK_VERSION = "pushSdkVersion";
    public static final int SDK_INT_24 = 24;
    public static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    public static final int SYSTEM_UID = 1000;
    public static final String TASK_ID = "taskID";
    public static final String TYPE = "type";
    public static int sCount;
    public static boolean sIsNewMcsPkg;
    public static String sMcsPkgName;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Integer, com.heytap.mcssdk.c.a> mAppLimitMap;
    public String mAuthCode;
    public Context mContext;
    public ICallBackResultService mICallBackResultService;
    public IGetAppNotificationCallBackService mIGetAppNotificationCallBackService;
    public ISetAppNotificationCallBackService mISetAppNotificationCallBackService;
    public List<d> mParsers;
    public List<c> mProcessors;
    public String mRegisterID;
    public String mVerifyCode;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final PushService a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1467649799, "Lcom/heytap/mcssdk/PushService$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1467649799, "Lcom/heytap/mcssdk/PushService$a;");
                    return;
                }
            }
            a = new PushService();
        }

        public a() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1248453220, "Lcom/heytap/mcssdk/PushService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1248453220, "Lcom/heytap/mcssdk/PushService;");
                return;
            }
        }
        OLD_MCS_PACKAGE = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
        OLD_MCS_RECEIVE_SDK_ACTION = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
        NEW_MCS_RECEIVE_SDK_ACTION = "";
        sCount = 0;
    }

    public PushService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        this.mRegisterID = null;
        synchronized (PushService.class) {
            if (sCount > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            sCount++;
        }
        addParser(new com.heytap.mcssdk.d.b());
        addParser(new com.heytap.mcssdk.d.a());
        addProcessor(new com.heytap.mcssdk.e.b());
        addProcessor(new com.heytap.mcssdk.e.a());
        this.mAppLimitMap = new ConcurrentHashMap<>();
    }

    private com.heytap.mcssdk.c.a addCommandToMap(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if (!this.mAppLimitMap.containsKey(Integer.valueOf(i))) {
                com.heytap.mcssdk.c.a aVar = new com.heytap.mcssdk.c.a(System.currentTimeMillis(), 1);
                this.mAppLimitMap.put(Integer.valueOf(i), aVar);
                com.heytap.mcssdk.utils.d.b("addCommandToMap :appBean is null");
                return aVar;
            }
            com.heytap.mcssdk.c.a aVar2 = this.mAppLimitMap.get(Integer.valueOf(i));
            if (checkTimeNeedUpdate(aVar2)) {
                aVar2.a(1);
                aVar2.a(System.currentTimeMillis());
                str = "addCommandToMap : appLimitBean.setCount(1)";
            } else {
                aVar2.a(aVar2.b() + 1);
                str = "addCommandToMap :appLimitBean.getCount() + 1";
            }
            com.heytap.mcssdk.utils.d.b(str);
            return aVar2;
        }
        return (com.heytap.mcssdk.c.a) invokeI.objValue;
    }

    private synchronized void addParser(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, dVar) == null) {
            synchronized (this) {
                if (dVar != null) {
                    this.mParsers.add(dVar);
                }
            }
        }
    }

    private synchronized void addProcessor(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, cVar) == null) {
            synchronized (this) {
                if (cVar != null) {
                    this.mProcessors.add(cVar);
                }
            }
        }
    }

    private boolean checkAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? checkContext() && checkRegisterID() : invokeV.booleanValue;
    }

    private boolean checkContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.mContext != null : invokeV.booleanValue;
    }

    private boolean checkRegisterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.mRegisterID != null : invokeV.booleanValue;
    }

    private boolean checkTimeNeedUpdate(com.heytap.mcssdk.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, aVar)) == null) {
            long a2 = aVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            com.heytap.mcssdk.utils.d.b("checkTimeNeedUpdate : lastedTime " + a2 + " currentTime:" + currentTimeMillis);
            return currentTimeMillis - a2 > 1000;
        }
        return invokeL.booleanValue;
    }

    public static PushService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.a : (PushService) invokeV.objValue;
    }

    private Intent getIntent(int i, String str, JSONObject jSONObject) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65548, this, i, str, jSONObject)) == null) {
            Intent intent = new Intent();
            intent.setAction(getReceiveSdkAction(this.mContext));
            intent.setPackage(getMcsPackageName(this.mContext));
            intent.putExtra("type", i);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt(APP_VERSION_NAME, Utils.getVersionName(this.mContext, this.mContext.getPackageName()));
                jSONObject2.putOpt(APP_VERSION_CODE, Integer.valueOf(Utils.getVersionCode(this.mContext, this.mContext.getPackageName())));
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.putOpt(next, jSONObject.get(next));
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                intent.putExtra("extra", jSONObject2.toString());
                throw th;
            }
            intent.putExtra("extra", jSONObject2.toString());
            intent.putExtra("params", str);
            intent.putExtra("appPackage", this.mContext.getPackageName());
            intent.putExtra("appKey", this.mAuthCode);
            intent.putExtra(com.heytap.mcssdk.constant.b.A, this.mVerifyCode);
            intent.putExtra(com.heytap.mcssdk.constant.b.B, this.mRegisterID);
            intent.putExtra(com.heytap.mcssdk.constant.b.C, getSDKVersionName());
            return intent;
        }
        return (Intent) invokeILL.objValue;
    }

    private String getNewMcsPackageName(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
            if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
                NEW_MCS_RECEIVE_SDK_ACTION = new String(com.heytap.mcssdk.a.a.b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
            }
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(NEW_MCS_RECEIVE_SDK_ACTION), 8192);
            if (Build.VERSION.SDK_INT >= 24) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    String str = resolveInfo.serviceInfo.packageName;
                    try {
                        z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                        z2 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (z || z2) {
                        return str;
                    }
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int getSDKVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return 3000;
        }
        return invokeV.intValue;
    }

    public static String getSDKVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? "3.0.0" : (String) invokeV.objValue;
    }

    private boolean isSupportPushInner(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) {
            if (this.mContext == null) {
                this.mContext = context.getApplicationContext();
            }
            String mcsPackageName = getMcsPackageName(this.mContext);
            return Utils.isExistPackage(this.mContext, mcsPackageName) && Utils.getVersionCode(this.mContext, mcsPackageName) >= 1019 && Utils.isSupportPush(this.mContext, mcsPackageName, SUPPORT_OPEN_PUSH);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void onAppStart(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            StatUtil.statisticMessage(context, new MessageStat(context.getPackageName(), "app_start", null));
        }
    }

    private void startMcsService(int i, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65554, this, i, str, jSONObject) == null) {
            if (checkCommandLimit(i)) {
                ICallBackResultService iCallBackResultService = this.mICallBackResultService;
                if (iCallBackResultService != null) {
                    iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
                    return;
                }
                return;
            }
            try {
                this.mContext.startService(getIntent(i, str, jSONObject));
            } catch (Exception e) {
                com.heytap.mcssdk.utils.d.e("startMcsService--Exception" + e.getMessage());
            }
        }
    }

    private void startMcsService(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65555, this, i, jSONObject) == null) {
            startMcsService(i, "", jSONObject);
        }
    }

    public void bindMcsService(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (!checkCommandLimit(i)) {
                Intent intent = getIntent(i, "", null);
                this.mContext.bindService(intent, new ServiceConnection(this, intent) { // from class: com.heytap.mcssdk.PushService.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Intent a;
                    public final /* synthetic */ PushService b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, intent};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = intent;
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                            Bundle bundle = new Bundle();
                            bundle.putAll(this.a.getExtras());
                            try {
                                IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
                            } catch (Exception e) {
                                com.heytap.mcssdk.utils.d.b("bindMcsService exception:" + e);
                            }
                            this.b.mContext.unbindService(this);
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                        }
                    }
                }, 1);
                return;
            }
            ICallBackResultService iCallBackResultService = this.mICallBackResultService;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently");
            }
        }
    }

    public boolean checkCommandLimit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return (i == 12291 || i == 12312 || addCommandToMap(i).b() <= 2) ? false : true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            clearNotificationType(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotificationType(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            if (checkAll()) {
                startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            clearNotifications(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void clearNotifications(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (checkContext()) {
                startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iSetAppNotificationCallBackService) == null) {
            if (checkContext()) {
                this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
                startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
            } else if (getPushCallback() != null) {
                this.mISetAppNotificationCallBackService.onSetAppNotificationSwitch(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iSetAppNotificationCallBackService) == null) {
            if (checkContext()) {
                this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
                startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
                return;
            }
            ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.mISetAppNotificationCallBackService;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    public Map<Integer, com.heytap.mcssdk.c.a> getAppLimitMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAppLimitMap : (Map) invokeV.objValue;
    }

    @Override // com.heytap.mcssdk.a
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iGetAppNotificationCallBackService) == null) {
            if (checkContext()) {
                this.mIGetAppNotificationCallBackService = iGetAppNotificationCallBackService;
                startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
                return;
            }
            IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.mIGetAppNotificationCallBackService;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public int getErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            switch (i) {
                case 12289:
                    return -1;
                case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                    return -2;
                case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                    return -14;
                default:
                    switch (i) {
                        case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                            return -11;
                        case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                            return -3;
                        case 12300:
                            return -4;
                        default:
                            switch (i) {
                                case MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                    return -10;
                                case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                    return -6;
                                case MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                    return -7;
                                case MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                    return -5;
                                case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                    return -8;
                                case MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                    return -9;
                                case MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                    return -13;
                                case MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                    return -12;
                                default:
                                    switch (i) {
                                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                            return -15;
                                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                            return -16;
                                        case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                            return -17;
                                        default:
                                            return 0;
                                    }
                            }
                    }
            }
        }
        return invokeI.intValue;
    }

    public String getMcsPackageName(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            if (sMcsPkgName == null) {
                String newMcsPackageName = getNewMcsPackageName(context);
                if (newMcsPackageName == null) {
                    sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                    z = false;
                } else {
                    sMcsPkgName = newMcsPackageName;
                    z = true;
                }
                sIsNewMcsPkg = z;
            }
            return sMcsPkgName;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            getNotificationStatus(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void getNotificationStatus(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            if (checkAll()) {
                startMcsService(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
            } else if (getPushCallback() != null) {
                getPushCallback().onGetNotificationStatus(-2, 0);
            }
        }
    }

    public List<d> getParsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mParsers : (List) invokeV.objValue;
    }

    public List<c> getProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mProcessors : (List) invokeV.objValue;
    }

    public ICallBackResultService getPushCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mICallBackResultService : (ICallBackResultService) invokeV.objValue;
    }

    public IGetAppNotificationCallBackService getPushGetAppNotificationCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mIGetAppNotificationCallBackService : (IGetAppNotificationCallBackService) invokeV.objValue;
    }

    public ISetAppNotificationCallBackService getPushSetAppNotificationCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mISetAppNotificationCallBackService : (ISetAppNotificationCallBackService) invokeV.objValue;
    }

    public void getPushStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (checkAll()) {
                startMcsService(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
            } else if (getPushCallback() != null) {
                getPushCallback().onGetPushStatus(-2, 0);
            }
        }
    }

    public int getPushVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (checkContext()) {
                Context context = this.mContext;
                return Utils.getVersionCode(context, getMcsPackageName(context));
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getPushVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (checkContext()) {
                Context context = this.mContext;
                return Utils.getVersionName(context, getMcsPackageName(context));
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getReceiveSdkAction(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) {
            if (sMcsPkgName == null) {
                getNewMcsPackageName(context);
            }
            if (sIsNewMcsPkg) {
                if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
                    NEW_MCS_RECEIVE_SDK_ACTION = new String(com.heytap.mcssdk.a.a.b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
                }
                return NEW_MCS_RECEIVE_SDK_ACTION;
            }
            return Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            getRegister(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void getRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONObject) == null) {
            if (checkContext()) {
                startMcsService(12289, jSONObject);
            } else if (getPushCallback() != null) {
                getPushCallback().onRegister(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public String getRegisterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mRegisterID : (String) invokeV.objValue;
    }

    public PushService init(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, context, z)) == null) {
            if (context != null) {
                innerInit(context);
                new com.heytap.mcssdk.b.a().a(this.mContext);
                com.heytap.mcssdk.utils.d.f(z);
                return this;
            }
            throw new IllegalArgumentException("context can't be null");
        }
        return (PushService) invokeLZ.objValue;
    }

    public void innerInit(Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            if (sMcsPkgName == null) {
                String newMcsPackageName = getNewMcsPackageName(applicationContext);
                if (newMcsPackageName == null) {
                    sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                    z = false;
                } else {
                    sMcsPkgName = newMcsPackageName;
                    z = true;
                }
                sIsNewMcsPkg = z;
            }
        }
    }

    public boolean isSupportPushByClient(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) ? isSupportPushInner(context) : invokeL.booleanValue;
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            openNotificationSettings(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void openNotificationSettings(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, jSONObject) == null) {
            if (checkAll()) {
                startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            pausePush(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void pausePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jSONObject) == null) {
            if (checkAll()) {
                startMcsService(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, context, str, str2, iCallBackResultService) == null) {
            register(context, str, str2, null, iCallBackResultService);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048611, this, context, str, str2, jSONObject, iCallBackResultService) == null) {
            if (context == null) {
                if (iCallBackResultService != null) {
                    iCallBackResultService.onRegister(-2, null);
                    return;
                }
                return;
            }
            if (this.mContext == null) {
                this.mContext = context.getApplicationContext();
            }
            if (!Utils.isSupportPushByClient(this.mContext)) {
                if (iCallBackResultService != null) {
                    iCallBackResultService.onRegister(-2, null);
                    return;
                }
                return;
            }
            this.mAuthCode = str;
            this.mVerifyCode = str2;
            this.mICallBackResultService = iCallBackResultService;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.putOpt("appVersionCode", Integer.valueOf(Utils.getVersionCode(context)));
                jSONObject.putOpt("appVersionName", Utils.getVersionName(context));
            } catch (JSONException e) {
                com.heytap.mcssdk.utils.d.e("register-Exception:" + e.getMessage());
            }
            startMcsService(12289, jSONObject);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void requestNotificationPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (checkContext()) {
                bindMcsService(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            resumePush(null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void resumePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, jSONObject) == null) {
            if (checkAll()) {
                startMcsService(12300, jSONObject);
            } else {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
            }
        }
    }

    public void setAppKeySecret(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, str, str2) == null) {
            this.mAuthCode = str;
            this.mVerifyCode = str2;
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            setNotificationType(i, null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setNotificationType(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i, jSONObject) == null) {
            if (!checkAll()) {
                com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, "please call the register first!");
                return;
            }
            startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i + "", jSONObject);
        }
    }

    public void setPushCallback(ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, iCallBackResultService) == null) {
            this.mICallBackResultService = iCallBackResultService;
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            setPushTime(list, i, i2, i3, i4, null);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jSONObject}) == null) {
            if (!checkAll()) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetPushTime(-2, "please call the register first!");
                }
            } else if (list == null || list.size() <= 0 || i < 0 || i2 < 0 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
                throw new IllegalArgumentException("params are not all right,please check params");
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("weekDays", com.heytap.mcssdk.c.b.a(list));
                    jSONObject2.put("startHour", i);
                    jSONObject2.put("startMin", i2);
                    jSONObject2.put("endHour", i3);
                    jSONObject2.put("endMin", i4);
                    startMcsService(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
                } catch (JSONException e) {
                    com.heytap.mcssdk.utils.d.e(com.heytap.mcssdk.utils.d.a, e.getLocalizedMessage());
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.a
    public void setRegisterID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.mRegisterID = str;
        }
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            unRegister(null);
        }
    }

    public void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048623, this, context, str, str2, jSONObject, iCallBackResultService) == null) {
            this.mAuthCode = str;
            this.mVerifyCode = str2;
            this.mContext = context.getApplicationContext();
            this.mICallBackResultService = iCallBackResultService;
            unRegister(jSONObject);
        }
    }

    @Override // com.heytap.mcssdk.a
    public void unRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jSONObject) == null) {
            if (checkContext()) {
                startMcsService(MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
            } else if (getPushCallback() != null) {
                getPushCallback().onUnRegister(-2);
            }
        }
    }
}
