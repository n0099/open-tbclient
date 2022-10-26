package com.yy.hiidostatis.message.sender;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.SharedTimerTask;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.ISingleton;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.MessageSender;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.Task;
import com.yy.hiidostatis.message.bean.Message;
import com.yy.hiidostatis.message.log.TraceLog;
import com.yy.hiidostatis.message.utils.TimeUtil;
import com.yy.hiidostatis.provider.MessageConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class SendMsgDispatcher implements Task, Runnable, MessageSender.ResultListener, ISingleton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHANGE_LIMIT_SIZE_THRESHOLD = 3;
    public static final int LIMIT_SIZE = 40960;
    public static final int LIMIT_SIZE_STEP = 10240;
    public static final long MAX_WAIT_MILLIS = 30000;
    public static final int SENDING_CAPACITY = 10;
    public static final int STOP_SEND_THRESHOLD = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageConfig config;
    public volatile AtomicInteger errorCount;
    public volatile int limitSize;
    public List messageProcessors;
    public int preRunTime;
    public volatile boolean running;
    public MessageSender sender;
    public AtomicInteger sendingCount;
    public AtomicInteger sfCount;
    public volatile int state;
    public MessageSupplier supplier;
    public SharedTimerTask timerTask;

    public SendMsgDispatcher(MessageSupplier messageSupplier, MessageSender messageSender, List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageSupplier, messageSender, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messageProcessors = new ArrayList();
        this.state = 0;
        this.errorCount = new AtomicInteger();
        this.limitSize = LIMIT_SIZE;
        this.sendingCount = new AtomicInteger(0);
        this.sfCount = new AtomicInteger();
        this.preRunTime = 0;
        this.supplier = messageSupplier;
        this.sender = messageSender;
        if (list != null) {
            this.messageProcessors.addAll(list);
        }
        messageSender.setResultListener(this);
    }

    private void execute(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j) == null) {
            synchronized (this) {
                if (this.state != 2 || TimeUtil.currentTimeInSecond() - this.preRunTime > 30000) {
                    this.state = 2;
                    this.running = false;
                    this.preRunTime = TimeUtil.currentTimeInSecond();
                    ThreadPool.getPool().execute(this, j);
                }
            }
        }
    }

    @Override // com.yy.hiidostatis.message.ISingleton
    public void setMainConfig(MessageConfig messageConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, messageConfig) != null) || this.config != null) {
            return;
        }
        this.config = messageConfig;
        this.timerTask = new SharedTimerTask(this) { // from class: com.yy.hiidostatis.message.sender.SendMsgDispatcher.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SendMsgDispatcher this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    this.this$0.execute();
                }
            }
        };
        long j = 30000;
        if (messageConfig.getInterval() > 0) {
            j = Math.max(messageConfig.getInterval(), 5) * 1000;
        }
        long j2 = j;
        ThreadPool.getPool().getTimer().schedule(this.timerTask, j2, j2);
    }

    public void appendMessageProcessor(MessageProcessor messageProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageProcessor) == null) {
            this.messageProcessors.add(messageProcessor);
        }
    }

    @Override // com.yy.hiidostatis.message.Task
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.state == 0 || TimeUtil.currentTimeInSecond() - this.preRunTime > 30000) {
                    this.state = 1;
                    this.preRunTime = TimeUtil.currentTimeInSecond();
                    ThreadPool.getPool().execute(this);
                }
            }
        }
    }

    public void insertMessageProcessor(int i, MessageProcessor messageProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, messageProcessor) == null) {
            this.messageProcessors.add(i, messageProcessor);
        }
    }

    @Override // com.yy.hiidostatis.message.MessageSender.ResultListener
    public void onResult(int i, Message message, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, message, str) == null) {
            int decrementAndGet = this.sendingCount.decrementAndGet();
            if (i == 0) {
                L.infoLimitTime(this, "Send Success:%s", message.getMsgId());
                TraceLog.successMessageLog(message.getMsgId());
                this.supplier.removeMessage(message.getMsgId());
                this.errorCount.set(this.errorCount.get() / 2);
                if (decrementAndGet < 5) {
                    execute();
                }
                int incrementAndGet = this.sfCount.incrementAndGet();
                if (!message.isSingle() && incrementAndGet > 3) {
                    this.sfCount.set(0);
                    this.limitSize = Math.min(this.limitSize + 10240, (int) LIMIT_SIZE);
                    L.debug(this, "change limit size:%d add", Integer.valueOf(this.limitSize));
                    return;
                } else if (incrementAndGet > 9) {
                    this.sfCount.set(0);
                    this.limitSize = Math.min(this.limitSize + 10240, (int) LIMIT_SIZE);
                    L.debug(this, "change limit size:%d add", Integer.valueOf(this.limitSize));
                    return;
                } else {
                    return;
                }
            }
            TraceLog.failedMessageLog(message.getMsgId());
            L.error(this, "Send Error:%s", message.getMsgId());
            this.supplier.restoreMessage(message.getMsgId());
            int incrementAndGet2 = this.errorCount.incrementAndGet();
            if (incrementAndGet2 > 3) {
                execute(Math.min(incrementAndGet2 * 1000, 30000L));
            }
            if (!message.isSingle() && this.sfCount.decrementAndGet() < -3) {
                this.sfCount.set(0);
                this.limitSize = Math.max(this.limitSize - 10240, 0);
                L.debug(this, "change limit size:%d reduce", Integer.valueOf(this.limitSize));
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.running) {
                    return;
                }
                synchronized (this) {
                    if (this.running) {
                        return;
                    }
                    this.running = true;
                    int i = 0;
                    while (true) {
                        if (!this.running || i >= 10) {
                            break;
                        }
                        synchronized (this) {
                            this.state = 1;
                        }
                        this.preRunTime = TimeUtil.currentTimeInSecond();
                        Message fetchMessage = this.supplier.fetchMessage(this.limitSize);
                        if (fetchMessage == null) {
                            synchronized (this) {
                                if (this.state != 2) {
                                    this.state = 0;
                                }
                            }
                        } else {
                            if (this.limitSize > fetchMessage.getContent().length) {
                                this.running = false;
                            }
                            Iterator it = this.messageProcessors.iterator();
                            while (it.hasNext() && (fetchMessage = ((MessageProcessor) it.next()).process(fetchMessage)) != null) {
                            }
                            if (fetchMessage != null) {
                                i = this.sendingCount.incrementAndGet();
                                this.sender.asyncSend(fetchMessage);
                            }
                        }
                    }
                    synchronized (this) {
                        if (this.state == 1) {
                            this.state = 0;
                        }
                        this.running = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                synchronized (this) {
                    if (this.state == 1) {
                        this.state = 0;
                    }
                    this.running = false;
                }
            }
        }
    }
}
