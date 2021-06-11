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
    public static final boolean f45909h = d.a.l0.a.v2.d.a();

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f45910b = null;

    /* renamed from: c  reason: collision with root package name */
    public Thread f45911c = null;

    /* renamed from: d  reason: collision with root package name */
    public Handler f45912d = null;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f45914f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f45915g = 0;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f45913e = Looper.getMainLooper().getThread();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            f.this.f45912d = new Handler();
            f.this.f45910b.startEngineInternal();
            Looper.loop();
        }
    }

    public final boolean c(Runnable runnable) {
        if (runnable != null && this.f45912d != null) {
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                this.f45912d.postAtFrontOfQueue(runnable);
                return true;
            }
            if (this.f45913e == currentThread) {
                if (f45909h) {
                    Runnable runnable2 = this.f45914f;
                    if (runnable2 == null) {
                        this.f45912d.postAtFrontOfQueue(runnable);
                    } else if (this.f45912d.hasCallbacks(runnable2)) {
                        this.f45912d.post(runnable);
                    } else {
                        this.f45912d.postAtFrontOfQueue(runnable);
                    }
                    this.f45914f = runnable;
                } else {
                    boolean hasMessages = this.f45912d.hasMessages(this.f45915g);
                    this.f45915g++;
                    Message obtain = Message.obtain(this.f45912d, runnable);
                    obtain.what = this.f45915g;
                    if (hasMessages) {
                        this.f45912d.sendMessage(obtain);
                    } else {
                        this.f45912d.sendMessageAtFrontOfQueue(obtain);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void d(@NonNull V8Engine v8Engine) {
        this.f45910b = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        if (this.f45912d == null || c(runnable)) {
            return;
        }
        this.f45912d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        if (this.f45912d == null || c(runnable)) {
            return;
        }
        this.f45912d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        Handler handler = this.f45912d;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler = this.f45912d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f45912d.getLooper().quitSafely();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        if (this.f45911c == null) {
            Thread thread = new Thread(new a());
            this.f45911c = thread;
            thread.setName(v8Engine.threadName());
            this.f45911c.setPriority(10);
            this.f45911c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        if (this.f45912d == null || c(runnable)) {
            return;
        }
        this.f45912d.postDelayed(runnable, j);
    }
}
