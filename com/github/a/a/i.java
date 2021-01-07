package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pLm = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pLn;

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
        this.pLn = 100;
        this.mCurrentThread = thread;
        this.pLn = i;
    }

    public ArrayList<String> P(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pLm) {
            for (Long l : pLm.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pLa.format(l) + "\r\n\r\n" + pLm.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eBU() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pLm) {
            if (pLm.size() == this.pLn && this.pLn > 0) {
                pLm.remove(pLm.keySet().iterator().next());
            }
            pLm.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
