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
    public String f42889a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42890b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42891c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42892d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42893e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42894f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42895g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.d.b f42896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42897i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.c.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0554a extends BitmapDrawable {
        public C0554a(Bitmap bitmap) {
            super(bitmap);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            if (a.this.f42890b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(a.this.f42890b, (Rect) null, getBounds(), getPaint());
        }
    }

    public a(Bitmap bitmap) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42890b = bitmap;
    }

    public void A(int i2) {
    }

    public int B() {
        Bitmap bitmap = this.f42890b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight() * this.f42890b.getRowBytes();
    }

    public void b(boolean z) {
        this.f42895g.set(z);
    }

    public final void c() {
        byte[] ninePatchChunk;
        Bitmap bitmap = this.f42890b;
        if (bitmap == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42890b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        Bitmap bitmap = this.f42890b;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        this.f42892d = false;
        Bitmap bitmap2 = this.f42890b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        return new BitmapShader(bitmap2, tileMode, tileMode);
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        if (this.f42890b == null) {
            return;
        }
        this.f42895g.set(true);
        canvas.drawBitmap(this.f42890b, f2, f3, paint);
        this.f42895g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.f42890b == null) {
            return;
        }
        this.f42895g.set(true);
        canvas.drawBitmap(this.f42890b, matrix, paint);
        this.f42895g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.f42890b == null) {
            return;
        }
        this.f42895g.set(true);
        canvas.drawBitmap(this.f42890b, rect, rectF, paint);
        this.f42895g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        if (imageView == null || (bitmap = this.f42890b) == null) {
            return;
        }
        this.f42892d = false;
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
        if (this.f42890b == null) {
            return null;
        }
        this.f42892d = false;
        return new C0554a(this.f42890b);
    }

    public byte[] k() {
        return this.f42893e;
    }

    public d.a.c.d.b l() {
        return this.f42896h;
    }

    public int m() {
        Bitmap bitmap = this.f42890b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public byte[] n() {
        byte[] byteArray;
        if (this.f42890b == null) {
            return null;
        }
        synchronized (m) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f42890b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect o() {
        return this.j;
    }

    public Bitmap p() {
        this.f42892d = false;
        return this.f42890b;
    }

    public String q() {
        return this.f42889a;
    }

    public int r() {
        Bitmap bitmap = this.f42890b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public boolean s() {
        return this.f42897i;
    }

    public boolean t() {
        return this.f42891c;
    }

    public boolean u() {
        return this.f42894f;
    }

    public boolean v() {
        return this.k;
    }

    public boolean w() {
        return this.f42890b != null;
    }

    public boolean x() {
        if (this.f42892d && !this.f42895g.get()) {
            Bitmap bitmap = this.f42890b;
            if (bitmap != null) {
                this.f42890b = null;
                bitmap.recycle();
            }
            d.a.c.d.b bVar = this.f42896h;
            if (bVar != null) {
                this.f42896h = null;
                bVar.close();
                return true;
            }
            return true;
        }
        return false;
    }

    public void y(boolean z) {
        this.f42894f = z;
    }

    public void z(int i2) {
    }

    public a(Bitmap bitmap, boolean z) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42890b = bitmap;
        this.f42891c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42890b = bitmap;
        this.f42891c = z;
        this.f42889a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42890b = bitmap;
        this.f42891c = z;
        this.f42889a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42890b = bitmap;
        this.f42891c = z;
        this.f42889a = str;
        this.f42893e = bArr;
        c();
    }

    public a(d.a.c.d.b bVar, Bitmap bitmap, boolean z) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42896h = bVar;
        this.f42890b = bitmap;
        this.f42891c = z;
    }

    public a(d.a.c.d.b bVar) {
        this.f42890b = null;
        this.f42891c = false;
        this.f42892d = true;
        this.f42893e = null;
        this.f42894f = true;
        this.f42895g = new AtomicBoolean(false);
        this.f42897i = false;
        this.k = false;
        this.f42896h = bVar;
        this.f42897i = true;
    }
}
