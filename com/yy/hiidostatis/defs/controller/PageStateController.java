package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.api.OnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class PageStateController {
    public volatile Context context;
    public volatile OnStatisListener listener;
    public volatile long periodTime;
    public volatile IStatisAPI statisAPI;
    public volatile ConcurrentLinkedQueue<PageBean> pages = new ConcurrentLinkedQueue<>();
    public volatile StringBuffer record = new StringBuffer(512);

    /* loaded from: classes8.dex */
    public static class PageBean {
        public String page;
        public long stime;

        public PageBean(String str, long j) {
            this.page = str;
            this.stime = j;
        }

        public String getPage() {
            return this.page;
        }

        public long getStime() {
            return this.stime;
        }

        public void setPage(String str) {
            this.page = str;
        }

        public void setStime(long j) {
            this.stime = j;
        }
    }

    public PageStateController(IStatisAPI iStatisAPI, Context context, OnStatisListener onStatisListener) {
        this.statisAPI = iStatisAPI;
        this.context = context;
        this.listener = onStatisListener;
    }

    private void sendToServer(boolean z) {
        long currentTimeMillis;
        long j;
        String stringBuffer = this.record.toString();
        this.record.setLength(0);
        long currentTimeMillis2 = System.currentTimeMillis() - this.periodTime;
        if (z) {
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        this.periodTime = currentTimeMillis;
        if (stringBuffer.length() == 0) {
            return;
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        if (this.listener != null) {
            j = this.listener.getCurrentUid();
        } else {
            j = 0;
        }
        this.statisAPI.reportPageState(j, substring, currentTimeMillis2);
    }

    public void onStart(String str) {
        if (str != null && !str.isEmpty()) {
            this.pages.add(new PageBean(str, System.currentTimeMillis()));
            if (this.periodTime == 0) {
                this.periodTime = System.currentTimeMillis();
            }
        }
    }

    public boolean onStop(String str) {
        Iterator<PageBean> it = this.pages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PageBean next = it.next();
            if (next.getPage().equals(str)) {
                this.pages.remove(next);
                this.record.append(String.format("%s:%d:%d|", Util.replaceEncode(next.getPage(), ":"), Long.valueOf(next.getStime()), Long.valueOf(System.currentTimeMillis() - next.getStime())));
                break;
            }
        }
        if (this.pages.isEmpty() || this.record.length() > 3000) {
            sendToServer(this.pages.isEmpty());
        }
        return this.pages.isEmpty();
    }
}
