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

    t drs();

    com.google.android.exoplayer2.util.h drt();

    com.google.android.exoplayer2.source.p dru();

    boolean drv();

    void drw();

    boolean drx();

    void dry() throws IOException;

    void fn(long j) throws ExoPlaybackException;

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
