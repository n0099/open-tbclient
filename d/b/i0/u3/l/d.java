package d.b.i0.u3.l;

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
    public static d f61598g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f61600b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f61601c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f61599a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1615d> f61602d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f61603e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f61604f = new a();

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
            d.this.f61603e.removeCallbacks(d.this.f61604f);
            d.this.f61603e.postDelayed(d.this.f61604f, 2000L);
        }
    }

    /* renamed from: d.b.i0.u3.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1615d {
        void z(boolean z);
    }

    public static d f() {
        if (f61598g == null) {
            synchronized (d.class) {
                if (f61598g == null) {
                    d dVar = new d();
                    f61598g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f61598g;
    }

    public void d(InterfaceC1615d interfaceC1615d) {
        if (interfaceC1615d == null || this.f61602d.contains(interfaceC1615d)) {
            return;
        }
        this.f61602d.add(interfaceC1615d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f61600b);
        inst.getContentResolver().unregisterContentObserver(this.f61601c);
        this.f61603e.removeCallbacks(this.f61604f);
        f61598g = null;
    }

    public final void g(Context context) {
        this.f61600b = new b();
        this.f61601c = new c(this.f61599a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f61600b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f61601c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1615d> it = this.f61602d.iterator();
        while (it.hasNext()) {
            it.next().z(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f61603e.removeCallbacks(this.f61604f);
        this.f61603e.postDelayed(this.f61604f, 2000L);
    }

    public void j() {
        this.f61602d.clear();
    }

    public void k(InterfaceC1615d interfaceC1615d) {
        if (this.f61602d.contains(interfaceC1615d)) {
            this.f61602d.remove(interfaceC1615d);
        }
    }
}
