package d.b.h0.m0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: b  reason: collision with root package name */
    public long f50311b;

    /* renamed from: c  reason: collision with root package name */
    public long f50312c;

    /* renamed from: d  reason: collision with root package name */
    public long f50313d;

    /* renamed from: e  reason: collision with root package name */
    public int f50314e;

    /* renamed from: f  reason: collision with root package name */
    public long f50315f;

    /* renamed from: g  reason: collision with root package name */
    public int f50316g;

    /* renamed from: h  reason: collision with root package name */
    public b f50317h = null;
    public final Handler i = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.f50317h = new b();
            f.this.f50317h.setSelfExecute(true);
            f.this.f50317h.execute(new String[0]);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            f.this.f50316g = k.d().a();
            f.this.e();
            return Boolean.TRUE;
        }
    }

    public final void e() {
        i iVar = (i) k.d().e(this.f50320a);
        if (iVar != null) {
            iVar.c(this);
        }
    }

    public void f() {
        this.i.sendEmptyMessage(0);
    }
}
