package com.thunder.livesdk.audio;

import com.thunder.livesdk.ExternalAudioSource;
import com.thunder.livesdk.ThunderAudioCapture;
import com.thunder.livesdk.ThunderDefaultMic;
import com.thunder.livesdk.ThunderPublisher;
/* loaded from: classes4.dex */
public class ThunderAudioCaptureProxyImp {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void pushCaptureData(long j, long j2, byte[] bArr, long j3);

    static boolean isDefaultMic(Object obj) {
        return obj instanceof ThunderDefaultMic;
    }

    static boolean isExternalSource(Object obj) {
        return obj instanceof ExternalAudioSource;
    }

    static boolean isNeedMicData(Object obj) {
        return isDefaultMic(obj) && ((ThunderDefaultMic) obj).getMicDataCallback() != null;
    }

    static void startCapture(final long j, final long j2, Object obj) {
        ((ThunderAudioCapture) obj).startCapture(new ThunderPublisher.IAudioPublisher() { // from class: com.thunder.livesdk.audio.ThunderAudioCaptureProxyImp.1
            @Override // com.thunder.livesdk.ThunderPublisher.IAudioPublisher
            public void pushAudioData(byte[] bArr, long j3) {
                ThunderAudioCaptureProxyImp.pushCaptureData(j, j2, bArr, j3);
            }
        });
    }

    static void stopCapture(Object obj) {
        ((ThunderAudioCapture) obj).stopCapture();
    }

    static int getSampleRate(Object obj) {
        return ((ThunderAudioCapture) obj).getSampleRate();
    }

    static int getChannels(Object obj) {
        return ((ThunderAudioCapture) obj).getChannels();
    }

    static int getBitDepth(Object obj) {
        return ((ThunderAudioCapture) obj).getBitDepth();
    }

    static void onCaptureData(Object obj, byte[] bArr, int i, boolean z) {
        ThunderDefaultMic.IYYLiveDefaultMicDataCallback micDataCallback;
        if (isDefaultMic(obj) && (micDataCallback = ((ThunderDefaultMic) obj).getMicDataCallback()) != null) {
            micDataCallback.onAudioDataCallback(bArr, z);
        }
    }
}
