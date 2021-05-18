package d.a.d0.a.d;

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
public class c extends d.a.d0.a.d.a {
    public ImageView N;
    public Bitmap O;

    /* loaded from: classes2.dex */
    public class a implements d.a.d0.a.e.a {
        public a() {
        }

        @Override // d.a.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            c cVar = c.this;
            cVar.D("StaticImage Load Failed: " + materialLoadErrorCode.toString());
        }

        @Override // d.a.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            c.this.M();
            c.this.E();
        }

        @Override // d.a.d0.a.e.a
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

    /* renamed from: d.a.d0.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0526c implements d.a.d0.a.e.a {
        public C0526c() {
        }

        @Override // d.a.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            c cVar = c.this;
            cVar.D("Get Static Image error: " + materialLoadErrorCode.getMessage());
        }

        @Override // d.a.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            c.this.O = bitmap;
        }

        @Override // d.a.d0.a.e.a
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
        this.O = this.f39810i.a(this.u, new C0526c());
    }

    @Override // d.a.d0.a.d.a, d.a.d0.a.g.b
    public void a() {
        super.a();
        if (this.f39810i.c(this.u, MaterialLoader.MaterialCacheType.PICTURE)) {
            M();
            E();
            return;
        }
        try {
            MaterialLoader.k(this.f39802a).f(this.u, new a());
        } catch (Exception e2) {
            D("StaticImage,Exception: " + e2.toString());
        }
    }

    @Override // d.a.d0.a.d.a, d.a.d0.a.g.b
    public void b(d.a.d0.a.g.c cVar) {
        super.b(cVar);
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
    }

    @Override // d.a.d0.a.d.a, d.a.d0.a.g.b
    public void d(d.a.d0.a.g.a aVar) {
        super.d(aVar);
    }

    @Override // d.a.d0.a.d.a, d.a.d0.a.g.b
    public void destroy() {
        super.destroy();
        this.N = null;
    }

    @Override // d.a.d0.a.d.a, d.a.d0.a.g.b
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
    }

    @Override // d.a.d0.a.d.a
    public void v() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
    }

    @Override // d.a.d0.a.d.a
    public void y() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f39803b != 2) {
            try {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                ImageView imageView = new ImageView(this.f39802a);
                this.N = imageView;
                imageView.setVisibility(0);
                this.N.setOnClickListener(new b());
                this.N.setLayoutParams(layoutParams);
                P();
            } catch (Exception e2) {
                this.f39807f.c(d.a.d0.a.d.a.M, e2);
                D(d.a.d0.a.d.a.M + " exception=" + Log.getStackTraceString(e2));
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
        this.f39807f.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // d.a.d0.a.d.a
    public void z() {
        AdView adView;
        this.f39807f.j(d.a.d0.a.d.a.M, "doStopOnUIThread");
        ImageView imageView = this.N;
        if (imageView != null && (adView = this.l) != null && adView.indexOfChild(imageView) >= 0) {
            this.f39807f.j(d.a.d0.a.d.a.M, "doStopOnUIThread release imageView");
            if (this.N.getDrawingCache() != null) {
                this.N.getDrawingCache().recycle();
            }
            this.l.removeAllViews();
        }
        Bitmap bitmap = this.O;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        d.a.d0.a.k.b bVar = this.f39807f;
        String str = d.a.d0.a.d.a.M;
        bVar.j(str, "doStopOnUIThread release newBitmap->" + this.O.toString());
        this.O.recycle();
        this.O = null;
    }
}
