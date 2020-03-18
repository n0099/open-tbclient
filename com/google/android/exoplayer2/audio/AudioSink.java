package com.google.android.exoplayer2.audio;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.q;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface AudioSink {

    /* loaded from: classes6.dex */
    public interface a {
        void Fb(int i);

        void duu();

        void i(int i, long j, long j2);
    }

    void Jl(int i);

    boolean Pm(String str);

    void a(a aVar);

    void a(b bVar);

    void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws ConfigurationException;

    boolean a(ByteBuffer byteBuffer, long j) throws InitializationException, WriteException;

    boolean avU();

    q d(q qVar);

    q dtt();

    void duq();

    void dur() throws WriteException;

    boolean dus();

    void dut();

    void pause();

    void play();

    void release();

    void reset();

    void setVolume(float f);

    long vM(boolean z);

    /* loaded from: classes6.dex */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    /* loaded from: classes6.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: " + i);
            this.errorCode = i;
        }
    }
}
