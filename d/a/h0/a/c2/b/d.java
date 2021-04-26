package d.a.h0.a.c2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import d.a.h0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f41784e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f41786b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41787c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f41785a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f41788d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f41786b == null) {
                    d.this.f41786b = (AudioManager) d.a.h0.a.w0.a.c().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : d.this.f41785a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f41786b != null ? d.this.f41786b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public static d e() {
        if (f41784e == null) {
            synchronized (d.class) {
                if (f41784e == null) {
                    f41784e = new d();
                }
            }
        }
        return f41784e;
    }

    public static void i() {
        d dVar = f41784e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f41785a.put(str, bVar);
            if (!this.f41787c) {
                h();
            }
            if (k.f43101a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f41785a.size());
            }
        }
    }

    public int f() {
        if (this.f41786b == null) {
            this.f41786b = (AudioManager) d.a.h0.a.w0.a.c().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        AudioManager audioManager = this.f41786b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f41785a.clear();
            this.f41786b = null;
            this.f41787c = false;
        }
        f41784e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.a.h0.a.w0.a.c().registerReceiver(this.f41788d, intentFilter);
        this.f41787c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f41785a.remove(str);
            if (this.f41785a.size() == 0 && this.f41787c) {
                k();
            }
            if (k.f43101a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f41785a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.a.h0.a.w0.a.c().unregisterReceiver(this.f41788d);
            this.f41787c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
