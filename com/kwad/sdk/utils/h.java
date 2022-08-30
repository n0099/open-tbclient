package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes7.dex */
public final class h {
    public AudioManager adW;
    public AudioManager.OnAudioFocusChangeListener ana = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            if (h.this.dv == null) {
                return;
            }
            if (i < 0) {
                h.this.dv.bk();
            } else {
                h.this.dv.bl();
            }
        }
    };
    public a dv;

    /* loaded from: classes7.dex */
    public interface a {
        void bk();

        void bl();
    }

    public h(Context context) {
        this.adW = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest zj() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.ana).build();
    }

    public final void c(a aVar) {
        this.dv = aVar;
    }

    public final boolean zi() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.ana;
        if (onAudioFocusChangeListener != null && (audioManager = this.adW) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(zj());
            } else if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }
}
