package com.yy.hiidostatis.message.sender;

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
    public static final int CHANGE_LIMIT_SIZE_THRESHOLD = 3;
    public static final int LIMIT_SIZE = 40960;
    public static final int LIMIT_SIZE_STEP = 10240;
    public static final long MAX_WAIT_MILLIS = 30000;
    public static final int SENDING_CAPACITY = 10;
    public static final int STOP_SEND_THRESHOLD = 3;
    public MessageConfig config;
    public volatile boolean running;
    public MessageSender sender;
    public MessageSupplier supplier;
    public SharedTimerTask timerTask;
    public List<MessageProcessor> messageProcessors = new ArrayList();
    public volatile int state = 0;
    public volatile AtomicInteger errorCount = new AtomicInteger();
    public volatile int limitSize = LIMIT_SIZE;
    public AtomicInteger sendingCount = new AtomicInteger(0);
    public AtomicInteger sfCount = new AtomicInteger();
    public int preRunTime = 0;

    public SendMsgDispatcher(MessageSupplier messageSupplier, MessageSender messageSender, List<MessageProcessor> list) {
        this.supplier = messageSupplier;
        this.sender = messageSender;
        if (list != null) {
            this.messageProcessors.addAll(list);
        }
        messageSender.setResultListener(this);
    }

    private void execute(long j) {
        synchronized (this) {
            if (this.state != 2 || TimeUtil.currentTimeInSecond() - this.preRunTime > 30000) {
                this.state = 2;
                this.running = false;
                this.preRunTime = TimeUtil.currentTimeInSecond();
                ThreadPool.getPool().execute(this, j);
            }
        }
    }

    public void appendMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessors.add(messageProcessor);
    }

    @Override // com.yy.hiidostatis.message.Task
    public void execute() {
        synchronized (this) {
            if (this.state == 0 || TimeUtil.currentTimeInSecond() - this.preRunTime > 30000) {
                this.state = 1;
                this.preRunTime = TimeUtil.currentTimeInSecond();
                ThreadPool.getPool().execute(this);
            }
        }
    }

    public void insertMessageProcessor(int i, MessageProcessor messageProcessor) {
        this.messageProcessors.add(i, messageProcessor);
    }

    @Override // com.yy.hiidostatis.message.MessageSender.ResultListener
    public void onResult(int i, Message message, String str) {
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

    @Override // java.lang.Runnable
    public void run() {
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
                        Iterator<MessageProcessor> it = this.messageProcessors.iterator();
                        while (it.hasNext() && (fetchMessage = it.next().process(fetchMessage)) != null) {
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

    @Override // com.yy.hiidostatis.message.ISingleton
    public void setMainConfig(MessageConfig messageConfig) {
        if (this.config != null) {
            return;
        }
        this.config = messageConfig;
        this.timerTask = new SharedTimerTask() { // from class: com.yy.hiidostatis.message.sender.SendMsgDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                SendMsgDispatcher.this.execute();
            }
        };
        long j = 30000;
        if (messageConfig.getInterval() > 0) {
            j = Math.max(messageConfig.getInterval(), 5) * 1000;
        }
        long j2 = j;
        ThreadPool.getPool().getTimer().schedule(this.timerTask, j2, j2);
    }
}
