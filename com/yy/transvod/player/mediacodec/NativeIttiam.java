package com.yy.transvod.player.mediacodec;

import android.media.MediaFormat;
import com.baidu.tieba.iwb;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public final class NativeIttiam extends iwb {
    public long c = 0;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public static native void nativeClassInit();

    private native int native_create(int i, MediaFormat mediaFormat, int i2, int i3);

    private native int native_decode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, long j, FrameInfo frameInfo);

    private native void native_destroy();

    private native void native_release();

    private native void native_setup();

    public void l() {
        if (this.c != 0) {
            native_destroy();
        }
        this.c = 0L;
    }

    public int j(int i, MediaFormat mediaFormat) {
        if (this.c == 0) {
            return native_create(i, mediaFormat, this.b, this.a);
        }
        return 0;
    }

    public int k(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, long j, FrameInfo frameInfo) {
        if (this.c != 0) {
            return native_decode(byteBuffer, byteBuffer2, z, j, frameInfo);
        }
        return -1;
    }

    public void m(a aVar) {
        new WeakReference(aVar);
    }
}
