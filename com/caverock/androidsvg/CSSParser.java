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
    private MediaType lCR;
    private boolean lCS = false;

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
        public AttribOp lCU;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lCU = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class f {
        public Combinator lDa;
        public List<a> lDb = null;
        public List<String> lDc = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lDa = null;
            this.tag = null;
            this.lDa = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lDb == null) {
                this.lDb = new ArrayList();
            }
            this.lDb.add(new a(str, attribOp, str2));
        }

        public void NO(String str) {
            if (this.lDc == null) {
                this.lDc = new ArrayList();
            }
            this.lDc.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lDa == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lDa == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lDb != null) {
                for (a aVar : this.lDb) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lCU) {
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
            if (this.lDc != null) {
                for (String str : this.lDc) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class d {
        private List<c> lCX = null;

        public void a(c cVar) {
            if (this.lCX == null) {
                this.lCX = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lCX.size()) {
                    if (this.lCX.get(i2).lCV.lCZ <= cVar.lCV.lCZ) {
                        i = i2 + 1;
                    } else {
                        this.lCX.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lCX.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lCX != null) {
                if (this.lCX == null) {
                    this.lCX = new ArrayList(dVar.lCX.size());
                }
                for (c cVar : dVar.lCX) {
                    this.lCX.add(cVar);
                }
            }
        }

        public List<c> dil() {
            return this.lCX;
        }

        public boolean isEmpty() {
            return this.lCX == null || this.lCX.isEmpty();
        }

        public String toString() {
            if (this.lCX == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lCX) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class c {
        public e lCV;
        public SVG.Style lCW;

        public c(e eVar, SVG.Style style) {
            this.lCV = null;
            this.lCW = null;
            this.lCV = eVar;
            this.lCW = style;
        }

        public String toString() {
            return this.lCV + " {}";
        }
    }

    /* loaded from: classes12.dex */
    public static class e {
        public List<f> lCY = null;
        public int lCZ = 0;

        public void a(f fVar) {
            if (this.lCY == null) {
                this.lCY = new ArrayList();
            }
            this.lCY.add(fVar);
        }

        public int size() {
            if (this.lCY == null) {
                return 0;
            }
            return this.lCY.size();
        }

        public f Hg(int i) {
            return this.lCY.get(i);
        }

        public boolean isEmpty() {
            if (this.lCY == null) {
                return true;
            }
            return this.lCY.isEmpty();
        }

        public void dim() {
            this.lCZ += 10000;
        }

        public void din() {
            this.lCZ += 100;
        }

        public void dio() {
            this.lCZ++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lCY) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lCZ).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lCR = null;
        this.lCR = mediaType;
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
        if (!bVar.dje()) {
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

        public String dih() {
            int dii = dii();
            if (dii == this.position) {
                return null;
            }
            String substring = this.lGq.substring(this.position, dii);
            this.position = dii;
            return substring;
        }

        private int dii() {
            if (dje()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lGq.charAt(this.position);
            if (charAt == 45) {
                charAt = djk();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int djk = djk();
                while (true) {
                    if ((djk < 65 || djk > 90) && ((djk < 97 || djk > 122) && !((djk >= 48 && djk <= 57) || djk == 45 || djk == 95))) {
                        break;
                    }
                    djk = djk();
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
            if (dje()) {
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
                    String dih = dih();
                    if (dih != null) {
                        fVar = new f(combinator, dih);
                        eVar.dio();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!dje()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dih2 = dih();
                            if (dih2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dih2);
                            eVar.din();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dih3 = dih();
                                if (dih3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dih3);
                                eVar.dim();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                skipWhitespace();
                                String dih4 = dih();
                                if (dih4 == null) {
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
                                    str = dij();
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
                                fVar.a(dih4, attribOp, str);
                                eVar.din();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dih() != null) {
                                    if (g('(')) {
                                        skipWhitespace();
                                        if (dih() != null) {
                                            skipWhitespace();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NO(this.lGq.substring(i2, this.position));
                                    eVar.din();
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
                if (!dje()) {
                }
            }
        }

        private String dij() {
            if (dje()) {
                return null;
            }
            String djp = djp();
            return djp == null ? dih() : djp;
        }

        public String dik() {
            if (dje()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lGq.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !Hj(charAt)) {
                if (!Hi(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = djk();
            }
            if (this.position > i) {
                return this.lGq.substring(i, i3);
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
        while (!bVar.dje()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.djf()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dih = bVar.dih();
        bVar.skipWhitespace();
        if (dih == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lCS && dih.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.skipWhitespace();
            if (a(a2, this.lCR)) {
                this.lCS = true;
                dVar.a(c(bVar));
                this.lCS = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dih);
            b(bVar);
        }
        bVar.skipWhitespace();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.dje()) {
            int intValue = bVar.djh().intValue();
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
        while (!bVar.dje()) {
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
        if (bVar.dje()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.dje() && bVar.a(eVar)) {
            if (bVar.djf()) {
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
            String dih = bVar.dih();
            bVar.skipWhitespace();
            if (!bVar.g(':')) {
                break;
            }
            bVar.skipWhitespace();
            String dik = bVar.dik();
            if (dik == null) {
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
            SVGParser.a(style, dih, dik);
            bVar.skipWhitespace();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.dje());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NN(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.dje()) {
            String dih = bVar.dih();
            if (dih == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dih);
            bVar.skipWhitespace();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lFo; agVar != null; agVar = ((SVG.ak) agVar).lFo) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hg(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hg = eVar.Hg(i);
        if (a(Hg, list, i2, aiVar)) {
            if (Hg.lDa == Combinator.DESCENDANT) {
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
            } else if (Hg.lDa == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFo.getChildren().get(a2 - 1));
                }
                return false;
            }
        }
        return false;
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2) {
        f Hg = eVar.Hg(i);
        SVG.ai aiVar = (SVG.ai) list.get(i2);
        if (a(Hg, list, i2, aiVar)) {
            if (Hg.lDa == Combinator.DESCENDANT) {
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
            } else if (Hg.lDa == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFo.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lFo) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lFo.getChildren().iterator();
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
        if (fVar.lDb != null) {
            for (a aVar : fVar.lDb) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lFm != null && aiVar.lFm.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lDc != null) {
            for (String str : fVar.lDc) {
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
