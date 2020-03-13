package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface s extends g.a {
    void M(long j, long j2) throws ExoPlaybackException;

    void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException;

    void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException;

    boolean avR();

    void disable();

    t dsH();

    com.google.android.exoplayer2.util.h dsI();

    com.google.android.exoplayer2.source.p dsJ();

    boolean dsK();

    void dsL();

    boolean dsM();

    void dsN() throws IOException;

    void fl(long j) throws ExoPlaybackException;

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
