package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
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
/* loaded from: classes6.dex */
public class PushManager implements b {
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_VERSION_CODE = "versionCode";
    private static final String APP_VERSION_NAME = "versionName";
    private static final String EVENT_ID = "eventID";
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
    private static final String EXTRA = "extra";
    private static final String GLOBAL_ID = "globalID";
    private static final int MAX_HOUR_IN_DAY = 23;
    private static final int MAX_MIN_IN_HOUR = 59;
    private static final int MCS_SUPPORT_VERSION = 1012;
    private static final String MESSAGE_ID = "messageID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String NEW_MCS_RECEIVE_SDK_ACTION = "com.mcs.action.RECEIVE_SDK_MESSAGE";
    private static final String PUSH_SDK_VERSION = "pushSdkVersion";
    private static final int SDK_INT_24 = 24;
    private static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    private static final int SYSTEM_UID = 1000;
    private static final String TASK_ID = "taskID";
    private static final String TYPE = "type";
    private static boolean sIsNewMcsPkg;
    private static String sMcsPkgName;
    private String mAppKey;
    private String mAppSecret;
    private Context mContext;
    private final Object mMcsServiceLock;
    private List<com.heytap.mcssdk.a.d> mParsers;
    private List<com.heytap.mcssdk.b.c> mProcessors;
    private PushCallback mPushCallback;
    private String mRegisterID;
    private static final int[] OLD_MCS_PACKAGE = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] OLD_MCS_RECEIVE_SDK_ACTION = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static int sCount = 0;

    private PushManager() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PushManager(d dVar) {
        this();
    }

    private synchronized void addParser(com.heytap.mcssdk.a.d dVar) {
        if (dVar != null) {
            this.mParsers.add(dVar);
        }
    }

    private synchronized void addProcessor(com.heytap.mcssdk.b.c cVar) {
        if (cVar != null) {
            this.mProcessors.add(cVar);
        }
    }

    private void checkAll() {
        checkContext();
        checkRegisterID();
    }

    private void checkContext() {
        if (this.mContext == null) {
            throw new IllegalArgumentException("please call the register first!");
        }
    }

    private void checkRegisterID() {
        if (this.mRegisterID == null) {
            throw new IllegalArgumentException("please call the register until get the registerID!");
        }
    }

    public static PushManager getInstance() {
        return e.a();
    }

    private Intent getIntent(int i, String str, JSONObject jSONObject) {
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
        } catch (Exception e) {
        } finally {
            intent.putExtra("extra", jSONObject2.toString());
        }
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra("appKey", this.mAppKey);
        intent.putExtra(CommandMessage.APP_SECRET, this.mAppSecret);
        intent.putExtra(CommandMessage.REGISTER_ID, this.mRegisterID);
        intent.putExtra(CommandMessage.SDK_VERSION, getSDKVersion());
        return intent;
    }

    public static String getMcsPackageName(Context context) {
        if (sMcsPkgName == null) {
            String newMcsPackageName = getNewMcsPackageName(context);
            if (newMcsPackageName == null) {
                sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                sIsNewMcsPkg = false;
            } else {
                sMcsPkgName = newMcsPackageName;
                sIsNewMcsPkg = true;
            }
        }
        return sMcsPkgName;
    }

    private static String getNewMcsPackageName(Context context) {
        boolean z;
        boolean z2;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(NEW_MCS_RECEIVE_SDK_ACTION), 8192);
        if (Build.VERSION.SDK_INT >= 24) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.packageName;
                try {
                    z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                    z2 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid(HttpConstants.OS_TYPE_VALUE, 0);
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (z || z2) {
                    return str;
                }
            }
        }
        return null;
    }

    public static String getReceiveSdkAction(Context context) {
        if (sMcsPkgName == null) {
            getNewMcsPackageName(context);
        }
        return sIsNewMcsPkg ? NEW_MCS_RECEIVE_SDK_ACTION : Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
    }

    public static String getSDKVersion() {
        return a.f;
    }

    public static boolean isSupportPush(Context context) {
        String mcsPackageName = getMcsPackageName(context);
        return Utils.isExistPackage(context, mcsPackageName) && Utils.getVersionCode(context, mcsPackageName) >= 1012 && Utils.isSupportPush(context, mcsPackageName, SUPPORT_OPEN_PUSH);
    }

    @Deprecated
    private static void onAppStart(Context context) {
        statisticMessage(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    private void startMcsService(int i, String str, JSONObject jSONObject) {
        synchronized (this.mMcsServiceLock) {
            this.mContext.startService(getIntent(i, str, jSONObject));
        }
    }

    private void startMcsService(int i, JSONObject jSONObject) {
        startMcsService(i, "", jSONObject);
    }

    public static void statisticMessage(Context context, AppMessage appMessage, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(getReceiveSdkAction(context));
            intent.setPackage(getMcsPackageName(context));
            intent.putExtra("type", CommandMessage.COMMAND_STATISTIC);
            intent.putExtra("taskID", appMessage.getTaskID());
            intent.putExtra("appPackage", appMessage.getAppPackage());
            intent.putExtra("messageID", String.valueOf(appMessage.getMessageID()));
            intent.putExtra("globalID", String.valueOf(appMessage.getMessageID()));
            intent.putExtra(MESSAGE_TYPE, appMessage.getType());
            intent.putExtra(EVENT_ID, str);
            context.startService(intent);
        } catch (Exception e) {
            LogUtil.e("statisticMessage--Exception" + e.getMessage());
        }
    }

    public static void statisticMessage(Context context, MessageStat messageStat) {
        StatUtil.statisticMessage(context, messageStat);
    }

    public static void statisticMessage(Context context, SptDataMessage sptDataMessage, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(getReceiveSdkAction(context));
            intent.setPackage(getMcsPackageName(context));
            intent.putExtra("type", CommandMessage.COMMAND_STATISTIC);
            intent.putExtra("taskID", sptDataMessage.getTaskID());
            intent.putExtra("appPackage", sptDataMessage.getAppPackage());
            intent.putExtra("messageID", sptDataMessage.getMessageID());
            intent.putExtra("globalID", sptDataMessage.getGlobalID());
            intent.putExtra(MESSAGE_TYPE, sptDataMessage.getType());
            intent.putExtra(EVENT_ID, str);
            context.startService(intent);
        } catch (Exception e) {
            LogUtil.e("statisticMessage--Exception" + e.getMessage());
        }
    }

    public static void statisticMessage(Context context, List<MessageStat> list) {
        StatUtil.statisticMessage(context, list);
    }

    public void bindMcsService(int i) {
        Intent intent = getIntent(i, "", null);
        this.mContext.bindService(intent, new d(this, intent), 1);
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.c
    public void clearNotificationType(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.c
    public void clearNotifications(JSONObject jSONObject) {
        try {
            checkContext();
            startMcsService(CommandMessage.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getAliases() {
        getAliases(null);
    }

    @Override // com.heytap.mcssdk.c
    public void getAliases(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_GET_ALIAS, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onGetAliases(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.c
    public void getNotificationStatus(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onGetNotificationStatus(-2, 0);
            }
        }
    }

    public List<com.heytap.mcssdk.a.d> getParsers() {
        return this.mParsers;
    }

    public List<com.heytap.mcssdk.b.c> getProcessors() {
        return this.mProcessors;
    }

    public PushCallback getPushCallback() {
        return this.mPushCallback;
    }

    public void getPushStatus() {
        try {
            checkAll();
            startMcsService(12306, null);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onGetPushStatus(-2, 0);
            }
        }
    }

    public int getPushVersionCode() {
        checkContext();
        return Utils.getVersionCode(this.mContext, getMcsPackageName(this.mContext));
    }

    public String getPushVersionName() {
        checkContext();
        return Utils.getVersionName(this.mContext, getMcsPackageName(this.mContext));
    }

    @Override // com.heytap.mcssdk.b
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.c
    public void getRegister(JSONObject jSONObject) {
        try {
            checkContext();
            startMcsService(12289, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onRegister(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public String getRegisterID() {
        return this.mRegisterID;
    }

    @Override // com.heytap.mcssdk.b
    public void getTags() {
        getTags(null);
    }

    @Override // com.heytap.mcssdk.c
    public void getTags(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_GET_TAGS, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onGetTags(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void getUserAccounts() {
        getUserAccounts(null);
    }

    @Override // com.heytap.mcssdk.c
    public void getUserAccounts(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(12302, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onGetUserAccounts(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.c
    public void openNotificationSettings(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.c
    public void pausePush(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_PAUSE_PUSH, jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void register(Context context, String str, String str2, PushCallback pushCallback) {
        register(context, str, str2, null, pushCallback);
    }

    @Override // com.heytap.mcssdk.c
    public void register(Context context, String str, String str2, JSONObject jSONObject, PushCallback pushCallback) {
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
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onRegister(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void requestNotificationPermission() {
        try {
            checkContext();
            bindMcsService(CommandMessage.COMMANAD_NOTIFICATION_ALLOWANCE);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.c
    public void resumePush(JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_RESUME_PUSH, jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setAliases(List<String> list) {
        setAliases(list, null);
    }

    @Override // com.heytap.mcssdk.c
    public void setAliases(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_SET_ALIAS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onSetAliases(-2, null);
            }
        }
    }

    public void setAppKeySecret(String str, String str2) {
        this.mAppKey = str;
        this.mAppSecret = str2;
    }

    @Override // com.heytap.mcssdk.b
    public void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    @Override // com.heytap.mcssdk.c
    public void setNotificationType(int i, JSONObject jSONObject) {
        try {
            checkAll();
            startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_TYPE, String.valueOf(i), jSONObject);
        } catch (Exception e) {
            LogUtil.e(LogUtil.TAG, e);
        }
    }

    public void setPushCallback(PushCallback pushCallback) {
        this.mPushCallback = pushCallback;
    }

    @Override // com.heytap.mcssdk.b
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    @Override // com.heytap.mcssdk.c
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() <= 0 || i < 0 || i > 23 || i2 < 0 || i2 > 59 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
                throw new IllegalArgumentException("params are not all right,please check params");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", CommandMessage.parseToString(list));
                jSONObject2.put("startHour", i);
                jSONObject2.put("startMin", i2);
                jSONObject2.put("endHour", i3);
                jSONObject2.put("endMin", i4);
                startMcsService(CommandMessage.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            if (getPushCallback() != null) {
                getPushCallback().onSetPushTime(-2, e2.getMessage());
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setRegisterID(String str) {
        this.mRegisterID = str;
    }

    @Override // com.heytap.mcssdk.b
    public void setTags(List<String> list) {
        setTags(list, null);
    }

    @Override // com.heytap.mcssdk.c
    public void setTags(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_SET_TAGS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onSetTags(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setUserAccount(String str) {
        setUserAccount(str, null);
    }

    @Override // com.heytap.mcssdk.c
    public void setUserAccount(String str, JSONObject jSONObject) {
        try {
            checkAll();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            setUserAccounts(arrayList, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onSetUserAccounts(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void setUserAccounts(List<String> list) {
        setUserAccounts(list, null);
    }

    @Override // com.heytap.mcssdk.c
    @Deprecated
    public void setUserAccounts(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_SET_ACCOUNTS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onSetUserAccounts(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unRegister() {
        unRegister(null);
    }

    public void unRegister(Context context, String str, String str2, JSONObject jSONObject, PushCallback pushCallback) {
        this.mAppKey = str;
        this.mAppSecret = str2;
        this.mContext = context.getApplicationContext();
        this.mPushCallback = pushCallback;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.c
    public void unRegister(JSONObject jSONObject) {
        try {
            checkContext();
            startMcsService(CommandMessage.COMMAND_UNREGISTER, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onUnRegister(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetAlias(String str) {
        unsetAlias(str, null);
    }

    @Override // com.heytap.mcssdk.c
    public void unsetAlias(String str, JSONObject jSONObject) {
        try {
            checkAll();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            unsetAliases(arrayList, jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onUnsetAliases(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetAliases(List<String> list) {
        unsetAliases(list, null);
    }

    @Override // com.heytap.mcssdk.c
    @Deprecated
    public void unsetAliases(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_UNSET_ALIAS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onUnsetAliases(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetTags(List<String> list) {
        unsetTags(list, null);
    }

    @Override // com.heytap.mcssdk.c
    public void unsetTags(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_UNSET_TAGS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onUnsetTags(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.b
    public void unsetUserAccounts(List<String> list) {
        unsetUserAccounts(list, null);
    }

    @Override // com.heytap.mcssdk.c
    public void unsetUserAccounts(List<String> list, JSONObject jSONObject) {
        try {
            checkAll();
            if (list == null || list.size() == 0) {
                return;
            }
            startMcsService(CommandMessage.COMMAND_UNSET_ACCOUNTS, CommandMessage.parseToString(list), jSONObject);
        } catch (Exception e) {
            if (getPushCallback() != null) {
                getPushCallback().onUnsetUserAccounts(-2, null);
            }
        }
    }
}
