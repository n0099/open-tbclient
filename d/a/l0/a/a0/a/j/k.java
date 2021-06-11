package d.a.l0.a.a0.a.j;

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
public class k extends d.a.l0.a.a0.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    public String f44302a;

    /* renamed from: b  reason: collision with root package name */
    public int f44303b;

    /* renamed from: c  reason: collision with root package name */
    public int f44304c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f44305d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f44306e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f44307f;

    /* renamed from: g  reason: collision with root package name */
    public int f44308g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f44309h;

    /* renamed from: i  reason: collision with root package name */
    public String f44310i;

    /* loaded from: classes2.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f44311a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f44312b;

        public a(DataSource dataSource, b bVar) {
            this.f44311a = dataSource;
            this.f44312b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
            k.this.f44308g = 3;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (this.f44311a.isFinished() && bitmap != null) {
                k.this.f44307f = Bitmap.createBitmap(bitmap);
                this.f44311a.close();
                CanvasView canvasView = this.f44312b.l;
                if (canvasView != null) {
                    canvasView.postInvalidate();
                }
            }
            k.this.f44308g = 2;
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (h(bVar)) {
            int alpha = bVar.f44265h.getAlpha();
            bVar.d(bVar.f44265h);
            Rect rect = this.f44306e;
            if (rect != null) {
                canvas.drawBitmap(this.f44307f, this.f44305d, rect, bVar.f44265h);
            } else {
                canvas.drawBitmap(this.f44307f, this.f44303b, this.f44304c, bVar.f44265h);
            }
            bVar.f44265h.setAlpha(alpha);
            return;
        }
        try {
            j(bVar);
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.f44310i = this.f44302a;
                String optString = jSONArray.optString(0);
                this.f44302a = optString;
                this.f44302a = f(Q, optString);
            }
            if (length > 2) {
                this.f44303b = i(jSONArray, 1);
                this.f44304c = i(jSONArray, 2);
            }
            if (length > 4) {
                int i2 = this.f44303b;
                int i3 = this.f44304c;
                int i4 = i(jSONArray, 3);
                int i5 = i(jSONArray, 4);
                if (i4 > 0 && i5 > 0) {
                    this.f44306e = new Rect(i2, i3, i4 + i2, i5 + i3);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.f44305d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            if (Q != null) {
                String g2 = g(this.f44302a, Q);
                if (!TextUtils.isEmpty(g2)) {
                    this.f44307f = BitmapFactory.decodeFile(g2);
                } else if (TextUtils.isEmpty(this.f44302a)) {
                } else {
                    if (this.f44309h == null || !TextUtils.equals(this.f44302a, this.f44310i)) {
                        this.f44309h = Uri.parse(this.f44302a);
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(this.f44302a) || this.f44307f == null || hashMap.containsKey(this.f44302a)) {
            return;
        }
        hashMap.put(this.f44302a, this.f44307f);
    }

    public final String f(d.a.l0.a.a2.e eVar, String str) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(d.a.l0.a.v2.q0.x(eVar).getPath())) ? str : d.a.l0.a.v2.q0.w(eVar, str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final String g(String str, d.a.l0.a.a2.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    str = d.a.l0.a.k2.b.M(str, eVar.f44425f);
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

    public final boolean h(b bVar) {
        CanvasView canvasView;
        if (this.f44307f != null) {
            return true;
        }
        if (this.f44309h == null || bVar == null || (canvasView = bVar.l) == null) {
            return false;
        }
        Bitmap e2 = canvasView.e(this.f44302a);
        this.f44307f = e2;
        if (e2 != null) {
            return true;
        }
        Bitmap c2 = d.a.l0.a.v2.t.c(this.f44309h, bVar.l.getContext());
        this.f44307f = c2;
        return c2 != null;
    }

    public final int i(JSONArray jSONArray, int i2) {
        return d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(i2));
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        if (this.f44308g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f44302a)) {
            return;
        }
        this.f44308g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f44302a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
