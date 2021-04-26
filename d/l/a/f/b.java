package d.l.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import d.l.a.c;
import d.l.a.f.a;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class b extends d.l.a.f.a {

    /* renamed from: c  reason: collision with root package name */
    public final C1790b f65702c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Bitmap> f65703d;

    /* renamed from: e  reason: collision with root package name */
    public final a f65704e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f65705f;

    /* renamed from: g  reason: collision with root package name */
    public final c f65706g;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65707a;

        /* renamed from: b  reason: collision with root package name */
        public int f65708b;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<SVGAVideoShapeEntity, Path> f65709c = new HashMap<>();

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            if (!this.f65709c.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.b());
                this.f65709c.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.f65709c.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                Intrinsics.throwNpe();
            }
            return path2;
        }

        public final void b(Canvas canvas) {
            if (this.f65707a != canvas.getWidth() || this.f65708b != canvas.getHeight()) {
                this.f65709c.clear();
            }
            this.f65707a = canvas.getWidth();
            this.f65708b = canvas.getHeight();
        }
    }

    /* renamed from: d.l.a.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1790b {

        /* renamed from: a  reason: collision with root package name */
        public final Paint f65710a = new Paint();

        /* renamed from: b  reason: collision with root package name */
        public final Path f65711b = new Path();

        /* renamed from: c  reason: collision with root package name */
        public final Path f65712c = new Path();

        /* renamed from: d  reason: collision with root package name */
        public final Matrix f65713d = new Matrix();

        /* renamed from: e  reason: collision with root package name */
        public final Matrix f65714e = new Matrix();

        public final Matrix a() {
            this.f65713d.reset();
            return this.f65713d;
        }

        public final Matrix b() {
            this.f65714e.reset();
            return this.f65714e;
        }

        public final Paint c() {
            this.f65710a.reset();
            return this.f65710a;
        }

        public final Path d() {
            this.f65711b.reset();
            return this.f65711b;
        }

        public final Path e() {
            this.f65712c.reset();
            return this.f65712c;
        }
    }

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        super(sVGAVideoEntity);
        this.f65706g = cVar;
        this.f65702c = new C1790b();
        this.f65703d = new HashMap<>();
        this.f65704e = new a();
        this.f65705f = new float[16];
    }

    @Override // d.l.a.f.a
    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        super.a(canvas, i2, scaleType);
        this.f65704e.b(canvas);
        for (a.C1789a c1789a : d(i2)) {
            h(c1789a, canvas, i2);
        }
        k(i2);
    }

    public final void e(a.C1789a c1789a, Canvas canvas, int i2) {
        String b2 = c1789a.b();
        if (b2 != null) {
            Function2<Canvas, Integer, Boolean> function2 = this.f65706g.a().get(b2);
            if (function2 != null) {
                Matrix l = l(c1789a.a().e());
                canvas.save();
                canvas.concat(l);
                function2.invoke(canvas, Integer.valueOf(i2));
                canvas.restore();
            }
            Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.f65706g.b().get(b2);
            if (function4 != null) {
                Matrix l2 = l(c1789a.a().e());
                canvas.save();
                canvas.concat(l2);
                function4.invoke(canvas, Integer.valueOf(i2), Integer.valueOf((int) c1789a.a().b().b()), Integer.valueOf((int) c1789a.a().b().a()));
                canvas.restore();
            }
        }
    }

    public final void f(a.C1789a c1789a, Canvas canvas) {
        String b2 = c1789a.b();
        if (b2 == null || Intrinsics.areEqual(this.f65706g.c().get(b2), Boolean.TRUE)) {
            return;
        }
        Bitmap bitmap = this.f65706g.d().get(b2);
        if (bitmap == null) {
            bitmap = c().e().get(b2);
        }
        if (bitmap != null) {
            Matrix l = l(c1789a.a().e());
            Paint c2 = this.f65702c.c();
            c2.setAntiAlias(c().a());
            c2.setFilterBitmap(c().a());
            c2.setAlpha((int) (c1789a.a().a() * 255));
            if (c1789a.a().c() != null) {
                d.l.a.g.b c3 = c1789a.a().c();
                if (c3 == null) {
                    return;
                }
                canvas.save();
                c2.reset();
                Path d2 = this.f65702c.d();
                c3.a(d2);
                d2.transform(l);
                canvas.clipPath(d2);
                l.preScale((float) (c1789a.a().b().b() / bitmap.getWidth()), (float) (c1789a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
                canvas.restore();
            } else {
                l.preScale((float) (c1789a.a().b().b() / bitmap.getWidth()), (float) (c1789a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
            }
            i(canvas, bitmap, c1789a, l);
        }
    }

    public final void g(a.C1789a c1789a, Canvas canvas) {
        SVGAVideoShapeEntity.a c2;
        float[] c3;
        String d2;
        String b2;
        int a2;
        Matrix l = l(c1789a.a().e());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1789a.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.b() != null) {
                Paint c4 = this.f65702c.c();
                c4.reset();
                c4.setAntiAlias(c().a());
                double d3 = 255;
                c4.setAlpha((int) (c1789a.a().a() * d3));
                Path d4 = this.f65702c.d();
                d4.reset();
                d4.addPath(this.f65704e.a(sVGAVideoShapeEntity));
                Matrix b3 = this.f65702c.b();
                b3.reset();
                Matrix d5 = sVGAVideoShapeEntity.d();
                if (d5 != null) {
                    b3.postConcat(d5);
                }
                b3.postConcat(l);
                d4.transform(b3);
                SVGAVideoShapeEntity.a c5 = sVGAVideoShapeEntity.c();
                if (c5 != null && (a2 = c5.a()) != 0) {
                    c4.setStyle(Paint.Style.FILL);
                    c4.setColor(a2);
                    c4.setAlpha(Math.min(255, Math.max(0, (int) (c1789a.a().a() * d3))));
                    if (c1789a.a().c() != null) {
                        canvas.save();
                    }
                    d.l.a.g.b c6 = c1789a.a().c();
                    if (c6 != null) {
                        Path e2 = this.f65702c.e();
                        c6.a(e2);
                        e2.transform(l);
                        canvas.clipPath(e2);
                    }
                    canvas.drawPath(d4, c4);
                    if (c1789a.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a c7 = sVGAVideoShapeEntity.c();
                if (c7 != null) {
                    float f2 = 0;
                    if (c7.g() > f2) {
                        c4.setStyle(Paint.Style.STROKE);
                        SVGAVideoShapeEntity.a c8 = sVGAVideoShapeEntity.c();
                        if (c8 != null) {
                            c4.setColor(c8.f());
                            c4.setAlpha(Math.min(255, Math.max(0, (int) (c1789a.a().a() * d3))));
                        }
                        float j = j(l);
                        SVGAVideoShapeEntity.a c9 = sVGAVideoShapeEntity.c();
                        if (c9 != null) {
                            c4.setStrokeWidth(c9.g() * j);
                        }
                        SVGAVideoShapeEntity.a c10 = sVGAVideoShapeEntity.c();
                        if (c10 != null && (b2 = c10.b()) != null) {
                            if (StringsKt__StringsJVMKt.equals(b2, "butt", true)) {
                                c4.setStrokeCap(Paint.Cap.BUTT);
                            } else if (StringsKt__StringsJVMKt.equals(b2, "round", true)) {
                                c4.setStrokeCap(Paint.Cap.ROUND);
                            } else if (StringsKt__StringsJVMKt.equals(b2, "square", true)) {
                                c4.setStrokeCap(Paint.Cap.SQUARE);
                            }
                        }
                        SVGAVideoShapeEntity.a c11 = sVGAVideoShapeEntity.c();
                        if (c11 != null && (d2 = c11.d()) != null) {
                            if (StringsKt__StringsJVMKt.equals(d2, "miter", true)) {
                                c4.setStrokeJoin(Paint.Join.MITER);
                            } else if (StringsKt__StringsJVMKt.equals(d2, "round", true)) {
                                c4.setStrokeJoin(Paint.Join.ROUND);
                            } else if (StringsKt__StringsJVMKt.equals(d2, "bevel", true)) {
                                c4.setStrokeJoin(Paint.Join.BEVEL);
                            }
                        }
                        if (sVGAVideoShapeEntity.c() != null) {
                            c4.setStrokeMiter(c2.e() * j);
                        }
                        SVGAVideoShapeEntity.a c12 = sVGAVideoShapeEntity.c();
                        if (c12 != null && (c3 = c12.c()) != null && c3.length == 3 && (c3[0] > f2 || c3[1] > f2)) {
                            float[] fArr = new float[2];
                            fArr[0] = (c3[0] >= 1.0f ? c3[0] : 1.0f) * j;
                            fArr[1] = (c3[1] >= 0.1f ? c3[1] : 0.1f) * j;
                            c4.setPathEffect(new DashPathEffect(fArr, c3[2] * j));
                        }
                        if (c1789a.a().c() != null) {
                            canvas.save();
                        }
                        d.l.a.g.b c13 = c1789a.a().c();
                        if (c13 != null) {
                            Path e3 = this.f65702c.e();
                            c13.a(e3);
                            e3.transform(l);
                            canvas.clipPath(e3);
                        }
                        canvas.drawPath(d4, c4);
                        if (c1789a.a().c() != null) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    public final void h(a.C1789a c1789a, Canvas canvas, int i2) {
        f(c1789a, canvas);
        g(c1789a, canvas);
        e(c1789a, canvas, i2);
    }

    public final void i(Canvas canvas, Bitmap bitmap, a.C1789a c1789a, Matrix matrix) {
        TextPaint drawingTextPaint;
        if (this.f65706g.h()) {
            this.f65703d.clear();
            this.f65706g.i(false);
        }
        String b2 = c1789a.b();
        if (b2 != null) {
            Bitmap bitmap2 = null;
            String str = this.f65706g.f().get(b2);
            if (str != null && (drawingTextPaint = this.f65706g.g().get(b2)) != null && (bitmap2 = this.f65703d.get(b2)) == null) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap2);
                Intrinsics.checkExpressionValueIsNotNull(drawingTextPaint, "drawingTextPaint");
                drawingTextPaint.setAntiAlias(true);
                Rect rect = new Rect();
                drawingTextPaint.getTextBounds(str, 0, str.length(), rect);
                canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((bitmap.getHeight() + 0) - drawingTextPaint.getFontMetrics().bottom) - drawingTextPaint.getFontMetrics().top) / 2, drawingTextPaint);
                HashMap<String, Bitmap> hashMap = this.f65703d;
                if (bitmap2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap.put(b2, bitmap2);
            }
            StaticLayout it = this.f65706g.e().get(b2);
            if (it != null && (bitmap2 = this.f65703d.get(b2)) == null) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                TextPaint paint = it.getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint, "it.paint");
                paint.setAntiAlias(true);
                StaticLayout staticLayout = new StaticLayout(it.getText(), 0, it.getText().length(), it.getPaint(), bitmap.getWidth(), it.getAlignment(), it.getSpacingMultiplier(), it.getSpacingAdd(), false);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap);
                canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout.getHeight()) / 2);
                staticLayout.draw(canvas3);
                HashMap<String, Bitmap> hashMap2 = this.f65703d;
                if (createBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                hashMap2.put(b2, createBitmap);
                bitmap2 = createBitmap;
            }
            if (bitmap2 != null) {
                Paint c2 = this.f65702c.c();
                c2.setAntiAlias(c().a());
                if (c1789a.a().c() != null) {
                    d.l.a.g.b c3 = c1789a.a().c();
                    if (c3 != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        c2.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        Path d2 = this.f65702c.d();
                        c3.a(d2);
                        canvas.drawPath(d2, c2);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                c2.setFilterBitmap(c().a());
                canvas.drawBitmap(bitmap2, matrix, c2);
            }
        }
    }

    public final float j(Matrix matrix) {
        matrix.getValues(this.f65705f);
        float[] fArr = this.f65705f;
        if (fArr[0] == 0.0f) {
            return 0.0f;
        }
        double d2 = fArr[0];
        double d3 = fArr[3];
        double d4 = fArr[1];
        double d5 = fArr[4];
        if (d2 * d5 == d3 * d4) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        double d6 = d2 / sqrt;
        double d7 = d3 / sqrt;
        double d8 = (d6 * d4) + (d7 * d5);
        double d9 = d4 - (d6 * d8);
        double d10 = d5 - (d8 * d7);
        double sqrt2 = Math.sqrt((d9 * d9) + (d10 * d10));
        if (d6 * (d10 / sqrt2) < d7 * (d9 / sqrt2)) {
            sqrt = -sqrt;
        }
        return Math.abs(b().a() ? (float) sqrt : (float) sqrt2);
    }

    public final void k(int i2) {
        SoundPool f2;
        Integer c2;
        for (d.l.a.g.a aVar : c().b()) {
            if (aVar.d() == i2 && (f2 = c().f()) != null && (c2 = aVar.c()) != null) {
                aVar.e(Integer.valueOf(f2.play(c2.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.a() <= i2) {
                Integer b2 = aVar.b();
                if (b2 != null) {
                    int intValue = b2.intValue();
                    SoundPool f3 = c().f();
                    if (f3 != null) {
                        f3.stop(intValue);
                    }
                }
                aVar.e(null);
            }
        }
    }

    public final Matrix l(Matrix matrix) {
        Matrix a2 = this.f65702c.a();
        a2.postScale(b().b(), b().c());
        a2.postTranslate(b().d(), b().e());
        a2.preConcat(matrix);
        return a2;
    }
}
