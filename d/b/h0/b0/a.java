package d.b.h0.b0;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import d.b.h0.b0.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: c  reason: collision with root package name */
    public String f49757c;

    /* renamed from: e  reason: collision with root package name */
    public T f49759e;

    /* renamed from: f  reason: collision with root package name */
    public final f f49760f;

    /* renamed from: g  reason: collision with root package name */
    public int f49761g;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<b<T>> f49755a = null;

    /* renamed from: b  reason: collision with root package name */
    public d f49756b = null;

    /* renamed from: d  reason: collision with root package name */
    public a<T>.c f49758d = null;

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(int i, T t);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f49762a;

        /* renamed from: b  reason: collision with root package name */
        public int f49763b;

        public c() {
            this.f49762a = false;
        }

        @Override // d.b.h0.b0.f.a
        public void a(String str, Object obj, long j, long j2) {
            int i;
            if (j2 == 0) {
                i = 0;
            } else {
                i = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i > 100) {
                    i = 90;
                }
            }
            publishProgress(Integer.valueOf(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            return g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.f49758d = null;
            if (a.this.f49756b != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    imageUploadResult.error_msg = string;
                    TiebaStatic.imgError(-1002, string, "");
                }
                a.this.f49756b.a(a.this.f49757c, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.f49758d = null;
            a.this.f49760f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr == null || numArr.length == 0 || a.this.f49755a == null || a.this.f49755a.get() == null) {
                return;
            }
            ((b) a.this.f49755a.get()).a(numArr[0].intValue(), a.this.f49759e);
        }

        public void e(boolean z) {
            this.f49762a = z;
        }

        public void f(int i) {
            this.f49763b = i;
        }

        public final ImageUploadResult g() {
            a.this.f49760f.c(this, null);
            a.this.f49760f.f(this.f49763b);
            ImageUploadResult j = a.this.f49760f.j(a.this.f49757c, this.f49762a);
            publishProgress(100);
            return j;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.f49756b != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.f49756b.a(a.this.f49757c, imageUploadResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.f49757c = null;
        this.f49757c = str;
        this.f49760f = new f(str2);
    }

    public T f() {
        return this.f49759e;
    }

    public void g(boolean z) {
        if (this.f49758d == null) {
            a<T>.c cVar = new c();
            this.f49758d = cVar;
            cVar.e(z);
            this.f49758d.f(this.f49761g);
            this.f49758d.execute(new String[0]);
        }
    }

    public void h(String str) {
        this.f49760f.b(str);
    }

    public void i(T t) {
        this.f49759e = t;
    }

    public void j() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f49760f.e(i, i2, i3, i4);
    }

    public void l(d dVar) {
        this.f49756b = dVar;
    }

    public void m(b<T> bVar) {
        this.f49755a = new WeakReference<>(bVar);
    }

    public void n(int i) {
        this.f49761g = i;
    }
}
