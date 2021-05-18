package d.a.i0.a.h0.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes2.dex */
public class f implements V8ThreadDelegatePolicy, d.a.i0.a.f1.f.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f42059h = d.a.i0.a.v2.d.a();

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f42060b = null;

    /* renamed from: c  reason: collision with root package name */
    public Thread f42061c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f42062d = null;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f42064f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f42065g = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f42063e = Looper.getMainLooper().getThread();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            f.this.f42062d = new Handler();
            f.this.f42060b.startEngineInternal();
            Looper.loop();
        }
    }

    public final boolean c(Runnable runnable) {
        if (runnable != null && this.f42062d != null) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                this.f42062d.postAtFrontOfQueue(runnable);
                return true;
            }
            if (this.f42063e == currentThread) {
                if (f42059h) {
                    Runnable runnable2 = this.f42064f;
                    if (runnable2 == null) {
                        this.f42062d.postAtFrontOfQueue(runnable);
                    } else if (this.f42062d.hasCallbacks(runnable2)) {
                        this.f42062d.post(runnable);
                    } else {
                        this.f42062d.postAtFrontOfQueue(runnable);
                    }
                    this.f42064f = runnable;
                } else {
                    boolean hasMessages = this.f42062d.hasMessages(this.f42065g);
                    this.f42065g++;
                    Message obtain = Message.obtain(this.f42062d, runnable);
                    obtain.what = this.f42065g;
                    if (hasMessages) {
                        this.f42062d.sendMessage(obtain);
                    } else {
                        this.f42062d.sendMessageAtFrontOfQueue(obtain);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void d(@NonNull V8Engine v8Engine) {
        this.f42060b = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        if (this.f42062d == null || c(runnable)) {
            return;
        }
        this.f42062d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        if (this.f42062d == null || c(runnable)) {
            return;
        }
        this.f42062d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        Handler handler = this.f42062d;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler = this.f42062d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f42062d.getLooper().quitSafely();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        if (this.f42061c == null) {
            Thread thread = new Thread(new a());
            this.f42061c = thread;
            thread.setName(v8Engine.threadName());
            this.f42061c.setPriority(10);
            this.f42061c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        if (this.f42062d == null || c(runnable)) {
            return;
        }
        this.f42062d.postDelayed(runnable, j);
    }
}
