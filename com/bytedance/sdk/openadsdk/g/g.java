package com.bytedance.sdk.openadsdk.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    public f f29085b;

    /* renamed from: c  reason: collision with root package name */
    public a f29086c;

    /* renamed from: d  reason: collision with root package name */
    public Context f29087d;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f29088e;

    /* renamed from: a  reason: collision with root package name */
    public int f29084a = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29089f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29090g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f29091h = -1;

    /* loaded from: classes5.dex */
    public static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<g> f29092a;

        public a(g gVar) {
            this.f29092a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f h2;
            int g2;
            try {
                if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    u.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.f29092a.get();
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
        this.f29087d = context;
        this.f29088e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.f29091h;
    }

    public int b() {
        return this.f29084a;
    }

    public boolean c() {
        if (this.f29090g) {
            this.f29090g = false;
            return true;
        }
        return false;
    }

    public int d() {
        try {
            if (this.f29088e != null) {
                return this.f29088e.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void e() {
        try {
            this.f29086c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            this.f29087d.registerReceiver(this.f29086c, intentFilter);
            this.f29089f = true;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f29089f) {
            try {
                this.f29087d.unregisterReceiver(this.f29086c);
                this.f29085b = null;
                this.f29089f = false;
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            if (this.f29088e != null) {
                return this.f29088e.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.f29085b;
    }

    public void a(int i) {
        this.f29091h = i;
    }

    public void b(int i) {
        this.f29084a = i;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.f29088e == null) {
            return;
        }
        int i = 0;
        if (z) {
            int g2 = g();
            if (g2 != 0) {
                this.f29084a = g2;
            }
            u.b("VolumeChangeObserver", "mute set volume to 0");
            this.f29088e.setStreamVolume(3, 0, 0);
            this.f29090g = true;
            return;
        }
        int i2 = this.f29084a;
        if (i2 == 0) {
            i2 = d() / 15;
        } else {
            if (i2 == -1) {
                if (!z2) {
                    return;
                }
                i2 = d() / 15;
            }
            u.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.f29084a);
            this.f29084a = -1;
            this.f29088e.setStreamVolume(3, i2, i);
            this.f29090g = true;
        }
        i = 1;
        u.b("VolumeChangeObserver", "not mute set volume to " + i2 + " mLastVolume=" + this.f29084a);
        this.f29084a = -1;
        this.f29088e.setStreamVolume(3, i2, i);
        this.f29090g = true;
    }

    public void a(f fVar) {
        this.f29085b = fVar;
    }
}
