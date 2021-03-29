package d.b.h0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.b.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1105d f51420a;

    /* renamed from: b  reason: collision with root package name */
    public c f51421b;

    /* renamed from: c  reason: collision with root package name */
    public b f51422c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f51423a;

        public b() {
            this.f51423a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f51423a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f51421b != null) {
                d.this.f51421b.a(false);
            }
            if (d.this.f51420a != null) {
                d.this.f51420a.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        try {
                            Process exec = Runtime.getRuntime().exec(strArr[0]);
                            this.f51423a = exec;
                            if (exec.waitFor() == 0) {
                                z = true;
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                } finally {
                    this.f51423a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f51421b != null) {
                d.this.f51421b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f51420a != null) {
                d.this.f51420a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.b.h0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1105d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f51425a;

        public HandlerC1105d(d dVar) {
            this.f51425a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f51425a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f51420a = null;
        this.f51421b = null;
        this.f51422c = null;
        HandlerC1105d handlerC1105d = new HandlerC1105d(this);
        this.f51420a = handlerC1105d;
        this.f51421b = cVar;
        handlerC1105d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f51422c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f51422c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f51422c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1105d handlerC1105d = this.f51420a;
        if (handlerC1105d != null) {
            handlerC1105d.removeMessages(0);
        }
    }
}
