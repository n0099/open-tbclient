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
/* loaded from: classes12.dex */
public class SVGParser extends DefaultHandler2 {
    private int lHU;
    private SVG lHR = null;
    private SVG.ag lHS = null;
    private boolean lHT = false;
    private boolean lHV = false;
    private SVGElem lHW = null;
    private StringBuilder lHX = null;
    private boolean lHY = false;
    private StringBuilder lHZ = null;
    private Set<String> lIa = null;

    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public static class b {
        private static final Map<String, Integer> lIe = new HashMap(47);

        static {
            lIe.put("aliceblue", 15792383);
            lIe.put("antiquewhite", 16444375);
            lIe.put("aqua", 65535);
            lIe.put("aquamarine", 8388564);
            lIe.put("azure", 15794175);
            lIe.put("beige", 16119260);
            lIe.put("bisque", 16770244);
            lIe.put("black", 0);
            lIe.put("blanchedalmond", 16772045);
            lIe.put("blue", 255);
            lIe.put("blueviolet", 9055202);
            lIe.put("brown", 10824234);
            lIe.put("burlywood", 14596231);
            lIe.put("cadetblue", 6266528);
            lIe.put("chartreuse", 8388352);
            lIe.put("chocolate", 13789470);
            lIe.put("coral", 16744272);
            lIe.put("cornflowerblue", 6591981);
            lIe.put("cornsilk", 16775388);
            lIe.put("crimson", 14423100);
            lIe.put("cyan", 65535);
            lIe.put("darkblue", 139);
            lIe.put("darkcyan", 35723);
            lIe.put("darkgoldenrod", 12092939);
            lIe.put("darkgray", 11119017);
            lIe.put("darkgreen", 25600);
            lIe.put("darkgrey", 11119017);
            lIe.put("darkkhaki", 12433259);
            lIe.put("darkmagenta", 9109643);
            lIe.put("darkolivegreen", 5597999);
            lIe.put("darkorange", 16747520);
            lIe.put("darkorchid", 10040012);
            lIe.put("darkred", 9109504);
            lIe.put("darksalmon", 15308410);
            lIe.put("darkseagreen", 9419919);
            lIe.put("darkslateblue", 4734347);
            lIe.put("darkslategray", 3100495);
            lIe.put("darkslategrey", 3100495);
            lIe.put("darkturquoise", 52945);
            lIe.put("darkviolet", 9699539);
            lIe.put("deeppink", 16716947);
            lIe.put("deepskyblue", 49151);
            lIe.put("dimgray", 6908265);
            lIe.put("dimgrey", 6908265);
            lIe.put("dodgerblue", 2003199);
            lIe.put("firebrick", 11674146);
            lIe.put("floralwhite", 16775920);
            lIe.put("forestgreen", 2263842);
            lIe.put("fuchsia", 16711935);
            lIe.put("gainsboro", 14474460);
            lIe.put("ghostwhite", 16316671);
            lIe.put("gold", 16766720);
            lIe.put("goldenrod", 14329120);
            lIe.put(com.baidu.fsg.face.base.b.c.m, 8421504);
            lIe.put("green", 32768);
            lIe.put("greenyellow", 11403055);
            lIe.put("grey", 8421504);
            lIe.put("honeydew", 15794160);
            lIe.put("hotpink", 16738740);
            lIe.put("indianred", 13458524);
            lIe.put("indigo", 4915330);
            lIe.put("ivory", 16777200);
            lIe.put("khaki", 15787660);
            lIe.put("lavender", 15132410);
            lIe.put("lavenderblush", 16773365);
            lIe.put("lawngreen", 8190976);
            lIe.put("lemonchiffon", 16775885);
            lIe.put("lightblue", 11393254);
            lIe.put("lightcoral", 15761536);
            lIe.put("lightcyan", 14745599);
            lIe.put("lightgoldenrodyellow", 16448210);
            lIe.put("lightgray", 13882323);
            lIe.put("lightgreen", 9498256);
            lIe.put("lightgrey", 13882323);
            lIe.put("lightpink", 16758465);
            lIe.put("lightsalmon", 16752762);
            lIe.put("lightseagreen", 2142890);
            lIe.put("lightskyblue", 8900346);
            lIe.put("lightslategray", 7833753);
            lIe.put("lightslategrey", 7833753);
            lIe.put("lightsteelblue", 11584734);
            lIe.put("lightyellow", 16777184);
            lIe.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            lIe.put("limegreen", 3329330);
            lIe.put("linen", 16445670);
            lIe.put("magenta", 16711935);
            lIe.put("maroon", 8388608);
            lIe.put("mediumaquamarine", 6737322);
            lIe.put("mediumblue", 205);
            lIe.put("mediumorchid", 12211667);
            lIe.put("mediumpurple", 9662683);
            lIe.put("mediumseagreen", 3978097);
            lIe.put("mediumslateblue", 8087790);
            lIe.put("mediumspringgreen", 64154);
            lIe.put("mediumturquoise", 4772300);
            lIe.put("mediumvioletred", 13047173);
            lIe.put("midnightblue", 1644912);
            lIe.put("mintcream", 16121850);
            lIe.put("mistyrose", 16770273);
            lIe.put("moccasin", 16770229);
            lIe.put("navajowhite", 16768685);
            lIe.put("navy", 128);
            lIe.put("oldlace", 16643558);
            lIe.put("olive", 8421376);
            lIe.put("olivedrab", 7048739);
            lIe.put("orange", 16753920);
            lIe.put("orangered", 16729344);
            lIe.put("orchid", 14315734);
            lIe.put("palegoldenrod", 15657130);
            lIe.put("palegreen", 10025880);
            lIe.put("paleturquoise", 11529966);
            lIe.put("palevioletred", 14381203);
            lIe.put("papayawhip", 16773077);
            lIe.put("peachpuff", 16767673);
            lIe.put("peru", 13468991);
            lIe.put("pink", 16761035);
            lIe.put("plum", 14524637);
            lIe.put("powderblue", 11591910);
            lIe.put("purple", 8388736);
            lIe.put("red", 16711680);
            lIe.put("rosybrown", 12357519);
            lIe.put("royalblue", 4286945);
            lIe.put("saddlebrown", 9127187);
            lIe.put("salmon", 16416882);
            lIe.put("sandybrown", 16032864);
            lIe.put("seagreen", 3050327);
            lIe.put("seashell", 16774638);
            lIe.put("sienna", 10506797);
            lIe.put("silver", 12632256);
            lIe.put("skyblue", 8900331);
            lIe.put("slateblue", 6970061);
            lIe.put("slategray", 7372944);
            lIe.put("slategrey", 7372944);
            lIe.put("snow", 16775930);
            lIe.put("springgreen", 65407);
            lIe.put("steelblue", 4620980);
            lIe.put("tan", 13808780);
            lIe.put("teal", 32896);
            lIe.put("thistle", 14204888);
            lIe.put("tomato", 16737095);
            lIe.put("turquoise", 4251856);
            lIe.put("violet", 15631086);
            lIe.put("wheat", 16113331);
            lIe.put("white", 16777215);
            lIe.put("whitesmoke", 16119285);
            lIe.put("yellow", 16776960);
            lIe.put("yellowgreen", 10145074);
        }

        public static Integer OA(String str) {
            return lIe.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c {
        private static final Map<String, SVG.n> lIf = new HashMap(9);

        static {
            lIf.put("xx-small", new SVG.n(0.694f, SVG.Unit.pt));
            lIf.put("x-small", new SVG.n(0.833f, SVG.Unit.pt));
            lIf.put("small", new SVG.n(10.0f, SVG.Unit.pt));
            lIf.put("medium", new SVG.n(12.0f, SVG.Unit.pt));
            lIf.put("large", new SVG.n(14.4f, SVG.Unit.pt));
            lIf.put("x-large", new SVG.n(17.3f, SVG.Unit.pt));
            lIf.put("xx-large", new SVG.n(20.7f, SVG.Unit.pt));
            lIf.put("smaller", new SVG.n(83.33f, SVG.Unit.percent));
            lIf.put("larger", new SVG.n(120.0f, SVG.Unit.percent));
        }

        public static SVG.n OB(String str) {
            return lIf.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class d {
        private static final Map<String, Integer> lIg = new HashMap(13);

        static {
            lIg.put("normal", 400);
            lIg.put("bold", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lIg.put("bolder", 1);
            lIg.put("lighter", -1);
            lIg.put("100", 100);
            lIg.put(BasicPushStatus.SUCCESS_CODE, 200);
            lIg.put("300", 300);
            lIg.put("400", 400);
            lIg.put("500", 500);
            lIg.put("600", Integer.valueOf((int) Constants.HTTP_DNS_INAVAILABLE_TIME));
            lIg.put("700", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lIg.put("800", 800);
            lIg.put("900", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
        }

        public static Integer OA(String str) {
            return lIg.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a {
        private static final Map<String, PreserveAspectRatio.Alignment> lId = new HashMap(10);

        static {
            lId.put("none", PreserveAspectRatio.Alignment.None);
            lId.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            lId.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            lId.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            lId.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            lId.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            lId.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            lId.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            lId.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            lId.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment Oz(String str) {
            return lId.get(str);
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
                    return this.lHR;
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
        this.lHR = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.lHT) {
            this.lHU++;
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
                    this.lHV = true;
                    this.lHW = fromString;
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
                    this.lHT = true;
                    this.lHU = 1;
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lHT) {
            if (this.lHV) {
                if (this.lHX == null) {
                    this.lHX = new StringBuilder(i2);
                }
                this.lHX.append(cArr, i, i2);
            } else if (this.lHY) {
                if (this.lHZ == null) {
                    this.lHZ = new StringBuilder(i2);
                }
                this.lHZ.append(cArr, i, i2);
            } else if (this.lHS instanceof SVG.av) {
                SVG.ae aeVar = (SVG.ae) this.lHS;
                int size = aeVar.UM.size();
                SVG.ak akVar = size == 0 ? null : aeVar.UM.get(size - 1);
                if (akVar instanceof SVG.az) {
                    SVG.az azVar = (SVG.az) akVar;
                    azVar.text += new String(cArr, i, i2);
                    return;
                }
                ((SVG.ae) this.lHS).a(new SVG.az(new String(cArr, i, i2)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lHT && this.lHY) {
            if (this.lHZ == null) {
                this.lHZ = new StringBuilder(i2);
            }
            this.lHZ.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.lHT) {
            int i = this.lHU - 1;
            this.lHU = i;
            if (i == 0) {
                this.lHT = false;
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
                    this.lHS = ((SVG.ak) this.lHS).lHd;
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
                    this.lHV = false;
                    if (this.lHW == SVGElem.title) {
                        this.lHR.setTitle(this.lHX.toString());
                    } else if (this.lHW == SVGElem.desc) {
                        this.lHR.setDesc(this.lHX.toString());
                    }
                    this.lHX.setLength(0);
                    return;
                case style:
                    if (this.lHZ != null) {
                        this.lHY = false;
                        Oy(this.lHZ.toString());
                        this.lHZ.setLength(0);
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
        acVar.lHc = this.lHR;
        acVar.lHd = this.lHS;
        a((SVG.ai) acVar, attributes);
        b(acVar, attributes);
        a((SVG.ad) acVar, attributes);
        a((SVG.ao) acVar, attributes);
        a(acVar, attributes);
        if (this.lHS == null) {
            this.lHR.a(acVar);
        } else {
            this.lHS.a(acVar);
        }
        this.lHS = acVar;
    }

    private void a(SVG.ac acVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    acVar.lFG = NY(trim);
                    break;
                case y:
                    acVar.lFH = NY(trim);
                    break;
                case width:
                    acVar.lFI = NY(trim);
                    if (acVar.lFI.diY()) {
                        throw new SAXException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    acVar.lFJ = NY(trim);
                    if (acVar.lFJ.diY()) {
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
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.k kVar = new SVG.k();
        kVar.lHc = this.lHR;
        kVar.lHd = this.lHS;
        a((SVG.ai) kVar, attributes);
        b(kVar, attributes);
        a((SVG.l) kVar, attributes);
        a((SVG.ad) kVar, attributes);
        this.lHS.a(kVar);
        this.lHS = kVar;
    }

    private void c(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.g gVar = new SVG.g();
        gVar.lHc = this.lHR;
        gVar.lHd = this.lHS;
        a((SVG.ai) gVar, attributes);
        b(gVar, attributes);
        a((SVG.l) gVar, attributes);
        this.lHS.a(gVar);
        this.lHS = gVar;
    }

    private void d(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ba baVar = new SVG.ba();
        baVar.lHc = this.lHR;
        baVar.lHd = this.lHS;
        a((SVG.ai) baVar, attributes);
        b(baVar, attributes);
        a((SVG.l) baVar, attributes);
        a((SVG.ad) baVar, attributes);
        a(baVar, attributes);
        this.lHS.a(baVar);
        this.lHS = baVar;
    }

    private void a(SVG.ba baVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    baVar.lFG = NY(trim);
                    break;
                case y:
                    baVar.lFH = NY(trim);
                    break;
                case width:
                    baVar.lFI = NY(trim);
                    if (baVar.lFI.diY()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    baVar.lFJ = NY(trim);
                    if (baVar.lFJ.diY()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        baVar.Tv = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void e(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.m mVar = new SVG.m();
        mVar.lHc = this.lHR;
        mVar.lHd = this.lHS;
        a((SVG.ai) mVar, attributes);
        b(mVar, attributes);
        a((SVG.l) mVar, attributes);
        a((SVG.ad) mVar, attributes);
        a(mVar, attributes);
        this.lHS.a(mVar);
        this.lHS = mVar;
    }

    private void a(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    mVar.lFG = NY(trim);
                    break;
                case y:
                    mVar.lFH = NY(trim);
                    break;
                case width:
                    mVar.lFI = NY(trim);
                    if (mVar.lFI.diY()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    mVar.lFJ = NY(trim);
                    if (mVar.lFJ.diY()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        mVar.Tv = trim;
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
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.t tVar = new SVG.t();
        tVar.lHc = this.lHR;
        tVar.lHd = this.lHS;
        a((SVG.ai) tVar, attributes);
        b(tVar, attributes);
        a((SVG.l) tVar, attributes);
        a((SVG.ad) tVar, attributes);
        a(tVar, attributes);
        this.lHS.a(tVar);
    }

    private void a(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    tVar.lFY = Ou(trim);
                    break;
                case pathLength:
                    tVar.lFZ = Float.valueOf(parseFloat(trim));
                    if (tVar.lFZ.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.z zVar = new SVG.z();
        zVar.lHc = this.lHR;
        zVar.lHd = this.lHS;
        a((SVG.ai) zVar, attributes);
        b(zVar, attributes);
        a((SVG.l) zVar, attributes);
        a((SVG.ad) zVar, attributes);
        a(zVar, attributes);
        this.lHS.a(zVar);
    }

    private void a(SVG.z zVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    zVar.lFG = NY(trim);
                    break;
                case y:
                    zVar.lFH = NY(trim);
                    break;
                case width:
                    zVar.lFI = NY(trim);
                    if (zVar.lFI.diY()) {
                        throw new SAXException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    zVar.lFJ = NY(trim);
                    if (zVar.lFJ.diY()) {
                        throw new SAXException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    zVar.lFA = NY(trim);
                    if (zVar.lFA.diY()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    zVar.lFB = NY(trim);
                    if (zVar.lFB.diY()) {
                        throw new SAXException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    private void h(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.c cVar = new SVG.c();
        cVar.lHc = this.lHR;
        cVar.lHd = this.lHS;
        a((SVG.ai) cVar, attributes);
        b(cVar, attributes);
        a((SVG.l) cVar, attributes);
        a((SVG.ad) cVar, attributes);
        a(cVar, attributes);
        this.lHS.a(cVar);
    }

    private void a(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    cVar.lFt = NY(trim);
                    break;
                case cy:
                    cVar.lFu = NY(trim);
                    break;
                case r:
                    cVar.lFv = NY(trim);
                    if (cVar.lFv.diY()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void i(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.h hVar = new SVG.h();
        hVar.lHc = this.lHR;
        hVar.lHd = this.lHS;
        a((SVG.ai) hVar, attributes);
        b(hVar, attributes);
        a((SVG.l) hVar, attributes);
        a((SVG.ad) hVar, attributes);
        a(hVar, attributes);
        this.lHS.a(hVar);
    }

    private void a(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    hVar.lFA = NY(trim);
                    if (hVar.lFA.diY()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.lFB = NY(trim);
                    if (hVar.lFB.diY()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.lFt = NY(trim);
                    break;
                case cy:
                    hVar.lFu = NY(trim);
                    break;
            }
        }
    }

    private void j(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.o oVar = new SVG.o();
        oVar.lHc = this.lHR;
        oVar.lHd = this.lHS;
        a((SVG.ai) oVar, attributes);
        b(oVar, attributes);
        a((SVG.l) oVar, attributes);
        a((SVG.ad) oVar, attributes);
        a(oVar, attributes);
        this.lHS.a(oVar);
    }

    private void a(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    oVar.lFL = NY(trim);
                    break;
                case y1:
                    oVar.lFM = NY(trim);
                    break;
                case x2:
                    oVar.lFN = NY(trim);
                    break;
                case y2:
                    oVar.lFO = NY(trim);
                    break;
            }
        }
    }

    private void k(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.x xVar = new SVG.x();
        xVar.lHc = this.lHR;
        xVar.lHd = this.lHS;
        a((SVG.ai) xVar, attributes);
        b(xVar, attributes);
        a((SVG.l) xVar, attributes);
        a((SVG.ad) xVar, attributes);
        a(xVar, attributes, "polyline");
        this.lHS.a(xVar);
    }

    private void a(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                e eVar = new e(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                eVar.skipWhitespace();
                while (!eVar.djC()) {
                    float nextFloat = eVar.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    eVar.djD();
                    float nextFloat2 = eVar.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    eVar.djD();
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
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.y yVar = new SVG.y();
        yVar.lHc = this.lHR;
        yVar.lHd = this.lHS;
        a((SVG.ai) yVar, attributes);
        b(yVar, attributes);
        a((SVG.l) yVar, attributes);
        a((SVG.ad) yVar, attributes);
        a(yVar, attributes, "polygon");
        this.lHS.a(yVar);
    }

    private void m(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.at atVar = new SVG.at();
        atVar.lHc = this.lHR;
        atVar.lHd = this.lHS;
        a((SVG.ai) atVar, attributes);
        b(atVar, attributes);
        a((SVG.l) atVar, attributes);
        a((SVG.ad) atVar, attributes);
        a((SVG.ax) atVar, attributes);
        this.lHS.a(atVar);
        this.lHS = atVar;
    }

    private void a(SVG.ax axVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    axVar.x = NZ(trim);
                    break;
                case y:
                    axVar.y = NZ(trim);
                    break;
                case dx:
                    axVar.lHk = NZ(trim);
                    break;
                case dy:
                    axVar.lHl = NZ(trim);
                    break;
            }
        }
    }

    private void n(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lHS instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.as asVar = new SVG.as();
        asVar.lHc = this.lHR;
        asVar.lHd = this.lHS;
        a((SVG.ai) asVar, attributes);
        b(asVar, attributes);
        a((SVG.ad) asVar, attributes);
        a((SVG.ax) asVar, attributes);
        this.lHS.a(asVar);
        this.lHS = asVar;
        if (asVar.lHd instanceof SVG.ay) {
            asVar.a((SVG.ay) asVar.lHd);
        } else {
            asVar.a(((SVG.au) asVar.lHd).djf());
        }
    }

    private void o(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lHS instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.ar arVar = new SVG.ar();
        arVar.lHc = this.lHR;
        arVar.lHd = this.lHS;
        a((SVG.ai) arVar, attributes);
        b(arVar, attributes);
        a((SVG.ad) arVar, attributes);
        a(arVar, attributes);
        this.lHS.a(arVar);
        if (arVar.lHd instanceof SVG.ay) {
            arVar.a((SVG.ay) arVar.lHd);
        } else {
            arVar.a(((SVG.au) arVar.lHd).djf());
        }
    }

    private void a(SVG.ar arVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        arVar.Tv = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void p(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ap apVar = new SVG.ap();
        apVar.lHc = this.lHR;
        apVar.lHd = this.lHS;
        a((SVG.ai) apVar, attributes);
        b(apVar, attributes);
        a((SVG.l) apVar, attributes);
        a((SVG.ad) apVar, attributes);
        this.lHS.a(apVar);
        this.lHS = apVar;
    }

    private void a(SVG.ad adVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    adVar.i(Ov(trim));
                    break;
                case requiredExtensions:
                    adVar.NR(trim);
                    break;
                case systemLanguage:
                    adVar.j(Ow(trim));
                    break;
                case requiredFormats:
                    adVar.k(Ox(trim));
                    break;
                case requiredFonts:
                    List<String> Of = Of(trim);
                    adVar.l(Of != null ? new HashSet(Of) : new HashSet(0));
                    break;
            }
        }
    }

    private void q(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aq aqVar = new SVG.aq();
        aqVar.lHc = this.lHR;
        aqVar.lHd = this.lHS;
        a((SVG.ai) aqVar, attributes);
        b(aqVar, attributes);
        a((SVG.ad) aqVar, attributes);
        a((SVG.ao) aqVar, attributes);
        this.lHS.a(aqVar);
        this.lHS = aqVar;
    }

    private void r(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.p pVar = new SVG.p();
        pVar.lHc = this.lHR;
        pVar.lHd = this.lHS;
        a((SVG.ai) pVar, attributes);
        b(pVar, attributes);
        a((SVG.ad) pVar, attributes);
        a((SVG.ao) pVar, attributes);
        a(pVar, attributes);
        this.lHS.a(pVar);
        this.lHS = pVar;
    }

    private void a(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    pVar.lFQ = NY(trim);
                    break;
                case refY:
                    pVar.lFR = NY(trim);
                    break;
                case markerWidth:
                    pVar.lFS = NY(trim);
                    if (pVar.lFS.diY()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    pVar.lFT = NY(trim);
                    if (pVar.lFT.diY()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        pVar.lFP = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        pVar.lFP = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        pVar.lFU = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        pVar.lFU = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void s(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aj ajVar = new SVG.aj();
        ajVar.lHc = this.lHR;
        ajVar.lHd = this.lHS;
        a((SVG.ai) ajVar, attributes);
        b(ajVar, attributes);
        a((SVG.i) ajVar, attributes);
        a(ajVar, attributes);
        this.lHS.a(ajVar);
        this.lHS = ajVar;
    }

    private void a(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        iVar.Tv = trim;
                        break;
                    } else {
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        iVar.lFC = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.lFC = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.lFD = NX(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.lFE = SVG.GradientSpread.valueOf(trim);
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
                    ajVar.lFL = NY(trim);
                    break;
                case y1:
                    ajVar.lFM = NY(trim);
                    break;
                case x2:
                    ajVar.lFN = NY(trim);
                    break;
                case y2:
                    ajVar.lFO = NY(trim);
                    break;
            }
        }
    }

    private void t(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.an anVar = new SVG.an();
        anVar.lHc = this.lHR;
        anVar.lHd = this.lHS;
        a((SVG.ai) anVar, attributes);
        b(anVar, attributes);
        a((SVG.i) anVar, attributes);
        a(anVar, attributes);
        this.lHS.a(anVar);
        this.lHS = anVar;
    }

    private void a(SVG.an anVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    anVar.lFt = NY(trim);
                    break;
                case cy:
                    anVar.lFu = NY(trim);
                    break;
                case r:
                    anVar.lFv = NY(trim);
                    if (anVar.lFv.diY()) {
                        throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    anVar.lHf = NY(trim);
                    break;
                case fy:
                    anVar.lHg = NY(trim);
                    break;
            }
        }
    }

    private void u(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lHS instanceof SVG.i)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.ab abVar = new SVG.ab();
        abVar.lHc = this.lHR;
        abVar.lHd = this.lHS;
        a((SVG.ai) abVar, attributes);
        b(abVar, attributes);
        a(abVar, attributes);
        this.lHS.a(abVar);
        this.lHS = abVar;
    }

    private void a(SVG.ab abVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    abVar.lGh = NW(trim);
                    break;
            }
        }
    }

    private Float NW(String str) throws SAXException {
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
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aa aaVar = new SVG.aa();
        aaVar.lHc = this.lHR;
        aaVar.lHd = this.lHS;
        a(aaVar, attributes);
        b(aaVar, attributes);
        this.lHS.a(aaVar);
        this.lHS = aaVar;
    }

    private void w(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.d dVar = new SVG.d();
        dVar.lHc = this.lHR;
        dVar.lHd = this.lHS;
        a((SVG.ai) dVar, attributes);
        b(dVar, attributes);
        a((SVG.l) dVar, attributes);
        a((SVG.ad) dVar, attributes);
        a(dVar, attributes);
        this.lHS.a(dVar);
        this.lHS = dVar;
    }

    private void a(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.lFw = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.lFw = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    private void x(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aw awVar = new SVG.aw();
        awVar.lHc = this.lHR;
        awVar.lHd = this.lHS;
        a((SVG.ai) awVar, attributes);
        b(awVar, attributes);
        a((SVG.ad) awVar, attributes);
        a(awVar, attributes);
        this.lHS.a(awVar);
        this.lHS = awVar;
        if (awVar.lHd instanceof SVG.ay) {
            awVar.a((SVG.ay) awVar.lHd);
        } else {
            awVar.a(((SVG.au) awVar.lHd).djf());
        }
    }

    private void a(SVG.aw awVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        awVar.Tv = trim;
                        break;
                    } else {
                        break;
                    }
                case startOffset:
                    awVar.lHj = NY(trim);
                    break;
            }
        }
    }

    private void y(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.w wVar = new SVG.w();
        wVar.lHc = this.lHR;
        wVar.lHd = this.lHS;
        a((SVG.ai) wVar, attributes);
        b(wVar, attributes);
        a((SVG.ad) wVar, attributes);
        a((SVG.ao) wVar, attributes);
        a(wVar, attributes);
        this.lHS.a(wVar);
        this.lHS = wVar;
    }

    private void a(SVG.w wVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    wVar.lFG = NY(trim);
                    break;
                case y:
                    wVar.lFH = NY(trim);
                    break;
                case width:
                    wVar.lFI = NY(trim);
                    if (wVar.lFI.diY()) {
                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    wVar.lFJ = NY(trim);
                    if (wVar.lFJ.diY()) {
                        throw new SAXException("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        wVar.Tv = trim;
                        break;
                    } else {
                        break;
                    }
                case patternUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lGe = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lGe = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lGf = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lGf = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    wVar.lGg = NX(trim);
                    break;
            }
        }
    }

    private void z(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.bb bbVar = new SVG.bb();
        bbVar.lHc = this.lHR;
        bbVar.lHd = this.lHS;
        a((SVG.ai) bbVar, attributes);
        a((SVG.ad) bbVar, attributes);
        a((SVG.ao) bbVar, attributes);
        this.lHS.a(bbVar);
        this.lHS = bbVar;
    }

    private void A(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.lHS == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.q qVar = new SVG.q();
        qVar.lHc = this.lHR;
        qVar.lHd = this.lHS;
        a((SVG.ai) qVar, attributes);
        b(qVar, attributes);
        a((SVG.ad) qVar, attributes);
        a(qVar, attributes);
        this.lHS.a(qVar);
        this.lHS = qVar;
    }

    private void a(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    qVar.lFG = NY(trim);
                    break;
                case y:
                    qVar.lFH = NY(trim);
                    break;
                case width:
                    qVar.lFI = NY(trim);
                    if (qVar.lFI.diY()) {
                        throw new SAXException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    qVar.lFJ = NY(trim);
                    if (qVar.lFJ.diY()) {
                        throw new SAXException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lFV = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lFV = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lFW = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lFW = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskContentUnits");
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public static class e {
        protected String lIh;
        protected int lIi;
        protected int position = 0;
        private com.caverock.androidsvg.b lIj = new com.caverock.androidsvg.b();

        public e(String str) {
            this.lIi = 0;
            this.lIh = str.trim();
            this.lIi = this.lIh.length();
        }

        public boolean djC() {
            return this.position == this.lIi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Ho(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public void skipWhitespace() {
            while (this.position < this.lIi && Ho(this.lIh.charAt(this.position))) {
                this.position++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hp(int i) {
            return i == 10 || i == 13;
        }

        public boolean djD() {
            skipWhitespace();
            if (this.position != this.lIi && this.lIh.charAt(this.position) == ',') {
                this.position++;
                skipWhitespace();
                return true;
            }
            return false;
        }

        public float nextFloat() {
            float B = this.lIj.B(this.lIh, this.position, this.lIi);
            if (!Float.isNaN(B)) {
                this.position = this.lIj.diN();
            }
            return B;
        }

        public float djE() {
            djD();
            float B = this.lIj.B(this.lIh, this.position, this.lIi);
            if (!Float.isNaN(B)) {
                this.position = this.lIj.diN();
            }
            return B;
        }

        public float bi(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            djD();
            return nextFloat();
        }

        public Integer djF() {
            if (this.position == this.lIi) {
                return null;
            }
            String str = this.lIh;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.n djG() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit djL = djL();
            if (djL == null) {
                return new SVG.n(nextFloat, SVG.Unit.px);
            }
            return new SVG.n(nextFloat, djL);
        }

        public Boolean djH() {
            if (this.position == this.lIi) {
                return null;
            }
            char charAt = this.lIh.charAt(this.position);
            if (charAt == '0' || charAt == '1') {
                this.position++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        public Boolean aL(Object obj) {
            if (obj == null) {
                return null;
            }
            djD();
            return djH();
        }

        public boolean g(char c) {
            boolean z = this.position < this.lIi && this.lIh.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        public boolean OC(String str) {
            int length = str.length();
            boolean z = this.position <= this.lIi - length && this.lIh.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int djI() {
            if (this.position == this.lIi) {
                return -1;
            }
            this.position++;
            if (this.position < this.lIi) {
                return this.lIh.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return h(' ');
        }

        public String h(char c) {
            if (djC()) {
                return null;
            }
            char charAt = this.lIh.charAt(this.position);
            if (Ho(charAt) || charAt == c) {
                return null;
            }
            int i = this.position;
            int djI = djI();
            while (djI != -1 && djI != c && !Ho(djI)) {
                djI = djI();
            }
            return this.lIh.substring(i, this.position);
        }

        public String djJ() {
            if (djC()) {
                return null;
            }
            int i = this.position;
            int charAt = this.lIh.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = djI();
            }
            int i2 = this.position;
            while (Ho(charAt)) {
                charAt = djI();
            }
            if (charAt == 40) {
                this.position++;
                return this.lIh.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        public String djK() {
            int i = this.position;
            while (!djC() && !Ho(this.lIh.charAt(this.position))) {
                this.position++;
            }
            String substring = this.lIh.substring(i, this.position);
            this.position = i;
            return substring;
        }

        public SVG.Unit djL() {
            if (djC()) {
                return null;
            }
            if (this.lIh.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            } else if (this.position <= this.lIi - 2) {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.lIh.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                return null;
            }
        }

        public boolean djM() {
            if (this.position == this.lIi) {
                return false;
            }
            char charAt = this.lIh.charAt(this.position);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public String djN() {
            if (djC()) {
                return null;
            }
            int i = this.position;
            char charAt = this.lIh.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                int djI = djI();
                while (djI != -1 && djI != charAt) {
                    djI = djI();
                }
                if (djI == -1) {
                    this.position = i;
                    return null;
                }
                this.position++;
                return this.lIh.substring(i + 1, this.position - 1);
            }
            return null;
        }

        public String djO() {
            if (djC()) {
                return null;
            }
            int i = this.position;
            this.position = this.lIi;
            return this.lIh.substring(i);
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
                    aiVar.lGZ = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    aiVar.lGZ = Boolean.TRUE;
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
                        aiVar.lHb = CSSParser.NN(trim);
                        continue;
                    default:
                        if (aiVar.lHa == null) {
                            aiVar.lHa = new SVG.Style();
                        }
                        a(aiVar.lHa, attributes.getLocalName(i), attributes.getValue(i).trim());
                        continue;
                }
            }
        }
    }

    private static void a(SVG.ai aiVar, String str) throws SAXException {
        e eVar = new e(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String h = eVar.h(':');
            eVar.skipWhitespace();
            if (eVar.g(':')) {
                eVar.skipWhitespace();
                String h2 = eVar.h(';');
                if (h2 != null) {
                    eVar.skipWhitespace();
                    if (eVar.djC() || eVar.g(';')) {
                        if (aiVar.lEL == null) {
                            aiVar.lEL = new SVG.Style();
                        }
                        a(aiVar.lEL, h, h2);
                        eVar.skipWhitespace();
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
                    style.lGj = ff(str2, "fill");
                    style.lGi |= 1;
                    return;
                case fill_rule:
                    style.lGk = Om(str2);
                    style.lGi |= 2;
                    return;
                case fill_opacity:
                    style.lGl = Float.valueOf(Oa(str2));
                    style.lGi |= 4;
                    return;
                case stroke:
                    style.lGm = ff(str2, "stroke");
                    style.lGi |= 8;
                    return;
                case stroke_opacity:
                    style.lGn = Float.valueOf(Oa(str2));
                    style.lGi |= 16;
                    return;
                case stroke_width:
                    style.lGo = NY(str2);
                    style.lGi |= 32;
                    return;
                case stroke_linecap:
                    style.lGp = On(str2);
                    style.lGi |= 64;
                    return;
                case stroke_linejoin:
                    style.lGq = Oo(str2);
                    style.lGi |= 128;
                    return;
                case stroke_miterlimit:
                    style.lGr = Float.valueOf(parseFloat(str2));
                    style.lGi |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.lGs = null;
                    } else {
                        style.lGs = Op(str2);
                    }
                    style.lGi |= 512;
                    return;
                case stroke_dashoffset:
                    style.lGt = NY(str2);
                    style.lGi |= 1024;
                    return;
                case opacity:
                    style.lGu = Float.valueOf(Oa(str2));
                    style.lGi |= 2048;
                    return;
                case color:
                    style.lGv = Od(str2);
                    style.lGi |= 4096;
                    return;
                case font:
                    a(style, str2);
                    return;
                case font_family:
                    style.lGw = Of(str2);
                    style.lGi |= 8192;
                    return;
                case font_size:
                    style.lGx = Og(str2);
                    style.lGi |= 16384;
                    return;
                case font_weight:
                    style.lGy = Oh(str2);
                    style.lGi |= 32768;
                    return;
                case font_style:
                    style.lGz = Oi(str2);
                    style.lGi |= 65536;
                    return;
                case text_decoration:
                    style.lGA = Ok(str2);
                    style.lGi |= 131072;
                    return;
                case direction:
                    style.lGB = Ol(str2);
                    style.lGi |= 68719476736L;
                    return;
                case text_anchor:
                    style.lGC = Oq(str2);
                    style.lGi |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    return;
                case overflow:
                    style.lGD = Or(str2);
                    style.lGi |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case marker:
                    style.lGF = fg(str2, str);
                    style.lGG = style.lGF;
                    style.lGH = style.lGF;
                    style.lGi |= 14680064;
                    return;
                case marker_start:
                    style.lGF = fg(str2, str);
                    style.lGi |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.lGG = fg(str2, str);
                    style.lGi |= ImageUploadStrategy.FILE_SIZE_4M;
                    return;
                case marker_end:
                    style.lGH = fg(str2, str);
                    style.lGi |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    style.lGI = Boolean.valueOf(!str2.equals("none"));
                    style.lGi |= AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH;
                    return;
                case visibility:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|visible|hidden|collapse|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    style.lGJ = Boolean.valueOf(str2.equals("visible"));
                    style.lGi |= 33554432;
                    return;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        style.lGK = SVG.f.diX();
                    } else {
                        style.lGK = Od(str2);
                    }
                    style.lGi |= 67108864;
                    return;
                case stop_opacity:
                    style.lGL = Float.valueOf(Oa(str2));
                    style.lGi |= 134217728;
                    return;
                case clip:
                    style.lGE = Os(str2);
                    style.lGi |= 1048576;
                    return;
                case clip_path:
                    style.clipPath = fg(str2, str);
                    style.lGi |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case clip_rule:
                    style.lGM = Om(str2);
                    style.lGi |= IjkMediaMeta.AV_CH_STEREO_LEFT;
                    return;
                case mask:
                    style.lGN = fg(str2, str);
                    style.lGi |= IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    return;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        style.lGO = SVG.f.diX();
                    } else {
                        style.lGO = Od(str2);
                    }
                    style.lGi |= IjkMediaMeta.AV_CH_WIDE_LEFT;
                    return;
                case solid_opacity:
                    style.lGP = Float.valueOf(Oa(str2));
                    style.lGi |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        style.lGQ = SVG.f.diX();
                    } else {
                        style.lGQ = Od(str2);
                    }
                    style.lGi |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                    return;
                case viewport_fill_opacity:
                    style.lGR = Float.valueOf(Oa(str2));
                    style.lGi |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                    return;
                case vector_effect:
                    style.lGS = Ot(str2);
                    style.lGi |= IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
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
                    aoVar.lHh = Ob(trim);
                    break;
            }
        }
    }

    private void a(SVG.l lVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                lVar.setTransform(NX(attributes.getValue(i)));
            }
        }
    }

    private Matrix NX(String str) throws SAXException {
        Matrix matrix = new Matrix();
        e eVar = new e(str);
        eVar.skipWhitespace();
        while (!eVar.djC()) {
            String djJ = eVar.djJ();
            if (djJ == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (djJ.equals("matrix")) {
                eVar.skipWhitespace();
                float nextFloat = eVar.nextFloat();
                eVar.djD();
                float nextFloat2 = eVar.nextFloat();
                eVar.djD();
                float nextFloat3 = eVar.nextFloat();
                eVar.djD();
                float nextFloat4 = eVar.nextFloat();
                eVar.djD();
                float nextFloat5 = eVar.nextFloat();
                eVar.djD();
                float nextFloat6 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat6) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (djJ.equals("translate")) {
                eVar.skipWhitespace();
                float nextFloat7 = eVar.nextFloat();
                float djE = eVar.djE();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat7) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djE)) {
                    matrix.preTranslate(nextFloat7, 0.0f);
                } else {
                    matrix.preTranslate(nextFloat7, djE);
                }
            } else if (djJ.equals("scale")) {
                eVar.skipWhitespace();
                float nextFloat8 = eVar.nextFloat();
                float djE2 = eVar.djE();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat8) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djE2)) {
                    matrix.preScale(nextFloat8, nextFloat8);
                } else {
                    matrix.preScale(nextFloat8, djE2);
                }
            } else if (djJ.equals(RotateImageAction.ACTION_NAME)) {
                eVar.skipWhitespace();
                float nextFloat9 = eVar.nextFloat();
                float djE3 = eVar.djE();
                float djE4 = eVar.djE();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat9) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djE3)) {
                    matrix.preRotate(nextFloat9);
                } else if (!Float.isNaN(djE4)) {
                    matrix.preRotate(nextFloat9, djE3, djE4);
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (djJ.equals("skewX")) {
                eVar.skipWhitespace();
                float nextFloat10 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat10) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat10)), 0.0f);
            } else if (djJ.equals("skewY")) {
                eVar.skipWhitespace();
                float nextFloat11 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat11) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat11)));
            } else if (djJ != null) {
                throw new SAXException("Invalid transform list fn: " + djJ + ")");
            }
            if (eVar.djC()) {
                break;
            }
            eVar.djD();
        }
        return matrix;
    }

    protected static SVG.n NY(String str) throws SAXException {
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

    private static List<SVG.n> NZ(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e(str);
        eVar.skipWhitespace();
        while (!eVar.djC()) {
            float nextFloat = eVar.nextFloat();
            if (Float.isNaN(nextFloat)) {
                throw new SAXException("Invalid length list value: " + eVar.djK());
            }
            SVG.Unit djL = eVar.djL();
            if (djL == null) {
                djL = SVG.Unit.px;
            }
            arrayList.add(new SVG.n(nextFloat, djL));
            eVar.djD();
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

    private static float Oa(String str) throws SAXException {
        float parseFloat = parseFloat(str);
        if (parseFloat < 0.0f) {
            return 0.0f;
        }
        if (parseFloat > 1.0f) {
            return 1.0f;
        }
        return parseFloat;
    }

    private static SVG.a Ob(String str) throws SAXException {
        e eVar = new e(str);
        eVar.skipWhitespace();
        float nextFloat = eVar.nextFloat();
        eVar.djD();
        float nextFloat2 = eVar.nextFloat();
        eVar.djD();
        float nextFloat3 = eVar.nextFloat();
        eVar.djD();
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
        eVar.skipWhitespace();
        String nextToken = eVar.nextToken();
        if ("defer".equals(nextToken)) {
            eVar.skipWhitespace();
            nextToken = eVar.nextToken();
        }
        PreserveAspectRatio.Alignment Oz = a.Oz(nextToken);
        eVar.skipWhitespace();
        if (eVar.djC()) {
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
        amVar.lHe = new PreserveAspectRatio(Oz, scale);
    }

    private static SVG.al ff(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf == -1) {
                throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
            }
            String trim = str.substring(4, indexOf).trim();
            SVG.al alVar = null;
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim2.length() > 0) {
                alVar = Oc(trim2);
            }
            return new SVG.s(trim, alVar);
        }
        return Oc(str);
    }

    private static SVG.al Oc(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.f.diX();
        }
        return Od(str);
    }

    private static SVG.e Od(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.a A = com.caverock.androidsvg.a.A(str, 1, str.length());
            if (A == null) {
                throw new SAXException("Bad hex colour value: " + str);
            }
            int diN = A.diN();
            if (diN == 7) {
                return new SVG.e(A.value());
            }
            if (diN == 4) {
                int value = A.value();
                int i = value & 3840;
                int i2 = value & 240;
                int i3 = value & 15;
                return new SVG.e((i << 12) | (i << 16) | (i2 << 8) | (i2 << 4) | (i3 << 4) | i3);
            }
            throw new SAXException("Bad hex colour value: " + str);
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            e eVar = new e(str.substring(4));
            eVar.skipWhitespace();
            float nextFloat = eVar.nextFloat();
            if (!Float.isNaN(nextFloat) && eVar.g('%')) {
                nextFloat = (nextFloat * 256.0f) / 100.0f;
            }
            float bi = eVar.bi(nextFloat);
            if (!Float.isNaN(bi) && eVar.g('%')) {
                bi = (bi * 256.0f) / 100.0f;
            }
            float bi2 = eVar.bi(bi);
            if (!Float.isNaN(bi2) && eVar.g('%')) {
                bi2 = (bi2 * 256.0f) / 100.0f;
            }
            eVar.skipWhitespace();
            if (Float.isNaN(bi2) || !eVar.g(')')) {
                throw new SAXException("Bad rgb() colour value: " + str);
            }
            return new SVG.e((bh(nextFloat) << 16) | (bh(bi) << 8) | bh(bi2));
        } else {
            return Oe(str);
        }
    }

    private static int bh(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static SVG.e Oe(String str) throws SAXException {
        Integer OA = b.OA(str.toLowerCase(Locale.US));
        if (OA == null) {
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return new SVG.e(OA.intValue());
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
                eVar.skipWhitespace();
                if (h == null) {
                    throw new SAXException("Invalid font style attribute: missing font size and family");
                }
                if (num != null && fontStyle != null) {
                    break;
                } else if (!h.equals("normal") && (num != null || (num = d.OA(h)) == null)) {
                    if (fontStyle != null || (fontStyle = Oj(h)) == null) {
                        if (str2 != null || !h.equals("small-caps")) {
                            break;
                        }
                        str2 = h;
                    }
                }
            }
            SVG.n Og = Og(h);
            if (eVar.g('/')) {
                eVar.skipWhitespace();
                String nextToken = eVar.nextToken();
                if (nextToken == null) {
                    throw new SAXException("Invalid font style attribute: missing line-height");
                }
                NY(nextToken);
                eVar.skipWhitespace();
            }
            style.lGw = Of(eVar.djO());
            style.lGx = Og;
            style.lGy = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.lGz = fontStyle;
            style.lGi |= 122880;
        }
    }

    private static List<String> Of(String str) throws SAXException {
        ArrayList arrayList = null;
        e eVar = new e(str);
        do {
            String djN = eVar.djN();
            if (djN == null) {
                djN = eVar.h(',');
            }
            if (djN == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(djN);
            eVar.djD();
        } while (!eVar.djC());
        return arrayList;
    }

    private static SVG.n Og(String str) throws SAXException {
        SVG.n OB = c.OB(str);
        if (OB == null) {
            return NY(str);
        }
        return OB;
    }

    private static Integer Oh(String str) throws SAXException {
        Integer OA = d.OA(str);
        if (OA == null) {
            throw new SAXException("Invalid font-weight property: " + str);
        }
        return OA;
    }

    private static SVG.Style.FontStyle Oi(String str) throws SAXException {
        SVG.Style.FontStyle Oj = Oj(str);
        if (Oj != null) {
            return Oj;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static SVG.Style.FontStyle Oj(String str) {
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

    private static SVG.Style.TextDecoration Ok(String str) throws SAXException {
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

    private static SVG.Style.TextDirection Ol(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private static SVG.Style.FillRule Om(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static SVG.Style.LineCaps On(String str) throws SAXException {
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

    private static SVG.Style.LineJoin Oo(String str) throws SAXException {
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

    private static SVG.n[] Op(String str) throws SAXException {
        SVG.n djG;
        e eVar = new e(str);
        eVar.skipWhitespace();
        if (!eVar.djC() && (djG = eVar.djG()) != null) {
            if (djG.diY()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            float floatValue = djG.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(djG);
            while (!eVar.djC()) {
                eVar.djD();
                SVG.n djG2 = eVar.djG();
                if (djG2 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
                if (djG2.diY()) {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                }
                arrayList.add(djG2);
                floatValue += djG2.floatValue();
            }
            if (floatValue == 0.0f) {
                return null;
            }
            return (SVG.n[]) arrayList.toArray(new SVG.n[arrayList.size()]);
        }
        return null;
    }

    private static SVG.Style.TextAnchor Oq(String str) throws SAXException {
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

    private static Boolean Or(String str) throws SAXException {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private static SVG.b Os(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (!str.toLowerCase(Locale.US).startsWith("rect(")) {
            throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
        }
        e eVar = new e(str.substring(5));
        eVar.skipWhitespace();
        SVG.n a2 = a(eVar);
        eVar.djD();
        SVG.n a3 = a(eVar);
        eVar.djD();
        SVG.n a4 = a(eVar);
        eVar.djD();
        SVG.n a5 = a(eVar);
        eVar.skipWhitespace();
        if (!eVar.g(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.b(a2, a3, a4, a5);
    }

    private static SVG.n a(e eVar) {
        return eVar.OC("auto") ? new SVG.n(0.0f) : eVar.djG();
    }

    private static SVG.Style.VectorEffect Ot(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private static SVG.u Ou(String str) throws SAXException {
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
        float djE;
        float bi;
        float f10;
        e eVar = new e(str);
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        SVG.u uVar = new SVG.u();
        if (!eVar.djC() && ((intValue = eVar.djF().intValue()) == 77 || intValue == 109)) {
            while (true) {
                while (true) {
                    float f17 = f14;
                    float f18 = f13;
                    int i = intValue;
                    float f19 = f12;
                    float f20 = f11;
                    float f21 = f15;
                    float f22 = f16;
                    eVar.skipWhitespace();
                    switch (i) {
                        case 65:
                        case 97:
                            float nextFloat = eVar.nextFloat();
                            float bi2 = eVar.bi(nextFloat);
                            float bi3 = eVar.bi(bi2);
                            Boolean aL = eVar.aL(Float.valueOf(bi3));
                            Boolean aL2 = eVar.aL(aL);
                            if (aL2 == null) {
                                bi = Float.NaN;
                                djE = Float.NaN;
                            } else {
                                djE = eVar.djE();
                                bi = eVar.bi(djE);
                            }
                            if (!Float.isNaN(bi) && nextFloat >= 0.0f && bi2 >= 0.0f) {
                                if (i == 97) {
                                    float f23 = f20 + djE;
                                    f10 = bi + f19;
                                    f11 = f23;
                                } else {
                                    float f24 = bi;
                                    f11 = djE;
                                    f10 = f24;
                                }
                                uVar.a(nextFloat, bi2, bi3, aL.booleanValue(), aL2.booleanValue(), f11, f10);
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
                            float bi4 = eVar.bi(nextFloat2);
                            float bi5 = eVar.bi(bi4);
                            float bi6 = eVar.bi(bi5);
                            float bi7 = eVar.bi(bi6);
                            float bi8 = eVar.bi(bi7);
                            if (Float.isNaN(bi8)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 99) {
                                    float f25 = bi8 + f19;
                                    bi4 += f19;
                                    bi5 += f20;
                                    f6 = f19 + bi6;
                                    f8 = nextFloat2 + f20;
                                    f7 = bi7 + f20;
                                    f9 = f25;
                                } else {
                                    f6 = bi6;
                                    f7 = bi7;
                                    f8 = nextFloat2;
                                    f9 = bi8;
                                }
                                uVar.b(f8, bi4, bi5, f6, f7, f9);
                                f16 = f6;
                                f15 = bi5;
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
                            f16 = eVar.bi(f15);
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
                            f16 = eVar.bi(f15);
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
                            f16 = eVar.bi(f15);
                            float bi9 = eVar.bi(f16);
                            float bi10 = eVar.bi(bi9);
                            if (Float.isNaN(bi10)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 113) {
                                    bi10 += f19;
                                    f15 += f20;
                                    f16 += f19;
                                    f = bi9 + f20;
                                } else {
                                    f = bi9;
                                }
                                uVar.l(f15, f16, f, bi10);
                                f12 = bi10;
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
                            float bi11 = eVar.bi(nextFloat4);
                            float bi12 = eVar.bi(bi11);
                            float bi13 = eVar.bi(bi12);
                            if (Float.isNaN(bi13)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 115) {
                                    float f29 = bi13 + f19;
                                    f2 = f19 + bi11;
                                    f4 = f20 + nextFloat4;
                                    f5 = f29;
                                    f3 = bi12 + f20;
                                } else {
                                    f2 = bi11;
                                    f3 = bi12;
                                    f4 = nextFloat4;
                                    f5 = bi13;
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
                            float bi14 = eVar.bi(nextFloat5);
                            if (Float.isNaN(bi14)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 116) {
                                    nextFloat5 += f20;
                                    bi14 += f19;
                                }
                                uVar.l(f31, f32, nextFloat5, bi14);
                                f13 = f18;
                                f12 = bi14;
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
                    eVar.djD();
                    if (!eVar.djC()) {
                        if (eVar.djM()) {
                            intValue = eVar.djF().intValue();
                        }
                    }
                }
            }
        }
        return uVar;
    }

    private static Set<String> Ov(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djC()) {
            String nextToken = eVar.nextToken();
            if (nextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(nextToken.substring("http://www.w3.org/TR/SVG11/feature#".length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            eVar.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> Ow(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djC()) {
            String nextToken = eVar.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            eVar.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> Ox(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djC()) {
            hashSet.add(eVar.nextToken());
            eVar.skipWhitespace();
        }
        return hashSet;
    }

    private static String fg(String str, String str2) throws SAXException {
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
        if (this.lHS == null) {
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
            this.lHY = true;
            return;
        }
        this.lHT = true;
        this.lHU = 1;
    }

    private void Oy(String str) throws SAXException {
        this.lHR.b(new CSSParser(CSSParser.MediaType.screen).NM(str));
    }
}
