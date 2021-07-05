package d.f.b.a;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import d.f.b.a.g;
import java.io.IOException;
/* loaded from: classes10.dex */
public interface r extends g.a {
    boolean b();

    boolean e();

    void f(t tVar, Format[] formatArr, d.f.b.a.d0.o oVar, long j, boolean z, long j2) throws ExoPlaybackException;

    int getState();

    d.f.b.a.d0.o getStream();

    int getTrackType();

    void h();

    boolean i();

    boolean isReady();

    void j(long j, long j2) throws ExoPlaybackException;

    void k(long j) throws ExoPlaybackException;

    d.f.b.a.i0.h l();

    void m();

    void n() throws IOException;

    s o();

    void r(Format[] formatArr, d.f.b.a.d0.o oVar, long j) throws ExoPlaybackException;

    void setIndex(int i2);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
