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
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f47463e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f47465b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47466c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f47464a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f47467d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f47465b == null) {
                    d.this.f47465b = (AudioManager) d.a.l0.a.c1.a.b().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.f47464a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f47465b != null ? d.this.f47465b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public static d e() {
        if (f47463e == null) {
            synchronized (d.class) {
                if (f47463e == null) {
                    f47463e = new d();
                }
            }
        }
        return f47463e;
    }

    public static void i() {
        d dVar = f47463e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f47464a.put(str, bVar);
            if (!this.f47466c) {
                h();
            }
            if (k.f46875a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f47464a.size());
            }
        }
    }

    public int f() {
        if (this.f47465b == null) {
            this.f47465b = (AudioManager) d.a.l0.a.c1.a.b().getSystemService("audio");
        }
        AudioManager audioManager = this.f47465b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f47464a.clear();
            this.f47465b = null;
            this.f47466c = false;
        }
        f47463e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.a.l0.a.c1.a.b().registerReceiver(this.f47467d, intentFilter);
        this.f47466c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f47464a.remove(str);
            if (this.f47464a.size() == 0 && this.f47466c) {
                k();
            }
            if (k.f46875a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f47464a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.a.l0.a.c1.a.b().unregisterReceiver(this.f47467d);
            this.f47466c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
