package com.caverock.androidsvg;

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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes10.dex */
public class c {
    private static HashSet<String> lET = null;
    private Canvas lEJ;
    private SVG.a lEK;
    private float lEL;
    private boolean lEM;
    private g lEN;
    private Stack<g> lEO;
    private Stack<SVG.ag> lEP;
    private Stack<Matrix> lEQ;
    private Stack<Canvas> lER;
    private Stack<Bitmap> lES;
    private SVG lEz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class g implements Cloneable {
        public Paint jE = new Paint();
        public Paint jF;
        public SVG.Style lCi;
        public SVG.a lEE;
        public boolean lFf;
        public boolean lFg;
        public SVG.a lFh;
        public boolean lFi;
        public boolean lFj;

        public g() {
            this.jE.setFlags(385);
            this.jE.setStyle(Paint.Style.FILL);
            this.jE.setTypeface(Typeface.DEFAULT);
            this.jF = new Paint();
            this.jF.setFlags(385);
            this.jF.setStyle(Paint.Style.STROKE);
            this.jF.setTypeface(Typeface.DEFAULT);
            this.lCi = SVG.Style.dhj();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lCi = (SVG.Style) this.lCi.clone();
                gVar.jE = new Paint(this.jE);
                gVar.jF = new Paint(this.jF);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lEN = new g();
        this.lEO = new Stack<>();
        a(this.lEN, SVG.Style.dhj());
        this.lEN.lFh = this.lEK;
        this.lEN.lFi = false;
        this.lEN.lFj = this.lEM;
        this.lEO.push((g) this.lEN.clone());
        this.lER = new Stack<>();
        this.lES = new Stack<>();
        this.lEQ = new Stack<>();
        this.lEP = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lEJ = canvas;
        this.lEL = f2;
        this.lEK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dhq() {
        return this.lEL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dhr() {
        return this.lEN.jE.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dhs() {
        return this.lEN.jE.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a dht() {
        return this.lEN.lEE != null ? this.lEN.lEE : this.lEN.lFh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lEz = svg;
        this.lEM = z;
        SVG.ac dhb = svg.dhb();
        if (dhb == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) dhb);
        a(dhb, dhb.lDf, dhb.lDg, aVar != null ? aVar : dhb.lEE, preserveAspectRatio != null ? preserveAspectRatio : dhb.lEB);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            dhu();
            c(akVar);
            if (akVar instanceof SVG.ac) {
                b((SVG.ac) akVar);
            } else if (akVar instanceof SVG.ba) {
                a((SVG.ba) akVar);
            } else if (akVar instanceof SVG.ap) {
                a((SVG.ap) akVar);
            } else if (akVar instanceof SVG.k) {
                a((SVG.k) akVar);
            } else if (akVar instanceof SVG.m) {
                a((SVG.m) akVar);
            } else if (akVar instanceof SVG.t) {
                a((SVG.t) akVar);
            } else if (akVar instanceof SVG.z) {
                a((SVG.z) akVar);
            } else if (akVar instanceof SVG.c) {
                a((SVG.c) akVar);
            } else if (akVar instanceof SVG.h) {
                a((SVG.h) akVar);
            } else if (akVar instanceof SVG.o) {
                a((SVG.o) akVar);
            } else if (akVar instanceof SVG.y) {
                a((SVG.y) akVar);
            } else if (akVar instanceof SVG.x) {
                a((SVG.x) akVar);
            } else if (akVar instanceof SVG.at) {
                a((SVG.at) akVar);
            }
            dhv();
        }
    }

    private void a(SVG.ag agVar, boolean z) {
        if (z) {
            a(agVar);
        }
        for (SVG.ak akVar : agVar.getChildren()) {
            b(akVar);
        }
        if (z) {
            dhw();
        }
    }

    private void dhu() {
        this.lEJ.save();
        this.lEO.push(this.lEN);
        this.lEN = (g) this.lEN.clone();
    }

    private void dhv() {
        this.lEJ.restore();
        this.lEN = this.lEO.pop();
    }

    private void a(SVG.ag agVar) {
        this.lEP.push(agVar);
        this.lEQ.push(this.lEJ.getMatrix());
    }

    private void dhw() {
        this.lEP.pop();
        this.lEQ.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lCi.uU(aiVar.lEA == null);
        if (aiVar.lEx != null) {
            a(gVar, aiVar.lEx);
        }
        if (this.lEz.dhd()) {
            for (CSSParser.c cVar : this.lEz.dhc()) {
                if (CSSParser.a(cVar.lCh, aiVar)) {
                    a(gVar, cVar.lCi);
                }
            }
        }
        if (aiVar.lCi != null) {
            a(gVar, aiVar.lCi);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lEw != null) {
                this.lEN.lFi = aiVar.lEw.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lEN.lCi.lDG instanceof SVG.s) {
            SVG.ak ND = this.lEz.ND(((SVG.s) this.lEN.lCi.lDG).RC);
            if (ND instanceof SVG.w) {
                a(ahVar, path, (SVG.w) ND);
                return;
            }
        }
        this.lEJ.drawPath(path, this.lEN.jE);
    }

    private void a(Path path) {
        if (this.lEN.lCi.lEp == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lEJ.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lEJ.setMatrix(new Matrix());
            Shader shader = this.lEN.jF.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lEJ.drawPath(path2, this.lEN.jF);
            this.lEJ.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lEJ.drawPath(path, this.lEN.jF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private void b(SVG.ac acVar) {
        a(acVar, acVar.lDf, acVar.lDg);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lEE, acVar.lEB);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lEB != null ? acVar.lEB : PreserveAspectRatio.lCx;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lEN, acVar);
                if (dhD()) {
                    if (acVar.lEA != null) {
                        f2 = acVar.lDd != null ? acVar.lDd.a(this) : 0.0f;
                        if (acVar.lDe != null) {
                            f3 = acVar.lDe.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a dht = dht();
                    this.lEN.lFh = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : dht.width, nVar2 != null ? nVar2.b(this) : dht.height);
                    if (!this.lEN.lCi.lEa.booleanValue()) {
                        m(this.lEN.lFh.lCK, this.lEN.lFh.lCL, this.lEN.lFh.width, this.lEN.lFh.height);
                    }
                    a(acVar, this.lEN.lFh);
                    if (aVar != null) {
                        this.lEJ.concat(a(this.lEN.lFh, aVar, preserveAspectRatio2));
                        this.lEN.lEE = acVar.lEE;
                    } else {
                        this.lEJ.translate(f2, f3);
                    }
                    boolean dhx = dhx();
                    dhG();
                    a((SVG.ag) acVar, true);
                    if (dhx) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lEN, kVar);
        if (dhD()) {
            if (kVar.lDc != null) {
                this.lEJ.concat(kVar.lDc);
            }
            d((SVG.ah) kVar);
            boolean dhx = dhx();
            a((SVG.ag) kVar, true);
            if (dhx) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lEA != null && ahVar.lEv != null) {
            Matrix matrix = new Matrix();
            if (this.lEQ.peek().invert(matrix)) {
                float[] fArr = {ahVar.lEv.lCK, ahVar.lEv.lCL, ahVar.lEv.dhf(), ahVar.lEv.lCL, ahVar.lEv.dhf(), ahVar.lEv.dhg(), ahVar.lEv.lCK, ahVar.lEv.dhg()};
                matrix.preConcat(this.lEJ.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    if (fArr[i2 + 1] < rectF.top) {
                        rectF.top = fArr[i2 + 1];
                    }
                    if (fArr[i2 + 1] > rectF.bottom) {
                        rectF.bottom = fArr[i2 + 1];
                    }
                }
                SVG.ah ahVar2 = (SVG.ah) this.lEP.peek();
                if (ahVar2.lEv == null) {
                    ahVar2.lEv = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lEv.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean dhx() {
        if (dhy()) {
            this.lEJ.saveLayerAlpha(null, bi(this.lEN.lCi.lDR.floatValue()), 31);
            this.lEO.push(this.lEN);
            this.lEN = (g) this.lEN.clone();
            if (this.lEN.lCi.lEk != null && this.lEN.lFj) {
                SVG.ak ND = this.lEz.ND(this.lEN.lCi.lEk);
                if (ND == null || !(ND instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lEN.lCi.lEk);
                    this.lEN.lCi.lEk = null;
                    return true;
                }
                this.lER.push(this.lEJ);
                dhz();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lEN.lCi.lEk != null && this.lEN.lFj) {
            SVG.ak ND = this.lEz.ND(this.lEN.lCi.lEk);
            dhz();
            a((SVG.q) ND, ahVar);
            Bitmap dhA = dhA();
            this.lEJ = this.lER.pop();
            this.lEJ.save();
            this.lEJ.setMatrix(new Matrix());
            this.lEJ.drawBitmap(dhA, 0.0f, 0.0f, this.lEN.jE);
            dhA.recycle();
            this.lEJ.restore();
        }
        dhv();
    }

    private boolean dhy() {
        if (this.lEN.lCi.lEk != null && !this.lEN.lFj) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lEN.lCi.lDR.floatValue() < 1.0f || (this.lEN.lCi.lEk != null && this.lEN.lFj);
    }

    private void dhz() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lEJ.getWidth(), this.lEJ.getHeight(), Bitmap.Config.ARGB_8888);
            this.lES.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lEJ.getMatrix());
            this.lEJ = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap dhA() {
        Bitmap pop = this.lES.pop();
        Bitmap pop2 = this.lES.pop();
        int width = pop.getWidth();
        int height = pop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        for (int i2 = 0; i2 < height; i2++) {
            pop.getPixels(iArr, 0, width, 0, i2, width, 1);
            pop2.getPixels(iArr2, 0, width, 0, i2, width, 1);
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i3];
                int i5 = i4 & 255;
                int i6 = (i4 >> 8) & 255;
                int i7 = (i4 >> 16) & 255;
                int i8 = (i4 >> 24) & 255;
                if (i8 == 0) {
                    iArr2[i3] = 0;
                } else {
                    int i9 = i5 * 2362;
                    int i10 = iArr2[i3];
                    iArr2[i3] = (((((i8 * (i9 + ((i6 * 23442) + (i7 * 6963)))) / 8355840) * ((i10 >> 24) & 255)) / 255) << 24) | (i10 & 16777215);
                }
            }
            pop2.setPixels(iArr2, 0, width, 0, i2, width, 1);
        }
        pop.recycle();
        return pop2;
    }

    private void a(SVG.ap apVar) {
        debug("Switch render", new Object[0]);
        a(this.lEN, apVar);
        if (dhD()) {
            if (apVar.lDc != null) {
                this.lEJ.concat(apVar.lDc);
            }
            d((SVG.ah) apVar);
            boolean dhx = dhx();
            b(apVar);
            if (dhx) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> dhm;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d dhe = this.lEz.dhe();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.dhl() == null && ((dhm = adVar.dhm()) == null || (!dhm.isEmpty() && dhm.contains(language)))) {
                    Set<String> dhk = adVar.dhk();
                    if (dhk != null) {
                        if (lET == null) {
                            dhB();
                        }
                        if (!dhk.isEmpty() && lET.containsAll(dhk)) {
                        }
                    }
                    Set<String> dhn = adVar.dhn();
                    if (dhn != null) {
                        if (!dhn.isEmpty() && dhe != null) {
                            for (String str : dhn) {
                                if (!dhe.NJ(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> dho = adVar.dho();
                    if (dho != null) {
                        if (!dho.isEmpty() && dhe != null) {
                            for (String str2 : dho) {
                                if (dhe.w(str2, this.lEN.lCi.lDV.intValue(), String.valueOf(this.lEN.lCi.lDW)) == null) {
                                    break;
                                }
                            }
                        }
                    }
                    b(akVar);
                    return;
                }
            }
        }
    }

    private static synchronized void dhB() {
        synchronized (c.class) {
            lET = new HashSet<>();
            lET.add("Structure");
            lET.add("BasicStructure");
            lET.add("ConditionalProcessing");
            lET.add("Image");
            lET.add("Style");
            lET.add("ViewportAttribute");
            lET.add("Shape");
            lET.add("BasicText");
            lET.add("PaintAttribute");
            lET.add("BasicPaintAttribute");
            lET.add("OpacityAttribute");
            lET.add("BasicGraphicsAttribute");
            lET.add("Marker");
            lET.add("Gradient");
            lET.add("Pattern");
            lET.add("Clip");
            lET.add("BasicClip");
            lET.add("Mask");
            lET.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lDf == null || !baVar.lDf.isZero()) {
            if (baVar.lDg == null || !baVar.lDg.isZero()) {
                a(this.lEN, baVar);
                if (dhD()) {
                    SVG.ak ND = baVar.lEz.ND(baVar.RC);
                    if (ND == null) {
                        k("Use reference '%s' not found", baVar.RC);
                        return;
                    }
                    if (baVar.lDc != null) {
                        this.lEJ.concat(baVar.lDc);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lDd != null ? baVar.lDd.a(this) : 0.0f, baVar.lDe != null ? baVar.lDe.b(this) : 0.0f);
                    this.lEJ.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean dhx = dhx();
                    a((SVG.ag) baVar);
                    if (ND instanceof SVG.ac) {
                        dhu();
                        SVG.ac acVar = (SVG.ac) ND;
                        a(acVar, baVar.lDf != null ? baVar.lDf : acVar.lDf, baVar.lDg != null ? baVar.lDg : acVar.lDg);
                        dhv();
                    } else if (ND instanceof SVG.aq) {
                        SVG.n nVar = baVar.lDf != null ? baVar.lDf : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lDg != null ? baVar.lDg : new SVG.n(100.0f, SVG.Unit.percent);
                        dhu();
                        a((SVG.aq) ND, nVar, nVar2);
                        dhv();
                    } else {
                        b(ND);
                    }
                    dhw();
                    if (dhx) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lDv != null) {
            a(this.lEN, tVar);
            if (dhD() && dhE()) {
                if (this.lEN.lFg || this.lEN.lFf) {
                    if (tVar.lDc != null) {
                        this.lEJ.concat(tVar.lDc);
                    }
                    Path bF = new C0643c(tVar.lDv).bF();
                    if (tVar.lEv == null) {
                        tVar.lEv = b(bF);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean dhx = dhx();
                    if (this.lEN.lFf) {
                        bF.setFillType(dhF());
                        a(tVar, bF);
                    }
                    if (this.lEN.lFg) {
                        a(bF);
                    }
                    a((SVG.j) tVar);
                    if (dhx) {
                        b((SVG.ah) tVar);
                    }
                }
            }
        }
    }

    private SVG.a b(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.a(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void a(SVG.z zVar) {
        debug("Rect render", new Object[0]);
        if (zVar.lDf != null && zVar.lDg != null && !zVar.lDf.isZero() && !zVar.lDg.isZero()) {
            a(this.lEN, zVar);
            if (dhD() && dhE()) {
                if (zVar.lDc != null) {
                    this.lEJ.concat(zVar.lDc);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean dhx = dhx();
                if (this.lEN.lFf) {
                    a(zVar, b2);
                }
                if (this.lEN.lFg) {
                    a(b2);
                }
                if (dhx) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lCS != null && !cVar.lCS.isZero()) {
            a(this.lEN, cVar);
            if (dhD() && dhE()) {
                if (cVar.lDc != null) {
                    this.lEJ.concat(cVar.lDc);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean dhx = dhx();
                if (this.lEN.lFf) {
                    a(cVar, b2);
                }
                if (this.lEN.lFg) {
                    a(b2);
                }
                if (dhx) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lCX != null && hVar.lCY != null && !hVar.lCX.isZero() && !hVar.lCY.isZero()) {
            a(this.lEN, hVar);
            if (dhD() && dhE()) {
                if (hVar.lDc != null) {
                    this.lEJ.concat(hVar.lDc);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean dhx = dhx();
                if (this.lEN.lFf) {
                    a(hVar, b2);
                }
                if (this.lEN.lFg) {
                    a(b2);
                }
                if (dhx) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lEN, oVar);
        if (dhD() && dhE() && this.lEN.lFg) {
            if (oVar.lDc != null) {
                this.lEJ.concat(oVar.lDc);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean dhx = dhx();
            a(c);
            a((SVG.j) oVar);
            if (dhx) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lDi != null ? oVar.lDi.a(this) : 0.0f;
        float b2 = oVar.lDj != null ? oVar.lDj.b(this) : 0.0f;
        float a3 = oVar.lDk != null ? oVar.lDk.a(this) : 0.0f;
        float b3 = oVar.lDl != null ? oVar.lDl.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lEN, xVar);
        if (dhD() && dhE()) {
            if (this.lEN.lFg || this.lEN.lFf) {
                if (xVar.lDc != null) {
                    this.lEJ.concat(xVar.lDc);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean dhx = dhx();
                    if (this.lEN.lFf) {
                        a(xVar, c);
                    }
                    if (this.lEN.lFg) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (dhx) {
                        b((SVG.ah) xVar);
                    }
                }
            }
        }
    }

    private List<b> b(SVG.x xVar) {
        int i2 = 2;
        float f2 = 0.0f;
        int length = xVar.points.length;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float f3 = 0.0f;
        b bVar = new b(xVar.points[0], xVar.points[1], 0.0f, 0.0f);
        while (i2 < length) {
            f3 = xVar.points[i2];
            float f4 = xVar.points[i2 + 1];
            bVar.C(f3, f4);
            arrayList.add(bVar);
            i2 += 2;
            f2 = f4;
            bVar = new b(f3, f4, f3 - bVar.x, f4 - bVar.y);
        }
        if (xVar instanceof SVG.y) {
            if (f3 != xVar.points[0] && f2 != xVar.points[1]) {
                float f5 = xVar.points[0];
                float f6 = xVar.points[1];
                bVar.C(f5, f6);
                arrayList.add(bVar);
                b bVar2 = new b(f5, f6, f5 - bVar.x, f6 - bVar.y);
                bVar2.a((b) arrayList.get(0));
                arrayList.add(bVar2);
                arrayList.set(0, bVar2);
            }
        } else {
            arrayList.add(bVar);
        }
        return arrayList;
    }

    private void a(SVG.y yVar) {
        debug("Polygon render", new Object[0]);
        a(this.lEN, yVar);
        if (dhD() && dhE()) {
            if (this.lEN.lFg || this.lEN.lFf) {
                if (yVar.lDc != null) {
                    this.lEJ.concat(yVar.lDc);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean dhx = dhx();
                    if (this.lEN.lFf) {
                        a(yVar, c);
                    }
                    if (this.lEN.lFg) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (dhx) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lEN, atVar);
        if (dhD()) {
            if (atVar.lDc != null) {
                this.lEJ.concat(atVar.lDc);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lEH == null || atVar.lEH.size() == 0) ? 0.0f : atVar.lEH.get(0).a(this);
            if (atVar.lEI != null && atVar.lEI.size() != 0) {
                f2 = atVar.lEI.get(0).b(this);
            }
            SVG.Style.TextAnchor dhC = dhC();
            if (dhC != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (dhC == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lEv == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lEv = new SVG.a(hVar.lFk.left, hVar.lFk.top, hVar.lFk.width(), hVar.lFk.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean dhx = dhx();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (dhx) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor dhC() {
        if (this.lEN.lCi.lDY == SVG.Style.TextDirection.LTR || this.lEN.lCi.lDZ == SVG.Style.TextAnchor.Middle) {
            return this.lEN.lCi.lDZ;
        }
        return this.lEN.lCi.lDZ == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class e extends i {
        public float x;
        public float y;

        public e(float f, float f2) {
            super();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NH(String str) {
            c.debug("TextSequence render", new Object[0]);
            if (c.this.dhE()) {
                if (c.this.lEN.lFf) {
                    c.this.lEJ.drawText(str, this.x, this.y, c.this.lEN.jE);
                }
                if (c.this.lEN.lFg) {
                    c.this.lEJ.drawText(str, this.x, this.y, c.this.lEN.jF);
                }
            }
            this.x += c.this.lEN.jE.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public abstract class i {
        public abstract void NH(String str);

        private i() {
        }

        public boolean b(SVG.av avVar) {
            return true;
        }
    }

    private void a(SVG.av avVar, i iVar) {
        if (dhD()) {
            Iterator<SVG.ak> it = avVar.SW.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.ak next = it.next();
                if (next instanceof SVG.az) {
                    iVar.NH(n(((SVG.az) next).text, z, !it.hasNext()));
                } else {
                    a(next, iVar);
                }
                z = false;
            }
        }
    }

    private void a(SVG.ak akVar, i iVar) {
        float f2;
        float f3;
        float f4;
        float f5 = 0.0f;
        if (iVar.b((SVG.av) akVar)) {
            if (akVar instanceof SVG.aw) {
                dhu();
                a((SVG.aw) akVar);
                dhv();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                dhu();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lEN, asVar);
                if (dhD()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lEH == null || asVar.lEH.size() == 0) ? 0.0f : asVar.lEH.get(0).a(this);
                        if (asVar.lEI != null && asVar.lEI.size() != 0) {
                            f5 = asVar.lEI.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.dhp());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean dhx = dhx();
                    a((SVG.av) asVar, iVar);
                    if (dhx) {
                        b((SVG.ah) asVar);
                    }
                }
                dhv();
            } else if (akVar instanceof SVG.ar) {
                dhu();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lEN, arVar);
                if (dhD()) {
                    c((SVG.ah) arVar.dhp());
                    SVG.ak ND = akVar.lEz.ND(arVar.RC);
                    if (ND != null && (ND instanceof SVG.av)) {
                        StringBuilder sb = new StringBuilder();
                        a((SVG.av) ND, sb);
                        if (sb.length() > 0) {
                            iVar.NH(sb.toString());
                        }
                    } else {
                        k("Tref reference '%s' not found", arVar.RC);
                    }
                }
                dhv();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lEN, awVar);
        if (dhD() && dhE()) {
            SVG.ak ND = awVar.lEz.ND(awVar.RC);
            if (ND == null) {
                k("TextPath reference '%s' not found", awVar.RC);
                return;
            }
            SVG.t tVar = (SVG.t) ND;
            Path bF = new C0643c(tVar.lDv).bF();
            if (tVar.lDc != null) {
                bF.transform(tVar.lDc);
            }
            float a2 = awVar.lEG != null ? awVar.lEG.a(this, new PathMeasure(bF, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor dhC = dhC();
            if (dhC != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (dhC == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.dhp());
            boolean dhx = dhx();
            a((SVG.av) awVar, (i) new d(bF, f2, 0.0f));
            if (dhx) {
                b((SVG.ah) awVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class d extends e {
        private Path path;

        public d(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.c.e, com.caverock.androidsvg.c.i
        public void NH(String str) {
            if (c.this.dhE()) {
                if (c.this.lEN.lFf) {
                    c.this.lEJ.drawTextOnPath(str, this.path, this.x, this.y, c.this.lEN.jE);
                }
                if (c.this.lEN.lFg) {
                    c.this.lEJ.drawTextOnPath(str, this.path, this.x, this.y, c.this.lEN.jF);
                }
            }
            this.x += c.this.lEN.jE.measureText(str);
        }
    }

    private float a(SVG.av avVar) {
        j jVar = new j();
        a(avVar, (i) jVar);
        return jVar.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class j extends i {
        public float x;

        private j() {
            super();
            this.x = 0.0f;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NH(String str) {
            this.x += c.this.lEN.jE.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class h extends i {
        RectF lFk;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lFk = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak ND = avVar.lEz.ND(awVar.RC);
                if (ND == null) {
                    c.k("TextPath path reference '%s' not found", awVar.RC);
                    return false;
                }
                SVG.t tVar = (SVG.t) ND;
                Path bF = new C0643c(tVar.lDv).bF();
                if (tVar.lDc != null) {
                    bF.transform(tVar.lDc);
                }
                RectF rectF = new RectF();
                bF.computeBounds(rectF, true);
                this.lFk.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NH(String str) {
            if (c.this.dhE()) {
                Rect rect = new Rect();
                c.this.lEN.jE.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lFk.union(rectF);
            }
            this.x += c.this.lEN.jE.measureText(str);
        }
    }

    private void a(SVG.av avVar, StringBuilder sb) {
        Iterator<SVG.ak> it = avVar.SW.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.ak next = it.next();
            if (next instanceof SVG.av) {
                a((SVG.av) next, sb);
            } else if (next instanceof SVG.az) {
                sb.append(n(((SVG.az) next).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String n(String str, boolean z, boolean z2) {
        if (this.lEN.lFi) {
            return str.replaceAll("[\\n\\t]", HanziToPinyin.Token.SEPARATOR);
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", HanziToPinyin.Token.SEPARATOR);
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", HanziToPinyin.Token.SEPARATOR);
    }

    private void a(SVG.aq aqVar, SVG.n nVar, SVG.n nVar2) {
        debug("Symbol render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                PreserveAspectRatio preserveAspectRatio = aqVar.lEB != null ? aqVar.lEB : PreserveAspectRatio.lCx;
                a(this.lEN, aqVar);
                this.lEN.lFh = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lEN.lFh.width, nVar2 != null ? nVar2.a(this) : this.lEN.lFh.height);
                if (!this.lEN.lCi.lEa.booleanValue()) {
                    m(this.lEN.lFh.lCK, this.lEN.lFh.lCL, this.lEN.lFh.width, this.lEN.lFh.height);
                }
                if (aqVar.lEE != null) {
                    this.lEJ.concat(a(this.lEN.lFh, aqVar.lEE, preserveAspectRatio));
                    this.lEN.lEE = aqVar.lEE;
                }
                boolean dhx = dhx();
                a((SVG.ag) aqVar, true);
                if (dhx) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lDf != null && !mVar.lDf.isZero() && mVar.lDg != null && !mVar.lDg.isZero() && mVar.RC != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lEB != null ? mVar.lEB : PreserveAspectRatio.lCx;
            Bitmap NG = NG(mVar.RC);
            if (NG == null) {
                com.caverock.androidsvg.d dhe = this.lEz.dhe();
                if (dhe != null) {
                    bitmap = dhe.NI(mVar.RC);
                } else {
                    return;
                }
            } else {
                bitmap = NG;
            }
            if (bitmap == null) {
                k("Could not locate image '%s'", mVar.RC);
                return;
            }
            a(this.lEN, mVar);
            if (dhD() && dhE()) {
                if (mVar.lDc != null) {
                    this.lEJ.concat(mVar.lDc);
                }
                this.lEN.lFh = new SVG.a(mVar.lDd != null ? mVar.lDd.a(this) : 0.0f, mVar.lDe != null ? mVar.lDe.b(this) : 0.0f, mVar.lDf.a(this), mVar.lDg.a(this));
                if (!this.lEN.lCi.lEa.booleanValue()) {
                    m(this.lEN.lFh.lCK, this.lEN.lFh.lCL, this.lEN.lFh.width, this.lEN.lFh.height);
                }
                mVar.lEv = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lEJ.concat(a(this.lEN.lFh, mVar.lEv, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean dhx = dhx();
                dhG();
                this.lEJ.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (dhx) {
                    b((SVG.ah) mVar);
                }
            }
        }
    }

    private Bitmap NG(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    private boolean dhD() {
        if (this.lEN.lCi.lEf != null) {
            return this.lEN.lCi.lEf.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhE() {
        if (this.lEN.lCi.lEg != null) {
            return this.lEN.lCi.lEg.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.dgY() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lCK;
        float f5 = -aVar2.lCL;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lCw)) {
            matrix.preTranslate(aVar.lCK, aVar.lCL);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dgZ() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.dgY()) {
            case XMidYMin:
            case XMidYMid:
            case XMidYMax:
                f4 -= (aVar2.width - f6) / 2.0f;
                break;
            case XMaxYMin:
            case XMaxYMid:
            case XMaxYMax:
                f4 -= aVar2.width - f6;
                break;
        }
        switch (preserveAspectRatio.dgY()) {
            case XMidYMid:
            case XMaxYMid:
            case XMinYMid:
                f5 -= (aVar2.height - f7) / 2.0f;
                break;
            case XMidYMax:
            case XMaxYMax:
            case XMinYMax:
                f5 -= aVar2.height - f7;
                break;
        }
        matrix.preTranslate(aVar.lCK, aVar.lCL);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lDF & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lCi.lDS = style.lDS;
        }
        if (a(style, 2048L)) {
            gVar.lCi.lDR = style.lDR;
        }
        if (a(style, 1L)) {
            gVar.lCi.lDG = style.lDG;
            gVar.lFf = style.lDG != null;
        }
        if (a(style, 4L)) {
            gVar.lCi.lDI = style.lDI;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lCi.lDG);
        }
        if (a(style, 2L)) {
            gVar.lCi.lDH = style.lDH;
        }
        if (a(style, 8L)) {
            gVar.lCi.lDJ = style.lDJ;
            gVar.lFg = style.lDJ != null;
        }
        if (a(style, 16L)) {
            gVar.lCi.lDK = style.lDK;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lCi.lDJ);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lCi.lEp = style.lEp;
        }
        if (a(style, 32L)) {
            gVar.lCi.lDL = style.lDL;
            gVar.jF.setStrokeWidth(gVar.lCi.lDL.c(this));
        }
        if (a(style, 64L)) {
            gVar.lCi.lDM = style.lDM;
            switch (style.lDM) {
                case Butt:
                    gVar.jF.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.jF.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.jF.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (a(style, 128L)) {
            gVar.lCi.lDN = style.lDN;
            switch (style.lDN) {
                case Miter:
                    gVar.jF.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.jF.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.jF.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (a(style, 256L)) {
            gVar.lCi.lDO = style.lDO;
            gVar.jF.setStrokeMiter(style.lDO.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lCi.lDP = style.lDP;
        }
        if (a(style, 1024L)) {
            gVar.lCi.lDQ = style.lDQ;
        }
        if (a(style, 1536L)) {
            if (gVar.lCi.lDP == null) {
                gVar.jF.setPathEffect(null);
            } else {
                int length = gVar.lCi.lDP.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lCi.lDP[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jF.setPathEffect(null);
                } else {
                    float c = gVar.lCi.lDQ.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jF.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float dhr = dhr();
            gVar.lCi.lDU = style.lDU;
            gVar.jE.setTextSize(style.lDU.a(this, dhr));
            gVar.jF.setTextSize(style.lDU.a(this, dhr));
        }
        if (a(style, 8192L)) {
            gVar.lCi.lDT = style.lDT;
        }
        if (a(style, 32768L)) {
            if (style.lDV.intValue() == -1 && gVar.lCi.lDV.intValue() > 100) {
                gVar.lCi.lDV = Integer.valueOf(style2.lDV.intValue() - 100);
            } else if (style.lDV.intValue() == 1 && gVar.lCi.lDV.intValue() < 900) {
                SVG.Style style3 = gVar.lCi;
                style3.lDV = Integer.valueOf(style3.lDV.intValue() + 100);
            } else {
                gVar.lCi.lDV = style.lDV;
            }
        }
        if (a(style, 65536L)) {
            gVar.lCi.lDW = style.lDW;
        }
        if (a(style, 106496L)) {
            if (gVar.lCi.lDT == null || this.lEz == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d dhe = this.lEz.dhe();
                typeface = null;
                for (String str : gVar.lCi.lDT) {
                    Typeface a2 = a(str, gVar.lCi.lDV, gVar.lCi.lDW);
                    if (a2 != null || dhe == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = dhe.w(str, gVar.lCi.lDV.intValue(), String.valueOf(gVar.lCi.lDW));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lCi.lDV, gVar.lCi.lDW);
            }
            gVar.jE.setTypeface(typeface);
            gVar.jF.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lCi.lDX = style.lDX;
            gVar.jE.setStrikeThruText(style.lDX == SVG.Style.TextDecoration.LineThrough);
            gVar.jE.setUnderlineText(style.lDX == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jF.setStrikeThruText(style.lDX == SVG.Style.TextDecoration.LineThrough);
                gVar.jF.setUnderlineText(style.lDX == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lCi.lDY = style.lDY;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lCi.lDZ = style.lDZ;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lCi.lEa = style.lEa;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lCi.lEc = style.lEc;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lCi.lEd = style.lEd;
        }
        if (a(style, 8388608L)) {
            gVar.lCi.lEe = style.lEe;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lCi.lEf = style.lEf;
        }
        if (a(style, 33554432L)) {
            gVar.lCi.lEg = style.lEg;
        }
        if (a(style, 1048576L)) {
            gVar.lCi.lEb = style.lEb;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lCi.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lCi.lEj = style.lEj;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lCi.lEk = style.lEk;
        }
        if (a(style, 67108864L)) {
            gVar.lCi.lEh = style.lEh;
        }
        if (a(style, 134217728L)) {
            gVar.lCi.lEi = style.lEi;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lCi.lEn = style.lEn;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lCi.lEo = style.lEo;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lCi.lDI : gVar.lCi.lDK).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lCU;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lCi.lDS.lCU;
        } else {
            return;
        }
        int bi = i2 | (bi(floatValue) << 24);
        if (z) {
            gVar.jE.setColor(bi);
        } else {
            gVar.jF.setColor(bi);
        }
    }

    private Typeface a(String str, Integer num, SVG.Style.FontStyle fontStyle) {
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
        if (str.equals("sans-serif")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i2);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (!str.equals("fantasy")) {
            return null;
        }
        return Typeface.create(Typeface.SANS_SERIF, i2);
    }

    private int bi(float f2) {
        int i2 = (int) (256.0f * f2);
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 255) {
            return i2;
        }
        return 255;
    }

    private Path.FillType dhF() {
        if (this.lEN.lCi.lDH == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lEN.lCi.lDH) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lEN.lCi.lEb != null) {
            f2 += this.lEN.lCi.lEb.lCP.a(this);
            f3 += this.lEN.lCi.lEb.lCM.b(this);
            f6 -= this.lEN.lCi.lEb.lCN.a(this);
            f7 -= this.lEN.lCi.lEb.lCO.b(this);
        }
        this.lEJ.clipRect(f2, f3, f6, f7);
    }

    private void dhG() {
        int i2;
        if (this.lEN.lCi.lEn instanceof SVG.e) {
            i2 = ((SVG.e) this.lEN.lCi.lEn).lCU;
        } else if (this.lEN.lCi.lEn instanceof SVG.f) {
            i2 = this.lEN.lCi.lDS.lCU;
        } else {
            return;
        }
        if (this.lEN.lCi.lEo != null) {
            i2 |= bi(this.lEN.lCi.lEo.floatValue()) << 24;
        }
        this.lEJ.drawColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.caverock.androidsvg.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0643c implements SVG.v {
        float lastX;
        float lastY;
        Path path = new Path();

        public C0643c(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
            }
        }

        public Path bF() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            c.a(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.v vVar) {
        double d2;
        float f9;
        float f10;
        double d3;
        if (f2 != f7 || f3 != f8) {
            if (f4 == 0.0f || f5 == 0.0f) {
                vVar.B(f7, f8);
                return;
            }
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            float radians = (float) Math.toRadians(f6 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (f2 - f7) / 2.0d;
            double d5 = (f3 - f8) / 2.0d;
            double d6 = (cos * d4) + (sin * d5);
            double d7 = (d4 * (-sin)) + (d5 * cos);
            double d8 = abs * abs;
            double d9 = abs2 * abs2;
            double d10 = d6 * d6;
            double d11 = d7 * d7;
            double d12 = (d10 / d8) + (d11 / d9);
            if (d12 > 1.0d) {
                float sqrt = abs * ((float) Math.sqrt(d12));
                float sqrt2 = abs2 * ((float) Math.sqrt(d12));
                d2 = sqrt * sqrt;
                f9 = sqrt2;
                f10 = sqrt;
                d3 = sqrt2 * sqrt2;
            } else {
                d2 = d8;
                f9 = abs2;
                f10 = abs;
                d3 = d9;
            }
            double d13 = z == z2 ? -1.0d : 1.0d;
            double d14 = (((d2 * d3) - (d2 * d11)) - (d3 * d10)) / ((d3 * d10) + (d2 * d11));
            if (d14 < 0.0d) {
                d14 = 0.0d;
            }
            double sqrt3 = Math.sqrt(d14) * d13;
            double d15 = ((f10 * d7) / f9) * sqrt3;
            double d16 = sqrt3 * (-((f9 * d6) / f10));
            double d17 = ((f2 + f7) / 2.0d) + ((cos * d15) - (sin * d16));
            double d18 = ((f3 + f8) / 2.0d) + (cos * d16) + (sin * d15);
            double d19 = (d6 - d15) / f10;
            double d20 = (d7 - d16) / f9;
            double d21 = ((-d6) - d15) / f10;
            double d22 = ((-d7) - d16) / f9;
            double degrees = Math.toDegrees((d20 < 0.0d ? -1.0d : 1.0d) * Math.acos(d19 / Math.sqrt((d19 * d19) + (d20 * d20))));
            double degrees2 = Math.toDegrees(((d19 * d22) - (d21 * d20) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d20 * d22) + (d19 * d21)) / Math.sqrt(((d19 * d19) + (d20 * d20)) * ((d21 * d21) + (d22 * d22)))));
            if (!z2 && degrees2 > 0.0d) {
                degrees2 -= 360.0d;
            } else if (z2 && degrees2 < 0.0d) {
                degrees2 += 360.0d;
            }
            float[] d23 = d(degrees % 360.0d, degrees2 % 360.0d);
            Matrix matrix = new Matrix();
            matrix.postScale(f10, f9);
            matrix.postRotate(f6);
            matrix.postTranslate((float) d17, (float) d18);
            matrix.mapPoints(d23);
            d23[d23.length - 2] = f7;
            d23[d23.length - 1] = f8;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < d23.length) {
                    vVar.b(d23[i3], d23[i3 + 1], d23[i3 + 2], d23[i3 + 3], d23[i3 + 4], d23[i3 + 5]);
                    i2 = i3 + 6;
                } else {
                    return;
                }
            }
        }
    }

    private static float[] d(double d2, double d3) {
        int ceil = (int) Math.ceil(Math.abs(d3) / 90.0d);
        double radians = Math.toRadians(d2);
        float radians2 = (float) (Math.toRadians(d3) / ceil);
        double sin = (1.3333333333333333d * Math.sin(radians2 / 2.0d)) / (1.0d + Math.cos(radians2 / 2.0d));
        float[] fArr = new float[ceil * 6];
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            double d4 = (i3 * radians2) + radians;
            double cos = Math.cos(d4);
            double sin2 = Math.sin(d4);
            int i4 = i2 + 1;
            fArr[i2] = (float) (cos - (sin * sin2));
            int i5 = i4 + 1;
            fArr[i4] = (float) ((cos * sin) + sin2);
            double d5 = d4 + radians2;
            double cos2 = Math.cos(d5);
            double sin3 = Math.sin(d5);
            int i6 = i5 + 1;
            fArr[i5] = (float) ((sin * sin3) + cos2);
            int i7 = i6 + 1;
            fArr[i6] = (float) (sin3 - (sin * cos2));
            int i8 = i7 + 1;
            fArr[i7] = (float) cos2;
            i2 = i8 + 1;
            fArr[i8] = (float) sin3;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b {
        public float gpX;
        public float gpY;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.gpX = 0.0f;
            this.gpY = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gpX = (float) (f3 / sqrt);
                this.gpY = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gpX = ((float) (f3 / sqrt)) + this.gpX;
                this.gpY += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.gpX += bVar.gpX;
            this.gpY += bVar.gpY;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.gpX + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gpY + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements SVG.v {
        private List<b> bvD = new ArrayList();
        private b lEY = null;
        private boolean lEZ = false;
        private boolean lFa = true;
        private int lFb = -1;
        private boolean lFc;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lFc) {
                    this.lEY.a(this.bvD.get(this.lFb));
                    this.bvD.set(this.lFb, this.lEY);
                    this.lFc = false;
                }
                if (this.lEY != null) {
                    this.bvD.add(this.lEY);
                }
            }
        }

        public List<b> dhK() {
            return this.bvD;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lFc) {
                this.lEY.a(this.bvD.get(this.lFb));
                this.bvD.set(this.lFb, this.lEY);
                this.lFc = false;
            }
            if (this.lEY != null) {
                this.bvD.add(this.lEY);
            }
            this.startX = f;
            this.startY = f2;
            this.lEY = new b(f, f2, 0.0f, 0.0f);
            this.lFb = this.bvD.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lEY.C(f, f2);
            this.bvD.add(this.lEY);
            this.lEY = new b(f, f2, f - this.lEY.x, f2 - this.lEY.y);
            this.lFc = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lFa || this.lEZ) {
                this.lEY.C(f, f2);
                this.bvD.add(this.lEY);
                this.lEZ = false;
            }
            this.lEY = new b(f5, f6, f5 - f3, f6 - f4);
            this.lFc = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lEY.C(f, f2);
            this.bvD.add(this.lEY);
            this.lEY = new b(f3, f4, f3 - f, f4 - f2);
            this.lFc = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lEZ = true;
            this.lFa = false;
            c.a(this.lEY.x, this.lEY.y, f, f2, f3, z, z2, f4, f5, this);
            this.lFa = true;
            this.lFc = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bvD.add(this.lEY);
            B(this.startX, this.startY);
            this.lFc = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(SVG.j jVar) {
        SVG.p pVar;
        SVG.p pVar2;
        SVG.p pVar3;
        List<b> b2;
        int size;
        if (this.lEN.lCi.lEc != null || this.lEN.lCi.lEd != null || this.lEN.lCi.lEe != null) {
            if (this.lEN.lCi.lEc != null) {
                SVG.ak ND = jVar.lEz.ND(this.lEN.lCi.lEc);
                if (ND != null) {
                    pVar = (SVG.p) ND;
                    if (this.lEN.lCi.lEd != null) {
                        SVG.ak ND2 = jVar.lEz.ND(this.lEN.lCi.lEd);
                        if (ND2 != null) {
                            pVar2 = (SVG.p) ND2;
                            if (this.lEN.lCi.lEe != null) {
                                SVG.ak ND3 = jVar.lEz.ND(this.lEN.lCi.lEe);
                                if (ND3 != null) {
                                    pVar3 = (SVG.p) ND3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lDv).dhK();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lEN.lCi;
                                        SVG.Style style2 = this.lEN.lCi;
                                        this.lEN.lCi.lEe = null;
                                        style2.lEd = null;
                                        style.lEc = null;
                                        if (pVar != null) {
                                            a(pVar, b2.get(0));
                                        }
                                        if (pVar2 != null) {
                                            for (int i2 = 1; i2 < size - 1; i2++) {
                                                a(pVar2, b2.get(i2));
                                            }
                                        }
                                        if (pVar3 != null) {
                                            a(pVar3, b2.get(size - 1));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                k("Marker reference '%s' not found", this.lEN.lCi.lEe);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lEN.lCi.lEd);
                    }
                    pVar2 = null;
                    if (this.lEN.lCi.lEe != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lEN.lCi.lEc);
                }
            }
            pVar = null;
            if (this.lEN.lCi.lEd != null) {
            }
            pVar2 = null;
            if (this.lEN.lCi.lEe != null) {
            }
            pVar3 = null;
            if (!(jVar instanceof SVG.t)) {
            }
            if (b2 == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(SVG.p pVar, b bVar) {
        float f2;
        boolean dhx;
        float f3;
        float f4 = 0.0f;
        dhu();
        if (pVar.lDr != null) {
            if (Float.isNaN(pVar.lDr.floatValue())) {
                if (bVar.gpX != 0.0f || bVar.gpY != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.gpY, bVar.gpX));
                }
            } else {
                f2 = pVar.lDr.floatValue();
            }
            float bh = !pVar.lDm ? 1.0f : this.lEN.lCi.lDL.bh(this.lEL);
            this.lEN = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bh, bh);
            float a2 = pVar.lDn == null ? pVar.lDn.a(this) : 0.0f;
            float b2 = pVar.lDo == null ? pVar.lDo.b(this) : 0.0f;
            float a3 = pVar.lDp == null ? pVar.lDp.a(this) : 3.0f;
            float b3 = pVar.lDq != null ? pVar.lDq.b(this) : 3.0f;
            if (pVar.lEE == null) {
                float f5 = a3 / pVar.lEE.width;
                float f6 = b3 / pVar.lEE.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lEB != null ? pVar.lEB : PreserveAspectRatio.lCx;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lCw)) {
                    f6 = preserveAspectRatio.dgZ() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lEJ.concat(matrix);
                float f7 = pVar.lEE.width * f5;
                float f8 = pVar.lEE.height * f6;
                switch (preserveAspectRatio.dgY()) {
                    case XMidYMin:
                    case XMidYMid:
                    case XMidYMax:
                        f3 = 0.0f - ((a3 - f7) / 2.0f);
                        break;
                    case XMaxYMin:
                    case XMaxYMid:
                    case XMaxYMax:
                        f3 = 0.0f - (a3 - f7);
                        break;
                    default:
                        f3 = 0.0f;
                        break;
                }
                switch (preserveAspectRatio.dgY()) {
                    case XMidYMid:
                    case XMaxYMid:
                    case XMinYMid:
                        f4 = 0.0f - ((b3 - f8) / 2.0f);
                        break;
                    case XMidYMax:
                    case XMaxYMax:
                    case XMinYMax:
                        f4 = 0.0f - (b3 - f8);
                        break;
                }
                if (!this.lEN.lCi.lEa.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lEJ.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lEJ.concat(matrix);
                if (!this.lEN.lCi.lEa.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            dhx = dhx();
            a((SVG.ag) pVar, false);
            if (dhx) {
                b((SVG.ah) pVar);
            }
            dhv();
        }
        f2 = 0.0f;
        if (!pVar.lDm) {
        }
        this.lEN = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bh, bh);
        if (pVar.lDn == null) {
        }
        if (pVar.lDo == null) {
        }
        if (pVar.lDp == null) {
        }
        if (pVar.lDq != null) {
        }
        if (pVar.lEE == null) {
        }
        dhx = dhx();
        a((SVG.ag) pVar, false);
        if (dhx) {
        }
        dhv();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.dhj());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lEA == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lEA;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lEE = this.lEz.dhb().lEE;
        if (gVar.lEE == null) {
            gVar.lEE = this.lEK;
        }
        gVar.lFh = this.lEK;
        gVar.lFj = this.lEN.lFj;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lEN.lCi.lDG instanceof SVG.s) {
            a(true, ahVar.lEv, (SVG.s) this.lEN.lCi.lDG);
        }
        if (this.lEN.lCi.lDJ instanceof SVG.s) {
            a(false, ahVar.lEv, (SVG.s) this.lEN.lCi.lDJ);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak ND = this.lEz.ND(sVar.RC);
        if (ND == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.RC;
            k("%s reference '%s' not found", objArr);
            if (sVar.lDu != null) {
                a(this.lEN, z, sVar.lDu);
                return;
            } else if (z) {
                this.lEN.lFf = false;
                return;
            } else {
                this.lEN.lFg = false;
                return;
            }
        }
        if (ND instanceof SVG.aj) {
            a(z, aVar, (SVG.aj) ND);
        }
        if (ND instanceof SVG.an) {
            a(z, aVar, (SVG.an) ND);
        }
        if (ND instanceof SVG.aa) {
            a(z, (SVG.aa) ND);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.aj ajVar) {
        float a2;
        float f2;
        float f3;
        float f4;
        if (ajVar.RC != null) {
            a(ajVar, ajVar.RC);
        }
        boolean z2 = ajVar.lCZ != null && ajVar.lCZ.booleanValue();
        Paint paint = z ? this.lEN.jE : this.lEN.jF;
        if (z2) {
            SVG.a dht = dht();
            float a3 = ajVar.lDi != null ? ajVar.lDi.a(this) : 0.0f;
            float b2 = ajVar.lDj != null ? ajVar.lDj.b(this) : 0.0f;
            float a4 = ajVar.lDk != null ? ajVar.lDk.a(this) : dht.width;
            a2 = ajVar.lDl != null ? ajVar.lDl.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lDi != null ? ajVar.lDi.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lDj != null ? ajVar.lDj.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lDk != null ? ajVar.lDk.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lDl != null ? ajVar.lDl.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        dhu();
        this.lEN = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lCK, aVar.lCL);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lDa != null) {
            matrix.preConcat(ajVar.lDa);
        }
        int size = ajVar.SW.size();
        if (size == 0) {
            dhv();
            if (z) {
                this.lEN.lFf = false;
                return;
            } else {
                this.lEN.lFg = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = ajVar.SW.iterator();
        int i2 = 0;
        float f5 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lDE.floatValue() >= f5) {
                fArr[i2] = abVar.lDE.floatValue();
                f5 = abVar.lDE.floatValue();
            } else {
                fArr[i2] = f5;
            }
            dhu();
            a(this.lEN, abVar);
            SVG.e eVar = (SVG.e) this.lEN.lCi.lEh;
            if (eVar == null) {
                eVar = SVG.e.lCV;
            }
            iArr[i2] = eVar.lCU | (bi(this.lEN.lCi.lEi.floatValue()) << 24);
            dhv();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            dhv();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lDb != null) {
            if (ajVar.lDb == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lDb == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dhv();
        LinearGradient linearGradient = new LinearGradient(f4, f3, f2, a2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void a(boolean z, SVG.a aVar, SVG.an anVar) {
        float a2;
        float f2;
        float f3;
        if (anVar.RC != null) {
            a(anVar, anVar.RC);
        }
        boolean z2 = anVar.lCZ != null && anVar.lCZ.booleanValue();
        Paint paint = z ? this.lEN.jE : this.lEN.jF;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lCQ != null ? anVar.lCQ.a(this) : nVar.a(this);
            float b2 = anVar.lCR != null ? anVar.lCR.b(this) : nVar.b(this);
            a2 = anVar.lCS != null ? anVar.lCS.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lCQ != null ? anVar.lCQ.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lCR != null ? anVar.lCR.a(this, 1.0f) : 0.5f;
            a2 = anVar.lCS != null ? anVar.lCS.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        dhu();
        this.lEN = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lCK, aVar.lCL);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lDa != null) {
            matrix.preConcat(anVar.lDa);
        }
        int size = anVar.SW.size();
        if (size == 0) {
            dhv();
            if (z) {
                this.lEN.lFf = false;
                return;
            } else {
                this.lEN.lFg = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = anVar.SW.iterator();
        int i2 = 0;
        float f4 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lDE.floatValue() >= f4) {
                fArr[i2] = abVar.lDE.floatValue();
                f4 = abVar.lDE.floatValue();
            } else {
                fArr[i2] = f4;
            }
            dhu();
            a(this.lEN, abVar);
            SVG.e eVar = (SVG.e) this.lEN.lCi.lEh;
            if (eVar == null) {
                eVar = SVG.e.lCV;
            }
            iArr[i2] = eVar.lCU | (bi(this.lEN.lCi.lEi.floatValue()) << 24);
            dhv();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            dhv();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lDb != null) {
            if (anVar.lDb == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lDb == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dhv();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak ND = iVar.lEz.ND(str);
        if (ND == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(ND instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (ND == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) ND;
            if (iVar.lCZ == null) {
                iVar.lCZ = iVar2.lCZ;
            }
            if (iVar.lDa == null) {
                iVar.lDa = iVar2.lDa;
            }
            if (iVar.lDb == null) {
                iVar.lDb = iVar2.lDb;
            }
            if (iVar.SW.isEmpty()) {
                iVar.SW = iVar2.SW;
            }
            try {
                if (iVar instanceof SVG.aj) {
                    a((SVG.aj) iVar, (SVG.aj) ND);
                } else {
                    a((SVG.an) iVar, (SVG.an) ND);
                }
            } catch (ClassCastException e2) {
            }
            if (iVar2.RC != null) {
                a(iVar, iVar2.RC);
            }
        }
    }

    private void a(SVG.aj ajVar, SVG.aj ajVar2) {
        if (ajVar.lDi == null) {
            ajVar.lDi = ajVar2.lDi;
        }
        if (ajVar.lDj == null) {
            ajVar.lDj = ajVar2.lDj;
        }
        if (ajVar.lDk == null) {
            ajVar.lDk = ajVar2.lDk;
        }
        if (ajVar.lDl == null) {
            ajVar.lDl = ajVar2.lDl;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lCQ == null) {
            anVar.lCQ = anVar2.lCQ;
        }
        if (anVar.lCR == null) {
            anVar.lCR = anVar2.lCR;
        }
        if (anVar.lCS == null) {
            anVar.lCS = anVar2.lCS;
        }
        if (anVar.lEC == null) {
            anVar.lEC = anVar2.lEC;
        }
        if (anVar.lED == null) {
            anVar.lED = anVar2.lED;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lEx, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lEN.lCi.lDG = aaVar.lEx.lEl;
                this.lEN.lFf = aaVar.lEx.lEl != null;
            }
            if (a(aaVar.lEx, 4294967296L)) {
                this.lEN.lCi.lDI = aaVar.lEx.lEm;
            }
            if (a(aaVar.lEx, 6442450944L)) {
                a(this.lEN, z, this.lEN.lCi.lDG);
                return;
            }
            return;
        }
        if (a(aaVar.lEx, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lEN.lCi.lDJ = aaVar.lEx.lEl;
            this.lEN.lFg = aaVar.lEx.lEl != null;
        }
        if (a(aaVar.lEx, 4294967296L)) {
            this.lEN.lCi.lDK = aaVar.lEx.lEm;
        }
        if (a(aaVar.lEx, 6442450944L)) {
            a(this.lEN, z, this.lEN.lCi.lDJ);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lEv);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lEN.lCi.clipPath != null) {
            SVG.ak ND = ahVar.lEz.ND(this.lEN.lCi.clipPath);
            if (ND == null) {
                k("ClipPath reference '%s' not found", this.lEN.lCi.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) ND;
            if (dVar.SW.isEmpty()) {
                this.lEJ.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lCT == null || dVar.lCT.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            dhH();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lCK, aVar.lCL);
                matrix.preScale(aVar.width, aVar.height);
                this.lEJ.concat(matrix);
            }
            if (dVar.lDc != null) {
                this.lEJ.concat(dVar.lDc);
            }
            this.lEN = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.SW) {
                a(akVar, true, path, new Matrix());
            }
            this.lEJ.clipPath(path);
            dhI();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (dhD()) {
            dhH();
            if (akVar instanceof SVG.ba) {
                if (z) {
                    a((SVG.ba) akVar, path, matrix);
                } else {
                    k("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (akVar instanceof SVG.t) {
                a((SVG.t) akVar, path, matrix);
            } else if (akVar instanceof SVG.at) {
                a((SVG.at) akVar, path, matrix);
            } else if (akVar instanceof SVG.j) {
                a((SVG.j) akVar, path, matrix);
            } else {
                k("Invalid %s element found in clipPath definition", akVar.getClass().getSimpleName());
            }
            dhI();
        }
    }

    private void dhH() {
        this.lEJ.save();
        this.lEO.push(this.lEN);
        this.lEN = (g) this.lEN.clone();
    }

    private void dhI() {
        this.lEJ.restore();
        this.lEN = this.lEO.pop();
    }

    private Path.FillType dhJ() {
        if (this.lEN.lCi.lEj == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lEN.lCi.lEj) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lEN, tVar);
        if (dhD() && dhE()) {
            if (tVar.lDc != null) {
                matrix.preConcat(tVar.lDc);
            }
            Path bF = new C0643c(tVar.lDv).bF();
            if (tVar.lEv == null) {
                tVar.lEv = b(bF);
            }
            d((SVG.ah) tVar);
            path.setFillType(dhJ());
            path.addPath(bF, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lEN, jVar);
        if (dhD() && dhE()) {
            if (jVar.lDc != null) {
                matrix.preConcat(jVar.lDc);
            }
            if (jVar instanceof SVG.z) {
                c = b((SVG.z) jVar);
            } else if (jVar instanceof SVG.c) {
                c = b((SVG.c) jVar);
            } else if (jVar instanceof SVG.h) {
                c = b((SVG.h) jVar);
            } else if (jVar instanceof SVG.x) {
                c = c((SVG.x) jVar);
            } else {
                return;
            }
            d((SVG.ah) jVar);
            path.setFillType(c.getFillType());
            path.addPath(c, matrix);
        }
    }

    private void a(SVG.ba baVar, Path path, Matrix matrix) {
        a(this.lEN, baVar);
        if (dhD() && dhE()) {
            if (baVar.lDc != null) {
                matrix.preConcat(baVar.lDc);
            }
            SVG.ak ND = baVar.lEz.ND(baVar.RC);
            if (ND == null) {
                k("Use reference '%s' not found", baVar.RC);
                return;
            }
            d((SVG.ah) baVar);
            a(ND, false, path, matrix);
        }
    }

    private void a(SVG.at atVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        a(this.lEN, atVar);
        if (dhD()) {
            if (atVar.lDc != null) {
                matrix.preConcat(atVar.lDc);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lEH == null || atVar.lEH.size() == 0) ? 0.0f : atVar.lEH.get(0).a(this);
            if (atVar.lEI != null && atVar.lEI.size() != 0) {
                f2 = atVar.lEI.get(0).b(this);
            }
            if (this.lEN.lCi.lDZ != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lEN.lCi.lDZ == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lEv == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lEv = new SVG.a(hVar.lFk.left, hVar.lFk.top, hVar.lFk.width(), hVar.lFk.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(dhJ());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class f extends i {
        public Path lFe;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lFe = path;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                c.j("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NH(String str) {
            if (c.this.dhE()) {
                Path path = new Path();
                c.this.lEN.jE.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lFe.addPath(path);
            }
            this.x += c.this.lEN.jE.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lDi == null ? 0.0f : oVar.lDi.a(this);
        float b2 = oVar.lDj == null ? 0.0f : oVar.lDj.b(this);
        float a3 = oVar.lDk == null ? 0.0f : oVar.lDk.a(this);
        float b3 = oVar.lDl != null ? oVar.lDl.b(this) : 0.0f;
        if (oVar.lEv == null) {
            oVar.lEv = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lCX == null && zVar.lCY == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lCX == null) {
            b2 = zVar.lCY.b(this);
            a2 = b2;
        } else if (zVar.lCY == null) {
            b2 = zVar.lCX.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lCX.a(this);
            b2 = zVar.lCY.b(this);
        }
        float min = Math.min(a2, zVar.lDf.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lDg.b(this) / 2.0f);
        float a3 = zVar.lDd != null ? zVar.lDd.a(this) : 0.0f;
        float b3 = zVar.lDe != null ? zVar.lDe.b(this) : 0.0f;
        float a4 = zVar.lDf.a(this);
        float b4 = zVar.lDg.b(this);
        if (zVar.lEv == null) {
            zVar.lEv = new SVG.a(a3, b3, a4, b4);
        }
        float f2 = a3 + a4;
        float f3 = b3 + b4;
        Path path = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path.moveTo(a3, b3);
            path.lineTo(f2, b3);
            path.lineTo(f2, f3);
            path.lineTo(a3, f3);
            path.lineTo(a3, b3);
        } else {
            float f4 = min * 0.5522848f;
            float f5 = min2 * 0.5522848f;
            path.moveTo(a3, b3 + min2);
            path.cubicTo(a3, (b3 + min2) - f5, (a3 + min) - f4, b3, a3 + min, b3);
            path.lineTo(f2 - min, b3);
            path.cubicTo((f2 - min) + f4, b3, f2, (b3 + min2) - f5, f2, b3 + min2);
            path.lineTo(f2, f3 - min2);
            path.cubicTo(f2, (f3 - min2) + f5, (f2 - min) + f4, f3, f2 - min, f3);
            path.lineTo(a3 + min, f3);
            path.cubicTo((a3 + min) - f4, f3, a3, (f3 - min2) + f5, a3, f3 - min2);
            path.lineTo(a3, b3 + min2);
        }
        path.close();
        return path;
    }

    private Path b(SVG.c cVar) {
        float a2 = cVar.lCQ != null ? cVar.lCQ.a(this) : 0.0f;
        float b2 = cVar.lCR != null ? cVar.lCR.b(this) : 0.0f;
        float c = cVar.lCS.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lEv == null) {
            cVar.lEv = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
        }
        float f6 = c * 0.5522848f;
        Path path = new Path();
        path.moveTo(a2, f3);
        path.cubicTo(a2 + f6, f3, f4, b2 - f6, f4, b2);
        path.cubicTo(f4, b2 + f6, a2 + f6, f5, a2, f5);
        path.cubicTo(a2 - f6, f5, f2, b2 + f6, f2, b2);
        path.cubicTo(f2, b2 - f6, a2 - f6, f3, a2, f3);
        path.close();
        return path;
    }

    private Path b(SVG.h hVar) {
        float a2 = hVar.lCQ != null ? hVar.lCQ.a(this) : 0.0f;
        float b2 = hVar.lCR != null ? hVar.lCR.b(this) : 0.0f;
        float a3 = hVar.lCX.a(this);
        float b3 = hVar.lCY.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lEv == null) {
            hVar.lEv = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
        }
        float f6 = a3 * 0.5522848f;
        float f7 = b3 * 0.5522848f;
        Path path = new Path();
        path.moveTo(a2, f3);
        path.cubicTo(a2 + f6, f3, f4, b2 - f7, f4, b2);
        path.cubicTo(f4, b2 + f7, a2 + f6, f5, a2, f5);
        path.cubicTo(a2 - f6, f5, f2, b2 + f7, f2, b2);
        path.cubicTo(f2, b2 - f7, a2 - f6, f3, a2, f3);
        path.close();
        return path;
    }

    private Path c(SVG.x xVar) {
        Path path = new Path();
        path.moveTo(xVar.points[0], xVar.points[1]);
        for (int i2 = 2; i2 < xVar.points.length; i2 += 2) {
            path.lineTo(xVar.points[i2], xVar.points[i2 + 1]);
        }
        if (xVar instanceof SVG.y) {
            path.close();
        }
        if (xVar.lEv == null) {
            xVar.lEv = b(path);
        }
        path.setFillType(dhJ());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lDB != null && wVar.lDB.booleanValue();
        if (wVar.RC != null) {
            a(wVar, wVar.RC);
        }
        if (z) {
            float a2 = wVar.lDd != null ? wVar.lDd.a(this) : 0.0f;
            float b2 = wVar.lDe != null ? wVar.lDe.b(this) : 0.0f;
            float a3 = wVar.lDf != null ? wVar.lDf.a(this) : 0.0f;
            f2 = wVar.lDg != null ? wVar.lDg.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lDd != null ? wVar.lDd.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lDe != null ? wVar.lDe.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lDf != null ? wVar.lDf.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lDg != null ? wVar.lDg.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lEv.width) + ahVar.lEv.lCK;
            float f7 = (a5 * ahVar.lEv.height) + ahVar.lEv.lCL;
            float f8 = a6 * ahVar.lEv.width;
            f2 = a7 * ahVar.lEv.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lEB != null ? wVar.lEB : PreserveAspectRatio.lCx;
            dhu();
            this.lEJ.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.dhj());
            gVar.lCi.lEa = false;
            this.lEN = a(wVar, gVar);
            SVG.a aVar = ahVar.lEv;
            if (wVar.lDD != null) {
                this.lEJ.concat(wVar.lDD);
                Matrix matrix = new Matrix();
                if (wVar.lDD.invert(matrix)) {
                    float[] fArr = {ahVar.lEv.lCK, ahVar.lEv.lCL, ahVar.lEv.dhf(), ahVar.lEv.lCL, ahVar.lEv.dhf(), ahVar.lEv.dhg(), ahVar.lEv.lCK, ahVar.lEv.dhg()};
                    matrix.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i2 = 2; i2 <= 6; i2 += 2) {
                        if (fArr[i2] < rectF.left) {
                            rectF.left = fArr[i2];
                        }
                        if (fArr[i2] > rectF.right) {
                            rectF.right = fArr[i2];
                        }
                        if (fArr[i2 + 1] < rectF.top) {
                            rectF.top = fArr[i2 + 1];
                        }
                        if (fArr[i2 + 1] > rectF.bottom) {
                            rectF.bottom = fArr[i2 + 1];
                        }
                    }
                    aVar = new SVG.a(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
                }
            }
            float floor = f5 + (((float) Math.floor((aVar.lCK - f5) / f3)) * f3);
            float dhf = aVar.dhf();
            float dhg = aVar.dhg();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lCL - f4) / f2)) * f2); floor2 < dhg; floor2 += f2) {
                for (float f9 = floor; f9 < dhf; f9 += f3) {
                    aVar2.lCK = f9;
                    aVar2.lCL = floor2;
                    dhu();
                    if (!this.lEN.lCi.lEa.booleanValue()) {
                        m(aVar2.lCK, aVar2.lCL, aVar2.width, aVar2.height);
                    }
                    if (wVar.lEE != null) {
                        this.lEJ.concat(a(aVar2, wVar.lEE, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lDC == null || wVar.lDC.booleanValue();
                        this.lEJ.translate(f9, floor2);
                        if (!z2) {
                            this.lEJ.scale(ahVar.lEv.width, ahVar.lEv.height);
                        }
                    }
                    boolean dhx = dhx();
                    for (SVG.ak akVar : wVar.SW) {
                        b(akVar);
                    }
                    if (dhx) {
                        b((SVG.ah) wVar);
                    }
                    dhv();
                }
            }
            dhv();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak ND = wVar.lEz.ND(str);
        if (ND == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(ND instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (ND == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) ND;
            if (wVar.lDB == null) {
                wVar.lDB = wVar2.lDB;
            }
            if (wVar.lDC == null) {
                wVar.lDC = wVar2.lDC;
            }
            if (wVar.lDD == null) {
                wVar.lDD = wVar2.lDD;
            }
            if (wVar.lDd == null) {
                wVar.lDd = wVar2.lDd;
            }
            if (wVar.lDe == null) {
                wVar.lDe = wVar2.lDe;
            }
            if (wVar.lDf == null) {
                wVar.lDf = wVar2.lDf;
            }
            if (wVar.lDg == null) {
                wVar.lDg = wVar2.lDg;
            }
            if (wVar.SW.isEmpty()) {
                wVar.SW = wVar2.SW;
            }
            if (wVar.lEE == null) {
                wVar.lEE = wVar2.lEE;
            }
            if (wVar.lEB == null) {
                wVar.lEB = wVar2.lEB;
            }
            if (wVar2.RC != null) {
                a(wVar, wVar2.RC);
            }
        }
    }

    private void a(SVG.q qVar, SVG.ah ahVar) {
        float f2;
        float f3;
        debug("Mask render", new Object[0]);
        if (qVar.lDs != null && qVar.lDs.booleanValue()) {
            f2 = qVar.lDf != null ? qVar.lDf.a(this) : ahVar.lEv.width;
            f3 = qVar.lDg != null ? qVar.lDg.b(this) : ahVar.lEv.height;
            if (qVar.lDd != null) {
                qVar.lDd.a(this);
            } else {
                float f4 = (float) (ahVar.lEv.lCK - (ahVar.lEv.width * 0.1d));
            }
            if (qVar.lDe != null) {
                qVar.lDe.b(this);
            } else {
                float f5 = (float) (ahVar.lEv.lCL - (ahVar.lEv.height * 0.1d));
            }
        } else {
            float a2 = qVar.lDd != null ? qVar.lDd.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lDe != null ? qVar.lDe.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lDf != null ? qVar.lDf.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lDg != null ? qVar.lDg.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lEv.width) + ahVar.lEv.lCK;
            float f7 = ahVar.lEv.lCL + (a3 * ahVar.lEv.height);
            f2 = ahVar.lEv.width * a4;
            f3 = ahVar.lEv.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            dhu();
            this.lEN = d((SVG.ak) qVar);
            this.lEN.lCi.lDR = Float.valueOf(1.0f);
            if (!(qVar.lDt == null || qVar.lDt.booleanValue())) {
                this.lEJ.translate(ahVar.lEv.lCK, ahVar.lEv.lCL);
                this.lEJ.scale(ahVar.lEv.width, ahVar.lEv.height);
            }
            a((SVG.ag) qVar, false);
            dhv();
        }
    }
}
