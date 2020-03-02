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
    private ac lDs = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lDt = null;
    private float lDu = 96.0f;
    private CSSParser.d lDv = new CSSParser.d();
    Map<String, ai> lDw = new HashMap();

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
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ad {
        void NR(String str);

        Set<String> diC();

        String diD();

        Set<String> diE();

        Set<String> diF();

        Set<String> diG();

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
        public n lDW;
        public n lDX;
        public n lDY;
        public n lDZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class an extends i {
        public n lDE;
        public n lDF;
        public n lDG;
        public n lFq;
        public n lFr;
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
        ay diH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ba extends k {
        public String Tl;
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class c extends j {
        public n lDE;
        public n lDF;
        public n lDG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class d extends k implements r {
        public Boolean lDH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class h extends j {
        public n lDE;
        public n lDF;
        public n lDL;
        public n lDM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class o extends j {
        public n lDW;
        public n lDX;
        public n lDY;
        public n lDZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class p extends ao implements r {
        public boolean lEa;
        public n lEb;
        public n lEc;
        public n lEd;
        public n lEe;
        public Float lEf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class q extends ae implements r {
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;
        public Boolean lEg;
        public Boolean lEh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class t extends j {
        public u lEj;
        public Float lEk;
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
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;
        public Boolean lEp;
        public Boolean lEq;
        public Matrix lEr;
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
        public n lDL;
        public n lDM;
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;
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

    public Picture dis() {
        float bg;
        n nVar = this.lDs.lDT;
        if (nVar != null) {
            float bg2 = nVar.bg(this.lDu);
            a aVar = this.lDs.lFs;
            if (aVar != null) {
                bg = (aVar.height * bg2) / aVar.width;
            } else {
                n nVar2 = this.lDs.lDU;
                bg = nVar2 != null ? nVar2.bg(this.lDu) : bg2;
            }
            return dr((int) Math.ceil(bg2), (int) Math.ceil(bg));
        }
        return dr(512, 512);
    }

    public Picture dr(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lDu).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac dit() {
        return this.lDs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lDs = acVar;
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
        this.lDv.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> diu() {
        return this.lDv.dil();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean div() {
        return !this.lDv.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class a implements Cloneable {
        public float height;
        public float lDy;
        public float lDz;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lDy = f;
            this.lDz = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float dix() {
            return this.lDy + this.width;
        }

        public float diy() {
            return this.lDz + this.height;
        }

        public void a(a aVar) {
            if (aVar.lDy < this.lDy) {
                this.lDy = aVar.lDy;
            }
            if (aVar.lDz < this.lDz) {
                this.lDz = aVar.lDz;
            }
            if (aVar.dix() > dix()) {
                this.width = aVar.dix() - this.lDy;
            }
            if (aVar.diy() > diy()) {
                this.height = aVar.diy() - this.lDz;
            }
        }

        public String toString() {
            return "[" + this.lDy + HanziToPinyin.Token.SEPARATOR + this.lDz + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public LineCaps lEA;
        public LineJoin lEB;
        public Float lEC;
        public n[] lED;
        public n lEE;
        public Float lEF;
        public e lEG;
        public List<String> lEH;
        public n lEI;
        public Integer lEJ;
        public FontStyle lEK;
        public TextDecoration lEL;
        public TextDirection lEM;
        public TextAnchor lEN;
        public Boolean lEO;
        public b lEP;
        public String lEQ;
        public String lER;
        public String lES;
        public Boolean lET;
        public Boolean lEU;
        public al lEV;
        public Float lEW;
        public FillRule lEX;
        public String lEY;
        public al lEZ;
        public long lEt = 0;
        public al lEu;
        public FillRule lEv;
        public Float lEw;
        public al lEx;
        public Float lEy;
        public n lEz;
        public Float lFa;
        public al lFb;
        public Float lFc;
        public VectorEffect lFd;

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

        public static Style diB() {
            Style style = new Style();
            style.lEt = -1L;
            style.lEu = e.lDJ;
            style.lEv = FillRule.NonZero;
            style.lEw = Float.valueOf(1.0f);
            style.lEx = null;
            style.lEy = Float.valueOf(1.0f);
            style.lEz = new n(1.0f);
            style.lEA = LineCaps.Butt;
            style.lEB = LineJoin.Miter;
            style.lEC = Float.valueOf(4.0f);
            style.lED = null;
            style.lEE = new n(0.0f);
            style.lEF = Float.valueOf(1.0f);
            style.lEG = e.lDJ;
            style.lEH = null;
            style.lEI = new n(12.0f, Unit.pt);
            style.lEJ = 400;
            style.lEK = FontStyle.Normal;
            style.lEL = TextDecoration.None;
            style.lEM = TextDirection.LTR;
            style.lEN = TextAnchor.Start;
            style.lEO = true;
            style.lEP = null;
            style.lEQ = null;
            style.lER = null;
            style.lES = null;
            style.lET = Boolean.TRUE;
            style.lEU = Boolean.TRUE;
            style.lEV = e.lDJ;
            style.lEW = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lEX = FillRule.NonZero;
            style.lEY = null;
            style.lEZ = null;
            style.lFa = Float.valueOf(1.0f);
            style.lFb = null;
            style.lFc = Float.valueOf(1.0f);
            style.lFd = VectorEffect.None;
            return style;
        }

        public void uY(boolean z) {
            this.lET = Boolean.TRUE;
            this.lEO = z ? Boolean.TRUE : Boolean.FALSE;
            this.lEP = null;
            this.clipPath = null;
            this.lEF = Float.valueOf(1.0f);
            this.lEV = e.lDJ;
            this.lEW = Float.valueOf(1.0f);
            this.lEY = null;
            this.lEZ = null;
            this.lFa = Float.valueOf(1.0f);
            this.lFb = null;
            this.lFc = Float.valueOf(1.0f);
            this.lFd = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lED != null) {
                    style.lED = (n[]) this.lED.clone();
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
        public static final e lDJ = new e(0);
        public int lDI;

        public e(int i) {
            this.lDI = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lDI));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class f extends al {
        private static f lDK = new f();

        private f() {
        }

        public static f diz() {
            return lDK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class s extends al {
        public String Tl;
        public al lEi;

        public s(String str, al alVar) {
            this.Tl = str;
            this.lEi = alVar;
        }

        public String toString() {
            return this.Tl + HanziToPinyin.Token.SEPARATOR + this.lEi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class n implements Cloneable {
        Unit lDV;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lDV = Unit.px;
            this.value = f;
            this.lDV = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lDV = Unit.px;
            this.value = f;
            this.lDV = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lDV) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.diJ();
                case ex:
                    return this.value * cVar.diK();
                case in:
                    return this.value * cVar.diI();
                case cm:
                    return (this.value * cVar.diI()) / 2.54f;
                case mm:
                    return (this.value * cVar.diI()) / 25.4f;
                case pt:
                    return (this.value * cVar.diI()) / 72.0f;
                case pc:
                    return (this.value * cVar.diI()) / 6.0f;
                case percent:
                    a diL = cVar.diL();
                    return diL == null ? this.value : (diL.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lDV == Unit.percent) {
                a diL = cVar.diL();
                if (diL == null) {
                    return this.value;
                }
                return (diL.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lDV == Unit.percent) {
                a diL = cVar.diL();
                if (diL == null) {
                    return this.value;
                }
                float f = diL.width;
                float f2 = diL.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lDV == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bg(float f) {
            switch (this.lDV) {
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

        public boolean diA() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lDV;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class b {
        public n lDA;
        public n lDB;
        public n lDC;
        public n lDD;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lDA = nVar;
            this.lDB = nVar2;
            this.lDC = nVar3;
            this.lDD = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ak {
        public SVG lFn;
        public ag lFo;

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
        public Boolean lFk = null;
        public Style lFl = null;
        public Style lCW = null;
        public List<String> lFm = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ah extends ai {
        public a lFj = null;

        protected ah() {
        }
    }

    /* loaded from: classes12.dex */
    protected static class af extends ah implements ad {
        public Set<String> lFe = null;
        public String lFf = null;
        public Set<String> lFg = null;
        public Set<String> lFh = null;
        public Set<String> lFi = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lFe = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diC() {
            return this.lFe;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lFf = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diD() {
            return this.lFf;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFg = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diE() {
            return this.lFg;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFh = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diF() {
            return this.lFh;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFi = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diG() {
            return this.lFi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> UB = new ArrayList();
        public Set<String> lFe = null;
        public String lFf = null;
        public Set<String> lFg = null;
        public Set<String> lFh = null;
        public Set<String> lFi = null;

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
            this.lFe = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diC() {
            return this.lFe;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lFf = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diD() {
            return this.lFf;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFg = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diE() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFh = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diF() {
            return this.lFh;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFi = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diG() {
            return this.lFi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class am extends ae {
        public PreserveAspectRatio lFp = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ao extends am {
        public a lFs;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class k extends ae implements l {
        public Matrix lDQ;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDQ = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static abstract class j extends af implements l {
        public Matrix lDQ;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDQ = matrix;
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
        public List<n> lFv;
        public List<n> lFw;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class at extends ax implements ay, l {
        public Matrix lDQ;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDQ = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class as extends ax implements au {
        private ay lFt;

        public void a(ay ayVar) {
            this.lFt = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class az extends ak implements au {
        private ay lFt;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ar extends av implements au {
        public String Tl;
        private ay lFt;

        public void a(ay ayVar) {
            this.lFt = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aw extends av implements au {
        public String Tl;
        private ay lFt;
        public n lFu;

        public void a(ay ayVar) {
            this.lFt = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class i extends ai implements ag {
        public String Tl;
        public List<ak> UB = new ArrayList();
        public Boolean lDN;
        public Matrix lDO;
        public GradientSpread lDP;

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
        public Float lEs;

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
        public Matrix lDQ;
        public n lDR;
        public n lDS;
        public n lDT;
        public n lDU;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lDQ = matrix;
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
    public com.caverock.androidsvg.d diw() {
        return this.lDt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class u implements v {
        private byte[] lEl;
        private float[] lEn;
        private int lEm = 0;
        private int lEo = 0;

        public u() {
            this.lEl = null;
            this.lEn = null;
            this.lEl = new byte[8];
            this.lEn = new float[16];
        }

        public boolean isEmpty() {
            return this.lEm == 0;
        }

        private void d(byte b) {
            if (this.lEm == this.lEl.length) {
                byte[] bArr = new byte[this.lEl.length * 2];
                System.arraycopy(this.lEl, 0, bArr, 0, this.lEl.length);
                this.lEl = bArr;
            }
            byte[] bArr2 = this.lEl;
            int i = this.lEm;
            this.lEm = i + 1;
            bArr2[i] = b;
        }

        private void Hh(int i) {
            if (this.lEn.length < this.lEo + i) {
                float[] fArr = new float[this.lEn.length * 2];
                System.arraycopy(this.lEn, 0, fArr, 0, this.lEn.length);
                this.lEn = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hh(2);
            float[] fArr = this.lEn;
            int i = this.lEo;
            this.lEo = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEn;
            int i2 = this.lEo;
            this.lEo = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hh(2);
            float[] fArr = this.lEn;
            int i = this.lEo;
            this.lEo = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEn;
            int i2 = this.lEo;
            this.lEo = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hh(6);
            float[] fArr = this.lEn;
            int i = this.lEo;
            this.lEo = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEn;
            int i2 = this.lEo;
            this.lEo = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEn;
            int i3 = this.lEo;
            this.lEo = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEn;
            int i4 = this.lEo;
            this.lEo = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEn;
            int i5 = this.lEo;
            this.lEo = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lEn;
            int i6 = this.lEo;
            this.lEo = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hh(4);
            float[] fArr = this.lEn;
            int i = this.lEo;
            this.lEo = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEn;
            int i2 = this.lEo;
            this.lEo = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEn;
            int i3 = this.lEo;
            this.lEo = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEn;
            int i4 = this.lEo;
            this.lEo = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hh(5);
            float[] fArr = this.lEn;
            int i = this.lEo;
            this.lEo = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEn;
            int i2 = this.lEo;
            this.lEo = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEn;
            int i3 = this.lEo;
            this.lEo = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEn;
            int i4 = this.lEo;
            this.lEo = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEn;
            int i5 = this.lEo;
            this.lEo = i5 + 1;
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
            while (i2 < this.lEm) {
                byte b = this.lEl[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lEn[i3], this.lEn[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lEn[i3], this.lEn[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lEn[i3], this.lEn[i6], this.lEn[i7], this.lEn[i8], this.lEn[i9], this.lEn[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lEn[i3], this.lEn[i11], this.lEn[i12], this.lEn[i13]);
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
                        vVar.a(this.lEn[i3], this.lEn[i14], this.lEn[i15], (b & 2) != 0, (b & 1) != 0, this.lEn[i16], this.lEn[i17]);
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
        if (str.equals(this.lDs.id)) {
            return this.lDs;
        }
        if (this.lDw.containsKey(str)) {
            return this.lDw.get(str);
        }
        ai a2 = a(this.lDs, str);
        this.lDw.put(str, a2);
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
