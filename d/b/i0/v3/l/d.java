package d.b.i0.v3.l;

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
    public static d f63337g;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f63339b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f63340c;

    /* renamed from: a  reason: collision with root package name */
    public Handler f63338a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<InterfaceC1676d> f63341d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Handler f63342e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public Runnable f63343f = new a();

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
            d.this.f63342e.removeCallbacks(d.this.f63343f);
            d.this.f63342e.postDelayed(d.this.f63343f, 2000L);
        }
    }

    /* renamed from: d.b.i0.v3.l.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1676d {
        void z(boolean z);
    }

    public static d f() {
        if (f63337g == null) {
            synchronized (d.class) {
                if (f63337g == null) {
                    d dVar = new d();
                    f63337g = dVar;
                    dVar.g(TbadkCoreApplication.getInst());
                }
            }
        }
        return f63337g;
    }

    public void d(InterfaceC1676d interfaceC1676d) {
        if (interfaceC1676d == null || this.f63341d.contains(interfaceC1676d)) {
            return;
        }
        this.f63341d.add(interfaceC1676d);
    }

    public void e() {
        j();
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.unregisterReceiver(this.f63339b);
        inst.getContentResolver().unregisterContentObserver(this.f63340c);
        this.f63342e.removeCallbacks(this.f63343f);
        f63337g = null;
    }

    public final void g(Context context) {
        this.f63339b = new b();
        this.f63340c = new c(this.f63338a);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        context.registerReceiver(this.f63339b, intentFilter);
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f63340c);
    }

    public void h(boolean z) {
        Iterator<InterfaceC1676d> it = this.f63341d.iterator();
        while (it.hasNext()) {
            it.next().z(z);
        }
    }

    public final void i(Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
            h(true);
            return;
        }
        this.f63342e.removeCallbacks(this.f63343f);
        this.f63342e.postDelayed(this.f63343f, 2000L);
    }

    public void j() {
        this.f63341d.clear();
    }

    public void k(InterfaceC1676d interfaceC1676d) {
        if (this.f63341d.contains(interfaceC1676d)) {
            this.f63341d.remove(interfaceC1676d);
        }
    }
}
