package d.a.m0.s.j;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.e.p.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public HandlerC1163d f50730a;

    /* renamed from: b  reason: collision with root package name */
    public c f50731b;

    /* renamed from: c  reason: collision with root package name */
    public b f50732c;

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public Process f50733a;

        public b() {
            this.f50733a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f50733a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.f50731b != null) {
                d.this.f50731b.a(false);
            }
            if (d.this.f50730a != null) {
                d.this.f50730a.removeMessages(0);
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
                            this.f50733a = exec;
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
                    this.f50733a.destroy();
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.f50731b != null) {
                d.this.f50731b.a(bool == null ? false : bool.booleanValue());
            }
            if (d.this.f50730a != null) {
                d.this.f50730a.removeMessages(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* renamed from: d.a.m0.s.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC1163d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f50735a;

        public HandlerC1163d(d dVar) {
            this.f50735a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what != 0 || (dVar = this.f50735a.get()) == null) {
                return;
            }
            dVar.e();
        }
    }

    public d(String str, c cVar) {
        this.f50730a = null;
        this.f50731b = null;
        this.f50732c = null;
        HandlerC1163d handlerC1163d = new HandlerC1163d(this);
        this.f50730a = handlerC1163d;
        this.f50731b = cVar;
        handlerC1163d.sendEmptyMessageDelayed(0, 50000L);
        b bVar = new b();
        this.f50732c = bVar;
        bVar.setSelfExecute(true);
        b bVar2 = this.f50732c;
        bVar2.execute(d() + str);
    }

    public final String d() {
        int I = j.I();
        return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
    }

    public final void e() {
        b bVar = this.f50732c;
        if (bVar != null) {
            bVar.cancel(true);
        }
        HandlerC1163d handlerC1163d = this.f50730a;
        if (handlerC1163d != null) {
            handlerC1163d.removeMessages(0);
        }
    }
}
