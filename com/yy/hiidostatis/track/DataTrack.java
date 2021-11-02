package com.yy.hiidostatis.track;

import android.content.Context;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.implementation.TaskManagerNew;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import org.json.JSONObject;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class DataTrack {
    public static final /* synthetic */ DataTrack[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INTERVAL = 600000;
    public static final DataTrack instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IDataTrackListener mDataTrackListener;
    public volatile boolean mIsEnable;
    public volatile boolean mIsTrack;
    public StatisAPI mStatisAPI;
    public StatisOption mStatisOption;
    public volatile long mUid;
    public long reportTime;

    /* loaded from: classes2.dex */
    public interface IDataTrackListener {
        JSONObject getConfig(String str, long j, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(37758001, "Lcom/yy/hiidostatis/track/DataTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(37758001, "Lcom/yy/hiidostatis/track/DataTrack;");
                return;
            }
        }
        DataTrack dataTrack = new DataTrack(Transition.MATCH_INSTANCE_STR, 0);
        instance = dataTrack;
        $VALUES = new DataTrack[]{dataTrack};
    }

    public DataTrack(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDataTrackListener = null;
        this.mIsTrack = false;
        this.mIsEnable = false;
        this.mUid = -1L;
        this.reportTime = 0L;
    }

    private boolean isReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.mIsEnable && this.mIsTrack : invokeV.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reportFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, str2, str3, str4, num, str5, str6, str7}) == null) {
            synchronized (this) {
                try {
                } finally {
                }
                if (isReport()) {
                    if (this.mStatisOption.getAppkey().equals(str)) {
                        sendLogFail(str, str2, str3, str4, num, str5, str6, str7);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reportTotal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                try {
                    String appkey = this.mStatisOption.getAppkey();
                    int cacheSize = ((TaskManagerNew) GeneralProxy.getGeneralStatisInstance(this.mContext, HdStatisConfig.getConfig(appkey)).getTaskManager()).cacheSize(this.mContext);
                    int[] total = ActLog.getTotal(this.mContext, appkey);
                    sendLogTotal(Integer.valueOf(cacheSize), Integer.valueOf(total[0]), Integer.valueOf(total[1]), Integer.valueOf(total[2]), Integer.valueOf(total[3]), Integer.valueOf(total[4]));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void reportTotalForce() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && isReport()) {
            ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.track.DataTrack.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DataTrack this$0;

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
                        this.this$0.reportTotal();
                    }
                }
            });
        }
    }

    private void reportTotalInterval() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.reportTime == 0 || System.currentTimeMillis() - this.reportTime >= 600000) {
                this.reportTime = System.currentTimeMillis();
                reportTotalForce();
            }
        }
    }

    private void sendLogFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{str, str2, str3, str4, num, str5, str6, str7}) == null) {
            try {
                StatisContent statisContent = new StatisContent();
                statisContent.put("fguid", str2);
                statisContent.put("smk", str3);
                statisContent.put("fact", str4);
                statisContent.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, num.intValue());
                statisContent.put("host", str5);
                statisContent.put("fcode", str6);
                statisContent.put("fmsg", str7);
                statisContent.put("uid", HiidoSDK.instance().getOnStatisListener().getCurrentUid());
                this.mStatisAPI.reportStatisticContent("zhlogfail", statisContent, true, false, false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void sendLogTotal(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{num, num2, num3, num4, num5, num6}) == null) {
            try {
                StatisContent statisContent = new StatisContent();
                if (num != null) {
                    statisContent.put("buf", num.intValue());
                }
                statisContent.put("cur", num2.intValue());
                statisContent.put("fait", num3.intValue());
                statisContent.put("suc", num4.intValue());
                statisContent.put("del", num5.intValue());
                statisContent.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, num6.intValue());
                statisContent.put("uid", HiidoSDK.instance().getOnStatisListener().getCurrentUid());
                this.mStatisAPI.reportStatisticContent("zhlogtotal", statisContent, true, false, false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trigger(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            synchronized (this) {
                long currentUid = HiidoSDK.instance().getOnStatisListener().getCurrentUid();
                if (this.mUid == -1 || this.mUid != currentUid) {
                    JSONObject config = this.mDataTrackListener.getConfig(this.mStatisOption.getAppkey(), currentUid, DeviceProxy.getHdid(this.mContext));
                    L.brief("json = %s", config);
                    this.mIsTrack = config != null && 1 == config.getJSONObject("tzConfig").getInt("open");
                    this.mUid = currentUid;
                    L.brief("mUid = %d", Long.valueOf(this.mUid));
                    L.brief("mIsTrack = %b", Boolean.valueOf(this.mIsTrack));
                }
                if (!this.mIsTrack) {
                    ActLog.setActLogListener(null);
                    this.mStatisAPI = null;
                    return;
                }
                if (this.mStatisAPI == null) {
                    ActLog.setActLogListener(new ActLog.ActLogListener(this) { // from class: com.yy.hiidostatis.track.DataTrack.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DataTrack this$0;

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

                        @Override // com.yy.hiidostatis.inner.util.log.ActLog.ActLogListener
                        public void sendFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, num, str5, str6, str7}) == null) {
                                this.this$0.reportFail(str, str2, str3, str4, num, str5, str6, str7);
                            }
                        }
                    });
                    this.mStatisAPI = HiidoSDK.instance().createNewStatisApi();
                    StatisOption statisOption = new StatisOption();
                    statisOption.setAppkey("TZ-" + this.mStatisOption.getAppkey());
                    statisOption.setAppId(this.mStatisOption.getAppId());
                    statisOption.setFrom(this.mStatisOption.getFrom());
                    statisOption.setVer(this.mStatisOption.getVer());
                    this.mStatisAPI.init(this.mContext, statisOption);
                }
                if (z) {
                    reportTotalForce();
                } else {
                    reportTotalInterval();
                }
            }
        }
    }

    public static DataTrack valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? (DataTrack) Enum.valueOf(DataTrack.class, str) : (DataTrack) invokeL.objValue;
    }

    public static DataTrack[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? (DataTrack[]) $VALUES.clone() : (DataTrack[]) invokeV.objValue;
    }

    public void init(Context context, StatisOption statisOption, IDataTrackListener iDataTrackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, statisOption, iDataTrackListener) == null) {
            this.mDataTrackListener = iDataTrackListener;
            this.mContext = context;
            this.mStatisOption = statisOption;
            String metaDataParam = ArdUtil.getMetaDataParam(context, "HIIDO_DATATRACK_ENABLE");
            L.brief("mIsEnable = %s", metaDataParam);
            this.mIsEnable = Boolean.parseBoolean(metaDataParam);
            L.brief("mIsEnable = %b", Boolean.valueOf(this.mIsEnable));
        }
    }

    public void triggerTrack(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.mIsEnable) {
            ThreadPool.getPool().execute(new Runnable(this, z) { // from class: com.yy.hiidostatis.track.DataTrack.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DataTrack this$0;
                public final /* synthetic */ boolean val$isForce;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.val$isForce = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.trigger(this.val$isForce);
                    }
                }
            });
        }
    }
}
