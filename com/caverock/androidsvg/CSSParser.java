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
    private MediaType lCi;
    private boolean lCj = false;

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
        public AttribOp lCl;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lCl = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class f {
        public Combinator lCr;
        public List<a> lCs = null;
        public List<String> lCt = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lCr = null;
            this.tag = null;
            this.lCr = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lCs == null) {
                this.lCs = new ArrayList();
            }
            this.lCs.add(new a(str, attribOp, str2));
        }

        public void NC(String str) {
            if (this.lCt == null) {
                this.lCt = new ArrayList();
            }
            this.lCt.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lCr == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lCr == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lCs != null) {
                for (a aVar : this.lCs) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lCl) {
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
            if (this.lCt != null) {
                for (String str : this.lCt) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        private List<c> lCo = null;

        public void a(c cVar) {
            if (this.lCo == null) {
                this.lCo = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lCo.size()) {
                    if (this.lCo.get(i2).lCm.lCq <= cVar.lCm.lCq) {
                        i = i2 + 1;
                    } else {
                        this.lCo.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lCo.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lCo != null) {
                if (this.lCo == null) {
                    this.lCo = new ArrayList(dVar.lCo.size());
                }
                for (c cVar : dVar.lCo) {
                    this.lCo.add(cVar);
                }
            }
        }

        public List<c> dgV() {
            return this.lCo;
        }

        public boolean isEmpty() {
            return this.lCo == null || this.lCo.isEmpty();
        }

        public String toString() {
            if (this.lCo == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lCo) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public e lCm;
        public SVG.Style lCn;

        public c(e eVar, SVG.Style style) {
            this.lCm = null;
            this.lCn = null;
            this.lCm = eVar;
            this.lCn = style;
        }

        public String toString() {
            return this.lCm + " {}";
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public List<f> lCp = null;
        public int lCq = 0;

        public void a(f fVar) {
            if (this.lCp == null) {
                this.lCp = new ArrayList();
            }
            this.lCp.add(fVar);
        }

        public int size() {
            if (this.lCp == null) {
                return 0;
            }
            return this.lCp.size();
        }

        public f Hb(int i) {
            return this.lCp.get(i);
        }

        public boolean isEmpty() {
            if (this.lCp == null) {
                return true;
            }
            return this.lCp.isEmpty();
        }

        public void dgW() {
            this.lCq += 10000;
        }

        public void dgX() {
            this.lCq += 100;
        }

        public void dgY() {
            this.lCq++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lCp) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lCq).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lCi = null;
        this.lCi = mediaType;
    }

    public d NA(String str) throws SAXException {
        b bVar = new b(str);
        bVar.dhP();
        return c(bVar);
    }

    public static boolean a(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.dhP();
        List<MediaType> a2 = a(bVar);
        if (!bVar.dhO()) {
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

        public String dgR() {
            int dgS = dgS();
            if (dgS == this.position) {
                return null;
            }
            String substring = this.lFH.substring(this.position, dgS);
            this.position = dgS;
            return substring;
        }

        private int dgS() {
            if (dhO()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lFH.charAt(this.position);
            if (charAt == 45) {
                charAt = dhV();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int dhV = dhV();
                while (true) {
                    if ((dhV < 65 || dhV > 90) && ((dhV < 97 || dhV > 122) && !((dhV >= 48 && dhV <= 57) || dhV == 45 || dhV == 95))) {
                        break;
                    }
                    dhV = dhV();
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
            if (dhO()) {
                return false;
            }
            int i = this.position;
            if (!eVar.isEmpty()) {
                if (g('>')) {
                    combinator = Combinator.CHILD;
                    dhP();
                } else if (g('+')) {
                    combinator = Combinator.FOLLOWS;
                    dhP();
                }
                if (!g('*')) {
                    fVar = new f(combinator, null);
                } else {
                    String dgR = dgR();
                    if (dgR != null) {
                        fVar = new f(combinator, dgR);
                        eVar.dgY();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!dhO()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dgR2 = dgR();
                            if (dgR2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dgR2);
                            eVar.dgX();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dgR3 = dgR();
                                if (dgR3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dgR3);
                                eVar.dgW();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                dhP();
                                String dgR4 = dgR();
                                if (dgR4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                dhP();
                                if (g('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (Oq("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = Oq("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    dhP();
                                    str = dgT();
                                    if (str == null) {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                    dhP();
                                } else {
                                    str = null;
                                }
                                if (!g(']')) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                fVar.a(dgR4, attribOp, str);
                                eVar.dgX();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dgR() != null) {
                                    if (g('(')) {
                                        dhP();
                                        if (dgR() != null) {
                                            dhP();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NC(this.lFH.substring(i2, this.position));
                                    eVar.dgX();
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
                if (!dhO()) {
                }
            }
        }

        private String dgT() {
            if (dhO()) {
                return null;
            }
            String dia = dia();
            return dia == null ? dgR() : dia;
        }

        public String dgU() {
            if (dhO()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lFH.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !He(charAt)) {
                if (!Hd(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = dhV();
            }
            if (this.position > i) {
                return this.lFH.substring(i, i3);
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
        while (!bVar.dhO()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.dhQ()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dgR = bVar.dgR();
        bVar.dhP();
        if (dgR == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lCj && dgR.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.dhP();
            if (a(a2, this.lCi)) {
                this.lCj = true;
                dVar.a(c(bVar));
                this.lCj = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dgR);
            b(bVar);
        }
        bVar.dhP();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.dhO()) {
            int intValue = bVar.dhS().intValue();
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
        while (!bVar.dhO()) {
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
        bVar.dhP();
        SVG.Style e2 = e(bVar);
        bVar.dhP();
        for (e eVar : d2) {
            dVar.a(new c(eVar, e2));
        }
        return true;
    }

    private List<e> d(b bVar) throws SAXException {
        if (bVar.dhO()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.dhO() && bVar.a(eVar)) {
            if (bVar.dhQ()) {
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
            String dgR = bVar.dgR();
            bVar.dhP();
            if (!bVar.g(':')) {
                break;
            }
            bVar.dhP();
            String dgU = bVar.dgU();
            if (dgU == null) {
                break;
            }
            bVar.dhP();
            if (bVar.g('!')) {
                bVar.dhP();
                if (!bVar.Oq("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                bVar.dhP();
            }
            bVar.g(';');
            SVGParser.a(style, dgR, dgU);
            bVar.dhP();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.dhO());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NB(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.dhO()) {
            String dgR = bVar.dgR();
            if (dgR == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dgR);
            bVar.dhP();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lEF; agVar != null; agVar = ((SVG.ak) agVar).lEF) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hb(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hb = eVar.Hb(i);
        if (a(Hb, list, i2, aiVar)) {
            if (Hb.lCr == Combinator.DESCENDANT) {
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
            } else if (Hb.lCr == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lEF.getChildren().get(a2 - 1));
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
            if (Hb.lCr == Combinator.DESCENDANT) {
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
            } else if (Hb.lCr == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lEF.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lEF) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lEF.getChildren().iterator();
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
        if (fVar.lCs != null) {
            for (a aVar : fVar.lCs) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lED != null && aiVar.lED.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lCt != null) {
            for (String str : fVar.lCt) {
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
