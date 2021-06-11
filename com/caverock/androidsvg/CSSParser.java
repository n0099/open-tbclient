package com.caverock.androidsvg;

import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidubce.services.vod.VodClient;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import org.xml.sax.SAXException;
/* loaded from: classes6.dex */
public class CSSParser {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f30417a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30418b = false;

    /* loaded from: classes6.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* loaded from: classes6.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30420a;

        static {
            int[] iArr = new int[AttribOp.values().length];
            f30420a = iArr;
            try {
                iArr[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30420a[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30420a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30421a;

        /* renamed from: b  reason: collision with root package name */
        public AttribOp f30422b;

        /* renamed from: c  reason: collision with root package name */
        public String f30423c;

        public b(String str, AttribOp attribOp, String str2) {
            this.f30421a = null;
            this.f30423c = null;
            this.f30421a = str;
            this.f30422b = attribOp;
            this.f30423c = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends SVGParser.f {
        public c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        /* JADX WARN: Code restructure failed: missing block: B:85:0x0154, code lost:
            if (r4 == null) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0156, code lost:
            r11.a(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0159, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x015a, code lost:
            r10.f30506b = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015c, code lost:
            return false;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0154 A[EDGE_INSN: B:90:0x0154->B:85:0x0154 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean A(f fVar) throws SAXException {
            Combinator combinator;
            g gVar;
            AttribOp attribOp;
            String str;
            if (g()) {
                return false;
            }
            int i2 = this.f30506b;
            if (!fVar.f()) {
                if (e(Typography.greater)) {
                    combinator = Combinator.CHILD;
                    w();
                } else if (e('+')) {
                    combinator = Combinator.FOLLOWS;
                    w();
                }
                if (!e('*')) {
                    gVar = new g(combinator, null);
                } else {
                    String y = y();
                    if (y != null) {
                        g gVar2 = new g(combinator, y);
                        fVar.c();
                        gVar = gVar2;
                    } else {
                        gVar = null;
                    }
                }
                while (true) {
                    if (!g()) {
                        if (e(IStringUtil.EXTENSION_SEPARATOR)) {
                            if (gVar == null) {
                                gVar = new g(combinator, null);
                            }
                            String y2 = y();
                            if (y2 != null) {
                                gVar.a(DealIntentService.KEY_CLASS, AttribOp.EQUALS, y2);
                                fVar.b();
                            } else {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                        } else {
                            if (e('#')) {
                                if (gVar == null) {
                                    gVar = new g(combinator, null);
                                }
                                String y3 = y();
                                if (y3 != null) {
                                    gVar.a("id", AttribOp.EQUALS, y3);
                                    fVar.d();
                                } else {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                            }
                            if (gVar == null) {
                                break;
                            } else if (e('[')) {
                                w();
                                String y4 = y();
                                if (y4 != null) {
                                    w();
                                    if (e(com.alipay.sdk.encrypt.a.f1886h)) {
                                        attribOp = AttribOp.EQUALS;
                                    } else if (f("~=")) {
                                        attribOp = AttribOp.INCLUDES;
                                    } else {
                                        attribOp = f("|=") ? AttribOp.DASHMATCH : null;
                                    }
                                    if (attribOp != null) {
                                        w();
                                        str = x();
                                        if (str != null) {
                                            w();
                                        } else {
                                            throw new SAXException("Invalid attribute selector in <style> element");
                                        }
                                    } else {
                                        str = null;
                                    }
                                    if (e(']')) {
                                        if (attribOp == null) {
                                            attribOp = AttribOp.EXISTS;
                                        }
                                        gVar.a(y4, attribOp, str);
                                        fVar.b();
                                    } else {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                } else {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                            } else if (e(':')) {
                                int i3 = this.f30506b;
                                if (y() != null) {
                                    if (e('(')) {
                                        w();
                                        if (y() != null) {
                                            w();
                                            if (!e(')')) {
                                                this.f30506b = i3 - 1;
                                            }
                                        }
                                    }
                                    gVar.b(this.f30505a.substring(i3, this.f30506b));
                                    fVar.b();
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            combinator = null;
            if (!e('*')) {
            }
            while (true) {
                if (!g()) {
                }
            }
        }

        public final int B() {
            int i2;
            if (g()) {
                return this.f30506b;
            }
            int i3 = this.f30506b;
            int charAt = this.f30505a.charAt(i3);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i2 = i3;
            } else {
                int a2 = a();
                while (true) {
                    if ((a2 < 65 || a2 > 90) && ((a2 < 97 || a2 > 122) && !((a2 >= 48 && a2 <= 57) || a2 == 45 || a2 == 95))) {
                        break;
                    }
                    a2 = a();
                }
                i2 = this.f30506b;
            }
            this.f30506b = i3;
            return i2;
        }

        public final String x() {
            if (g()) {
                return null;
            }
            String p = p();
            return p != null ? p : y();
        }

        public String y() {
            int B = B();
            int i2 = this.f30506b;
            if (B == i2) {
                return null;
            }
            String substring = this.f30505a.substring(i2, B);
            this.f30506b = B;
            return substring;
        }

        public String z() {
            if (g()) {
                return null;
            }
            int i2 = this.f30506b;
            int charAt = this.f30505a.charAt(i2);
            int i3 = i2;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !i(charAt)) {
                if (!j(charAt)) {
                    i3 = this.f30506b + 1;
                }
                charAt = a();
            }
            if (this.f30506b > i2) {
                return this.f30505a.substring(i2, i3);
            }
            this.f30506b = i2;
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public f f30424a;

        /* renamed from: b  reason: collision with root package name */
        public SVG.Style f30425b;

        public d(f fVar, SVG.Style style) {
            this.f30424a = null;
            this.f30425b = null;
            this.f30424a = fVar;
            this.f30425b = style;
        }

        public String toString() {
            return this.f30424a + " {}";
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public List<d> f30426a = null;

        public void a(d dVar) {
            if (this.f30426a == null) {
                this.f30426a = new ArrayList();
            }
            for (int i2 = 0; i2 < this.f30426a.size(); i2++) {
                if (this.f30426a.get(i2).f30424a.f30428b > dVar.f30424a.f30428b) {
                    this.f30426a.add(i2, dVar);
                    return;
                }
            }
            this.f30426a.add(dVar);
        }

        public void b(e eVar) {
            if (eVar.f30426a == null) {
                return;
            }
            if (this.f30426a == null) {
                this.f30426a = new ArrayList(eVar.f30426a.size());
            }
            for (d dVar : eVar.f30426a) {
                this.f30426a.add(dVar);
            }
        }

        public List<d> c() {
            return this.f30426a;
        }

        public boolean d() {
            List<d> list = this.f30426a;
            return list == null || list.isEmpty();
        }

        public String toString() {
            if (this.f30426a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (d dVar : this.f30426a) {
                sb.append(dVar.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public List<g> f30427a = null;

        /* renamed from: b  reason: collision with root package name */
        public int f30428b = 0;

        public void a(g gVar) {
            if (this.f30427a == null) {
                this.f30427a = new ArrayList();
            }
            this.f30427a.add(gVar);
        }

        public void b() {
            this.f30428b += 100;
        }

        public void c() {
            this.f30428b++;
        }

        public void d() {
            this.f30428b += 10000;
        }

        public g e(int i2) {
            return this.f30427a.get(i2);
        }

        public boolean f() {
            List<g> list = this.f30427a;
            if (list == null) {
                return true;
            }
            return list.isEmpty();
        }

        public int g() {
            List<g> list = this.f30427a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (g gVar : this.f30427a) {
                sb.append(gVar);
                sb.append(' ');
            }
            sb.append('(');
            sb.append(this.f30428b);
            sb.append(')');
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Combinator f30429a;

        /* renamed from: b  reason: collision with root package name */
        public String f30430b;

        /* renamed from: c  reason: collision with root package name */
        public List<b> f30431c = null;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f30432d = null;

        public g(Combinator combinator, String str) {
            this.f30429a = null;
            this.f30430b = null;
            this.f30429a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.f30430b = str;
        }

        public void a(String str, AttribOp attribOp, String str2) {
            if (this.f30431c == null) {
                this.f30431c = new ArrayList();
            }
            this.f30431c.add(new b(str, attribOp, str2));
        }

        public void b(String str) {
            if (this.f30432d == null) {
                this.f30432d = new ArrayList();
            }
            this.f30432d.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.f30429a;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.f30430b;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<b> list = this.f30431c;
            if (list != null) {
                for (b bVar : list) {
                    sb.append('[');
                    sb.append(bVar.f30421a);
                    int i2 = a.f30420a[bVar.f30422b.ordinal()];
                    if (i2 == 1) {
                        sb.append(com.alipay.sdk.encrypt.a.f1886h);
                        sb.append(bVar.f30423c);
                    } else if (i2 == 2) {
                        sb.append("~=");
                        sb.append(bVar.f30423c);
                    } else if (i2 == 3) {
                        sb.append("|=");
                        sb.append(bVar.f30423c);
                    }
                    sb.append(']');
                }
            }
            List<String> list2 = this.f30432d;
            if (list2 != null) {
                for (String str2 : list2) {
                    sb.append(':');
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.f30417a = null;
        this.f30417a = mediaType;
    }

    public static int a(List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        if (i2 < 0) {
            return -1;
        }
        SVG.h0 h0Var = list.get(i2);
        SVG.h0 h0Var2 = j0Var.f30473b;
        if (h0Var != h0Var2) {
            return -1;
        }
        int i3 = 0;
        for (SVG.l0 l0Var : h0Var2.getChildren()) {
            if (l0Var == j0Var) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static boolean b(String str, MediaType mediaType) throws SAXException {
        c cVar = new c(str);
        cVar.w();
        List<MediaType> h2 = h(cVar);
        if (cVar.g()) {
            return c(h2, mediaType);
        }
        throw new SAXException("Invalid @media type list");
    }

    public static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all) {
                return true;
            }
            if (mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    public static List<String> f(String str) throws SAXException {
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.g()) {
            String y = cVar.y();
            if (y != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(y);
                cVar.w();
            } else {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
        }
        return arrayList;
    }

    public static List<MediaType> h(c cVar) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!cVar.g()) {
            try {
                arrayList.add(MediaType.valueOf(cVar.r(',')));
                if (!cVar.v()) {
                    break;
                }
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    public static boolean l(f fVar, int i2, List<SVG.h0> list, int i3, SVG.j0 j0Var) {
        g e2 = fVar.e(i2);
        if (o(e2, list, i3, j0Var)) {
            Combinator combinator = e2.f30429a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 >= 0) {
                    if (n(fVar, i2 - 1, list, i3)) {
                        return true;
                    }
                    i3--;
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return n(fVar, i2 - 1, list, i3);
            } else {
                int a2 = a(list, i3, j0Var);
                if (a2 <= 0) {
                    return false;
                }
                return l(fVar, i2 - 1, list, i3, (SVG.j0) j0Var.f30473b.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    public static boolean m(f fVar, SVG.j0 j0Var) {
        ArrayList arrayList = new ArrayList();
        for (SVG.h0 h0Var = j0Var.f30473b; h0Var != null; h0Var = ((SVG.l0) h0Var).f30473b) {
            arrayList.add(0, h0Var);
        }
        int size = arrayList.size() - 1;
        if (fVar.g() == 1) {
            return o(fVar.e(0), arrayList, size, j0Var);
        }
        return l(fVar, fVar.g() - 1, arrayList, size, j0Var);
    }

    public static boolean n(f fVar, int i2, List<SVG.h0> list, int i3) {
        g e2 = fVar.e(i2);
        SVG.j0 j0Var = (SVG.j0) list.get(i3);
        if (o(e2, list, i3, j0Var)) {
            Combinator combinator = e2.f30429a;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 > 0) {
                    i3--;
                    if (n(fVar, i2 - 1, list, i3)) {
                        return true;
                    }
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return n(fVar, i2 - 1, list, i3 - 1);
            } else {
                int a2 = a(list, i3, j0Var);
                if (a2 <= 0) {
                    return false;
                }
                return l(fVar, i2 - 1, list, i3, (SVG.j0) j0Var.f30473b.getChildren().get(a2 - 1));
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(g gVar, List<SVG.h0> list, int i2, SVG.j0 j0Var) {
        List<String> list2;
        String str = gVar.f30430b;
        if (str != null) {
            if (str.equalsIgnoreCase("G")) {
                if (!(j0Var instanceof SVG.l)) {
                    return false;
                }
            } else if (!gVar.f30430b.equals(j0Var.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        List<b> list3 = gVar.f30431c;
        if (list3 != null) {
            for (b bVar : list3) {
                String str2 = bVar.f30421a;
                if (str2 == "id") {
                    if (!bVar.f30423c.equals(j0Var.f30467c)) {
                        return false;
                    }
                } else if (str2 != DealIntentService.KEY_CLASS || (list2 = j0Var.f30471g) == null || !list2.contains(bVar.f30423c)) {
                    return false;
                }
            }
        }
        List<String> list4 = gVar.f30432d;
        if (list4 != null) {
            for (String str3 : list4) {
                if (!str3.equals("first-child") || a(list, i2, j0Var) != 0) {
                    return false;
                }
                while (r5.hasNext()) {
                }
            }
            return true;
        }
        return true;
    }

    public static void q(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    public e d(String str) throws SAXException {
        c cVar = new c(str);
        cVar.w();
        return j(cVar);
    }

    public final void e(e eVar, c cVar) throws SAXException {
        String y = cVar.y();
        cVar.w();
        if (y != null) {
            if (!this.f30418b && y.equals(VodClient.PATH_MEDIA)) {
                List<MediaType> h2 = h(cVar);
                if (cVar.e('{')) {
                    cVar.w();
                    if (c(h2, this.f30417a)) {
                        this.f30418b = true;
                        eVar.b(j(cVar));
                        this.f30418b = false;
                    } else {
                        j(cVar);
                    }
                    if (!cVar.e('}')) {
                        throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new SAXException("Invalid @media rule: missing rule set");
                }
            } else {
                q("Ignoring @%s rule", y);
                p(cVar);
            }
            cVar.w();
            return;
        }
        throw new SAXException("Invalid '@' rule in <style> element");
    }

    public final SVG.Style g(c cVar) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String y = cVar.y();
            cVar.w();
            if (!cVar.e(':')) {
                break;
            }
            cVar.w();
            String z = cVar.z();
            if (z == null) {
                break;
            }
            cVar.w();
            if (cVar.e('!')) {
                cVar.w();
                if (cVar.f("important")) {
                    cVar.w();
                } else {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
            }
            cVar.e(';');
            SVGParser.B0(style, y, z);
            cVar.w();
            if (cVar.e('}')) {
                return style;
            }
        } while (!cVar.g());
        throw new SAXException("Malformed rule set in <style> element");
    }

    public final boolean i(e eVar, c cVar) throws SAXException {
        List<f> k = k(cVar);
        if (k == null || k.isEmpty()) {
            return false;
        }
        if (cVar.e('{')) {
            cVar.w();
            SVG.Style g2 = g(cVar);
            cVar.w();
            for (f fVar : k) {
                eVar.a(new d(fVar, g2));
            }
            return true;
        }
        throw new SAXException("Malformed rule block in <style> element: missing '{'");
    }

    public final e j(c cVar) throws SAXException {
        e eVar = new e();
        while (!cVar.g()) {
            if (!cVar.f("<!--") && !cVar.f("-->")) {
                if (cVar.e('@')) {
                    e(eVar, cVar);
                } else if (!i(eVar, cVar)) {
                    break;
                }
            }
        }
        return eVar;
    }

    public final List<f> k(c cVar) throws SAXException {
        if (cVar.g()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        f fVar = new f();
        while (!cVar.g() && cVar.A(fVar)) {
            if (cVar.v()) {
                arrayList.add(fVar);
                fVar = new f();
            }
        }
        if (!fVar.f()) {
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public final void p(c cVar) {
        int i2 = 0;
        while (!cVar.g()) {
            int intValue = cVar.k().intValue();
            if (intValue == 59 && i2 == 0) {
                return;
            }
            if (intValue == 123) {
                i2++;
            } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                return;
            }
        }
    }
}
