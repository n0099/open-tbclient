package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.MessageStat;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PushManager implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_PACKAGE = "appPackage";
    public static final String APP_VERSION_CODE = "versionCode";
    public static final String APP_VERSION_NAME = "versionName";
    public static final String EVENT_ID = "eventID";
    public static final String EVENT_ID_APP_BLACK_LIST = "app_black_list";
    public static final String EVENT_ID_PUSH_ADD_MESSAGE_NO_DISTURBING = "add_message_no_disturbing";
    public static final String EVENT_ID_PUSH_ADD_MESSAGE_TOP = "add_message_top";
    public static final String EVENT_ID_PUSH_CLICK = "push_click";
    public static final String EVENT_ID_PUSH_DELETE = "push_delete";
    public static final String EVENT_ID_PUSH_EXCEPTION = "push_exception";
    public static final String EVENT_ID_PUSH_MESSAGE_REPEAT = "message_repeat";
    public static final String EVENT_ID_PUSH_NO_IMSI = "imsi_not_exist";
    public static final String EVENT_ID_PUSH_NO_SHOW = "push_no_show";
    public static final String EVENT_ID_PUSH_REGISTER = "push_register";
    public static final String EVENT_ID_PUSH_REVOKE = "push_revoke";
    public static final String EVENT_ID_PUSH_REVOKE_DELETE = "push_revoke_delete";
    public static final String EVENT_ID_PUSH_SHOW = "push_show";
    public static final String EVENT_ID_PUSH_TRANSMIT = "push_transmit";
    public static final String EVENT_ID_READ_MESSAGE = "push_read_message";
    public static final String EXTRA = "extra";
    public static final String GLOBAL_ID = "globalID";
    public static final int MAX_HOUR_IN_DAY = 23;
    public static final int MAX_MIN_IN_HOUR = 59;
    public static final int MCS_SUPPORT_VERSION = 1012;
    public static final String MESSAGE_ID = "messageID";
    public static final String MESSAGE_TYPE = "messageType";
    public static final String NEW_MCS_RECEIVE_SDK_ACTION = "com.mcs.action.RECEIVE_SDK_MESSAGE";
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
    public String mAppKey;
    public String mAppSecret;
    public Context mContext;
    public final Object mMcsServiceLock;
    public List<com.heytap.mcssdk.a.d> mParsers;
    public List<com.heytap.mcssdk.b.c> mProcessors;
    public PushCallback mPushCallback;
    public String mRegisterID;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-7489428, "Lcom/heytap/mcssdk/PushManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-7489428, "Lcom/heytap/mcssdk/PushManager;");
                return;
            }
        }
        OLD_MCS_PACKAGE = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
        OLD_MCS_RECEIVE_SDK_ACTION = new int[]{99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
        sCount = 0;
    }

    public PushManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMcsServiceLock = new Object();
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        this.mRegisterID = null;
        synchronized (PushManager.class) {
            if (sCount > 0) {
                throw new RuntimeException("PushManager can't create again!");
            }
            sCount++;
        }
        addParser(new com.heytap.mcssdk.a.a());
        addParser(new com.heytap.mcssdk.a.e());
        addParser(new com.heytap.mcssdk.a.b());
        addProcessor(new com.heytap.mcssdk.b.a());
        addProcessor(new com.heytap.mcssdk.b.d());
        addProcessor(new com.heytap.mcssdk.b.b());
    }

    public /* synthetic */ PushManager(d dVar) {
        this();
    }

    private synchronized void addParser(com.heytap.mcssdk.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar) == null) {
            synchronized (this) {
                if (dVar != null) {
                    this.mParsers.add(dVar);
                }
            }
        }
    }

    private synchronized void addProcessor(com.heytap.mcssdk.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, cVar) == null) {
            synchronized (this) {
                if (cVar != null) {
                    this.mProcessors.add(cVar);
                }
            }
        }
    }

    private void checkAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            checkContext();
            checkRegisterID();
        }
    }

    private void checkContext() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.mContext == null) {
            throw new IllegalArgumentException("please call the register first!");
        }
    }

    private void checkRegisterID() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && this.mRegisterID == null) {
            throw new IllegalArgumentException("please call the register until get the registerID!");
        }
    }

    public static PushManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? e.a() : (PushManager) invokeV.objValue;
    }

    private Intent getIntent(int i2, String str, JSONObject jSONObject) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65546, this, i2, str, jSONObject)) == null) {
            Intent intent = new Intent();
            intent.setAction(getReceiveSdkAction(this.mContext));
            intent.setPackage(getMcsPackageName(this.mContext));
            intent.putExtra("type", i2);
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
            intent.putExtra("appKey", this.mAppKey);
            intent.putExtra(CommandMessage.APP_SECRET, this.mAppSecret);
            intent.putExtra(CommandMessage.REGISTER_ID, this.mRegisterID);
            intent.putExtra(CommandMessage.SDK_VERSION, getSDKVersion());
            return intent;
        }
        return (Intent) invokeILL.objValue;
    }

    public static String getMcsPackageName(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
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

    public static String getNewMcsPackageName(Context context) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
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

    public static String getReceiveSdkAction(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (sMcsPkgName == null) {
                getNewMcsPackageName(context);
            }
            return sIsNewMcsPkg ? NEW_MCS_RECEIVE_SDK_ACTION : Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
        }
        return (String) invokeL.objValue;
    }

    public static String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.f70492f : (String) invokeV.objValue;
    }

    public static boolean isSupportPush(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            String mcsPackageName = getMcsPackageName(context);
            return Utils.isExistPackage(context, mcsPackageName) && Utils.getVersionCode(context, mcsPackageName) >= 1012 && Utils.isSupportPush(context, mcsPackageName, SUPPORT_OPEN_PUSH);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void onAppStart(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            statisticMessage(context, new MessageStat(context.getPackageName(), "app_start", null));
        }
    }

    private void startMcsService(int i2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65553, this, i2, str, jSONObject) == null) {
            synchronized (this.mMcsServiceLock) {
                this.mContext.startService(getIntent(i2, str, jSONObject));
            }
        }
    }

    private void startMcsService(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65554, this, i2, jSONObject) == null) {
            startMcsService(i2, "", jSONObject);
        }
    }

    public static void statisticMessage(Context context, AppMessage appMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, context, appMessage, str) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction(getReceiveSdkAction(context));
                intent.setPackage(getMcsPackageName(context));
                intent.putExtra("type", 12291);
                intent.putExtra("taskID", appMessage.getTaskID());
                intent.putExtra("appPackage", appMessage.getAppPackage());
                intent.putExtra("messageID", String.valueOf(appMessage.getMessageID()));
                intent.putExtra("globalID", String.valueOf(appMessage.getMessageID()));
                intent.putExtra("messageType", appMessage.getType());
                intent.putExtra("eventID", str);
                context.startService(intent);
            } catch (Exception e2) {
                LogUtil.e("statisticMessage--Exception" + e2.getMessage());
            }
        }
    }

    public static void statisticMessage(Context context, MessageStat messageStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, messageStat) == null) {
            StatUtil.statisticMessage(context, messageStat);
        }
    }

    public static void statisticMessage(Context context, SptDataMessage sptDataMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, context, sptDataMessage, str) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction(getReceiveSdkAction(context));
                intent.setPackage(getMcsPackageName(context));
                intent.putExtra("type", 12291);
                intent.putExtra("taskID", sptDataMessage.getTaskID());
                intent.putExtra("appPackage", sptDataMessage.getAppPackage());
                intent.putExtra("messageID", sptDataMessage.getMessageID());
                intent.putExtra("globalID", sptDataMessage.getGlobalID());
                intent.putExtra("messageType", sptDataMessage.getType());
                intent.putExtra("eventID", str);
                context.startService(intent);
            } catch (Exception e2) {
                LogUtil.e("statisticMessage--Exception" + e2.getMessage());
            }
        }
    }

    public static void statisticMessage(Context context, List<MessageStat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, list) == null) {
            StatUtil.statisticMessage(context, list);
        }
    }

    public void bindMcsService(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            Intent intent = getIntent(i2, "", null);
            this.mContext.bindService(intent, new d(this, intent), 1);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotificationType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            clearNotificationType(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void clearNotificationType(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            clearNotifications(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void clearNotifications(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            try {
                checkContext();
                startMcsService(CommandMessage.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getAliases() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getAliases(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void getAliases(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(12293, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onGetAliases(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getNotificationStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            getNotificationStatus(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void getNotificationStatus(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(CommandMessage.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onGetNotificationStatus(-2, 0);
                }
            }
        }
    }

    public List<com.heytap.mcssdk.a.d> getParsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mParsers : (List) invokeV.objValue;
    }

    public List<com.heytap.mcssdk.b.c> getProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mProcessors : (List) invokeV.objValue;
    }

    public PushCallback getPushCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPushCallback : (PushCallback) invokeV.objValue;
    }

    public void getPushStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                checkAll();
                startMcsService(CommandMessage.COMMAND_GET_PUSH_STATUS, null);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onGetPushStatus(-2, 0);
                }
            }
        }
    }

    public int getPushVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            checkContext();
            Context context = this.mContext;
            return Utils.getVersionCode(context, getMcsPackageName(context));
        }
        return invokeV.intValue;
    }

    public String getPushVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            checkContext();
            Context context = this.mContext;
            return Utils.getVersionName(context, getMcsPackageName(context));
        }
        return (String) invokeV.objValue;
    }

    @Override // com.heytap.mcssdk.b
    public void getRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            getRegister(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void getRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            try {
                checkContext();
                startMcsService(12289, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onRegister(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public String getRegisterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRegisterID : (String) invokeV.objValue;
    }

    @Override // com.heytap.mcssdk.b
    public void getTags() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            getTags(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void getTags(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(12296, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onGetTags(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getUserAccounts() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            getUserAccounts(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void getUserAccounts(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(12302, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onGetUserAccounts(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void openNotificationSettings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            openNotificationSettings(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void openNotificationSettings(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void pausePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            pausePush(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void pausePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(12299, jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void register(Context context, String str, String str2, PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048602, this, context, str, str2, pushCallback) == null) {
            register(context, str, str2, null, pushCallback);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void register(Context context, String str, String str2, JSONObject jSONObject, PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048603, this, context, str, str2, jSONObject, pushCallback) == null) {
            try {
                if (context == null) {
                    throw new IllegalArgumentException("context is null !");
                }
                statisticMessage(context, new MessageStat(context.getPackageName(), EVENT_ID_PUSH_REGISTER, null));
                if (!isSupportPush(context)) {
                    throw new IllegalArgumentException("the phone is not support push!");
                }
                this.mAppKey = str;
                this.mAppSecret = str2;
                this.mContext = context.getApplicationContext();
                this.mPushCallback = pushCallback;
                startMcsService(12289, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onRegister(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void requestNotificationPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            try {
                checkContext();
                bindMcsService(CommandMessage.COMMANAD_NOTIFICATION_ALLOWANCE);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void resumePush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            resumePush(null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void resumePush(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(12300, jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setAliases(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            setAliases(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void setAliases(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12292, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetAliases(-2, null);
                }
            }
        }
    }

    public void setAppKeySecret(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            this.mAppKey = str;
            this.mAppSecret = str2;
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setNotificationType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            setNotificationType(i2, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void setNotificationType(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i2, jSONObject) == null) {
            try {
                checkAll();
                startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_TYPE, String.valueOf(i2), jSONObject);
            } catch (Exception e2) {
                LogUtil.e(LogUtil.TAG, e2);
            }
        }
    }

    public void setPushCallback(PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, pushCallback) == null) {
            this.mPushCallback = pushCallback;
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            setPushTime(list, i2, i3, i4, i5, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), jSONObject}) == null) {
            try {
                checkAll();
                if (list == null || list.size() <= 0 || i2 < 0 || i2 > 23 || i3 < 0 || i3 > 59 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
                    throw new IllegalArgumentException("params are not all right,please check params");
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("weekDays", CommandMessage.parseToString(list));
                    jSONObject2.put("startHour", i2);
                    jSONObject2.put("startMin", i3);
                    jSONObject2.put("endHour", i4);
                    jSONObject2.put("endMin", i5);
                    startMcsService(12298, jSONObject2.toString(), jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetPushTime(-2, e3.getMessage());
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setRegisterID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mRegisterID = str;
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setTags(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, list) == null) {
            setTags(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void setTags(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12295, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetTags(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setUserAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            setUserAccount(str, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void setUserAccount(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, str, jSONObject) == null) {
            try {
                checkAll();
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                setUserAccounts(arrayList, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetUserAccounts(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setUserAccounts(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            setUserAccounts(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    @Deprecated
    public void setUserAccounts(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12301, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onSetUserAccounts(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unRegister() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            unRegister(null);
        }
    }

    public void unRegister(Context context, String str, String str2, JSONObject jSONObject, PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048623, this, context, str, str2, jSONObject, pushCallback) == null) {
            this.mAppKey = str;
            this.mAppSecret = str2;
            this.mContext = context.getApplicationContext();
            this.mPushCallback = pushCallback;
            unRegister(jSONObject);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void unRegister(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jSONObject) == null) {
            try {
                checkContext();
                startMcsService(12290, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onUnRegister(-2);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetAlias(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            unsetAlias(str, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void unsetAlias(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, str, jSONObject) == null) {
            try {
                checkAll();
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                unsetAliases(arrayList, jSONObject);
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onUnsetAliases(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetAliases(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, list) == null) {
            unsetAliases(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    @Deprecated
    public void unsetAliases(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12294, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onUnsetAliases(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetTags(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, list) == null) {
            unsetTags(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void unsetTags(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12297, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onUnsetTags(-2, null);
                }
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetUserAccounts(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, list) == null) {
            unsetUserAccounts(list, null);
        }
    }

    @Override // com.heytap.mcssdk.c
    public void unsetUserAccounts(List<String> list, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, list, jSONObject) == null) {
            try {
                checkAll();
                if (list != null && list.size() != 0) {
                    startMcsService(12303, CommandMessage.parseToString(list), jSONObject);
                }
            } catch (Exception unused) {
                if (getPushCallback() != null) {
                    getPushCallback().onUnsetUserAccounts(-2, null);
                }
            }
        }
    }
}
