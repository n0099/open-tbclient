package d.b.d0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AdView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.d0.a.d.a {
    public ImageView N;
    public Bitmap O;

    /* loaded from: classes2.dex */
    public class a implements d.b.d0.a.e.a {
        public a() {
        }

        @Override // d.b.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            c cVar = c.this;
            cVar.D("StaticImage Load Failed: " + materialLoadErrorCode.toString());
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            c.this.M();
            c.this.E();
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.C();
        }
    }

    /* renamed from: d.b.d0.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0600c implements d.b.d0.a.e.a {
        public C0600c() {
        }

        @Override // d.b.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            c cVar = c.this;
            cVar.D("Get Static Image error: " + materialLoadErrorCode.getMessage());
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            c.this.O = bitmap;
        }

        @Override // d.b.d0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    public c(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        this.s = "image";
    }

    public final void P() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setScaleType(this.G == 17 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
        }
        this.O = this.i.a(this.u, new C0600c());
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void a(d.b.d0.a.g.c cVar) {
        super.a(cVar);
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void b() {
        super.b();
        if (this.i.c(this.u, MaterialLoader.MaterialCacheType.PICTURE)) {
            M();
            E();
            return;
        }
        try {
            MaterialLoader.k(this.f43318a).f(this.u, new a());
        } catch (Exception e2) {
            D("StaticImage,Exception: " + e2.toString());
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i, int i2) {
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void d(d.b.d0.a.g.a aVar) {
        super.d(aVar);
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void destroy() {
        super.destroy();
        this.N = null;
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public View getAdView() {
        return super.getAdView();
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        N();
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

    @Override // d.b.d0.a.d.a
    public void v() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
    }

    @Override // d.b.d0.a.d.a
    public void y() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f43319b != 2) {
            try {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                ImageView imageView = new ImageView(this.f43318a);
                this.N = imageView;
                imageView.setVisibility(0);
                this.N.setOnClickListener(new b());
                this.N.setLayoutParams(layoutParams);
                P();
            } catch (Exception e2) {
                this.f43323f.c(d.b.d0.a.d.a.M, e2);
                D(d.b.d0.a.d.a.M + " exception=" + Log.getStackTraceString(e2));
            }
            if (this.O == null) {
                return;
            }
            this.N.setDrawingCacheEnabled(true);
            this.N.setImageBitmap(this.O);
            j(this.N, layoutParams);
            this.N.requestLayout();
            super.y();
            this.N.requestFocus();
            G();
            return;
        }
        this.f43323f.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // d.b.d0.a.d.a
    public void z() {
        AdView adView;
        this.f43323f.j(d.b.d0.a.d.a.M, "doStopOnUIThread");
        ImageView imageView = this.N;
        if (imageView != null && (adView = this.l) != null && adView.indexOfChild(imageView) >= 0) {
            this.f43323f.j(d.b.d0.a.d.a.M, "doStopOnUIThread release imageView");
            if (this.N.getDrawingCache() != null) {
                this.N.getDrawingCache().recycle();
            }
            this.l.removeAllViews();
        }
        Bitmap bitmap = this.O;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        d.b.d0.a.k.b bVar = this.f43323f;
        String str = d.b.d0.a.d.a.M;
        bVar.j(str, "doStopOnUIThread release newBitmap->" + this.O.toString());
        this.O.recycle();
        this.O = null;
    }
}
