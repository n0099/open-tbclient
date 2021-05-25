package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.caverock.androidsvg.CSSParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xml.sax.SAXException;
/* loaded from: classes6.dex */
public class SVG {

    /* renamed from: a  reason: collision with root package name */
    public d0 f30334a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.c.a.d f30335b = null;

    /* renamed from: c  reason: collision with root package name */
    public float f30336c = 96.0f;

    /* renamed from: d  reason: collision with root package name */
    public CSSParser.e f30337d = new CSSParser.e();

    /* renamed from: e  reason: collision with root package name */
    public Map<String, j0> f30338e = new HashMap();

    /* loaded from: classes6.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* loaded from: classes6.dex */
    public static class Style implements Cloneable {
        public c A;
        public String B;
        public String C;
        public String D;
        public Boolean E;
        public Boolean F;
        public m0 G;
        public Float H;
        public String I;
        public FillRule J;
        public String K;
        public m0 L;
        public Float M;
        public m0 N;
        public Float O;
        public VectorEffect P;

        /* renamed from: e  reason: collision with root package name */
        public long f30339e = 0;

        /* renamed from: f  reason: collision with root package name */
        public m0 f30340f;

        /* renamed from: g  reason: collision with root package name */
        public FillRule f30341g;

        /* renamed from: h  reason: collision with root package name */
        public Float f30342h;

        /* renamed from: i  reason: collision with root package name */
        public m0 f30343i;
        public Float j;
        public o k;
        public LineCaps l;
        public LineJoin m;
        public Float n;
        public o[] o;
        public o p;
        public Float q;
        public f r;
        public List<String> s;
        public o t;
        public Integer u;
        public FontStyle v;
        public TextDecoration w;
        public TextDirection x;
        public TextAnchor y;
        public Boolean z;

        /* loaded from: classes6.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes6.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes6.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes6.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes6.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes6.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes6.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes6.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style b() {
            Style style = new Style();
            style.f30339e = -1L;
            style.f30340f = f.f30356f;
            style.f30341g = FillRule.NonZero;
            Float valueOf = Float.valueOf(1.0f);
            style.f30342h = valueOf;
            style.f30343i = null;
            style.j = valueOf;
            style.k = new o(1.0f);
            style.l = LineCaps.Butt;
            style.m = LineJoin.Miter;
            style.n = Float.valueOf(4.0f);
            style.o = null;
            style.p = new o(0.0f);
            style.q = valueOf;
            style.r = f.f30356f;
            style.s = null;
            style.t = new o(12.0f, Unit.pt);
            style.u = 400;
            style.v = FontStyle.Normal;
            style.w = TextDecoration.None;
            style.x = TextDirection.LTR;
            style.y = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.z = bool;
            style.A = null;
            style.B = null;
            style.C = null;
            style.D = null;
            style.E = bool;
            style.F = bool;
            style.G = f.f30356f;
            style.H = valueOf;
            style.I = null;
            style.J = FillRule.NonZero;
            style.K = null;
            style.L = null;
            style.M = valueOf;
            style.N = null;
            style.O = valueOf;
            style.P = VectorEffect.None;
            return style;
        }

        public void c(boolean z) {
            Boolean bool = Boolean.TRUE;
            this.E = bool;
            if (!z) {
                bool = Boolean.FALSE;
            }
            this.z = bool;
            this.A = null;
            this.I = null;
            this.q = Float.valueOf(1.0f);
            this.G = f.f30356f;
            this.H = Float.valueOf(1.0f);
            this.K = null;
            this.L = null;
            this.M = Float.valueOf(1.0f);
            this.N = null;
            this.O = Float.valueOf(1.0f);
            this.P = VectorEffect.None;
        }

        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.o != null) {
                    style.o = (o[]) this.o.clone();
                }
                return style;
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30344a;

        static {
            int[] iArr = new int[Unit.values().length];
            f30344a = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30344a[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30344a[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30344a[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30344a[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30344a[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30344a[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30344a[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30344a[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a0 extends k {
        public o o;
        public o p;
        public o q;
        public o r;
        public o s;
        public o t;
    }

    /* loaded from: classes6.dex */
    public static class a1 extends l0 implements v0 {

        /* renamed from: c  reason: collision with root package name */
        public String f30345c;

        /* renamed from: d  reason: collision with root package name */
        public z0 f30346d;

        public a1(String str) {
            this.f30345c = str;
        }

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.f30346d;
        }

        @Override // com.caverock.androidsvg.SVG.l0
        public String toString() {
            return a1.class.getSimpleName() + " '" + this.f30345c + "'";
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public float f30347e;

        /* renamed from: f  reason: collision with root package name */
        public float f30348f;

        /* renamed from: g  reason: collision with root package name */
        public float f30349g;

        /* renamed from: h  reason: collision with root package name */
        public float f30350h;

        public b(float f2, float f3, float f4, float f5) {
            this.f30347e = f2;
            this.f30348f = f3;
            this.f30349g = f4;
            this.f30350h = f5;
        }

        public static b a(float f2, float f3, float f4, float f5) {
            return new b(f2, f3, f4 - f2, f5 - f3);
        }

        public float b() {
            return this.f30347e + this.f30349g;
        }

        public float c() {
            return this.f30348f + this.f30350h;
        }

        public void d(b bVar) {
            float f2 = bVar.f30347e;
            if (f2 < this.f30347e) {
                this.f30347e = f2;
            }
            float f3 = bVar.f30348f;
            if (f3 < this.f30348f) {
                this.f30348f = f3;
            }
            if (bVar.b() > b()) {
                this.f30349g = bVar.b() - this.f30347e;
            }
            if (bVar.c() > c()) {
                this.f30350h = bVar.c() - this.f30348f;
            }
        }

        public String toString() {
            return "[" + this.f30347e + " " + this.f30348f + " " + this.f30349g + " " + this.f30350h + "]";
        }
    }

    /* loaded from: classes6.dex */
    public static class b0 extends j0 implements h0 {
        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
        }
    }

    /* loaded from: classes6.dex */
    public static class b1 extends l {
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public o f30351a;

        /* renamed from: b  reason: collision with root package name */
        public o f30352b;

        /* renamed from: c  reason: collision with root package name */
        public o f30353c;

        /* renamed from: d  reason: collision with root package name */
        public o f30354d;

        public c(o oVar, o oVar2, o oVar3, o oVar4) {
            this.f30351a = oVar;
            this.f30352b = oVar2;
            this.f30353c = oVar3;
            this.f30354d = oVar4;
        }
    }

    /* loaded from: classes6.dex */
    public static class c0 extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        public Float f30355h;

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
        }
    }

    /* loaded from: classes6.dex */
    public static class c1 extends p0 implements s {
    }

    /* loaded from: classes6.dex */
    public static class d extends k {
        public o o;
        public o p;
        public o q;
    }

    /* loaded from: classes6.dex */
    public static class d0 extends p0 {
        public o p;
        public o q;
        public o r;
        public o s;
        public String t;
    }

    /* loaded from: classes6.dex */
    public static class e extends l implements s {
        public Boolean o;
    }

    /* loaded from: classes6.dex */
    public interface e0 {
        String a();

        void b(Set<String> set);

        void d(Set<String> set);

        Set<String> e();

        Set<String> f();

        void g(Set<String> set);

        Set<String> h();

        void j(Set<String> set);

        void k(String str);

        Set<String> m();
    }

    /* loaded from: classes6.dex */
    public static class f extends m0 {

        /* renamed from: f  reason: collision with root package name */
        public static final f f30356f = new f(0);

        /* renamed from: e  reason: collision with root package name */
        public int f30357e;

        public f(int i2) {
            this.f30357e = i2;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.f30357e));
        }
    }

    /* loaded from: classes6.dex */
    public static class f0 extends i0 implements h0, e0 {

        /* renamed from: i  reason: collision with root package name */
        public List<l0> f30358i = new ArrayList();
        public Set<String> j = null;
        public String k = null;
        public Set<String> l = null;
        public Set<String> m = null;

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            this.j = set;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return this.f30358i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            this.f30358i.add(l0Var);
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void k(String str) {
            this.k = str;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            return this.m;
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends m0 {

        /* renamed from: e  reason: collision with root package name */
        public static g f30359e = new g();

        public static g b() {
            return f30359e;
        }
    }

    /* loaded from: classes6.dex */
    public static class g0 extends i0 implements e0 {

        /* renamed from: i  reason: collision with root package name */
        public Set<String> f30360i = null;
        public String j = null;
        public Set<String> k = null;
        public Set<String> l = null;
        public Set<String> m = null;

        @Override // com.caverock.androidsvg.SVG.e0
        public String a() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void b(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void d(Set<String> set) {
            this.k = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> e() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> f() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void g(Set<String> set) {
            this.f30360i = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> h() {
            return this.f30360i;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void j(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public void k(String str) {
            this.j = str;
        }

        @Override // com.caverock.androidsvg.SVG.e0
        public Set<String> m() {
            return this.m;
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends l implements s {
    }

    /* loaded from: classes6.dex */
    public interface h0 {
        List<l0> getChildren();

        void i(l0 l0Var) throws SAXException;
    }

    /* loaded from: classes6.dex */
    public static class i extends k {
        public o o;
        public o p;
        public o q;
        public o r;
    }

    /* loaded from: classes6.dex */
    public static class i0 extends j0 {

        /* renamed from: h  reason: collision with root package name */
        public b f30361h = null;
    }

    /* loaded from: classes6.dex */
    public static class j extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        public List<l0> f30362h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public Boolean f30363i;
        public Matrix j;
        public GradientSpread k;
        public String l;

        @Override // com.caverock.androidsvg.SVG.h0
        public List<l0> getChildren() {
            return this.f30362h;
        }

        @Override // com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            if (l0Var instanceof c0) {
                this.f30362h.add(l0Var);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + l0Var + " elements.");
        }
    }

    /* loaded from: classes6.dex */
    public static class j0 extends l0 {

        /* renamed from: c  reason: collision with root package name */
        public String f30364c = null;

        /* renamed from: d  reason: collision with root package name */
        public Boolean f30365d = null;

        /* renamed from: e  reason: collision with root package name */
        public Style f30366e = null;

        /* renamed from: f  reason: collision with root package name */
        public Style f30367f = null;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f30368g = null;
    }

    /* loaded from: classes6.dex */
    public static abstract class k extends g0 implements m {
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* loaded from: classes6.dex */
    public static class k0 extends j {
        public o m;
        public o n;
        public o o;
        public o p;
    }

    /* loaded from: classes6.dex */
    public static class l extends f0 implements m {
        public Matrix n;

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* loaded from: classes6.dex */
    public static class l0 {

        /* renamed from: a  reason: collision with root package name */
        public SVG f30369a;

        /* renamed from: b  reason: collision with root package name */
        public h0 f30370b;

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* loaded from: classes6.dex */
    public interface m {
        void l(Matrix matrix);
    }

    /* loaded from: classes6.dex */
    public static abstract class m0 implements Cloneable {
    }

    /* loaded from: classes6.dex */
    public static class n extends n0 implements m {
        public String o;
        public o p;
        public o q;
        public o r;
        public o s;
        public Matrix t;

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            this.t = matrix;
        }
    }

    /* loaded from: classes6.dex */
    public static class n0 extends f0 {
        public PreserveAspectRatio n = null;
    }

    /* loaded from: classes6.dex */
    public static class o0 extends j {
        public o m;
        public o n;
        public o o;
        public o p;
        public o q;
    }

    /* loaded from: classes6.dex */
    public static class p extends k {
        public o o;
        public o p;
        public o q;
        public o r;
    }

    /* loaded from: classes6.dex */
    public static class p0 extends n0 {
        public b o;
    }

    /* loaded from: classes6.dex */
    public static class q extends p0 implements s {
        public boolean p;
        public o q;
        public o r;
        public o s;
        public o t;
        public Float u;
    }

    /* loaded from: classes6.dex */
    public static class q0 extends l {
    }

    /* loaded from: classes6.dex */
    public static class r extends f0 implements s {
        public Boolean n;
        public Boolean o;
        public o p;
        public o q;
        public o r;
        public o s;
    }

    /* loaded from: classes6.dex */
    public static class r0 extends p0 implements s {
    }

    /* loaded from: classes6.dex */
    public interface s {
    }

    /* loaded from: classes6.dex */
    public static class s0 extends w0 implements v0 {
        public String n;
        public z0 o;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.o;
        }

        public void n(z0 z0Var) {
            this.o = z0Var;
        }
    }

    /* loaded from: classes6.dex */
    public static class t extends m0 {

        /* renamed from: e  reason: collision with root package name */
        public String f30373e;

        /* renamed from: f  reason: collision with root package name */
        public m0 f30374f;

        public t(String str, m0 m0Var) {
            this.f30373e = str;
            this.f30374f = m0Var;
        }

        public String toString() {
            return this.f30373e + " " + this.f30374f;
        }
    }

    /* loaded from: classes6.dex */
    public static class t0 extends y0 implements v0 {
        public z0 r;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.r;
        }

        public void n(z0 z0Var) {
            this.r = z0Var;
        }
    }

    /* loaded from: classes6.dex */
    public static class u extends k {
        public v o;
        public Float p;
    }

    /* loaded from: classes6.dex */
    public static class u0 extends y0 implements z0, m {
        public Matrix r;

        @Override // com.caverock.androidsvg.SVG.m
        public void l(Matrix matrix) {
            this.r = matrix;
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements w {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f30375a;

        /* renamed from: c  reason: collision with root package name */
        public float[] f30377c;

        /* renamed from: b  reason: collision with root package name */
        public int f30376b = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f30378d = 0;

        public v() {
            this.f30375a = null;
            this.f30377c = null;
            this.f30375a = new byte[8];
            this.f30377c = new float[16];
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            f((byte) 0);
            g(2);
            float[] fArr = this.f30377c;
            int i2 = this.f30378d;
            int i3 = i2 + 1;
            this.f30378d = i3;
            fArr[i2] = f2;
            this.f30378d = i3 + 1;
            fArr[i3] = f3;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            f((byte) 1);
            g(2);
            float[] fArr = this.f30377c;
            int i2 = this.f30378d;
            int i3 = i2 + 1;
            this.f30378d = i3;
            fArr[i2] = f2;
            this.f30378d = i3 + 1;
            fArr[i3] = f3;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            f((byte) 3);
            g(4);
            float[] fArr = this.f30377c;
            int i2 = this.f30378d;
            int i3 = i2 + 1;
            this.f30378d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.f30378d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.f30378d = i5;
            fArr[i4] = f4;
            this.f30378d = i5 + 1;
            fArr[i5] = f5;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            f((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            f((byte) 2);
            g(6);
            float[] fArr = this.f30377c;
            int i2 = this.f30378d;
            int i3 = i2 + 1;
            this.f30378d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.f30378d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.f30378d = i5;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            this.f30378d = i6;
            fArr[i5] = f5;
            int i7 = i6 + 1;
            this.f30378d = i7;
            fArr[i6] = f6;
            this.f30378d = i7 + 1;
            fArr[i7] = f7;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            f((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            g(5);
            float[] fArr = this.f30377c;
            int i2 = this.f30378d;
            int i3 = i2 + 1;
            this.f30378d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.f30378d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.f30378d = i5;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            this.f30378d = i6;
            fArr[i5] = f5;
            this.f30378d = i6 + 1;
            fArr[i6] = f6;
        }

        public final void f(byte b2) {
            int i2 = this.f30376b;
            byte[] bArr = this.f30375a;
            if (i2 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f30375a = bArr2;
            }
            byte[] bArr3 = this.f30375a;
            int i3 = this.f30376b;
            this.f30376b = i3 + 1;
            bArr3[i3] = b2;
        }

        public final void g(int i2) {
            float[] fArr = this.f30377c;
            if (fArr.length < this.f30378d + i2) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f30377c = fArr2;
            }
        }

        public void h(w wVar) {
            int i2;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f30376b; i4++) {
                byte b2 = this.f30375a[i4];
                if (b2 == 0) {
                    float[] fArr = this.f30377c;
                    int i5 = i3 + 1;
                    i2 = i5 + 1;
                    wVar.a(fArr[i3], fArr[i5]);
                } else if (b2 != 1) {
                    if (b2 == 2) {
                        float[] fArr2 = this.f30377c;
                        int i6 = i3 + 1;
                        float f2 = fArr2[i3];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        int i10 = i9 + 1;
                        float f6 = fArr2[i9];
                        i3 = i10 + 1;
                        wVar.d(f2, f3, f4, f5, f6, fArr2[i10]);
                    } else if (b2 == 3) {
                        float[] fArr3 = this.f30377c;
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        wVar.c(fArr3[i3], fArr3[i11], fArr3[i12], fArr3[i13]);
                        i3 = i13 + 1;
                    } else if (b2 != 8) {
                        boolean z = (b2 & 2) != 0;
                        boolean z2 = (b2 & 1) != 0;
                        float[] fArr4 = this.f30377c;
                        int i14 = i3 + 1;
                        float f7 = fArr4[i3];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        float f9 = fArr4[i15];
                        int i17 = i16 + 1;
                        wVar.e(f7, f8, f9, z, z2, fArr4[i16], fArr4[i17]);
                        i3 = i17 + 1;
                    } else {
                        wVar.close();
                    }
                } else {
                    float[] fArr5 = this.f30377c;
                    int i18 = i3 + 1;
                    i2 = i18 + 1;
                    wVar.b(fArr5[i3], fArr5[i18]);
                }
                i3 = i2;
            }
        }

        public boolean i() {
            return this.f30376b == 0;
        }
    }

    /* loaded from: classes6.dex */
    public interface v0 {
        z0 c();
    }

    /* loaded from: classes6.dex */
    public interface w {
        void a(float f2, float f3);

        void b(float f2, float f3);

        void c(float f2, float f3, float f4, float f5);

        void close();

        void d(float f2, float f3, float f4, float f5, float f6, float f7);

        void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6);
    }

    /* loaded from: classes6.dex */
    public static class w0 extends f0 {
        @Override // com.caverock.androidsvg.SVG.f0, com.caverock.androidsvg.SVG.h0
        public void i(l0 l0Var) throws SAXException {
            if (l0Var instanceof v0) {
                this.f30358i.add(l0Var);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + l0Var + " elements.");
        }
    }

    /* loaded from: classes6.dex */
    public static class x extends p0 implements s {
        public Boolean p;
        public Boolean q;
        public Matrix r;
        public o s;
        public o t;
        public o u;
        public o v;
        public String w;
    }

    /* loaded from: classes6.dex */
    public static class x0 extends w0 implements v0 {
        public String n;
        public o o;
        public z0 p;

        @Override // com.caverock.androidsvg.SVG.v0
        public z0 c() {
            return this.p;
        }

        public void n(z0 z0Var) {
            this.p = z0Var;
        }
    }

    /* loaded from: classes6.dex */
    public static class y extends k {
        public float[] o;
    }

    /* loaded from: classes6.dex */
    public static class y0 extends w0 {
        public List<o> n;
        public List<o> o;
        public List<o> p;
        public List<o> q;
    }

    /* loaded from: classes6.dex */
    public static class z extends y {
    }

    /* loaded from: classes6.dex */
    public interface z0 {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static SVG f(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        InputStream open = assetManager.open(str);
        try {
            return sVGParser.n(open);
        } finally {
            try {
                open.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG g(InputStream inputStream) throws SVGParseException {
        return new SVGParser().n(inputStream);
    }

    public static SVG h(Context context, int i2) throws SVGParseException {
        return i(context.getResources(), i2);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static SVG i(Resources resources, int i2) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            return sVGParser.n(openRawResource);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public void a(CSSParser.e eVar) {
        this.f30337d.b(eVar);
    }

    public List<CSSParser.d> b() {
        return this.f30337d.c();
    }

    public final j0 c(h0 h0Var, String str) {
        j0 c2;
        j0 j0Var = (j0) h0Var;
        if (str.equals(j0Var.f30364c)) {
            return j0Var;
        }
        for (l0 l0Var : h0Var.getChildren()) {
            if (l0Var instanceof j0) {
                j0 j0Var2 = (j0) l0Var;
                if (str.equals(j0Var2.f30364c)) {
                    return j0Var2;
                }
                if ((l0Var instanceof h0) && (c2 = c((h0) l0Var, str)) != null) {
                    return c2;
                }
            }
        }
        return null;
    }

    public l0 d(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f30334a.f30364c)) {
            return this.f30334a;
        }
        if (this.f30338e.containsKey(str)) {
            return this.f30338e.get(str);
        }
        j0 c2 = c(this.f30334a, str);
        this.f30338e.put(str, c2);
        return c2;
    }

    public d.c.a.d e() {
        return this.f30335b;
    }

    public d0 j() {
        return this.f30334a;
    }

    public boolean k() {
        return !this.f30337d.d();
    }

    public Picture l() {
        float c2;
        o oVar = this.f30334a.r;
        if (oVar != null) {
            float c3 = oVar.c(this.f30336c);
            d0 d0Var = this.f30334a;
            b bVar = d0Var.o;
            if (bVar != null) {
                c2 = (bVar.f30350h * c3) / bVar.f30349g;
            } else {
                o oVar2 = d0Var.s;
                c2 = oVar2 != null ? oVar2.c(this.f30336c) : c3;
            }
            return m((int) Math.ceil(c3), (int) Math.ceil(c2));
        }
        return m(512, 512);
    }

    public Picture m(int i2, int i3) {
        Picture picture = new Picture();
        new d.c.a.c(picture.beginRecording(i2, i3), new b(0.0f, 0.0f, i2, i3), this.f30336c).G0(this, null, null, false);
        picture.endRecording();
        return picture;
    }

    public l0 n(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return d(str.substring(1));
        }
        return null;
    }

    public void o(String str) {
    }

    public void p(d0 d0Var) {
        this.f30334a = d0Var;
    }

    public void q(String str) {
    }

    /* loaded from: classes6.dex */
    public static class o implements Cloneable {

        /* renamed from: e  reason: collision with root package name */
        public float f30371e;

        /* renamed from: f  reason: collision with root package name */
        public Unit f30372f;

        public o(float f2, Unit unit) {
            this.f30371e = 0.0f;
            this.f30372f = Unit.px;
            this.f30371e = f2;
            this.f30372f = unit;
        }

        public float b() {
            return this.f30371e;
        }

        public float c(float f2) {
            int i2 = a.f30344a[this.f30372f.ordinal()];
            if (i2 != 1) {
                switch (i2) {
                    case 4:
                        return this.f30371e * f2;
                    case 5:
                        return (this.f30371e * f2) / 2.54f;
                    case 6:
                        return (this.f30371e * f2) / 25.4f;
                    case 7:
                        return (this.f30371e * f2) / 72.0f;
                    case 8:
                        return (this.f30371e * f2) / 6.0f;
                    default:
                        return this.f30371e;
                }
            }
            return this.f30371e;
        }

        public float d(d.c.a.c cVar) {
            if (this.f30372f == Unit.percent) {
                b W = cVar.W();
                if (W == null) {
                    return this.f30371e;
                }
                float f2 = W.f30349g;
                float f3 = W.f30350h;
                if (f2 == f3) {
                    return (this.f30371e * f2) / 100.0f;
                }
                return (this.f30371e * ((float) (Math.sqrt((f2 * f2) + (f3 * f3)) / 1.414213562373095d))) / 100.0f;
            }
            return f(cVar);
        }

        public float e(d.c.a.c cVar, float f2) {
            if (this.f30372f == Unit.percent) {
                return (this.f30371e * f2) / 100.0f;
            }
            return f(cVar);
        }

        public float f(d.c.a.c cVar) {
            switch (a.f30344a[this.f30372f.ordinal()]) {
                case 1:
                    return this.f30371e;
                case 2:
                    return this.f30371e * cVar.U();
                case 3:
                    return this.f30371e * cVar.V();
                case 4:
                    return this.f30371e * cVar.X();
                case 5:
                    return (this.f30371e * cVar.X()) / 2.54f;
                case 6:
                    return (this.f30371e * cVar.X()) / 25.4f;
                case 7:
                    return (this.f30371e * cVar.X()) / 72.0f;
                case 8:
                    return (this.f30371e * cVar.X()) / 6.0f;
                case 9:
                    b W = cVar.W();
                    if (W == null) {
                        return this.f30371e;
                    }
                    return (this.f30371e * W.f30349g) / 100.0f;
                default:
                    return this.f30371e;
            }
        }

        public float g(d.c.a.c cVar) {
            if (this.f30372f == Unit.percent) {
                b W = cVar.W();
                if (W == null) {
                    return this.f30371e;
                }
                return (this.f30371e * W.f30350h) / 100.0f;
            }
            return f(cVar);
        }

        public boolean h() {
            return this.f30371e < 0.0f;
        }

        public boolean i() {
            return this.f30371e == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.f30371e) + this.f30372f;
        }

        public o(float f2) {
            this.f30371e = 0.0f;
            Unit unit = Unit.px;
            this.f30372f = unit;
            this.f30371e = f2;
            this.f30372f = unit;
        }
    }
}
