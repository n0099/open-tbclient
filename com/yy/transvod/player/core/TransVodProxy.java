package com.yy.transvod.player.core;

import android.content.Context;
import android.os.Build;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.eic;
import com.baidu.tieba.mic;
import com.baidu.tieba.uhc;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.yy.transvod.player.common.AudioSendStamp;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes2.dex */
public class TransVodProxy {
    public AtomicInteger a;
    public boolean b;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public static native void nativeClassInit();

    private native String nativeGetRedirectUrl();

    public static native String nativeGetVersion();

    private native void nativeRelease();

    private native void nativeSetup(String str, String str2, String str3, int i, String str4);

    private native void native_appInbackground(boolean z);

    private native void native_audioFocusChange(boolean z);

    private native void native_error(int i);

    public static native long native_getTickCount();

    public static native void native_mockCrash();

    private native void native_networkChanged(int i);

    private native void native_pause();

    private native void native_pausePlayWithTrack(boolean z);

    private native void native_play(String str, int i, int i2, int i3, int i4, boolean z, boolean z2, long j, TreeMap<String, String> treeMap);

    private native void native_report(MediaSample mediaSample);

    private native void native_reportAudioSendStamp(AudioSendStamp[] audioSendStampArr, int i);

    private native void native_report_array(MediaSample[] mediaSampleArr);

    private native void native_report_array_clear();

    private native void native_resume();

    private native void native_resumePlayWithTrack(boolean z);

    private native void native_seekTo(float f);

    private native void native_setCacheTime(long j, long j2, long j3);

    private native void native_setDataSource(String str, int i);

    private native void native_setDataSourceAndPrepare(String str, int i, int i2, int i3, int i4, boolean z, boolean z2, long j, TreeMap<String, String> treeMap);

    private native void native_setNumberOfLoops(int i);

    private native void native_stop(boolean z);

    private native void native_updateAVDelta(long j, long j2);

    private native void native_updatePcdnUrls(int i, String str, String[] strArr);

    public TransVodProxy(Context context, int i, uhc uhcVar) {
        new WeakReference(null);
        new WeakReference(null);
        this.a = new AtomicInteger(1);
        this.b = false;
        String str = uhcVar.a;
        nativeSetup(Build.MANUFACTURER + "_" + Build.MODEL.replace(WebvttCueParser.CHAR_SPACE, SignatureImpl.SEP), String.format("%s-%s", Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)), DebugActiveUploadResult.SOURCE, i, str);
    }

    public void x(int i, String str, String[] strArr) {
        if (this.b) {
            TLog.g(this, "TransVodProxy internalUpdatePcdnUrls is already quit");
        } else if (this.a.get() == 9) {
            TLog.g(this, "TransVodProxy internalUpdatePcdnUrls state invalid");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append("###");
                sb.append(str2);
            }
            native_updatePcdnUrls(i, str, strArr);
            TLog.g(this, "update pcdn urls " + sb.toString() + " manu " + str);
        }
    }

    public static void e() {
        native_mockCrash();
    }

    public String d() {
        return nativeGetRedirectUrl();
    }

    public void h() {
        native_pause();
    }

    public void l() {
        TLog.g(this, "transVodProxy release");
        nativeRelease();
        this.b = true;
    }

    public void n() {
        native_resume();
    }

    public void a(boolean z) {
        native_appInbackground(z);
    }

    public void b(boolean z) {
        native_audioFocusChange(z);
    }

    public void c(int i) {
        native_error(i);
    }

    public void f(int i) {
        native_networkChanged(i);
    }

    public void g(ArrayList<AudioSendStamp> arrayList) {
        if (this.a.get() == 6 && !arrayList.isEmpty()) {
            int size = arrayList.size();
            AudioSendStamp[] audioSendStampArr = new AudioSendStamp[size];
            for (int i = 0; i < arrayList.size(); i++) {
                audioSendStampArr[i] = arrayList.get(i);
            }
            native_reportAudioSendStamp(audioSendStampArr, size);
        }
    }

    public void i(boolean z) {
        native_pausePlayWithTrack(z);
    }

    public void k(a aVar) {
        new WeakReference(aVar);
    }

    public void m(MediaSample[] mediaSampleArr) {
        if (this.a.get() == 6) {
            native_report_array(mediaSampleArr);
        }
    }

    public void o(boolean z) {
        native_resumePlayWithTrack(z);
    }

    public void p(float f) {
        native_seekTo(f);
    }

    public void t(mic micVar) {
        new WeakReference(micVar);
    }

    public void u(int i) {
        native_setNumberOfLoops(i);
    }

    public void v(boolean z) {
        this.a.set(1);
        native_stop(z);
    }

    public void j(String str, int i, int i2, int i3, int i4, boolean z, boolean z2, long j, eic eicVar) {
        if (this.b) {
            TLog.g(this, "TransVodProxy play is already quit");
            return;
        }
        this.a.set(6);
        native_play(str, i, i2, i3, i4, z, z2, j, eicVar.a);
    }

    public void q(long j, long j2, long j3) {
        native_setCacheTime(j, j2, j3);
    }

    public void r(String str, int i) {
        if (this.b) {
            TLog.g(this, "TransVodProxy setDataSource is already quit");
        } else if (this.a.get() == 9) {
            TLog.g(this, "TransVodProxy setDataSource state invalid");
        } else {
            native_setDataSource(str, i);
        }
    }

    public void w(long j, long j2) {
        if (this.a.get() == 6) {
            native_updateAVDelta(j, j2);
        }
    }

    public void s(String str, int i, int i2, int i3, int i4, boolean z, boolean z2, long j, eic eicVar) {
        if (this.b) {
            TLog.g(this, "TransVodProxy setDataSourceAndPrepare is already quit");
        } else if (this.a.get() == 9) {
            TLog.g(this, "TransVodProxy setDataSourceAndPrepare state invalid");
        } else {
            this.a.set(2);
            native_setDataSourceAndPrepare(str, i, i2, i3, i4, z, z2, j, eicVar.a);
        }
    }
}
