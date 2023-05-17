package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
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
/* loaded from: classes10.dex */
public class TaskManagerNew implements ITaskManager {
    public TaskDataSqLiteCacheManager cacheManager;
    public volatile AbstractConfig mConfig;
    public static final int MAX_RETRY_TIMES = AbstractConfig.MAX_DATA_RETRY_TIME;
    public static final int MAX_CACHE_DAY = AbstractConfig.MAX_DATA_CACHE_DAY;
    public volatile boolean isEnableSend = true;
    public volatile FailSendControler failSendControler = new FailSendControler(-1);
    public CacheIp mCacheIp = new CacheIp();
    public CacheIp mCacheIpTemporary = new CacheIp();
    public String mLastSucDataId = null;
    public IStatisHttpUtil mHttpUtil = null;
    public AtomicInteger sendFailedCount = new AtomicInteger(0);
    public Vector<TaskData> mPreStoreVectors = new Vector<>();
    public volatile boolean mIsStoreWorking = false;
    public final int BATCH_STORE_SIZE = 100;
    public final long BATCH_STORE_WAITING_TIME = 50;
    public final long BATCH_STORE_INTERVAL_TIME = 10000;
    public volatile boolean mIsWorking = false;
    public final TaskExecutor mSaveExecutor = new TaskExecutor(new ITaskExecutor.OnTaskRejectedListener() { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.1
        @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor.OnTaskRejectedListener
        public void onRejectedTask(ITaskExecutor.ExecutorTask executorTask) {
            L.brief("Store rejected task %s", executorTask.getData().getDataId());
            TaskManagerNew.this.cacheManager.save(executorTask.getContext(), executorTask.getData());
        }
    }, "Statis_SDK_Save_Worker");
    public final TaskExecutor mExecutor = new TaskExecutor(null, "Statis_SDK_Send_Worker");

    /* loaded from: classes10.dex */
    public static class FailSendControler {
        public static final long SEND_FAIL_SLEEP_TIMES = 10000;
        public final long sleepTime;
        public long lastFailTime = 0;
        public int failContinuous = 0;

        public FailSendControler(long j) {
            this.sleepTime = j <= 0 ? 10000L : j;
        }

        public int getFailContinuous() {
            return this.failContinuous;
        }

        public long getSleepTime() {
            return this.sleepTime;
        }

        public void increase() {
            this.lastFailTime = System.currentTimeMillis();
            this.failContinuous++;
        }

        public boolean isOverTime() {
            if (System.currentTimeMillis() - this.lastFailTime > getSleepTime()) {
                return true;
            }
            return false;
        }

        public void reset() {
            this.lastFailTime = 0L;
            this.failContinuous = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IStatisHttpUtil getHttpUtil() {
        IStatisHttpUtil statisHttpUtil;
        if (isEncrypt()) {
            statisHttpUtil = new StatisHttpEncryptUtil();
        } else {
            statisHttpUtil = new StatisHttpUtil();
        }
        statisHttpUtil.setTestServer(this.mConfig.getTestServer());
        statisHttpUtil.setCacheIp(this.mCacheIp);
        return statisHttpUtil;
    }

    private IStatisHttpUtil getHttpUtilCache() {
        IStatisHttpUtil iStatisHttpUtil = this.mHttpUtil;
        if (iStatisHttpUtil != null) {
            return iStatisHttpUtil;
        }
        IStatisHttpUtil httpUtil = getHttpUtil();
        this.mHttpUtil = httpUtil;
        return httpUtil;
    }

    private boolean isAbroad() {
        return this.mConfig.isAbroad();
    }

    public TaskExecutor getExecutor() {
        return this.mExecutor;
    }

    public TaskManagerNew(Context context, AbstractConfig abstractConfig) {
        this.mConfig = abstractConfig;
        this.cacheManager = new TaskDataSqLiteCacheManager(context, abstractConfig.getCacheFileName());
    }

    private boolean isOverMaxTryTimes(TaskData taskData) {
        if (taskData.getTryTimes() >= MAX_RETRY_TIMES) {
            return true;
        }
        return false;
    }

    private boolean isOverdue(TaskData taskData) {
        try {
            if (Util.daysBetween(taskData.getTime(), System.currentTimeMillis()) <= MAX_CACHE_DAY) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            return false;
        }
    }

    public int cacheSize(Context context) {
        return this.cacheManager.size(context);
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void enableSend(boolean z) {
        this.isEnableSend = z;
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void flush(Context context) {
        this.failSendControler.reset();
        createSendTask(context, true, 0);
    }

    private void removeInvalid(Context context, TaskData taskData) {
        this.cacheManager.remove(context, taskData);
        ActLog.writeActLog(context, ActLog.TYPE_DISCARD, taskData.getContent(), null, null, null);
        ActLog.writeSendFailLog(context, null, null, taskData.getContent(), "remove Invalid", "-1", Integer.valueOf(taskData.getTryTimes()));
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public void sendTemporary(Context context, final String str) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IStatisHttpUtil httpUtil = TaskManagerNew.this.getHttpUtil();
                    httpUtil.setLastTryTimes(0);
                    httpUtil.setRetryTimeHost(0);
                    httpUtil.setTryTimeIp(1);
                    httpUtil.setCacheIp(TaskManagerNew.this.mCacheIpTemporary);
                    L.debug(this, "sendTemporary:lastTryTimes:%d . Return value: %B to send command %s. ", Integer.valueOf(httpUtil.getLastTryTimes()), Boolean.valueOf(httpUtil.sendSync(str)), str);
                } catch (Throwable th) {
                    L.debug(this, "sendTemporary error = %s", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSendTask(final Context context, final boolean z, int i) {
        if (this.mIsWorking) {
            return;
        }
        this.mIsWorking = true;
        try {
            this.mExecutor.submit(new ITaskExecutor.ExecutorTask(context, null) { // from class: com.yy.hiidostatis.inner.implementation.TaskManagerNew.2
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    do {
                        try {
                            i2 = TaskManagerNew.this.sendNext(context, z, i2);
                        } catch (Throwable th) {
                            try {
                                L.debug(this, "exception:%s", th);
                                return;
                            } finally {
                                TaskManagerNew.this.mIsWorking = false;
                                TaskManagerNew.this.createSendTask(context, true, 15000);
                            }
                        }
                    } while (i2 == 0);
                    TaskManagerNew.this.mIsWorking = false;
                    if (i2 <= 0) {
                        return;
                    }
                    TaskManagerNew.this.createSendTask(context, true, i2);
                }
            }, i);
        } catch (Throwable th) {
            this.mIsWorking = false;
            L.debug(this, "noticeSend:RejectedExecutionException=%s,do nothing.", th);
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public boolean send(Context context, String str, String str2) {
        ActLog.writeActLog(context, ActLog.TYPE_ADD, str2, null, null, null);
        TaskData taskData = new TaskData(str);
        taskData.setContent(str2);
        taskData.setDataId(taskData.createDataId());
        taskData.setVerifyMd5(taskData.createVerifyMd5());
        boolean save = this.cacheManager.save(context, taskData);
        createSendTask(context, true, 0);
        return save;
    }

    private boolean doSend(Context context, TaskData taskData) {
        if (taskData.getDataId() != null && taskData.getDataId().equals(this.mLastSucDataId)) {
            L.warn(this, "data send more than 1 times continuously. dataId=%s", this.mLastSucDataId);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                L.debug(this, e.getMessage(), new Object[0]);
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

    private boolean isEncrypt() {
        boolean isEncryptTestServer = this.mConfig.isEncryptTestServer();
        String testServer = this.mConfig.getTestServer();
        L.brief("isEncrypt[%b],isEncryptTestServer[%b],testServer[%s]", Boolean.valueOf(this.mConfig.isEncrypt()), Boolean.valueOf(isEncryptTestServer), testServer);
        if (!this.mConfig.isEncrypt()) {
            return false;
        }
        if (!isEncryptTestServer && !Util.empty(testServer)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sendNext(Context context, boolean z, int i) {
        if (!this.isEnableSend) {
            L.brief("isEnableSend:false,end send.", new Object[0]);
            return -1;
        } else if (i != 0 && !ArdUtil.isNetworkAvailable(context)) {
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

    @Override // com.yy.hiidostatis.inner.implementation.ITaskManager
    public boolean send(Context context, String str, String str2, Long l) {
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
}
