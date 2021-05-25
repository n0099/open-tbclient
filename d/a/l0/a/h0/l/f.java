package d.a.l0.a.h0.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes2.dex */
public class f implements V8ThreadDelegatePolicy, d.a.l0.a.f1.f.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f42233h = d.a.l0.a.v2.d.a();

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f42234b = null;

    /* renamed from: c  reason: collision with root package name */
    public Thread f42235c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f42236d = null;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f42238f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f42239g = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f42237e = Looper.getMainLooper().getThread();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            f.this.f42236d = new Handler();
            f.this.f42234b.startEngineInternal();
            Looper.loop();
        }
    }

    public final boolean c(Runnable runnable) {
        if (runnable != null && this.f42236d != null) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                this.f42236d.postAtFrontOfQueue(runnable);
                return true;
            }
            if (this.f42237e == currentThread) {
                if (f42233h) {
                    Runnable runnable2 = this.f42238f;
                    if (runnable2 == null) {
                        this.f42236d.postAtFrontOfQueue(runnable);
                    } else if (this.f42236d.hasCallbacks(runnable2)) {
                        this.f42236d.post(runnable);
                    } else {
                        this.f42236d.postAtFrontOfQueue(runnable);
                    }
                    this.f42238f = runnable;
                } else {
                    boolean hasMessages = this.f42236d.hasMessages(this.f42239g);
                    this.f42239g++;
                    Message obtain = Message.obtain(this.f42236d, runnable);
                    obtain.what = this.f42239g;
                    if (hasMessages) {
                        this.f42236d.sendMessage(obtain);
                    } else {
                        this.f42236d.sendMessageAtFrontOfQueue(obtain);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void d(@NonNull V8Engine v8Engine) {
        this.f42234b = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        if (this.f42236d == null || c(runnable)) {
            return;
        }
        this.f42236d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        if (this.f42236d == null || c(runnable)) {
            return;
        }
        this.f42236d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        Handler handler = this.f42236d;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler = this.f42236d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f42236d.getLooper().quitSafely();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        if (this.f42235c == null) {
            Thread thread = new Thread(new a());
            this.f42235c = thread;
            thread.setName(v8Engine.threadName());
            this.f42235c.setPriority(10);
            this.f42235c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        if (this.f42236d == null || c(runnable)) {
            return;
        }
        this.f42236d.postDelayed(runnable, j);
    }
}
