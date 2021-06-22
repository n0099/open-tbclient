package d.a.n0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1222d f54514a;

    /* renamed from: b  reason: collision with root package name */
    public c f54515b;

    /* renamed from: c  reason: collision with root package name */
    public b f54516c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f54517a;

        public b() {
            this.f54517a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f54517a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f54515b != null) {
                d.this.f54515b.a(false);
            }
            if (d.this.f54514a != null) {
                d.this.f54514a.removeMessages(0);
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
                            this.f54517a = exec;
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
                    this.f54517a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f54515b != null) {
                d.this.f54515b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f54514a != null) {
                d.this.f54514a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.a.n0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1222d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f54519a;

        public HandlerC1222d(d dVar) {
            this.f54519a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f54519a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f54514a = null;
        this.f54515b = null;
        this.f54516c = null;
        HandlerC1222d handlerC1222d = new HandlerC1222d(this);
        this.f54514a = handlerC1222d;
        this.f54515b = cVar;
        handlerC1222d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f54516c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f54516c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f54516c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1222d handlerC1222d = this.f54514a;
        if (handlerC1222d != null) {
            handlerC1222d.removeMessages(0);
        }
    }
}
