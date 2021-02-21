package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pRr = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pRs;

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
        this.pRs = 100;
        this.mCurrentThread = thread;
        this.pRs = i;
    }

    public ArrayList<String> T(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pRr) {
            for (Long l : pRr.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pRf.format(l) + "\r\n\r\n" + pRr.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eAC() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pRr) {
            if (pRr.size() == this.pRs && this.pRs > 0) {
                pRr.remove(pRr.keySet().iterator().next());
            }
            pRr.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
