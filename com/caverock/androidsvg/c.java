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
    private static HashSet<String> lEY = null;
    private SVG lEE;
    private Canvas lEO;
    private SVG.a lEP;
    private float lEQ;
    private boolean lER;
    private g lES;
    private Stack<g> lET;
    private Stack<SVG.ag> lEU;
    private Stack<Matrix> lEV;
    private Stack<Canvas> lEW;
    private Stack<Bitmap> lEX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class g implements Cloneable {
        public Paint jE = new Paint();
        public Paint jF;
        public SVG.Style lCn;
        public SVG.a lEJ;
        public boolean lFk;
        public boolean lFl;
        public SVG.a lFm;
        public boolean lFn;
        public boolean lFo;

        public g() {
            this.jE.setFlags(385);
            this.jE.setStyle(Paint.Style.FILL);
            this.jE.setTypeface(Typeface.DEFAULT);
            this.jF = new Paint();
            this.jF.setFlags(385);
            this.jF.setStyle(Paint.Style.STROKE);
            this.jF.setTypeface(Typeface.DEFAULT);
            this.lCn = SVG.Style.dhl();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lCn = (SVG.Style) this.lCn.clone();
                gVar.jE = new Paint(this.jE);
                gVar.jF = new Paint(this.jF);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lES = new g();
        this.lET = new Stack<>();
        a(this.lES, SVG.Style.dhl());
        this.lES.lFm = this.lEP;
        this.lES.lFn = false;
        this.lES.lFo = this.lER;
        this.lET.push((g) this.lES.clone());
        this.lEW = new Stack<>();
        this.lEX = new Stack<>();
        this.lEV = new Stack<>();
        this.lEU = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lEO = canvas;
        this.lEQ = f2;
        this.lEP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dhs() {
        return this.lEQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dht() {
        return this.lES.jE.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dhu() {
        return this.lES.jE.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a dhv() {
        return this.lES.lEJ != null ? this.lES.lEJ : this.lES.lFm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lEE = svg;
        this.lER = z;
        SVG.ac dhd = svg.dhd();
        if (dhd == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) dhd);
        a(dhd, dhd.lDk, dhd.lDl, aVar != null ? aVar : dhd.lEJ, preserveAspectRatio != null ? preserveAspectRatio : dhd.lEG);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            dhw();
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
            dhx();
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
            dhy();
        }
    }

    private void dhw() {
        this.lEO.save();
        this.lET.push(this.lES);
        this.lES = (g) this.lES.clone();
    }

    private void dhx() {
        this.lEO.restore();
        this.lES = this.lET.pop();
    }

    private void a(SVG.ag agVar) {
        this.lEU.push(agVar);
        this.lEV.push(this.lEO.getMatrix());
    }

    private void dhy() {
        this.lEU.pop();
        this.lEV.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lCn.uU(aiVar.lEF == null);
        if (aiVar.lEC != null) {
            a(gVar, aiVar.lEC);
        }
        if (this.lEE.dhf()) {
            for (CSSParser.c cVar : this.lEE.dhe()) {
                if (CSSParser.a(cVar.lCm, aiVar)) {
                    a(gVar, cVar.lCn);
                }
            }
        }
        if (aiVar.lCn != null) {
            a(gVar, aiVar.lCn);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lEB != null) {
                this.lES.lFn = aiVar.lEB.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lES.lCn.lDL instanceof SVG.s) {
            SVG.ak ND = this.lEE.ND(((SVG.s) this.lES.lCn.lDL).RC);
            if (ND instanceof SVG.w) {
                a(ahVar, path, (SVG.w) ND);
                return;
            }
        }
        this.lEO.drawPath(path, this.lES.jE);
    }

    private void a(Path path) {
        if (this.lES.lCn.lEu == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lEO.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lEO.setMatrix(new Matrix());
            Shader shader = this.lES.jF.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lEO.drawPath(path2, this.lES.jF);
            this.lEO.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lEO.drawPath(path, this.lES.jF);
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
        a(acVar, acVar.lDk, acVar.lDl);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lEJ, acVar.lEG);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lEG != null ? acVar.lEG : PreserveAspectRatio.lCC;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lES, acVar);
                if (dhF()) {
                    if (acVar.lEF != null) {
                        f2 = acVar.lDi != null ? acVar.lDi.a(this) : 0.0f;
                        if (acVar.lDj != null) {
                            f3 = acVar.lDj.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a dhv = dhv();
                    this.lES.lFm = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : dhv.width, nVar2 != null ? nVar2.b(this) : dhv.height);
                    if (!this.lES.lCn.lEf.booleanValue()) {
                        m(this.lES.lFm.lCP, this.lES.lFm.lCQ, this.lES.lFm.width, this.lES.lFm.height);
                    }
                    a(acVar, this.lES.lFm);
                    if (aVar != null) {
                        this.lEO.concat(a(this.lES.lFm, aVar, preserveAspectRatio2));
                        this.lES.lEJ = acVar.lEJ;
                    } else {
                        this.lEO.translate(f2, f3);
                    }
                    boolean dhz = dhz();
                    dhI();
                    a((SVG.ag) acVar, true);
                    if (dhz) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lES, kVar);
        if (dhF()) {
            if (kVar.lDh != null) {
                this.lEO.concat(kVar.lDh);
            }
            d((SVG.ah) kVar);
            boolean dhz = dhz();
            a((SVG.ag) kVar, true);
            if (dhz) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lEF != null && ahVar.lEA != null) {
            Matrix matrix = new Matrix();
            if (this.lEV.peek().invert(matrix)) {
                float[] fArr = {ahVar.lEA.lCP, ahVar.lEA.lCQ, ahVar.lEA.dhh(), ahVar.lEA.lCQ, ahVar.lEA.dhh(), ahVar.lEA.dhi(), ahVar.lEA.lCP, ahVar.lEA.dhi()};
                matrix.preConcat(this.lEO.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lEU.peek();
                if (ahVar2.lEA == null) {
                    ahVar2.lEA = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lEA.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean dhz() {
        if (dhA()) {
            this.lEO.saveLayerAlpha(null, bi(this.lES.lCn.lDW.floatValue()), 31);
            this.lET.push(this.lES);
            this.lES = (g) this.lES.clone();
            if (this.lES.lCn.lEp != null && this.lES.lFo) {
                SVG.ak ND = this.lEE.ND(this.lES.lCn.lEp);
                if (ND == null || !(ND instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lES.lCn.lEp);
                    this.lES.lCn.lEp = null;
                    return true;
                }
                this.lEW.push(this.lEO);
                dhB();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lES.lCn.lEp != null && this.lES.lFo) {
            SVG.ak ND = this.lEE.ND(this.lES.lCn.lEp);
            dhB();
            a((SVG.q) ND, ahVar);
            Bitmap dhC = dhC();
            this.lEO = this.lEW.pop();
            this.lEO.save();
            this.lEO.setMatrix(new Matrix());
            this.lEO.drawBitmap(dhC, 0.0f, 0.0f, this.lES.jE);
            dhC.recycle();
            this.lEO.restore();
        }
        dhx();
    }

    private boolean dhA() {
        if (this.lES.lCn.lEp != null && !this.lES.lFo) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lES.lCn.lDW.floatValue() < 1.0f || (this.lES.lCn.lEp != null && this.lES.lFo);
    }

    private void dhB() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lEO.getWidth(), this.lEO.getHeight(), Bitmap.Config.ARGB_8888);
            this.lEX.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lEO.getMatrix());
            this.lEO = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap dhC() {
        Bitmap pop = this.lEX.pop();
        Bitmap pop2 = this.lEX.pop();
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
        a(this.lES, apVar);
        if (dhF()) {
            if (apVar.lDh != null) {
                this.lEO.concat(apVar.lDh);
            }
            d((SVG.ah) apVar);
            boolean dhz = dhz();
            b(apVar);
            if (dhz) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> dho;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d dhg = this.lEE.dhg();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.dhn() == null && ((dho = adVar.dho()) == null || (!dho.isEmpty() && dho.contains(language)))) {
                    Set<String> dhm = adVar.dhm();
                    if (dhm != null) {
                        if (lEY == null) {
                            dhD();
                        }
                        if (!dhm.isEmpty() && lEY.containsAll(dhm)) {
                        }
                    }
                    Set<String> dhp = adVar.dhp();
                    if (dhp != null) {
                        if (!dhp.isEmpty() && dhg != null) {
                            for (String str : dhp) {
                                if (!dhg.NJ(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> dhq = adVar.dhq();
                    if (dhq != null) {
                        if (!dhq.isEmpty() && dhg != null) {
                            for (String str2 : dhq) {
                                if (dhg.w(str2, this.lES.lCn.lEa.intValue(), String.valueOf(this.lES.lCn.lEb)) == null) {
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

    private static synchronized void dhD() {
        synchronized (c.class) {
            lEY = new HashSet<>();
            lEY.add("Structure");
            lEY.add("BasicStructure");
            lEY.add("ConditionalProcessing");
            lEY.add("Image");
            lEY.add("Style");
            lEY.add("ViewportAttribute");
            lEY.add("Shape");
            lEY.add("BasicText");
            lEY.add("PaintAttribute");
            lEY.add("BasicPaintAttribute");
            lEY.add("OpacityAttribute");
            lEY.add("BasicGraphicsAttribute");
            lEY.add("Marker");
            lEY.add("Gradient");
            lEY.add("Pattern");
            lEY.add("Clip");
            lEY.add("BasicClip");
            lEY.add("Mask");
            lEY.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lDk == null || !baVar.lDk.isZero()) {
            if (baVar.lDl == null || !baVar.lDl.isZero()) {
                a(this.lES, baVar);
                if (dhF()) {
                    SVG.ak ND = baVar.lEE.ND(baVar.RC);
                    if (ND == null) {
                        k("Use reference '%s' not found", baVar.RC);
                        return;
                    }
                    if (baVar.lDh != null) {
                        this.lEO.concat(baVar.lDh);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lDi != null ? baVar.lDi.a(this) : 0.0f, baVar.lDj != null ? baVar.lDj.b(this) : 0.0f);
                    this.lEO.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean dhz = dhz();
                    a((SVG.ag) baVar);
                    if (ND instanceof SVG.ac) {
                        dhw();
                        SVG.ac acVar = (SVG.ac) ND;
                        a(acVar, baVar.lDk != null ? baVar.lDk : acVar.lDk, baVar.lDl != null ? baVar.lDl : acVar.lDl);
                        dhx();
                    } else if (ND instanceof SVG.aq) {
                        SVG.n nVar = baVar.lDk != null ? baVar.lDk : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lDl != null ? baVar.lDl : new SVG.n(100.0f, SVG.Unit.percent);
                        dhw();
                        a((SVG.aq) ND, nVar, nVar2);
                        dhx();
                    } else {
                        b(ND);
                    }
                    dhy();
                    if (dhz) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lDA != null) {
            a(this.lES, tVar);
            if (dhF() && dhG()) {
                if (this.lES.lFl || this.lES.lFk) {
                    if (tVar.lDh != null) {
                        this.lEO.concat(tVar.lDh);
                    }
                    Path bF = new C0643c(tVar.lDA).bF();
                    if (tVar.lEA == null) {
                        tVar.lEA = b(bF);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean dhz = dhz();
                    if (this.lES.lFk) {
                        bF.setFillType(dhH());
                        a(tVar, bF);
                    }
                    if (this.lES.lFl) {
                        a(bF);
                    }
                    a((SVG.j) tVar);
                    if (dhz) {
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
        if (zVar.lDk != null && zVar.lDl != null && !zVar.lDk.isZero() && !zVar.lDl.isZero()) {
            a(this.lES, zVar);
            if (dhF() && dhG()) {
                if (zVar.lDh != null) {
                    this.lEO.concat(zVar.lDh);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean dhz = dhz();
                if (this.lES.lFk) {
                    a(zVar, b2);
                }
                if (this.lES.lFl) {
                    a(b2);
                }
                if (dhz) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lCX != null && !cVar.lCX.isZero()) {
            a(this.lES, cVar);
            if (dhF() && dhG()) {
                if (cVar.lDh != null) {
                    this.lEO.concat(cVar.lDh);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean dhz = dhz();
                if (this.lES.lFk) {
                    a(cVar, b2);
                }
                if (this.lES.lFl) {
                    a(b2);
                }
                if (dhz) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lDc != null && hVar.lDd != null && !hVar.lDc.isZero() && !hVar.lDd.isZero()) {
            a(this.lES, hVar);
            if (dhF() && dhG()) {
                if (hVar.lDh != null) {
                    this.lEO.concat(hVar.lDh);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean dhz = dhz();
                if (this.lES.lFk) {
                    a(hVar, b2);
                }
                if (this.lES.lFl) {
                    a(b2);
                }
                if (dhz) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lES, oVar);
        if (dhF() && dhG() && this.lES.lFl) {
            if (oVar.lDh != null) {
                this.lEO.concat(oVar.lDh);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean dhz = dhz();
            a(c);
            a((SVG.j) oVar);
            if (dhz) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lDn != null ? oVar.lDn.a(this) : 0.0f;
        float b2 = oVar.lDo != null ? oVar.lDo.b(this) : 0.0f;
        float a3 = oVar.lDp != null ? oVar.lDp.a(this) : 0.0f;
        float b3 = oVar.lDq != null ? oVar.lDq.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lES, xVar);
        if (dhF() && dhG()) {
            if (this.lES.lFl || this.lES.lFk) {
                if (xVar.lDh != null) {
                    this.lEO.concat(xVar.lDh);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean dhz = dhz();
                    if (this.lES.lFk) {
                        a(xVar, c);
                    }
                    if (this.lES.lFl) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (dhz) {
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
        a(this.lES, yVar);
        if (dhF() && dhG()) {
            if (this.lES.lFl || this.lES.lFk) {
                if (yVar.lDh != null) {
                    this.lEO.concat(yVar.lDh);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean dhz = dhz();
                    if (this.lES.lFk) {
                        a(yVar, c);
                    }
                    if (this.lES.lFl) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (dhz) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lES, atVar);
        if (dhF()) {
            if (atVar.lDh != null) {
                this.lEO.concat(atVar.lDh);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lEM == null || atVar.lEM.size() == 0) ? 0.0f : atVar.lEM.get(0).a(this);
            if (atVar.lEN != null && atVar.lEN.size() != 0) {
                f2 = atVar.lEN.get(0).b(this);
            }
            SVG.Style.TextAnchor dhE = dhE();
            if (dhE != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (dhE == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lEA == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lEA = new SVG.a(hVar.lFp.left, hVar.lFp.top, hVar.lFp.width(), hVar.lFp.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean dhz = dhz();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (dhz) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor dhE() {
        if (this.lES.lCn.lEd == SVG.Style.TextDirection.LTR || this.lES.lCn.lEe == SVG.Style.TextAnchor.Middle) {
            return this.lES.lCn.lEe;
        }
        return this.lES.lCn.lEe == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
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
            if (c.this.dhG()) {
                if (c.this.lES.lFk) {
                    c.this.lEO.drawText(str, this.x, this.y, c.this.lES.jE);
                }
                if (c.this.lES.lFl) {
                    c.this.lEO.drawText(str, this.x, this.y, c.this.lES.jF);
                }
            }
            this.x += c.this.lES.jE.measureText(str);
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
        if (dhF()) {
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
                dhw();
                a((SVG.aw) akVar);
                dhx();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                dhw();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lES, asVar);
                if (dhF()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lEM == null || asVar.lEM.size() == 0) ? 0.0f : asVar.lEM.get(0).a(this);
                        if (asVar.lEN != null && asVar.lEN.size() != 0) {
                            f5 = asVar.lEN.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.dhr());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean dhz = dhz();
                    a((SVG.av) asVar, iVar);
                    if (dhz) {
                        b((SVG.ah) asVar);
                    }
                }
                dhx();
            } else if (akVar instanceof SVG.ar) {
                dhw();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lES, arVar);
                if (dhF()) {
                    c((SVG.ah) arVar.dhr());
                    SVG.ak ND = akVar.lEE.ND(arVar.RC);
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
                dhx();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lES, awVar);
        if (dhF() && dhG()) {
            SVG.ak ND = awVar.lEE.ND(awVar.RC);
            if (ND == null) {
                k("TextPath reference '%s' not found", awVar.RC);
                return;
            }
            SVG.t tVar = (SVG.t) ND;
            Path bF = new C0643c(tVar.lDA).bF();
            if (tVar.lDh != null) {
                bF.transform(tVar.lDh);
            }
            float a2 = awVar.lEL != null ? awVar.lEL.a(this, new PathMeasure(bF, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor dhE = dhE();
            if (dhE != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (dhE == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.dhr());
            boolean dhz = dhz();
            a((SVG.av) awVar, (i) new d(bF, f2, 0.0f));
            if (dhz) {
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
            if (c.this.dhG()) {
                if (c.this.lES.lFk) {
                    c.this.lEO.drawTextOnPath(str, this.path, this.x, this.y, c.this.lES.jE);
                }
                if (c.this.lES.lFl) {
                    c.this.lEO.drawTextOnPath(str, this.path, this.x, this.y, c.this.lES.jF);
                }
            }
            this.x += c.this.lES.jE.measureText(str);
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
            this.x += c.this.lES.jE.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class h extends i {
        RectF lFp;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lFp = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak ND = avVar.lEE.ND(awVar.RC);
                if (ND == null) {
                    c.k("TextPath path reference '%s' not found", awVar.RC);
                    return false;
                }
                SVG.t tVar = (SVG.t) ND;
                Path bF = new C0643c(tVar.lDA).bF();
                if (tVar.lDh != null) {
                    bF.transform(tVar.lDh);
                }
                RectF rectF = new RectF();
                bF.computeBounds(rectF, true);
                this.lFp.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void NH(String str) {
            if (c.this.dhG()) {
                Rect rect = new Rect();
                c.this.lES.jE.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lFp.union(rectF);
            }
            this.x += c.this.lES.jE.measureText(str);
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
        if (this.lES.lFn) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lEG != null ? aqVar.lEG : PreserveAspectRatio.lCC;
                a(this.lES, aqVar);
                this.lES.lFm = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lES.lFm.width, nVar2 != null ? nVar2.a(this) : this.lES.lFm.height);
                if (!this.lES.lCn.lEf.booleanValue()) {
                    m(this.lES.lFm.lCP, this.lES.lFm.lCQ, this.lES.lFm.width, this.lES.lFm.height);
                }
                if (aqVar.lEJ != null) {
                    this.lEO.concat(a(this.lES.lFm, aqVar.lEJ, preserveAspectRatio));
                    this.lES.lEJ = aqVar.lEJ;
                }
                boolean dhz = dhz();
                a((SVG.ag) aqVar, true);
                if (dhz) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lDk != null && !mVar.lDk.isZero() && mVar.lDl != null && !mVar.lDl.isZero() && mVar.RC != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lEG != null ? mVar.lEG : PreserveAspectRatio.lCC;
            Bitmap NG = NG(mVar.RC);
            if (NG == null) {
                com.caverock.androidsvg.d dhg = this.lEE.dhg();
                if (dhg != null) {
                    bitmap = dhg.NI(mVar.RC);
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
            a(this.lES, mVar);
            if (dhF() && dhG()) {
                if (mVar.lDh != null) {
                    this.lEO.concat(mVar.lDh);
                }
                this.lES.lFm = new SVG.a(mVar.lDi != null ? mVar.lDi.a(this) : 0.0f, mVar.lDj != null ? mVar.lDj.b(this) : 0.0f, mVar.lDk.a(this), mVar.lDl.a(this));
                if (!this.lES.lCn.lEf.booleanValue()) {
                    m(this.lES.lFm.lCP, this.lES.lFm.lCQ, this.lES.lFm.width, this.lES.lFm.height);
                }
                mVar.lEA = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lEO.concat(a(this.lES.lFm, mVar.lEA, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean dhz = dhz();
                dhI();
                this.lEO.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (dhz) {
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

    private boolean dhF() {
        if (this.lES.lCn.lEk != null) {
            return this.lES.lCn.lEk.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhG() {
        if (this.lES.lCn.lEl != null) {
            return this.lES.lCn.lEl.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.dha() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lCP;
        float f5 = -aVar2.lCQ;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lCB)) {
            matrix.preTranslate(aVar.lCP, aVar.lCQ);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dhb() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.dha()) {
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
        switch (preserveAspectRatio.dha()) {
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
        matrix.preTranslate(aVar.lCP, aVar.lCQ);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lDK & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lCn.lDX = style.lDX;
        }
        if (a(style, 2048L)) {
            gVar.lCn.lDW = style.lDW;
        }
        if (a(style, 1L)) {
            gVar.lCn.lDL = style.lDL;
            gVar.lFk = style.lDL != null;
        }
        if (a(style, 4L)) {
            gVar.lCn.lDN = style.lDN;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lCn.lDL);
        }
        if (a(style, 2L)) {
            gVar.lCn.lDM = style.lDM;
        }
        if (a(style, 8L)) {
            gVar.lCn.lDO = style.lDO;
            gVar.lFl = style.lDO != null;
        }
        if (a(style, 16L)) {
            gVar.lCn.lDP = style.lDP;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lCn.lDO);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lCn.lEu = style.lEu;
        }
        if (a(style, 32L)) {
            gVar.lCn.lDQ = style.lDQ;
            gVar.jF.setStrokeWidth(gVar.lCn.lDQ.c(this));
        }
        if (a(style, 64L)) {
            gVar.lCn.lDR = style.lDR;
            switch (style.lDR) {
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
            gVar.lCn.lDS = style.lDS;
            switch (style.lDS) {
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
            gVar.lCn.lDT = style.lDT;
            gVar.jF.setStrokeMiter(style.lDT.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lCn.lDU = style.lDU;
        }
        if (a(style, 1024L)) {
            gVar.lCn.lDV = style.lDV;
        }
        if (a(style, 1536L)) {
            if (gVar.lCn.lDU == null) {
                gVar.jF.setPathEffect(null);
            } else {
                int length = gVar.lCn.lDU.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lCn.lDU[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jF.setPathEffect(null);
                } else {
                    float c = gVar.lCn.lDV.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jF.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float dht = dht();
            gVar.lCn.lDZ = style.lDZ;
            gVar.jE.setTextSize(style.lDZ.a(this, dht));
            gVar.jF.setTextSize(style.lDZ.a(this, dht));
        }
        if (a(style, 8192L)) {
            gVar.lCn.lDY = style.lDY;
        }
        if (a(style, 32768L)) {
            if (style.lEa.intValue() == -1 && gVar.lCn.lEa.intValue() > 100) {
                gVar.lCn.lEa = Integer.valueOf(style2.lEa.intValue() - 100);
            } else if (style.lEa.intValue() == 1 && gVar.lCn.lEa.intValue() < 900) {
                SVG.Style style3 = gVar.lCn;
                style3.lEa = Integer.valueOf(style3.lEa.intValue() + 100);
            } else {
                gVar.lCn.lEa = style.lEa;
            }
        }
        if (a(style, 65536L)) {
            gVar.lCn.lEb = style.lEb;
        }
        if (a(style, 106496L)) {
            if (gVar.lCn.lDY == null || this.lEE == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d dhg = this.lEE.dhg();
                typeface = null;
                for (String str : gVar.lCn.lDY) {
                    Typeface a2 = a(str, gVar.lCn.lEa, gVar.lCn.lEb);
                    if (a2 != null || dhg == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = dhg.w(str, gVar.lCn.lEa.intValue(), String.valueOf(gVar.lCn.lEb));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lCn.lEa, gVar.lCn.lEb);
            }
            gVar.jE.setTypeface(typeface);
            gVar.jF.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lCn.lEc = style.lEc;
            gVar.jE.setStrikeThruText(style.lEc == SVG.Style.TextDecoration.LineThrough);
            gVar.jE.setUnderlineText(style.lEc == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jF.setStrikeThruText(style.lEc == SVG.Style.TextDecoration.LineThrough);
                gVar.jF.setUnderlineText(style.lEc == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lCn.lEd = style.lEd;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lCn.lEe = style.lEe;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lCn.lEf = style.lEf;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lCn.lEh = style.lEh;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lCn.lEi = style.lEi;
        }
        if (a(style, 8388608L)) {
            gVar.lCn.lEj = style.lEj;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lCn.lEk = style.lEk;
        }
        if (a(style, 33554432L)) {
            gVar.lCn.lEl = style.lEl;
        }
        if (a(style, 1048576L)) {
            gVar.lCn.lEg = style.lEg;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lCn.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lCn.lEo = style.lEo;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lCn.lEp = style.lEp;
        }
        if (a(style, 67108864L)) {
            gVar.lCn.lEm = style.lEm;
        }
        if (a(style, 134217728L)) {
            gVar.lCn.lEn = style.lEn;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lCn.lEs = style.lEs;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lCn.lEt = style.lEt;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lCn.lDN : gVar.lCn.lDP).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lCZ;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lCn.lDX.lCZ;
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

    private Path.FillType dhH() {
        if (this.lES.lCn.lDM == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lES.lCn.lDM) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lES.lCn.lEg != null) {
            f2 += this.lES.lCn.lEg.lCU.a(this);
            f3 += this.lES.lCn.lEg.lCR.b(this);
            f6 -= this.lES.lCn.lEg.lCS.a(this);
            f7 -= this.lES.lCn.lEg.lCT.b(this);
        }
        this.lEO.clipRect(f2, f3, f6, f7);
    }

    private void dhI() {
        int i2;
        if (this.lES.lCn.lEs instanceof SVG.e) {
            i2 = ((SVG.e) this.lES.lCn.lEs).lCZ;
        } else if (this.lES.lCn.lEs instanceof SVG.f) {
            i2 = this.lES.lCn.lDX.lCZ;
        } else {
            return;
        }
        if (this.lES.lCn.lEt != null) {
            i2 |= bi(this.lES.lCn.lEt.floatValue()) << 24;
        }
        this.lEO.drawColor(i2);
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
        private b lFd = null;
        private boolean lFe = false;
        private boolean lFf = true;
        private int lFg = -1;
        private boolean lFh;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lFh) {
                    this.lFd.a(this.bvD.get(this.lFg));
                    this.bvD.set(this.lFg, this.lFd);
                    this.lFh = false;
                }
                if (this.lFd != null) {
                    this.bvD.add(this.lFd);
                }
            }
        }

        public List<b> dhM() {
            return this.bvD;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lFh) {
                this.lFd.a(this.bvD.get(this.lFg));
                this.bvD.set(this.lFg, this.lFd);
                this.lFh = false;
            }
            if (this.lFd != null) {
                this.bvD.add(this.lFd);
            }
            this.startX = f;
            this.startY = f2;
            this.lFd = new b(f, f2, 0.0f, 0.0f);
            this.lFg = this.bvD.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lFd.C(f, f2);
            this.bvD.add(this.lFd);
            this.lFd = new b(f, f2, f - this.lFd.x, f2 - this.lFd.y);
            this.lFh = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lFf || this.lFe) {
                this.lFd.C(f, f2);
                this.bvD.add(this.lFd);
                this.lFe = false;
            }
            this.lFd = new b(f5, f6, f5 - f3, f6 - f4);
            this.lFh = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lFd.C(f, f2);
            this.bvD.add(this.lFd);
            this.lFd = new b(f3, f4, f3 - f, f4 - f2);
            this.lFh = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lFe = true;
            this.lFf = false;
            c.a(this.lFd.x, this.lFd.y, f, f2, f3, z, z2, f4, f5, this);
            this.lFf = true;
            this.lFh = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.bvD.add(this.lFd);
            B(this.startX, this.startY);
            this.lFh = true;
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
        if (this.lES.lCn.lEh != null || this.lES.lCn.lEi != null || this.lES.lCn.lEj != null) {
            if (this.lES.lCn.lEh != null) {
                SVG.ak ND = jVar.lEE.ND(this.lES.lCn.lEh);
                if (ND != null) {
                    pVar = (SVG.p) ND;
                    if (this.lES.lCn.lEi != null) {
                        SVG.ak ND2 = jVar.lEE.ND(this.lES.lCn.lEi);
                        if (ND2 != null) {
                            pVar2 = (SVG.p) ND2;
                            if (this.lES.lCn.lEj != null) {
                                SVG.ak ND3 = jVar.lEE.ND(this.lES.lCn.lEj);
                                if (ND3 != null) {
                                    pVar3 = (SVG.p) ND3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lDA).dhM();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lES.lCn;
                                        SVG.Style style2 = this.lES.lCn;
                                        this.lES.lCn.lEj = null;
                                        style2.lEi = null;
                                        style.lEh = null;
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
                                k("Marker reference '%s' not found", this.lES.lCn.lEj);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lES.lCn.lEi);
                    }
                    pVar2 = null;
                    if (this.lES.lCn.lEj != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lES.lCn.lEh);
                }
            }
            pVar = null;
            if (this.lES.lCn.lEi != null) {
            }
            pVar2 = null;
            if (this.lES.lCn.lEj != null) {
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
        boolean dhz;
        float f3;
        float f4 = 0.0f;
        dhw();
        if (pVar.lDw != null) {
            if (Float.isNaN(pVar.lDw.floatValue())) {
                if (bVar.gpX != 0.0f || bVar.gpY != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.gpY, bVar.gpX));
                }
            } else {
                f2 = pVar.lDw.floatValue();
            }
            float bh = !pVar.lDr ? 1.0f : this.lES.lCn.lDQ.bh(this.lEQ);
            this.lES = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bh, bh);
            float a2 = pVar.lDs == null ? pVar.lDs.a(this) : 0.0f;
            float b2 = pVar.lDt == null ? pVar.lDt.b(this) : 0.0f;
            float a3 = pVar.lDu == null ? pVar.lDu.a(this) : 3.0f;
            float b3 = pVar.lDv != null ? pVar.lDv.b(this) : 3.0f;
            if (pVar.lEJ == null) {
                float f5 = a3 / pVar.lEJ.width;
                float f6 = b3 / pVar.lEJ.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lEG != null ? pVar.lEG : PreserveAspectRatio.lCC;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lCB)) {
                    f6 = preserveAspectRatio.dhb() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lEO.concat(matrix);
                float f7 = pVar.lEJ.width * f5;
                float f8 = pVar.lEJ.height * f6;
                switch (preserveAspectRatio.dha()) {
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
                switch (preserveAspectRatio.dha()) {
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
                if (!this.lES.lCn.lEf.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lEO.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lEO.concat(matrix);
                if (!this.lES.lCn.lEf.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            dhz = dhz();
            a((SVG.ag) pVar, false);
            if (dhz) {
                b((SVG.ah) pVar);
            }
            dhx();
        }
        f2 = 0.0f;
        if (!pVar.lDr) {
        }
        this.lES = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bh, bh);
        if (pVar.lDs == null) {
        }
        if (pVar.lDt == null) {
        }
        if (pVar.lDu == null) {
        }
        if (pVar.lDv != null) {
        }
        if (pVar.lEJ == null) {
        }
        dhz = dhz();
        a((SVG.ag) pVar, false);
        if (dhz) {
        }
        dhx();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.dhl());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lEF == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lEF;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lEJ = this.lEE.dhd().lEJ;
        if (gVar.lEJ == null) {
            gVar.lEJ = this.lEP;
        }
        gVar.lFm = this.lEP;
        gVar.lFo = this.lES.lFo;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lES.lCn.lDL instanceof SVG.s) {
            a(true, ahVar.lEA, (SVG.s) this.lES.lCn.lDL);
        }
        if (this.lES.lCn.lDO instanceof SVG.s) {
            a(false, ahVar.lEA, (SVG.s) this.lES.lCn.lDO);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak ND = this.lEE.ND(sVar.RC);
        if (ND == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.RC;
            k("%s reference '%s' not found", objArr);
            if (sVar.lDz != null) {
                a(this.lES, z, sVar.lDz);
                return;
            } else if (z) {
                this.lES.lFk = false;
                return;
            } else {
                this.lES.lFl = false;
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
        boolean z2 = ajVar.lDe != null && ajVar.lDe.booleanValue();
        Paint paint = z ? this.lES.jE : this.lES.jF;
        if (z2) {
            SVG.a dhv = dhv();
            float a3 = ajVar.lDn != null ? ajVar.lDn.a(this) : 0.0f;
            float b2 = ajVar.lDo != null ? ajVar.lDo.b(this) : 0.0f;
            float a4 = ajVar.lDp != null ? ajVar.lDp.a(this) : dhv.width;
            a2 = ajVar.lDq != null ? ajVar.lDq.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lDn != null ? ajVar.lDn.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lDo != null ? ajVar.lDo.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lDp != null ? ajVar.lDp.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lDq != null ? ajVar.lDq.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        dhw();
        this.lES = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lCP, aVar.lCQ);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lDf != null) {
            matrix.preConcat(ajVar.lDf);
        }
        int size = ajVar.SW.size();
        if (size == 0) {
            dhx();
            if (z) {
                this.lES.lFk = false;
                return;
            } else {
                this.lES.lFl = false;
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
            if (i2 == 0 || abVar.lDJ.floatValue() >= f5) {
                fArr[i2] = abVar.lDJ.floatValue();
                f5 = abVar.lDJ.floatValue();
            } else {
                fArr[i2] = f5;
            }
            dhw();
            a(this.lES, abVar);
            SVG.e eVar = (SVG.e) this.lES.lCn.lEm;
            if (eVar == null) {
                eVar = SVG.e.lDa;
            }
            iArr[i2] = eVar.lCZ | (bi(this.lES.lCn.lEn.floatValue()) << 24);
            dhx();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            dhx();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lDg != null) {
            if (ajVar.lDg == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lDg == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dhx();
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
        boolean z2 = anVar.lDe != null && anVar.lDe.booleanValue();
        Paint paint = z ? this.lES.jE : this.lES.jF;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lCV != null ? anVar.lCV.a(this) : nVar.a(this);
            float b2 = anVar.lCW != null ? anVar.lCW.b(this) : nVar.b(this);
            a2 = anVar.lCX != null ? anVar.lCX.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lCV != null ? anVar.lCV.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lCW != null ? anVar.lCW.a(this, 1.0f) : 0.5f;
            a2 = anVar.lCX != null ? anVar.lCX.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        dhw();
        this.lES = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lCP, aVar.lCQ);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lDf != null) {
            matrix.preConcat(anVar.lDf);
        }
        int size = anVar.SW.size();
        if (size == 0) {
            dhx();
            if (z) {
                this.lES.lFk = false;
                return;
            } else {
                this.lES.lFl = false;
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
            if (i2 == 0 || abVar.lDJ.floatValue() >= f4) {
                fArr[i2] = abVar.lDJ.floatValue();
                f4 = abVar.lDJ.floatValue();
            } else {
                fArr[i2] = f4;
            }
            dhw();
            a(this.lES, abVar);
            SVG.e eVar = (SVG.e) this.lES.lCn.lEm;
            if (eVar == null) {
                eVar = SVG.e.lDa;
            }
            iArr[i2] = eVar.lCZ | (bi(this.lES.lCn.lEn.floatValue()) << 24);
            dhx();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            dhx();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lDg != null) {
            if (anVar.lDg == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lDg == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dhx();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak ND = iVar.lEE.ND(str);
        if (ND == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(ND instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (ND == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) ND;
            if (iVar.lDe == null) {
                iVar.lDe = iVar2.lDe;
            }
            if (iVar.lDf == null) {
                iVar.lDf = iVar2.lDf;
            }
            if (iVar.lDg == null) {
                iVar.lDg = iVar2.lDg;
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
        if (ajVar.lDn == null) {
            ajVar.lDn = ajVar2.lDn;
        }
        if (ajVar.lDo == null) {
            ajVar.lDo = ajVar2.lDo;
        }
        if (ajVar.lDp == null) {
            ajVar.lDp = ajVar2.lDp;
        }
        if (ajVar.lDq == null) {
            ajVar.lDq = ajVar2.lDq;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lCV == null) {
            anVar.lCV = anVar2.lCV;
        }
        if (anVar.lCW == null) {
            anVar.lCW = anVar2.lCW;
        }
        if (anVar.lCX == null) {
            anVar.lCX = anVar2.lCX;
        }
        if (anVar.lEH == null) {
            anVar.lEH = anVar2.lEH;
        }
        if (anVar.lEI == null) {
            anVar.lEI = anVar2.lEI;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lEC, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lES.lCn.lDL = aaVar.lEC.lEq;
                this.lES.lFk = aaVar.lEC.lEq != null;
            }
            if (a(aaVar.lEC, 4294967296L)) {
                this.lES.lCn.lDN = aaVar.lEC.lEr;
            }
            if (a(aaVar.lEC, 6442450944L)) {
                a(this.lES, z, this.lES.lCn.lDL);
                return;
            }
            return;
        }
        if (a(aaVar.lEC, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lES.lCn.lDO = aaVar.lEC.lEq;
            this.lES.lFl = aaVar.lEC.lEq != null;
        }
        if (a(aaVar.lEC, 4294967296L)) {
            this.lES.lCn.lDP = aaVar.lEC.lEr;
        }
        if (a(aaVar.lEC, 6442450944L)) {
            a(this.lES, z, this.lES.lCn.lDO);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lEA);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lES.lCn.clipPath != null) {
            SVG.ak ND = ahVar.lEE.ND(this.lES.lCn.clipPath);
            if (ND == null) {
                k("ClipPath reference '%s' not found", this.lES.lCn.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) ND;
            if (dVar.SW.isEmpty()) {
                this.lEO.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lCY == null || dVar.lCY.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            dhJ();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lCP, aVar.lCQ);
                matrix.preScale(aVar.width, aVar.height);
                this.lEO.concat(matrix);
            }
            if (dVar.lDh != null) {
                this.lEO.concat(dVar.lDh);
            }
            this.lES = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.SW) {
                a(akVar, true, path, new Matrix());
            }
            this.lEO.clipPath(path);
            dhK();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (dhF()) {
            dhJ();
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
            dhK();
        }
    }

    private void dhJ() {
        this.lEO.save();
        this.lET.push(this.lES);
        this.lES = (g) this.lES.clone();
    }

    private void dhK() {
        this.lEO.restore();
        this.lES = this.lET.pop();
    }

    private Path.FillType dhL() {
        if (this.lES.lCn.lEo == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lES.lCn.lEo) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lES, tVar);
        if (dhF() && dhG()) {
            if (tVar.lDh != null) {
                matrix.preConcat(tVar.lDh);
            }
            Path bF = new C0643c(tVar.lDA).bF();
            if (tVar.lEA == null) {
                tVar.lEA = b(bF);
            }
            d((SVG.ah) tVar);
            path.setFillType(dhL());
            path.addPath(bF, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lES, jVar);
        if (dhF() && dhG()) {
            if (jVar.lDh != null) {
                matrix.preConcat(jVar.lDh);
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
        a(this.lES, baVar);
        if (dhF() && dhG()) {
            if (baVar.lDh != null) {
                matrix.preConcat(baVar.lDh);
            }
            SVG.ak ND = baVar.lEE.ND(baVar.RC);
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
        a(this.lES, atVar);
        if (dhF()) {
            if (atVar.lDh != null) {
                matrix.preConcat(atVar.lDh);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lEM == null || atVar.lEM.size() == 0) ? 0.0f : atVar.lEM.get(0).a(this);
            if (atVar.lEN != null && atVar.lEN.size() != 0) {
                f2 = atVar.lEN.get(0).b(this);
            }
            if (this.lES.lCn.lEe != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lES.lCn.lEe == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lEA == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lEA = new SVG.a(hVar.lFp.left, hVar.lFp.top, hVar.lFp.width(), hVar.lFp.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(dhL());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class f extends i {
        public Path lFj;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lFj = path;
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
            if (c.this.dhG()) {
                Path path = new Path();
                c.this.lES.jE.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lFj.addPath(path);
            }
            this.x += c.this.lES.jE.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lDn == null ? 0.0f : oVar.lDn.a(this);
        float b2 = oVar.lDo == null ? 0.0f : oVar.lDo.b(this);
        float a3 = oVar.lDp == null ? 0.0f : oVar.lDp.a(this);
        float b3 = oVar.lDq != null ? oVar.lDq.b(this) : 0.0f;
        if (oVar.lEA == null) {
            oVar.lEA = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lDc == null && zVar.lDd == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lDc == null) {
            b2 = zVar.lDd.b(this);
            a2 = b2;
        } else if (zVar.lDd == null) {
            b2 = zVar.lDc.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lDc.a(this);
            b2 = zVar.lDd.b(this);
        }
        float min = Math.min(a2, zVar.lDk.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lDl.b(this) / 2.0f);
        float a3 = zVar.lDi != null ? zVar.lDi.a(this) : 0.0f;
        float b3 = zVar.lDj != null ? zVar.lDj.b(this) : 0.0f;
        float a4 = zVar.lDk.a(this);
        float b4 = zVar.lDl.b(this);
        if (zVar.lEA == null) {
            zVar.lEA = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lCV != null ? cVar.lCV.a(this) : 0.0f;
        float b2 = cVar.lCW != null ? cVar.lCW.b(this) : 0.0f;
        float c = cVar.lCX.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lEA == null) {
            cVar.lEA = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lCV != null ? hVar.lCV.a(this) : 0.0f;
        float b2 = hVar.lCW != null ? hVar.lCW.b(this) : 0.0f;
        float a3 = hVar.lDc.a(this);
        float b3 = hVar.lDd.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lEA == null) {
            hVar.lEA = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lEA == null) {
            xVar.lEA = b(path);
        }
        path.setFillType(dhL());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lDG != null && wVar.lDG.booleanValue();
        if (wVar.RC != null) {
            a(wVar, wVar.RC);
        }
        if (z) {
            float a2 = wVar.lDi != null ? wVar.lDi.a(this) : 0.0f;
            float b2 = wVar.lDj != null ? wVar.lDj.b(this) : 0.0f;
            float a3 = wVar.lDk != null ? wVar.lDk.a(this) : 0.0f;
            f2 = wVar.lDl != null ? wVar.lDl.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lDi != null ? wVar.lDi.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lDj != null ? wVar.lDj.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lDk != null ? wVar.lDk.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lDl != null ? wVar.lDl.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lEA.width) + ahVar.lEA.lCP;
            float f7 = (a5 * ahVar.lEA.height) + ahVar.lEA.lCQ;
            float f8 = a6 * ahVar.lEA.width;
            f2 = a7 * ahVar.lEA.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lEG != null ? wVar.lEG : PreserveAspectRatio.lCC;
            dhw();
            this.lEO.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.dhl());
            gVar.lCn.lEf = false;
            this.lES = a(wVar, gVar);
            SVG.a aVar = ahVar.lEA;
            if (wVar.lDI != null) {
                this.lEO.concat(wVar.lDI);
                Matrix matrix = new Matrix();
                if (wVar.lDI.invert(matrix)) {
                    float[] fArr = {ahVar.lEA.lCP, ahVar.lEA.lCQ, ahVar.lEA.dhh(), ahVar.lEA.lCQ, ahVar.lEA.dhh(), ahVar.lEA.dhi(), ahVar.lEA.lCP, ahVar.lEA.dhi()};
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
            float floor = f5 + (((float) Math.floor((aVar.lCP - f5) / f3)) * f3);
            float dhh = aVar.dhh();
            float dhi = aVar.dhi();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lCQ - f4) / f2)) * f2); floor2 < dhi; floor2 += f2) {
                for (float f9 = floor; f9 < dhh; f9 += f3) {
                    aVar2.lCP = f9;
                    aVar2.lCQ = floor2;
                    dhw();
                    if (!this.lES.lCn.lEf.booleanValue()) {
                        m(aVar2.lCP, aVar2.lCQ, aVar2.width, aVar2.height);
                    }
                    if (wVar.lEJ != null) {
                        this.lEO.concat(a(aVar2, wVar.lEJ, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lDH == null || wVar.lDH.booleanValue();
                        this.lEO.translate(f9, floor2);
                        if (!z2) {
                            this.lEO.scale(ahVar.lEA.width, ahVar.lEA.height);
                        }
                    }
                    boolean dhz = dhz();
                    for (SVG.ak akVar : wVar.SW) {
                        b(akVar);
                    }
                    if (dhz) {
                        b((SVG.ah) wVar);
                    }
                    dhx();
                }
            }
            dhx();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak ND = wVar.lEE.ND(str);
        if (ND == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(ND instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (ND == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) ND;
            if (wVar.lDG == null) {
                wVar.lDG = wVar2.lDG;
            }
            if (wVar.lDH == null) {
                wVar.lDH = wVar2.lDH;
            }
            if (wVar.lDI == null) {
                wVar.lDI = wVar2.lDI;
            }
            if (wVar.lDi == null) {
                wVar.lDi = wVar2.lDi;
            }
            if (wVar.lDj == null) {
                wVar.lDj = wVar2.lDj;
            }
            if (wVar.lDk == null) {
                wVar.lDk = wVar2.lDk;
            }
            if (wVar.lDl == null) {
                wVar.lDl = wVar2.lDl;
            }
            if (wVar.SW.isEmpty()) {
                wVar.SW = wVar2.SW;
            }
            if (wVar.lEJ == null) {
                wVar.lEJ = wVar2.lEJ;
            }
            if (wVar.lEG == null) {
                wVar.lEG = wVar2.lEG;
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
        if (qVar.lDx != null && qVar.lDx.booleanValue()) {
            f2 = qVar.lDk != null ? qVar.lDk.a(this) : ahVar.lEA.width;
            f3 = qVar.lDl != null ? qVar.lDl.b(this) : ahVar.lEA.height;
            if (qVar.lDi != null) {
                qVar.lDi.a(this);
            } else {
                float f4 = (float) (ahVar.lEA.lCP - (ahVar.lEA.width * 0.1d));
            }
            if (qVar.lDj != null) {
                qVar.lDj.b(this);
            } else {
                float f5 = (float) (ahVar.lEA.lCQ - (ahVar.lEA.height * 0.1d));
            }
        } else {
            float a2 = qVar.lDi != null ? qVar.lDi.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lDj != null ? qVar.lDj.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lDk != null ? qVar.lDk.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lDl != null ? qVar.lDl.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lEA.width) + ahVar.lEA.lCP;
            float f7 = ahVar.lEA.lCQ + (a3 * ahVar.lEA.height);
            f2 = ahVar.lEA.width * a4;
            f3 = ahVar.lEA.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            dhw();
            this.lES = d((SVG.ak) qVar);
            this.lES.lCn.lDW = Float.valueOf(1.0f);
            if (!(qVar.lDy == null || qVar.lDy.booleanValue())) {
                this.lEO.translate(ahVar.lEA.lCP, ahVar.lEA.lCQ);
                this.lEO.scale(ahVar.lEA.width, ahVar.lEA.height);
            }
            a((SVG.ag) qVar, false);
            dhx();
        }
    }
}
