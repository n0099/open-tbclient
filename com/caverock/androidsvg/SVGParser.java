package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.utils.Constants;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes10.dex */
public class SVGParser extends DefaultHandler2 {
    private int lFp;
    private SVG lFm = null;
    private SVG.ag lFn = null;
    private boolean lFo = false;
    private boolean lFq = false;
    private SVGElem lFr = null;
    private StringBuilder lFs = null;
    private boolean lFt = false;
    private StringBuilder lFu = null;
    private Set<String> lFv = null;

    /* loaded from: classes10.dex */
    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        private static final Map<String, SVGElem> cache = new HashMap();

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            if (sVGElem == null) {
                if (str.equals("switch")) {
                    cache.put(str, SWITCH);
                    return SWITCH;
                }
                try {
                    SVGElem valueOf = valueOf(str);
                    if (valueOf != SWITCH) {
                        cache.put(str, valueOf);
                        return valueOf;
                    }
                } catch (IllegalArgumentException e) {
                }
                cache.put(str, UNSUPPORTED);
                return UNSUPPORTED;
            }
            return sVGElem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        id,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        private static final Map<String, SVGAttr> cache = new HashMap();

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            if (sVGAttr == null) {
                if (str.equals(DealIntentService.KEY_CLASS)) {
                    cache.put(str, CLASS);
                    return CLASS;
                } else if (str.indexOf(95) != -1) {
                    cache.put(str, UNSUPPORTED);
                    return UNSUPPORTED;
                } else {
                    try {
                        SVGAttr valueOf = valueOf(str.replace('-', '_'));
                        if (valueOf != CLASS) {
                            cache.put(str, valueOf);
                            return valueOf;
                        }
                    } catch (IllegalArgumentException e) {
                    }
                    cache.put(str, UNSUPPORTED);
                    return UNSUPPORTED;
                }
            }
            return sVGAttr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static final Map<String, Integer> lFz = new HashMap(47);

        static {
            lFz.put("aliceblue", 15792383);
            lFz.put("antiquewhite", 16444375);
            lFz.put("aqua", 65535);
            lFz.put("aquamarine", 8388564);
            lFz.put("azure", 15794175);
            lFz.put("beige", 16119260);
            lFz.put("bisque", 16770244);
            lFz.put("black", 0);
            lFz.put("blanchedalmond", 16772045);
            lFz.put("blue", 255);
            lFz.put("blueviolet", 9055202);
            lFz.put("brown", 10824234);
            lFz.put("burlywood", 14596231);
            lFz.put("cadetblue", 6266528);
            lFz.put("chartreuse", 8388352);
            lFz.put("chocolate", 13789470);
            lFz.put("coral", 16744272);
            lFz.put("cornflowerblue", 6591981);
            lFz.put("cornsilk", 16775388);
            lFz.put("crimson", 14423100);
            lFz.put("cyan", 65535);
            lFz.put("darkblue", 139);
            lFz.put("darkcyan", 35723);
            lFz.put("darkgoldenrod", 12092939);
            lFz.put("darkgray", 11119017);
            lFz.put("darkgreen", 25600);
            lFz.put("darkgrey", 11119017);
            lFz.put("darkkhaki", 12433259);
            lFz.put("darkmagenta", 9109643);
            lFz.put("darkolivegreen", 5597999);
            lFz.put("darkorange", 16747520);
            lFz.put("darkorchid", 10040012);
            lFz.put("darkred", 9109504);
            lFz.put("darksalmon", 15308410);
            lFz.put("darkseagreen", 9419919);
            lFz.put("darkslateblue", 4734347);
            lFz.put("darkslategray", 3100495);
            lFz.put("darkslategrey", 3100495);
            lFz.put("darkturquoise", 52945);
            lFz.put("darkviolet", 9699539);
            lFz.put("deeppink", 16716947);
            lFz.put("deepskyblue", 49151);
            lFz.put("dimgray", 6908265);
            lFz.put("dimgrey", 6908265);
            lFz.put("dodgerblue", 2003199);
            lFz.put("firebrick", 11674146);
            lFz.put("floralwhite", 16775920);
            lFz.put("forestgreen", 2263842);
            lFz.put("fuchsia", 16711935);
            lFz.put("gainsboro", 14474460);
            lFz.put("ghostwhite", 16316671);
            lFz.put("gold", 16766720);
            lFz.put("goldenrod", 14329120);
            lFz.put(com.baidu.fsg.face.base.b.c.m, 8421504);
            lFz.put("green", 32768);
            lFz.put("greenyellow", 11403055);
            lFz.put("grey", 8421504);
            lFz.put("honeydew", 15794160);
            lFz.put("hotpink", 16738740);
            lFz.put("indianred", 13458524);
            lFz.put("indigo", 4915330);
            lFz.put("ivory", 16777200);
            lFz.put("khaki", 15787660);
            lFz.put("lavender", 15132410);
            lFz.put("lavenderblush", 16773365);
            lFz.put("lawngreen", 8190976);
            lFz.put("lemonchiffon", 16775885);
            lFz.put("lightblue", 11393254);
            lFz.put("lightcoral", 15761536);
            lFz.put("lightcyan", 14745599);
            lFz.put("lightgoldenrodyellow", 16448210);
            lFz.put("lightgray", 13882323);
            lFz.put("lightgreen", 9498256);
            lFz.put("lightgrey", 13882323);
            lFz.put("lightpink", 16758465);
            lFz.put("lightsalmon", 16752762);
            lFz.put("lightseagreen", 2142890);
            lFz.put("lightskyblue", 8900346);
            lFz.put("lightslategray", 7833753);
            lFz.put("lightslategrey", 7833753);
            lFz.put("lightsteelblue", 11584734);
            lFz.put("lightyellow", 16777184);
            lFz.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            lFz.put("limegreen", 3329330);
            lFz.put("linen", 16445670);
            lFz.put("magenta", 16711935);
            lFz.put("maroon", 8388608);
            lFz.put("mediumaquamarine", 6737322);
            lFz.put("mediumblue", 205);
            lFz.put("mediumorchid", 12211667);
            lFz.put("mediumpurple", 9662683);
            lFz.put("mediumseagreen", 3978097);
            lFz.put("mediumslateblue", 8087790);
            lFz.put("mediumspringgreen", 64154);
            lFz.put("mediumturquoise", 4772300);
            lFz.put("mediumvioletred", 13047173);
            lFz.put("midnightblue", 1644912);
            lFz.put("mintcream", 16121850);
            lFz.put("mistyrose", 16770273);
            lFz.put("moccasin", 16770229);
            lFz.put("navajowhite", 16768685);
            lFz.put("navy", 128);
            lFz.put("oldlace", 16643558);
            lFz.put("olive", 8421376);
            lFz.put("olivedrab", 7048739);
            lFz.put("orange", 16753920);
            lFz.put("orangered", 16729344);
            lFz.put("orchid", 14315734);
            lFz.put("palegoldenrod", 15657130);
            lFz.put("palegreen", 10025880);
            lFz.put("paleturquoise", 11529966);
            lFz.put("palevioletred", 14381203);
            lFz.put("papayawhip", 16773077);
            lFz.put("peachpuff", 16767673);
            lFz.put("peru", 13468991);
            lFz.put("pink", 16761035);
            lFz.put("plum", 14524637);
            lFz.put("powderblue", 11591910);
            lFz.put("purple", 8388736);
            lFz.put("red", 16711680);
            lFz.put("rosybrown", 12357519);
            lFz.put("royalblue", 4286945);
            lFz.put("saddlebrown", 9127187);
            lFz.put("salmon", 16416882);
            lFz.put("sandybrown", 16032864);
            lFz.put("seagreen", 3050327);
            lFz.put("seashell", 16774638);
            lFz.put("sienna", 10506797);
            lFz.put("silver", 12632256);
            lFz.put("skyblue", 8900331);
            lFz.put("slateblue", 6970061);
            lFz.put("slategray", 7372944);
            lFz.put("slategrey", 7372944);
            lFz.put("snow", 16775930);
            lFz.put("springgreen", 65407);
            lFz.put("steelblue", 4620980);
            lFz.put("tan", 13808780);
            lFz.put("teal", 32896);
            lFz.put("thistle", 14204888);
            lFz.put("tomato", 16737095);
            lFz.put("turquoise", 4251856);
            lFz.put("violet", 15631086);
            lFz.put("wheat", 16113331);
            lFz.put("white", 16777215);
            lFz.put("whitesmoke", 16119285);
            lFz.put("yellow", 16776960);
            lFz.put("yellowgreen", 10145074);
        }

        public static Integer Oo(String str) {
            return lFz.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private static final Map<String, SVG.n> lFA = new HashMap(9);

        static {
            lFA.put("xx-small", new SVG.n(0.694f, SVG.Unit.pt));
            lFA.put("x-small", new SVG.n(0.833f, SVG.Unit.pt));
            lFA.put("small", new SVG.n(10.0f, SVG.Unit.pt));
            lFA.put("medium", new SVG.n(12.0f, SVG.Unit.pt));
            lFA.put("large", new SVG.n(14.4f, SVG.Unit.pt));
            lFA.put("x-large", new SVG.n(17.3f, SVG.Unit.pt));
            lFA.put("xx-large", new SVG.n(20.7f, SVG.Unit.pt));
            lFA.put("smaller", new SVG.n(83.33f, SVG.Unit.percent));
            lFA.put("larger", new SVG.n(120.0f, SVG.Unit.percent));
        }

        public static SVG.n Op(String str) {
            return lFA.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class d {
        private static final Map<String, Integer> lFB = new HashMap(13);

        static {
            lFB.put("normal", 400);
            lFB.put("bold", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lFB.put("bolder", 1);
            lFB.put("lighter", -1);
            lFB.put("100", 100);
            lFB.put(BasicPushStatus.SUCCESS_CODE, 200);
            lFB.put("300", 300);
            lFB.put("400", 400);
            lFB.put("500", 500);
            lFB.put("600", Integer.valueOf((int) Constants.HTTP_DNS_INAVAILABLE_TIME));
            lFB.put("700", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lFB.put("800", 800);
            lFB.put("900", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
        }

        public static Integer Oo(String str) {
            return lFB.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final Map<String, PreserveAspectRatio.Alignment> lFy = new HashMap(10);

        static {
            lFy.put("none", PreserveAspectRatio.Alignment.None);
            lFy.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            lFy.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            lFy.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            lFy.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            lFy.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            lFy.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            lFy.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            lFy.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            lFy.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment On(String str) {
            return lFy.get(str);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: protected */
    public SVG o(InputStream inputStream) throws SVGParseException {
        InputStream inputStream2;
        InputStream bufferedInputStream = !inputStream.markSupported() ? new BufferedInputStream(inputStream) : inputStream;
        try {
            bufferedInputStream.mark(3);
            int read = bufferedInputStream.read() + (bufferedInputStream.read() << 8);
            bufferedInputStream.reset();
            inputStream2 = read == 35615 ? new GZIPInputStream(bufferedInputStream) : bufferedInputStream;
        } catch (IOException e2) {
            inputStream2 = bufferedInputStream;
        }
        try {
            try {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this);
                    xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                    xMLReader.parse(new InputSource(inputStream2));
                    return this.lFm;
                } catch (ParserConfigurationException e3) {
                    throw new SVGParseException("XML Parser problem", e3);
                }
            } catch (IOException e4) {
                throw new SVGParseException("File error", e4);
            } catch (SAXException e5) {
                throw new SVGParseException("SVG parse error: " + e5.getMessage(), e5);
            }
        } finally {
            try {
                inputStream2.close();
            } catch (IOException e6) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.lFm = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.lFo) {
            this.lFp++;
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            SVGElem fromString = SVGElem.fromString(str2);
            switch (fromString) {
                case svg:
                    a(attributes);
                    return;
                case g:
                case a:
                    b(attributes);
                    return;
                case defs:
                    c(attributes);
                    return;
                case use:
                    d(attributes);
                    return;
                case path:
                    f(attributes);
                    return;
                case rect:
                    g(attributes);
                    return;
                case circle:
                    h(attributes);
                    return;
                case ellipse:
                    i(attributes);
                    return;
                case line:
                    j(attributes);
                    return;
                case polyline:
                    k(attributes);
                    return;
                case polygon:
                    l(attributes);
                    return;
                case text:
                    m(attributes);
                    return;
                case tspan:
                    n(attributes);
                    return;
                case tref:
                    o(attributes);
                    return;
                case SWITCH:
                    p(attributes);
                    return;
                case symbol:
                    q(attributes);
                    return;
                case marker:
                    r(attributes);
                    return;
                case linearGradient:
                    s(attributes);
                    return;
                case radialGradient:
                    t(attributes);
                    return;
                case stop:
                    u(attributes);
                    return;
                case title:
                case desc:
                    this.lFq = true;
                    this.lFr = fromString;
                    return;
                case clipPath:
                    w(attributes);
                    return;
                case textPath:
                    x(attributes);
                    return;
                case pattern:
                    y(attributes);
                    return;
                case image:
                    e(attributes);
                    return;
                case view:
                    z(attributes);
                    return;
                case mask:
                    A(attributes);
                    return;
                case style:
                    B(attributes);
                    return;
                case solidColor:
                    v(attributes);
                    return;
                default:
                    this.lFo = true;
                    this.lFp = 1;
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lFo) {
            if (this.lFq) {
                if (this.lFs == null) {
                    this.lFs = new StringBuilder(i2);
                }
                this.lFs.append(cArr, i, i2);
            } else if (this.lFt) {
                if (this.lFu == null) {
                    this.lFu = new StringBuilder(i2);
                }
                this.lFu.append(cArr, i, i2);
            } else if (this.lFn instanceof SVG.av) {
                SVG.ae aeVar = (SVG.ae) this.lFn;
                int size = aeVar.SW.size();
                SVG.ak akVar = size == 0 ? null : aeVar.SW.get(size - 1);
                if (akVar instanceof SVG.az) {
                    SVG.az azVar = (SVG.az) akVar;
                    azVar.text += new String(cArr, i, i2);
                    return;
                }
                ((SVG.ae) this.lFn).a(new SVG.az(new String(cArr, i, i2)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lFo && this.lFt) {
            if (this.lFu == null) {
                this.lFu = new StringBuilder(i2);
            }
            this.lFu.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.lFo) {
            int i = this.lFp - 1;
            this.lFp = i;
            if (i == 0) {
                this.lFo = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            switch (SVGElem.fromString(str2)) {
                case svg:
                case g:
                case defs:
                case use:
                case text:
                case tspan:
                case SWITCH:
                case symbol:
                case marker:
                case linearGradient:
                case radialGradient:
                case stop:
                case clipPath:
                case textPath:
                case pattern:
                case image:
                case view:
                case mask:
                case solidColor:
                    this.lFn = ((SVG.ak) this.lFn).lEA;
                    return;
                case a:
                case path:
                case rect:
                case circle:
                case ellipse:
                case line:
                case polyline:
                case polygon:
                case tref:
                default:
                    return;
                case title:
                case desc:
                    this.lFq = false;
                    if (this.lFr == SVGElem.title) {
                        this.lFm.setTitle(this.lFs.toString());
                    } else if (this.lFr == SVGElem.desc) {
                        this.lFm.setDesc(this.lFs.toString());
                    }
                    this.lFs.setLength(0);
                    return;
                case style:
                    if (this.lFu != null) {
                        this.lFt = false;
                        Om(this.lFu.toString());
                        this.lFu.setLength(0);
                        return;
                    }
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    private void debug(String str, Object... objArr) {
    }

    private void a(Attributes attributes) throws SAXException {
        debug("<svg>", new Object[0]);
        SVG.ac acVar = new SVG.ac();
        acVar.lEz = this.lFm;
        acVar.lEA = this.lFn;
        a((SVG.ai) acVar, attributes);
        b(acVar, attributes);
        a((SVG.ad) acVar, attributes);
        a((SVG.ao) acVar, attributes);
        a(acVar, attributes);
        if (this.lFn == null) {
            this.lFm.a(acVar);
        } else {
            this.lFn.a(acVar);
        }
        this.lFn = acVar;
    }

    private void a(SVG.ac acVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    acVar.lDd = NM(trim);
                    break;
                case y:
                    acVar.lDe = NM(trim);
                    break;
                case width:
                    acVar.lDf = NM(trim);
                    if (acVar.lDf.dhi()) {
                        throw new SAXException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    acVar.lDg = NM(trim);
                    if (acVar.lDg.dhi()) {
                        throw new SAXException("Invalid <svg> element. height cannot be negative");
                    }
                    break;
                case version:
                    acVar.version = trim;
                    break;
            }
        }
    }

    private void b(Attributes attributes) throws SAXException {
        debug("<g>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.k kVar = new SVG.k();
        kVar.lEz = this.lFm;
        kVar.lEA = this.lFn;
        a((SVG.ai) kVar, attributes);
        b(kVar, attributes);
        a((SVG.l) kVar, attributes);
        a((SVG.ad) kVar, attributes);
        this.lFn.a(kVar);
        this.lFn = kVar;
    }

    private void c(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.g gVar = new SVG.g();
        gVar.lEz = this.lFm;
        gVar.lEA = this.lFn;
        a((SVG.ai) gVar, attributes);
        b(gVar, attributes);
        a((SVG.l) gVar, attributes);
        this.lFn.a(gVar);
        this.lFn = gVar;
    }

    private void d(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ba baVar = new SVG.ba();
        baVar.lEz = this.lFm;
        baVar.lEA = this.lFn;
        a((SVG.ai) baVar, attributes);
        b(baVar, attributes);
        a((SVG.l) baVar, attributes);
        a((SVG.ad) baVar, attributes);
        a(baVar, attributes);
        this.lFn.a(baVar);
        this.lFn = baVar;
    }

    private void a(SVG.ba baVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    baVar.lDd = NM(trim);
                    break;
                case y:
                    baVar.lDe = NM(trim);
                    break;
                case width:
                    baVar.lDf = NM(trim);
                    if (baVar.lDf.dhi()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    baVar.lDg = NM(trim);
                    if (baVar.lDg.dhi()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        baVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void e(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.m mVar = new SVG.m();
        mVar.lEz = this.lFm;
        mVar.lEA = this.lFn;
        a((SVG.ai) mVar, attributes);
        b(mVar, attributes);
        a((SVG.l) mVar, attributes);
        a((SVG.ad) mVar, attributes);
        a(mVar, attributes);
        this.lFn.a(mVar);
        this.lFn = mVar;
    }

    private void a(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    mVar.lDd = NM(trim);
                    break;
                case y:
                    mVar.lDe = NM(trim);
                    break;
                case width:
                    mVar.lDf = NM(trim);
                    if (mVar.lDf.dhi()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    mVar.lDg = NM(trim);
                    if (mVar.lDg.dhi()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        mVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
                case preserveAspectRatio:
                    a((SVG.am) mVar, trim);
                    break;
            }
        }
    }

    private void f(Attributes attributes) throws SAXException {
        debug("<path>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.t tVar = new SVG.t();
        tVar.lEz = this.lFm;
        tVar.lEA = this.lFn;
        a((SVG.ai) tVar, attributes);
        b(tVar, attributes);
        a((SVG.l) tVar, attributes);
        a((SVG.ad) tVar, attributes);
        a(tVar, attributes);
        this.lFn.a(tVar);
    }

    private void a(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    tVar.lDv = Oi(trim);
                    break;
                case pathLength:
                    tVar.lDw = Float.valueOf(parseFloat(trim));
                    if (tVar.lDw.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.z zVar = new SVG.z();
        zVar.lEz = this.lFm;
        zVar.lEA = this.lFn;
        a((SVG.ai) zVar, attributes);
        b(zVar, attributes);
        a((SVG.l) zVar, attributes);
        a((SVG.ad) zVar, attributes);
        a(zVar, attributes);
        this.lFn.a(zVar);
    }

    private void a(SVG.z zVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    zVar.lDd = NM(trim);
                    break;
                case y:
                    zVar.lDe = NM(trim);
                    break;
                case width:
                    zVar.lDf = NM(trim);
                    if (zVar.lDf.dhi()) {
                        throw new SAXException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    zVar.lDg = NM(trim);
                    if (zVar.lDg.dhi()) {
                        throw new SAXException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    zVar.lCX = NM(trim);
                    if (zVar.lCX.dhi()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    zVar.lCY = NM(trim);
                    if (zVar.lCY.dhi()) {
                        throw new SAXException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    private void h(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.c cVar = new SVG.c();
        cVar.lEz = this.lFm;
        cVar.lEA = this.lFn;
        a((SVG.ai) cVar, attributes);
        b(cVar, attributes);
        a((SVG.l) cVar, attributes);
        a((SVG.ad) cVar, attributes);
        a(cVar, attributes);
        this.lFn.a(cVar);
    }

    private void a(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    cVar.lCQ = NM(trim);
                    break;
                case cy:
                    cVar.lCR = NM(trim);
                    break;
                case r:
                    cVar.lCS = NM(trim);
                    if (cVar.lCS.dhi()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void i(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.h hVar = new SVG.h();
        hVar.lEz = this.lFm;
        hVar.lEA = this.lFn;
        a((SVG.ai) hVar, attributes);
        b(hVar, attributes);
        a((SVG.l) hVar, attributes);
        a((SVG.ad) hVar, attributes);
        a(hVar, attributes);
        this.lFn.a(hVar);
    }

    private void a(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    hVar.lCX = NM(trim);
                    if (hVar.lCX.dhi()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.lCY = NM(trim);
                    if (hVar.lCY.dhi()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.lCQ = NM(trim);
                    break;
                case cy:
                    hVar.lCR = NM(trim);
                    break;
            }
        }
    }

    private void j(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.o oVar = new SVG.o();
        oVar.lEz = this.lFm;
        oVar.lEA = this.lFn;
        a((SVG.ai) oVar, attributes);
        b(oVar, attributes);
        a((SVG.l) oVar, attributes);
        a((SVG.ad) oVar, attributes);
        a(oVar, attributes);
        this.lFn.a(oVar);
    }

    private void a(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    oVar.lDi = NM(trim);
                    break;
                case y1:
                    oVar.lDj = NM(trim);
                    break;
                case x2:
                    oVar.lDk = NM(trim);
                    break;
                case y2:
                    oVar.lDl = NM(trim);
                    break;
            }
        }
    }

    private void k(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.x xVar = new SVG.x();
        xVar.lEz = this.lFm;
        xVar.lEA = this.lFn;
        a((SVG.ai) xVar, attributes);
        b(xVar, attributes);
        a((SVG.l) xVar, attributes);
        a((SVG.ad) xVar, attributes);
        a(xVar, attributes, "polyline");
        this.lFn.a(xVar);
    }

    private void a(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                e eVar = new e(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                eVar.dhN();
                while (!eVar.dhM()) {
                    float nextFloat = eVar.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    eVar.dhO();
                    float nextFloat2 = eVar.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    eVar.dhO();
                    arrayList.add(Float.valueOf(nextFloat));
                    arrayList.add(Float.valueOf(nextFloat2));
                }
                xVar.points = new float[arrayList.size()];
                int i2 = 0;
                for (Float f : arrayList) {
                    xVar.points[i2] = f.floatValue();
                    i2++;
                }
            }
        }
    }

    private void l(Attributes attributes) throws SAXException {
        debug("<polygon>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.y yVar = new SVG.y();
        yVar.lEz = this.lFm;
        yVar.lEA = this.lFn;
        a((SVG.ai) yVar, attributes);
        b(yVar, attributes);
        a((SVG.l) yVar, attributes);
        a((SVG.ad) yVar, attributes);
        a(yVar, attributes, "polygon");
        this.lFn.a(yVar);
    }

    private void m(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.at atVar = new SVG.at();
        atVar.lEz = this.lFm;
        atVar.lEA = this.lFn;
        a((SVG.ai) atVar, attributes);
        b(atVar, attributes);
        a((SVG.l) atVar, attributes);
        a((SVG.ad) atVar, attributes);
        a((SVG.ax) atVar, attributes);
        this.lFn.a(atVar);
        this.lFn = atVar;
    }

    private void a(SVG.ax axVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    axVar.x = NN(trim);
                    break;
                case y:
                    axVar.y = NN(trim);
                    break;
                case dx:
                    axVar.lEH = NN(trim);
                    break;
                case dy:
                    axVar.lEI = NN(trim);
                    break;
            }
        }
    }

    private void n(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFn instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.as asVar = new SVG.as();
        asVar.lEz = this.lFm;
        asVar.lEA = this.lFn;
        a((SVG.ai) asVar, attributes);
        b(asVar, attributes);
        a((SVG.ad) asVar, attributes);
        a((SVG.ax) asVar, attributes);
        this.lFn.a(asVar);
        this.lFn = asVar;
        if (asVar.lEA instanceof SVG.ay) {
            asVar.a((SVG.ay) asVar.lEA);
        } else {
            asVar.a(((SVG.au) asVar.lEA).dhp());
        }
    }

    private void o(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFn instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.ar arVar = new SVG.ar();
        arVar.lEz = this.lFm;
        arVar.lEA = this.lFn;
        a((SVG.ai) arVar, attributes);
        b(arVar, attributes);
        a((SVG.ad) arVar, attributes);
        a(arVar, attributes);
        this.lFn.a(arVar);
        if (arVar.lEA instanceof SVG.ay) {
            arVar.a((SVG.ay) arVar.lEA);
        } else {
            arVar.a(((SVG.au) arVar.lEA).dhp());
        }
    }

    private void a(SVG.ar arVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        arVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void p(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ap apVar = new SVG.ap();
        apVar.lEz = this.lFm;
        apVar.lEA = this.lFn;
        a((SVG.ai) apVar, attributes);
        b(apVar, attributes);
        a((SVG.l) apVar, attributes);
        a((SVG.ad) apVar, attributes);
        this.lFn.a(apVar);
        this.lFn = apVar;
    }

    private void a(SVG.ad adVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    adVar.i(Oj(trim));
                    break;
                case requiredExtensions:
                    adVar.NF(trim);
                    break;
                case systemLanguage:
                    adVar.j(Ok(trim));
                    break;
                case requiredFormats:
                    adVar.k(Ol(trim));
                    break;
                case requiredFonts:
                    List<String> NT = NT(trim);
                    adVar.l(NT != null ? new HashSet(NT) : new HashSet(0));
                    break;
            }
        }
    }

    private void q(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aq aqVar = new SVG.aq();
        aqVar.lEz = this.lFm;
        aqVar.lEA = this.lFn;
        a((SVG.ai) aqVar, attributes);
        b(aqVar, attributes);
        a((SVG.ad) aqVar, attributes);
        a((SVG.ao) aqVar, attributes);
        this.lFn.a(aqVar);
        this.lFn = aqVar;
    }

    private void r(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.p pVar = new SVG.p();
        pVar.lEz = this.lFm;
        pVar.lEA = this.lFn;
        a((SVG.ai) pVar, attributes);
        b(pVar, attributes);
        a((SVG.ad) pVar, attributes);
        a((SVG.ao) pVar, attributes);
        a(pVar, attributes);
        this.lFn.a(pVar);
        this.lFn = pVar;
    }

    private void a(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    pVar.lDn = NM(trim);
                    break;
                case refY:
                    pVar.lDo = NM(trim);
                    break;
                case markerWidth:
                    pVar.lDp = NM(trim);
                    if (pVar.lDp.dhi()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    pVar.lDq = NM(trim);
                    if (pVar.lDq.dhi()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        pVar.lDm = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        pVar.lDm = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        pVar.lDr = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        pVar.lDr = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void s(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aj ajVar = new SVG.aj();
        ajVar.lEz = this.lFm;
        ajVar.lEA = this.lFn;
        a((SVG.ai) ajVar, attributes);
        b(ajVar, attributes);
        a((SVG.i) ajVar, attributes);
        a(ajVar, attributes);
        this.lFn.a(ajVar);
        this.lFn = ajVar;
    }

    private void a(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        iVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        iVar.lCZ = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.lCZ = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.lDa = NL(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.lDb = SVG.GradientSpread.valueOf(trim);
                        break;
                    } catch (IllegalArgumentException e2) {
                        throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                    }
            }
        }
    }

    private void a(SVG.aj ajVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    ajVar.lDi = NM(trim);
                    break;
                case y1:
                    ajVar.lDj = NM(trim);
                    break;
                case x2:
                    ajVar.lDk = NM(trim);
                    break;
                case y2:
                    ajVar.lDl = NM(trim);
                    break;
            }
        }
    }

    private void t(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.an anVar = new SVG.an();
        anVar.lEz = this.lFm;
        anVar.lEA = this.lFn;
        a((SVG.ai) anVar, attributes);
        b(anVar, attributes);
        a((SVG.i) anVar, attributes);
        a(anVar, attributes);
        this.lFn.a(anVar);
        this.lFn = anVar;
    }

    private void a(SVG.an anVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    anVar.lCQ = NM(trim);
                    break;
                case cy:
                    anVar.lCR = NM(trim);
                    break;
                case r:
                    anVar.lCS = NM(trim);
                    if (anVar.lCS.dhi()) {
                        throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    anVar.lEC = NM(trim);
                    break;
                case fy:
                    anVar.lED = NM(trim);
                    break;
            }
        }
    }

    private void u(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFn instanceof SVG.i)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.ab abVar = new SVG.ab();
        abVar.lEz = this.lFm;
        abVar.lEA = this.lFn;
        a((SVG.ai) abVar, attributes);
        b(abVar, attributes);
        a(abVar, attributes);
        this.lFn.a(abVar);
        this.lFn = abVar;
    }

    private void a(SVG.ab abVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    abVar.lDE = NK(trim);
                    break;
            }
        }
    }

    private Float NK(String str) throws SAXException {
        int i;
        boolean z;
        if (str.length() == 0) {
            throw new SAXException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        if (str.charAt(str.length() - 1) == '%') {
            i = length - 1;
            z = true;
        } else {
            i = length;
            z = false;
        }
        try {
            float C = C(str, 0, i);
            if (z) {
                C /= 100.0f;
            }
            return Float.valueOf(C >= 0.0f ? C > 100.0f ? 100.0f : C : 0.0f);
        } catch (NumberFormatException e2) {
            throw new SAXException("Invalid offset value in <stop>: " + str, e2);
        }
    }

    private void v(Attributes attributes) throws SAXException {
        debug("<solidColor>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aa aaVar = new SVG.aa();
        aaVar.lEz = this.lFm;
        aaVar.lEA = this.lFn;
        a(aaVar, attributes);
        b(aaVar, attributes);
        this.lFn.a(aaVar);
        this.lFn = aaVar;
    }

    private void w(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.d dVar = new SVG.d();
        dVar.lEz = this.lFm;
        dVar.lEA = this.lFn;
        a((SVG.ai) dVar, attributes);
        b(dVar, attributes);
        a((SVG.l) dVar, attributes);
        a((SVG.ad) dVar, attributes);
        a(dVar, attributes);
        this.lFn.a(dVar);
        this.lFn = dVar;
    }

    private void a(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.lCT = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.lCT = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    private void x(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aw awVar = new SVG.aw();
        awVar.lEz = this.lFm;
        awVar.lEA = this.lFn;
        a((SVG.ai) awVar, attributes);
        b(awVar, attributes);
        a((SVG.ad) awVar, attributes);
        a(awVar, attributes);
        this.lFn.a(awVar);
        this.lFn = awVar;
        if (awVar.lEA instanceof SVG.ay) {
            awVar.a((SVG.ay) awVar.lEA);
        } else {
            awVar.a(((SVG.au) awVar.lEA).dhp());
        }
    }

    private void a(SVG.aw awVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        awVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
                case startOffset:
                    awVar.lEG = NM(trim);
                    break;
            }
        }
    }

    private void y(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.w wVar = new SVG.w();
        wVar.lEz = this.lFm;
        wVar.lEA = this.lFn;
        a((SVG.ai) wVar, attributes);
        b(wVar, attributes);
        a((SVG.ad) wVar, attributes);
        a((SVG.ao) wVar, attributes);
        a(wVar, attributes);
        this.lFn.a(wVar);
        this.lFn = wVar;
    }

    private void a(SVG.w wVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    wVar.lDd = NM(trim);
                    break;
                case y:
                    wVar.lDe = NM(trim);
                    break;
                case width:
                    wVar.lDf = NM(trim);
                    if (wVar.lDf.dhi()) {
                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    wVar.lDg = NM(trim);
                    if (wVar.lDg.dhi()) {
                        throw new SAXException("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        wVar.RC = trim;
                        break;
                    } else {
                        break;
                    }
                case patternUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lDB = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lDB = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lDC = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lDC = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    wVar.lDD = NL(trim);
                    break;
            }
        }
    }

    private void z(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.bb bbVar = new SVG.bb();
        bbVar.lEz = this.lFm;
        bbVar.lEA = this.lFn;
        a((SVG.ai) bbVar, attributes);
        a((SVG.ad) bbVar, attributes);
        a((SVG.ao) bbVar, attributes);
        this.lFn.a(bbVar);
        this.lFn = bbVar;
    }

    private void A(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.q qVar = new SVG.q();
        qVar.lEz = this.lFm;
        qVar.lEA = this.lFn;
        a((SVG.ai) qVar, attributes);
        b(qVar, attributes);
        a((SVG.ad) qVar, attributes);
        a(qVar, attributes);
        this.lFn.a(qVar);
        this.lFn = qVar;
    }

    private void a(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    qVar.lDd = NM(trim);
                    break;
                case y:
                    qVar.lDe = NM(trim);
                    break;
                case width:
                    qVar.lDf = NM(trim);
                    if (qVar.lDf.dhi()) {
                        throw new SAXException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    qVar.lDg = NM(trim);
                    if (qVar.lDg.dhi()) {
                        throw new SAXException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lDs = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lDs = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lDt = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lDt = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskContentUnits");
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public static class e {
        protected String lFC;
        protected int lFD;
        protected int position = 0;
        private com.caverock.androidsvg.b lFE = new com.caverock.androidsvg.b();

        public e(String str) {
            this.lFD = 0;
            this.lFC = str.trim();
            this.lFD = this.lFC.length();
        }

        public boolean dhM() {
            return this.position == this.lFD;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hd(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public void dhN() {
            while (this.position < this.lFD && Hd(this.lFC.charAt(this.position))) {
                this.position++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean He(int i) {
            return i == 10 || i == 13;
        }

        public boolean dhO() {
            dhN();
            if (this.position != this.lFD && this.lFC.charAt(this.position) == ',') {
                this.position++;
                dhN();
                return true;
            }
            return false;
        }

        public float nextFloat() {
            float B = this.lFE.B(this.lFC, this.position, this.lFD);
            if (!Float.isNaN(B)) {
                this.position = this.lFE.dgX();
            }
            return B;
        }

        public float dhP() {
            dhO();
            float B = this.lFE.B(this.lFC, this.position, this.lFD);
            if (!Float.isNaN(B)) {
                this.position = this.lFE.dgX();
            }
            return B;
        }

        public float bj(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            dhO();
            return nextFloat();
        }

        public Integer dhQ() {
            if (this.position == this.lFD) {
                return null;
            }
            String str = this.lFC;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.n dhR() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit dhW = dhW();
            if (dhW == null) {
                return new SVG.n(nextFloat, SVG.Unit.px);
            }
            return new SVG.n(nextFloat, dhW);
        }

        public Boolean dhS() {
            if (this.position == this.lFD) {
                return null;
            }
            char charAt = this.lFC.charAt(this.position);
            if (charAt == '0' || charAt == '1') {
                this.position++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        public Boolean aJ(Object obj) {
            if (obj == null) {
                return null;
            }
            dhO();
            return dhS();
        }

        public boolean g(char c) {
            boolean z = this.position < this.lFD && this.lFC.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        public boolean Oq(String str) {
            int length = str.length();
            boolean z = this.position <= this.lFD - length && this.lFC.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int dhT() {
            if (this.position == this.lFD) {
                return -1;
            }
            this.position++;
            if (this.position < this.lFD) {
                return this.lFC.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return h(' ');
        }

        public String h(char c) {
            if (dhM()) {
                return null;
            }
            char charAt = this.lFC.charAt(this.position);
            if (Hd(charAt) || charAt == c) {
                return null;
            }
            int i = this.position;
            int dhT = dhT();
            while (dhT != -1 && dhT != c && !Hd(dhT)) {
                dhT = dhT();
            }
            return this.lFC.substring(i, this.position);
        }

        public String dhU() {
            if (dhM()) {
                return null;
            }
            int i = this.position;
            int charAt = this.lFC.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = dhT();
            }
            int i2 = this.position;
            while (Hd(charAt)) {
                charAt = dhT();
            }
            if (charAt == 40) {
                this.position++;
                return this.lFC.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        public String dhV() {
            int i = this.position;
            while (!dhM() && !Hd(this.lFC.charAt(this.position))) {
                this.position++;
            }
            String substring = this.lFC.substring(i, this.position);
            this.position = i;
            return substring;
        }

        public SVG.Unit dhW() {
            if (dhM()) {
                return null;
            }
            if (this.lFC.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            } else if (this.position <= this.lFD - 2) {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.lFC.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                return null;
            }
        }

        public boolean dhX() {
            if (this.position == this.lFD) {
                return false;
            }
            char charAt = this.lFC.charAt(this.position);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public String dhY() {
            if (dhM()) {
                return null;
            }
            int i = this.position;
            char charAt = this.lFC.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                int dhT = dhT();
                while (dhT != -1 && dhT != charAt) {
                    dhT = dhT();
                }
                if (dhT == -1) {
                    this.position = i;
                    return null;
                }
                this.position++;
                return this.lFC.substring(i + 1, this.position - 1);
            }
            return null;
        }

        public String dhZ() {
            if (dhM()) {
                return null;
            }
            int i = this.position;
            this.position = this.lFD;
            return this.lFC.substring(i);
        }
    }

    private void a(SVG.ai aiVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                aiVar.id = attributes.getValue(i).trim();
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i).trim();
                if ("default".equals(trim)) {
                    aiVar.lEw = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    aiVar.lEw = Boolean.TRUE;
                    return;
                } else {
                    throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                }
            }
        }
    }

    private void b(SVG.ai aiVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            if (trim.length() != 0) {
                switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                    case style:
                        a(aiVar, trim);
                        continue;
                    case CLASS:
                        aiVar.lEy = CSSParser.NB(trim);
                        continue;
                    default:
                        if (aiVar.lEx == null) {
                            aiVar.lEx = new SVG.Style();
                        }
                        a(aiVar.lEx, attributes.getLocalName(i), attributes.getValue(i).trim());
                        continue;
                }
            }
        }
    }

    private static void a(SVG.ai aiVar, String str) throws SAXException {
        e eVar = new e(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String h = eVar.h(':');
            eVar.dhN();
            if (eVar.g(':')) {
                eVar.dhN();
                String h2 = eVar.h(';');
                if (h2 != null) {
                    eVar.dhN();
                    if (eVar.dhM() || eVar.g(';')) {
                        if (aiVar.lCi == null) {
                            aiVar.lCi = new SVG.Style();
                        }
                        a(aiVar.lCi, h, h2);
                        eVar.dhN();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() != 0 && !str2.equals("inherit")) {
            switch (SVGAttr.fromString(str)) {
                case fill:
                    style.lDG = eY(str2, "fill");
                    style.lDF |= 1;
                    return;
                case fill_rule:
                    style.lDH = Oa(str2);
                    style.lDF |= 2;
                    return;
                case fill_opacity:
                    style.lDI = Float.valueOf(NO(str2));
                    style.lDF |= 4;
                    return;
                case stroke:
                    style.lDJ = eY(str2, "stroke");
                    style.lDF |= 8;
                    return;
                case stroke_opacity:
                    style.lDK = Float.valueOf(NO(str2));
                    style.lDF |= 16;
                    return;
                case stroke_width:
                    style.lDL = NM(str2);
                    style.lDF |= 32;
                    return;
                case stroke_linecap:
                    style.lDM = Ob(str2);
                    style.lDF |= 64;
                    return;
                case stroke_linejoin:
                    style.lDN = Oc(str2);
                    style.lDF |= 128;
                    return;
                case stroke_miterlimit:
                    style.lDO = Float.valueOf(parseFloat(str2));
                    style.lDF |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.lDP = null;
                    } else {
                        style.lDP = Od(str2);
                    }
                    style.lDF |= 512;
                    return;
                case stroke_dashoffset:
                    style.lDQ = NM(str2);
                    style.lDF |= 1024;
                    return;
                case opacity:
                    style.lDR = Float.valueOf(NO(str2));
                    style.lDF |= 2048;
                    return;
                case color:
                    style.lDS = NR(str2);
                    style.lDF |= 4096;
                    return;
                case font:
                    a(style, str2);
                    return;
                case font_family:
                    style.lDT = NT(str2);
                    style.lDF |= 8192;
                    return;
                case font_size:
                    style.lDU = NU(str2);
                    style.lDF |= 16384;
                    return;
                case font_weight:
                    style.lDV = NV(str2);
                    style.lDF |= 32768;
                    return;
                case font_style:
                    style.lDW = NW(str2);
                    style.lDF |= 65536;
                    return;
                case text_decoration:
                    style.lDX = NY(str2);
                    style.lDF |= 131072;
                    return;
                case direction:
                    style.lDY = NZ(str2);
                    style.lDF |= 68719476736L;
                    return;
                case text_anchor:
                    style.lDZ = Oe(str2);
                    style.lDF |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    return;
                case overflow:
                    style.lEa = Of(str2);
                    style.lDF |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case marker:
                    style.lEc = eZ(str2, str);
                    style.lEd = style.lEc;
                    style.lEe = style.lEc;
                    style.lDF |= 14680064;
                    return;
                case marker_start:
                    style.lEc = eZ(str2, str);
                    style.lDF |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.lEd = eZ(str2, str);
                    style.lDF |= ImageUploadStrategy.FILE_SIZE_4M;
                    return;
                case marker_end:
                    style.lEe = eZ(str2, str);
                    style.lDF |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    style.lEf = Boolean.valueOf(!str2.equals("none"));
                    style.lDF |= AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH;
                    return;
                case visibility:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|visible|hidden|collapse|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    style.lEg = Boolean.valueOf(str2.equals("visible"));
                    style.lDF |= 33554432;
                    return;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        style.lEh = SVG.f.dhh();
                    } else {
                        style.lEh = NR(str2);
                    }
                    style.lDF |= 67108864;
                    return;
                case stop_opacity:
                    style.lEi = Float.valueOf(NO(str2));
                    style.lDF |= 134217728;
                    return;
                case clip:
                    style.lEb = Og(str2);
                    style.lDF |= 1048576;
                    return;
                case clip_path:
                    style.clipPath = eZ(str2, str);
                    style.lDF |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case clip_rule:
                    style.lEj = Oa(str2);
                    style.lDF |= IjkMediaMeta.AV_CH_STEREO_LEFT;
                    return;
                case mask:
                    style.lEk = eZ(str2, str);
                    style.lDF |= IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    return;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        style.lEl = SVG.f.dhh();
                    } else {
                        style.lEl = NR(str2);
                    }
                    style.lDF |= IjkMediaMeta.AV_CH_WIDE_LEFT;
                    return;
                case solid_opacity:
                    style.lEm = Float.valueOf(NO(str2));
                    style.lDF |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        style.lEn = SVG.f.dhh();
                    } else {
                        style.lEn = NR(str2);
                    }
                    style.lDF |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                    return;
                case viewport_fill_opacity:
                    style.lEo = Float.valueOf(NO(str2));
                    style.lDF |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                    return;
                case vector_effect:
                    style.lEp = Oh(str2);
                    style.lDF |= IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
                    return;
                default:
                    return;
            }
        }
    }

    private void a(SVG.ao aoVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case preserveAspectRatio:
                    a((SVG.am) aoVar, trim);
                    break;
                case viewBox:
                    aoVar.lEE = NP(trim);
                    break;
            }
        }
    }

    private void a(SVG.l lVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                lVar.setTransform(NL(attributes.getValue(i)));
            }
        }
    }

    private Matrix NL(String str) throws SAXException {
        Matrix matrix = new Matrix();
        e eVar = new e(str);
        eVar.dhN();
        while (!eVar.dhM()) {
            String dhU = eVar.dhU();
            if (dhU == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (dhU.equals("matrix")) {
                eVar.dhN();
                float nextFloat = eVar.nextFloat();
                eVar.dhO();
                float nextFloat2 = eVar.nextFloat();
                eVar.dhO();
                float nextFloat3 = eVar.nextFloat();
                eVar.dhO();
                float nextFloat4 = eVar.nextFloat();
                eVar.dhO();
                float nextFloat5 = eVar.nextFloat();
                eVar.dhO();
                float nextFloat6 = eVar.nextFloat();
                eVar.dhN();
                if (Float.isNaN(nextFloat6) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (dhU.equals("translate")) {
                eVar.dhN();
                float nextFloat7 = eVar.nextFloat();
                float dhP = eVar.dhP();
                eVar.dhN();
                if (Float.isNaN(nextFloat7) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dhP)) {
                    matrix.preTranslate(nextFloat7, 0.0f);
                } else {
                    matrix.preTranslate(nextFloat7, dhP);
                }
            } else if (dhU.equals("scale")) {
                eVar.dhN();
                float nextFloat8 = eVar.nextFloat();
                float dhP2 = eVar.dhP();
                eVar.dhN();
                if (Float.isNaN(nextFloat8) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dhP2)) {
                    matrix.preScale(nextFloat8, nextFloat8);
                } else {
                    matrix.preScale(nextFloat8, dhP2);
                }
            } else if (dhU.equals(RotateImageAction.ACTION_NAME)) {
                eVar.dhN();
                float nextFloat9 = eVar.nextFloat();
                float dhP3 = eVar.dhP();
                float dhP4 = eVar.dhP();
                eVar.dhN();
                if (Float.isNaN(nextFloat9) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dhP3)) {
                    matrix.preRotate(nextFloat9);
                } else if (!Float.isNaN(dhP4)) {
                    matrix.preRotate(nextFloat9, dhP3, dhP4);
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (dhU.equals("skewX")) {
                eVar.dhN();
                float nextFloat10 = eVar.nextFloat();
                eVar.dhN();
                if (Float.isNaN(nextFloat10) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat10)), 0.0f);
            } else if (dhU.equals("skewY")) {
                eVar.dhN();
                float nextFloat11 = eVar.nextFloat();
                eVar.dhN();
                if (Float.isNaN(nextFloat11) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat11)));
            } else if (dhU != null) {
                throw new SAXException("Invalid transform list fn: " + dhU + ")");
            }
            if (eVar.dhM()) {
                break;
            }
            eVar.dhO();
        }
        return matrix;
    }

    protected static SVG.n NM(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVG.Unit unit = SVG.Unit.px;
        char charAt = str.charAt(length - 1);
        if (charAt == '%') {
            length--;
            unit = SVG.Unit.percent;
        } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException e2) {
                throw new SAXException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVG.n(C(str, 0, length), unit);
        } catch (NumberFormatException e3) {
            throw new SAXException("Invalid length value: " + str, e3);
        }
    }

    private static List<SVG.n> NN(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e(str);
        eVar.dhN();
        while (!eVar.dhM()) {
            float nextFloat = eVar.nextFloat();
            if (Float.isNaN(nextFloat)) {
                throw new SAXException("Invalid length list value: " + eVar.dhV());
            }
            SVG.Unit dhW = eVar.dhW();
            if (dhW == null) {
                dhW = SVG.Unit.px;
            }
            arrayList.add(new SVG.n(nextFloat, dhW));
            eVar.dhO();
        }
        return arrayList;
    }

    private static float parseFloat(String str) throws SAXException {
        int length = str.length();
        if (length == 0) {
            throw new SAXException("Invalid float value (empty string)");
        }
        return C(str, 0, length);
    }

    private static float C(String str, int i, int i2) throws SAXException {
        float B = new com.caverock.androidsvg.b().B(str, i, i2);
        if (!Float.isNaN(B)) {
            return B;
        }
        throw new SAXException("Invalid float value: " + str);
    }

    private static float NO(String str) throws SAXException {
        float parseFloat = parseFloat(str);
        if (parseFloat < 0.0f) {
            return 0.0f;
        }
        if (parseFloat > 1.0f) {
            return 1.0f;
        }
        return parseFloat;
    }

    private static SVG.a NP(String str) throws SAXException {
        e eVar = new e(str);
        eVar.dhN();
        float nextFloat = eVar.nextFloat();
        eVar.dhO();
        float nextFloat2 = eVar.nextFloat();
        eVar.dhO();
        float nextFloat3 = eVar.nextFloat();
        eVar.dhO();
        float nextFloat4 = eVar.nextFloat();
        if (Float.isNaN(nextFloat) || Float.isNaN(nextFloat2) || Float.isNaN(nextFloat3) || Float.isNaN(nextFloat4)) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        }
        if (nextFloat3 < 0.0f) {
            throw new SAXException("Invalid viewBox. width cannot be negative");
        }
        if (nextFloat4 < 0.0f) {
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
        return new SVG.a(nextFloat, nextFloat2, nextFloat3, nextFloat4);
    }

    private static void a(SVG.am amVar, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        e eVar = new e(str);
        eVar.dhN();
        String nextToken = eVar.nextToken();
        if ("defer".equals(nextToken)) {
            eVar.dhN();
            nextToken = eVar.nextToken();
        }
        PreserveAspectRatio.Alignment On = a.On(nextToken);
        eVar.dhN();
        if (eVar.dhM()) {
            scale = null;
        } else {
            String nextToken2 = eVar.nextToken();
            if (nextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (nextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        amVar.lEB = new PreserveAspectRatio(On, scale);
    }

    private static SVG.al eY(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf == -1) {
                throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
            }
            String trim = str.substring(4, indexOf).trim();
            SVG.al alVar = null;
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim2.length() > 0) {
                alVar = NQ(trim2);
            }
            return new SVG.s(trim, alVar);
        }
        return NQ(str);
    }

    private static SVG.al NQ(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.f.dhh();
        }
        return NR(str);
    }

    private static SVG.e NR(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.a A = com.caverock.androidsvg.a.A(str, 1, str.length());
            if (A == null) {
                throw new SAXException("Bad hex colour value: " + str);
            }
            int dgX = A.dgX();
            if (dgX == 7) {
                return new SVG.e(A.value());
            }
            if (dgX == 4) {
                int value = A.value();
                int i = value & 3840;
                int i2 = value & 240;
                int i3 = value & 15;
                return new SVG.e((i << 12) | (i << 16) | (i2 << 8) | (i2 << 4) | (i3 << 4) | i3);
            }
            throw new SAXException("Bad hex colour value: " + str);
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            e eVar = new e(str.substring(4));
            eVar.dhN();
            float nextFloat = eVar.nextFloat();
            if (!Float.isNaN(nextFloat) && eVar.g('%')) {
                nextFloat = (nextFloat * 256.0f) / 100.0f;
            }
            float bj = eVar.bj(nextFloat);
            if (!Float.isNaN(bj) && eVar.g('%')) {
                bj = (bj * 256.0f) / 100.0f;
            }
            float bj2 = eVar.bj(bj);
            if (!Float.isNaN(bj2) && eVar.g('%')) {
                bj2 = (bj2 * 256.0f) / 100.0f;
            }
            eVar.dhN();
            if (Float.isNaN(bj2) || !eVar.g(')')) {
                throw new SAXException("Bad rgb() colour value: " + str);
            }
            return new SVG.e((bi(nextFloat) << 16) | (bi(bj) << 8) | bi(bj2));
        } else {
            return NS(str);
        }
    }

    private static int bi(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static SVG.e NS(String str) throws SAXException {
        Integer Oo = b.Oo(str.toLowerCase(Locale.US));
        if (Oo == null) {
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return new SVG.e(Oo.intValue());
    }

    private static void a(SVG.Style style, String str) throws SAXException {
        String h;
        String str2 = null;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf('|' + str + '|') == -1) {
            e eVar = new e(str);
            SVG.Style.FontStyle fontStyle = null;
            Integer num = null;
            while (true) {
                h = eVar.h('/');
                eVar.dhN();
                if (h == null) {
                    throw new SAXException("Invalid font style attribute: missing font size and family");
                }
                if (num != null && fontStyle != null) {
                    break;
                } else if (!h.equals("normal") && (num != null || (num = d.Oo(h)) == null)) {
                    if (fontStyle != null || (fontStyle = NX(h)) == null) {
                        if (str2 != null || !h.equals("small-caps")) {
                            break;
                        }
                        str2 = h;
                    }
                }
            }
            SVG.n NU = NU(h);
            if (eVar.g('/')) {
                eVar.dhN();
                String nextToken = eVar.nextToken();
                if (nextToken == null) {
                    throw new SAXException("Invalid font style attribute: missing line-height");
                }
                NM(nextToken);
                eVar.dhN();
            }
            style.lDT = NT(eVar.dhZ());
            style.lDU = NU;
            style.lDV = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.lDW = fontStyle;
            style.lDF |= 122880;
        }
    }

    private static List<String> NT(String str) throws SAXException {
        ArrayList arrayList = null;
        e eVar = new e(str);
        do {
            String dhY = eVar.dhY();
            if (dhY == null) {
                dhY = eVar.h(',');
            }
            if (dhY == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dhY);
            eVar.dhO();
        } while (!eVar.dhM());
        return arrayList;
    }

    private static SVG.n NU(String str) throws SAXException {
        SVG.n Op = c.Op(str);
        if (Op == null) {
            return NM(str);
        }
        return Op;
    }

    private static Integer NV(String str) throws SAXException {
        Integer Oo = d.Oo(str);
        if (Oo == null) {
            throw new SAXException("Invalid font-weight property: " + str);
        }
        return Oo;
    }

    private static SVG.Style.FontStyle NW(String str) throws SAXException {
        SVG.Style.FontStyle NX = NX(str);
        if (NX != null) {
            return NX;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static SVG.Style.FontStyle NX(String str) {
        if ("italic".equals(str)) {
            return SVG.Style.FontStyle.Italic;
        }
        if ("normal".equals(str)) {
            return SVG.Style.FontStyle.Normal;
        }
        if ("oblique".equals(str)) {
            return SVG.Style.FontStyle.Oblique;
        }
        return null;
    }

    private static SVG.Style.TextDecoration NY(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.TextDecoration.None;
        }
        if ("underline".equals(str)) {
            return SVG.Style.TextDecoration.Underline;
        }
        if ("overline".equals(str)) {
            return SVG.Style.TextDecoration.Overline;
        }
        if ("line-through".equals(str)) {
            return SVG.Style.TextDecoration.LineThrough;
        }
        if ("blink".equals(str)) {
            return SVG.Style.TextDecoration.Blink;
        }
        throw new SAXException("Invalid text-decoration property: " + str);
    }

    private static SVG.Style.TextDirection NZ(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private static SVG.Style.FillRule Oa(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static SVG.Style.LineCaps Ob(String str) throws SAXException {
        if ("butt".equals(str)) {
            return SVG.Style.LineCaps.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCaps.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCaps.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: " + str);
    }

    private static SVG.Style.LineJoin Oc(String str) throws SAXException {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: " + str);
    }

    private static SVG.n[] Od(String str) throws SAXException {
        SVG.n dhR;
        e eVar = new e(str);
        eVar.dhN();
        if (!eVar.dhM() && (dhR = eVar.dhR()) != null) {
            if (dhR.dhi()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            float floatValue = dhR.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(dhR);
            while (!eVar.dhM()) {
                eVar.dhO();
                SVG.n dhR2 = eVar.dhR();
                if (dhR2 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
                if (dhR2.dhi()) {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                }
                arrayList.add(dhR2);
                floatValue += dhR2.floatValue();
            }
            if (floatValue == 0.0f) {
                return null;
            }
            return (SVG.n[]) arrayList.toArray(new SVG.n[arrayList.size()]);
        }
        return null;
    }

    private static SVG.Style.TextAnchor Oe(String str) throws SAXException {
        if ("start".equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if ("end".equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    private static Boolean Of(String str) throws SAXException {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private static SVG.b Og(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (!str.toLowerCase(Locale.US).startsWith("rect(")) {
            throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
        }
        e eVar = new e(str.substring(5));
        eVar.dhN();
        SVG.n a2 = a(eVar);
        eVar.dhO();
        SVG.n a3 = a(eVar);
        eVar.dhO();
        SVG.n a4 = a(eVar);
        eVar.dhO();
        SVG.n a5 = a(eVar);
        eVar.dhN();
        if (!eVar.g(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.b(a2, a3, a4, a5);
    }

    private static SVG.n a(e eVar) {
        return eVar.Oq("auto") ? new SVG.n(0.0f) : eVar.dhR();
    }

    private static SVG.Style.VectorEffect Oh(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private static SVG.u Oi(String str) throws SAXException {
        int intValue;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float dhP;
        float bj;
        float f10;
        e eVar = new e(str);
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        SVG.u uVar = new SVG.u();
        if (!eVar.dhM() && ((intValue = eVar.dhQ().intValue()) == 77 || intValue == 109)) {
            while (true) {
                while (true) {
                    float f17 = f14;
                    float f18 = f13;
                    int i = intValue;
                    float f19 = f12;
                    float f20 = f11;
                    float f21 = f15;
                    float f22 = f16;
                    eVar.dhN();
                    switch (i) {
                        case 65:
                        case 97:
                            float nextFloat = eVar.nextFloat();
                            float bj2 = eVar.bj(nextFloat);
                            float bj3 = eVar.bj(bj2);
                            Boolean aJ = eVar.aJ(Float.valueOf(bj3));
                            Boolean aJ2 = eVar.aJ(aJ);
                            if (aJ2 == null) {
                                bj = Float.NaN;
                                dhP = Float.NaN;
                            } else {
                                dhP = eVar.dhP();
                                bj = eVar.bj(dhP);
                            }
                            if (!Float.isNaN(bj) && nextFloat >= 0.0f && bj2 >= 0.0f) {
                                if (i == 97) {
                                    float f23 = f20 + dhP;
                                    f10 = bj + f19;
                                    f11 = f23;
                                } else {
                                    float f24 = bj;
                                    f11 = dhP;
                                    f10 = f24;
                                }
                                uVar.a(nextFloat, bj2, bj3, aJ.booleanValue(), aJ2.booleanValue(), f11, f10);
                                f16 = f10;
                                f15 = f11;
                                f14 = f17;
                                f13 = f18;
                                f12 = f10;
                                intValue = i;
                                break;
                            }
                            break;
                        case 67:
                        case 99:
                            float nextFloat2 = eVar.nextFloat();
                            float bj4 = eVar.bj(nextFloat2);
                            float bj5 = eVar.bj(bj4);
                            float bj6 = eVar.bj(bj5);
                            float bj7 = eVar.bj(bj6);
                            float bj8 = eVar.bj(bj7);
                            if (Float.isNaN(bj8)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 99) {
                                    float f25 = bj8 + f19;
                                    bj4 += f19;
                                    bj5 += f20;
                                    f6 = f19 + bj6;
                                    f8 = nextFloat2 + f20;
                                    f7 = bj7 + f20;
                                    f9 = f25;
                                } else {
                                    f6 = bj6;
                                    f7 = bj7;
                                    f8 = nextFloat2;
                                    f9 = bj8;
                                }
                                uVar.b(f8, bj4, bj5, f6, f7, f9);
                                f16 = f6;
                                f15 = bj5;
                                intValue = i;
                                f13 = f18;
                                f14 = f17;
                                float f26 = f7;
                                f12 = f9;
                                f11 = f26;
                                break;
                            }
                        case 72:
                        case 104:
                            float nextFloat3 = eVar.nextFloat();
                            if (Float.isNaN(nextFloat3)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 104) {
                                    nextFloat3 += f20;
                                }
                                uVar.B(nextFloat3, f19);
                                f14 = f17;
                                f12 = f19;
                                f11 = nextFloat3;
                                intValue = i;
                                f13 = f18;
                                f15 = nextFloat3;
                                f16 = f22;
                                break;
                            }
                        case 76:
                        case 108:
                            f15 = eVar.nextFloat();
                            f16 = eVar.bj(f15);
                            if (Float.isNaN(f16)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 108) {
                                    f15 += f20;
                                    f16 += f19;
                                }
                                uVar.B(f15, f16);
                                f14 = f17;
                                f13 = f18;
                                f12 = f16;
                                f11 = f15;
                                intValue = i;
                                break;
                            }
                        case 77:
                        case 109:
                            f15 = eVar.nextFloat();
                            f16 = eVar.bj(f15);
                            if (Float.isNaN(f16)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 109 && !uVar.isEmpty()) {
                                    f15 += f20;
                                    f16 += f19;
                                }
                                uVar.moveTo(f15, f16);
                                f13 = f15;
                                f12 = f16;
                                f11 = f15;
                                intValue = i == 109 ? 108 : 76;
                                f14 = f16;
                                break;
                            }
                        case 81:
                        case 113:
                            f15 = eVar.nextFloat();
                            f16 = eVar.bj(f15);
                            float bj9 = eVar.bj(f16);
                            float bj10 = eVar.bj(bj9);
                            if (Float.isNaN(bj10)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 113) {
                                    bj10 += f19;
                                    f15 += f20;
                                    f16 += f19;
                                    f = bj9 + f20;
                                } else {
                                    f = bj9;
                                }
                                uVar.l(f15, f16, f, bj10);
                                f12 = bj10;
                                f11 = f;
                                intValue = i;
                                f13 = f18;
                                f14 = f17;
                                break;
                            }
                        case 83:
                        case 115:
                            float f27 = (2.0f * f20) - f21;
                            float f28 = (2.0f * f19) - f22;
                            float nextFloat4 = eVar.nextFloat();
                            float bj11 = eVar.bj(nextFloat4);
                            float bj12 = eVar.bj(bj11);
                            float bj13 = eVar.bj(bj12);
                            if (Float.isNaN(bj13)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 115) {
                                    float f29 = bj13 + f19;
                                    f2 = f19 + bj11;
                                    f4 = f20 + nextFloat4;
                                    f5 = f29;
                                    f3 = bj12 + f20;
                                } else {
                                    f2 = bj11;
                                    f3 = bj12;
                                    f4 = nextFloat4;
                                    f5 = bj13;
                                }
                                uVar.b(f27, f28, f4, f2, f3, f5);
                                f16 = f2;
                                f15 = f4;
                                intValue = i;
                                f13 = f18;
                                f14 = f17;
                                float f30 = f3;
                                f12 = f5;
                                f11 = f30;
                                break;
                            }
                        case 84:
                        case 116:
                            float f31 = (2.0f * f20) - f21;
                            float f32 = (2.0f * f19) - f22;
                            float nextFloat5 = eVar.nextFloat();
                            float bj14 = eVar.bj(nextFloat5);
                            if (Float.isNaN(bj14)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 116) {
                                    nextFloat5 += f20;
                                    bj14 += f19;
                                }
                                uVar.l(f31, f32, nextFloat5, bj14);
                                f13 = f18;
                                f12 = bj14;
                                f11 = nextFloat5;
                                f16 = f32;
                                f15 = f31;
                                f14 = f17;
                                intValue = i;
                                break;
                            }
                        case 86:
                        case 118:
                            float nextFloat6 = eVar.nextFloat();
                            if (Float.isNaN(nextFloat6)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 118) {
                                    nextFloat6 += f19;
                                }
                                uVar.B(f20, nextFloat6);
                                f14 = f17;
                                f13 = f18;
                                f11 = f20;
                                intValue = i;
                                f12 = nextFloat6;
                                float f33 = nextFloat6;
                                f15 = f21;
                                f16 = f33;
                                break;
                            }
                        case 90:
                        case 122:
                            uVar.close();
                            f16 = f17;
                            f15 = f18;
                            f14 = f17;
                            f13 = f18;
                            f12 = f17;
                            f11 = f18;
                            intValue = i;
                            break;
                    }
                    eVar.dhO();
                    if (!eVar.dhM()) {
                        if (eVar.dhX()) {
                            intValue = eVar.dhQ().intValue();
                        }
                    }
                }
            }
        }
        return uVar;
    }

    private static Set<String> Oj(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dhM()) {
            String nextToken = eVar.nextToken();
            if (nextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(nextToken.substring("http://www.w3.org/TR/SVG11/feature#".length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            eVar.dhN();
        }
        return hashSet;
    }

    private static Set<String> Ok(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dhM()) {
            String nextToken = eVar.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            eVar.dhN();
        }
        return hashSet;
    }

    private static Set<String> Ol(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dhM()) {
            hashSet.add(eVar.nextToken());
            eVar.dhN();
        }
        return hashSet;
    }

    private static String eZ(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (!str.startsWith("url(") || !str.endsWith(")")) {
            throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
        }
        return str.substring(4, str.length() - 1).trim();
    }

    private void B(Attributes attributes) throws SAXException {
        boolean z;
        debug("<style>", new Object[0]);
        if (this.lFn == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        int i = 0;
        boolean z2 = true;
        String str = SchemeCollecter.CLASSIFY_ALL;
        while (i < attributes.getLength()) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case type:
                    z = trim.equals("text/css");
                    break;
                case media:
                    str = trim;
                    z = z2;
                    break;
                default:
                    z = z2;
                    break;
            }
            i++;
            z2 = z;
        }
        if (z2 && CSSParser.a(str, CSSParser.MediaType.screen)) {
            this.lFt = true;
            return;
        }
        this.lFo = true;
        this.lFp = 1;
    }

    private void Om(String str) throws SAXException {
        this.lFm.b(new CSSParser(CSSParser.MediaType.screen).NA(str));
    }
}
