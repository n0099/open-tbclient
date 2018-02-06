package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.AesEncrypt;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class WbAppActivator {
    private static final String TAG = WbAppActivator.class.getName();
    private static WbAppActivator mInstance;
    private String mAppkey;
    private Context mContext;
    private AppInstallCmdExecutor mInstallExecutor;
    private AppInvokeCmdExecutor mInvokeExecutor;
    private volatile ReentrantLock mLock = new ReentrantLock(true);

    private WbAppActivator(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mInvokeExecutor = new AppInvokeCmdExecutor(this.mContext);
        this.mInstallExecutor = new AppInstallCmdExecutor(this.mContext);
        this.mAppkey = str;
    }

    public static synchronized WbAppActivator getInstance(Context context, String str) {
        WbAppActivator wbAppActivator;
        synchronized (WbAppActivator.class) {
            if (mInstance == null) {
                mInstance = new WbAppActivator(context, str);
            }
            wbAppActivator = mInstance;
        }
        return wbAppActivator;
    }

    public void activateApp() {
        final SharedPreferences weiboSdkSp = FrequencyHelper.getWeiboSdkSp(this.mContext);
        long frequency = FrequencyHelper.getFrequency(this.mContext, weiboSdkSp);
        long currentTimeMillis = System.currentTimeMillis() - FrequencyHelper.getLastTime(this.mContext, weiboSdkSp);
        if (currentTimeMillis < frequency) {
            LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", Long.valueOf(currentTimeMillis)));
        } else {
            new Thread(new Runnable() { // from class: com.sina.weibo.sdk.cmd.WbAppActivator.1
                @Override // java.lang.Runnable
                public void run() {
                    CmdInfo cmdInfo;
                    LogUtil.v(WbAppActivator.TAG, "mLock.isLocked()--->" + WbAppActivator.this.mLock.isLocked());
                    if (WbAppActivator.this.mLock.tryLock()) {
                        CmdInfo cmdInfo2 = null;
                        try {
                            try {
                                String requestCmdInfo = WbAppActivator.requestCmdInfo(WbAppActivator.this.mContext, WbAppActivator.this.mAppkey);
                                if (requestCmdInfo == null) {
                                    cmdInfo = null;
                                } else {
                                    cmdInfo = new CmdInfo(AesEncrypt.Decrypt(requestCmdInfo));
                                    try {
                                        WbAppActivator.this.handleInstallCmd(cmdInfo.getInstallCmds());
                                        WbAppActivator.this.handleInvokeCmd(cmdInfo.getInvokeCmds());
                                    } catch (WeiboException e) {
                                        cmdInfo2 = cmdInfo;
                                        e = e;
                                        LogUtil.e(WbAppActivator.TAG, e.getMessage());
                                        WbAppActivator.this.mLock.unlock();
                                        if (cmdInfo2 != null) {
                                            FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, weiboSdkSp, cmdInfo2.getFrequency());
                                            FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, weiboSdkSp, System.currentTimeMillis());
                                        }
                                        LogUtil.v(WbAppActivator.TAG, "after unlock \n mLock.isLocked()--->" + WbAppActivator.this.mLock.isLocked());
                                        return;
                                    } catch (Throwable th) {
                                        cmdInfo2 = cmdInfo;
                                        th = th;
                                        WbAppActivator.this.mLock.unlock();
                                        if (cmdInfo2 != null) {
                                            FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, weiboSdkSp, cmdInfo2.getFrequency());
                                            FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, weiboSdkSp, System.currentTimeMillis());
                                        }
                                        LogUtil.v(WbAppActivator.TAG, "after unlock \n mLock.isLocked()--->" + WbAppActivator.this.mLock.isLocked());
                                        throw th;
                                    }
                                }
                                WbAppActivator.this.mLock.unlock();
                                if (cmdInfo != null) {
                                    FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, weiboSdkSp, cmdInfo.getFrequency());
                                    FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, weiboSdkSp, System.currentTimeMillis());
                                }
                                LogUtil.v(WbAppActivator.TAG, "after unlock \n mLock.isLocked()--->" + WbAppActivator.this.mLock.isLocked());
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (WeiboException e2) {
                            e = e2;
                        }
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String requestCmdInfo(Context context, String str) {
        String packageName = context.getPackageName();
        String sign = Utility.getSign(context, packageName);
        WeiboParameters weiboParameters = new WeiboParameters(str);
        weiboParameters.put("appkey", str);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        weiboParameters.put("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        return NetUtils.internalHttpRequest(context, "http://api.weibo.cn/2/client/common_config", "GET", weiboParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInstallCmd(List<AppInstallCmd> list) {
        if (list != null) {
            this.mInstallExecutor.start();
            for (AppInstallCmd appInstallCmd : list) {
                this.mInstallExecutor.doExecutor(appInstallCmd);
            }
            this.mInstallExecutor.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInvokeCmd(List<AppInvokeCmd> list) {
        if (list != null) {
            for (AppInvokeCmd appInvokeCmd : list) {
                this.mInvokeExecutor.doExecutor(appInvokeCmd);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class FrequencyHelper {
        private static final int DEFAULT_FREQUENCY = 3600000;
        private static final String KEY_FREQUENCY = "frequency_get_cmd";
        private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
        private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";

        private FrequencyHelper() {
        }

        public static SharedPreferences getWeiboSdkSp(Context context) {
            return context.getSharedPreferences(WEIBO_SDK_PREFERENCES_NAME, 0);
        }

        public static long getFrequency(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(KEY_FREQUENCY, 3600000L);
            }
            return 3600000L;
        }

        public static void saveFrequency(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null && j > 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(KEY_FREQUENCY, j);
                edit.commit();
            }
        }

        public static long getLastTime(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(KEY_LAST_TIME_GET_CMD, 0L);
            }
            return 0L;
        }

        public static void saveLastTime(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(KEY_LAST_TIME_GET_CMD, j);
                edit.commit();
            }
        }
    }
}
