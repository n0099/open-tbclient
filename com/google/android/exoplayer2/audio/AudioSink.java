package com.google.android.exoplayer2.audio;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.q;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public interface AudioSink {

    /* loaded from: classes5.dex */
    public interface a {
        void EP(int i);

        void dsH();

        void i(int i, long j, long j2);
    }

    void Ja(int i);

    boolean OZ(String str);

    void a(a aVar);

    void a(b bVar);

    void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws ConfigurationException;

    boolean a(ByteBuffer byteBuffer, long j) throws InitializationException, WriteException;

    boolean atB();

    q d(q qVar);

    q drF();

    void dsD();

    void dsE() throws WriteException;

    boolean dsF();

    void dsG();

    void pause();

    void play();

    void release();

    void reset();

    void setVolume(float f);

    long vB(boolean z);

    /* loaded from: classes5.dex */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    /* loaded from: classes5.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }
}
