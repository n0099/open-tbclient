package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface s extends g.a {
    void N(long j, long j2) throws ExoPlaybackException;

    void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException;

    void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException;

    boolean atB();

    void disable();

    t drq();

    com.google.android.exoplayer2.util.h drr();

    com.google.android.exoplayer2.source.p drs();

    boolean drt();

    void dru();

    boolean drv();

    void drw() throws IOException;

    void fn(long j) throws ExoPlaybackException;

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
