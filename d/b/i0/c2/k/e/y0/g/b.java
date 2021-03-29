package d.b.i0.c2.k.e.y0.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f52988b;

    /* renamed from: c  reason: collision with root package name */
    public String f52989c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f52990d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f52991e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f52987a = new Handler();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f52989c) || b.this.f52990d == null) {
                return;
            }
            if (b.this.f52988b == null) {
                b.this.f52988b = new SearchEmotionModel();
            }
            b.this.f52988b.t(b.this.f52989c, 0, 30, b.this.f52990d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f52988b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f52987a.removeCallbacks(this.f52991e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f52989c = "";
            return;
        }
        this.f52987a.removeCallbacks(this.f52991e);
        this.f52987a.postDelayed(this.f52991e, 300L);
        this.f52989c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f52990d = bVar;
    }
}
