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
    public String f40299a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f40300b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f40301c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40302d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f40303e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40304f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f40305g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.d.b f40306h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40307i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.c.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0527a extends BitmapDrawable {
        public C0527a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f40300b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f40300b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40300b = bitmap;
    }

    public void A(int i2) {
    }

    public int B() {
        Bitmap bitmap = this.f40300b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f40300b.getRowBytes();
    }

    public void b(boolean z) {
        this.f40305g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f40300b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f40300b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f40300b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f40302d = false;
        Bitmap bitmap2 = this.f40300b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f40300b == null) {
            return;
        }
        this.f40305g.set(true);
        canvas.drawBitmap(this.f40300b, f2, f3, paint);
        this.f40305g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f40300b == null) {
            return;
        }
        this.f40305g.set(true);
        canvas.drawBitmap(this.f40300b, matrix, paint);
        this.f40305g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f40300b == null) {
            return;
        }
        this.f40305g.set(true);
        canvas.drawBitmap(this.f40300b, rect, rectF, paint);
        this.f40305g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f40300b) == null) {
            return;
        }
        this.f40302d = false;
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
        if (this.f40300b == null) {
            return null;
        }
        this.f40302d = false;
        return new C0527a(this.f40300b);
    }

    public byte[] k() {
        return this.f40303e;
    }

    public d.a.c.d.b l() {
        return this.f40306h;
    }

    public int m() {
        Bitmap bitmap = this.f40300b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f40300b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f40300b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f40302d = false;
        return this.f40300b;
    }

    public String q() {
        return this.f40299a;
    }

    public int r() {
        Bitmap bitmap = this.f40300b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.f40307i;
    }

    public boolean t() {
        return this.f40301c;
    }

    public boolean u() {
        return this.f40304f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f40300b != null;
    }

    public boolean x() {
        if (this.f40302d && !this.f40305g.get()) {
            Bitmap bitmap = this.f40300b;
            if (bitmap != null) {
                this.f40300b = null;
                bitmap.recycle();
            }
            d.a.c.d.b bVar = this.f40306h;
            if (bVar != null) {
                this.f40306h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f40304f = z;
    }

    public void z(int i2) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40300b = bitmap;
        this.f40301c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40300b = bitmap;
        this.f40301c = z;
        this.f40299a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40300b = bitmap;
        this.f40301c = z;
        this.f40299a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40300b = bitmap;
        this.f40301c = z;
        this.f40299a = str;
        this.f40303e = bArr;
        c();
    }

    public a(d.a.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40306h = bVar;
        this.f40300b = bitmap;
        this.f40301c = z;
    }

    public a(d.a.c.d.b bVar) {
        this.f40300b = null;
        this.f40301c = false;
        this.f40302d = true;
        this.f40303e = null;
        this.f40304f = true;
        this.f40305g = new AtomicBoolean(false);
        this.f40307i = false;
        this.k = false;
        this.f40306h = bVar;
        this.f40307i = true;
    }
}
