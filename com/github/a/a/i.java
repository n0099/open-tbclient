package com.github.a.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {
    private static final LinkedHashMap<Long, String> pGL = new LinkedHashMap<>();
    private Thread mCurrentThread;
    private int pGM;

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
        this.pGM = 100;
        this.mCurrentThread = thread;
        this.pGM = i;
    }

    public ArrayList<String> P(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (pGL) {
            for (Long l : pGL.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(com.github.a.a.a.a.pGz.format(l) + "\r\n\r\n" + pGL.get(l));
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
        synchronized (pGL) {
            if (pGL.size() == this.pGM && this.pGM > 0) {
                pGL.remove(pGL.keySet().iterator().next());
            }
            pGL.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
