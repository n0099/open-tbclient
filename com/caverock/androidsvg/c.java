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
    private static HashSet<String> lFS = null;
    private Canvas lFI;
    private SVG.a lFJ;
    private float lFK;
    private boolean lFL;
    private g lFM;
    private Stack<g> lFN;
    private Stack<SVG.ag> lFO;
    private Stack<Matrix> lFP;
    private Stack<Canvas> lFQ;
    private Stack<Bitmap> lFR;
    private SVG lFy;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class g implements Cloneable {
        public Paint jI = new Paint();
        public Paint jJ;
        public SVG.Style lDh;
        public SVG.a lFD;
        public boolean lGe;
        public boolean lGf;
        public SVG.a lGg;
        public boolean lGh;
        public boolean lGi;

        public g() {
            this.jI.setFlags(385);
            this.jI.setStyle(Paint.Style.FILL);
            this.jI.setTypeface(Typeface.DEFAULT);
            this.jJ = new Paint();
            this.jJ.setFlags(385);
            this.jJ.setStyle(Paint.Style.STROKE);
            this.jJ.setTypeface(Typeface.DEFAULT);
            this.lDh = SVG.Style.diC();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lDh = (SVG.Style) this.lDh.clone();
                gVar.jI = new Paint(this.jI);
                gVar.jJ = new Paint(this.jJ);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lFM = new g();
        this.lFN = new Stack<>();
        a(this.lFM, SVG.Style.diC());
        this.lFM.lGg = this.lFJ;
        this.lFM.lGh = false;
        this.lFM.lGi = this.lFL;
        this.lFN.push((g) this.lFM.clone());
        this.lFQ = new Stack<>();
        this.lFR = new Stack<>();
        this.lFP = new Stack<>();
        this.lFO = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lFI = canvas;
        this.lFK = f2;
        this.lFJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diJ() {
        return this.lFK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diK() {
        return this.lFM.jI.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float diL() {
        return this.lFM.jI.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a diM() {
        return this.lFM.lFD != null ? this.lFM.lFD : this.lFM.lGg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lFy = svg;
        this.lFL = z;
        SVG.ac diu = svg.diu();
        if (diu == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) diu);
        a(diu, diu.lEe, diu.lEf, aVar != null ? aVar : diu.lFD, preserveAspectRatio != null ? preserveAspectRatio : diu.lFA);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            diN();
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
            diO();
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
            diP();
        }
    }

    private void diN() {
        this.lFI.save();
        this.lFN.push(this.lFM);
        this.lFM = (g) this.lFM.clone();
    }

    private void diO() {
        this.lFI.restore();
        this.lFM = this.lFN.pop();
    }

    private void a(SVG.ag agVar) {
        this.lFO.push(agVar);
        this.lFP.push(this.lFI.getMatrix());
    }

    private void diP() {
        this.lFO.pop();
        this.lFP.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lDh.uY(aiVar.lFz == null);
        if (aiVar.lFw != null) {
            a(gVar, aiVar.lFw);
        }
        if (this.lFy.diw()) {
            for (CSSParser.c cVar : this.lFy.div()) {
                if (CSSParser.a(cVar.lDg, aiVar)) {
                    a(gVar, cVar.lDh);
                }
            }
        }
        if (aiVar.lDh != null) {
            a(gVar, aiVar.lDh);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lFv != null) {
                this.lFM.lGh = aiVar.lFv.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lFM.lDh.lEF instanceof SVG.s) {
            SVG.ak NQ = this.lFy.NQ(((SVG.s) this.lFM.lDh.lEF).Tl);
            if (NQ instanceof SVG.w) {
                a(ahVar, path, (SVG.w) NQ);
                return;
            }
        }
        this.lFI.drawPath(path, this.lFM.jI);
    }

    private void a(Path path) {
        if (this.lFM.lDh.lFo == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lFI.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lFI.setMatrix(new Matrix());
            Shader shader = this.lFM.jJ.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lFI.drawPath(path2, this.lFM.jJ);
            this.lFI.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lFI.drawPath(path, this.lFM.jJ);
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
        a(acVar, acVar.lEe, acVar.lEf);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lFD, acVar.lFA);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lFA != null ? acVar.lFA : PreserveAspectRatio.lDw;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lFM, acVar);
                if (diW()) {
                    if (acVar.lFz != null) {
                        f2 = acVar.lEc != null ? acVar.lEc.a(this) : 0.0f;
                        if (acVar.lEd != null) {
                            f3 = acVar.lEd.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a diM = diM();
                    this.lFM.lGg = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : diM.width, nVar2 != null ? nVar2.b(this) : diM.height);
                    if (!this.lFM.lDh.lEZ.booleanValue()) {
                        m(this.lFM.lGg.lDJ, this.lFM.lGg.lDK, this.lFM.lGg.width, this.lFM.lGg.height);
                    }
                    a(acVar, this.lFM.lGg);
                    if (aVar != null) {
                        this.lFI.concat(a(this.lFM.lGg, aVar, preserveAspectRatio2));
                        this.lFM.lFD = acVar.lFD;
                    } else {
                        this.lFI.translate(f2, f3);
                    }
                    boolean diQ = diQ();
                    diZ();
                    a((SVG.ag) acVar, true);
                    if (diQ) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lFM, kVar);
        if (diW()) {
            if (kVar.lEb != null) {
                this.lFI.concat(kVar.lEb);
            }
            d((SVG.ah) kVar);
            boolean diQ = diQ();
            a((SVG.ag) kVar, true);
            if (diQ) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lFz != null && ahVar.lFu != null) {
            Matrix matrix = new Matrix();
            if (this.lFP.peek().invert(matrix)) {
                float[] fArr = {ahVar.lFu.lDJ, ahVar.lFu.lDK, ahVar.lFu.diy(), ahVar.lFu.lDK, ahVar.lFu.diy(), ahVar.lFu.diz(), ahVar.lFu.lDJ, ahVar.lFu.diz()};
                matrix.preConcat(this.lFI.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lFO.peek();
                if (ahVar2.lFu == null) {
                    ahVar2.lFu = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lFu.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean diQ() {
        if (diR()) {
            this.lFI.saveLayerAlpha(null, bh(this.lFM.lDh.lEQ.floatValue()), 31);
            this.lFN.push(this.lFM);
            this.lFM = (g) this.lFM.clone();
            if (this.lFM.lDh.lFj != null && this.lFM.lGi) {
                SVG.ak NQ = this.lFy.NQ(this.lFM.lDh.lFj);
                if (NQ == null || !(NQ instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lFM.lDh.lFj);
                    this.lFM.lDh.lFj = null;
                    return true;
                }
                this.lFQ.push(this.lFI);
                diS();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lFM.lDh.lFj != null && this.lFM.lGi) {
            SVG.ak NQ = this.lFy.NQ(this.lFM.lDh.lFj);
            diS();
            a((SVG.q) NQ, ahVar);
            Bitmap diT = diT();
            this.lFI = this.lFQ.pop();
            this.lFI.save();
            this.lFI.setMatrix(new Matrix());
            this.lFI.drawBitmap(diT, 0.0f, 0.0f, this.lFM.jI);
            diT.recycle();
            this.lFI.restore();
        }
        diO();
    }

    private boolean diR() {
        if (this.lFM.lDh.lFj != null && !this.lFM.lGi) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lFM.lDh.lEQ.floatValue() < 1.0f || (this.lFM.lDh.lFj != null && this.lFM.lGi);
    }

    private void diS() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lFI.getWidth(), this.lFI.getHeight(), Bitmap.Config.ARGB_8888);
            this.lFR.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lFI.getMatrix());
            this.lFI = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap diT() {
        Bitmap pop = this.lFR.pop();
        Bitmap pop2 = this.lFR.pop();
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
        a(this.lFM, apVar);
        if (diW()) {
            if (apVar.lEb != null) {
                this.lFI.concat(apVar.lEb);
            }
            d((SVG.ah) apVar);
            boolean diQ = diQ();
            b(apVar);
            if (diQ) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> diF;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d dix = this.lFy.dix();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.diE() == null && ((diF = adVar.diF()) == null || (!diF.isEmpty() && diF.contains(language)))) {
                    Set<String> diD = adVar.diD();
                    if (diD != null) {
                        if (lFS == null) {
                            diU();
                        }
                        if (!diD.isEmpty() && lFS.containsAll(diD)) {
                        }
                    }
                    Set<String> diG = adVar.diG();
                    if (diG != null) {
                        if (!diG.isEmpty() && dix != null) {
                            for (String str : diG) {
                                if (!dix.NW(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> diH = adVar.diH();
                    if (diH != null) {
                        if (!diH.isEmpty() && dix != null) {
                            for (String str2 : diH) {
                                if (dix.x(str2, this.lFM.lDh.lEU.intValue(), String.valueOf(this.lFM.lDh.lEV)) == null) {
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

    private static synchronized void diU() {
        synchronized (c.class) {
            lFS = new HashSet<>();
            lFS.add("Structure");
            lFS.add("BasicStructure");
            lFS.add("ConditionalProcessing");
            lFS.add("Image");
            lFS.add("Style");
            lFS.add("ViewportAttribute");
            lFS.add("Shape");
            lFS.add("BasicText");
            lFS.add("PaintAttribute");
            lFS.add("BasicPaintAttribute");
            lFS.add("OpacityAttribute");
            lFS.add("BasicGraphicsAttribute");
            lFS.add("Marker");
            lFS.add("Gradient");
            lFS.add("Pattern");
            lFS.add("Clip");
            lFS.add("BasicClip");
            lFS.add("Mask");
            lFS.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lEe == null || !baVar.lEe.isZero()) {
            if (baVar.lEf == null || !baVar.lEf.isZero()) {
                a(this.lFM, baVar);
                if (diW()) {
                    SVG.ak NQ = baVar.lFy.NQ(baVar.Tl);
                    if (NQ == null) {
                        k("Use reference '%s' not found", baVar.Tl);
                        return;
                    }
                    if (baVar.lEb != null) {
                        this.lFI.concat(baVar.lEb);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lEc != null ? baVar.lEc.a(this) : 0.0f, baVar.lEd != null ? baVar.lEd.b(this) : 0.0f);
                    this.lFI.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean diQ = diQ();
                    a((SVG.ag) baVar);
                    if (NQ instanceof SVG.ac) {
                        diN();
                        SVG.ac acVar = (SVG.ac) NQ;
                        a(acVar, baVar.lEe != null ? baVar.lEe : acVar.lEe, baVar.lEf != null ? baVar.lEf : acVar.lEf);
                        diO();
                    } else if (NQ instanceof SVG.aq) {
                        SVG.n nVar = baVar.lEe != null ? baVar.lEe : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lEf != null ? baVar.lEf : new SVG.n(100.0f, SVG.Unit.percent);
                        diN();
                        a((SVG.aq) NQ, nVar, nVar2);
                        diO();
                    } else {
                        b(NQ);
                    }
                    diP();
                    if (diQ) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lEu != null) {
            a(this.lFM, tVar);
            if (diW() && diX()) {
                if (this.lFM.lGf || this.lFM.lGe) {
                    if (tVar.lEb != null) {
                        this.lFI.concat(tVar.lEb);
                    }
                    Path bG = new C0651c(tVar.lEu).bG();
                    if (tVar.lFu == null) {
                        tVar.lFu = b(bG);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean diQ = diQ();
                    if (this.lFM.lGe) {
                        bG.setFillType(diY());
                        a(tVar, bG);
                    }
                    if (this.lFM.lGf) {
                        a(bG);
                    }
                    a((SVG.j) tVar);
                    if (diQ) {
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
        if (zVar.lEe != null && zVar.lEf != null && !zVar.lEe.isZero() && !zVar.lEf.isZero()) {
            a(this.lFM, zVar);
            if (diW() && diX()) {
                if (zVar.lEb != null) {
                    this.lFI.concat(zVar.lEb);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean diQ = diQ();
                if (this.lFM.lGe) {
                    a(zVar, b2);
                }
                if (this.lFM.lGf) {
                    a(b2);
                }
                if (diQ) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lDR != null && !cVar.lDR.isZero()) {
            a(this.lFM, cVar);
            if (diW() && diX()) {
                if (cVar.lEb != null) {
                    this.lFI.concat(cVar.lEb);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean diQ = diQ();
                if (this.lFM.lGe) {
                    a(cVar, b2);
                }
                if (this.lFM.lGf) {
                    a(b2);
                }
                if (diQ) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lDW != null && hVar.lDX != null && !hVar.lDW.isZero() && !hVar.lDX.isZero()) {
            a(this.lFM, hVar);
            if (diW() && diX()) {
                if (hVar.lEb != null) {
                    this.lFI.concat(hVar.lEb);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean diQ = diQ();
                if (this.lFM.lGe) {
                    a(hVar, b2);
                }
                if (this.lFM.lGf) {
                    a(b2);
                }
                if (diQ) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lFM, oVar);
        if (diW() && diX() && this.lFM.lGf) {
            if (oVar.lEb != null) {
                this.lFI.concat(oVar.lEb);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean diQ = diQ();
            a(c);
            a((SVG.j) oVar);
            if (diQ) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lEh != null ? oVar.lEh.a(this) : 0.0f;
        float b2 = oVar.lEi != null ? oVar.lEi.b(this) : 0.0f;
        float a3 = oVar.lEj != null ? oVar.lEj.a(this) : 0.0f;
        float b3 = oVar.lEk != null ? oVar.lEk.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lFM, xVar);
        if (diW() && diX()) {
            if (this.lFM.lGf || this.lFM.lGe) {
                if (xVar.lEb != null) {
                    this.lFI.concat(xVar.lEb);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean diQ = diQ();
                    if (this.lFM.lGe) {
                        a(xVar, c);
                    }
                    if (this.lFM.lGf) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (diQ) {
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
        a(this.lFM, yVar);
        if (diW() && diX()) {
            if (this.lFM.lGf || this.lFM.lGe) {
                if (yVar.lEb != null) {
                    this.lFI.concat(yVar.lEb);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean diQ = diQ();
                    if (this.lFM.lGe) {
                        a(yVar, c);
                    }
                    if (this.lFM.lGf) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (diQ) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lFM, atVar);
        if (diW()) {
            if (atVar.lEb != null) {
                this.lFI.concat(atVar.lEb);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFG == null || atVar.lFG.size() == 0) ? 0.0f : atVar.lFG.get(0).a(this);
            if (atVar.lFH != null && atVar.lFH.size() != 0) {
                f2 = atVar.lFH.get(0).b(this);
            }
            SVG.Style.TextAnchor diV = diV();
            if (diV != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (diV == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFu == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFu = new SVG.a(hVar.lGj.left, hVar.lGj.top, hVar.lGj.width(), hVar.lGj.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean diQ = diQ();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (diQ) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor diV() {
        if (this.lFM.lDh.lEX == SVG.Style.TextDirection.LTR || this.lFM.lDh.lEY == SVG.Style.TextAnchor.Middle) {
            return this.lFM.lDh.lEY;
        }
        return this.lFM.lDh.lEY == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
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
        public void NU(String str) {
            c.debug("TextSequence render", new Object[0]);
            if (c.this.diX()) {
                if (c.this.lFM.lGe) {
                    c.this.lFI.drawText(str, this.x, this.y, c.this.lFM.jI);
                }
                if (c.this.lFM.lGf) {
                    c.this.lFI.drawText(str, this.x, this.y, c.this.lFM.jJ);
                }
            }
            this.x += c.this.lFM.jI.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public abstract class i {
        public abstract void NU(String str);

        private i() {
        }

        public boolean b(SVG.av avVar) {
            return true;
        }
    }

    private void a(SVG.av avVar, i iVar) {
        if (diW()) {
            Iterator<SVG.ak> it = avVar.UB.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.ak next = it.next();
                if (next instanceof SVG.az) {
                    iVar.NU(n(((SVG.az) next).text, z, !it.hasNext()));
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
                diN();
                a((SVG.aw) akVar);
                diO();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                diN();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lFM, asVar);
                if (diW()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lFG == null || asVar.lFG.size() == 0) ? 0.0f : asVar.lFG.get(0).a(this);
                        if (asVar.lFH != null && asVar.lFH.size() != 0) {
                            f5 = asVar.lFH.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.diI());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean diQ = diQ();
                    a((SVG.av) asVar, iVar);
                    if (diQ) {
                        b((SVG.ah) asVar);
                    }
                }
                diO();
            } else if (akVar instanceof SVG.ar) {
                diN();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lFM, arVar);
                if (diW()) {
                    c((SVG.ah) arVar.diI());
                    SVG.ak NQ = akVar.lFy.NQ(arVar.Tl);
                    if (NQ != null && (NQ instanceof SVG.av)) {
                        StringBuilder sb = new StringBuilder();
                        a((SVG.av) NQ, sb);
                        if (sb.length() > 0) {
                            iVar.NU(sb.toString());
                        }
                    } else {
                        k("Tref reference '%s' not found", arVar.Tl);
                    }
                }
                diO();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lFM, awVar);
        if (diW() && diX()) {
            SVG.ak NQ = awVar.lFy.NQ(awVar.Tl);
            if (NQ == null) {
                k("TextPath reference '%s' not found", awVar.Tl);
                return;
            }
            SVG.t tVar = (SVG.t) NQ;
            Path bG = new C0651c(tVar.lEu).bG();
            if (tVar.lEb != null) {
                bG.transform(tVar.lEb);
            }
            float a2 = awVar.lFF != null ? awVar.lFF.a(this, new PathMeasure(bG, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor diV = diV();
            if (diV != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (diV == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.diI());
            boolean diQ = diQ();
            a((SVG.av) awVar, (i) new d(bG, f2, 0.0f));
            if (diQ) {
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
        public void NU(String str) {
            if (c.this.diX()) {
                if (c.this.lFM.lGe) {
                    c.this.lFI.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFM.jI);
                }
                if (c.this.lFM.lGf) {
                    c.this.lFI.drawTextOnPath(str, this.path, this.x, this.y, c.this.lFM.jJ);
                }
            }
            this.x += c.this.lFM.jI.measureText(str);
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
        public void NU(String str) {
            this.x += c.this.lFM.jI.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class h extends i {
        RectF lGj;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lGj = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak NQ = avVar.lFy.NQ(awVar.Tl);
                if (NQ == null) {
                    c.k("TextPath path reference '%s' not found", awVar.Tl);
                    return false;
                }
                SVG.t tVar = (SVG.t) NQ;
                Path bG = new C0651c(tVar.lEu).bG();
                if (tVar.lEb != null) {
                    bG.transform(tVar.lEb);
                }
                RectF rectF = new RectF();
                bG.computeBounds(rectF, true);
                this.lGj.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NU(String str) {
            if (c.this.diX()) {
                Rect rect = new Rect();
                c.this.lFM.jI.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lGj.union(rectF);
            }
            this.x += c.this.lFM.jI.measureText(str);
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
        if (this.lFM.lGh) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lFA != null ? aqVar.lFA : PreserveAspectRatio.lDw;
                a(this.lFM, aqVar);
                this.lFM.lGg = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lFM.lGg.width, nVar2 != null ? nVar2.a(this) : this.lFM.lGg.height);
                if (!this.lFM.lDh.lEZ.booleanValue()) {
                    m(this.lFM.lGg.lDJ, this.lFM.lGg.lDK, this.lFM.lGg.width, this.lFM.lGg.height);
                }
                if (aqVar.lFD != null) {
                    this.lFI.concat(a(this.lFM.lGg, aqVar.lFD, preserveAspectRatio));
                    this.lFM.lFD = aqVar.lFD;
                }
                boolean diQ = diQ();
                a((SVG.ag) aqVar, true);
                if (diQ) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lEe != null && !mVar.lEe.isZero() && mVar.lEf != null && !mVar.lEf.isZero() && mVar.Tl != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lFA != null ? mVar.lFA : PreserveAspectRatio.lDw;
            Bitmap NT = NT(mVar.Tl);
            if (NT == null) {
                com.caverock.androidsvg.d dix = this.lFy.dix();
                if (dix != null) {
                    bitmap = dix.NV(mVar.Tl);
                } else {
                    return;
                }
            } else {
                bitmap = NT;
            }
            if (bitmap == null) {
                k("Could not locate image '%s'", mVar.Tl);
                return;
            }
            a(this.lFM, mVar);
            if (diW() && diX()) {
                if (mVar.lEb != null) {
                    this.lFI.concat(mVar.lEb);
                }
                this.lFM.lGg = new SVG.a(mVar.lEc != null ? mVar.lEc.a(this) : 0.0f, mVar.lEd != null ? mVar.lEd.b(this) : 0.0f, mVar.lEe.a(this), mVar.lEf.a(this));
                if (!this.lFM.lDh.lEZ.booleanValue()) {
                    m(this.lFM.lGg.lDJ, this.lFM.lGg.lDK, this.lFM.lGg.width, this.lFM.lGg.height);
                }
                mVar.lFu = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lFI.concat(a(this.lFM.lGg, mVar.lFu, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean diQ = diQ();
                diZ();
                this.lFI.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (diQ) {
                    b((SVG.ah) mVar);
                }
            }
        }
    }

    private Bitmap NT(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    private boolean diW() {
        if (this.lFM.lDh.lFe != null) {
            return this.lFM.lDh.lFe.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean diX() {
        if (this.lFM.lDh.lFf != null) {
            return this.lFM.lDh.lFf.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.dir() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lDJ;
        float f5 = -aVar2.lDK;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lDv)) {
            matrix.preTranslate(aVar.lDJ, aVar.lDK);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dis() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.dir()) {
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
        switch (preserveAspectRatio.dir()) {
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
        matrix.preTranslate(aVar.lDJ, aVar.lDK);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lEE & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lDh.lER = style.lER;
        }
        if (a(style, 2048L)) {
            gVar.lDh.lEQ = style.lEQ;
        }
        if (a(style, 1L)) {
            gVar.lDh.lEF = style.lEF;
            gVar.lGe = style.lEF != null;
        }
        if (a(style, 4L)) {
            gVar.lDh.lEH = style.lEH;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lDh.lEF);
        }
        if (a(style, 2L)) {
            gVar.lDh.lEG = style.lEG;
        }
        if (a(style, 8L)) {
            gVar.lDh.lEI = style.lEI;
            gVar.lGf = style.lEI != null;
        }
        if (a(style, 16L)) {
            gVar.lDh.lEJ = style.lEJ;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lDh.lEI);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lDh.lFo = style.lFo;
        }
        if (a(style, 32L)) {
            gVar.lDh.lEK = style.lEK;
            gVar.jJ.setStrokeWidth(gVar.lDh.lEK.c(this));
        }
        if (a(style, 64L)) {
            gVar.lDh.lEL = style.lEL;
            switch (style.lEL) {
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
            gVar.lDh.lEM = style.lEM;
            switch (style.lEM) {
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
            gVar.lDh.lEN = style.lEN;
            gVar.jJ.setStrokeMiter(style.lEN.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lDh.lEO = style.lEO;
        }
        if (a(style, 1024L)) {
            gVar.lDh.lEP = style.lEP;
        }
        if (a(style, 1536L)) {
            if (gVar.lDh.lEO == null) {
                gVar.jJ.setPathEffect(null);
            } else {
                int length = gVar.lDh.lEO.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lDh.lEO[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jJ.setPathEffect(null);
                } else {
                    float c = gVar.lDh.lEP.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jJ.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float diK = diK();
            gVar.lDh.lET = style.lET;
            gVar.jI.setTextSize(style.lET.a(this, diK));
            gVar.jJ.setTextSize(style.lET.a(this, diK));
        }
        if (a(style, 8192L)) {
            gVar.lDh.lES = style.lES;
        }
        if (a(style, 32768L)) {
            if (style.lEU.intValue() == -1 && gVar.lDh.lEU.intValue() > 100) {
                gVar.lDh.lEU = Integer.valueOf(style2.lEU.intValue() - 100);
            } else if (style.lEU.intValue() == 1 && gVar.lDh.lEU.intValue() < 900) {
                SVG.Style style3 = gVar.lDh;
                style3.lEU = Integer.valueOf(style3.lEU.intValue() + 100);
            } else {
                gVar.lDh.lEU = style.lEU;
            }
        }
        if (a(style, 65536L)) {
            gVar.lDh.lEV = style.lEV;
        }
        if (a(style, 106496L)) {
            if (gVar.lDh.lES == null || this.lFy == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d dix = this.lFy.dix();
                typeface = null;
                for (String str : gVar.lDh.lES) {
                    Typeface a2 = a(str, gVar.lDh.lEU, gVar.lDh.lEV);
                    if (a2 != null || dix == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = dix.x(str, gVar.lDh.lEU.intValue(), String.valueOf(gVar.lDh.lEV));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lDh.lEU, gVar.lDh.lEV);
            }
            gVar.jI.setTypeface(typeface);
            gVar.jJ.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lDh.lEW = style.lEW;
            gVar.jI.setStrikeThruText(style.lEW == SVG.Style.TextDecoration.LineThrough);
            gVar.jI.setUnderlineText(style.lEW == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jJ.setStrikeThruText(style.lEW == SVG.Style.TextDecoration.LineThrough);
                gVar.jJ.setUnderlineText(style.lEW == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lDh.lEX = style.lEX;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lDh.lEY = style.lEY;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lDh.lEZ = style.lEZ;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lDh.lFb = style.lFb;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lDh.lFc = style.lFc;
        }
        if (a(style, 8388608L)) {
            gVar.lDh.lFd = style.lFd;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lDh.lFe = style.lFe;
        }
        if (a(style, 33554432L)) {
            gVar.lDh.lFf = style.lFf;
        }
        if (a(style, 1048576L)) {
            gVar.lDh.lFa = style.lFa;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lDh.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lDh.lFi = style.lFi;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lDh.lFj = style.lFj;
        }
        if (a(style, 67108864L)) {
            gVar.lDh.lFg = style.lFg;
        }
        if (a(style, 134217728L)) {
            gVar.lDh.lFh = style.lFh;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lDh.lFm = style.lFm;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lDh.lFn = style.lFn;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lDh.lEH : gVar.lDh.lEJ).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lDT;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lDh.lER.lDT;
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

    private Path.FillType diY() {
        if (this.lFM.lDh.lEG == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFM.lDh.lEG) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lFM.lDh.lFa != null) {
            f2 += this.lFM.lDh.lFa.lDO.a(this);
            f3 += this.lFM.lDh.lFa.lDL.b(this);
            f6 -= this.lFM.lDh.lFa.lDM.a(this);
            f7 -= this.lFM.lDh.lFa.lDN.b(this);
        }
        this.lFI.clipRect(f2, f3, f6, f7);
    }

    private void diZ() {
        int i2;
        if (this.lFM.lDh.lFm instanceof SVG.e) {
            i2 = ((SVG.e) this.lFM.lDh.lFm).lDT;
        } else if (this.lFM.lDh.lFm instanceof SVG.f) {
            i2 = this.lFM.lDh.lER.lDT;
        } else {
            return;
        }
        if (this.lFM.lDh.lFn != null) {
            i2 |= bh(this.lFM.lDh.lFn.floatValue()) << 24;
        }
        this.lFI.drawColor(i2);
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
        public float gsn;
        public float gso;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.gsn = 0.0f;
            this.gso = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gsn = (float) (f3 / sqrt);
                this.gso = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gsn = ((float) (f3 / sqrt)) + this.gsn;
                this.gso += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.gsn += bVar.gsn;
            this.gso += bVar.gso;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.gsn + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gso + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements SVG.v {
        private List<b> bzO = new ArrayList();
        private b lFX = null;
        private boolean lFY = false;
        private boolean lFZ = true;
        private int lGa = -1;
        private boolean lGb;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lGb) {
                    this.lFX.a(this.bzO.get(this.lGa));
                    this.bzO.set(this.lGa, this.lFX);
                    this.lGb = false;
                }
                if (this.lFX != null) {
                    this.bzO.add(this.lFX);
                }
            }
        }

        public List<b> djd() {
            return this.bzO;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lGb) {
                this.lFX.a(this.bzO.get(this.lGa));
                this.bzO.set(this.lGa, this.lFX);
                this.lGb = false;
            }
            if (this.lFX != null) {
                this.bzO.add(this.lFX);
            }
            this.startX = f;
            this.startY = f2;
            this.lFX = new b(f, f2, 0.0f, 0.0f);
            this.lGa = this.bzO.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lFX.C(f, f2);
            this.bzO.add(this.lFX);
            this.lFX = new b(f, f2, f - this.lFX.x, f2 - this.lFX.y);
            this.lGb = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lFZ || this.lFY) {
                this.lFX.C(f, f2);
                this.bzO.add(this.lFX);
                this.lFY = false;
            }
            this.lFX = new b(f5, f6, f5 - f3, f6 - f4);
            this.lGb = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lFX.C(f, f2);
            this.bzO.add(this.lFX);
            this.lFX = new b(f3, f4, f3 - f, f4 - f2);
            this.lGb = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lFY = true;
            this.lFZ = false;
            c.a(this.lFX.x, this.lFX.y, f, f2, f3, z, z2, f4, f5, this);
            this.lFZ = true;
            this.lGb = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bzO.add(this.lFX);
            B(this.startX, this.startY);
            this.lGb = true;
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
        if (this.lFM.lDh.lFb != null || this.lFM.lDh.lFc != null || this.lFM.lDh.lFd != null) {
            if (this.lFM.lDh.lFb != null) {
                SVG.ak NQ = jVar.lFy.NQ(this.lFM.lDh.lFb);
                if (NQ != null) {
                    pVar = (SVG.p) NQ;
                    if (this.lFM.lDh.lFc != null) {
                        SVG.ak NQ2 = jVar.lFy.NQ(this.lFM.lDh.lFc);
                        if (NQ2 != null) {
                            pVar2 = (SVG.p) NQ2;
                            if (this.lFM.lDh.lFd != null) {
                                SVG.ak NQ3 = jVar.lFy.NQ(this.lFM.lDh.lFd);
                                if (NQ3 != null) {
                                    pVar3 = (SVG.p) NQ3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lEu).djd();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lFM.lDh;
                                        SVG.Style style2 = this.lFM.lDh;
                                        this.lFM.lDh.lFd = null;
                                        style2.lFc = null;
                                        style.lFb = null;
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
                                k("Marker reference '%s' not found", this.lFM.lDh.lFd);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lFM.lDh.lFc);
                    }
                    pVar2 = null;
                    if (this.lFM.lDh.lFd != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lFM.lDh.lFb);
                }
            }
            pVar = null;
            if (this.lFM.lDh.lFc != null) {
            }
            pVar2 = null;
            if (this.lFM.lDh.lFd != null) {
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
        boolean diQ;
        float f3;
        float f4 = 0.0f;
        diN();
        if (pVar.lEq != null) {
            if (Float.isNaN(pVar.lEq.floatValue())) {
                if (bVar.gsn != 0.0f || bVar.gso != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.gso, bVar.gsn));
                }
            } else {
                f2 = pVar.lEq.floatValue();
            }
            float bg = !pVar.lEl ? 1.0f : this.lFM.lDh.lEK.bg(this.lFK);
            this.lFM = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bg, bg);
            float a2 = pVar.lEm == null ? pVar.lEm.a(this) : 0.0f;
            float b2 = pVar.lEn == null ? pVar.lEn.b(this) : 0.0f;
            float a3 = pVar.lEo == null ? pVar.lEo.a(this) : 3.0f;
            float b3 = pVar.lEp != null ? pVar.lEp.b(this) : 3.0f;
            if (pVar.lFD == null) {
                float f5 = a3 / pVar.lFD.width;
                float f6 = b3 / pVar.lFD.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lFA != null ? pVar.lFA : PreserveAspectRatio.lDw;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lDv)) {
                    f6 = preserveAspectRatio.dis() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lFI.concat(matrix);
                float f7 = pVar.lFD.width * f5;
                float f8 = pVar.lFD.height * f6;
                switch (preserveAspectRatio.dir()) {
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
                switch (preserveAspectRatio.dir()) {
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
                if (!this.lFM.lDh.lEZ.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lFI.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lFI.concat(matrix);
                if (!this.lFM.lDh.lEZ.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            diQ = diQ();
            a((SVG.ag) pVar, false);
            if (diQ) {
                b((SVG.ah) pVar);
            }
            diO();
        }
        f2 = 0.0f;
        if (!pVar.lEl) {
        }
        this.lFM = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bg, bg);
        if (pVar.lEm == null) {
        }
        if (pVar.lEn == null) {
        }
        if (pVar.lEo == null) {
        }
        if (pVar.lEp != null) {
        }
        if (pVar.lFD == null) {
        }
        diQ = diQ();
        a((SVG.ag) pVar, false);
        if (diQ) {
        }
        diO();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.diC());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lFz == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lFz;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lFD = this.lFy.diu().lFD;
        if (gVar.lFD == null) {
            gVar.lFD = this.lFJ;
        }
        gVar.lGg = this.lFJ;
        gVar.lGi = this.lFM.lGi;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lFM.lDh.lEF instanceof SVG.s) {
            a(true, ahVar.lFu, (SVG.s) this.lFM.lDh.lEF);
        }
        if (this.lFM.lDh.lEI instanceof SVG.s) {
            a(false, ahVar.lFu, (SVG.s) this.lFM.lDh.lEI);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak NQ = this.lFy.NQ(sVar.Tl);
        if (NQ == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.Tl;
            k("%s reference '%s' not found", objArr);
            if (sVar.lEt != null) {
                a(this.lFM, z, sVar.lEt);
                return;
            } else if (z) {
                this.lFM.lGe = false;
                return;
            } else {
                this.lFM.lGf = false;
                return;
            }
        }
        if (NQ instanceof SVG.aj) {
            a(z, aVar, (SVG.aj) NQ);
        }
        if (NQ instanceof SVG.an) {
            a(z, aVar, (SVG.an) NQ);
        }
        if (NQ instanceof SVG.aa) {
            a(z, (SVG.aa) NQ);
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
        boolean z2 = ajVar.lDY != null && ajVar.lDY.booleanValue();
        Paint paint = z ? this.lFM.jI : this.lFM.jJ;
        if (z2) {
            SVG.a diM = diM();
            float a3 = ajVar.lEh != null ? ajVar.lEh.a(this) : 0.0f;
            float b2 = ajVar.lEi != null ? ajVar.lEi.b(this) : 0.0f;
            float a4 = ajVar.lEj != null ? ajVar.lEj.a(this) : diM.width;
            a2 = ajVar.lEk != null ? ajVar.lEk.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lEh != null ? ajVar.lEh.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lEi != null ? ajVar.lEi.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lEj != null ? ajVar.lEj.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lEk != null ? ajVar.lEk.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        diN();
        this.lFM = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDJ, aVar.lDK);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lDZ != null) {
            matrix.preConcat(ajVar.lDZ);
        }
        int size = ajVar.UB.size();
        if (size == 0) {
            diO();
            if (z) {
                this.lFM.lGe = false;
                return;
            } else {
                this.lFM.lGf = false;
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
            if (i2 == 0 || abVar.lED.floatValue() >= f5) {
                fArr[i2] = abVar.lED.floatValue();
                f5 = abVar.lED.floatValue();
            } else {
                fArr[i2] = f5;
            }
            diN();
            a(this.lFM, abVar);
            SVG.e eVar = (SVG.e) this.lFM.lDh.lFg;
            if (eVar == null) {
                eVar = SVG.e.lDU;
            }
            iArr[i2] = eVar.lDT | (bh(this.lFM.lDh.lFh.floatValue()) << 24);
            diO();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            diO();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lEa != null) {
            if (ajVar.lEa == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lEa == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diO();
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
        boolean z2 = anVar.lDY != null && anVar.lDY.booleanValue();
        Paint paint = z ? this.lFM.jI : this.lFM.jJ;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lDP != null ? anVar.lDP.a(this) : nVar.a(this);
            float b2 = anVar.lDQ != null ? anVar.lDQ.b(this) : nVar.b(this);
            a2 = anVar.lDR != null ? anVar.lDR.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lDP != null ? anVar.lDP.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lDQ != null ? anVar.lDQ.a(this, 1.0f) : 0.5f;
            a2 = anVar.lDR != null ? anVar.lDR.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        diN();
        this.lFM = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lDJ, aVar.lDK);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lDZ != null) {
            matrix.preConcat(anVar.lDZ);
        }
        int size = anVar.UB.size();
        if (size == 0) {
            diO();
            if (z) {
                this.lFM.lGe = false;
                return;
            } else {
                this.lFM.lGf = false;
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
            if (i2 == 0 || abVar.lED.floatValue() >= f4) {
                fArr[i2] = abVar.lED.floatValue();
                f4 = abVar.lED.floatValue();
            } else {
                fArr[i2] = f4;
            }
            diN();
            a(this.lFM, abVar);
            SVG.e eVar = (SVG.e) this.lFM.lDh.lFg;
            if (eVar == null) {
                eVar = SVG.e.lDU;
            }
            iArr[i2] = eVar.lDT | (bh(this.lFM.lDh.lFh.floatValue()) << 24);
            diO();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            diO();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lEa != null) {
            if (anVar.lEa == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lEa == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        diO();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak NQ = iVar.lFy.NQ(str);
        if (NQ == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(NQ instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (NQ == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) NQ;
            if (iVar.lDY == null) {
                iVar.lDY = iVar2.lDY;
            }
            if (iVar.lDZ == null) {
                iVar.lDZ = iVar2.lDZ;
            }
            if (iVar.lEa == null) {
                iVar.lEa = iVar2.lEa;
            }
            if (iVar.UB.isEmpty()) {
                iVar.UB = iVar2.UB;
            }
            try {
                if (iVar instanceof SVG.aj) {
                    a((SVG.aj) iVar, (SVG.aj) NQ);
                } else {
                    a((SVG.an) iVar, (SVG.an) NQ);
                }
            } catch (ClassCastException e2) {
            }
            if (iVar2.Tl != null) {
                a(iVar, iVar2.Tl);
            }
        }
    }

    private void a(SVG.aj ajVar, SVG.aj ajVar2) {
        if (ajVar.lEh == null) {
            ajVar.lEh = ajVar2.lEh;
        }
        if (ajVar.lEi == null) {
            ajVar.lEi = ajVar2.lEi;
        }
        if (ajVar.lEj == null) {
            ajVar.lEj = ajVar2.lEj;
        }
        if (ajVar.lEk == null) {
            ajVar.lEk = ajVar2.lEk;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lDP == null) {
            anVar.lDP = anVar2.lDP;
        }
        if (anVar.lDQ == null) {
            anVar.lDQ = anVar2.lDQ;
        }
        if (anVar.lDR == null) {
            anVar.lDR = anVar2.lDR;
        }
        if (anVar.lFB == null) {
            anVar.lFB = anVar2.lFB;
        }
        if (anVar.lFC == null) {
            anVar.lFC = anVar2.lFC;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lFw, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lFM.lDh.lEF = aaVar.lFw.lFk;
                this.lFM.lGe = aaVar.lFw.lFk != null;
            }
            if (a(aaVar.lFw, 4294967296L)) {
                this.lFM.lDh.lEH = aaVar.lFw.lFl;
            }
            if (a(aaVar.lFw, 6442450944L)) {
                a(this.lFM, z, this.lFM.lDh.lEF);
                return;
            }
            return;
        }
        if (a(aaVar.lFw, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lFM.lDh.lEI = aaVar.lFw.lFk;
            this.lFM.lGf = aaVar.lFw.lFk != null;
        }
        if (a(aaVar.lFw, 4294967296L)) {
            this.lFM.lDh.lEJ = aaVar.lFw.lFl;
        }
        if (a(aaVar.lFw, 6442450944L)) {
            a(this.lFM, z, this.lFM.lDh.lEI);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lFu);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lFM.lDh.clipPath != null) {
            SVG.ak NQ = ahVar.lFy.NQ(this.lFM.lDh.clipPath);
            if (NQ == null) {
                k("ClipPath reference '%s' not found", this.lFM.lDh.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) NQ;
            if (dVar.UB.isEmpty()) {
                this.lFI.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lDS == null || dVar.lDS.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            dja();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lDJ, aVar.lDK);
                matrix.preScale(aVar.width, aVar.height);
                this.lFI.concat(matrix);
            }
            if (dVar.lEb != null) {
                this.lFI.concat(dVar.lEb);
            }
            this.lFM = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.UB) {
                a(akVar, true, path, new Matrix());
            }
            this.lFI.clipPath(path);
            djb();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (diW()) {
            dja();
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
            djb();
        }
    }

    private void dja() {
        this.lFI.save();
        this.lFN.push(this.lFM);
        this.lFM = (g) this.lFM.clone();
    }

    private void djb() {
        this.lFI.restore();
        this.lFM = this.lFN.pop();
    }

    private Path.FillType djc() {
        if (this.lFM.lDh.lFi == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lFM.lDh.lFi) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lFM, tVar);
        if (diW() && diX()) {
            if (tVar.lEb != null) {
                matrix.preConcat(tVar.lEb);
            }
            Path bG = new C0651c(tVar.lEu).bG();
            if (tVar.lFu == null) {
                tVar.lFu = b(bG);
            }
            d((SVG.ah) tVar);
            path.setFillType(djc());
            path.addPath(bG, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lFM, jVar);
        if (diW() && diX()) {
            if (jVar.lEb != null) {
                matrix.preConcat(jVar.lEb);
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
        a(this.lFM, baVar);
        if (diW() && diX()) {
            if (baVar.lEb != null) {
                matrix.preConcat(baVar.lEb);
            }
            SVG.ak NQ = baVar.lFy.NQ(baVar.Tl);
            if (NQ == null) {
                k("Use reference '%s' not found", baVar.Tl);
                return;
            }
            d((SVG.ah) baVar);
            a(NQ, false, path, matrix);
        }
    }

    private void a(SVG.at atVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        a(this.lFM, atVar);
        if (diW()) {
            if (atVar.lEb != null) {
                matrix.preConcat(atVar.lEb);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lFG == null || atVar.lFG.size() == 0) ? 0.0f : atVar.lFG.get(0).a(this);
            if (atVar.lFH != null && atVar.lFH.size() != 0) {
                f2 = atVar.lFH.get(0).b(this);
            }
            if (this.lFM.lDh.lEY != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lFM.lDh.lEY == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lFu == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lFu = new SVG.a(hVar.lGj.left, hVar.lGj.top, hVar.lGj.width(), hVar.lGj.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(djc());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class f extends i {
        public Path lGd;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lGd = path;
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
        public void NU(String str) {
            if (c.this.diX()) {
                Path path = new Path();
                c.this.lFM.jI.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lGd.addPath(path);
            }
            this.x += c.this.lFM.jI.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lEh == null ? 0.0f : oVar.lEh.a(this);
        float b2 = oVar.lEi == null ? 0.0f : oVar.lEi.b(this);
        float a3 = oVar.lEj == null ? 0.0f : oVar.lEj.a(this);
        float b3 = oVar.lEk != null ? oVar.lEk.b(this) : 0.0f;
        if (oVar.lFu == null) {
            oVar.lFu = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lDW == null && zVar.lDX == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lDW == null) {
            b2 = zVar.lDX.b(this);
            a2 = b2;
        } else if (zVar.lDX == null) {
            b2 = zVar.lDW.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lDW.a(this);
            b2 = zVar.lDX.b(this);
        }
        float min = Math.min(a2, zVar.lEe.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lEf.b(this) / 2.0f);
        float a3 = zVar.lEc != null ? zVar.lEc.a(this) : 0.0f;
        float b3 = zVar.lEd != null ? zVar.lEd.b(this) : 0.0f;
        float a4 = zVar.lEe.a(this);
        float b4 = zVar.lEf.b(this);
        if (zVar.lFu == null) {
            zVar.lFu = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lDP != null ? cVar.lDP.a(this) : 0.0f;
        float b2 = cVar.lDQ != null ? cVar.lDQ.b(this) : 0.0f;
        float c = cVar.lDR.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lFu == null) {
            cVar.lFu = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lDP != null ? hVar.lDP.a(this) : 0.0f;
        float b2 = hVar.lDQ != null ? hVar.lDQ.b(this) : 0.0f;
        float a3 = hVar.lDW.a(this);
        float b3 = hVar.lDX.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lFu == null) {
            hVar.lFu = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lFu == null) {
            xVar.lFu = b(path);
        }
        path.setFillType(djc());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lEA != null && wVar.lEA.booleanValue();
        if (wVar.Tl != null) {
            a(wVar, wVar.Tl);
        }
        if (z) {
            float a2 = wVar.lEc != null ? wVar.lEc.a(this) : 0.0f;
            float b2 = wVar.lEd != null ? wVar.lEd.b(this) : 0.0f;
            float a3 = wVar.lEe != null ? wVar.lEe.a(this) : 0.0f;
            f2 = wVar.lEf != null ? wVar.lEf.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lEc != null ? wVar.lEc.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lEd != null ? wVar.lEd.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lEe != null ? wVar.lEe.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lEf != null ? wVar.lEf.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lFu.width) + ahVar.lFu.lDJ;
            float f7 = (a5 * ahVar.lFu.height) + ahVar.lFu.lDK;
            float f8 = a6 * ahVar.lFu.width;
            f2 = a7 * ahVar.lFu.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lFA != null ? wVar.lFA : PreserveAspectRatio.lDw;
            diN();
            this.lFI.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.diC());
            gVar.lDh.lEZ = false;
            this.lFM = a(wVar, gVar);
            SVG.a aVar = ahVar.lFu;
            if (wVar.lEC != null) {
                this.lFI.concat(wVar.lEC);
                Matrix matrix = new Matrix();
                if (wVar.lEC.invert(matrix)) {
                    float[] fArr = {ahVar.lFu.lDJ, ahVar.lFu.lDK, ahVar.lFu.diy(), ahVar.lFu.lDK, ahVar.lFu.diy(), ahVar.lFu.diz(), ahVar.lFu.lDJ, ahVar.lFu.diz()};
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
            float floor = f5 + (((float) Math.floor((aVar.lDJ - f5) / f3)) * f3);
            float diy = aVar.diy();
            float diz = aVar.diz();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lDK - f4) / f2)) * f2); floor2 < diz; floor2 += f2) {
                for (float f9 = floor; f9 < diy; f9 += f3) {
                    aVar2.lDJ = f9;
                    aVar2.lDK = floor2;
                    diN();
                    if (!this.lFM.lDh.lEZ.booleanValue()) {
                        m(aVar2.lDJ, aVar2.lDK, aVar2.width, aVar2.height);
                    }
                    if (wVar.lFD != null) {
                        this.lFI.concat(a(aVar2, wVar.lFD, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lEB == null || wVar.lEB.booleanValue();
                        this.lFI.translate(f9, floor2);
                        if (!z2) {
                            this.lFI.scale(ahVar.lFu.width, ahVar.lFu.height);
                        }
                    }
                    boolean diQ = diQ();
                    for (SVG.ak akVar : wVar.UB) {
                        b(akVar);
                    }
                    if (diQ) {
                        b((SVG.ah) wVar);
                    }
                    diO();
                }
            }
            diO();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak NQ = wVar.lFy.NQ(str);
        if (NQ == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(NQ instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (NQ == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) NQ;
            if (wVar.lEA == null) {
                wVar.lEA = wVar2.lEA;
            }
            if (wVar.lEB == null) {
                wVar.lEB = wVar2.lEB;
            }
            if (wVar.lEC == null) {
                wVar.lEC = wVar2.lEC;
            }
            if (wVar.lEc == null) {
                wVar.lEc = wVar2.lEc;
            }
            if (wVar.lEd == null) {
                wVar.lEd = wVar2.lEd;
            }
            if (wVar.lEe == null) {
                wVar.lEe = wVar2.lEe;
            }
            if (wVar.lEf == null) {
                wVar.lEf = wVar2.lEf;
            }
            if (wVar.UB.isEmpty()) {
                wVar.UB = wVar2.UB;
            }
            if (wVar.lFD == null) {
                wVar.lFD = wVar2.lFD;
            }
            if (wVar.lFA == null) {
                wVar.lFA = wVar2.lFA;
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
        if (qVar.lEr != null && qVar.lEr.booleanValue()) {
            f2 = qVar.lEe != null ? qVar.lEe.a(this) : ahVar.lFu.width;
            f3 = qVar.lEf != null ? qVar.lEf.b(this) : ahVar.lFu.height;
            if (qVar.lEc != null) {
                qVar.lEc.a(this);
            } else {
                float f4 = (float) (ahVar.lFu.lDJ - (ahVar.lFu.width * 0.1d));
            }
            if (qVar.lEd != null) {
                qVar.lEd.b(this);
            } else {
                float f5 = (float) (ahVar.lFu.lDK - (ahVar.lFu.height * 0.1d));
            }
        } else {
            float a2 = qVar.lEc != null ? qVar.lEc.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lEd != null ? qVar.lEd.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lEe != null ? qVar.lEe.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lEf != null ? qVar.lEf.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lFu.width) + ahVar.lFu.lDJ;
            float f7 = ahVar.lFu.lDK + (a3 * ahVar.lFu.height);
            f2 = ahVar.lFu.width * a4;
            f3 = ahVar.lFu.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            diN();
            this.lFM = d((SVG.ak) qVar);
            this.lFM.lDh.lEQ = Float.valueOf(1.0f);
            if (!(qVar.lEs == null || qVar.lEs.booleanValue())) {
                this.lFI.translate(ahVar.lFu.lDJ, ahVar.lFu.lDK);
                this.lFI.scale(ahVar.lFu.width, ahVar.lFu.height);
            }
            a((SVG.ag) qVar, false);
            diO();
        }
    }
}
