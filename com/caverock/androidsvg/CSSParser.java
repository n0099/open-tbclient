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
/* loaded from: classes12.dex */
public class CSSParser {
    private MediaType lEG;
    private boolean lEH = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public static class a {
        public AttribOp lEJ;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lEJ = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class f {
        public Combinator lEP;
        public List<a> lEQ = null;
        public List<String> lER = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lEP = null;
            this.tag = null;
            this.lEP = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lEQ == null) {
                this.lEQ = new ArrayList();
            }
            this.lEQ.add(new a(str, attribOp, str2));
        }

        public void NO(String str) {
            if (this.lER == null) {
                this.lER = new ArrayList();
            }
            this.lER.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lEP == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lEP == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lEQ != null) {
                for (a aVar : this.lEQ) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lEJ) {
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
            if (this.lER != null) {
                for (String str : this.lER) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class d {
        private List<c> lEM = null;

        public void a(c cVar) {
            if (this.lEM == null) {
                this.lEM = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lEM.size()) {
                    if (this.lEM.get(i2).lEK.lEO <= cVar.lEK.lEO) {
                        i = i2 + 1;
                    } else {
                        this.lEM.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lEM.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lEM != null) {
                if (this.lEM == null) {
                    this.lEM = new ArrayList(dVar.lEM.size());
                }
                for (c cVar : dVar.lEM) {
                    this.lEM.add(cVar);
                }
            }
        }

        public List<c> diJ() {
            return this.lEM;
        }

        public boolean isEmpty() {
            return this.lEM == null || this.lEM.isEmpty();
        }

        public String toString() {
            if (this.lEM == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lEM) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class c {
        public e lEK;
        public SVG.Style lEL;

        public c(e eVar, SVG.Style style) {
            this.lEK = null;
            this.lEL = null;
            this.lEK = eVar;
            this.lEL = style;
        }

        public String toString() {
            return this.lEK + " {}";
        }
    }

    /* loaded from: classes12.dex */
    public static class e {
        public List<f> lEN = null;
        public int lEO = 0;

        public void a(f fVar) {
            if (this.lEN == null) {
                this.lEN = new ArrayList();
            }
            this.lEN.add(fVar);
        }

        public int size() {
            if (this.lEN == null) {
                return 0;
            }
            return this.lEN.size();
        }

        public f Hm(int i) {
            return this.lEN.get(i);
        }

        public boolean isEmpty() {
            if (this.lEN == null) {
                return true;
            }
            return this.lEN.isEmpty();
        }

        public void diK() {
            this.lEO += 10000;
        }

        public void diL() {
            this.lEO += 100;
        }

        public void diM() {
            this.lEO++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lEN) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lEO).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lEG = null;
        this.lEG = mediaType;
    }

    public d NM(String str) throws SAXException {
        b bVar = new b(str);
        bVar.skipWhitespace();
        return c(bVar);
    }

    public static boolean a(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.skipWhitespace();
        List<MediaType> a2 = a(bVar);
        if (!bVar.djC()) {
            throw new SAXException("Invalid @media type list");
        }
        return a(a2, mediaType);
    }

    private static void j(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b extends SVGParser.e {
        public b(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public String diF() {
            int diG = diG();
            if (diG == this.position) {
                return null;
            }
            String substring = this.lIh.substring(this.position, diG);
            this.position = diG;
            return substring;
        }

        private int diG() {
            if (djC()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lIh.charAt(this.position);
            if (charAt == 45) {
                charAt = djI();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int djI = djI();
                while (true) {
                    if ((djI < 65 || djI > 90) && ((djI < 97 || djI > 122) && !((djI >= 48 && djI <= 57) || djI == 45 || djI == 95))) {
                        break;
                    }
                    djI = djI();
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
            if (djC()) {
                return false;
            }
            int i = this.position;
            if (!eVar.isEmpty()) {
                if (g('>')) {
                    combinator = Combinator.CHILD;
                    skipWhitespace();
                } else if (g('+')) {
                    combinator = Combinator.FOLLOWS;
                    skipWhitespace();
                }
                if (!g('*')) {
                    fVar = new f(combinator, null);
                } else {
                    String diF = diF();
                    if (diF != null) {
                        fVar = new f(combinator, diF);
                        eVar.diM();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!djC()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String diF2 = diF();
                            if (diF2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, diF2);
                            eVar.diL();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String diF3 = diF();
                                if (diF3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, diF3);
                                eVar.diK();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                skipWhitespace();
                                String diF4 = diF();
                                if (diF4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                skipWhitespace();
                                if (g('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (OC("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = OC("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    skipWhitespace();
                                    str = diH();
                                    if (str == null) {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                    skipWhitespace();
                                } else {
                                    str = null;
                                }
                                if (!g(']')) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                fVar.a(diF4, attribOp, str);
                                eVar.diL();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (diF() != null) {
                                    if (g('(')) {
                                        skipWhitespace();
                                        if (diF() != null) {
                                            skipWhitespace();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NO(this.lIh.substring(i2, this.position));
                                    eVar.diL();
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
                if (!djC()) {
                }
            }
        }

        private String diH() {
            if (djC()) {
                return null;
            }
            String djN = djN();
            return djN == null ? diF() : djN;
        }

        public String diI() {
            if (djC()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lIh.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !Hp(charAt)) {
                if (!Ho(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = djI();
            }
            if (this.position > i) {
                return this.lIh.substring(i, i3);
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
        while (!bVar.djC()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.djD()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String diF = bVar.diF();
        bVar.skipWhitespace();
        if (diF == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lEH && diF.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.skipWhitespace();
            if (a(a2, this.lEG)) {
                this.lEH = true;
                dVar.a(c(bVar));
                this.lEH = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", diF);
            b(bVar);
        }
        bVar.skipWhitespace();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.djC()) {
            int intValue = bVar.djF().intValue();
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
        while (!bVar.djC()) {
            if (!bVar.OC("<!--") && !bVar.OC("-->")) {
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
        bVar.skipWhitespace();
        SVG.Style e2 = e(bVar);
        bVar.skipWhitespace();
        for (e eVar : d2) {
            dVar.a(new c(eVar, e2));
        }
        return true;
    }

    private List<e> d(b bVar) throws SAXException {
        if (bVar.djC()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.djC() && bVar.a(eVar)) {
            if (bVar.djD()) {
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
            String diF = bVar.diF();
            bVar.skipWhitespace();
            if (!bVar.g(':')) {
                break;
            }
            bVar.skipWhitespace();
            String diI = bVar.diI();
            if (diI == null) {
                break;
            }
            bVar.skipWhitespace();
            if (bVar.g('!')) {
                bVar.skipWhitespace();
                if (!bVar.OC("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                bVar.skipWhitespace();
            }
            bVar.g(';');
            SVGParser.a(style, diF, diI);
            bVar.skipWhitespace();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.djC());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NN(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.djC()) {
            String diF = bVar.diF();
            if (diF == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(diF);
            bVar.skipWhitespace();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lHd; agVar != null; agVar = ((SVG.ak) agVar).lHd) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hm(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hm = eVar.Hm(i);
        if (a(Hm, list, i2, aiVar)) {
            if (Hm.lEP == Combinator.DESCENDANT) {
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
            } else if (Hm.lEP == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lHd.getChildren().get(a2 - 1));
                }
                return false;
            }
        }
        return false;
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2) {
        f Hm = eVar.Hm(i);
        SVG.ai aiVar = (SVG.ai) list.get(i2);
        if (a(Hm, list, i2, aiVar)) {
            if (Hm.lEP == Combinator.DESCENDANT) {
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
            } else if (Hm.lEP == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lHd.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lHd) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lHd.getChildren().iterator();
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
        if (fVar.lEQ != null) {
            for (a aVar : fVar.lEQ) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lHb != null && aiVar.lHb.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lER != null) {
            for (String str : fVar.lER) {
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
