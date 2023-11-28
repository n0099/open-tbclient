package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
/* loaded from: classes10.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0677a {
        boolean aT(int i);

        void free();

        boolean isOver();

        a tT();

        x.a tU();

        int tV();

        void tW();

        boolean tX();

        void tY();

        void tZ();

        boolean ua();
    }

    /* loaded from: classes10.dex */
    public interface b {
        int ub();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void onBegin();

        void uc();
    }

    a a(i iVar);

    a aS(int i);

    a aS(String str);

    a aT(String str);

    a aZ(boolean z);

    a ba(boolean z);

    a bb(boolean z);

    a c(String str, boolean z);

    boolean cancel();

    a e(Object obj);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    boolean pause();

    a q(String str, String str2);

    int start();

    b tC();

    boolean tD();

    boolean tE();

    int tF();

    int tG();

    boolean tH();

    i tI();

    long tJ();

    long tK();

    byte tL();

    boolean tM();

    Throwable tN();

    int tO();

    int tP();

    boolean tQ();

    boolean tR();

    boolean tS();
}
