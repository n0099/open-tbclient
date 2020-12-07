package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes7.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> psA = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int psB;

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
        this.psB = 100;
        this.mCurrentThread = thread;
        this.psB = i;
    }

    public ArrayList<String> L(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (psA) {
            for (Long l : psA.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pso.format(l) + "\r\n\r\n" + psA.get(l));
                }
            }
        }
        return arrayList;
    }

    @Override // com.github.a.a.a
    protected void exE() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.mCurrentThread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (psA) {
            if (psA.size() == this.psB && this.psB > 0) {
                psA.remove(psA.keySet().iterator().next());
            }
            psA.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
