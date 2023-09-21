package com.yy.transvod.player.mediacodec;

import android.media.MediaFormat;
import com.baidu.tieba.v7c;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public final class NativeFfmpeg extends v7c {
    public static final Integer d = 1;
    public static final Integer e = 2;
    public long c = 0;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public static native void nativeClassInit();

    private native int native_create(int i, MediaFormat mediaFormat, int i2, int i3);

    private native int native_decode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, long j, long j2);

    private native void native_destroy();

    private native int native_receive_frame(ByteBuffer byteBuffer, TreeMap<Integer, Object> treeMap, FrameInfo frameInfo);

    private native void native_release();

    private native int native_send_packet(ByteBuffer byteBuffer, boolean z, long j, long j2);

    private native void native_setup();

    public void k() {
        if (this.c != 0) {
            native_destroy();
        }
        this.c = 0L;
    }

    public static ArrayList<MixAudioExtraInfo> l(TreeMap<Integer, Object> treeMap) {
        Object obj;
        if ((treeMap == null && treeMap.isEmpty()) || (obj = treeMap.get(d)) == null) {
            return null;
        }
        return (ArrayList) obj;
    }

    public static ArrayList<Long> m(TreeMap<Integer, Object> treeMap) {
        Object obj;
        if ((treeMap == null && treeMap.isEmpty()) || (obj = treeMap.get(e)) == null) {
            return null;
        }
        return (ArrayList) obj;
    }

    public void p(a aVar) {
        new WeakReference(aVar);
    }

    public int j(int i, MediaFormat mediaFormat) {
        if (this.c == 0) {
            return native_create(i, mediaFormat, this.b, this.a);
        }
        return 0;
    }

    public int n(ByteBuffer byteBuffer, TreeMap<Integer, Object> treeMap, FrameInfo frameInfo) {
        if (this.c != 0) {
            return native_receive_frame(byteBuffer, treeMap, frameInfo);
        }
        return -1;
    }

    public int o(ByteBuffer byteBuffer, boolean z, long j, long j2) {
        if (this.c != 0) {
            return native_send_packet(byteBuffer, z, j, j2);
        }
        return -1;
    }
}
