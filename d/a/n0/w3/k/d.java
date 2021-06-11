package d.a.n0.w3.k;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static d f66537g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f66539b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f66540c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f66538a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1771d> f66541d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f66542e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f66543f = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.h(false);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.this.i(intent);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            d.this.f66542e.removeCallbacks(d.this.f66543f);
            d.this.f66542e.postDelayed(d.this.f66543f, 2000L);
        }
    }

    /* renamed from: d.a.n0.w3.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1771d {
        void s(boolean z);
    }

    public static d f() {
        if (f66537g == null) {
            synchronized (d.class) {
                if (f66537g == null) {
                    d dVar = new d();
                    f66537g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f66537g;
    }

    public void d(InterfaceC1771d interfaceC1771d) {
        if (interfaceC1771d == null || this.f66541d.contains(interfaceC1771d)) {
            return;
        }
        this.f66541d.add(interfaceC1771d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f66539b);
        inst.getContentResolver().unregisterContentObserver(this.f66540c);
        this.f66542e.removeCallbacks(this.f66543f);
        f66537g = null;
    }

    public final void g(Context context) {
        this.f66539b = new b();
        this.f66540c = new c(this.f66538a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f66539b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f66540c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1771d> it = this.f66541d.iterator();
        while (it.hasNext()) {
            it.next().s(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f66542e.removeCallbacks(this.f66543f);
        this.f66542e.postDelayed(this.f66543f, 2000L);
    }

    public void j() {
        this.f66541d.clear();
    }

    public void k(InterfaceC1771d interfaceC1771d) {
        if (this.f66541d.contains(interfaceC1771d)) {
            this.f66541d.remove(interfaceC1771d);
        }
    }
}
