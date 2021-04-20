package d.b.c0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.gif.GifAnimView;
import d.b.c0.a.f.e;
import java.io.FileInputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.c0.a.d.a {
    public FileInputStream N;
    public GifAnimView O;

    /* loaded from: classes2.dex */
    public class a implements d.b.c0.a.e.a {
        public a() {
        }

        @Override // d.b.c0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            b.this.D("cache gif, load failed");
        }

        @Override // d.b.c0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            b bVar = b.this;
            bVar.P(MaterialLoader.k(bVar.f42996a).l(str));
        }

        @Override // d.b.c0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: d.b.c0.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0577b implements d.b.c0.a.f.d {
        public C0577b(b bVar) {
        }

        @Override // d.b.c0.a.f.d
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

        @Override // d.b.c0.a.f.e
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

    @Override // d.b.c0.a.d.a, d.b.c0.a.g.b
    public void b() {
        super.b();
        String optString = this.j.optString("cached_path");
        if (!TextUtils.isEmpty(optString)) {
            P(optString);
            return;
        }
        try {
            if (!this.i.c(this.u, MaterialLoader.MaterialCacheType.VIDEO)) {
                MaterialLoader.k(this.f42996a).f(this.u, new a());
            } else {
                P(this.i.b(this.u, MaterialLoader.MaterialCacheType.VIDEO));
            }
        } catch (Throwable unused) {
            D("gif渲染失败");
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i, int i2) {
    }

    @Override // d.b.c0.a.d.a, d.b.c0.a.g.b
    public void destroy() {
        super.destroy();
    }

    @Override // d.b.c0.a.d.a, d.b.c0.a.g.b
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
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // d.b.c0.a.d.a
    public void v() {
        GifAnimView gifAnimView = this.O;
        if (gifAnimView != null) {
            gifAnimView.setOnClickListener(null);
        }
    }

    @Override // d.b.c0.a.d.a
    public void y() {
        if (this.f42997b != 2) {
            GifAnimView gifAnimView = new GifAnimView(this.f42996a, new C0577b(this));
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
        this.f43001f.a("XGifAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // d.b.c0.a.d.a
    public void z() {
    }
}
