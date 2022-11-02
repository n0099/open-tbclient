package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.util.Map;
/* loaded from: classes8.dex */
public interface c {

    /* loaded from: classes8.dex */
    public interface a {
        void ai(int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void ns();
    }

    /* renamed from: com.kwad.sdk.core.video.kwai.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0618c {
        boolean j(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean k(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(c cVar);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void nt();
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(TimedText timedText);
    }

    /* loaded from: classes8.dex */
    public interface h {
        void i(int i, int i2);
    }

    void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar);

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0618c interfaceC0618c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void b(e eVar);

    void c(d dVar);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i);

    void setDataSource(Context context, Uri uri);

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();
}
