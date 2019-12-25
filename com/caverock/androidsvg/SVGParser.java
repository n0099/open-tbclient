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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
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
/* loaded from: classes9.dex */
public class SVGParser extends DefaultHandler2 {
    private int lBR;
    private SVG lBO = null;
    private SVG.ag lBP = null;
    private boolean lBQ = false;
    private boolean lBS = false;
    private SVGElem lBT = null;
    private StringBuilder lBU = null;
    private boolean lBV = false;
    private StringBuilder lBW = null;
    private Set<String> lBX = null;

    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static class b {
        private static final Map<String, Integer> lCb = new HashMap(47);

        static {
            lCb.put("aliceblue", 15792383);
            lCb.put("antiquewhite", 16444375);
            lCb.put("aqua", 65535);
            lCb.put("aquamarine", 8388564);
            lCb.put("azure", 15794175);
            lCb.put("beige", 16119260);
            lCb.put("bisque", 16770244);
            lCb.put("black", 0);
            lCb.put("blanchedalmond", 16772045);
            lCb.put("blue", 255);
            lCb.put("blueviolet", 9055202);
            lCb.put("brown", 10824234);
            lCb.put("burlywood", 14596231);
            lCb.put("cadetblue", 6266528);
            lCb.put("chartreuse", 8388352);
            lCb.put("chocolate", 13789470);
            lCb.put("coral", 16744272);
            lCb.put("cornflowerblue", 6591981);
            lCb.put("cornsilk", 16775388);
            lCb.put("crimson", 14423100);
            lCb.put("cyan", 65535);
            lCb.put("darkblue", 139);
            lCb.put("darkcyan", 35723);
            lCb.put("darkgoldenrod", 12092939);
            lCb.put("darkgray", 11119017);
            lCb.put("darkgreen", 25600);
            lCb.put("darkgrey", 11119017);
            lCb.put("darkkhaki", 12433259);
            lCb.put("darkmagenta", 9109643);
            lCb.put("darkolivegreen", 5597999);
            lCb.put("darkorange", 16747520);
            lCb.put("darkorchid", 10040012);
            lCb.put("darkred", 9109504);
            lCb.put("darksalmon", 15308410);
            lCb.put("darkseagreen", 9419919);
            lCb.put("darkslateblue", 4734347);
            lCb.put("darkslategray", 3100495);
            lCb.put("darkslategrey", 3100495);
            lCb.put("darkturquoise", 52945);
            lCb.put("darkviolet", 9699539);
            lCb.put("deeppink", 16716947);
            lCb.put("deepskyblue", 49151);
            lCb.put("dimgray", 6908265);
            lCb.put("dimgrey", 6908265);
            lCb.put("dodgerblue", 2003199);
            lCb.put("firebrick", 11674146);
            lCb.put("floralwhite", 16775920);
            lCb.put("forestgreen", 2263842);
            lCb.put("fuchsia", 16711935);
            lCb.put("gainsboro", 14474460);
            lCb.put("ghostwhite", 16316671);
            lCb.put("gold", 16766720);
            lCb.put("goldenrod", 14329120);
            lCb.put(com.baidu.fsg.face.base.b.c.m, 8421504);
            lCb.put("green", 32768);
            lCb.put("greenyellow", 11403055);
            lCb.put("grey", 8421504);
            lCb.put("honeydew", 15794160);
            lCb.put("hotpink", 16738740);
            lCb.put("indianred", 13458524);
            lCb.put("indigo", 4915330);
            lCb.put("ivory", 16777200);
            lCb.put("khaki", 15787660);
            lCb.put("lavender", 15132410);
            lCb.put("lavenderblush", 16773365);
            lCb.put("lawngreen", 8190976);
            lCb.put("lemonchiffon", 16775885);
            lCb.put("lightblue", 11393254);
            lCb.put("lightcoral", 15761536);
            lCb.put("lightcyan", 14745599);
            lCb.put("lightgoldenrodyellow", 16448210);
            lCb.put("lightgray", 13882323);
            lCb.put("lightgreen", 9498256);
            lCb.put("lightgrey", 13882323);
            lCb.put("lightpink", 16758465);
            lCb.put("lightsalmon", 16752762);
            lCb.put("lightseagreen", 2142890);
            lCb.put("lightskyblue", 8900346);
            lCb.put("lightslategray", 7833753);
            lCb.put("lightslategrey", 7833753);
            lCb.put("lightsteelblue", 11584734);
            lCb.put("lightyellow", 16777184);
            lCb.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            lCb.put("limegreen", 3329330);
            lCb.put("linen", 16445670);
            lCb.put("magenta", 16711935);
            lCb.put("maroon", 8388608);
            lCb.put("mediumaquamarine", 6737322);
            lCb.put("mediumblue", 205);
            lCb.put("mediumorchid", 12211667);
            lCb.put("mediumpurple", 9662683);
            lCb.put("mediumseagreen", 3978097);
            lCb.put("mediumslateblue", 8087790);
            lCb.put("mediumspringgreen", 64154);
            lCb.put("mediumturquoise", 4772300);
            lCb.put("mediumvioletred", 13047173);
            lCb.put("midnightblue", 1644912);
            lCb.put("mintcream", 16121850);
            lCb.put("mistyrose", 16770273);
            lCb.put("moccasin", 16770229);
            lCb.put("navajowhite", 16768685);
            lCb.put("navy", 128);
            lCb.put("oldlace", 16643558);
            lCb.put("olive", 8421376);
            lCb.put("olivedrab", 7048739);
            lCb.put("orange", 16753920);
            lCb.put("orangered", 16729344);
            lCb.put("orchid", 14315734);
            lCb.put("palegoldenrod", 15657130);
            lCb.put("palegreen", 10025880);
            lCb.put("paleturquoise", 11529966);
            lCb.put("palevioletred", 14381203);
            lCb.put("papayawhip", 16773077);
            lCb.put("peachpuff", 16767673);
            lCb.put("peru", 13468991);
            lCb.put("pink", 16761035);
            lCb.put("plum", 14524637);
            lCb.put("powderblue", 11591910);
            lCb.put("purple", 8388736);
            lCb.put("red", 16711680);
            lCb.put("rosybrown", 12357519);
            lCb.put("royalblue", 4286945);
            lCb.put("saddlebrown", 9127187);
            lCb.put("salmon", 16416882);
            lCb.put("sandybrown", 16032864);
            lCb.put("seagreen", 3050327);
            lCb.put("seashell", 16774638);
            lCb.put("sienna", 10506797);
            lCb.put("silver", 12632256);
            lCb.put("skyblue", 8900331);
            lCb.put("slateblue", 6970061);
            lCb.put("slategray", 7372944);
            lCb.put("slategrey", 7372944);
            lCb.put("snow", 16775930);
            lCb.put("springgreen", 65407);
            lCb.put("steelblue", 4620980);
            lCb.put("tan", 13808780);
            lCb.put("teal", 32896);
            lCb.put("thistle", 14204888);
            lCb.put("tomato", 16737095);
            lCb.put("turquoise", 4251856);
            lCb.put("violet", 15631086);
            lCb.put("wheat", 16113331);
            lCb.put("white", 16777215);
            lCb.put("whitesmoke", 16119285);
            lCb.put("yellow", 16776960);
            lCb.put("yellowgreen", 10145074);
        }

        public static Integer Oe(String str) {
            return lCb.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c {
        private static final Map<String, SVG.n> lCc = new HashMap(9);

        static {
            lCc.put("xx-small", new SVG.n(0.694f, SVG.Unit.pt));
            lCc.put("x-small", new SVG.n(0.833f, SVG.Unit.pt));
            lCc.put("small", new SVG.n(10.0f, SVG.Unit.pt));
            lCc.put("medium", new SVG.n(12.0f, SVG.Unit.pt));
            lCc.put("large", new SVG.n(14.4f, SVG.Unit.pt));
            lCc.put("x-large", new SVG.n(17.3f, SVG.Unit.pt));
            lCc.put("xx-large", new SVG.n(20.7f, SVG.Unit.pt));
            lCc.put("smaller", new SVG.n(83.33f, SVG.Unit.percent));
            lCc.put("larger", new SVG.n(120.0f, SVG.Unit.percent));
        }

        public static SVG.n Of(String str) {
            return lCc.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class d {
        private static final Map<String, Integer> lCd = new HashMap(13);

        static {
            lCd.put("normal", 400);
            lCd.put("bold", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lCd.put("bolder", 1);
            lCd.put("lighter", -1);
            lCd.put("100", 100);
            lCd.put(BasicPushStatus.SUCCESS_CODE, 200);
            lCd.put("300", 300);
            lCd.put("400", 400);
            lCd.put("500", 500);
            lCd.put("600", Integer.valueOf((int) Constants.HTTP_DNS_INAVAILABLE_TIME));
            lCd.put("700", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lCd.put("800", 800);
            lCd.put("900", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
        }

        public static Integer Oe(String str) {
            return lCd.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final Map<String, PreserveAspectRatio.Alignment> lCa = new HashMap(10);

        static {
            lCa.put("none", PreserveAspectRatio.Alignment.None);
            lCa.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            lCa.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            lCa.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            lCa.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            lCa.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            lCa.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            lCa.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            lCa.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            lCa.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment Od(String str) {
            return lCa.get(str);
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
                    return this.lBO;
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
        this.lBO = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.lBQ) {
            this.lBR++;
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
                    this.lBS = true;
                    this.lBT = fromString;
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
                    this.lBQ = true;
                    this.lBR = 1;
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lBQ) {
            if (this.lBS) {
                if (this.lBU == null) {
                    this.lBU = new StringBuilder(i2);
                }
                this.lBU.append(cArr, i, i2);
            } else if (this.lBV) {
                if (this.lBW == null) {
                    this.lBW = new StringBuilder(i2);
                }
                this.lBW.append(cArr, i, i2);
            } else if (this.lBP instanceof SVG.av) {
                SVG.ae aeVar = (SVG.ae) this.lBP;
                int size = aeVar.ST.size();
                SVG.ak akVar = size == 0 ? null : aeVar.ST.get(size - 1);
                if (akVar instanceof SVG.az) {
                    SVG.az azVar = (SVG.az) akVar;
                    azVar.text += new String(cArr, i, i2);
                    return;
                }
                ((SVG.ae) this.lBP).a(new SVG.az(new String(cArr, i, i2)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lBQ && this.lBV) {
            if (this.lBW == null) {
                this.lBW = new StringBuilder(i2);
            }
            this.lBW.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.lBQ) {
            int i = this.lBR - 1;
            this.lBR = i;
            if (i == 0) {
                this.lBQ = false;
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
                    this.lBP = ((SVG.ak) this.lBP).lBc;
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
                    this.lBS = false;
                    if (this.lBT == SVGElem.title) {
                        this.lBO.setTitle(this.lBU.toString());
                    } else if (this.lBT == SVGElem.desc) {
                        this.lBO.setDesc(this.lBU.toString());
                    }
                    this.lBU.setLength(0);
                    return;
                case style:
                    if (this.lBW != null) {
                        this.lBV = false;
                        Oc(this.lBW.toString());
                        this.lBW.setLength(0);
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
        acVar.lBb = this.lBO;
        acVar.lBc = this.lBP;
        a((SVG.ai) acVar, attributes);
        b(acVar, attributes);
        a((SVG.ad) acVar, attributes);
        a((SVG.ao) acVar, attributes);
        a(acVar, attributes);
        if (this.lBP == null) {
            this.lBO.a(acVar);
        } else {
            this.lBP.a(acVar);
        }
        this.lBP = acVar;
    }

    private void a(SVG.ac acVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    acVar.lzF = NC(trim);
                    break;
                case y:
                    acVar.lzG = NC(trim);
                    break;
                case width:
                    acVar.lzH = NC(trim);
                    if (acVar.lzH.dgg()) {
                        throw new SAXException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    acVar.lzI = NC(trim);
                    if (acVar.lzI.dgg()) {
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
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.k kVar = new SVG.k();
        kVar.lBb = this.lBO;
        kVar.lBc = this.lBP;
        a((SVG.ai) kVar, attributes);
        b(kVar, attributes);
        a((SVG.l) kVar, attributes);
        a((SVG.ad) kVar, attributes);
        this.lBP.a(kVar);
        this.lBP = kVar;
    }

    private void c(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.g gVar = new SVG.g();
        gVar.lBb = this.lBO;
        gVar.lBc = this.lBP;
        a((SVG.ai) gVar, attributes);
        b(gVar, attributes);
        a((SVG.l) gVar, attributes);
        this.lBP.a(gVar);
        this.lBP = gVar;
    }

    private void d(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ba baVar = new SVG.ba();
        baVar.lBb = this.lBO;
        baVar.lBc = this.lBP;
        a((SVG.ai) baVar, attributes);
        b(baVar, attributes);
        a((SVG.l) baVar, attributes);
        a((SVG.ad) baVar, attributes);
        a(baVar, attributes);
        this.lBP.a(baVar);
        this.lBP = baVar;
    }

    private void a(SVG.ba baVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    baVar.lzF = NC(trim);
                    break;
                case y:
                    baVar.lzG = NC(trim);
                    break;
                case width:
                    baVar.lzH = NC(trim);
                    if (baVar.lzH.dgg()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    baVar.lzI = NC(trim);
                    if (baVar.lzI.dgg()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        baVar.Rz = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void e(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.m mVar = new SVG.m();
        mVar.lBb = this.lBO;
        mVar.lBc = this.lBP;
        a((SVG.ai) mVar, attributes);
        b(mVar, attributes);
        a((SVG.l) mVar, attributes);
        a((SVG.ad) mVar, attributes);
        a(mVar, attributes);
        this.lBP.a(mVar);
        this.lBP = mVar;
    }

    private void a(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    mVar.lzF = NC(trim);
                    break;
                case y:
                    mVar.lzG = NC(trim);
                    break;
                case width:
                    mVar.lzH = NC(trim);
                    if (mVar.lzH.dgg()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    mVar.lzI = NC(trim);
                    if (mVar.lzI.dgg()) {
                        throw new SAXException("Invalid <use> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        mVar.Rz = trim;
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
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.t tVar = new SVG.t();
        tVar.lBb = this.lBO;
        tVar.lBc = this.lBP;
        a((SVG.ai) tVar, attributes);
        b(tVar, attributes);
        a((SVG.l) tVar, attributes);
        a((SVG.ad) tVar, attributes);
        a(tVar, attributes);
        this.lBP.a(tVar);
    }

    private void a(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    tVar.lzX = NY(trim);
                    break;
                case pathLength:
                    tVar.lzY = Float.valueOf(parseFloat(trim));
                    if (tVar.lzY.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.z zVar = new SVG.z();
        zVar.lBb = this.lBO;
        zVar.lBc = this.lBP;
        a((SVG.ai) zVar, attributes);
        b(zVar, attributes);
        a((SVG.l) zVar, attributes);
        a((SVG.ad) zVar, attributes);
        a(zVar, attributes);
        this.lBP.a(zVar);
    }

    private void a(SVG.z zVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    zVar.lzF = NC(trim);
                    break;
                case y:
                    zVar.lzG = NC(trim);
                    break;
                case width:
                    zVar.lzH = NC(trim);
                    if (zVar.lzH.dgg()) {
                        throw new SAXException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    zVar.lzI = NC(trim);
                    if (zVar.lzI.dgg()) {
                        throw new SAXException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    zVar.lzz = NC(trim);
                    if (zVar.lzz.dgg()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    zVar.lzA = NC(trim);
                    if (zVar.lzA.dgg()) {
                        throw new SAXException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    private void h(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.c cVar = new SVG.c();
        cVar.lBb = this.lBO;
        cVar.lBc = this.lBP;
        a((SVG.ai) cVar, attributes);
        b(cVar, attributes);
        a((SVG.l) cVar, attributes);
        a((SVG.ad) cVar, attributes);
        a(cVar, attributes);
        this.lBP.a(cVar);
    }

    private void a(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    cVar.lzs = NC(trim);
                    break;
                case cy:
                    cVar.lzt = NC(trim);
                    break;
                case r:
                    cVar.lzu = NC(trim);
                    if (cVar.lzu.dgg()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void i(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.h hVar = new SVG.h();
        hVar.lBb = this.lBO;
        hVar.lBc = this.lBP;
        a((SVG.ai) hVar, attributes);
        b(hVar, attributes);
        a((SVG.l) hVar, attributes);
        a((SVG.ad) hVar, attributes);
        a(hVar, attributes);
        this.lBP.a(hVar);
    }

    private void a(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    hVar.lzz = NC(trim);
                    if (hVar.lzz.dgg()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.lzA = NC(trim);
                    if (hVar.lzA.dgg()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.lzs = NC(trim);
                    break;
                case cy:
                    hVar.lzt = NC(trim);
                    break;
            }
        }
    }

    private void j(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.o oVar = new SVG.o();
        oVar.lBb = this.lBO;
        oVar.lBc = this.lBP;
        a((SVG.ai) oVar, attributes);
        b(oVar, attributes);
        a((SVG.l) oVar, attributes);
        a((SVG.ad) oVar, attributes);
        a(oVar, attributes);
        this.lBP.a(oVar);
    }

    private void a(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    oVar.lzK = NC(trim);
                    break;
                case y1:
                    oVar.lzL = NC(trim);
                    break;
                case x2:
                    oVar.lzM = NC(trim);
                    break;
                case y2:
                    oVar.lzN = NC(trim);
                    break;
            }
        }
    }

    private void k(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.x xVar = new SVG.x();
        xVar.lBb = this.lBO;
        xVar.lBc = this.lBP;
        a((SVG.ai) xVar, attributes);
        b(xVar, attributes);
        a((SVG.l) xVar, attributes);
        a((SVG.ad) xVar, attributes);
        a(xVar, attributes, "polyline");
        this.lBP.a(xVar);
    }

    private void a(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                e eVar = new e(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                eVar.dgL();
                while (!eVar.dgK()) {
                    float dgN = eVar.dgN();
                    if (Float.isNaN(dgN)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    eVar.dgM();
                    float dgN2 = eVar.dgN();
                    if (Float.isNaN(dgN2)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    eVar.dgM();
                    arrayList.add(Float.valueOf(dgN));
                    arrayList.add(Float.valueOf(dgN2));
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
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.y yVar = new SVG.y();
        yVar.lBb = this.lBO;
        yVar.lBc = this.lBP;
        a((SVG.ai) yVar, attributes);
        b(yVar, attributes);
        a((SVG.l) yVar, attributes);
        a((SVG.ad) yVar, attributes);
        a(yVar, attributes, "polygon");
        this.lBP.a(yVar);
    }

    private void m(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.at atVar = new SVG.at();
        atVar.lBb = this.lBO;
        atVar.lBc = this.lBP;
        a((SVG.ai) atVar, attributes);
        b(atVar, attributes);
        a((SVG.l) atVar, attributes);
        a((SVG.ad) atVar, attributes);
        a((SVG.ax) atVar, attributes);
        this.lBP.a(atVar);
        this.lBP = atVar;
    }

    private void a(SVG.ax axVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    axVar.x = ND(trim);
                    break;
                case y:
                    axVar.y = ND(trim);
                    break;
                case dx:
                    axVar.lBj = ND(trim);
                    break;
                case dy:
                    axVar.lBk = ND(trim);
                    break;
            }
        }
    }

    private void n(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lBP instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.as asVar = new SVG.as();
        asVar.lBb = this.lBO;
        asVar.lBc = this.lBP;
        a((SVG.ai) asVar, attributes);
        b(asVar, attributes);
        a((SVG.ad) asVar, attributes);
        a((SVG.ax) asVar, attributes);
        this.lBP.a(asVar);
        this.lBP = asVar;
        if (asVar.lBc instanceof SVG.ay) {
            asVar.a((SVG.ay) asVar.lBc);
        } else {
            asVar.a(((SVG.au) asVar.lBc).dgn());
        }
    }

    private void o(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lBP instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.ar arVar = new SVG.ar();
        arVar.lBb = this.lBO;
        arVar.lBc = this.lBP;
        a((SVG.ai) arVar, attributes);
        b(arVar, attributes);
        a((SVG.ad) arVar, attributes);
        a(arVar, attributes);
        this.lBP.a(arVar);
        if (arVar.lBc instanceof SVG.ay) {
            arVar.a((SVG.ay) arVar.lBc);
        } else {
            arVar.a(((SVG.au) arVar.lBc).dgn());
        }
    }

    private void a(SVG.ar arVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        arVar.Rz = trim;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    private void p(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ap apVar = new SVG.ap();
        apVar.lBb = this.lBO;
        apVar.lBc = this.lBP;
        a((SVG.ai) apVar, attributes);
        b(apVar, attributes);
        a((SVG.l) apVar, attributes);
        a((SVG.ad) apVar, attributes);
        this.lBP.a(apVar);
        this.lBP = apVar;
    }

    private void a(SVG.ad adVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    adVar.i(NZ(trim));
                    break;
                case requiredExtensions:
                    adVar.Nv(trim);
                    break;
                case systemLanguage:
                    adVar.j(Oa(trim));
                    break;
                case requiredFormats:
                    adVar.k(Ob(trim));
                    break;
                case requiredFonts:
                    List<String> NJ = NJ(trim);
                    adVar.l(NJ != null ? new HashSet(NJ) : new HashSet(0));
                    break;
            }
        }
    }

    private void q(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aq aqVar = new SVG.aq();
        aqVar.lBb = this.lBO;
        aqVar.lBc = this.lBP;
        a((SVG.ai) aqVar, attributes);
        b(aqVar, attributes);
        a((SVG.ad) aqVar, attributes);
        a((SVG.ao) aqVar, attributes);
        this.lBP.a(aqVar);
        this.lBP = aqVar;
    }

    private void r(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.p pVar = new SVG.p();
        pVar.lBb = this.lBO;
        pVar.lBc = this.lBP;
        a((SVG.ai) pVar, attributes);
        b(pVar, attributes);
        a((SVG.ad) pVar, attributes);
        a((SVG.ao) pVar, attributes);
        a(pVar, attributes);
        this.lBP.a(pVar);
        this.lBP = pVar;
    }

    private void a(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    pVar.lzP = NC(trim);
                    break;
                case refY:
                    pVar.lzQ = NC(trim);
                    break;
                case markerWidth:
                    pVar.lzR = NC(trim);
                    if (pVar.lzR.dgg()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    pVar.lzS = NC(trim);
                    if (pVar.lzS.dgg()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        pVar.lzO = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        pVar.lzO = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        pVar.lzT = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        pVar.lzT = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void s(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aj ajVar = new SVG.aj();
        ajVar.lBb = this.lBO;
        ajVar.lBc = this.lBP;
        a((SVG.ai) ajVar, attributes);
        b(ajVar, attributes);
        a((SVG.i) ajVar, attributes);
        a(ajVar, attributes);
        this.lBP.a(ajVar);
        this.lBP = ajVar;
    }

    private void a(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        iVar.Rz = trim;
                        break;
                    } else {
                        break;
                    }
                case gradientUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        iVar.lzB = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.lzB = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.lzC = NB(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.lzD = SVG.GradientSpread.valueOf(trim);
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
                    ajVar.lzK = NC(trim);
                    break;
                case y1:
                    ajVar.lzL = NC(trim);
                    break;
                case x2:
                    ajVar.lzM = NC(trim);
                    break;
                case y2:
                    ajVar.lzN = NC(trim);
                    break;
            }
        }
    }

    private void t(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.an anVar = new SVG.an();
        anVar.lBb = this.lBO;
        anVar.lBc = this.lBP;
        a((SVG.ai) anVar, attributes);
        b(anVar, attributes);
        a((SVG.i) anVar, attributes);
        a(anVar, attributes);
        this.lBP.a(anVar);
        this.lBP = anVar;
    }

    private void a(SVG.an anVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    anVar.lzs = NC(trim);
                    break;
                case cy:
                    anVar.lzt = NC(trim);
                    break;
                case r:
                    anVar.lzu = NC(trim);
                    if (anVar.lzu.dgg()) {
                        throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    anVar.lBe = NC(trim);
                    break;
                case fy:
                    anVar.lBf = NC(trim);
                    break;
            }
        }
    }

    private void u(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lBP instanceof SVG.i)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.ab abVar = new SVG.ab();
        abVar.lBb = this.lBO;
        abVar.lBc = this.lBP;
        a((SVG.ai) abVar, attributes);
        b(abVar, attributes);
        a(abVar, attributes);
        this.lBP.a(abVar);
        this.lBP = abVar;
    }

    private void a(SVG.ab abVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    abVar.lAg = NA(trim);
                    break;
            }
        }
    }

    private Float NA(String str) throws SAXException {
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
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aa aaVar = new SVG.aa();
        aaVar.lBb = this.lBO;
        aaVar.lBc = this.lBP;
        a(aaVar, attributes);
        b(aaVar, attributes);
        this.lBP.a(aaVar);
        this.lBP = aaVar;
    }

    private void w(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.d dVar = new SVG.d();
        dVar.lBb = this.lBO;
        dVar.lBc = this.lBP;
        a((SVG.ai) dVar, attributes);
        b(dVar, attributes);
        a((SVG.l) dVar, attributes);
        a((SVG.ad) dVar, attributes);
        a(dVar, attributes);
        this.lBP.a(dVar);
        this.lBP = dVar;
    }

    private void a(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.lzv = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.lzv = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    private void x(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aw awVar = new SVG.aw();
        awVar.lBb = this.lBO;
        awVar.lBc = this.lBP;
        a((SVG.ai) awVar, attributes);
        b(awVar, attributes);
        a((SVG.ad) awVar, attributes);
        a(awVar, attributes);
        this.lBP.a(awVar);
        this.lBP = awVar;
        if (awVar.lBc instanceof SVG.ay) {
            awVar.a((SVG.ay) awVar.lBc);
        } else {
            awVar.a(((SVG.au) awVar.lBc).dgn());
        }
    }

    private void a(SVG.aw awVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        awVar.Rz = trim;
                        break;
                    } else {
                        break;
                    }
                case startOffset:
                    awVar.lBi = NC(trim);
                    break;
            }
        }
    }

    private void y(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.w wVar = new SVG.w();
        wVar.lBb = this.lBO;
        wVar.lBc = this.lBP;
        a((SVG.ai) wVar, attributes);
        b(wVar, attributes);
        a((SVG.ad) wVar, attributes);
        a((SVG.ao) wVar, attributes);
        a(wVar, attributes);
        this.lBP.a(wVar);
        this.lBP = wVar;
    }

    private void a(SVG.w wVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    wVar.lzF = NC(trim);
                    break;
                case y:
                    wVar.lzG = NC(trim);
                    break;
                case width:
                    wVar.lzH = NC(trim);
                    if (wVar.lzH.dgg()) {
                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    wVar.lzI = NC(trim);
                    if (wVar.lzI.dgg()) {
                        throw new SAXException("Invalid <pattern> element. height cannot be negative");
                    }
                    break;
                case href:
                    if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                        wVar.Rz = trim;
                        break;
                    } else {
                        break;
                    }
                case patternUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lAd = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lAd = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lAe = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lAe = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    wVar.lAf = NB(trim);
                    break;
            }
        }
    }

    private void z(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.bb bbVar = new SVG.bb();
        bbVar.lBb = this.lBO;
        bbVar.lBc = this.lBP;
        a((SVG.ai) bbVar, attributes);
        a((SVG.ad) bbVar, attributes);
        a((SVG.ao) bbVar, attributes);
        this.lBP.a(bbVar);
        this.lBP = bbVar;
    }

    private void A(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.lBP == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.q qVar = new SVG.q();
        qVar.lBb = this.lBO;
        qVar.lBc = this.lBP;
        a((SVG.ai) qVar, attributes);
        b(qVar, attributes);
        a((SVG.ad) qVar, attributes);
        a(qVar, attributes);
        this.lBP.a(qVar);
        this.lBP = qVar;
    }

    private void a(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    qVar.lzF = NC(trim);
                    break;
                case y:
                    qVar.lzG = NC(trim);
                    break;
                case width:
                    qVar.lzH = NC(trim);
                    if (qVar.lzH.dgg()) {
                        throw new SAXException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    qVar.lzI = NC(trim);
                    if (qVar.lzI.dgg()) {
                        throw new SAXException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lzU = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lzU = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lzV = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lzV = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskContentUnits");
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public static class e {
        protected String lCe;
        protected int lCf;
        protected int position = 0;
        private com.caverock.androidsvg.b lCg = new com.caverock.androidsvg.b();

        public e(String str) {
            this.lCf = 0;
            this.lCe = str.trim();
            this.lCf = this.lCe.length();
        }

        public boolean dgK() {
            return this.position == this.lCf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean GY(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public void dgL() {
            while (this.position < this.lCf && GY(this.lCe.charAt(this.position))) {
                this.position++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean GZ(int i) {
            return i == 10 || i == 13;
        }

        public boolean dgM() {
            dgL();
            if (this.position != this.lCf && this.lCe.charAt(this.position) == ',') {
                this.position++;
                dgL();
                return true;
            }
            return false;
        }

        public float dgN() {
            float B = this.lCg.B(this.lCe, this.position, this.lCf);
            if (!Float.isNaN(B)) {
                this.position = this.lCg.dfV();
            }
            return B;
        }

        public float dgO() {
            dgM();
            float B = this.lCg.B(this.lCe, this.position, this.lCf);
            if (!Float.isNaN(B)) {
                this.position = this.lCg.dfV();
            }
            return B;
        }

        public float bk(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            dgM();
            return dgN();
        }

        public Integer dgP() {
            if (this.position == this.lCf) {
                return null;
            }
            String str = this.lCe;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.n dgQ() {
            float dgN = dgN();
            if (Float.isNaN(dgN)) {
                return null;
            }
            SVG.Unit dgV = dgV();
            if (dgV == null) {
                return new SVG.n(dgN, SVG.Unit.px);
            }
            return new SVG.n(dgN, dgV);
        }

        public Boolean dgR() {
            if (this.position == this.lCf) {
                return null;
            }
            char charAt = this.lCe.charAt(this.position);
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
            dgM();
            return dgR();
        }

        public boolean g(char c) {
            boolean z = this.position < this.lCf && this.lCe.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        public boolean Og(String str) {
            int length = str.length();
            boolean z = this.position <= this.lCf - length && this.lCe.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int dgS() {
            if (this.position == this.lCf) {
                return -1;
            }
            this.position++;
            if (this.position < this.lCf) {
                return this.lCe.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return h(' ');
        }

        public String h(char c) {
            if (dgK()) {
                return null;
            }
            char charAt = this.lCe.charAt(this.position);
            if (GY(charAt) || charAt == c) {
                return null;
            }
            int i = this.position;
            int dgS = dgS();
            while (dgS != -1 && dgS != c && !GY(dgS)) {
                dgS = dgS();
            }
            return this.lCe.substring(i, this.position);
        }

        public String dgT() {
            if (dgK()) {
                return null;
            }
            int i = this.position;
            int charAt = this.lCe.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = dgS();
            }
            int i2 = this.position;
            while (GY(charAt)) {
                charAt = dgS();
            }
            if (charAt == 40) {
                this.position++;
                return this.lCe.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        public String dgU() {
            int i = this.position;
            while (!dgK() && !GY(this.lCe.charAt(this.position))) {
                this.position++;
            }
            String substring = this.lCe.substring(i, this.position);
            this.position = i;
            return substring;
        }

        public SVG.Unit dgV() {
            if (dgK()) {
                return null;
            }
            if (this.lCe.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            } else if (this.position <= this.lCf - 2) {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.lCe.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                return null;
            }
        }

        public boolean dgW() {
            if (this.position == this.lCf) {
                return false;
            }
            char charAt = this.lCe.charAt(this.position);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public String dgX() {
            if (dgK()) {
                return null;
            }
            int i = this.position;
            char charAt = this.lCe.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                int dgS = dgS();
                while (dgS != -1 && dgS != charAt) {
                    dgS = dgS();
                }
                if (dgS == -1) {
                    this.position = i;
                    return null;
                }
                this.position++;
                return this.lCe.substring(i + 1, this.position - 1);
            }
            return null;
        }

        public String dgY() {
            if (dgK()) {
                return null;
            }
            int i = this.position;
            this.position = this.lCf;
            return this.lCe.substring(i);
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
                if (DefaultSharedPrefsWrapper.SP_FILE_DEFAULT.equals(trim)) {
                    aiVar.lAY = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    aiVar.lAY = Boolean.TRUE;
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
                        aiVar.lBa = CSSParser.Nr(trim);
                        continue;
                    default:
                        if (aiVar.lAZ == null) {
                            aiVar.lAZ = new SVG.Style();
                        }
                        a(aiVar.lAZ, attributes.getLocalName(i), attributes.getValue(i).trim());
                        continue;
                }
            }
        }
    }

    private static void a(SVG.ai aiVar, String str) throws SAXException {
        e eVar = new e(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String h = eVar.h(':');
            eVar.dgL();
            if (eVar.g(':')) {
                eVar.dgL();
                String h2 = eVar.h(';');
                if (h2 != null) {
                    eVar.dgL();
                    if (eVar.dgK() || eVar.g(';')) {
                        if (aiVar.lyK == null) {
                            aiVar.lyK = new SVG.Style();
                        }
                        a(aiVar.lyK, h, h2);
                        eVar.dgL();
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
                    style.lAi = eW(str2, "fill");
                    style.lAh |= 1;
                    return;
                case fill_rule:
                    style.lAj = NQ(str2);
                    style.lAh |= 2;
                    return;
                case fill_opacity:
                    style.lAk = Float.valueOf(NE(str2));
                    style.lAh |= 4;
                    return;
                case stroke:
                    style.lAl = eW(str2, "stroke");
                    style.lAh |= 8;
                    return;
                case stroke_opacity:
                    style.lAm = Float.valueOf(NE(str2));
                    style.lAh |= 16;
                    return;
                case stroke_width:
                    style.lAn = NC(str2);
                    style.lAh |= 32;
                    return;
                case stroke_linecap:
                    style.lAo = NR(str2);
                    style.lAh |= 64;
                    return;
                case stroke_linejoin:
                    style.lAp = NS(str2);
                    style.lAh |= 128;
                    return;
                case stroke_miterlimit:
                    style.lAq = Float.valueOf(parseFloat(str2));
                    style.lAh |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.lAr = null;
                    } else {
                        style.lAr = NT(str2);
                    }
                    style.lAh |= 512;
                    return;
                case stroke_dashoffset:
                    style.lAs = NC(str2);
                    style.lAh |= 1024;
                    return;
                case opacity:
                    style.lAt = Float.valueOf(NE(str2));
                    style.lAh |= 2048;
                    return;
                case color:
                    style.lAu = NH(str2);
                    style.lAh |= 4096;
                    return;
                case font:
                    a(style, str2);
                    return;
                case font_family:
                    style.lAv = NJ(str2);
                    style.lAh |= 8192;
                    return;
                case font_size:
                    style.lAw = NK(str2);
                    style.lAh |= 16384;
                    return;
                case font_weight:
                    style.lAx = NL(str2);
                    style.lAh |= 32768;
                    return;
                case font_style:
                    style.lAy = NM(str2);
                    style.lAh |= 65536;
                    return;
                case text_decoration:
                    style.lAz = NO(str2);
                    style.lAh |= 131072;
                    return;
                case direction:
                    style.lAA = NP(str2);
                    style.lAh |= 68719476736L;
                    return;
                case text_anchor:
                    style.lAB = NU(str2);
                    style.lAh |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    return;
                case overflow:
                    style.lAC = NV(str2);
                    style.lAh |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case marker:
                    style.lAE = eX(str2, str);
                    style.lAF = style.lAE;
                    style.lAG = style.lAE;
                    style.lAh |= 14680064;
                    return;
                case marker_start:
                    style.lAE = eX(str2, str);
                    style.lAh |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.lAF = eX(str2, str);
                    style.lAh |= ImageUploadStrategy.FILE_SIZE_4M;
                    return;
                case marker_end:
                    style.lAG = eX(str2, str);
                    style.lAh |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    style.lAH = Boolean.valueOf(!str2.equals("none"));
                    style.lAh |= AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH;
                    return;
                case visibility:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|visible|hidden|collapse|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    style.lAI = Boolean.valueOf(str2.equals("visible"));
                    style.lAh |= 33554432;
                    return;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        style.lAJ = SVG.f.dgf();
                    } else {
                        style.lAJ = NH(str2);
                    }
                    style.lAh |= 67108864;
                    return;
                case stop_opacity:
                    style.lAK = Float.valueOf(NE(str2));
                    style.lAh |= 134217728;
                    return;
                case clip:
                    style.lAD = NW(str2);
                    style.lAh |= 1048576;
                    return;
                case clip_path:
                    style.clipPath = eX(str2, str);
                    style.lAh |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case clip_rule:
                    style.lAL = NQ(str2);
                    style.lAh |= IjkMediaMeta.AV_CH_STEREO_LEFT;
                    return;
                case mask:
                    style.lAM = eX(str2, str);
                    style.lAh |= IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    return;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        style.lAN = SVG.f.dgf();
                    } else {
                        style.lAN = NH(str2);
                    }
                    style.lAh |= IjkMediaMeta.AV_CH_WIDE_LEFT;
                    return;
                case solid_opacity:
                    style.lAO = Float.valueOf(NE(str2));
                    style.lAh |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        style.lAP = SVG.f.dgf();
                    } else {
                        style.lAP = NH(str2);
                    }
                    style.lAh |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                    return;
                case viewport_fill_opacity:
                    style.lAQ = Float.valueOf(NE(str2));
                    style.lAh |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                    return;
                case vector_effect:
                    style.lAR = NX(str2);
                    style.lAh |= IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
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
                    aoVar.lBg = NF(trim);
                    break;
            }
        }
    }

    private void a(SVG.l lVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                lVar.c(NB(attributes.getValue(i)));
            }
        }
    }

    private Matrix NB(String str) throws SAXException {
        Matrix matrix = new Matrix();
        e eVar = new e(str);
        eVar.dgL();
        while (!eVar.dgK()) {
            String dgT = eVar.dgT();
            if (dgT == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (dgT.equals("matrix")) {
                eVar.dgL();
                float dgN = eVar.dgN();
                eVar.dgM();
                float dgN2 = eVar.dgN();
                eVar.dgM();
                float dgN3 = eVar.dgN();
                eVar.dgM();
                float dgN4 = eVar.dgN();
                eVar.dgM();
                float dgN5 = eVar.dgN();
                eVar.dgM();
                float dgN6 = eVar.dgN();
                eVar.dgL();
                if (Float.isNaN(dgN6) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{dgN, dgN3, dgN5, dgN2, dgN4, dgN6, 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (dgT.equals("translate")) {
                eVar.dgL();
                float dgN7 = eVar.dgN();
                float dgO = eVar.dgO();
                eVar.dgL();
                if (Float.isNaN(dgN7) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dgO)) {
                    matrix.preTranslate(dgN7, 0.0f);
                } else {
                    matrix.preTranslate(dgN7, dgO);
                }
            } else if (dgT.equals("scale")) {
                eVar.dgL();
                float dgN8 = eVar.dgN();
                float dgO2 = eVar.dgO();
                eVar.dgL();
                if (Float.isNaN(dgN8) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dgO2)) {
                    matrix.preScale(dgN8, dgN8);
                } else {
                    matrix.preScale(dgN8, dgO2);
                }
            } else if (dgT.equals(RotateImageAction.ACTION_NAME)) {
                eVar.dgL();
                float dgN9 = eVar.dgN();
                float dgO3 = eVar.dgO();
                float dgO4 = eVar.dgO();
                eVar.dgL();
                if (Float.isNaN(dgN9) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(dgO3)) {
                    matrix.preRotate(dgN9);
                } else if (!Float.isNaN(dgO4)) {
                    matrix.preRotate(dgN9, dgO3, dgO4);
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (dgT.equals("skewX")) {
                eVar.dgL();
                float dgN10 = eVar.dgN();
                eVar.dgL();
                if (Float.isNaN(dgN10) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(dgN10)), 0.0f);
            } else if (dgT.equals("skewY")) {
                eVar.dgL();
                float dgN11 = eVar.dgN();
                eVar.dgL();
                if (Float.isNaN(dgN11) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(dgN11)));
            } else if (dgT != null) {
                throw new SAXException("Invalid transform list fn: " + dgT + ")");
            }
            if (eVar.dgK()) {
                break;
            }
            eVar.dgM();
        }
        return matrix;
    }

    protected static SVG.n NC(String str) throws SAXException {
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

    private static List<SVG.n> ND(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e(str);
        eVar.dgL();
        while (!eVar.dgK()) {
            float dgN = eVar.dgN();
            if (Float.isNaN(dgN)) {
                throw new SAXException("Invalid length list value: " + eVar.dgU());
            }
            SVG.Unit dgV = eVar.dgV();
            if (dgV == null) {
                dgV = SVG.Unit.px;
            }
            arrayList.add(new SVG.n(dgN, dgV));
            eVar.dgM();
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

    private static float NE(String str) throws SAXException {
        float parseFloat = parseFloat(str);
        if (parseFloat < 0.0f) {
            return 0.0f;
        }
        if (parseFloat > 1.0f) {
            return 1.0f;
        }
        return parseFloat;
    }

    private static SVG.a NF(String str) throws SAXException {
        e eVar = new e(str);
        eVar.dgL();
        float dgN = eVar.dgN();
        eVar.dgM();
        float dgN2 = eVar.dgN();
        eVar.dgM();
        float dgN3 = eVar.dgN();
        eVar.dgM();
        float dgN4 = eVar.dgN();
        if (Float.isNaN(dgN) || Float.isNaN(dgN2) || Float.isNaN(dgN3) || Float.isNaN(dgN4)) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        }
        if (dgN3 < 0.0f) {
            throw new SAXException("Invalid viewBox. width cannot be negative");
        }
        if (dgN4 < 0.0f) {
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
        return new SVG.a(dgN, dgN2, dgN3, dgN4);
    }

    private static void a(SVG.am amVar, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        e eVar = new e(str);
        eVar.dgL();
        String nextToken = eVar.nextToken();
        if ("defer".equals(nextToken)) {
            eVar.dgL();
            nextToken = eVar.nextToken();
        }
        PreserveAspectRatio.Alignment Od = a.Od(nextToken);
        eVar.dgL();
        if (eVar.dgK()) {
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
        amVar.lBd = new PreserveAspectRatio(Od, scale);
    }

    private static SVG.al eW(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf == -1) {
                throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
            }
            String trim = str.substring(4, indexOf).trim();
            SVG.al alVar = null;
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim2.length() > 0) {
                alVar = NG(trim2);
            }
            return new SVG.s(trim, alVar);
        }
        return NG(str);
    }

    private static SVG.al NG(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.f.dgf();
        }
        return NH(str);
    }

    private static SVG.e NH(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.a A = com.caverock.androidsvg.a.A(str, 1, str.length());
            if (A == null) {
                throw new SAXException("Bad hex colour value: " + str);
            }
            int dfV = A.dfV();
            if (dfV == 7) {
                return new SVG.e(A.value());
            }
            if (dfV == 4) {
                int value = A.value();
                int i = value & 3840;
                int i2 = value & 240;
                int i3 = value & 15;
                return new SVG.e((i << 12) | (i << 16) | (i2 << 8) | (i2 << 4) | (i3 << 4) | i3);
            }
            throw new SAXException("Bad hex colour value: " + str);
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            e eVar = new e(str.substring(4));
            eVar.dgL();
            float dgN = eVar.dgN();
            if (!Float.isNaN(dgN) && eVar.g('%')) {
                dgN = (dgN * 256.0f) / 100.0f;
            }
            float bk = eVar.bk(dgN);
            if (!Float.isNaN(bk) && eVar.g('%')) {
                bk = (bk * 256.0f) / 100.0f;
            }
            float bk2 = eVar.bk(bk);
            if (!Float.isNaN(bk2) && eVar.g('%')) {
                bk2 = (bk2 * 256.0f) / 100.0f;
            }
            eVar.dgL();
            if (Float.isNaN(bk2) || !eVar.g(')')) {
                throw new SAXException("Bad rgb() colour value: " + str);
            }
            return new SVG.e((bj(dgN) << 16) | (bj(bk) << 8) | bj(bk2));
        } else {
            return NI(str);
        }
    }

    private static int bj(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static SVG.e NI(String str) throws SAXException {
        Integer Oe = b.Oe(str.toLowerCase(Locale.US));
        if (Oe == null) {
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return new SVG.e(Oe.intValue());
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
                eVar.dgL();
                if (h == null) {
                    throw new SAXException("Invalid font style attribute: missing font size and family");
                }
                if (num != null && fontStyle != null) {
                    break;
                } else if (!h.equals("normal") && (num != null || (num = d.Oe(h)) == null)) {
                    if (fontStyle != null || (fontStyle = NN(h)) == null) {
                        if (str2 != null || !h.equals("small-caps")) {
                            break;
                        }
                        str2 = h;
                    }
                }
            }
            SVG.n NK = NK(h);
            if (eVar.g('/')) {
                eVar.dgL();
                String nextToken = eVar.nextToken();
                if (nextToken == null) {
                    throw new SAXException("Invalid font style attribute: missing line-height");
                }
                NC(nextToken);
                eVar.dgL();
            }
            style.lAv = NJ(eVar.dgY());
            style.lAw = NK;
            style.lAx = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.lAy = fontStyle;
            style.lAh |= 122880;
        }
    }

    private static List<String> NJ(String str) throws SAXException {
        ArrayList arrayList = null;
        e eVar = new e(str);
        do {
            String dgX = eVar.dgX();
            if (dgX == null) {
                dgX = eVar.h(',');
            }
            if (dgX == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(dgX);
            eVar.dgM();
        } while (!eVar.dgK());
        return arrayList;
    }

    private static SVG.n NK(String str) throws SAXException {
        SVG.n Of = c.Of(str);
        if (Of == null) {
            return NC(str);
        }
        return Of;
    }

    private static Integer NL(String str) throws SAXException {
        Integer Oe = d.Oe(str);
        if (Oe == null) {
            throw new SAXException("Invalid font-weight property: " + str);
        }
        return Oe;
    }

    private static SVG.Style.FontStyle NM(String str) throws SAXException {
        SVG.Style.FontStyle NN = NN(str);
        if (NN != null) {
            return NN;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static SVG.Style.FontStyle NN(String str) {
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

    private static SVG.Style.TextDecoration NO(String str) throws SAXException {
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

    private static SVG.Style.TextDirection NP(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private static SVG.Style.FillRule NQ(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static SVG.Style.LineCaps NR(String str) throws SAXException {
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

    private static SVG.Style.LineJoin NS(String str) throws SAXException {
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

    private static SVG.n[] NT(String str) throws SAXException {
        SVG.n dgQ;
        e eVar = new e(str);
        eVar.dgL();
        if (!eVar.dgK() && (dgQ = eVar.dgQ()) != null) {
            if (dgQ.dgg()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            float floatValue = dgQ.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(dgQ);
            while (!eVar.dgK()) {
                eVar.dgM();
                SVG.n dgQ2 = eVar.dgQ();
                if (dgQ2 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
                if (dgQ2.dgg()) {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                }
                arrayList.add(dgQ2);
                floatValue += dgQ2.floatValue();
            }
            if (floatValue == 0.0f) {
                return null;
            }
            return (SVG.n[]) arrayList.toArray(new SVG.n[arrayList.size()]);
        }
        return null;
    }

    private static SVG.Style.TextAnchor NU(String str) throws SAXException {
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

    private static Boolean NV(String str) throws SAXException {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private static SVG.b NW(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (!str.toLowerCase(Locale.US).startsWith("rect(")) {
            throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
        }
        e eVar = new e(str.substring(5));
        eVar.dgL();
        SVG.n a2 = a(eVar);
        eVar.dgM();
        SVG.n a3 = a(eVar);
        eVar.dgM();
        SVG.n a4 = a(eVar);
        eVar.dgM();
        SVG.n a5 = a(eVar);
        eVar.dgL();
        if (!eVar.g(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.b(a2, a3, a4, a5);
    }

    private static SVG.n a(e eVar) {
        return eVar.Og("auto") ? new SVG.n(0.0f) : eVar.dgQ();
    }

    private static SVG.Style.VectorEffect NX(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private static SVG.u NY(String str) throws SAXException {
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
        float dgO;
        float bk;
        float f10;
        e eVar = new e(str);
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        SVG.u uVar = new SVG.u();
        if (!eVar.dgK() && ((intValue = eVar.dgP().intValue()) == 77 || intValue == 109)) {
            while (true) {
                while (true) {
                    float f17 = f14;
                    float f18 = f13;
                    int i = intValue;
                    float f19 = f12;
                    float f20 = f11;
                    float f21 = f15;
                    float f22 = f16;
                    eVar.dgL();
                    switch (i) {
                        case 65:
                        case 97:
                            float dgN = eVar.dgN();
                            float bk2 = eVar.bk(dgN);
                            float bk3 = eVar.bk(bk2);
                            Boolean aJ = eVar.aJ(Float.valueOf(bk3));
                            Boolean aJ2 = eVar.aJ(aJ);
                            if (aJ2 == null) {
                                bk = Float.NaN;
                                dgO = Float.NaN;
                            } else {
                                dgO = eVar.dgO();
                                bk = eVar.bk(dgO);
                            }
                            if (!Float.isNaN(bk) && dgN >= 0.0f && bk2 >= 0.0f) {
                                if (i == 97) {
                                    float f23 = f20 + dgO;
                                    f10 = bk + f19;
                                    f11 = f23;
                                } else {
                                    float f24 = bk;
                                    f11 = dgO;
                                    f10 = f24;
                                }
                                uVar.a(dgN, bk2, bk3, aJ.booleanValue(), aJ2.booleanValue(), f11, f10);
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
                            float dgN2 = eVar.dgN();
                            float bk4 = eVar.bk(dgN2);
                            float bk5 = eVar.bk(bk4);
                            float bk6 = eVar.bk(bk5);
                            float bk7 = eVar.bk(bk6);
                            float bk8 = eVar.bk(bk7);
                            if (Float.isNaN(bk8)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 99) {
                                    float f25 = bk8 + f19;
                                    bk4 += f19;
                                    bk5 += f20;
                                    f6 = f19 + bk6;
                                    f8 = dgN2 + f20;
                                    f7 = bk7 + f20;
                                    f9 = f25;
                                } else {
                                    f6 = bk6;
                                    f7 = bk7;
                                    f8 = dgN2;
                                    f9 = bk8;
                                }
                                uVar.b(f8, bk4, bk5, f6, f7, f9);
                                f16 = f6;
                                f15 = bk5;
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
                            float dgN3 = eVar.dgN();
                            if (Float.isNaN(dgN3)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 104) {
                                    dgN3 += f20;
                                }
                                uVar.B(dgN3, f19);
                                f14 = f17;
                                f12 = f19;
                                f11 = dgN3;
                                intValue = i;
                                f13 = f18;
                                f15 = dgN3;
                                f16 = f22;
                                break;
                            }
                        case 76:
                        case 108:
                            f15 = eVar.dgN();
                            f16 = eVar.bk(f15);
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
                            f15 = eVar.dgN();
                            f16 = eVar.bk(f15);
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
                            f15 = eVar.dgN();
                            f16 = eVar.bk(f15);
                            float bk9 = eVar.bk(f16);
                            float bk10 = eVar.bk(bk9);
                            if (Float.isNaN(bk10)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 113) {
                                    bk10 += f19;
                                    f15 += f20;
                                    f16 += f19;
                                    f = bk9 + f20;
                                } else {
                                    f = bk9;
                                }
                                uVar.l(f15, f16, f, bk10);
                                f12 = bk10;
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
                            float dgN4 = eVar.dgN();
                            float bk11 = eVar.bk(dgN4);
                            float bk12 = eVar.bk(bk11);
                            float bk13 = eVar.bk(bk12);
                            if (Float.isNaN(bk13)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 115) {
                                    float f29 = bk13 + f19;
                                    f2 = f19 + bk11;
                                    f4 = f20 + dgN4;
                                    f5 = f29;
                                    f3 = bk12 + f20;
                                } else {
                                    f2 = bk11;
                                    f3 = bk12;
                                    f4 = dgN4;
                                    f5 = bk13;
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
                            float dgN5 = eVar.dgN();
                            float bk14 = eVar.bk(dgN5);
                            if (Float.isNaN(bk14)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 116) {
                                    dgN5 += f20;
                                    bk14 += f19;
                                }
                                uVar.l(f31, f32, dgN5, bk14);
                                f13 = f18;
                                f12 = bk14;
                                f11 = dgN5;
                                f16 = f32;
                                f15 = f31;
                                f14 = f17;
                                intValue = i;
                                break;
                            }
                        case 86:
                        case 118:
                            float dgN6 = eVar.dgN();
                            if (Float.isNaN(dgN6)) {
                                Log.e("SVGParser", "Bad path coords for " + ((char) i) + " path segment");
                                break;
                            } else {
                                if (i == 118) {
                                    dgN6 += f19;
                                }
                                uVar.B(f20, dgN6);
                                f14 = f17;
                                f13 = f18;
                                f11 = f20;
                                intValue = i;
                                f12 = dgN6;
                                float f33 = dgN6;
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
                    eVar.dgM();
                    if (!eVar.dgK()) {
                        if (eVar.dgW()) {
                            intValue = eVar.dgP().intValue();
                        }
                    }
                }
            }
        }
        return uVar;
    }

    private static Set<String> NZ(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dgK()) {
            String nextToken = eVar.nextToken();
            if (nextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(nextToken.substring("http://www.w3.org/TR/SVG11/feature#".length()));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            eVar.dgL();
        }
        return hashSet;
    }

    private static Set<String> Oa(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dgK()) {
            String nextToken = eVar.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            eVar.dgL();
        }
        return hashSet;
    }

    private static Set<String> Ob(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.dgK()) {
            hashSet.add(eVar.nextToken());
            eVar.dgL();
        }
        return hashSet;
    }

    private static String eX(String str, String str2) throws SAXException {
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
        if (this.lBP == null) {
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
            this.lBV = true;
            return;
        }
        this.lBQ = true;
        this.lBR = 1;
    }

    private void Oc(String str) throws SAXException {
        this.lBO.b(new CSSParser(CSSParser.MediaType.screen).Nq(str));
    }
}
