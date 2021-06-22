package d.a.m0.a.h0.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes3.dex */
public class f implements V8ThreadDelegatePolicy, d.a.m0.a.f1.f.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46017h = d.a.m0.a.v2.d.a();

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f46018b = null;

    /* renamed from: c  reason: collision with root package name */
    public Thread f46019c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f46020d = null;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f46022f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f46023g = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f46021e = Looper.getMainLooper().getThread();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            f.this.f46020d = new Handler();
            f.this.f46018b.startEngineInternal();
            Looper.loop();
        }
    }

    public final boolean c(Runnable runnable) {
        if (runnable != null && this.f46020d != null) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                this.f46020d.postAtFrontOfQueue(runnable);
                return true;
            }
            if (this.f46021e == currentThread) {
                if (f46017h) {
                    Runnable runnable2 = this.f46022f;
                    if (runnable2 == null) {
                        this.f46020d.postAtFrontOfQueue(runnable);
                    } else if (this.f46020d.hasCallbacks(runnable2)) {
                        this.f46020d.post(runnable);
                    } else {
                        this.f46020d.postAtFrontOfQueue(runnable);
                    }
                    this.f46022f = runnable;
                } else {
                    boolean hasMessages = this.f46020d.hasMessages(this.f46023g);
                    this.f46023g++;
                    Message obtain = Message.obtain(this.f46020d, runnable);
                    obtain.what = this.f46023g;
                    if (hasMessages) {
                        this.f46020d.sendMessage(obtain);
                    } else {
                        this.f46020d.sendMessageAtFrontOfQueue(obtain);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void d(@NonNull V8Engine v8Engine) {
        this.f46018b = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        if (this.f46020d == null || c(runnable)) {
            return;
        }
        this.f46020d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        if (this.f46020d == null || c(runnable)) {
            return;
        }
        this.f46020d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        Handler handler = this.f46020d;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler = this.f46020d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f46020d.getLooper().quitSafely();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        if (this.f46019c == null) {
            Thread thread = new Thread(new a());
            this.f46019c = thread;
            thread.setName(v8Engine.threadName());
            this.f46019c.setPriority(10);
            this.f46019c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        if (this.f46020d == null || c(runnable)) {
            return;
        }
        this.f46020d.postDelayed(runnable, j);
    }
}
