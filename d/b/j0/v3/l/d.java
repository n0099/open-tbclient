package d.b.j0.v3.l;

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
    public static d f63758g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f63760b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f63761c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f63759a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1699d> f63762d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f63763e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f63764f = new a();

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
            d.this.f63763e.removeCallbacks(d.this.f63764f);
            d.this.f63763e.postDelayed(d.this.f63764f, 2000L);
        }
    }

    /* renamed from: d.b.j0.v3.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1699d {
        void z(boolean z);
    }

    public static d f() {
        if (f63758g == null) {
            synchronized (d.class) {
                if (f63758g == null) {
                    d dVar = new d();
                    f63758g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f63758g;
    }

    public void d(InterfaceC1699d interfaceC1699d) {
        if (interfaceC1699d == null || this.f63762d.contains(interfaceC1699d)) {
            return;
        }
        this.f63762d.add(interfaceC1699d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f63760b);
        inst.getContentResolver().unregisterContentObserver(this.f63761c);
        this.f63763e.removeCallbacks(this.f63764f);
        f63758g = null;
    }

    public final void g(Context context) {
        this.f63760b = new b();
        this.f63761c = new c(this.f63759a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f63760b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f63761c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1699d> it = this.f63762d.iterator();
        while (it.hasNext()) {
            it.next().z(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f63763e.removeCallbacks(this.f63764f);
        this.f63763e.postDelayed(this.f63764f, 2000L);
    }

    public void j() {
        this.f63762d.clear();
    }

    public void k(InterfaceC1699d interfaceC1699d) {
        if (this.f63762d.contains(interfaceC1699d)) {
            this.f63762d.remove(interfaceC1699d);
        }
    }
}
