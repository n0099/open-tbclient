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
    public static d f62822g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f62824b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f62825c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f62823a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1714d> f62826d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f62827e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f62828f = new a();

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
            d.this.f62827e.removeCallbacks(d.this.f62828f);
            d.this.f62827e.postDelayed(d.this.f62828f, 2000L);
        }
    }

    /* renamed from: d.a.n0.w3.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1714d {
        void r(boolean z);
    }

    public static d f() {
        if (f62822g == null) {
            synchronized (d.class) {
                if (f62822g == null) {
                    d dVar = new d();
                    f62822g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f62822g;
    }

    public void d(InterfaceC1714d interfaceC1714d) {
        if (interfaceC1714d == null || this.f62826d.contains(interfaceC1714d)) {
            return;
        }
        this.f62826d.add(interfaceC1714d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f62824b);
        inst.getContentResolver().unregisterContentObserver(this.f62825c);
        this.f62827e.removeCallbacks(this.f62828f);
        f62822g = null;
    }

    public final void g(Context context) {
        this.f62824b = new b();
        this.f62825c = new c(this.f62823a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f62824b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f62825c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1714d> it = this.f62826d.iterator();
        while (it.hasNext()) {
            it.next().r(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f62827e.removeCallbacks(this.f62828f);
        this.f62827e.postDelayed(this.f62828f, 2000L);
    }

    public void j() {
        this.f62826d.clear();
    }

    public void k(InterfaceC1714d interfaceC1714d) {
        if (this.f62826d.contains(interfaceC1714d)) {
            this.f62826d.remove(interfaceC1714d);
        }
    }
}
