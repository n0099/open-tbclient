package d.a.c.j.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object m = new Object();

    /* renamed from: a  reason: collision with root package name */
    public String f39544a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f39545b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39546c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39547d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f39548e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39549f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f39550g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.d.b f39551h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39552i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.c.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0514a extends BitmapDrawable {
        public C0514a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f39545b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f39545b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39545b = bitmap;
    }

    public void A(int i2) {
    }

    public int B() {
        Bitmap bitmap = this.f39545b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f39545b.getRowBytes();
    }

    public void b(boolean z) {
        this.f39550g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f39545b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f39545b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f39545b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f39547d = false;
        Bitmap bitmap2 = this.f39545b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f39545b == null) {
            return;
        }
        this.f39550g.set(true);
        canvas.drawBitmap(this.f39545b, f2, f3, paint);
        this.f39550g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f39545b == null) {
            return;
        }
        this.f39550g.set(true);
        canvas.drawBitmap(this.f39545b, matrix, paint);
        this.f39550g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f39545b == null) {
            return;
        }
        this.f39550g.set(true);
        canvas.drawBitmap(this.f39545b, rect, rectF, paint);
        this.f39550g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f39545b) == null) {
            return;
        }
        this.f39547d = false;
        imageView.setImageBitmap(bitmap);
    }

    public void i(Canvas canvas, RectF rectF) {
        NinePatch ninePatch;
        if (!this.k || (ninePatch = this.l) == null) {
            return;
        }
        ninePatch.draw(canvas, rectF);
    }

    public BitmapDrawable j() {
        if (this.f39545b == null) {
            return null;
        }
        this.f39547d = false;
        return new C0514a(this.f39545b);
    }

    public byte[] k() {
        return this.f39548e;
    }

    public d.a.c.d.b l() {
        return this.f39551h;
    }

    public int m() {
        Bitmap bitmap = this.f39545b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f39545b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f39545b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f39547d = false;
        return this.f39545b;
    }

    public String q() {
        return this.f39544a;
    }

    public int r() {
        Bitmap bitmap = this.f39545b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.f39552i;
    }

    public boolean t() {
        return this.f39546c;
    }

    public boolean u() {
        return this.f39549f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f39545b != null;
    }

    public boolean x() {
        if (this.f39547d && !this.f39550g.get()) {
            Bitmap bitmap = this.f39545b;
            if (bitmap != null) {
                this.f39545b = null;
                bitmap.recycle();
            }
            d.a.c.d.b bVar = this.f39551h;
            if (bVar != null) {
                this.f39551h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f39549f = z;
    }

    public void z(int i2) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39545b = bitmap;
        this.f39546c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39545b = bitmap;
        this.f39546c = z;
        this.f39544a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39545b = bitmap;
        this.f39546c = z;
        this.f39544a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39545b = bitmap;
        this.f39546c = z;
        this.f39544a = str;
        this.f39548e = bArr;
        c();
    }

    public a(d.a.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39551h = bVar;
        this.f39545b = bitmap;
        this.f39546c = z;
    }

    public a(d.a.c.d.b bVar) {
        this.f39545b = null;
        this.f39546c = false;
        this.f39547d = true;
        this.f39548e = null;
        this.f39549f = true;
        this.f39550g = new AtomicBoolean(false);
        this.f39552i = false;
        this.k = false;
        this.f39551h = bVar;
        this.f39552i = true;
    }
}
