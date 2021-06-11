package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import com.yy.hiidostatis.inner.AbstractConfig;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.log.TraceLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class TaskDataSqLiteCacheManager {
    public static final int MAX_CACHE_SIZE = 100;
    public ConcurrentHashMap<String, AtomicInteger> actRemain;
    public String mCacheFileName;
    public Context mCtx;
    public TaskDataSqLiteDBManager mDbManager;
    public MessageMonitor monitor;
    public static final int MAX_RETRY_TIMES = AbstractConfig.MAX_DATA_RETRY_TIME;
    public static final int MAX_CACHE_DAY = AbstractConfig.MAX_DATA_CACHE_DAY;
    public TaskDataSet memoryCacheDataSet = new TaskDataSet();
    public ReentrantLock lock = new ReentrantLock();
    public int mLastFileSize = -1;
    public boolean isFirstSyncFromFile = true;
    public List<String> sendingData = new ArrayList();

    public TaskDataSqLiteCacheManager(Context context, String str) {
        this.mCtx = context;
        this.mCacheFileName = str;
    }

    private int addRemain(String str, int i2) {
        AtomicInteger atomicInteger = this.actRemain.get(str);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger();
            this.actRemain.put(str, atomicInteger);
        }
        return atomicInteger.addAndGet(i2);
    }

    private TaskDataSqLiteDBManager getDbManager() {
        TaskDataSqLiteDBManager taskDataSqLiteDBManager = this.mDbManager;
        if (taskDataSqLiteDBManager != null) {
            return taskDataSqLiteDBManager;
        }
        synchronized (this) {
            if (this.mDbManager != null) {
                return this.mDbManager;
            }
            String format = String.format("%s.db", ProcessUtil.getFileNameBindProcess(this.mCtx, this.mCacheFileName));
            L.brief("dbName = %s", format);
            TaskDataSqLiteDBManager taskDataSqLiteDBManager2 = new TaskDataSqLiteDBManager(this.mCtx, format);
            this.mDbManager = taskDataSqLiteDBManager2;
            this.actRemain = taskDataSqLiteDBManager2.countActRemain();
            return this.mDbManager;
        }
    }

    private boolean isOverMaxTryTimes(TaskData taskData) {
        return taskData.getTryTimes() >= MAX_RETRY_TIMES;
    }

    private boolean isOverdue(TaskData taskData) {
        try {
            return Util.daysBetween(taskData.getTime(), System.currentTimeMillis()) > MAX_CACHE_DAY;
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            return false;
        }
    }

    private int reduceRemain(String str, int i2) {
        AtomicInteger atomicInteger = this.actRemain.get(str);
        if (atomicInteger != null) {
            return atomicInteger.addAndGet(i2 * (-1));
        }
        return 0;
    }

    private void syncFromFile(Context context) {
        this.mLastFileSize = getDbManager().size();
        int i2 = this.isFirstSyncFromFile ? 50 : 100;
        this.isFirstSyncFromFile = false;
        TaskDataSet firstList = getDbManager().getFirstList(i2, this.sendingData);
        if (firstList != null) {
            TaskDataSet taskDataSet = new TaskDataSet();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                TaskData removeFirst = firstList.removeFirst();
                if (removeFirst != null) {
                    if (removeFirst.verifyMd5()) {
                        this.memoryCacheDataSet.save(removeFirst);
                        i3++;
                    } else {
                        taskDataSet.save(removeFirst);
                        i4++;
                        L.debug(this, "data verify failure ,give up .data=[%s]", removeFirst.getContent());
                        ActLog.writeSendFailLog(context, "-", null, removeFirst.getContent(), "drop one data.verifyMd5 Failure", "-1", null);
                        ActLog.writeActLog(null, ActLog.TYPE_DISCARD, removeFirst.getContent(), null, null, null);
                    }
                } else {
                    getDbManager().removeAll(taskDataSet);
                    L.debug(this, "syncFromFile. succ dataset size = [%d],fail dataset size = [%d], file dataset size = [%d]", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.mLastFileSize));
                    return;
                }
            }
        } else {
            L.debug(this, "syncFromFile dataset size = 0", new Object[0]);
        }
    }

    public void add(Context context, TaskData taskData) {
        this.lock.lock();
        try {
            if (this.memoryCacheDataSet.size() < 100) {
                this.memoryCacheDataSet.save(taskData);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public int cacheData(Context context, List<TaskData> list) {
        this.lock.lock();
        try {
            this.memoryCacheDataSet.addAll(list);
            if (this.memoryCacheDataSet.size() > 100) {
                while (this.memoryCacheDataSet.size() > 100) {
                    this.memoryCacheDataSet.removeLast();
                }
            }
            return this.memoryCacheDataSet.size();
        } finally {
            this.lock.unlock();
        }
    }

    public List<TaskData> getAndMoveToSendingList(Context context, int i2) {
        this.lock.lock();
        ArrayList arrayList = new ArrayList();
        try {
            getDbManager();
            if (this.memoryCacheDataSet.isEmpty()) {
                syncFromFile(context);
            }
            if (!this.memoryCacheDataSet.isEmpty()) {
                int size = this.memoryCacheDataSet.size();
                HashMap hashMap = new HashMap();
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    TaskData removeFirst = this.memoryCacheDataSet.removeFirst();
                    if (removeFirst == null) {
                        syncFromFile(context);
                        if (this.memoryCacheDataSet.isEmpty()) {
                            break;
                        }
                    }
                    if (!isOverdue(removeFirst) && !isOverMaxTryTimes(removeFirst)) {
                        i4 += removeFirst.getContent().length();
                        removeFirst.setRemain(reduceRemain(removeFirst.getAct(), 1));
                        Integer num = (Integer) hashMap.get(removeFirst.getAct());
                        if (num == null) {
                            num = Integer.valueOf(this.monitor.getPackId(removeFirst.getAct()));
                            hashMap.put(removeFirst.getAct(), num);
                        }
                        removeFirst.setPackId(num.intValue());
                        arrayList.add(removeFirst);
                        this.sendingData.add(removeFirst.getDataId());
                        if (i4 > i2) {
                            break;
                        }
                        i3++;
                    }
                    getDbManager().remove(removeFirst);
                    TraceLog.dropMessageLog(removeFirst.getAct(), removeFirst.getDataId());
                    i3--;
                    i3++;
                }
            }
            L.verbose(this, "getFirst from  memory cache. memory cache dataset size = %d. mLastFileSize = %d", Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    public TaskData getFirst(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            if (this.memoryCacheDataSet.isEmpty()) {
                syncFromFile(context);
            }
            r5 = this.memoryCacheDataSet.isEmpty() ? null : this.memoryCacheDataSet.getFirst();
            L.verbose(this, "getFirst from  memory cache. memory cache dataset size = %d. mLastFileSize = %d", Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
            this.lock.unlock();
            L.brief("getFirst elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            try {
                L.error(this, "Failed to getFirst data .Exception:%s", th);
                this.lock.unlock();
                L.brief("getFirst elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("getFirst elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
        return r5;
    }

    public void remove(Context context, TaskData taskData) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            if (!this.memoryCacheDataSet.isEmpty()) {
                L.verbose(this, "remove from  memory cache [%b].", Boolean.valueOf(this.memoryCacheDataSet.remove(taskData)));
            }
            getDbManager().remove(taskData);
            L.verbose(this, "remove data : %s from file . memory cache dataset size = %d. mLastFileSize = %d ", taskData.getDataId(), Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
            this.lock.unlock();
            L.brief("remove elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            try {
                L.debug(this, "Failed to remove data .Exception:%s", th);
                this.lock.unlock();
                L.brief("remove elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("remove elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
    }

    public void removeSendListBatch(Context context, List<String> list) {
        this.lock.lock();
        try {
            this.sendingData.removeAll(list);
            getDbManager().remove(list);
        } finally {
            this.lock.unlock();
        }
    }

    public void restoreSendList(Context context, List<String[]> list) {
        this.lock.lock();
        try {
            for (String[] strArr : list) {
                this.sendingData.remove(strArr[1]);
                addRemain(strArr[0], 1);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean save(Context context, TaskData taskData) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            getDbManager().save(taskData);
            this.memoryCacheDataSet.add(taskData);
            if (this.memoryCacheDataSet.size() > 100) {
                this.memoryCacheDataSet.removeLast();
            }
            addRemain(taskData.getAct(), 1);
            L.verbose(this, "save data : %s to file . memory cache dataset size = %d. mLastFileSize = %d", taskData.getDataId(), Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
            this.lock.unlock();
            L.brief("save elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return true;
        } catch (Throwable th) {
            try {
                L.debug(this, "Failed to save data : %s Exception:%s", taskData.getDataId(), th);
                this.lock.unlock();
                L.brief("save elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return false;
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("save elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
    }

    public int saveAll(Context context, Collection<TaskData> collection, Map<String, Integer> map) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            try {
                getDbManager().saveAll(collection);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                addRemain(entry.getKey(), entry.getValue().intValue());
            }
            this.memoryCacheDataSet.addAll(collection);
            if (this.memoryCacheDataSet.size() > 100) {
                while (this.memoryCacheDataSet.size() > 100) {
                    this.memoryCacheDataSet.removeLast();
                }
            }
            L.verbose(this, "saveAll data : dataSize [%d] to file . memory cache dataset size = %d. mLastFileSize = %d", Integer.valueOf(collection.size()), Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
            int size = this.memoryCacheDataSet.size();
            this.lock.unlock();
            L.brief("saveAll elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return size;
        } catch (Throwable th) {
            try {
                L.debug(this, "Failed to saveAll data : dataSize [%d] Exception:%s", Integer.valueOf(collection.size()), th);
                int size2 = this.memoryCacheDataSet.size();
                this.lock.unlock();
                L.brief("saveAll elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return size2;
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("saveAll elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
    }

    public int size(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            int size = getDbManager().size();
            this.lock.unlock();
            L.brief("get size elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return size;
        } catch (Throwable th) {
            try {
                L.debug(this, "Failed to get size .Exception:%s", th);
                this.lock.unlock();
                L.brief("get size elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return 0;
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("get size elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
    }

    public boolean update(Context context, TaskData taskData) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            getDbManager().update(taskData);
            L.verbose(this, "update data : %s to file . memory cache dataset size = %d. mLastFileSize = %d", taskData.getDataId(), Integer.valueOf(this.memoryCacheDataSet.size()), Integer.valueOf(this.mLastFileSize));
            this.lock.unlock();
            L.brief("update elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return true;
        } catch (Throwable th) {
            try {
                L.debug(this, "Failed to update data : %s Exception:%s", taskData.getDataId(), th);
                this.lock.unlock();
                L.brief("update elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return false;
            } catch (Throwable th2) {
                this.lock.unlock();
                L.brief("update elapsed time :%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                throw th2;
            }
        }
    }

    public TaskDataSqLiteCacheManager(Context context, String str, MessageMonitor messageMonitor) {
        this.mCtx = context;
        this.mCacheFileName = str;
        this.monitor = messageMonitor;
    }
}
