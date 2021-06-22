package d.a.o0.w3.k;

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
    public static d f66662g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f66664b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f66665c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f66663a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1775d> f66666d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f66667e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f66668f = new a();

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
            d.this.f66667e.removeCallbacks(d.this.f66668f);
            d.this.f66667e.postDelayed(d.this.f66668f, 2000L);
        }
    }

    /* renamed from: d.a.o0.w3.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1775d {
        void s(boolean z);
    }

    public static d f() {
        if (f66662g == null) {
            synchronized (d.class) {
                if (f66662g == null) {
                    d dVar = new d();
                    f66662g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f66662g;
    }

    public void d(InterfaceC1775d interfaceC1775d) {
        if (interfaceC1775d == null || this.f66666d.contains(interfaceC1775d)) {
            return;
        }
        this.f66666d.add(interfaceC1775d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f66664b);
        inst.getContentResolver().unregisterContentObserver(this.f66665c);
        this.f66667e.removeCallbacks(this.f66668f);
        f66662g = null;
    }

    public final void g(Context context) {
        this.f66664b = new b();
        this.f66665c = new c(this.f66663a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f66664b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f66665c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1775d> it = this.f66666d.iterator();
        while (it.hasNext()) {
            it.next().s(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f66667e.removeCallbacks(this.f66668f);
        this.f66667e.postDelayed(this.f66668f, 2000L);
    }

    public void j() {
        this.f66666d.clear();
    }

    public void k(InterfaceC1775d interfaceC1775d) {
        if (this.f66666d.contains(interfaceC1775d)) {
            this.f66666d.remove(interfaceC1775d);
        }
    }
}
