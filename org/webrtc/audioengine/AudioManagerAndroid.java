package org.webrtc.audioengine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import com.kwai.video.player.misc.IMediaFormat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class AudioManagerAndroid implements AppBackgroundMonitorListener, AudioRoutingListener, VolumeChangeListener {
    private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLING_RATE = 44100;
    private static final String TAG = "[AudioManagerAndroid]";
    private static String mAppCachePath = "";
    private int mAudioLowLatencyOutputFrameSize;
    private boolean mAudioLowLatencySupported;
    private final AudioManager mAudioManager;
    private AudioRoutingController mAudioRoutingController;
    private final Context mContext;
    private int mNativeOutputSampleRate;
    private AppBackgroundMonitor mNotifyAppBackground;
    private VolumeChangeReceiver mVolumeBroadcastReceiver;
    private boolean initialized = false;
    private Boolean mShouldNotify = false;

    private static native void nativeLogDebugInfo(String str);

    private native void nativeNotifyAppBackground(boolean z);

    private native void nativeNotifyAudioRouteChanged(int i);

    private native void nativeNotifyBluetoothPlug(int i);

    private native void nativeNotifyBluetoothScoInterrupt(int i);

    private native void nativeNotifyHeadsetPlug(int i);

    private native void nativeNotifyPhoneCallReceive(int i);

    private native void nativeNotifySystemVolumeChange(int i);

    private AudioManagerAndroid(Context context) {
        this.mContext = context;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.mAudioManager = audioManager;
        this.mNativeOutputSampleRate = 44100;
        this.mAudioLowLatencyOutputFrameSize = 256;
        if (Build.VERSION.SDK_INT >= 17) {
            String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            if (property != null) {
                this.mNativeOutputSampleRate = Integer.parseInt(property);
            }
            String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            if (property2 != null) {
                this.mAudioLowLatencyOutputFrameSize = Integer.parseInt(property2);
            }
        }
        try {
            this.mAudioLowLatencySupported = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        } catch (RuntimeException e) {
            this.mAudioLowLatencySupported = false;
        }
        try {
            mAppCachePath = this.mContext.getExternalCacheDir().getPath();
        } catch (Exception e2) {
            doLog("[AudioManagerAndroid]getExternalCacheDir failed. exception: " + e2.getMessage());
        }
        this.mAudioRoutingController = new AudioRoutingController(this.mContext, this);
        this.mVolumeBroadcastReceiver = new VolumeChangeReceiver(this.mContext, this);
        this.mNotifyAppBackground = new AppBackgroundMonitor(this.mContext, this);
    }

    private void init(Context context) {
        if (!this.initialized) {
            doLog("[AudioManagerAndroid]audio mode is: " + this.mAudioManager.getMode());
            this.initialized = true;
        }
    }

    private void setNotify(int i) {
        if (i == 1) {
            this.mAudioRoutingController.init();
            this.mVolumeBroadcastReceiver.init();
            this.mNotifyAppBackground.init();
            synchronized (this.mShouldNotify) {
                this.mShouldNotify = true;
            }
            return;
        }
        this.mAudioRoutingController.uninit();
        this.mVolumeBroadcastReceiver.uninit();
        this.mNotifyAppBackground.uninit();
        synchronized (this.mShouldNotify) {
            this.mShouldNotify = false;
        }
    }

    private int getNativeOutputSampleRate() {
        return this.mNativeOutputSampleRate;
    }

    private boolean isAudioLowLatencySupported() {
        return this.mAudioLowLatencySupported;
    }

    private int getAudioLowLatencyOutputFrameSize() {
        return this.mAudioLowLatencyOutputFrameSize;
    }

    private static int getMode(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getMode();
        } catch (Exception e) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private static int getMaxDeviceVolume(Context context, int i) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(i);
        } catch (Exception e) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private static int getCurDeviceVolume(Context context, int i) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamVolume(i);
        } catch (Exception e) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private void setSpeakerphoneOn(Context context, boolean z) {
        if (this.mAudioRoutingController != null) {
            this.mAudioRoutingController.setSpeakerphoneOn(z);
        }
    }

    private int queryAudioOutputRouting() {
        int i = -1;
        if (this.mAudioRoutingController != null) {
            i = this.mAudioRoutingController.queryAudioOutputRouting();
        }
        doLog("[AudioManagerAndroid]queryAudioOutputRouting: " + i);
        return i;
    }

    private static int isSpeakerphoneOn(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).isSpeakerphoneOn() ? 1 : 0;
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]isSpeakerphoneOn error, exception: " + e.getMessage());
            return 0;
        }
    }

    private static int isHeadsetPlugin(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn() ? 1 : 0;
    }

    private static void setMode(final Context context, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AsyncTask.execute(new Runnable() { // from class: org.webrtc.audioengine.AudioManagerAndroid.1
                @Override // java.lang.Runnable
                public void run() {
                    AudioManagerAndroid.setModeInner(context, i);
                }
            });
        } else {
            setModeInner(context, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setModeInner(Context context, int i) {
        try {
            ((AudioManager) context.getSystemService("audio")).setMode(i);
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]setMode failed: " + e.getMessage().toString());
        }
    }

    private void startOrStopBluetoothSco(Context context, boolean z) {
        if (this.mAudioRoutingController != null) {
            this.mAudioRoutingController.startOrStopBluetoothSco(z);
        }
    }

    public static void doLog(String str) {
        nativeLogDebugInfo(str);
    }

    private static boolean isMultiAudioTrackFile(String str) {
        boolean z;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i = 0;
            for (int i2 = 0; i2 < trackCount; i2++) {
                if (mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME).contains("audio/")) {
                    i++;
                }
            }
            z = i > 1;
            try {
                mediaExtractor.release();
            } catch (Exception e) {
                e = e;
                doLog("[AudioManagerAndroid]isMultiAudioTrackFile exception: " + e.getMessage());
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        return z;
    }

    private static boolean isSupportHuaWeiSystemKaraoke() {
        boolean z = false;
        try {
            String emui = getEMUI();
            if (emui != null) {
                doLog("[AudioManagerAndroid]emuiStr: " + emui);
                if (Integer.parseInt(emui.substring(10, emui.indexOf("."))) >= 10) {
                    z = true;
                }
            }
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]isSupportHuaWeiSystemKaraoke exception: " + e.getMessage());
        }
        doLog("[AudioManagerAndroid]isSupportHuaWeiSystemKaraoke: " + z);
        return z;
    }

    @SuppressLint({"PrivateApi"})
    private static String getEMUI() {
        String str;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]getEMUI exception: " + e.getMessage());
            str = null;
        }
        return str;
    }

    private static boolean isSupportVivoSystemKaraoke(Context context) {
        boolean z;
        StringTokenizer stringTokenizer;
        try {
            stringTokenizer = new StringTokenizer(((AudioManager) context.getSystemService("audio")).getParameters("vivo_ktv_mic_type"), "=");
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]isSupportVivoSystemKaraoke exception: " + e.getMessage());
        }
        if (stringTokenizer.countTokens() != 2) {
            z = false;
        } else {
            if (stringTokenizer.nextToken().equals("vivo_ktv_mic_type")) {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                if (parseInt == 1 || parseInt == 0) {
                    z = true;
                }
            }
            z = false;
        }
        doLog("[AudioManagerAndroid]isSupportVivoSystemKaraoke: " + z);
        return z;
    }

    public static boolean setThreadPriorityAudio(int i) {
        if (Build.VERSION.SDK_INT == 16 && (Build.BRAND.toLowerCase() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.MODEL.toLowerCase()).equals("samsung-gt-s6818")) {
            doLog("setThreadPriorityAudio " + i);
            Process.setThreadPriority(i, -16);
            return true;
        }
        return false;
    }

    private static int getAndroidOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    private static byte[] getSystemProperty(byte[] bArr) {
        byte[] bytes;
        try {
            if (new String(bArr).equals("ro.product.cpu.abilist")) {
                if (Build.VERSION.SDK_INT >= 21) {
                    bytes = Build.SUPPORTED_ABIS[0].getBytes();
                } else {
                    bytes = Build.CPU_ABI.getBytes();
                }
            } else {
                String property = System.getProperty(new String(bArr));
                if (property == null) {
                    doLog("[AudioManagerAndroid]getSystemProperty " + bArr + " failed.");
                    bytes = " ".getBytes();
                } else {
                    bytes = property.getBytes();
                }
            }
            return bytes;
        } catch (Exception e) {
            doLog("[AudioManagerAndroid]getSystemProperty error, ex: " + e.getMessage());
            return "".getBytes();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] getAssetsFileData(Context context, String str) {
        Throwable th;
        int i;
        int i2;
        ByteBuffer byteBuffer;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (str.isEmpty()) {
                return null;
            }
            try {
                InputStream open = context.getAssets().open(str);
                bufferedInputStream = new BufferedInputStream(open);
                try {
                    i2 = open.available();
                    try {
                        byteBuffer = ByteBuffer.allocateDirect(i2);
                        try {
                            byteBuffer.rewind();
                            byte[] bArr = new byte[1024000];
                            i = 0;
                            while (i2 > i) {
                                try {
                                    int read = bufferedInputStream.read(bArr);
                                    byteBuffer.put(bArr, 0, read);
                                    i += read;
                                } catch (IOException e) {
                                    e = e;
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e2) {
                                            doLog("GetAssetsFile: bufferedInputStream close failed");
                                        }
                                    }
                                    if (i2 != i) {
                                    }
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    doLog("GetAssetsFile: bufferedInputStream close failed");
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            i = 0;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        i = 0;
                        byteBuffer = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    i = 0;
                    i2 = 0;
                    byteBuffer = null;
                }
            } catch (IOException e7) {
                e = e7;
                i = 0;
                i2 = 0;
                byteBuffer = null;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e8) {
                        doLog("GetAssetsFile: bufferedInputStream close failed");
                    }
                }
                throw th;
            }
            if (i2 != i) {
                byte[] bArr2 = new byte[i2];
                byteBuffer.rewind();
                byteBuffer.get(bArr2);
                return bArr2;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static byte[] getExternalCacheDir() {
        return mAppCachePath.getBytes();
    }

    @Override // org.webrtc.audioengine.AudioRoutingListener
    public void onAudioRoutingChanged(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyAudioRouteChanged(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.AudioRoutingListener
    public void onBluetoothState(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyBluetoothPlug(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.AudioRoutingListener
    public void onBluetoothScoState(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyBluetoothScoInterrupt(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.AudioRoutingListener
    public void onHeadsetState(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyBluetoothScoInterrupt(i);
                nativeNotifyHeadsetPlug(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.AudioRoutingListener
    public void onPhoneCallState(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyPhoneCallReceive(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.VolumeChangeListener
    public void onSystemVolumeChange(int i) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifySystemVolumeChange(i);
            }
        }
    }

    @Override // org.webrtc.audioengine.AppBackgroundMonitorListener
    public void notifyAppBackground(boolean z) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyAppBackground(z);
            }
        }
    }
}
