package d.b.c.j.d;

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
    public String f42837a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42838b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42839c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42840d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42841e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42842f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42843g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.d.b f42844h;
    public boolean i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.b.c.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0569a extends BitmapDrawable {
        public C0569a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f42838b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f42838b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42838b = bitmap;
    }

    public void A(int i) {
    }

    public int B() {
        Bitmap bitmap = this.f42838b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f42838b.getRowBytes();
    }

    public void b(boolean z) {
        this.f42843g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f42838b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42838b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f42838b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f42840d = false;
        Bitmap bitmap2 = this.f42838b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f42838b == null) {
            return;
        }
        this.f42843g.set(true);
        canvas.drawBitmap(this.f42838b, f2, f3, paint);
        this.f42843g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f42838b == null) {
            return;
        }
        this.f42843g.set(true);
        canvas.drawBitmap(this.f42838b, matrix, paint);
        this.f42843g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f42838b == null) {
            return;
        }
        this.f42843g.set(true);
        canvas.drawBitmap(this.f42838b, rect, rectF, paint);
        this.f42843g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f42838b) == null) {
            return;
        }
        this.f42840d = false;
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
        if (this.f42838b == null) {
            return null;
        }
        this.f42840d = false;
        return new C0569a(this.f42838b);
    }

    public byte[] k() {
        return this.f42841e;
    }

    public d.b.c.d.b l() {
        return this.f42844h;
    }

    public int m() {
        Bitmap bitmap = this.f42838b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f42838b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f42838b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f42840d = false;
        return this.f42838b;
    }

    public String q() {
        return this.f42837a;
    }

    public int r() {
        Bitmap bitmap = this.f42838b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.i;
    }

    public boolean t() {
        return this.f42839c;
    }

    public boolean u() {
        return this.f42842f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f42838b != null;
    }

    public boolean x() {
        if (this.f42840d && !this.f42843g.get()) {
            Bitmap bitmap = this.f42838b;
            if (bitmap != null) {
                this.f42838b = null;
                bitmap.recycle();
            }
            d.b.c.d.b bVar = this.f42844h;
            if (bVar != null) {
                this.f42844h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f42842f = z;
    }

    public void z(int i) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42838b = bitmap;
        this.f42839c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42838b = bitmap;
        this.f42839c = z;
        this.f42837a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42838b = bitmap;
        this.f42839c = z;
        this.f42837a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42838b = bitmap;
        this.f42839c = z;
        this.f42837a = str;
        this.f42841e = bArr;
        c();
    }

    public a(d.b.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42844h = bVar;
        this.f42838b = bitmap;
        this.f42839c = z;
    }

    public a(d.b.c.d.b bVar) {
        this.f42838b = null;
        this.f42839c = false;
        this.f42840d = true;
        this.f42841e = null;
        this.f42842f = true;
        this.f42843g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42844h = bVar;
        this.i = true;
    }
}
