package d.c.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes6.dex */
public class c {
    public static HashSet<String> l;

    /* renamed from: a  reason: collision with root package name */
    public Canvas f65993a;

    /* renamed from: b  reason: collision with root package name */
    public SVG.b f65994b;

    /* renamed from: c  reason: collision with root package name */
    public float f65995c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65996d;

    /* renamed from: e  reason: collision with root package name */
    public SVG f65997e;

    /* renamed from: f  reason: collision with root package name */
    public h f65998f;

    /* renamed from: g  reason: collision with root package name */
    public Stack<h> f65999g;

    /* renamed from: h  reason: collision with root package name */
    public Stack<SVG.h0> f66000h;

    /* renamed from: i  reason: collision with root package name */
    public Stack<Matrix> f66001i;
    public Stack<Canvas> j;
    public Stack<Bitmap> k;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66002a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f66003b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f66004c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f66005d;

        static {
            int[] iArr = new int[SVG.Style.FillRule.values().length];
            f66005d = iArr;
            try {
                iArr[SVG.Style.FillRule.EvenOdd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66005d[SVG.Style.FillRule.NonZero.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SVG.Style.LineJoin.values().length];
            f66004c = iArr2;
            try {
                iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66004c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f66004c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[SVG.Style.LineCaps.values().length];
            f66003b = iArr3;
            try {
                iArr3[SVG.Style.LineCaps.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f66003b[SVG.Style.LineCaps.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f66003b[SVG.Style.LineCaps.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr4 = new int[PreserveAspectRatio.Alignment.values().length];
            f66002a = iArr4;
            try {
                iArr4[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f66002a[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SVG.w {

        /* renamed from: b  reason: collision with root package name */
        public float f66007b;

        /* renamed from: c  reason: collision with root package name */
        public float f66008c;

        /* renamed from: h  reason: collision with root package name */
        public boolean f66013h;

        /* renamed from: a  reason: collision with root package name */
        public List<C1843c> f66006a = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public C1843c f66009d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66010e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66011f = true;

        /* renamed from: g  reason: collision with root package name */
        public int f66012g = -1;

        public b(SVG.v vVar) {
            if (vVar == null) {
                return;
            }
            vVar.h(this);
            if (this.f66013h) {
                this.f66009d.b(this.f66006a.get(this.f66012g));
                this.f66006a.set(this.f66012g, this.f66009d);
                this.f66013h = false;
            }
            C1843c c1843c = this.f66009d;
            if (c1843c != null) {
                this.f66006a.add(c1843c);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            if (this.f66013h) {
                this.f66009d.b(this.f66006a.get(this.f66012g));
                this.f66006a.set(this.f66012g, this.f66009d);
                this.f66013h = false;
            }
            C1843c c1843c = this.f66009d;
            if (c1843c != null) {
                this.f66006a.add(c1843c);
            }
            this.f66007b = f2;
            this.f66008c = f3;
            this.f66009d = new C1843c(c.this, f2, f3, 0.0f, 0.0f);
            this.f66012g = this.f66006a.size();
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            this.f66009d.a(f2, f3);
            this.f66006a.add(this.f66009d);
            c cVar = c.this;
            C1843c c1843c = this.f66009d;
            this.f66009d = new C1843c(cVar, f2, f3, f2 - c1843c.f66015a, f3 - c1843c.f66016b);
            this.f66013h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            this.f66009d.a(f2, f3);
            this.f66006a.add(this.f66009d);
            this.f66009d = new C1843c(c.this, f4, f5, f4 - f2, f5 - f3);
            this.f66013h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            this.f66006a.add(this.f66009d);
            b(this.f66007b, this.f66008c);
            this.f66013h = true;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            if (this.f66011f || this.f66010e) {
                this.f66009d.a(f2, f3);
                this.f66006a.add(this.f66009d);
                this.f66010e = false;
            }
            this.f66009d = new C1843c(c.this, f6, f7, f6 - f4, f7 - f5);
            this.f66013h = false;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            this.f66010e = true;
            this.f66011f = false;
            C1843c c1843c = this.f66009d;
            c.m(c1843c.f66015a, c1843c.f66016b, f2, f3, f4, z, z2, f5, f6, this);
            this.f66011f = true;
            this.f66013h = false;
        }

        public List<C1843c> f() {
            return this.f66006a;
        }
    }

    /* renamed from: d.c.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1843c {

        /* renamed from: a  reason: collision with root package name */
        public float f66015a;

        /* renamed from: b  reason: collision with root package name */
        public float f66016b;

        /* renamed from: c  reason: collision with root package name */
        public float f66017c;

        /* renamed from: d  reason: collision with root package name */
        public float f66018d;

        public C1843c(c cVar, float f2, float f3, float f4, float f5) {
            this.f66017c = 0.0f;
            this.f66018d = 0.0f;
            this.f66015a = f2;
            this.f66016b = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f66017c = (float) (f4 / sqrt);
                this.f66018d = (float) (f5 / sqrt);
            }
        }

        public void a(float f2, float f3) {
            float f4 = f2 - this.f66015a;
            float f5 = f3 - this.f66016b;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f66017c += (float) (f4 / sqrt);
                this.f66018d += (float) (f5 / sqrt);
            }
        }

        public void b(C1843c c1843c) {
            this.f66017c += c1843c.f66017c;
            this.f66018d += c1843c.f66018d;
        }

        public String toString() {
            return "(" + this.f66015a + "," + this.f66016b + " " + this.f66017c + "," + this.f66018d + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SVG.w {

        /* renamed from: a  reason: collision with root package name */
        public Path f66019a = new Path();

        /* renamed from: b  reason: collision with root package name */
        public float f66020b;

        /* renamed from: c  reason: collision with root package name */
        public float f66021c;

        public d(c cVar, SVG.v vVar) {
            if (vVar == null) {
                return;
            }
            vVar.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            this.f66019a.moveTo(f2, f3);
            this.f66020b = f2;
            this.f66021c = f3;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            this.f66019a.lineTo(f2, f3);
            this.f66020b = f2;
            this.f66021c = f3;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            this.f66019a.quadTo(f2, f3, f4, f5);
            this.f66020b = f4;
            this.f66021c = f5;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            this.f66019a.close();
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.f66019a.cubicTo(f2, f3, f4, f5, f6, f7);
            this.f66020b = f6;
            this.f66021c = f7;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            c.m(this.f66020b, this.f66021c, f2, f3, f4, z, z2, f5, f6, this);
            this.f66020b = f5;
            this.f66021c = f6;
        }

        public Path f() {
            return this.f66019a;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends f {

        /* renamed from: d  reason: collision with root package name */
        public Path f66022d;

        public e(Path path, float f2, float f3) {
            super(f2, f3);
            this.f66022d = path;
        }

        @Override // d.c.a.c.f, d.c.a.c.j
        public void b(String str) {
            if (c.this.Y0()) {
                if (c.this.f65998f.f66032f) {
                    c.this.f65993a.drawTextOnPath(str, this.f66022d, this.f66024a, this.f66025b, c.this.f65998f.f66034h);
                }
                if (c.this.f65998f.f66033g) {
                    c.this.f65993a.drawTextOnPath(str, this.f66022d, this.f66024a, this.f66025b, c.this.f65998f.f66035i);
                }
            }
            this.f66024a += c.this.f65998f.f66034h.measureText(str);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends j {

        /* renamed from: a  reason: collision with root package name */
        public float f66024a;

        /* renamed from: b  reason: collision with root package name */
        public float f66025b;

        public f(float f2, float f3) {
            super(c.this, null);
            this.f66024a = f2;
            this.f66025b = f3;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            c.C("TextSequence render", new Object[0]);
            if (c.this.Y0()) {
                if (c.this.f65998f.f66032f) {
                    c.this.f65993a.drawText(str, this.f66024a, this.f66025b, c.this.f65998f.f66034h);
                }
                if (c.this.f65998f.f66033g) {
                    c.this.f65993a.drawText(str, this.f66024a, this.f66025b, c.this.f65998f.f66035i);
                }
            }
            this.f66024a += c.this.f65998f.f66034h.measureText(str);
        }
    }

    /* loaded from: classes6.dex */
    public class g extends j {

        /* renamed from: a  reason: collision with root package name */
        public float f66027a;

        /* renamed from: b  reason: collision with root package name */
        public float f66028b;

        /* renamed from: c  reason: collision with root package name */
        public Path f66029c;

        public g(float f2, float f3, Path path) {
            super(c.this, null);
            this.f66027a = f2;
            this.f66028b = f3;
            this.f66029c = path;
        }

        @Override // d.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            if (w0Var instanceof SVG.x0) {
                c.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            if (c.this.Y0()) {
                Path path = new Path();
                c.this.f65998f.f66034h.getTextPath(str, 0, str.length(), this.f66027a, this.f66028b, path);
                this.f66029c.addPath(path);
            }
            this.f66027a += c.this.f65998f.f66034h.measureText(str);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public SVG.Style f66031e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66032f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f66033g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f66034h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f66035i;
        public SVG.b j;
        public SVG.b k;
        public boolean l;
        public boolean m;

        public h(c cVar) {
            Paint paint = new Paint();
            this.f66034h = paint;
            paint.setFlags(385);
            this.f66034h.setStyle(Paint.Style.FILL);
            this.f66034h.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f66035i = paint2;
            paint2.setFlags(385);
            this.f66035i.setStyle(Paint.Style.STROKE);
            this.f66035i.setTypeface(Typeface.DEFAULT);
            this.f66031e = SVG.Style.b();
        }

        public Object clone() {
            try {
                h hVar = (h) super.clone();
                hVar.f66031e = (SVG.Style) this.f66031e.clone();
                hVar.f66034h = new Paint(this.f66034h);
                hVar.f66035i = new Paint(this.f66035i);
                return hVar;
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends j {

        /* renamed from: a  reason: collision with root package name */
        public float f66036a;

        /* renamed from: b  reason: collision with root package name */
        public float f66037b;

        /* renamed from: c  reason: collision with root package name */
        public RectF f66038c;

        public i(float f2, float f3) {
            super(c.this, null);
            this.f66038c = new RectF();
            this.f66036a = f2;
            this.f66037b = f3;
        }

        @Override // d.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            if (w0Var instanceof SVG.x0) {
                SVG.x0 x0Var = (SVG.x0) w0Var;
                SVG.l0 n = w0Var.f30369a.n(x0Var.n);
                if (n == null) {
                    c.J("TextPath path reference '%s' not found", x0Var.n);
                    return false;
                }
                SVG.u uVar = (SVG.u) n;
                Path f2 = new d(c.this, uVar.o).f();
                Matrix matrix = uVar.n;
                if (matrix != null) {
                    f2.transform(matrix);
                }
                RectF rectF = new RectF();
                f2.computeBounds(rectF, true);
                this.f66038c.union(rectF);
                return false;
            }
            return true;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            if (c.this.Y0()) {
                Rect rect = new Rect();
                c.this.f65998f.f66034h.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f66036a, this.f66037b);
                this.f66038c.union(rectF);
            }
            this.f66036a += c.this.f65998f.f66034h.measureText(str);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class j {
        public j(c cVar) {
        }

        public boolean a(SVG.w0 w0Var) {
            return true;
        }

        public abstract void b(String str);

        public /* synthetic */ j(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(Canvas canvas, SVG.b bVar, float f2) {
        this.f65993a = canvas;
        this.f65995c = f2;
        this.f65994b = bVar;
    }

    public static void C(String str, Object... objArr) {
    }

    public static void J(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static synchronized void Z() {
        synchronized (c.class) {
            HashSet<String> hashSet = new HashSet<>();
            l = hashSet;
            hashSet.add("Structure");
            l.add("BasicStructure");
            l.add("ConditionalProcessing");
            l.add("Image");
            l.add("Style");
            l.add("ViewportAttribute");
            l.add("Shape");
            l.add("BasicText");
            l.add("PaintAttribute");
            l.add("BasicPaintAttribute");
            l.add("OpacityAttribute");
            l.add("BasicGraphicsAttribute");
            l.add("Marker");
            l.add("Gradient");
            l.add("Pattern");
            l.add("Clip");
            l.add("BasicClip");
            l.add("Mask");
            l.add("View");
        }
    }

    public static void Z0(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        float f9;
        SVG.w wVar2;
        double d2;
        if (f2 == f7 && f3 == f8) {
            return;
        }
        if (f4 == 0.0f) {
            f9 = f7;
            wVar2 = wVar;
        } else if (f5 != 0.0f) {
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            double radians = (float) Math.toRadians(f6 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (f2 - f7) / 2.0d;
            double d4 = (f3 - f8) / 2.0d;
            double d5 = (cos * d3) + (sin * d4);
            double d6 = ((-sin) * d3) + (d4 * cos);
            double d7 = abs * abs;
            double d8 = abs2 * abs2;
            double d9 = d5 * d5;
            double d10 = d6 * d6;
            double d11 = (d9 / d7) + (d10 / d8);
            if (d11 > 1.0d) {
                abs *= (float) Math.sqrt(d11);
                abs2 *= (float) Math.sqrt(d11);
                d7 = abs * abs;
                d8 = abs2 * abs2;
            }
            double d12 = z == z2 ? -1.0d : 1.0d;
            double d13 = d7 * d8;
            double d14 = d7 * d10;
            double d15 = d8 * d9;
            double d16 = ((d13 - d14) - d15) / (d14 + d15);
            if (d16 < 0.0d) {
                d16 = 0.0d;
            }
            double sqrt = d12 * Math.sqrt(d16);
            double d17 = abs;
            double d18 = abs2;
            double d19 = ((d17 * d6) / d18) * sqrt;
            float f10 = abs;
            float f11 = abs2;
            double d20 = sqrt * (-((d18 * d5) / d17));
            double d21 = ((f2 + f7) / 2.0d) + ((cos * d19) - (sin * d20));
            double d22 = ((f3 + f8) / 2.0d) + (sin * d19) + (cos * d20);
            double d23 = (d5 - d19) / d17;
            double d24 = (d6 - d20) / d18;
            double d25 = ((-d5) - d19) / d17;
            double d26 = ((-d6) - d20) / d18;
            double d27 = (d23 * d23) + (d24 * d24);
            double degrees = Math.toDegrees((d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27)));
            double degrees2 = Math.toDegrees(((d23 * d26) - (d24 * d25) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26)))));
            if (z2 || degrees2 <= 0.0d) {
                d2 = 360.0d;
                if (z2 && degrees2 < 0.0d) {
                    degrees2 += 360.0d;
                }
            } else {
                d2 = 360.0d;
                degrees2 -= 360.0d;
            }
            float[] n = n(degrees % d2, degrees2 % d2);
            Matrix matrix = new Matrix();
            matrix.postScale(f10, f11);
            matrix.postRotate(f6);
            matrix.postTranslate((float) d21, (float) d22);
            matrix.mapPoints(n);
            n[n.length - 2] = f7;
            n[n.length - 1] = f8;
            for (int i2 = 0; i2 < n.length; i2 += 6) {
                wVar.d(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
            }
            return;
        } else {
            wVar2 = wVar;
            f9 = f7;
        }
        wVar2.b(f9, f8);
    }

    public static float[] n(double d2, double d3) {
        float radians;
        int ceil = (int) Math.ceil(Math.abs(d3) / 90.0d);
        double radians2 = Math.toRadians(d2);
        double radians3 = (float) (Math.toRadians(d3) / ceil);
        double d4 = radians3 / 2.0d;
        double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i2 = 0;
        int i3 = 0;
        while (i2 < ceil) {
            double d5 = (i2 * radians) + radians2;
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i4 = i3 + 1;
            int i5 = ceil;
            double d6 = radians2;
            fArr[i3] = (float) (cos - (sin * sin2));
            int i6 = i4 + 1;
            fArr[i4] = (float) (sin2 + (cos * sin));
            double d7 = d5 + radians3;
            double cos2 = Math.cos(d7);
            double sin3 = Math.sin(d7);
            int i7 = i6 + 1;
            fArr[i6] = (float) ((sin * sin3) + cos2);
            int i8 = i7 + 1;
            fArr[i7] = (float) (sin3 - (sin * cos2));
            int i9 = i8 + 1;
            fArr[i8] = (float) cos2;
            fArr[i9] = (float) sin3;
            i2++;
            radians2 = d6;
            i3 = i9 + 1;
            ceil = i5;
        }
        return fArr;
    }

    public final void A() {
        this.f65993a.restore();
        this.f65998f = this.f65999g.pop();
    }

    public final void A0(SVG.l0 l0Var) {
        if (l0Var instanceof SVG.s) {
            return;
        }
        S0();
        y(l0Var);
        if (l0Var instanceof SVG.d0) {
            x0((SVG.d0) l0Var);
        } else if (l0Var instanceof SVG.b1) {
            E0((SVG.b1) l0Var);
        } else if (l0Var instanceof SVG.q0) {
            B0((SVG.q0) l0Var);
        } else if (l0Var instanceof SVG.l) {
            q0((SVG.l) l0Var);
        } else if (l0Var instanceof SVG.n) {
            r0((SVG.n) l0Var);
        } else if (l0Var instanceof SVG.u) {
            t0((SVG.u) l0Var);
        } else if (l0Var instanceof SVG.a0) {
            w0((SVG.a0) l0Var);
        } else if (l0Var instanceof SVG.d) {
            o0((SVG.d) l0Var);
        } else if (l0Var instanceof SVG.i) {
            p0((SVG.i) l0Var);
        } else if (l0Var instanceof SVG.p) {
            s0((SVG.p) l0Var);
        } else if (l0Var instanceof SVG.z) {
            v0((SVG.z) l0Var);
        } else if (l0Var instanceof SVG.y) {
            u0((SVG.y) l0Var);
        } else if (l0Var instanceof SVG.u0) {
            D0((SVG.u0) l0Var);
        }
        R0();
    }

    public final void B() {
        this.f65993a.save();
        this.f65999g.push(this.f65998f);
        this.f65998f = (h) this.f65998f.clone();
    }

    public final void B0(SVG.q0 q0Var) {
        C("Switch render", new Object[0]);
        W0(this.f65998f, q0Var);
        if (E()) {
            Matrix matrix = q0Var.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            t(q0Var);
            boolean n0 = n0();
            K0(q0Var);
            if (n0) {
                k0(q0Var);
            }
            U0(q0Var);
        }
    }

    public final void C0(SVG.r0 r0Var, SVG.o oVar, SVG.o oVar2) {
        C("Symbol render", new Object[0]);
        if (oVar == null || !oVar.i()) {
            if (oVar2 == null || !oVar2.i()) {
                PreserveAspectRatio preserveAspectRatio = r0Var.n;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.f30331d;
                }
                W0(this.f65998f, r0Var);
                this.f65998f.j = new SVG.b(0.0f, 0.0f, oVar != null ? oVar.f(this) : this.f65998f.j.f30349g, oVar2 != null ? oVar2.f(this) : this.f65998f.j.f30350h);
                if (!this.f65998f.f66031e.z.booleanValue()) {
                    SVG.b bVar = this.f65998f.j;
                    O0(bVar.f30347e, bVar.f30348f, bVar.f30349g, bVar.f30350h);
                }
                SVG.b bVar2 = r0Var.o;
                if (bVar2 != null) {
                    this.f65993a.concat(s(this.f65998f.j, bVar2, preserveAspectRatio));
                    this.f65998f.k = r0Var.o;
                }
                boolean n0 = n0();
                F0(r0Var, true);
                if (n0) {
                    k0(r0Var);
                }
                U0(r0Var);
            }
        }
    }

    public final void D(boolean z, SVG.b bVar, SVG.t tVar) {
        SVG.l0 n = this.f65997e.n(tVar.f30373e);
        if (n == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = tVar.f30373e;
            J("%s reference '%s' not found", objArr);
            SVG.m0 m0Var = tVar.f30374f;
            if (m0Var != null) {
                P0(this.f65998f, z, m0Var);
                return;
            } else if (z) {
                this.f65998f.f66032f = false;
                return;
            } else {
                this.f65998f.f66033g = false;
                return;
            }
        }
        if (n instanceof SVG.k0) {
            b0(z, bVar, (SVG.k0) n);
        }
        if (n instanceof SVG.o0) {
            h0(z, bVar, (SVG.o0) n);
        }
        if (n instanceof SVG.b0) {
            Q0(z, (SVG.b0) n);
        }
    }

    public final void D0(SVG.u0 u0Var) {
        C("Text render", new Object[0]);
        W0(this.f65998f, u0Var);
        if (E()) {
            Matrix matrix = u0Var.r;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            List<SVG.o> list = u0Var.n;
            float f2 = 0.0f;
            float f3 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).f(this);
            List<SVG.o> list2 = u0Var.o;
            float g2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).g(this);
            List<SVG.o> list3 = u0Var.p;
            float f4 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).f(this);
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f2 = u0Var.q.get(0).g(this);
            }
            SVG.Style.TextAnchor S = S();
            if (S != SVG.Style.TextAnchor.Start) {
                float r = r(u0Var);
                if (S == SVG.Style.TextAnchor.Middle) {
                    r /= 2.0f;
                }
                f3 -= r;
            }
            if (u0Var.f30361h == null) {
                i iVar = new i(f3, g2);
                I(u0Var, iVar);
                RectF rectF = iVar.f66038c;
                u0Var.f30361h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f66038c.height());
            }
            U0(u0Var);
            v(u0Var);
            t(u0Var);
            boolean n0 = n0();
            I(u0Var, new f(f3 + f4, g2 + f2));
            if (n0) {
                k0(u0Var);
            }
        }
    }

    public final boolean E() {
        Boolean bool = this.f65998f.f66031e.E;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void E0(SVG.b1 b1Var) {
        C("Use render", new Object[0]);
        SVG.o oVar = b1Var.r;
        if (oVar == null || !oVar.i()) {
            SVG.o oVar2 = b1Var.s;
            if (oVar2 == null || !oVar2.i()) {
                W0(this.f65998f, b1Var);
                if (E()) {
                    SVG.l0 n = b1Var.f30369a.n(b1Var.o);
                    if (n == null) {
                        J("Use reference '%s' not found", b1Var.o);
                        return;
                    }
                    Matrix matrix = b1Var.n;
                    if (matrix != null) {
                        this.f65993a.concat(matrix);
                    }
                    Matrix matrix2 = new Matrix();
                    SVG.o oVar3 = b1Var.p;
                    float f2 = oVar3 != null ? oVar3.f(this) : 0.0f;
                    SVG.o oVar4 = b1Var.q;
                    matrix2.preTranslate(f2, oVar4 != null ? oVar4.g(this) : 0.0f);
                    this.f65993a.concat(matrix2);
                    t(b1Var);
                    boolean n0 = n0();
                    j0(b1Var);
                    if (n instanceof SVG.d0) {
                        S0();
                        SVG.d0 d0Var = (SVG.d0) n;
                        SVG.o oVar5 = b1Var.r;
                        if (oVar5 == null) {
                            oVar5 = d0Var.r;
                        }
                        SVG.o oVar6 = b1Var.s;
                        if (oVar6 == null) {
                            oVar6 = d0Var.s;
                        }
                        y0(d0Var, oVar5, oVar6);
                        R0();
                    } else if (n instanceof SVG.r0) {
                        SVG.o oVar7 = b1Var.r;
                        if (oVar7 == null) {
                            oVar7 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        SVG.o oVar8 = b1Var.s;
                        if (oVar8 == null) {
                            oVar8 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        S0();
                        C0((SVG.r0) n, oVar7, oVar8);
                        R0();
                    } else {
                        A0(n);
                    }
                    i0();
                    if (n0) {
                        k0(b1Var);
                    }
                    U0(b1Var);
                }
            }
        }
    }

    public final void F(SVG.i0 i0Var, Path path) {
        SVG.m0 m0Var = this.f65998f.f66031e.f30340f;
        if (m0Var instanceof SVG.t) {
            SVG.l0 n = this.f65997e.n(((SVG.t) m0Var).f30373e);
            if (n instanceof SVG.x) {
                P(i0Var, path, (SVG.x) n);
                return;
            }
        }
        this.f65993a.drawPath(path, this.f65998f.f66034h);
    }

    public final void F0(SVG.h0 h0Var, boolean z) {
        if (z) {
            j0(h0Var);
        }
        for (SVG.l0 l0Var : h0Var.getChildren()) {
            A0(l0Var);
        }
        if (z) {
            i0();
        }
    }

    public final void G(Path path) {
        h hVar = this.f65998f;
        if (hVar.f66031e.P == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.f65993a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f65993a.setMatrix(new Matrix());
            Shader shader = this.f65998f.f66035i.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f65993a.drawPath(path2, this.f65998f.f66035i);
            this.f65993a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f65993a.drawPath(path, hVar.f66035i);
    }

    public void G0(SVG svg, SVG.b bVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.f65997e = svg;
        this.f65996d = z;
        SVG.d0 j2 = svg.j();
        if (j2 == null) {
            Z0("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        N0();
        y(j2);
        SVG.o oVar = j2.r;
        SVG.o oVar2 = j2.s;
        if (bVar == null) {
            bVar = j2.o;
        }
        SVG.b bVar2 = bVar;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = j2.n;
        }
        z0(j2, oVar, oVar2, bVar2, preserveAspectRatio);
    }

    public final void H() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f65993a.getWidth(), this.f65993a.getHeight(), Bitmap.Config.ARGB_8888);
            this.k.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.f65993a.getMatrix());
            this.f65993a = canvas;
        } catch (OutOfMemoryError e2) {
            J("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0108, code lost:
        if (r7 != 8) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H0(SVG.q qVar, C1843c c1843c) {
        float f2;
        SVG.b bVar;
        boolean n0;
        float f3;
        float f4;
        float f5;
        S0();
        Float f6 = qVar.u;
        float f7 = 0.0f;
        if (f6 != null) {
            if (Float.isNaN(f6.floatValue())) {
                if (c1843c.f66017c != 0.0f || c1843c.f66018d != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(c1843c.f66018d, c1843c.f66017c));
                }
            } else {
                f2 = qVar.u.floatValue();
            }
            float c2 = !qVar.p ? 1.0f : this.f65998f.f66031e.k.c(this.f65995c);
            this.f65998f = Q(qVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(c1843c.f66015a, c1843c.f66016b);
            matrix.preRotate(f2);
            matrix.preScale(c2, c2);
            SVG.o oVar = qVar.q;
            float f8 = oVar == null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = qVar.r;
            float g2 = oVar2 == null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = qVar.s;
            float f9 = oVar3 == null ? oVar3.f(this) : 3.0f;
            SVG.o oVar4 = qVar.t;
            float g3 = oVar4 != null ? oVar4.g(this) : 3.0f;
            bVar = qVar.o;
            if (bVar == null) {
                float f10 = f9 / bVar.f30349g;
                float f11 = g3 / bVar.f30350h;
                PreserveAspectRatio preserveAspectRatio = qVar.n;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.f30331d;
                }
                if (!preserveAspectRatio.equals(PreserveAspectRatio.f30330c)) {
                    f10 = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f10, f11) : Math.min(f10, f11);
                    f11 = f10;
                }
                matrix.preTranslate((-f8) * f10, (-g2) * f11);
                this.f65993a.concat(matrix);
                SVG.b bVar2 = qVar.o;
                float f12 = bVar2.f30349g * f10;
                float f13 = bVar2.f30350h * f11;
                switch (a.f66002a[preserveAspectRatio.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f3 = (f9 - f12) / 2.0f;
                        f4 = 0.0f - f3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        f3 = f9 - f12;
                        f4 = 0.0f - f3;
                        break;
                    default:
                        f4 = 0.0f;
                        break;
                }
                int i2 = a.f66002a[preserveAspectRatio.a().ordinal()];
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 != 7) {
                                }
                            }
                        }
                    }
                    f5 = g3 - f13;
                    f7 = 0.0f - f5;
                    if (!this.f65998f.f66031e.z.booleanValue()) {
                        O0(f4, f7, f9, g3);
                    }
                    matrix.reset();
                    matrix.preScale(f10, f11);
                    this.f65993a.concat(matrix);
                }
                f5 = (g3 - f13) / 2.0f;
                f7 = 0.0f - f5;
                if (!this.f65998f.f66031e.z.booleanValue()) {
                }
                matrix.reset();
                matrix.preScale(f10, f11);
                this.f65993a.concat(matrix);
            } else {
                matrix.preTranslate(-f8, -g2);
                this.f65993a.concat(matrix);
                if (!this.f65998f.f66031e.z.booleanValue()) {
                    O0(0.0f, 0.0f, f9, g3);
                }
            }
            n0 = n0();
            F0(qVar, false);
            if (n0) {
                k0(qVar);
            }
            R0();
        }
        f2 = 0.0f;
        if (!qVar.p) {
        }
        this.f65998f = Q(qVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(c1843c.f66015a, c1843c.f66016b);
        matrix2.preRotate(f2);
        matrix2.preScale(c2, c2);
        SVG.o oVar5 = qVar.q;
        if (oVar5 == null) {
        }
        SVG.o oVar22 = qVar.r;
        if (oVar22 == null) {
        }
        SVG.o oVar32 = qVar.s;
        if (oVar32 == null) {
        }
        SVG.o oVar42 = qVar.t;
        if (oVar42 != null) {
        }
        bVar = qVar.o;
        if (bVar == null) {
        }
        n0 = n0();
        F0(qVar, false);
        if (n0) {
        }
        R0();
    }

    public final void I(SVG.w0 w0Var, j jVar) {
        if (E()) {
            Iterator<SVG.l0> it = w0Var.f30358i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(T0(((SVG.a1) next).f30345c, z, !it.hasNext()));
                } else {
                    m0(next, jVar);
                }
                z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I0(SVG.k kVar) {
        SVG.q qVar;
        String str;
        SVG.q qVar2;
        String str2;
        SVG.q qVar3;
        List<C1843c> p;
        int size;
        SVG.Style style = this.f65998f.f66031e;
        if (style.B == null && style.C == null && style.D == null) {
            return;
        }
        String str3 = this.f65998f.f66031e.B;
        if (str3 != null) {
            SVG.l0 n = kVar.f30369a.n(str3);
            if (n != null) {
                qVar = (SVG.q) n;
                str = this.f65998f.f66031e.C;
                if (str != null) {
                    SVG.l0 n2 = kVar.f30369a.n(str);
                    if (n2 != null) {
                        qVar2 = (SVG.q) n2;
                        str2 = this.f65998f.f66031e.D;
                        if (str2 != null) {
                            SVG.l0 n3 = kVar.f30369a.n(str2);
                            if (n3 != null) {
                                qVar3 = (SVG.q) n3;
                                if (!(kVar instanceof SVG.u)) {
                                    p = new b(((SVG.u) kVar).o).f();
                                } else if (kVar instanceof SVG.p) {
                                    p = o((SVG.p) kVar);
                                } else {
                                    p = p((SVG.y) kVar);
                                }
                                if (p == null && (size = p.size()) != 0) {
                                    SVG.Style style2 = this.f65998f.f66031e;
                                    style2.D = null;
                                    style2.C = null;
                                    style2.B = null;
                                    if (qVar != null) {
                                        H0(qVar, p.get(0));
                                    }
                                    if (qVar2 != null) {
                                        for (int i2 = 1; i2 < size - 1; i2++) {
                                            H0(qVar2, p.get(i2));
                                        }
                                    }
                                    if (qVar3 == null) {
                                        H0(qVar3, p.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            J("Marker reference '%s' not found", this.f65998f.f66031e.D);
                        }
                        qVar3 = null;
                        if (!(kVar instanceof SVG.u)) {
                        }
                        if (p == null) {
                            return;
                        }
                        SVG.Style style22 = this.f65998f.f66031e;
                        style22.D = null;
                        style22.C = null;
                        style22.B = null;
                        if (qVar != null) {
                        }
                        if (qVar2 != null) {
                        }
                        if (qVar3 == null) {
                        }
                    } else {
                        J("Marker reference '%s' not found", this.f65998f.f66031e.C);
                    }
                }
                qVar2 = null;
                str2 = this.f65998f.f66031e.D;
                if (str2 != null) {
                }
                qVar3 = null;
                if (!(kVar instanceof SVG.u)) {
                }
                if (p == null) {
                }
            } else {
                J("Marker reference '%s' not found", this.f65998f.f66031e.B);
            }
        }
        qVar = null;
        str = this.f65998f.f66031e.C;
        if (str != null) {
        }
        qVar2 = null;
        str2 = this.f65998f.f66031e.D;
        if (str2 != null) {
        }
        qVar3 = null;
        if (!(kVar instanceof SVG.u)) {
        }
        if (p == null) {
        }
    }

    public final void J0(SVG.r rVar, SVG.i0 i0Var) {
        float f2;
        float f3;
        C("Mask render", new Object[0]);
        Boolean bool = rVar.n;
        boolean z = true;
        if (bool != null && bool.booleanValue()) {
            SVG.o oVar = rVar.r;
            f2 = oVar != null ? oVar.f(this) : i0Var.f30361h.f30349g;
            SVG.o oVar2 = rVar.s;
            f3 = oVar2 != null ? oVar2.g(this) : i0Var.f30361h.f30350h;
            SVG.o oVar3 = rVar.p;
            if (oVar3 != null) {
                oVar3.f(this);
            } else {
                SVG.b bVar = i0Var.f30361h;
                float f4 = bVar.f30347e;
                float f5 = bVar.f30349g;
            }
            SVG.o oVar4 = rVar.q;
            if (oVar4 != null) {
                oVar4.g(this);
            } else {
                SVG.b bVar2 = i0Var.f30361h;
                float f6 = bVar2.f30348f;
                float f7 = bVar2.f30350h;
            }
        } else {
            SVG.o oVar5 = rVar.p;
            if (oVar5 != null) {
                oVar5.e(this, 1.0f);
            }
            SVG.o oVar6 = rVar.q;
            if (oVar6 != null) {
                oVar6.e(this, 1.0f);
            }
            SVG.o oVar7 = rVar.r;
            float e2 = oVar7 != null ? oVar7.e(this, 1.0f) : 1.2f;
            SVG.o oVar8 = rVar.s;
            float e3 = oVar8 != null ? oVar8.e(this, 1.0f) : 1.2f;
            SVG.b bVar3 = i0Var.f30361h;
            float f8 = bVar3.f30347e;
            float f9 = bVar3.f30349g;
            float f10 = bVar3.f30348f;
            f2 = e2 * f9;
            f3 = e3 * bVar3.f30350h;
        }
        if (f2 == 0.0f || f3 == 0.0f) {
            return;
        }
        S0();
        h Q = Q(rVar);
        this.f65998f = Q;
        Q.f66031e.q = Float.valueOf(1.0f);
        Boolean bool2 = rVar.o;
        if (bool2 != null && !bool2.booleanValue()) {
            z = false;
        }
        if (!z) {
            Canvas canvas = this.f65993a;
            SVG.b bVar4 = i0Var.f30361h;
            canvas.translate(bVar4.f30347e, bVar4.f30348f);
            Canvas canvas2 = this.f65993a;
            SVG.b bVar5 = i0Var.f30361h;
            canvas2.scale(bVar5.f30349g, bVar5.f30350h);
        }
        F0(rVar, false);
        R0();
    }

    public final void K(SVG.w0 w0Var, StringBuilder sb) {
        Iterator<SVG.l0> it = w0Var.f30358i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.l0 next = it.next();
            if (next instanceof SVG.w0) {
                K((SVG.w0) next, sb);
            } else if (next instanceof SVG.a1) {
                sb.append(T0(((SVG.a1) next).f30345c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    public final void K0(SVG.q0 q0Var) {
        Set<String> f2;
        String language = Locale.getDefault().getLanguage();
        d.c.a.d e2 = this.f65997e.e();
        for (SVG.l0 l0Var : q0Var.getChildren()) {
            if (l0Var instanceof SVG.e0) {
                SVG.e0 e0Var = (SVG.e0) l0Var;
                if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                    Set<String> h2 = e0Var.h();
                    if (h2 != null) {
                        if (l == null) {
                            Z();
                        }
                        if (!h2.isEmpty() && l.containsAll(h2)) {
                        }
                    }
                    Set<String> e3 = e0Var.e();
                    if (e3 != null) {
                        if (!e3.isEmpty() && e2 != null) {
                            for (String str : e3) {
                                if (!e2.a(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> m = e0Var.m();
                    if (m != null) {
                        if (!m.isEmpty() && e2 != null) {
                            for (String str2 : m) {
                                if (e2.b(str2, this.f65998f.f66031e.u.intValue(), String.valueOf(this.f65998f.f66031e.v)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    A0(l0Var);
                    return;
                }
            }
        }
    }

    public final void L(SVG.j jVar, String str) {
        SVG.l0 n = jVar.f30369a.n(str);
        if (n == null) {
            Z0("Gradient reference '%s' not found", str);
        } else if (!(n instanceof SVG.j)) {
            J("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (n == jVar) {
            J("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.j jVar2 = (SVG.j) n;
            if (jVar.f30363i == null) {
                jVar.f30363i = jVar2.f30363i;
            }
            if (jVar.j == null) {
                jVar.j = jVar2.j;
            }
            if (jVar.k == null) {
                jVar.k = jVar2.k;
            }
            if (jVar.f30362h.isEmpty()) {
                jVar.f30362h = jVar2.f30362h;
            }
            try {
                if (jVar instanceof SVG.k0) {
                    M((SVG.k0) jVar, (SVG.k0) n);
                } else {
                    N((SVG.o0) jVar, (SVG.o0) n);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = jVar2.l;
            if (str2 != null) {
                L(jVar, str2);
            }
        }
    }

    public final void L0(SVG.x0 x0Var) {
        C("TextPath render", new Object[0]);
        W0(this.f65998f, x0Var);
        if (E() && Y0()) {
            SVG.l0 n = x0Var.f30369a.n(x0Var.n);
            if (n == null) {
                J("TextPath reference '%s' not found", x0Var.n);
                return;
            }
            SVG.u uVar = (SVG.u) n;
            Path f2 = new d(this, uVar.o).f();
            Matrix matrix = uVar.n;
            if (matrix != null) {
                f2.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(f2, false);
            SVG.o oVar = x0Var.o;
            float e2 = oVar != null ? oVar.e(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor S = S();
            if (S != SVG.Style.TextAnchor.Start) {
                float r = r(x0Var);
                if (S == SVG.Style.TextAnchor.Middle) {
                    r /= 2.0f;
                }
                e2 -= r;
            }
            v((SVG.i0) x0Var.c());
            boolean n0 = n0();
            I(x0Var, new e(f2, e2, 0.0f));
            if (n0) {
                k0(x0Var);
            }
        }
    }

    public final void M(SVG.k0 k0Var, SVG.k0 k0Var2) {
        if (k0Var.m == null) {
            k0Var.m = k0Var2.m;
        }
        if (k0Var.n == null) {
            k0Var.n = k0Var2.n;
        }
        if (k0Var.o == null) {
            k0Var.o = k0Var2.o;
        }
        if (k0Var.p == null) {
            k0Var.p = k0Var2.p;
        }
    }

    public final boolean M0() {
        h hVar = this.f65998f;
        if (hVar.f66031e.K != null && !hVar.m) {
            Z0("Masks are not supported when using getPicture()", new Object[0]);
        }
        if (this.f65998f.f66031e.q.floatValue() >= 1.0f) {
            h hVar2 = this.f65998f;
            if (hVar2.f66031e.K == null || !hVar2.m) {
                return false;
            }
        }
        return true;
    }

    public final void N(SVG.o0 o0Var, SVG.o0 o0Var2) {
        if (o0Var.m == null) {
            o0Var.m = o0Var2.m;
        }
        if (o0Var.n == null) {
            o0Var.n = o0Var2.n;
        }
        if (o0Var.o == null) {
            o0Var.o = o0Var2.o;
        }
        if (o0Var.p == null) {
            o0Var.p = o0Var2.p;
        }
        if (o0Var.q == null) {
            o0Var.q = o0Var2.q;
        }
    }

    public final void N0() {
        this.f65998f = new h(this);
        this.f65999g = new Stack<>();
        V0(this.f65998f, SVG.Style.b());
        h hVar = this.f65998f;
        hVar.j = this.f65994b;
        hVar.l = false;
        hVar.m = this.f65996d;
        this.f65999g.push((h) hVar.clone());
        this.j = new Stack<>();
        this.k = new Stack<>();
        this.f66001i = new Stack<>();
        this.f66000h = new Stack<>();
    }

    public final void O(SVG.x xVar, String str) {
        SVG.l0 n = xVar.f30369a.n(str);
        if (n == null) {
            Z0("Pattern reference '%s' not found", str);
        } else if (!(n instanceof SVG.x)) {
            J("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (n == xVar) {
            J("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.x xVar2 = (SVG.x) n;
            if (xVar.p == null) {
                xVar.p = xVar2.p;
            }
            if (xVar.q == null) {
                xVar.q = xVar2.q;
            }
            if (xVar.r == null) {
                xVar.r = xVar2.r;
            }
            if (xVar.s == null) {
                xVar.s = xVar2.s;
            }
            if (xVar.t == null) {
                xVar.t = xVar2.t;
            }
            if (xVar.u == null) {
                xVar.u = xVar2.u;
            }
            if (xVar.v == null) {
                xVar.v = xVar2.v;
            }
            if (xVar.f30358i.isEmpty()) {
                xVar.f30358i = xVar2.f30358i;
            }
            if (xVar.o == null) {
                xVar.o = xVar2.o;
            }
            if (xVar.n == null) {
                xVar.n = xVar2.n;
            }
            String str2 = xVar2.w;
            if (str2 != null) {
                O(xVar, str2);
            }
        }
    }

    public final void O0(float f2, float f3, float f4, float f5) {
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        SVG.c cVar = this.f65998f.f66031e.A;
        if (cVar != null) {
            f2 += cVar.f30354d.f(this);
            f3 += this.f65998f.f66031e.A.f30351a.g(this);
            f6 -= this.f65998f.f66031e.A.f30352b.f(this);
            f7 -= this.f65998f.f66031e.A.f30353c.g(this);
        }
        this.f65993a.clipRect(f2, f3, f6, f7);
    }

    public final void P(SVG.i0 i0Var, Path path, SVG.x xVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Boolean bool = xVar.p;
        boolean z = bool != null && bool.booleanValue();
        String str = xVar.w;
        if (str != null) {
            O(xVar, str);
        }
        if (z) {
            SVG.o oVar = xVar.s;
            f2 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = xVar.t;
            f4 = oVar2 != null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = xVar.u;
            f5 = oVar3 != null ? oVar3.f(this) : 0.0f;
            SVG.o oVar4 = xVar.v;
            f3 = oVar4 != null ? oVar4.g(this) : 0.0f;
        } else {
            SVG.o oVar5 = xVar.s;
            float e2 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
            SVG.o oVar6 = xVar.t;
            float e3 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
            SVG.o oVar7 = xVar.u;
            float e4 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.0f;
            SVG.o oVar8 = xVar.v;
            float e5 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
            SVG.b bVar = i0Var.f30361h;
            float f6 = bVar.f30347e;
            float f7 = bVar.f30349g;
            f2 = (e2 * f7) + f6;
            float f8 = bVar.f30348f;
            float f9 = bVar.f30350h;
            float f10 = e4 * f7;
            f3 = e5 * f9;
            f4 = (e3 * f9) + f8;
            f5 = f10;
        }
        if (f5 == 0.0f || f3 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = xVar.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f30331d;
        }
        S0();
        this.f65993a.clipPath(path);
        h hVar = new h(this);
        V0(hVar, SVG.Style.b());
        hVar.f66031e.z = Boolean.FALSE;
        R(xVar, hVar);
        this.f65998f = hVar;
        SVG.b bVar2 = i0Var.f30361h;
        Matrix matrix = xVar.r;
        if (matrix != null) {
            this.f65993a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (xVar.r.invert(matrix2)) {
                SVG.b bVar3 = i0Var.f30361h;
                SVG.b bVar4 = i0Var.f30361h;
                SVG.b bVar5 = i0Var.f30361h;
                float[] fArr = {bVar3.f30347e, bVar3.f30348f, bVar3.b(), bVar4.f30348f, bVar4.b(), i0Var.f30361h.c(), bVar5.f30347e, bVar5.c()};
                matrix2.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    int i3 = i2 + 1;
                    if (fArr[i3] < rectF.top) {
                        rectF.top = fArr[i3];
                    }
                    if (fArr[i3] > rectF.bottom) {
                        rectF.bottom = fArr[i3];
                    }
                }
                float f11 = rectF.left;
                float f12 = rectF.top;
                bVar2 = new SVG.b(f11, f12, rectF.right - f11, rectF.bottom - f12);
            }
        }
        float floor = f2 + (((float) Math.floor((bVar2.f30347e - f2) / f5)) * f5);
        float b2 = bVar2.b();
        float c2 = bVar2.c();
        SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f5, f3);
        for (float floor2 = f4 + (((float) Math.floor((bVar2.f30348f - f4) / f3)) * f3); floor2 < c2; floor2 += f3) {
            for (float f13 = floor; f13 < b2; f13 += f5) {
                bVar6.f30347e = f13;
                bVar6.f30348f = floor2;
                S0();
                if (!this.f65998f.f66031e.z.booleanValue()) {
                    O0(bVar6.f30347e, bVar6.f30348f, bVar6.f30349g, bVar6.f30350h);
                }
                SVG.b bVar7 = xVar.o;
                if (bVar7 != null) {
                    this.f65993a.concat(s(bVar6, bVar7, preserveAspectRatio));
                } else {
                    Boolean bool2 = xVar.q;
                    boolean z2 = bool2 == null || bool2.booleanValue();
                    this.f65993a.translate(f13, floor2);
                    if (!z2) {
                        Canvas canvas = this.f65993a;
                        SVG.b bVar8 = i0Var.f30361h;
                        canvas.scale(bVar8.f30349g, bVar8.f30350h);
                    }
                }
                boolean n0 = n0();
                for (SVG.l0 l0Var : xVar.f30358i) {
                    A0(l0Var);
                }
                if (n0) {
                    k0(xVar);
                }
                R0();
            }
        }
        R0();
    }

    public final void P0(h hVar, boolean z, SVG.m0 m0Var) {
        int i2;
        SVG.Style style = hVar.f66031e;
        float floatValue = (z ? style.f30342h : style.j).floatValue();
        if (m0Var instanceof SVG.f) {
            i2 = ((SVG.f) m0Var).f30357e;
        } else if (!(m0Var instanceof SVG.g)) {
            return;
        } else {
            i2 = hVar.f66031e.r.f30357e;
        }
        int z2 = i2 | (z(floatValue) << 24);
        if (z) {
            hVar.f66034h.setColor(z2);
        } else {
            hVar.f66035i.setColor(z2);
        }
    }

    public final h Q(SVG.l0 l0Var) {
        h hVar = new h(this);
        V0(hVar, SVG.Style.b());
        R(l0Var, hVar);
        return hVar;
    }

    public final void Q0(boolean z, SVG.b0 b0Var) {
        if (z) {
            if (a0(b0Var.f30366e, 2147483648L)) {
                h hVar = this.f65998f;
                SVG.Style style = hVar.f66031e;
                SVG.m0 m0Var = b0Var.f30366e.L;
                style.f30340f = m0Var;
                hVar.f66032f = m0Var != null;
            }
            if (a0(b0Var.f30366e, 4294967296L)) {
                this.f65998f.f66031e.f30342h = b0Var.f30366e.M;
            }
            if (a0(b0Var.f30366e, 6442450944L)) {
                h hVar2 = this.f65998f;
                P0(hVar2, z, hVar2.f66031e.f30340f);
                return;
            }
            return;
        }
        if (a0(b0Var.f30366e, 2147483648L)) {
            h hVar3 = this.f65998f;
            SVG.Style style2 = hVar3.f66031e;
            SVG.m0 m0Var2 = b0Var.f30366e.L;
            style2.f30343i = m0Var2;
            hVar3.f66033g = m0Var2 != null;
        }
        if (a0(b0Var.f30366e, 4294967296L)) {
            this.f65998f.f66031e.j = b0Var.f30366e.M;
        }
        if (a0(b0Var.f30366e, 6442450944L)) {
            h hVar4 = this.f65998f;
            P0(hVar4, z, hVar4.f66031e.f30343i);
        }
    }

    public final h R(SVG.l0 l0Var, h hVar) {
        ArrayList<SVG.j0> arrayList = new ArrayList();
        while (true) {
            if (l0Var instanceof SVG.j0) {
                arrayList.add(0, (SVG.j0) l0Var);
            }
            SVG.h0 h0Var = l0Var.f30370b;
            if (h0Var == null) {
                break;
            }
            l0Var = (SVG.l0) h0Var;
        }
        for (SVG.j0 j0Var : arrayList) {
            W0(hVar, j0Var);
        }
        SVG.b bVar = this.f65997e.j().o;
        hVar.k = bVar;
        if (bVar == null) {
            hVar.k = this.f65994b;
        }
        hVar.j = this.f65994b;
        hVar.m = this.f65998f.m;
        return hVar;
    }

    public final void R0() {
        this.f65993a.restore();
        this.f65998f = this.f65999g.pop();
    }

    public final SVG.Style.TextAnchor S() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.f65998f.f66031e;
        if (style.x != SVG.Style.TextDirection.LTR && (textAnchor = style.y) != SVG.Style.TextAnchor.Middle) {
            SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
            return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
        }
        return this.f65998f.f66031e.y;
    }

    public final void S0() {
        this.f65993a.save();
        this.f65999g.push(this.f65998f);
        this.f65998f = (h) this.f65998f.clone();
    }

    public final Path.FillType T() {
        SVG.Style.FillRule fillRule = this.f65998f.f66031e.J;
        if (fillRule == null) {
            return Path.FillType.WINDING;
        }
        if (a.f66005d[fillRule.ordinal()] != 1) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    public final String T0(String str, boolean z, boolean z2) {
        if (this.f65998f.l) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    public float U() {
        return this.f65998f.f66034h.getTextSize();
    }

    public final void U0(SVG.i0 i0Var) {
        if (i0Var.f30370b == null || i0Var.f30361h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f66001i.peek().invert(matrix)) {
            SVG.b bVar = i0Var.f30361h;
            SVG.b bVar2 = i0Var.f30361h;
            SVG.b bVar3 = i0Var.f30361h;
            float[] fArr = {bVar.f30347e, bVar.f30348f, bVar.b(), bVar2.f30348f, bVar2.b(), i0Var.f30361h.c(), bVar3.f30347e, bVar3.c()};
            matrix.preConcat(this.f65993a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.i0 i0Var2 = (SVG.i0) this.f66000h.peek();
            SVG.b bVar4 = i0Var2.f30361h;
            if (bVar4 == null) {
                i0Var2.f30361h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.d(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public float V() {
        return this.f65998f.f66034h.getTextSize() / 2.0f;
    }

    public final void V0(h hVar, SVG.Style style) {
        SVG svg;
        if (a0(style, 4096L)) {
            hVar.f66031e.r = style.r;
        }
        if (a0(style, 2048L)) {
            hVar.f66031e.q = style.q;
        }
        if (a0(style, 1L)) {
            hVar.f66031e.f30340f = style.f30340f;
            hVar.f66032f = style.f30340f != null;
        }
        if (a0(style, 4L)) {
            hVar.f66031e.f30342h = style.f30342h;
        }
        if (a0(style, 6149L)) {
            P0(hVar, true, hVar.f66031e.f30340f);
        }
        if (a0(style, 2L)) {
            hVar.f66031e.f30341g = style.f30341g;
        }
        if (a0(style, 8L)) {
            hVar.f66031e.f30343i = style.f30343i;
            hVar.f66033g = style.f30343i != null;
        }
        if (a0(style, 16L)) {
            hVar.f66031e.j = style.j;
        }
        if (a0(style, 6168L)) {
            P0(hVar, false, hVar.f66031e.f30343i);
        }
        if (a0(style, 34359738368L)) {
            hVar.f66031e.P = style.P;
        }
        if (a0(style, 32L)) {
            SVG.Style style2 = hVar.f66031e;
            SVG.o oVar = style.k;
            style2.k = oVar;
            hVar.f66035i.setStrokeWidth(oVar.d(this));
        }
        if (a0(style, 64L)) {
            hVar.f66031e.l = style.l;
            int i2 = a.f66003b[style.l.ordinal()];
            if (i2 == 1) {
                hVar.f66035i.setStrokeCap(Paint.Cap.BUTT);
            } else if (i2 == 2) {
                hVar.f66035i.setStrokeCap(Paint.Cap.ROUND);
            } else if (i2 == 3) {
                hVar.f66035i.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (a0(style, 128L)) {
            hVar.f66031e.m = style.m;
            int i3 = a.f66004c[style.m.ordinal()];
            if (i3 == 1) {
                hVar.f66035i.setStrokeJoin(Paint.Join.MITER);
            } else if (i3 == 2) {
                hVar.f66035i.setStrokeJoin(Paint.Join.ROUND);
            } else if (i3 == 3) {
                hVar.f66035i.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (a0(style, 256L)) {
            hVar.f66031e.n = style.n;
            hVar.f66035i.setStrokeMiter(style.n.floatValue());
        }
        if (a0(style, 512L)) {
            hVar.f66031e.o = style.o;
        }
        if (a0(style, 1024L)) {
            hVar.f66031e.p = style.p;
        }
        Typeface typeface = null;
        if (a0(style, 1536L)) {
            SVG.o[] oVarArr = hVar.f66031e.o;
            if (oVarArr == null) {
                hVar.f66035i.setPathEffect(null);
            } else {
                int length = oVarArr.length;
                int i4 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i4];
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    fArr[i5] = hVar.f66031e.o[i5 % length].d(this);
                    f2 += fArr[i5];
                }
                if (f2 == 0.0f) {
                    hVar.f66035i.setPathEffect(null);
                } else {
                    float d2 = hVar.f66031e.p.d(this);
                    if (d2 < 0.0f) {
                        d2 = (d2 % f2) + f2;
                    }
                    hVar.f66035i.setPathEffect(new DashPathEffect(fArr, d2));
                }
            }
        }
        if (a0(style, 16384L)) {
            float U = U();
            hVar.f66031e.t = style.t;
            hVar.f66034h.setTextSize(style.t.e(this, U));
            hVar.f66035i.setTextSize(style.t.e(this, U));
        }
        if (a0(style, 8192L)) {
            hVar.f66031e.s = style.s;
        }
        if (a0(style, 32768L)) {
            if (style.u.intValue() == -1 && hVar.f66031e.u.intValue() > 100) {
                SVG.Style style3 = hVar.f66031e;
                style3.u = Integer.valueOf(style3.u.intValue() - 100);
            } else if (style.u.intValue() == 1 && hVar.f66031e.u.intValue() < 900) {
                SVG.Style style4 = hVar.f66031e;
                style4.u = Integer.valueOf(style4.u.intValue() + 100);
            } else {
                hVar.f66031e.u = style.u;
            }
        }
        if (a0(style, 65536L)) {
            hVar.f66031e.v = style.v;
        }
        if (a0(style, 106496L)) {
            if (hVar.f66031e.s != null && (svg = this.f65997e) != null) {
                d.c.a.d e2 = svg.e();
                for (String str : hVar.f66031e.s) {
                    SVG.Style style5 = hVar.f66031e;
                    Typeface x = x(str, style5.u, style5.v);
                    if (x != null || e2 == null) {
                        typeface = x;
                        continue;
                    } else {
                        typeface = e2.b(str, hVar.f66031e.u.intValue(), String.valueOf(hVar.f66031e.v));
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.f66031e;
                typeface = x(TypefaceCompatApi28Impl.DEFAULT_FAMILY, style6.u, style6.v);
            }
            hVar.f66034h.setTypeface(typeface);
            hVar.f66035i.setTypeface(typeface);
        }
        if (a0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            hVar.f66031e.w = style.w;
            hVar.f66034h.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
            hVar.f66034h.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                hVar.f66035i.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
                hVar.f66035i.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a0(style, 68719476736L)) {
            hVar.f66031e.x = style.x;
        }
        if (a0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            hVar.f66031e.y = style.y;
        }
        if (a0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            hVar.f66031e.z = style.z;
        }
        if (a0(style, 2097152L)) {
            hVar.f66031e.B = style.B;
        }
        if (a0(style, 4194304L)) {
            hVar.f66031e.C = style.C;
        }
        if (a0(style, 8388608L)) {
            hVar.f66031e.D = style.D;
        }
        if (a0(style, 16777216L)) {
            hVar.f66031e.E = style.E;
        }
        if (a0(style, 33554432L)) {
            hVar.f66031e.F = style.F;
        }
        if (a0(style, 1048576L)) {
            hVar.f66031e.A = style.A;
        }
        if (a0(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            hVar.f66031e.I = style.I;
        }
        if (a0(style, 536870912L)) {
            hVar.f66031e.J = style.J;
        }
        if (a0(style, 1073741824L)) {
            hVar.f66031e.K = style.K;
        }
        if (a0(style, 67108864L)) {
            hVar.f66031e.G = style.G;
        }
        if (a0(style, 134217728L)) {
            hVar.f66031e.H = style.H;
        }
        if (a0(style, AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT)) {
            hVar.f66031e.N = style.N;
        }
        if (a0(style, 17179869184L)) {
            hVar.f66031e.O = style.O;
        }
    }

    public SVG.b W() {
        h hVar = this.f65998f;
        SVG.b bVar = hVar.k;
        return bVar != null ? bVar : hVar.j;
    }

    public final void W0(h hVar, SVG.j0 j0Var) {
        hVar.f66031e.c(j0Var.f30370b == null);
        SVG.Style style = j0Var.f30366e;
        if (style != null) {
            V0(hVar, style);
        }
        if (this.f65997e.k()) {
            for (CSSParser.d dVar : this.f65997e.b()) {
                if (CSSParser.m(dVar.f30321a, j0Var)) {
                    V0(hVar, dVar.f30322b);
                }
            }
        }
        SVG.Style style2 = j0Var.f30367f;
        if (style2 != null) {
            V0(hVar, style2);
        }
    }

    public float X() {
        return this.f65995c;
    }

    public final void X0() {
        int i2;
        SVG.Style style = this.f65998f.f66031e;
        SVG.m0 m0Var = style.N;
        if (m0Var instanceof SVG.f) {
            i2 = ((SVG.f) m0Var).f30357e;
        } else if (!(m0Var instanceof SVG.g)) {
            return;
        } else {
            i2 = style.r.f30357e;
        }
        Float f2 = this.f65998f.f66031e.O;
        if (f2 != null) {
            i2 |= z(f2.floatValue()) << 24;
        }
        this.f65993a.drawColor(i2);
    }

    public final Path.FillType Y() {
        SVG.Style.FillRule fillRule = this.f65998f.f66031e.f30341g;
        if (fillRule == null) {
            return Path.FillType.WINDING;
        }
        if (a.f66005d[fillRule.ordinal()] != 1) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    public final boolean Y0() {
        Boolean bool = this.f65998f.f66031e.F;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean a0(SVG.Style style, long j2) {
        return (style.f30339e & j2) != 0;
    }

    public final void b0(boolean z, SVG.b bVar, SVG.k0 k0Var) {
        float e2;
        float f2;
        float f3;
        float f4;
        String str = k0Var.l;
        if (str != null) {
            L(k0Var, str);
        }
        Boolean bool = k0Var.f30363i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        h hVar = this.f65998f;
        Paint paint = z ? hVar.f66034h : hVar.f66035i;
        if (z2) {
            SVG.b W = W();
            SVG.o oVar = k0Var.m;
            float f5 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = k0Var.n;
            float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = k0Var.o;
            float f6 = oVar3 != null ? oVar3.f(this) : W.f30349g;
            SVG.o oVar4 = k0Var.p;
            e2 = oVar4 != null ? oVar4.g(this) : 0.0f;
            f4 = f6;
            f2 = f5;
            f3 = g2;
        } else {
            SVG.o oVar5 = k0Var.m;
            float e3 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
            SVG.o oVar6 = k0Var.n;
            float e4 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
            SVG.o oVar7 = k0Var.o;
            float e5 = oVar7 != null ? oVar7.e(this, 1.0f) : 1.0f;
            SVG.o oVar8 = k0Var.p;
            e2 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
            f2 = e3;
            f3 = e4;
            f4 = e5;
        }
        S0();
        this.f65998f = Q(k0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.f30347e, bVar.f30348f);
            matrix.preScale(bVar.f30349g, bVar.f30350h);
        }
        Matrix matrix2 = k0Var.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = k0Var.f30362h.size();
        if (size == 0) {
            R0();
            if (z) {
                this.f65998f.f66032f = false;
                return;
            } else {
                this.f65998f.f66033g = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f7 = -1.0f;
        Iterator<SVG.l0> it = k0Var.f30362h.iterator();
        while (it.hasNext()) {
            SVG.c0 c0Var = (SVG.c0) it.next();
            if (i2 != 0 && c0Var.f30355h.floatValue() < f7) {
                fArr[i2] = f7;
            } else {
                fArr[i2] = c0Var.f30355h.floatValue();
                f7 = c0Var.f30355h.floatValue();
            }
            S0();
            W0(this.f65998f, c0Var);
            SVG.f fVar = (SVG.f) this.f65998f.f66031e.G;
            if (fVar == null) {
                fVar = SVG.f.f30356f;
            }
            iArr[i2] = fVar.f30357e | (z(this.f65998f.f66031e.H.floatValue()) << 24);
            i2++;
            R0();
        }
        if ((f2 == f4 && f3 == e2) || size == 1) {
            R0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = k0Var.k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        R0();
        LinearGradient linearGradient = new LinearGradient(f2, f3, f4, e2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    public final Path c0(SVG.d dVar) {
        SVG.o oVar = dVar.o;
        float f2 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = dVar.p;
        float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
        float d2 = dVar.q.d(this);
        float f3 = f2 - d2;
        float f4 = g2 - d2;
        float f5 = f2 + d2;
        float f6 = g2 + d2;
        if (dVar.f30361h == null) {
            float f7 = 2.0f * d2;
            dVar.f30361h = new SVG.b(f3, f4, f7, f7);
        }
        float f8 = 0.5522848f * d2;
        Path path = new Path();
        path.moveTo(f2, f4);
        float f9 = f2 + f8;
        float f10 = g2 - f8;
        path.cubicTo(f9, f4, f5, f10, f5, g2);
        float f11 = g2 + f8;
        path.cubicTo(f5, f11, f9, f6, f2, f6);
        float f12 = f2 - f8;
        path.cubicTo(f12, f6, f3, f11, f3, g2);
        path.cubicTo(f3, f10, f12, f4, f2, f4);
        path.close();
        return path;
    }

    public final Path d0(SVG.i iVar) {
        SVG.o oVar = iVar.o;
        float f2 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = iVar.p;
        float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
        float f3 = iVar.q.f(this);
        float g3 = iVar.r.g(this);
        float f4 = f2 - f3;
        float f5 = g2 - g3;
        float f6 = f2 + f3;
        float f7 = g2 + g3;
        if (iVar.f30361h == null) {
            iVar.f30361h = new SVG.b(f4, f5, f3 * 2.0f, 2.0f * g3);
        }
        float f8 = f3 * 0.5522848f;
        float f9 = 0.5522848f * g3;
        Path path = new Path();
        path.moveTo(f2, f5);
        float f10 = f2 + f8;
        float f11 = g2 - f9;
        path.cubicTo(f10, f5, f6, f11, f6, g2);
        float f12 = f9 + g2;
        path.cubicTo(f6, f12, f10, f7, f2, f7);
        float f13 = f2 - f8;
        path.cubicTo(f13, f7, f4, f12, f4, g2);
        path.cubicTo(f4, f11, f13, f5, f2, f5);
        path.close();
        return path;
    }

    public final Path e0(SVG.p pVar) {
        SVG.o oVar = pVar.o;
        float f2 = oVar == null ? 0.0f : oVar.f(this);
        SVG.o oVar2 = pVar.p;
        float g2 = oVar2 == null ? 0.0f : oVar2.g(this);
        SVG.o oVar3 = pVar.q;
        float f3 = oVar3 == null ? 0.0f : oVar3.f(this);
        SVG.o oVar4 = pVar.r;
        float g3 = oVar4 != null ? oVar4.g(this) : 0.0f;
        if (pVar.f30361h == null) {
            pVar.f30361h = new SVG.b(Math.min(f2, g2), Math.min(g2, g3), Math.abs(f3 - f2), Math.abs(g3 - g2));
        }
        Path path = new Path();
        path.moveTo(f2, g2);
        path.lineTo(f3, g3);
        return path;
    }

    public final Path f0(SVG.y yVar) {
        Path path = new Path();
        float[] fArr = yVar.o;
        path.moveTo(fArr[0], fArr[1]);
        int i2 = 2;
        while (true) {
            float[] fArr2 = yVar.o;
            if (i2 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
            i2 += 2;
        }
        if (yVar instanceof SVG.z) {
            path.close();
        }
        if (yVar.f30361h == null) {
            yVar.f30361h = q(path);
        }
        path.setFillType(T());
        return path;
    }

    public final Path g0(SVG.a0 a0Var) {
        float f2;
        float g2;
        Path path;
        if (a0Var.s == null && a0Var.t == null) {
            f2 = 0.0f;
            g2 = 0.0f;
        } else {
            SVG.o oVar = a0Var.s;
            if (oVar == null) {
                f2 = a0Var.t.g(this);
            } else if (a0Var.t == null) {
                f2 = oVar.f(this);
            } else {
                f2 = oVar.f(this);
                g2 = a0Var.t.g(this);
            }
            g2 = f2;
        }
        float min = Math.min(f2, a0Var.q.f(this) / 2.0f);
        float min2 = Math.min(g2, a0Var.r.g(this) / 2.0f);
        SVG.o oVar2 = a0Var.o;
        float f3 = oVar2 != null ? oVar2.f(this) : 0.0f;
        SVG.o oVar3 = a0Var.p;
        float g3 = oVar3 != null ? oVar3.g(this) : 0.0f;
        float f4 = a0Var.q.f(this);
        float g4 = a0Var.r.g(this);
        if (a0Var.f30361h == null) {
            a0Var.f30361h = new SVG.b(f3, g3, f4, g4);
        }
        float f5 = f3 + f4;
        float f6 = g3 + g4;
        Path path2 = new Path();
        if (min != 0.0f && min2 != 0.0f) {
            float f7 = min * 0.5522848f;
            float f8 = 0.5522848f * min2;
            float f9 = g3 + min2;
            path2.moveTo(f3, f9);
            float f10 = f9 - f8;
            float f11 = f3 + min;
            float f12 = f11 - f7;
            path2.cubicTo(f3, f10, f12, g3, f11, g3);
            float f13 = f5 - min;
            path2.lineTo(f13, g3);
            float f14 = f13 + f7;
            path2.cubicTo(f14, g3, f5, f10, f5, f9);
            float f15 = f6 - min2;
            path2.lineTo(f5, f15);
            float f16 = f15 + f8;
            path = path2;
            path2.cubicTo(f5, f16, f14, f6, f13, f6);
            path.lineTo(f11, f6);
            path.cubicTo(f12, f6, f3, f16, f3, f15);
            path.lineTo(f3, f9);
        } else {
            path = path2;
            path.moveTo(f3, g3);
            path.lineTo(f5, g3);
            path.lineTo(f5, f6);
            path.lineTo(f3, f6);
            path.lineTo(f3, g3);
        }
        path.close();
        return path;
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path f0;
        W0(this.f65998f, kVar);
        if (E() && Y0()) {
            Matrix matrix2 = kVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (kVar instanceof SVG.a0) {
                f0 = g0((SVG.a0) kVar);
            } else if (kVar instanceof SVG.d) {
                f0 = c0((SVG.d) kVar);
            } else if (kVar instanceof SVG.i) {
                f0 = d0((SVG.i) kVar);
            } else if (!(kVar instanceof SVG.y)) {
                return;
            } else {
                f0 = f0((SVG.y) kVar);
            }
            t(kVar);
            path.setFillType(f0.getFillType());
            path.addPath(f0, matrix);
        }
    }

    public final void h0(boolean z, SVG.b bVar, SVG.o0 o0Var) {
        float f2;
        float e2;
        float f3;
        String str = o0Var.l;
        if (str != null) {
            L(o0Var, str);
        }
        Boolean bool = o0Var.f30363i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        h hVar = this.f65998f;
        Paint paint = z ? hVar.f66034h : hVar.f66035i;
        if (z2) {
            SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
            SVG.o oVar2 = o0Var.m;
            float f4 = oVar2 != null ? oVar2.f(this) : oVar.f(this);
            SVG.o oVar3 = o0Var.n;
            float g2 = oVar3 != null ? oVar3.g(this) : oVar.g(this);
            SVG.o oVar4 = o0Var.o;
            e2 = oVar4 != null ? oVar4.d(this) : oVar.d(this);
            f2 = f4;
            f3 = g2;
        } else {
            SVG.o oVar5 = o0Var.m;
            float e3 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.5f;
            SVG.o oVar6 = o0Var.n;
            float e4 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.5f;
            SVG.o oVar7 = o0Var.o;
            f2 = e3;
            e2 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.5f;
            f3 = e4;
        }
        S0();
        this.f65998f = Q(o0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.f30347e, bVar.f30348f);
            matrix.preScale(bVar.f30349g, bVar.f30350h);
        }
        Matrix matrix2 = o0Var.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = o0Var.f30362h.size();
        if (size == 0) {
            R0();
            if (z) {
                this.f65998f.f66032f = false;
                return;
            } else {
                this.f65998f.f66033g = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f5 = -1.0f;
        Iterator<SVG.l0> it = o0Var.f30362h.iterator();
        while (it.hasNext()) {
            SVG.c0 c0Var = (SVG.c0) it.next();
            if (i2 != 0 && c0Var.f30355h.floatValue() < f5) {
                fArr[i2] = f5;
            } else {
                fArr[i2] = c0Var.f30355h.floatValue();
                f5 = c0Var.f30355h.floatValue();
            }
            S0();
            W0(this.f65998f, c0Var);
            SVG.f fVar = (SVG.f) this.f65998f.f66031e.G;
            if (fVar == null) {
                fVar = SVG.f.f30356f;
            }
            iArr[i2] = fVar.f30357e | (z(this.f65998f.f66031e.H.floatValue()) << 24);
            i2++;
            R0();
        }
        if (e2 != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = o0Var.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            R0();
            RadialGradient radialGradient = new RadialGradient(f2, f3, e2, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            return;
        }
        R0();
        paint.setColor(iArr[size - 1]);
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        W0(this.f65998f, uVar);
        if (E() && Y0()) {
            Matrix matrix2 = uVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path f2 = new d(this, uVar.o).f();
            if (uVar.f30361h == null) {
                uVar.f30361h = q(f2);
            }
            t(uVar);
            path.setFillType(T());
            path.addPath(f2, matrix);
        }
    }

    public final void i0() {
        this.f66000h.pop();
        this.f66001i.pop();
    }

    public final void j(SVG.l0 l0Var, boolean z, Path path, Matrix matrix) {
        if (E()) {
            B();
            if (l0Var instanceof SVG.b1) {
                if (z) {
                    l((SVG.b1) l0Var, path, matrix);
                } else {
                    J("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (l0Var instanceof SVG.u) {
                i((SVG.u) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.u0) {
                k((SVG.u0) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.k) {
                h((SVG.k) l0Var, path, matrix);
            } else {
                J("Invalid %s element found in clipPath definition", l0Var.getClass().getSimpleName());
            }
            A();
        }
    }

    public final void j0(SVG.h0 h0Var) {
        this.f66000h.push(h0Var);
        this.f66001i.push(this.f65993a.getMatrix());
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        W0(this.f65998f, u0Var);
        if (E()) {
            Matrix matrix2 = u0Var.r;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.o> list = u0Var.n;
            float f2 = 0.0f;
            float f3 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).f(this);
            List<SVG.o> list2 = u0Var.o;
            float g2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).g(this);
            List<SVG.o> list3 = u0Var.p;
            float f4 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).f(this);
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f2 = u0Var.q.get(0).g(this);
            }
            if (this.f65998f.f66031e.y != SVG.Style.TextAnchor.Start) {
                float r = r(u0Var);
                if (this.f65998f.f66031e.y == SVG.Style.TextAnchor.Middle) {
                    r /= 2.0f;
                }
                f3 -= r;
            }
            if (u0Var.f30361h == null) {
                i iVar = new i(f3, g2);
                I(u0Var, iVar);
                RectF rectF = iVar.f66038c;
                u0Var.f30361h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f66038c.height());
            }
            t(u0Var);
            Path path2 = new Path();
            I(u0Var, new g(f3 + f4, g2 + f2, path2));
            path.setFillType(T());
            path.addPath(path2, matrix);
        }
    }

    public final void k0(SVG.i0 i0Var) {
        h hVar = this.f65998f;
        String str = hVar.f66031e.K;
        if (str != null && hVar.m) {
            SVG.l0 n = this.f65997e.n(str);
            H();
            J0((SVG.r) n, i0Var);
            Bitmap l0 = l0();
            Canvas pop = this.j.pop();
            this.f65993a = pop;
            pop.save();
            this.f65993a.setMatrix(new Matrix());
            this.f65993a.drawBitmap(l0, 0.0f, 0.0f, this.f65998f.f66034h);
            l0.recycle();
            this.f65993a.restore();
        }
        R0();
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        W0(this.f65998f, b1Var);
        if (E() && Y0()) {
            Matrix matrix2 = b1Var.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.l0 n = b1Var.f30369a.n(b1Var.o);
            if (n == null) {
                J("Use reference '%s' not found", b1Var.o);
                return;
            }
            t(b1Var);
            j(n, false, path, matrix);
        }
    }

    public final Bitmap l0() {
        Bitmap pop = this.k.pop();
        Bitmap pop2 = this.k.pop();
        int width = pop.getWidth();
        int height = pop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i2 = 0;
        while (i2 < height) {
            pop.getPixels(iArr, 0, width, 0, i2, width, 1);
            int i3 = i2;
            pop2.getPixels(iArr2, 0, width, 0, i2, width, 1);
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = iArr[i4];
                int i6 = i5 & 255;
                int i7 = (i5 >> 8) & 255;
                int i8 = (i5 >> 16) & 255;
                int i9 = (i5 >> 24) & 255;
                if (i9 == 0) {
                    iArr2[i4] = 0;
                } else {
                    int i10 = iArr2[i4];
                    iArr2[i4] = (i10 & ViewCompat.MEASURED_SIZE_MASK) | (((((i10 >> 24) & 255) * (((((i8 * 6963) + (i7 * 23442)) + (i6 * 2362)) * i9) / 8355840)) / 255) << 24);
                }
            }
            pop2.setPixels(iArr2, 0, width, 0, i3, width, 1);
            i2 = i3 + 1;
        }
        pop.recycle();
        return pop2;
    }

    public final void m0(SVG.l0 l0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                S0();
                L0((SVG.x0) l0Var);
                R0();
            } else if (l0Var instanceof SVG.t0) {
                C("TSpan render", new Object[0]);
                S0();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                W0(this.f65998f, t0Var);
                if (E()) {
                    boolean z = jVar instanceof f;
                    float f6 = 0.0f;
                    if (z) {
                        List<SVG.o> list = t0Var.n;
                        if (list != null && list.size() != 0) {
                            f5 = t0Var.n.get(0).f(this);
                        } else {
                            f5 = ((f) jVar).f66024a;
                        }
                        List<SVG.o> list2 = t0Var.o;
                        if (list2 != null && list2.size() != 0) {
                            f3 = t0Var.o.get(0).g(this);
                        } else {
                            f3 = ((f) jVar).f66025b;
                        }
                        List<SVG.o> list3 = t0Var.p;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.p.get(0).f(this);
                        List<SVG.o> list4 = t0Var.q;
                        if (list4 != null && list4.size() != 0) {
                            f6 = t0Var.q.get(0).g(this);
                        }
                        f2 = f6;
                        f6 = f5;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    v((SVG.i0) t0Var.c());
                    if (z) {
                        f fVar = (f) jVar;
                        fVar.f66024a = f6 + f4;
                        fVar.f66025b = f3 + f2;
                    }
                    boolean n0 = n0();
                    I(t0Var, jVar);
                    if (n0) {
                        k0(t0Var);
                    }
                }
                R0();
            } else if (l0Var instanceof SVG.s0) {
                S0();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                W0(this.f65998f, s0Var);
                if (E()) {
                    v((SVG.i0) s0Var.c());
                    SVG.l0 n = l0Var.f30369a.n(s0Var.n);
                    if (n == null || !(n instanceof SVG.w0)) {
                        J("Tref reference '%s' not found", s0Var.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        K((SVG.w0) n, sb);
                        if (sb.length() > 0) {
                            jVar.b(sb.toString());
                        }
                    }
                }
                R0();
            }
        }
    }

    public final boolean n0() {
        if (M0()) {
            this.f65993a.saveLayerAlpha(null, z(this.f65998f.f66031e.q.floatValue()), 31);
            this.f65999g.push(this.f65998f);
            h hVar = (h) this.f65998f.clone();
            this.f65998f = hVar;
            String str = hVar.f66031e.K;
            if (str != null && hVar.m) {
                SVG.l0 n = this.f65997e.n(str);
                if (n != null && (n instanceof SVG.r)) {
                    this.j.push(this.f65993a);
                    H();
                } else {
                    J("Mask reference '%s' not found", this.f65998f.f66031e.K);
                    this.f65998f.f66031e.K = null;
                }
            }
            return true;
        }
        return false;
    }

    public final List<C1843c> o(SVG.p pVar) {
        SVG.o oVar = pVar.o;
        float f2 = oVar != null ? oVar.f(this) : 0.0f;
        SVG.o oVar2 = pVar.p;
        float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
        SVG.o oVar3 = pVar.q;
        float f3 = oVar3 != null ? oVar3.f(this) : 0.0f;
        SVG.o oVar4 = pVar.r;
        float g3 = oVar4 != null ? oVar4.g(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f4 = f3 - f2;
        float f5 = g3 - g2;
        arrayList.add(new C1843c(this, f2, g2, f4, f5));
        arrayList.add(new C1843c(this, f3, g3, f4, f5));
        return arrayList;
    }

    public final void o0(SVG.d dVar) {
        C("Circle render", new Object[0]);
        SVG.o oVar = dVar.q;
        if (oVar == null || oVar.i()) {
            return;
        }
        W0(this.f65998f, dVar);
        if (E() && Y0()) {
            Matrix matrix = dVar.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            Path c0 = c0(dVar);
            U0(dVar);
            v(dVar);
            t(dVar);
            boolean n0 = n0();
            if (this.f65998f.f66032f) {
                F(dVar, c0);
            }
            if (this.f65998f.f66033g) {
                G(c0);
            }
            if (n0) {
                k0(dVar);
            }
        }
    }

    public final List<C1843c> p(SVG.y yVar) {
        int length = yVar.o.length;
        int i2 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = yVar.o;
        C1843c c1843c = new C1843c(this, fArr[0], fArr[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < length) {
            float[] fArr2 = yVar.o;
            float f4 = fArr2[i2];
            float f5 = fArr2[i2 + 1];
            c1843c.a(f4, f5);
            arrayList.add(c1843c);
            i2 += 2;
            c1843c = new C1843c(this, f4, f5, f4 - c1843c.f66015a, f5 - c1843c.f66016b);
            f3 = f5;
            f2 = f4;
        }
        if (yVar instanceof SVG.z) {
            float[] fArr3 = yVar.o;
            if (f2 != fArr3[0] && f3 != fArr3[1]) {
                float f6 = fArr3[0];
                float f7 = fArr3[1];
                c1843c.a(f6, f7);
                arrayList.add(c1843c);
                C1843c c1843c2 = new C1843c(this, f6, f7, f6 - c1843c.f66015a, f7 - c1843c.f66016b);
                c1843c2.b((C1843c) arrayList.get(0));
                arrayList.add(c1843c2);
                arrayList.set(0, c1843c2);
            }
        } else {
            arrayList.add(c1843c);
        }
        return arrayList;
    }

    public final void p0(SVG.i iVar) {
        C("Ellipse render", new Object[0]);
        SVG.o oVar = iVar.q;
        if (oVar == null || iVar.r == null || oVar.i() || iVar.r.i()) {
            return;
        }
        W0(this.f65998f, iVar);
        if (E() && Y0()) {
            Matrix matrix = iVar.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            Path d0 = d0(iVar);
            U0(iVar);
            v(iVar);
            t(iVar);
            boolean n0 = n0();
            if (this.f65998f.f66032f) {
                F(iVar, d0);
            }
            if (this.f65998f.f66033g) {
                G(d0);
            }
            if (n0) {
                k0(iVar);
            }
        }
    }

    public final SVG.b q(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public final void q0(SVG.l lVar) {
        C("Group render", new Object[0]);
        W0(this.f65998f, lVar);
        if (E()) {
            Matrix matrix = lVar.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            t(lVar);
            boolean n0 = n0();
            F0(lVar, true);
            if (n0) {
                k0(lVar);
            }
            U0(lVar);
        }
    }

    public final float r(SVG.w0 w0Var) {
        k kVar = new k(this, null);
        I(w0Var, kVar);
        return kVar.f66040a;
    }

    public final void r0(SVG.n nVar) {
        SVG.o oVar;
        C("Image render", new Object[0]);
        SVG.o oVar2 = nVar.r;
        if (oVar2 == null || oVar2.i() || (oVar = nVar.s) == null || oVar.i() || nVar.o == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = nVar.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f30331d;
        }
        Bitmap w = w(nVar.o);
        if (w == null) {
            d.c.a.d e2 = this.f65997e.e();
            if (e2 == null) {
                return;
            }
            w = e2.c(nVar.o);
        }
        if (w == null) {
            J("Could not locate image '%s'", nVar.o);
            return;
        }
        W0(this.f65998f, nVar);
        if (E() && Y0()) {
            Matrix matrix = nVar.t;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            SVG.o oVar3 = nVar.p;
            float f2 = oVar3 != null ? oVar3.f(this) : 0.0f;
            SVG.o oVar4 = nVar.q;
            this.f65998f.j = new SVG.b(f2, oVar4 != null ? oVar4.g(this) : 0.0f, nVar.r.f(this), nVar.s.f(this));
            if (!this.f65998f.f66031e.z.booleanValue()) {
                SVG.b bVar = this.f65998f.j;
                O0(bVar.f30347e, bVar.f30348f, bVar.f30349g, bVar.f30350h);
            }
            SVG.b bVar2 = new SVG.b(0.0f, 0.0f, w.getWidth(), w.getHeight());
            nVar.f30361h = bVar2;
            this.f65993a.concat(s(this.f65998f.j, bVar2, preserveAspectRatio));
            U0(nVar);
            t(nVar);
            boolean n0 = n0();
            X0();
            this.f65993a.drawBitmap(w, 0.0f, 0.0f, new Paint());
            if (n0) {
                k0(nVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        if (r11 != 8) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix s(SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        int i2;
        float f2;
        float f3;
        Matrix matrix = new Matrix();
        if (preserveAspectRatio != null && preserveAspectRatio.a() != null) {
            float f4 = bVar.f30349g / bVar2.f30349g;
            float f5 = bVar.f30350h / bVar2.f30350h;
            float f6 = -bVar2.f30347e;
            float f7 = -bVar2.f30348f;
            if (preserveAspectRatio.equals(PreserveAspectRatio.f30330c)) {
                matrix.preTranslate(bVar.f30347e, bVar.f30348f);
                matrix.preScale(f4, f5);
                matrix.preTranslate(f6, f7);
                return matrix;
            }
            float max = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f4, f5) : Math.min(f4, f5);
            float f8 = bVar.f30349g / max;
            float f9 = bVar.f30350h / max;
            switch (a.f66002a[preserveAspectRatio.a().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    f3 = (bVar2.f30349g - f8) / 2.0f;
                    f6 -= f3;
                    i2 = a.f66002a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 != 7) {
                                        break;
                                    }
                                }
                            }
                        }
                        f2 = bVar2.f30350h - f9;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f30347e, bVar.f30348f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                    }
                    f2 = (bVar2.f30350h - f9) / 2.0f;
                    f7 -= f2;
                    matrix.preTranslate(bVar.f30347e, bVar.f30348f);
                    matrix.preScale(max, max);
                    matrix.preTranslate(f6, f7);
                case 4:
                case 5:
                case 6:
                    f3 = bVar2.f30349g - f8;
                    f6 -= f3;
                    i2 = a.f66002a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                    }
                    f2 = (bVar2.f30350h - f9) / 2.0f;
                    f7 -= f2;
                    matrix.preTranslate(bVar.f30347e, bVar.f30348f);
                    matrix.preScale(max, max);
                    matrix.preTranslate(f6, f7);
                    break;
                default:
                    i2 = a.f66002a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                    }
                    f2 = (bVar2.f30350h - f9) / 2.0f;
                    f7 -= f2;
                    matrix.preTranslate(bVar.f30347e, bVar.f30348f);
                    matrix.preScale(max, max);
                    matrix.preTranslate(f6, f7);
                    break;
            }
        }
        return matrix;
    }

    public final void s0(SVG.p pVar) {
        C("Line render", new Object[0]);
        W0(this.f65998f, pVar);
        if (E() && Y0() && this.f65998f.f66033g) {
            Matrix matrix = pVar.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            Path e0 = e0(pVar);
            U0(pVar);
            v(pVar);
            t(pVar);
            boolean n0 = n0();
            G(e0);
            I0(pVar);
            if (n0) {
                k0(pVar);
            }
        }
    }

    public final void t(SVG.i0 i0Var) {
        u(i0Var, i0Var.f30361h);
    }

    public final void t0(SVG.u uVar) {
        C("Path render", new Object[0]);
        if (uVar.o == null) {
            return;
        }
        W0(this.f65998f, uVar);
        if (E() && Y0()) {
            h hVar = this.f65998f;
            if (hVar.f66033g || hVar.f66032f) {
                Matrix matrix = uVar.n;
                if (matrix != null) {
                    this.f65993a.concat(matrix);
                }
                Path f2 = new d(this, uVar.o).f();
                if (uVar.f30361h == null) {
                    uVar.f30361h = q(f2);
                }
                U0(uVar);
                v(uVar);
                t(uVar);
                boolean n0 = n0();
                if (this.f65998f.f66032f) {
                    f2.setFillType(Y());
                    F(uVar, f2);
                }
                if (this.f65998f.f66033g) {
                    G(f2);
                }
                I0(uVar);
                if (n0) {
                    k0(uVar);
                }
            }
        }
    }

    public final void u(SVG.i0 i0Var, SVG.b bVar) {
        String str = this.f65998f.f66031e.I;
        if (str == null) {
            return;
        }
        SVG.l0 n = i0Var.f30369a.n(str);
        if (n == null) {
            J("ClipPath reference '%s' not found", this.f65998f.f66031e.I);
            return;
        }
        SVG.e eVar = (SVG.e) n;
        if (eVar.f30358i.isEmpty()) {
            this.f65993a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = eVar.o;
        boolean z = bool == null || bool.booleanValue();
        if ((i0Var instanceof SVG.l) && !z) {
            Z0("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.getClass().getSimpleName());
            return;
        }
        B();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.f30347e, bVar.f30348f);
            matrix.preScale(bVar.f30349g, bVar.f30350h);
            this.f65993a.concat(matrix);
        }
        Matrix matrix2 = eVar.n;
        if (matrix2 != null) {
            this.f65993a.concat(matrix2);
        }
        this.f65998f = Q(eVar);
        t(eVar);
        Path path = new Path();
        for (SVG.l0 l0Var : eVar.f30358i) {
            j(l0Var, true, path, new Matrix());
        }
        this.f65993a.clipPath(path);
        A();
    }

    public final void u0(SVG.y yVar) {
        C("PolyLine render", new Object[0]);
        W0(this.f65998f, yVar);
        if (E() && Y0()) {
            h hVar = this.f65998f;
            if (hVar.f66033g || hVar.f66032f) {
                Matrix matrix = yVar.n;
                if (matrix != null) {
                    this.f65993a.concat(matrix);
                }
                if (yVar.o.length < 2) {
                    return;
                }
                Path f0 = f0(yVar);
                U0(yVar);
                v(yVar);
                t(yVar);
                boolean n0 = n0();
                if (this.f65998f.f66032f) {
                    F(yVar, f0);
                }
                if (this.f65998f.f66033g) {
                    G(f0);
                }
                I0(yVar);
                if (n0) {
                    k0(yVar);
                }
            }
        }
    }

    public final void v(SVG.i0 i0Var) {
        SVG.m0 m0Var = this.f65998f.f66031e.f30340f;
        if (m0Var instanceof SVG.t) {
            D(true, i0Var.f30361h, (SVG.t) m0Var);
        }
        SVG.m0 m0Var2 = this.f65998f.f66031e.f30343i;
        if (m0Var2 instanceof SVG.t) {
            D(false, i0Var.f30361h, (SVG.t) m0Var2);
        }
    }

    public final void v0(SVG.z zVar) {
        C("Polygon render", new Object[0]);
        W0(this.f65998f, zVar);
        if (E() && Y0()) {
            h hVar = this.f65998f;
            if (hVar.f66033g || hVar.f66032f) {
                Matrix matrix = zVar.n;
                if (matrix != null) {
                    this.f65993a.concat(matrix);
                }
                if (zVar.o.length < 2) {
                    return;
                }
                Path f0 = f0(zVar);
                U0(zVar);
                v(zVar);
                t(zVar);
                boolean n0 = n0();
                if (this.f65998f.f66032f) {
                    F(zVar, f0);
                }
                if (this.f65998f.f66033g) {
                    G(f0);
                }
                I0(zVar);
                if (n0) {
                    k0(zVar);
                }
            }
        }
    }

    public final Bitmap w(String str) {
        int indexOf;
        if (str.startsWith(WebGLImageLoader.DATA_URL) && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && DataUrlLoader.BASE64_TAG.equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    public final void w0(SVG.a0 a0Var) {
        C("Rect render", new Object[0]);
        SVG.o oVar = a0Var.q;
        if (oVar == null || a0Var.r == null || oVar.i() || a0Var.r.i()) {
            return;
        }
        W0(this.f65998f, a0Var);
        if (E() && Y0()) {
            Matrix matrix = a0Var.n;
            if (matrix != null) {
                this.f65993a.concat(matrix);
            }
            Path g0 = g0(a0Var);
            U0(a0Var);
            v(a0Var);
            t(a0Var);
            boolean n0 = n0();
            if (this.f65998f.f66032f) {
                F(a0Var, g0);
            }
            if (this.f65998f.f66033g) {
                G(g0);
            }
            if (n0) {
                k0(a0Var);
            }
        }
    }

    public final Typeface x(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        int i2 = 1;
        boolean z = fontStyle == SVG.Style.FontStyle.Italic;
        if (num.intValue() <= 500) {
            i2 = z ? 2 : 0;
        } else if (z) {
            i2 = 3;
        }
        if (str.equals("serif")) {
            return Typeface.create(Typeface.SERIF, i2);
        }
        if (str.equals(TypefaceCompatApi28Impl.DEFAULT_FAMILY)) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i2);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (str.equals("fantasy")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        return null;
    }

    public final void x0(SVG.d0 d0Var) {
        y0(d0Var, d0Var.r, d0Var.s);
    }

    public final void y(SVG.l0 l0Var) {
        Boolean bool;
        if ((l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).f30365d) != null) {
            this.f65998f.l = bool.booleanValue();
        }
    }

    public final void y0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2) {
        z0(d0Var, oVar, oVar2, d0Var.o, d0Var.n);
    }

    public final int z(float f2) {
        int i2 = (int) (f2 * 256.0f);
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    public final void z0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2, SVG.b bVar, PreserveAspectRatio preserveAspectRatio) {
        float f2;
        C("Svg render", new Object[0]);
        if (oVar == null || !oVar.i()) {
            if (oVar2 == null || !oVar2.i()) {
                if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                    preserveAspectRatio = PreserveAspectRatio.f30331d;
                }
                W0(this.f65998f, d0Var);
                if (E()) {
                    if (d0Var.f30370b != null) {
                        SVG.o oVar3 = d0Var.p;
                        float f3 = oVar3 != null ? oVar3.f(this) : 0.0f;
                        SVG.o oVar4 = d0Var.q;
                        r1 = f3;
                        f2 = oVar4 != null ? oVar4.g(this) : 0.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.b W = W();
                    this.f65998f.j = new SVG.b(r1, f2, oVar != null ? oVar.f(this) : W.f30349g, oVar2 != null ? oVar2.g(this) : W.f30350h);
                    if (!this.f65998f.f66031e.z.booleanValue()) {
                        SVG.b bVar2 = this.f65998f.j;
                        O0(bVar2.f30347e, bVar2.f30348f, bVar2.f30349g, bVar2.f30350h);
                    }
                    u(d0Var, this.f65998f.j);
                    if (bVar != null) {
                        this.f65993a.concat(s(this.f65998f.j, bVar, preserveAspectRatio));
                        this.f65998f.k = d0Var.o;
                    } else {
                        this.f65993a.translate(r1, f2);
                    }
                    boolean n0 = n0();
                    X0();
                    F0(d0Var, true);
                    if (n0) {
                        k0(d0Var);
                    }
                    U0(d0Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends j {

        /* renamed from: a  reason: collision with root package name */
        public float f66040a;

        public k() {
            super(c.this, null);
            this.f66040a = 0.0f;
        }

        @Override // d.c.a.c.j
        public void b(String str) {
            this.f66040a += c.this.f65998f.f66034h.measureText(str);
        }

        public /* synthetic */ k(c cVar, a aVar) {
            this();
        }
    }
}
