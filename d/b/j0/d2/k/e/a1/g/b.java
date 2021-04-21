package d.b.j0.d2.k.e.a1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f54436b;

    /* renamed from: c  reason: collision with root package name */
    public String f54437c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f54438d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f54439e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f54435a = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f54437c) || b.this.f54438d == null) {
                return;
            }
            if (b.this.f54436b == null) {
                b.this.f54436b = new SearchEmotionModel();
            }
            b.this.f54436b.t(b.this.f54437c, 0, 30, b.this.f54438d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f54436b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f54435a.removeCallbacks(this.f54439e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54437c = "";
            return;
        }
        this.f54435a.removeCallbacks(this.f54439e);
        this.f54435a.postDelayed(this.f54439e, 300L);
        this.f54437c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f54438d = bVar;
    }
}
