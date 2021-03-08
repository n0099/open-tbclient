package org.webrtc.audioengine;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class WebRtcAudioTrack {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int SAMPLE_RATE_HZ = 44100;
    private static final String TAG = "WebRtcAudioTrack";
    private final AudioManager audioManager;
    private ByteBuffer byteBuffer;
    private final Context context;
    private AudioRoutingChangedListener mAudioRoutingChangedListener;
    private final long nativeAudioTrack;
    private AudioTrack audioTrack = null;
    private AudioTrackThread audioThread = null;
    private int bufferedPlaySamples = 0;
    private int sampleRate = 44100;
    private int channel = 2;
    private int playPosition = 0;
    private byte[] mMuteData = null;
    private int mMinBufSize = 0;
    private boolean mIsAlreadyMute = false;
    final String logTag = "AudioTrackJava: ";

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGetPlayoutData(int i, long j, int i2);

    private native long nativeGetTickCount();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetPlayPos(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetPlayUnderRunCount(long j, int i);

    private native void nativeSetTrackBufferSizeMs(int i);

    /* loaded from: classes6.dex */
    private class AudioTrackThread extends Thread {
        private volatile boolean keepAlive;

        public AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            WebRtcAudioTrack.this.doLog("AudioTrackJava: Thread" + WebRtcAudioTrack.getThreadInfo());
            try {
                WebRtcAudioTrack.this.audioTrack.play();
                WebRtcAudioTrack.assertTrue(WebRtcAudioTrack.this.audioTrack.getPlayState() == 3);
                int capacity = WebRtcAudioTrack.this.byteBuffer.capacity();
                while (this.keepAlive) {
                    WebRtcAudioTrack.this.nativeGetPlayoutData(capacity, WebRtcAudioTrack.this.nativeAudioTrack, WebRtcAudioTrack.this.bufferedPlaySamples);
                    WebRtcAudioTrack.assertTrue(capacity <= WebRtcAudioTrack.this.byteBuffer.remaining());
                    if (WebRtcAudioTrack.this.mIsAlreadyMute || WebRtcAudioTrack.this.audioTrack.getPlaybackHeadPosition() >= WebRtcAudioTrack.this.mMinBufSize) {
                        WebRtcAudioTrack.this.mIsAlreadyMute = true;
                    } else {
                        System.arraycopy(WebRtcAudioTrack.this.mMuteData, 0, WebRtcAudioTrack.this.byteBuffer.array(), 0, WebRtcAudioTrack.this.byteBuffer.array().length);
                    }
                    int writeOnLollipop = WebRtcAudioTrack.runningOnLollipopOrHigher() ? writeOnLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, capacity) : writePreLollipop(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, capacity);
                    WebRtcAudioTrack.this.bufferedPlaySamples += writeOnLollipop >> 1;
                    int playbackHeadPosition = WebRtcAudioTrack.this.audioTrack.getPlaybackHeadPosition() * WebRtcAudioTrack.this.channel;
                    if (playbackHeadPosition < WebRtcAudioTrack.this.playPosition) {
                        WebRtcAudioTrack.this.playPosition = 0;
                    }
                    WebRtcAudioTrack.this.bufferedPlaySamples -= playbackHeadPosition - WebRtcAudioTrack.this.playPosition;
                    WebRtcAudioTrack.this.playPosition = playbackHeadPosition;
                    WebRtcAudioTrack.this.nativeSetPlayPos(WebRtcAudioTrack.this.nativeAudioTrack, WebRtcAudioTrack.this.playPosition);
                    if (Build.VERSION.SDK_INT >= 24) {
                        WebRtcAudioTrack.this.nativeSetPlayUnderRunCount(WebRtcAudioTrack.this.nativeAudioTrack, WebRtcAudioTrack.this.audioTrack.getUnderrunCount());
                    }
                    if (writeOnLollipop != capacity) {
                        WebRtcAudioTrack.this.doLogErr("AudioTrack.write failed: " + writeOnLollipop);
                        if (writeOnLollipop == -3) {
                            this.keepAlive = false;
                        }
                    }
                    WebRtcAudioTrack.this.byteBuffer.rewind();
                }
                try {
                    WebRtcAudioTrack.this.audioTrack.stop();
                } catch (Exception e) {
                    WebRtcAudioTrack.this.doLogErr("AudioTrack.stop failed: " + e.getMessage());
                }
                WebRtcAudioTrack.assertTrue(WebRtcAudioTrack.this.audioTrack.getPlayState() == 1);
                WebRtcAudioTrack.this.audioTrack.flush();
                WebRtcAudioTrack.this.nativeSetPlayPos(WebRtcAudioTrack.this.nativeAudioTrack, 0);
            } catch (Exception e2) {
                WebRtcAudioTrack.this.doLogErr("AudioTrack.play failed: " + e2.getMessage());
            }
        }

        @TargetApi(21)
        private int writeOnLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer, i, 0);
        }

        private int writePreLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        }

        public void joinThread() {
            this.keepAlive = false;
            while (isAlive()) {
                for (int i = 0; i < 3; i++) {
                    try {
                        join(2000L);
                        if (!isAlive()) {
                            break;
                        }
                        WebRtcAudioTrack.this.doLog("AudioTrackThread " + getId() + " may block " + i + ", call stack :");
                        StackTraceElement[] stackTrace = getStackTrace();
                        if (stackTrace != null) {
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                WebRtcAudioTrack.this.doLog(stackTraceElement.toString());
                            }
                        }
                    } catch (InterruptedException e) {
                    }
                }
                if (isAlive()) {
                    join();
                }
            }
            WebRtcAudioTrack.this.doLog("AudioTrack thread exist " + getId());
        }
    }

    WebRtcAudioTrack(Context context, long j) {
        this.context = context;
        this.nativeAudioTrack = j;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        if (isSupportRoutingChangedListener()) {
            this.mAudioRoutingChangedListener = new AudioRoutingChangedListener();
        }
    }

    private boolean initPlayout(int i, int i2, int i3) {
        int i4;
        doLog("WebRtcAudioTrack:initPlayout(sampleRate=" + i + ", channels=" + i2 + ", streamType=" + i3 + ")");
        int i5 = 4;
        if (i2 == 2) {
            i5 = 12;
        }
        int i6 = i2 * 2;
        ByteBuffer byteBuffer = this.byteBuffer;
        this.byteBuffer = ByteBuffer.allocateDirect((i / 100) * i6);
        this.mMuteData = new byte[this.byteBuffer.array().length];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
        this.bufferedPlaySamples = 0;
        this.channel = i2;
        this.playPosition = 0;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i5, 2);
        int i7 = i6 * (i / 100);
        this.mMinBufSize = minBufferSize;
        if (minBufferSize % i7 != 0) {
            i4 = ((minBufferSize / i7) + 1) * i7;
            if (i4 < i7 * 10) {
                i4 = i7 * 10;
            }
        } else {
            i4 = minBufferSize;
        }
        try {
            this.audioTrack = new AudioTrack(i3, i, i5, 2, i4, 1);
            int i8 = (int) ((((1000.0d * i4) / 2.0d) / this.channel) / i);
            doLog("AudioTrackJava: getMinBufferSize: " + minBufferSize + ", playBufSize: " + i4 + ", bufferMs: " + i8 + ", streamType: " + i3);
            nativeSetTrackBufferSizeMs(i8);
            if (this.audioTrack.getState() != 1) {
                doLogErr("Initialization of audio track failed >> " + this.audioTrack.getState());
                this.audioTrack.release();
                this.audioTrack = null;
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            doLogErr(e.getMessage());
            return false;
        }
    }

    private boolean startPlayout() {
        if (this.audioTrack != null) {
            doLog("startPlayout");
            assertTrue(this.audioThread == null);
            if (this.audioTrack.getState() != 1) {
                doLogErr("Audio track is not successfully initialized >> " + this.audioTrack.getState());
                this.audioTrack.release();
                this.audioTrack = null;
                return false;
            }
            this.audioThread = new AudioTrackThread("YY_Aud_Track_Java");
            this.audioThread.start();
            if (isSupportRoutingChangedListener()) {
                this.audioTrack.addOnRoutingChangedListener(this.mAudioRoutingChangedListener, (Handler) null);
            }
            return true;
        }
        return false;
    }

    private boolean stopPlayout() {
        if (this.audioTrack != null) {
            doLog("stopPlayout...begin");
            assertTrue(this.audioThread != null);
            this.audioThread.joinThread();
            this.audioThread = null;
            if (Build.VERSION.SDK_INT >= 24) {
                nativeSetPlayUnderRunCount(this.nativeAudioTrack, 0);
            }
            if (this.audioTrack != null) {
                if (isSupportRoutingChangedListener()) {
                    this.audioTrack.removeOnRoutingChangedListener(this.mAudioRoutingChangedListener);
                }
                this.audioTrack.release();
                this.audioTrack = null;
            }
            doLog("stopPlayout...end");
            this.mIsAlreadyMute = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static boolean runningOnLollipopOrHigher() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLog(String str) {
        AudioManagerAndroid.doLog("AudioTrackJava: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLogErr(String str) {
        AudioManagerAndroid.doLog("AudioTrackJava: [Error]" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    private static boolean runningOnJellyBeanOrHigher() {
        return Build.VERSION.SDK_INT >= 16;
    }

    private static boolean runningOnJellyBeanMR1OrHigher() {
        return Build.VERSION.SDK_INT >= 17;
    }

    private int getNativeSampleRate() {
        String property;
        if (runningOnJellyBeanMR1OrHigher() && (property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) != null) {
            return Integer.parseInt(property);
        }
        return 44100;
    }

    static String modeToString(int i) {
        switch (i) {
            case 0:
                return "MODE_NORMAL";
            case 1:
                return "MODE_RINGTONE";
            case 2:
                return "MODE_IN_CALL";
            case 3:
                return "MODE_IN_COMMUNICATION";
            default:
                return "MODE_INVALID";
        }
    }

    private boolean isSupportRoutingChangedListener() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
