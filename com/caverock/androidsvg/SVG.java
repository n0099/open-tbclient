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
/* loaded from: classes12.dex */
public class SVG {
    private ac lDq = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lDr = null;
    private float lDs = 96.0f;
    private CSSParser.d lDt = new CSSParser.d();
    Map<String, ai> lDu = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public static class ac extends ao {
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ad {
        void NR(String str);

        Set<String> diA();

        String diB();

        Set<String> diC();

        Set<String> diD();

        Set<String> diE();

        void i(Set<String> set);

        void j(Set<String> set);

        void k(Set<String> set);

        void l(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ag {
        void a(ak akVar) throws SAXException;

        List<ak> getChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aj extends i {
        public n lDU;
        public n lDV;
        public n lDW;
        public n lDX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class an extends i {
        public n lDC;
        public n lDD;
        public n lDE;
        public n lFo;
        public n lFp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ap extends k {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aq extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface au {
        ay diF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ba extends k {
        public String Tl;
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class c extends j {
        public n lDC;
        public n lDD;
        public n lDE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class d extends k implements r {
        public Boolean lDF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class h extends j {
        public n lDC;
        public n lDD;
        public n lDJ;
        public n lDK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class o extends j {
        public n lDU;
        public n lDV;
        public n lDW;
        public n lDX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class p extends ao implements r {
        public boolean lDY;
        public n lDZ;
        public n lEa;
        public n lEb;
        public n lEc;
        public Float lEd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class q extends ae implements r {
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;
        public Boolean lEe;
        public Boolean lEf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class t extends j {
        public u lEh;
        public Float lEi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface v {
        void B(float f, float f2);

        void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void b(float f, float f2, float f3, float f4, float f5, float f6);

        void close();

        void l(float f, float f2, float f3, float f4);

        void moveTo(float f, float f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class w extends ao implements r {
        public String Tl;
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;
        public Boolean lEn;
        public Boolean lEo;
        public Matrix lEp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class x extends j {
        public float[] points;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class y extends x {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class z extends j {
        public n lDJ;
        public n lDK;
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;
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

    public Picture diq() {
        float bg;
        n nVar = this.lDq.lDR;
        if (nVar != null) {
            float bg2 = nVar.bg(this.lDs);
            a aVar = this.lDq.lFq;
            if (aVar != null) {
                bg = (aVar.height * bg2) / aVar.width;
            } else {
                n nVar2 = this.lDq.lDS;
                bg = nVar2 != null ? nVar2.bg(this.lDs) : bg2;
            }
            return dr((int) Math.ceil(bg2), (int) Math.ceil(bg));
        }
        return dr(512, 512);
    }

    public Picture dr(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lDs).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac dir() {
        return this.lDq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lDq = acVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak NP(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return NQ(str.substring(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CSSParser.d dVar) {
        this.lDt.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> dis() {
        return this.lDt.dij();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dit() {
        return !this.lDt.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class a implements Cloneable {
        public float height;
        public float lDw;
        public float lDx;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lDw = f;
            this.lDx = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float div() {
            return this.lDw + this.width;
        }

        public float diw() {
            return this.lDx + this.height;
        }

        public void a(a aVar) {
            if (aVar.lDw < this.lDw) {
                this.lDw = aVar.lDw;
            }
            if (aVar.lDx < this.lDx) {
                this.lDx = aVar.lDx;
            }
            if (aVar.div() > div()) {
                this.width = aVar.div() - this.lDw;
            }
            if (aVar.diw() > diw()) {
                this.height = aVar.diw() - this.lDx;
            }
        }

        public String toString() {
            return "[" + this.lDw + HanziToPinyin.Token.SEPARATOR + this.lDx + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public Float lEA;
        public n[] lEB;
        public n lEC;
        public Float lED;
        public e lEE;
        public List<String> lEF;
        public n lEG;
        public Integer lEH;
        public FontStyle lEI;
        public TextDecoration lEJ;
        public TextDirection lEK;
        public TextAnchor lEL;
        public Boolean lEM;
        public b lEN;
        public String lEO;
        public String lEP;
        public String lEQ;
        public Boolean lER;
        public Boolean lES;
        public al lET;
        public Float lEU;
        public FillRule lEV;
        public String lEW;
        public al lEX;
        public Float lEY;
        public al lEZ;
        public long lEr = 0;
        public al lEs;
        public FillRule lEt;
        public Float lEu;
        public al lEv;
        public Float lEw;
        public n lEx;
        public LineCaps lEy;
        public LineJoin lEz;
        public Float lFa;
        public VectorEffect lFb;

        /* loaded from: classes12.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes12.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes12.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes12.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes12.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes12.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes12.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes12.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        public static Style diz() {
            Style style = new Style();
            style.lEr = -1L;
            style.lEs = e.lDH;
            style.lEt = FillRule.NonZero;
            style.lEu = Float.valueOf(1.0f);
            style.lEv = null;
            style.lEw = Float.valueOf(1.0f);
            style.lEx = new n(1.0f);
            style.lEy = LineCaps.Butt;
            style.lEz = LineJoin.Miter;
            style.lEA = Float.valueOf(4.0f);
            style.lEB = null;
            style.lEC = new n(0.0f);
            style.lED = Float.valueOf(1.0f);
            style.lEE = e.lDH;
            style.lEF = null;
            style.lEG = new n(12.0f, Unit.pt);
            style.lEH = 400;
            style.lEI = FontStyle.Normal;
            style.lEJ = TextDecoration.None;
            style.lEK = TextDirection.LTR;
            style.lEL = TextAnchor.Start;
            style.lEM = true;
            style.lEN = null;
            style.lEO = null;
            style.lEP = null;
            style.lEQ = null;
            style.lER = Boolean.TRUE;
            style.lES = Boolean.TRUE;
            style.lET = e.lDH;
            style.lEU = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lEV = FillRule.NonZero;
            style.lEW = null;
            style.lEX = null;
            style.lEY = Float.valueOf(1.0f);
            style.lEZ = null;
            style.lFa = Float.valueOf(1.0f);
            style.lFb = VectorEffect.None;
            return style;
        }

        public void uY(boolean z) {
            this.lER = Boolean.TRUE;
            this.lEM = z ? Boolean.TRUE : Boolean.FALSE;
            this.lEN = null;
            this.clipPath = null;
            this.lED = Float.valueOf(1.0f);
            this.lET = e.lDH;
            this.lEU = Float.valueOf(1.0f);
            this.lEW = null;
            this.lEX = null;
            this.lEY = Float.valueOf(1.0f);
            this.lEZ = null;
            this.lFa = Float.valueOf(1.0f);
            this.lFb = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lEB != null) {
                    style.lEB = (n[]) this.lEB.clone();
                }
                return style;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static abstract class al implements Cloneable {
        protected al() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class e extends al {
        public static final e lDH = new e(0);
        public int lDG;

        public e(int i) {
            this.lDG = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lDG));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class f extends al {
        private static f lDI = new f();

        private f() {
        }

        public static f dix() {
            return lDI;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class s extends al {
        public String Tl;
        public al lEg;

        public s(String str, al alVar) {
            this.Tl = str;
            this.lEg = alVar;
        }

        public String toString() {
            return this.Tl + HanziToPinyin.Token.SEPARATOR + this.lEg;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class n implements Cloneable {
        Unit lDT;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lDT = Unit.px;
            this.value = f;
            this.lDT = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lDT = Unit.px;
            this.value = f;
            this.lDT = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lDT) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.diH();
                case ex:
                    return this.value * cVar.diI();
                case in:
                    return this.value * cVar.diG();
                case cm:
                    return (this.value * cVar.diG()) / 2.54f;
                case mm:
                    return (this.value * cVar.diG()) / 25.4f;
                case pt:
                    return (this.value * cVar.diG()) / 72.0f;
                case pc:
                    return (this.value * cVar.diG()) / 6.0f;
                case percent:
                    a diJ = cVar.diJ();
                    return diJ == null ? this.value : (diJ.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lDT == Unit.percent) {
                a diJ = cVar.diJ();
                if (diJ == null) {
                    return this.value;
                }
                return (diJ.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lDT == Unit.percent) {
                a diJ = cVar.diJ();
                if (diJ == null) {
                    return this.value;
                }
                float f = diJ.width;
                float f2 = diJ.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lDT == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bg(float f) {
            switch (this.lDT) {
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

        public boolean diy() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lDT;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class b {
        public n lDA;
        public n lDB;
        public n lDy;
        public n lDz;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lDy = nVar;
            this.lDz = nVar2;
            this.lDA = nVar3;
            this.lDB = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ak {
        public SVG lFl;
        public ag lFm;

        protected ak() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ai extends ak {
        public String id = null;
        public Boolean lFi = null;
        public Style lFj = null;
        public Style lCU = null;
        public List<String> lFk = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ah extends ai {
        public a lFh = null;

        protected ah() {
        }
    }

    /* loaded from: classes12.dex */
    protected static class af extends ah implements ad {
        public Set<String> lFc = null;
        public String lFd = null;
        public Set<String> lFe = null;
        public Set<String> lFf = null;
        public Set<String> lFg = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lFc = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diA() {
            return this.lFc;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lFd = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diB() {
            return this.lFd;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFe = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diC() {
            return this.lFe;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFf = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diD() {
            return this.lFf;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFg = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diE() {
            return this.lFg;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> UB = new ArrayList();
        public Set<String> lFc = null;
        public String lFd = null;
        public Set<String> lFe = null;
        public Set<String> lFf = null;
        public Set<String> lFg = null;

        protected ae() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.UB;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            this.UB.add(akVar);
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lFc = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diA() {
            return this.lFc;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lFd = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diB() {
            return this.lFd;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFe = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diC() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFf = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diD() {
            return this.lFf;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFg = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diE() {
            return this.lFg;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class am extends ae {
        public PreserveAspectRatio lFn = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ao extends am {
        public a lFq;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class k extends ae implements l {
        public Matrix lDO;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDO = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static abstract class j extends af implements l {
        public Matrix lDO;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDO = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class av extends ae {
        protected av() {
        }

        @Override // com.caverock.androidsvg.SVG.ae, com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof au) {
                this.UB.add(akVar);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ax extends av {
        public List<n> lFt;
        public List<n> lFu;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class at extends ax implements ay, l {
        public Matrix lDO;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDO = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class as extends ax implements au {
        private ay lFr;

        public void a(ay ayVar) {
            this.lFr = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diF() {
            return this.lFr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class az extends ak implements au {
        private ay lFr;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diF() {
            return this.lFr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ar extends av implements au {
        public String Tl;
        private ay lFr;

        public void a(ay ayVar) {
            this.lFr = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diF() {
            return this.lFr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aw extends av implements au {
        public String Tl;
        private ay lFr;
        public n lFs;

        public void a(ay ayVar) {
            this.lFr = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diF() {
            return this.lFr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class i extends ai implements ag {
        public String Tl;
        public List<ak> UB = new ArrayList();
        public Boolean lDL;
        public Matrix lDM;
        public GradientSpread lDN;

        protected i() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.UB;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof ab) {
                this.UB.add(akVar);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ab extends ai implements ag {
        public Float lEq;

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class m extends am implements l {
        public String Tl;
        public Matrix lDO;
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lDS;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDO = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
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
    public com.caverock.androidsvg.d diu() {
        return this.lDr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class u implements v {
        private byte[] lEj;
        private float[] lEl;
        private int lEk = 0;
        private int lEm = 0;

        public u() {
            this.lEj = null;
            this.lEl = null;
            this.lEj = new byte[8];
            this.lEl = new float[16];
        }

        public boolean isEmpty() {
            return this.lEk == 0;
        }

        private void d(byte b) {
            if (this.lEk == this.lEj.length) {
                byte[] bArr = new byte[this.lEj.length * 2];
                System.arraycopy(this.lEj, 0, bArr, 0, this.lEj.length);
                this.lEj = bArr;
            }
            byte[] bArr2 = this.lEj;
            int i = this.lEk;
            this.lEk = i + 1;
            bArr2[i] = b;
        }

        private void Hh(int i) {
            if (this.lEl.length < this.lEm + i) {
                float[] fArr = new float[this.lEl.length * 2];
                System.arraycopy(this.lEl, 0, fArr, 0, this.lEl.length);
                this.lEl = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hh(2);
            float[] fArr = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEl;
            int i2 = this.lEm;
            this.lEm = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hh(2);
            float[] fArr = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEl;
            int i2 = this.lEm;
            this.lEm = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hh(6);
            float[] fArr = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEl;
            int i2 = this.lEm;
            this.lEm = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEl;
            int i3 = this.lEm;
            this.lEm = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEl;
            int i4 = this.lEm;
            this.lEm = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEl;
            int i5 = this.lEm;
            this.lEm = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lEl;
            int i6 = this.lEm;
            this.lEm = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hh(4);
            float[] fArr = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEl;
            int i2 = this.lEm;
            this.lEm = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEl;
            int i3 = this.lEm;
            this.lEm = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEl;
            int i4 = this.lEm;
            this.lEm = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hh(5);
            float[] fArr = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEl;
            int i2 = this.lEm;
            this.lEm = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEl;
            int i3 = this.lEm;
            this.lEm = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEl;
            int i4 = this.lEm;
            this.lEm = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEl;
            int i5 = this.lEm;
            this.lEm = i5 + 1;
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
            while (i2 < this.lEk) {
                byte b = this.lEj[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lEl[i3], this.lEl[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lEl[i3], this.lEl[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lEl[i3], this.lEl[i6], this.lEl[i7], this.lEl[i8], this.lEl[i9], this.lEl[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lEl[i3], this.lEl[i11], this.lEl[i12], this.lEl[i13]);
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
                        vVar.a(this.lEl[i3], this.lEl[i14], this.lEl[i15], (b & 2) != 0, (b & 1) != 0, this.lEl[i16], this.lEl[i17]);
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

    protected ak NQ(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.lDq.id)) {
            return this.lDq;
        }
        if (this.lDu.containsKey(str)) {
            return this.lDu.get(str);
        }
        ai a2 = a(this.lDq, str);
        this.lDu.put(str, a2);
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
