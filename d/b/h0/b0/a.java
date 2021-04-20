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
    public String f50150c;

    /* renamed from: e  reason: collision with root package name */
    public T f50152e;

    /* renamed from: f  reason: collision with root package name */
    public final f f50153f;

    /* renamed from: g  reason: collision with root package name */
    public int f50154g;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<b<T>> f50148a = null;

    /* renamed from: b  reason: collision with root package name */
    public d f50149b = null;

    /* renamed from: d  reason: collision with root package name */
    public a<T>.c f50151d = null;

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(int i, T t);
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f50155a;

        /* renamed from: b  reason: collision with root package name */
        public int f50156b;

        public c() {
            this.f50155a = false;
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
            a.this.f50151d = null;
            if (a.this.f50149b != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    String string = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    imageUploadResult.error_msg = string;
                    TiebaStatic.imgError(-1002, string, "");
                }
                a.this.f50149b.a(a.this.f50150c, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.f50151d = null;
            a.this.f50153f.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr == null || numArr.length == 0 || a.this.f50148a == null || a.this.f50148a.get() == null) {
                return;
            }
            ((b) a.this.f50148a.get()).a(numArr[0].intValue(), a.this.f50152e);
        }

        public void e(boolean z) {
            this.f50155a = z;
        }

        public void f(int i) {
            this.f50156b = i;
        }

        public final ImageUploadResult g() {
            a.this.f50153f.c(this, null);
            a.this.f50153f.f(this.f50156b);
            ImageUploadResult j = a.this.f50153f.j(a.this.f50150c, this.f50155a);
            publishProgress(100);
            return j;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.f50149b != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.f50149b.a(a.this.f50150c, imageUploadResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.f50150c = null;
        this.f50150c = str;
        this.f50153f = new f(str2);
    }

    public T f() {
        return this.f50152e;
    }

    public void g(boolean z) {
        if (this.f50151d == null) {
            a<T>.c cVar = new c();
            this.f50151d = cVar;
            cVar.e(z);
            this.f50151d.f(this.f50154g);
            this.f50151d.execute(new String[0]);
        }
    }

    public void h(String str) {
        this.f50153f.b(str);
    }

    public void i(T t) {
        this.f50152e = t;
    }

    public void j() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f50153f.e(i, i2, i3, i4);
    }

    public void l(d dVar) {
        this.f50149b = dVar;
    }

    public void m(b<T> bVar) {
        this.f50148a = new WeakReference<>(bVar);
    }

    public void n(int i) {
        this.f50154g = i;
    }
}
