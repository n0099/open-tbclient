package com.yy.hiidostatis.message.module.sessionreport;

import com.yy.hiidostatis.inner.util.SharedThreadTimer;
import com.yy.hiidostatis.inner.util.SharedTimerTask;
import com.yy.hiidostatis.message.SessionReport;
import com.yy.hiidostatis.message.SessionReportWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class SessionReportWrapperImpl implements SessionReportWrapper, SessionReport.AfterFlush, SessionReport.Processor {
    public SharedThreadTimer globeTimer;
    public SessionReport sessionReport;
    public Map<String, Set<String>> exclude = new ConcurrentHashMap();
    public Map<Long, OnTimer> cache = new HashMap();
    public Set<String> sessions = new HashSet();

    @Override // com.yy.hiidostatis.message.SessionReport.AfterFlush
    public SessionReport.StatisContentAble reset(String str, SessionReport.StatisContentAble statisContentAble) {
        return null;
    }

    /* loaded from: classes9.dex */
    public class OnTimer extends SharedTimerTask {
        public Map<String, List<String>> eventIds = new HashMap();
        public Set<String> globe = new HashSet();

        public OnTimer() {
        }

        public synchronized void addGlobe(String str) {
            this.globe.add(str);
        }

        public synchronized void addEventId(String str, String str2) {
            List<String> list = this.eventIds.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.eventIds.put(str, list);
            }
            list.add(str2);
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.globe) {
                if (SessionReportWrapperImpl.this.sessionClosed(str)) {
                    arrayList.add(str);
                } else {
                    SessionReportWrapperImpl.this.sessionReport.flushSessionAll(str, (Set) SessionReportWrapperImpl.this.exclude.get(str));
                }
            }
            for (Map.Entry<String, List<String>> entry : this.eventIds.entrySet()) {
                if (SessionReportWrapperImpl.this.sessionClosed(entry.getKey())) {
                    arrayList.add(entry.getKey());
                } else {
                    for (String str2 : entry.getValue()) {
                        SessionReportWrapperImpl.this.sessionReport.flushSession(entry.getKey(), str2);
                    }
                }
            }
            for (String str3 : arrayList) {
                this.globe.remove(str3);
                this.eventIds.remove(str3);
            }
        }
    }

    public SessionReportWrapperImpl(SessionReport sessionReport) {
        this.sessionReport = sessionReport;
    }

    private synchronized void removeSession(String str) {
        this.sessions.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean sessionClosed(String str) {
        return !this.sessions.contains(str);
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public void closeSession(String str) {
        this.sessionReport.closeSession(str);
        this.exclude.remove(str);
        removeSession(str);
    }

    public boolean flushSessionAll(String str) {
        return flushSessionAll(str, null);
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean flushSession(String str, String str2) {
        return this.sessionReport.flushSession(str, str2);
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean flushSessionAll(String str, Set<String> set) {
        return this.sessionReport.flushSessionAll(str, set);
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public synchronized void beginSession(String str, String str2, long j, Map<String, Long> map) {
        this.sessionReport.beginSession(str, str2, this, this);
        this.sessions.add(str);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i > 0) {
            OnTimer onTimer = this.cache.get(Long.valueOf(j));
            if (onTimer == null) {
                OnTimer onTimer2 = new OnTimer();
                onTimer2.addGlobe(str);
                this.cache.put(Long.valueOf(j), onTimer2);
                if (this.globeTimer == null) {
                    this.globeTimer = new SharedThreadTimer();
                }
                this.globeTimer.schedule(onTimer2, j, j);
            } else {
                onTimer.addGlobe(str);
            }
        }
        if (map != null) {
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                OnTimer onTimer3 = this.cache.get(entry.getValue());
                if (onTimer3 == null) {
                    onTimer3 = new OnTimer();
                    this.cache.put(entry.getValue(), onTimer3);
                    hashMap.put(entry.getValue(), onTimer3);
                }
                onTimer3.addEventId(str, entry.getKey());
                hashSet.add(entry.getKey());
            }
            if (i > 0) {
                this.exclude.put(str, hashSet);
            }
            if (this.globeTimer == null) {
                this.globeTimer = new SharedThreadTimer();
            }
            for (Map.Entry entry2 : hashMap.entrySet()) {
                this.globeTimer.schedule((SharedTimerTask) entry2.getValue(), ((Long) entry2.getKey()).longValue(), ((Long) entry2.getKey()).longValue());
            }
        }
    }

    @Override // com.yy.hiidostatis.message.SessionReport.Processor
    public SessionReport.StatisContentAble process(SessionReport.StatisContentAble statisContentAble, String str, Object obj) {
        EventValue eventValue = (EventValue) obj;
        CommonSessionState commonSessionState = (CommonSessionState) statisContentAble;
        if (commonSessionState == null) {
            commonSessionState = new CommonSessionState();
        }
        String dimIdentification = eventValue.dimIdentification();
        CalValue calValue = commonSessionState.get(dimIdentification, eventValue.key);
        if (calValue == null) {
            calValue = new CalValue();
        }
        commonSessionState.put(dimIdentification, eventValue.key, eventValue.calAction.cal(eventValue.value, calValue), eventValue.extra);
        return commonSessionState;
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        EventValue eventValue = new EventValue(calAction, str3, number);
        eventValue.dimens = map;
        eventValue.extra = map2;
        return this.sessionReport.pushToSession(str, str2, eventValue);
    }

    @Override // com.yy.hiidostatis.message.SessionReportWrapper
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        for (EventValue eventValue : list) {
            eventValue.dimens = map;
            eventValue.extra = map2;
            this.sessionReport.pushToSession(str, str2, eventValue);
        }
        return true;
    }
}
