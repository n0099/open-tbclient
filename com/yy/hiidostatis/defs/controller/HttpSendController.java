package com.yy.hiidostatis.defs.controller;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.SendCell;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.http.IStatisHttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class HttpSendController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File cacheDir;
    public int delayStep;
    public IStatisHttpUtil httpUtil;
    public TreeMap<Long, SendCell> waitForSend;
    public int waitQueueCapacity;

    public HttpSendController(IStatisHttpUtil iStatisHttpUtil, File file, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iStatisHttpUtil, file, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.waitForSend = new TreeMap<>();
        this.waitQueueCapacity = 20;
        this.delayStep = 2;
        this.httpUtil = iStatisHttpUtil;
        this.cacheDir = file;
        this.waitQueueCapacity = i2;
        this.delayStep = i3;
        loadSendCellFromFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSendCellFromFile() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpSendController this$0;

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
                            File[] listFiles = this.this$0.cacheDir.listFiles();
                            long currentTimeMillis = System.currentTimeMillis();
                            int size = this.this$0.waitForSend.size();
                            for (File file : listFiles) {
                                if (size >= this.this$0.waitQueueCapacity) {
                                    return;
                                }
                                long parseId = SendCell.parseId(file.getName());
                                if (parseId > 0) {
                                    if (parseId / 10000 > currentTimeMillis) {
                                        this.this$0.putTask(SendCell.loadFromFile(file));
                                        size++;
                                    } else {
                                        file.delete();
                                    }
                                }
                            }
                            if (size > 0) {
                                this.this$0.sendHttp(0L);
                            }
                        } catch (Throwable th) {
                            L.debug(this, th.getMessage(), new Object[0]);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SendCell pollTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            synchronized (this.waitForSend) {
                Map.Entry<Long, SendCell> pollLastEntry = this.waitForSend.pollLastEntry();
                if (pollLastEntry != null) {
                    return pollLastEntry.getValue();
                }
                return null;
            }
        }
        return (SendCell) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putTask(SendCell sendCell) {
        Map.Entry<Long, SendCell> pollFirstEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, sendCell) == null) {
            synchronized (this.waitForSend) {
                this.waitForSend.put(Long.valueOf(sendCell.getId()), sendCell);
                if (this.waitForSend.size() > this.waitQueueCapacity && (pollFirstEntry = this.waitForSend.pollFirstEntry()) != null && pollFirstEntry.getValue() != null) {
                    save(pollFirstEntry.getValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SendCell sendCell) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, sendCell) == null) {
            ThreadPool.getPool().execute(new Runnable(this, sendCell) { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpSendController this$0;
                public final /* synthetic */ SendCell val$cell;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sendCell};
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
                    this.val$cell = sendCell;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$cell.saveToFile(this.this$0.cacheDir);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHttp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65551, this, j2) == null) {
            ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.defs.controller.HttpSendController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpSendController this$0;

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
                        SendCell pollTask = this.this$0.pollTask();
                        if (pollTask == null) {
                            this.this$0.loadSendCellFromFile();
                            return;
                        }
                        try {
                            String format = String.format("%s&hd_stime=%d", pollTask.getContent(), Long.valueOf(Util.wallTimeMillis()));
                            this.this$0.httpUtil.setLastTryTimes(pollTask.getRetry());
                            boolean sendSync = this.this$0.httpUtil.sendSync(format);
                            int lastTryTimes = this.this$0.httpUtil.getLastTryTimes();
                            L.debug(this, "Return value: %B to send command %s. ", Boolean.valueOf(sendSync), format);
                            if (!sendSync) {
                                if (this.this$0.httpUtil.getLastStatusCode() != 414 && this.this$0.httpUtil.getLastStatusCode() != 400) {
                                    L.warn(this, "data:%s ; all tryTimes:%d ; createTime:%d", Long.valueOf(pollTask.getId()), Integer.valueOf(lastTryTimes), Long.valueOf(pollTask.getTimestamp()));
                                    pollTask.retryIncrease();
                                    this.this$0.save(pollTask);
                                    this.this$0.putTask(pollTask);
                                    this.this$0.sendHttp((pollTask.getRetry() + 1) * this.this$0.delayStep);
                                }
                                pollTask.deleteFile(this.this$0.cacheDir);
                                L.warn(this, "httpUtil.getLastStatusCode()=%d,removeInvalid:%s", Integer.valueOf(this.this$0.httpUtil.getLastStatusCode()), pollTask.getContent());
                                this.this$0.sendHttp(0L);
                            } else {
                                pollTask.deleteFile(this.this$0.cacheDir);
                                this.this$0.sendHttp(0L);
                            }
                        } catch (Throwable th) {
                            L.debug(this, th.getMessage(), new Object[0]);
                        }
                    }
                }
            }, j2 * 1000);
        }
    }

    public void send(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
            putTask(new SendCell(str, j2));
            sendHttp(0L);
        }
    }
}
