package d.a.n0.b0;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import d.a.n0.b0.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: c  reason: collision with root package name */
    public String f52674c;

    /* renamed from: e  reason: collision with root package name */
    public T f52676e;

    /* renamed from: f  reason: collision with root package name */
    public final f f52677f;

    /* renamed from: g  reason: collision with root package name */
    public int f52678g;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<b<T>> f52672a = null;

    /* renamed from: b  reason: collision with root package name */
    public d f52673b = null;

    /* renamed from: d  reason: collision with root package name */
    public a<T>.c f52675d = null;

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(int i2, T t);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52679a;

        /* renamed from: b  reason: collision with root package name */
        public int f52680b;

        public c() {
            this.f52679a = false;
        }

        @Override // d.a.n0.b0.f.a
        public void a(String str, Object obj, long j, long j2) {
            int i2;
            if (j2 == 0) {
                i2 = 0;
            } else {
                i2 = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i2 > 100) {
                    i2 = 90;
                }
            }
            publishProgress(Integer.valueOf(i2));
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
            a.this.f52675d = null;
            if (a.this.f52673b != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    imageUploadResult.error_msg = string;
                    TiebaStatic.imgError(-1002, string, "");
                }
                a.this.f52673b.a(a.this.f52674c, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.f52675d = null;
            a.this.f52677f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr == null || numArr.length == 0 || a.this.f52672a == null || a.this.f52672a.get() == null) {
                return;
            }
            ((b) a.this.f52672a.get()).a(numArr[0].intValue(), a.this.f52676e);
        }

        public void e(boolean z) {
            this.f52679a = z;
        }

        public void f(int i2) {
            this.f52680b = i2;
        }

        public final ImageUploadResult g() {
            a.this.f52677f.c(this, null);
            a.this.f52677f.f(this.f52680b);
            ImageUploadResult j = a.this.f52677f.j(a.this.f52674c, this.f52679a);
            publishProgress(100);
            return j;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.f52673b != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.f52673b.a(a.this.f52674c, imageUploadResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.f52674c = null;
        this.f52674c = str;
        this.f52677f = new f(str2);
    }

    public T f() {
        return this.f52676e;
    }

    public void g(boolean z) {
        if (this.f52675d == null) {
            a<T>.c cVar = new c();
            this.f52675d = cVar;
            cVar.e(z);
            this.f52675d.f(this.f52678g);
            this.f52675d.execute(new String[0]);
        }
    }

    public void h(String str) {
        this.f52677f.b(str);
    }

    public void i(T t) {
        this.f52676e = t;
    }

    public void j() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f52677f.e(i2, i3, i4, i5);
    }

    public void l(d dVar) {
        this.f52673b = dVar;
    }

    public void m(b<T> bVar) {
        this.f52672a = new WeakReference<>(bVar);
    }

    public void n(int i2) {
        this.f52678g = i2;
    }
}
