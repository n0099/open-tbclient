package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes7.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> psC = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int psD;

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
        this.psD = 100;
        this.mCurrentThread = thread;
        this.psD = i;
    }

    public ArrayList<String> L(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (psC) {
            for (Long l : psC.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.psq.format(l) + "\r\n\r\n" + psC.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void exF() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (psC) {
            if (psC.size() == this.psD && this.psD > 0) {
                psC.remove(psC.keySet().iterator().next());
            }
            psC.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
