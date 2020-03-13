package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class f implements v {
    private final Context context;
    @Nullable
    private final com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> lYC;
    private final int lYD;
    private final long lYE;

    public f(Context context, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar) {
        this(context, aVar, 0);
    }

    public f(Context context, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, int i) {
        this(context, aVar, i, 5000L);
    }

    public f(Context context, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, int i, long j) {
        this.context = context;
        this.lYC = aVar;
        this.lYD = i;
        this.lYE = j;
    }

    @Override // com.google.android.exoplayer2.v
    public s[] a(Handler handler, com.google.android.exoplayer2.video.e eVar, com.google.android.exoplayer2.audio.d dVar, com.google.android.exoplayer2.text.j jVar, com.google.android.exoplayer2.metadata.d dVar2) {
        ArrayList<s> arrayList = new ArrayList<>();
        a(this.context, this.lYC, this.lYE, handler, eVar, this.lYD, arrayList);
        a(this.context, this.lYC, dsT(), handler, dVar, this.lYD, arrayList);
        a(this.context, jVar, handler.getLooper(), this.lYD, arrayList);
        a(this.context, dVar2, handler.getLooper(), this.lYD, arrayList);
        a(this.context, handler, this.lYD, arrayList);
        return (s[]) arrayList.toArray(new s[arrayList.size()]);
    }

    protected void a(Context context, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, long j, Handler handler, com.google.android.exoplayer2.video.e eVar, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.video.c(context, com.google.android.exoplayer2.mediacodec.b.mql, j, aVar, false, handler, eVar, 50));
        if (i != 0) {
            int size = arrayList.size();
            int i2 = i == 2 ? size - 1 : size;
            try {
                int i3 = i2 + 1;
                arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.google.android.exoplayer2.video.e.class, Integer.TYPE).newInstance(true, Long.valueOf(j), handler, eVar, 50));
                Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException e) {
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:11|12|13)|14|15|16|17|18|(3:20|21|23)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(3:8|9|10)|(3:11|12|13)|14|15|16|17|18|(3:20|21|23)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e9, code lost:
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ea, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(Context context, @Nullable com.google.android.exoplayer2.drm.a<com.google.android.exoplayer2.drm.c> aVar, AudioProcessor[] audioProcessorArr, Handler handler, com.google.android.exoplayer2.audio.d dVar, int i, ArrayList<s> arrayList) {
        int i2;
        int i3;
        int i4;
        arrayList.add(new com.google.android.exoplayer2.audio.g(com.google.android.exoplayer2.mediacodec.b.mql, aVar, true, handler, dVar, com.google.android.exoplayer2.audio.c.gq(context), audioProcessorArr));
        if (i != 0) {
            int size = arrayList.size();
            if (i == 2) {
                size--;
            }
            try {
                try {
                    i4 = size + 1;
                } catch (ClassNotFoundException e) {
                    i2 = size;
                }
                try {
                    try {
                        arrayList.add(size, (s) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                        Log.i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                        i3 = i4;
                    } catch (ClassNotFoundException e2) {
                        i2 = i4;
                        i3 = i2;
                        int i5 = i3 + 1;
                        arrayList.add(i3, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                        Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        int i6 = i5 + 1;
                        arrayList.add(i5, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                        Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    }
                    int i52 = i3 + 1;
                    arrayList.add(i3, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                    Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    try {
                        int i62 = i52 + 1;
                        arrayList.add(i52, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.d.class, AudioProcessor[].class).newInstance(handler, dVar, audioProcessorArr));
                        Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (ClassNotFoundException e3) {
                    } catch (Exception e4) {
                        throw new RuntimeException(e4);
                    }
                } catch (Exception e5) {
                    throw new RuntimeException(e5);
                }
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    protected void a(Context context, com.google.android.exoplayer2.text.j jVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.text.k(jVar, looper));
    }

    protected void a(Context context, com.google.android.exoplayer2.metadata.d dVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.e(dVar, looper));
    }

    protected void a(Context context, Handler handler, int i, ArrayList<s> arrayList) {
    }

    protected AudioProcessor[] dsT() {
        return new AudioProcessor[0];
    }
}
