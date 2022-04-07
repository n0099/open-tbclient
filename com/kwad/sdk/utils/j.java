package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes5.dex */
public class j {
    public AudioManager a;
    public AudioManager.OnAudioFocusChangeListener b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.j.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (j.this.c == null) {
                return;
            }
            if (i < 0) {
                j.this.c.a();
            } else {
                j.this.c.b();
            }
        }
    };
    public a c;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public j(Context context) {
        this.a = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest b() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.b).build();
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.b;
        if (onAudioFocusChangeListener == null || (audioManager = this.a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(b()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }
}
