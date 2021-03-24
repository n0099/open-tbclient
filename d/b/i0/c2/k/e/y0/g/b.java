package d.b.i0.c2.k.e.y0.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f52987b;

    /* renamed from: c  reason: collision with root package name */
    public String f52988c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f52989d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f52990e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f52986a = new Handler();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f52988c) || b.this.f52989d == null) {
                return;
            }
            if (b.this.f52987b == null) {
                b.this.f52987b = new SearchEmotionModel();
            }
            b.this.f52987b.t(b.this.f52988c, 0, 30, b.this.f52989d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f52987b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f52986a.removeCallbacks(this.f52990e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f52988c = "";
            return;
        }
        this.f52986a.removeCallbacks(this.f52990e);
        this.f52986a.postDelayed(this.f52990e, 300L);
        this.f52988c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f52989d = bVar;
    }
}
