package d.b.h0.a.c2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import d.b.h0.a.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static d f44492e;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f44494b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44495c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f44493a = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public BroadcastReceiver f44496d = new a();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.f44494b == null) {
                    d.this.f44494b = (AudioManager) d.b.h0.a.w0.a.c().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.f44493a.entrySet()) {
                    ((b) entry.getValue()).a(d.this.f44494b != null ? d.this.f44494b.getStreamVolume(3) : 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    public static d e() {
        if (f44492e == null) {
            synchronized (d.class) {
                if (f44492e == null) {
                    f44492e = new d();
                }
            }
        }
        return f44492e;
    }

    public static void i() {
        d dVar = f44492e;
        if (dVar != null) {
            dVar.g();
        }
    }

    public void d(@NonNull String str, @NonNull b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            this.f44493a.put(str, bVar);
            if (!this.f44495c) {
                h();
            }
            if (k.f45772a) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.f44493a.size());
            }
        }
    }

    public int f() {
        if (this.f44494b == null) {
            this.f44494b = (AudioManager) d.b.h0.a.w0.a.c().getSystemService("audio");
        }
        AudioManager audioManager = this.f44494b;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    public final void g() {
        synchronized (this) {
            this.f44493a.clear();
            this.f44494b = null;
            this.f44495c = false;
        }
        f44492e = null;
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        d.b.h0.a.w0.a.c().registerReceiver(this.f44496d, intentFilter);
        this.f44495c = true;
    }

    public boolean j(@NonNull String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this) {
            b remove = this.f44493a.remove(str);
            if (this.f44493a.size() == 0 && this.f44495c) {
                k();
            }
            if (k.f45772a && remove != null) {
                Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.f44493a.size());
            }
            z = remove != null;
        }
        return z;
    }

    public final void k() {
        try {
            d.b.h0.a.w0.a.c().unregisterReceiver(this.f44496d);
            this.f44495c = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
