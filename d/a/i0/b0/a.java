package d.a.i0.b0;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import d.a.i0.b0.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: c  reason: collision with root package name */
    public String f48040c;

    /* renamed from: e  reason: collision with root package name */
    public T f48042e;

    /* renamed from: f  reason: collision with root package name */
    public final f f48043f;

    /* renamed from: g  reason: collision with root package name */
    public int f48044g;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<b<T>> f48038a = null;

    /* renamed from: b  reason: collision with root package name */
    public d f48039b = null;

    /* renamed from: d  reason: collision with root package name */
    public a<T>.c f48041d = null;

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(int i2, T t);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48045a;

        /* renamed from: b  reason: collision with root package name */
        public int f48046b;

        public c() {
            this.f48045a = false;
        }

        @Override // d.a.i0.b0.f.a
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
            a.this.f48041d = null;
            if (a.this.f48039b != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    imageUploadResult.error_msg = string;
                    TiebaStatic.imgError(-1002, string, "");
                }
                a.this.f48039b.a(a.this.f48040c, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.f48041d = null;
            a.this.f48043f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr == null || numArr.length == 0 || a.this.f48038a == null || a.this.f48038a.get() == null) {
                return;
            }
            ((b) a.this.f48038a.get()).a(numArr[0].intValue(), a.this.f48042e);
        }

        public void e(boolean z) {
            this.f48045a = z;
        }

        public void f(int i2) {
            this.f48046b = i2;
        }

        public final ImageUploadResult g() {
            a.this.f48043f.c(this, null);
            a.this.f48043f.f(this.f48046b);
            ImageUploadResult j = a.this.f48043f.j(a.this.f48040c, this.f48045a);
            publishProgress(100);
            return j;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.f48039b != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.f48039b.a(a.this.f48040c, imageUploadResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.f48040c = null;
        this.f48040c = str;
        this.f48043f = new f(str2);
    }

    public T f() {
        return this.f48042e;
    }

    public void g(boolean z) {
        if (this.f48041d == null) {
            a<T>.c cVar = new c();
            this.f48041d = cVar;
            cVar.e(z);
            this.f48041d.f(this.f48044g);
            this.f48041d.execute(new String[0]);
        }
    }

    public void h(String str) {
        this.f48043f.b(str);
    }

    public void i(T t) {
        this.f48042e = t;
    }

    public void j() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f48043f.e(i2, i3, i4, i5);
    }

    public void l(d dVar) {
        this.f48039b = dVar;
    }

    public void m(b<T> bVar) {
        this.f48038a = new WeakReference<>(bVar);
    }

    public void n(int i2) {
        this.f48044g = i2;
    }
}
