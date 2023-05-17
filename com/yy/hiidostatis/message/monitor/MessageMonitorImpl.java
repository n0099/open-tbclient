package com.yy.hiidostatis.message.monitor;

import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.utils.KVIO;
import com.yy.hiidostatis.provider.MessageConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class MessageMonitorImpl implements MessageMonitor {
    public static final String PROCESS_ID_KEY = "hiido_process_id";
    public MessageConfig config;
    public Object lock = new Object();
    public final ConcurrentHashMap<String, MessageParams> msgParams = new ConcurrentHashMap<>();
    public int processId = KVIO.get().decodeInt(PROCESS_ID_KEY, 1);

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public void init() {
    }

    /* loaded from: classes10.dex */
    public static class MessageParams {
        public String act;
        public AtomicLong autoId;
        public String autoIdKey;
        public AtomicInteger packId = new AtomicInteger();

        public MessageParams(String str) {
            this.act = str;
            this.autoIdKey = str + "_auid";
            this.autoId = new AtomicLong(KVIO.get().decodeLong(this.autoIdKey));
        }

        public String getAct() {
            return this.act;
        }

        public long getAutoId() {
            return this.autoId.get();
        }

        public String getAutoIdKey() {
            return this.autoIdKey;
        }

        public long incrementAndGetAutoId() {
            return this.autoId.incrementAndGet();
        }

        public int incrementAndGetPackId() {
            return this.packId.incrementAndGet();
        }
    }

    public MessageMonitorImpl(MessageConfig messageConfig) {
        this.config = messageConfig;
        KVIO.get().encode(PROCESS_ID_KEY, this.processId + 1);
    }

    private MessageParams getAct(String str) {
        MessageParams messageParams = this.msgParams.get(str);
        if (messageParams == null) {
            synchronized (this.lock) {
                messageParams = this.msgParams.get(str);
                if (messageParams == null) {
                    messageParams = new MessageParams(str);
                    this.msgParams.put(str, messageParams);
                }
            }
        }
        return messageParams;
    }

    private synchronized void writeAutoIdToRecord(MessageParams messageParams) {
        KVIO.get().encode(messageParams.getAutoIdKey(), messageParams.getAutoId());
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public long getAutoId(String str) {
        MessageParams act = getAct(str);
        long incrementAndGetAutoId = act.incrementAndGetAutoId();
        writeAutoIdToRecord(act);
        return incrementAndGetAutoId;
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public int getPackId(String str) {
        return getAct(str).incrementAndGetPackId();
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public void commit() {
        KVIO.get().commit();
    }

    @Override // com.yy.hiidostatis.message.MessageMonitor
    public int getProcessId() {
        return this.processId;
    }
}
