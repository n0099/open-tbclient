package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class BasicBehaviorController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean EMPTY_DATA_FORBIDDEN = false;
    public static final long EMPTY_VALUE = 0;
    public static final String KEY_BEHAVIOR_APPA = "PREF_KEY_BEHAVIOR_APPA";
    public static final String KEY_BEHAVIOR_PAGE = "PREF_KEY_BEHAVIOR_PAGE";
    public static final String KEY_LAST_ONPAUSE_TIME = "PREF_KEY_StatisSDK_LAST_ONPAUSE_TIME";
    public static final String KEY_QUIT_TIME = "PREF_KEY_StatisSDK_QuitTime";
    public static final String KEY_SESSION = "PREF_KEY_StatisSDK_SESSION";
    public static final String KEY_UID = "PREF_KEY_StatisSDK_UID";
    public transient /* synthetic */ FieldHolder $fh;
    public final AppActionReporter mAppActionCollector;
    public long mBackgroundDurationMillisAsQuit;
    public final Context mContext;
    public volatile boolean mIsLoaded;
    public long mLastReportCpuMillis;
    public int mMaxbehaviorSendThreshold;
    public final IOnStatisListener mOnStatisListener;
    public final PageActionReporter mPageActionCollector;
    public IStatisAPI mStatisAPI;
    public int mbehaviorSendThreshold;

    /* loaded from: classes8.dex */
    public class AppActionReporter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AppaInfo mAppaInfo;
        public long mBeginStartCpuTimeMillis;
        public volatile AppaElemInfo mElemInfo;
        public long mEndStartCpuTimeMillis;
        public final /* synthetic */ BasicBehaviorController this$0;

        public AppActionReporter(BasicBehaviorController basicBehaviorController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basicBehaviorController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = basicBehaviorController;
            this.mAppaInfo = new AppaInfo();
        }

        private void createElemIfNull() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.mElemInfo == null) {
                this.mElemInfo = new AppaElemInfo();
            }
        }

        private boolean isStartCalled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) ? this.mBeginStartCpuTimeMillis != 0 : invokeV.booleanValue;
        }

        private boolean isStartedCalled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.mEndStartCpuTimeMillis != 0 : invokeV.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRecordPagePath(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, this, strArr) == null) {
                addParams(strArr);
            }
        }

        private void onSaveAppaFile(AppaInfo appaInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65544, this, appaInfo) == null) {
                ThreadPool.getPool().executeQueue(new Runnable(this, appaInfo) { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.AppActionReporter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AppActionReporter this$1;
                    public final /* synthetic */ AppaInfo val$info;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, appaInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$info = appaInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$1.this$0.saveAppaInfo(this.val$info);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSaveTmpAppa(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
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
        }

        private void resetData() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65546, this) == null) {
                this.mElemInfo = null;
                this.mEndStartCpuTimeMillis = 0L;
                this.mBeginStartCpuTimeMillis = 0L;
            }
        }

        public void addParams(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) {
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
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mAppaInfo.clear();
                onSaveAppaFile(this.mAppaInfo);
            }
        }

        public AppaInfo getAppaInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAppaInfo : (AppaInfo) invokeV.objValue;
        }

        public void onAppStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        }

        public void onExitApp(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                onExitApp(false, z, z2);
            }
        }

        public void onStartApp() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                L.brief("appa onStartApp: init app data", new Object[0]);
                resetData();
                createElemIfNull();
                long wallTimeMillis = Util.wallTimeMillis();
                this.mBeginStartCpuTimeMillis = wallTimeMillis;
                L.brief("Begin Start Cpu Time Millis is %d", Long.valueOf(wallTimeMillis));
                if (this.mElemInfo != null) {
                    this.mElemInfo.setStime(this.mBeginStartCpuTimeMillis);
                }
                long lastQuitTime = this.this$0.getLastQuitTime();
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
        }

        private void onExitApp(boolean z, boolean z2, boolean z3) {
            AppaElemInfo appaElemInfo;
            AppaElemInfo appaElemInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                L.brief("appa onExitApp: shutdown %b flush commands %b. isNormal %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
                AppaElemInfo appaElemInfo3 = this.mElemInfo;
                long wallTimeMillis = Util.wallTimeMillis();
                if (z3) {
                    long lastOnPauseTime = this.this$0.getLastOnPauseTime();
                    long j = this.this$0.mBackgroundDurationMillisAsQuit;
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
                            this.this$0.clearStoredAppaInfo();
                        }
                        resetData();
                        this.this$0.saveQuitTimeMillis(wallTimeMillis);
                        this.this$0.saveUid();
                        this.this$0.sendReportForce(false);
                    }
                }
                appaElemInfo = appaElemInfo3;
                if (appaElemInfo == null) {
                }
                L.debug(this, "appa onExitApp:Failed to statis app usage time .elemInfo[%s] is null or mBeginStartCpuTimeMillis[%d]=0 or mEndStartCpuTimeMillis[%d]=0", appaElemInfo, Long.valueOf(this.mBeginStartCpuTimeMillis), Long.valueOf(this.mEndStartCpuTimeMillis));
                this.this$0.clearStoredAppaInfo();
                resetData();
                this.this$0.saveQuitTimeMillis(wallTimeMillis);
                this.this$0.saveUid();
                this.this$0.sendReportForce(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class PageActionReporter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mEnterTimeStamp;
        public PageElemInfo mPageElemInfo;
        public final PageInfo mPageInfo;
        public long mStartJumpingTimeStamp;
        public final /* synthetic */ BasicBehaviorController this$0;

        public PageActionReporter(BasicBehaviorController basicBehaviorController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basicBehaviorController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = basicBehaviorController;
            this.mPageInfo = new PageInfo();
        }

        private void onSavePageFile(PageInfo pageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, pageInfo) == null) {
                ThreadPool.getPool().executeQueue(new Runnable(this, pageInfo) { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.PageActionReporter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PageActionReporter this$1;
                    public final /* synthetic */ PageInfo val$info;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, pageInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$info = pageInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$1.this$0.savePageInfo(this.val$info);
                        }
                    }
                });
            }
        }

        private void onSaveTmpPage() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                PageInfo pageInfo = new PageInfo();
                pageInfo.add(this.mPageInfo);
                pageInfo.addElem(this.mPageElemInfo);
                onSavePageFile(pageInfo);
                this.this$0.saveTmpAppa(this.mPageElemInfo.getPage());
            }
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mPageInfo.clear();
                onSavePageFile(this.mPageInfo);
            }
        }

        public void clearCurPageElement() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mPageElemInfo = null;
                this.mEnterTimeStamp = 0L;
                this.mStartJumpingTimeStamp = 0L;
                L.brief("clear curpage element !", new Object[0]);
            }
        }

        public PageInfo getPageInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPageInfo : (PageInfo) invokeV.objValue;
        }

        public void onFinishGotoUI(long j, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)}) == null) {
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
                    if (this.mPageElemInfo.getDelayedTime() > this.this$0.mBackgroundDurationMillisAsQuit * 3) {
                        L.warn(this, "page onFinishGotoUI [%s]: Dtime[%d] is off normal,this page data not report", page, Long.valueOf(this.mPageElemInfo.getDelayedTime()));
                        clearCurPageElement();
                        return;
                    }
                    L.brief("page onFinishGotoUI [%s]:normal. report from page [%s] to destPageId [%s]", page, page, str);
                    this.mPageInfo.addElem(this.mPageElemInfo);
                    clearCurPageElement();
                    L.brief("Page elements %d", Integer.valueOf(this.mPageInfo.getElemsCount()));
                    this.this$0.onNewDataAdded(j);
                    onSavePageFile(this.mPageInfo);
                    this.this$0.recordPagePath(page);
                    this.this$0.saveTmpAppa(null);
                    return;
                }
                L.error(this, "page onFinishGotoUI , Illegal state exception, is onResumeUI,onLeavingUI not called? mPageElemInfo is null", new Object[0]);
            }
        }

        public void onLeavingUI(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
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
        }

        public void onResumeUI(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048581, this, j, str) == null) {
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
        }

        public void setCurPageParam(String str) {
            PageElemInfo pageElemInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (pageElemInfo = this.mPageElemInfo) == null) {
                return;
            }
            pageElemInfo.clearParams();
            this.mPageElemInfo.addParam(str);
        }
    }

    public BasicBehaviorController(Context context, Handler handler, IOnStatisListener iOnStatisListener, IStatisAPI iStatisAPI, long j, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, iOnStatisListener, iStatisAPI, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAppActionCollector = new AppActionReporter(this);
        this.mPageActionCollector = new PageActionReporter(this);
        this.mIsLoaded = false;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_APPA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoredPageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_PAGE, null);
        }
    }

    public static boolean empty(Info<?> info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, info)) == null) ? info == null || info.getElemsCount() == 0 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastQuitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_QUIT_TIME, 0L) : invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStoredSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? DefaultPreference.getPreference().getPrefString(this.mContext, KEY_SESSION, null) : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getStoredUid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65559, this, j)) == null) ? DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_UID, j) : invokeJ.longValue;
    }

    private int getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            int i2 = this.mbehaviorSendThreshold;
            int i3 = this.mMaxbehaviorSendThreshold;
            int max = Math.max(1, Math.min(i2, i3));
            if (max < 1 || max > i3) {
                L.debug(this, "Error : logical error , threshold result : %d", Integer.valueOf(max));
            }
            return max;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadStoredAppaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) ? DefaultPreference.getPreference().getPrefString(this.mContext, KEY_BEHAVIOR_APPA, null) : (String) invokeV.objValue;
    }

    private void loadStoredAsync() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || this.mIsLoaded) {
            return;
        }
        this.mIsLoaded = true;
        L.brief("Load stored async", new Object[0]);
        loadStoredAsyncSend();
    }

    private void loadStoredAsyncSend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.mContext == null) {
                L.error(this, "Illegal state error : no Context set.", new Object[0]);
                return;
            }
            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.defs.controller.BasicBehaviorController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BasicBehaviorController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String loadStoredAppaInfo = this.this$0.loadStoredAppaInfo();
                            String loadStoredPageInfo = this.this$0.loadStoredPageInfo();
                            L.brief("clear stored info", new Object[0]);
                            this.this$0.clearStoredPageInfo();
                            this.this$0.clearStoredAppaInfo();
                            if (!Util.empty(loadStoredAppaInfo) || !Util.empty(loadStoredPageInfo)) {
                                long storedUid = this.this$0.getStoredUid(0L);
                                String storedSession = this.this$0.getStoredSession();
                                L.brief("Send old behavior report, for uid %d, session %s", Long.valueOf(storedUid), storedSession);
                                StatisAPI createNewStatisApi = HiidoSDK.instance().createNewStatisApi();
                                createNewStatisApi.setSession(storedSession);
                                createNewStatisApi.init(this.this$0.mContext, this.this$0.mStatisAPI.getOption());
                                L.debug(this, "report stored basicBehavior with new statisAPI [%s]", createNewStatisApi);
                                if (!Util.empty(loadStoredAppaInfo)) {
                                    createNewStatisApi.reportLanuch(storedUid, loadStoredAppaInfo, SensorController.loadFileAndClear(this.this$0.mContext));
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
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadStoredPageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) ? DefaultPreference.getPreference().getPrefString(this.mContext, KEY_BEHAVIOR_PAGE, null) : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewDataAdded(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65565, this, j) == null) {
            sendReportIfReach(getThreshold());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordPagePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, str) == null) {
            getAppActionCollector().onRecordPagePath(str);
        }
    }

    private void reportBasicBehavior(Context context, long j, AppaInfo appaInfo, PageInfo pageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, this, new Object[]{context, Long.valueOf(j), appaInfo, pageInfo}) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAppaInfo(AppaInfo appaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, appaInfo) == null) {
            DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_APPA, appaInfo.getResult());
            saveUid();
            saveSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePageInfo(PageInfo pageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, pageInfo) == null) {
            DefaultPreference.getPreference().setPrefString(this.mContext, KEY_BEHAVIOR_PAGE, pageInfo.getResult());
            saveUid();
            saveSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveQuitTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65570, this, j) == null) {
            DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_QUIT_TIME, j);
        }
    }

    private void saveSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            DefaultPreference.getPreference().setPrefString(this.mContext, KEY_SESSION, this.mStatisAPI.getSession());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTmpAppa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, str) == null) {
            getAppActionCollector().onSaveTmpAppa(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_UID, this.mOnStatisListener.getCurrentUid());
        }
    }

    private void sendReportIfReach(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65574, this, i2) == null) {
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
    }

    public AppActionReporter getAppActionCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppActionCollector : (AppActionReporter) invokeV.objValue;
    }

    public long getLastOnPauseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DefaultPreference.getPreference().getPrefLong(this.mContext, KEY_LAST_ONPAUSE_TIME, 0L) : invokeV.longValue;
    }

    public long getLastReportCpuMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLastReportCpuMillis : invokeV.longValue;
    }

    public PageActionReporter getPageActionCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPageActionCollector : (PageActionReporter) invokeV.objValue;
    }

    public boolean isReported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLastReportCpuMillis != 0 : invokeV.booleanValue;
    }

    public void saveLastOnPauseTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            DefaultPreference.getPreference().setPrefLong(this.mContext, KEY_LAST_ONPAUSE_TIME, j);
        }
    }

    public void sendReportForce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            sendReportIfReach(z ? -1 : 1);
        }
    }
}
