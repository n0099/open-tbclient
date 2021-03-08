package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pSg = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pSh;

    @Override // com.github.a.a.a
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.github.a.a.a
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    public i(Thread thread, int i, long j) {
        super(j);
        this.pSh = 100;
        this.mCurrentThread = thread;
        this.pSh = i;
    }

    public ArrayList<String> T(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pSg) {
            for (Long l : pSg.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pRU.format(l) + "\r\n\r\n" + pSg.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eAI() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pSg) {
            if (pSg.size() == this.pSh && this.pSh > 0) {
                pSg.remove(pSg.keySet().iterator().next());
            }
            pSg.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
