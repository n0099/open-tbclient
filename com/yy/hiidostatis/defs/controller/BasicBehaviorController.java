package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Handler;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.defs.interf.IOnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.defs.obj.AppaElemInfo;
import com.yy.hiidostatis.defs.obj.AppaInfo;
import com.yy.hiidostatis.defs.obj.Info;
import com.yy.hiidostatis.defs.obj.PageElemInfo;
import com.yy.hiidostatis.defs.obj.PageInfo;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
/* loaded from: classes7.dex */
public class BasicBehaviorController {
    public static final boolean EMPTY_DATA_FORBIDDEN = false;
    public static final long EMPTY_VALUE = 0;
    public static final String KEY_BEHAVIOR_APPA = "PREF_KEY_BEHAVIOR_APPA";
    public static final String KEY_BEHAVIOR_PAGE = "PREF_KEY_BEHAVIOR_PAGE";
    public static final String KEY_LAST_ONPAUSE_TIME = "PREF_KEY_StatisSDK_LAST_ONPAUSE_TIME";
    public static final String KEY_QUIT_TIME = "PREF_KEY_StatisSDK_QuitTime";
    public static final String KEY_SESSION = "PREF_KEY_StatisSDK_SESSION";
    public static final String KEY_UID = "PREF_KEY_StatisSDK_UID";
    public long mBackgroundDurationMillisAsQuit;
    public final Context mContext;
    public long mLastReportCpuMillis;
    public int mMaxbehaviorSendThreshold;
    public final IOnStatisListener mOnStatisListener;
    public IStatisAPI mStatisAPI;
    public int mbehaviorSendThreshold;
    public final AppActionReporter mAppActionCollector = new AppActionReporter();
    public final PageActionReporter mPageActionCollector = new PageActionReporter();
    public volatile boolean mIsLoaded = false;

    /* loaded from: classes7.dex */
    public class AppActionReporter {
        public final AppaInfo mAppaInfo = new AppaInfo();
        public long mBeginStartCpuTimeMillis;
        public volatile AppaElemInfo mElemInfo;
        public long mEndStartCpuTimeMillis;

        public AppActionReporter() {
        }

        private void createElemIfNull() {
            if (this.mElemInfo == null) {
                this.mElemInfo = new AppaElemInfo();
            }
        }

        private boolean isStartCalled() {
            return this.mBeginStartCpuTimeMillis != 0;
        }

        private boolean isStartedCalled() {
            return this.mEndStartCpuTimeMillis != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRecordPagePath(String... strArr) {
            addParams(strArr);
        }

        private void onSaveAppaFile(final AppaInfo appaInfo) {
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.AppActionReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    BasicBehaviorController.this.saveAppaInfo(appaInfo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSaveTmpAppa(String str) {
            AppaInfo appaInfo = new AppaInfo();
            appaInfo.add(this.mAppaInfo);
            AppaElemInfo copy = this.mElemInfo.copy();
            copy.setLingerTime(Util.wallTimeMillis() - this.mBeginStartCpuTimeMillis);
            if (!Util.empty(str)) {
                copy.addParam(str);
            }
            appaInfo.addElem(copy);
            onSaveAppaFile(appaInfo);
        }

        private void resetData() {
            this.mElemInfo = null;
            this.mEndStartCpuTimeMillis = 0L;
            this.mBeginStartCpuTimeMillis = 0L;
        }

        public void addParams(String... strArr) {
            if (this.mElemInfo == null) {
                createElemIfNull();
            }
            if (strArr != null) {
                try {
                    for (String str : strArr) {
                        this.mElemInfo.addParam(str);
                    }
                } catch (Throwable th) {
                    L.debug(this, "addParams :exception %s", th);
                }
            }
        }

        public void clear() {
            this.mAppaInfo.clear();
            onSaveAppaFile(this.mAppaInfo);
        }

        public AppaInfo getAppaInfo() {
            return this.mAppaInfo;
        }

        public void onAppStarted() {
            L.brief("appa onAppStarted: entry", new Object[0]);
            if (isStartedCalled()) {
                L.error(this, "appa onAppStarted : already called. mEndStartCpuTimeMillis is %d", Long.valueOf(this.mEndStartCpuTimeMillis));
                return;
            }
            this.mEndStartCpuTimeMillis = Util.wallTimeMillis();
            long j = 0;
            if (isStartCalled()) {
                j = this.mEndStartCpuTimeMillis - this.mBeginStartCpuTimeMillis;
                L.brief("appa :launch delayed : %d millis", Long.valueOf(j));
                if (this.mElemInfo != null) {
                    this.mElemInfo.setDtime(j);
                }
            }
            L.brief("appa onAppStarted: mBeginStartCpuTimeMillis [%d],mEndStartCpuTimeMillis[%d],Dtimes[%d] ", Long.valueOf(this.mBeginStartCpuTimeMillis), Long.valueOf(this.mEndStartCpuTimeMillis), Long.valueOf(j));
        }

        public void onExitApp(boolean z, boolean z2) {
            onExitApp(false, z, z2);
        }

        public void onStartApp() {
            L.brief("appa onStartApp: init app data", new Object[0]);
            resetData();
            createElemIfNull();
            long wallTimeMillis = Util.wallTimeMillis();
            this.mBeginStartCpuTimeMillis = wallTimeMillis;
            L.brief("Begin Start Cpu Time Millis is %d", Long.valueOf(wallTimeMillis));
            if (this.mElemInfo != null) {
                this.mElemInfo.setStime(this.mBeginStartCpuTimeMillis);
            }
            long lastQuitTime = BasicBehaviorController.this.getLastQuitTime();
            L.brief("Loaded last quit time is %d", Long.valueOf(lastQuitTime));
            if (lastQuitTime == 0) {
                L.debug(this, "Last quit time is empty value %d", Long.valueOf(lastQuitTime));
                return;
            }
            long j = this.mBeginStartCpuTimeMillis;
            long j2 = j - lastQuitTime;
            L.brief("set ftime wall time %d - last quit time %d = %d", Long.valueOf(j), Long.valueOf(lastQuitTime), Long.valueOf(j2));
            if (this.mElemInfo != null) {
                this.mElemInfo.setFtime(j2);
            }
        }

        private void onExitApp(boolean z, boolean z2, boolean z3) {
            AppaElemInfo appaElemInfo;
            AppaElemInfo appaElemInfo2;
            L.brief("appa onExitApp: shutdown %b flush commands %b. isNormal %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            AppaElemInfo appaElemInfo3 = this.mElemInfo;
            long wallTimeMillis = Util.wallTimeMillis();
            if (z3) {
                long lastOnPauseTime = BasicBehaviorController.this.getLastOnPauseTime();
                long j = BasicBehaviorController.this.mBackgroundDurationMillisAsQuit;
                if (lastOnPauseTime < wallTimeMillis) {
                    appaElemInfo = appaElemInfo3;
                    if (lastOnPauseTime - this.mBeginStartCpuTimeMillis > 0) {
                        long j2 = wallTimeMillis - lastOnPauseTime;
                        long j3 = j / 2;
                        if (j2 > j - j3 && j2 < j + j3) {
                            L.brief("appa onExitApp:get the lastOnPauseTime[%d] instead of quitTime[%d]", Long.valueOf(lastOnPauseTime), Long.valueOf(wallTimeMillis));
                            wallTimeMillis = lastOnPauseTime;
                        }
                    }
                    if (appaElemInfo == null && isStartCalled() && isStartedCalled()) {
                        long j4 = this.mBeginStartCpuTimeMillis;
                        L.brief("Start CPU time millis is %d", Long.valueOf(j4));
                        if (j4 != 0) {
                            long j5 = wallTimeMillis - j4;
                            L.brief("Calculated usage time, begin %d,end %d, lasts %d", Long.valueOf(j4), Long.valueOf(wallTimeMillis), Long.valueOf(j5));
                            int i2 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
                            if (i2 != 0) {
                                L.brief("set app linger time %d sec", Long.valueOf(j5));
                                appaElemInfo2 = appaElemInfo;
                                appaElemInfo2.setLingerTime(j5);
                            } else {
                                appaElemInfo2 = appaElemInfo;
                                L.debug(this, "appa onExitApp:Cannot calculate app action linger time.", new Object[0]);
                            }
                            if (j5 > 21600000 || i2 < 0) {
                                L.warn(this, "appa onExitApp:app action linger time [%d] is off normal.", Long.valueOf(j5));
                            } else {
                                L.brief("appa onExitApp:normal", Long.valueOf(j5));
                            }
                            this.mAppaInfo.addElem(appaElemInfo2);
                        }
                    } else {
                        L.debug(this, "appa onExitApp:Failed to statis app usage time .elemInfo[%s] is null or mBeginStartCpuTimeMillis[%d]=0 or mEndStartCpuTimeMillis[%d]=0", appaElemInfo, Long.valueOf(this.mBeginStartCpuTimeMillis), Long.valueOf(this.mEndStartCpuTimeMillis));
                        BasicBehaviorController.this.clearStoredAppaInfo();
                    }
                    resetData();
                    BasicBehaviorController.this.saveQuitTimeMillis(wallTimeMillis);
                    BasicBehaviorController.this.saveUid();
                    BasicBehaviorController.this.sendReportForce(false);
                }
            }
            appaElemInfo = appaElemInfo3;
            if (appaElemInfo == null) {
            }
            L.debug(this, "appa onExitApp:Failed to statis app usage time .elemInfo[%s] is null or mBeginStartCpuTimeMillis[%d]=0 or mEndStartCpuTimeMillis[%d]=0", appaElemInfo, Long.valueOf(this.mBeginStartCpuTimeMillis), Long.valueOf(this.mEndStartCpuTimeMillis));
            BasicBehaviorController.this.clearStoredAppaInfo();
            resetData();
            BasicBehaviorController.this.saveQuitTimeMillis(wallTimeMillis);
            BasicBehaviorController.this.saveUid();
            BasicBehaviorController.this.sendReportForce(false);
        }
    }

    /* loaded from: classes7.dex */
    public class PageActionReporter {
        public long mEnterTimeStamp;
        public PageElemInfo mPageElemInfo;
        public final PageInfo mPageInfo = new PageInfo();
        public long mStartJumpingTimeStamp;

        public PageActionReporter() {
        }

        private void onSavePageFile(final PageInfo pageInfo) {
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.PageActionReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    BasicBehaviorController.this.savePageInfo(pageInfo);
                }
            });
        }

        private void onSaveTmpPage() {
            PageInfo pageInfo = new PageInfo();
            pageInfo.add(this.mPageInfo);
            pageInfo.addElem(this.mPageElemInfo);
            onSavePageFile(pageInfo);
            BasicBehaviorController.this.saveTmpAppa(this.mPageElemInfo.getPage());
        }

        public void clear() {
            this.mPageInfo.clear();
            onSavePageFile(this.mPageInfo);
        }

        public void clearCurPageElement() {
            this.mPageElemInfo = null;
            this.mEnterTimeStamp = 0L;
            this.mStartJumpingTimeStamp = 0L;
            L.brief("clear curpage element !", new Object[0]);
        }

        public PageInfo getPageInfo() {
            return this.mPageInfo;
        }

        public void onFinishGotoUI(long j, String str, boolean z) {
            PageElemInfo pageElemInfo = this.mPageElemInfo;
            if (pageElemInfo != null) {
                String page = pageElemInfo.getPage();
                if (Util.empty(page) || this.mStartJumpingTimeStamp == 0 || this.mEnterTimeStamp == 0) {
                    L.error(this, "page onFinishGotoUI [%s]: Illegal state exception.pageid[%s] is null or mEnterTimeStamp[%d]=0 or mStartJumpingTimeStamp[%d]=0 ", page, page, Long.valueOf(this.mEnterTimeStamp), Long.valueOf(this.mStartJumpingTimeStamp));
                    return;
                }
                if (z) {
                    this.mPageElemInfo.setDestinationPage(null);
                    this.mPageElemInfo.setDtime(0L);
                } else {
                    long wallTimeMillis = Util.wallTimeMillis();
                    this.mPageElemInfo.setDestinationPage(str);
                    this.mPageElemInfo.setDtime(wallTimeMillis - this.mStartJumpingTimeStamp);
                }
                if (this.mPageElemInfo.getDelayedTime() > BasicBehaviorController.this.mBackgroundDurationMillisAsQuit * 3) {
                    L.warn(this, "page onFinishGotoUI [%s]: Dtime[%d] is off normal,this page data not report", page, Long.valueOf(this.mPageElemInfo.getDelayedTime()));
                    clearCurPageElement();
                    return;
                }
                L.brief("page onFinishGotoUI [%s]:normal. report from page [%s] to destPageId [%s]", page, page, str);
                this.mPageInfo.addElem(this.mPageElemInfo);
                clearCurPageElement();
                L.brief("Page elements %d", Integer.valueOf(this.mPageInfo.getElemsCount()));
                BasicBehaviorController.this.onNewDataAdded(j);
                onSavePageFile(this.mPageInfo);
                BasicBehaviorController.this.recordPagePath(page);
                BasicBehaviorController.this.saveTmpAppa(null);
                return;
            }
            L.error(this, "page onFinishGotoUI , Illegal state exception, is onResumeUI,onLeavingUI not called? mPageElemInfo is null", new Object[0]);
        }

        public void onLeavingUI(String str, String str2) {
            PageElemInfo pageElemInfo = this.mPageElemInfo;
            if (pageElemInfo == null) {
                L.error(this, "page onLeavingUI [%s]: Illegal state exception, is onResumeUI not called? mPageElemInfo is null. ", str);
                return;
            }
            String page = pageElemInfo.getPage();
            if (!Util.empty(page) && !Util.empty(str) && !str.equals(page)) {
                L.error(this, "page onLeavingUI [%s]: onLeavingUI page[%s] is not euqal onResumeUI page[%s]", page, str, page);
                return;
            }
            if (page == null) {
                L.brief("page onLeavingUI [%s]:onResumeUI page[%s] is null,the onLeavingUI page instead of it", str, page, str);
                this.mPageElemInfo.setPage(str);
            } else {
                str = page;
            }
            if (!Util.empty(str) && this.mEnterTimeStamp != 0 && this.mStartJumpingTimeStamp == 0) {
                long wallTimeMillis = Util.wallTimeMillis();
                this.mStartJumpingTimeStamp = wallTimeMillis;
                long j = wallTimeMillis - this.mEnterTimeStamp;
                this.mPageElemInfo.setLtime(j);
                this.mPageElemInfo.setDestinationPage(str2);
                L.brief("page onLeavingUI [%s]:normal. pageid[%s], lingerTimeMillis[%d], mStartJumpingTimeStamp[%d]", str, str, Long.valueOf(j), Long.valueOf(this.mStartJumpingTimeStamp));
                onSaveTmpPage();
                return;
            }
            L.error(this, "page onLeavingUI[%s], Illegal state exception. pageid[%s] is null or mEnterTimeStamp[%d] = 0 or mStartJumpingTimeStamp[%d]!=0.", str, str, Long.valueOf(this.mEnterTimeStamp), Long.valueOf(this.mStartJumpingTimeStamp));
        }

        public void onResumeUI(long j, String str) {
            if (this.mPageElemInfo != null) {
                onFinishGotoUI(j, str, false);
            }
            clearCurPageElement();
            PageElemInfo pageElemInfo = new PageElemInfo();
            this.mPageElemInfo = pageElemInfo;
            pageElemInfo.setPage(str);
            long wallTimeMillis = Util.wallTimeMillis();
            this.mEnterTimeStamp = wallTimeMillis;
            this.mPageElemInfo.setStime(wallTimeMillis);
            L.brief("page onResumeUI [%s]:normal. init page data,pageid[%s],mEnterTimeStamp[%d]", str, str, Long.valueOf(this.mEnterTimeStamp));
        }

        public void setCurPageParam(String str) {
            PageElemInfo pageElemInfo = this.mPageElemInfo;
            if (pageElemInfo != null) {
                pageElemInfo.clearParams();
                this.mPageElemInfo.addParam(str);
            }
        }
    }

    public BasicBehaviorController(Context context, Handler handler, IOnStatisListener iOnStatisListener, IStatisAPI iStatisAPI, long j, int i2, int i3) {
        this.mContext = context;
        this.mOnStatisListener = iOnStatisListener;
        this.mStatisAPI = iStatisAPI;
        this.mBackgroundDurationMillisAsQuit = j;
        this.mbehaviorSendThreshold = i2;
        this.mMaxbehaviorSendThreshold = i3;
        loadStoredAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoredAppaInfo() {
        DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_APPA, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoredPageInfo() {
        DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_PAGE, null);
    }

    public static boolean empty(Info<?> info) {
        return info == null || info.getElemsCount() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastQuitTime() {
        return DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_QUIT_TIME, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStoredSession() {
        return DefaultPreference.getPreference().getPrefString(this.mContext, KEY_SESSION, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getStoredUid(long j) {
        return DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_UID, j);
    }

    private int getThreshold() {
        int i2 = this.mbehaviorSendThreshold;
        int i3 = this.mMaxbehaviorSendThreshold;
        int max = Math.max(1, Math.min(i2, i3));
        if (max < 1 || max > i3) {
            L.debug(this, "Error : logical error , threshold result : %d", Integer.valueOf(max));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadStoredAppaInfo() {
        return DefaultPreference.getPreference().getPrefString(this.mContext, KEY_BEHAVIOR_APPA, null);
    }

    private void loadStoredAsync() {
        if (this.mIsLoaded) {
            return;
        }
        this.mIsLoaded = true;
        L.brief("Load stored async", new Object[0]);
        loadStoredAsyncSend();
    }

    private void loadStoredAsyncSend() {
        if (this.mContext == null) {
            L.error(this, "Illegal state error : no Context set.", new Object[0]);
            return;
        }
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String loadStoredAppaInfo = BasicBehaviorController.this.loadStoredAppaInfo();
                    String loadStoredPageInfo = BasicBehaviorController.this.loadStoredPageInfo();
                    L.brief("clear stored info", new Object[0]);
                    BasicBehaviorController.this.clearStoredPageInfo();
                    BasicBehaviorController.this.clearStoredAppaInfo();
                    if (!Util.empty(loadStoredAppaInfo) || !Util.empty(loadStoredPageInfo)) {
                        long storedUid = BasicBehaviorController.this.getStoredUid(0L);
                        String storedSession = BasicBehaviorController.this.getStoredSession();
                        L.brief("Send old behavior report, for uid %d, session %s", Long.valueOf(storedUid), storedSession);
                        StatisAPI createNewStatisApi = HiidoSDK.instance().createNewStatisApi();
                        createNewStatisApi.setSession(storedSession);
                        createNewStatisApi.init(BasicBehaviorController.this.mContext, BasicBehaviorController.this.mStatisAPI.getOption());
                        L.debug(this, "report stored basicBehavior with new statisAPI [%s]", createNewStatisApi);
                        if (!Util.empty(loadStoredAppaInfo)) {
                            createNewStatisApi.reportLanuch(storedUid, loadStoredAppaInfo, SensorController.loadFileAndClear(BasicBehaviorController.this.mContext));
                        }
                        if (Util.empty(loadStoredPageInfo)) {
                            return;
                        }
                        createNewStatisApi.reportPage(storedUid, loadStoredPageInfo);
                        return;
                    }
                    L.brief("Input appa is null && page is null ", new Object[0]);
                } catch (Throwable th) {
                    L.debug(this, "loadStoredAsyncSend exception = %s", th);
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadStoredPageInfo() {
        return DefaultPreference.getPreference().getPrefString(this.mContext, KEY_BEHAVIOR_PAGE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewDataAdded(long j) {
        sendReportIfReach(getThreshold());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordPagePath(String str) {
        getAppActionCollector().onRecordPagePath(str);
    }

    private void reportBasicBehavior(Context context, long j, AppaInfo appaInfo, PageInfo pageInfo) {
        if (context == null) {
            L.debug("BasicStatisAPI", "Null context when reporting to hiido, cancelled.", new Object[0]);
            return;
        }
        if (empty(appaInfo) && empty(pageInfo)) {
            L.debug("BasicBehaviorController", "BasicBehaviour discarded, None of appa, page has value, %s, %s", appaInfo, pageInfo);
        }
        L.brief("To report Appa info %s", appaInfo);
        L.brief("To report Page info %s", pageInfo);
        if (appaInfo != null && appaInfo.getElemsCount() > 0) {
            this.mStatisAPI.reportLanuch(j, appaInfo.getResult(), SensorController.loadFileAndClear(context));
        }
        if (pageInfo == null || pageInfo.getElemsCount() <= 0) {
            return;
        }
        this.mStatisAPI.reportPage(j, pageInfo.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAppaInfo(AppaInfo appaInfo) {
        DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_APPA, appaInfo.getResult());
        saveUid();
        saveSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePageInfo(PageInfo pageInfo) {
        DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_PAGE, pageInfo.getResult());
        saveUid();
        saveSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveQuitTimeMillis(long j) {
        DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_QUIT_TIME, j);
    }

    private void saveSession() {
        DefaultPreference.getPreference().setPrefString(this.mContext, KEY_SESSION, this.mStatisAPI.getSession());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTmpAppa(String str) {
        getAppActionCollector().onSaveTmpAppa(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUid() {
        DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_UID, this.mOnStatisListener.getCurrentUid());
    }

    private void sendReportIfReach(int i2) {
        Context context = this.mContext;
        if (context == null) {
            L.error(this, "Illegal state : Context is null.", new Object[0]);
        }
        PageInfo pageInfo = this.mPageActionCollector.getPageInfo();
        int elemsCount = pageInfo.getElemsCount();
        AppaInfo appaInfo = this.mAppActionCollector.getAppaInfo();
        int elemsCount2 = appaInfo.getElemsCount();
        L.brief("page %d appa %d, threshold %d", Integer.valueOf(elemsCount), Integer.valueOf(elemsCount2), Integer.valueOf(i2));
        if (elemsCount2 >= i2) {
            reportBasicBehavior(context, this.mOnStatisListener.getCurrentUid(), appaInfo, null);
            this.mAppActionCollector.clear();
        }
        if (elemsCount >= i2) {
            reportBasicBehavior(context, this.mOnStatisListener.getCurrentUid(), null, pageInfo);
            this.mPageActionCollector.clear();
        }
    }

    public AppActionReporter getAppActionCollector() {
        return this.mAppActionCollector;
    }

    public long getLastOnPauseTime() {
        return DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_LAST_ONPAUSE_TIME, 0L);
    }

    public long getLastReportCpuMillis() {
        return this.mLastReportCpuMillis;
    }

    public PageActionReporter getPageActionCollector() {
        return this.mPageActionCollector;
    }

    public boolean isReported() {
        return this.mLastReportCpuMillis != 0;
    }

    public void saveLastOnPauseTime(long j) {
        DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_LAST_ONPAUSE_TIME, j);
    }

    public void sendReportForce(boolean z) {
        sendReportIfReach(z ? -1 : 1);
    }
}
