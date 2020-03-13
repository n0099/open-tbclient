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
    private int lGo;
    private SVG lGl = null;
    private SVG.ag lGm = null;
    private boolean lGn = false;
    private boolean lGp = false;
    private SVGElem lGq = null;
    private StringBuilder lGr = null;
    private boolean lGs = false;
    private StringBuilder lGt = null;
    private Set<String> lGu = null;

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
        private static final Map<String, Integer> lGy = new HashMap(47);

        static {
            lGy.put("aliceblue", 15792383);
            lGy.put("antiquewhite", 16444375);
            lGy.put("aqua", 65535);
            lGy.put("aquamarine", 8388564);
            lGy.put("azure", 15794175);
            lGy.put("beige", 16119260);
            lGy.put("bisque", 16770244);
            lGy.put("black", 0);
            lGy.put("blanchedalmond", 16772045);
            lGy.put("blue", 255);
            lGy.put("blueviolet", 9055202);
            lGy.put("brown", 10824234);
            lGy.put("burlywood", 14596231);
            lGy.put("cadetblue", 6266528);
            lGy.put("chartreuse", 8388352);
            lGy.put("chocolate", 13789470);
            lGy.put("coral", 16744272);
            lGy.put("cornflowerblue", 6591981);
            lGy.put("cornsilk", 16775388);
            lGy.put("crimson", 14423100);
            lGy.put("cyan", 65535);
            lGy.put("darkblue", 139);
            lGy.put("darkcyan", 35723);
            lGy.put("darkgoldenrod", 12092939);
            lGy.put("darkgray", 11119017);
            lGy.put("darkgreen", 25600);
            lGy.put("darkgrey", 11119017);
            lGy.put("darkkhaki", 12433259);
            lGy.put("darkmagenta", 9109643);
            lGy.put("darkolivegreen", 5597999);
            lGy.put("darkorange", 16747520);
            lGy.put("darkorchid", 10040012);
            lGy.put("darkred", 9109504);
            lGy.put("darksalmon", 15308410);
            lGy.put("darkseagreen", 9419919);
            lGy.put("darkslateblue", 4734347);
            lGy.put("darkslategray", 3100495);
            lGy.put("darkslategrey", 3100495);
            lGy.put("darkturquoise", 52945);
            lGy.put("darkviolet", 9699539);
            lGy.put("deeppink", 16716947);
            lGy.put("deepskyblue", 49151);
            lGy.put("dimgray", 6908265);
            lGy.put("dimgrey", 6908265);
            lGy.put("dodgerblue", 2003199);
            lGy.put("firebrick", 11674146);
            lGy.put("floralwhite", 16775920);
            lGy.put("forestgreen", 2263842);
            lGy.put("fuchsia", 16711935);
            lGy.put("gainsboro", 14474460);
            lGy.put("ghostwhite", 16316671);
            lGy.put("gold", 16766720);
            lGy.put("goldenrod", 14329120);
            lGy.put(com.baidu.fsg.face.base.b.c.m, 8421504);
            lGy.put("green", 32768);
            lGy.put("greenyellow", 11403055);
            lGy.put("grey", 8421504);
            lGy.put("honeydew", 15794160);
            lGy.put("hotpink", 16738740);
            lGy.put("indianred", 13458524);
            lGy.put("indigo", 4915330);
            lGy.put("ivory", 16777200);
            lGy.put("khaki", 15787660);
            lGy.put("lavender", 15132410);
            lGy.put("lavenderblush", 16773365);
            lGy.put("lawngreen", 8190976);
            lGy.put("lemonchiffon", 16775885);
            lGy.put("lightblue", 11393254);
            lGy.put("lightcoral", 15761536);
            lGy.put("lightcyan", 14745599);
            lGy.put("lightgoldenrodyellow", 16448210);
            lGy.put("lightgray", 13882323);
            lGy.put("lightgreen", 9498256);
            lGy.put("lightgrey", 13882323);
            lGy.put("lightpink", 16758465);
            lGy.put("lightsalmon", 16752762);
            lGy.put("lightseagreen", 2142890);
            lGy.put("lightskyblue", 8900346);
            lGy.put("lightslategray", 7833753);
            lGy.put("lightslategrey", 7833753);
            lGy.put("lightsteelblue", 11584734);
            lGy.put("lightyellow", 16777184);
            lGy.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
            lGy.put("limegreen", 3329330);
            lGy.put("linen", 16445670);
            lGy.put("magenta", 16711935);
            lGy.put("maroon", 8388608);
            lGy.put("mediumaquamarine", 6737322);
            lGy.put("mediumblue", 205);
            lGy.put("mediumorchid", 12211667);
            lGy.put("mediumpurple", 9662683);
            lGy.put("mediumseagreen", 3978097);
            lGy.put("mediumslateblue", 8087790);
            lGy.put("mediumspringgreen", 64154);
            lGy.put("mediumturquoise", 4772300);
            lGy.put("mediumvioletred", 13047173);
            lGy.put("midnightblue", 1644912);
            lGy.put("mintcream", 16121850);
            lGy.put("mistyrose", 16770273);
            lGy.put("moccasin", 16770229);
            lGy.put("navajowhite", 16768685);
            lGy.put("navy", 128);
            lGy.put("oldlace", 16643558);
            lGy.put("olive", 8421376);
            lGy.put("olivedrab", 7048739);
            lGy.put("orange", 16753920);
            lGy.put("orangered", 16729344);
            lGy.put("orchid", 14315734);
            lGy.put("palegoldenrod", 15657130);
            lGy.put("palegreen", 10025880);
            lGy.put("paleturquoise", 11529966);
            lGy.put("palevioletred", 14381203);
            lGy.put("papayawhip", 16773077);
            lGy.put("peachpuff", 16767673);
            lGy.put("peru", 13468991);
            lGy.put("pink", 16761035);
            lGy.put("plum", 14524637);
            lGy.put("powderblue", 11591910);
            lGy.put("purple", 8388736);
            lGy.put("red", 16711680);
            lGy.put("rosybrown", 12357519);
            lGy.put("royalblue", 4286945);
            lGy.put("saddlebrown", 9127187);
            lGy.put("salmon", 16416882);
            lGy.put("sandybrown", 16032864);
            lGy.put("seagreen", 3050327);
            lGy.put("seashell", 16774638);
            lGy.put("sienna", 10506797);
            lGy.put("silver", 12632256);
            lGy.put("skyblue", 8900331);
            lGy.put("slateblue", 6970061);
            lGy.put("slategray", 7372944);
            lGy.put("slategrey", 7372944);
            lGy.put("snow", 16775930);
            lGy.put("springgreen", 65407);
            lGy.put("steelblue", 4620980);
            lGy.put("tan", 13808780);
            lGy.put("teal", 32896);
            lGy.put("thistle", 14204888);
            lGy.put("tomato", 16737095);
            lGy.put("turquoise", 4251856);
            lGy.put("violet", 15631086);
            lGy.put("wheat", 16113331);
            lGy.put("white", 16777215);
            lGy.put("whitesmoke", 16119285);
            lGy.put("yellow", 16776960);
            lGy.put("yellowgreen", 10145074);
        }

        public static Integer OB(String str) {
            return lGy.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c {
        private static final Map<String, SVG.n> lGz = new HashMap(9);

        static {
            lGz.put("xx-small", new SVG.n(0.694f, SVG.Unit.pt));
            lGz.put("x-small", new SVG.n(0.833f, SVG.Unit.pt));
            lGz.put("small", new SVG.n(10.0f, SVG.Unit.pt));
            lGz.put("medium", new SVG.n(12.0f, SVG.Unit.pt));
            lGz.put("large", new SVG.n(14.4f, SVG.Unit.pt));
            lGz.put("x-large", new SVG.n(17.3f, SVG.Unit.pt));
            lGz.put("xx-large", new SVG.n(20.7f, SVG.Unit.pt));
            lGz.put("smaller", new SVG.n(83.33f, SVG.Unit.percent));
            lGz.put("larger", new SVG.n(120.0f, SVG.Unit.percent));
        }

        public static SVG.n OC(String str) {
            return lGz.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class d {
        private static final Map<String, Integer> lGA = new HashMap(13);

        static {
            lGA.put("normal", 400);
            lGA.put("bold", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lGA.put("bolder", 1);
            lGA.put("lighter", -1);
            lGA.put("100", 100);
            lGA.put(BasicPushStatus.SUCCESS_CODE, 200);
            lGA.put("300", 300);
            lGA.put("400", 400);
            lGA.put("500", 500);
            lGA.put("600", Integer.valueOf((int) Constants.HTTP_DNS_INAVAILABLE_TIME));
            lGA.put("700", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING));
            lGA.put("800", 800);
            lGA.put("900", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_TIMED_TEXT_ERROR));
        }

        public static Integer OB(String str) {
            return lGA.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a {
        private static final Map<String, PreserveAspectRatio.Alignment> lGx = new HashMap(10);

        static {
            lGx.put("none", PreserveAspectRatio.Alignment.None);
            lGx.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            lGx.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            lGx.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            lGx.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            lGx.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            lGx.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            lGx.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            lGx.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            lGx.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment OA(String str) {
            return lGx.get(str);
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
                    return this.lGl;
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
        this.lGl = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.lGn) {
            this.lGo++;
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
                    this.lGp = true;
                    this.lGq = fromString;
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
                    this.lGn = true;
                    this.lGo = 1;
                    return;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lGn) {
            if (this.lGp) {
                if (this.lGr == null) {
                    this.lGr = new StringBuilder(i2);
                }
                this.lGr.append(cArr, i, i2);
            } else if (this.lGs) {
                if (this.lGt == null) {
                    this.lGt = new StringBuilder(i2);
                }
                this.lGt.append(cArr, i, i2);
            } else if (this.lGm instanceof SVG.av) {
                SVG.ae aeVar = (SVG.ae) this.lGm;
                int size = aeVar.UB.size();
                SVG.ak akVar = size == 0 ? null : aeVar.UB.get(size - 1);
                if (akVar instanceof SVG.az) {
                    SVG.az azVar = (SVG.az) akVar;
                    azVar.text += new String(cArr, i, i2);
                    return;
                }
                ((SVG.ae) this.lGm).a(new SVG.az(new String(cArr, i, i2)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.lGn && this.lGs) {
            if (this.lGt == null) {
                this.lGt = new StringBuilder(i2);
            }
            this.lGt.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.lGn) {
            int i = this.lGo - 1;
            this.lGo = i;
            if (i == 0) {
                this.lGn = false;
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
                    this.lGm = ((SVG.ak) this.lGm).lFz;
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
                    this.lGp = false;
                    if (this.lGq == SVGElem.title) {
                        this.lGl.setTitle(this.lGr.toString());
                    } else if (this.lGq == SVGElem.desc) {
                        this.lGl.setDesc(this.lGr.toString());
                    }
                    this.lGr.setLength(0);
                    return;
                case style:
                    if (this.lGt != null) {
                        this.lGs = false;
                        Oz(this.lGt.toString());
                        this.lGt.setLength(0);
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
        acVar.lFy = this.lGl;
        acVar.lFz = this.lGm;
        a((SVG.ai) acVar, attributes);
        b(acVar, attributes);
        a((SVG.ad) acVar, attributes);
        a((SVG.ao) acVar, attributes);
        a(acVar, attributes);
        if (this.lGm == null) {
            this.lGl.a(acVar);
        } else {
            this.lGm.a(acVar);
        }
        this.lGm = acVar;
    }

    private void a(SVG.ac acVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    acVar.lEc = NZ(trim);
                    break;
                case y:
                    acVar.lEd = NZ(trim);
                    break;
                case width:
                    acVar.lEe = NZ(trim);
                    if (acVar.lEe.diB()) {
                        throw new SAXException("Invalid <svg> element. width cannot be negative");
                    }
                    break;
                case height:
                    acVar.lEf = NZ(trim);
                    if (acVar.lEf.diB()) {
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.k kVar = new SVG.k();
        kVar.lFy = this.lGl;
        kVar.lFz = this.lGm;
        a((SVG.ai) kVar, attributes);
        b(kVar, attributes);
        a((SVG.l) kVar, attributes);
        a((SVG.ad) kVar, attributes);
        this.lGm.a(kVar);
        this.lGm = kVar;
    }

    private void c(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.g gVar = new SVG.g();
        gVar.lFy = this.lGl;
        gVar.lFz = this.lGm;
        a((SVG.ai) gVar, attributes);
        b(gVar, attributes);
        a((SVG.l) gVar, attributes);
        this.lGm.a(gVar);
        this.lGm = gVar;
    }

    private void d(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ba baVar = new SVG.ba();
        baVar.lFy = this.lGl;
        baVar.lFz = this.lGm;
        a((SVG.ai) baVar, attributes);
        b(baVar, attributes);
        a((SVG.l) baVar, attributes);
        a((SVG.ad) baVar, attributes);
        a(baVar, attributes);
        this.lGm.a(baVar);
        this.lGm = baVar;
    }

    private void a(SVG.ba baVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    baVar.lEc = NZ(trim);
                    break;
                case y:
                    baVar.lEd = NZ(trim);
                    break;
                case width:
                    baVar.lEe = NZ(trim);
                    if (baVar.lEe.diB()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    baVar.lEf = NZ(trim);
                    if (baVar.lEf.diB()) {
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.m mVar = new SVG.m();
        mVar.lFy = this.lGl;
        mVar.lFz = this.lGm;
        a((SVG.ai) mVar, attributes);
        b(mVar, attributes);
        a((SVG.l) mVar, attributes);
        a((SVG.ad) mVar, attributes);
        a(mVar, attributes);
        this.lGm.a(mVar);
        this.lGm = mVar;
    }

    private void a(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    mVar.lEc = NZ(trim);
                    break;
                case y:
                    mVar.lEd = NZ(trim);
                    break;
                case width:
                    mVar.lEe = NZ(trim);
                    if (mVar.lEe.diB()) {
                        throw new SAXException("Invalid <use> element. width cannot be negative");
                    }
                    break;
                case height:
                    mVar.lEf = NZ(trim);
                    if (mVar.lEf.diB()) {
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.t tVar = new SVG.t();
        tVar.lFy = this.lGl;
        tVar.lFz = this.lGm;
        a((SVG.ai) tVar, attributes);
        b(tVar, attributes);
        a((SVG.l) tVar, attributes);
        a((SVG.ad) tVar, attributes);
        a(tVar, attributes);
        this.lGm.a(tVar);
    }

    private void a(SVG.t tVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case d:
                    tVar.lEu = Ov(trim);
                    break;
                case pathLength:
                    tVar.lEv = Float.valueOf(parseFloat(trim));
                    if (tVar.lEv.floatValue() < 0.0f) {
                        throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                    }
                    break;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.z zVar = new SVG.z();
        zVar.lFy = this.lGl;
        zVar.lFz = this.lGm;
        a((SVG.ai) zVar, attributes);
        b(zVar, attributes);
        a((SVG.l) zVar, attributes);
        a((SVG.ad) zVar, attributes);
        a(zVar, attributes);
        this.lGm.a(zVar);
    }

    private void a(SVG.z zVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    zVar.lEc = NZ(trim);
                    break;
                case y:
                    zVar.lEd = NZ(trim);
                    break;
                case width:
                    zVar.lEe = NZ(trim);
                    if (zVar.lEe.diB()) {
                        throw new SAXException("Invalid <rect> element. width cannot be negative");
                    }
                    break;
                case height:
                    zVar.lEf = NZ(trim);
                    if (zVar.lEf.diB()) {
                        throw new SAXException("Invalid <rect> element. height cannot be negative");
                    }
                    break;
                case rx:
                    zVar.lDW = NZ(trim);
                    if (zVar.lDW.diB()) {
                        throw new SAXException("Invalid <rect> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    zVar.lDX = NZ(trim);
                    if (zVar.lDX.diB()) {
                        throw new SAXException("Invalid <rect> element. ry cannot be negative");
                    }
                    break;
            }
        }
    }

    private void h(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.c cVar = new SVG.c();
        cVar.lFy = this.lGl;
        cVar.lFz = this.lGm;
        a((SVG.ai) cVar, attributes);
        b(cVar, attributes);
        a((SVG.l) cVar, attributes);
        a((SVG.ad) cVar, attributes);
        a(cVar, attributes);
        this.lGm.a(cVar);
    }

    private void a(SVG.c cVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    cVar.lDP = NZ(trim);
                    break;
                case cy:
                    cVar.lDQ = NZ(trim);
                    break;
                case r:
                    cVar.lDR = NZ(trim);
                    if (cVar.lDR.diB()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void i(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.h hVar = new SVG.h();
        hVar.lFy = this.lGl;
        hVar.lFz = this.lGm;
        a((SVG.ai) hVar, attributes);
        b(hVar, attributes);
        a((SVG.l) hVar, attributes);
        a((SVG.ad) hVar, attributes);
        a(hVar, attributes);
        this.lGm.a(hVar);
    }

    private void a(SVG.h hVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case rx:
                    hVar.lDW = NZ(trim);
                    if (hVar.lDW.diB()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case ry:
                    hVar.lDX = NZ(trim);
                    if (hVar.lDX.diB()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case cx:
                    hVar.lDP = NZ(trim);
                    break;
                case cy:
                    hVar.lDQ = NZ(trim);
                    break;
            }
        }
    }

    private void j(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.o oVar = new SVG.o();
        oVar.lFy = this.lGl;
        oVar.lFz = this.lGm;
        a((SVG.ai) oVar, attributes);
        b(oVar, attributes);
        a((SVG.l) oVar, attributes);
        a((SVG.ad) oVar, attributes);
        a(oVar, attributes);
        this.lGm.a(oVar);
    }

    private void a(SVG.o oVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x1:
                    oVar.lEh = NZ(trim);
                    break;
                case y1:
                    oVar.lEi = NZ(trim);
                    break;
                case x2:
                    oVar.lEj = NZ(trim);
                    break;
                case y2:
                    oVar.lEk = NZ(trim);
                    break;
            }
        }
    }

    private void k(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.x xVar = new SVG.x();
        xVar.lFy = this.lGl;
        xVar.lFz = this.lGm;
        a((SVG.ai) xVar, attributes);
        b(xVar, attributes);
        a((SVG.l) xVar, attributes);
        a((SVG.ad) xVar, attributes);
        a(xVar, attributes, "polyline");
        this.lGm.a(xVar);
    }

    private void a(SVG.x xVar, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                e eVar = new e(attributes.getValue(i));
                ArrayList<Float> arrayList = new ArrayList();
                eVar.skipWhitespace();
                while (!eVar.djf()) {
                    float nextFloat = eVar.nextFloat();
                    if (Float.isNaN(nextFloat)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    eVar.djg();
                    float nextFloat2 = eVar.nextFloat();
                    if (Float.isNaN(nextFloat2)) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    eVar.djg();
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.y yVar = new SVG.y();
        yVar.lFy = this.lGl;
        yVar.lFz = this.lGm;
        a((SVG.ai) yVar, attributes);
        b(yVar, attributes);
        a((SVG.l) yVar, attributes);
        a((SVG.ad) yVar, attributes);
        a(yVar, attributes, "polygon");
        this.lGm.a(yVar);
    }

    private void m(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.at atVar = new SVG.at();
        atVar.lFy = this.lGl;
        atVar.lFz = this.lGm;
        a((SVG.ai) atVar, attributes);
        b(atVar, attributes);
        a((SVG.l) atVar, attributes);
        a((SVG.ad) atVar, attributes);
        a((SVG.ax) atVar, attributes);
        this.lGm.a(atVar);
        this.lGm = atVar;
    }

    private void a(SVG.ax axVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    axVar.x = Oa(trim);
                    break;
                case y:
                    axVar.y = Oa(trim);
                    break;
                case dx:
                    axVar.lFG = Oa(trim);
                    break;
                case dy:
                    axVar.lFH = Oa(trim);
                    break;
            }
        }
    }

    private void n(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lGm instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.as asVar = new SVG.as();
        asVar.lFy = this.lGl;
        asVar.lFz = this.lGm;
        a((SVG.ai) asVar, attributes);
        b(asVar, attributes);
        a((SVG.ad) asVar, attributes);
        a((SVG.ax) asVar, attributes);
        this.lGm.a(asVar);
        this.lGm = asVar;
        if (asVar.lFz instanceof SVG.ay) {
            asVar.a((SVG.ay) asVar.lFz);
        } else {
            asVar.a(((SVG.au) asVar.lFz).diI());
        }
    }

    private void o(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lGm instanceof SVG.av)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.ar arVar = new SVG.ar();
        arVar.lFy = this.lGl;
        arVar.lFz = this.lGm;
        a((SVG.ai) arVar, attributes);
        b(arVar, attributes);
        a((SVG.ad) arVar, attributes);
        a(arVar, attributes);
        this.lGm.a(arVar);
        if (arVar.lFz instanceof SVG.ay) {
            arVar.a((SVG.ay) arVar.lFz);
        } else {
            arVar.a(((SVG.au) arVar.lFz).diI());
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ap apVar = new SVG.ap();
        apVar.lFy = this.lGl;
        apVar.lFz = this.lGm;
        a((SVG.ai) apVar, attributes);
        b(apVar, attributes);
        a((SVG.l) apVar, attributes);
        a((SVG.ad) apVar, attributes);
        this.lGm.a(apVar);
        this.lGm = apVar;
    }

    private void a(SVG.ad adVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case requiredFeatures:
                    adVar.i(Ow(trim));
                    break;
                case requiredExtensions:
                    adVar.NS(trim);
                    break;
                case systemLanguage:
                    adVar.j(Ox(trim));
                    break;
                case requiredFormats:
                    adVar.k(Oy(trim));
                    break;
                case requiredFonts:
                    List<String> Og = Og(trim);
                    adVar.l(Og != null ? new HashSet(Og) : new HashSet(0));
                    break;
            }
        }
    }

    private void q(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aq aqVar = new SVG.aq();
        aqVar.lFy = this.lGl;
        aqVar.lFz = this.lGm;
        a((SVG.ai) aqVar, attributes);
        b(aqVar, attributes);
        a((SVG.ad) aqVar, attributes);
        a((SVG.ao) aqVar, attributes);
        this.lGm.a(aqVar);
        this.lGm = aqVar;
    }

    private void r(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.p pVar = new SVG.p();
        pVar.lFy = this.lGl;
        pVar.lFz = this.lGm;
        a((SVG.ai) pVar, attributes);
        b(pVar, attributes);
        a((SVG.ad) pVar, attributes);
        a((SVG.ao) pVar, attributes);
        a(pVar, attributes);
        this.lGm.a(pVar);
        this.lGm = pVar;
    }

    private void a(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case refX:
                    pVar.lEm = NZ(trim);
                    break;
                case refY:
                    pVar.lEn = NZ(trim);
                    break;
                case markerWidth:
                    pVar.lEo = NZ(trim);
                    if (pVar.lEo.diB()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case markerHeight:
                    pVar.lEp = NZ(trim);
                    if (pVar.lEp.diB()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case markerUnits:
                    if ("strokeWidth".equals(trim)) {
                        pVar.lEl = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        pVar.lEl = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case orient:
                    if ("auto".equals(trim)) {
                        pVar.lEq = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        pVar.lEq = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void s(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aj ajVar = new SVG.aj();
        ajVar.lFy = this.lGl;
        ajVar.lFz = this.lGm;
        a((SVG.ai) ajVar, attributes);
        b(ajVar, attributes);
        a((SVG.i) ajVar, attributes);
        a(ajVar, attributes);
        this.lGm.a(ajVar);
        this.lGm = ajVar;
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
                        iVar.lDY = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        iVar.lDY = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute gradientUnits");
                    }
                case gradientTransform:
                    iVar.lDZ = NY(trim);
                    break;
                case spreadMethod:
                    try {
                        iVar.lEa = SVG.GradientSpread.valueOf(trim);
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
                    ajVar.lEh = NZ(trim);
                    break;
                case y1:
                    ajVar.lEi = NZ(trim);
                    break;
                case x2:
                    ajVar.lEj = NZ(trim);
                    break;
                case y2:
                    ajVar.lEk = NZ(trim);
                    break;
            }
        }
    }

    private void t(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.an anVar = new SVG.an();
        anVar.lFy = this.lGl;
        anVar.lFz = this.lGm;
        a((SVG.ai) anVar, attributes);
        b(anVar, attributes);
        a((SVG.i) anVar, attributes);
        a(anVar, attributes);
        this.lGm.a(anVar);
        this.lGm = anVar;
    }

    private void a(SVG.an anVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case cx:
                    anVar.lDP = NZ(trim);
                    break;
                case cy:
                    anVar.lDQ = NZ(trim);
                    break;
                case r:
                    anVar.lDR = NZ(trim);
                    if (anVar.lDR.diB()) {
                        throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                    }
                    break;
                case fx:
                    anVar.lFB = NZ(trim);
                    break;
                case fy:
                    anVar.lFC = NZ(trim);
                    break;
            }
        }
    }

    private void u(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(this.lGm instanceof SVG.i)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.ab abVar = new SVG.ab();
        abVar.lFy = this.lGl;
        abVar.lFz = this.lGm;
        a((SVG.ai) abVar, attributes);
        b(abVar, attributes);
        a(abVar, attributes);
        this.lGm.a(abVar);
        this.lGm = abVar;
    }

    private void a(SVG.ab abVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case offset:
                    abVar.lED = NX(trim);
                    break;
            }
        }
    }

    private Float NX(String str) throws SAXException {
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
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aa aaVar = new SVG.aa();
        aaVar.lFy = this.lGl;
        aaVar.lFz = this.lGm;
        a(aaVar, attributes);
        b(aaVar, attributes);
        this.lGm.a(aaVar);
        this.lGm = aaVar;
    }

    private void w(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.d dVar = new SVG.d();
        dVar.lFy = this.lGl;
        dVar.lFz = this.lGm;
        a((SVG.ai) dVar, attributes);
        b(dVar, attributes);
        a((SVG.l) dVar, attributes);
        a((SVG.ad) dVar, attributes);
        a(dVar, attributes);
        this.lGm.a(dVar);
        this.lGm = dVar;
    }

    private void a(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case clipPathUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        dVar.lDS = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        dVar.lDS = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute clipPathUnits");
                    }
            }
        }
    }

    private void x(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.aw awVar = new SVG.aw();
        awVar.lFy = this.lGl;
        awVar.lFz = this.lGm;
        a((SVG.ai) awVar, attributes);
        b(awVar, attributes);
        a((SVG.ad) awVar, attributes);
        a(awVar, attributes);
        this.lGm.a(awVar);
        this.lGm = awVar;
        if (awVar.lFz instanceof SVG.ay) {
            awVar.a((SVG.ay) awVar.lFz);
        } else {
            awVar.a(((SVG.au) awVar.lFz).diI());
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
                    awVar.lFF = NZ(trim);
                    break;
            }
        }
    }

    private void y(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.w wVar = new SVG.w();
        wVar.lFy = this.lGl;
        wVar.lFz = this.lGm;
        a((SVG.ai) wVar, attributes);
        b(wVar, attributes);
        a((SVG.ad) wVar, attributes);
        a((SVG.ao) wVar, attributes);
        a(wVar, attributes);
        this.lGm.a(wVar);
        this.lGm = wVar;
    }

    private void a(SVG.w wVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    wVar.lEc = NZ(trim);
                    break;
                case y:
                    wVar.lEd = NZ(trim);
                    break;
                case width:
                    wVar.lEe = NZ(trim);
                    if (wVar.lEe.diB()) {
                        throw new SAXException("Invalid <pattern> element. width cannot be negative");
                    }
                    break;
                case height:
                    wVar.lEf = NZ(trim);
                    if (wVar.lEf.diB()) {
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
                        wVar.lEA = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lEA = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternUnits");
                    }
                case patternContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        wVar.lEB = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        wVar.lEB = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute patternContentUnits");
                    }
                case patternTransform:
                    wVar.lEC = NY(trim);
                    break;
            }
        }
    }

    private void z(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.bb bbVar = new SVG.bb();
        bbVar.lFy = this.lGl;
        bbVar.lFz = this.lGm;
        a((SVG.ai) bbVar, attributes);
        a((SVG.ad) bbVar, attributes);
        a((SVG.ao) bbVar, attributes);
        this.lGm.a(bbVar);
        this.lGm = bbVar;
    }

    private void A(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.lGm == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.q qVar = new SVG.q();
        qVar.lFy = this.lGl;
        qVar.lFz = this.lGm;
        a((SVG.ai) qVar, attributes);
        b(qVar, attributes);
        a((SVG.ad) qVar, attributes);
        a(qVar, attributes);
        this.lGm.a(qVar);
        this.lGm = qVar;
    }

    private void a(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String trim = attributes.getValue(i).trim();
            switch (SVGAttr.fromString(attributes.getLocalName(i))) {
                case x:
                    qVar.lEc = NZ(trim);
                    break;
                case y:
                    qVar.lEd = NZ(trim);
                    break;
                case width:
                    qVar.lEe = NZ(trim);
                    if (qVar.lEe.diB()) {
                        throw new SAXException("Invalid <mask> element. width cannot be negative");
                    }
                    break;
                case height:
                    qVar.lEf = NZ(trim);
                    if (qVar.lEf.diB()) {
                        throw new SAXException("Invalid <mask> element. height cannot be negative");
                    }
                    break;
                case maskUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lEr = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lEr = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                case maskContentUnits:
                    if ("objectBoundingBox".equals(trim)) {
                        qVar.lEs = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.lEs = true;
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
        protected String lGB;
        protected int lGC;
        protected int position = 0;
        private com.caverock.androidsvg.b lGD = new com.caverock.androidsvg.b();

        public e(String str) {
            this.lGC = 0;
            this.lGB = str.trim();
            this.lGC = this.lGB.length();
        }

        public boolean djf() {
            return this.position == this.lGC;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hi(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public void skipWhitespace() {
            while (this.position < this.lGC && Hi(this.lGB.charAt(this.position))) {
                this.position++;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean Hj(int i) {
            return i == 10 || i == 13;
        }

        public boolean djg() {
            skipWhitespace();
            if (this.position != this.lGC && this.lGB.charAt(this.position) == ',') {
                this.position++;
                skipWhitespace();
                return true;
            }
            return false;
        }

        public float nextFloat() {
            float B = this.lGD.B(this.lGB, this.position, this.lGC);
            if (!Float.isNaN(B)) {
                this.position = this.lGD.diq();
            }
            return B;
        }

        public float djh() {
            djg();
            float B = this.lGD.B(this.lGB, this.position, this.lGC);
            if (!Float.isNaN(B)) {
                this.position = this.lGD.diq();
            }
            return B;
        }

        public float bi(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            djg();
            return nextFloat();
        }

        public Integer dji() {
            if (this.position == this.lGC) {
                return null;
            }
            String str = this.lGB;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.n djj() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit djo = djo();
            if (djo == null) {
                return new SVG.n(nextFloat, SVG.Unit.px);
            }
            return new SVG.n(nextFloat, djo);
        }

        public Boolean djk() {
            if (this.position == this.lGC) {
                return null;
            }
            char charAt = this.lGB.charAt(this.position);
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
            djg();
            return djk();
        }

        public boolean g(char c) {
            boolean z = this.position < this.lGC && this.lGB.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        public boolean OD(String str) {
            int length = str.length();
            boolean z = this.position <= this.lGC - length && this.lGB.substring(this.position, this.position + length).equals(str);
            if (z) {
                this.position = length + this.position;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int djl() {
            if (this.position == this.lGC) {
                return -1;
            }
            this.position++;
            if (this.position < this.lGC) {
                return this.lGB.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return h(' ');
        }

        public String h(char c) {
            if (djf()) {
                return null;
            }
            char charAt = this.lGB.charAt(this.position);
            if (Hi(charAt) || charAt == c) {
                return null;
            }
            int i = this.position;
            int djl = djl();
            while (djl != -1 && djl != c && !Hi(djl)) {
                djl = djl();
            }
            return this.lGB.substring(i, this.position);
        }

        public String djm() {
            if (djf()) {
                return null;
            }
            int i = this.position;
            int charAt = this.lGB.charAt(this.position);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = djl();
            }
            int i2 = this.position;
            while (Hi(charAt)) {
                charAt = djl();
            }
            if (charAt == 40) {
                this.position++;
                return this.lGB.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        public String djn() {
            int i = this.position;
            while (!djf() && !Hi(this.lGB.charAt(this.position))) {
                this.position++;
            }
            String substring = this.lGB.substring(i, this.position);
            this.position = i;
            return substring;
        }

        public SVG.Unit djo() {
            if (djf()) {
                return null;
            }
            if (this.lGB.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            } else if (this.position <= this.lGC - 2) {
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.lGB.substring(this.position, this.position + 2).toLowerCase(Locale.US));
                    this.position += 2;
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                return null;
            }
        }

        public boolean djp() {
            if (this.position == this.lGC) {
                return false;
            }
            char charAt = this.lGB.charAt(this.position);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public String djq() {
            if (djf()) {
                return null;
            }
            int i = this.position;
            char charAt = this.lGB.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                int djl = djl();
                while (djl != -1 && djl != charAt) {
                    djl = djl();
                }
                if (djl == -1) {
                    this.position = i;
                    return null;
                }
                this.position++;
                return this.lGB.substring(i + 1, this.position - 1);
            }
            return null;
        }

        public String djr() {
            if (djf()) {
                return null;
            }
            int i = this.position;
            this.position = this.lGC;
            return this.lGB.substring(i);
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
                    aiVar.lFv = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    aiVar.lFv = Boolean.TRUE;
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
                        aiVar.lFx = CSSParser.NO(trim);
                        continue;
                    default:
                        if (aiVar.lFw == null) {
                            aiVar.lFw = new SVG.Style();
                        }
                        a(aiVar.lFw, attributes.getLocalName(i), attributes.getValue(i).trim());
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
                    if (eVar.djf() || eVar.g(';')) {
                        if (aiVar.lDh == null) {
                            aiVar.lDh = new SVG.Style();
                        }
                        a(aiVar.lDh, h, h2);
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
                    style.lEF = fh(str2, "fill");
                    style.lEE |= 1;
                    return;
                case fill_rule:
                    style.lEG = On(str2);
                    style.lEE |= 2;
                    return;
                case fill_opacity:
                    style.lEH = Float.valueOf(Ob(str2));
                    style.lEE |= 4;
                    return;
                case stroke:
                    style.lEI = fh(str2, "stroke");
                    style.lEE |= 8;
                    return;
                case stroke_opacity:
                    style.lEJ = Float.valueOf(Ob(str2));
                    style.lEE |= 16;
                    return;
                case stroke_width:
                    style.lEK = NZ(str2);
                    style.lEE |= 32;
                    return;
                case stroke_linecap:
                    style.lEL = Oo(str2);
                    style.lEE |= 64;
                    return;
                case stroke_linejoin:
                    style.lEM = Op(str2);
                    style.lEE |= 128;
                    return;
                case stroke_miterlimit:
                    style.lEN = Float.valueOf(parseFloat(str2));
                    style.lEE |= 256;
                    return;
                case stroke_dasharray:
                    if ("none".equals(str2)) {
                        style.lEO = null;
                    } else {
                        style.lEO = Oq(str2);
                    }
                    style.lEE |= 512;
                    return;
                case stroke_dashoffset:
                    style.lEP = NZ(str2);
                    style.lEE |= 1024;
                    return;
                case opacity:
                    style.lEQ = Float.valueOf(Ob(str2));
                    style.lEE |= 2048;
                    return;
                case color:
                    style.lER = Oe(str2);
                    style.lEE |= 4096;
                    return;
                case font:
                    a(style, str2);
                    return;
                case font_family:
                    style.lES = Og(str2);
                    style.lEE |= 8192;
                    return;
                case font_size:
                    style.lET = Oh(str2);
                    style.lEE |= 16384;
                    return;
                case font_weight:
                    style.lEU = Oi(str2);
                    style.lEE |= 32768;
                    return;
                case font_style:
                    style.lEV = Oj(str2);
                    style.lEE |= 65536;
                    return;
                case text_decoration:
                    style.lEW = Ol(str2);
                    style.lEE |= 131072;
                    return;
                case direction:
                    style.lEX = Om(str2);
                    style.lEE |= 68719476736L;
                    return;
                case text_anchor:
                    style.lEY = Or(str2);
                    style.lEE |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    return;
                case overflow:
                    style.lEZ = Os(str2);
                    style.lEE |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    return;
                case marker:
                    style.lFb = fi(str2, str);
                    style.lFc = style.lFb;
                    style.lFd = style.lFb;
                    style.lEE |= 14680064;
                    return;
                case marker_start:
                    style.lFb = fi(str2, str);
                    style.lEE |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                    return;
                case marker_mid:
                    style.lFc = fi(str2, str);
                    style.lEE |= ImageUploadStrategy.FILE_SIZE_4M;
                    return;
                case marker_end:
                    style.lFd = fi(str2, str);
                    style.lEE |= 8388608;
                    return;
                case display:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"display\" attribute: " + str2);
                    }
                    style.lFe = Boolean.valueOf(!str2.equals("none"));
                    style.lEE |= AccountConstants.TYPE_MODIFY_ADDRESSLIST_SWITCH;
                    return;
                case visibility:
                    if (str2.indexOf(com.baidu.android.imsdk.internal.Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER) >= 0 || "|visible|hidden|collapse|".indexOf('|' + str2 + '|') == -1) {
                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                    }
                    style.lFf = Boolean.valueOf(str2.equals("visible"));
                    style.lEE |= 33554432;
                    return;
                case stop_color:
                    if (str2.equals("currentColor")) {
                        style.lFg = SVG.f.diA();
                    } else {
                        style.lFg = Oe(str2);
                    }
                    style.lEE |= 67108864;
                    return;
                case stop_opacity:
                    style.lFh = Float.valueOf(Ob(str2));
                    style.lEE |= 134217728;
                    return;
                case clip:
                    style.lFa = Ot(str2);
                    style.lEE |= 1048576;
                    return;
                case clip_path:
                    style.clipPath = fi(str2, str);
                    style.lEE |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case clip_rule:
                    style.lFi = On(str2);
                    style.lEE |= IjkMediaMeta.AV_CH_STEREO_LEFT;
                    return;
                case mask:
                    style.lFj = fi(str2, str);
                    style.lEE |= IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    return;
                case solid_color:
                    if (str2.equals("currentColor")) {
                        style.lFk = SVG.f.diA();
                    } else {
                        style.lFk = Oe(str2);
                    }
                    style.lEE |= IjkMediaMeta.AV_CH_WIDE_LEFT;
                    return;
                case solid_opacity:
                    style.lFl = Float.valueOf(Ob(str2));
                    style.lEE |= 4294967296L;
                    return;
                case viewport_fill:
                    if (str2.equals("currentColor")) {
                        style.lFm = SVG.f.diA();
                    } else {
                        style.lFm = Oe(str2);
                    }
                    style.lEE |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                    return;
                case viewport_fill_opacity:
                    style.lFn = Float.valueOf(Ob(str2));
                    style.lEE |= IjkMediaMeta.AV_CH_SURROUND_DIRECT_RIGHT;
                    return;
                case vector_effect:
                    style.lFo = Ou(str2);
                    style.lEE |= IjkMediaMeta.AV_CH_LOW_FREQUENCY_2;
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
                    aoVar.lFD = Oc(trim);
                    break;
            }
        }
    }

    private void a(SVG.l lVar, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                lVar.setTransform(NY(attributes.getValue(i)));
            }
        }
    }

    private Matrix NY(String str) throws SAXException {
        Matrix matrix = new Matrix();
        e eVar = new e(str);
        eVar.skipWhitespace();
        while (!eVar.djf()) {
            String djm = eVar.djm();
            if (djm == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (djm.equals("matrix")) {
                eVar.skipWhitespace();
                float nextFloat = eVar.nextFloat();
                eVar.djg();
                float nextFloat2 = eVar.nextFloat();
                eVar.djg();
                float nextFloat3 = eVar.nextFloat();
                eVar.djg();
                float nextFloat4 = eVar.nextFloat();
                eVar.djg();
                float nextFloat5 = eVar.nextFloat();
                eVar.djg();
                float nextFloat6 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat6) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (djm.equals("translate")) {
                eVar.skipWhitespace();
                float nextFloat7 = eVar.nextFloat();
                float djh = eVar.djh();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat7) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djh)) {
                    matrix.preTranslate(nextFloat7, 0.0f);
                } else {
                    matrix.preTranslate(nextFloat7, djh);
                }
            } else if (djm.equals("scale")) {
                eVar.skipWhitespace();
                float nextFloat8 = eVar.nextFloat();
                float djh2 = eVar.djh();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat8) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djh2)) {
                    matrix.preScale(nextFloat8, nextFloat8);
                } else {
                    matrix.preScale(nextFloat8, djh2);
                }
            } else if (djm.equals(RotateImageAction.ACTION_NAME)) {
                eVar.skipWhitespace();
                float nextFloat9 = eVar.nextFloat();
                float djh3 = eVar.djh();
                float djh4 = eVar.djh();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat9) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (Float.isNaN(djh3)) {
                    matrix.preRotate(nextFloat9);
                } else if (!Float.isNaN(djh4)) {
                    matrix.preRotate(nextFloat9, djh3, djh4);
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (djm.equals("skewX")) {
                eVar.skipWhitespace();
                float nextFloat10 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat10) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat10)), 0.0f);
            } else if (djm.equals("skewY")) {
                eVar.skipWhitespace();
                float nextFloat11 = eVar.nextFloat();
                eVar.skipWhitespace();
                if (Float.isNaN(nextFloat11) || !eVar.g(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat11)));
            } else if (djm != null) {
                throw new SAXException("Invalid transform list fn: " + djm + ")");
            }
            if (eVar.djf()) {
                break;
            }
            eVar.djg();
        }
        return matrix;
    }

    protected static SVG.n NZ(String str) throws SAXException {
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

    private static List<SVG.n> Oa(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        e eVar = new e(str);
        eVar.skipWhitespace();
        while (!eVar.djf()) {
            float nextFloat = eVar.nextFloat();
            if (Float.isNaN(nextFloat)) {
                throw new SAXException("Invalid length list value: " + eVar.djn());
            }
            SVG.Unit djo = eVar.djo();
            if (djo == null) {
                djo = SVG.Unit.px;
            }
            arrayList.add(new SVG.n(nextFloat, djo));
            eVar.djg();
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

    private static float Ob(String str) throws SAXException {
        float parseFloat = parseFloat(str);
        if (parseFloat < 0.0f) {
            return 0.0f;
        }
        if (parseFloat > 1.0f) {
            return 1.0f;
        }
        return parseFloat;
    }

    private static SVG.a Oc(String str) throws SAXException {
        e eVar = new e(str);
        eVar.skipWhitespace();
        float nextFloat = eVar.nextFloat();
        eVar.djg();
        float nextFloat2 = eVar.nextFloat();
        eVar.djg();
        float nextFloat3 = eVar.nextFloat();
        eVar.djg();
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
        PreserveAspectRatio.Alignment OA = a.OA(nextToken);
        eVar.skipWhitespace();
        if (eVar.djf()) {
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
        amVar.lFA = new PreserveAspectRatio(OA, scale);
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
                alVar = Od(trim2);
            }
            return new SVG.s(trim, alVar);
        }
        return Od(str);
    }

    private static SVG.al Od(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.f.diA();
        }
        return Oe(str);
    }

    private static SVG.e Oe(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            com.caverock.androidsvg.a A = com.caverock.androidsvg.a.A(str, 1, str.length());
            if (A == null) {
                throw new SAXException("Bad hex colour value: " + str);
            }
            int diq = A.diq();
            if (diq == 7) {
                return new SVG.e(A.value());
            }
            if (diq == 4) {
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
            return Of(str);
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

    private static SVG.e Of(String str) throws SAXException {
        Integer OB = b.OB(str.toLowerCase(Locale.US));
        if (OB == null) {
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return new SVG.e(OB.intValue());
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
                } else if (!h.equals("normal") && (num != null || (num = d.OB(h)) == null)) {
                    if (fontStyle != null || (fontStyle = Ok(h)) == null) {
                        if (str2 != null || !h.equals("small-caps")) {
                            break;
                        }
                        str2 = h;
                    }
                }
            }
            SVG.n Oh = Oh(h);
            if (eVar.g('/')) {
                eVar.skipWhitespace();
                String nextToken = eVar.nextToken();
                if (nextToken == null) {
                    throw new SAXException("Invalid font style attribute: missing line-height");
                }
                NZ(nextToken);
                eVar.skipWhitespace();
            }
            style.lES = Og(eVar.djr());
            style.lET = Oh;
            style.lEU = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.lEV = fontStyle;
            style.lEE |= 122880;
        }
    }

    private static List<String> Og(String str) throws SAXException {
        ArrayList arrayList = null;
        e eVar = new e(str);
        do {
            String djq = eVar.djq();
            if (djq == null) {
                djq = eVar.h(',');
            }
            if (djq == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(djq);
            eVar.djg();
        } while (!eVar.djf());
        return arrayList;
    }

    private static SVG.n Oh(String str) throws SAXException {
        SVG.n OC = c.OC(str);
        if (OC == null) {
            return NZ(str);
        }
        return OC;
    }

    private static Integer Oi(String str) throws SAXException {
        Integer OB = d.OB(str);
        if (OB == null) {
            throw new SAXException("Invalid font-weight property: " + str);
        }
        return OB;
    }

    private static SVG.Style.FontStyle Oj(String str) throws SAXException {
        SVG.Style.FontStyle Ok = Ok(str);
        if (Ok != null) {
            return Ok;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static SVG.Style.FontStyle Ok(String str) {
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

    private static SVG.Style.TextDecoration Ol(String str) throws SAXException {
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

    private static SVG.Style.TextDirection Om(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private static SVG.Style.FillRule On(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static SVG.Style.LineCaps Oo(String str) throws SAXException {
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

    private static SVG.Style.LineJoin Op(String str) throws SAXException {
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

    private static SVG.n[] Oq(String str) throws SAXException {
        SVG.n djj;
        e eVar = new e(str);
        eVar.skipWhitespace();
        if (!eVar.djf() && (djj = eVar.djj()) != null) {
            if (djj.diB()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            float floatValue = djj.floatValue();
            ArrayList arrayList = new ArrayList();
            arrayList.add(djj);
            while (!eVar.djf()) {
                eVar.djg();
                SVG.n djj2 = eVar.djj();
                if (djj2 == null) {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
                if (djj2.diB()) {
                    throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                }
                arrayList.add(djj2);
                floatValue += djj2.floatValue();
            }
            if (floatValue == 0.0f) {
                return null;
            }
            return (SVG.n[]) arrayList.toArray(new SVG.n[arrayList.size()]);
        }
        return null;
    }

    private static SVG.Style.TextAnchor Or(String str) throws SAXException {
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

    private static Boolean Os(String str) throws SAXException {
        if ("visible".equals(str) || "auto".equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private static SVG.b Ot(String str) throws SAXException {
        if ("auto".equals(str)) {
            return null;
        }
        if (!str.toLowerCase(Locale.US).startsWith("rect(")) {
            throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
        }
        e eVar = new e(str.substring(5));
        eVar.skipWhitespace();
        SVG.n a2 = a(eVar);
        eVar.djg();
        SVG.n a3 = a(eVar);
        eVar.djg();
        SVG.n a4 = a(eVar);
        eVar.djg();
        SVG.n a5 = a(eVar);
        eVar.skipWhitespace();
        if (!eVar.g(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.b(a2, a3, a4, a5);
    }

    private static SVG.n a(e eVar) {
        return eVar.OD("auto") ? new SVG.n(0.0f) : eVar.djj();
    }

    private static SVG.Style.VectorEffect Ou(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    private static SVG.u Ov(String str) throws SAXException {
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
        float djh;
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
        if (!eVar.djf() && ((intValue = eVar.dji().intValue()) == 77 || intValue == 109)) {
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
                                djh = Float.NaN;
                            } else {
                                djh = eVar.djh();
                                bi = eVar.bi(djh);
                            }
                            if (!Float.isNaN(bi) && nextFloat >= 0.0f && bi2 >= 0.0f) {
                                if (i == 97) {
                                    float f23 = f20 + djh;
                                    f10 = bi + f19;
                                    f11 = f23;
                                } else {
                                    float f24 = bi;
                                    f11 = djh;
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
                    eVar.djg();
                    if (!eVar.djf()) {
                        if (eVar.djp()) {
                            intValue = eVar.dji().intValue();
                        }
                    }
                }
            }
        }
        return uVar;
    }

    private static Set<String> Ow(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djf()) {
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

    private static Set<String> Ox(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djf()) {
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

    private static Set<String> Oy(String str) throws SAXException {
        e eVar = new e(str);
        HashSet hashSet = new HashSet();
        while (!eVar.djf()) {
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
        if (this.lGm == null) {
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
            this.lGs = true;
            return;
        }
        this.lGn = true;
        this.lGo = 1;
    }

    private void Oz(String str) throws SAXException {
        this.lGl.b(new CSSParser(CSSParser.MediaType.screen).NN(str));
    }
}
