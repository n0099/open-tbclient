package d.a.k0.v3.k;

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
    public static d f62715g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f62717b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f62718c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f62716a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1701d> f62719d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f62720e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f62721f = new a();

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
            d.this.f62720e.removeCallbacks(d.this.f62721f);
            d.this.f62720e.postDelayed(d.this.f62721f, 2000L);
        }
    }

    /* renamed from: d.a.k0.v3.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1701d {
        void r(boolean z);
    }

    public static d f() {
        if (f62715g == null) {
            synchronized (d.class) {
                if (f62715g == null) {
                    d dVar = new d();
                    f62715g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f62715g;
    }

    public void d(InterfaceC1701d interfaceC1701d) {
        if (interfaceC1701d == null || this.f62719d.contains(interfaceC1701d)) {
            return;
        }
        this.f62719d.add(interfaceC1701d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f62717b);
        inst.getContentResolver().unregisterContentObserver(this.f62718c);
        this.f62720e.removeCallbacks(this.f62721f);
        f62715g = null;
    }

    public final void g(Context context) {
        this.f62717b = new b();
        this.f62718c = new c(this.f62716a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f62717b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f62718c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1701d> it = this.f62719d.iterator();
        while (it.hasNext()) {
            it.next().r(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f62720e.removeCallbacks(this.f62721f);
        this.f62720e.postDelayed(this.f62721f, 2000L);
    }

    public void j() {
        this.f62719d.clear();
    }

    public void k(InterfaceC1701d interfaceC1701d) {
        if (this.f62719d.contains(interfaceC1701d)) {
            this.f62719d.remove(interfaceC1701d);
        }
    }
}
