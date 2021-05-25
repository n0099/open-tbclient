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
    public String f40626a;

    /* renamed from: b  reason: collision with root package name */
    public int f40627b;

    /* renamed from: c  reason: collision with root package name */
    public int f40628c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f40629d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f40630e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f40631f;

    /* renamed from: g  reason: collision with root package name */
    public int f40632g = 0;

    /* renamed from: h  reason: collision with root package name */
    public Uri f40633h;

    /* renamed from: i  reason: collision with root package name */
    public String f40634i;

    /* loaded from: classes2.dex */
    public class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f40635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f40636b;

        public a(DataSource dataSource, b bVar) {
            this.f40635a = dataSource;
            this.f40636b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
            k.this.f40632g = 3;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            if (this.f40635a.isFinished() && bitmap != null) {
                k.this.f40631f = Bitmap.createBitmap(bitmap);
                this.f40635a.close();
                CanvasView canvasView = this.f40636b.l;
                if (canvasView != null) {
                    canvasView.postInvalidate();
                }
            }
            k.this.f40632g = 2;
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (h(bVar)) {
            int alpha = bVar.f40589h.getAlpha();
            bVar.d(bVar.f40589h);
            Rect rect = this.f40630e;
            if (rect != null) {
                canvas.drawBitmap(this.f40631f, this.f40629d, rect, bVar.f40589h);
            } else {
                canvas.drawBitmap(this.f40631f, this.f40627b, this.f40628c, bVar.f40589h);
            }
            bVar.f40589h.setAlpha(alpha);
            return;
        }
        try {
            j(bVar);
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
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
                this.f40634i = this.f40626a;
                String optString = jSONArray.optString(0);
                this.f40626a = optString;
                this.f40626a = f(Q, optString);
            }
            if (length > 2) {
                this.f40627b = i(jSONArray, 1);
                this.f40628c = i(jSONArray, 2);
            }
            if (length > 4) {
                int i2 = this.f40627b;
                int i3 = this.f40628c;
                int i4 = i(jSONArray, 3);
                int i5 = i(jSONArray, 4);
                if (i4 > 0 && i5 > 0) {
                    this.f40630e = new Rect(i2, i3, i4 + i2, i5 + i3);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.f40629d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            if (Q != null) {
                String g2 = g(this.f40626a, Q);
                if (!TextUtils.isEmpty(g2)) {
                    this.f40631f = BitmapFactory.decodeFile(g2);
                } else if (TextUtils.isEmpty(this.f40626a)) {
                } else {
                    if (this.f40633h == null || !TextUtils.equals(this.f40626a, this.f40634i)) {
                        this.f40633h = Uri.parse(this.f40626a);
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(this.f40626a) || this.f40631f == null || hashMap.containsKey(this.f40626a)) {
            return;
        }
        hashMap.put(this.f40626a, this.f40631f);
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
                    str = d.a.l0.a.k2.b.M(str, eVar.f40749f);
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
        if (this.f40631f != null) {
            return true;
        }
        if (this.f40633h == null || bVar == null || (canvasView = bVar.l) == null) {
            return false;
        }
        Bitmap e2 = canvasView.e(this.f40626a);
        this.f40631f = e2;
        if (e2 != null) {
            return true;
        }
        Bitmap c2 = d.a.l0.a.v2.t.c(this.f40633h, bVar.l.getContext());
        this.f40631f = c2;
        return c2 != null;
    }

    public final int i(JSONArray jSONArray, int i2) {
        return d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(i2));
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        if (this.f40632g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f40626a)) {
            return;
        }
        this.f40632g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f40626a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
