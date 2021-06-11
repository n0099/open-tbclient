package d.a.n0.e2.k.e.b1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f56875b;

    /* renamed from: c  reason: collision with root package name */
    public String f56876c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f56877d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f56878e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f56874a = new Handler();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f56876c) || b.this.f56877d == null) {
                return;
            }
            if (b.this.f56875b == null) {
                b.this.f56875b = new SearchEmotionModel();
            }
            b.this.f56875b.x(b.this.f56876c, 0, 30, b.this.f56877d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f56875b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f56874a.removeCallbacks(this.f56878e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f56876c = "";
            return;
        }
        this.f56874a.removeCallbacks(this.f56878e);
        this.f56874a.postDelayed(this.f56878e, 300L);
        this.f56876c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f56877d = bVar;
    }
}
