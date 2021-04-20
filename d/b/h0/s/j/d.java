package d.b.h0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1118d f51837a;

    /* renamed from: b  reason: collision with root package name */
    public c f51838b;

    /* renamed from: c  reason: collision with root package name */
    public b f51839c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f51840a;

        public b() {
            this.f51840a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f51840a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f51838b != null) {
                d.this.f51838b.a(false);
            }
            if (d.this.f51837a != null) {
                d.this.f51837a.removeMessages(0);
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
                            this.f51840a = exec;
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
                    this.f51840a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f51838b != null) {
                d.this.f51838b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f51837a != null) {
                d.this.f51837a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.b.h0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1118d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f51842a;

        public HandlerC1118d(d dVar) {
            this.f51842a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f51842a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f51837a = null;
        this.f51838b = null;
        this.f51839c = null;
        HandlerC1118d handlerC1118d = new HandlerC1118d(this);
        this.f51837a = handlerC1118d;
        this.f51838b = cVar;
        handlerC1118d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f51839c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f51839c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f51839c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1118d handlerC1118d = this.f51837a;
        if (handlerC1118d != null) {
            handlerC1118d.removeMessages(0);
        }
    }
}
