package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
class AppInvokeCmdExecutor implements CmdExecutor<AppInvokeCmd> {
    private static final int NOTIFICATION_ID = 2;
    private static final int SHOW_NOTICIATION = 1;
    private Context mContext;
    private NotificationHandler mHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class NotificationHandler extends Handler {
        public NotificationHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    AppInvokeCmdExecutor.showNotification(AppInvokeCmdExecutor.this.mContext, (AppInvokeCmd) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    public AppInvokeCmdExecutor(Context context) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new NotificationHandler(this.mContext.getMainLooper());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.sina.weibo.sdk.cmd.CmdExecutor
    public boolean doExecutor(AppInvokeCmd appInvokeCmd) {
        if (appInvokeCmd == null || TextUtils.isEmpty(appInvokeCmd.getNotificationText()) || TextUtils.isEmpty(appInvokeCmd.getScheme())) {
            return false;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = appInvokeCmd;
        this.mHandler.sendMessageDelayed(obtainMessage, appInvokeCmd.getNotificationDelay());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showNotification(Context context, AppInvokeCmd appInvokeCmd) {
        SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appInvokeCmd.getNotificationText()).setNotificationPendingIntent(buildInvokePendingIntent(context, appInvokeCmd)).setNotificationTitle(appInvokeCmd.getNotificationTitle()).setTickerText(appInvokeCmd.getNotificationText()).build(context).show(2);
    }

    private static PendingIntent buildInvokePendingIntent(Context context, AppInvokeCmd appInvokeCmd) {
        List<ResolveInfo> queryIntentActivities;
        String scheme = appInvokeCmd.getScheme();
        String url = appInvokeCmd.getUrl();
        Intent buildOpenSchemeIntent = buildOpenSchemeIntent(scheme, appInvokeCmd.getAppPackage());
        if (buildOpenSchemeIntent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(buildOpenSchemeIntent, 65536)) == null || queryIntentActivities.isEmpty()) {
            buildOpenSchemeIntent = null;
        }
        if (buildOpenSchemeIntent == null) {
            buildOpenSchemeIntent = buildOpenUrlIntent(url);
        }
        if (buildOpenSchemeIntent != null) {
            buildOpenSchemeIntent.setFlags(268435456);
            return PendingIntent.getActivity(context, 0, buildOpenSchemeIntent, 134217728);
        }
        return null;
    }

    private static Intent buildOpenSchemeIntent(String str, String str2) {
        if (TextUtils.isEmpty(str) || !Uri.parse(str).isHierarchical()) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setPackage(str2);
        return intent;
    }

    private static Intent buildOpenUrlIntent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            return intent;
        }
        return null;
    }
}
