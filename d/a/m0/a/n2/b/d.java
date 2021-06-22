package d.a.m0.a.n2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import d.a.m0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f47571e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f47573b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47574c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f47572a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f47575d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f47573b == null) {
                    d.this.f47573b = (AudioManager) d.a.m0.a.c1.a.b().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.f47572a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f47573b != null ? d.this.f47573b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public static d e() {
        if (f47571e == null) {
            synchronized (d.class) {
                if (f47571e == null) {
                    f47571e = new d();
                }
            }
        }
        return f47571e;
    }

    public static void i() {
        d dVar = f47571e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f47572a.put(str, bVar);
            if (!this.f47574c) {
                h();
            }
            if (k.f46983a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f47572a.size());
            }
        }
    }

    public int f() {
        if (this.f47573b == null) {
            this.f47573b = (AudioManager) d.a.m0.a.c1.a.b().getSystemService("audio");
        }
        AudioManager audioManager = this.f47573b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f47572a.clear();
            this.f47573b = null;
            this.f47574c = false;
        }
        f47571e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.a.m0.a.c1.a.b().registerReceiver(this.f47575d, intentFilter);
        this.f47574c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f47572a.remove(str);
            if (this.f47572a.size() == 0 && this.f47574c) {
                k();
            }
            if (k.f46983a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f47572a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.a.m0.a.c1.a.b().unregisterReceiver(this.f47575d);
            this.f47574c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
