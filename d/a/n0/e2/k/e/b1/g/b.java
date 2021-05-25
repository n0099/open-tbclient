package d.a.n0.e2.k.e.b1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f53186b;

    /* renamed from: c  reason: collision with root package name */
    public String f53187c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f53188d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f53189e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f53185a = new Handler();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f53187c) || b.this.f53188d == null) {
                return;
            }
            if (b.this.f53186b == null) {
                b.this.f53186b = new SearchEmotionModel();
            }
            b.this.f53186b.t(b.this.f53187c, 0, 30, b.this.f53188d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f53186b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f53185a.removeCallbacks(this.f53189e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f53187c = "";
            return;
        }
        this.f53185a.removeCallbacks(this.f53189e);
        this.f53185a.postDelayed(this.f53189e, 300L);
        this.f53187c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f53188d = bVar;
    }
}
