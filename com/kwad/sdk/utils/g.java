package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f34135a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f34136b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (g.this.f34137c == null) {
                return;
            }
            if (i2 < 0) {
                g.this.f34137c.a();
            } else {
                g.this.f34137c.b();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public a f34137c;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public g(Context context) {
        this.f34135a = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    @TargetApi(26)
    private AudioFocusRequest b() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f34136b).build();
    }

    public void a(a aVar) {
        this.f34137c = aVar;
    }

    public boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f34136b;
        if (onAudioFocusChangeListener == null || (audioManager = this.f34135a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(b()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }
}
