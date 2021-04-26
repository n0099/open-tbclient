package d.a.h0.a.y.a.j;

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
public class k extends d.a.h0.a.y.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    public String f45162a;

    /* renamed from: b  reason: collision with root package name */
    public int f45163b;

    /* renamed from: c  reason: collision with root package name */
    public int f45164c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f45165d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f45166e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f45167f;

    /* renamed from: g  reason: collision with root package name */
    public int f45168g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f45169h;

    /* renamed from: i  reason: collision with root package name */
    public String f45170i;

    /* loaded from: classes2.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f45171a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f45172b;

        public a(DataSource dataSource, b bVar) {
            this.f45171a = dataSource;
            this.f45172b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
            k.this.f45168g = 3;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (this.f45171a.isFinished() && bitmap != null) {
                k.this.f45167f = Bitmap.createBitmap(bitmap);
                this.f45171a.close();
                CanvasView canvasView = this.f45172b.l;
                if (canvasView != null) {
                    canvasView.postInvalidate();
                }
            }
            k.this.f45168g = 2;
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (g(bVar)) {
            int alpha = bVar.f45125h.getAlpha();
            bVar.d(bVar.f45125h);
            Rect rect = this.f45166e;
            if (rect != null) {
                canvas.drawBitmap(this.f45167f, this.f45165d, rect, bVar.f45125h);
            } else {
                canvas.drawBitmap(this.f45167f, this.f45163b, this.f45164c, bVar.f45125h);
            }
            bVar.f45125h.setAlpha(alpha);
            return;
        }
        try {
            i(bVar);
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.f45170i = this.f45162a;
                this.f45162a = jSONArray.optString(0);
            }
            if (length > 2) {
                this.f45163b = h(jSONArray, 1);
                this.f45164c = h(jSONArray, 2);
            }
            if (length > 4) {
                int i2 = this.f45163b;
                int i3 = this.f45164c;
                int h2 = h(jSONArray, 3);
                int h3 = h(jSONArray, 4);
                if (h2 > 0 && h3 > 0) {
                    this.f45166e = new Rect(i2, i3, h2 + i2, h3 + i3);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.f45165d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            d.a.h0.a.r1.e F = d.a.h0.a.z0.f.V().F();
            if (F != null) {
                String f2 = f(this.f45162a, F);
                if (!TextUtils.isEmpty(f2)) {
                    this.f45167f = BitmapFactory.decodeFile(f2);
                } else if (TextUtils.isEmpty(this.f45162a)) {
                } else {
                    if (this.f45169h == null || !TextUtils.equals(this.f45162a, this.f45170i)) {
                        this.f45169h = Uri.parse(this.f45162a);
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(this.f45162a) || this.f45167f == null || hashMap.containsKey(this.f45162a)) {
            return;
        }
        hashMap.put(this.f45162a, this.f45167f);
    }

    public final String f(String str, d.a.h0.a.r1.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    str = d.a.h0.a.a2.b.u(str, eVar.f43823f);
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
        if (this.f45167f != null) {
            return true;
        }
        if (this.f45169h == null || bVar == null || (canvasView = bVar.l) == null) {
            return false;
        }
        Bitmap e2 = canvasView.e(this.f45162a);
        this.f45167f = e2;
        if (e2 != null) {
            return true;
        }
        Bitmap c2 = d.a.h0.a.i2.s.c(this.f45169h, bVar.l.getContext());
        this.f45167f = c2;
        return c2 != null;
    }

    public final int h(JSONArray jSONArray, int i2) {
        return d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(i2));
    }

    @UiThread
    public final void i(b bVar) {
        CanvasView canvasView;
        if (this.f45168g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f45162a)) {
            return;
        }
        this.f45168g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f45162a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
