package d.a.o0.e2.k.e.b1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f57000b;

    /* renamed from: c  reason: collision with root package name */
    public String f57001c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f57002d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f57003e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f56999a = new Handler();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f57001c) || b.this.f57002d == null) {
                return;
            }
            if (b.this.f57000b == null) {
                b.this.f57000b = new SearchEmotionModel();
            }
            b.this.f57000b.x(b.this.f57001c, 0, 30, b.this.f57002d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f57000b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f56999a.removeCallbacks(this.f57003e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f57001c = "";
            return;
        }
        this.f56999a.removeCallbacks(this.f57003e);
        this.f56999a.postDelayed(this.f57003e, 300L);
        this.f57001c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f57002d = bVar;
    }
}
