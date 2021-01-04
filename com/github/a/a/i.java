package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes15.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pJE = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pJF;

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
        this.pJF = 100;
        this.mCurrentThread = thread;
        this.pJF = i;
    }

    public ArrayList<String> O(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pJE) {
            for (Long l : pJE.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pJs.format(l) + "\r\n\r\n" + pJE.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eBq() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pJE) {
            if (pJE.size() == this.pJF && this.pJF > 0) {
                pJE.remove(pJE.keySet().iterator().next());
            }
            pJE.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
