package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes5.dex */
public final class h {
    public AudioManager a;
    public AudioManager.OnAudioFocusChangeListener b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            if (h.this.c == null) {
                return;
            }
            if (i < 0) {
                h.this.c.a();
            } else {
                h.this.c.b();
            }
        }
    };
    public a c;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public h(Context context) {
        this.a = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest b() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.b).build();
    }

    public final void a(a aVar) {
        this.c = aVar;
    }

    public final boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.b;
        if (onAudioFocusChangeListener != null && (audioManager = this.a) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(b());
            } else if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }
}
