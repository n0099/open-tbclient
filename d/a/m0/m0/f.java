package d.a.m0.m0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: b  reason: collision with root package name */
    public long f49528b;

    /* renamed from: c  reason: collision with root package name */
    public long f49529c;

    /* renamed from: d  reason: collision with root package name */
    public long f49530d;

    /* renamed from: e  reason: collision with root package name */
    public int f49531e;

    /* renamed from: f  reason: collision with root package name */
    public long f49532f;

    /* renamed from: g  reason: collision with root package name */
    public int f49533g;

    /* renamed from: h  reason: collision with root package name */
    public b f49534h = null;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f49535i = new a(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.f49534h = new b();
            f.this.f49534h.setSelfExecute(true);
            f.this.f49534h.execute(new String[0]);
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
            f.this.f49533g = k.d().a();
            f.this.e();
            return Boolean.TRUE;
        }
    }

    public final void e() {
        i iVar = (i) k.d().e(this.f49538a);
        if (iVar != null) {
            iVar.c(this);
        }
    }

    public void f() {
        this.f49535i.sendEmptyMessage(0);
    }
}
