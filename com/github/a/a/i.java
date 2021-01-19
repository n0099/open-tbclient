package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pGM = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pGN;

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
        this.pGN = 100;
        this.mCurrentThread = thread;
        this.pGN = i;
    }

    public ArrayList<String> P(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pGM) {
            for (Long l : pGM.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pGA.format(l) + "\r\n\r\n" + pGM.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eyc() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pGM) {
            if (pGM.size() == this.pGN && this.pGN > 0) {
                pGM.remove(pGM.keySet().iterator().next());
            }
            pGM.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
