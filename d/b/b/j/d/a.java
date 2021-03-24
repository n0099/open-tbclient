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
    public String f42339a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42340b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42341c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42342d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42343e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42344f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42345g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.d.b f42346h;
    public boolean i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.b.b.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0550a extends BitmapDrawable {
        public C0550a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f42340b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f42340b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42340b = bitmap;
    }

    public void A(int i) {
    }

    public int B() {
        Bitmap bitmap = this.f42340b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f42340b.getRowBytes();
    }

    public void b(boolean z) {
        this.f42345g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f42340b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42340b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f42340b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f42342d = false;
        Bitmap bitmap2 = this.f42340b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f42340b == null) {
            return;
        }
        this.f42345g.set(true);
        canvas.drawBitmap(this.f42340b, f2, f3, paint);
        this.f42345g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f42340b == null) {
            return;
        }
        this.f42345g.set(true);
        canvas.drawBitmap(this.f42340b, matrix, paint);
        this.f42345g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f42340b == null) {
            return;
        }
        this.f42345g.set(true);
        canvas.drawBitmap(this.f42340b, rect, rectF, paint);
        this.f42345g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f42340b) == null) {
            return;
        }
        this.f42342d = false;
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
        if (this.f42340b == null) {
            return null;
        }
        this.f42342d = false;
        return new C0550a(this.f42340b);
    }

    public byte[] k() {
        return this.f42343e;
    }

    public d.b.b.d.b l() {
        return this.f42346h;
    }

    public int m() {
        Bitmap bitmap = this.f42340b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f42340b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f42340b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f42342d = false;
        return this.f42340b;
    }

    public String q() {
        return this.f42339a;
    }

    public int r() {
        Bitmap bitmap = this.f42340b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.i;
    }

    public boolean t() {
        return this.f42341c;
    }

    public boolean u() {
        return this.f42344f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f42340b != null;
    }

    public boolean x() {
        if (this.f42342d && !this.f42345g.get()) {
            Bitmap bitmap = this.f42340b;
            if (bitmap != null) {
                this.f42340b = null;
                bitmap.recycle();
            }
            d.b.b.d.b bVar = this.f42346h;
            if (bVar != null) {
                this.f42346h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f42344f = z;
    }

    public void z(int i) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42340b = bitmap;
        this.f42341c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42340b = bitmap;
        this.f42341c = z;
        this.f42339a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42340b = bitmap;
        this.f42341c = z;
        this.f42339a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42340b = bitmap;
        this.f42341c = z;
        this.f42339a = str;
        this.f42343e = bArr;
        c();
    }

    public a(d.b.b.d.b bVar, Bitmap bitmap, boolean z) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42346h = bVar;
        this.f42340b = bitmap;
        this.f42341c = z;
    }

    public a(d.b.b.d.b bVar) {
        this.f42340b = null;
        this.f42341c = false;
        this.f42342d = true;
        this.f42343e = null;
        this.f42344f = true;
        this.f42345g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f42346h = bVar;
        this.i = true;
    }
}
