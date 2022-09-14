package com.kwai.filedownloader;

import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;
/* loaded from: classes8.dex */
public interface x extends s.a {

    /* loaded from: classes8.dex */
    public interface a {
        t Cy();

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot n(Throwable th);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void start();
    }

    long CA();

    byte Ca();

    Throwable Cc();

    int Ce();

    boolean Cg();

    void Cz();

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();
}
