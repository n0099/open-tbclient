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
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f43770e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f43772b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43773c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f43771a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f43774d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f43772b == null) {
                    d.this.f43772b = (AudioManager) d.b.g0.a.w0.a.c().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.f43771a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f43772b != null ? d.this.f43772b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    public static d e() {
        if (f43770e == null) {
            synchronized (d.class) {
                if (f43770e == null) {
                    f43770e = new d();
                }
            }
        }
        return f43770e;
    }

    public static void i() {
        d dVar = f43770e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f43771a.put(str, bVar);
            if (!this.f43773c) {
                h();
            }
            if (k.f45050a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f43771a.size());
            }
        }
    }

    public int f() {
        if (this.f43772b == null) {
            this.f43772b = (AudioManager) d.b.g0.a.w0.a.c().getSystemService("audio");
        }
        AudioManager audioManager = this.f43772b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f43771a.clear();
            this.f43772b = null;
            this.f43773c = false;
        }
        f43770e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.b.g0.a.w0.a.c().registerReceiver(this.f43774d, intentFilter);
        this.f43773c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f43771a.remove(str);
            if (this.f43771a.size() == 0 && this.f43773c) {
                k();
            }
            if (k.f45050a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f43771a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.b.g0.a.w0.a.c().unregisterReceiver(this.f43774d);
            this.f43773c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
