package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private AudioManager f10818a;

    /* renamed from: b  reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f10819b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (g.this.c == null) {
                return;
            }
            if (i < 0) {
                g.this.c.a();
            } else {
                g.this.c.b();
            }
        }
    };
    private a c;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public g(Context context) {
        this.f10818a = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest c() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.f10819b).build();
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean a() {
        if (this.f10819b == null || this.f10818a == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == this.f10818a.requestAudioFocus(c()) : 1 == this.f10818a.requestAudioFocus(this.f10819b, 3, 2);
    }

    public boolean b() {
        if (this.f10819b == null || this.f10818a == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 26 ? 1 == this.f10818a.abandonAudioFocusRequest(c()) : 1 == this.f10818a.abandonAudioFocus(this.f10819b);
    }
}
