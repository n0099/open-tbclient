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
/* loaded from: classes12.dex */
public class c {
    private static HashSet<String> lFF = null;
    private Stack<g> lFA;
    private Stack<SVG.ag> lFB;
    private Stack<Matrix> lFC;
    private Stack<Canvas> lFD;
    private Stack<Bitmap> lFE;
    private SVG lFl;
    private Canvas lFv;
    private SVG.a lFw;
    private float lFx;
    private boolean lFy;
    private g lFz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class g implements Cloneable {
        public Paint jI = new Paint();
        public Paint jJ;
        public SVG.Style lCU;
        public boolean lFR;
        public boolean lFS;
        public SVG.a lFT;
        public boolean lFU;
        public boolean lFV;
        public SVG.a lFq;

        public g() {
            this.jI.setFlags(385);
            this.jI.setStyle(Paint.Style.FILL);
            this.jI.setTypeface(Typeface.DEFAULT);
            this.jJ = new Paint();
            this.jJ.setFlags(385);
            this.jJ.setStyle(Paint.Style.STROKE);
            this.jJ.setTypeface(Typeface.DEFAULT);
            this.lCU = SVG.Style.diz();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lCU = (SVG.Style) this.lCU.clone();
                gVar.jI = new Paint(this.jI);
                gVar.jJ = new Paint(this.jJ);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lFz = new g();
        this.lFA = new Stack<>();
        a(this.lFz, SVG.Style.diz());
        this.lFz.lFT = this.lFw;
        this.lFz.lFU = false;
        this.lFz.lFV = this.lFy;
        this.lFA.push((g) this.lFz.clone());
        this.lFD = new Stack<>();
        this.lFE = new Stack<>();
        this.lFC = new Stack<>();
        this.lFB = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lFv = canvas;
        this.lFx = f2;
        this.lFw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diG() {
        return this.lFx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diH() {
        return this.lFz.jI.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diI() {
        return this.lFz.jI.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a diJ() {
        return this.lFz.lFq != null ? this.lFz.lFq : this.lFz.lFT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lFl = svg;
        this.lFy = z;
        SVG.ac dir = svg.dir();
        if (dir == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) dir);
        a(dir, dir.lDR, dir.lDS, aVar != null ? aVar : dir.lFq, preserveAspectRatio != null ? preserveAspectRatio : dir.lFn);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            diK();
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
            diL();
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
            diM();
        }
    }

    private void diK() {
        this.lFv.save();
        this.lFA.push(this.lFz);
        this.lFz = (g) this.lFz.clone();
    }

    private void diL() {
        this.lFv.restore();
        this.lFz = this.lFA.pop();
    }

    private void a(SVG.ag agVar) {
        this.lFB.push(agVar);
        this.lFC.push(this.lFv.getMatrix());
    }

    private void diM() {
        this.lFB.pop();
        this.lFC.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lCU.uY(aiVar.lFm == null);
        if (aiVar.lFj != null) {
            a(gVar, aiVar.lFj);
        }
        if (this.lFl.dit()) {
            for (CSSParser.c cVar : this.lFl.dis()) {
                if (CSSParser.a(cVar.lCT, aiVar)) {
                    a(gVar, cVar.lCU);
                }
            }
        }
        if (aiVar.lCU != null) {
            a(gVar, aiVar.lCU);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lFi != null) {
                this.lFz.lFU = aiVar.lFi.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lFz.lCU.lEs instanceof SVG.s) {
            SVG.ak NP = this.lFl.NP(((SVG.s) this.lFz.lCU.lEs).Tl);
            if (NP instanceof SVG.w) {
                a(ahVar, path, (SVG.w) NP);
                return;
            }
        }
        this.lFv.drawPath(path, this.lFz.jI);
    }

    private void a(Path path) {
        if (this.lFz.lCU.lFb == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lFv.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lFv.setMatrix(new Matrix());
            Shader shader = this.lFz.jJ.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lFv.drawPath(path2, this.lFz.jJ);
            this.lFv.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lFv.drawPath(path, this.lFz.jJ);
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
        a(acVar, acVar.lDR, acVar.lDS);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lFq, acVar.lFn);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lFn != null ? acVar.lFn : PreserveAspectRatio.lDj;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lFz, acVar);
                if (diT()) {
                    if (acVar.lFm != null) {
                        f2 = acVar.lDP != null ? acVar.lDP.a(this) : 0.0f;
                        if (acVar.lDQ != null) {
                            f3 = acVar.lDQ.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a diJ = diJ();
                    this.lFz.lFT = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : diJ.width, nVar2 != null ? nVar2.b(this) : diJ.height);
                    if (!this.lFz.lCU.lEM.booleanValue()) {
                        m(this.lFz.lFT.lDw, this.lFz.lFT.lDx, this.lFz.lFT.width, this.lFz.lFT.height);
                    }
                    a(acVar, this.lFz.lFT);
                    if (aVar != null) {
                        this.lFv.concat(a(this.lFz.lFT, aVar, preserveAspectRatio2));
                        this.lFz.lFq = acVar.lFq;
                    } else {
                        this.lFv.translate(f2, f3);
                    }
                    boolean diN = diN();
                    diW();
                    a((SVG.ag) acVar, true);
                    if (diN) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lFz, kVar);
        if (diT()) {
            if (kVar.lDO != null) {
                this.lFv.concat(kVar.lDO);
            }
            d((SVG.ah) kVar);
            boolean diN = diN();
            a((SVG.ag) kVar, true);
            if (diN) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lFm != null && ahVar.lFh != null) {
            Matrix matrix = new Matrix();
            if (this.lFC.peek().invert(matrix)) {
                float[] fArr = {ahVar.lFh.lDw, ahVar.lFh.lDx, ahVar.lFh.div(), ahVar.lFh.lDx, ahVar.lFh.div(), ahVar.lFh.diw(), ahVar.lFh.lDw, ahVar.lFh.diw()};
                matrix.preConcat(this.lFv.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lFB.peek();
                if (ahVar2.lFh == null) {
                    ahVar2.lFh = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lFh.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean diN() {
        if (diO()) {
            this.lFv.saveLayerAlpha(null, bh(this.lFz.lCU.lED.floatValue()), 31);
            this.lFA.push(this.lFz);
            this.lFz = (g) this.lFz.clone();
            if (this.lFz.lCU.lEW != null && this.lFz.lFV) {
                SVG.ak NP = this.lFl.NP(this.lFz.lCU.lEW);
                if (NP == null || !(NP instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lFz.lCU.lEW);
                    this.lFz.lCU.lEW = null;
                    return true;
                }
                this.lFD.push(this.lFv);
                diP();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lFz.lCU.lEW != null && this.lFz.lFV) {
            SVG.ak NP = this.lFl.NP(this.lFz.lCU.lEW);
            diP();
            a((SVG.q) NP, ahVar);
            Bitmap diQ = diQ();
            this.lFv = this.lFD.pop();
            this.lFv.save();
            this.lFv.setMatrix(new Matrix());
            this.lFv.drawBitmap(diQ, 0.0f, 0.0f, this.lFz.jI);
            diQ.recycle();
            this.lFv.restore();
        }
        diL();
    }

    private boolean diO() {
        if (this.lFz.lCU.lEW != null && !this.lFz.lFV) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lFz.lCU.lED.floatValue() < 1.0f || (this.lFz.lCU.lEW != null && this.lFz.lFV);
    }

    private void diP() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lFv.getWidth(), this.lFv.getHeight(), Bitmap.Config.ARGB_8888);
            this.lFE.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lFv.getMatrix());
            this.lFv = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap diQ() {
        Bitmap pop = this.lFE.pop();
        Bitmap pop2 = this.lFE.pop();
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
        a(this.lFz, apVar);
        if (diT()) {
            if (apVar.lDO != null) {
                this.lFv.concat(apVar.lDO);
            }
            d((SVG.ah) apVar);
            boolean diN = diN();
            b(apVar);
            if (diN) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> diC;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d diu = this.lFl.diu();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.diB() == null && ((diC = adVar.diC()) == null || (!diC.isEmpty() && diC.contains(language)))) {
                    Set<String> diA = adVar.diA();
                    if (diA != null) {
                        if (lFF == null) {
                            diR();
                        }
                        if (!diA.isEmpty() && lFF.containsAll(diA)) {
                        }
                    }
                    Set<String> diD = adVar.diD();
                    if (diD != null) {
                        if (!diD.isEmpty() && diu != null) {
                            for (String str : diD) {
                                if (!diu.NV(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> diE = adVar.diE();
                    if (diE != null) {
                        if (!diE.isEmpty() && diu != null) {
                            for (String str2 : diE) {
                                if (diu.x(str2, this.lFz.lCU.lEH.intValue(), String.valueOf(this.lFz.lCU.lEI)) == null) {
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

    private static synchronized void diR() {
        synchronized (c.class) {
            lFF = new HashSet<>();
            lFF.add("Structure");
            lFF.add("BasicStructure");
            lFF.add("ConditionalProcessing");
            lFF.add("Image");
            lFF.add("Style");
            lFF.add("ViewportAttribute");
            lFF.add("Shape");
            lFF.add("BasicText");
            lFF.add("PaintAttribute");
            lFF.add("BasicPaintAttribute");
            lFF.add("OpacityAttribute");
            lFF.add("BasicGraphicsAttribute");
            lFF.add("Marker");
            lFF.add("Gradient");
            lFF.add("Pattern");
            lFF.add("Clip");
            lFF.add("BasicClip");
            lFF.add("Mask");
            lFF.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lDR == null || !baVar.lDR.isZero()) {
            if (baVar.lDS == null || !baVar.lDS.isZero()) {
                a(this.lFz, baVar);
                if (diT()) {
                    SVG.ak NP = baVar.lFl.NP(baVar.Tl);
                    if (NP == null) {
                        k("Use reference '%s' not found", baVar.Tl);
                        return;
                    }
                    if (baVar.lDO != null) {
                        this.lFv.concat(baVar.lDO);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lDP != null ? baVar.lDP.a(this) : 0.0f, baVar.lDQ != null ? baVar.lDQ.b(this) : 0.0f);
                    this.lFv.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean diN = diN();
                    a((SVG.ag) baVar);
                    if (NP instanceof SVG.ac) {
                        diK();
                        SVG.ac acVar = (SVG.ac) NP;
                        a(acVar, baVar.lDR != null ? baVar.lDR : acVar.lDR, baVar.lDS != null ? baVar.lDS : acVar.lDS);
                        diL();
                    } else if (NP instanceof SVG.aq) {
                        SVG.n nVar = baVar.lDR != null ? baVar.lDR : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lDS != null ? baVar.lDS : new SVG.n(100.0f, SVG.Unit.percent);
                        diK();
                        a((SVG.aq) NP, nVar, nVar2);
                        diL();
                    } else {
                        b(NP);
                    }
                    diM();
                    if (diN) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lEh != null) {
            a(this.lFz, tVar);
            if (diT() && diU()) {
                if (this.lFz.lFS || this.lFz.lFR) {
                    if (tVar.lDO != null) {
                        this.lFv.concat(tVar.lDO);
                    }
                    Path bG = new C0651c(tVar.lEh).bG();
                    if (tVar.lFh == null) {
                        tVar.lFh = b(bG);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean diN = diN();
                    if (this.lFz.lFR) {
                        bG.setFillType(diV());
                        a(tVar, bG);
                    }
                    if (this.lFz.lFS) {
                        a(bG);
                    }
                    a((SVG.j) tVar);
                    if (diN) {
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
        if (zVar.lDR != null && zVar.lDS != null && !zVar.lDR.isZero() && !zVar.lDS.isZero()) {
            a(this.lFz, zVar);
            if (diT() && diU()) {
                if (zVar.lDO != null) {
                    this.lFv.concat(zVar.lDO);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean diN = diN();
                if (this.lFz.lFR) {
                    a(zVar, b2);
                }
                if (this.lFz.lFS) {
                    a(b2);
                }
                if (diN) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lDE != null && !cVar.lDE.isZero()) {
            a(this.lFz, cVar);
            if (diT() && diU()) {
                if (cVar.lDO != null) {
                    this.lFv.concat(cVar.lDO);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean diN = diN();
                if (this.lFz.lFR) {
                    a(cVar, b2);
                }
                if (this.lFz.lFS) {
                    a(b2);
                }
                if (diN) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lDJ != null && hVar.lDK != null && !hVar.lDJ.isZero() && !hVar.lDK.isZero()) {
            a(this.lFz, hVar);
            if (diT() && diU()) {
                if (hVar.lDO != null) {
                    this.lFv.concat(hVar.lDO);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean diN = diN();
                if (this.lFz.lFR) {
                    a(hVar, b2);
                }
                if (this.lFz.lFS) {
                    a(b2);
                }
                if (diN) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lFz, oVar);
        if (diT() && diU() && this.lFz.lFS) {
            if (oVar.lDO != null) {
                this.lFv.concat(oVar.lDO);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean diN = diN();
            a(c);
            a((SVG.j) oVar);
            if (diN) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lDU != null ? oVar.lDU.a(this) : 0.0f;
        float b2 = oVar.lDV != null ? oVar.lDV.b(this) : 0.0f;
        float a3 = oVar.lDW != null ? oVar.lDW.a(this) : 0.0f;
        float b3 = oVar.lDX != null ? oVar.lDX.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lFz, xVar);
        if (diT() && diU()) {
            if (this.lFz.lFS || this.lFz.lFR) {
                if (xVar.lDO != null) {
                    this.lFv.concat(xVar.lDO);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean diN = diN();
                    if (this.lFz.lFR) {
                        a(xVar, c);
                    }
                    if (this.lFz.lFS) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (diN) {
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
        a(this.lFz, yVar);
        if (diT() && diU()) {
            if (this.lFz.lFS || this.lFz.lFR) {
                if (yVar.lDO != null) {
                    this.lFv.concat(yVar.lDO);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean diN = diN();
                    if (this.lFz.lFR) {
                        a(yVar, c);
                    }
                    if (this.lFz.lFS) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (diN) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lFz, atVar);
        if (diT()) {
            if (atVar.lDO != null) {
                this.lFv.concat(atVar.lDO);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFt == null || atVar.lFt.size() == 0) ? 0.0f : atVar.lFt.get(0).a(this);
            if (atVar.lFu != null && atVar.lFu.size() != 0) {
                f2 = atVar.lFu.get(0).b(this);
            }
            SVG.Style.TextAnchor diS = diS();
            if (diS != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (diS == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFh == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFh = new SVG.a(hVar.lFW.left, hVar.lFW.top, hVar.lFW.width(), hVar.lFW.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean diN = diN();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (diN) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor diS() {
        if (this.lFz.lCU.lEK == SVG.Style.TextDirection.LTR || this.lFz.lCU.lEL == SVG.Style.TextAnchor.Middle) {
            return this.lFz.lCU.lEL;
        }
        return this.lFz.lCU.lEL == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class e extends i {
        public float x;
        public float y;

        public e(float f, float f2) {
            super();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NT(String str) {
            c.debug("TextSequence render", new Object[0]);
            if (c.this.diU()) {
                if (c.this.lFz.lFR) {
                    c.this.lFv.drawText(str, this.x, this.y, c.this.lFz.jI);
                }
                if (c.this.lFz.lFS) {
                    c.this.lFv.drawText(str, this.x, this.y, c.this.lFz.jJ);
                }
            }
            this.x += c.this.lFz.jI.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public abstract class i {
        public abstract void NT(String str);

        private i() {
        }

        public boolean b(SVG.av avVar) {
            return true;
        }
    }

    private void a(SVG.av avVar, i iVar) {
        if (diT()) {
            Iterator<SVG.ak> it = avVar.UB.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.ak next = it.next();
                if (next instanceof SVG.az) {
                    iVar.NT(n(((SVG.az) next).text, z, !it.hasNext()));
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
                diK();
                a((SVG.aw) akVar);
                diL();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                diK();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lFz, asVar);
                if (diT()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lFt == null || asVar.lFt.size() == 0) ? 0.0f : asVar.lFt.get(0).a(this);
                        if (asVar.lFu != null && asVar.lFu.size() != 0) {
                            f5 = asVar.lFu.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.diF());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean diN = diN();
                    a((SVG.av) asVar, iVar);
                    if (diN) {
                        b((SVG.ah) asVar);
                    }
                }
                diL();
            } else if (akVar instanceof SVG.ar) {
                diK();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lFz, arVar);
                if (diT()) {
                    c((SVG.ah) arVar.diF());
                    SVG.ak NP = akVar.lFl.NP(arVar.Tl);
                    if (NP != null && (NP instanceof SVG.av)) {
                        StringBuilder sb = new StringBuilder();
                        a((SVG.av) NP, sb);
                        if (sb.length() > 0) {
                            iVar.NT(sb.toString());
                        }
                    } else {
                        k("Tref reference '%s' not found", arVar.Tl);
                    }
                }
                diL();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lFz, awVar);
        if (diT() && diU()) {
            SVG.ak NP = awVar.lFl.NP(awVar.Tl);
            if (NP == null) {
                k("TextPath reference '%s' not found", awVar.Tl);
                return;
            }
            SVG.t tVar = (SVG.t) NP;
            Path bG = new C0651c(tVar.lEh).bG();
            if (tVar.lDO != null) {
                bG.transform(tVar.lDO);
            }
            float a2 = awVar.lFs != null ? awVar.lFs.a(this, new PathMeasure(bG, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor diS = diS();
            if (diS != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (diS == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.diF());
            boolean diN = diN();
            a((SVG.av) awVar, (i) new d(bG, f2, 0.0f));
            if (diN) {
                b((SVG.ah) awVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class d extends e {
        private Path path;

        public d(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.c.e, com.caverock.androidsvg.c.i
        public void NT(String str) {
            if (c.this.diU()) {
                if (c.this.lFz.lFR) {
                    c.this.lFv.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFz.jI);
                }
                if (c.this.lFz.lFS) {
                    c.this.lFv.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFz.jJ);
                }
            }
            this.x += c.this.lFz.jI.measureText(str);
        }
    }

    private float a(SVG.av avVar) {
        j jVar = new j();
        a(avVar, (i) jVar);
        return jVar.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class j extends i {
        public float x;

        private j() {
            super();
            this.x = 0.0f;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NT(String str) {
            this.x += c.this.lFz.jI.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class h extends i {
        RectF lFW;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lFW = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak NP = avVar.lFl.NP(awVar.Tl);
                if (NP == null) {
                    c.k("TextPath path reference '%s' not found", awVar.Tl);
                    return false;
                }
                SVG.t tVar = (SVG.t) NP;
                Path bG = new C0651c(tVar.lEh).bG();
                if (tVar.lDO != null) {
                    bG.transform(tVar.lDO);
                }
                RectF rectF = new RectF();
                bG.computeBounds(rectF, true);
                this.lFW.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NT(String str) {
            if (c.this.diU()) {
                Rect rect = new Rect();
                c.this.lFz.jI.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lFW.union(rectF);
            }
            this.x += c.this.lFz.jI.measureText(str);
        }
    }

    private void a(SVG.av avVar, StringBuilder sb) {
        Iterator<SVG.ak> it = avVar.UB.iterator();
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
        if (this.lFz.lFU) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lFn != null ? aqVar.lFn : PreserveAspectRatio.lDj;
                a(this.lFz, aqVar);
                this.lFz.lFT = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lFz.lFT.width, nVar2 != null ? nVar2.a(this) : this.lFz.lFT.height);
                if (!this.lFz.lCU.lEM.booleanValue()) {
                    m(this.lFz.lFT.lDw, this.lFz.lFT.lDx, this.lFz.lFT.width, this.lFz.lFT.height);
                }
                if (aqVar.lFq != null) {
                    this.lFv.concat(a(this.lFz.lFT, aqVar.lFq, preserveAspectRatio));
                    this.lFz.lFq = aqVar.lFq;
                }
                boolean diN = diN();
                a((SVG.ag) aqVar, true);
                if (diN) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lDR != null && !mVar.lDR.isZero() && mVar.lDS != null && !mVar.lDS.isZero() && mVar.Tl != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lFn != null ? mVar.lFn : PreserveAspectRatio.lDj;
            Bitmap NS = NS(mVar.Tl);
            if (NS == null) {
                com.caverock.androidsvg.d diu = this.lFl.diu();
                if (diu != null) {
                    bitmap = diu.NU(mVar.Tl);
                } else {
                    return;
                }
            } else {
                bitmap = NS;
            }
            if (bitmap == null) {
                k("Could not locate image '%s'", mVar.Tl);
                return;
            }
            a(this.lFz, mVar);
            if (diT() && diU()) {
                if (mVar.lDO != null) {
                    this.lFv.concat(mVar.lDO);
                }
                this.lFz.lFT = new SVG.a(mVar.lDP != null ? mVar.lDP.a(this) : 0.0f, mVar.lDQ != null ? mVar.lDQ.b(this) : 0.0f, mVar.lDR.a(this), mVar.lDS.a(this));
                if (!this.lFz.lCU.lEM.booleanValue()) {
                    m(this.lFz.lFT.lDw, this.lFz.lFT.lDx, this.lFz.lFT.width, this.lFz.lFT.height);
                }
                mVar.lFh = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lFv.concat(a(this.lFz.lFT, mVar.lFh, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean diN = diN();
                diW();
                this.lFv.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (diN) {
                    b((SVG.ah) mVar);
                }
            }
        }
    }

    private Bitmap NS(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    private boolean diT() {
        if (this.lFz.lCU.lER != null) {
            return this.lFz.lCU.lER.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean diU() {
        if (this.lFz.lCU.lES != null) {
            return this.lFz.lCU.lES.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.dio() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lDw;
        float f5 = -aVar2.lDx;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lDi)) {
            matrix.preTranslate(aVar.lDw, aVar.lDx);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dip() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.dio()) {
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
        switch (preserveAspectRatio.dio()) {
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
        matrix.preTranslate(aVar.lDw, aVar.lDx);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lEr & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lCU.lEE = style.lEE;
        }
        if (a(style, 2048L)) {
            gVar.lCU.lED = style.lED;
        }
        if (a(style, 1L)) {
            gVar.lCU.lEs = style.lEs;
            gVar.lFR = style.lEs != null;
        }
        if (a(style, 4L)) {
            gVar.lCU.lEu = style.lEu;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lCU.lEs);
        }
        if (a(style, 2L)) {
            gVar.lCU.lEt = style.lEt;
        }
        if (a(style, 8L)) {
            gVar.lCU.lEv = style.lEv;
            gVar.lFS = style.lEv != null;
        }
        if (a(style, 16L)) {
            gVar.lCU.lEw = style.lEw;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lCU.lEv);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lCU.lFb = style.lFb;
        }
        if (a(style, 32L)) {
            gVar.lCU.lEx = style.lEx;
            gVar.jJ.setStrokeWidth(gVar.lCU.lEx.c(this));
        }
        if (a(style, 64L)) {
            gVar.lCU.lEy = style.lEy;
            switch (style.lEy) {
                case Butt:
                    gVar.jJ.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.jJ.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.jJ.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (a(style, 128L)) {
            gVar.lCU.lEz = style.lEz;
            switch (style.lEz) {
                case Miter:
                    gVar.jJ.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.jJ.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.jJ.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (a(style, 256L)) {
            gVar.lCU.lEA = style.lEA;
            gVar.jJ.setStrokeMiter(style.lEA.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lCU.lEB = style.lEB;
        }
        if (a(style, 1024L)) {
            gVar.lCU.lEC = style.lEC;
        }
        if (a(style, 1536L)) {
            if (gVar.lCU.lEB == null) {
                gVar.jJ.setPathEffect(null);
            } else {
                int length = gVar.lCU.lEB.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lCU.lEB[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jJ.setPathEffect(null);
                } else {
                    float c = gVar.lCU.lEC.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jJ.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float diH = diH();
            gVar.lCU.lEG = style.lEG;
            gVar.jI.setTextSize(style.lEG.a(this, diH));
            gVar.jJ.setTextSize(style.lEG.a(this, diH));
        }
        if (a(style, 8192L)) {
            gVar.lCU.lEF = style.lEF;
        }
        if (a(style, 32768L)) {
            if (style.lEH.intValue() == -1 && gVar.lCU.lEH.intValue() > 100) {
                gVar.lCU.lEH = Integer.valueOf(style2.lEH.intValue() - 100);
            } else if (style.lEH.intValue() == 1 && gVar.lCU.lEH.intValue() < 900) {
                SVG.Style style3 = gVar.lCU;
                style3.lEH = Integer.valueOf(style3.lEH.intValue() + 100);
            } else {
                gVar.lCU.lEH = style.lEH;
            }
        }
        if (a(style, 65536L)) {
            gVar.lCU.lEI = style.lEI;
        }
        if (a(style, 106496L)) {
            if (gVar.lCU.lEF == null || this.lFl == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d diu = this.lFl.diu();
                typeface = null;
                for (String str : gVar.lCU.lEF) {
                    Typeface a2 = a(str, gVar.lCU.lEH, gVar.lCU.lEI);
                    if (a2 != null || diu == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = diu.x(str, gVar.lCU.lEH.intValue(), String.valueOf(gVar.lCU.lEI));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lCU.lEH, gVar.lCU.lEI);
            }
            gVar.jI.setTypeface(typeface);
            gVar.jJ.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lCU.lEJ = style.lEJ;
            gVar.jI.setStrikeThruText(style.lEJ == SVG.Style.TextDecoration.LineThrough);
            gVar.jI.setUnderlineText(style.lEJ == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jJ.setStrikeThruText(style.lEJ == SVG.Style.TextDecoration.LineThrough);
                gVar.jJ.setUnderlineText(style.lEJ == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lCU.lEK = style.lEK;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lCU.lEL = style.lEL;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lCU.lEM = style.lEM;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lCU.lEO = style.lEO;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lCU.lEP = style.lEP;
        }
        if (a(style, 8388608L)) {
            gVar.lCU.lEQ = style.lEQ;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lCU.lER = style.lER;
        }
        if (a(style, 33554432L)) {
            gVar.lCU.lES = style.lES;
        }
        if (a(style, 1048576L)) {
            gVar.lCU.lEN = style.lEN;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lCU.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lCU.lEV = style.lEV;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lCU.lEW = style.lEW;
        }
        if (a(style, 67108864L)) {
            gVar.lCU.lET = style.lET;
        }
        if (a(style, 134217728L)) {
            gVar.lCU.lEU = style.lEU;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lCU.lEZ = style.lEZ;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lCU.lFa = style.lFa;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lCU.lEu : gVar.lCU.lEw).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lDG;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lCU.lEE.lDG;
        } else {
            return;
        }
        int bh = i2 | (bh(floatValue) << 24);
        if (z) {
            gVar.jI.setColor(bh);
        } else {
            gVar.jJ.setColor(bh);
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

    private int bh(float f2) {
        int i2 = (int) (256.0f * f2);
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 255) {
            return i2;
        }
        return 255;
    }

    private Path.FillType diV() {
        if (this.lFz.lCU.lEt == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFz.lCU.lEt) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lFz.lCU.lEN != null) {
            f2 += this.lFz.lCU.lEN.lDB.a(this);
            f3 += this.lFz.lCU.lEN.lDy.b(this);
            f6 -= this.lFz.lCU.lEN.lDz.a(this);
            f7 -= this.lFz.lCU.lEN.lDA.b(this);
        }
        this.lFv.clipRect(f2, f3, f6, f7);
    }

    private void diW() {
        int i2;
        if (this.lFz.lCU.lEZ instanceof SVG.e) {
            i2 = ((SVG.e) this.lFz.lCU.lEZ).lDG;
        } else if (this.lFz.lCU.lEZ instanceof SVG.f) {
            i2 = this.lFz.lCU.lEE.lDG;
        } else {
            return;
        }
        if (this.lFz.lCU.lFa != null) {
            i2 |= bh(this.lFz.lCU.lFa.floatValue()) << 24;
        }
        this.lFv.drawColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.caverock.androidsvg.c$c  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0651c implements SVG.v {
        float lastX;
        float lastY;
        Path path = new Path();

        public C0651c(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
            }
        }

        public Path bG() {
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
    /* loaded from: classes12.dex */
    public class b {
        public float grY;
        public float grZ;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.grY = 0.0f;
            this.grZ = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.grY = (float) (f3 / sqrt);
                this.grZ = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.grY = ((float) (f3 / sqrt)) + this.grY;
                this.grZ += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.grY += bVar.grY;
            this.grZ += bVar.grZ;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.grY + Constants.ACCEPT_TIME_SEPARATOR_SP + this.grZ + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements SVG.v {
        private List<b> bzM = new ArrayList();
        private b lFK = null;
        private boolean lFL = false;
        private boolean lFM = true;
        private int lFN = -1;
        private boolean lFO;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lFO) {
                    this.lFK.a(this.bzM.get(this.lFN));
                    this.bzM.set(this.lFN, this.lFK);
                    this.lFO = false;
                }
                if (this.lFK != null) {
                    this.bzM.add(this.lFK);
                }
            }
        }

        public List<b> dja() {
            return this.bzM;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lFO) {
                this.lFK.a(this.bzM.get(this.lFN));
                this.bzM.set(this.lFN, this.lFK);
                this.lFO = false;
            }
            if (this.lFK != null) {
                this.bzM.add(this.lFK);
            }
            this.startX = f;
            this.startY = f2;
            this.lFK = new b(f, f2, 0.0f, 0.0f);
            this.lFN = this.bzM.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lFK.C(f, f2);
            this.bzM.add(this.lFK);
            this.lFK = new b(f, f2, f - this.lFK.x, f2 - this.lFK.y);
            this.lFO = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lFM || this.lFL) {
                this.lFK.C(f, f2);
                this.bzM.add(this.lFK);
                this.lFL = false;
            }
            this.lFK = new b(f5, f6, f5 - f3, f6 - f4);
            this.lFO = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lFK.C(f, f2);
            this.bzM.add(this.lFK);
            this.lFK = new b(f3, f4, f3 - f, f4 - f2);
            this.lFO = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lFL = true;
            this.lFM = false;
            c.a(this.lFK.x, this.lFK.y, f, f2, f3, z, z2, f4, f5, this);
            this.lFM = true;
            this.lFO = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bzM.add(this.lFK);
            B(this.startX, this.startY);
            this.lFO = true;
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
        if (this.lFz.lCU.lEO != null || this.lFz.lCU.lEP != null || this.lFz.lCU.lEQ != null) {
            if (this.lFz.lCU.lEO != null) {
                SVG.ak NP = jVar.lFl.NP(this.lFz.lCU.lEO);
                if (NP != null) {
                    pVar = (SVG.p) NP;
                    if (this.lFz.lCU.lEP != null) {
                        SVG.ak NP2 = jVar.lFl.NP(this.lFz.lCU.lEP);
                        if (NP2 != null) {
                            pVar2 = (SVG.p) NP2;
                            if (this.lFz.lCU.lEQ != null) {
                                SVG.ak NP3 = jVar.lFl.NP(this.lFz.lCU.lEQ);
                                if (NP3 != null) {
                                    pVar3 = (SVG.p) NP3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lEh).dja();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lFz.lCU;
                                        SVG.Style style2 = this.lFz.lCU;
                                        this.lFz.lCU.lEQ = null;
                                        style2.lEP = null;
                                        style.lEO = null;
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
                                k("Marker reference '%s' not found", this.lFz.lCU.lEQ);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lFz.lCU.lEP);
                    }
                    pVar2 = null;
                    if (this.lFz.lCU.lEQ != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lFz.lCU.lEO);
                }
            }
            pVar = null;
            if (this.lFz.lCU.lEP != null) {
            }
            pVar2 = null;
            if (this.lFz.lCU.lEQ != null) {
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
        boolean diN;
        float f3;
        float f4 = 0.0f;
        diK();
        if (pVar.lEd != null) {
            if (Float.isNaN(pVar.lEd.floatValue())) {
                if (bVar.grY != 0.0f || bVar.grZ != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.grZ, bVar.grY));
                }
            } else {
                f2 = pVar.lEd.floatValue();
            }
            float bg = !pVar.lDY ? 1.0f : this.lFz.lCU.lEx.bg(this.lFx);
            this.lFz = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bg, bg);
            float a2 = pVar.lDZ == null ? pVar.lDZ.a(this) : 0.0f;
            float b2 = pVar.lEa == null ? pVar.lEa.b(this) : 0.0f;
            float a3 = pVar.lEb == null ? pVar.lEb.a(this) : 3.0f;
            float b3 = pVar.lEc != null ? pVar.lEc.b(this) : 3.0f;
            if (pVar.lFq == null) {
                float f5 = a3 / pVar.lFq.width;
                float f6 = b3 / pVar.lFq.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lFn != null ? pVar.lFn : PreserveAspectRatio.lDj;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lDi)) {
                    f6 = preserveAspectRatio.dip() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lFv.concat(matrix);
                float f7 = pVar.lFq.width * f5;
                float f8 = pVar.lFq.height * f6;
                switch (preserveAspectRatio.dio()) {
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
                switch (preserveAspectRatio.dio()) {
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
                if (!this.lFz.lCU.lEM.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lFv.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lFv.concat(matrix);
                if (!this.lFz.lCU.lEM.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            diN = diN();
            a((SVG.ag) pVar, false);
            if (diN) {
                b((SVG.ah) pVar);
            }
            diL();
        }
        f2 = 0.0f;
        if (!pVar.lDY) {
        }
        this.lFz = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bg, bg);
        if (pVar.lDZ == null) {
        }
        if (pVar.lEa == null) {
        }
        if (pVar.lEb == null) {
        }
        if (pVar.lEc != null) {
        }
        if (pVar.lFq == null) {
        }
        diN = diN();
        a((SVG.ag) pVar, false);
        if (diN) {
        }
        diL();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.diz());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lFm == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lFm;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lFq = this.lFl.dir().lFq;
        if (gVar.lFq == null) {
            gVar.lFq = this.lFw;
        }
        gVar.lFT = this.lFw;
        gVar.lFV = this.lFz.lFV;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lFz.lCU.lEs instanceof SVG.s) {
            a(true, ahVar.lFh, (SVG.s) this.lFz.lCU.lEs);
        }
        if (this.lFz.lCU.lEv instanceof SVG.s) {
            a(false, ahVar.lFh, (SVG.s) this.lFz.lCU.lEv);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak NP = this.lFl.NP(sVar.Tl);
        if (NP == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.Tl;
            k("%s reference '%s' not found", objArr);
            if (sVar.lEg != null) {
                a(this.lFz, z, sVar.lEg);
                return;
            } else if (z) {
                this.lFz.lFR = false;
                return;
            } else {
                this.lFz.lFS = false;
                return;
            }
        }
        if (NP instanceof SVG.aj) {
            a(z, aVar, (SVG.aj) NP);
        }
        if (NP instanceof SVG.an) {
            a(z, aVar, (SVG.an) NP);
        }
        if (NP instanceof SVG.aa) {
            a(z, (SVG.aa) NP);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.aj ajVar) {
        float a2;
        float f2;
        float f3;
        float f4;
        if (ajVar.Tl != null) {
            a(ajVar, ajVar.Tl);
        }
        boolean z2 = ajVar.lDL != null && ajVar.lDL.booleanValue();
        Paint paint = z ? this.lFz.jI : this.lFz.jJ;
        if (z2) {
            SVG.a diJ = diJ();
            float a3 = ajVar.lDU != null ? ajVar.lDU.a(this) : 0.0f;
            float b2 = ajVar.lDV != null ? ajVar.lDV.b(this) : 0.0f;
            float a4 = ajVar.lDW != null ? ajVar.lDW.a(this) : diJ.width;
            a2 = ajVar.lDX != null ? ajVar.lDX.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lDU != null ? ajVar.lDU.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lDV != null ? ajVar.lDV.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lDW != null ? ajVar.lDW.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lDX != null ? ajVar.lDX.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        diK();
        this.lFz = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDw, aVar.lDx);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lDM != null) {
            matrix.preConcat(ajVar.lDM);
        }
        int size = ajVar.UB.size();
        if (size == 0) {
            diL();
            if (z) {
                this.lFz.lFR = false;
                return;
            } else {
                this.lFz.lFS = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = ajVar.UB.iterator();
        int i2 = 0;
        float f5 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lEq.floatValue() >= f5) {
                fArr[i2] = abVar.lEq.floatValue();
                f5 = abVar.lEq.floatValue();
            } else {
                fArr[i2] = f5;
            }
            diK();
            a(this.lFz, abVar);
            SVG.e eVar = (SVG.e) this.lFz.lCU.lET;
            if (eVar == null) {
                eVar = SVG.e.lDH;
            }
            iArr[i2] = eVar.lDG | (bh(this.lFz.lCU.lEU.floatValue()) << 24);
            diL();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            diL();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lDN != null) {
            if (ajVar.lDN == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lDN == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diL();
        LinearGradient linearGradient = new LinearGradient(f4, f3, f2, a2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void a(boolean z, SVG.a aVar, SVG.an anVar) {
        float a2;
        float f2;
        float f3;
        if (anVar.Tl != null) {
            a(anVar, anVar.Tl);
        }
        boolean z2 = anVar.lDL != null && anVar.lDL.booleanValue();
        Paint paint = z ? this.lFz.jI : this.lFz.jJ;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lDC != null ? anVar.lDC.a(this) : nVar.a(this);
            float b2 = anVar.lDD != null ? anVar.lDD.b(this) : nVar.b(this);
            a2 = anVar.lDE != null ? anVar.lDE.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lDC != null ? anVar.lDC.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lDD != null ? anVar.lDD.a(this, 1.0f) : 0.5f;
            a2 = anVar.lDE != null ? anVar.lDE.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        diK();
        this.lFz = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDw, aVar.lDx);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lDM != null) {
            matrix.preConcat(anVar.lDM);
        }
        int size = anVar.UB.size();
        if (size == 0) {
            diL();
            if (z) {
                this.lFz.lFR = false;
                return;
            } else {
                this.lFz.lFS = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = anVar.UB.iterator();
        int i2 = 0;
        float f4 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lEq.floatValue() >= f4) {
                fArr[i2] = abVar.lEq.floatValue();
                f4 = abVar.lEq.floatValue();
            } else {
                fArr[i2] = f4;
            }
            diK();
            a(this.lFz, abVar);
            SVG.e eVar = (SVG.e) this.lFz.lCU.lET;
            if (eVar == null) {
                eVar = SVG.e.lDH;
            }
            iArr[i2] = eVar.lDG | (bh(this.lFz.lCU.lEU.floatValue()) << 24);
            diL();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            diL();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lDN != null) {
            if (anVar.lDN == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lDN == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diL();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak NP = iVar.lFl.NP(str);
        if (NP == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(NP instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (NP == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) NP;
            if (iVar.lDL == null) {
                iVar.lDL = iVar2.lDL;
            }
            if (iVar.lDM == null) {
                iVar.lDM = iVar2.lDM;
            }
            if (iVar.lDN == null) {
                iVar.lDN = iVar2.lDN;
            }
            if (iVar.UB.isEmpty()) {
                iVar.UB = iVar2.UB;
            }
            try {
                if (iVar instanceof SVG.aj) {
                    a((SVG.aj) iVar, (SVG.aj) NP);
                } else {
                    a((SVG.an) iVar, (SVG.an) NP);
                }
            } catch (ClassCastException e2) {
            }
            if (iVar2.Tl != null) {
                a(iVar, iVar2.Tl);
            }
        }
    }

    private void a(SVG.aj ajVar, SVG.aj ajVar2) {
        if (ajVar.lDU == null) {
            ajVar.lDU = ajVar2.lDU;
        }
        if (ajVar.lDV == null) {
            ajVar.lDV = ajVar2.lDV;
        }
        if (ajVar.lDW == null) {
            ajVar.lDW = ajVar2.lDW;
        }
        if (ajVar.lDX == null) {
            ajVar.lDX = ajVar2.lDX;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lDC == null) {
            anVar.lDC = anVar2.lDC;
        }
        if (anVar.lDD == null) {
            anVar.lDD = anVar2.lDD;
        }
        if (anVar.lDE == null) {
            anVar.lDE = anVar2.lDE;
        }
        if (anVar.lFo == null) {
            anVar.lFo = anVar2.lFo;
        }
        if (anVar.lFp == null) {
            anVar.lFp = anVar2.lFp;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lFj, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lFz.lCU.lEs = aaVar.lFj.lEX;
                this.lFz.lFR = aaVar.lFj.lEX != null;
            }
            if (a(aaVar.lFj, 4294967296L)) {
                this.lFz.lCU.lEu = aaVar.lFj.lEY;
            }
            if (a(aaVar.lFj, 6442450944L)) {
                a(this.lFz, z, this.lFz.lCU.lEs);
                return;
            }
            return;
        }
        if (a(aaVar.lFj, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lFz.lCU.lEv = aaVar.lFj.lEX;
            this.lFz.lFS = aaVar.lFj.lEX != null;
        }
        if (a(aaVar.lFj, 4294967296L)) {
            this.lFz.lCU.lEw = aaVar.lFj.lEY;
        }
        if (a(aaVar.lFj, 6442450944L)) {
            a(this.lFz, z, this.lFz.lCU.lEv);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lFh);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lFz.lCU.clipPath != null) {
            SVG.ak NP = ahVar.lFl.NP(this.lFz.lCU.clipPath);
            if (NP == null) {
                k("ClipPath reference '%s' not found", this.lFz.lCU.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) NP;
            if (dVar.UB.isEmpty()) {
                this.lFv.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lDF == null || dVar.lDF.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            diX();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lDw, aVar.lDx);
                matrix.preScale(aVar.width, aVar.height);
                this.lFv.concat(matrix);
            }
            if (dVar.lDO != null) {
                this.lFv.concat(dVar.lDO);
            }
            this.lFz = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.UB) {
                a(akVar, true, path, new Matrix());
            }
            this.lFv.clipPath(path);
            diY();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (diT()) {
            diX();
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
            diY();
        }
    }

    private void diX() {
        this.lFv.save();
        this.lFA.push(this.lFz);
        this.lFz = (g) this.lFz.clone();
    }

    private void diY() {
        this.lFv.restore();
        this.lFz = this.lFA.pop();
    }

    private Path.FillType diZ() {
        if (this.lFz.lCU.lEV == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFz.lCU.lEV) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lFz, tVar);
        if (diT() && diU()) {
            if (tVar.lDO != null) {
                matrix.preConcat(tVar.lDO);
            }
            Path bG = new C0651c(tVar.lEh).bG();
            if (tVar.lFh == null) {
                tVar.lFh = b(bG);
            }
            d((SVG.ah) tVar);
            path.setFillType(diZ());
            path.addPath(bG, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lFz, jVar);
        if (diT() && diU()) {
            if (jVar.lDO != null) {
                matrix.preConcat(jVar.lDO);
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
        a(this.lFz, baVar);
        if (diT() && diU()) {
            if (baVar.lDO != null) {
                matrix.preConcat(baVar.lDO);
            }
            SVG.ak NP = baVar.lFl.NP(baVar.Tl);
            if (NP == null) {
                k("Use reference '%s' not found", baVar.Tl);
                return;
            }
            d((SVG.ah) baVar);
            a(NP, false, path, matrix);
        }
    }

    private void a(SVG.at atVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        a(this.lFz, atVar);
        if (diT()) {
            if (atVar.lDO != null) {
                matrix.preConcat(atVar.lDO);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFt == null || atVar.lFt.size() == 0) ? 0.0f : atVar.lFt.get(0).a(this);
            if (atVar.lFu != null && atVar.lFu.size() != 0) {
                f2 = atVar.lFu.get(0).b(this);
            }
            if (this.lFz.lCU.lEL != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lFz.lCU.lEL == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFh == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFh = new SVG.a(hVar.lFW.left, hVar.lFW.top, hVar.lFW.width(), hVar.lFW.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(diZ());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class f extends i {
        public Path lFQ;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lFQ = path;
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
        public void NT(String str) {
            if (c.this.diU()) {
                Path path = new Path();
                c.this.lFz.jI.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lFQ.addPath(path);
            }
            this.x += c.this.lFz.jI.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lDU == null ? 0.0f : oVar.lDU.a(this);
        float b2 = oVar.lDV == null ? 0.0f : oVar.lDV.b(this);
        float a3 = oVar.lDW == null ? 0.0f : oVar.lDW.a(this);
        float b3 = oVar.lDX != null ? oVar.lDX.b(this) : 0.0f;
        if (oVar.lFh == null) {
            oVar.lFh = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lDJ == null && zVar.lDK == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lDJ == null) {
            b2 = zVar.lDK.b(this);
            a2 = b2;
        } else if (zVar.lDK == null) {
            b2 = zVar.lDJ.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lDJ.a(this);
            b2 = zVar.lDK.b(this);
        }
        float min = Math.min(a2, zVar.lDR.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lDS.b(this) / 2.0f);
        float a3 = zVar.lDP != null ? zVar.lDP.a(this) : 0.0f;
        float b3 = zVar.lDQ != null ? zVar.lDQ.b(this) : 0.0f;
        float a4 = zVar.lDR.a(this);
        float b4 = zVar.lDS.b(this);
        if (zVar.lFh == null) {
            zVar.lFh = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lDC != null ? cVar.lDC.a(this) : 0.0f;
        float b2 = cVar.lDD != null ? cVar.lDD.b(this) : 0.0f;
        float c = cVar.lDE.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lFh == null) {
            cVar.lFh = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lDC != null ? hVar.lDC.a(this) : 0.0f;
        float b2 = hVar.lDD != null ? hVar.lDD.b(this) : 0.0f;
        float a3 = hVar.lDJ.a(this);
        float b3 = hVar.lDK.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lFh == null) {
            hVar.lFh = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lFh == null) {
            xVar.lFh = b(path);
        }
        path.setFillType(diZ());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lEn != null && wVar.lEn.booleanValue();
        if (wVar.Tl != null) {
            a(wVar, wVar.Tl);
        }
        if (z) {
            float a2 = wVar.lDP != null ? wVar.lDP.a(this) : 0.0f;
            float b2 = wVar.lDQ != null ? wVar.lDQ.b(this) : 0.0f;
            float a3 = wVar.lDR != null ? wVar.lDR.a(this) : 0.0f;
            f2 = wVar.lDS != null ? wVar.lDS.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lDP != null ? wVar.lDP.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lDQ != null ? wVar.lDQ.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lDR != null ? wVar.lDR.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lDS != null ? wVar.lDS.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lFh.width) + ahVar.lFh.lDw;
            float f7 = (a5 * ahVar.lFh.height) + ahVar.lFh.lDx;
            float f8 = a6 * ahVar.lFh.width;
            f2 = a7 * ahVar.lFh.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lFn != null ? wVar.lFn : PreserveAspectRatio.lDj;
            diK();
            this.lFv.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.diz());
            gVar.lCU.lEM = false;
            this.lFz = a(wVar, gVar);
            SVG.a aVar = ahVar.lFh;
            if (wVar.lEp != null) {
                this.lFv.concat(wVar.lEp);
                Matrix matrix = new Matrix();
                if (wVar.lEp.invert(matrix)) {
                    float[] fArr = {ahVar.lFh.lDw, ahVar.lFh.lDx, ahVar.lFh.div(), ahVar.lFh.lDx, ahVar.lFh.div(), ahVar.lFh.diw(), ahVar.lFh.lDw, ahVar.lFh.diw()};
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
            float floor = f5 + (((float) Math.floor((aVar.lDw - f5) / f3)) * f3);
            float div = aVar.div();
            float diw = aVar.diw();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lDx - f4) / f2)) * f2); floor2 < diw; floor2 += f2) {
                for (float f9 = floor; f9 < div; f9 += f3) {
                    aVar2.lDw = f9;
                    aVar2.lDx = floor2;
                    diK();
                    if (!this.lFz.lCU.lEM.booleanValue()) {
                        m(aVar2.lDw, aVar2.lDx, aVar2.width, aVar2.height);
                    }
                    if (wVar.lFq != null) {
                        this.lFv.concat(a(aVar2, wVar.lFq, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lEo == null || wVar.lEo.booleanValue();
                        this.lFv.translate(f9, floor2);
                        if (!z2) {
                            this.lFv.scale(ahVar.lFh.width, ahVar.lFh.height);
                        }
                    }
                    boolean diN = diN();
                    for (SVG.ak akVar : wVar.UB) {
                        b(akVar);
                    }
                    if (diN) {
                        b((SVG.ah) wVar);
                    }
                    diL();
                }
            }
            diL();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak NP = wVar.lFl.NP(str);
        if (NP == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(NP instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (NP == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) NP;
            if (wVar.lEn == null) {
                wVar.lEn = wVar2.lEn;
            }
            if (wVar.lEo == null) {
                wVar.lEo = wVar2.lEo;
            }
            if (wVar.lEp == null) {
                wVar.lEp = wVar2.lEp;
            }
            if (wVar.lDP == null) {
                wVar.lDP = wVar2.lDP;
            }
            if (wVar.lDQ == null) {
                wVar.lDQ = wVar2.lDQ;
            }
            if (wVar.lDR == null) {
                wVar.lDR = wVar2.lDR;
            }
            if (wVar.lDS == null) {
                wVar.lDS = wVar2.lDS;
            }
            if (wVar.UB.isEmpty()) {
                wVar.UB = wVar2.UB;
            }
            if (wVar.lFq == null) {
                wVar.lFq = wVar2.lFq;
            }
            if (wVar.lFn == null) {
                wVar.lFn = wVar2.lFn;
            }
            if (wVar2.Tl != null) {
                a(wVar, wVar2.Tl);
            }
        }
    }

    private void a(SVG.q qVar, SVG.ah ahVar) {
        float f2;
        float f3;
        debug("Mask render", new Object[0]);
        if (qVar.lEe != null && qVar.lEe.booleanValue()) {
            f2 = qVar.lDR != null ? qVar.lDR.a(this) : ahVar.lFh.width;
            f3 = qVar.lDS != null ? qVar.lDS.b(this) : ahVar.lFh.height;
            if (qVar.lDP != null) {
                qVar.lDP.a(this);
            } else {
                float f4 = (float) (ahVar.lFh.lDw - (ahVar.lFh.width * 0.1d));
            }
            if (qVar.lDQ != null) {
                qVar.lDQ.b(this);
            } else {
                float f5 = (float) (ahVar.lFh.lDx - (ahVar.lFh.height * 0.1d));
            }
        } else {
            float a2 = qVar.lDP != null ? qVar.lDP.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lDQ != null ? qVar.lDQ.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lDR != null ? qVar.lDR.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lDS != null ? qVar.lDS.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lFh.width) + ahVar.lFh.lDw;
            float f7 = ahVar.lFh.lDx + (a3 * ahVar.lFh.height);
            f2 = ahVar.lFh.width * a4;
            f3 = ahVar.lFh.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            diK();
            this.lFz = d((SVG.ak) qVar);
            this.lFz.lCU.lED = Float.valueOf(1.0f);
            if (!(qVar.lEf == null || qVar.lEf.booleanValue())) {
                this.lFv.translate(ahVar.lFh.lDw, ahVar.lFh.lDx);
                this.lFv.scale(ahVar.lFh.width, ahVar.lFh.height);
            }
            a((SVG.ag) qVar, false);
            diL();
        }
    }
}
