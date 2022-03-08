package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class TaskDataSqLiteCacheManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CACHE_DAY;
    public static final int MAX_CACHE_SIZE = 100;
    public static final int MAX_RETRY_TIMES;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, AtomicInteger> actRemain;
    public boolean isFirstSyncFromFile;
    public ReentrantLock lock;
    public String mCacheFileName;
    public Context mCtx;
    public TaskDataSqLiteDBManager mDbManager;
    public int mLastFileSize;
    public TaskDataSet memoryCacheDataSet;
    public MessageMonitor monitor;
    public List<String> sendingData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2112306108, "Lcom/yy/hiidostatis/inner/implementation/TaskDataSqLiteCacheManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2112306108, "Lcom/yy/hiidostatis/inner/implementation/TaskDataSqLiteCacheManager;");
                return;
            }
        }
        MAX_RETRY_TIMES = AbstractConfig.MAX_DATA_RETRY_TIME;
        MAX_CACHE_DAY = AbstractConfig.MAX_DATA_CACHE_DAY;
    }

    public TaskDataSqLiteCacheManager(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.memoryCacheDataSet = new TaskDataSet();
        this.lock = new ReentrantLock();
        this.mLastFileSize = -1;
        this.isFirstSyncFromFile = true;
        this.sendingData = new ArrayList();
        this.mCtx = context;
        this.mCacheFileName = str;
    }

    private int addRemain(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, str, i2)) == null) {
            AtomicInteger atomicInteger = this.actRemain.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.actRemain.put(str, atomicInteger);
            }
            return atomicInteger.addAndGet(i2);
        }
        return invokeLI.intValue;
    }

    private TaskDataSqLiteDBManager getDbManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return (TaskDataSqLiteDBManager) invokeV.objValue;
    }

    private boolean isOverMaxTryTimes(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, taskData)) == null) ? taskData.getTryTimes() >= MAX_RETRY_TIMES : invokeL.booleanValue;
    }

    private boolean isOverdue(TaskData taskData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, taskData)) == null) {
            try {
                return Util.daysBetween(taskData.getTime(), System.currentTimeMillis()) > MAX_CACHE_DAY;
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private int reduceRemain(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, str, i2)) == null) {
            AtomicInteger atomicInteger = this.actRemain.get(str);
            if (atomicInteger != null) {
                return atomicInteger.addAndGet(i2 * (-1));
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    private void syncFromFile(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65544, this, context) != null) {
            return;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, taskData) == null) {
            this.lock.lock();
            try {
                if (this.memoryCacheDataSet.size() < 100) {
                    this.memoryCacheDataSet.save(taskData);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public int cacheData(Context context, List<TaskData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list)) == null) {
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
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, NEW_ARRAY, APUT, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    public List<TaskData> getAndMoveToSendingList(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2)) == null) {
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
        return (List) invokeLI.objValue;
    }

    public TaskData getFirst(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
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
        return (TaskData) invokeL.objValue;
    }

    public void remove(Context context, TaskData taskData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, taskData) == null) {
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
    }

    public void removeSendListBatch(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, list) == null) {
            this.lock.lock();
            try {
                this.sendingData.removeAll(list);
                getDbManager().remove(list);
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void restoreSendList(Context context, List<String[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, list) == null) {
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
    }

    public boolean save(Context context, TaskData taskData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, taskData)) == null) {
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
        return invokeLL.booleanValue;
    }

    public int saveAll(Context context, Collection<TaskData> collection, Map<String, Integer> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, collection, map)) == null) {
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
        return invokeLLL.intValue;
    }

    public int size(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
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
        return invokeL.intValue;
    }

    public boolean update(Context context, TaskData taskData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, taskData)) == null) {
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
        return invokeLL.booleanValue;
    }

    public TaskDataSqLiteCacheManager(Context context, String str, MessageMonitor messageMonitor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, messageMonitor};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.memoryCacheDataSet = new TaskDataSet();
        this.lock = new ReentrantLock();
        this.mLastFileSize = -1;
        this.isFirstSyncFromFile = true;
        this.sendingData = new ArrayList();
        this.mCtx = context;
        this.mCacheFileName = str;
        this.monitor = messageMonitor;
    }
}
