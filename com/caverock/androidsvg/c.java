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
    private static HashSet<String> lHw = null;
    private SVG lHc;
    private Canvas lHm;
    private SVG.a lHn;
    private float lHo;
    private boolean lHp;
    private g lHq;
    private Stack<g> lHr;
    private Stack<SVG.ag> lHs;
    private Stack<Matrix> lHt;
    private Stack<Canvas> lHu;
    private Stack<Bitmap> lHv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class g implements Cloneable {
        public Paint jH = new Paint();
        public Paint jI;
        public SVG.Style lEL;
        public boolean lHK;
        public boolean lHL;
        public SVG.a lHM;
        public boolean lHN;
        public boolean lHO;
        public SVG.a lHh;

        public g() {
            this.jH.setFlags(385);
            this.jH.setStyle(Paint.Style.FILL);
            this.jH.setTypeface(Typeface.DEFAULT);
            this.jI = new Paint();
            this.jI.setFlags(385);
            this.jI.setStyle(Paint.Style.STROKE);
            this.jI.setTypeface(Typeface.DEFAULT);
            this.lEL = SVG.Style.diZ();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lEL = (SVG.Style) this.lEL.clone();
                gVar.jH = new Paint(this.jH);
                gVar.jI = new Paint(this.jI);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lHq = new g();
        this.lHr = new Stack<>();
        a(this.lHq, SVG.Style.diZ());
        this.lHq.lHM = this.lHn;
        this.lHq.lHN = false;
        this.lHq.lHO = this.lHp;
        this.lHr.push((g) this.lHq.clone());
        this.lHu = new Stack<>();
        this.lHv = new Stack<>();
        this.lHt = new Stack<>();
        this.lHs = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lHm = canvas;
        this.lHo = f2;
        this.lHn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float djg() {
        return this.lHo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float djh() {
        return this.lHq.jH.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dji() {
        return this.lHq.jH.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a djj() {
        return this.lHq.lHh != null ? this.lHq.lHh : this.lHq.lHM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lHc = svg;
        this.lHp = z;
        SVG.ac diR = svg.diR();
        if (diR == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) diR);
        a(diR, diR.lFI, diR.lFJ, aVar != null ? aVar : diR.lHh, preserveAspectRatio != null ? preserveAspectRatio : diR.lHe);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            djk();
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
            djl();
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
            djm();
        }
    }

    private void djk() {
        this.lHm.save();
        this.lHr.push(this.lHq);
        this.lHq = (g) this.lHq.clone();
    }

    private void djl() {
        this.lHm.restore();
        this.lHq = this.lHr.pop();
    }

    private void a(SVG.ag agVar) {
        this.lHs.push(agVar);
        this.lHt.push(this.lHm.getMatrix());
    }

    private void djm() {
        this.lHs.pop();
        this.lHt.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lEL.vf(aiVar.lHd == null);
        if (aiVar.lHa != null) {
            a(gVar, aiVar.lHa);
        }
        if (this.lHc.diT()) {
            for (CSSParser.c cVar : this.lHc.diS()) {
                if (CSSParser.a(cVar.lEK, aiVar)) {
                    a(gVar, cVar.lEL);
                }
            }
        }
        if (aiVar.lEL != null) {
            a(gVar, aiVar.lEL);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lGZ != null) {
                this.lHq.lHN = aiVar.lGZ.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lHq.lEL.lGj instanceof SVG.s) {
            SVG.ak NP = this.lHc.NP(((SVG.s) this.lHq.lEL.lGj).Tv);
            if (NP instanceof SVG.w) {
                a(ahVar, path, (SVG.w) NP);
                return;
            }
        }
        this.lHm.drawPath(path, this.lHq.jH);
    }

    private void a(Path path) {
        if (this.lHq.lEL.lGS == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lHm.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lHm.setMatrix(new Matrix());
            Shader shader = this.lHq.jI.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lHm.drawPath(path2, this.lHq.jI);
            this.lHm.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lHm.drawPath(path, this.lHq.jI);
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
        a(acVar, acVar.lFI, acVar.lFJ);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lHh, acVar.lHe);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lHe != null ? acVar.lHe : PreserveAspectRatio.lFa;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lHq, acVar);
                if (djt()) {
                    if (acVar.lHd != null) {
                        f2 = acVar.lFG != null ? acVar.lFG.a(this) : 0.0f;
                        if (acVar.lFH != null) {
                            f3 = acVar.lFH.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a djj = djj();
                    this.lHq.lHM = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : djj.width, nVar2 != null ? nVar2.b(this) : djj.height);
                    if (!this.lHq.lEL.lGD.booleanValue()) {
                        m(this.lHq.lHM.lFn, this.lHq.lHM.lFo, this.lHq.lHM.width, this.lHq.lHM.height);
                    }
                    a(acVar, this.lHq.lHM);
                    if (aVar != null) {
                        this.lHm.concat(a(this.lHq.lHM, aVar, preserveAspectRatio2));
                        this.lHq.lHh = acVar.lHh;
                    } else {
                        this.lHm.translate(f2, f3);
                    }
                    boolean djn = djn();
                    djw();
                    a((SVG.ag) acVar, true);
                    if (djn) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lHq, kVar);
        if (djt()) {
            if (kVar.lFF != null) {
                this.lHm.concat(kVar.lFF);
            }
            d((SVG.ah) kVar);
            boolean djn = djn();
            a((SVG.ag) kVar, true);
            if (djn) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lHd != null && ahVar.lGY != null) {
            Matrix matrix = new Matrix();
            if (this.lHt.peek().invert(matrix)) {
                float[] fArr = {ahVar.lGY.lFn, ahVar.lGY.lFo, ahVar.lGY.diV(), ahVar.lGY.lFo, ahVar.lGY.diV(), ahVar.lGY.diW(), ahVar.lGY.lFn, ahVar.lGY.diW()};
                matrix.preConcat(this.lHm.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lHs.peek();
                if (ahVar2.lGY == null) {
                    ahVar2.lGY = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lGY.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean djn() {
        if (djo()) {
            this.lHm.saveLayerAlpha(null, bh(this.lHq.lEL.lGu.floatValue()), 31);
            this.lHr.push(this.lHq);
            this.lHq = (g) this.lHq.clone();
            if (this.lHq.lEL.lGN != null && this.lHq.lHO) {
                SVG.ak NP = this.lHc.NP(this.lHq.lEL.lGN);
                if (NP == null || !(NP instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lHq.lEL.lGN);
                    this.lHq.lEL.lGN = null;
                    return true;
                }
                this.lHu.push(this.lHm);
                djp();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lHq.lEL.lGN != null && this.lHq.lHO) {
            SVG.ak NP = this.lHc.NP(this.lHq.lEL.lGN);
            djp();
            a((SVG.q) NP, ahVar);
            Bitmap djq = djq();
            this.lHm = this.lHu.pop();
            this.lHm.save();
            this.lHm.setMatrix(new Matrix());
            this.lHm.drawBitmap(djq, 0.0f, 0.0f, this.lHq.jH);
            djq.recycle();
            this.lHm.restore();
        }
        djl();
    }

    private boolean djo() {
        if (this.lHq.lEL.lGN != null && !this.lHq.lHO) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lHq.lEL.lGu.floatValue() < 1.0f || (this.lHq.lEL.lGN != null && this.lHq.lHO);
    }

    private void djp() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lHm.getWidth(), this.lHm.getHeight(), Bitmap.Config.ARGB_8888);
            this.lHv.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lHm.getMatrix());
            this.lHm = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap djq() {
        Bitmap pop = this.lHv.pop();
        Bitmap pop2 = this.lHv.pop();
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
        a(this.lHq, apVar);
        if (djt()) {
            if (apVar.lFF != null) {
                this.lHm.concat(apVar.lFF);
            }
            d((SVG.ah) apVar);
            boolean djn = djn();
            b(apVar);
            if (djn) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> djc;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d diU = this.lHc.diU();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.djb() == null && ((djc = adVar.djc()) == null || (!djc.isEmpty() && djc.contains(language)))) {
                    Set<String> dja = adVar.dja();
                    if (dja != null) {
                        if (lHw == null) {
                            djr();
                        }
                        if (!dja.isEmpty() && lHw.containsAll(dja)) {
                        }
                    }
                    Set<String> djd = adVar.djd();
                    if (djd != null) {
                        if (!djd.isEmpty() && diU != null) {
                            for (String str : djd) {
                                if (!diU.NV(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> dje = adVar.dje();
                    if (dje != null) {
                        if (!dje.isEmpty() && diU != null) {
                            for (String str2 : dje) {
                                if (diU.x(str2, this.lHq.lEL.lGy.intValue(), String.valueOf(this.lHq.lEL.lGz)) == null) {
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

    private static synchronized void djr() {
        synchronized (c.class) {
            lHw = new HashSet<>();
            lHw.add("Structure");
            lHw.add("BasicStructure");
            lHw.add("ConditionalProcessing");
            lHw.add("Image");
            lHw.add("Style");
            lHw.add("ViewportAttribute");
            lHw.add("Shape");
            lHw.add("BasicText");
            lHw.add("PaintAttribute");
            lHw.add("BasicPaintAttribute");
            lHw.add("OpacityAttribute");
            lHw.add("BasicGraphicsAttribute");
            lHw.add("Marker");
            lHw.add("Gradient");
            lHw.add("Pattern");
            lHw.add("Clip");
            lHw.add("BasicClip");
            lHw.add("Mask");
            lHw.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lFI == null || !baVar.lFI.isZero()) {
            if (baVar.lFJ == null || !baVar.lFJ.isZero()) {
                a(this.lHq, baVar);
                if (djt()) {
                    SVG.ak NP = baVar.lHc.NP(baVar.Tv);
                    if (NP == null) {
                        k("Use reference '%s' not found", baVar.Tv);
                        return;
                    }
                    if (baVar.lFF != null) {
                        this.lHm.concat(baVar.lFF);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lFG != null ? baVar.lFG.a(this) : 0.0f, baVar.lFH != null ? baVar.lFH.b(this) : 0.0f);
                    this.lHm.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean djn = djn();
                    a((SVG.ag) baVar);
                    if (NP instanceof SVG.ac) {
                        djk();
                        SVG.ac acVar = (SVG.ac) NP;
                        a(acVar, baVar.lFI != null ? baVar.lFI : acVar.lFI, baVar.lFJ != null ? baVar.lFJ : acVar.lFJ);
                        djl();
                    } else if (NP instanceof SVG.aq) {
                        SVG.n nVar = baVar.lFI != null ? baVar.lFI : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lFJ != null ? baVar.lFJ : new SVG.n(100.0f, SVG.Unit.percent);
                        djk();
                        a((SVG.aq) NP, nVar, nVar2);
                        djl();
                    } else {
                        b(NP);
                    }
                    djm();
                    if (djn) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lFY != null) {
            a(this.lHq, tVar);
            if (djt() && dju()) {
                if (this.lHq.lHL || this.lHq.lHK) {
                    if (tVar.lFF != null) {
                        this.lHm.concat(tVar.lFF);
                    }
                    Path bG = new C0652c(tVar.lFY).bG();
                    if (tVar.lGY == null) {
                        tVar.lGY = b(bG);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean djn = djn();
                    if (this.lHq.lHK) {
                        bG.setFillType(djv());
                        a(tVar, bG);
                    }
                    if (this.lHq.lHL) {
                        a(bG);
                    }
                    a((SVG.j) tVar);
                    if (djn) {
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
        if (zVar.lFI != null && zVar.lFJ != null && !zVar.lFI.isZero() && !zVar.lFJ.isZero()) {
            a(this.lHq, zVar);
            if (djt() && dju()) {
                if (zVar.lFF != null) {
                    this.lHm.concat(zVar.lFF);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean djn = djn();
                if (this.lHq.lHK) {
                    a(zVar, b2);
                }
                if (this.lHq.lHL) {
                    a(b2);
                }
                if (djn) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lFv != null && !cVar.lFv.isZero()) {
            a(this.lHq, cVar);
            if (djt() && dju()) {
                if (cVar.lFF != null) {
                    this.lHm.concat(cVar.lFF);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean djn = djn();
                if (this.lHq.lHK) {
                    a(cVar, b2);
                }
                if (this.lHq.lHL) {
                    a(b2);
                }
                if (djn) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lFA != null && hVar.lFB != null && !hVar.lFA.isZero() && !hVar.lFB.isZero()) {
            a(this.lHq, hVar);
            if (djt() && dju()) {
                if (hVar.lFF != null) {
                    this.lHm.concat(hVar.lFF);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean djn = djn();
                if (this.lHq.lHK) {
                    a(hVar, b2);
                }
                if (this.lHq.lHL) {
                    a(b2);
                }
                if (djn) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lHq, oVar);
        if (djt() && dju() && this.lHq.lHL) {
            if (oVar.lFF != null) {
                this.lHm.concat(oVar.lFF);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean djn = djn();
            a(c);
            a((SVG.j) oVar);
            if (djn) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lFL != null ? oVar.lFL.a(this) : 0.0f;
        float b2 = oVar.lFM != null ? oVar.lFM.b(this) : 0.0f;
        float a3 = oVar.lFN != null ? oVar.lFN.a(this) : 0.0f;
        float b3 = oVar.lFO != null ? oVar.lFO.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lHq, xVar);
        if (djt() && dju()) {
            if (this.lHq.lHL || this.lHq.lHK) {
                if (xVar.lFF != null) {
                    this.lHm.concat(xVar.lFF);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean djn = djn();
                    if (this.lHq.lHK) {
                        a(xVar, c);
                    }
                    if (this.lHq.lHL) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (djn) {
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
        a(this.lHq, yVar);
        if (djt() && dju()) {
            if (this.lHq.lHL || this.lHq.lHK) {
                if (yVar.lFF != null) {
                    this.lHm.concat(yVar.lFF);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean djn = djn();
                    if (this.lHq.lHK) {
                        a(yVar, c);
                    }
                    if (this.lHq.lHL) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (djn) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lHq, atVar);
        if (djt()) {
            if (atVar.lFF != null) {
                this.lHm.concat(atVar.lFF);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lHk == null || atVar.lHk.size() == 0) ? 0.0f : atVar.lHk.get(0).a(this);
            if (atVar.lHl != null && atVar.lHl.size() != 0) {
                f2 = atVar.lHl.get(0).b(this);
            }
            SVG.Style.TextAnchor djs = djs();
            if (djs != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (djs == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lGY == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lGY = new SVG.a(hVar.lHP.left, hVar.lHP.top, hVar.lHP.width(), hVar.lHP.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean djn = djn();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (djn) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor djs() {
        if (this.lHq.lEL.lGB == SVG.Style.TextDirection.LTR || this.lHq.lEL.lGC == SVG.Style.TextAnchor.Middle) {
            return this.lHq.lEL.lGC;
        }
        return this.lHq.lEL.lGC == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
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
            if (c.this.dju()) {
                if (c.this.lHq.lHK) {
                    c.this.lHm.drawText(str, this.x, this.y, c.this.lHq.jH);
                }
                if (c.this.lHq.lHL) {
                    c.this.lHm.drawText(str, this.x, this.y, c.this.lHq.jI);
                }
            }
            this.x += c.this.lHq.jH.measureText(str);
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
        if (djt()) {
            Iterator<SVG.ak> it = avVar.UM.iterator();
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
                djk();
                a((SVG.aw) akVar);
                djl();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                djk();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lHq, asVar);
                if (djt()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lHk == null || asVar.lHk.size() == 0) ? 0.0f : asVar.lHk.get(0).a(this);
                        if (asVar.lHl != null && asVar.lHl.size() != 0) {
                            f5 = asVar.lHl.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.djf());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean djn = djn();
                    a((SVG.av) asVar, iVar);
                    if (djn) {
                        b((SVG.ah) asVar);
                    }
                }
                djl();
            } else if (akVar instanceof SVG.ar) {
                djk();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lHq, arVar);
                if (djt()) {
                    c((SVG.ah) arVar.djf());
                    SVG.ak NP = akVar.lHc.NP(arVar.Tv);
                    if (NP != null && (NP instanceof SVG.av)) {
                        StringBuilder sb = new StringBuilder();
                        a((SVG.av) NP, sb);
                        if (sb.length() > 0) {
                            iVar.NT(sb.toString());
                        }
                    } else {
                        k("Tref reference '%s' not found", arVar.Tv);
                    }
                }
                djl();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lHq, awVar);
        if (djt() && dju()) {
            SVG.ak NP = awVar.lHc.NP(awVar.Tv);
            if (NP == null) {
                k("TextPath reference '%s' not found", awVar.Tv);
                return;
            }
            SVG.t tVar = (SVG.t) NP;
            Path bG = new C0652c(tVar.lFY).bG();
            if (tVar.lFF != null) {
                bG.transform(tVar.lFF);
            }
            float a2 = awVar.lHj != null ? awVar.lHj.a(this, new PathMeasure(bG, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor djs = djs();
            if (djs != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (djs == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.djf());
            boolean djn = djn();
            a((SVG.av) awVar, (i) new d(bG, f2, 0.0f));
            if (djn) {
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
            if (c.this.dju()) {
                if (c.this.lHq.lHK) {
                    c.this.lHm.drawTextOnPath(str, this.path, this.x, this.y, c.this.lHq.jH);
                }
                if (c.this.lHq.lHL) {
                    c.this.lHm.drawTextOnPath(str, this.path, this.x, this.y, c.this.lHq.jI);
                }
            }
            this.x += c.this.lHq.jH.measureText(str);
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
            this.x += c.this.lHq.jH.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class h extends i {
        RectF lHP;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lHP = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak NP = avVar.lHc.NP(awVar.Tv);
                if (NP == null) {
                    c.k("TextPath path reference '%s' not found", awVar.Tv);
                    return false;
                }
                SVG.t tVar = (SVG.t) NP;
                Path bG = new C0652c(tVar.lFY).bG();
                if (tVar.lFF != null) {
                    bG.transform(tVar.lFF);
                }
                RectF rectF = new RectF();
                bG.computeBounds(rectF, true);
                this.lHP.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NT(String str) {
            if (c.this.dju()) {
                Rect rect = new Rect();
                c.this.lHq.jH.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lHP.union(rectF);
            }
            this.x += c.this.lHq.jH.measureText(str);
        }
    }

    private void a(SVG.av avVar, StringBuilder sb) {
        Iterator<SVG.ak> it = avVar.UM.iterator();
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
        if (this.lHq.lHN) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lHe != null ? aqVar.lHe : PreserveAspectRatio.lFa;
                a(this.lHq, aqVar);
                this.lHq.lHM = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lHq.lHM.width, nVar2 != null ? nVar2.a(this) : this.lHq.lHM.height);
                if (!this.lHq.lEL.lGD.booleanValue()) {
                    m(this.lHq.lHM.lFn, this.lHq.lHM.lFo, this.lHq.lHM.width, this.lHq.lHM.height);
                }
                if (aqVar.lHh != null) {
                    this.lHm.concat(a(this.lHq.lHM, aqVar.lHh, preserveAspectRatio));
                    this.lHq.lHh = aqVar.lHh;
                }
                boolean djn = djn();
                a((SVG.ag) aqVar, true);
                if (djn) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lFI != null && !mVar.lFI.isZero() && mVar.lFJ != null && !mVar.lFJ.isZero() && mVar.Tv != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lHe != null ? mVar.lHe : PreserveAspectRatio.lFa;
            Bitmap NS = NS(mVar.Tv);
            if (NS == null) {
                com.caverock.androidsvg.d diU = this.lHc.diU();
                if (diU != null) {
                    bitmap = diU.NU(mVar.Tv);
                } else {
                    return;
                }
            } else {
                bitmap = NS;
            }
            if (bitmap == null) {
                k("Could not locate image '%s'", mVar.Tv);
                return;
            }
            a(this.lHq, mVar);
            if (djt() && dju()) {
                if (mVar.lFF != null) {
                    this.lHm.concat(mVar.lFF);
                }
                this.lHq.lHM = new SVG.a(mVar.lFG != null ? mVar.lFG.a(this) : 0.0f, mVar.lFH != null ? mVar.lFH.b(this) : 0.0f, mVar.lFI.a(this), mVar.lFJ.a(this));
                if (!this.lHq.lEL.lGD.booleanValue()) {
                    m(this.lHq.lHM.lFn, this.lHq.lHM.lFo, this.lHq.lHM.width, this.lHq.lHM.height);
                }
                mVar.lGY = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lHm.concat(a(this.lHq.lHM, mVar.lGY, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean djn = djn();
                djw();
                this.lHm.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (djn) {
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

    private boolean djt() {
        if (this.lHq.lEL.lGI != null) {
            return this.lHq.lEL.lGI.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dju() {
        if (this.lHq.lEL.lGJ != null) {
            return this.lHq.lEL.lGJ.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.diO() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lFn;
        float f5 = -aVar2.lFo;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lEZ)) {
            matrix.preTranslate(aVar.lFn, aVar.lFo);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.diP() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.diO()) {
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
        switch (preserveAspectRatio.diO()) {
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
        matrix.preTranslate(aVar.lFn, aVar.lFo);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lGi & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lEL.lGv = style.lGv;
        }
        if (a(style, 2048L)) {
            gVar.lEL.lGu = style.lGu;
        }
        if (a(style, 1L)) {
            gVar.lEL.lGj = style.lGj;
            gVar.lHK = style.lGj != null;
        }
        if (a(style, 4L)) {
            gVar.lEL.lGl = style.lGl;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lEL.lGj);
        }
        if (a(style, 2L)) {
            gVar.lEL.lGk = style.lGk;
        }
        if (a(style, 8L)) {
            gVar.lEL.lGm = style.lGm;
            gVar.lHL = style.lGm != null;
        }
        if (a(style, 16L)) {
            gVar.lEL.lGn = style.lGn;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lEL.lGm);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lEL.lGS = style.lGS;
        }
        if (a(style, 32L)) {
            gVar.lEL.lGo = style.lGo;
            gVar.jI.setStrokeWidth(gVar.lEL.lGo.c(this));
        }
        if (a(style, 64L)) {
            gVar.lEL.lGp = style.lGp;
            switch (style.lGp) {
                case Butt:
                    gVar.jI.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.jI.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.jI.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (a(style, 128L)) {
            gVar.lEL.lGq = style.lGq;
            switch (style.lGq) {
                case Miter:
                    gVar.jI.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.jI.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.jI.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (a(style, 256L)) {
            gVar.lEL.lGr = style.lGr;
            gVar.jI.setStrokeMiter(style.lGr.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lEL.lGs = style.lGs;
        }
        if (a(style, 1024L)) {
            gVar.lEL.lGt = style.lGt;
        }
        if (a(style, 1536L)) {
            if (gVar.lEL.lGs == null) {
                gVar.jI.setPathEffect(null);
            } else {
                int length = gVar.lEL.lGs.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lEL.lGs[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jI.setPathEffect(null);
                } else {
                    float c = gVar.lEL.lGt.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jI.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float djh = djh();
            gVar.lEL.lGx = style.lGx;
            gVar.jH.setTextSize(style.lGx.a(this, djh));
            gVar.jI.setTextSize(style.lGx.a(this, djh));
        }
        if (a(style, 8192L)) {
            gVar.lEL.lGw = style.lGw;
        }
        if (a(style, 32768L)) {
            if (style.lGy.intValue() == -1 && gVar.lEL.lGy.intValue() > 100) {
                gVar.lEL.lGy = Integer.valueOf(style2.lGy.intValue() - 100);
            } else if (style.lGy.intValue() == 1 && gVar.lEL.lGy.intValue() < 900) {
                SVG.Style style3 = gVar.lEL;
                style3.lGy = Integer.valueOf(style3.lGy.intValue() + 100);
            } else {
                gVar.lEL.lGy = style.lGy;
            }
        }
        if (a(style, 65536L)) {
            gVar.lEL.lGz = style.lGz;
        }
        if (a(style, 106496L)) {
            if (gVar.lEL.lGw == null || this.lHc == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d diU = this.lHc.diU();
                typeface = null;
                for (String str : gVar.lEL.lGw) {
                    Typeface a2 = a(str, gVar.lEL.lGy, gVar.lEL.lGz);
                    if (a2 != null || diU == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = diU.x(str, gVar.lEL.lGy.intValue(), String.valueOf(gVar.lEL.lGz));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lEL.lGy, gVar.lEL.lGz);
            }
            gVar.jH.setTypeface(typeface);
            gVar.jI.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lEL.lGA = style.lGA;
            gVar.jH.setStrikeThruText(style.lGA == SVG.Style.TextDecoration.LineThrough);
            gVar.jH.setUnderlineText(style.lGA == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jI.setStrikeThruText(style.lGA == SVG.Style.TextDecoration.LineThrough);
                gVar.jI.setUnderlineText(style.lGA == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lEL.lGB = style.lGB;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lEL.lGC = style.lGC;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lEL.lGD = style.lGD;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lEL.lGF = style.lGF;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lEL.lGG = style.lGG;
        }
        if (a(style, 8388608L)) {
            gVar.lEL.lGH = style.lGH;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lEL.lGI = style.lGI;
        }
        if (a(style, 33554432L)) {
            gVar.lEL.lGJ = style.lGJ;
        }
        if (a(style, 1048576L)) {
            gVar.lEL.lGE = style.lGE;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lEL.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lEL.lGM = style.lGM;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lEL.lGN = style.lGN;
        }
        if (a(style, 67108864L)) {
            gVar.lEL.lGK = style.lGK;
        }
        if (a(style, 134217728L)) {
            gVar.lEL.lGL = style.lGL;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lEL.lGQ = style.lGQ;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lEL.lGR = style.lGR;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lEL.lGl : gVar.lEL.lGn).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lFx;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lEL.lGv.lFx;
        } else {
            return;
        }
        int bh = i2 | (bh(floatValue) << 24);
        if (z) {
            gVar.jH.setColor(bh);
        } else {
            gVar.jI.setColor(bh);
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

    private Path.FillType djv() {
        if (this.lHq.lEL.lGk == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lHq.lEL.lGk) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lHq.lEL.lGE != null) {
            f2 += this.lHq.lEL.lGE.lFs.a(this);
            f3 += this.lHq.lEL.lGE.lFp.b(this);
            f6 -= this.lHq.lEL.lGE.lFq.a(this);
            f7 -= this.lHq.lEL.lGE.lFr.b(this);
        }
        this.lHm.clipRect(f2, f3, f6, f7);
    }

    private void djw() {
        int i2;
        if (this.lHq.lEL.lGQ instanceof SVG.e) {
            i2 = ((SVG.e) this.lHq.lEL.lGQ).lFx;
        } else if (this.lHq.lEL.lGQ instanceof SVG.f) {
            i2 = this.lHq.lEL.lGv.lFx;
        } else {
            return;
        }
        if (this.lHq.lEL.lGR != null) {
            i2 |= bh(this.lHq.lEL.lGR.floatValue()) << 24;
        }
        this.lHm.drawColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.caverock.androidsvg.c$c  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C0652c implements SVG.v {
        float lastX;
        float lastY;
        Path path = new Path();

        public C0652c(SVG.u uVar) {
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
        public float lHH;
        public float lHI;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.lHH = 0.0f;
            this.lHI = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.lHH = (float) (f3 / sqrt);
                this.lHI = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.lHH = ((float) (f3 / sqrt)) + this.lHH;
                this.lHI += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.lHH += bVar.lHH;
            this.lHI += bVar.lHI;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.lHH + Constants.ACCEPT_TIME_SEPARATOR_SP + this.lHI + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements SVG.v {
        private List<b> bzZ = new ArrayList();
        private b lHB = null;
        private boolean lHC = false;
        private boolean lHD = true;
        private int lHE = -1;
        private boolean lHF;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lHF) {
                    this.lHB.a(this.bzZ.get(this.lHE));
                    this.bzZ.set(this.lHE, this.lHB);
                    this.lHF = false;
                }
                if (this.lHB != null) {
                    this.bzZ.add(this.lHB);
                }
            }
        }

        public List<b> djA() {
            return this.bzZ;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lHF) {
                this.lHB.a(this.bzZ.get(this.lHE));
                this.bzZ.set(this.lHE, this.lHB);
                this.lHF = false;
            }
            if (this.lHB != null) {
                this.bzZ.add(this.lHB);
            }
            this.startX = f;
            this.startY = f2;
            this.lHB = new b(f, f2, 0.0f, 0.0f);
            this.lHE = this.bzZ.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lHB.C(f, f2);
            this.bzZ.add(this.lHB);
            this.lHB = new b(f, f2, f - this.lHB.x, f2 - this.lHB.y);
            this.lHF = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lHD || this.lHC) {
                this.lHB.C(f, f2);
                this.bzZ.add(this.lHB);
                this.lHC = false;
            }
            this.lHB = new b(f5, f6, f5 - f3, f6 - f4);
            this.lHF = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lHB.C(f, f2);
            this.bzZ.add(this.lHB);
            this.lHB = new b(f3, f4, f3 - f, f4 - f2);
            this.lHF = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lHC = true;
            this.lHD = false;
            c.a(this.lHB.x, this.lHB.y, f, f2, f3, z, z2, f4, f5, this);
            this.lHD = true;
            this.lHF = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bzZ.add(this.lHB);
            B(this.startX, this.startY);
            this.lHF = true;
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
        if (this.lHq.lEL.lGF != null || this.lHq.lEL.lGG != null || this.lHq.lEL.lGH != null) {
            if (this.lHq.lEL.lGF != null) {
                SVG.ak NP = jVar.lHc.NP(this.lHq.lEL.lGF);
                if (NP != null) {
                    pVar = (SVG.p) NP;
                    if (this.lHq.lEL.lGG != null) {
                        SVG.ak NP2 = jVar.lHc.NP(this.lHq.lEL.lGG);
                        if (NP2 != null) {
                            pVar2 = (SVG.p) NP2;
                            if (this.lHq.lEL.lGH != null) {
                                SVG.ak NP3 = jVar.lHc.NP(this.lHq.lEL.lGH);
                                if (NP3 != null) {
                                    pVar3 = (SVG.p) NP3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lFY).djA();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lHq.lEL;
                                        SVG.Style style2 = this.lHq.lEL;
                                        this.lHq.lEL.lGH = null;
                                        style2.lGG = null;
                                        style.lGF = null;
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
                                k("Marker reference '%s' not found", this.lHq.lEL.lGH);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lHq.lEL.lGG);
                    }
                    pVar2 = null;
                    if (this.lHq.lEL.lGH != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lHq.lEL.lGF);
                }
            }
            pVar = null;
            if (this.lHq.lEL.lGG != null) {
            }
            pVar2 = null;
            if (this.lHq.lEL.lGH != null) {
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
        boolean djn;
        float f3;
        float f4 = 0.0f;
        djk();
        if (pVar.lFU != null) {
            if (Float.isNaN(pVar.lFU.floatValue())) {
                if (bVar.lHH != 0.0f || bVar.lHI != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.lHI, bVar.lHH));
                }
            } else {
                f2 = pVar.lFU.floatValue();
            }
            float bg = !pVar.lFP ? 1.0f : this.lHq.lEL.lGo.bg(this.lHo);
            this.lHq = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bg, bg);
            float a2 = pVar.lFQ == null ? pVar.lFQ.a(this) : 0.0f;
            float b2 = pVar.lFR == null ? pVar.lFR.b(this) : 0.0f;
            float a3 = pVar.lFS == null ? pVar.lFS.a(this) : 3.0f;
            float b3 = pVar.lFT != null ? pVar.lFT.b(this) : 3.0f;
            if (pVar.lHh == null) {
                float f5 = a3 / pVar.lHh.width;
                float f6 = b3 / pVar.lHh.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lHe != null ? pVar.lHe : PreserveAspectRatio.lFa;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lEZ)) {
                    f6 = preserveAspectRatio.diP() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lHm.concat(matrix);
                float f7 = pVar.lHh.width * f5;
                float f8 = pVar.lHh.height * f6;
                switch (preserveAspectRatio.diO()) {
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
                switch (preserveAspectRatio.diO()) {
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
                if (!this.lHq.lEL.lGD.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lHm.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lHm.concat(matrix);
                if (!this.lHq.lEL.lGD.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            djn = djn();
            a((SVG.ag) pVar, false);
            if (djn) {
                b((SVG.ah) pVar);
            }
            djl();
        }
        f2 = 0.0f;
        if (!pVar.lFP) {
        }
        this.lHq = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bg, bg);
        if (pVar.lFQ == null) {
        }
        if (pVar.lFR == null) {
        }
        if (pVar.lFS == null) {
        }
        if (pVar.lFT != null) {
        }
        if (pVar.lHh == null) {
        }
        djn = djn();
        a((SVG.ag) pVar, false);
        if (djn) {
        }
        djl();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.diZ());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lHd == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lHd;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lHh = this.lHc.diR().lHh;
        if (gVar.lHh == null) {
            gVar.lHh = this.lHn;
        }
        gVar.lHM = this.lHn;
        gVar.lHO = this.lHq.lHO;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lHq.lEL.lGj instanceof SVG.s) {
            a(true, ahVar.lGY, (SVG.s) this.lHq.lEL.lGj);
        }
        if (this.lHq.lEL.lGm instanceof SVG.s) {
            a(false, ahVar.lGY, (SVG.s) this.lHq.lEL.lGm);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak NP = this.lHc.NP(sVar.Tv);
        if (NP == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.Tv;
            k("%s reference '%s' not found", objArr);
            if (sVar.lFX != null) {
                a(this.lHq, z, sVar.lFX);
                return;
            } else if (z) {
                this.lHq.lHK = false;
                return;
            } else {
                this.lHq.lHL = false;
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
        if (ajVar.Tv != null) {
            a(ajVar, ajVar.Tv);
        }
        boolean z2 = ajVar.lFC != null && ajVar.lFC.booleanValue();
        Paint paint = z ? this.lHq.jH : this.lHq.jI;
        if (z2) {
            SVG.a djj = djj();
            float a3 = ajVar.lFL != null ? ajVar.lFL.a(this) : 0.0f;
            float b2 = ajVar.lFM != null ? ajVar.lFM.b(this) : 0.0f;
            float a4 = ajVar.lFN != null ? ajVar.lFN.a(this) : djj.width;
            a2 = ajVar.lFO != null ? ajVar.lFO.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lFL != null ? ajVar.lFL.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lFM != null ? ajVar.lFM.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lFN != null ? ajVar.lFN.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lFO != null ? ajVar.lFO.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        djk();
        this.lHq = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lFn, aVar.lFo);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lFD != null) {
            matrix.preConcat(ajVar.lFD);
        }
        int size = ajVar.UM.size();
        if (size == 0) {
            djl();
            if (z) {
                this.lHq.lHK = false;
                return;
            } else {
                this.lHq.lHL = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = ajVar.UM.iterator();
        int i2 = 0;
        float f5 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lGh.floatValue() >= f5) {
                fArr[i2] = abVar.lGh.floatValue();
                f5 = abVar.lGh.floatValue();
            } else {
                fArr[i2] = f5;
            }
            djk();
            a(this.lHq, abVar);
            SVG.e eVar = (SVG.e) this.lHq.lEL.lGK;
            if (eVar == null) {
                eVar = SVG.e.lFy;
            }
            iArr[i2] = eVar.lFx | (bh(this.lHq.lEL.lGL.floatValue()) << 24);
            djl();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            djl();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lFE != null) {
            if (ajVar.lFE == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lFE == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        djl();
        LinearGradient linearGradient = new LinearGradient(f4, f3, f2, a2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void a(boolean z, SVG.a aVar, SVG.an anVar) {
        float a2;
        float f2;
        float f3;
        if (anVar.Tv != null) {
            a(anVar, anVar.Tv);
        }
        boolean z2 = anVar.lFC != null && anVar.lFC.booleanValue();
        Paint paint = z ? this.lHq.jH : this.lHq.jI;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lFt != null ? anVar.lFt.a(this) : nVar.a(this);
            float b2 = anVar.lFu != null ? anVar.lFu.b(this) : nVar.b(this);
            a2 = anVar.lFv != null ? anVar.lFv.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lFt != null ? anVar.lFt.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lFu != null ? anVar.lFu.a(this, 1.0f) : 0.5f;
            a2 = anVar.lFv != null ? anVar.lFv.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        djk();
        this.lHq = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lFn, aVar.lFo);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lFD != null) {
            matrix.preConcat(anVar.lFD);
        }
        int size = anVar.UM.size();
        if (size == 0) {
            djl();
            if (z) {
                this.lHq.lHK = false;
                return;
            } else {
                this.lHq.lHL = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = anVar.UM.iterator();
        int i2 = 0;
        float f4 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lGh.floatValue() >= f4) {
                fArr[i2] = abVar.lGh.floatValue();
                f4 = abVar.lGh.floatValue();
            } else {
                fArr[i2] = f4;
            }
            djk();
            a(this.lHq, abVar);
            SVG.e eVar = (SVG.e) this.lHq.lEL.lGK;
            if (eVar == null) {
                eVar = SVG.e.lFy;
            }
            iArr[i2] = eVar.lFx | (bh(this.lHq.lEL.lGL.floatValue()) << 24);
            djl();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            djl();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lFE != null) {
            if (anVar.lFE == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lFE == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        djl();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak NP = iVar.lHc.NP(str);
        if (NP == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(NP instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (NP == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) NP;
            if (iVar.lFC == null) {
                iVar.lFC = iVar2.lFC;
            }
            if (iVar.lFD == null) {
                iVar.lFD = iVar2.lFD;
            }
            if (iVar.lFE == null) {
                iVar.lFE = iVar2.lFE;
            }
            if (iVar.UM.isEmpty()) {
                iVar.UM = iVar2.UM;
            }
            try {
                if (iVar instanceof SVG.aj) {
                    a((SVG.aj) iVar, (SVG.aj) NP);
                } else {
                    a((SVG.an) iVar, (SVG.an) NP);
                }
            } catch (ClassCastException e2) {
            }
            if (iVar2.Tv != null) {
                a(iVar, iVar2.Tv);
            }
        }
    }

    private void a(SVG.aj ajVar, SVG.aj ajVar2) {
        if (ajVar.lFL == null) {
            ajVar.lFL = ajVar2.lFL;
        }
        if (ajVar.lFM == null) {
            ajVar.lFM = ajVar2.lFM;
        }
        if (ajVar.lFN == null) {
            ajVar.lFN = ajVar2.lFN;
        }
        if (ajVar.lFO == null) {
            ajVar.lFO = ajVar2.lFO;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lFt == null) {
            anVar.lFt = anVar2.lFt;
        }
        if (anVar.lFu == null) {
            anVar.lFu = anVar2.lFu;
        }
        if (anVar.lFv == null) {
            anVar.lFv = anVar2.lFv;
        }
        if (anVar.lHf == null) {
            anVar.lHf = anVar2.lHf;
        }
        if (anVar.lHg == null) {
            anVar.lHg = anVar2.lHg;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lHa, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lHq.lEL.lGj = aaVar.lHa.lGO;
                this.lHq.lHK = aaVar.lHa.lGO != null;
            }
            if (a(aaVar.lHa, 4294967296L)) {
                this.lHq.lEL.lGl = aaVar.lHa.lGP;
            }
            if (a(aaVar.lHa, 6442450944L)) {
                a(this.lHq, z, this.lHq.lEL.lGj);
                return;
            }
            return;
        }
        if (a(aaVar.lHa, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lHq.lEL.lGm = aaVar.lHa.lGO;
            this.lHq.lHL = aaVar.lHa.lGO != null;
        }
        if (a(aaVar.lHa, 4294967296L)) {
            this.lHq.lEL.lGn = aaVar.lHa.lGP;
        }
        if (a(aaVar.lHa, 6442450944L)) {
            a(this.lHq, z, this.lHq.lEL.lGm);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lGY);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lHq.lEL.clipPath != null) {
            SVG.ak NP = ahVar.lHc.NP(this.lHq.lEL.clipPath);
            if (NP == null) {
                k("ClipPath reference '%s' not found", this.lHq.lEL.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) NP;
            if (dVar.UM.isEmpty()) {
                this.lHm.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lFw == null || dVar.lFw.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            djx();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lFn, aVar.lFo);
                matrix.preScale(aVar.width, aVar.height);
                this.lHm.concat(matrix);
            }
            if (dVar.lFF != null) {
                this.lHm.concat(dVar.lFF);
            }
            this.lHq = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.UM) {
                a(akVar, true, path, new Matrix());
            }
            this.lHm.clipPath(path);
            djy();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (djt()) {
            djx();
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
            djy();
        }
    }

    private void djx() {
        this.lHm.save();
        this.lHr.push(this.lHq);
        this.lHq = (g) this.lHq.clone();
    }

    private void djy() {
        this.lHm.restore();
        this.lHq = this.lHr.pop();
    }

    private Path.FillType djz() {
        if (this.lHq.lEL.lGM == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lHq.lEL.lGM) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lHq, tVar);
        if (djt() && dju()) {
            if (tVar.lFF != null) {
                matrix.preConcat(tVar.lFF);
            }
            Path bG = new C0652c(tVar.lFY).bG();
            if (tVar.lGY == null) {
                tVar.lGY = b(bG);
            }
            d((SVG.ah) tVar);
            path.setFillType(djz());
            path.addPath(bG, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lHq, jVar);
        if (djt() && dju()) {
            if (jVar.lFF != null) {
                matrix.preConcat(jVar.lFF);
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
        a(this.lHq, baVar);
        if (djt() && dju()) {
            if (baVar.lFF != null) {
                matrix.preConcat(baVar.lFF);
            }
            SVG.ak NP = baVar.lHc.NP(baVar.Tv);
            if (NP == null) {
                k("Use reference '%s' not found", baVar.Tv);
                return;
            }
            d((SVG.ah) baVar);
            a(NP, false, path, matrix);
        }
    }

    private void a(SVG.at atVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        a(this.lHq, atVar);
        if (djt()) {
            if (atVar.lFF != null) {
                matrix.preConcat(atVar.lFF);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lHk == null || atVar.lHk.size() == 0) ? 0.0f : atVar.lHk.get(0).a(this);
            if (atVar.lHl != null && atVar.lHl.size() != 0) {
                f2 = atVar.lHl.get(0).b(this);
            }
            if (this.lHq.lEL.lGC != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lHq.lEL.lGC == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lGY == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lGY = new SVG.a(hVar.lHP.left, hVar.lHP.top, hVar.lHP.width(), hVar.lHP.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(djz());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class f extends i {
        public Path lHJ;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lHJ = path;
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
            if (c.this.dju()) {
                Path path = new Path();
                c.this.lHq.jH.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lHJ.addPath(path);
            }
            this.x += c.this.lHq.jH.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lFL == null ? 0.0f : oVar.lFL.a(this);
        float b2 = oVar.lFM == null ? 0.0f : oVar.lFM.b(this);
        float a3 = oVar.lFN == null ? 0.0f : oVar.lFN.a(this);
        float b3 = oVar.lFO != null ? oVar.lFO.b(this) : 0.0f;
        if (oVar.lGY == null) {
            oVar.lGY = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lFA == null && zVar.lFB == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lFA == null) {
            b2 = zVar.lFB.b(this);
            a2 = b2;
        } else if (zVar.lFB == null) {
            b2 = zVar.lFA.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lFA.a(this);
            b2 = zVar.lFB.b(this);
        }
        float min = Math.min(a2, zVar.lFI.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lFJ.b(this) / 2.0f);
        float a3 = zVar.lFG != null ? zVar.lFG.a(this) : 0.0f;
        float b3 = zVar.lFH != null ? zVar.lFH.b(this) : 0.0f;
        float a4 = zVar.lFI.a(this);
        float b4 = zVar.lFJ.b(this);
        if (zVar.lGY == null) {
            zVar.lGY = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lFt != null ? cVar.lFt.a(this) : 0.0f;
        float b2 = cVar.lFu != null ? cVar.lFu.b(this) : 0.0f;
        float c = cVar.lFv.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lGY == null) {
            cVar.lGY = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lFt != null ? hVar.lFt.a(this) : 0.0f;
        float b2 = hVar.lFu != null ? hVar.lFu.b(this) : 0.0f;
        float a3 = hVar.lFA.a(this);
        float b3 = hVar.lFB.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lGY == null) {
            hVar.lGY = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lGY == null) {
            xVar.lGY = b(path);
        }
        path.setFillType(djz());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lGe != null && wVar.lGe.booleanValue();
        if (wVar.Tv != null) {
            a(wVar, wVar.Tv);
        }
        if (z) {
            float a2 = wVar.lFG != null ? wVar.lFG.a(this) : 0.0f;
            float b2 = wVar.lFH != null ? wVar.lFH.b(this) : 0.0f;
            float a3 = wVar.lFI != null ? wVar.lFI.a(this) : 0.0f;
            f2 = wVar.lFJ != null ? wVar.lFJ.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lFG != null ? wVar.lFG.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lFH != null ? wVar.lFH.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lFI != null ? wVar.lFI.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lFJ != null ? wVar.lFJ.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lGY.width) + ahVar.lGY.lFn;
            float f7 = (a5 * ahVar.lGY.height) + ahVar.lGY.lFo;
            float f8 = a6 * ahVar.lGY.width;
            f2 = a7 * ahVar.lGY.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lHe != null ? wVar.lHe : PreserveAspectRatio.lFa;
            djk();
            this.lHm.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.diZ());
            gVar.lEL.lGD = false;
            this.lHq = a(wVar, gVar);
            SVG.a aVar = ahVar.lGY;
            if (wVar.lGg != null) {
                this.lHm.concat(wVar.lGg);
                Matrix matrix = new Matrix();
                if (wVar.lGg.invert(matrix)) {
                    float[] fArr = {ahVar.lGY.lFn, ahVar.lGY.lFo, ahVar.lGY.diV(), ahVar.lGY.lFo, ahVar.lGY.diV(), ahVar.lGY.diW(), ahVar.lGY.lFn, ahVar.lGY.diW()};
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
            float floor = f5 + (((float) Math.floor((aVar.lFn - f5) / f3)) * f3);
            float diV = aVar.diV();
            float diW = aVar.diW();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lFo - f4) / f2)) * f2); floor2 < diW; floor2 += f2) {
                for (float f9 = floor; f9 < diV; f9 += f3) {
                    aVar2.lFn = f9;
                    aVar2.lFo = floor2;
                    djk();
                    if (!this.lHq.lEL.lGD.booleanValue()) {
                        m(aVar2.lFn, aVar2.lFo, aVar2.width, aVar2.height);
                    }
                    if (wVar.lHh != null) {
                        this.lHm.concat(a(aVar2, wVar.lHh, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lGf == null || wVar.lGf.booleanValue();
                        this.lHm.translate(f9, floor2);
                        if (!z2) {
                            this.lHm.scale(ahVar.lGY.width, ahVar.lGY.height);
                        }
                    }
                    boolean djn = djn();
                    for (SVG.ak akVar : wVar.UM) {
                        b(akVar);
                    }
                    if (djn) {
                        b((SVG.ah) wVar);
                    }
                    djl();
                }
            }
            djl();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak NP = wVar.lHc.NP(str);
        if (NP == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(NP instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (NP == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) NP;
            if (wVar.lGe == null) {
                wVar.lGe = wVar2.lGe;
            }
            if (wVar.lGf == null) {
                wVar.lGf = wVar2.lGf;
            }
            if (wVar.lGg == null) {
                wVar.lGg = wVar2.lGg;
            }
            if (wVar.lFG == null) {
                wVar.lFG = wVar2.lFG;
            }
            if (wVar.lFH == null) {
                wVar.lFH = wVar2.lFH;
            }
            if (wVar.lFI == null) {
                wVar.lFI = wVar2.lFI;
            }
            if (wVar.lFJ == null) {
                wVar.lFJ = wVar2.lFJ;
            }
            if (wVar.UM.isEmpty()) {
                wVar.UM = wVar2.UM;
            }
            if (wVar.lHh == null) {
                wVar.lHh = wVar2.lHh;
            }
            if (wVar.lHe == null) {
                wVar.lHe = wVar2.lHe;
            }
            if (wVar2.Tv != null) {
                a(wVar, wVar2.Tv);
            }
        }
    }

    private void a(SVG.q qVar, SVG.ah ahVar) {
        float f2;
        float f3;
        debug("Mask render", new Object[0]);
        if (qVar.lFV != null && qVar.lFV.booleanValue()) {
            f2 = qVar.lFI != null ? qVar.lFI.a(this) : ahVar.lGY.width;
            f3 = qVar.lFJ != null ? qVar.lFJ.b(this) : ahVar.lGY.height;
            if (qVar.lFG != null) {
                qVar.lFG.a(this);
            } else {
                float f4 = (float) (ahVar.lGY.lFn - (ahVar.lGY.width * 0.1d));
            }
            if (qVar.lFH != null) {
                qVar.lFH.b(this);
            } else {
                float f5 = (float) (ahVar.lGY.lFo - (ahVar.lGY.height * 0.1d));
            }
        } else {
            float a2 = qVar.lFG != null ? qVar.lFG.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lFH != null ? qVar.lFH.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lFI != null ? qVar.lFI.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lFJ != null ? qVar.lFJ.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lGY.width) + ahVar.lGY.lFn;
            float f7 = ahVar.lGY.lFo + (a3 * ahVar.lGY.height);
            f2 = ahVar.lGY.width * a4;
            f3 = ahVar.lGY.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            djk();
            this.lHq = d((SVG.ak) qVar);
            this.lHq.lEL.lGu = Float.valueOf(1.0f);
            if (!(qVar.lFW == null || qVar.lFW.booleanValue())) {
                this.lHm.translate(ahVar.lGY.lFn, ahVar.lGY.lFo);
                this.lHm.scale(ahVar.lGY.width, ahVar.lGY.height);
            }
            a((SVG.ag) qVar, false);
            djl();
        }
    }
}
