package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
/* loaded from: classes10.dex */
public interface x extends s.a {

    /* loaded from: classes10.dex */
    public interface a {
        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot h(Throwable th);

        t uj();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void start();
    }

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();

    byte tL();

    Throwable tN();

    int tP();

    boolean tR();

    void uk();

    long ul();
}
