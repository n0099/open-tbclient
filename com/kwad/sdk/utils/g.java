package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f37060a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f37061b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (g.this.f37062c == null) {
                return;
            }
            if (i < 0) {
                g.this.f37062c.a();
            } else {
                g.this.f37062c.b();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public a f37062c;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public g(Context context) {
        this.f37060a = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest c() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f37061b).build();
    }

    public void a(a aVar) {
        this.f37062c = aVar;
    }

    public boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f37061b;
        if (onAudioFocusChangeListener == null || (audioManager = this.f37060a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(c()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }

    public boolean b() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f37061b;
        if (onAudioFocusChangeListener == null || (audioManager = this.f37060a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.abandonAudioFocusRequest(c()) : 1 == audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }
}
