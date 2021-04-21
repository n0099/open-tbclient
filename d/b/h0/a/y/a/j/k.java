package d.b.h0.a.y.a.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k extends d.b.h0.a.y.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    public String f47729a;

    /* renamed from: b  reason: collision with root package name */
    public int f47730b;

    /* renamed from: c  reason: collision with root package name */
    public int f47731c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f47732d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f47733e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f47734f;

    /* renamed from: g  reason: collision with root package name */
    public int f47735g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f47736h;
    public String i;

    /* loaded from: classes2.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f47737a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47738b;

        public a(DataSource dataSource, b bVar) {
            this.f47737a = dataSource;
            this.f47738b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
            k.this.f47735g = 3;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (this.f47737a.isFinished() && bitmap != null) {
                k.this.f47734f = Bitmap.createBitmap(bitmap);
                this.f47737a.close();
                CanvasView canvasView = this.f47738b.l;
                if (canvasView != null) {
                    canvasView.postInvalidate();
                }
            }
            k.this.f47735g = 2;
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (g(bVar)) {
            int alpha = bVar.f47693h.getAlpha();
            bVar.d(bVar.f47693h);
            Rect rect = this.f47733e;
            if (rect != null) {
                canvas.drawBitmap(this.f47734f, this.f47732d, rect, bVar.f47693h);
            } else {
                canvas.drawBitmap(this.f47734f, this.f47730b, this.f47731c, bVar.f47693h);
            }
            bVar.f47693h.setAlpha(alpha);
            return;
        }
        try {
            i(bVar);
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.i = this.f47729a;
                this.f47729a = jSONArray.optString(0);
            }
            if (length > 2) {
                this.f47730b = h(jSONArray, 1);
                this.f47731c = h(jSONArray, 2);
            }
            if (length > 4) {
                int i = this.f47730b;
                int i2 = this.f47731c;
                int h2 = h(jSONArray, 3);
                int h3 = h(jSONArray, 4);
                if (h2 > 0 && h3 > 0) {
                    this.f47733e = new Rect(i, i2, h2 + i, h3 + i2);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.f47732d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            d.b.h0.a.r1.e t = d.b.h0.a.z0.f.V().t();
            if (t != null) {
                String f2 = f(this.f47729a, t);
                if (!TextUtils.isEmpty(f2)) {
                    this.f47734f = BitmapFactory.decodeFile(f2);
                } else if (TextUtils.isEmpty(this.f47729a)) {
                } else {
                    if (this.f47736h == null || !TextUtils.equals(this.f47729a, this.i)) {
                        this.f47736h = Uri.parse(this.f47729a);
                    }
                }
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(this.f47729a) || this.f47734f == null || hashMap.containsKey(this.f47729a)) {
            return;
        }
        hashMap.put(this.f47729a, this.f47734f);
    }

    public final String f(String str, d.b.h0.a.r1.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    str = d.b.h0.a.a2.b.u(str, eVar.f46461f);
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    return file.getAbsolutePath();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean g(b bVar) {
        CanvasView canvasView;
        if (this.f47734f != null) {
            return true;
        }
        if (this.f47736h == null || bVar == null || (canvasView = bVar.l) == null) {
            return false;
        }
        Bitmap e2 = canvasView.e(this.f47729a);
        this.f47734f = e2;
        if (e2 != null) {
            return true;
        }
        Bitmap c2 = d.b.h0.a.i2.s.c(this.f47736h, bVar.l.getContext());
        this.f47734f = c2;
        return c2 != null;
    }

    public final int h(JSONArray jSONArray, int i) {
        return d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(i));
    }

    @UiThread
    public final void i(b bVar) {
        CanvasView canvasView;
        if (this.f47735g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f47729a)) {
            return;
        }
        this.f47735g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f47729a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
