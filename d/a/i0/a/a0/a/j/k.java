package d.a.i0.a.a0.a.j;

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
public class k extends d.a.i0.a.a0.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    public String f40452a;

    /* renamed from: b  reason: collision with root package name */
    public int f40453b;

    /* renamed from: c  reason: collision with root package name */
    public int f40454c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f40455d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f40456e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f40457f;

    /* renamed from: g  reason: collision with root package name */
    public int f40458g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f40459h;

    /* renamed from: i  reason: collision with root package name */
    public String f40460i;

    /* loaded from: classes2.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f40461a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f40462b;

        public a(DataSource dataSource, b bVar) {
            this.f40461a = dataSource;
            this.f40462b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
            k.this.f40458g = 3;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (this.f40461a.isFinished() && bitmap != null) {
                k.this.f40457f = Bitmap.createBitmap(bitmap);
                this.f40461a.close();
                CanvasView canvasView = this.f40462b.l;
                if (canvasView != null) {
                    canvasView.postInvalidate();
                }
            }
            k.this.f40458g = 2;
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (h(bVar)) {
            int alpha = bVar.f40415h.getAlpha();
            bVar.d(bVar.f40415h);
            Rect rect = this.f40456e;
            if (rect != null) {
                canvas.drawBitmap(this.f40457f, this.f40455d, rect, bVar.f40415h);
            } else {
                canvas.drawBitmap(this.f40457f, this.f40453b, this.f40454c, bVar.f40415h);
            }
            bVar.f40415h.setAlpha(alpha);
            return;
        }
        try {
            j(bVar);
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.f40460i = this.f40452a;
                String optString = jSONArray.optString(0);
                this.f40452a = optString;
                this.f40452a = f(Q, optString);
            }
            if (length > 2) {
                this.f40453b = i(jSONArray, 1);
                this.f40454c = i(jSONArray, 2);
            }
            if (length > 4) {
                int i2 = this.f40453b;
                int i3 = this.f40454c;
                int i4 = i(jSONArray, 3);
                int i5 = i(jSONArray, 4);
                if (i4 > 0 && i5 > 0) {
                    this.f40456e = new Rect(i2, i3, i4 + i2, i5 + i3);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.f40455d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            if (Q != null) {
                String g2 = g(this.f40452a, Q);
                if (!TextUtils.isEmpty(g2)) {
                    this.f40457f = BitmapFactory.decodeFile(g2);
                } else if (TextUtils.isEmpty(this.f40452a)) {
                } else {
                    if (this.f40459h == null || !TextUtils.equals(this.f40452a, this.f40460i)) {
                        this.f40459h = Uri.parse(this.f40452a);
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(this.f40452a) || this.f40457f == null || hashMap.containsKey(this.f40452a)) {
            return;
        }
        hashMap.put(this.f40452a, this.f40457f);
    }

    public final String f(d.a.i0.a.a2.e eVar, String str) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(d.a.i0.a.v2.q0.x(eVar).getPath())) ? str : d.a.i0.a.v2.q0.w(eVar, str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final String g(String str, d.a.i0.a.a2.e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    str = d.a.i0.a.k2.b.M(str, eVar.f40575f);
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
        if (this.f40457f != null) {
            return true;
        }
        if (this.f40459h == null || bVar == null || (canvasView = bVar.l) == null) {
            return false;
        }
        Bitmap e2 = canvasView.e(this.f40452a);
        this.f40457f = e2;
        if (e2 != null) {
            return true;
        }
        Bitmap c2 = d.a.i0.a.v2.t.c(this.f40459h, bVar.l.getContext());
        this.f40457f = c2;
        return c2 != null;
    }

    public final int i(JSONArray jSONArray, int i2) {
        return d.a.i0.a.v2.n0.g((float) jSONArray.optDouble(i2));
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        if (this.f40458g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f40452a)) {
            return;
        }
        this.f40458g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f40452a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
