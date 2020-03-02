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
    private static HashSet<String> lFH = null;
    private boolean lFA;
    private g lFB;
    private Stack<g> lFC;
    private Stack<SVG.ag> lFD;
    private Stack<Matrix> lFE;
    private Stack<Canvas> lFF;
    private Stack<Bitmap> lFG;
    private SVG lFn;
    private Canvas lFx;
    private SVG.a lFy;
    private float lFz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class g implements Cloneable {
        public Paint jI = new Paint();
        public Paint jJ;
        public SVG.Style lCW;
        public boolean lFT;
        public boolean lFU;
        public SVG.a lFV;
        public boolean lFW;
        public boolean lFX;
        public SVG.a lFs;

        public g() {
            this.jI.setFlags(385);
            this.jI.setStyle(Paint.Style.FILL);
            this.jI.setTypeface(Typeface.DEFAULT);
            this.jJ = new Paint();
            this.jJ.setFlags(385);
            this.jJ.setStyle(Paint.Style.STROKE);
            this.jJ.setTypeface(Typeface.DEFAULT);
            this.lCW = SVG.Style.diB();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lCW = (SVG.Style) this.lCW.clone();
                gVar.jI = new Paint(this.jI);
                gVar.jJ = new Paint(this.jJ);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lFB = new g();
        this.lFC = new Stack<>();
        a(this.lFB, SVG.Style.diB());
        this.lFB.lFV = this.lFy;
        this.lFB.lFW = false;
        this.lFB.lFX = this.lFA;
        this.lFC.push((g) this.lFB.clone());
        this.lFF = new Stack<>();
        this.lFG = new Stack<>();
        this.lFE = new Stack<>();
        this.lFD = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lFx = canvas;
        this.lFz = f2;
        this.lFy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diI() {
        return this.lFz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diJ() {
        return this.lFB.jI.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diK() {
        return this.lFB.jI.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a diL() {
        return this.lFB.lFs != null ? this.lFB.lFs : this.lFB.lFV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lFn = svg;
        this.lFA = z;
        SVG.ac dit = svg.dit();
        if (dit == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) dit);
        a(dit, dit.lDT, dit.lDU, aVar != null ? aVar : dit.lFs, preserveAspectRatio != null ? preserveAspectRatio : dit.lFp);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            diM();
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
            diN();
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
            diO();
        }
    }

    private void diM() {
        this.lFx.save();
        this.lFC.push(this.lFB);
        this.lFB = (g) this.lFB.clone();
    }

    private void diN() {
        this.lFx.restore();
        this.lFB = this.lFC.pop();
    }

    private void a(SVG.ag agVar) {
        this.lFD.push(agVar);
        this.lFE.push(this.lFx.getMatrix());
    }

    private void diO() {
        this.lFD.pop();
        this.lFE.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lCW.uY(aiVar.lFo == null);
        if (aiVar.lFl != null) {
            a(gVar, aiVar.lFl);
        }
        if (this.lFn.div()) {
            for (CSSParser.c cVar : this.lFn.diu()) {
                if (CSSParser.a(cVar.lCV, aiVar)) {
                    a(gVar, cVar.lCW);
                }
            }
        }
        if (aiVar.lCW != null) {
            a(gVar, aiVar.lCW);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lFk != null) {
                this.lFB.lFW = aiVar.lFk.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lFB.lCW.lEu instanceof SVG.s) {
            SVG.ak NP = this.lFn.NP(((SVG.s) this.lFB.lCW.lEu).Tl);
            if (NP instanceof SVG.w) {
                a(ahVar, path, (SVG.w) NP);
                return;
            }
        }
        this.lFx.drawPath(path, this.lFB.jI);
    }

    private void a(Path path) {
        if (this.lFB.lCW.lFd == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lFx.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lFx.setMatrix(new Matrix());
            Shader shader = this.lFB.jJ.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lFx.drawPath(path2, this.lFB.jJ);
            this.lFx.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lFx.drawPath(path, this.lFB.jJ);
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
        a(acVar, acVar.lDT, acVar.lDU);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lFs, acVar.lFp);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lFp != null ? acVar.lFp : PreserveAspectRatio.lDl;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lFB, acVar);
                if (diV()) {
                    if (acVar.lFo != null) {
                        f2 = acVar.lDR != null ? acVar.lDR.a(this) : 0.0f;
                        if (acVar.lDS != null) {
                            f3 = acVar.lDS.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a diL = diL();
                    this.lFB.lFV = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : diL.width, nVar2 != null ? nVar2.b(this) : diL.height);
                    if (!this.lFB.lCW.lEO.booleanValue()) {
                        m(this.lFB.lFV.lDy, this.lFB.lFV.lDz, this.lFB.lFV.width, this.lFB.lFV.height);
                    }
                    a(acVar, this.lFB.lFV);
                    if (aVar != null) {
                        this.lFx.concat(a(this.lFB.lFV, aVar, preserveAspectRatio2));
                        this.lFB.lFs = acVar.lFs;
                    } else {
                        this.lFx.translate(f2, f3);
                    }
                    boolean diP = diP();
                    diY();
                    a((SVG.ag) acVar, true);
                    if (diP) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lFB, kVar);
        if (diV()) {
            if (kVar.lDQ != null) {
                this.lFx.concat(kVar.lDQ);
            }
            d((SVG.ah) kVar);
            boolean diP = diP();
            a((SVG.ag) kVar, true);
            if (diP) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lFo != null && ahVar.lFj != null) {
            Matrix matrix = new Matrix();
            if (this.lFE.peek().invert(matrix)) {
                float[] fArr = {ahVar.lFj.lDy, ahVar.lFj.lDz, ahVar.lFj.dix(), ahVar.lFj.lDz, ahVar.lFj.dix(), ahVar.lFj.diy(), ahVar.lFj.lDy, ahVar.lFj.diy()};
                matrix.preConcat(this.lFx.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lFD.peek();
                if (ahVar2.lFj == null) {
                    ahVar2.lFj = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lFj.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean diP() {
        if (diQ()) {
            this.lFx.saveLayerAlpha(null, bh(this.lFB.lCW.lEF.floatValue()), 31);
            this.lFC.push(this.lFB);
            this.lFB = (g) this.lFB.clone();
            if (this.lFB.lCW.lEY != null && this.lFB.lFX) {
                SVG.ak NP = this.lFn.NP(this.lFB.lCW.lEY);
                if (NP == null || !(NP instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lFB.lCW.lEY);
                    this.lFB.lCW.lEY = null;
                    return true;
                }
                this.lFF.push(this.lFx);
                diR();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lFB.lCW.lEY != null && this.lFB.lFX) {
            SVG.ak NP = this.lFn.NP(this.lFB.lCW.lEY);
            diR();
            a((SVG.q) NP, ahVar);
            Bitmap diS = diS();
            this.lFx = this.lFF.pop();
            this.lFx.save();
            this.lFx.setMatrix(new Matrix());
            this.lFx.drawBitmap(diS, 0.0f, 0.0f, this.lFB.jI);
            diS.recycle();
            this.lFx.restore();
        }
        diN();
    }

    private boolean diQ() {
        if (this.lFB.lCW.lEY != null && !this.lFB.lFX) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lFB.lCW.lEF.floatValue() < 1.0f || (this.lFB.lCW.lEY != null && this.lFB.lFX);
    }

    private void diR() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lFx.getWidth(), this.lFx.getHeight(), Bitmap.Config.ARGB_8888);
            this.lFG.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lFx.getMatrix());
            this.lFx = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap diS() {
        Bitmap pop = this.lFG.pop();
        Bitmap pop2 = this.lFG.pop();
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
        a(this.lFB, apVar);
        if (diV()) {
            if (apVar.lDQ != null) {
                this.lFx.concat(apVar.lDQ);
            }
            d((SVG.ah) apVar);
            boolean diP = diP();
            b(apVar);
            if (diP) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> diE;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d diw = this.lFn.diw();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.diD() == null && ((diE = adVar.diE()) == null || (!diE.isEmpty() && diE.contains(language)))) {
                    Set<String> diC = adVar.diC();
                    if (diC != null) {
                        if (lFH == null) {
                            diT();
                        }
                        if (!diC.isEmpty() && lFH.containsAll(diC)) {
                        }
                    }
                    Set<String> diF = adVar.diF();
                    if (diF != null) {
                        if (!diF.isEmpty() && diw != null) {
                            for (String str : diF) {
                                if (!diw.NV(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> diG = adVar.diG();
                    if (diG != null) {
                        if (!diG.isEmpty() && diw != null) {
                            for (String str2 : diG) {
                                if (diw.x(str2, this.lFB.lCW.lEJ.intValue(), String.valueOf(this.lFB.lCW.lEK)) == null) {
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

    private static synchronized void diT() {
        synchronized (c.class) {
            lFH = new HashSet<>();
            lFH.add("Structure");
            lFH.add("BasicStructure");
            lFH.add("ConditionalProcessing");
            lFH.add("Image");
            lFH.add("Style");
            lFH.add("ViewportAttribute");
            lFH.add("Shape");
            lFH.add("BasicText");
            lFH.add("PaintAttribute");
            lFH.add("BasicPaintAttribute");
            lFH.add("OpacityAttribute");
            lFH.add("BasicGraphicsAttribute");
            lFH.add("Marker");
            lFH.add("Gradient");
            lFH.add("Pattern");
            lFH.add("Clip");
            lFH.add("BasicClip");
            lFH.add("Mask");
            lFH.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lDT == null || !baVar.lDT.isZero()) {
            if (baVar.lDU == null || !baVar.lDU.isZero()) {
                a(this.lFB, baVar);
                if (diV()) {
                    SVG.ak NP = baVar.lFn.NP(baVar.Tl);
                    if (NP == null) {
                        k("Use reference '%s' not found", baVar.Tl);
                        return;
                    }
                    if (baVar.lDQ != null) {
                        this.lFx.concat(baVar.lDQ);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lDR != null ? baVar.lDR.a(this) : 0.0f, baVar.lDS != null ? baVar.lDS.b(this) : 0.0f);
                    this.lFx.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean diP = diP();
                    a((SVG.ag) baVar);
                    if (NP instanceof SVG.ac) {
                        diM();
                        SVG.ac acVar = (SVG.ac) NP;
                        a(acVar, baVar.lDT != null ? baVar.lDT : acVar.lDT, baVar.lDU != null ? baVar.lDU : acVar.lDU);
                        diN();
                    } else if (NP instanceof SVG.aq) {
                        SVG.n nVar = baVar.lDT != null ? baVar.lDT : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lDU != null ? baVar.lDU : new SVG.n(100.0f, SVG.Unit.percent);
                        diM();
                        a((SVG.aq) NP, nVar, nVar2);
                        diN();
                    } else {
                        b(NP);
                    }
                    diO();
                    if (diP) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lEj != null) {
            a(this.lFB, tVar);
            if (diV() && diW()) {
                if (this.lFB.lFU || this.lFB.lFT) {
                    if (tVar.lDQ != null) {
                        this.lFx.concat(tVar.lDQ);
                    }
                    Path bG = new C0651c(tVar.lEj).bG();
                    if (tVar.lFj == null) {
                        tVar.lFj = b(bG);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean diP = diP();
                    if (this.lFB.lFT) {
                        bG.setFillType(diX());
                        a(tVar, bG);
                    }
                    if (this.lFB.lFU) {
                        a(bG);
                    }
                    a((SVG.j) tVar);
                    if (diP) {
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
        if (zVar.lDT != null && zVar.lDU != null && !zVar.lDT.isZero() && !zVar.lDU.isZero()) {
            a(this.lFB, zVar);
            if (diV() && diW()) {
                if (zVar.lDQ != null) {
                    this.lFx.concat(zVar.lDQ);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean diP = diP();
                if (this.lFB.lFT) {
                    a(zVar, b2);
                }
                if (this.lFB.lFU) {
                    a(b2);
                }
                if (diP) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lDG != null && !cVar.lDG.isZero()) {
            a(this.lFB, cVar);
            if (diV() && diW()) {
                if (cVar.lDQ != null) {
                    this.lFx.concat(cVar.lDQ);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean diP = diP();
                if (this.lFB.lFT) {
                    a(cVar, b2);
                }
                if (this.lFB.lFU) {
                    a(b2);
                }
                if (diP) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lDL != null && hVar.lDM != null && !hVar.lDL.isZero() && !hVar.lDM.isZero()) {
            a(this.lFB, hVar);
            if (diV() && diW()) {
                if (hVar.lDQ != null) {
                    this.lFx.concat(hVar.lDQ);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean diP = diP();
                if (this.lFB.lFT) {
                    a(hVar, b2);
                }
                if (this.lFB.lFU) {
                    a(b2);
                }
                if (diP) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lFB, oVar);
        if (diV() && diW() && this.lFB.lFU) {
            if (oVar.lDQ != null) {
                this.lFx.concat(oVar.lDQ);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean diP = diP();
            a(c);
            a((SVG.j) oVar);
            if (diP) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lDW != null ? oVar.lDW.a(this) : 0.0f;
        float b2 = oVar.lDX != null ? oVar.lDX.b(this) : 0.0f;
        float a3 = oVar.lDY != null ? oVar.lDY.a(this) : 0.0f;
        float b3 = oVar.lDZ != null ? oVar.lDZ.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lFB, xVar);
        if (diV() && diW()) {
            if (this.lFB.lFU || this.lFB.lFT) {
                if (xVar.lDQ != null) {
                    this.lFx.concat(xVar.lDQ);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean diP = diP();
                    if (this.lFB.lFT) {
                        a(xVar, c);
                    }
                    if (this.lFB.lFU) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (diP) {
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
        a(this.lFB, yVar);
        if (diV() && diW()) {
            if (this.lFB.lFU || this.lFB.lFT) {
                if (yVar.lDQ != null) {
                    this.lFx.concat(yVar.lDQ);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean diP = diP();
                    if (this.lFB.lFT) {
                        a(yVar, c);
                    }
                    if (this.lFB.lFU) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (diP) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lFB, atVar);
        if (diV()) {
            if (atVar.lDQ != null) {
                this.lFx.concat(atVar.lDQ);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFv == null || atVar.lFv.size() == 0) ? 0.0f : atVar.lFv.get(0).a(this);
            if (atVar.lFw != null && atVar.lFw.size() != 0) {
                f2 = atVar.lFw.get(0).b(this);
            }
            SVG.Style.TextAnchor diU = diU();
            if (diU != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (diU == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFj == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFj = new SVG.a(hVar.lFY.left, hVar.lFY.top, hVar.lFY.width(), hVar.lFY.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean diP = diP();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (diP) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor diU() {
        if (this.lFB.lCW.lEM == SVG.Style.TextDirection.LTR || this.lFB.lCW.lEN == SVG.Style.TextAnchor.Middle) {
            return this.lFB.lCW.lEN;
        }
        return this.lFB.lCW.lEN == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
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
            if (c.this.diW()) {
                if (c.this.lFB.lFT) {
                    c.this.lFx.drawText(str, this.x, this.y, c.this.lFB.jI);
                }
                if (c.this.lFB.lFU) {
                    c.this.lFx.drawText(str, this.x, this.y, c.this.lFB.jJ);
                }
            }
            this.x += c.this.lFB.jI.measureText(str);
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
        if (diV()) {
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
                diM();
                a((SVG.aw) akVar);
                diN();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                diM();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lFB, asVar);
                if (diV()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lFv == null || asVar.lFv.size() == 0) ? 0.0f : asVar.lFv.get(0).a(this);
                        if (asVar.lFw != null && asVar.lFw.size() != 0) {
                            f5 = asVar.lFw.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.diH());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean diP = diP();
                    a((SVG.av) asVar, iVar);
                    if (diP) {
                        b((SVG.ah) asVar);
                    }
                }
                diN();
            } else if (akVar instanceof SVG.ar) {
                diM();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lFB, arVar);
                if (diV()) {
                    c((SVG.ah) arVar.diH());
                    SVG.ak NP = akVar.lFn.NP(arVar.Tl);
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
                diN();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lFB, awVar);
        if (diV() && diW()) {
            SVG.ak NP = awVar.lFn.NP(awVar.Tl);
            if (NP == null) {
                k("TextPath reference '%s' not found", awVar.Tl);
                return;
            }
            SVG.t tVar = (SVG.t) NP;
            Path bG = new C0651c(tVar.lEj).bG();
            if (tVar.lDQ != null) {
                bG.transform(tVar.lDQ);
            }
            float a2 = awVar.lFu != null ? awVar.lFu.a(this, new PathMeasure(bG, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor diU = diU();
            if (diU != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (diU == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.diH());
            boolean diP = diP();
            a((SVG.av) awVar, (i) new d(bG, f2, 0.0f));
            if (diP) {
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
            if (c.this.diW()) {
                if (c.this.lFB.lFT) {
                    c.this.lFx.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFB.jI);
                }
                if (c.this.lFB.lFU) {
                    c.this.lFx.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFB.jJ);
                }
            }
            this.x += c.this.lFB.jI.measureText(str);
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
            this.x += c.this.lFB.jI.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class h extends i {
        RectF lFY;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lFY = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak NP = avVar.lFn.NP(awVar.Tl);
                if (NP == null) {
                    c.k("TextPath path reference '%s' not found", awVar.Tl);
                    return false;
                }
                SVG.t tVar = (SVG.t) NP;
                Path bG = new C0651c(tVar.lEj).bG();
                if (tVar.lDQ != null) {
                    bG.transform(tVar.lDQ);
                }
                RectF rectF = new RectF();
                bG.computeBounds(rectF, true);
                this.lFY.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NT(String str) {
            if (c.this.diW()) {
                Rect rect = new Rect();
                c.this.lFB.jI.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lFY.union(rectF);
            }
            this.x += c.this.lFB.jI.measureText(str);
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
        if (this.lFB.lFW) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lFp != null ? aqVar.lFp : PreserveAspectRatio.lDl;
                a(this.lFB, aqVar);
                this.lFB.lFV = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lFB.lFV.width, nVar2 != null ? nVar2.a(this) : this.lFB.lFV.height);
                if (!this.lFB.lCW.lEO.booleanValue()) {
                    m(this.lFB.lFV.lDy, this.lFB.lFV.lDz, this.lFB.lFV.width, this.lFB.lFV.height);
                }
                if (aqVar.lFs != null) {
                    this.lFx.concat(a(this.lFB.lFV, aqVar.lFs, preserveAspectRatio));
                    this.lFB.lFs = aqVar.lFs;
                }
                boolean diP = diP();
                a((SVG.ag) aqVar, true);
                if (diP) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lDT != null && !mVar.lDT.isZero() && mVar.lDU != null && !mVar.lDU.isZero() && mVar.Tl != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lFp != null ? mVar.lFp : PreserveAspectRatio.lDl;
            Bitmap NS = NS(mVar.Tl);
            if (NS == null) {
                com.caverock.androidsvg.d diw = this.lFn.diw();
                if (diw != null) {
                    bitmap = diw.NU(mVar.Tl);
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
            a(this.lFB, mVar);
            if (diV() && diW()) {
                if (mVar.lDQ != null) {
                    this.lFx.concat(mVar.lDQ);
                }
                this.lFB.lFV = new SVG.a(mVar.lDR != null ? mVar.lDR.a(this) : 0.0f, mVar.lDS != null ? mVar.lDS.b(this) : 0.0f, mVar.lDT.a(this), mVar.lDU.a(this));
                if (!this.lFB.lCW.lEO.booleanValue()) {
                    m(this.lFB.lFV.lDy, this.lFB.lFV.lDz, this.lFB.lFV.width, this.lFB.lFV.height);
                }
                mVar.lFj = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lFx.concat(a(this.lFB.lFV, mVar.lFj, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean diP = diP();
                diY();
                this.lFx.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (diP) {
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

    private boolean diV() {
        if (this.lFB.lCW.lET != null) {
            return this.lFB.lCW.lET.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean diW() {
        if (this.lFB.lCW.lEU != null) {
            return this.lFB.lCW.lEU.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.diq() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lDy;
        float f5 = -aVar2.lDz;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lDk)) {
            matrix.preTranslate(aVar.lDy, aVar.lDz);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dir() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.diq()) {
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
        switch (preserveAspectRatio.diq()) {
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
        matrix.preTranslate(aVar.lDy, aVar.lDz);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lEt & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lCW.lEG = style.lEG;
        }
        if (a(style, 2048L)) {
            gVar.lCW.lEF = style.lEF;
        }
        if (a(style, 1L)) {
            gVar.lCW.lEu = style.lEu;
            gVar.lFT = style.lEu != null;
        }
        if (a(style, 4L)) {
            gVar.lCW.lEw = style.lEw;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lCW.lEu);
        }
        if (a(style, 2L)) {
            gVar.lCW.lEv = style.lEv;
        }
        if (a(style, 8L)) {
            gVar.lCW.lEx = style.lEx;
            gVar.lFU = style.lEx != null;
        }
        if (a(style, 16L)) {
            gVar.lCW.lEy = style.lEy;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lCW.lEx);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lCW.lFd = style.lFd;
        }
        if (a(style, 32L)) {
            gVar.lCW.lEz = style.lEz;
            gVar.jJ.setStrokeWidth(gVar.lCW.lEz.c(this));
        }
        if (a(style, 64L)) {
            gVar.lCW.lEA = style.lEA;
            switch (style.lEA) {
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
            gVar.lCW.lEB = style.lEB;
            switch (style.lEB) {
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
            gVar.lCW.lEC = style.lEC;
            gVar.jJ.setStrokeMiter(style.lEC.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lCW.lED = style.lED;
        }
        if (a(style, 1024L)) {
            gVar.lCW.lEE = style.lEE;
        }
        if (a(style, 1536L)) {
            if (gVar.lCW.lED == null) {
                gVar.jJ.setPathEffect(null);
            } else {
                int length = gVar.lCW.lED.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lCW.lED[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jJ.setPathEffect(null);
                } else {
                    float c = gVar.lCW.lEE.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jJ.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float diJ = diJ();
            gVar.lCW.lEI = style.lEI;
            gVar.jI.setTextSize(style.lEI.a(this, diJ));
            gVar.jJ.setTextSize(style.lEI.a(this, diJ));
        }
        if (a(style, 8192L)) {
            gVar.lCW.lEH = style.lEH;
        }
        if (a(style, 32768L)) {
            if (style.lEJ.intValue() == -1 && gVar.lCW.lEJ.intValue() > 100) {
                gVar.lCW.lEJ = Integer.valueOf(style2.lEJ.intValue() - 100);
            } else if (style.lEJ.intValue() == 1 && gVar.lCW.lEJ.intValue() < 900) {
                SVG.Style style3 = gVar.lCW;
                style3.lEJ = Integer.valueOf(style3.lEJ.intValue() + 100);
            } else {
                gVar.lCW.lEJ = style.lEJ;
            }
        }
        if (a(style, 65536L)) {
            gVar.lCW.lEK = style.lEK;
        }
        if (a(style, 106496L)) {
            if (gVar.lCW.lEH == null || this.lFn == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d diw = this.lFn.diw();
                typeface = null;
                for (String str : gVar.lCW.lEH) {
                    Typeface a2 = a(str, gVar.lCW.lEJ, gVar.lCW.lEK);
                    if (a2 != null || diw == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = diw.x(str, gVar.lCW.lEJ.intValue(), String.valueOf(gVar.lCW.lEK));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lCW.lEJ, gVar.lCW.lEK);
            }
            gVar.jI.setTypeface(typeface);
            gVar.jJ.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lCW.lEL = style.lEL;
            gVar.jI.setStrikeThruText(style.lEL == SVG.Style.TextDecoration.LineThrough);
            gVar.jI.setUnderlineText(style.lEL == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jJ.setStrikeThruText(style.lEL == SVG.Style.TextDecoration.LineThrough);
                gVar.jJ.setUnderlineText(style.lEL == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lCW.lEM = style.lEM;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lCW.lEN = style.lEN;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lCW.lEO = style.lEO;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lCW.lEQ = style.lEQ;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lCW.lER = style.lER;
        }
        if (a(style, 8388608L)) {
            gVar.lCW.lES = style.lES;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lCW.lET = style.lET;
        }
        if (a(style, 33554432L)) {
            gVar.lCW.lEU = style.lEU;
        }
        if (a(style, 1048576L)) {
            gVar.lCW.lEP = style.lEP;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lCW.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lCW.lEX = style.lEX;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lCW.lEY = style.lEY;
        }
        if (a(style, 67108864L)) {
            gVar.lCW.lEV = style.lEV;
        }
        if (a(style, 134217728L)) {
            gVar.lCW.lEW = style.lEW;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lCW.lFb = style.lFb;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lCW.lFc = style.lFc;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lCW.lEw : gVar.lCW.lEy).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lDI;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lCW.lEG.lDI;
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

    private Path.FillType diX() {
        if (this.lFB.lCW.lEv == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFB.lCW.lEv) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lFB.lCW.lEP != null) {
            f2 += this.lFB.lCW.lEP.lDD.a(this);
            f3 += this.lFB.lCW.lEP.lDA.b(this);
            f6 -= this.lFB.lCW.lEP.lDB.a(this);
            f7 -= this.lFB.lCW.lEP.lDC.b(this);
        }
        this.lFx.clipRect(f2, f3, f6, f7);
    }

    private void diY() {
        int i2;
        if (this.lFB.lCW.lFb instanceof SVG.e) {
            i2 = ((SVG.e) this.lFB.lCW.lFb).lDI;
        } else if (this.lFB.lCW.lFb instanceof SVG.f) {
            i2 = this.lFB.lCW.lEG.lDI;
        } else {
            return;
        }
        if (this.lFB.lCW.lFc != null) {
            i2 |= bh(this.lFB.lCW.lFc.floatValue()) << 24;
        }
        this.lFx.drawColor(i2);
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
        public float gsa;
        public float gsb;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.gsa = 0.0f;
            this.gsb = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gsa = (float) (f3 / sqrt);
                this.gsb = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gsa = ((float) (f3 / sqrt)) + this.gsa;
                this.gsb += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.gsa += bVar.gsa;
            this.gsb += bVar.gsb;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.gsa + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gsb + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements SVG.v {
        private List<b> bzN = new ArrayList();
        private b lFM = null;
        private boolean lFN = false;
        private boolean lFO = true;
        private int lFP = -1;
        private boolean lFQ;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lFQ) {
                    this.lFM.a(this.bzN.get(this.lFP));
                    this.bzN.set(this.lFP, this.lFM);
                    this.lFQ = false;
                }
                if (this.lFM != null) {
                    this.bzN.add(this.lFM);
                }
            }
        }

        public List<b> djc() {
            return this.bzN;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lFQ) {
                this.lFM.a(this.bzN.get(this.lFP));
                this.bzN.set(this.lFP, this.lFM);
                this.lFQ = false;
            }
            if (this.lFM != null) {
                this.bzN.add(this.lFM);
            }
            this.startX = f;
            this.startY = f2;
            this.lFM = new b(f, f2, 0.0f, 0.0f);
            this.lFP = this.bzN.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lFM.C(f, f2);
            this.bzN.add(this.lFM);
            this.lFM = new b(f, f2, f - this.lFM.x, f2 - this.lFM.y);
            this.lFQ = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lFO || this.lFN) {
                this.lFM.C(f, f2);
                this.bzN.add(this.lFM);
                this.lFN = false;
            }
            this.lFM = new b(f5, f6, f5 - f3, f6 - f4);
            this.lFQ = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lFM.C(f, f2);
            this.bzN.add(this.lFM);
            this.lFM = new b(f3, f4, f3 - f, f4 - f2);
            this.lFQ = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lFN = true;
            this.lFO = false;
            c.a(this.lFM.x, this.lFM.y, f, f2, f3, z, z2, f4, f5, this);
            this.lFO = true;
            this.lFQ = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bzN.add(this.lFM);
            B(this.startX, this.startY);
            this.lFQ = true;
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
        if (this.lFB.lCW.lEQ != null || this.lFB.lCW.lER != null || this.lFB.lCW.lES != null) {
            if (this.lFB.lCW.lEQ != null) {
                SVG.ak NP = jVar.lFn.NP(this.lFB.lCW.lEQ);
                if (NP != null) {
                    pVar = (SVG.p) NP;
                    if (this.lFB.lCW.lER != null) {
                        SVG.ak NP2 = jVar.lFn.NP(this.lFB.lCW.lER);
                        if (NP2 != null) {
                            pVar2 = (SVG.p) NP2;
                            if (this.lFB.lCW.lES != null) {
                                SVG.ak NP3 = jVar.lFn.NP(this.lFB.lCW.lES);
                                if (NP3 != null) {
                                    pVar3 = (SVG.p) NP3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lEj).djc();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lFB.lCW;
                                        SVG.Style style2 = this.lFB.lCW;
                                        this.lFB.lCW.lES = null;
                                        style2.lER = null;
                                        style.lEQ = null;
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
                                k("Marker reference '%s' not found", this.lFB.lCW.lES);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lFB.lCW.lER);
                    }
                    pVar2 = null;
                    if (this.lFB.lCW.lES != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lFB.lCW.lEQ);
                }
            }
            pVar = null;
            if (this.lFB.lCW.lER != null) {
            }
            pVar2 = null;
            if (this.lFB.lCW.lES != null) {
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
        boolean diP;
        float f3;
        float f4 = 0.0f;
        diM();
        if (pVar.lEf != null) {
            if (Float.isNaN(pVar.lEf.floatValue())) {
                if (bVar.gsa != 0.0f || bVar.gsb != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.gsb, bVar.gsa));
                }
            } else {
                f2 = pVar.lEf.floatValue();
            }
            float bg = !pVar.lEa ? 1.0f : this.lFB.lCW.lEz.bg(this.lFz);
            this.lFB = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bg, bg);
            float a2 = pVar.lEb == null ? pVar.lEb.a(this) : 0.0f;
            float b2 = pVar.lEc == null ? pVar.lEc.b(this) : 0.0f;
            float a3 = pVar.lEd == null ? pVar.lEd.a(this) : 3.0f;
            float b3 = pVar.lEe != null ? pVar.lEe.b(this) : 3.0f;
            if (pVar.lFs == null) {
                float f5 = a3 / pVar.lFs.width;
                float f6 = b3 / pVar.lFs.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lFp != null ? pVar.lFp : PreserveAspectRatio.lDl;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lDk)) {
                    f6 = preserveAspectRatio.dir() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lFx.concat(matrix);
                float f7 = pVar.lFs.width * f5;
                float f8 = pVar.lFs.height * f6;
                switch (preserveAspectRatio.diq()) {
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
                switch (preserveAspectRatio.diq()) {
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
                if (!this.lFB.lCW.lEO.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lFx.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lFx.concat(matrix);
                if (!this.lFB.lCW.lEO.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            diP = diP();
            a((SVG.ag) pVar, false);
            if (diP) {
                b((SVG.ah) pVar);
            }
            diN();
        }
        f2 = 0.0f;
        if (!pVar.lEa) {
        }
        this.lFB = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bg, bg);
        if (pVar.lEb == null) {
        }
        if (pVar.lEc == null) {
        }
        if (pVar.lEd == null) {
        }
        if (pVar.lEe != null) {
        }
        if (pVar.lFs == null) {
        }
        diP = diP();
        a((SVG.ag) pVar, false);
        if (diP) {
        }
        diN();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.diB());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lFo == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lFo;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lFs = this.lFn.dit().lFs;
        if (gVar.lFs == null) {
            gVar.lFs = this.lFy;
        }
        gVar.lFV = this.lFy;
        gVar.lFX = this.lFB.lFX;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lFB.lCW.lEu instanceof SVG.s) {
            a(true, ahVar.lFj, (SVG.s) this.lFB.lCW.lEu);
        }
        if (this.lFB.lCW.lEx instanceof SVG.s) {
            a(false, ahVar.lFj, (SVG.s) this.lFB.lCW.lEx);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak NP = this.lFn.NP(sVar.Tl);
        if (NP == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.Tl;
            k("%s reference '%s' not found", objArr);
            if (sVar.lEi != null) {
                a(this.lFB, z, sVar.lEi);
                return;
            } else if (z) {
                this.lFB.lFT = false;
                return;
            } else {
                this.lFB.lFU = false;
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
        boolean z2 = ajVar.lDN != null && ajVar.lDN.booleanValue();
        Paint paint = z ? this.lFB.jI : this.lFB.jJ;
        if (z2) {
            SVG.a diL = diL();
            float a3 = ajVar.lDW != null ? ajVar.lDW.a(this) : 0.0f;
            float b2 = ajVar.lDX != null ? ajVar.lDX.b(this) : 0.0f;
            float a4 = ajVar.lDY != null ? ajVar.lDY.a(this) : diL.width;
            a2 = ajVar.lDZ != null ? ajVar.lDZ.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lDW != null ? ajVar.lDW.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lDX != null ? ajVar.lDX.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lDY != null ? ajVar.lDY.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lDZ != null ? ajVar.lDZ.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        diM();
        this.lFB = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDy, aVar.lDz);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lDO != null) {
            matrix.preConcat(ajVar.lDO);
        }
        int size = ajVar.UB.size();
        if (size == 0) {
            diN();
            if (z) {
                this.lFB.lFT = false;
                return;
            } else {
                this.lFB.lFU = false;
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
            if (i2 == 0 || abVar.lEs.floatValue() >= f5) {
                fArr[i2] = abVar.lEs.floatValue();
                f5 = abVar.lEs.floatValue();
            } else {
                fArr[i2] = f5;
            }
            diM();
            a(this.lFB, abVar);
            SVG.e eVar = (SVG.e) this.lFB.lCW.lEV;
            if (eVar == null) {
                eVar = SVG.e.lDJ;
            }
            iArr[i2] = eVar.lDI | (bh(this.lFB.lCW.lEW.floatValue()) << 24);
            diN();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            diN();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lDP != null) {
            if (ajVar.lDP == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lDP == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diN();
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
        boolean z2 = anVar.lDN != null && anVar.lDN.booleanValue();
        Paint paint = z ? this.lFB.jI : this.lFB.jJ;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lDE != null ? anVar.lDE.a(this) : nVar.a(this);
            float b2 = anVar.lDF != null ? anVar.lDF.b(this) : nVar.b(this);
            a2 = anVar.lDG != null ? anVar.lDG.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lDE != null ? anVar.lDE.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lDF != null ? anVar.lDF.a(this, 1.0f) : 0.5f;
            a2 = anVar.lDG != null ? anVar.lDG.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        diM();
        this.lFB = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDy, aVar.lDz);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lDO != null) {
            matrix.preConcat(anVar.lDO);
        }
        int size = anVar.UB.size();
        if (size == 0) {
            diN();
            if (z) {
                this.lFB.lFT = false;
                return;
            } else {
                this.lFB.lFU = false;
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
            if (i2 == 0 || abVar.lEs.floatValue() >= f4) {
                fArr[i2] = abVar.lEs.floatValue();
                f4 = abVar.lEs.floatValue();
            } else {
                fArr[i2] = f4;
            }
            diM();
            a(this.lFB, abVar);
            SVG.e eVar = (SVG.e) this.lFB.lCW.lEV;
            if (eVar == null) {
                eVar = SVG.e.lDJ;
            }
            iArr[i2] = eVar.lDI | (bh(this.lFB.lCW.lEW.floatValue()) << 24);
            diN();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            diN();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lDP != null) {
            if (anVar.lDP == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lDP == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diN();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak NP = iVar.lFn.NP(str);
        if (NP == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(NP instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (NP == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) NP;
            if (iVar.lDN == null) {
                iVar.lDN = iVar2.lDN;
            }
            if (iVar.lDO == null) {
                iVar.lDO = iVar2.lDO;
            }
            if (iVar.lDP == null) {
                iVar.lDP = iVar2.lDP;
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
        if (ajVar.lDW == null) {
            ajVar.lDW = ajVar2.lDW;
        }
        if (ajVar.lDX == null) {
            ajVar.lDX = ajVar2.lDX;
        }
        if (ajVar.lDY == null) {
            ajVar.lDY = ajVar2.lDY;
        }
        if (ajVar.lDZ == null) {
            ajVar.lDZ = ajVar2.lDZ;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lDE == null) {
            anVar.lDE = anVar2.lDE;
        }
        if (anVar.lDF == null) {
            anVar.lDF = anVar2.lDF;
        }
        if (anVar.lDG == null) {
            anVar.lDG = anVar2.lDG;
        }
        if (anVar.lFq == null) {
            anVar.lFq = anVar2.lFq;
        }
        if (anVar.lFr == null) {
            anVar.lFr = anVar2.lFr;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lFl, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lFB.lCW.lEu = aaVar.lFl.lEZ;
                this.lFB.lFT = aaVar.lFl.lEZ != null;
            }
            if (a(aaVar.lFl, 4294967296L)) {
                this.lFB.lCW.lEw = aaVar.lFl.lFa;
            }
            if (a(aaVar.lFl, 6442450944L)) {
                a(this.lFB, z, this.lFB.lCW.lEu);
                return;
            }
            return;
        }
        if (a(aaVar.lFl, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lFB.lCW.lEx = aaVar.lFl.lEZ;
            this.lFB.lFU = aaVar.lFl.lEZ != null;
        }
        if (a(aaVar.lFl, 4294967296L)) {
            this.lFB.lCW.lEy = aaVar.lFl.lFa;
        }
        if (a(aaVar.lFl, 6442450944L)) {
            a(this.lFB, z, this.lFB.lCW.lEx);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lFj);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lFB.lCW.clipPath != null) {
            SVG.ak NP = ahVar.lFn.NP(this.lFB.lCW.clipPath);
            if (NP == null) {
                k("ClipPath reference '%s' not found", this.lFB.lCW.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) NP;
            if (dVar.UB.isEmpty()) {
                this.lFx.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lDH == null || dVar.lDH.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            diZ();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lDy, aVar.lDz);
                matrix.preScale(aVar.width, aVar.height);
                this.lFx.concat(matrix);
            }
            if (dVar.lDQ != null) {
                this.lFx.concat(dVar.lDQ);
            }
            this.lFB = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.UB) {
                a(akVar, true, path, new Matrix());
            }
            this.lFx.clipPath(path);
            dja();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (diV()) {
            diZ();
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
            dja();
        }
    }

    private void diZ() {
        this.lFx.save();
        this.lFC.push(this.lFB);
        this.lFB = (g) this.lFB.clone();
    }

    private void dja() {
        this.lFx.restore();
        this.lFB = this.lFC.pop();
    }

    private Path.FillType djb() {
        if (this.lFB.lCW.lEX == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFB.lCW.lEX) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lFB, tVar);
        if (diV() && diW()) {
            if (tVar.lDQ != null) {
                matrix.preConcat(tVar.lDQ);
            }
            Path bG = new C0651c(tVar.lEj).bG();
            if (tVar.lFj == null) {
                tVar.lFj = b(bG);
            }
            d((SVG.ah) tVar);
            path.setFillType(djb());
            path.addPath(bG, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lFB, jVar);
        if (diV() && diW()) {
            if (jVar.lDQ != null) {
                matrix.preConcat(jVar.lDQ);
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
        a(this.lFB, baVar);
        if (diV() && diW()) {
            if (baVar.lDQ != null) {
                matrix.preConcat(baVar.lDQ);
            }
            SVG.ak NP = baVar.lFn.NP(baVar.Tl);
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
        a(this.lFB, atVar);
        if (diV()) {
            if (atVar.lDQ != null) {
                matrix.preConcat(atVar.lDQ);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFv == null || atVar.lFv.size() == 0) ? 0.0f : atVar.lFv.get(0).a(this);
            if (atVar.lFw != null && atVar.lFw.size() != 0) {
                f2 = atVar.lFw.get(0).b(this);
            }
            if (this.lFB.lCW.lEN != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lFB.lCW.lEN == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFj == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFj = new SVG.a(hVar.lFY.left, hVar.lFY.top, hVar.lFY.width(), hVar.lFY.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(djb());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class f extends i {
        public Path lFS;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lFS = path;
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
            if (c.this.diW()) {
                Path path = new Path();
                c.this.lFB.jI.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lFS.addPath(path);
            }
            this.x += c.this.lFB.jI.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lDW == null ? 0.0f : oVar.lDW.a(this);
        float b2 = oVar.lDX == null ? 0.0f : oVar.lDX.b(this);
        float a3 = oVar.lDY == null ? 0.0f : oVar.lDY.a(this);
        float b3 = oVar.lDZ != null ? oVar.lDZ.b(this) : 0.0f;
        if (oVar.lFj == null) {
            oVar.lFj = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lDL == null && zVar.lDM == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lDL == null) {
            b2 = zVar.lDM.b(this);
            a2 = b2;
        } else if (zVar.lDM == null) {
            b2 = zVar.lDL.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lDL.a(this);
            b2 = zVar.lDM.b(this);
        }
        float min = Math.min(a2, zVar.lDT.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lDU.b(this) / 2.0f);
        float a3 = zVar.lDR != null ? zVar.lDR.a(this) : 0.0f;
        float b3 = zVar.lDS != null ? zVar.lDS.b(this) : 0.0f;
        float a4 = zVar.lDT.a(this);
        float b4 = zVar.lDU.b(this);
        if (zVar.lFj == null) {
            zVar.lFj = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lDE != null ? cVar.lDE.a(this) : 0.0f;
        float b2 = cVar.lDF != null ? cVar.lDF.b(this) : 0.0f;
        float c = cVar.lDG.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lFj == null) {
            cVar.lFj = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lDE != null ? hVar.lDE.a(this) : 0.0f;
        float b2 = hVar.lDF != null ? hVar.lDF.b(this) : 0.0f;
        float a3 = hVar.lDL.a(this);
        float b3 = hVar.lDM.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lFj == null) {
            hVar.lFj = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lFj == null) {
            xVar.lFj = b(path);
        }
        path.setFillType(djb());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lEp != null && wVar.lEp.booleanValue();
        if (wVar.Tl != null) {
            a(wVar, wVar.Tl);
        }
        if (z) {
            float a2 = wVar.lDR != null ? wVar.lDR.a(this) : 0.0f;
            float b2 = wVar.lDS != null ? wVar.lDS.b(this) : 0.0f;
            float a3 = wVar.lDT != null ? wVar.lDT.a(this) : 0.0f;
            f2 = wVar.lDU != null ? wVar.lDU.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lDR != null ? wVar.lDR.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lDS != null ? wVar.lDS.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lDT != null ? wVar.lDT.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lDU != null ? wVar.lDU.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lFj.width) + ahVar.lFj.lDy;
            float f7 = (a5 * ahVar.lFj.height) + ahVar.lFj.lDz;
            float f8 = a6 * ahVar.lFj.width;
            f2 = a7 * ahVar.lFj.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lFp != null ? wVar.lFp : PreserveAspectRatio.lDl;
            diM();
            this.lFx.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.diB());
            gVar.lCW.lEO = false;
            this.lFB = a(wVar, gVar);
            SVG.a aVar = ahVar.lFj;
            if (wVar.lEr != null) {
                this.lFx.concat(wVar.lEr);
                Matrix matrix = new Matrix();
                if (wVar.lEr.invert(matrix)) {
                    float[] fArr = {ahVar.lFj.lDy, ahVar.lFj.lDz, ahVar.lFj.dix(), ahVar.lFj.lDz, ahVar.lFj.dix(), ahVar.lFj.diy(), ahVar.lFj.lDy, ahVar.lFj.diy()};
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
            float floor = f5 + (((float) Math.floor((aVar.lDy - f5) / f3)) * f3);
            float dix = aVar.dix();
            float diy = aVar.diy();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lDz - f4) / f2)) * f2); floor2 < diy; floor2 += f2) {
                for (float f9 = floor; f9 < dix; f9 += f3) {
                    aVar2.lDy = f9;
                    aVar2.lDz = floor2;
                    diM();
                    if (!this.lFB.lCW.lEO.booleanValue()) {
                        m(aVar2.lDy, aVar2.lDz, aVar2.width, aVar2.height);
                    }
                    if (wVar.lFs != null) {
                        this.lFx.concat(a(aVar2, wVar.lFs, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lEq == null || wVar.lEq.booleanValue();
                        this.lFx.translate(f9, floor2);
                        if (!z2) {
                            this.lFx.scale(ahVar.lFj.width, ahVar.lFj.height);
                        }
                    }
                    boolean diP = diP();
                    for (SVG.ak akVar : wVar.UB) {
                        b(akVar);
                    }
                    if (diP) {
                        b((SVG.ah) wVar);
                    }
                    diN();
                }
            }
            diN();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak NP = wVar.lFn.NP(str);
        if (NP == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(NP instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (NP == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) NP;
            if (wVar.lEp == null) {
                wVar.lEp = wVar2.lEp;
            }
            if (wVar.lEq == null) {
                wVar.lEq = wVar2.lEq;
            }
            if (wVar.lEr == null) {
                wVar.lEr = wVar2.lEr;
            }
            if (wVar.lDR == null) {
                wVar.lDR = wVar2.lDR;
            }
            if (wVar.lDS == null) {
                wVar.lDS = wVar2.lDS;
            }
            if (wVar.lDT == null) {
                wVar.lDT = wVar2.lDT;
            }
            if (wVar.lDU == null) {
                wVar.lDU = wVar2.lDU;
            }
            if (wVar.UB.isEmpty()) {
                wVar.UB = wVar2.UB;
            }
            if (wVar.lFs == null) {
                wVar.lFs = wVar2.lFs;
            }
            if (wVar.lFp == null) {
                wVar.lFp = wVar2.lFp;
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
        if (qVar.lEg != null && qVar.lEg.booleanValue()) {
            f2 = qVar.lDT != null ? qVar.lDT.a(this) : ahVar.lFj.width;
            f3 = qVar.lDU != null ? qVar.lDU.b(this) : ahVar.lFj.height;
            if (qVar.lDR != null) {
                qVar.lDR.a(this);
            } else {
                float f4 = (float) (ahVar.lFj.lDy - (ahVar.lFj.width * 0.1d));
            }
            if (qVar.lDS != null) {
                qVar.lDS.b(this);
            } else {
                float f5 = (float) (ahVar.lFj.lDz - (ahVar.lFj.height * 0.1d));
            }
        } else {
            float a2 = qVar.lDR != null ? qVar.lDR.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lDS != null ? qVar.lDS.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lDT != null ? qVar.lDT.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lDU != null ? qVar.lDU.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lFj.width) + ahVar.lFj.lDy;
            float f7 = ahVar.lFj.lDz + (a3 * ahVar.lFj.height);
            f2 = ahVar.lFj.width * a4;
            f3 = ahVar.lFj.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            diM();
            this.lFB = d((SVG.ak) qVar);
            this.lFB.lCW.lEF = Float.valueOf(1.0f);
            if (!(qVar.lEh == null || qVar.lEh.booleanValue())) {
                this.lFx.translate(ahVar.lFj.lDy, ahVar.lFj.lDz);
                this.lFx.scale(ahVar.lFj.width, ahVar.lFj.height);
            }
            a((SVG.ag) qVar, false);
            diN();
        }
    }
}
