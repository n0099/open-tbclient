package d.b.i0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1140d f52173a;

    /* renamed from: b  reason: collision with root package name */
    public c f52174b;

    /* renamed from: c  reason: collision with root package name */
    public b f52175c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f52176a;

        public b() {
            this.f52176a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f52176a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f52174b != null) {
                d.this.f52174b.a(false);
            }
            if (d.this.f52173a != null) {
                d.this.f52173a.removeMessages(0);
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
                            this.f52176a = exec;
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
                    this.f52176a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f52174b != null) {
                d.this.f52174b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f52173a != null) {
                d.this.f52173a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.b.i0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1140d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f52178a;

        public HandlerC1140d(d dVar) {
            this.f52178a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f52178a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f52173a = null;
        this.f52174b = null;
        this.f52175c = null;
        HandlerC1140d handlerC1140d = new HandlerC1140d(this);
        this.f52173a = handlerC1140d;
        this.f52174b = cVar;
        handlerC1140d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f52175c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f52175c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f52175c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1140d handlerC1140d = this.f52173a;
        if (handlerC1140d != null) {
            handlerC1140d.removeMessages(0);
        }
    }
}
