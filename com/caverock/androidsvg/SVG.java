package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes9.dex */
public class SVG {
    private ac lzg = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lzh = null;
    private float lzi = 96.0f;
    private CSSParser.d lzj = new CSSParser.d();
    Map<String, ai> lzk = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ac extends ao {
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface ad {
        void Nv(String str);

        Set<String> dgi();

        String dgj();

        Set<String> dgk();

        Set<String> dgl();

        Set<String> dgm();

        void i(Set<String> set);

        void j(Set<String> set);

        void k(Set<String> set);

        void l(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface ag {
        void a(ak akVar) throws SAXException;

        List<ak> getChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class aj extends i {
        public n lzK;
        public n lzL;
        public n lzM;
        public n lzN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class an extends i {
        public n lBe;
        public n lBf;
        public n lzs;
        public n lzt;
        public n lzu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ap extends k {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class aq extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface au {
        ay dgn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ba extends k {
        public String Rz;
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class c extends j {
        public n lzs;
        public n lzt;
        public n lzu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class d extends k implements r {
        public Boolean lzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class h extends j {
        public n lzA;
        public n lzs;
        public n lzt;
        public n lzz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface l {
        void c(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class o extends j {
        public n lzK;
        public n lzL;
        public n lzM;
        public n lzN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class p extends ao implements r {
        public boolean lzO;
        public n lzP;
        public n lzQ;
        public n lzR;
        public n lzS;
        public Float lzT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class q extends ae implements r {
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;
        public Boolean lzU;
        public Boolean lzV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class t extends j {
        public u lzX;
        public Float lzY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface v {
        void B(float f, float f2);

        void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void b(float f, float f2, float f3, float f4, float f5, float f6);

        void close();

        void l(float f, float f2, float f3, float f4);

        void moveTo(float f, float f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class w extends ao implements r {
        public String Rz;
        public Boolean lAd;
        public Boolean lAe;
        public Matrix lAf;
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class x extends j {
        public float[] points;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class y extends x {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class z extends j {
        public n lzA;
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;
        public n lzz;
    }

    public static SVG n(InputStream inputStream) throws SVGParseException {
        return new SVGParser().o(inputStream);
    }

    public static SVG I(Context context, int i2) throws SVGParseException {
        return e(context.getResources(), i2);
    }

    public static SVG e(Resources resources, int i2) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            return sVGParser.o(openRawResource);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException e2) {
            }
        }
    }

    public static SVG a(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        InputStream open = assetManager.open(str);
        try {
            return sVGParser.o(open);
        } finally {
            try {
                open.close();
            } catch (IOException e2) {
            }
        }
    }

    public Picture dfY() {
        float bi;
        n nVar = this.lzg.lzH;
        if (nVar != null) {
            float bi2 = nVar.bi(this.lzi);
            a aVar = this.lzg.lBg;
            if (aVar != null) {
                bi = (aVar.height * bi2) / aVar.width;
            } else {
                n nVar2 = this.lzg.lzI;
                bi = nVar2 != null ? nVar2.bi(this.lzi) : bi2;
            }
            return dq((int) Math.ceil(bi2), (int) Math.ceil(bi));
        }
        return dq(512, 512);
    }

    public Picture dq(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lzi).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac dfZ() {
        return this.lzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lzg = acVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak Nt(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return Nu(str.substring(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CSSParser.d dVar) {
        this.lzj.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> dga() {
        return this.lzj.dfR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dgb() {
        return !this.lzj.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class a implements Cloneable {
        public float height;
        public float lzm;
        public float lzn;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lzm = f;
            this.lzn = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float dgd() {
            return this.lzm + this.width;
        }

        public float dge() {
            return this.lzn + this.height;
        }

        public void a(a aVar) {
            if (aVar.lzm < this.lzm) {
                this.lzm = aVar.lzm;
            }
            if (aVar.lzn < this.lzn) {
                this.lzn = aVar.lzn;
            }
            if (aVar.dgd() > dgd()) {
                this.width = aVar.dgd() - this.lzm;
            }
            if (aVar.dge() > dge()) {
                this.height = aVar.dge() - this.lzn;
            }
        }

        public String toString() {
            return "[" + this.lzm + HanziToPinyin.Token.SEPARATOR + this.lzn + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public TextDirection lAA;
        public TextAnchor lAB;
        public Boolean lAC;
        public b lAD;
        public String lAE;
        public String lAF;
        public String lAG;
        public Boolean lAH;
        public Boolean lAI;
        public al lAJ;
        public Float lAK;
        public FillRule lAL;
        public String lAM;
        public al lAN;
        public Float lAO;
        public al lAP;
        public Float lAQ;
        public VectorEffect lAR;
        public long lAh = 0;
        public al lAi;
        public FillRule lAj;
        public Float lAk;
        public al lAl;
        public Float lAm;
        public n lAn;
        public LineCaps lAo;
        public LineJoin lAp;
        public Float lAq;
        public n[] lAr;
        public n lAs;
        public Float lAt;
        public e lAu;
        public List<String> lAv;
        public n lAw;
        public Integer lAx;
        public FontStyle lAy;
        public TextDecoration lAz;

        /* loaded from: classes9.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes9.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes9.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes9.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes9.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes9.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes9.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes9.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style dgh() {
            Style style = new Style();
            style.lAh = -1L;
            style.lAi = e.lzx;
            style.lAj = FillRule.NonZero;
            style.lAk = Float.valueOf(1.0f);
            style.lAl = null;
            style.lAm = Float.valueOf(1.0f);
            style.lAn = new n(1.0f);
            style.lAo = LineCaps.Butt;
            style.lAp = LineJoin.Miter;
            style.lAq = Float.valueOf(4.0f);
            style.lAr = null;
            style.lAs = new n(0.0f);
            style.lAt = Float.valueOf(1.0f);
            style.lAu = e.lzx;
            style.lAv = null;
            style.lAw = new n(12.0f, Unit.pt);
            style.lAx = 400;
            style.lAy = FontStyle.Normal;
            style.lAz = TextDecoration.None;
            style.lAA = TextDirection.LTR;
            style.lAB = TextAnchor.Start;
            style.lAC = true;
            style.lAD = null;
            style.lAE = null;
            style.lAF = null;
            style.lAG = null;
            style.lAH = Boolean.TRUE;
            style.lAI = Boolean.TRUE;
            style.lAJ = e.lzx;
            style.lAK = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lAL = FillRule.NonZero;
            style.lAM = null;
            style.lAN = null;
            style.lAO = Float.valueOf(1.0f);
            style.lAP = null;
            style.lAQ = Float.valueOf(1.0f);
            style.lAR = VectorEffect.None;
            return style;
        }

        public void uJ(boolean z) {
            this.lAH = Boolean.TRUE;
            this.lAC = z ? Boolean.TRUE : Boolean.FALSE;
            this.lAD = null;
            this.clipPath = null;
            this.lAt = Float.valueOf(1.0f);
            this.lAJ = e.lzx;
            this.lAK = Float.valueOf(1.0f);
            this.lAM = null;
            this.lAN = null;
            this.lAO = Float.valueOf(1.0f);
            this.lAP = null;
            this.lAQ = Float.valueOf(1.0f);
            this.lAR = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lAr != null) {
                    style.lAr = (n[]) this.lAr.clone();
                }
                return style;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static abstract class al implements Cloneable {
        protected al() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class e extends al {
        public static final e lzx = new e(0);
        public int lzw;

        public e(int i) {
            this.lzw = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lzw));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class f extends al {
        private static f lzy = new f();

        private f() {
        }

        public static f dgf() {
            return lzy;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class s extends al {
        public String Rz;
        public al lzW;

        public s(String str, al alVar) {
            this.Rz = str;
            this.lzW = alVar;
        }

        public String toString() {
            return this.Rz + HanziToPinyin.Token.SEPARATOR + this.lzW;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class n implements Cloneable {
        Unit lzJ;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lzJ = Unit.px;
            this.value = f;
            this.lzJ = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lzJ = Unit.px;
            this.value = f;
            this.lzJ = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lzJ) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.dgp();
                case ex:
                    return this.value * cVar.dgq();
                case in:
                    return this.value * cVar.dgo();
                case cm:
                    return (this.value * cVar.dgo()) / 2.54f;
                case mm:
                    return (this.value * cVar.dgo()) / 25.4f;
                case pt:
                    return (this.value * cVar.dgo()) / 72.0f;
                case pc:
                    return (this.value * cVar.dgo()) / 6.0f;
                case percent:
                    a dgr = cVar.dgr();
                    return dgr == null ? this.value : (dgr.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lzJ == Unit.percent) {
                a dgr = cVar.dgr();
                if (dgr == null) {
                    return this.value;
                }
                return (dgr.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lzJ == Unit.percent) {
                a dgr = cVar.dgr();
                if (dgr == null) {
                    return this.value;
                }
                float f = dgr.width;
                float f2 = dgr.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lzJ == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bi(float f) {
            switch (this.lzJ) {
                case px:
                    return this.value;
                case em:
                case ex:
                default:
                    return this.value;
                case in:
                    return this.value * f;
                case cm:
                    return (this.value * f) / 2.54f;
                case mm:
                    return (this.value * f) / 25.4f;
                case pt:
                    return (this.value * f) / 72.0f;
                case pc:
                    return (this.value * f) / 6.0f;
            }
        }

        public boolean isZero() {
            return this.value == 0.0f;
        }

        public boolean dgg() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lzJ;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class b {
        public n lzo;
        public n lzp;
        public n lzq;
        public n lzr;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lzo = nVar;
            this.lzp = nVar2;
            this.lzq = nVar3;
            this.lzr = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ak {
        public SVG lBb;
        public ag lBc;

        protected ak() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ai extends ak {
        public String id = null;
        public Boolean lAY = null;
        public Style lAZ = null;
        public Style lyK = null;
        public List<String> lBa = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ah extends ai {
        public a lAX = null;

        protected ah() {
        }
    }

    /* loaded from: classes9.dex */
    protected static class af extends ah implements ad {
        public Set<String> lAS = null;
        public String lAT = null;
        public Set<String> lAU = null;
        public Set<String> lAV = null;
        public Set<String> lAW = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lAS = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgi() {
            return this.lAS;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void Nv(String str) {
            this.lAT = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dgj() {
            return this.lAT;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lAU = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgk() {
            return this.lAU;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lAV = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgl() {
            return this.lAV;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lAW = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgm() {
            return this.lAW;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> ST = new ArrayList();
        public Set<String> lAS = null;
        public String lAT = null;
        public Set<String> lAU = null;
        public Set<String> lAV = null;
        public Set<String> lAW = null;

        protected ae() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.ST;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            this.ST.add(akVar);
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lAS = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgi() {
            return this.lAS;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void Nv(String str) {
            this.lAT = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dgj() {
            return this.lAT;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lAU = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgk() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lAV = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgl() {
            return this.lAV;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lAW = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dgm() {
            return this.lAW;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class am extends ae {
        public PreserveAspectRatio lBd = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ao extends am {
        public a lBg;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class k extends ae implements l {
        public Matrix lzE;

        @Override // com.caverock.androidsvg.SVG.l
        public void c(Matrix matrix) {
            this.lzE = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static abstract class j extends af implements l {
        public Matrix lzE;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void c(Matrix matrix) {
            this.lzE = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class av extends ae {
        protected av() {
        }

        @Override // com.caverock.androidsvg.SVG.ae, com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof au) {
                this.ST.add(akVar);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ax extends av {
        public List<n> lBj;
        public List<n> lBk;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class at extends ax implements ay, l {
        public Matrix lzE;

        @Override // com.caverock.androidsvg.SVG.l
        public void c(Matrix matrix) {
            this.lzE = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class as extends ax implements au {
        private ay lBh;

        public void a(ay ayVar) {
            this.lBh = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dgn() {
            return this.lBh;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class az extends ak implements au {
        private ay lBh;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dgn() {
            return this.lBh;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ar extends av implements au {
        public String Rz;
        private ay lBh;

        public void a(ay ayVar) {
            this.lBh = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dgn() {
            return this.lBh;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class aw extends av implements au {
        public String Rz;
        private ay lBh;
        public n lBi;

        public void a(ay ayVar) {
            this.lBh = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dgn() {
            return this.lBh;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class i extends ai implements ag {
        public String Rz;
        public List<ak> ST = new ArrayList();
        public Boolean lzB;
        public Matrix lzC;
        public GradientSpread lzD;

        protected i() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.ST;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof ab) {
                this.ST.add(akVar);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class ab extends ai implements ag {
        public Float lAg;

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class m extends am implements l {
        public String Rz;
        public Matrix lzE;
        public n lzF;
        public n lzG;
        public n lzH;
        public n lzI;

        @Override // com.caverock.androidsvg.SVG.l
        public void c(Matrix matrix) {
            this.lzE = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class aa extends ai implements ag {
        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDesc(String str) {
        this.desc = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.caverock.androidsvg.d dgc() {
        return this.lzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class u implements v {
        private float[] lAb;
        private byte[] lzZ;
        private int lAa = 0;
        private int lAc = 0;

        public u() {
            this.lzZ = null;
            this.lAb = null;
            this.lzZ = new byte[8];
            this.lAb = new float[16];
        }

        public boolean isEmpty() {
            return this.lAa == 0;
        }

        private void d(byte b) {
            if (this.lAa == this.lzZ.length) {
                byte[] bArr = new byte[this.lzZ.length * 2];
                System.arraycopy(this.lzZ, 0, bArr, 0, this.lzZ.length);
                this.lzZ = bArr;
            }
            byte[] bArr2 = this.lzZ;
            int i = this.lAa;
            this.lAa = i + 1;
            bArr2[i] = b;
        }

        private void GX(int i) {
            if (this.lAb.length < this.lAc + i) {
                float[] fArr = new float[this.lAb.length * 2];
                System.arraycopy(this.lAb, 0, fArr, 0, this.lAb.length);
                this.lAb = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            GX(2);
            float[] fArr = this.lAb;
            int i = this.lAc;
            this.lAc = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lAb;
            int i2 = this.lAc;
            this.lAc = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            GX(2);
            float[] fArr = this.lAb;
            int i = this.lAc;
            this.lAc = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lAb;
            int i2 = this.lAc;
            this.lAc = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            GX(6);
            float[] fArr = this.lAb;
            int i = this.lAc;
            this.lAc = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lAb;
            int i2 = this.lAc;
            this.lAc = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lAb;
            int i3 = this.lAc;
            this.lAc = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lAb;
            int i4 = this.lAc;
            this.lAc = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lAb;
            int i5 = this.lAc;
            this.lAc = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lAb;
            int i6 = this.lAc;
            this.lAc = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            GX(4);
            float[] fArr = this.lAb;
            int i = this.lAc;
            this.lAc = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lAb;
            int i2 = this.lAc;
            this.lAc = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lAb;
            int i3 = this.lAc;
            this.lAc = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lAb;
            int i4 = this.lAc;
            this.lAc = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            GX(5);
            float[] fArr = this.lAb;
            int i = this.lAc;
            this.lAc = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lAb;
            int i2 = this.lAc;
            this.lAc = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lAb;
            int i3 = this.lAc;
            this.lAc = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lAb;
            int i4 = this.lAc;
            this.lAc = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lAb;
            int i5 = this.lAc;
            this.lAc = i5 + 1;
            fArr5[i5] = f5;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            d((byte) 8);
        }

        public void a(v vVar) {
            int i;
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.lAa) {
                byte b = this.lzZ[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lAb[i3], this.lAb[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lAb[i3], this.lAb[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lAb[i3], this.lAb[i6], this.lAb[i7], this.lAb[i8], this.lAb[i9], this.lAb[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lAb[i3], this.lAb[i11], this.lAb[i12], this.lAb[i13]);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        int i14 = i3 + 1;
                        int i15 = i14 + 1;
                        int i16 = i15 + 1;
                        int i17 = i16 + 1;
                        vVar.a(this.lAb[i3], this.lAb[i14], this.lAb[i15], (b & 2) != 0, (b & 1) != 0, this.lAb[i16], this.lAb[i17]);
                        i = i17 + 1;
                        break;
                    case 8:
                        vVar.close();
                        i = i3;
                        break;
                }
                i2++;
                i3 = i;
            }
        }
    }

    protected ak Nu(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.lzg.id)) {
            return this.lzg;
        }
        if (this.lzk.containsKey(str)) {
            return this.lzk.get(str);
        }
        ai a2 = a(this.lzg, str);
        this.lzk.put(str, a2);
        return a2;
    }

    private ai a(ag agVar, String str) {
        ai a2;
        ai aiVar = (ai) agVar;
        if (!str.equals(aiVar.id)) {
            for (ak akVar : agVar.getChildren()) {
                if (akVar instanceof ai) {
                    ai aiVar2 = (ai) akVar;
                    if (str.equals(aiVar2.id)) {
                        return aiVar2;
                    }
                    if ((akVar instanceof ag) && (a2 = a((ag) akVar, str)) != null) {
                        return a2;
                    }
                }
            }
            return null;
        }
        return aiVar;
    }
}
