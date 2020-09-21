package com.sina.weibo.sdk.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes24.dex */
class WBAgentHandler {
    private static int MAX_CACHE_SIZE = 5;
    private static CopyOnWriteArrayList<PageLog> mActivePages;
    private static WBAgentHandler mInstance;
    private static Timer mLogTimer;
    private static Map<String, PageLog> mPages;
    private static Timer mTimer;

    public static synchronized WBAgentHandler getInstance() {
        WBAgentHandler wBAgentHandler;
        synchronized (WBAgentHandler.class) {
            if (mInstance == null) {
                mInstance = new WBAgentHandler();
            }
            wBAgentHandler = mInstance;
        }
        return wBAgentHandler;
    }

    private WBAgentHandler() {
        mActivePages = new CopyOnWriteArrayList<>();
        mPages = new HashMap();
        LogUtil.i(WBAgent.TAG, "init handler");
    }

    public void onPageStart(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(str);
            pageLog.setType(LogType.FRAGMENT);
            synchronized (mPages) {
                mPages.put(str, pageLog);
            }
            LogUtil.d(WBAgent.TAG, str + ", " + (pageLog.getStartTime() / 1000));
        }
    }

    public void onPageEnd(String str) {
        if (!StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(str)) {
                PageLog pageLog = mPages.get(str);
                pageLog.setDuration(System.currentTimeMillis() - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(str);
                }
                LogUtil.d(WBAgent.TAG, str + ", " + (pageLog.getStartTime() / 1000) + ", " + (pageLog.getDuration() / 1000));
            } else {
                LogUtil.e(WBAgent.TAG, "please call onPageStart before onPageEnd");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
    }

    public void onResume(Context context) {
        if (LogReport.getPackageName() == null) {
            LogReport.setPackageName(context.getPackageName());
        }
        if (mTimer == null) {
            mTimer = timerTask(context, 500L, StatisticConfig.getUploadInterval());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        checkNewSession(context, currentTimeMillis);
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            PageLog pageLog = new PageLog(name, currentTimeMillis);
            pageLog.setType(LogType.ACTIVITY);
            synchronized (mPages) {
                mPages.put(name, pageLog);
            }
        }
        LogUtil.d(WBAgent.TAG, name + ", " + (currentTimeMillis / 1000));
    }

    public void onPause(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String name = context.getClass().getName();
        LogUtil.i(WBAgent.TAG, "update last page endtime:" + (currentTimeMillis / 1000));
        PageLog.updateSession(context, null, 0L, Long.valueOf(currentTimeMillis));
        if (StatisticConfig.ACTIVITY_DURATION_OPEN) {
            if (mPages.containsKey(name)) {
                PageLog pageLog = mPages.get(name);
                pageLog.setDuration(currentTimeMillis - pageLog.getStartTime());
                synchronized (mActivePages) {
                    mActivePages.add(pageLog);
                }
                synchronized (mPages) {
                    mPages.remove(name);
                }
                LogUtil.d(WBAgent.TAG, name + ", " + (pageLog.getStartTime() / 1000) + ", " + (pageLog.getDuration() / 1000));
            } else {
                LogUtil.e(WBAgent.TAG, "please call onResume before onPause");
            }
            if (mActivePages.size() >= MAX_CACHE_SIZE) {
                synchronized (mActivePages) {
                    saveActivePages(mActivePages);
                    mActivePages.clear();
                }
            }
        }
        checkAppStatus(context);
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        EventLog eventLog = new EventLog(str, str2, map);
        eventLog.setType(LogType.EVENT);
        synchronized (mActivePages) {
            mActivePages.add(eventLog);
        }
        if (map == null) {
            LogUtil.d(WBAgent.TAG, "event--- page:" + str + " ,event name:" + str2);
        } else {
            LogUtil.d(WBAgent.TAG, "event--- page:" + str + " ,event name:" + str2 + " ,extend:" + map.toString());
        }
        if (mActivePages.size() >= MAX_CACHE_SIZE) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    public void uploadAppLogs(final Context context) {
        long currentTimeMillis = System.currentTimeMillis() - LogReport.getTime(context);
        if (LogReport.getTime(context) > 0 && currentTimeMillis < 30000) {
            timerTask(context, 30000 - currentTimeMillis, 0L);
        } else {
            WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
                }
            });
        }
    }

    public void onStop(Context context) {
        checkAppStatus(context);
    }

    private void checkAppStatus(Context context) {
        if (isBackground(context)) {
            synchronized (mActivePages) {
                saveActivePages(mActivePages);
                mActivePages.clear();
            }
        }
    }

    private boolean isBackground(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                if (runningAppProcessInfo.importance == 400) {
                    LogUtil.i(WBAgent.TAG, "后台:" + runningAppProcessInfo.processName);
                    return true;
                }
                LogUtil.i(WBAgent.TAG, "前台:" + runningAppProcessInfo.processName);
                return false;
            }
        }
        return false;
    }

    public void onKillProcess() {
        LogUtil.i(WBAgent.TAG, "save applogs and close timer and shutdown thread executor");
        synchronized (mActivePages) {
            saveActivePages(mActivePages);
        }
        mInstance = null;
        closeTimer();
        WBAgentExecutor.shutDownExecutor();
    }

    private void checkNewSession(Context context, long j) {
        if (PageLog.isNewSession(context, j)) {
            PageLog pageLog = new PageLog(context);
            pageLog.setType(LogType.SESSION_END);
            PageLog pageLog2 = new PageLog(context, j);
            pageLog2.setType(LogType.SESSION_START);
            synchronized (mActivePages) {
                if (pageLog.getEndTime() > 0) {
                    mActivePages.add(pageLog);
                } else {
                    LogUtil.d(WBAgent.TAG, "is a new install");
                }
                mActivePages.add(pageLog2);
            }
            LogUtil.d(WBAgent.TAG, "last session--- starttime:" + pageLog.getStartTime() + " ,endtime:" + pageLog.getEndTime());
            LogUtil.d(WBAgent.TAG, "is a new session--- starttime:" + pageLog2.getStartTime());
            return;
        }
        LogUtil.i(WBAgent.TAG, "is not a new session");
    }

    private synchronized void saveActivePages(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        final String pageLogs = LogBuilder.getPageLogs(copyOnWriteArrayList);
        WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.2
            @Override // java.lang.Runnable
            public void run() {
                LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), pageLogs, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String getLogsInMemory() {
        String str;
        str = "";
        if (mActivePages.size() > 0) {
            synchronized (mActivePages) {
                str = LogBuilder.getPageLogs(mActivePages);
                mActivePages.clear();
            }
        }
        return str;
    }

    private Timer timerTask(final Context context, long j, long j2) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        };
        if (j2 == 0) {
            timer.schedule(timerTask, j);
        } else {
            timer.schedule(timerTask, j, j2);
        }
        return timer;
    }

    private void closeTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void registerApptoAd(final Context context, final String str, Map<String, String> map) {
        try {
            final AdEventLog adEventLog = new AdEventLog();
            adEventLog.setType(LogType.APP_AD_START);
            if (isFirstStartBoolean(context)) {
                adEventLog.setmEvent_id("1");
            }
            adEventLog.setmImei(MD5.hexdigest(getImei(context)));
            adEventLog.setmStart_time(System.currentTimeMillis());
            adEventLog.setmExtend(map);
            String aid = Utility.getAid(context, str);
            if (TextUtils.isEmpty(aid)) {
                TimerTask timerTask = new TimerTask() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.4
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        adEventLog.setmAid(Utility.getAid(context, str));
                        WBAgentHandler.this.uploadAdlog(context, adEventLog);
                    }
                };
                mLogTimer = new Timer();
                mLogTimer.schedule(timerTask, 5000L);
                return;
            }
            adEventLog.setmAid(aid);
            uploadAdlog(context, adEventLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    public void uploadAdlog(final Context context, AdEventLog adEventLog) {
        mActivePages.add(adEventLog);
        WBAgentExecutor.execute(new Runnable() { // from class: com.sina.weibo.sdk.statistic.WBAgentHandler.5
            @Override // java.lang.Runnable
            public void run() {
                LogReport.uploadAppLogs(context, WBAgentHandler.this.getLogsInMemory());
            }
        });
    }

    public static boolean isFirstStartBoolean(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(WBConstants.THIRD_APP_IS_FIRST, 0);
        boolean z = sharedPreferences.getBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, true);
        if (z) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(WBConstants.THIRD_APP_IS_FIRST_KEY, false);
            edit.commit();
        }
        return z;
    }
}
