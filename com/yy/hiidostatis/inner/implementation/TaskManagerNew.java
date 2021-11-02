package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.implementation.ITaskExecutor;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.http.CacheIp;
import com.yy.hiidostatis.inner.util.http.IStatisHttpUtil;
import com.yy.hiidostatis.inner.util.http.StatisHttpEncryptUtil;
import com.yy.hiidostatis.inner.util.http.StatisHttpUtil;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class TaskManagerNew implements ITaskManager {
    public static /* synthetic */ Interceptable $ic;
    public static final int MAX_CACHE_DAY;
    public static final int MAX_RETRY_TIMES;
    public transient /* synthetic */ FieldHolder $fh;
    public final long BATCH_STORE_INTERVAL_TIME;
    public final int BATCH_STORE_SIZE;
    public final long BATCH_STORE_WAITING_TIME;
    public TaskDataSqLiteCacheManager cacheManager;
    public volatile FailSendControler failSendControler;
    public volatile boolean isEnableSend;
    public CacheIp mCacheIp;
    public CacheIp mCacheIpTemporary;
    public volatile AbstractConfig mConfig;
    public final TaskExecutor mExecutor;
    public IStatisHttpUtil mHttpUtil;
    public volatile boolean mIsStoreWorking;
    public volatile boolean mIsWorking;
    public String mLastSucDataId;
    public Vector<TaskData> mPreStoreVectors;
    public final TaskExecutor mSaveExecutor;
    public AtomicInteger sendFailedCount;

    /* loaded from: classes2.dex */
    public static class FailSendControler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long SEND_FAIL_SLEEP_TIMES = 10000;
        public transient /* synthetic */ FieldHolder $fh;
        public int failContinuous;
        public long lastFailTime;
        public final long sleepTime;

        public FailSendControler(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lastFailTime = 0L;
            this.failContinuous = 0;
            this.sleepTime = j <= 0 ? 10000L : j;
        }

        public int getFailContinuous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.failContinuous : invokeV.intValue;
        }

        public long getSleepTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sleepTime : invokeV.longValue;
        }

        public void increase() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.lastFailTime = System.currentTimeMillis();
                this.failContinuous++;
            }
        }

        public boolean isOverTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? System.currentTimeMillis() - this.lastFailTime > getSleepTime() : invokeV.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.lastFailTime = 0L;
                this.failContinuous = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-190274510, "Lcom/yy/hiidostatis/inner/implementation/TaskManagerNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-190274510, "Lcom/yy/hiidostatis/inner/implementation/TaskManagerNew;");
                return;
            }
        }
        MAX_RETRY_TIMES = AbstractConfig.MAX_DATA_RETRY_TIME;
        MAX_CACHE_DAY = AbstractConfig.MAX_DATA_CACHE_DAY;
    }

    public TaskManagerNew(Context context, AbstractConfig abstractConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, abstractConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isEnableSend = true;
        this.failSendControler = new FailSendControler(-1L);
        this.mCacheIp = new CacheIp();
        this.mCacheIpTemporary = new CacheIp();
        this.mLastSucDataId = null;
        this.mHttpUtil = null;
        this.sendFailedCount = new AtomicInteger(0);
        this.mPreStoreVectors = new Vector<>();
        this.mIsStoreWorking = false;
        this.BATCH_STORE_SIZE = 100;
        this.BATCH_STORE_WAITING_TIME = 50L;
        this.BATCH_STORE_INTERVAL_TIME = 10000L;
        this.mIsWorking = false;
        this.mConfig = abstractConfig;
        this.cacheManager = new TaskDataSqLiteCacheManager(context, abstractConfig.getCacheFileName());
        this.mSaveExecutor = new TaskExecutor(new ITaskExecutor.OnTaskRejectedListener(this) { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TaskManagerNew this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor.OnTaskRejectedListener
            public void onRejectedTask(ITaskExecutor.ExecutorTask executorTask) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, executorTask) == null) {
                    L.brief("Store rejected task %s", executorTask.getData().getDataId());
                    this.this$0.cacheManager.save(executorTask.getContext(), executorTask.getData());
                }
            }
        }, "Statis_SDK_Save_Worker");
        this.mExecutor = new TaskExecutor(null, "Statis_SDK_Send_Worker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSendTask(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.mIsWorking) {
            return;
        }
        this.mIsWorking = true;
        try {
            this.mExecutor.submit(new ITaskExecutor.ExecutorTask(this, context, null, context, z) { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskManagerNew this$0;
                public final /* synthetic */ Context val$c;
                public final /* synthetic */ boolean val$isSendFront;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, r10, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (TaskData) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$c = context;
                    this.val$isSendFront = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i3 = 0;
                        do {
                            try {
                                i3 = this.this$0.sendNext(this.val$c, this.val$isSendFront, i3);
                            } catch (Throwable th) {
                                try {
                                    L.debug(this, "exception:%s", th);
                                    return;
                                } finally {
                                    this.this$0.mIsWorking = false;
                                    this.this$0.createSendTask(this.val$c, true, 15000);
                                }
                            }
                        } while (i3 == 0);
                        this.this$0.mIsWorking = false;
                        if (i3 > 0) {
                            this.this$0.createSendTask(this.val$c, true, i3);
                        }
                    }
                }
            }, i2);
        } catch (Throwable th) {
            this.mIsWorking = false;
            L.debug(this, "noticeSend:RejectedExecutionException=%s,do nothing.", th);
        }
    }

    private boolean doSend(Context context, TaskData taskData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, taskData)) == null) {
            if (taskData.getDataId() != null && taskData.getDataId().equals(this.mLastSucDataId)) {
                L.warn(this, "data send more than 1 times continuously. dataId=%s", this.mLastSucDataId);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                    L.debug(this, e2.getMessage(), new Object[0]);
                }
                return true;
            }
            taskData.getTryTimes();
            long currentTimeMillis = System.currentTimeMillis();
            IStatisHttpUtil httpUtilCache = getHttpUtilCache();
            httpUtilCache.setLastTryTimes(taskData.getTryTimes());
            String content = taskData.getContent();
            try {
                content = String.format("%s&hd_stime=%d", content, Long.valueOf(Util.wallTimeMillis()));
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
            boolean sendSync = httpUtilCache.sendSync(content);
            int lastTryTimes = httpUtilCache.getLastTryTimes();
            L.debug(this, "Return value: %B to send command %s. ", Boolean.valueOf(sendSync), content);
            if (Math.random() < 0.001d) {
                HiidoSDK.instance().reportReturnCode(50000, httpUtilCache.getHost(), System.currentTimeMillis() - currentTimeMillis, String.valueOf(httpUtilCache.getLastStatusCode()));
            }
            if (!sendSync) {
                HiidoSDK.instance().reportCount("SDK_METRICS", 50000, httpUtilCache.getHost(), HiidoSDK.SDK_FAILED_COUNTER_NAME, 1L);
                if (httpUtilCache.getLastStatusCode() != 414 && httpUtilCache.getLastStatusCode() != 400) {
                    taskData.setTryTimes(lastTryTimes);
                    L.debug(this, "data:%s ; all tryTimes:%d ; createTime:%d", taskData.getDataId(), Integer.valueOf(taskData.getTryTimes()), Long.valueOf(taskData.getTime()));
                    this.failSendControler.increase();
                } else {
                    removeInvalid(context, taskData);
                    this.failSendControler.reset();
                    L.warn(this, "httpUtil.getLastStatusCode()=%d,removeInvalid:%s", Integer.valueOf(httpUtilCache.getLastStatusCode()), taskData.getContent());
                    return true;
                }
            } else {
                HiidoSDK.instance().reportCount("SDK_METRICS", 50000, httpUtilCache.getHost(), HiidoSDK.SDK_SUCCESS_COUNTER_NAME, 1L);
                HiidoSDK.instance().reportCount("SDK_METRICS", 50000, httpUtilCache.getHost(), HiidoSDK.SDK_DURATION_COUNTER_NAME, System.currentTimeMillis() - currentTimeMillis);
                this.failSendControler.reset();
                this.mLastSucDataId = taskData.getDataId();
            }
            return sendSync;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IStatisHttpUtil getHttpUtil() {
        InterceptResult invokeV;
        IStatisHttpUtil statisHttpUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (isEncrypt()) {
                statisHttpUtil = new StatisHttpEncryptUtil();
            } else {
                statisHttpUtil = new StatisHttpUtil();
            }
            statisHttpUtil.setTestServer(this.mConfig.getTestServer());
            statisHttpUtil.setCacheIp(this.mCacheIp);
            return statisHttpUtil;
        }
        return (IStatisHttpUtil) invokeV.objValue;
    }

    private IStatisHttpUtil getHttpUtilCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            IStatisHttpUtil iStatisHttpUtil = this.mHttpUtil;
            if (iStatisHttpUtil != null) {
                return iStatisHttpUtil;
            }
            IStatisHttpUtil httpUtil = getHttpUtil();
            this.mHttpUtil = httpUtil;
            return httpUtil;
        }
        return (IStatisHttpUtil) invokeV.objValue;
    }

    private boolean isAbroad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.mConfig.isAbroad() : invokeV.booleanValue;
    }

    private boolean isEncrypt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            boolean isEncryptTestServer = this.mConfig.isEncryptTestServer();
            String testServer = this.mConfig.getTestServer();
            L.brief("isEncrypt[%b],isEncryptTestServer[%b],testServer[%s]", Boolean.valueOf(this.mConfig.isEncrypt()), Boolean.valueOf(isEncryptTestServer), testServer);
            if (this.mConfig.isEncrypt()) {
                return isEncryptTestServer || Util.empty(testServer);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isOverMaxTryTimes(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, taskData)) == null) ? taskData.getTryTimes() >= MAX_RETRY_TIMES : invokeL.booleanValue;
    }

    private boolean isOverdue(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, taskData)) == null) {
            try {
                return Util.daysBetween(taskData.getTime(), System.currentTimeMillis()) > MAX_CACHE_DAY;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void removeInvalid(Context context, TaskData taskData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, context, taskData) == null) {
            this.cacheManager.remove(context, taskData);
            ActLog.writeActLog(context, ActLog.TYPE_DISCARD, taskData.getContent(), null, null, null);
            ActLog.writeSendFailLog(context, null, null, taskData.getContent(), "remove Invalid", "-1", Integer.valueOf(taskData.getTryTimes()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sendNext(Context context, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (!this.isEnableSend) {
                L.brief("isEnableSend:false,end send.", new Object[0]);
                return -1;
            } else if (i2 != 0 && !ArdUtil.isNetworkAvailable(context)) {
                L.brief("isNetworkAvailable:false,end send.", new Object[0]);
                return 2000;
            } else {
                L.brief("isSendFront:%b", Boolean.valueOf(z));
                TaskData first = this.cacheManager.getFirst(context);
                if (first == null) {
                    L.brief("data is null,end send. ", new Object[0]);
                    return -1;
                } else if (!isOverdue(first) && !isOverMaxTryTimes(first)) {
                    if (doSend(context, first)) {
                        this.cacheManager.remove(context, first);
                        this.sendFailedCount.set(0);
                        return 0;
                    }
                    if (isOverMaxTryTimes(first)) {
                        removeInvalid(context, first);
                    } else {
                        this.cacheManager.update(context, first);
                    }
                    int incrementAndGet = this.sendFailedCount.incrementAndGet();
                    if (incrementAndGet > 10) {
                        this.sendFailedCount.compareAndSet(incrementAndGet, 10);
                    }
                    return Math.min(10000, incrementAndGet * incrementAndGet * 100);
                } else {
                    L.warn(this, "data:%s .overdue or over MaxTryTimes. give up the data. max cache day = [%d].MaxTryTimes = [%d] .dataTryTimes = [%d]", first.getDataId(), Integer.valueOf(MAX_CACHE_DAY), Integer.valueOf(MAX_RETRY_TIMES), Integer.valueOf(first.getTryTimes()));
                    removeInvalid(context, first);
                    return 0;
                }
            }
        }
        return invokeCommon.intValue;
    }

    public int cacheSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? this.cacheManager.size(context) : invokeL.intValue;
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void enableSend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.isEnableSend = z;
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void flush(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.failSendControler.reset();
            createSendTask(context, true, 0);
        }
    }

    public TaskExecutor getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mExecutor : (TaskExecutor) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public boolean send(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, str2)) == null) {
            ActLog.writeActLog(context, ActLog.TYPE_ADD, str2, null, null, null);
            TaskData taskData = new TaskData(str);
            taskData.setContent(str2);
            taskData.setDataId(taskData.createDataId());
            taskData.setVerifyMd5(taskData.createVerifyMd5());
            boolean save = this.cacheManager.save(context, taskData);
            createSendTask(context, true, 0);
            return save;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void sendTemporary(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            ThreadPool.getPool().execute(new Runnable(this, str) { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskManagerNew this$0;
                public final /* synthetic */ String val$content;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$content = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            IStatisHttpUtil httpUtil = this.this$0.getHttpUtil();
                            httpUtil.setLastTryTimes(0);
                            httpUtil.setRetryTimeHost(0);
                            httpUtil.setTryTimeIp(1);
                            httpUtil.setCacheIp(this.this$0.mCacheIpTemporary);
                            L.debug(this, "sendTemporary:lastTryTimes:%d . Return value: %B to send command %s. ", Integer.valueOf(httpUtil.getLastTryTimes()), Boolean.valueOf(httpUtil.sendSync(this.val$content)), this.val$content);
                        } catch (Throwable th) {
                            L.debug(this, "sendTemporary error = %s", th);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public boolean send(Context context, String str, String str2, Long l) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, context, str, str2, l)) == null) {
            ActLog.writeActLog(context, ActLog.TYPE_ADD, str2, null, null, null);
            TaskData taskData = new TaskData(str);
            taskData.setContent(str2);
            taskData.setDataId(taskData.createDataId());
            taskData.setVerifyMd5(taskData.createVerifyMd5());
            if (l != null) {
                taskData.setOrder(l.longValue());
            }
            boolean save = this.cacheManager.save(context, taskData);
            createSendTask(context, true, 0);
            return save;
        }
        return invokeLLLL.booleanValue;
    }
}
