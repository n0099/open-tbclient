package org.webrtc.audioengine;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.webkit.sdk.PermissionRequest;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
class WebRtcAudioRecord {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int SAMPLE_RATE_HZ = 44100;
    private static final String TAG = "[AudioRecord]";
    private final ActivityManager activityManager;
    private final AudioManager audioManager;
    private ByteBuffer byteBuffer;
    private int channelCount;
    private final Context context;
    private final long nativeAudioRecord;
    private AudioRecord audioRecord = null;
    private AudioRecordThread audioThread = null;
    private AcousticEchoCanceler aec = null;
    private boolean useBuiltInAEC = false;
    private final Set<Long> threadIds = new HashSet();
    private int sampleRate = 0;
    private int bytesPerBuffer = 0;
    private int framesPerBuffer = 0;

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i, long j);

    private native long nativeGetTickCount();

    private static boolean runningOnJellyBeanOrHigher() {
        return Build.VERSION.SDK_INT >= 16;
    }

    private static boolean runningOnJellyBeanMR1OrHigher() {
        return Build.VERSION.SDK_INT >= 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasRecPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printCurrentThreadName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.activityManager.getRunningAppProcesses();
        doLog("Begin Print Current Thread Name=====================================");
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                doLog("Current App Process Name:" + it.next().processName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doLog("End Print Current Thread Name=======================================");
    }

    /* loaded from: classes4.dex */
    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            Process.setThreadPriority(-19);
            WebRtcAudioRecord.this.doLog("AudioRecordThread" + WebRtcAudioRecord.getThreadInfo());
            if (!WebRtcAudioRecord.this.hasRecPermission(WebRtcAudioRecord.this.context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                WebRtcAudioRecord.this.nativeDataIsRecorded(-1, WebRtcAudioRecord.this.nativeAudioRecord);
                WebRtcAudioRecord.this.doLog("AudioRecordThread has no rec permission");
                return;
            }
            try {
                WebRtcAudioRecord.this.audioRecord.startRecording();
                boolean z = WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3;
                if (!z) {
                    WebRtcAudioRecord.this.nativeDataIsRecorded(-2, WebRtcAudioRecord.this.nativeAudioRecord);
                    WebRtcAudioRecord.this.printCurrentThreadName();
                }
                System.nanoTime();
                WebRtcAudioRecord.this.nativeDataIsRecorded(-100, WebRtcAudioRecord.this.nativeAudioRecord);
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (!this.keepAlive) {
                        break;
                    }
                    try {
                        i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                    } catch (Exception e) {
                        WebRtcAudioRecord.this.doLogErr("AudioRecord.read failed: " + e.getMessage());
                        i = -1;
                    }
                    if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                        WebRtcAudioRecord.this.nativeDataIsRecorded(i, WebRtcAudioRecord.this.nativeAudioRecord);
                        z2 = false;
                        i2 = 0;
                    } else if (i == -3 && z) {
                        WebRtcAudioRecord.this.nativeDataIsRecorded(-3, WebRtcAudioRecord.this.nativeAudioRecord);
                        WebRtcAudioRecord.this.printCurrentThreadName();
                        this.keepAlive = false;
                        break;
                    } else {
                        if (!z2 && (i2 = i2 + 1) > 3) {
                            WebRtcAudioRecord.this.nativeDataIsRecorded(-4, WebRtcAudioRecord.this.nativeAudioRecord);
                            WebRtcAudioRecord.this.printCurrentThreadName();
                            z2 = true;
                        }
                        SystemClock.sleep(100L);
                    }
                }
                WebRtcAudioRecord.this.removeThreadId();
            } catch (Exception e2) {
                WebRtcAudioRecord.this.nativeDataIsRecorded(-1, WebRtcAudioRecord.this.nativeAudioRecord);
                WebRtcAudioRecord.this.printCurrentThreadName();
                WebRtcAudioRecord.this.doLogErr("AudioRecord.startRecording failed: " + e2.getMessage());
            }
        }

        public void joinThread() {
            this.keepAlive = false;
            while (isAlive()) {
                try {
                    join();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    WebRtcAudioRecord(Context context, long j) {
        this.context = context;
        this.nativeAudioRecord = j;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    private int getNativeSampleRate() {
        String property;
        if (runningOnJellyBeanMR1OrHigher() && (property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE")) != null) {
            return Integer.parseInt(property);
        }
        return 44100;
    }

    public static boolean builtInAECIsAvailable() {
        if (runningOnJellyBeanOrHigher()) {
            return AcousticEchoCanceler.isAvailable();
        }
        return false;
    }

    private boolean enableBuiltInAEC(boolean z) {
        doLog("EnableBuiltInAEC(" + z + ')');
        if (runningOnJellyBeanOrHigher()) {
            this.useBuiltInAEC = z;
            if (this.aec != null) {
                if (this.aec.setEnabled(z) != 0) {
                    doLogErr("AcousticEchoCanceler.setEnabled failed");
                    return false;
                }
                doLog("AcousticEchoCanceler.getEnabled: " + this.aec.getEnabled());
            }
            return true;
        }
        return false;
    }

    private int initRecording(int i, int i2) {
        int i3;
        if (i2 == 256) {
            this.channelCount = 2;
            i3 = 12;
        } else {
            this.channelCount = 1;
            i3 = 16;
        }
        this.bytesPerBuffer = this.channelCount * 2 * (i / 100);
        this.framesPerBuffer = i / 100;
        ByteBuffer byteBuffer = this.byteBuffer;
        this.byteBuffer = ByteBuffer.allocateDirect(this.bytesPerBuffer);
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int minBufferSize = AudioRecord.getMinBufferSize(i, i3, 2);
        try {
            if (this.audioRecord != null) {
                this.audioRecord.stop();
                this.audioRecord.release();
                this.audioRecord = null;
            }
        } catch (Exception e) {
            doLogErr("InitRecording audioRecord stop and release fail: " + e.getMessage());
        }
        int max = Math.max(this.byteBuffer.capacity(), minBufferSize * 2);
        doLog("InitRecording, sampleRate:" + i + ", bufferSizeInBytes: " + max + ", capacity: " + this.byteBuffer.capacity() + ", minBufferSize: " + minBufferSize + " ,audioSource: " + i2);
        int i4 = i2 == 256 ? 1 : i2;
        try {
            this.audioRecord = new AudioRecord(i4, i, i3, 2, max);
            if (this.audioRecord.getState() != 1) {
                doLogErr("AudioRecord can not initialized");
                return -1;
            }
            doLog("AudioRecordJava: audio format: " + this.audioRecord.getAudioFormat() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate() + ", audio source: " + i4);
            return this.framesPerBuffer;
        } catch (IllegalArgumentException e2) {
            doLogErr("AudioRecord parameter error, " + e2.getMessage());
            return -1;
        }
    }

    private boolean startRecording() {
        doLog("StartRecording");
        if (this.audioRecord == null) {
            doLogErr("start() called before init()");
            return false;
        } else if (this.audioThread != null) {
            doLogErr("start() was already called");
            return false;
        } else {
            this.audioThread = new AudioRecordThread("YY_Aud_Record_Java");
            this.audioThread.start();
            doLog("Create a Thread name:YY_Aud_Record_Java");
            return true;
        }
    }

    private boolean stopRecording() {
        doLog("StopRecording...begin");
        if (this.audioThread == null) {
            doLogErr("start() was never called, or stop() was already called");
            return false;
        }
        this.audioThread.joinThread();
        this.audioThread = null;
        if (this.aec != null) {
            this.aec.release();
            this.aec = null;
        }
        try {
            if (this.audioRecord != null) {
                this.audioRecord.stop();
                this.audioRecord.release();
                this.audioRecord = null;
            }
        } catch (Exception e) {
            doLogErr("StopRecording audioRecord stop and release fail: " + e.getMessage());
        }
        doLog("StopRecording...end");
        nativeDataIsRecorded(-6, this.nativeAudioRecord);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLog(String str) {
        AudioManagerAndroid.doLog(TAG + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLogErr(String str) {
        AudioManagerAndroid.doLog("[AudioRecord][Error]" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    private static void assertIsTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private void addThreadId() {
        this.threadIds.add(Long.valueOf(Thread.currentThread().getId()));
        doLog("addThreadId threadIds: " + this.threadIds + " (#threads=" + this.threadIds.size() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeThreadId() {
        this.threadIds.remove(Long.valueOf(Thread.currentThread().getId()));
        doLog("removeThreadId threadIds: " + this.threadIds + " (#threads=" + this.threadIds.size() + ")");
    }
}
