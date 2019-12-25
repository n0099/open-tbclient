package com.google.android.exoplayer2.audio;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.q;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface AudioSink {

    /* loaded from: classes4.dex */
    public interface a {
        void EK(int i);

        void drv();

        void i(int i, long j, long j2);
    }

    void IR(int i);

    boolean OO(String str);

    void a(a aVar);

    void a(b bVar);

    void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws ConfigurationException;

    boolean a(ByteBuffer byteBuffer, long j) throws InitializationException, WriteException;

    boolean ati();

    q d(q qVar);

    q dqt();

    void drr();

    void drs() throws WriteException;

    boolean drt();

    void dru();

    void pause();

    void play();

    void release();

    void reset();

    void setVolume(float f);

    long vp(boolean z);

    /* loaded from: classes4.dex */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }
}
