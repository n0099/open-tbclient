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
    private MediaType lDc;
    private boolean lDd = false;

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
        public AttribOp lDf;
        public String name;
        public String value;

        public a(String str, AttribOp attribOp, String str2) {
            this.name = null;
            this.value = null;
            this.name = str;
            this.lDf = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class f {
        public Combinator lDl;
        public List<a> lDm = null;
        public List<String> lDn = null;
        public String tag;

        public f(Combinator combinator, String str) {
            this.lDl = null;
            this.tag = null;
            this.lDl = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.lDm == null) {
                this.lDm = new ArrayList();
            }
            this.lDm.add(new a(str, attribOp, str2));
        }

        public void NP(String str) {
            if (this.lDn == null) {
                this.lDn = new ArrayList();
            }
            this.lDn.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.lDl == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.lDl == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.lDm != null) {
                for (a aVar : this.lDm) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.lDf) {
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
            if (this.lDn != null) {
                for (String str : this.lDn) {
                    sb.append(':').append(str);
                }
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class d {
        private List<c> lDi = null;

        public void a(c cVar) {
            if (this.lDi == null) {
                this.lDi = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lDi.size()) {
                    if (this.lDi.get(i2).lDg.lDk <= cVar.lDg.lDk) {
                        i = i2 + 1;
                    } else {
                        this.lDi.add(i2, cVar);
                        return;
                    }
                } else {
                    this.lDi.add(cVar);
                    return;
                }
            }
        }

        public void a(d dVar) {
            if (dVar.lDi != null) {
                if (this.lDi == null) {
                    this.lDi = new ArrayList(dVar.lDi.size());
                }
                for (c cVar : dVar.lDi) {
                    this.lDi.add(cVar);
                }
            }
        }

        public List<c> dim() {
            return this.lDi;
        }

        public boolean isEmpty() {
            return this.lDi == null || this.lDi.isEmpty();
        }

        public String toString() {
            if (this.lDi == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (c cVar : this.lDi) {
                sb.append(cVar.toString()).append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes12.dex */
    public static class c {
        public e lDg;
        public SVG.Style lDh;

        public c(e eVar, SVG.Style style) {
            this.lDg = null;
            this.lDh = null;
            this.lDg = eVar;
            this.lDh = style;
        }

        public String toString() {
            return this.lDg + " {}";
        }
    }

    /* loaded from: classes12.dex */
    public static class e {
        public List<f> lDj = null;
        public int lDk = 0;

        public void a(f fVar) {
            if (this.lDj == null) {
                this.lDj = new ArrayList();
            }
            this.lDj.add(fVar);
        }

        public int size() {
            if (this.lDj == null) {
                return 0;
            }
            return this.lDj.size();
        }

        public f Hg(int i) {
            return this.lDj.get(i);
        }

        public boolean isEmpty() {
            if (this.lDj == null) {
                return true;
            }
            return this.lDj.isEmpty();
        }

        public void din() {
            this.lDk += 10000;
        }

        public void dio() {
            this.lDk += 100;
        }

        public void dip() {
            this.lDk++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (f fVar : this.lDj) {
                sb.append(fVar).append(' ');
            }
            return sb.append('(').append(this.lDk).append(')').toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.lDc = null;
        this.lDc = mediaType;
    }

    public d NN(String str) throws SAXException {
        b bVar = new b(str);
        bVar.skipWhitespace();
        return c(bVar);
    }

    public static boolean a(String str, MediaType mediaType) throws SAXException {
        b bVar = new b(str);
        bVar.skipWhitespace();
        List<MediaType> a2 = a(bVar);
        if (!bVar.djf()) {
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

        public String dii() {
            int dij = dij();
            if (dij == this.position) {
                return null;
            }
            String substring = this.lGB.substring(this.position, dij);
            this.position = dij;
            return substring;
        }

        private int dij() {
            if (djf()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.lGB.charAt(this.position);
            if (charAt == 45) {
                charAt = djl();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int djl = djl();
                while (true) {
                    if ((djl < 65 || djl > 90) && ((djl < 97 || djl > 122) && !((djl >= 48 && djl <= 57) || djl == 45 || djl == 95))) {
                        break;
                    }
                    djl = djl();
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
            if (djf()) {
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
                    String dii = dii();
                    if (dii != null) {
                        fVar = new f(combinator, dii);
                        eVar.dip();
                    } else {
                        fVar = null;
                    }
                }
                while (true) {
                    if (!djf()) {
                        if (g('.')) {
                            if (fVar == null) {
                                fVar = new f(combinator, null);
                            }
                            String dii2 = dii();
                            if (dii2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            fVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, dii2);
                            eVar.dio();
                        } else {
                            if (g('#')) {
                                if (fVar == null) {
                                    fVar = new f(combinator, null);
                                }
                                String dii3 = dii();
                                if (dii3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                fVar.a("id", AttribOp.EQUALS, dii3);
                                eVar.din();
                            }
                            if (fVar == null) {
                                break;
                            } else if (g('[')) {
                                skipWhitespace();
                                String dii4 = dii();
                                if (dii4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                skipWhitespace();
                                if (g('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (OD("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = OD("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    skipWhitespace();
                                    str = dik();
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
                                fVar.a(dii4, attribOp, str);
                                eVar.dio();
                            } else if (g(':')) {
                                int i2 = this.position;
                                if (dii() != null) {
                                    if (g('(')) {
                                        skipWhitespace();
                                        if (dii() != null) {
                                            skipWhitespace();
                                            if (!g(')')) {
                                                this.position = i2 - 1;
                                            }
                                        }
                                    }
                                    fVar.NP(this.lGB.substring(i2, this.position));
                                    eVar.dio();
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
                if (!djf()) {
                }
            }
        }

        private String dik() {
            if (djf()) {
                return null;
            }
            String djq = djq();
            return djq == null ? dii() : djq;
        }

        public String dil() {
            if (djf()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int i3 = i2;
            int charAt = this.lGB.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !Hj(charAt)) {
                if (!Hi(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = djl();
            }
            if (this.position > i) {
                return this.lGB.substring(i, i3);
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
        while (!bVar.djf()) {
            try {
                arrayList.add(MediaType.valueOf(bVar.h(',')));
                if (!bVar.djg()) {
                    break;
                }
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void a(d dVar, b bVar) throws SAXException {
        String dii = bVar.dii();
        bVar.skipWhitespace();
        if (dii == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.lDd && dii.equals("media")) {
            List<MediaType> a2 = a(bVar);
            if (!bVar.g('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            bVar.skipWhitespace();
            if (a(a2, this.lDc)) {
                this.lDd = true;
                dVar.a(c(bVar));
                this.lDd = false;
            } else {
                c(bVar);
            }
            if (!bVar.g('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            j("Ignoring @%s rule", dii);
            b(bVar);
        }
        bVar.skipWhitespace();
    }

    private void b(b bVar) {
        int i = 0;
        while (!bVar.djf()) {
            int intValue = bVar.dji().intValue();
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
        while (!bVar.djf()) {
            if (!bVar.OD("<!--") && !bVar.OD("-->")) {
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
        if (bVar.djf()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e();
        while (!bVar.djf() && bVar.a(eVar)) {
            if (bVar.djg()) {
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
            String dii = bVar.dii();
            bVar.skipWhitespace();
            if (!bVar.g(':')) {
                break;
            }
            bVar.skipWhitespace();
            String dil = bVar.dil();
            if (dil == null) {
                break;
            }
            bVar.skipWhitespace();
            if (bVar.g('!')) {
                bVar.skipWhitespace();
                if (!bVar.OD("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                bVar.skipWhitespace();
            }
            bVar.g(';');
            SVGParser.a(style, dii, dil);
            bVar.skipWhitespace();
            if (bVar.g('}')) {
                return style;
            }
        } while (!bVar.djf());
        throw new SAXException("Malformed rule set in <style> element");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<String> NO(String str) throws SAXException {
        b bVar = new b(str);
        ArrayList arrayList = null;
        while (!bVar.djf()) {
            String dii = bVar.dii();
            if (dii == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dii);
            bVar.skipWhitespace();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(e eVar, SVG.ai aiVar) {
        ArrayList arrayList = new ArrayList();
        for (SVG.ag agVar = aiVar.lFz; agVar != null; agVar = ((SVG.ak) agVar).lFz) {
            arrayList.add(0, agVar);
        }
        int size = arrayList.size() - 1;
        return eVar.size() == 1 ? a(eVar.Hg(0), arrayList, size, aiVar) : a(eVar, eVar.size() - 1, arrayList, size, aiVar);
    }

    private static boolean a(e eVar, int i, List<SVG.ag> list, int i2, SVG.ai aiVar) {
        f Hg = eVar.Hg(i);
        if (a(Hg, list, i2, aiVar)) {
            if (Hg.lDl == Combinator.DESCENDANT) {
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
            } else if (Hg.lDl == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 > 0) {
                    return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFz.getChildren().get(a2 - 1));
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
            if (Hg.lDl == Combinator.DESCENDANT) {
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
            } else if (Hg.lDl == Combinator.CHILD) {
                return a(eVar, i - 1, list, i2 - 1);
            } else {
                int a2 = a(list, i2, aiVar);
                if (a2 <= 0) {
                    return false;
                }
                return a(eVar, i - 1, list, i2, (SVG.ai) aiVar.lFz.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    private static int a(List<SVG.ag> list, int i, SVG.ai aiVar) {
        if (i >= 0 && list.get(i) == aiVar.lFz) {
            int i2 = 0;
            Iterator<SVG.ak> it = aiVar.lFz.getChildren().iterator();
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
        if (fVar.lDm != null) {
            for (a aVar : fVar.lDm) {
                if (aVar.name == "id") {
                    if (!aVar.value.equals(aiVar.id)) {
                        return false;
                    }
                } else {
                    if (aVar.name == DealIntentService.KEY_CLASS && aiVar.lFx != null && aiVar.lFx.contains(aVar.value)) {
                    }
                    return false;
                }
            }
        }
        if (fVar.lDn != null) {
            for (String str : fVar.lDn) {
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
