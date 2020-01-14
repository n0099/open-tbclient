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
    private ac lCJ = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lCK = null;
    private float lCL = 96.0f;
    private CSSParser.d lCM = new CSSParser.d();
    Map<String, ai> lCN = new HashMap();

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
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface ad {
        void NF(String str);

        Set<String> dhm();

        String dhn();

        Set<String> dho();

        Set<String> dhp();

        Set<String> dhq();

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
        public n lDn;
        public n lDo;
        public n lDp;
        public n lDq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class an extends i {
        public n lCV;
        public n lCW;
        public n lCX;
        public n lEH;
        public n lEI;
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
        ay dhr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ba extends k {
        public String RC;
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class c extends j {
        public n lCV;
        public n lCW;
        public n lCX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class d extends k implements r {
        public Boolean lCY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class h extends j {
        public n lCV;
        public n lCW;
        public n lDc;
        public n lDd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class o extends j {
        public n lDn;
        public n lDo;
        public n lDp;
        public n lDq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class p extends ao implements r {
        public boolean lDr;
        public n lDs;
        public n lDt;
        public n lDu;
        public n lDv;
        public Float lDw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class q extends ae implements r {
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
        public Boolean lDx;
        public Boolean lDy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class t extends j {
        public u lDA;
        public Float lDB;
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
        public Boolean lDG;
        public Boolean lDH;
        public Matrix lDI;
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
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
        public n lDc;
        public n lDd;
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;
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

    public Picture dhc() {
        float bh;
        n nVar = this.lCJ.lDk;
        if (nVar != null) {
            float bh2 = nVar.bh(this.lCL);
            a aVar = this.lCJ.lEJ;
            if (aVar != null) {
                bh = (aVar.height * bh2) / aVar.width;
            } else {
                n nVar2 = this.lCJ.lDl;
                bh = nVar2 != null ? nVar2.bh(this.lCL) : bh2;
            }
            return m31do((int) Math.ceil(bh2), (int) Math.ceil(bh));
        }
        return m31do(512, 512);
    }

    /* renamed from: do  reason: not valid java name */
    public Picture m31do(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lCL).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac dhd() {
        return this.lCJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lCJ = acVar;
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
        this.lCM.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> dhe() {
        return this.lCM.dgV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dhf() {
        return !this.lCM.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class a implements Cloneable {
        public float height;
        public float lCP;
        public float lCQ;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lCP = f;
            this.lCQ = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float dhh() {
            return this.lCP + this.width;
        }

        public float dhi() {
            return this.lCQ + this.height;
        }

        public void a(a aVar) {
            if (aVar.lCP < this.lCP) {
                this.lCP = aVar.lCP;
            }
            if (aVar.lCQ < this.lCQ) {
                this.lCQ = aVar.lCQ;
            }
            if (aVar.dhh() > dhh()) {
                this.width = aVar.dhh() - this.lCP;
            }
            if (aVar.dhi() > dhi()) {
                this.height = aVar.dhi() - this.lCQ;
            }
        }

        public String toString() {
            return "[" + this.lCP + HanziToPinyin.Token.SEPARATOR + this.lCQ + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public long lDK = 0;
        public al lDL;
        public FillRule lDM;
        public Float lDN;
        public al lDO;
        public Float lDP;
        public n lDQ;
        public LineCaps lDR;
        public LineJoin lDS;
        public Float lDT;
        public n[] lDU;
        public n lDV;
        public Float lDW;
        public e lDX;
        public List<String> lDY;
        public n lDZ;
        public Integer lEa;
        public FontStyle lEb;
        public TextDecoration lEc;
        public TextDirection lEd;
        public TextAnchor lEe;
        public Boolean lEf;
        public b lEg;
        public String lEh;
        public String lEi;
        public String lEj;
        public Boolean lEk;
        public Boolean lEl;
        public al lEm;
        public Float lEn;
        public FillRule lEo;
        public String lEp;
        public al lEq;
        public Float lEr;
        public al lEs;
        public Float lEt;
        public VectorEffect lEu;

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

        public static Style dhl() {
            Style style = new Style();
            style.lDK = -1L;
            style.lDL = e.lDa;
            style.lDM = FillRule.NonZero;
            style.lDN = Float.valueOf(1.0f);
            style.lDO = null;
            style.lDP = Float.valueOf(1.0f);
            style.lDQ = new n(1.0f);
            style.lDR = LineCaps.Butt;
            style.lDS = LineJoin.Miter;
            style.lDT = Float.valueOf(4.0f);
            style.lDU = null;
            style.lDV = new n(0.0f);
            style.lDW = Float.valueOf(1.0f);
            style.lDX = e.lDa;
            style.lDY = null;
            style.lDZ = new n(12.0f, Unit.pt);
            style.lEa = 400;
            style.lEb = FontStyle.Normal;
            style.lEc = TextDecoration.None;
            style.lEd = TextDirection.LTR;
            style.lEe = TextAnchor.Start;
            style.lEf = true;
            style.lEg = null;
            style.lEh = null;
            style.lEi = null;
            style.lEj = null;
            style.lEk = Boolean.TRUE;
            style.lEl = Boolean.TRUE;
            style.lEm = e.lDa;
            style.lEn = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lEo = FillRule.NonZero;
            style.lEp = null;
            style.lEq = null;
            style.lEr = Float.valueOf(1.0f);
            style.lEs = null;
            style.lEt = Float.valueOf(1.0f);
            style.lEu = VectorEffect.None;
            return style;
        }

        public void uU(boolean z) {
            this.lEk = Boolean.TRUE;
            this.lEf = z ? Boolean.TRUE : Boolean.FALSE;
            this.lEg = null;
            this.clipPath = null;
            this.lDW = Float.valueOf(1.0f);
            this.lEm = e.lDa;
            this.lEn = Float.valueOf(1.0f);
            this.lEp = null;
            this.lEq = null;
            this.lEr = Float.valueOf(1.0f);
            this.lEs = null;
            this.lEt = Float.valueOf(1.0f);
            this.lEu = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lDU != null) {
                    style.lDU = (n[]) this.lDU.clone();
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
        public static final e lDa = new e(0);
        public int lCZ;

        public e(int i) {
            this.lCZ = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lCZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class f extends al {
        private static f lDb = new f();

        private f() {
        }

        public static f dhj() {
            return lDb;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class s extends al {
        public String RC;
        public al lDz;

        public s(String str, al alVar) {
            this.RC = str;
            this.lDz = alVar;
        }

        public String toString() {
            return this.RC + HanziToPinyin.Token.SEPARATOR + this.lDz;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class n implements Cloneable {
        Unit lDm;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lDm = Unit.px;
            this.value = f;
            this.lDm = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lDm = Unit.px;
            this.value = f;
            this.lDm = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lDm) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.dht();
                case ex:
                    return this.value * cVar.dhu();
                case in:
                    return this.value * cVar.dhs();
                case cm:
                    return (this.value * cVar.dhs()) / 2.54f;
                case mm:
                    return (this.value * cVar.dhs()) / 25.4f;
                case pt:
                    return (this.value * cVar.dhs()) / 72.0f;
                case pc:
                    return (this.value * cVar.dhs()) / 6.0f;
                case percent:
                    a dhv = cVar.dhv();
                    return dhv == null ? this.value : (dhv.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lDm == Unit.percent) {
                a dhv = cVar.dhv();
                if (dhv == null) {
                    return this.value;
                }
                return (dhv.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lDm == Unit.percent) {
                a dhv = cVar.dhv();
                if (dhv == null) {
                    return this.value;
                }
                float f = dhv.width;
                float f2 = dhv.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lDm == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bh(float f) {
            switch (this.lDm) {
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

        public boolean dhk() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lDm;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class b {
        public n lCR;
        public n lCS;
        public n lCT;
        public n lCU;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lCR = nVar;
            this.lCS = nVar2;
            this.lCT = nVar3;
            this.lCU = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ak {
        public SVG lEE;
        public ag lEF;

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
        public Boolean lEB = null;
        public Style lEC = null;
        public Style lCn = null;
        public List<String> lED = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ah extends ai {
        public a lEA = null;

        protected ah() {
        }
    }

    /* loaded from: classes10.dex */
    protected static class af extends ah implements ad {
        public Set<String> lEv = null;
        public String lEw = null;
        public Set<String> lEx = null;
        public Set<String> lEy = null;
        public Set<String> lEz = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lEv = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhm() {
            return this.lEv;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NF(String str) {
            this.lEw = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dhn() {
            return this.lEw;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lEx = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dho() {
            return this.lEx;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lEy = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhp() {
            return this.lEy;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lEz = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhq() {
            return this.lEz;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> SW = new ArrayList();
        public Set<String> lEv = null;
        public String lEw = null;
        public Set<String> lEx = null;
        public Set<String> lEy = null;
        public Set<String> lEz = null;

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
            this.lEv = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhm() {
            return this.lEv;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NF(String str) {
            this.lEw = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String dhn() {
            return this.lEw;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lEx = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dho() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lEy = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhp() {
            return this.lEy;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lEz = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dhq() {
            return this.lEz;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class am extends ae {
        public PreserveAspectRatio lEG = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ao extends am {
        public a lEJ;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class k extends ae implements l {
        public Matrix lDh;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDh = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static abstract class j extends af implements l {
        public Matrix lDh;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDh = matrix;
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
        public List<n> lEM;
        public List<n> lEN;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class at extends ax implements ay, l {
        public Matrix lDh;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDh = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class as extends ax implements au {
        private ay lEK;

        public void a(ay ayVar) {
            this.lEK = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhr() {
            return this.lEK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class az extends ak implements au {
        private ay lEK;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhr() {
            return this.lEK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class ar extends av implements au {
        public String RC;
        private ay lEK;

        public void a(ay ayVar) {
            this.lEK = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhr() {
            return this.lEK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class aw extends av implements au {
        public String RC;
        private ay lEK;
        public n lEL;

        public void a(ay ayVar) {
            this.lEK = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay dhr() {
            return this.lEK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class i extends ai implements ag {
        public String RC;
        public List<ak> SW = new ArrayList();
        public Boolean lDe;
        public Matrix lDf;
        public GradientSpread lDg;

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
        public Float lDJ;

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
        public Matrix lDh;
        public n lDi;
        public n lDj;
        public n lDk;
        public n lDl;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDh = matrix;
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
    public com.caverock.androidsvg.d dhg() {
        return this.lCK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class u implements v {
        private byte[] lDC;
        private float[] lDE;
        private int lDD = 0;
        private int lDF = 0;

        public u() {
            this.lDC = null;
            this.lDE = null;
            this.lDC = new byte[8];
            this.lDE = new float[16];
        }

        public boolean isEmpty() {
            return this.lDD == 0;
        }

        private void d(byte b) {
            if (this.lDD == this.lDC.length) {
                byte[] bArr = new byte[this.lDC.length * 2];
                System.arraycopy(this.lDC, 0, bArr, 0, this.lDC.length);
                this.lDC = bArr;
            }
            byte[] bArr2 = this.lDC;
            int i = this.lDD;
            this.lDD = i + 1;
            bArr2[i] = b;
        }

        private void Hc(int i) {
            if (this.lDE.length < this.lDF + i) {
                float[] fArr = new float[this.lDE.length * 2];
                System.arraycopy(this.lDE, 0, fArr, 0, this.lDE.length);
                this.lDE = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hc(2);
            float[] fArr = this.lDE;
            int i = this.lDF;
            this.lDF = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDE;
            int i2 = this.lDF;
            this.lDF = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hc(2);
            float[] fArr = this.lDE;
            int i = this.lDF;
            this.lDF = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDE;
            int i2 = this.lDF;
            this.lDF = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hc(6);
            float[] fArr = this.lDE;
            int i = this.lDF;
            this.lDF = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDE;
            int i2 = this.lDF;
            this.lDF = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDE;
            int i3 = this.lDF;
            this.lDF = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDE;
            int i4 = this.lDF;
            this.lDF = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lDE;
            int i5 = this.lDF;
            this.lDF = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lDE;
            int i6 = this.lDF;
            this.lDF = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hc(4);
            float[] fArr = this.lDE;
            int i = this.lDF;
            this.lDF = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDE;
            int i2 = this.lDF;
            this.lDF = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDE;
            int i3 = this.lDF;
            this.lDF = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDE;
            int i4 = this.lDF;
            this.lDF = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hc(5);
            float[] fArr = this.lDE;
            int i = this.lDF;
            this.lDF = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lDE;
            int i2 = this.lDF;
            this.lDF = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lDE;
            int i3 = this.lDF;
            this.lDF = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lDE;
            int i4 = this.lDF;
            this.lDF = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lDE;
            int i5 = this.lDF;
            this.lDF = i5 + 1;
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
            while (i2 < this.lDD) {
                byte b = this.lDC[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lDE[i3], this.lDE[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lDE[i3], this.lDE[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lDE[i3], this.lDE[i6], this.lDE[i7], this.lDE[i8], this.lDE[i9], this.lDE[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lDE[i3], this.lDE[i11], this.lDE[i12], this.lDE[i13]);
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
                        vVar.a(this.lDE[i3], this.lDE[i14], this.lDE[i15], (b & 2) != 0, (b & 1) != 0, this.lDE[i16], this.lDE[i17]);
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
        if (str.equals(this.lCJ.id)) {
            return this.lCJ;
        }
        if (this.lCN.containsKey(str)) {
            return this.lCN.get(str);
        }
        ai a2 = a(this.lCJ, str);
        this.lCN.put(str, a2);
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
