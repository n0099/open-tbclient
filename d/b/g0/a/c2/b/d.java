package d.b.g0.a.c2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import d.b.g0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f43771e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f43773b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43774c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f43772a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f43775d = new a();

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f43773b == null) {
                    d.this.f43773b = (AudioManager) d.b.g0.a.w0.a.c().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.f43772a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f43773b != null ? d.this.f43773b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);
    }

    public static d e() {
        if (f43771e == null) {
            synchronized (d.class) {
                if (f43771e == null) {
                    f43771e = new d();
                }
            }
        }
        return f43771e;
    }

    public static void i() {
        d dVar = f43771e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f43772a.put(str, bVar);
            if (!this.f43774c) {
                h();
            }
            if (k.f45051a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f43772a.size());
            }
        }
    }

    public int f() {
        if (this.f43773b == null) {
            this.f43773b = (AudioManager) d.b.g0.a.w0.a.c().getSystemService("audio");
        }
        AudioManager audioManager = this.f43773b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f43772a.clear();
            this.f43773b = null;
            this.f43774c = false;
        }
        f43771e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.b.g0.a.w0.a.c().registerReceiver(this.f43775d, intentFilter);
        this.f43774c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f43772a.remove(str);
            if (this.f43772a.size() == 0 && this.f43774c) {
                k();
            }
            if (k.f45051a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f43772a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.b.g0.a.w0.a.c().unregisterReceiver(this.f43775d);
            this.f43774c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
