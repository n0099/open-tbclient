package d.a.k0.d2.k.e.a1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f52929b;

    /* renamed from: c  reason: collision with root package name */
    public String f52930c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f52931d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f52932e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f52928a = new Handler();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f52930c) || b.this.f52931d == null) {
                return;
            }
            if (b.this.f52929b == null) {
                b.this.f52929b = new SearchEmotionModel();
            }
            b.this.f52929b.t(b.this.f52930c, 0, 30, b.this.f52931d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f52929b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f52928a.removeCallbacks(this.f52932e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f52930c = "";
            return;
        }
        this.f52928a.removeCallbacks(this.f52932e);
        this.f52928a.postDelayed(this.f52932e, 300L);
        this.f52930c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f52931d = bVar;
    }
}
