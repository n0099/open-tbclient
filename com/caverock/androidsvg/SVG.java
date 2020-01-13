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
/* loaded from: classes10.dex */
public class SVG {
    private ac lCE = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lCF = null;
    private float lCG = 96.0f;
    private CSSParser.d lCH = new CSSParser.d();
    Map<String, ai> lCI = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static class ac extends ao {
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface ad {
        void NF(String str);

        Set<String> dhk();

        String dhl();

        Set<String> dhm();

        Set<String> dhn();

        Set<String> dho();

        void i(Set<String> set);

        void j(Set<String> set);

        void k(Set<String> set);

        void l(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface ag {
        void a(ak akVar) throws SAXException;

        List<ak> getChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class aj extends i {
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class an extends i {
        public n lCQ;
        public n lCR;
        public n lCS;
        public n lEC;
        public n lED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ap extends k {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class aq extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface au {
        ay dhp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ba extends k {
        public String RC;
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class c extends j {
        public n lCQ;
        public n lCR;
        public n lCS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class d extends k implements r {
        public Boolean lCT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class h extends j {
        public n lCQ;
        public n lCR;
        public n lCX;
        public n lCY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class o extends j {
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class p extends ao implements r {
        public boolean lDm;
        public n lDn;
        public n lDo;
        public n lDp;
        public n lDq;
        public Float lDr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class q extends ae implements r {
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;
        public Boolean lDs;
        public Boolean lDt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class t extends j {
        public u lDv;
        public Float lDw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface v {
        void B(float f, float f2);

        void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void b(float f, float f2, float f3, float f4, float f5, float f6);

        void close();

        void l(float f, float f2, float f3, float f4);

        void moveTo(float f, float f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class w extends ao implements r {
        public String RC;
        public Boolean lDB;
        public Boolean lDC;
        public Matrix lDD;
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class x extends j {
        public float[] points;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class y extends x {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class z extends j {
        public n lCX;
        public n lCY;
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;
    }

    public static SVG n(InputStream inputStream) throws SVGParseException {
        return new SVGParser().o(inputStream);
    }

    public static SVG J(Context context, int i2) throws SVGParseException {
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

    public Picture dha() {
        float bh;
        n nVar = this.lCE.lDf;
        if (nVar != null) {
            float bh2 = nVar.bh(this.lCG);
            a aVar = this.lCE.lEE;
            if (aVar != null) {
                bh = (aVar.height * bh2) / aVar.width;
            } else {
                n nVar2 = this.lCE.lDg;
                bh = nVar2 != null ? nVar2.bh(this.lCG) : bh2;
            }
            return m31do((int) Math.ceil(bh2), (int) Math.ceil(bh));
        }
        return m31do(512, 512);
    }

    /* renamed from: do  reason: not valid java name */
    public Picture m31do(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lCG).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac dhb() {
        return this.lCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lCE = acVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak ND(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return NE(str.substring(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CSSParser.d dVar) {
        this.lCH.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> dhc() {
        return this.lCH.dgT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dhd() {
        return !this.lCH.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class a implements Cloneable {
        public float height;
        public float lCK;
        public float lCL;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lCK = f;
            this.lCL = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float dhf() {
            return this.lCK + this.width;
        }

        public float dhg() {
            return this.lCL + this.height;
        }

        public void a(a aVar) {
            if (aVar.lCK < this.lCK) {
                this.lCK = aVar.lCK;
            }
            if (aVar.lCL < this.lCL) {
                this.lCL = aVar.lCL;
            }
            if (aVar.dhf() > dhf()) {
                this.width = aVar.dhf() - this.lCK;
            }
            if (aVar.dhg() > dhg()) {
                this.height = aVar.dhg() - this.lCL;
            }
        }

        public String toString() {
            return "[" + this.lCK + HanziToPinyin.Token.SEPARATOR + this.lCL + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public long lDF = 0;
        public al lDG;
        public FillRule lDH;
        public Float lDI;
        public al lDJ;
        public Float lDK;
        public n lDL;
        public LineCaps lDM;
        public LineJoin lDN;
        public Float lDO;
        public n[] lDP;
        public n lDQ;
        public Float lDR;
        public e lDS;
        public List<String> lDT;
        public n lDU;
        public Integer lDV;
        public FontStyle lDW;
        public TextDecoration lDX;
        public TextDirection lDY;
        public TextAnchor lDZ;
        public Boolean lEa;
        public b lEb;
        public String lEc;
        public String lEd;
        public String lEe;
        public Boolean lEf;
        public Boolean lEg;
        public al lEh;
        public Float lEi;
        public FillRule lEj;
        public String lEk;
        public al lEl;
        public Float lEm;
        public al lEn;
        public Float lEo;
        public VectorEffect lEp;

        /* loaded from: classes10.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes10.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes10.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes10.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes10.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes10.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes10.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes10.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style dhj() {
            Style style = new Style();
            style.lDF = -1L;
            style.lDG = e.lCV;
            style.lDH = FillRule.NonZero;
            style.lDI = Float.valueOf(1.0f);
            style.lDJ = null;
            style.lDK = Float.valueOf(1.0f);
            style.lDL = new n(1.0f);
            style.lDM = LineCaps.Butt;
            style.lDN = LineJoin.Miter;
            style.lDO = Float.valueOf(4.0f);
            style.lDP = null;
            style.lDQ = new n(0.0f);
            style.lDR = Float.valueOf(1.0f);
            style.lDS = e.lCV;
            style.lDT = null;
            style.lDU = new n(12.0f, Unit.pt);
            style.lDV = 400;
            style.lDW = FontStyle.Normal;
            style.lDX = TextDecoration.None;
            style.lDY = TextDirection.LTR;
            style.lDZ = TextAnchor.Start;
            style.lEa = true;
            style.lEb = null;
            style.lEc = null;
            style.lEd = null;
            style.lEe = null;
            style.lEf = Boolean.TRUE;
            style.lEg = Boolean.TRUE;
            style.lEh = e.lCV;
            style.lEi = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lEj = FillRule.NonZero;
            style.lEk = null;
            style.lEl = null;
            style.lEm = Float.valueOf(1.0f);
            style.lEn = null;
            style.lEo = Float.valueOf(1.0f);
            style.lEp = VectorEffect.None;
            return style;
        }

        public void uU(boolean z) {
            this.lEf = Boolean.TRUE;
            this.lEa = z ? Boolean.TRUE : Boolean.FALSE;
            this.lEb = null;
            this.clipPath = null;
            this.lDR = Float.valueOf(1.0f);
            this.lEh = e.lCV;
            this.lEi = Float.valueOf(1.0f);
            this.lEk = null;
            this.lEl = null;
            this.lEm = Float.valueOf(1.0f);
            this.lEn = null;
            this.lEo = Float.valueOf(1.0f);
            this.lEp = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lDP != null) {
                    style.lDP = (n[]) this.lDP.clone();
                }
                return style;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static abstract class al implements Cloneable {
        protected al() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class e extends al {
        public static final e lCV = new e(0);
        public int lCU;

        public e(int i) {
            this.lCU = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lCU));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class f extends al {
        private static f lCW = new f();

        private f() {
        }

        public static f dhh() {
            return lCW;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class s extends al {
        public String RC;
        public al lDu;

        public s(String str, al alVar) {
            this.RC = str;
            this.lDu = alVar;
        }

        public String toString() {
            return this.RC + HanziToPinyin.Token.SEPARATOR + this.lDu;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class n implements Cloneable {
        Unit lDh;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lDh = Unit.px;
            this.value = f;
            this.lDh = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lDh = Unit.px;
            this.value = f;
            this.lDh = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lDh) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.dhr();
                case ex:
                    return this.value * cVar.dhs();
                case in:
                    return this.value * cVar.dhq();
                case cm:
                    return (this.value * cVar.dhq()) / 2.54f;
                case mm:
                    return (this.value * cVar.dhq()) / 25.4f;
                case pt:
                    return (this.value * cVar.dhq()) / 72.0f;
                case pc:
                    return (this.value * cVar.dhq()) / 6.0f;
                case percent:
                    a dht = cVar.dht();
                    return dht == null ? this.value : (dht.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lDh == Unit.percent) {
                a dht = cVar.dht();
                if (dht == null) {
                    return this.value;
                }
                return (dht.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lDh == Unit.percent) {
                a dht = cVar.dht();
                if (dht == null) {
                    return this.value;
                }
                float f = dht.width;
                float f2 = dht.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lDh == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bh(float f) {
            switch (this.lDh) {
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

        public boolean dhi() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lDh;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class b {
        public n lCM;
        public n lCN;
        public n lCO;
        public n lCP;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lCM = nVar;
            this.lCN = nVar2;
            this.lCO = nVar3;
            this.lCP = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ak {
        public ag lEA;
        public SVG lEz;

        protected ak() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ai extends ak {
        public String id = null;
        public Boolean lEw = null;
        public Style lEx = null;
        public Style lCi = null;
        public List<String> lEy = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ah extends ai {
        public a lEv = null;

        protected ah() {
        }
    }

    /* loaded from: classes10.dex */
    protected static class af extends ah implements ad {
        public Set<String> lEq = null;
        public String lEr = null;
        public Set<String> lEs = null;
        public Set<String> lEt = null;
        public Set<String> lEu = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lEq = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhk() {
            return this.lEq;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NF(String str) {
            this.lEr = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dhl() {
            return this.lEr;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lEs = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhm() {
            return this.lEs;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lEt = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhn() {
            return this.lEt;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lEu = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dho() {
            return this.lEu;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> SW = new ArrayList();
        public Set<String> lEq = null;
        public String lEr = null;
        public Set<String> lEs = null;
        public Set<String> lEt = null;
        public Set<String> lEu = null;

        protected ae() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.SW;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            this.SW.add(akVar);
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lEq = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhk() {
            return this.lEq;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NF(String str) {
            this.lEr = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dhl() {
            return this.lEr;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lEs = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhm() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lEt = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhn() {
            return this.lEt;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lEu = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dho() {
            return this.lEu;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class am extends ae {
        public PreserveAspectRatio lEB = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ao extends am {
        public a lEE;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class k extends ae implements l {
        public Matrix lDc;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDc = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static abstract class j extends af implements l {
        public Matrix lDc;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDc = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class av extends ae {
        protected av() {
        }

        @Override // com.caverock.androidsvg.SVG.ae, com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof au) {
                this.SW.add(akVar);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ax extends av {
        public List<n> lEH;
        public List<n> lEI;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class at extends ax implements ay, l {
        public Matrix lDc;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDc = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class as extends ax implements au {
        private ay lEF;

        public void a(ay ayVar) {
            this.lEF = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhp() {
            return this.lEF;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class az extends ak implements au {
        private ay lEF;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhp() {
            return this.lEF;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ar extends av implements au {
        public String RC;
        private ay lEF;

        public void a(ay ayVar) {
            this.lEF = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhp() {
            return this.lEF;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class aw extends av implements au {
        public String RC;
        private ay lEF;
        public n lEG;

        public void a(ay ayVar) {
            this.lEF = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhp() {
            return this.lEF;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class i extends ai implements ag {
        public String RC;
        public List<ak> SW = new ArrayList();
        public Boolean lCZ;
        public Matrix lDa;
        public GradientSpread lDb;

        protected i() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.SW;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof ab) {
                this.SW.add(akVar);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ab extends ai implements ag {
        public Float lDE;

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class m extends am implements l {
        public String RC;
        public Matrix lDc;
        public n lDd;
        public n lDe;
        public n lDf;
        public n lDg;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDc = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
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
    public com.caverock.androidsvg.d dhe() {
        return this.lCF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class u implements v {
        private byte[] lDx;
        private float[] lDz;
        private int lDy = 0;
        private int lDA = 0;

        public u() {
            this.lDx = null;
            this.lDz = null;
            this.lDx = new byte[8];
            this.lDz = new float[16];
        }

        public boolean isEmpty() {
            return this.lDy == 0;
        }

        private void d(byte b) {
            if (this.lDy == this.lDx.length) {
                byte[] bArr = new byte[this.lDx.length * 2];
                System.arraycopy(this.lDx, 0, bArr, 0, this.lDx.length);
                this.lDx = bArr;
            }
            byte[] bArr2 = this.lDx;
            int i = this.lDy;
            this.lDy = i + 1;
            bArr2[i] = b;
        }

        private void Hc(int i) {
            if (this.lDz.length < this.lDA + i) {
                float[] fArr = new float[this.lDz.length * 2];
                System.arraycopy(this.lDz, 0, fArr, 0, this.lDz.length);
                this.lDz = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hc(2);
            float[] fArr = this.lDz;
            int i = this.lDA;
            this.lDA = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDz;
            int i2 = this.lDA;
            this.lDA = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hc(2);
            float[] fArr = this.lDz;
            int i = this.lDA;
            this.lDA = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDz;
            int i2 = this.lDA;
            this.lDA = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hc(6);
            float[] fArr = this.lDz;
            int i = this.lDA;
            this.lDA = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDz;
            int i2 = this.lDA;
            this.lDA = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDz;
            int i3 = this.lDA;
            this.lDA = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDz;
            int i4 = this.lDA;
            this.lDA = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lDz;
            int i5 = this.lDA;
            this.lDA = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lDz;
            int i6 = this.lDA;
            this.lDA = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hc(4);
            float[] fArr = this.lDz;
            int i = this.lDA;
            this.lDA = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDz;
            int i2 = this.lDA;
            this.lDA = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDz;
            int i3 = this.lDA;
            this.lDA = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDz;
            int i4 = this.lDA;
            this.lDA = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hc(5);
            float[] fArr = this.lDz;
            int i = this.lDA;
            this.lDA = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDz;
            int i2 = this.lDA;
            this.lDA = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDz;
            int i3 = this.lDA;
            this.lDA = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDz;
            int i4 = this.lDA;
            this.lDA = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lDz;
            int i5 = this.lDA;
            this.lDA = i5 + 1;
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
            while (i2 < this.lDy) {
                byte b = this.lDx[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lDz[i3], this.lDz[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lDz[i3], this.lDz[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lDz[i3], this.lDz[i6], this.lDz[i7], this.lDz[i8], this.lDz[i9], this.lDz[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lDz[i3], this.lDz[i11], this.lDz[i12], this.lDz[i13]);
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
                        vVar.a(this.lDz[i3], this.lDz[i14], this.lDz[i15], (b & 2) != 0, (b & 1) != 0, this.lDz[i16], this.lDz[i17]);
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

    protected ak NE(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.lCE.id)) {
            return this.lCE;
        }
        if (this.lCI.containsKey(str)) {
            return this.lCI.get(str);
        }
        ai a2 = a(this.lCE, str);
        this.lCI.put(str, a2);
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
