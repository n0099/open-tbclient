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
    private int lGb;
    private SVG lFY = null;
    private SVG.ag lFZ = null;
    private boolean lGa = false;
    private boolean lGc = false;
    private SVGElem lGd = null;
    private StringBuilder lGe = null;
    private boolean lGf = false;
    private StringBuilder lGg = null;
    private Set<String> lGh = null;

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
        private static final Map<String, Integer> lGl = new HashMap(47);

        static {
            lGl.put("aliceblue", 15792383);
            lGl.put("antiquewhite", 16444375);
            lGl.put("aqua", 65535);
            lGl.put("aquamarine", 8388564);
            lGl.put("azure", 15794175);
            lGl.put("beige", 16119260);
            lGl.put("bisque", 16770244);
            lGl.put("black", 0);
            lGl.put("blanchedalmond", 16772045);
            lGl.put("blue", 255);
            lGl.put("blueviolet", 9055202);
            lGl.put("brown", 10824234);
            lGl.put("burlywood", 14596231);
            lGl.put("cadetblue", 6266528);
            lGl.put("chartreuse", 8388352);
            lGl.put("chocolate", 13789470);
            lGl.put("coral", 16744272);
            lGl.put("cornflowerblue", 6591981);
            lGl.put("cornsilk", 16775388);
            lGl.put("crimson", 14423100);
            lGl.put("cyan", 65535);
            lGl.put("darkblue", 139);
            lGl.put("darkcyan", 35723);
            lGl.put("darkgoldenrod", 12092939);
            lGl.put("darkgray", 11119017);
            lGl.put("darkgreen", 25600);
            lGl.put("darkgrey", 11119017);
            lGl.put("darkkhaki", 12433259);
            lGl.put("darkmagenta", 9109643);
            lGl.put("darkolivegreen", 5597999);
            lGl.put("darkorange", 16747520);
            lGl.put("darkorchid", 10040012);
            lGl.put("darkred", 9109504);
            lGl.put("darksalmon", 15308410);
            lGl.put("darkseagreen", 9419919);
            lGl.put("darkslateblue", 4734347);
            lGl.put("darkslategray", 3100495);
            lGl.put("darkslategrey", 3100495);
            lGl.put("darkturquoise", 52945);
            lGl.put("darkviolet", 9699539);
            lGl.put("deeppink", 16716947);
            lGl.put("deepskyblue", 49151);
            lGl.put("dimgray", 6908265);
            lGl.put("dimgrey", 6908265);
            lGl.put("dodgerblue", 2003199);
            lGl.put("firebrick", 11674146);
            lGl.put("floralwhite", 16775920);
            lGl.put("forestgreen", 2263842);
            lGl.put("fuchsia", 16711935);
            lGl.put("gainsboro", 14474460);
            lGl.put("ghostwhite", 16316671);
            lGl.put("gold", 16766720);
            lGl.put("goldenrod", 14329120);
            lGl.put(com.baidu.fsg.face.base.b.c.m, 8421504);
            lGl.put("green", 32768);
            lGl.put("greenyellow", 11403055);
            lGl.put("grey", 8421504);
            lGl.put("honeydew", 15794160);
            lGl.put("hotpink", 16738740);
            lGl.put("indianred", 13458524);
            lGl.put("indigo", 4915330);
            lGl.put("ivory", 16777200);
            lGl.put("khaki", 15787660);
            lGl.put("lavender", 15132410);
            lGl.put("lavenderblush", 16773365);
            lGl.put("lawngreen", 8190976);
            lGl.put("lemonchiffon", 16775885);
            lGl.put("lightblue", 11393254);
            lGl.put("lightcoral", 15761536);
            lGl.put("lightcyan", 14745599);
            lGl.put("lightgoldenrodyellow", 16448210);
            lGl.put("lightgray", 13882323);
            lGl.put("lightgreen", 9498256);
            lGl.put("lightgrey", 13882323);
            lGl.put("lightpink", 16758465);
            lGl.put("lightsalmon", 16752762);
            lGl.put("lightseagreen", 2142890);
            lGl.put("lightskyblue", 8900346);
            lGl.put("lightslategray", 7833753);
            lGl.put("lightslategrey", 7833753);
            lGl.put("lightsteelblue", 11584734);
            lGl.put("lightyellow", 16777184);
            lGl.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            lGl.put("limegreen", 3329330);
            lGl.put("linen", 16445670);
            lGl.put("magenta", 16711935);
            lGl.put("maroon", 8388608);
            lGl.put("mediumaquamarine", 6737322);
            lGl.put("mediumblue", 205);
            lGl.put("mediumorchid", 12211667);
            lGl.put("mediumpurple", 9662683);
            lGl.put("mediumseagreen", 3978097);
            lGl.put("mediumslateblue", 8087790);
            lGl.put("mediumspringgreen", 64154);
            lGl.put("mediumturquoise", 4772300);
            lGl.put("mediumvioletred", 13047173);
            lGl.put("midnightblue", 1644912);
            lGl.put("mintcream", 16121850);
            lGl.put("mistyrose", 16770273);
            lGl.put("moccasin", 16770229);
            lGl.put("navajowhite", 16768685);
            lGl.put("navy", 128);
            lGl.put("oldlace", 16643558);
            lGl.put("olive", 8421376);
            lGl.put("olivedrab", 7048739);
            lGl.put("orange", 16753920);
            lGl.put("orangered", 16729344);
            lGl.put("orchid", 14315734);
            lGl.put("palegoldenrod", 15657130);
            lGl.put("palegreen", 10025880);
            lGl.put("paleturquoise", 11529966);
            lGl.put("palevioletred", 14381203);
            lGl.put("papayawhip", 16773077);
            lGl.put("peachpuff", 16767673);
            lGl.put("peru", 13468991);
            lGl.put("pink", 16761035);
            lGl.put("plum", 14524637);
            lGl.put("powderblue", 11591910);
            lGl.put("purple", 8388736);
            lGl.put("red", 16711680);
            lGl.put("rosybrown", 12357519);
            lGl.put("royalblue", 4286945);
            lGl.put("saddlebrown", 9127187);
            lGl.put("salmon", 16416882);
            lGl.put("sandybrown", 16032864);
            lGl.put("seagreen", 3050327);
            lGl.put("seashell", 16774638);
            lGl.put("sienna", 10506797);
            lGl.put("silver", 12632256);
            lGl.put("skyblue", 8900331);
            lGl.put("slateblue", 6970061);
            lGl.put("slategray", 7372944);
            lGl.put("slategrey", 7372944);
            lGl.put("snow", 16775930);
            lGl.put("springgreen", 65407);
            lGl.put("steelblue", 4620980);
            lGl.put("tan", 13808780);
            lGl.put("teal", 32896);
            lGl.put("thistle", 14204888);
            lGl.put("tomato", 16737095);
            lGl.put("turquoise", 4251856);
            lGl.put("violet", 15631086);
            lGl.put("wheat", 16113331);
            lGl.put("white", 16777215);
            lGl.put("whitesmoke", 16119285);
            lGl.put("yellow", 16776960);
            lGl.put("yellowgreen", 10145074);
        }

        public static Integer OA(String str) {
            return lGl.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c {
        private static final Map<String, SVG.n> lGm = new HashMap(9);

        static {
            lGm.put("xx-small", new SVG.n(0.694f, SVG.Unit.pt));
            lGm.put("x-small", new SVG.n(0.833f, SVG.Unit.pt));
            lGm.put("small", new SVG.n(10.0f, SVG.Unit.pt));
            lGm.put("medium", new SVG.n(12.0f, SVG.Unit.pt));
            lGm.put("large", new SVG.n(14.4f, SVG.Unit.pt));
            lGm.put("x-large", new SVG.n(17.3f, SVG.Unit.pt));
            lGm.put("xx-large", new SVG.n(20.7f, SVG.Unit.pt));
            lGm.put("smaller", new SVG.n(83.33f, SVG.Unit.percent));
            lGm.put("larger", new SVG.n(120.0f, SVG.Unit.percent));
        }

        public static SVG.n OB(String str) {
            return lGm.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class d {
        private static final Map<String, Integer> lGn = new HashMap(13);

        static {
            lGn.put("normal", 400);
            lGn.put("bold", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lGn.put("bolder", 1);
            lGn.put("lighter", -1);
            lGn.put("100", 100);
            lGn.put(BasicPushStatus.SUCCESS_CODE, 200);
            lGn.put("300", 300);
            lGn.put("400", 400);
            lGn.put("500", 500);
            lGn.put("600", Integer.valueOf((int) Constants.HTTP_DNS_INAVAILABLE_TIME));
            lGn.put("700", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lGn.put("800", 800);
            lGn.put("900", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
        }

        public static Integer OA(String str) {
            return lGn.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a {
        private static final Map<String, PreserveAspectRatio.Alignment> lGk = new HashMap(10);

        static {
            lGk.put("none", PreserveAspectRatio.Alignment.None);
            lGk.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            lGk.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            lGk.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            lGk.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            lGk.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            lGk.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            lGk.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            lGk.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            lGk.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment Oz(String str) {
            return lGk.get(str);
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
                    return this.lFY;
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
        this.lFY = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.lGa) {
            this.lGb++;
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
                    this.lGc = true;
                    this.lGd = fromString;
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
                    this.lGa = true;
                    this.lGb = 1;
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lGa) {
            if (this.lGc) {
                if (this.lGe == null) {
                    this.lGe = new StringBuilder(i2);
                }
                this.lGe.append(cArr, i, i2);
            } else if (this.lGf) {
                if (this.lGg == null) {
                    this.lGg = new StringBuilder(i2);
                }
                this.lGg.append(cArr, i, i2);
            } else if (this.lFZ instanceof SVG.av) {
                SVG.ae aeVar = (SVG.ae) this.lFZ;
                int size = aeVar.UB.size();
                SVG.ak akVar = size == 0 ? null : aeVar.UB.get(size - 1);
                if (akVar instanceof SVG.az) {
                    SVG.az azVar = (SVG.az) akVar;
                    azVar.text += new String(cArr, i, i2);
                    return;
                }
                ((SVG.ae) this.lFZ).a(new SVG.az(new String(cArr, i, i2)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lGa && this.lGf) {
            if (this.lGg == null) {
                this.lGg = new StringBuilder(i2);
            }
            this.lGg.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.lGa) {
            int i = this.lGb - 1;
            this.lGb = i;
            if (i == 0) {
                this.lGa = false;
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
                    this.lFZ = ((SVG.ak) this.lFZ).lFm;
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
                    this.lGc = false;
                    if (this.lGd == SVGElem.title) {
                        this.lFY.setTitle(this.lGe.toString());
                    } else if (this.lGd == SVGElem.desc) {
                        this.lFY.setDesc(this.lGe.toString());
                    }
                    this.lGe.setLength(0);
                    return;
                case style:
                    if (this.lGg != null) {
                        this.lGf = false;
                        Oy(this.lGg.toString());
                        this.lGg.setLength(0);
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
        acVar.lFl = this.lFY;
        acVar.lFm = this.lFZ;
        a((SVG.ai) acVar, attributes);
        b(acVar, attributes);
        a((SVG.ad) acVar, attributes);
        a((SVG.ao) acVar, attributes);
        a(acVar, attributes);
        if (this.lFZ == null) {
            this.lFY.a(acVar);
        } else {
            this.lFZ.a(acVar);
        }
        this.lFZ = acVar;
    }

    private void a(SVG.ac acVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    acVar.lDP = NY(trim);
                    break;
                case y:
                    acVar.lDQ = NY(trim);
                    break;
                case width:
                    acVar.lDR = NY(trim);
                    if (acVar.lDR.diy()) {
                        throw new SAXException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    acVar.lDS = NY(trim);
                    if (acVar.lDS.diy()) {
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
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.k kVar = new SVG.k();
        kVar.lFl = this.lFY;
        kVar.lFm = this.lFZ;
        a((SVG.ai) kVar, attributes);
        b(kVar, attributes);
        a((SVG.l) kVar, attributes);
        a((SVG.ad) kVar, attributes);
        this.lFZ.a(kVar);
        this.lFZ = kVar;
    }

    private void c(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.g gVar = new SVG.g();
        gVar.lFl = this.lFY;
        gVar.lFm = this.lFZ;
        a((SVG.ai) gVar, attributes);
        b(gVar, attributes);
        a((SVG.l) gVar, attributes);
        this.lFZ.a(gVar);
        this.lFZ = gVar;
    }

    private void d(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ba baVar = new SVG.ba();
        baVar.lFl = this.lFY;
        baVar.lFm = this.lFZ;
        a((SVG.ai) baVar, attributes);
        b(baVar, attributes);
        a((SVG.l) baVar, attributes);
        a((SVG.ad) baVar, attributes);
        a(baVar, attributes);
        this.lFZ.a(baVar);
        this.lFZ = baVar;
    }

    private void a(SVG.ba baVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    baVar.lDP = NY(trim);
                    break;
                case y:
                    baVar.lDQ = NY(trim);
                    break;
                case width:
                    baVar.lDR = NY(trim);
                    if (baVar.lDR.diy()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    baVar.lDS = NY(trim);
                    if (baVar.lDS.diy()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        baVar.Tl = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void e(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.m mVar = new SVG.m();
        mVar.lFl = this.lFY;
        mVar.lFm = this.lFZ;
        a((SVG.ai) mVar, attributes);
        b(mVar, attributes);
        a((SVG.l) mVar, attributes);
        a((SVG.ad) mVar, attributes);
        a(mVar, attributes);
        this.lFZ.a(mVar);
        this.lFZ = mVar;
    }

    private void a(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    mVar.lDP = NY(trim);
                    break;
                case y:
                    mVar.lDQ = NY(trim);
                    break;
                case width:
                    mVar.lDR = NY(trim);
                    if (mVar.lDR.diy()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    mVar.lDS = NY(trim);
                    if (mVar.lDS.diy()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        mVar.Tl = trim;
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
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.t tVar = new SVG.t();
        tVar.lFl = this.lFY;
        tVar.lFm = this.lFZ;
        a((SVG.ai) tVar, attributes);
        b(tVar, attributes);
        a((SVG.l) tVar, attributes);
        a((SVG.ad) tVar, attributes);
        a(tVar, attributes);
        this.lFZ.a(tVar);
    }

    private void a(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    tVar.lEh = Ou(trim);
                    break;
                case pathLength:
                    tVar.lEi = Float.valueOf(parseFloat(trim));
                    if (tVar.lEi.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.z zVar = new SVG.z();
        zVar.lFl = this.lFY;
        zVar.lFm = this.lFZ;
        a((SVG.ai) zVar, attributes);
        b(zVar, attributes);
        a((SVG.l) zVar, attributes);
        a((SVG.ad) zVar, attributes);
        a(zVar, attributes);
        this.lFZ.a(zVar);
    }

    private void a(SVG.z zVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    zVar.lDP = NY(trim);
                    break;
                case y:
                    zVar.lDQ = NY(trim);
                    break;
                case width:
                    zVar.lDR = NY(trim);
                    if (zVar.lDR.diy()) {
                        throw new SAXException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    zVar.lDS = NY(trim);
                    if (zVar.lDS.diy()) {
                        throw new SAXException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    zVar.lDJ = NY(trim);
                    if (zVar.lDJ.diy()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    zVar.lDK = NY(trim);
                    if (zVar.lDK.diy()) {
                        throw new SAXException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    private void h(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.c cVar = new SVG.c();
        cVar.lFl = this.lFY;
        cVar.lFm = this.lFZ;
        a((SVG.ai) cVar, attributes);
        b(cVar, attributes);
        a((SVG.l) cVar, attributes);
        a((SVG.ad) cVar, attributes);
        a(cVar, attributes);
        this.lFZ.a(cVar);
    }

    private void a(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    cVar.lDC = NY(trim);
                    break;
                case cy:
                    cVar.lDD = NY(trim);
                    break;
                case r:
                    cVar.lDE = NY(trim);
                    if (cVar.lDE.diy()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void i(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.h hVar = new SVG.h();
        hVar.lFl = this.lFY;
        hVar.lFm = this.lFZ;
        a((SVG.ai) hVar, attributes);
        b(hVar, attributes);
        a((SVG.l) hVar, attributes);
        a((SVG.ad) hVar, attributes);
        a(hVar, attributes);
        this.lFZ.a(hVar);
    }

    private void a(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    hVar.lDJ = NY(trim);
                    if (hVar.lDJ.diy()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.lDK = NY(trim);
                    if (hVar.lDK.diy()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.lDC = NY(trim);
                    break;
                case cy:
                    hVar.lDD = NY(trim);
                    break;
            }
        }
    }

    private void j(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.o oVar = new SVG.o();
        oVar.lFl = this.lFY;
        oVar.lFm = this.lFZ;
        a((SVG.ai) oVar, attributes);
        b(oVar, attributes);
        a((SVG.l) oVar, attributes);
        a((SVG.ad) oVar, attributes);
        a(oVar, attributes);
        this.lFZ.a(oVar);
    }

    private void a(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    oVar.lDU = NY(trim);
                    break;
                case y1:
                    oVar.lDV = NY(trim);
                    break;
                case x2:
                    oVar.lDW = NY(trim);
                    break;
                case y2:
                    oVar.lDX = NY(trim);
                    break;
            }
        }
    }

    private void k(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.x xVar = new SVG.x();
        xVar.lFl = this.lFY;
        xVar.lFm = this.lFZ;
        a((SVG.ai) xVar, attributes);
        b(xVar, attributes);
        a((SVG.l) xVar, attributes);
        a((SVG.ad) xVar, attributes);
        a(xVar, attributes, "polyline");
        this.lFZ.a(xVar);
    }

    private void a(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                e eVar = new e(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                eVar.skipWhitespace();
                while (!eVar.djc()) {
                    float nextFloat = eVar.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    eVar.djd();
                    float nextFloat2 = eVar.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    eVar.djd();
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
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.y yVar = new SVG.y();
        yVar.lFl = this.lFY;
        yVar.lFm = this.lFZ;
        a((SVG.ai) yVar, attributes);
        b(yVar, attributes);
        a((SVG.l) yVar, attributes);
        a((SVG.ad) yVar, attributes);
        a(yVar, attributes, "polygon");
        this.lFZ.a(yVar);
    }

    private void m(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.at atVar = new SVG.at();
        atVar.lFl = this.lFY;
        atVar.lFm = this.lFZ;
        a((SVG.ai) atVar, attributes);
        b(atVar, attributes);
        a((SVG.l) atVar, attributes);
        a((SVG.ad) atVar, attributes);
        a((SVG.ax) atVar, attributes);
        this.lFZ.a(atVar);
        this.lFZ = atVar;
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
                    axVar.lFt = NZ(trim);
                    break;
                case dy:
                    axVar.lFu = NZ(trim);
                    break;
            }
        }
    }

    private void n(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFZ instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.as asVar = new SVG.as();
        asVar.lFl = this.lFY;
        asVar.lFm = this.lFZ;
        a((SVG.ai) asVar, attributes);
        b(asVar, attributes);
        a((SVG.ad) asVar, attributes);
        a((SVG.ax) asVar, attributes);
        this.lFZ.a(asVar);
        this.lFZ = asVar;
        if (asVar.lFm instanceof SVG.ay) {
            asVar.a((SVG.ay) asVar.lFm);
        } else {
            asVar.a(((SVG.au) asVar.lFm).diF());
        }
    }

    private void o(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFZ instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.ar arVar = new SVG.ar();
        arVar.lFl = this.lFY;
        arVar.lFm = this.lFZ;
        a((SVG.ai) arVar, attributes);
        b(arVar, attributes);
        a((SVG.ad) arVar, attributes);
        a(arVar, attributes);
        this.lFZ.a(arVar);
        if (arVar.lFm instanceof SVG.ay) {
            arVar.a((SVG.ay) arVar.lFm);
        } else {
            arVar.a(((SVG.au) arVar.lFm).diF());
        }
    }

    private void a(SVG.ar arVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        arVar.Tl = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void p(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ap apVar = new SVG.ap();
        apVar.lFl = this.lFY;
        apVar.lFm = this.lFZ;
        a((SVG.ai) apVar, attributes);
        b(apVar, attributes);
        a((SVG.l) apVar, attributes);
        a((SVG.ad) apVar, attributes);
        this.lFZ.a(apVar);
        this.lFZ = apVar;
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
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aq aqVar = new SVG.aq();
        aqVar.lFl = this.lFY;
        aqVar.lFm = this.lFZ;
        a((SVG.ai) aqVar, attributes);
        b(aqVar, attributes);
        a((SVG.ad) aqVar, attributes);
        a((SVG.ao) aqVar, attributes);
        this.lFZ.a(aqVar);
        this.lFZ = aqVar;
    }

    private void r(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.p pVar = new SVG.p();
        pVar.lFl = this.lFY;
        pVar.lFm = this.lFZ;
        a((SVG.ai) pVar, attributes);
        b(pVar, attributes);
        a((SVG.ad) pVar, attributes);
        a((SVG.ao) pVar, attributes);
        a(pVar, attributes);
        this.lFZ.a(pVar);
        this.lFZ = pVar;
    }

    private void a(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    pVar.lDZ = NY(trim);
                    break;
                case refY:
                    pVar.lEa = NY(trim);
                    break;
                case markerWidth:
                    pVar.lEb = NY(trim);
                    if (pVar.lEb.diy()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    pVar.lEc = NY(trim);
                    if (pVar.lEc.diy()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        pVar.lDY = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        pVar.lDY = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        pVar.lEd = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        pVar.lEd = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void s(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aj ajVar = new SVG.aj();
        ajVar.lFl = this.lFY;
        ajVar.lFm = this.lFZ;
        a((SVG.ai) ajVar, attributes);
        b(ajVar, attributes);
        a((SVG.i) ajVar, attributes);
        a(ajVar, attributes);
        this.lFZ.a(ajVar);
        this.lFZ = ajVar;
    }

    private void a(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        iVar.Tl = trim;
                        break;
                    } else {
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        iVar.lDL = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.lDL = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.lDM = NX(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.lDN = SVG.GradientSpread.valueOf(trim);
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
                    ajVar.lDU = NY(trim);
                    break;
                case y1:
                    ajVar.lDV = NY(trim);
                    break;
                case x2:
                    ajVar.lDW = NY(trim);
                    break;
                case y2:
                    ajVar.lDX = NY(trim);
                    break;
            }
        }
    }

    private void t(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.an anVar = new SVG.an();
        anVar.lFl = this.lFY;
        anVar.lFm = this.lFZ;
        a((SVG.ai) anVar, attributes);
        b(anVar, attributes);
        a((SVG.i) anVar, attributes);
        a(anVar, attributes);
        this.lFZ.a(anVar);
        this.lFZ = anVar;
    }

    private void a(SVG.an anVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    anVar.lDC = NY(trim);
                    break;
                case cy:
                    anVar.lDD = NY(trim);
                    break;
                case r:
                    anVar.lDE = NY(trim);
                    if (anVar.lDE.diy()) {
                        throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    anVar.lFo = NY(trim);
                    break;
                case fy:
                    anVar.lFp = NY(trim);
                    break;
            }
        }
    }

    private void u(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lFZ instanceof SVG.i)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.ab abVar = new SVG.ab();
        abVar.lFl = this.lFY;
        abVar.lFm = this.lFZ;
        a((SVG.ai) abVar, attributes);
        b(abVar, attributes);
        a(abVar, attributes);
        this.lFZ.a(abVar);
        this.lFZ = abVar;
    }

    private void a(SVG.ab abVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    abVar.lEq = NW(trim);
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
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aa aaVar = new SVG.aa();
        aaVar.lFl = this.lFY;
        aaVar.lFm = this.lFZ;
        a(aaVar, attributes);
        b(aaVar, attributes);
        this.lFZ.a(aaVar);
        this.lFZ = aaVar;
    }

    private void w(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.d dVar = new SVG.d();
        dVar.lFl = this.lFY;
        dVar.lFm = this.lFZ;
        a((SVG.ai) dVar, attributes);
        b(dVar, attributes);
        a((SVG.l) dVar, attributes);
        a((SVG.ad) dVar, attributes);
        a(dVar, attributes);
        this.lFZ.a(dVar);
        this.lFZ = dVar;
    }

    private void a(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.lDF = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.lDF = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    private void x(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aw awVar = new SVG.aw();
        awVar.lFl = this.lFY;
        awVar.lFm = this.lFZ;
        a((SVG.ai) awVar, attributes);
        b(awVar, attributes);
        a((SVG.ad) awVar, attributes);
        a(awVar, attributes);
        this.lFZ.a(awVar);
        this.lFZ = awVar;
        if (awVar.lFm instanceof SVG.ay) {
            awVar.a((SVG.ay) awVar.lFm);
        } else {
            awVar.a(((SVG.au) awVar.lFm).diF());
        }
    }

    private void a(SVG.aw awVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        awVar.Tl = trim;
                        break;
                    } else {
                        break;
                    }
                case startOffset:
                    awVar.lFs = NY(trim);
                    break;
            }
        }
    }

    private void y(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.w wVar = new SVG.w();
        wVar.lFl = this.lFY;
        wVar.lFm = this.lFZ;
        a((SVG.ai) wVar, attributes);
        b(wVar, attributes);
        a((SVG.ad) wVar, attributes);
        a((SVG.ao) wVar, attributes);
        a(wVar, attributes);
        this.lFZ.a(wVar);
        this.lFZ = wVar;
    }

    private void a(SVG.w wVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    wVar.lDP = NY(trim);
                    break;
                case y:
                    wVar.lDQ = NY(trim);
                    break;
                case width:
                    wVar.lDR = NY(trim);
                    if (wVar.lDR.diy()) {
                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    wVar.lDS = NY(trim);
                    if (wVar.lDS.diy()) {
                        throw new SAXException("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        wVar.Tl = trim;
                        break;
                    } else {
                        break;
                    }
                case patternUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lEn = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lEn = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lEo = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lEo = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    wVar.lEp = NX(trim);
                    break;
            }
        }
    }

    private void z(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.bb bbVar = new SVG.bb();
        bbVar.lFl = this.lFY;
        bbVar.lFm = this.lFZ;
        a((SVG.ai) bbVar, attributes);
        a((SVG.ad) bbVar, attributes);
        a((SVG.ao) bbVar, attributes);
        this.lFZ.a(bbVar);
        this.lFZ = bbVar;
    }

    private void A(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.lFZ == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.q qVar = new SVG.q();
        qVar.lFl = this.lFY;
        qVar.lFm = this.lFZ;
        a((SVG.ai) qVar, attributes);
        b(qVar, attributes);
        a((SVG.ad) qVar, attributes);
        a(qVar, attributes);
        this.lFZ.a(qVar);
        this.lFZ = qVar;
    }

    private void a(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    qVar.lDP = NY(trim);
                    break;
                case y:
                    qVar.lDQ = NY(trim);
                    break;
                case width:
                    qVar.lDR = NY(trim);
                    if (qVar.lDR.diy()) {
                        throw new SAXException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    qVar.lDS = NY(trim);
                    if (qVar.lDS.diy()) {
                        throw new SAXException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lEe = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lEe = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lEf = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lEf = true;
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
        protected String lGo;
        protected int lGp;
        protected int position = 0;
        private com.caverock.androidsvg.b lGq = new com.caverock.androidsvg.b();

        public e(String str) {
            this.lGp = 0;
            this.lGo = str.trim();
            this.lGp = this.lGo.length();
        }

        public boolean djc() {
            return this.position == this.lGp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hi(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public void skipWhitespace() {
            while (this.position < this.lGp && Hi(this.lGo.charAt(this.position))) {
                this.position++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hj(int i) {
            return i == 10 || i == 13;
        }

        public boolean djd() {
            skipWhitespace();
            if (this.position != this.lGp && this.lGo.charAt(this.position) == ',') {
                this.position++;
                skipWhitespace();
                return true;
            }
            return false;
        }

        public float nextFloat() {
            float B = this.lGq.B(this.lGo, this.position, this.lGp);
            if (!Float.isNaN(B)) {
                this.position = this.lGq.din();
            }
            return B;
        }

        public float dje() {
            djd();
            float B = this.lGq.B(this.lGo, this.position, this.lGp);
            if (!Float.isNaN(B)) {
                this.position = this.lGq.din();
            }
            return B;
        }

        public float bi(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            djd();
            return nextFloat();
        }

        public Integer djf() {
            if (this.position == this.lGp) {
                return null;
            }
            String str = this.lGo;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.n djg() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit djl = djl();
            if (djl == null) {
                return new SVG.n(nextFloat, SVG.Unit.px);
            }
            return new SVG.n(nextFloat, djl);
        }

        public Boolean djh() {
            if (this.position == this.lGp) {
                return null;
            }
            char charAt = this.lGo.charAt(this.position);
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
            djd();
            return djh();
        }

        public boolean g(char c) {
            boolean z = this.position < this.lGp && this.lGo.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        public boolean OC(String str) {
            int length = str.length();
            boolean z = this.position <= this.lGp - length && this.lGo.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int dji() {
            if (this.position == this.lGp) {
                return -1;
            }
            this.position++;
            if (this.position < this.lGp) {
                return this.lGo.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return h(' ');
        }

        public String h(char c) {
            if (djc()) {
                return null;
            }
            char charAt = this.lGo.charAt(this.position);
            if (Hi(charAt) || charAt == c) {
                return null;
            }
            int i = this.position;
            int dji = dji();
            while (dji != -1 && dji != c && !Hi(dji)) {
                dji = dji();
            }
            return this.lGo.substring(i, this.position);
        }

        public String djj() {
            if (djc()) {
                return null;
            }
            int i = this.position;
            int charAt = this.lGo.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = dji();
            }
            int i2 = this.position;
            while (Hi(charAt)) {
                charAt = dji();
            }
            if (charAt == 40) {
                this.position++;
                return this.lGo.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        public String djk() {
            int i = this.position;
            while (!djc() && !Hi(this.lGo.charAt(this.position))) {
                this.position++;
            }
            String substring = this.lGo.substring(i, this.position);
            this.position = i;
            return substring;
        }

        public SVG.Unit djl() {
            if (djc()) {
                return null;
            }
            if (this.lGo.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            } else if (this.position <= this.lGp - 2) {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.lGo.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                return null;
            }
        }

        public boolean djm() {
            if (this.position == this.lGp) {
                return false;
            }
            char charAt = this.lGo.charAt(this.position);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public String djn() {
            if (djc()) {
                return null;
            }
            int i = this.position;
            char charAt = this.lGo.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                int dji = dji();
                while (dji != -1 && dji != charAt) {
                    dji = dji();
                }
                if (dji == -1) {
                    this.position = i;
                    return null;
                }
                this.position++;
                return this.lGo.substring(i + 1, this.position - 1);
            }
            return null;
        }

        public String djo() {
            if (djc()) {
                return null;
            }
            int i = this.position;
            this.position = this.lGp;
            return this.lGo.substring(i);
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
                    aiVar.lFi = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    aiVar.lFi = Boolean.TRUE;
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
                        aiVar.lFk = CSSParser.NN(trim);
                        continue;
                    default:
                        if (aiVar.lFj == null) {
                            aiVar.lFj = new SVG.Style();
                        }
                        a(aiVar.lFj, attributes.getLocalName(i), attributes.getValue(i).trim());
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
                    if (eVar.djc() || eVar.g(';')) {
                        if (aiVar.lCU == null) {
                            aiVar.lCU = new SVG.Style();
                        }
                        a(aiVar.lCU, h, h2);
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
                    style.lEs = fh(str2, "fill");
                    style.lEr |= 1;
                    return;
                case fill_rule:
                    style.lEt = Om(str2);
                    style.lEr |= 2;
                    return;
                case fill_opacity:
                    style.lEu = Float.valueOf(Oa(str2));
                    style.lEr |= 4;
                    return;
                case stroke:
                    style.lEv = fh(str2, "stroke");
                    style.lEr |= 8;
                    return;
                case stroke_opacity:
                    style.lEw = Float.valueOf(Oa(str2));
                    style.lEr |= 16;
                    return;
                case stroke_width:
                    style.lEx = NY(str2);
                    style.lEr |= 32;
                    return;
                case stroke_linecap:
                    style.lEy = On(str2);
                    style.lEr |= 64;
                    return;
                case stroke_linejoin:
                    style.lEz = Oo(str2);
                    style.lEr |= 128;
                    return;
                case stroke_miterlimit:
                    style.lEA = Float.valueOf(parseFloat(str2));
                    style.lEr |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.lEB = null;
                    } else {
                        style.lEB = Op(str2);
                    }
                    style.lEr |= 512;
                    return;
                case stroke_dashoffset:
                    style.lEC = NY(str2);
                    style.lEr |= 1024;
                    return;
                case opacity:
                    style.lED = Float.valueOf(Oa(str2));
                    style.lEr |= 2048;
                    return;
                case color:
                    style.lEE = Od(str2);
                    style.lEr |= 4096;
                    return;
                case font:
                    a(style, str2);
                    return;
                case font_family:
                    style.lEF = Of(str2);
                    style.lEr |= 8192;
                    return;
                case font_size:
                    style.lEG = Og(str2);
                    style.lEr |= 16384;
                    return;
                case font_weight:
                    style.lEH = Oh(str2);
                    style.lEr |= 32768;
                    return;
                case font_style:
                    style.lEI = Oi(str2);
                    style.lEr |= 65536;
                    return;
                case text_decoration:
                    style.lEJ = Ok(str2);
                    style.lEr |= 131072;
                    return;
                case direction:
                    style.lEK = Ol(str2);
                    style.lEr |= 68719476736L;
                    return;
                case text_anchor:
                    style.lEL = Oq(str2);
                    style.lEr |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    return;
                case overflow:
                    style.lEM = Or(str2);
                    style.lEr |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case marker:
                    style.lEO = fi(str2, str);
                    style.lEP = style.lEO;
                    style.lEQ = style.lEO;
                    style.lEr |= 14680064;
                    return;
                case marker_start:
                    style.lEO = fi(str2, str);
                    style.lEr |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.lEP = fi(str2, str);
                    style.lEr |= ImageUploadStrategy.FILE_SIZE_4M;
                    return;
                case marker_end:
                    style.lEQ = fi(str2, str);
                    style.lEr |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    style.lER = Boolean.valueOf(!str2.equals("none"));
                    style.lEr |= AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH;
                    return;
                case visibility:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|visible|hidden|collapse|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    style.lES = Boolean.valueOf(str2.equals("visible"));
                    style.lEr |= 33554432;
                    return;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        style.lET = SVG.f.dix();
                    } else {
                        style.lET = Od(str2);
                    }
                    style.lEr |= 67108864;
                    return;
                case stop_opacity:
                    style.lEU = Float.valueOf(Oa(str2));
                    style.lEr |= 134217728;
                    return;
                case clip:
                    style.lEN = Os(str2);
                    style.lEr |= 1048576;
                    return;
                case clip_path:
                    style.clipPath = fi(str2, str);
                    style.lEr |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case clip_rule:
                    style.lEV = Om(str2);
                    style.lEr |= IjkMediaMeta.AV_CH_STEREO_LEFT;
                    return;
                case mask:
                    style.lEW = fi(str2, str);
                    style.lEr |= IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    return;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        style.lEX = SVG.f.dix();
                    } else {
                        style.lEX = Od(str2);
                    }
                    style.lEr |= IjkMediaMeta.AV_CH_WIDE_LEFT;
                    return;
                case solid_opacity:
                    style.lEY = Float.valueOf(Oa(str2));
                    style.lEr |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        style.lEZ = SVG.f.dix();
                    } else {
                        style.lEZ = Od(str2);
                    }
                    style.lEr |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                    return;
                case viewport_fill_opacity:
                    style.lFa = Float.valueOf(Oa(str2));
                    style.lEr |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                    return;
                case vector_effect:
                    style.lFb = Ot(str2);
                    style.lEr |= IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
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
                    aoVar.lFq = Ob(trim);
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
        while (!eVar.djc()) {
            String djj = eVar.djj();
            if (djj == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (djj.equals("matrix")) {
                eVar.skipWhitespace();
                float nextFloat = eVar.nextFloat();
                eVar.djd();
                float nextFloat2 = eVar.nextFloat();
                eVar.djd();
                float nextFloat3 = eVar.nextFloat();
                eVar.djd();
                float nextFloat4 = eVar.nextFloat();
                eVar.djd();
                float nextFloat5 = eVar.nextFloat();
                eVar.djd();
                float nextFloat6 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat6) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (djj.equals("translate")) {
                eVar.skipWhitespace();
                float nextFloat7 = eVar.nextFloat();
                float dje = eVar.dje();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat7) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dje)) {
                    matrix.preTranslate(nextFloat7, 0.0f);
                } else {
                    matrix.preTranslate(nextFloat7, dje);
                }
            } else if (djj.equals("scale")) {
                eVar.skipWhitespace();
                float nextFloat8 = eVar.nextFloat();
                float dje2 = eVar.dje();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat8) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dje2)) {
                    matrix.preScale(nextFloat8, nextFloat8);
                } else {
                    matrix.preScale(nextFloat8, dje2);
                }
            } else if (djj.equals(RotateImageAction.ACTION_NAME)) {
                eVar.skipWhitespace();
                float nextFloat9 = eVar.nextFloat();
                float dje3 = eVar.dje();
                float dje4 = eVar.dje();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat9) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dje3)) {
                    matrix.preRotate(nextFloat9);
                } else if (!Float.isNaN(dje4)) {
                    matrix.preRotate(nextFloat9, dje3, dje4);
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (djj.equals("skewX")) {
                eVar.skipWhitespace();
                float nextFloat10 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat10) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat10)), 0.0f);
            } else if (djj.equals("skewY")) {
                eVar.skipWhitespace();
                float nextFloat11 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat11) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat11)));
            } else if (djj != null) {
                throw new SAXException("Invalid transform list fn: " + djj + ")");
            }
            if (eVar.djc()) {
                break;
            }
            eVar.djd();
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
        while (!eVar.djc()) {
            float nextFloat = eVar.nextFloat();
            if (Float.isNaN(nextFloat)) {
                throw new SAXException("Invalid length list value: " + eVar.djk());
            }
            SVG.Unit djl = eVar.djl();
            if (djl == null) {
                djl = SVG.Unit.px;
            }
            arrayList.add(new SVG.n(nextFloat, djl));
            eVar.djd();
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
        eVar.djd();
        float nextFloat2 = eVar.nextFloat();
        eVar.djd();
        float nextFloat3 = eVar.nextFloat();
        eVar.djd();
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
        if (eVar.djc()) {
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
        amVar.lFn = new PreserveAspectRatio(Oz, scale);
    }

    private static SVG.al fh(String str, String str2) throws SAXException {
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
            return SVG.f.dix();
        }
        return Od(str);
    }

    private static SVG.e Od(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.a A = com.caverock.androidsvg.a.A(str, 1, str.length());
            if (A == null) {
                throw new SAXException("Bad hex colour value: " + str);
            }
            int din = A.din();
            if (din == 7) {
                return new SVG.e(A.value());
            }
            if (din == 4) {
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
            style.lEF = Of(eVar.djo());
            style.lEG = Og;
            style.lEH = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.lEI = fontStyle;
            style.lEr |= 122880;
        }
    }

    private static List<String> Of(String str) throws SAXException {
        ArrayList arrayList = null;
        e eVar = new e(str);
        do {
            String djn = eVar.djn();
            if (djn == null) {
                djn = eVar.h(',');
            }
            if (djn == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(djn);
            eVar.djd();
        } while (!eVar.djc());
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
        SVG.n djg;
        e eVar = new e(str);
        eVar.skipWhitespace();
        if (!eVar.djc() && (djg = eVar.djg()) != null) {
            if (djg.diy()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            float floatValue = djg.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(djg);
            while (!eVar.djc()) {
                eVar.djd();
                SVG.n djg2 = eVar.djg();
                if (djg2 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
                if (djg2.diy()) {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                }
                arrayList.add(djg2);
                floatValue += djg2.floatValue();
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
        eVar.djd();
        SVG.n a3 = a(eVar);
        eVar.djd();
        SVG.n a4 = a(eVar);
        eVar.djd();
        SVG.n a5 = a(eVar);
        eVar.skipWhitespace();
        if (!eVar.g(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.b(a2, a3, a4, a5);
    }

    private static SVG.n a(e eVar) {
        return eVar.OC("auto") ? new SVG.n(0.0f) : eVar.djg();
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
        float dje;
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
        if (!eVar.djc() && ((intValue = eVar.djf().intValue()) == 77 || intValue == 109)) {
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
                                dje = Float.NaN;
                            } else {
                                dje = eVar.dje();
                                bi = eVar.bi(dje);
                            }
                            if (!Float.isNaN(bi) && nextFloat >= 0.0f && bi2 >= 0.0f) {
                                if (i == 97) {
                                    float f23 = f20 + dje;
                                    f10 = bi + f19;
                                    f11 = f23;
                                } else {
                                    float f24 = bi;
                                    f11 = dje;
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
                    eVar.djd();
                    if (!eVar.djc()) {
                        if (eVar.djm()) {
                            intValue = eVar.djf().intValue();
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
        while (!eVar.djc()) {
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
        while (!eVar.djc()) {
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
        while (!eVar.djc()) {
            hashSet.add(eVar.nextToken());
            eVar.skipWhitespace();
        }
        return hashSet;
    }

    private static String fi(String str, String str2) throws SAXException {
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
        if (this.lFZ == null) {
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
            this.lGf = true;
            return;
        }
        this.lGa = true;
        this.lGb = 1;
    }

    private void Oy(String str) throws SAXException {
        this.lFY.b(new CSSParser(CSSParser.MediaType.screen).NM(str));
    }
}
