package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class j {
    public AudioManager a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f58162b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.j.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (j.this.f58163c == null) {
                return;
            }
            if (i2 < 0) {
                j.this.f58163c.a();
            } else {
                j.this.f58163c.b();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public a f58163c;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public j(Context context) {
        this.a = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    @TargetApi(26)
    private AudioFocusRequest b() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f58162b).build();
    }

    public void a(a aVar) {
        this.f58163c = aVar;
    }

    public boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f58162b;
        if (onAudioFocusChangeListener == null || (audioManager = this.a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(b()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }
}
