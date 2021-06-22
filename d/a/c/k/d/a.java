package d.a.c.k.d;

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
    public String f42992a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42993b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42994c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42995d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42996e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42997f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42998g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.d.b f42999h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43000i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.c.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0557a extends BitmapDrawable {
        public C0557a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f42993b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f42993b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42993b = bitmap;
    }

    public void A(int i2) {
    }

    public int B() {
        Bitmap bitmap = this.f42993b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f42993b.getRowBytes();
    }

    public void b(boolean z) {
        this.f42998g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f42993b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42993b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f42993b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f42995d = false;
        Bitmap bitmap2 = this.f42993b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f42993b == null) {
            return;
        }
        this.f42998g.set(true);
        canvas.drawBitmap(this.f42993b, f2, f3, paint);
        this.f42998g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f42993b == null) {
            return;
        }
        this.f42998g.set(true);
        canvas.drawBitmap(this.f42993b, matrix, paint);
        this.f42998g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f42993b == null) {
            return;
        }
        this.f42998g.set(true);
        canvas.drawBitmap(this.f42993b, rect, rectF, paint);
        this.f42998g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f42993b) == null) {
            return;
        }
        this.f42995d = false;
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
        if (this.f42993b == null) {
            return null;
        }
        this.f42995d = false;
        return new C0557a(this.f42993b);
    }

    public byte[] k() {
        return this.f42996e;
    }

    public d.a.c.d.b l() {
        return this.f42999h;
    }

    public int m() {
        Bitmap bitmap = this.f42993b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f42993b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f42993b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f42995d = false;
        return this.f42993b;
    }

    public String q() {
        return this.f42992a;
    }

    public int r() {
        Bitmap bitmap = this.f42993b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.f43000i;
    }

    public boolean t() {
        return this.f42994c;
    }

    public boolean u() {
        return this.f42997f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f42993b != null;
    }

    public boolean x() {
        if (this.f42995d && !this.f42998g.get()) {
            Bitmap bitmap = this.f42993b;
            if (bitmap != null) {
                this.f42993b = null;
                bitmap.recycle();
            }
            d.a.c.d.b bVar = this.f42999h;
            if (bVar != null) {
                this.f42999h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f42997f = z;
    }

    public void z(int i2) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42993b = bitmap;
        this.f42994c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42993b = bitmap;
        this.f42994c = z;
        this.f42992a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42993b = bitmap;
        this.f42994c = z;
        this.f42992a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42993b = bitmap;
        this.f42994c = z;
        this.f42992a = str;
        this.f42996e = bArr;
        c();
    }

    public a(d.a.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42999h = bVar;
        this.f42993b = bitmap;
        this.f42994c = z;
    }

    public a(d.a.c.d.b bVar) {
        this.f42993b = null;
        this.f42994c = false;
        this.f42995d = true;
        this.f42996e = null;
        this.f42997f = true;
        this.f42998g = new AtomicBoolean(false);
        this.f43000i = false;
        this.k = false;
        this.f42999h = bVar;
        this.f43000i = true;
    }
}
