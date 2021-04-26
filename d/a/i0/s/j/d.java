package d.a.i0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1079d f49838a;

    /* renamed from: b  reason: collision with root package name */
    public c f49839b;

    /* renamed from: c  reason: collision with root package name */
    public b f49840c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f49841a;

        public b() {
            this.f49841a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f49841a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f49839b != null) {
                d.this.f49839b.a(false);
            }
            if (d.this.f49838a != null) {
                d.this.f49838a.removeMessages(0);
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
                            this.f49841a = exec;
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
                    this.f49841a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f49839b != null) {
                d.this.f49839b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f49838a != null) {
                d.this.f49838a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.a.i0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1079d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f49843a;

        public HandlerC1079d(d dVar) {
            this.f49843a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f49843a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f49838a = null;
        this.f49839b = null;
        this.f49840c = null;
        HandlerC1079d handlerC1079d = new HandlerC1079d(this);
        this.f49838a = handlerC1079d;
        this.f49839b = cVar;
        handlerC1079d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f49840c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f49840c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f49840c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1079d handlerC1079d = this.f49838a;
        if (handlerC1079d != null) {
            handlerC1079d.removeMessages(0);
        }
    }
}
