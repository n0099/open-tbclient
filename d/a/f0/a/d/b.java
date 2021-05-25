package d.a.f0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.gif.GifAnimView;
import d.a.f0.a.f.e;
import java.io.FileInputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.f0.a.d.a {
    public FileInputStream N;
    public GifAnimView O;

    /* loaded from: classes2.dex */
    public class a implements d.a.f0.a.e.a {
        public a() {
        }

        @Override // d.a.f0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            b.this.D("cache gif, load failed");
        }

        @Override // d.a.f0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            b bVar = b.this;
            bVar.P(MaterialLoader.k(bVar.f39788a).l(str));
        }

        @Override // d.a.f0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: d.a.f0.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0531b implements d.a.f0.a.f.d {
        public C0531b(b bVar) {
        }

        @Override // d.a.f0.a.f.d
        public void callback() {
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.C();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements e {
        public d() {
        }

        @Override // d.a.f0.a.f.e
        public void onAdPresent() {
            b.this.G();
        }
    }

    public b(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        this.s = "gif";
    }

    public final void P(String str) {
        try {
            this.N = new FileInputStream(str);
            E();
        } catch (Exception unused) {
        }
        M();
    }

    @Override // d.a.f0.a.d.a, d.a.f0.a.g.b
    public void a() {
        super.a();
        String optString = this.j.optString("cached_path");
        if (!TextUtils.isEmpty(optString)) {
            P(optString);
            return;
        }
        try {
            if (!this.f39796i.c(this.u, MaterialLoader.MaterialCacheType.VIDEO)) {
                MaterialLoader.k(this.f39788a).f(this.u, new a());
            } else {
                P(this.f39796i.b(this.u, MaterialLoader.MaterialCacheType.VIDEO));
            }
        } catch (Throwable unused) {
            D("gif渲染失败");
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
    }

    @Override // d.a.f0.a.d.a, d.a.f0.a.g.b
    public View getAdView() {
        return super.getAdView();
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
    }

    @Override // d.a.f0.a.d.a
    public void v() {
        GifAnimView gifAnimView = this.O;
        if (gifAnimView != null) {
            gifAnimView.setOnClickListener(null);
        }
    }

    @Override // d.a.f0.a.d.a
    public void y() {
        if (this.f39789b != 2) {
            GifAnimView gifAnimView = new GifAnimView(this.f39788a, new C0531b(this));
            this.O = gifAnimView;
            gifAnimView.setGifImage(this.N);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.O.setLayoutParams(layoutParams);
            this.O.setShowDimension(this.l.getWidth(), this.l.getHeight());
            this.O.setAlpha(255);
            this.O.setOnClickListener(new c());
            this.O.i();
            j(this.O, layoutParams);
            this.O.requestLayout();
            this.O.n = new d();
            super.y();
            return;
        }
        this.f39793f.a("XGifAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // d.a.f0.a.d.a
    public void z() {
    }
}
