package com.yy.transvod.player.mediacodec;

import com.baidu.tieba.gec;
import com.yy.transvod.player.log.TLog;
import java.nio.ByteBuffer;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class MediaInfo {
    public static final String l = "MediaInfo";
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public ByteBuffer k = null;

    public static native void native_copy_frame(MediaInfo mediaInfo, MediaInfo mediaInfo2, ByteBuffer[] byteBufferArr);

    public static MediaInfo a() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.i();
        return mediaInfo;
    }

    public boolean f() {
        return g(this);
    }

    public MediaInfo i() {
        this.a = 0;
        this.c = 0;
        this.b = 0;
        this.e = 0;
        this.d = 0;
        this.j = 0;
        this.h = 0;
        this.g = 0;
        this.f = 0;
        this.i = 0;
        this.k = null;
        return this;
    }

    public static MediaInfo b(int i, int i2, int i3) {
        MediaInfo a = a();
        a.a = i;
        if (h(a)) {
            a.b = i2;
            a.c = i3;
        } else {
            a.j = i2;
            a.h = i3;
            a.g = 1024;
        }
        return a;
    }

    public static void d(MediaInfo mediaInfo, MediaInfo mediaInfo2, ByteBuffer[] byteBufferArr) {
        native_copy_frame(mediaInfo, mediaInfo2, byteBufferArr);
    }

    public static boolean g(MediaInfo mediaInfo) {
        int i = mediaInfo.a;
        if (i > 0 && i <= 11) {
            return true;
        }
        return false;
    }

    public static boolean h(MediaInfo mediaInfo) {
        switch (mediaInfo.a) {
            case 1:
            case 5:
                return false;
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
                return true;
            case 9:
            default:
                String str = l;
                TLog.d(str, "mediainfo type = " + mediaInfo.a);
                return false;
        }
    }

    public boolean e(MediaInfo mediaInfo) {
        int i = this.a;
        if (i != 0 && mediaInfo.a != i) {
            return true;
        }
        if (h(mediaInfo)) {
            if (this.b != mediaInfo.b || this.c != mediaInfo.c || this.d != mediaInfo.d || this.e != mediaInfo.e) {
                return true;
            }
            return false;
        } else if (this.j != mediaInfo.j || mediaInfo.h != this.h) {
            return true;
        } else {
            return false;
        }
    }

    public MediaInfo c(MediaInfo mediaInfo) {
        if (h(mediaInfo)) {
            this.a = mediaInfo.a;
            this.b = mediaInfo.b;
            this.c = mediaInfo.c;
            int i = mediaInfo.d;
            int i2 = mediaInfo.b;
            if (i <= i2) {
                i = i2;
            }
            this.d = i;
            int i3 = mediaInfo.e;
            int i4 = mediaInfo.c;
            if (i3 <= i4) {
                i3 = i4;
            }
            this.e = i3;
            int i5 = mediaInfo.i;
            if (i5 <= 0) {
                i5 = this.d * i3;
            }
            this.i = i5;
            this.f = mediaInfo.f;
        } else {
            this.a = mediaInfo.a;
            this.j = mediaInfo.j;
            this.g = mediaInfo.g;
            this.h = mediaInfo.h;
            this.f = mediaInfo.f;
        }
        return this;
    }

    public final String toString() {
        if (h(this)) {
            return String.format(Locale.CHINA, "type:%s, frameSize:%dx%d, planeSize:%dx%d", gec.a[this.a], Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e));
        }
        return String.format(Locale.CHINA, "type:%s, sampleRate:%d, samples:%d, channels:%d", gec.a[this.a], Integer.valueOf(this.j), Integer.valueOf(this.g), Integer.valueOf(this.h));
    }
}
