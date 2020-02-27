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
    private MediaType lCP;
    private boolean lCQ = false;

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
        public AttribOp lCS;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lCS = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class f {
        public Combinator lCY;
        public List<a> lCZ = null;
        public List<String> lDa = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lCY = null;
            this.tag = null;
            this.lCY = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lCZ == null) {
                this.lCZ = new ArrayList();
            }
            this.lCZ.add(new a(str, attribOp, str2));
        }

        public void NO(String str) {
            if (this.lDa == null) {
                this.lDa = new ArrayList();
            }
            this.lDa.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lCY == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lCY == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lCZ != null) {
                for (a aVar : this.lCZ) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lCS) {
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
            if (this.lDa != null) {
                for (String str : this.lDa) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class d {
        private List<c> lCV = null;

        public void a(c cVar) {
            if (this.lCV == null) {
                this.lCV = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lCV.size()) {
                    if (this.lCV.get(i2).lCT.lCX <= cVar.lCT.lCX) {
                        i = i2 + 1;
                    } else {
                        this.lCV.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lCV.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lCV != null) {
                if (this.lCV == null) {
                    this.lCV = new ArrayList(dVar.lCV.size());
                }
                for (c cVar : dVar.lCV) {
                    this.lCV.add(cVar);
                }
            }
        }

        public List<c> dij() {
            return this.lCV;
        }

        public boolean isEmpty() {
            return this.lCV == null || this.lCV.isEmpty();
        }

        public String toString() {
            if (this.lCV == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lCV) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class c {
        public e lCT;
        public SVG.Style lCU;

        public c(e eVar, SVG.Style style) {
            this.lCT = null;
            this.lCU = null;
            this.lCT = eVar;
            this.lCU = style;
        }

        public String toString() {
            return this.lCT + " {}";
        }
    }

    /* loaded from: classes12.dex */
    public static class e {
        public List<f> lCW = null;
        public int lCX = 0;

        public void a(f fVar) {
            if (this.lCW == null) {
                this.lCW = new ArrayList();
            }
            this.lCW.add(fVar);
        }

        public int size() {
            if (this.lCW == null) {
                return 0;
            }
            return this.lCW.size();
        }

        public f Hg(int i) {
            return this.lCW.get(i);
        }

        public boolean isEmpty() {
            if (this.lCW == null) {
                return true;
            }
            return this.lCW.isEmpty();
        }

        public void dik() {
            this.lCX += 10000;
        }

        public void dil() {
            this.lCX += 100;
        }

        public void dim() {
            this.lCX++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lCW) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lCX).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lCP = null;
        this.lCP = mediaType;
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
        if (!bVar.djc()) {
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

        public String dif() {
            int dig = dig();
            if (dig == this.position) {
                return null;
            }
            String substring = this.lGo.substring(this.position, dig);
            this.position = dig;
            return substring;
        }

        private int dig() {
            if (djc()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lGo.charAt(this.position);
            if (charAt == 45) {
                charAt = dji();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int dji = dji();
                while (true) {
                    if ((dji < 65 || dji > 90) && ((dji < 97 || dji > 122) && !((dji >= 48 && dji <= 57) || dji == 45 || dji == 95))) {
                        break;
                    }
                    dji = dji();
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
            if (djc()) {
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
                    String dif = dif();
                    if (dif != null) {
                        fVar = new f(combinator, dif);
                        eVar.dim();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!djc()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dif2 = dif();
                            if (dif2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dif2);
                            eVar.dil();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dif3 = dif();
                                if (dif3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dif3);
                                eVar.dik();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                skipWhitespace();
                                String dif4 = dif();
                                if (dif4 == null) {
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
                                    str = dih();
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
                                fVar.a(dif4, attribOp, str);
                                eVar.dil();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dif() != null) {
                                    if (g('(')) {
                                        skipWhitespace();
                                        if (dif() != null) {
                                            skipWhitespace();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NO(this.lGo.substring(i2, this.position));
                                    eVar.dil();
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
                if (!djc()) {
                }
            }
        }

        private String dih() {
            if (djc()) {
                return null;
            }
            String djn = djn();
            return djn == null ? dif() : djn;
        }

        public String dii() {
            if (djc()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lGo.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !Hj(charAt)) {
                if (!Hi(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = dji();
            }
            if (this.position > i) {
                return this.lGo.substring(i, i3);
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
        while (!bVar.djc()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.djd()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dif = bVar.dif();
        bVar.skipWhitespace();
        if (dif == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lCQ && dif.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.skipWhitespace();
            if (a(a2, this.lCP)) {
                this.lCQ = true;
                dVar.a(c(bVar));
                this.lCQ = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dif);
            b(bVar);
        }
        bVar.skipWhitespace();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.djc()) {
            int intValue = bVar.djf().intValue();
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
        while (!bVar.djc()) {
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
        if (bVar.djc()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.djc() && bVar.a(eVar)) {
            if (bVar.djd()) {
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
            String dif = bVar.dif();
            bVar.skipWhitespace();
            if (!bVar.g(':')) {
                break;
            }
            bVar.skipWhitespace();
            String dii = bVar.dii();
            if (dii == null) {
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
            SVGParser.a(style, dif, dii);
            bVar.skipWhitespace();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.djc());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NN(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.djc()) {
            String dif = bVar.dif();
            if (dif == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dif);
            bVar.skipWhitespace();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lFm; agVar != null; agVar = ((SVG.ak) agVar).lFm) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hg(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hg = eVar.Hg(i);
        if (a(Hg, list, i2, aiVar)) {
            if (Hg.lCY == Combinator.DESCENDANT) {
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
            } else if (Hg.lCY == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFm.getChildren().get(a2 - 1));
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
            if (Hg.lCY == Combinator.DESCENDANT) {
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
            } else if (Hg.lCY == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFm.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lFm) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lFm.getChildren().iterator();
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
        if (fVar.lCZ != null) {
            for (a aVar : fVar.lCZ) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lFk != null && aiVar.lFk.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lDa != null) {
            for (String str : fVar.lDa) {
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
