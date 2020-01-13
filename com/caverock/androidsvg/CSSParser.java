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
/* loaded from: classes10.dex */
public class CSSParser {
    private MediaType lCd;
    private boolean lCe = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a {
        public AttribOp lCg;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lCg = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f {
        public Combinator lCm;
        public List<a> lCn = null;
        public List<String> lCo = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lCm = null;
            this.tag = null;
            this.lCm = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lCn == null) {
                this.lCn = new ArrayList();
            }
            this.lCn.add(new a(str, attribOp, str2));
        }

        public void NC(String str) {
            if (this.lCo == null) {
                this.lCo = new ArrayList();
            }
            this.lCo.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lCm == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lCm == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lCn != null) {
                for (a aVar : this.lCn) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lCg) {
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
            if (this.lCo != null) {
                for (String str : this.lCo) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        private List<c> lCj = null;

        public void a(c cVar) {
            if (this.lCj == null) {
                this.lCj = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lCj.size()) {
                    if (this.lCj.get(i2).lCh.lCl <= cVar.lCh.lCl) {
                        i = i2 + 1;
                    } else {
                        this.lCj.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lCj.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lCj != null) {
                if (this.lCj == null) {
                    this.lCj = new ArrayList(dVar.lCj.size());
                }
                for (c cVar : dVar.lCj) {
                    this.lCj.add(cVar);
                }
            }
        }

        public List<c> dgT() {
            return this.lCj;
        }

        public boolean isEmpty() {
            return this.lCj == null || this.lCj.isEmpty();
        }

        public String toString() {
            if (this.lCj == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lCj) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public e lCh;
        public SVG.Style lCi;

        public c(e eVar, SVG.Style style) {
            this.lCh = null;
            this.lCi = null;
            this.lCh = eVar;
            this.lCi = style;
        }

        public String toString() {
            return this.lCh + " {}";
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public List<f> lCk = null;
        public int lCl = 0;

        public void a(f fVar) {
            if (this.lCk == null) {
                this.lCk = new ArrayList();
            }
            this.lCk.add(fVar);
        }

        public int size() {
            if (this.lCk == null) {
                return 0;
            }
            return this.lCk.size();
        }

        public f Hb(int i) {
            return this.lCk.get(i);
        }

        public boolean isEmpty() {
            if (this.lCk == null) {
                return true;
            }
            return this.lCk.isEmpty();
        }

        public void dgU() {
            this.lCl += 10000;
        }

        public void dgV() {
            this.lCl += 100;
        }

        public void dgW() {
            this.lCl++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lCk) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lCl).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lCd = null;
        this.lCd = mediaType;
    }

    public d NA(String str) throws SAXException {
        b bVar = new b(str);
        bVar.dhN();
        return c(bVar);
    }

    public static boolean a(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.dhN();
        List<MediaType> a2 = a(bVar);
        if (!bVar.dhM()) {
            throw new SAXException("Invalid @media type list");
        }
        return a(a2, mediaType);
    }

    private static void j(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b extends SVGParser.e {
        public b(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public String dgP() {
            int dgQ = dgQ();
            if (dgQ == this.position) {
                return null;
            }
            String substring = this.lFC.substring(this.position, dgQ);
            this.position = dgQ;
            return substring;
        }

        private int dgQ() {
            if (dhM()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lFC.charAt(this.position);
            if (charAt == 45) {
                charAt = dhT();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int dhT = dhT();
                while (true) {
                    if ((dhT < 65 || dhT > 90) && ((dhT < 97 || dhT > 122) && !((dhT >= 48 && dhT <= 57) || dhT == 45 || dhT == 95))) {
                        break;
                    }
                    dhT = dhT();
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
            if (dhM()) {
                return false;
            }
            int i = this.position;
            if (!eVar.isEmpty()) {
                if (g('>')) {
                    combinator = Combinator.CHILD;
                    dhN();
                } else if (g('+')) {
                    combinator = Combinator.FOLLOWS;
                    dhN();
                }
                if (!g('*')) {
                    fVar = new f(combinator, null);
                } else {
                    String dgP = dgP();
                    if (dgP != null) {
                        fVar = new f(combinator, dgP);
                        eVar.dgW();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!dhM()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dgP2 = dgP();
                            if (dgP2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dgP2);
                            eVar.dgV();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dgP3 = dgP();
                                if (dgP3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dgP3);
                                eVar.dgU();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                dhN();
                                String dgP4 = dgP();
                                if (dgP4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                dhN();
                                if (g('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (Oq("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = Oq("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    dhN();
                                    str = dgR();
                                    if (str == null) {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                    dhN();
                                } else {
                                    str = null;
                                }
                                if (!g(']')) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                fVar.a(dgP4, attribOp, str);
                                eVar.dgV();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dgP() != null) {
                                    if (g('(')) {
                                        dhN();
                                        if (dgP() != null) {
                                            dhN();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NC(this.lFC.substring(i2, this.position));
                                    eVar.dgV();
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
                if (!dhM()) {
                }
            }
        }

        private String dgR() {
            if (dhM()) {
                return null;
            }
            String dhY = dhY();
            return dhY == null ? dgP() : dhY;
        }

        public String dgS() {
            if (dhM()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lFC.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !He(charAt)) {
                if (!Hd(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = dhT();
            }
            if (this.position > i) {
                return this.lFC.substring(i, i3);
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
        while (!bVar.dhM()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.dhO()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dgP = bVar.dgP();
        bVar.dhN();
        if (dgP == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lCe && dgP.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.dhN();
            if (a(a2, this.lCd)) {
                this.lCe = true;
                dVar.a(c(bVar));
                this.lCe = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dgP);
            b(bVar);
        }
        bVar.dhN();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.dhM()) {
            int intValue = bVar.dhQ().intValue();
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
        while (!bVar.dhM()) {
            if (!bVar.Oq("<!--") && !bVar.Oq("-->")) {
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
        bVar.dhN();
        SVG.Style e2 = e(bVar);
        bVar.dhN();
        for (e eVar : d2) {
            dVar.a(new c(eVar, e2));
        }
        return true;
    }

    private List<e> d(b bVar) throws SAXException {
        if (bVar.dhM()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.dhM() && bVar.a(eVar)) {
            if (bVar.dhO()) {
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
            String dgP = bVar.dgP();
            bVar.dhN();
            if (!bVar.g(':')) {
                break;
            }
            bVar.dhN();
            String dgS = bVar.dgS();
            if (dgS == null) {
                break;
            }
            bVar.dhN();
            if (bVar.g('!')) {
                bVar.dhN();
                if (!bVar.Oq("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                bVar.dhN();
            }
            bVar.g(';');
            SVGParser.a(style, dgP, dgS);
            bVar.dhN();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.dhM());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NB(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.dhM()) {
            String dgP = bVar.dgP();
            if (dgP == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dgP);
            bVar.dhN();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lEA; agVar != null; agVar = ((SVG.ak) agVar).lEA) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hb(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hb = eVar.Hb(i);
        if (a(Hb, list, i2, aiVar)) {
            if (Hb.lCm == Combinator.DESCENDANT) {
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
            } else if (Hb.lCm == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lEA.getChildren().get(a2 - 1));
                }
                return false;
            }
        }
        return false;
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2) {
        f Hb = eVar.Hb(i);
        SVG.ai aiVar = (SVG.ai) list.get(i2);
        if (a(Hb, list, i2, aiVar)) {
            if (Hb.lCm == Combinator.DESCENDANT) {
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
            } else if (Hb.lCm == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lEA.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lEA) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lEA.getChildren().iterator();
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
        if (fVar.lCn != null) {
            for (a aVar : fVar.lCn) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lEy != null && aiVar.lEy.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lCo != null) {
            for (String str : fVar.lCo) {
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
