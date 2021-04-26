package d.a.j0.d2.k.e.a1.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.tieba.face.SearchEmotionModel;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public SearchEmotionModel f52230b;

    /* renamed from: c  reason: collision with root package name */
    public String f52231c;

    /* renamed from: d  reason: collision with root package name */
    public SearchEmotionModel.b f52232d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f52233e = new a();

    /* renamed from: a  reason: collision with root package name */
    public Handler f52229a = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(b.this.f52231c) || b.this.f52232d == null) {
                return;
            }
            if (b.this.f52230b == null) {
                b.this.f52230b = new SearchEmotionModel();
            }
            b.this.f52230b.t(b.this.f52231c, 0, 30, b.this.f52232d);
        }
    }

    public void e() {
        SearchEmotionModel searchEmotionModel = this.f52230b;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        this.f52229a.removeCallbacks(this.f52233e);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f52231c = "";
            return;
        }
        this.f52229a.removeCallbacks(this.f52233e);
        this.f52229a.postDelayed(this.f52233e, 300L);
        this.f52231c = str;
    }

    public void g(SearchEmotionModel.b bVar) {
        this.f52232d = bVar;
    }
}
