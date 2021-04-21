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
    public String f43077a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f43078b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f43079c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43080d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f43081e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43082f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f43083g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.d.b f43084h;
    public boolean i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.b.c.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0588a extends BitmapDrawable {
        public C0588a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f43078b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f43078b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43078b = bitmap;
    }

    public void A(int i) {
    }

    public int B() {
        Bitmap bitmap = this.f43078b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f43078b.getRowBytes();
    }

    public void b(boolean z) {
        this.f43083g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f43078b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f43078b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f43078b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f43080d = false;
        Bitmap bitmap2 = this.f43078b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f43078b == null) {
            return;
        }
        this.f43083g.set(true);
        canvas.drawBitmap(this.f43078b, f2, f3, paint);
        this.f43083g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f43078b == null) {
            return;
        }
        this.f43083g.set(true);
        canvas.drawBitmap(this.f43078b, matrix, paint);
        this.f43083g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f43078b == null) {
            return;
        }
        this.f43083g.set(true);
        canvas.drawBitmap(this.f43078b, rect, rectF, paint);
        this.f43083g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f43078b) == null) {
            return;
        }
        this.f43080d = false;
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
        if (this.f43078b == null) {
            return null;
        }
        this.f43080d = false;
        return new C0588a(this.f43078b);
    }

    public byte[] k() {
        return this.f43081e;
    }

    public d.b.c.d.b l() {
        return this.f43084h;
    }

    public int m() {
        Bitmap bitmap = this.f43078b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f43078b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f43078b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f43080d = false;
        return this.f43078b;
    }

    public String q() {
        return this.f43077a;
    }

    public int r() {
        Bitmap bitmap = this.f43078b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.i;
    }

    public boolean t() {
        return this.f43079c;
    }

    public boolean u() {
        return this.f43082f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f43078b != null;
    }

    public boolean x() {
        if (this.f43080d && !this.f43083g.get()) {
            Bitmap bitmap = this.f43078b;
            if (bitmap != null) {
                this.f43078b = null;
                bitmap.recycle();
            }
            d.b.c.d.b bVar = this.f43084h;
            if (bVar != null) {
                this.f43084h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f43082f = z;
    }

    public void z(int i) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43078b = bitmap;
        this.f43079c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43078b = bitmap;
        this.f43079c = z;
        this.f43077a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43078b = bitmap;
        this.f43079c = z;
        this.f43077a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43078b = bitmap;
        this.f43079c = z;
        this.f43077a = str;
        this.f43081e = bArr;
        c();
    }

    public a(d.b.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43084h = bVar;
        this.f43078b = bitmap;
        this.f43079c = z;
    }

    public a(d.b.c.d.b bVar) {
        this.f43078b = null;
        this.f43079c = false;
        this.f43080d = true;
        this.f43081e = null;
        this.f43082f = true;
        this.f43083g = new AtomicBoolean(false);
        this.i = false;
        this.k = false;
        this.f43084h = bVar;
        this.i = true;
    }
}
