package com.kwai.filedownloader;

import com.kwai.filedownloader.x;
/* loaded from: classes10.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0692a {
        a Ci();

        x.a Cj();

        int Ck();

        void Cl();

        boolean Cm();

        void Cn();

        void Co();

        boolean Cp();

        boolean bR(int i);

        void free();

        boolean isOver();
    }

    /* loaded from: classes10.dex */
    public interface b {
        int Cq();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void Cr();

        void onBegin();
    }

    b BR();

    boolean BS();

    boolean BT();

    int BU();

    int BV();

    boolean BW();

    i BX();

    long BY();

    long BZ();

    byte Ca();

    boolean Cb();

    Throwable Cc();

    int Cd();

    int Ce();

    boolean Cf();

    boolean Cg();

    boolean Ch();

    a Y(String str, String str2);

    a a(i iVar);

    a bA(boolean z);

    a bQ(int i);

    a by(boolean z);

    a bz(boolean z);

    a c(String str, boolean z);

    boolean cancel();

    a en(String str);

    a eo(String str);

    a g(Object obj);

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

    int start();
}
