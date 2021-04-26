package d.a.j0.v3.k;

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
    public static d f61991g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f61993b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f61994c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f61992a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1636d> f61995d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f61996e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f61997f = new a();

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
            d.this.f61996e.removeCallbacks(d.this.f61997f);
            d.this.f61996e.postDelayed(d.this.f61997f, 2000L);
        }
    }

    /* renamed from: d.a.j0.v3.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1636d {
        void r(boolean z);
    }

    public static d f() {
        if (f61991g == null) {
            synchronized (d.class) {
                if (f61991g == null) {
                    d dVar = new d();
                    f61991g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f61991g;
    }

    public void d(InterfaceC1636d interfaceC1636d) {
        if (interfaceC1636d == null || this.f61995d.contains(interfaceC1636d)) {
            return;
        }
        this.f61995d.add(interfaceC1636d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f61993b);
        inst.getContentResolver().unregisterContentObserver(this.f61994c);
        this.f61996e.removeCallbacks(this.f61997f);
        f61991g = null;
    }

    public final void g(Context context) {
        this.f61993b = new b();
        this.f61994c = new c(this.f61992a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f61993b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f61994c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1636d> it = this.f61995d.iterator();
        while (it.hasNext()) {
            it.next().r(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f61996e.removeCallbacks(this.f61997f);
        this.f61996e.postDelayed(this.f61997f, 2000L);
    }

    public void j() {
        this.f61995d.clear();
    }

    public void k(InterfaceC1636d interfaceC1636d) {
        if (this.f61995d.contains(interfaceC1636d)) {
            this.f61995d.remove(interfaceC1636d);
        }
    }
}
