package d.b.b.j.d;

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
    public String f42340a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42341b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42342c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42343d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42344e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42345f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42346g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.d.b f42347h;
    public boolean i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.b.b.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0551a extends BitmapDrawable {
        public C0551a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f42341b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f42341b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42341b = bitmap;
    }

    public void A(int i) {
    }

    public int B() {
        Bitmap bitmap = this.f42341b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f42341b.getRowBytes();
    }

    public void b(boolean z) {
        this.f42346g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f42341b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42341b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f42341b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f42343d = false;
        Bitmap bitmap2 = this.f42341b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f42341b == null) {
            return;
        }
        this.f42346g.set(true);
        canvas.drawBitmap(this.f42341b, f2, f3, paint);
        this.f42346g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f42341b == null) {
            return;
        }
        this.f42346g.set(true);
        canvas.drawBitmap(this.f42341b, matrix, paint);
        this.f42346g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f42341b == null) {
            return;
        }
        this.f42346g.set(true);
        canvas.drawBitmap(this.f42341b, rect, rectF, paint);
        this.f42346g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f42341b) == null) {
            return;
        }
        this.f42343d = false;
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
        if (this.f42341b == null) {
            return null;
        }
        this.f42343d = false;
        return new C0551a(this.f42341b);
    }

    public byte[] k() {
        return this.f42344e;
    }

    public d.b.b.d.b l() {
        return this.f42347h;
    }

    public int m() {
        Bitmap bitmap = this.f42341b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f42341b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f42341b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f42343d = false;
        return this.f42341b;
    }

    public String q() {
        return this.f42340a;
    }

    public int r() {
        Bitmap bitmap = this.f42341b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.i;
    }

    public boolean t() {
        return this.f42342c;
    }

    public boolean u() {
        return this.f42345f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f42341b != null;
    }

    public boolean x() {
        if (this.f42343d && !this.f42346g.get()) {
            Bitmap bitmap = this.f42341b;
            if (bitmap != null) {
                this.f42341b = null;
                bitmap.recycle();
            }
            d.b.b.d.b bVar = this.f42347h;
            if (bVar != null) {
                this.f42347h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f42345f = z;
    }

    public void z(int i) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42341b = bitmap;
        this.f42342c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42341b = bitmap;
        this.f42342c = z;
        this.f42340a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42341b = bitmap;
        this.f42342c = z;
        this.f42340a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42341b = bitmap;
        this.f42342c = z;
        this.f42340a = str;
        this.f42344e = bArr;
        c();
    }

    public a(d.b.b.d.b bVar, Bitmap bitmap, boolean z) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42347h = bVar;
        this.f42341b = bitmap;
        this.f42342c = z;
    }

    public a(d.b.b.d.b bVar) {
        this.f42341b = null;
        this.f42342c = false;
        this.f42343d = true;
        this.f42344e = null;
        this.f42345f = true;
        this.f42346g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42347h = bVar;
        this.i = true;
    }
}
