package d.b.i0.d2.k.e.a1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f54015b;

    /* renamed from: c  reason: collision with root package name */
    public String f54016c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f54017d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f54018e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f54014a = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f54016c) || b.this.f54017d == null) {
                return;
            }
            if (b.this.f54015b == null) {
                b.this.f54015b = new SearchEmotionModel();
            }
            b.this.f54015b.t(b.this.f54016c, 0, 30, b.this.f54017d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f54015b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f54014a.removeCallbacks(this.f54018e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f54016c = "";
            return;
        }
        this.f54014a.removeCallbacks(this.f54018e);
        this.f54014a.postDelayed(this.f54018e, 300L);
        this.f54016c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f54017d = bVar;
    }
}
