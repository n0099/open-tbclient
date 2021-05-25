package d.a.l0.a.n2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import d.a.l0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f43787e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f43789b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43790c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f43788a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f43791d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f43789b == null) {
                    d.this.f43789b = (AudioManager) d.a.l0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : d.this.f43788a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f43789b != null ? d.this.f43789b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public static d e() {
        if (f43787e == null) {
            synchronized (d.class) {
                if (f43787e == null) {
                    f43787e = new d();
                }
            }
        }
        return f43787e;
    }

    public static void i() {
        d dVar = f43787e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f43788a.put(str, bVar);
            if (!this.f43790c) {
                h();
            }
            if (k.f43199a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f43788a.size());
            }
        }
    }

    public int f() {
        if (this.f43789b == null) {
            this.f43789b = (AudioManager) d.a.l0.a.c1.a.b().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        AudioManager audioManager = this.f43789b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f43788a.clear();
            this.f43789b = null;
            this.f43790c = false;
        }
        f43787e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.a.l0.a.c1.a.b().registerReceiver(this.f43791d, intentFilter);
        this.f43790c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f43788a.remove(str);
            if (this.f43788a.size() == 0 && this.f43790c) {
                k();
            }
            if (k.f43199a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f43788a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.a.l0.a.c1.a.b().unregisterReceiver(this.f43791d);
            this.f43790c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
