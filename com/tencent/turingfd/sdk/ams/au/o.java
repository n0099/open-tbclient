package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sapi2.result.OneKeyLoginResult;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public abstract class o implements k {

    /* renamed from: a  reason: collision with root package name */
    public n f13839a;

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f13840a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f13841b;
        public final /* synthetic */ Object c;

        public a(o oVar, AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f13840a = atomicReference;
            this.f13841b = atomicReference2;
            this.c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f13840a.set(iBinder);
            this.f13841b.set(this);
            synchronized (this.c) {
                try {
                    this.c.notifyAll();
                } catch (Throwable th) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f13842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f13843b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ AtomicReference e;
        public final /* synthetic */ Object f;

        public b(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f13842a = atomicReference;
            this.f13843b = atomicReference2;
            this.c = atomicReference3;
            this.d = context;
            this.e = atomicReference4;
            this.f = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            try {
                str = o.this.a((IBinder) this.f13842a.get());
            } catch (Throwable th) {
                this.f13843b.set(Integer.valueOf((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL));
                str = "";
            }
            this.c.set(str);
            try {
                this.d.unbindService((ServiceConnection) this.e.get());
            } catch (Throwable th2) {
                this.f13843b.set(-103);
            }
            synchronized (this.f) {
                try {
                    this.f.notifyAll();
                } catch (Throwable th3) {
                }
            }
        }
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        Object obj = new Object();
        q qVar = (q) this;
        Intent intent = new Intent(y.a(y.k));
        intent.setComponent(new ComponentName(y.a(y.g), y.a(y.h)));
        if (context.bindService(intent, new a(this, atomicReference, atomicReference2, obj), 1)) {
            if (atomicReference.get() == null) {
                synchronized (obj) {
                    try {
                        obj.wait(1000L);
                    } catch (Throwable th) {
                    }
                }
            }
            if (atomicReference.get() == null) {
                return OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL;
            }
            return 0;
        }
        return -100;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new b(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable th) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }

    @Override // com.tencent.turingfd.sdk.ams.au.k
    public n a(Context context) {
        n nVar = this.f13839a;
        if (nVar == null || nVar.f13838b != 0) {
            this.f13839a = c(context);
        }
        return this.f13839a;
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingfd.sdk.ams.au.k
    public void b(Context context) {
        this.f13839a = c(context);
    }

    public final n c(Context context) {
        int i;
        int i2;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            int a2 = a(context, atomicReference2, atomicReference3);
            if (a2 == 0) {
                try {
                    i = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable th) {
                    i = i2;
                }
            } else {
                i = a2;
            }
        } catch (Throwable th2) {
            i = -1;
        }
        return new n(atomicReference.get(), i);
    }
}
