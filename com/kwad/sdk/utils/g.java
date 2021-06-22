package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f37626a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f37627b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (g.this.f37628c == null) {
                return;
            }
            if (i2 < 0) {
                g.this.f37628c.a();
            } else {
                g.this.f37628c.b();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public a f37628c;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    public g(Context context) {
        this.f37626a = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest c() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f37627b).build();
    }

    public void a(a aVar) {
        this.f37628c = aVar;
    }

    public boolean a() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f37627b;
        if (onAudioFocusChangeListener == null || (audioManager = this.f37626a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.requestAudioFocus(c()) : 1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }

    public boolean b() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f37627b;
        if (onAudioFocusChangeListener == null || (audioManager = this.f37626a) == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == audioManager.abandonAudioFocusRequest(c()) : 1 == audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }
}
