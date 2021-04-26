package com.bytedance.sdk.openadsdk.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public f f29986b;

    /* renamed from: c  reason: collision with root package name */
    public a f29987c;

    /* renamed from: d  reason: collision with root package name */
    public Context f29988d;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f29989e;

    /* renamed from: a  reason: collision with root package name */
    public int f29985a = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29990f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29991g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f29992h = -1;

    /* loaded from: classes5.dex */
    public static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<g> f29993a;

        public a(g gVar) {
            this.f29993a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f h2;
            int g2;
            try {
                if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    u.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.f29993a.get();
                    if (gVar == null || (h2 = gVar.h()) == null || (g2 = gVar.g()) == gVar.a()) {
                        return;
                    }
                    gVar.a(g2);
                    if (g2 >= 0) {
                        h2.c(g2);
                    }
                }
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }

    public g(Context context) {
        this.f29988d = context;
        this.f29989e = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public int a() {
        return this.f29992h;
    }

    public int b() {
        return this.f29985a;
    }

    public boolean c() {
        if (this.f29991g) {
            this.f29991g = false;
            return true;
        }
        return false;
    }

    public int d() {
        try {
            if (this.f29989e != null) {
                return this.f29989e.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void e() {
        try {
            this.f29987c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            this.f29988d.registerReceiver(this.f29987c, intentFilter);
            this.f29990f = true;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f29990f) {
            try {
                this.f29988d.unregisterReceiver(this.f29987c);
                this.f29986b = null;
                this.f29990f = false;
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            if (this.f29989e != null) {
                return this.f29989e.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.f29986b;
    }

    public void a(int i2) {
        this.f29992h = i2;
    }

    public void b(int i2) {
        this.f29985a = i2;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.f29989e == null) {
            return;
        }
        int i2 = 0;
        if (z) {
            int g2 = g();
            if (g2 != 0) {
                this.f29985a = g2;
            }
            u.b("VolumeChangeObserver", "mute set volume to 0");
            this.f29989e.setStreamVolume(3, 0, 0);
            this.f29991g = true;
            return;
        }
        int i3 = this.f29985a;
        if (i3 == 0) {
            i3 = d() / 15;
        } else {
            if (i3 == -1) {
                if (!z2) {
                    return;
                }
                i3 = d() / 15;
            }
            u.b("VolumeChangeObserver", "not mute set volume to " + i3 + " mLastVolume=" + this.f29985a);
            this.f29985a = -1;
            this.f29989e.setStreamVolume(3, i3, i2);
            this.f29991g = true;
        }
        i2 = 1;
        u.b("VolumeChangeObserver", "not mute set volume to " + i3 + " mLastVolume=" + this.f29985a);
        this.f29985a = -1;
        this.f29989e.setStreamVolume(3, i3, i2);
        this.f29991g = true;
    }

    public void a(f fVar) {
        this.f29986b = fVar;
    }
}
