package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AppInstallCmdExecutor implements CmdExecutor<AppInstallCmd> {
    private static final int MESSAGE_DO_CMD = 1;
    private static final int MESSAGE_QUIT_LOOP = 2;
    private boolean isStarted = false;
    private Context mContext;
    private InstallHandler mHandler;
    private Looper mLooper;
    private HandlerThread thread;
    private static final String WB_APK_FILE_DIR = Environment.getExternalStorageDirectory() + "/Android/org_share_data/";
    private static final String TAG = AppInstallCmdExecutor.class.getName();

    public AppInstallCmdExecutor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* loaded from: classes3.dex */
    private static final class NOTIFICATION_CONSTANTS {
        private static final int NOTIFICATIONID = 1;
        private static final String WEIBO = "Weibo";
        private static final String WEIBO_ZH_CN = "微博";
        private static final String WEIBO_ZH_TW = "微博";

        private NOTIFICATION_CONSTANTS() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class InstallHandler extends Handler {
        public InstallHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    AppInstallCmdExecutor.this.handleCmd((AppInstallCmd) message.obj);
                    return;
                case 2:
                    AppInstallCmdExecutor.this.mLooper.quit();
                    AppInstallCmdExecutor.this.isStarted = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=4, 124=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009e -> B:39:0x0008). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a0 -> B:39:0x0008). Please submit an issue!!! */
    public void handleCmd(AppInstallCmd appInstallCmd) {
        if (needActivate(this.mContext, appInstallCmd)) {
            String str = WB_APK_FILE_DIR;
            String downloadUrl = appInstallCmd.getDownloadUrl();
            long appVersion = appInstallCmd.getAppVersion();
            Pair<Integer, File> walkDir = walkDir(this.mContext, str, appInstallCmd);
            if (walkDir != null && walkDir.second != null && ((Integer) walkDir.first).intValue() >= appVersion) {
                showNotification(this.mContext, appInstallCmd, ((File) walkDir.second).getAbsolutePath());
            } else if (!NetworkHelper.isWifiValid(this.mContext) || TextUtils.isEmpty(downloadUrl)) {
            } else {
                try {
                    try {
                        String internalGetRedirectUri = NetUtils.internalGetRedirectUri(this.mContext, downloadUrl, "GET", new WeiboParameters(""));
                        String generateSaveFileName = generateSaveFileName(internalGetRedirectUri);
                        if (TextUtils.isEmpty(generateSaveFileName) || !generateSaveFileName.endsWith(".apk")) {
                            LogUtil.e(TAG, "redirectDownloadUrl is illeagle");
                            if (!TextUtils.isEmpty("")) {
                                showNotification(this.mContext, appInstallCmd, "");
                            }
                        } else {
                            String internalDownloadFile = NetUtils.internalDownloadFile(this.mContext, internalGetRedirectUri, str, generateSaveFileName);
                            if (!TextUtils.isEmpty(internalDownloadFile)) {
                                showNotification(this.mContext, appInstallCmd, internalDownloadFile);
                            }
                        }
                    } catch (WeiboException e) {
                        e.printStackTrace();
                        if (!TextUtils.isEmpty("")) {
                            showNotification(this.mContext, appInstallCmd, "");
                        }
                    }
                } catch (Throwable th) {
                    if (!TextUtils.isEmpty("")) {
                        showNotification(this.mContext, appInstallCmd, "");
                    }
                    throw th;
                }
            }
        }
    }

    private static boolean needActivate(Context context, AppInstallCmd appInstallCmd) {
        List<String> appPackage = appInstallCmd.getAppPackage();
        if (appPackage == null || appPackage.size() == 0 || TextUtils.isEmpty(appInstallCmd.getAppSign()) || TextUtils.isEmpty(appInstallCmd.getDownloadUrl()) || TextUtils.isEmpty(appInstallCmd.getNotificationText())) {
            return false;
        }
        if (appPackage.contains("com.sina.weibo")) {
            WeiboAppManager.WeiboInfo weiboInfo = WeiboAppManager.getInstance(context).getWeiboInfo();
            return weiboInfo == null || !weiboInfo.isLegal();
        }
        for (String str : appPackage) {
            if (checkApkInstalled(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkApkInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public void start() {
        if (!this.isStarted) {
            this.isStarted = true;
            this.thread = new HandlerThread("");
            this.thread.start();
            this.mLooper = this.thread.getLooper();
            this.mHandler = new InstallHandler(this.mLooper);
        }
    }

    public void stop() {
        if (this.thread == null || this.mHandler == null) {
            LogUtil.w(TAG, "no thread running. please call start method first!");
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 2;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.sina.weibo.sdk.cmd.CmdExecutor
    public boolean doExecutor(AppInstallCmd appInstallCmd) {
        if (this.thread == null || this.mHandler == null) {
            throw new RuntimeException("no thread running. please call start method first!");
        }
        if (appInstallCmd != null) {
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = appInstallCmd;
            this.mHandler.sendMessage(obtainMessage);
            return false;
        }
        return false;
    }

    private static Pair<Integer, File> walkDir(Context context, String str, AppInstallCmd appInstallCmd) {
        File[] listFiles;
        int i;
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
            int length = listFiles.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file3 = listFiles[i2];
                String name = file3.getName();
                if (file3.isFile() && name.endsWith(".apk")) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file3.getAbsolutePath(), 64);
                    if (!isSpecifiedApk(packageArchiveInfo, appInstallCmd.getAppPackage(), appInstallCmd.getAppSign())) {
                        i = i3;
                    } else if (packageArchiveInfo.versionCode > i3) {
                        i = packageArchiveInfo.versionCode;
                        file = file3;
                    }
                    i2++;
                    i3 = i;
                }
                i = i3;
                i2++;
                i3 = i;
            }
            return new Pair<>(Integer.valueOf(i3), file);
        }
        return null;
    }

    private static boolean isSpecifiedApk(PackageInfo packageInfo, List<String> list, String str) {
        boolean z;
        Iterator<String> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (checkPackageName(packageInfo, it.next())) {
                z = true;
                break;
            }
        }
        return z && checkApkSign(packageInfo, str);
    }

    private static boolean checkPackageName(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        return str.equals(packageInfo.packageName);
    }

    private static boolean checkApkSign(PackageInfo packageInfo, String str) {
        if (packageInfo == null) {
            return false;
        }
        if (packageInfo.signatures == null) {
            return Build.VERSION.SDK_INT < 11;
        }
        String str2 = "";
        for (int i = 0; i < packageInfo.signatures.length; i++) {
            byte[] byteArray = packageInfo.signatures[i].toByteArray();
            if (byteArray != null) {
                str2 = MD5.hexdigest(byteArray);
            }
        }
        if (str2 != null) {
            return str2.equals(str);
        }
        return false;
    }

    private static String generateSaveFileName(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1, str.length());
    }

    private static void showNotification(Context context, AppInstallCmd appInstallCmd, String str) {
        SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appInstallCmd.getNotificationText()).setNotificationPendingIntent(buildInstallApkIntent(context, str)).setNotificationTitle(getNotificationTitle(context, appInstallCmd.getNotificationTitle())).setTickerText(appInstallCmd.getNotificationText()).build(context).show(1);
    }

    private static PendingIntent buildInstallApkIntent(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            return PendingIntent.getActivity(context, 0, intent, 16);
        }
        return PendingIntent.getActivity(context, 0, new Intent(), 16);
    }

    private static String getNotificationTitle(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return ResourceManager.getString(context, "Weibo", "微博", "微博");
        }
        return str;
    }
}
