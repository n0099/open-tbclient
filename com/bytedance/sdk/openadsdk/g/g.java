package com.bytedance.sdk.openadsdk.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private f f7463b;
    private a c;
    private Context d;
    private AudioManager e;

    /* renamed from: a  reason: collision with root package name */
    private int f7462a = -1;
    private boolean f = false;
    private boolean g = false;
    private int h = -1;

    public g(Context context) {
        this.d = context;
        this.e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int b() {
        return this.f7462a;
    }

    public void b(int i) {
        this.f7462a = i;
    }

    public boolean c() {
        if (this.g) {
            this.g = false;
            return true;
        }
        return false;
    }

    public int d() {
        try {
            if (this.e != null) {
                return this.e.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        int i;
        int i2 = 0;
        if (this.e != null) {
            if (z) {
                int g = g();
                if (g != 0) {
                    this.f7462a = g;
                }
                u.b("VolumeChangeObserver", "mute set volume to 0");
                this.e.setStreamVolume(3, 0, 0);
                this.g = true;
                return;
            }
            if (this.f7462a == 0) {
                i = d() / 15;
                i2 = 1;
            } else if (this.f7462a == -1) {
                if (z2) {
                    i = d() / 15;
                    i2 = 1;
                } else {
                    return;
                }
            } else {
                i = this.f7462a;
            }
            u.b("VolumeChangeObserver", "not mute set volume to " + i + " mLastVolume=" + this.f7462a);
            this.f7462a = -1;
            this.e.setStreamVolume(3, i, i2);
            this.g = true;
        }
    }

    public void a(f fVar) {
        this.f7463b = fVar;
    }

    public void e() {
        try {
            this.c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            this.d.registerReceiver(this.c, intentFilter);
            this.f = true;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f) {
            try {
                this.d.unregisterReceiver(this.c);
                this.f7463b = null;
                this.f = false;
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            if (this.e != null) {
                return this.e.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            u.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.f7463b;
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<g> f7464a;

        public a(g gVar) {
            this.f7464a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f h;
            int g;
            try {
                if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    u.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.f7464a.get();
                    if (gVar != null && (h = gVar.h()) != null && (g = gVar.g()) != gVar.a()) {
                        gVar.a(g);
                        if (g >= 0) {
                            h.c(g);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }
}
