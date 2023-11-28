package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes10.dex */
public final class h {
    public AudioManager aAs;
    public AudioManager.OnAudioFocusChangeListener aMV = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (h.this.hq == null) {
                return;
            }
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        h.this.hq.onAudioBeOccupied();
                    } else {
                        h.this.hq.onAudioBeReleased();
                    }
                }
            });
        }
    };
    public a hq;

    /* loaded from: classes10.dex */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.aAs = (AudioManager) context.getSystemService("audio");
    }

    public final void c(a aVar) {
        this.hq = aVar;
    }

    @TargetApi(26)
    private AudioFocusRequest JE() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.aMV).build();
    }

    public final boolean JD() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aMV;
        if (onAudioFocusChangeListener != null && (audioManager = this.aAs) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (1 != audioManager.requestAudioFocus(JE())) {
                    return false;
                }
                return true;
            } else if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }
}
