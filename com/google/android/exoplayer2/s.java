package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g;
import java.io.IOException;
/* loaded from: classes4.dex */
public interface s extends g.a {
    void N(long j, long j2) throws ExoPlaybackException;

    void a(u uVar, Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j, boolean z, long j2) throws ExoPlaybackException;

    void a(Format[] formatArr, com.google.android.exoplayer2.source.p pVar, long j) throws ExoPlaybackException;

    boolean ati();

    void disable();

    t dqe();

    com.google.android.exoplayer2.util.h dqf();

    com.google.android.exoplayer2.source.p dqg();

    boolean dqh();

    void dqi();

    boolean dqj();

    void dqk() throws IOException;

    void fi(long j) throws ExoPlaybackException;

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
