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
/* loaded from: classes9.dex */
public class c {
    private static HashSet<String> lBv = null;
    private SVG lBb;
    private Canvas lBl;
    private SVG.a lBm;
    private float lBn;
    private boolean lBo;
    private g lBp;
    private Stack<g> lBq;
    private Stack<SVG.ag> lBr;
    private Stack<Matrix> lBs;
    private Stack<Canvas> lBt;
    private Stack<Bitmap> lBu;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class g implements Cloneable {
        public Paint jF = new Paint();
        public Paint jG;
        public boolean lBH;
        public boolean lBI;
        public SVG.a lBJ;
        public boolean lBK;
        public boolean lBL;
        public SVG.a lBg;
        public SVG.Style lyK;

        public g() {
            this.jF.setFlags(385);
            this.jF.setStyle(Paint.Style.FILL);
            this.jF.setTypeface(Typeface.DEFAULT);
            this.jG = new Paint();
            this.jG.setFlags(385);
            this.jG.setStyle(Paint.Style.STROKE);
            this.jG.setTypeface(Typeface.DEFAULT);
            this.lyK = SVG.Style.dgh();
        }

        protected Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.lyK = (SVG.Style) this.lyK.clone();
                gVar.jF = new Paint(this.jF);
                gVar.jG = new Paint(this.jG);
                return gVar;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.lBp = new g();
        this.lBq = new Stack<>();
        a(this.lBp, SVG.Style.dgh());
        this.lBp.lBJ = this.lBm;
        this.lBp.lBK = false;
        this.lBp.lBL = this.lBo;
        this.lBq.push((g) this.lBp.clone());
        this.lBt = new Stack<>();
        this.lBu = new Stack<>();
        this.lBs = new Stack<>();
        this.lBr = new Stack<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Canvas canvas, SVG.a aVar, float f2) {
        this.lBl = canvas;
        this.lBn = f2;
        this.lBm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dgo() {
        return this.lBn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dgp() {
        return this.lBp.jF.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float dgq() {
        return this.lBp.jF.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.a dgr() {
        return this.lBp.lBg != null ? this.lBp.lBg : this.lBp.lBJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.lBb = svg;
        this.lBo = z;
        SVG.ac dfZ = svg.dfZ();
        if (dfZ == null) {
            j("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        c((SVG.ak) dfZ);
        a(dfZ, dfZ.lzH, dfZ.lzI, aVar != null ? aVar : dfZ.lBg, preserveAspectRatio != null ? preserveAspectRatio : dfZ.lBd);
    }

    private void b(SVG.ak akVar) {
        if (!(akVar instanceof SVG.r)) {
            dgs();
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
            dgt();
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
            dgu();
        }
    }

    private void dgs() {
        this.lBl.save();
        this.lBq.push(this.lBp);
        this.lBp = (g) this.lBp.clone();
    }

    private void dgt() {
        this.lBl.restore();
        this.lBp = this.lBq.pop();
    }

    private void a(SVG.ag agVar) {
        this.lBr.push(agVar);
        this.lBs.push(this.lBl.getMatrix());
    }

    private void dgu() {
        this.lBr.pop();
        this.lBs.pop();
    }

    private void a(g gVar, SVG.ai aiVar) {
        gVar.lyK.uJ(aiVar.lBc == null);
        if (aiVar.lAZ != null) {
            a(gVar, aiVar.lAZ);
        }
        if (this.lBb.dgb()) {
            for (CSSParser.c cVar : this.lBb.dga()) {
                if (CSSParser.a(cVar.lyJ, aiVar)) {
                    a(gVar, cVar.lyK);
                }
            }
        }
        if (aiVar.lyK != null) {
            a(gVar, aiVar.lyK);
        }
    }

    private void c(SVG.ak akVar) {
        if (akVar instanceof SVG.ai) {
            SVG.ai aiVar = (SVG.ai) akVar;
            if (aiVar.lAY != null) {
                this.lBp.lBK = aiVar.lAY.booleanValue();
            }
        }
    }

    private void a(SVG.ah ahVar, Path path) {
        if (this.lBp.lyK.lAi instanceof SVG.s) {
            SVG.ak Nt = this.lBb.Nt(((SVG.s) this.lBp.lyK.lAi).Rz);
            if (Nt instanceof SVG.w) {
                a(ahVar, path, (SVG.w) Nt);
                return;
            }
        }
        this.lBl.drawPath(path, this.lBp.jF);
    }

    private void a(Path path) {
        if (this.lBp.lyK.lAR == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.lBl.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.lBl.setMatrix(new Matrix());
            Shader shader = this.lBp.jG.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.lBl.drawPath(path2, this.lBp.jG);
            this.lBl.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.lBl.drawPath(path, this.lBp.jG);
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
        a(acVar, acVar.lzH, acVar.lzI);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2) {
        a(acVar, nVar, nVar2, acVar.lBg, acVar.lBd);
    }

    private void a(SVG.ac acVar, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        PreserveAspectRatio preserveAspectRatio2;
        float f2;
        float f3 = 0.0f;
        debug("Svg render", new Object[0]);
        if (nVar == null || !nVar.isZero()) {
            if (nVar2 == null || !nVar2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio2 = acVar.lBd != null ? acVar.lBd : PreserveAspectRatio.lyZ;
                } else {
                    preserveAspectRatio2 = preserveAspectRatio;
                }
                a(this.lBp, acVar);
                if (dgB()) {
                    if (acVar.lBc != null) {
                        f2 = acVar.lzF != null ? acVar.lzF.a(this) : 0.0f;
                        if (acVar.lzG != null) {
                            f3 = acVar.lzG.b(this);
                        }
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a dgr = dgr();
                    this.lBp.lBJ = new SVG.a(f2, f3, nVar != null ? nVar.a(this) : dgr.width, nVar2 != null ? nVar2.b(this) : dgr.height);
                    if (!this.lBp.lyK.lAC.booleanValue()) {
                        m(this.lBp.lBJ.lzm, this.lBp.lBJ.lzn, this.lBp.lBJ.width, this.lBp.lBJ.height);
                    }
                    a(acVar, this.lBp.lBJ);
                    if (aVar != null) {
                        this.lBl.concat(a(this.lBp.lBJ, aVar, preserveAspectRatio2));
                        this.lBp.lBg = acVar.lBg;
                    } else {
                        this.lBl.translate(f2, f3);
                    }
                    boolean dgv = dgv();
                    dgE();
                    a((SVG.ag) acVar, true);
                    if (dgv) {
                        b((SVG.ah) acVar);
                    }
                    a((SVG.ah) acVar);
                }
            }
        }
    }

    private void a(SVG.k kVar) {
        debug("Group render", new Object[0]);
        a(this.lBp, kVar);
        if (dgB()) {
            if (kVar.lzE != null) {
                this.lBl.concat(kVar.lzE);
            }
            d((SVG.ah) kVar);
            boolean dgv = dgv();
            a((SVG.ag) kVar, true);
            if (dgv) {
                b((SVG.ah) kVar);
            }
            a((SVG.ah) kVar);
        }
    }

    private void a(SVG.ah ahVar) {
        if (ahVar.lBc != null && ahVar.lAX != null) {
            Matrix matrix = new Matrix();
            if (this.lBs.peek().invert(matrix)) {
                float[] fArr = {ahVar.lAX.lzm, ahVar.lAX.lzn, ahVar.lAX.dgd(), ahVar.lAX.lzn, ahVar.lAX.dgd(), ahVar.lAX.dge(), ahVar.lAX.lzm, ahVar.lAX.dge()};
                matrix.preConcat(this.lBl.getMatrix());
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
                SVG.ah ahVar2 = (SVG.ah) this.lBr.peek();
                if (ahVar2.lAX == null) {
                    ahVar2.lAX = SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    ahVar2.lAX.a(SVG.a.k(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private boolean dgv() {
        if (dgw()) {
            this.lBl.saveLayerAlpha(null, bj(this.lBp.lyK.lAt.floatValue()), 31);
            this.lBq.push(this.lBp);
            this.lBp = (g) this.lBp.clone();
            if (this.lBp.lyK.lAM != null && this.lBp.lBL) {
                SVG.ak Nt = this.lBb.Nt(this.lBp.lyK.lAM);
                if (Nt == null || !(Nt instanceof SVG.q)) {
                    k("Mask reference '%s' not found", this.lBp.lyK.lAM);
                    this.lBp.lyK.lAM = null;
                    return true;
                }
                this.lBt.push(this.lBl);
                dgx();
            }
            return true;
        }
        return false;
    }

    private void b(SVG.ah ahVar) {
        if (this.lBp.lyK.lAM != null && this.lBp.lBL) {
            SVG.ak Nt = this.lBb.Nt(this.lBp.lyK.lAM);
            dgx();
            a((SVG.q) Nt, ahVar);
            Bitmap dgy = dgy();
            this.lBl = this.lBt.pop();
            this.lBl.save();
            this.lBl.setMatrix(new Matrix());
            this.lBl.drawBitmap(dgy, 0.0f, 0.0f, this.lBp.jF);
            dgy.recycle();
            this.lBl.restore();
        }
        dgt();
    }

    private boolean dgw() {
        if (this.lBp.lyK.lAM != null && !this.lBp.lBL) {
            j("Masks are not supported when using getPicture()", new Object[0]);
        }
        return this.lBp.lyK.lAt.floatValue() < 1.0f || (this.lBp.lyK.lAM != null && this.lBp.lBL);
    }

    private void dgx() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.lBl.getWidth(), this.lBl.getHeight(), Bitmap.Config.ARGB_8888);
            this.lBu.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.lBl.getMatrix());
            this.lBl = canvas;
        } catch (OutOfMemoryError e2) {
            k("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    private Bitmap dgy() {
        Bitmap pop = this.lBu.pop();
        Bitmap pop2 = this.lBu.pop();
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
        a(this.lBp, apVar);
        if (dgB()) {
            if (apVar.lzE != null) {
                this.lBl.concat(apVar.lzE);
            }
            d((SVG.ah) apVar);
            boolean dgv = dgv();
            b(apVar);
            if (dgv) {
                b((SVG.ah) apVar);
            }
            a((SVG.ah) apVar);
        }
    }

    private void b(SVG.ap apVar) {
        Set<String> dgk;
        String language = Locale.getDefault().getLanguage();
        com.caverock.androidsvg.d dgc = this.lBb.dgc();
        for (SVG.ak akVar : apVar.getChildren()) {
            if (akVar instanceof SVG.ad) {
                SVG.ad adVar = (SVG.ad) akVar;
                if (adVar.dgj() == null && ((dgk = adVar.dgk()) == null || (!dgk.isEmpty() && dgk.contains(language)))) {
                    Set<String> dgi = adVar.dgi();
                    if (dgi != null) {
                        if (lBv == null) {
                            dgz();
                        }
                        if (!dgi.isEmpty() && lBv.containsAll(dgi)) {
                        }
                    }
                    Set<String> dgl = adVar.dgl();
                    if (dgl != null) {
                        if (!dgl.isEmpty() && dgc != null) {
                            for (String str : dgl) {
                                if (!dgc.Nz(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    Set<String> dgm = adVar.dgm();
                    if (dgm != null) {
                        if (!dgm.isEmpty() && dgc != null) {
                            for (String str2 : dgm) {
                                if (dgc.w(str2, this.lBp.lyK.lAx.intValue(), String.valueOf(this.lBp.lyK.lAy)) == null) {
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

    private static synchronized void dgz() {
        synchronized (c.class) {
            lBv = new HashSet<>();
            lBv.add("Structure");
            lBv.add("BasicStructure");
            lBv.add("ConditionalProcessing");
            lBv.add("Image");
            lBv.add("Style");
            lBv.add("ViewportAttribute");
            lBv.add("Shape");
            lBv.add("BasicText");
            lBv.add("PaintAttribute");
            lBv.add("BasicPaintAttribute");
            lBv.add("OpacityAttribute");
            lBv.add("BasicGraphicsAttribute");
            lBv.add("Marker");
            lBv.add("Gradient");
            lBv.add("Pattern");
            lBv.add("Clip");
            lBv.add("BasicClip");
            lBv.add("Mask");
            lBv.add("View");
        }
    }

    private void a(SVG.ba baVar) {
        debug("Use render", new Object[0]);
        if (baVar.lzH == null || !baVar.lzH.isZero()) {
            if (baVar.lzI == null || !baVar.lzI.isZero()) {
                a(this.lBp, baVar);
                if (dgB()) {
                    SVG.ak Nt = baVar.lBb.Nt(baVar.Rz);
                    if (Nt == null) {
                        k("Use reference '%s' not found", baVar.Rz);
                        return;
                    }
                    if (baVar.lzE != null) {
                        this.lBl.concat(baVar.lzE);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(baVar.lzF != null ? baVar.lzF.a(this) : 0.0f, baVar.lzG != null ? baVar.lzG.b(this) : 0.0f);
                    this.lBl.concat(matrix);
                    d((SVG.ah) baVar);
                    boolean dgv = dgv();
                    a((SVG.ag) baVar);
                    if (Nt instanceof SVG.ac) {
                        dgs();
                        SVG.ac acVar = (SVG.ac) Nt;
                        a(acVar, baVar.lzH != null ? baVar.lzH : acVar.lzH, baVar.lzI != null ? baVar.lzI : acVar.lzI);
                        dgt();
                    } else if (Nt instanceof SVG.aq) {
                        SVG.n nVar = baVar.lzH != null ? baVar.lzH : new SVG.n(100.0f, SVG.Unit.percent);
                        SVG.n nVar2 = baVar.lzI != null ? baVar.lzI : new SVG.n(100.0f, SVG.Unit.percent);
                        dgs();
                        a((SVG.aq) Nt, nVar, nVar2);
                        dgt();
                    } else {
                        b(Nt);
                    }
                    dgu();
                    if (dgv) {
                        b((SVG.ah) baVar);
                    }
                    a((SVG.ah) baVar);
                }
            }
        }
    }

    private void a(SVG.t tVar) {
        debug("Path render", new Object[0]);
        if (tVar.lzX != null) {
            a(this.lBp, tVar);
            if (dgB() && dgC()) {
                if (this.lBp.lBI || this.lBp.lBH) {
                    if (tVar.lzE != null) {
                        this.lBl.concat(tVar.lzE);
                    }
                    Path bF = new C0638c(tVar.lzX).bF();
                    if (tVar.lAX == null) {
                        tVar.lAX = b(bF);
                    }
                    a((SVG.ah) tVar);
                    c((SVG.ah) tVar);
                    d((SVG.ah) tVar);
                    boolean dgv = dgv();
                    if (this.lBp.lBH) {
                        bF.setFillType(dgD());
                        a(tVar, bF);
                    }
                    if (this.lBp.lBI) {
                        a(bF);
                    }
                    a((SVG.j) tVar);
                    if (dgv) {
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
        if (zVar.lzH != null && zVar.lzI != null && !zVar.lzH.isZero() && !zVar.lzI.isZero()) {
            a(this.lBp, zVar);
            if (dgB() && dgC()) {
                if (zVar.lzE != null) {
                    this.lBl.concat(zVar.lzE);
                }
                Path b2 = b(zVar);
                a((SVG.ah) zVar);
                c((SVG.ah) zVar);
                d((SVG.ah) zVar);
                boolean dgv = dgv();
                if (this.lBp.lBH) {
                    a(zVar, b2);
                }
                if (this.lBp.lBI) {
                    a(b2);
                }
                if (dgv) {
                    b((SVG.ah) zVar);
                }
            }
        }
    }

    private void a(SVG.c cVar) {
        debug("Circle render", new Object[0]);
        if (cVar.lzu != null && !cVar.lzu.isZero()) {
            a(this.lBp, cVar);
            if (dgB() && dgC()) {
                if (cVar.lzE != null) {
                    this.lBl.concat(cVar.lzE);
                }
                Path b2 = b(cVar);
                a((SVG.ah) cVar);
                c((SVG.ah) cVar);
                d((SVG.ah) cVar);
                boolean dgv = dgv();
                if (this.lBp.lBH) {
                    a(cVar, b2);
                }
                if (this.lBp.lBI) {
                    a(b2);
                }
                if (dgv) {
                    b((SVG.ah) cVar);
                }
            }
        }
    }

    private void a(SVG.h hVar) {
        debug("Ellipse render", new Object[0]);
        if (hVar.lzz != null && hVar.lzA != null && !hVar.lzz.isZero() && !hVar.lzA.isZero()) {
            a(this.lBp, hVar);
            if (dgB() && dgC()) {
                if (hVar.lzE != null) {
                    this.lBl.concat(hVar.lzE);
                }
                Path b2 = b(hVar);
                a((SVG.ah) hVar);
                c((SVG.ah) hVar);
                d((SVG.ah) hVar);
                boolean dgv = dgv();
                if (this.lBp.lBH) {
                    a(hVar, b2);
                }
                if (this.lBp.lBI) {
                    a(b2);
                }
                if (dgv) {
                    b((SVG.ah) hVar);
                }
            }
        }
    }

    private void a(SVG.o oVar) {
        debug("Line render", new Object[0]);
        a(this.lBp, oVar);
        if (dgB() && dgC() && this.lBp.lBI) {
            if (oVar.lzE != null) {
                this.lBl.concat(oVar.lzE);
            }
            Path c = c(oVar);
            a((SVG.ah) oVar);
            c((SVG.ah) oVar);
            d((SVG.ah) oVar);
            boolean dgv = dgv();
            a(c);
            a((SVG.j) oVar);
            if (dgv) {
                b((SVG.ah) oVar);
            }
        }
    }

    private List<b> b(SVG.o oVar) {
        float a2 = oVar.lzK != null ? oVar.lzK.a(this) : 0.0f;
        float b2 = oVar.lzL != null ? oVar.lzL.b(this) : 0.0f;
        float a3 = oVar.lzM != null ? oVar.lzM.a(this) : 0.0f;
        float b3 = oVar.lzN != null ? oVar.lzN.b(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new b(a2, b2, a3 - a2, b3 - b2));
        arrayList.add(new b(a3, b3, a3 - a2, b3 - b2));
        return arrayList;
    }

    private void a(SVG.x xVar) {
        debug("PolyLine render", new Object[0]);
        a(this.lBp, xVar);
        if (dgB() && dgC()) {
            if (this.lBp.lBI || this.lBp.lBH) {
                if (xVar.lzE != null) {
                    this.lBl.concat(xVar.lzE);
                }
                if (xVar.points.length >= 2) {
                    Path c = c(xVar);
                    a((SVG.ah) xVar);
                    c((SVG.ah) xVar);
                    d((SVG.ah) xVar);
                    boolean dgv = dgv();
                    if (this.lBp.lBH) {
                        a(xVar, c);
                    }
                    if (this.lBp.lBI) {
                        a(c);
                    }
                    a((SVG.j) xVar);
                    if (dgv) {
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
        a(this.lBp, yVar);
        if (dgB() && dgC()) {
            if (this.lBp.lBI || this.lBp.lBH) {
                if (yVar.lzE != null) {
                    this.lBl.concat(yVar.lzE);
                }
                if (yVar.points.length >= 2) {
                    Path c = c((SVG.x) yVar);
                    a((SVG.ah) yVar);
                    c((SVG.ah) yVar);
                    d((SVG.ah) yVar);
                    boolean dgv = dgv();
                    if (this.lBp.lBH) {
                        a(yVar, c);
                    }
                    if (this.lBp.lBI) {
                        a(c);
                    }
                    a((SVG.j) yVar);
                    if (dgv) {
                        b((SVG.ah) yVar);
                    }
                }
            }
        }
    }

    private void a(SVG.at atVar) {
        float f2 = 0.0f;
        debug("Text render", new Object[0]);
        a(this.lBp, atVar);
        if (dgB()) {
            if (atVar.lzE != null) {
                this.lBl.concat(atVar.lzE);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lBj == null || atVar.lBj.size() == 0) ? 0.0f : atVar.lBj.get(0).a(this);
            if (atVar.lBk != null && atVar.lBk.size() != 0) {
                f2 = atVar.lBk.get(0).b(this);
            }
            SVG.Style.TextAnchor dgA = dgA();
            if (dgA != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (dgA == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lAX == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lAX = new SVG.a(hVar.lBM.left, hVar.lBM.top, hVar.lBM.width(), hVar.lBM.height());
            }
            a((SVG.ah) atVar);
            c((SVG.ah) atVar);
            d((SVG.ah) atVar);
            boolean dgv = dgv();
            a((SVG.av) atVar, new e(a2 + a3, f2 + b2));
            if (dgv) {
                b((SVG.ah) atVar);
            }
        }
    }

    private SVG.Style.TextAnchor dgA() {
        if (this.lBp.lyK.lAA == SVG.Style.TextDirection.LTR || this.lBp.lyK.lAB == SVG.Style.TextAnchor.Middle) {
            return this.lBp.lyK.lAB;
        }
        return this.lBp.lyK.lAB == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class e extends i {
        public float x;
        public float y;

        public e(float f, float f2) {
            super();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public void Nx(String str) {
            c.debug("TextSequence render", new Object[0]);
            if (c.this.dgC()) {
                if (c.this.lBp.lBH) {
                    c.this.lBl.drawText(str, this.x, this.y, c.this.lBp.jF);
                }
                if (c.this.lBp.lBI) {
                    c.this.lBl.drawText(str, this.x, this.y, c.this.lBp.jG);
                }
            }
            this.x += c.this.lBp.jF.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public abstract class i {
        public abstract void Nx(String str);

        private i() {
        }

        public boolean b(SVG.av avVar) {
            return true;
        }
    }

    private void a(SVG.av avVar, i iVar) {
        if (dgB()) {
            Iterator<SVG.ak> it = avVar.ST.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.ak next = it.next();
                if (next instanceof SVG.az) {
                    iVar.Nx(n(((SVG.az) next).text, z, !it.hasNext()));
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
                dgs();
                a((SVG.aw) akVar);
                dgt();
            } else if (akVar instanceof SVG.as) {
                debug("TSpan render", new Object[0]);
                dgs();
                SVG.as asVar = (SVG.as) akVar;
                a(this.lBp, asVar);
                if (dgB()) {
                    if (iVar instanceof e) {
                        f4 = (asVar.x == null || asVar.x.size() == 0) ? ((e) iVar).x : asVar.x.get(0).a(this);
                        f3 = (asVar.y == null || asVar.y.size() == 0) ? ((e) iVar).y : asVar.y.get(0).b(this);
                        f2 = (asVar.lBj == null || asVar.lBj.size() == 0) ? 0.0f : asVar.lBj.get(0).a(this);
                        if (asVar.lBk != null && asVar.lBk.size() != 0) {
                            f5 = asVar.lBk.get(0).b(this);
                        }
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    c((SVG.ah) asVar.dgn());
                    if (iVar instanceof e) {
                        ((e) iVar).x = f4 + f2;
                        ((e) iVar).y = f3 + f5;
                    }
                    boolean dgv = dgv();
                    a((SVG.av) asVar, iVar);
                    if (dgv) {
                        b((SVG.ah) asVar);
                    }
                }
                dgt();
            } else if (akVar instanceof SVG.ar) {
                dgs();
                SVG.ar arVar = (SVG.ar) akVar;
                a(this.lBp, arVar);
                if (dgB()) {
                    c((SVG.ah) arVar.dgn());
                    SVG.ak Nt = akVar.lBb.Nt(arVar.Rz);
                    if (Nt != null && (Nt instanceof SVG.av)) {
                        StringBuilder sb = new StringBuilder();
                        a((SVG.av) Nt, sb);
                        if (sb.length() > 0) {
                            iVar.Nx(sb.toString());
                        }
                    } else {
                        k("Tref reference '%s' not found", arVar.Rz);
                    }
                }
                dgt();
            }
        }
    }

    private void a(SVG.aw awVar) {
        float f2;
        debug("TextPath render", new Object[0]);
        a(this.lBp, awVar);
        if (dgB() && dgC()) {
            SVG.ak Nt = awVar.lBb.Nt(awVar.Rz);
            if (Nt == null) {
                k("TextPath reference '%s' not found", awVar.Rz);
                return;
            }
            SVG.t tVar = (SVG.t) Nt;
            Path bF = new C0638c(tVar.lzX).bF();
            if (tVar.lzE != null) {
                bF.transform(tVar.lzE);
            }
            float a2 = awVar.lBi != null ? awVar.lBi.a(this, new PathMeasure(bF, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor dgA = dgA();
            if (dgA != SVG.Style.TextAnchor.Start) {
                float a3 = a((SVG.av) awVar);
                if (dgA == SVG.Style.TextAnchor.Middle) {
                    f2 = a2 - (a3 / 2.0f);
                } else {
                    f2 = a2 - a3;
                }
            } else {
                f2 = a2;
            }
            c((SVG.ah) awVar.dgn());
            boolean dgv = dgv();
            a((SVG.av) awVar, (i) new d(bF, f2, 0.0f));
            if (dgv) {
                b((SVG.ah) awVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d extends e {
        private Path path;

        public d(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.c.e, com.caverock.androidsvg.c.i
        public void Nx(String str) {
            if (c.this.dgC()) {
                if (c.this.lBp.lBH) {
                    c.this.lBl.drawTextOnPath(str, this.path, this.x, this.y, c.this.lBp.jF);
                }
                if (c.this.lBp.lBI) {
                    c.this.lBl.drawTextOnPath(str, this.path, this.x, this.y, c.this.lBp.jG);
                }
            }
            this.x += c.this.lBp.jF.measureText(str);
        }
    }

    private float a(SVG.av avVar) {
        j jVar = new j();
        a(avVar, (i) jVar);
        return jVar.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class j extends i {
        public float x;

        private j() {
            super();
            this.x = 0.0f;
        }

        @Override // com.caverock.androidsvg.c.i
        public void Nx(String str) {
            this.x += c.this.lBp.jF.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class h extends i {
        RectF lBM;
        float x;
        float y;

        public h(float f, float f2) {
            super();
            this.lBM = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.c.i
        public boolean b(SVG.av avVar) {
            if (avVar instanceof SVG.aw) {
                SVG.aw awVar = (SVG.aw) avVar;
                SVG.ak Nt = avVar.lBb.Nt(awVar.Rz);
                if (Nt == null) {
                    c.k("TextPath path reference '%s' not found", awVar.Rz);
                    return false;
                }
                SVG.t tVar = (SVG.t) Nt;
                Path bF = new C0638c(tVar.lzX).bF();
                if (tVar.lzE != null) {
                    bF.transform(tVar.lzE);
                }
                RectF rectF = new RectF();
                bF.computeBounds(rectF, true);
                this.lBM.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.c.i
        public void Nx(String str) {
            if (c.this.dgC()) {
                Rect rect = new Rect();
                c.this.lBp.jF.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.lBM.union(rectF);
            }
            this.x += c.this.lBp.jF.measureText(str);
        }
    }

    private void a(SVG.av avVar, StringBuilder sb) {
        Iterator<SVG.ak> it = avVar.ST.iterator();
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
        if (this.lBp.lBK) {
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
                PreserveAspectRatio preserveAspectRatio = aqVar.lBd != null ? aqVar.lBd : PreserveAspectRatio.lyZ;
                a(this.lBp, aqVar);
                this.lBp.lBJ = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.a(this) : this.lBp.lBJ.width, nVar2 != null ? nVar2.a(this) : this.lBp.lBJ.height);
                if (!this.lBp.lyK.lAC.booleanValue()) {
                    m(this.lBp.lBJ.lzm, this.lBp.lBJ.lzn, this.lBp.lBJ.width, this.lBp.lBJ.height);
                }
                if (aqVar.lBg != null) {
                    this.lBl.concat(a(this.lBp.lBJ, aqVar.lBg, preserveAspectRatio));
                    this.lBp.lBg = aqVar.lBg;
                }
                boolean dgv = dgv();
                a((SVG.ag) aqVar, true);
                if (dgv) {
                    b((SVG.ah) aqVar);
                }
                a((SVG.ah) aqVar);
            }
        }
    }

    private void a(SVG.m mVar) {
        Bitmap bitmap;
        debug("Image render", new Object[0]);
        if (mVar.lzH != null && !mVar.lzH.isZero() && mVar.lzI != null && !mVar.lzI.isZero() && mVar.Rz != null) {
            PreserveAspectRatio preserveAspectRatio = mVar.lBd != null ? mVar.lBd : PreserveAspectRatio.lyZ;
            Bitmap Nw = Nw(mVar.Rz);
            if (Nw == null) {
                com.caverock.androidsvg.d dgc = this.lBb.dgc();
                if (dgc != null) {
                    bitmap = dgc.Ny(mVar.Rz);
                } else {
                    return;
                }
            } else {
                bitmap = Nw;
            }
            if (bitmap == null) {
                k("Could not locate image '%s'", mVar.Rz);
                return;
            }
            a(this.lBp, mVar);
            if (dgB() && dgC()) {
                if (mVar.lzE != null) {
                    this.lBl.concat(mVar.lzE);
                }
                this.lBp.lBJ = new SVG.a(mVar.lzF != null ? mVar.lzF.a(this) : 0.0f, mVar.lzG != null ? mVar.lzG.b(this) : 0.0f, mVar.lzH.a(this), mVar.lzI.a(this));
                if (!this.lBp.lyK.lAC.booleanValue()) {
                    m(this.lBp.lBJ.lzm, this.lBp.lBJ.lzn, this.lBp.lBJ.width, this.lBp.lBJ.height);
                }
                mVar.lAX = new SVG.a(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                this.lBl.concat(a(this.lBp.lBJ, mVar.lAX, preserveAspectRatio));
                a((SVG.ah) mVar);
                d((SVG.ah) mVar);
                boolean dgv = dgv();
                dgE();
                this.lBl.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
                if (dgv) {
                    b((SVG.ah) mVar);
                }
            }
        }
    }

    private Bitmap Nw(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    private boolean dgB() {
        if (this.lBp.lyK.lAH != null) {
            return this.lBp.lyK.lAH.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dgC() {
        if (this.lBp.lyK.lAI != null) {
            return this.lBp.lyK.lAI.booleanValue();
        }
        return true;
    }

    private Matrix a(SVG.a aVar, SVG.a aVar2, PreserveAspectRatio preserveAspectRatio) {
        Matrix matrix = new Matrix();
        if (preserveAspectRatio == null || preserveAspectRatio.dfW() == null) {
            return matrix;
        }
        float f2 = aVar.width / aVar2.width;
        float f3 = aVar.height / aVar2.height;
        float f4 = -aVar2.lzm;
        float f5 = -aVar2.lzn;
        if (preserveAspectRatio.equals(PreserveAspectRatio.lyY)) {
            matrix.preTranslate(aVar.lzm, aVar.lzn);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            return matrix;
        }
        float max = preserveAspectRatio.dfX() == PreserveAspectRatio.Scale.Slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = aVar.width / max;
        float f7 = aVar.height / max;
        switch (preserveAspectRatio.dfW()) {
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
        switch (preserveAspectRatio.dfW()) {
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
        matrix.preTranslate(aVar.lzm, aVar.lzn);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        return matrix;
    }

    private boolean a(SVG.Style style, long j2) {
        return (style.lAh & j2) != 0;
    }

    private void a(g gVar, SVG.Style style) {
        Typeface typeface;
        SVG.Style style2;
        if (a(style, 4096L)) {
            gVar.lyK.lAu = style.lAu;
        }
        if (a(style, 2048L)) {
            gVar.lyK.lAt = style.lAt;
        }
        if (a(style, 1L)) {
            gVar.lyK.lAi = style.lAi;
            gVar.lBH = style.lAi != null;
        }
        if (a(style, 4L)) {
            gVar.lyK.lAk = style.lAk;
        }
        if (a(style, 6149L)) {
            a(gVar, true, gVar.lyK.lAi);
        }
        if (a(style, 2L)) {
            gVar.lyK.lAj = style.lAj;
        }
        if (a(style, 8L)) {
            gVar.lyK.lAl = style.lAl;
            gVar.lBI = style.lAl != null;
        }
        if (a(style, 16L)) {
            gVar.lyK.lAm = style.lAm;
        }
        if (a(style, 6168L)) {
            a(gVar, false, gVar.lyK.lAl);
        }
        if (a(style, IjkMediaMeta.AV_CH_LOW_FREQUENCY_2)) {
            gVar.lyK.lAR = style.lAR;
        }
        if (a(style, 32L)) {
            gVar.lyK.lAn = style.lAn;
            gVar.jG.setStrokeWidth(gVar.lyK.lAn.c(this));
        }
        if (a(style, 64L)) {
            gVar.lyK.lAo = style.lAo;
            switch (style.lAo) {
                case Butt:
                    gVar.jG.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.jG.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.jG.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (a(style, 128L)) {
            gVar.lyK.lAp = style.lAp;
            switch (style.lAp) {
                case Miter:
                    gVar.jG.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.jG.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.jG.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (a(style, 256L)) {
            gVar.lyK.lAq = style.lAq;
            gVar.jG.setStrokeMiter(style.lAq.floatValue());
        }
        if (a(style, 512L)) {
            gVar.lyK.lAr = style.lAr;
        }
        if (a(style, 1024L)) {
            gVar.lyK.lAs = style.lAs;
        }
        if (a(style, 1536L)) {
            if (gVar.lyK.lAr == null) {
                gVar.jG.setPathEffect(null);
            } else {
                int length = gVar.lyK.lAr.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.lyK.lAr[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.jG.setPathEffect(null);
                } else {
                    float c = gVar.lyK.lAs.c(this);
                    if (c < 0.0f) {
                        c = (c % f2) + f2;
                    }
                    gVar.jG.setPathEffect(new DashPathEffect(fArr, c));
                }
            }
        }
        if (a(style, 16384L)) {
            float dgp = dgp();
            gVar.lyK.lAw = style.lAw;
            gVar.jF.setTextSize(style.lAw.a(this, dgp));
            gVar.jG.setTextSize(style.lAw.a(this, dgp));
        }
        if (a(style, 8192L)) {
            gVar.lyK.lAv = style.lAv;
        }
        if (a(style, 32768L)) {
            if (style.lAx.intValue() == -1 && gVar.lyK.lAx.intValue() > 100) {
                gVar.lyK.lAx = Integer.valueOf(style2.lAx.intValue() - 100);
            } else if (style.lAx.intValue() == 1 && gVar.lyK.lAx.intValue() < 900) {
                SVG.Style style3 = gVar.lyK;
                style3.lAx = Integer.valueOf(style3.lAx.intValue() + 100);
            } else {
                gVar.lyK.lAx = style.lAx;
            }
        }
        if (a(style, 65536L)) {
            gVar.lyK.lAy = style.lAy;
        }
        if (a(style, 106496L)) {
            if (gVar.lyK.lAv == null || this.lBb == null) {
                typeface = null;
            } else {
                com.caverock.androidsvg.d dgc = this.lBb.dgc();
                typeface = null;
                for (String str : gVar.lyK.lAv) {
                    Typeface a2 = a(str, gVar.lyK.lAx, gVar.lyK.lAy);
                    if (a2 != null || dgc == null) {
                        typeface = a2;
                        continue;
                    } else {
                        typeface = dgc.w(str, gVar.lyK.lAx.intValue(), String.valueOf(gVar.lyK.lAy));
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("sans-serif", gVar.lyK.lAx, gVar.lyK.lAy);
            }
            gVar.jF.setTypeface(typeface);
            gVar.jG.setTypeface(typeface);
        }
        if (a(style, 131072L)) {
            gVar.lyK.lAz = style.lAz;
            gVar.jF.setStrikeThruText(style.lAz == SVG.Style.TextDecoration.LineThrough);
            gVar.jF.setUnderlineText(style.lAz == SVG.Style.TextDecoration.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.jG.setStrikeThruText(style.lAz == SVG.Style.TextDecoration.LineThrough);
                gVar.jG.setUnderlineText(style.lAz == SVG.Style.TextDecoration.Underline);
            }
        }
        if (a(style, 68719476736L)) {
            gVar.lyK.lAA = style.lAA;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            gVar.lyK.lAB = style.lAB;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            gVar.lyK.lAC = style.lAC;
        }
        if (a(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            gVar.lyK.lAE = style.lAE;
        }
        if (a(style, ImageUploadStrategy.FILE_SIZE_4M)) {
            gVar.lyK.lAF = style.lAF;
        }
        if (a(style, 8388608L)) {
            gVar.lyK.lAG = style.lAG;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH)) {
            gVar.lyK.lAH = style.lAH;
        }
        if (a(style, 33554432L)) {
            gVar.lyK.lAI = style.lAI;
        }
        if (a(style, 1048576L)) {
            gVar.lyK.lAD = style.lAD;
        }
        if (a(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
            gVar.lyK.clipPath = style.clipPath;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            gVar.lyK.lAL = style.lAL;
        }
        if (a(style, IjkMediaMeta.AV_CH_STEREO_RIGHT)) {
            gVar.lyK.lAM = style.lAM;
        }
        if (a(style, 67108864L)) {
            gVar.lyK.lAJ = style.lAJ;
        }
        if (a(style, 134217728L)) {
            gVar.lyK.lAK = style.lAK;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT)) {
            gVar.lyK.lAP = style.lAP;
        }
        if (a(style, IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT)) {
            gVar.lyK.lAQ = style.lAQ;
        }
    }

    private void a(g gVar, boolean z, SVG.al alVar) {
        int i2;
        float floatValue = (z ? gVar.lyK.lAk : gVar.lyK.lAm).floatValue();
        if (alVar instanceof SVG.e) {
            i2 = ((SVG.e) alVar).lzw;
        } else if (alVar instanceof SVG.f) {
            i2 = gVar.lyK.lAu.lzw;
        } else {
            return;
        }
        int bj = i2 | (bj(floatValue) << 24);
        if (z) {
            gVar.jF.setColor(bj);
        } else {
            gVar.jG.setColor(bj);
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

    private int bj(float f2) {
        int i2 = (int) (256.0f * f2);
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 255) {
            return i2;
        }
        return 255;
    }

    private Path.FillType dgD() {
        if (this.lBp.lyK.lAj == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lBp.lyK.lAj) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void m(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.lBp.lyK.lAD != null) {
            f2 += this.lBp.lyK.lAD.lzr.a(this);
            f3 += this.lBp.lyK.lAD.lzo.b(this);
            f6 -= this.lBp.lyK.lAD.lzp.a(this);
            f7 -= this.lBp.lyK.lAD.lzq.b(this);
        }
        this.lBl.clipRect(f2, f3, f6, f7);
    }

    private void dgE() {
        int i2;
        if (this.lBp.lyK.lAP instanceof SVG.e) {
            i2 = ((SVG.e) this.lBp.lyK.lAP).lzw;
        } else if (this.lBp.lyK.lAP instanceof SVG.f) {
            i2 = this.lBp.lyK.lAu.lzw;
        } else {
            return;
        }
        if (this.lBp.lyK.lAQ != null) {
            i2 |= bj(this.lBp.lyK.lAQ.floatValue()) << 24;
        }
        this.lBl.drawColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.caverock.androidsvg.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0638c implements SVG.v {
        float lastX;
        float lastY;
        Path path = new Path();

        public C0638c(SVG.u uVar) {
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
    /* loaded from: classes9.dex */
    public class b {
        public float gmO;
        public float gmP;
        public float x;
        public float y;

        public b(float f, float f2, float f3, float f4) {
            this.gmO = 0.0f;
            this.gmP = 0.0f;
            this.x = f;
            this.y = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gmO = (float) (f3 / sqrt);
                this.gmP = (float) (f4 / sqrt);
            }
        }

        public void C(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.gmO = ((float) (f3 / sqrt)) + this.gmO;
                this.gmP += (float) (f4 / sqrt);
            }
        }

        public void a(b bVar) {
            this.gmO += bVar.gmO;
            this.gmP += bVar.gmP;
        }

        public String toString() {
            return "(" + this.x + Constants.ACCEPT_TIME_SEPARATOR_SP + this.y + HanziToPinyin.Token.SEPARATOR + this.gmO + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gmP + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements SVG.v {
        private List<b> buP = new ArrayList();
        private b lBA = null;
        private boolean lBB = false;
        private boolean lBC = true;
        private int lBD = -1;
        private boolean lBE;
        private float startX;
        private float startY;

        public a(SVG.u uVar) {
            if (uVar != null) {
                uVar.a(this);
                if (this.lBE) {
                    this.lBA.a(this.buP.get(this.lBD));
                    this.buP.set(this.lBD, this.lBA);
                    this.lBE = false;
                }
                if (this.lBA != null) {
                    this.buP.add(this.lBA);
                }
            }
        }

        public List<b> dgI() {
            return this.buP;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            if (this.lBE) {
                this.lBA.a(this.buP.get(this.lBD));
                this.buP.set(this.lBD, this.lBA);
                this.lBE = false;
            }
            if (this.lBA != null) {
                this.buP.add(this.lBA);
            }
            this.startX = f;
            this.startY = f2;
            this.lBA = new b(f, f2, 0.0f, 0.0f);
            this.lBD = this.buP.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            this.lBA.C(f, f2);
            this.buP.add(this.lBA);
            this.lBA = new b(f, f2, f - this.lBA.x, f2 - this.lBA.y);
            this.lBE = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.lBC || this.lBB) {
                this.lBA.C(f, f2);
                this.buP.add(this.lBA);
                this.lBB = false;
            }
            this.lBA = new b(f5, f6, f5 - f3, f6 - f4);
            this.lBE = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            this.lBA.C(f, f2);
            this.buP.add(this.lBA);
            this.lBA = new b(f3, f4, f3 - f, f4 - f2);
            this.lBE = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.lBB = true;
            this.lBC = false;
            c.a(this.lBA.x, this.lBA.y, f, f2, f3, z, z2, f4, f5, this);
            this.lBC = true;
            this.lBE = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.buP.add(this.lBA);
            B(this.startX, this.startY);
            this.lBE = true;
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
        if (this.lBp.lyK.lAE != null || this.lBp.lyK.lAF != null || this.lBp.lyK.lAG != null) {
            if (this.lBp.lyK.lAE != null) {
                SVG.ak Nt = jVar.lBb.Nt(this.lBp.lyK.lAE);
                if (Nt != null) {
                    pVar = (SVG.p) Nt;
                    if (this.lBp.lyK.lAF != null) {
                        SVG.ak Nt2 = jVar.lBb.Nt(this.lBp.lyK.lAF);
                        if (Nt2 != null) {
                            pVar2 = (SVG.p) Nt2;
                            if (this.lBp.lyK.lAG != null) {
                                SVG.ak Nt3 = jVar.lBb.Nt(this.lBp.lyK.lAG);
                                if (Nt3 != null) {
                                    pVar3 = (SVG.p) Nt3;
                                    if (!(jVar instanceof SVG.t)) {
                                        b2 = new a(((SVG.t) jVar).lzX).dgI();
                                    } else if (jVar instanceof SVG.o) {
                                        b2 = b((SVG.o) jVar);
                                    } else {
                                        b2 = b((SVG.x) jVar);
                                    }
                                    if (b2 == null && (size = b2.size()) != 0) {
                                        SVG.Style style = this.lBp.lyK;
                                        SVG.Style style2 = this.lBp.lyK;
                                        this.lBp.lyK.lAG = null;
                                        style2.lAF = null;
                                        style.lAE = null;
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
                                k("Marker reference '%s' not found", this.lBp.lyK.lAG);
                            }
                            pVar3 = null;
                            if (!(jVar instanceof SVG.t)) {
                            }
                            if (b2 == null) {
                                return;
                            }
                            return;
                        }
                        k("Marker reference '%s' not found", this.lBp.lyK.lAF);
                    }
                    pVar2 = null;
                    if (this.lBp.lyK.lAG != null) {
                    }
                    pVar3 = null;
                    if (!(jVar instanceof SVG.t)) {
                    }
                    if (b2 == null) {
                    }
                } else {
                    k("Marker reference '%s' not found", this.lBp.lyK.lAE);
                }
            }
            pVar = null;
            if (this.lBp.lyK.lAF != null) {
            }
            pVar2 = null;
            if (this.lBp.lyK.lAG != null) {
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
        boolean dgv;
        float f3;
        float f4 = 0.0f;
        dgs();
        if (pVar.lzT != null) {
            if (Float.isNaN(pVar.lzT.floatValue())) {
                if (bVar.gmO != 0.0f || bVar.gmP != 0.0f) {
                    f2 = (float) Math.toDegrees(Math.atan2(bVar.gmP, bVar.gmO));
                }
            } else {
                f2 = pVar.lzT.floatValue();
            }
            float bi = !pVar.lzO ? 1.0f : this.lBp.lyK.lAn.bi(this.lBn);
            this.lBp = d((SVG.ak) pVar);
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.x, bVar.y);
            matrix.preRotate(f2);
            matrix.preScale(bi, bi);
            float a2 = pVar.lzP == null ? pVar.lzP.a(this) : 0.0f;
            float b2 = pVar.lzQ == null ? pVar.lzQ.b(this) : 0.0f;
            float a3 = pVar.lzR == null ? pVar.lzR.a(this) : 3.0f;
            float b3 = pVar.lzS != null ? pVar.lzS.b(this) : 3.0f;
            if (pVar.lBg == null) {
                float f5 = a3 / pVar.lBg.width;
                float f6 = b3 / pVar.lBg.height;
                PreserveAspectRatio preserveAspectRatio = pVar.lBd != null ? pVar.lBd : PreserveAspectRatio.lyZ;
                if (!preserveAspectRatio.equals(PreserveAspectRatio.lyY)) {
                    f6 = preserveAspectRatio.dfX() == PreserveAspectRatio.Scale.Slice ? Math.max(f5, f6) : Math.min(f5, f6);
                    f5 = f6;
                }
                matrix.preTranslate((-a2) * f5, (-b2) * f6);
                this.lBl.concat(matrix);
                float f7 = pVar.lBg.width * f5;
                float f8 = pVar.lBg.height * f6;
                switch (preserveAspectRatio.dfW()) {
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
                switch (preserveAspectRatio.dfW()) {
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
                if (!this.lBp.lyK.lAC.booleanValue()) {
                    m(f3, f4, a3, b3);
                }
                matrix.reset();
                matrix.preScale(f5, f6);
                this.lBl.concat(matrix);
            } else {
                matrix.preTranslate(-a2, -b2);
                this.lBl.concat(matrix);
                if (!this.lBp.lyK.lAC.booleanValue()) {
                    m(0.0f, 0.0f, a3, b3);
                }
            }
            dgv = dgv();
            a((SVG.ag) pVar, false);
            if (dgv) {
                b((SVG.ah) pVar);
            }
            dgt();
        }
        f2 = 0.0f;
        if (!pVar.lzO) {
        }
        this.lBp = d((SVG.ak) pVar);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(bVar.x, bVar.y);
        matrix2.preRotate(f2);
        matrix2.preScale(bi, bi);
        if (pVar.lzP == null) {
        }
        if (pVar.lzQ == null) {
        }
        if (pVar.lzR == null) {
        }
        if (pVar.lzS != null) {
        }
        if (pVar.lBg == null) {
        }
        dgv = dgv();
        a((SVG.ag) pVar, false);
        if (dgv) {
        }
        dgt();
    }

    private g d(SVG.ak akVar) {
        g gVar = new g();
        a(gVar, SVG.Style.dgh());
        return a(akVar, gVar);
    }

    private g a(SVG.ak akVar, g gVar) {
        ArrayList<SVG.ai> arrayList = new ArrayList();
        SVG.ak akVar2 = akVar;
        while (true) {
            if (akVar2 instanceof SVG.ai) {
                arrayList.add(0, (SVG.ai) akVar2);
            }
            if (akVar2.lBc == null) {
                break;
            }
            akVar2 = (SVG.ak) akVar2.lBc;
        }
        for (SVG.ai aiVar : arrayList) {
            a(gVar, aiVar);
        }
        gVar.lBg = this.lBb.dfZ().lBg;
        if (gVar.lBg == null) {
            gVar.lBg = this.lBm;
        }
        gVar.lBJ = this.lBm;
        gVar.lBL = this.lBp.lBL;
        return gVar;
    }

    private void c(SVG.ah ahVar) {
        if (this.lBp.lyK.lAi instanceof SVG.s) {
            a(true, ahVar.lAX, (SVG.s) this.lBp.lyK.lAi);
        }
        if (this.lBp.lyK.lAl instanceof SVG.s) {
            a(false, ahVar.lAX, (SVG.s) this.lBp.lyK.lAl);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.ak Nt = this.lBb.Nt(sVar.Rz);
        if (Nt == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.Rz;
            k("%s reference '%s' not found", objArr);
            if (sVar.lzW != null) {
                a(this.lBp, z, sVar.lzW);
                return;
            } else if (z) {
                this.lBp.lBH = false;
                return;
            } else {
                this.lBp.lBI = false;
                return;
            }
        }
        if (Nt instanceof SVG.aj) {
            a(z, aVar, (SVG.aj) Nt);
        }
        if (Nt instanceof SVG.an) {
            a(z, aVar, (SVG.an) Nt);
        }
        if (Nt instanceof SVG.aa) {
            a(z, (SVG.aa) Nt);
        }
    }

    private void a(boolean z, SVG.a aVar, SVG.aj ajVar) {
        float a2;
        float f2;
        float f3;
        float f4;
        if (ajVar.Rz != null) {
            a(ajVar, ajVar.Rz);
        }
        boolean z2 = ajVar.lzB != null && ajVar.lzB.booleanValue();
        Paint paint = z ? this.lBp.jF : this.lBp.jG;
        if (z2) {
            SVG.a dgr = dgr();
            float a3 = ajVar.lzK != null ? ajVar.lzK.a(this) : 0.0f;
            float b2 = ajVar.lzL != null ? ajVar.lzL.b(this) : 0.0f;
            float a4 = ajVar.lzM != null ? ajVar.lzM.a(this) : dgr.width;
            a2 = ajVar.lzN != null ? ajVar.lzN.b(this) : 0.0f;
            f2 = a4;
            f3 = b2;
            f4 = a3;
        } else {
            float a5 = ajVar.lzK != null ? ajVar.lzK.a(this, 1.0f) : 0.0f;
            float a6 = ajVar.lzL != null ? ajVar.lzL.a(this, 1.0f) : 0.0f;
            float a7 = ajVar.lzM != null ? ajVar.lzM.a(this, 1.0f) : 1.0f;
            a2 = ajVar.lzN != null ? ajVar.lzN.a(this, 1.0f) : 0.0f;
            f2 = a7;
            f3 = a6;
            f4 = a5;
        }
        dgs();
        this.lBp = d(ajVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lzm, aVar.lzn);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (ajVar.lzC != null) {
            matrix.preConcat(ajVar.lzC);
        }
        int size = ajVar.ST.size();
        if (size == 0) {
            dgt();
            if (z) {
                this.lBp.lBH = false;
                return;
            } else {
                this.lBp.lBI = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = ajVar.ST.iterator();
        int i2 = 0;
        float f5 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lAg.floatValue() >= f5) {
                fArr[i2] = abVar.lAg.floatValue();
                f5 = abVar.lAg.floatValue();
            } else {
                fArr[i2] = f5;
            }
            dgs();
            a(this.lBp, abVar);
            SVG.e eVar = (SVG.e) this.lBp.lyK.lAJ;
            if (eVar == null) {
                eVar = SVG.e.lzx;
            }
            iArr[i2] = eVar.lzw | (bj(this.lBp.lyK.lAK.floatValue()) << 24);
            dgt();
            i2++;
        }
        if ((f4 == f2 && f3 == a2) || size == 1) {
            dgt();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (ajVar.lzD != null) {
            if (ajVar.lzD == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (ajVar.lzD == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dgt();
        LinearGradient linearGradient = new LinearGradient(f4, f3, f2, a2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void a(boolean z, SVG.a aVar, SVG.an anVar) {
        float a2;
        float f2;
        float f3;
        if (anVar.Rz != null) {
            a(anVar, anVar.Rz);
        }
        boolean z2 = anVar.lzB != null && anVar.lzB.booleanValue();
        Paint paint = z ? this.lBp.jF : this.lBp.jG;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            float a3 = anVar.lzs != null ? anVar.lzs.a(this) : nVar.a(this);
            float b2 = anVar.lzt != null ? anVar.lzt.b(this) : nVar.b(this);
            a2 = anVar.lzu != null ? anVar.lzu.c(this) : nVar.c(this);
            f2 = b2;
            f3 = a3;
        } else {
            float a4 = anVar.lzs != null ? anVar.lzs.a(this, 1.0f) : 0.5f;
            float a5 = anVar.lzt != null ? anVar.lzt.a(this, 1.0f) : 0.5f;
            a2 = anVar.lzu != null ? anVar.lzu.a(this, 1.0f) : 0.5f;
            f2 = a5;
            f3 = a4;
        }
        dgs();
        this.lBp = d(anVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.lzm, aVar.lzn);
            matrix.preScale(aVar.width, aVar.height);
        }
        if (anVar.lzC != null) {
            matrix.preConcat(anVar.lzC);
        }
        int size = anVar.ST.size();
        if (size == 0) {
            dgt();
            if (z) {
                this.lBp.lBH = false;
                return;
            } else {
                this.lBp.lBI = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.ak> it = anVar.ST.iterator();
        int i2 = 0;
        float f4 = -1.0f;
        while (it.hasNext()) {
            SVG.ab abVar = (SVG.ab) it.next();
            if (i2 == 0 || abVar.lAg.floatValue() >= f4) {
                fArr[i2] = abVar.lAg.floatValue();
                f4 = abVar.lAg.floatValue();
            } else {
                fArr[i2] = f4;
            }
            dgs();
            a(this.lBp, abVar);
            SVG.e eVar = (SVG.e) this.lBp.lyK.lAJ;
            if (eVar == null) {
                eVar = SVG.e.lzx;
            }
            iArr[i2] = eVar.lzw | (bj(this.lBp.lyK.lAK.floatValue()) << 24);
            dgt();
            i2++;
        }
        if (a2 == 0.0f || size == 1) {
            dgt();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (anVar.lzD != null) {
            if (anVar.lzD == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (anVar.lzD == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        dgt();
        RadialGradient radialGradient = new RadialGradient(f3, f2, a2, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void a(SVG.i iVar, String str) {
        SVG.ak Nt = iVar.lBb.Nt(str);
        if (Nt == null) {
            j("Gradient reference '%s' not found", str);
        } else if (!(Nt instanceof SVG.i)) {
            k("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (Nt == iVar) {
            k("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) Nt;
            if (iVar.lzB == null) {
                iVar.lzB = iVar2.lzB;
            }
            if (iVar.lzC == null) {
                iVar.lzC = iVar2.lzC;
            }
            if (iVar.lzD == null) {
                iVar.lzD = iVar2.lzD;
            }
            if (iVar.ST.isEmpty()) {
                iVar.ST = iVar2.ST;
            }
            try {
                if (iVar instanceof SVG.aj) {
                    a((SVG.aj) iVar, (SVG.aj) Nt);
                } else {
                    a((SVG.an) iVar, (SVG.an) Nt);
                }
            } catch (ClassCastException e2) {
            }
            if (iVar2.Rz != null) {
                a(iVar, iVar2.Rz);
            }
        }
    }

    private void a(SVG.aj ajVar, SVG.aj ajVar2) {
        if (ajVar.lzK == null) {
            ajVar.lzK = ajVar2.lzK;
        }
        if (ajVar.lzL == null) {
            ajVar.lzL = ajVar2.lzL;
        }
        if (ajVar.lzM == null) {
            ajVar.lzM = ajVar2.lzM;
        }
        if (ajVar.lzN == null) {
            ajVar.lzN = ajVar2.lzN;
        }
    }

    private void a(SVG.an anVar, SVG.an anVar2) {
        if (anVar.lzs == null) {
            anVar.lzs = anVar2.lzs;
        }
        if (anVar.lzt == null) {
            anVar.lzt = anVar2.lzt;
        }
        if (anVar.lzu == null) {
            anVar.lzu = anVar2.lzu;
        }
        if (anVar.lBe == null) {
            anVar.lBe = anVar2.lBe;
        }
        if (anVar.lBf == null) {
            anVar.lBf = anVar2.lBf;
        }
    }

    private void a(boolean z, SVG.aa aaVar) {
        if (z) {
            if (a(aaVar.lAZ, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
                this.lBp.lyK.lAi = aaVar.lAZ.lAN;
                this.lBp.lBH = aaVar.lAZ.lAN != null;
            }
            if (a(aaVar.lAZ, 4294967296L)) {
                this.lBp.lyK.lAk = aaVar.lAZ.lAO;
            }
            if (a(aaVar.lAZ, 6442450944L)) {
                a(this.lBp, z, this.lBp.lyK.lAi);
                return;
            }
            return;
        }
        if (a(aaVar.lAZ, IjkMediaMeta.AV_CH_WIDE_LEFT)) {
            this.lBp.lyK.lAl = aaVar.lAZ.lAN;
            this.lBp.lBI = aaVar.lAZ.lAN != null;
        }
        if (a(aaVar.lAZ, 4294967296L)) {
            this.lBp.lyK.lAm = aaVar.lAZ.lAO;
        }
        if (a(aaVar.lAZ, 6442450944L)) {
            a(this.lBp, z, this.lBp.lyK.lAl);
        }
    }

    private void d(SVG.ah ahVar) {
        a(ahVar, ahVar.lAX);
    }

    private void a(SVG.ah ahVar, SVG.a aVar) {
        if (this.lBp.lyK.clipPath != null) {
            SVG.ak Nt = ahVar.lBb.Nt(this.lBp.lyK.clipPath);
            if (Nt == null) {
                k("ClipPath reference '%s' not found", this.lBp.lyK.clipPath);
                return;
            }
            SVG.d dVar = (SVG.d) Nt;
            if (dVar.ST.isEmpty()) {
                this.lBl.clipRect(0, 0, 0, 0);
                return;
            }
            boolean z = dVar.lzv == null || dVar.lzv.booleanValue();
            if ((ahVar instanceof SVG.k) && !z) {
                j("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", ahVar.getClass().getSimpleName());
                return;
            }
            dgF();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(aVar.lzm, aVar.lzn);
                matrix.preScale(aVar.width, aVar.height);
                this.lBl.concat(matrix);
            }
            if (dVar.lzE != null) {
                this.lBl.concat(dVar.lzE);
            }
            this.lBp = d((SVG.ak) dVar);
            d((SVG.ah) dVar);
            Path path = new Path();
            for (SVG.ak akVar : dVar.ST) {
                a(akVar, true, path, new Matrix());
            }
            this.lBl.clipPath(path);
            dgG();
        }
    }

    private void a(SVG.ak akVar, boolean z, Path path, Matrix matrix) {
        if (dgB()) {
            dgF();
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
            dgG();
        }
    }

    private void dgF() {
        this.lBl.save();
        this.lBq.push(this.lBp);
        this.lBp = (g) this.lBp.clone();
    }

    private void dgG() {
        this.lBl.restore();
        this.lBp = this.lBq.pop();
    }

    private Path.FillType dgH() {
        if (this.lBp.lyK.lAL == null) {
            return Path.FillType.WINDING;
        }
        switch (this.lBp.lyK.lAL) {
            case EvenOdd:
                return Path.FillType.EVEN_ODD;
            default:
                return Path.FillType.WINDING;
        }
    }

    private void a(SVG.t tVar, Path path, Matrix matrix) {
        a(this.lBp, tVar);
        if (dgB() && dgC()) {
            if (tVar.lzE != null) {
                matrix.preConcat(tVar.lzE);
            }
            Path bF = new C0638c(tVar.lzX).bF();
            if (tVar.lAX == null) {
                tVar.lAX = b(bF);
            }
            d((SVG.ah) tVar);
            path.setFillType(dgH());
            path.addPath(bF, matrix);
        }
    }

    private void a(SVG.j jVar, Path path, Matrix matrix) {
        Path c;
        a(this.lBp, jVar);
        if (dgB() && dgC()) {
            if (jVar.lzE != null) {
                matrix.preConcat(jVar.lzE);
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
        a(this.lBp, baVar);
        if (dgB() && dgC()) {
            if (baVar.lzE != null) {
                matrix.preConcat(baVar.lzE);
            }
            SVG.ak Nt = baVar.lBb.Nt(baVar.Rz);
            if (Nt == null) {
                k("Use reference '%s' not found", baVar.Rz);
                return;
            }
            d((SVG.ah) baVar);
            a(Nt, false, path, matrix);
        }
    }

    private void a(SVG.at atVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        a(this.lBp, atVar);
        if (dgB()) {
            if (atVar.lzE != null) {
                matrix.preConcat(atVar.lzE);
            }
            float a2 = (atVar.x == null || atVar.x.size() == 0) ? 0.0f : atVar.x.get(0).a(this);
            float b2 = (atVar.y == null || atVar.y.size() == 0) ? 0.0f : atVar.y.get(0).b(this);
            float a3 = (atVar.lBj == null || atVar.lBj.size() == 0) ? 0.0f : atVar.lBj.get(0).a(this);
            if (atVar.lBk != null && atVar.lBk.size() != 0) {
                f2 = atVar.lBk.get(0).b(this);
            }
            if (this.lBp.lyK.lAB != SVG.Style.TextAnchor.Start) {
                float a4 = a((SVG.av) atVar);
                if (this.lBp.lyK.lAB == SVG.Style.TextAnchor.Middle) {
                    a2 -= a4 / 2.0f;
                } else {
                    a2 -= a4;
                }
            }
            if (atVar.lAX == null) {
                h hVar = new h(a2, b2);
                a((SVG.av) atVar, (i) hVar);
                atVar.lAX = new SVG.a(hVar.lBM.left, hVar.lBM.top, hVar.lBM.width(), hVar.lBM.height());
            }
            d((SVG.ah) atVar);
            Path path2 = new Path();
            a((SVG.av) atVar, new f(a2 + a3, f2 + b2, path2));
            path.setFillType(dgH());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class f extends i {
        public Path lBG;
        public float x;
        public float y;

        public f(float f, float f2, Path path) {
            super();
            this.x = f;
            this.y = f2;
            this.lBG = path;
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
        public void Nx(String str) {
            if (c.this.dgC()) {
                Path path = new Path();
                c.this.lBp.jF.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.lBG.addPath(path);
            }
            this.x += c.this.lBp.jF.measureText(str);
        }
    }

    private Path c(SVG.o oVar) {
        float a2 = oVar.lzK == null ? 0.0f : oVar.lzK.a(this);
        float b2 = oVar.lzL == null ? 0.0f : oVar.lzL.b(this);
        float a3 = oVar.lzM == null ? 0.0f : oVar.lzM.a(this);
        float b3 = oVar.lzN != null ? oVar.lzN.b(this) : 0.0f;
        if (oVar.lAX == null) {
            oVar.lAX = new SVG.a(Math.min(a2, b2), Math.min(b2, b3), Math.abs(a3 - a2), Math.abs(b3 - b2));
        }
        Path path = new Path();
        path.moveTo(a2, b2);
        path.lineTo(a3, b3);
        return path;
    }

    private Path b(SVG.z zVar) {
        float a2;
        float b2;
        if (zVar.lzz == null && zVar.lzA == null) {
            a2 = 0.0f;
            b2 = 0.0f;
        } else if (zVar.lzz == null) {
            b2 = zVar.lzA.b(this);
            a2 = b2;
        } else if (zVar.lzA == null) {
            b2 = zVar.lzz.a(this);
            a2 = b2;
        } else {
            a2 = zVar.lzz.a(this);
            b2 = zVar.lzA.b(this);
        }
        float min = Math.min(a2, zVar.lzH.a(this) / 2.0f);
        float min2 = Math.min(b2, zVar.lzI.b(this) / 2.0f);
        float a3 = zVar.lzF != null ? zVar.lzF.a(this) : 0.0f;
        float b3 = zVar.lzG != null ? zVar.lzG.b(this) : 0.0f;
        float a4 = zVar.lzH.a(this);
        float b4 = zVar.lzI.b(this);
        if (zVar.lAX == null) {
            zVar.lAX = new SVG.a(a3, b3, a4, b4);
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
        float a2 = cVar.lzs != null ? cVar.lzs.a(this) : 0.0f;
        float b2 = cVar.lzt != null ? cVar.lzt.b(this) : 0.0f;
        float c = cVar.lzu.c(this);
        float f2 = a2 - c;
        float f3 = b2 - c;
        float f4 = a2 + c;
        float f5 = b2 + c;
        if (cVar.lAX == null) {
            cVar.lAX = new SVG.a(f2, f3, 2.0f * c, 2.0f * c);
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
        float a2 = hVar.lzs != null ? hVar.lzs.a(this) : 0.0f;
        float b2 = hVar.lzt != null ? hVar.lzt.b(this) : 0.0f;
        float a3 = hVar.lzz.a(this);
        float b3 = hVar.lzA.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (hVar.lAX == null) {
            hVar.lAX = new SVG.a(f2, f3, 2.0f * a3, 2.0f * b3);
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
        if (xVar.lAX == null) {
            xVar.lAX = b(path);
        }
        path.setFillType(dgH());
        return path;
    }

    private void a(SVG.ah ahVar, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = wVar.lAd != null && wVar.lAd.booleanValue();
        if (wVar.Rz != null) {
            a(wVar, wVar.Rz);
        }
        if (z) {
            float a2 = wVar.lzF != null ? wVar.lzF.a(this) : 0.0f;
            float b2 = wVar.lzG != null ? wVar.lzG.b(this) : 0.0f;
            float a3 = wVar.lzH != null ? wVar.lzH.a(this) : 0.0f;
            f2 = wVar.lzI != null ? wVar.lzI.b(this) : 0.0f;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = wVar.lzF != null ? wVar.lzF.a(this, 1.0f) : 0.0f;
            float a5 = wVar.lzG != null ? wVar.lzG.a(this, 1.0f) : 0.0f;
            float a6 = wVar.lzH != null ? wVar.lzH.a(this, 1.0f) : 0.0f;
            float a7 = wVar.lzI != null ? wVar.lzI.a(this, 1.0f) : 0.0f;
            float f6 = (a4 * ahVar.lAX.width) + ahVar.lAX.lzm;
            float f7 = (a5 * ahVar.lAX.height) + ahVar.lAX.lzn;
            float f8 = a6 * ahVar.lAX.width;
            f2 = a7 * ahVar.lAX.height;
            f3 = f8;
            f4 = f7;
            f5 = f6;
        }
        if (f3 != 0.0f && f2 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = wVar.lBd != null ? wVar.lBd : PreserveAspectRatio.lyZ;
            dgs();
            this.lBl.clipPath(path);
            g gVar = new g();
            a(gVar, SVG.Style.dgh());
            gVar.lyK.lAC = false;
            this.lBp = a(wVar, gVar);
            SVG.a aVar = ahVar.lAX;
            if (wVar.lAf != null) {
                this.lBl.concat(wVar.lAf);
                Matrix matrix = new Matrix();
                if (wVar.lAf.invert(matrix)) {
                    float[] fArr = {ahVar.lAX.lzm, ahVar.lAX.lzn, ahVar.lAX.dgd(), ahVar.lAX.lzn, ahVar.lAX.dgd(), ahVar.lAX.dge(), ahVar.lAX.lzm, ahVar.lAX.dge()};
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
            float floor = f5 + (((float) Math.floor((aVar.lzm - f5) / f3)) * f3);
            float dgd = aVar.dgd();
            float dge = aVar.dge();
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, f3, f2);
            for (float floor2 = f4 + (((float) Math.floor((aVar.lzn - f4) / f2)) * f2); floor2 < dge; floor2 += f2) {
                for (float f9 = floor; f9 < dgd; f9 += f3) {
                    aVar2.lzm = f9;
                    aVar2.lzn = floor2;
                    dgs();
                    if (!this.lBp.lyK.lAC.booleanValue()) {
                        m(aVar2.lzm, aVar2.lzn, aVar2.width, aVar2.height);
                    }
                    if (wVar.lBg != null) {
                        this.lBl.concat(a(aVar2, wVar.lBg, preserveAspectRatio));
                    } else {
                        boolean z2 = wVar.lAe == null || wVar.lAe.booleanValue();
                        this.lBl.translate(f9, floor2);
                        if (!z2) {
                            this.lBl.scale(ahVar.lAX.width, ahVar.lAX.height);
                        }
                    }
                    boolean dgv = dgv();
                    for (SVG.ak akVar : wVar.ST) {
                        b(akVar);
                    }
                    if (dgv) {
                        b((SVG.ah) wVar);
                    }
                    dgt();
                }
            }
            dgt();
        }
    }

    private void a(SVG.w wVar, String str) {
        SVG.ak Nt = wVar.lBb.Nt(str);
        if (Nt == null) {
            j("Pattern reference '%s' not found", str);
        } else if (!(Nt instanceof SVG.w)) {
            k("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (Nt == wVar) {
            k("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) Nt;
            if (wVar.lAd == null) {
                wVar.lAd = wVar2.lAd;
            }
            if (wVar.lAe == null) {
                wVar.lAe = wVar2.lAe;
            }
            if (wVar.lAf == null) {
                wVar.lAf = wVar2.lAf;
            }
            if (wVar.lzF == null) {
                wVar.lzF = wVar2.lzF;
            }
            if (wVar.lzG == null) {
                wVar.lzG = wVar2.lzG;
            }
            if (wVar.lzH == null) {
                wVar.lzH = wVar2.lzH;
            }
            if (wVar.lzI == null) {
                wVar.lzI = wVar2.lzI;
            }
            if (wVar.ST.isEmpty()) {
                wVar.ST = wVar2.ST;
            }
            if (wVar.lBg == null) {
                wVar.lBg = wVar2.lBg;
            }
            if (wVar.lBd == null) {
                wVar.lBd = wVar2.lBd;
            }
            if (wVar2.Rz != null) {
                a(wVar, wVar2.Rz);
            }
        }
    }

    private void a(SVG.q qVar, SVG.ah ahVar) {
        float f2;
        float f3;
        debug("Mask render", new Object[0]);
        if (qVar.lzU != null && qVar.lzU.booleanValue()) {
            f2 = qVar.lzH != null ? qVar.lzH.a(this) : ahVar.lAX.width;
            f3 = qVar.lzI != null ? qVar.lzI.b(this) : ahVar.lAX.height;
            if (qVar.lzF != null) {
                qVar.lzF.a(this);
            } else {
                float f4 = (float) (ahVar.lAX.lzm - (ahVar.lAX.width * 0.1d));
            }
            if (qVar.lzG != null) {
                qVar.lzG.b(this);
            } else {
                float f5 = (float) (ahVar.lAX.lzn - (ahVar.lAX.height * 0.1d));
            }
        } else {
            float a2 = qVar.lzF != null ? qVar.lzF.a(this, 1.0f) : -0.1f;
            float a3 = qVar.lzG != null ? qVar.lzG.a(this, 1.0f) : -0.1f;
            float a4 = qVar.lzH != null ? qVar.lzH.a(this, 1.0f) : 1.2f;
            float a5 = qVar.lzI != null ? qVar.lzI.a(this, 1.0f) : 1.2f;
            float f6 = (a2 * ahVar.lAX.width) + ahVar.lAX.lzm;
            float f7 = ahVar.lAX.lzn + (a3 * ahVar.lAX.height);
            f2 = ahVar.lAX.width * a4;
            f3 = ahVar.lAX.height * a5;
        }
        if (f2 != 0.0f && f3 != 0.0f) {
            dgs();
            this.lBp = d((SVG.ak) qVar);
            this.lBp.lyK.lAt = Float.valueOf(1.0f);
            if (!(qVar.lzV == null || qVar.lzV.booleanValue())) {
                this.lBl.translate(ahVar.lAX.lzm, ahVar.lAX.lzn);
                this.lBl.scale(ahVar.lAX.width, ahVar.lAX.height);
            }
            a((SVG.ag) qVar, false);
            dgt();
        }
    }
}
