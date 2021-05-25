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
    public String f39208a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f39209b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39211d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f39212e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39213f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f39214g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.d.b f39215h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39216i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.c.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0498a extends BitmapDrawable {
        public C0498a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f39209b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f39209b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39209b = bitmap;
    }

    public void A(int i2) {
    }

    public int B() {
        Bitmap bitmap = this.f39209b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f39209b.getRowBytes();
    }

    public void b(boolean z) {
        this.f39214g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f39209b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f39209b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f39209b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f39211d = false;
        Bitmap bitmap2 = this.f39209b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f39209b == null) {
            return;
        }
        this.f39214g.set(true);
        canvas.drawBitmap(this.f39209b, f2, f3, paint);
        this.f39214g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f39209b == null) {
            return;
        }
        this.f39214g.set(true);
        canvas.drawBitmap(this.f39209b, matrix, paint);
        this.f39214g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f39209b == null) {
            return;
        }
        this.f39214g.set(true);
        canvas.drawBitmap(this.f39209b, rect, rectF, paint);
        this.f39214g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f39209b) == null) {
            return;
        }
        this.f39211d = false;
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
        if (this.f39209b == null) {
            return null;
        }
        this.f39211d = false;
        return new C0498a(this.f39209b);
    }

    public byte[] k() {
        return this.f39212e;
    }

    public d.a.c.d.b l() {
        return this.f39215h;
    }

    public int m() {
        Bitmap bitmap = this.f39209b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f39209b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f39209b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f39211d = false;
        return this.f39209b;
    }

    public String q() {
        return this.f39208a;
    }

    public int r() {
        Bitmap bitmap = this.f39209b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.f39216i;
    }

    public boolean t() {
        return this.f39210c;
    }

    public boolean u() {
        return this.f39213f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f39209b != null;
    }

    public boolean x() {
        if (this.f39211d && !this.f39214g.get()) {
            Bitmap bitmap = this.f39209b;
            if (bitmap != null) {
                this.f39209b = null;
                bitmap.recycle();
            }
            d.a.c.d.b bVar = this.f39215h;
            if (bVar != null) {
                this.f39215h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f39213f = z;
    }

    public void z(int i2) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39209b = bitmap;
        this.f39210c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39209b = bitmap;
        this.f39210c = z;
        this.f39208a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39209b = bitmap;
        this.f39210c = z;
        this.f39208a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39209b = bitmap;
        this.f39210c = z;
        this.f39208a = str;
        this.f39212e = bArr;
        c();
    }

    public a(d.a.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39215h = bVar;
        this.f39209b = bitmap;
        this.f39210c = z;
    }

    public a(d.a.c.d.b bVar) {
        this.f39209b = null;
        this.f39210c = false;
        this.f39211d = true;
        this.f39212e = null;
        this.f39213f = true;
        this.f39214g = new AtomicBoolean(false);
        this.f39216i = false;
        this.k = false;
        this.f39215h = bVar;
        this.f39216i = true;
    }
}
