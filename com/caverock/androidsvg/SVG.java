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
    private ac lFh = null;
    private String title = "";
    private String desc = "";
    private com.caverock.androidsvg.d lFi = null;
    private float lFj = 96.0f;
    private CSSParser.d lFk = new CSSParser.d();
    Map<String, ai> lFl = new HashMap();

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
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;
        public String version;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ad {
        void NR(String str);

        Set<String> dja();

        String djb();

        Set<String> djc();

        Set<String> djd();

        Set<String> dje();

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
        public n lFL;
        public n lFM;
        public n lFN;
        public n lFO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class an extends i {
        public n lFt;
        public n lFu;
        public n lFv;
        public n lHf;
        public n lHg;
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
        ay djf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface ay {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ba extends k {
        public String Tv;
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class bb extends ao implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class c extends j {
        public n lFt;
        public n lFu;
        public n lFv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class d extends k implements r {
        public Boolean lFw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class g extends k implements r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class h extends j {
        public n lFA;
        public n lFB;
        public n lFt;
        public n lFu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface l {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class o extends j {
        public n lFL;
        public n lFM;
        public n lFN;
        public n lFO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class p extends ao implements r {
        public boolean lFP;
        public n lFQ;
        public n lFR;
        public n lFS;
        public n lFT;
        public Float lFU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class q extends ae implements r {
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;
        public Boolean lFV;
        public Boolean lFW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public interface r {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class t extends j {
        public u lFY;
        public Float lFZ;
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
        public String Tv;
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;
        public Boolean lGe;
        public Boolean lGf;
        public Matrix lGg;
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
        public n lFA;
        public n lFB;
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;
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

    public Picture diQ() {
        float bg;
        n nVar = this.lFh.lFI;
        if (nVar != null) {
            float bg2 = nVar.bg(this.lFj);
            a aVar = this.lFh.lHh;
            if (aVar != null) {
                bg = (aVar.height * bg2) / aVar.width;
            } else {
                n nVar2 = this.lFh.lFJ;
                bg = nVar2 != null ? nVar2.bg(this.lFj) : bg2;
            }
            return ds((int) Math.ceil(bg2), (int) Math.ceil(bg));
        }
        return ds(512, 512);
    }

    public Picture ds(int i2, int i3) {
        Picture picture = new Picture();
        new com.caverock.androidsvg.c(picture.beginRecording(i2, i3), new a(0.0f, 0.0f, i2, i3), this.lFj).a(this, (a) null, (PreserveAspectRatio) null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac diR() {
        return this.lFh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ac acVar) {
        this.lFh = acVar;
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
        this.lFk.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.c> diS() {
        return this.lFk.diJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean diT() {
        return !this.lFk.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class a implements Cloneable {
        public float height;
        public float lFn;
        public float lFo;
        public float width;

        public a(float f, float f2, float f3, float f4) {
            this.lFn = f;
            this.lFo = f2;
            this.width = f3;
            this.height = f4;
        }

        public static a k(float f, float f2, float f3, float f4) {
            return new a(f, f2, f3 - f, f4 - f2);
        }

        public float diV() {
            return this.lFn + this.width;
        }

        public float diW() {
            return this.lFo + this.height;
        }

        public void a(a aVar) {
            if (aVar.lFn < this.lFn) {
                this.lFn = aVar.lFn;
            }
            if (aVar.lFo < this.lFo) {
                this.lFo = aVar.lFo;
            }
            if (aVar.diV() > diV()) {
                this.width = aVar.diV() - this.lFn;
            }
            if (aVar.diW() > diW()) {
                this.height = aVar.diW() - this.lFo;
            }
        }

        public String toString() {
            return "[" + this.lFn + HanziToPinyin.Token.SEPARATOR + this.lFo + HanziToPinyin.Token.SEPARATOR + this.width + HanziToPinyin.Token.SEPARATOR + this.height + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class Style implements Cloneable {
        public String clipPath;
        public TextDecoration lGA;
        public TextDirection lGB;
        public TextAnchor lGC;
        public Boolean lGD;
        public b lGE;
        public String lGF;
        public String lGG;
        public String lGH;
        public Boolean lGI;
        public Boolean lGJ;
        public al lGK;
        public Float lGL;
        public FillRule lGM;
        public String lGN;
        public al lGO;
        public Float lGP;
        public al lGQ;
        public Float lGR;
        public VectorEffect lGS;
        public long lGi = 0;
        public al lGj;
        public FillRule lGk;
        public Float lGl;
        public al lGm;
        public Float lGn;
        public n lGo;
        public LineCaps lGp;
        public LineJoin lGq;
        public Float lGr;
        public n[] lGs;
        public n lGt;
        public Float lGu;
        public e lGv;
        public List<String> lGw;
        public n lGx;
        public Integer lGy;
        public FontStyle lGz;

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

        public static Style diZ() {
            Style style = new Style();
            style.lGi = -1L;
            style.lGj = e.lFy;
            style.lGk = FillRule.NonZero;
            style.lGl = Float.valueOf(1.0f);
            style.lGm = null;
            style.lGn = Float.valueOf(1.0f);
            style.lGo = new n(1.0f);
            style.lGp = LineCaps.Butt;
            style.lGq = LineJoin.Miter;
            style.lGr = Float.valueOf(4.0f);
            style.lGs = null;
            style.lGt = new n(0.0f);
            style.lGu = Float.valueOf(1.0f);
            style.lGv = e.lFy;
            style.lGw = null;
            style.lGx = new n(12.0f, Unit.pt);
            style.lGy = 400;
            style.lGz = FontStyle.Normal;
            style.lGA = TextDecoration.None;
            style.lGB = TextDirection.LTR;
            style.lGC = TextAnchor.Start;
            style.lGD = true;
            style.lGE = null;
            style.lGF = null;
            style.lGG = null;
            style.lGH = null;
            style.lGI = Boolean.TRUE;
            style.lGJ = Boolean.TRUE;
            style.lGK = e.lFy;
            style.lGL = Float.valueOf(1.0f);
            style.clipPath = null;
            style.lGM = FillRule.NonZero;
            style.lGN = null;
            style.lGO = null;
            style.lGP = Float.valueOf(1.0f);
            style.lGQ = null;
            style.lGR = Float.valueOf(1.0f);
            style.lGS = VectorEffect.None;
            return style;
        }

        public void vf(boolean z) {
            this.lGI = Boolean.TRUE;
            this.lGD = z ? Boolean.TRUE : Boolean.FALSE;
            this.lGE = null;
            this.clipPath = null;
            this.lGu = Float.valueOf(1.0f);
            this.lGK = e.lFy;
            this.lGL = Float.valueOf(1.0f);
            this.lGN = null;
            this.lGO = null;
            this.lGP = Float.valueOf(1.0f);
            this.lGQ = null;
            this.lGR = Float.valueOf(1.0f);
            this.lGS = VectorEffect.None;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                if (this.lGs != null) {
                    style.lGs = (n[]) this.lGs.clone();
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
        public static final e lFy = new e(0);
        public int lFx;

        public e(int i) {
            this.lFx = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.lFx));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class f extends al {
        private static f lFz = new f();

        private f() {
        }

        public static f diX() {
            return lFz;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class s extends al {
        public String Tv;
        public al lFX;

        public s(String str, al alVar) {
            this.Tv = str;
            this.lFX = alVar;
        }

        public String toString() {
            return this.Tv + HanziToPinyin.Token.SEPARATOR + this.lFX;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class n implements Cloneable {
        Unit lFK;
        float value;

        public n(float f, Unit unit) {
            this.value = 0.0f;
            this.lFK = Unit.px;
            this.value = f;
            this.lFK = unit;
        }

        public n(float f) {
            this.value = 0.0f;
            this.lFK = Unit.px;
            this.value = f;
            this.lFK = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float a(com.caverock.androidsvg.c cVar) {
            switch (this.lFK) {
                case px:
                    return this.value;
                case em:
                    return this.value * cVar.djh();
                case ex:
                    return this.value * cVar.dji();
                case in:
                    return this.value * cVar.djg();
                case cm:
                    return (this.value * cVar.djg()) / 2.54f;
                case mm:
                    return (this.value * cVar.djg()) / 25.4f;
                case pt:
                    return (this.value * cVar.djg()) / 72.0f;
                case pc:
                    return (this.value * cVar.djg()) / 6.0f;
                case percent:
                    a djj = cVar.djj();
                    return djj == null ? this.value : (djj.width * this.value) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float b(com.caverock.androidsvg.c cVar) {
            if (this.lFK == Unit.percent) {
                a djj = cVar.djj();
                if (djj == null) {
                    return this.value;
                }
                return (djj.height * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float c(com.caverock.androidsvg.c cVar) {
            if (this.lFK == Unit.percent) {
                a djj = cVar.djj();
                if (djj == null) {
                    return this.value;
                }
                float f = djj.width;
                float f2 = djj.height;
                if (f == f2) {
                    return (this.value * f) / 100.0f;
                }
                return (((float) (Math.sqrt((f2 * f2) + (f * f)) / 1.414213562373095d)) * this.value) / 100.0f;
            }
            return a(cVar);
        }

        public float a(com.caverock.androidsvg.c cVar, float f) {
            return this.lFK == Unit.percent ? (this.value * f) / 100.0f : a(cVar);
        }

        public float bg(float f) {
            switch (this.lFK) {
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

        public boolean diY() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.lFK;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class b {
        public n lFp;
        public n lFq;
        public n lFr;
        public n lFs;

        public b(n nVar, n nVar2, n nVar3, n nVar4) {
            this.lFp = nVar;
            this.lFq = nVar2;
            this.lFr = nVar3;
            this.lFs = nVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ak {
        public SVG lHc;
        public ag lHd;

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
        public Boolean lGZ = null;
        public Style lHa = null;
        public Style lEL = null;
        public List<String> lHb = null;

        protected ai() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ah extends ai {
        public a lGY = null;

        protected ah() {
        }
    }

    /* loaded from: classes12.dex */
    protected static class af extends ah implements ad {
        public Set<String> lGT = null;
        public String lGU = null;
        public Set<String> lGV = null;
        public Set<String> lGW = null;
        public Set<String> lGX = null;

        protected af() {
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lGT = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dja() {
            return this.lGT;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lGU = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String djb() {
            return this.lGU;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lGV = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> djc() {
            return this.lGV;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lGW = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> djd() {
            return this.lGW;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lGX = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dje() {
            return this.lGX;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ae extends ah implements ad, ag {
        public List<ak> UM = new ArrayList();
        public Set<String> lGT = null;
        public String lGU = null;
        public Set<String> lGV = null;
        public Set<String> lGW = null;
        public Set<String> lGX = null;

        protected ae() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.UM;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            this.UM.add(akVar);
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void i(Set<String> set) {
            this.lGT = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dja() {
            return this.lGT;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void NR(String str) {
            this.lGU = str;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public String djb() {
            return this.lGU;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void j(Set<String> set) {
            this.lGV = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> djc() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void k(Set<String> set) {
            this.lGW = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> djd() {
            return this.lGW;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public void l(Set<String> set) {
            this.lGX = set;
        }

        @Override // com.caverock.androidsvg.SVG.ad
        public Set<String> dje() {
            return this.lGX;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class am extends ae {
        public PreserveAspectRatio lHe = null;

        protected am() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ao extends am {
        public a lHh;

        protected ao() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class k extends ae implements l {
        public Matrix lFF;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lFF = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static abstract class j extends af implements l {
        public Matrix lFF;

        protected j() {
        }

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lFF = matrix;
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
                this.UM.add(akVar);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ax extends av {
        public List<n> lHk;
        public List<n> lHl;
        public List<n> x;
        public List<n> y;

        protected ax() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class at extends ax implements ay, l {
        public Matrix lFF;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lFF = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class as extends ax implements au {
        private ay lHi;

        public void a(ay ayVar) {
            this.lHi = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay djf() {
            return this.lHi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class az extends ak implements au {
        private ay lHi;
        public String text;

        public az(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.ak
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay djf() {
            return this.lHi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ar extends av implements au {
        public String Tv;
        private ay lHi;

        public void a(ay ayVar) {
            this.lHi = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay djf() {
            return this.lHi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class aw extends av implements au {
        public String Tv;
        private ay lHi;
        public n lHj;

        public void a(ay ayVar) {
            this.lHi = ayVar;
        }

        @Override // com.caverock.androidsvg.SVG.au
        public ay djf() {
            return this.lHi;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class i extends ai implements ag {
        public String Tv;
        public List<ak> UM = new ArrayList();
        public Boolean lFC;
        public Matrix lFD;
        public GradientSpread lFE;

        protected i() {
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public List<ak> getChildren() {
            return this.UM;
        }

        @Override // com.caverock.androidsvg.SVG.ag
        public void a(ak akVar) throws SAXException {
            if (akVar instanceof ab) {
                this.UM.add(akVar);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + akVar + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class ab extends ai implements ag {
        public Float lGh;

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
        public String Tv;
        public Matrix lFF;
        public n lFG;
        public n lFH;
        public n lFI;
        public n lFJ;

        @Override // com.caverock.androidsvg.SVG.l
        public void setTransform(Matrix matrix) {
            this.lFF = matrix;
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
    public com.caverock.androidsvg.d diU() {
        return this.lFi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class u implements v {
        private byte[] lGa;
        private float[] lGc;
        private int lGb = 0;
        private int lGd = 0;

        public u() {
            this.lGa = null;
            this.lGc = null;
            this.lGa = new byte[8];
            this.lGc = new float[16];
        }

        public boolean isEmpty() {
            return this.lGb == 0;
        }

        private void d(byte b) {
            if (this.lGb == this.lGa.length) {
                byte[] bArr = new byte[this.lGa.length * 2];
                System.arraycopy(this.lGa, 0, bArr, 0, this.lGa.length);
                this.lGa = bArr;
            }
            byte[] bArr2 = this.lGa;
            int i = this.lGb;
            this.lGb = i + 1;
            bArr2[i] = b;
        }

        private void Hn(int i) {
            if (this.lGc.length < this.lGd + i) {
                float[] fArr = new float[this.lGc.length * 2];
                System.arraycopy(this.lGc, 0, fArr, 0, this.lGc.length);
                this.lGc = fArr;
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void moveTo(float f, float f2) {
            d((byte) 0);
            Hn(2);
            float[] fArr = this.lGc;
            int i = this.lGd;
            this.lGd = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lGc;
            int i2 = this.lGd;
            this.lGd = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void B(float f, float f2) {
            d((byte) 1);
            Hn(2);
            float[] fArr = this.lGc;
            int i = this.lGd;
            this.lGd = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lGc;
            int i2 = this.lGd;
            this.lGd = i2 + 1;
            fArr2[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f, float f2, float f3, float f4, float f5, float f6) {
            d((byte) 2);
            Hn(6);
            float[] fArr = this.lGc;
            int i = this.lGd;
            this.lGd = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lGc;
            int i2 = this.lGd;
            this.lGd = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lGc;
            int i3 = this.lGd;
            this.lGd = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lGc;
            int i4 = this.lGd;
            this.lGd = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lGc;
            int i5 = this.lGd;
            this.lGd = i5 + 1;
            fArr5[i5] = f5;
            float[] fArr6 = this.lGc;
            int i6 = this.lGd;
            this.lGd = i6 + 1;
            fArr6[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void l(float f, float f2, float f3, float f4) {
            d((byte) 3);
            Hn(4);
            float[] fArr = this.lGc;
            int i = this.lGd;
            this.lGd = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lGc;
            int i2 = this.lGd;
            this.lGd = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lGc;
            int i3 = this.lGd;
            this.lGd = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lGc;
            int i4 = this.lGd;
            this.lGd = i4 + 1;
            fArr4[i4] = f4;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            d((byte) ((z2 ? 1 : 0) | (z ? 2 : 0) | 4));
            Hn(5);
            float[] fArr = this.lGc;
            int i = this.lGd;
            this.lGd = i + 1;
            fArr[i] = f;
            float[] fArr2 = this.lGc;
            int i2 = this.lGd;
            this.lGd = i2 + 1;
            fArr2[i2] = f2;
            float[] fArr3 = this.lGc;
            int i3 = this.lGd;
            this.lGd = i3 + 1;
            fArr3[i3] = f3;
            float[] fArr4 = this.lGc;
            int i4 = this.lGd;
            this.lGd = i4 + 1;
            fArr4[i4] = f4;
            float[] fArr5 = this.lGc;
            int i5 = this.lGd;
            this.lGd = i5 + 1;
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
            while (i2 < this.lGb) {
                byte b = this.lGa[i2];
                switch (b) {
                    case 0:
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        vVar.moveTo(this.lGc[i3], this.lGc[i4]);
                        break;
                    case 1:
                        int i5 = i3 + 1;
                        i = i5 + 1;
                        vVar.B(this.lGc[i3], this.lGc[i5]);
                        break;
                    case 2:
                        int i6 = i3 + 1;
                        int i7 = i6 + 1;
                        int i8 = i7 + 1;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        vVar.b(this.lGc[i3], this.lGc[i6], this.lGc[i7], this.lGc[i8], this.lGc[i9], this.lGc[i10]);
                        i = i10 + 1;
                        break;
                    case 3:
                        int i11 = i3 + 1;
                        int i12 = i11 + 1;
                        int i13 = i12 + 1;
                        i = i13 + 1;
                        vVar.l(this.lGc[i3], this.lGc[i11], this.lGc[i12], this.lGc[i13]);
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
                        vVar.a(this.lGc[i3], this.lGc[i14], this.lGc[i15], (b & 2) != 0, (b & 1) != 0, this.lGc[i16], this.lGc[i17]);
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
        if (str.equals(this.lFh.id)) {
            return this.lFh;
        }
        if (this.lFl.containsKey(str)) {
            return this.lFl.get(str);
        }
        ai a2 = a(this.lFh, str);
        this.lFl.put(str, a2);
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
