package com.yy.hiidostatis.message.module.sessionreport;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.utils.NoNull;
import com.yy.hiidostatis.provider.MessageConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class SessionReportImpl implements SessionReport {
    public MessageConfig config;
    public Packer packer;
    public Map<String, Session> sessions = new ConcurrentHashMap();

    /* loaded from: classes10.dex */
    public class Session {
        public final String act;
        public final SessionReport.AfterFlush afterFlush;
        public final SessionReport.Processor processor;
        public final String session;
        public Map<String, SessionReport.StatisContentAble> values = new HashMap();

        public Session(String str, String str2, SessionReport.Processor processor, SessionReport.AfterFlush afterFlush) {
            this.session = str;
            this.act = str2;
            this.processor = processor;
            this.afterFlush = afterFlush;
        }

        private void send(String str, SessionReport.StatisContentAble statisContentAble) {
            List<StatisContent> statisContent = statisContentAble.toStatisContent(this.act, str);
            if (statisContent != null && !statisContent.isEmpty()) {
                for (StatisContent statisContent2 : statisContent) {
                    statisContent2.put("session", this.session);
                    SessionReportImpl.this.packer.addMessage(statisContent2);
                }
            }
        }

        public synchronized boolean pushToSession(String str, Object obj) {
            try {
                this.values.put(str, this.processor.process(this.values.get(str), str, obj));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void flushSession(String str) {
            SessionReport.StatisContentAble statisContentAble = this.values.get(str);
            if (statisContentAble == null) {
                return;
            }
            send(str, statisContentAble);
            if (this.afterFlush != null) {
                SessionReport.StatisContentAble reset = this.afterFlush.reset(str, statisContentAble);
                if (reset == null) {
                    this.values.remove(str);
                } else {
                    this.values.put(str, reset);
                }
            }
        }

        public void close() {
            if (!NoNull.isEmpty(this.values)) {
                try {
                    for (Map.Entry<String, SessionReport.StatisContentAble> entry : this.values.entrySet()) {
                        send(entry.getKey(), entry.getValue());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SessionReportImpl(MessageConfig messageConfig, Packer packer) {
        this.config = messageConfig;
        this.packer = packer;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSession(String str, String str2) {
        Session session = this.sessions.get(str);
        if (session == null) {
            return false;
        }
        session.flushSession(str2);
        return true;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public void closeSession(String str) {
        Session remove = this.sessions.remove(str);
        if (remove == null) {
            return;
        }
        remove.close();
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSessionAll(String str) {
        return flushSessionAll(str, null);
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public void beginSession(String str, String str2, SessionReport.Processor processor, SessionReport.AfterFlush afterFlush) {
        this.sessions.put(str, new Session(str, str2, processor, afterFlush));
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean flushSessionAll(String str, Set<String> set) {
        Session session = this.sessions.get(str);
        if (session == null) {
            return false;
        }
        for (Map.Entry entry : new ArrayList(session.values.entrySet())) {
            if (set == null || !set.contains(entry.getKey())) {
                session.flushSession((String) entry.getKey());
            }
        }
        return true;
    }

    @Override // com.yy.hiidostatis.message.SessionReport
    public boolean pushToSession(String str, String str2, Object obj) {
        Session session = this.sessions.get(str);
        if (session != null) {
            return session.pushToSession(str2, obj);
        }
        return false;
    }
}
