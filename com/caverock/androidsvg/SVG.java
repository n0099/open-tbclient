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
    private ac lDD = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lDE = null;
    private float lDF = 96.0f;
    private CSSParser.d lDG = new CSSParser.d();
    Map<String, ai> lDH = new HashMap();

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
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ad {
        void NS(String str);

        Set<String> diD();

        String diE();

        Set<String> diF();

        Set<String> diG();

        Set<String> diH();

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
        public n lEh;
        public n lEi;
        public n lEj;
        public n lEk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class an extends i {
        public n lDP;
        public n lDQ;
        public n lDR;
        public n lFB;
        public n lFC;
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
        ay diI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ba extends k {
        public String Tl;
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class c extends j {
        public n lDP;
        public n lDQ;
        public n lDR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class d extends k implements r {
        public Boolean lDS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class h extends j {
        public n lDP;
        public n lDQ;
        public n lDW;
        public n lDX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class o extends j {
        public n lEh;
        public n lEi;
        public n lEj;
        public n lEk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class p extends ao implements r {
        public boolean lEl;
        public n lEm;
        public n lEn;
        public n lEo;
        public n lEp;
        public Float lEq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class q extends ae implements r {
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;
        public Boolean lEr;
        public Boolean lEs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class t extends j {
        public u lEu;
        public Float lEv;
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
        public Boolean lEA;
        public Boolean lEB;
        public Matrix lEC;
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;
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
        public n lDW;
        public n lDX;
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;
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

    public Picture dit() {
        float bg;
        n nVar = this.lDD.lEe;
        if (nVar != null) {
            float bg2 = nVar.bg(this.lDF);
            a aVar = this.lDD.lFD;
            if (aVar != null) {
                bg = (aVar.height * bg2) / aVar.width;
            } else {
                n nVar2 = this.lDD.lEf;
                bg = nVar2 != null ? nVar2.bg(this.lDF) : bg2;
            }
            return dr((int) Math.ceil(bg2), (int) Math.ceil(bg));
        }
        return dr(512, 512);
    }

    public Picture dr(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lDF).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac diu() {
        return this.lDD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lDD = acVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak NQ(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return NR(str.substring(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CSSParser.d dVar) {
        this.lDG.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> div() {
        return this.lDG.dim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean diw() {
        return !this.lDG.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class a implements Cloneable {
        public float height;
        public float lDJ;
        public float lDK;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lDJ = f;
            this.lDK = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float diy() {
            return this.lDJ + this.width;
        }

        public float diz() {
            return this.lDK + this.height;
        }

        public void a(a aVar) {
            if (aVar.lDJ < this.lDJ) {
                this.lDJ = aVar.lDJ;
            }
            if (aVar.lDK < this.lDK) {
                this.lDK = aVar.lDK;
            }
            if (aVar.diy() > diy()) {
                this.width = aVar.diy() - this.lDJ;
            }
            if (aVar.diz() > diz()) {
                this.height = aVar.diz() - this.lDK;
            }
        }

        public String toString() {
            return "[" + this.lDJ + HanziToPinyin.Token.SEPARATOR + this.lDK + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public long lEE = 0;
        public al lEF;
        public FillRule lEG;
        public Float lEH;
        public al lEI;
        public Float lEJ;
        public n lEK;
        public LineCaps lEL;
        public LineJoin lEM;
        public Float lEN;
        public n[] lEO;
        public n lEP;
        public Float lEQ;
        public e lER;
        public List<String> lES;
        public n lET;
        public Integer lEU;
        public FontStyle lEV;
        public TextDecoration lEW;
        public TextDirection lEX;
        public TextAnchor lEY;
        public Boolean lEZ;
        public b lFa;
        public String lFb;
        public String lFc;
        public String lFd;
        public Boolean lFe;
        public Boolean lFf;
        public al lFg;
        public Float lFh;
        public FillRule lFi;
        public String lFj;
        public al lFk;
        public Float lFl;
        public al lFm;
        public Float lFn;
        public VectorEffect lFo;

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

        public static Style diC() {
            Style style = new Style();
            style.lEE = -1L;
            style.lEF = e.lDU;
            style.lEG = FillRule.NonZero;
            style.lEH = Float.valueOf(1.0f);
            style.lEI = null;
            style.lEJ = Float.valueOf(1.0f);
            style.lEK = new n(1.0f);
            style.lEL = LineCaps.Butt;
            style.lEM = LineJoin.Miter;
            style.lEN = Float.valueOf(4.0f);
            style.lEO = null;
            style.lEP = new n(0.0f);
            style.lEQ = Float.valueOf(1.0f);
            style.lER = e.lDU;
            style.lES = null;
            style.lET = new n(12.0f, Unit.pt);
            style.lEU = 400;
            style.lEV = FontStyle.Normal;
            style.lEW = TextDecoration.None;
            style.lEX = TextDirection.LTR;
            style.lEY = TextAnchor.Start;
            style.lEZ = true;
            style.lFa = null;
            style.lFb = null;
            style.lFc = null;
            style.lFd = null;
            style.lFe = Boolean.TRUE;
            style.lFf = Boolean.TRUE;
            style.lFg = e.lDU;
            style.lFh = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lFi = FillRule.NonZero;
            style.lFj = null;
            style.lFk = null;
            style.lFl = Float.valueOf(1.0f);
            style.lFm = null;
            style.lFn = Float.valueOf(1.0f);
            style.lFo = VectorEffect.None;
            return style;
        }

        public void uY(boolean z) {
            this.lFe = Boolean.TRUE;
            this.lEZ = z ? Boolean.TRUE : Boolean.FALSE;
            this.lFa = null;
            this.clipPath = null;
            this.lEQ = Float.valueOf(1.0f);
            this.lFg = e.lDU;
            this.lFh = Float.valueOf(1.0f);
            this.lFj = null;
            this.lFk = null;
            this.lFl = Float.valueOf(1.0f);
            this.lFm = null;
            this.lFn = Float.valueOf(1.0f);
            this.lFo = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lEO != null) {
                    style.lEO = (n[]) this.lEO.clone();
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
        public static final e lDU = new e(0);
        public int lDT;

        public e(int i) {
            this.lDT = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lDT));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class f extends al {
        private static f lDV = new f();

        private f() {
        }

        public static f diA() {
            return lDV;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class s extends al {
        public String Tl;
        public al lEt;

        public s(String str, al alVar) {
            this.Tl = str;
            this.lEt = alVar;
        }

        public String toString() {
            return this.Tl + HanziToPinyin.Token.SEPARATOR + this.lEt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class n implements Cloneable {
        Unit lEg;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lEg = Unit.px;
            this.value = f;
            this.lEg = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lEg = Unit.px;
            this.value = f;
            this.lEg = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lEg) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.diK();
                case ex:
                    return this.value * cVar.diL();
                case in:
                    return this.value * cVar.diJ();
                case cm:
                    return (this.value * cVar.diJ()) / 2.54f;
                case mm:
                    return (this.value * cVar.diJ()) / 25.4f;
                case pt:
                    return (this.value * cVar.diJ()) / 72.0f;
                case pc:
                    return (this.value * cVar.diJ()) / 6.0f;
                case percent:
                    a diM = cVar.diM();
                    return diM == null ? this.value : (diM.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lEg == Unit.percent) {
                a diM = cVar.diM();
                if (diM == null) {
                    return this.value;
                }
                return (diM.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lEg == Unit.percent) {
                a diM = cVar.diM();
                if (diM == null) {
                    return this.value;
                }
                float f = diM.width;
                float f2 = diM.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lEg == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bg(float f) {
            switch (this.lEg) {
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

        public boolean diB() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lEg;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class b {
        public n lDL;
        public n lDM;
        public n lDN;
        public n lDO;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lDL = nVar;
            this.lDM = nVar2;
            this.lDN = nVar3;
            this.lDO = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ak {
        public SVG lFy;
        public ag lFz;

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
        public Boolean lFv = null;
        public Style lFw = null;
        public Style lDh = null;
        public List<String> lFx = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ah extends ai {
        public a lFu = null;

        protected ah() {
        }
    }

    /* loaded from: classes12.dex */
    protected static class af extends ah implements ad {
        public Set<String> lFp = null;
        public String lFq = null;
        public Set<String> lFr = null;
        public Set<String> lFs = null;
        public Set<String> lFt = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lFp = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diD() {
            return this.lFp;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NS(String str) {
            this.lFq = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diE() {
            return this.lFq;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFr = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diF() {
            return this.lFr;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFs = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diG() {
            return this.lFs;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFt = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> UB = new ArrayList();
        public Set<String> lFp = null;
        public String lFq = null;
        public Set<String> lFr = null;
        public Set<String> lFs = null;
        public Set<String> lFt = null;

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
            this.lFp = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diD() {
            return this.lFp;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NS(String str) {
            this.lFq = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String diE() {
            return this.lFq;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lFr = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diF() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lFs = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diG() {
            return this.lFs;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lFt = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> diH() {
            return this.lFt;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class am extends ae {
        public PreserveAspectRatio lFA = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ao extends am {
        public a lFD;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class k extends ae implements l {
        public Matrix lEb;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lEb = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static abstract class j extends af implements l {
        public Matrix lEb;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lEb = matrix;
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
        public List<n> lFG;
        public List<n> lFH;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class at extends ax implements ay, l {
        public Matrix lEb;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lEb = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class as extends ax implements au {
        private ay lFE;

        public void a(ay ayVar) {
            this.lFE = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diI() {
            return this.lFE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class az extends ak implements au {
        private ay lFE;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diI() {
            return this.lFE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ar extends av implements au {
        public String Tl;
        private ay lFE;

        public void a(ay ayVar) {
            this.lFE = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diI() {
            return this.lFE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aw extends av implements au {
        public String Tl;
        private ay lFE;
        public n lFF;

        public void a(ay ayVar) {
            this.lFE = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay diI() {
            return this.lFE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class i extends ai implements ag {
        public String Tl;
        public List<ak> UB = new ArrayList();
        public Boolean lDY;
        public Matrix lDZ;
        public GradientSpread lEa;

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
        public Float lED;

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
        public Matrix lEb;
        public n lEc;
        public n lEd;
        public n lEe;
        public n lEf;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lEb = matrix;
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
    public com.caverock.androidsvg.d dix() {
        return this.lDE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class u implements v {
        private byte[] lEw;
        private float[] lEy;
        private int lEx = 0;
        private int lEz = 0;

        public u() {
            this.lEw = null;
            this.lEy = null;
            this.lEw = new byte[8];
            this.lEy = new float[16];
        }

        public boolean isEmpty() {
            return this.lEx == 0;
        }

        private void d(byte b) {
            if (this.lEx == this.lEw.length) {
                byte[] bArr = new byte[this.lEw.length * 2];
                System.arraycopy(this.lEw, 0, bArr, 0, this.lEw.length);
                this.lEw = bArr;
            }
            byte[] bArr2 = this.lEw;
            int i = this.lEx;
            this.lEx = i + 1;
            bArr2[i] = b;
        }

        private void Hh(int i) {
            if (this.lEy.length < this.lEz + i) {
                float[] fArr = new float[this.lEy.length * 2];
                System.arraycopy(this.lEy, 0, fArr, 0, this.lEy.length);
                this.lEy = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hh(2);
            float[] fArr = this.lEy;
            int i = this.lEz;
            this.lEz = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEy;
            int i2 = this.lEz;
            this.lEz = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hh(2);
            float[] fArr = this.lEy;
            int i = this.lEz;
            this.lEz = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEy;
            int i2 = this.lEz;
            this.lEz = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hh(6);
            float[] fArr = this.lEy;
            int i = this.lEz;
            this.lEz = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEy;
            int i2 = this.lEz;
            this.lEz = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEy;
            int i3 = this.lEz;
            this.lEz = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEy;
            int i4 = this.lEz;
            this.lEz = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEy;
            int i5 = this.lEz;
            this.lEz = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lEy;
            int i6 = this.lEz;
            this.lEz = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hh(4);
            float[] fArr = this.lEy;
            int i = this.lEz;
            this.lEz = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEy;
            int i2 = this.lEz;
            this.lEz = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEy;
            int i3 = this.lEz;
            this.lEz = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEy;
            int i4 = this.lEz;
            this.lEz = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hh(5);
            float[] fArr = this.lEy;
            int i = this.lEz;
            this.lEz = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lEy;
            int i2 = this.lEz;
            this.lEz = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lEy;
            int i3 = this.lEz;
            this.lEz = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lEy;
            int i4 = this.lEz;
            this.lEz = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lEy;
            int i5 = this.lEz;
            this.lEz = i5 + 1;
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
            while (i2 < this.lEx) {
                byte b = this.lEw[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lEy[i3], this.lEy[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lEy[i3], this.lEy[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lEy[i3], this.lEy[i6], this.lEy[i7], this.lEy[i8], this.lEy[i9], this.lEy[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lEy[i3], this.lEy[i11], this.lEy[i12], this.lEy[i13]);
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
                        vVar.a(this.lEy[i3], this.lEy[i14], this.lEy[i15], (b & 2) != 0, (b & 1) != 0, this.lEy[i16], this.lEy[i17]);
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

    protected ak NR(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.lDD.id)) {
            return this.lDD;
        }
        if (this.lDH.containsKey(str)) {
            return this.lDH.get(str);
        }
        ai a2 = a(this.lDD, str);
        this.lDH.put(str, a2);
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
