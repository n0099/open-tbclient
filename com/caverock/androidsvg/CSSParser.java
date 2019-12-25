package com.caverock.androidsvg;

import android.util.Log;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.xml.sax.SAXException;
/* loaded from: classes9.dex */
public class CSSParser {
    private MediaType lyF;
    private boolean lyG = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* loaded from: classes9.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        tty,
        tv
    }

    /* loaded from: classes9.dex */
    public static class a {
        public AttribOp lyI;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lyI = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class f {
        public Combinator lyO;
        public List<a> lyP = null;
        public List<String> lyQ = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lyO = null;
            this.tag = null;
            this.lyO = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lyP == null) {
                this.lyP = new ArrayList();
            }
            this.lyP.add(new a(str, attribOp, str2));
        }

        public void Ns(String str) {
            if (this.lyQ == null) {
                this.lyQ = new ArrayList();
            }
            this.lyQ.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lyO == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lyO == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lyP != null) {
                for (a aVar : this.lyP) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lyI) {
                        case EQUALS:
                            sb.append('=').append(aVar.value);
                            break;
                        case INCLUDES:
                            sb.append("~=").append(aVar.value);
                            break;
                        case DASHMATCH:
                            sb.append("|=").append(aVar.value);
                            break;
                    }
                    sb.append(']');
                }
            }
            if (this.lyQ != null) {
                for (String str : this.lyQ) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        private List<c> lyL = null;

        public void a(c cVar) {
            if (this.lyL == null) {
                this.lyL = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lyL.size()) {
                    if (this.lyL.get(i2).lyJ.lyN <= cVar.lyJ.lyN) {
                        i = i2 + 1;
                    } else {
                        this.lyL.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lyL.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lyL != null) {
                if (this.lyL == null) {
                    this.lyL = new ArrayList(dVar.lyL.size());
                }
                for (c cVar : dVar.lyL) {
                    this.lyL.add(cVar);
                }
            }
        }

        public List<c> dfR() {
            return this.lyL;
        }

        public boolean isEmpty() {
            return this.lyL == null || this.lyL.isEmpty();
        }

        public String toString() {
            if (this.lyL == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lyL) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public e lyJ;
        public SVG.Style lyK;

        public c(e eVar, SVG.Style style) {
            this.lyJ = null;
            this.lyK = null;
            this.lyJ = eVar;
            this.lyK = style;
        }

        public String toString() {
            return this.lyJ + " {}";
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public List<f> lyM = null;
        public int lyN = 0;

        public void a(f fVar) {
            if (this.lyM == null) {
                this.lyM = new ArrayList();
            }
            this.lyM.add(fVar);
        }

        public int size() {
            if (this.lyM == null) {
                return 0;
            }
            return this.lyM.size();
        }

        public f GW(int i) {
            return this.lyM.get(i);
        }

        public boolean isEmpty() {
            if (this.lyM == null) {
                return true;
            }
            return this.lyM.isEmpty();
        }

        public void dfS() {
            this.lyN += 10000;
        }

        public void dfT() {
            this.lyN += 100;
        }

        public void dfU() {
            this.lyN++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lyM) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lyN).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lyF = null;
        this.lyF = mediaType;
    }

    public d Nq(String str) throws SAXException {
        b bVar = new b(str);
        bVar.dgL();
        return c(bVar);
    }

    public static boolean a(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.dgL();
        List<MediaType> a2 = a(bVar);
        if (!bVar.dgK()) {
            throw new SAXException("Invalid @media type list");
        }
        return a(a2, mediaType);
    }

    private static void j(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b extends SVGParser.e {
        public b(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public String dfN() {
            int dfO = dfO();
            if (dfO == this.position) {
                return null;
            }
            String substring = this.lCe.substring(this.position, dfO);
            this.position = dfO;
            return substring;
        }

        private int dfO() {
            if (dgK()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lCe.charAt(this.position);
            if (charAt == 45) {
                charAt = dgS();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int dgS = dgS();
                while (true) {
                    if ((dgS < 65 || dgS > 90) && ((dgS < 97 || dgS > 122) && !((dgS >= 48 && dgS <= 57) || dgS == 45 || dgS == 95))) {
                        break;
                    }
                    dgS = dgS();
                }
                i2 = this.position;
            }
            this.position = i;
            return i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
            if (r2 == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
            r10.a(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0161, code lost:
            r9.position = r6;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x00a4 A[EDGE_INSN: B:88:0x00a4->B:41:0x00a4 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(e eVar) throws SAXException {
            Combinator combinator;
            f fVar;
            AttribOp attribOp;
            String str;
            if (dgK()) {
                return false;
            }
            int i = this.position;
            if (!eVar.isEmpty()) {
                if (g('>')) {
                    combinator = Combinator.CHILD;
                    dgL();
                } else if (g('+')) {
                    combinator = Combinator.FOLLOWS;
                    dgL();
                }
                if (!g('*')) {
                    fVar = new f(combinator, null);
                } else {
                    String dfN = dfN();
                    if (dfN != null) {
                        fVar = new f(combinator, dfN);
                        eVar.dfU();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!dgK()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dfN2 = dfN();
                            if (dfN2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dfN2);
                            eVar.dfT();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dfN3 = dfN();
                                if (dfN3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dfN3);
                                eVar.dfS();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                dgL();
                                String dfN4 = dfN();
                                if (dfN4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                dgL();
                                if (g('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (Og("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = Og("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    dgL();
                                    str = dfP();
                                    if (str == null) {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                    dgL();
                                } else {
                                    str = null;
                                }
                                if (!g(']')) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                fVar.a(dfN4, attribOp, str);
                                eVar.dfT();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dfN() != null) {
                                    if (g('(')) {
                                        dgL();
                                        if (dfN() != null) {
                                            dgL();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.Ns(this.lCe.substring(i2, this.position));
                                    eVar.dfT();
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            combinator = null;
            if (!g('*')) {
            }
            while (true) {
                if (!dgK()) {
                }
            }
        }

        private String dfP() {
            if (dgK()) {
                return null;
            }
            String dgX = dgX();
            return dgX == null ? dfN() : dgX;
        }

        public String dfQ() {
            if (dgK()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lCe.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !GZ(charAt)) {
                if (!GY(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = dgS();
            }
            if (this.position > i) {
                return this.lCe.substring(i, i3);
            }
            this.position = i;
            return null;
        }
    }

    private static boolean a(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 != MediaType.all) {
                if (mediaType2 == mediaType) {
                }
            }
            return true;
        }
        return false;
    }

    private static List<MediaType> a(b bVar) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!bVar.dgK()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.dgM()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dfN = bVar.dfN();
        bVar.dgL();
        if (dfN == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lyG && dfN.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.dgL();
            if (a(a2, this.lyF)) {
                this.lyG = true;
                dVar.a(c(bVar));
                this.lyG = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dfN);
            b(bVar);
        }
        bVar.dgL();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.dgK()) {
            int intValue = bVar.dgP().intValue();
            if (intValue != 59 || i != 0) {
                if (intValue == 123) {
                    i++;
                } else if (intValue == 125 && i > 0 && i - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private d c(b bVar) throws SAXException {
        d dVar = new d();
        while (!bVar.dgK()) {
            if (!bVar.Og("<!--") && !bVar.Og("-->")) {
                if (bVar.g('@')) {
                    a(dVar, bVar);
                } else if (!b(dVar, bVar)) {
                    break;
                }
            }
        }
        return dVar;
    }

    private boolean b(d dVar, b bVar) throws SAXException {
        List<e> d2 = d(bVar);
        if (d2 == null || d2.isEmpty()) {
            return false;
        }
        if (!bVar.g('{')) {
            throw new SAXException("Malformed rule block in <style> element: missing '{'");
        }
        bVar.dgL();
        SVG.Style e2 = e(bVar);
        bVar.dgL();
        for (e eVar : d2) {
            dVar.a(new c(eVar, e2));
        }
        return true;
    }

    private List<e> d(b bVar) throws SAXException {
        if (bVar.dgK()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.dgK() && bVar.a(eVar)) {
            if (bVar.dgM()) {
                arrayList.add(eVar);
                eVar = new e();
            }
        }
        if (!eVar.isEmpty()) {
            arrayList.add(eVar);
        }
        return arrayList;
    }

    private SVG.Style e(b bVar) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String dfN = bVar.dfN();
            bVar.dgL();
            if (!bVar.g(':')) {
                break;
            }
            bVar.dgL();
            String dfQ = bVar.dfQ();
            if (dfQ == null) {
                break;
            }
            bVar.dgL();
            if (bVar.g('!')) {
                bVar.dgL();
                if (!bVar.Og("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                bVar.dgL();
            }
            bVar.g(';');
            SVGParser.a(style, dfN, dfQ);
            bVar.dgL();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.dgK());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> Nr(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.dgK()) {
            String dfN = bVar.dfN();
            if (dfN == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dfN);
            bVar.dgL();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lBc; agVar != null; agVar = ((SVG.ak) agVar).lBc) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.GW(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f GW = eVar.GW(i);
        if (a(GW, list, i2, aiVar)) {
            if (GW.lyO == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 >= 0) {
                    if (a(eVar, i - 1, list, i2)) {
                        return true;
                    }
                    i2--;
                }
                return false;
            } else if (GW.lyO == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lBc.getChildren().get(a2 - 1));
                }
                return false;
            }
        }
        return false;
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2) {
        f GW = eVar.GW(i);
        SVG.ai aiVar = (SVG.ai) list.get(i2);
        if (a(GW, list, i2, aiVar)) {
            if (GW.lyO == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 > 0) {
                    i2--;
                    if (a(eVar, i - 1, list, i2)) {
                        return true;
                    }
                }
                return false;
            } else if (GW.lyO == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lBc.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lBc) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lBc.getChildren().iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    return -1;
                }
                if (it.next() != aiVar) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static boolean a(f fVar, List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (fVar.tag != null) {
            if (fVar.tag.equalsIgnoreCase("G")) {
                if (!(aiVar instanceof SVG.k)) {
                    return false;
                }
            } else if (!fVar.tag.equals(aiVar.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        if (fVar.lyP != null) {
            for (a aVar : fVar.lyP) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lBa != null && aiVar.lBa.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lyQ != null) {
            for (String str : fVar.lyQ) {
                if (!str.equals("first-child")) {
                    return false;
                }
                if (a(list, i, aiVar) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
