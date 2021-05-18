package d.a.j0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1154d f50657a;

    /* renamed from: b  reason: collision with root package name */
    public c f50658b;

    /* renamed from: c  reason: collision with root package name */
    public b f50659c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f50660a;

        public b() {
            this.f50660a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f50660a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f50658b != null) {
                d.this.f50658b.a(false);
            }
            if (d.this.f50657a != null) {
                d.this.f50657a.removeMessages(0);
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
                            this.f50660a = exec;
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
                    this.f50660a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f50658b != null) {
                d.this.f50658b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f50657a != null) {
                d.this.f50657a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.a.j0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1154d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f50662a;

        public HandlerC1154d(d dVar) {
            this.f50662a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f50662a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f50657a = null;
        this.f50658b = null;
        this.f50659c = null;
        HandlerC1154d handlerC1154d = new HandlerC1154d(this);
        this.f50657a = handlerC1154d;
        this.f50658b = cVar;
        handlerC1154d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f50659c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f50659c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f50659c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1154d handlerC1154d = this.f50657a;
        if (handlerC1154d != null) {
            handlerC1154d.removeMessages(0);
        }
    }
}
