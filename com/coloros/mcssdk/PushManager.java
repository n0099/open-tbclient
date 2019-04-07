package com.coloros.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.coloros.mcssdk.callback.PushCallback;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coloros.mcssdk.mode.SptDataMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PushManager {
    public static final String APP_PACKAGE = "appPackage";
    public static final String EVENT_ID = "eventID";
    public static final String EVENT_ID_PUSH_CLICK = "push_click";
    public static final String EVENT_ID_PUSH_DELETE = "push_delete";
    public static final String EVENT_ID_PUSH_EXCEPTION = "push_exception";
    public static final String EVENT_ID_PUSH_NO_SHOW = "push_no_show";
    public static final String EVENT_ID_PUSH_SHOW = "push_show";
    public static final String EVENT_ID_PUSH_TRANSMIT = "push_transmit";
    public static final String MCS_PACKAGE = "com.coloros.mcs";
    public static final String MCS_RECEIVE_SDK_ACTION = "com.coloros.mcssdk.action.RECEIVE_SDK_MESSAGE";
    public static final int MCS_SUPPORT_VERSION = 1012;
    public static final String MESSAGE_ID = "messageID";
    public static final String MESSAGE_TYPE = "messageType";
    public static final String MESSAGE_TYPE_APP = "push_message";
    public static final String MESSAGE_TYPE_NOTI = "notification";
    public static final String MESSAGE_TYPE_SPT_DATA = "spt_data";
    private static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    public static final String TASK_ID = "taskID";
    public static final String TYPE = "type";
    private static final String VERSION = "1.0.1";
    private static int count = 0;
    private String mAppKey;
    private String mAppSecret;
    private Context mContext;
    private List<com.coloros.mcssdk.a.d> mParsers;
    private List<com.coloros.mcssdk.b.c> mProcessors;
    private PushCallback mPushCallback;
    private String mRegisterID;

    private PushManager() {
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        synchronized (PushManager.class) {
            if (count > 0) {
                throw new RuntimeException("PushManager can't create again!");
            }
            count++;
        }
        addParser(new com.coloros.mcssdk.a.a());
        addParser(new com.coloros.mcssdk.a.e());
        addParser(new com.coloros.mcssdk.a.b());
        addProcessor(new com.coloros.mcssdk.b.a());
        addProcessor(new com.coloros.mcssdk.b.d());
        addProcessor(new com.coloros.mcssdk.b.b());
    }

    private synchronized void addParser(com.coloros.mcssdk.a.d dVar) {
        if (dVar != null) {
            this.mParsers.add(dVar);
        }
    }

    private synchronized void addProcessor(com.coloros.mcssdk.b.c cVar) {
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
        PushManager pushManager;
        pushManager = c.a;
        return pushManager;
    }

    public static boolean isSupportPush(Context context) {
        return com.coloros.mcssdk.c.e.a(context, MCS_PACKAGE) && com.coloros.mcssdk.c.e.b(context, MCS_PACKAGE) >= 1012 && com.coloros.mcssdk.c.e.a(context, MCS_PACKAGE, SUPPORT_OPEN_PUSH);
    }

    private void startMcsService(int i) {
        startMcsService(i, "");
    }

    private void startMcsService(int i, String str) {
        Intent intent = new Intent();
        intent.setAction(MCS_RECEIVE_SDK_ACTION);
        intent.setPackage(MCS_PACKAGE);
        intent.putExtra("type", i);
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra("appKey", this.mAppKey);
        intent.putExtra(CommandMessage.APP_SECRET, this.mAppSecret);
        intent.putExtra(CommandMessage.REGISTER_ID, this.mRegisterID);
        intent.putExtra(CommandMessage.SDK_VERSION, getSDKVersion());
        this.mContext.startService(intent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r3v1 int A[REMOVE]) = (r5v0 com.coloros.mcssdk.mode.AppMessage) type: VIRTUAL call: com.coloros.mcssdk.mode.AppMessage.getMessageID():int)] */
    public static void statisticMessage(Context context, AppMessage appMessage, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(MCS_RECEIVE_SDK_ACTION);
            intent.setPackage(MCS_PACKAGE);
            intent.putExtra("type", CommandMessage.COMMAND_STATISTIC);
            intent.putExtra("taskID", appMessage.getTaskID());
            intent.putExtra("appPackage", appMessage.getAppPackage());
            intent.putExtra("messageID", new StringBuilder().append(appMessage.getMessageID()).toString());
            intent.putExtra(MESSAGE_TYPE, appMessage.getType());
            intent.putExtra(EVENT_ID, str);
            context.startService(intent);
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.b("statisticMessage--Exception" + e.getMessage());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r3v1 int A[REMOVE]) = (r5v0 com.coloros.mcssdk.mode.SptDataMessage) type: VIRTUAL call: com.coloros.mcssdk.mode.SptDataMessage.getMessageID():int)] */
    public static void statisticMessage(Context context, SptDataMessage sptDataMessage, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(MCS_RECEIVE_SDK_ACTION);
            intent.setPackage(MCS_PACKAGE);
            intent.putExtra("type", CommandMessage.COMMAND_STATISTIC);
            intent.putExtra("taskID", sptDataMessage.getTaskID());
            intent.putExtra("appPackage", sptDataMessage.getAppPackage());
            intent.putExtra("messageID", new StringBuilder().append(sptDataMessage.getMessageID()).toString());
            intent.putExtra(MESSAGE_TYPE, sptDataMessage.getType());
            intent.putExtra(EVENT_ID, str);
            context.startService(intent);
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.b("statisticMessage--Exception" + e.getMessage());
        }
    }

    public void clearNotificationType() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE);
    }

    public void getAliases() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_GET_ALIAS);
    }

    public void getNotificationStatus() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_GET_NOTIFICATION_STATUS);
    }

    public List<com.coloros.mcssdk.a.d> getParsers() {
        return this.mParsers;
    }

    public List<com.coloros.mcssdk.b.c> getProcessors() {
        return this.mProcessors;
    }

    public PushCallback getPushCallback() {
        return this.mPushCallback;
    }

    public void getPushStatus() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_GET_PUSH_STATUS);
    }

    public void getPushTime() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_SET_PUSH_TIME);
    }

    public int getPushVersionCode() {
        checkContext();
        return com.coloros.mcssdk.c.e.b(this.mContext, MCS_PACKAGE);
    }

    public String getPushVersionName() {
        checkContext();
        return com.coloros.mcssdk.c.e.c(this.mContext, MCS_PACKAGE);
    }

    public void getRegister() {
        checkContext();
        startMcsService(12289);
    }

    public String getSDKVersion() {
        return "1.0.1";
    }

    public void getTags() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_GET_TAGS);
    }

    public void getUserAccounts() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_GET_ACCOUNTS);
    }

    public void openNotificationSettings() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_SETTINGS);
    }

    public void pausePush() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_PAUSE_PUSH);
    }

    public void register(Context context, String str, String str2, PushCallback pushCallback) {
        if (context == null) {
            throw new IllegalArgumentException("context is null !");
        }
        if (!isSupportPush(context)) {
            throw new IllegalArgumentException("the phone is not support oppo push!");
        }
        this.mAppKey = str;
        this.mAppSecret = str2;
        this.mContext = context.getApplicationContext();
        this.mPushCallback = pushCallback;
        startMcsService(12289);
    }

    public void resumePush() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_RESUME_PUSH);
    }

    public void setAliases(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_SET_ALIAS, CommandMessage.parseToString(list));
    }

    public void setAppKeySecret(String str, String str2) {
        this.mAppKey = str;
        this.mAppSecret = str2;
    }

    public void setNotificationType(int i) {
        checkAll();
        startMcsService(CommandMessage.COMMAND_SET_NOTIFICATION_TYPE, String.valueOf(i));
    }

    public void setPushCallback(PushCallback pushCallback) {
        this.mPushCallback = pushCallback;
    }

    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        checkAll();
        if (list == null || list.size() <= 0 || i < 0 || i > 23 || i2 < 0 || i2 > 59 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("weekDays", CommandMessage.parseToString(list));
            jSONObject.put("startHour", i);
            jSONObject.put("startMin", i2);
            jSONObject.put("endHour", i3);
            jSONObject.put("endMin", i4);
            startMcsService(CommandMessage.COMMAND_SET_PUSH_TIME, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setRegisterID(String str) {
        this.mRegisterID = str;
    }

    public void setTags(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_SET_TAGS, CommandMessage.parseToString(list));
    }

    public void setUserAccount(String str) {
        checkAll();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        setUserAccounts(arrayList);
    }

    @Deprecated
    public void setUserAccounts(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_SET_ACCOUNTS, CommandMessage.parseToString(list));
    }

    public void unRegister() {
        checkAll();
        startMcsService(CommandMessage.COMMAND_UNREGISTER);
    }

    public void unsetAlias(String str) {
        checkAll();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        unsetAliases(arrayList);
    }

    @Deprecated
    public void unsetAliases(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_UNSET_ALIAS, CommandMessage.parseToString(list));
    }

    public void unsetTags(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_UNSET_TAGS, CommandMessage.parseToString(list));
    }

    public void unsetUserAccounts(List<String> list) {
        checkAll();
        if (list == null || list.size() == 0) {
            return;
        }
        startMcsService(CommandMessage.COMMAND_UNSET_ACCOUNTS, CommandMessage.parseToString(list));
    }
}
