package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pQR = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pQS;

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
        this.pQS = 100;
        this.mCurrentThread = thread;
        this.pQS = i;
    }

    public ArrayList<String> T(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pQR) {
            for (Long l : pQR.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pQF.format(l) + "\r\n\r\n" + pQR.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void eAu() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (pQR) {
            if (pQR.size() == this.pQS && this.pQS > 0) {
                pQR.remove(pQR.keySet().iterator().next());
            }
            pQR.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
