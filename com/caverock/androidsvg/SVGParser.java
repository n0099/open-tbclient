package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.view.DisplayCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
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
import kotlinx.coroutines.DebugKt;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
/* loaded from: classes6.dex */
public class SVGParser extends DefaultHandler2 {

    /* renamed from: d  reason: collision with root package name */
    public int f30457d;

    /* renamed from: a  reason: collision with root package name */
    public SVG f30454a = null;

    /* renamed from: b  reason: collision with root package name */
    public SVG.h0 f30455b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30456c = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30458e = false;

    /* renamed from: f  reason: collision with root package name */
    public SVGElem f30459f = null;

    /* renamed from: g  reason: collision with root package name */
    public StringBuilder f30460g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30461h = false;

    /* renamed from: i  reason: collision with root package name */
    public StringBuilder f30462i = null;

    /* loaded from: classes6.dex */
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
        
        public static final Map<String, SVGAttr> cache = new HashMap();

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            if (sVGAttr != null) {
                return sVGAttr;
            }
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
                } catch (IllegalArgumentException unused) {
                }
                cache.put(str, UNSUPPORTED);
                return UNSUPPORTED;
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum SVGElem {
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
        
        public static final Map<String, SVGElem> cache = new HashMap();

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            if (sVGElem != null) {
                return sVGElem;
            }
            if (str.equals(SetImageWatermarkTypeReqMsg.SWITCH)) {
                cache.put(str, SWITCH);
                return SWITCH;
            }
            try {
                SVGElem valueOf = valueOf(str);
                if (valueOf != SWITCH) {
                    cache.put(str, valueOf);
                    return valueOf;
                }
            } catch (IllegalArgumentException unused) {
            }
            cache.put(str, UNSUPPORTED);
            return UNSUPPORTED;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30467a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f30468b;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            f30468b = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30468b[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30468b[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30468b[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30468b[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30468b[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30468b[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30468b[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30468b[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30468b[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30468b[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f30468b[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f30468b[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f30468b[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f30468b[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f30468b[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f30468b[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f30468b[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f30468b[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f30468b[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f30468b[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f30468b[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f30468b[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f30468b[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f30468b[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f30468b[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f30468b[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f30468b[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f30468b[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f30468b[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f30468b[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f30468b[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f30468b[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f30468b[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f30468b[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f30468b[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f30468b[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f30468b[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f30468b[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f30468b[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f30468b[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f30468b[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f30468b[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f30468b[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f30468b[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f30468b[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f30468b[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f30468b[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f30468b[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f30468b[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f30468b[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f30468b[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f30468b[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f30468b[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f30468b[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f30468b[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f30468b[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f30468b[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f30468b[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f30468b[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f30468b[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f30468b[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f30468b[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f30468b[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f30468b[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f30468b[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f30468b[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f30468b[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f30468b[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f30468b[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f30468b[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f30468b[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f30468b[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f30468b[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f30468b[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f30468b[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f30468b[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f30468b[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f30468b[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f30468b[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f30468b[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f30468b[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f30468b[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f30468b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f30468b[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f30468b[SVGAttr.viewBox.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f30468b[SVGAttr.type.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f30468b[SVGAttr.media.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            f30467a = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                f30467a[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f30467a[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f30467a[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f30467a[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f30467a[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f30467a[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f30467a[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f30467a[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f30467a[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f30467a[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f30467a[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f30467a[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f30467a[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f30467a[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f30467a[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f30467a[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f30467a[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f30467a[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f30467a[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f30467a[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f30467a[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f30467a[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f30467a[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f30467a[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f30467a[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f30467a[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f30467a[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f30467a[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f30467a[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f30467a[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused119) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, PreserveAspectRatio.Alignment> f30469a;

        static {
            HashMap hashMap = new HashMap(10);
            f30469a = hashMap;
            hashMap.put("none", PreserveAspectRatio.Alignment.None);
            f30469a.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            f30469a.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            f30469a.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            f30469a.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            f30469a.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            f30469a.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            f30469a.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            f30469a.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            f30469a.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment a(String str) {
            return f30469a.get(str);
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, Integer> f30470a;

        static {
            HashMap hashMap = new HashMap(47);
            f30470a = hashMap;
            hashMap.put("aliceblue", 15792383);
            f30470a.put("antiquewhite", 16444375);
            f30470a.put("aqua", 65535);
            f30470a.put("aquamarine", 8388564);
            f30470a.put("azure", 15794175);
            f30470a.put("beige", 16119260);
            f30470a.put("bisque", 16770244);
            f30470a.put("black", 0);
            f30470a.put("blanchedalmond", 16772045);
            f30470a.put("blue", 255);
            f30470a.put("blueviolet", 9055202);
            f30470a.put("brown", 10824234);
            f30470a.put("burlywood", 14596231);
            f30470a.put("cadetblue", 6266528);
            f30470a.put("chartreuse", 8388352);
            f30470a.put("chocolate", 13789470);
            f30470a.put("coral", 16744272);
            f30470a.put("cornflowerblue", 6591981);
            f30470a.put("cornsilk", 16775388);
            f30470a.put("crimson", 14423100);
            f30470a.put("cyan", 65535);
            f30470a.put("darkblue", 139);
            f30470a.put("darkcyan", 35723);
            f30470a.put("darkgoldenrod", 12092939);
            f30470a.put("darkgray", 11119017);
            f30470a.put("darkgreen", Integer.valueOf((int) LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER));
            f30470a.put("darkgrey", 11119017);
            f30470a.put("darkkhaki", 12433259);
            f30470a.put("darkmagenta", 9109643);
            f30470a.put("darkolivegreen", 5597999);
            f30470a.put("darkorange", 16747520);
            f30470a.put("darkorchid", 10040012);
            f30470a.put("darkred", 9109504);
            f30470a.put("darksalmon", 15308410);
            f30470a.put("darkseagreen", 9419919);
            f30470a.put("darkslateblue", 4734347);
            f30470a.put("darkslategray", 3100495);
            f30470a.put("darkslategrey", 3100495);
            f30470a.put("darkturquoise", 52945);
            f30470a.put("darkviolet", 9699539);
            f30470a.put("deeppink", 16716947);
            f30470a.put("deepskyblue", 49151);
            f30470a.put("dimgray", 6908265);
            f30470a.put("dimgrey", 6908265);
            f30470a.put("dodgerblue", 2003199);
            f30470a.put("firebrick", 11674146);
            f30470a.put("floralwhite", 16775920);
            f30470a.put("forestgreen", 2263842);
            f30470a.put("fuchsia", 16711935);
            f30470a.put("gainsboro", 14474460);
            f30470a.put("ghostwhite", 16316671);
            f30470a.put("gold", 16766720);
            f30470a.put("goldenrod", 14329120);
            f30470a.put("gray", 8421504);
            f30470a.put("green", 32768);
            f30470a.put("greenyellow", 11403055);
            f30470a.put("grey", 8421504);
            f30470a.put("honeydew", 15794160);
            f30470a.put("hotpink", 16738740);
            f30470a.put("indianred", 13458524);
            f30470a.put("indigo", 4915330);
            f30470a.put("ivory", 16777200);
            f30470a.put("khaki", 15787660);
            f30470a.put("lavender", 15132410);
            f30470a.put("lavenderblush", 16773365);
            f30470a.put("lawngreen", 8190976);
            f30470a.put("lemonchiffon", 16775885);
            f30470a.put("lightblue", 11393254);
            f30470a.put("lightcoral", 15761536);
            f30470a.put("lightcyan", 14745599);
            f30470a.put("lightgoldenrodyellow", 16448210);
            f30470a.put("lightgray", 13882323);
            f30470a.put("lightgreen", 9498256);
            f30470a.put("lightgrey", 13882323);
            f30470a.put("lightpink", 16758465);
            f30470a.put("lightsalmon", 16752762);
            f30470a.put("lightseagreen", 2142890);
            f30470a.put("lightskyblue", 8900346);
            f30470a.put("lightslategray", 7833753);
            f30470a.put("lightslategrey", 7833753);
            f30470a.put("lightsteelblue", 11584734);
            f30470a.put("lightyellow", 16777184);
            f30470a.put("lime", 65280);
            f30470a.put("limegreen", 3329330);
            f30470a.put("linen", 16445670);
            f30470a.put("magenta", 16711935);
            f30470a.put("maroon", 8388608);
            f30470a.put("mediumaquamarine", 6737322);
            f30470a.put("mediumblue", 205);
            f30470a.put("mediumorchid", 12211667);
            f30470a.put("mediumpurple", 9662683);
            f30470a.put("mediumseagreen", 3978097);
            f30470a.put("mediumslateblue", 8087790);
            f30470a.put("mediumspringgreen", 64154);
            f30470a.put("mediumturquoise", 4772300);
            f30470a.put("mediumvioletred", 13047173);
            f30470a.put("midnightblue", 1644912);
            f30470a.put("mintcream", 16121850);
            f30470a.put("mistyrose", 16770273);
            f30470a.put("moccasin", 16770229);
            f30470a.put("navajowhite", 16768685);
            f30470a.put("navy", 128);
            f30470a.put("oldlace", 16643558);
            f30470a.put("olive", 8421376);
            f30470a.put("olivedrab", 7048739);
            f30470a.put("orange", 16753920);
            f30470a.put("orangered", 16729344);
            f30470a.put("orchid", 14315734);
            f30470a.put("palegoldenrod", 15657130);
            f30470a.put("palegreen", 10025880);
            f30470a.put("paleturquoise", 11529966);
            f30470a.put("palevioletred", 14381203);
            f30470a.put("papayawhip", 16773077);
            f30470a.put("peachpuff", 16767673);
            f30470a.put("peru", 13468991);
            f30470a.put("pink", 16761035);
            f30470a.put("plum", 14524637);
            f30470a.put("powderblue", 11591910);
            f30470a.put("purple", 8388736);
            f30470a.put("red", Integer.valueOf((int) ItemTouchHelper.ACTION_MODE_DRAG_MASK));
            f30470a.put("rosybrown", 12357519);
            f30470a.put("royalblue", 4286945);
            f30470a.put("saddlebrown", 9127187);
            f30470a.put("salmon", 16416882);
            f30470a.put("sandybrown", 16032864);
            f30470a.put("seagreen", 3050327);
            f30470a.put("seashell", 16774638);
            f30470a.put("sienna", 10506797);
            f30470a.put("silver", 12632256);
            f30470a.put("skyblue", 8900331);
            f30470a.put("slateblue", 6970061);
            f30470a.put("slategray", 7372944);
            f30470a.put("slategrey", 7372944);
            f30470a.put("snow", 16775930);
            f30470a.put("springgreen", 65407);
            f30470a.put("steelblue", 4620980);
            f30470a.put("tan", 13808780);
            f30470a.put("teal", 32896);
            f30470a.put("thistle", 14204888);
            f30470a.put("tomato", 16737095);
            f30470a.put("turquoise", 4251856);
            f30470a.put("violet", 15631086);
            f30470a.put("wheat", 16113331);
            f30470a.put("white", Integer.valueOf((int) ViewCompat.MEASURED_SIZE_MASK));
            f30470a.put("whitesmoke", 16119285);
            f30470a.put("yellow", 16776960);
            f30470a.put("yellowgreen", 10145074);
        }

        public static Integer a(String str) {
            return f30470a.get(str);
        }
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, SVG.o> f30471a;

        static {
            HashMap hashMap = new HashMap(9);
            f30471a = hashMap;
            hashMap.put("xx-small", new SVG.o(0.694f, SVG.Unit.pt));
            f30471a.put("x-small", new SVG.o(0.833f, SVG.Unit.pt));
            f30471a.put("small", new SVG.o(10.0f, SVG.Unit.pt));
            f30471a.put("medium", new SVG.o(12.0f, SVG.Unit.pt));
            f30471a.put("large", new SVG.o(14.4f, SVG.Unit.pt));
            f30471a.put("x-large", new SVG.o(17.3f, SVG.Unit.pt));
            f30471a.put("xx-large", new SVG.o(20.7f, SVG.Unit.pt));
            f30471a.put("smaller", new SVG.o(83.33f, SVG.Unit.percent));
            f30471a.put("larger", new SVG.o(120.0f, SVG.Unit.percent));
        }

        public static SVG.o a(String str) {
            return f30471a.get(str);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final Map<String, Integer> f30472a;

        static {
            HashMap hashMap = new HashMap(13);
            f30472a = hashMap;
            hashMap.put("normal", 400);
            f30472a.put("bold", 700);
            f30472a.put("bolder", 1);
            f30472a.put("lighter", -1);
            f30472a.put("100", 100);
            f30472a.put(BasicPushStatus.SUCCESS_CODE, 200);
            f30472a.put("300", 300);
            f30472a.put(FontParser.sFontWeightDefault, 400);
            f30472a.put("500", 500);
            f30472a.put("600", 600);
            f30472a.put("700", 700);
            f30472a.put("800", 800);
            f30472a.put("900", 900);
        }

        public static Integer a(String str) {
            return f30472a.get(str);
        }
    }

    /* loaded from: classes6.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f30473a;

        /* renamed from: c  reason: collision with root package name */
        public int f30475c;

        /* renamed from: b  reason: collision with root package name */
        public int f30474b = 0;

        /* renamed from: d  reason: collision with root package name */
        public d.c.a.b f30476d = new d.c.a.b();

        public f(String str) {
            this.f30475c = 0;
            String trim = str.trim();
            this.f30473a = trim;
            this.f30475c = trim.length();
        }

        public int a() {
            int i2 = this.f30474b;
            int i3 = this.f30475c;
            if (i2 == i3) {
                return -1;
            }
            int i4 = i2 + 1;
            this.f30474b = i4;
            if (i4 < i3) {
                return this.f30473a.charAt(i4);
            }
            return -1;
        }

        public String b() {
            int i2 = this.f30474b;
            while (!g() && !j(this.f30473a.charAt(this.f30474b))) {
                this.f30474b++;
            }
            String substring = this.f30473a.substring(i2, this.f30474b);
            this.f30474b = i2;
            return substring;
        }

        public Boolean c(Object obj) {
            if (obj == null) {
                return null;
            }
            v();
            return l();
        }

        public float d(float f2) {
            if (Float.isNaN(f2)) {
                return Float.NaN;
            }
            v();
            return m();
        }

        public boolean e(char c2) {
            int i2 = this.f30474b;
            boolean z = i2 < this.f30475c && this.f30473a.charAt(i2) == c2;
            if (z) {
                this.f30474b++;
            }
            return z;
        }

        public boolean f(String str) {
            int length = str.length();
            int i2 = this.f30474b;
            boolean z = i2 <= this.f30475c - length && this.f30473a.substring(i2, i2 + length).equals(str);
            if (z) {
                this.f30474b += length;
            }
            return z;
        }

        public boolean g() {
            return this.f30474b == this.f30475c;
        }

        public boolean h() {
            int i2 = this.f30474b;
            if (i2 == this.f30475c) {
                return false;
            }
            char charAt = this.f30473a.charAt(i2);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        public boolean i(int i2) {
            return i2 == 10 || i2 == 13;
        }

        public boolean j(int i2) {
            return i2 == 32 || i2 == 10 || i2 == 13 || i2 == 9;
        }

        public Integer k() {
            int i2 = this.f30474b;
            if (i2 == this.f30475c) {
                return null;
            }
            String str = this.f30473a;
            this.f30474b = i2 + 1;
            return Integer.valueOf(str.charAt(i2));
        }

        public Boolean l() {
            int i2 = this.f30474b;
            if (i2 == this.f30475c) {
                return null;
            }
            char charAt = this.f30473a.charAt(i2);
            if (charAt == '0' || charAt == '1') {
                this.f30474b++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        public float m() {
            float b2 = this.f30476d.b(this.f30473a, this.f30474b, this.f30475c);
            if (!Float.isNaN(b2)) {
                this.f30474b = this.f30476d.a();
            }
            return b2;
        }

        public String n() {
            if (g()) {
                return null;
            }
            int i2 = this.f30474b;
            int charAt = this.f30473a.charAt(i2);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = a();
            }
            int i3 = this.f30474b;
            while (j(charAt)) {
                charAt = a();
            }
            if (charAt == 40) {
                this.f30474b++;
                return this.f30473a.substring(i2, i3);
            }
            this.f30474b = i2;
            return null;
        }

        public SVG.o o() {
            float m = m();
            if (Float.isNaN(m)) {
                return null;
            }
            SVG.Unit s = s();
            if (s == null) {
                return new SVG.o(m, SVG.Unit.px);
            }
            return new SVG.o(m, s);
        }

        public String p() {
            if (g()) {
                return null;
            }
            int i2 = this.f30474b;
            char charAt = this.f30473a.charAt(i2);
            if (charAt == '\'' || charAt == '\"') {
                int a2 = a();
                while (a2 != -1 && a2 != charAt) {
                    a2 = a();
                }
                if (a2 == -1) {
                    this.f30474b = i2;
                    return null;
                }
                int i3 = this.f30474b + 1;
                this.f30474b = i3;
                return this.f30473a.substring(i2 + 1, i3 - 1);
            }
            return null;
        }

        public String q() {
            return r(' ');
        }

        public String r(char c2) {
            if (g()) {
                return null;
            }
            char charAt = this.f30473a.charAt(this.f30474b);
            if (j(charAt) || charAt == c2) {
                return null;
            }
            int i2 = this.f30474b;
            int a2 = a();
            while (a2 != -1 && a2 != c2 && !j(a2)) {
                a2 = a();
            }
            return this.f30473a.substring(i2, this.f30474b);
        }

        public SVG.Unit s() {
            if (g()) {
                return null;
            }
            if (this.f30473a.charAt(this.f30474b) == '%') {
                this.f30474b++;
                return SVG.Unit.percent;
            }
            int i2 = this.f30474b;
            if (i2 > this.f30475c - 2) {
                return null;
            }
            try {
                SVG.Unit valueOf = SVG.Unit.valueOf(this.f30473a.substring(i2, i2 + 2).toLowerCase(Locale.US));
                this.f30474b += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public float t() {
            v();
            float b2 = this.f30476d.b(this.f30473a, this.f30474b, this.f30475c);
            if (!Float.isNaN(b2)) {
                this.f30474b = this.f30476d.a();
            }
            return b2;
        }

        public String u() {
            if (g()) {
                return null;
            }
            int i2 = this.f30474b;
            this.f30474b = this.f30475c;
            return this.f30473a.substring(i2);
        }

        public boolean v() {
            w();
            int i2 = this.f30474b;
            if (i2 != this.f30475c && this.f30473a.charAt(i2) == ',') {
                this.f30474b++;
                w();
                return true;
            }
            return false;
        }

        public void w() {
            while (true) {
                int i2 = this.f30474b;
                if (i2 >= this.f30475c || !j(this.f30473a.charAt(i2))) {
                    return;
                }
                this.f30474b++;
            }
        }
    }

    public static void B0(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        switch (a.f30468b[SVGAttr.fromString(str).ordinal()]) {
            case 47:
                style.f30411f = h0(str2, "fill");
                style.f30410e |= 1;
                return;
            case 48:
                style.f30412g = S(str2);
                style.f30410e |= 2;
                return;
            case 49:
                style.f30413h = Float.valueOf(f0(str2));
                style.f30410e |= 4;
                return;
            case 50:
                style.f30414i = h0(str2, "stroke");
                style.f30410e |= 8;
                return;
            case 51:
                style.j = Float.valueOf(f0(str2));
                style.f30410e |= 16;
                return;
            case 52:
                style.k = c0(str2);
                style.f30410e |= 32;
                return;
            case 53:
                style.l = n0(str2);
                style.f30410e |= 64;
                return;
            case 54:
                style.m = o0(str2);
                style.f30410e |= 128;
                return;
            case 55:
                style.n = Float.valueOf(T(str2));
                style.f30410e |= 256;
                return;
            case 56:
                if ("none".equals(str2)) {
                    style.o = null;
                } else {
                    style.o = m0(str2);
                }
                style.f30410e |= 512;
                return;
            case 57:
                style.p = c0(str2);
                style.f30410e |= 1024;
                return;
            case 58:
                style.q = Float.valueOf(f0(str2));
                style.f30410e |= 2048;
                return;
            case 59:
                style.r = P(str2);
                style.f30410e |= 4096;
                return;
            case 60:
                V(style, str2);
                return;
            case 61:
                style.s = W(str2);
                style.f30410e |= 8192;
                return;
            case 62:
                style.t = X(str2);
                style.f30410e |= 16384;
                return;
            case 63:
                style.u = Z(str2);
                style.f30410e |= 32768;
                return;
            case 64:
                style.v = Y(str2);
                style.f30410e |= 65536;
                return;
            case 65:
                style.w = s0(str2);
                style.f30410e |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                return;
            case 66:
                style.x = t0(str2);
                style.f30410e |= 68719476736L;
                return;
            case 67:
                style.y = r0(str2);
                style.f30410e |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                return;
            case 68:
                style.z = g0(str2);
                style.f30410e |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                return;
            case 69:
                String a0 = a0(str2, str);
                style.B = a0;
                style.C = a0;
                style.D = a0;
                style.f30410e |= 14680064;
                return;
            case 70:
                style.B = a0(str2, str);
                style.f30410e |= 2097152;
                return;
            case 71:
                style.C = a0(str2, str);
                style.f30410e |= 4194304;
                return;
            case 72:
                style.D = a0(str2, str);
                style.f30410e |= 8388608;
                return;
            case 73:
                if (str2.indexOf(124) < 0) {
                    if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') != -1) {
                        style.E = Boolean.valueOf(!str2.equals("none"));
                        style.f30410e |= 16777216;
                        return;
                    }
                }
                throw new SAXException("Invalid value for \"display\" attribute: " + str2);
            case 74:
                if (str2.indexOf(124) < 0) {
                    if ("|visible|hidden|collapse|".indexOf('|' + str2 + '|') != -1) {
                        style.F = Boolean.valueOf(str2.equals("visible"));
                        style.f30410e |= 33554432;
                        return;
                    }
                }
                throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
            case 75:
                if (str2.equals("currentColor")) {
                    style.G = SVG.g.b();
                } else {
                    style.G = P(str2);
                }
                style.f30410e |= 67108864;
                return;
            case 76:
                style.H = Float.valueOf(f0(str2));
                style.f30410e |= 134217728;
                return;
            case 77:
                style.A = O(str2);
                style.f30410e |= 1048576;
                return;
            case 78:
                style.I = a0(str2, str);
                style.f30410e |= AccountConstants.TYPE_MODIFY_NICKNAME;
                return;
            case 79:
                style.J = S(str2);
                style.f30410e |= 536870912;
                return;
            case 80:
                style.K = a0(str2, str);
                style.f30410e |= 1073741824;
                return;
            case 81:
                if (str2.equals("currentColor")) {
                    style.L = SVG.g.b();
                } else {
                    style.L = P(str2);
                }
                style.f30410e |= 2147483648L;
                return;
            case 82:
                style.M = Float.valueOf(f0(str2));
                style.f30410e |= 4294967296L;
                return;
            case 83:
                if (str2.equals("currentColor")) {
                    style.N = SVG.g.b();
                } else {
                    style.N = P(str2);
                }
                style.f30410e |= AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                return;
            case 84:
                style.O = Float.valueOf(f0(str2));
                style.f30410e |= 17179869184L;
                return;
            case 85:
                style.P = v0(str2);
                style.f30410e |= 34359738368L;
                return;
            default:
                return;
        }
    }

    public static SVG.c O(String str) throws SAXException {
        if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).startsWith("rect(")) {
            f fVar = new f(str.substring(5));
            fVar.w();
            SVG.o e0 = e0(fVar);
            fVar.v();
            SVG.o e02 = e0(fVar);
            fVar.v();
            SVG.o e03 = e0(fVar);
            fVar.v();
            SVG.o e04 = e0(fVar);
            fVar.w();
            if (fVar.e(')')) {
                return new SVG.c(e0, e02, e03, e04);
            }
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
    }

    public static SVG.f P(String str) throws SAXException {
        if (str.charAt(0) == '#') {
            d.c.a.a b2 = d.c.a.a.b(str, 1, str.length());
            if (b2 != null) {
                int a2 = b2.a();
                if (a2 == 7) {
                    return new SVG.f(b2.c());
                }
                if (a2 == 4) {
                    int c2 = b2.c();
                    int i2 = c2 & DisplayCompat.DISPLAY_SIZE_4K_WIDTH;
                    int i3 = c2 & 240;
                    int i4 = c2 & 15;
                    return new SVG.f(i4 | (i2 << 12) | (i2 << 16) | (i3 << 8) | (i3 << 4) | (i4 << 4));
                }
                throw new SAXException("Bad hex colour value: " + str);
            }
            throw new SAXException("Bad hex colour value: " + str);
        } else if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            f fVar = new f(str.substring(4));
            fVar.w();
            float m = fVar.m();
            if (!Float.isNaN(m) && fVar.e('%')) {
                m = (m * 256.0f) / 100.0f;
            }
            float d2 = fVar.d(m);
            if (!Float.isNaN(d2) && fVar.e('%')) {
                d2 = (d2 * 256.0f) / 100.0f;
            }
            float d3 = fVar.d(d2);
            if (!Float.isNaN(d3) && fVar.e('%')) {
                d3 = (d3 * 256.0f) / 100.0f;
            }
            fVar.w();
            if (!Float.isNaN(d3) && fVar.e(')')) {
                return new SVG.f((b(m) << 16) | (b(d2) << 8) | b(d3));
            }
            throw new SAXException("Bad rgb() colour value: " + str);
        } else {
            return Q(str);
        }
    }

    public static SVG.f Q(String str) throws SAXException {
        Integer a2 = c.a(str.toLowerCase(Locale.US));
        if (a2 != null) {
            return new SVG.f(a2.intValue());
        }
        throw new SAXException("Invalid colour keyword: " + str);
    }

    public static SVG.m0 R(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals("currentColor")) {
            return SVG.g.b();
        }
        return P(str);
    }

    public static SVG.Style.FillRule S(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    public static float T(String str) throws SAXException {
        int length = str.length();
        if (length != 0) {
            return U(str, 0, length);
        }
        throw new SAXException("Invalid float value (empty string)");
    }

    public static float U(String str, int i2, int i3) throws SAXException {
        float b2 = new d.c.a.b().b(str, i2, i3);
        if (Float.isNaN(b2)) {
            throw new SAXException("Invalid float value: " + str);
        }
        return b2;
    }

    public static void V(SVG.Style style, String str) throws SAXException {
        String r;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf('|' + str + '|') != -1) {
            return;
        }
        f fVar = new f(str);
        Integer num = null;
        SVG.Style.FontStyle fontStyle = null;
        String str2 = null;
        while (true) {
            r = fVar.r('/');
            fVar.w();
            if (r == null) {
                throw new SAXException("Invalid font style attribute: missing font size and family");
            }
            if (num != null && fontStyle != null) {
                break;
            } else if (!r.equals("normal") && (num != null || (num = e.a(r)) == null)) {
                if (fontStyle != null || (fontStyle = g(r)) == null) {
                    if (str2 != null || !r.equals("small-caps")) {
                        break;
                    }
                    str2 = r;
                }
            }
        }
        SVG.o X = X(r);
        if (fVar.e('/')) {
            fVar.w();
            String q = fVar.q();
            if (q != null) {
                c0(q);
                fVar.w();
            } else {
                throw new SAXException("Invalid font style attribute: missing line-height");
            }
        }
        style.s = W(fVar.u());
        style.t = X;
        style.u = Integer.valueOf(num == null ? 400 : num.intValue());
        if (fontStyle == null) {
            fontStyle = SVG.Style.FontStyle.Normal;
        }
        style.v = fontStyle;
        style.f30410e |= 122880;
    }

    public static List<String> W(String str) throws SAXException {
        f fVar = new f(str);
        ArrayList arrayList = null;
        do {
            String p = fVar.p();
            if (p == null) {
                p = fVar.r(',');
            }
            if (p == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(p);
            fVar.v();
        } while (!fVar.g());
        return arrayList;
    }

    public static SVG.o X(String str) throws SAXException {
        SVG.o a2 = d.a(str);
        return a2 == null ? c0(str) : a2;
    }

    public static SVG.Style.FontStyle Y(String str) throws SAXException {
        SVG.Style.FontStyle g2 = g(str);
        if (g2 != null) {
            return g2;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    public static Integer Z(String str) throws SAXException {
        Integer a2 = e.a(str);
        if (a2 != null) {
            return a2;
        }
        throw new SAXException("Invalid font-weight property: " + str);
    }

    public static String a0(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.startsWith("url(") && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
            return str.substring(4, str.length() - 1).trim();
        }
        throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
    }

    public static int b(float f2) {
        if (f2 < 0.0f) {
            return 0;
        }
        if (f2 > 255.0f) {
            return 255;
        }
        return Math.round(f2);
    }

    public static SVG.o c0(String str) throws SAXException {
        if (str.length() != 0) {
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
                } catch (IllegalArgumentException unused) {
                    throw new SAXException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.o(U(str, 0, length), unit);
            } catch (NumberFormatException e2) {
                throw new SAXException("Invalid length value: " + str, e2);
            }
        }
        throw new SAXException("Invalid length value (empty string)");
    }

    public static List<SVG.o> d0(String str) throws SAXException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            f fVar = new f(str);
            fVar.w();
            while (!fVar.g()) {
                float m = fVar.m();
                if (!Float.isNaN(m)) {
                    SVG.Unit s = fVar.s();
                    if (s == null) {
                        s = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.o(m, s));
                    fVar.v();
                } else {
                    throw new SAXException("Invalid length list value: " + fVar.b());
                }
            }
            return arrayList;
        }
        throw new SAXException("Invalid length list (empty string)");
    }

    public static SVG.o e0(f fVar) {
        if (fVar.f(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            return new SVG.o(0.0f);
        }
        return fVar.o();
    }

    public static float f0(String str) throws SAXException {
        float T = T(str);
        if (T < 0.0f) {
            return 0.0f;
        }
        if (T > 1.0f) {
            return 1.0f;
        }
        return T;
    }

    public static SVG.Style.FontStyle g(String str) {
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

    public static Boolean g0(String str) throws SAXException {
        if (!"visible".equals(str) && !DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str)) {
            if (!"hidden".equals(str) && !"scroll".equals(str)) {
                throw new SAXException("Invalid toverflow property: " + str);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static SVG.m0 h0(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new SVG.t(trim, trim2.length() > 0 ? R(trim2) : null);
            }
            throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
        }
        return R(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x02af, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SVG.v i0(String str) throws SAXException {
        float t;
        float d2;
        float d3;
        float d4;
        float f2;
        float f3;
        f fVar = new f(str);
        SVG.v vVar = new SVG.v();
        if (fVar.g()) {
            return vVar;
        }
        int intValue = fVar.k().intValue();
        int i2 = 109;
        if (intValue != 77 && intValue != 109) {
            return vVar;
        }
        int i3 = intValue;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (true) {
            fVar.w();
            switch (i3) {
                case 65:
                case 97:
                    float m = fVar.m();
                    float d5 = fVar.d(m);
                    float d6 = fVar.d(d5);
                    Boolean c2 = fVar.c(Float.valueOf(d6));
                    Boolean c3 = fVar.c(c2);
                    if (c3 == null) {
                        t = Float.NaN;
                        d2 = Float.NaN;
                    } else {
                        t = fVar.t();
                        d2 = fVar.d(t);
                    }
                    if (!Float.isNaN(d2) && m >= 0.0f && d5 >= 0.0f) {
                        if (i3 == 97) {
                            t += f4;
                            d2 += f6;
                        }
                        vVar.e(m, d5, d6, c2.booleanValue(), c3.booleanValue(), t, d2);
                        f4 = t;
                        f5 = f4;
                        f6 = d2;
                        f7 = f6;
                        break;
                    }
                    break;
                case 67:
                case 99:
                    float m2 = fVar.m();
                    float d7 = fVar.d(m2);
                    float d8 = fVar.d(d7);
                    float d9 = fVar.d(d8);
                    d3 = fVar.d(d9);
                    d4 = fVar.d(d3);
                    if (Float.isNaN(d4)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 99) {
                        d3 += f4;
                        d4 += f6;
                        m2 += f4;
                        d7 += f6;
                        d8 += f4;
                        d9 += f6;
                    }
                    f2 = d8;
                    f3 = d9;
                    vVar.d(m2, d7, f2, f3, d3, d4);
                    f5 = f2;
                    f4 = d3;
                    f7 = f3;
                    f6 = d4;
                    break;
                case 72:
                case 104:
                    float m3 = fVar.m();
                    if (Float.isNaN(m3)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 104) {
                        m3 += f4;
                    }
                    f4 = m3;
                    vVar.b(f4, f6);
                    f5 = f4;
                    break;
                case 76:
                case 108:
                    float m4 = fVar.m();
                    float d10 = fVar.d(m4);
                    if (Float.isNaN(d10)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 108) {
                        m4 += f4;
                        d10 += f6;
                    }
                    f4 = m4;
                    f6 = d10;
                    vVar.b(f4, f6);
                    f5 = f4;
                    f7 = f6;
                    break;
                case 77:
                case 109:
                    float m5 = fVar.m();
                    float d11 = fVar.d(m5);
                    if (Float.isNaN(d11)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == i2 && !vVar.i()) {
                        m5 += f4;
                        d11 += f6;
                    }
                    f4 = m5;
                    f6 = d11;
                    vVar.a(f4, f6);
                    f5 = f4;
                    f8 = f5;
                    f7 = f6;
                    f9 = f7;
                    i3 = i3 != i2 ? 76 : 108;
                    break;
                case 81:
                case 113:
                    f5 = fVar.m();
                    f7 = fVar.d(f5);
                    float d12 = fVar.d(f7);
                    float d13 = fVar.d(d12);
                    if (Float.isNaN(d13)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 113) {
                        d12 += f4;
                        d13 += f6;
                        f5 += f4;
                        f7 += f6;
                    }
                    f4 = d12;
                    f6 = d13;
                    vVar.c(f5, f7, f4, f6);
                    break;
                case 83:
                case 115:
                    float f10 = (f4 * 2.0f) - f5;
                    float f11 = (2.0f * f6) - f7;
                    float m6 = fVar.m();
                    float d14 = fVar.d(m6);
                    d3 = fVar.d(d14);
                    d4 = fVar.d(d3);
                    if (Float.isNaN(d4)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 115) {
                        d3 += f4;
                        d4 += f6;
                        m6 += f4;
                        d14 += f6;
                    }
                    f2 = m6;
                    f3 = d14;
                    vVar.d(f10, f11, f2, f3, d3, d4);
                    f5 = f2;
                    f4 = d3;
                    f7 = f3;
                    f6 = d4;
                    break;
                case 84:
                case 116:
                    f5 = (f4 * 2.0f) - f5;
                    f7 = (2.0f * f6) - f7;
                    float m7 = fVar.m();
                    float d15 = fVar.d(m7);
                    if (Float.isNaN(d15)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 116) {
                        m7 += f4;
                        d15 += f6;
                    }
                    f4 = m7;
                    f6 = d15;
                    vVar.c(f5, f7, f4, f6);
                    break;
                case 86:
                case 118:
                    float m8 = fVar.m();
                    if (Float.isNaN(m8)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) i3) + " path segment");
                        return vVar;
                    }
                    if (i3 == 118) {
                        m8 += f6;
                    }
                    f6 = m8;
                    vVar.b(f4, f6);
                    f7 = f6;
                    break;
                case 90:
                case 122:
                    vVar.close();
                    f4 = f8;
                    f5 = f4;
                    f6 = f9;
                    f7 = f6;
                    break;
                default:
                    return vVar;
            }
            fVar.v();
            if (fVar.g()) {
                return vVar;
            }
            if (fVar.h()) {
                i3 = fVar.k().intValue();
            }
            i2 = 109;
        }
    }

    public static void j0(SVG.n0 n0Var, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        f fVar = new f(str);
        fVar.w();
        String q = fVar.q();
        if ("defer".equals(q)) {
            fVar.w();
            q = fVar.q();
        }
        PreserveAspectRatio.Alignment a2 = b.a(q);
        fVar.w();
        if (fVar.g()) {
            scale = null;
        } else {
            String q2 = fVar.q();
            if (q2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (q2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        n0Var.n = new PreserveAspectRatio(a2, scale);
    }

    public static Set<String> k0(String str) throws SAXException {
        f fVar = new f(str);
        HashSet hashSet = new HashSet();
        while (!fVar.g()) {
            String q = fVar.q();
            if (q.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(q.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            fVar.w();
        }
        return hashSet;
    }

    public static Set<String> l0(String str) throws SAXException {
        f fVar = new f(str);
        HashSet hashSet = new HashSet();
        while (!fVar.g()) {
            hashSet.add(fVar.q());
            fVar.w();
        }
        return hashSet;
    }

    public static SVG.o[] m0(String str) throws SAXException {
        SVG.o o;
        f fVar = new f(str);
        fVar.w();
        if (fVar.g() || (o = fVar.o()) == null) {
            return null;
        }
        if (!o.h()) {
            float b2 = o.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(o);
            while (!fVar.g()) {
                fVar.v();
                SVG.o o2 = fVar.o();
                if (o2 != null) {
                    if (!o2.h()) {
                        arrayList.add(o2);
                        b2 += o2.b();
                    } else {
                        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                    }
                } else {
                    throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                }
            }
            if (b2 == 0.0f) {
                return null;
            }
            return (SVG.o[]) arrayList.toArray(new SVG.o[arrayList.size()]);
        }
        throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
    }

    public static SVG.Style.LineCaps n0(String str) throws SAXException {
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

    public static SVG.Style.LineJoin o0(String str) throws SAXException {
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

    public static void p0(SVG.j0 j0Var, String str) throws SAXException {
        f fVar = new f(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String r = fVar.r(':');
            fVar.w();
            if (!fVar.e(':')) {
                return;
            }
            fVar.w();
            String r2 = fVar.r(';');
            if (r2 == null) {
                return;
            }
            fVar.w();
            if (fVar.g() || fVar.e(';')) {
                if (j0Var.f30438f == null) {
                    j0Var.f30438f = new SVG.Style();
                }
                B0(j0Var.f30438f, r, r2);
                fVar.w();
            }
        }
    }

    public static Set<String> q0(String str) throws SAXException {
        f fVar = new f(str);
        HashSet hashSet = new HashSet();
        while (!fVar.g()) {
            String q = fVar.q();
            int indexOf = q.indexOf(45);
            if (indexOf != -1) {
                q = q.substring(0, indexOf);
            }
            hashSet.add(new Locale(q, "", "").getLanguage());
            fVar.w();
        }
        return hashSet;
    }

    public static SVG.Style.TextAnchor r0(String str) throws SAXException {
        if (IntentConfig.START.equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if (ProgressInfo.JSON_KEY_END.equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    public static SVG.Style.TextDecoration s0(String str) throws SAXException {
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

    public static SVG.Style.TextDirection t0(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    public static SVG.Style.VectorEffect v0(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    public static SVG.b w0(String str) throws SAXException {
        f fVar = new f(str);
        fVar.w();
        float m = fVar.m();
        fVar.v();
        float m2 = fVar.m();
        fVar.v();
        float m3 = fVar.m();
        fVar.v();
        float m4 = fVar.m();
        if (Float.isNaN(m) || Float.isNaN(m2) || Float.isNaN(m3) || Float.isNaN(m4)) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        }
        if (m3 >= 0.0f) {
            if (m4 >= 0.0f) {
                return new SVG.b(m, m2, m3, m4);
            }
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
        throw new SAXException("Invalid viewBox. width cannot be negative");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(SVG.x xVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                xVar.s = c0(trim);
            } else if (i3 == 2) {
                xVar.t = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                xVar.u = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <pattern> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.o c02 = c0(trim);
                xVar.v = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i3 != 6) {
                switch (i3) {
                    case 40:
                        if ("objectBoundingBox".equals(trim)) {
                            xVar.p = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            xVar.p = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternUnits");
                        }
                    case 41:
                        if ("objectBoundingBox".equals(trim)) {
                            xVar.q = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            xVar.q = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternContentUnits");
                        }
                    case 42:
                        xVar.r = u0(trim);
                        continue;
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                xVar.w = trim;
            }
        }
    }

    public final void A0(Attributes attributes) throws SAXException {
        d("<polyline>", new Object[0]);
        if (this.f30455b != null) {
            SVG.y yVar = new SVG.y();
            yVar.f30440a = this.f30454a;
            yVar.f30441b = this.f30455b;
            r(yVar, attributes);
            G(yVar, attributes);
            K(yVar, attributes);
            q(yVar, attributes);
            B(yVar, attributes, "polyline");
            this.f30455b.i(yVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void B(SVG.y yVar, Attributes attributes, String str) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.points) {
                f fVar = new f(attributes.getValue(i2));
                ArrayList<Float> arrayList = new ArrayList();
                fVar.w();
                while (!fVar.g()) {
                    float m = fVar.m();
                    if (!Float.isNaN(m)) {
                        fVar.v();
                        float m2 = fVar.m();
                        if (!Float.isNaN(m2)) {
                            fVar.v();
                            arrayList.add(Float.valueOf(m));
                            arrayList.add(Float.valueOf(m2));
                        } else {
                            throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                yVar.o = new float[arrayList.size()];
                int i3 = 0;
                for (Float f2 : arrayList) {
                    yVar.o[i3] = f2.floatValue();
                    i3++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(SVG.o0 o0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 35) {
                o0Var.p = c0(trim);
            } else if (i3 != 36) {
                switch (i3) {
                    case 12:
                        o0Var.m = c0(trim);
                        continue;
                    case 13:
                        o0Var.n = c0(trim);
                        continue;
                    case 14:
                        SVG.o c0 = c0(trim);
                        o0Var.o = c0;
                        if (c0.h()) {
                            throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                        }
                        continue;
                }
            } else {
                o0Var.q = c0(trim);
            }
        }
    }

    public final void C0(Attributes attributes) throws SAXException {
        d("<radialGradient>", new Object[0]);
        if (this.f30455b != null) {
            SVG.o0 o0Var = new SVG.o0();
            o0Var.f30440a = this.f30454a;
            o0Var.f30441b = this.f30455b;
            r(o0Var, attributes);
            G(o0Var, attributes);
            t(o0Var, attributes);
            C(o0Var, attributes);
            this.f30455b.i(o0Var);
            this.f30455b = o0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void D(SVG.a0 a0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                a0Var.o = c0(trim);
            } else if (i3 == 2) {
                a0Var.p = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                a0Var.q = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.o c02 = c0(trim);
                a0Var.r = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i3 == 10) {
                SVG.o c03 = c0(trim);
                a0Var.s = c03;
                if (c03.h()) {
                    throw new SAXException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i3 != 11) {
                continue;
            } else {
                SVG.o c04 = c0(trim);
                a0Var.t = c04;
                if (c04.h()) {
                    throw new SAXException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    public final void D0(Attributes attributes) throws SAXException {
        d("<rect>", new Object[0]);
        if (this.f30455b != null) {
            SVG.a0 a0Var = new SVG.a0();
            a0Var.f30440a = this.f30454a;
            a0Var.f30441b = this.f30455b;
            r(a0Var, attributes);
            G(a0Var, attributes);
            K(a0Var, attributes);
            q(a0Var, attributes);
            D(a0Var, attributes);
            this.f30455b.i(a0Var);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void E(SVG.d0 d0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                d0Var.p = c0(trim);
            } else if (i3 == 2) {
                d0Var.q = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                d0Var.r = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.o c02 = c0(trim);
                d0Var.s = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i3 == 5) {
                d0Var.t = trim;
            }
        }
    }

    public final void E0(Attributes attributes) throws SAXException {
        d("<solidColor>", new Object[0]);
        if (this.f30455b != null) {
            SVG.b0 b0Var = new SVG.b0();
            b0Var.f30440a = this.f30454a;
            b0Var.f30441b = this.f30455b;
            r(b0Var, attributes);
            G(b0Var, attributes);
            this.f30455b.i(b0Var);
            this.f30455b = b0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void F(SVG.c0 c0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 37) {
                c0Var.f30426h = b0(trim);
            }
        }
    }

    public final void F0(Attributes attributes) throws SAXException {
        d("<stop>", new Object[0]);
        SVG.h0 h0Var = this.f30455b;
        if (h0Var != null) {
            if (h0Var instanceof SVG.j) {
                SVG.c0 c0Var = new SVG.c0();
                c0Var.f30440a = this.f30454a;
                c0Var.f30441b = this.f30455b;
                r(c0Var, attributes);
                G(c0Var, attributes);
                F(c0Var, attributes);
                this.f30455b.i(c0Var);
                this.f30455b = c0Var;
                return;
            }
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void G(SVG.j0 j0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 45) {
                    p0(j0Var, trim);
                } else if (i3 != 46) {
                    if (j0Var.f30437e == null) {
                        j0Var.f30437e = new SVG.Style();
                    }
                    B0(j0Var.f30437e, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                } else {
                    j0Var.f30439g = CSSParser.f(trim);
                }
            }
        }
    }

    public final void G0(Attributes attributes) throws SAXException {
        d("<style>", new Object[0]);
        if (this.f30455b != null) {
            String str = "all";
            boolean z = true;
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 87) {
                    z = trim.equals("text/css");
                } else if (i3 == 88) {
                    str = trim;
                }
            }
            if (z && CSSParser.b(str, CSSParser.MediaType.screen)) {
                this.f30461h = true;
                return;
            }
            this.f30456c = true;
            this.f30457d = 1;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void H(SVG.s0 s0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 6 && "http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                s0Var.n = trim;
            }
        }
    }

    public final void H0(Attributes attributes) throws SAXException {
        d("<svg>", new Object[0]);
        SVG.d0 d0Var = new SVG.d0();
        d0Var.f30440a = this.f30454a;
        d0Var.f30441b = this.f30455b;
        r(d0Var, attributes);
        G(d0Var, attributes);
        q(d0Var, attributes);
        M(d0Var, attributes);
        E(d0Var, attributes);
        SVG.h0 h0Var = this.f30455b;
        if (h0Var == null) {
            this.f30454a.p(d0Var);
        } else {
            h0Var.i(d0Var);
        }
        this.f30455b = d0Var;
    }

    public final void I(SVG.x0 x0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 != 6) {
                if (i3 == 39) {
                    x0Var.o = c0(trim);
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                x0Var.n = trim;
            }
        }
    }

    public final void I0(Attributes attributes) throws SAXException {
        d("<symbol>", new Object[0]);
        if (this.f30455b != null) {
            SVG.p0 r0Var = new SVG.r0();
            r0Var.f30440a = this.f30454a;
            r0Var.f30441b = this.f30455b;
            r(r0Var, attributes);
            G(r0Var, attributes);
            q(r0Var, attributes);
            M(r0Var, attributes);
            this.f30455b.i(r0Var);
            this.f30455b = r0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void J(SVG.y0 y0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                y0Var.n = d0(trim);
            } else if (i3 == 2) {
                y0Var.o = d0(trim);
            } else if (i3 == 19) {
                y0Var.p = d0(trim);
            } else if (i3 == 20) {
                y0Var.q = d0(trim);
            }
        }
    }

    public final void J0(Attributes attributes) throws SAXException {
        d("<text>", new Object[0]);
        if (this.f30455b != null) {
            SVG.u0 u0Var = new SVG.u0();
            u0Var.f30440a = this.f30454a;
            u0Var.f30441b = this.f30455b;
            r(u0Var, attributes);
            G(u0Var, attributes);
            K(u0Var, attributes);
            q(u0Var, attributes);
            J(u0Var, attributes);
            this.f30455b.i(u0Var);
            this.f30455b = u0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void K(SVG.m mVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.transform) {
                mVar.l(u0(attributes.getValue(i2)));
            }
        }
    }

    public final void K0(Attributes attributes) throws SAXException {
        d("<textPath>", new Object[0]);
        if (this.f30455b != null) {
            SVG.x0 x0Var = new SVG.x0();
            x0Var.f30440a = this.f30454a;
            x0Var.f30441b = this.f30455b;
            r(x0Var, attributes);
            G(x0Var, attributes);
            q(x0Var, attributes);
            I(x0Var, attributes);
            this.f30455b.i(x0Var);
            this.f30455b = x0Var;
            SVG.h0 h0Var = x0Var.f30441b;
            if (h0Var instanceof SVG.z0) {
                x0Var.n((SVG.z0) h0Var);
                return;
            } else {
                x0Var.n(((SVG.v0) h0Var).c());
                return;
            }
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void L(SVG.b1 b1Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                b1Var.p = c0(trim);
            } else if (i3 == 2) {
                b1Var.q = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                b1Var.r = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                }
            } else if (i3 != 4) {
                if (i3 == 6 && "http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                    b1Var.o = trim;
                }
            } else {
                SVG.o c02 = c0(trim);
                b1Var.s = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    public final void L0(Attributes attributes) throws SAXException {
        d("<tref>", new Object[0]);
        SVG.h0 h0Var = this.f30455b;
        if (h0Var != null) {
            if (h0Var instanceof SVG.w0) {
                SVG.s0 s0Var = new SVG.s0();
                s0Var.f30440a = this.f30454a;
                s0Var.f30441b = this.f30455b;
                r(s0Var, attributes);
                G(s0Var, attributes);
                q(s0Var, attributes);
                H(s0Var, attributes);
                this.f30455b.i(s0Var);
                SVG.h0 h0Var2 = s0Var.f30441b;
                if (h0Var2 instanceof SVG.z0) {
                    s0Var.n((SVG.z0) h0Var2);
                    return;
                } else {
                    s0Var.n(((SVG.v0) h0Var2).c());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void M(SVG.p0 p0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 7) {
                j0(p0Var, trim);
            } else if (i3 == 86) {
                p0Var.o = w0(trim);
            }
        }
    }

    public final void M0(Attributes attributes) throws SAXException {
        d("<tspan>", new Object[0]);
        SVG.h0 h0Var = this.f30455b;
        if (h0Var != null) {
            if (h0Var instanceof SVG.w0) {
                SVG.t0 t0Var = new SVG.t0();
                t0Var.f30440a = this.f30454a;
                t0Var.f30441b = this.f30455b;
                r(t0Var, attributes);
                G(t0Var, attributes);
                q(t0Var, attributes);
                J(t0Var, attributes);
                this.f30455b.i(t0Var);
                this.f30455b = t0Var;
                SVG.h0 h0Var2 = t0Var.f30441b;
                if (h0Var2 instanceof SVG.z0) {
                    t0Var.n((SVG.z0) h0Var2);
                    return;
                } else {
                    t0Var.n(((SVG.v0) h0Var2).c());
                    return;
                }
            }
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void N(String str) throws SAXException {
        this.f30454a.a(new CSSParser(CSSParser.MediaType.screen).d(str));
    }

    public final void N0(Attributes attributes) throws SAXException {
        d("<use>", new Object[0]);
        if (this.f30455b != null) {
            SVG.b1 b1Var = new SVG.b1();
            b1Var.f30440a = this.f30454a;
            b1Var.f30441b = this.f30455b;
            r(b1Var, attributes);
            G(b1Var, attributes);
            K(b1Var, attributes);
            q(b1Var, attributes);
            L(b1Var, attributes);
            this.f30455b.i(b1Var);
            this.f30455b = b1Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void O0(Attributes attributes) throws SAXException {
        d("<view>", new Object[0]);
        if (this.f30455b != null) {
            SVG.p0 c1Var = new SVG.c1();
            c1Var.f30440a = this.f30454a;
            c1Var.f30441b = this.f30455b;
            r(c1Var, attributes);
            q(c1Var, attributes);
            M(c1Var, attributes);
            this.f30455b.i(c1Var);
            this.f30455b = c1Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void P0(Attributes attributes) throws SAXException {
        d("<switch>", new Object[0]);
        if (this.f30455b != null) {
            SVG.q0 q0Var = new SVG.q0();
            q0Var.f30440a = this.f30454a;
            q0Var.f30441b = this.f30455b;
            r(q0Var, attributes);
            G(q0Var, attributes);
            K(q0Var, attributes);
            q(q0Var, attributes);
            this.f30455b.i(q0Var);
            this.f30455b = q0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void a(Attributes attributes) throws SAXException {
        d("<circle>", new Object[0]);
        if (this.f30455b != null) {
            SVG.d dVar = new SVG.d();
            dVar.f30440a = this.f30454a;
            dVar.f30441b = this.f30455b;
            r(dVar, attributes);
            G(dVar, attributes);
            K(dVar, attributes);
            q(dVar, attributes);
            o(dVar, attributes);
            this.f30455b.i(dVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final Float b0(String str) throws SAXException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z = false;
            }
            try {
                float U = U(str, 0, length);
                float f2 = 100.0f;
                if (z) {
                    U /= 100.0f;
                }
                if (U < 0.0f) {
                    f2 = 0.0f;
                } else if (U <= 100.0f) {
                    f2 = U;
                }
                return Float.valueOf(f2);
            } catch (NumberFormatException e2) {
                throw new SAXException("Invalid offset value in <stop>: " + str, e2);
            }
        }
        throw new SAXException("Invalid offset value in <stop> (empty string)");
    }

    public final void c(Attributes attributes) throws SAXException {
        d("<clipPath>", new Object[0]);
        if (this.f30455b != null) {
            SVG.e eVar = new SVG.e();
            eVar.f30440a = this.f30454a;
            eVar.f30441b = this.f30455b;
            r(eVar, attributes);
            G(eVar, attributes);
            K(eVar, attributes);
            q(eVar, attributes);
            p(eVar, attributes);
            this.f30455b.i(eVar);
            this.f30455b = eVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) throws SAXException {
        if (this.f30456c) {
            return;
        }
        if (this.f30458e) {
            if (this.f30460g == null) {
                this.f30460g = new StringBuilder(i3);
            }
            this.f30460g.append(cArr, i2, i3);
        } else if (this.f30461h) {
            if (this.f30462i == null) {
                this.f30462i = new StringBuilder(i3);
            }
            this.f30462i.append(cArr, i2, i3);
        } else {
            SVG.h0 h0Var = this.f30455b;
            if (h0Var instanceof SVG.w0) {
                SVG.f0 f0Var = (SVG.f0) h0Var;
                int size = f0Var.f30429i.size();
                SVG.l0 l0Var = size == 0 ? null : f0Var.f30429i.get(size - 1);
                if (l0Var instanceof SVG.a1) {
                    StringBuilder sb = new StringBuilder();
                    SVG.a1 a1Var = (SVG.a1) l0Var;
                    sb.append(a1Var.f30416c);
                    sb.append(new String(cArr, i2, i3));
                    a1Var.f30416c = sb.toString();
                    return;
                }
                ((SVG.f0) this.f30455b).i(new SVG.a1(new String(cArr, i2, i3)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i2, int i3) throws SAXException {
        if (!this.f30456c && this.f30461h) {
            if (this.f30462i == null) {
                this.f30462i = new StringBuilder(i3);
            }
            this.f30462i.append(cArr, i2, i3);
        }
    }

    public final void d(String str, Object... objArr) {
    }

    public final void e(Attributes attributes) throws SAXException {
        d("<defs>", new Object[0]);
        if (this.f30455b != null) {
            SVG.h hVar = new SVG.h();
            hVar.f30440a = this.f30454a;
            hVar.f30441b = this.f30455b;
            r(hVar, attributes);
            G(hVar, attributes);
            K(hVar, attributes);
            this.f30455b.i(hVar);
            this.f30455b = hVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.f30456c) {
            int i2 = this.f30457d - 1;
            this.f30457d = i2;
            if (i2 == 0) {
                this.f30456c = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            int i3 = a.f30467a[SVGElem.fromString(str2).ordinal()];
            if (i3 != 1 && i3 != 2 && i3 != 4 && i3 != 5 && i3 != 13 && i3 != 14) {
                switch (i3) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.f30458e = false;
                        SVGElem sVGElem = this.f30459f;
                        if (sVGElem == SVGElem.title) {
                            this.f30454a.q(this.f30460g.toString());
                        } else if (sVGElem == SVGElem.desc) {
                            this.f30454a.o(this.f30460g.toString());
                        }
                        this.f30460g.setLength(0);
                        return;
                    case 30:
                        StringBuilder sb = this.f30462i;
                        if (sb != null) {
                            this.f30461h = false;
                            N(sb.toString());
                            this.f30462i.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.f30455b = ((SVG.l0) this.f30455b).f30441b;
        }
    }

    public final void f(Attributes attributes) throws SAXException {
        d("<ellipse>", new Object[0]);
        if (this.f30455b != null) {
            SVG.i iVar = new SVG.i();
            iVar.f30440a = this.f30454a;
            iVar.f30441b = this.f30455b;
            r(iVar, attributes);
            G(iVar, attributes);
            K(iVar, attributes);
            q(iVar, attributes);
            s(iVar, attributes);
            this.f30455b.i(iVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void h(Attributes attributes) throws SAXException {
        d("<g>", new Object[0]);
        if (this.f30455b != null) {
            SVG.l lVar = new SVG.l();
            lVar.f30440a = this.f30454a;
            lVar.f30441b = this.f30455b;
            r(lVar, attributes);
            G(lVar, attributes);
            K(lVar, attributes);
            q(lVar, attributes);
            this.f30455b.i(lVar);
            this.f30455b = lVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void i(Attributes attributes) throws SAXException {
        d("<image>", new Object[0]);
        if (this.f30455b != null) {
            SVG.n nVar = new SVG.n();
            nVar.f30440a = this.f30454a;
            nVar.f30441b = this.f30455b;
            r(nVar, attributes);
            G(nVar, attributes);
            K(nVar, attributes);
            q(nVar, attributes);
            u(nVar, attributes);
            this.f30455b.i(nVar);
            this.f30455b = nVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void j(Attributes attributes) throws SAXException {
        d("<line>", new Object[0]);
        if (this.f30455b != null) {
            SVG.p pVar = new SVG.p();
            pVar.f30440a = this.f30454a;
            pVar.f30441b = this.f30455b;
            r(pVar, attributes);
            G(pVar, attributes);
            K(pVar, attributes);
            q(pVar, attributes);
            v(pVar, attributes);
            this.f30455b.i(pVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void k(Attributes attributes) throws SAXException {
        d("<linearGradiant>", new Object[0]);
        if (this.f30455b != null) {
            SVG.k0 k0Var = new SVG.k0();
            k0Var.f30440a = this.f30454a;
            k0Var.f30441b = this.f30455b;
            r(k0Var, attributes);
            G(k0Var, attributes);
            t(k0Var, attributes);
            w(k0Var, attributes);
            this.f30455b.i(k0Var);
            this.f30455b = k0Var;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void l(Attributes attributes) throws SAXException {
        d("<marker>", new Object[0]);
        if (this.f30455b != null) {
            SVG.q qVar = new SVG.q();
            qVar.f30440a = this.f30454a;
            qVar.f30441b = this.f30455b;
            r(qVar, attributes);
            G(qVar, attributes);
            q(qVar, attributes);
            M(qVar, attributes);
            x(qVar, attributes);
            this.f30455b.i(qVar);
            this.f30455b = qVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void m(Attributes attributes) throws SAXException {
        d("<mask>", new Object[0]);
        if (this.f30455b != null) {
            SVG.r rVar = new SVG.r();
            rVar.f30440a = this.f30454a;
            rVar.f30441b = this.f30455b;
            r(rVar, attributes);
            G(rVar, attributes);
            q(rVar, attributes);
            y(rVar, attributes);
            this.f30455b.i(rVar);
            this.f30455b = rVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public SVG n(InputStream inputStream) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new GZIPInputStream(inputStream);
            }
        } catch (IOException unused) {
        }
        try {
            try {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this);
                    xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                    xMLReader.parse(new InputSource(inputStream));
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        Log.e("SVGParser", "Exception thrown closing input stream");
                    }
                    return this.f30454a;
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        Log.e("SVGParser", "Exception thrown closing input stream");
                    }
                    throw th;
                }
            } catch (ParserConfigurationException e2) {
                throw new SVGParseException("XML Parser problem", e2);
            }
        } catch (IOException e3) {
            throw new SVGParseException("File error", e3);
        } catch (SAXException e4) {
            throw new SVGParseException("SVG parse error: " + e4.getMessage(), e4);
        }
    }

    public final void o(SVG.d dVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 12:
                    dVar.o = c0(trim);
                    break;
                case 13:
                    dVar.p = c0(trim);
                    break;
                case 14:
                    SVG.o c0 = c0(trim);
                    dVar.q = c0;
                    if (c0.h()) {
                        throw new SAXException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    public final void p(SVG.e eVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    eVar.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    eVar.o = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    public final void q(SVG.e0 e0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 21:
                    e0Var.g(k0(trim));
                    break;
                case 22:
                    e0Var.k(trim);
                    break;
                case 23:
                    e0Var.d(q0(trim));
                    break;
                case 24:
                    e0Var.j(l0(trim));
                    break;
                case 25:
                    List<String> W = W(trim);
                    e0Var.b(W != null ? new HashSet(W) : new HashSet(0));
                    break;
            }
        }
    }

    public final void r(SVG.j0 j0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i2).trim();
                    if ("default".equals(trim)) {
                        j0Var.f30436d = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        j0Var.f30436d = Boolean.TRUE;
                        return;
                    } else {
                        throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                j0Var.f30435c = attributes.getValue(i2).trim();
                return;
            }
        }
    }

    public final void s(SVG.i iVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 10:
                    SVG.o c0 = c0(trim);
                    iVar.q = c0;
                    if (c0.h()) {
                        throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    SVG.o c02 = c0(trim);
                    iVar.r = c02;
                    if (c02.h()) {
                        throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    iVar.o = c0(trim);
                    break;
                case 13:
                    iVar.p = c0(trim);
                    break;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.f30454a = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.f30456c) {
            this.f30457d++;
        } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            SVGElem fromString = SVGElem.fromString(str2);
            switch (a.f30467a[fromString.ordinal()]) {
                case 1:
                    H0(attributes);
                    return;
                case 2:
                case 3:
                    h(attributes);
                    return;
                case 4:
                    e(attributes);
                    return;
                case 5:
                    N0(attributes);
                    return;
                case 6:
                    x0(attributes);
                    return;
                case 7:
                    D0(attributes);
                    return;
                case 8:
                    a(attributes);
                    return;
                case 9:
                    f(attributes);
                    return;
                case 10:
                    j(attributes);
                    return;
                case 11:
                    A0(attributes);
                    return;
                case 12:
                    z0(attributes);
                    return;
                case 13:
                    J0(attributes);
                    return;
                case 14:
                    M0(attributes);
                    return;
                case 15:
                    L0(attributes);
                    return;
                case 16:
                    P0(attributes);
                    return;
                case 17:
                    I0(attributes);
                    return;
                case 18:
                    l(attributes);
                    return;
                case 19:
                    k(attributes);
                    return;
                case 20:
                    C0(attributes);
                    return;
                case 21:
                    F0(attributes);
                    return;
                case 22:
                case 23:
                    this.f30458e = true;
                    this.f30459f = fromString;
                    return;
                case 24:
                    c(attributes);
                    return;
                case 25:
                    K0(attributes);
                    return;
                case 26:
                    y0(attributes);
                    return;
                case 27:
                    i(attributes);
                    return;
                case 28:
                    O0(attributes);
                    return;
                case 29:
                    m(attributes);
                    return;
                case 30:
                    G0(attributes);
                    return;
                case 31:
                    E0(attributes);
                    return;
                default:
                    this.f30456c = true;
                    this.f30457d = 1;
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(SVG.j jVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 != 6) {
                switch (i3) {
                    case 32:
                        if ("objectBoundingBox".equals(trim)) {
                            jVar.f30434i = Boolean.FALSE;
                            continue;
                        } else if ("userSpaceOnUse".equals(trim)) {
                            jVar.f30434i = Boolean.TRUE;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute gradientUnits");
                        }
                    case 33:
                        jVar.j = u0(trim);
                        continue;
                    case 34:
                        try {
                            jVar.k = SVG.GradientSpread.valueOf(trim);
                            continue;
                        } catch (IllegalArgumentException unused) {
                            throw new SAXException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                        }
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                jVar.l = trim;
            }
        }
    }

    public final void u(SVG.n nVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                nVar.p = c0(trim);
            } else if (i3 == 2) {
                nVar.q = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                nVar.r = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <use> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.o c02 = c0(trim);
                nVar.s = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            } else if (i3 != 6) {
                if (i3 == 7) {
                    j0(nVar, trim);
                }
            } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                nVar.o = trim;
            }
        }
    }

    public final Matrix u0(String str) throws SAXException {
        Matrix matrix = new Matrix();
        f fVar = new f(str);
        fVar.w();
        while (!fVar.g()) {
            String n = fVar.n();
            if (n != null) {
                if (n.equals("matrix")) {
                    fVar.w();
                    float m = fVar.m();
                    fVar.v();
                    float m2 = fVar.m();
                    fVar.v();
                    float m3 = fVar.m();
                    fVar.v();
                    float m4 = fVar.m();
                    fVar.v();
                    float m5 = fVar.m();
                    fVar.v();
                    float m6 = fVar.m();
                    fVar.w();
                    if (!Float.isNaN(m6) && fVar.e(')')) {
                        Matrix matrix2 = new Matrix();
                        matrix2.setValues(new float[]{m, m3, m5, m2, m4, m6, 0.0f, 0.0f, 1.0f});
                        matrix.preConcat(matrix2);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("translate")) {
                    fVar.w();
                    float m7 = fVar.m();
                    float t = fVar.t();
                    fVar.w();
                    if (!Float.isNaN(m7) && fVar.e(')')) {
                        if (Float.isNaN(t)) {
                            matrix.preTranslate(m7, 0.0f);
                        } else {
                            matrix.preTranslate(m7, t);
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("scale")) {
                    fVar.w();
                    float m8 = fVar.m();
                    float t2 = fVar.t();
                    fVar.w();
                    if (!Float.isNaN(m8) && fVar.e(')')) {
                        if (Float.isNaN(t2)) {
                            matrix.preScale(m8, m8);
                        } else {
                            matrix.preScale(m8, t2);
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("rotate")) {
                    fVar.w();
                    float m9 = fVar.m();
                    float t3 = fVar.t();
                    float t4 = fVar.t();
                    fVar.w();
                    if (!Float.isNaN(m9) && fVar.e(')')) {
                        if (Float.isNaN(t3)) {
                            matrix.preRotate(m9);
                        } else if (!Float.isNaN(t4)) {
                            matrix.preRotate(m9, t3, t4);
                        } else {
                            throw new SAXException("Invalid transform list: " + str);
                        }
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("skewX")) {
                    fVar.w();
                    float m10 = fVar.m();
                    fVar.w();
                    if (!Float.isNaN(m10) && fVar.e(')')) {
                        matrix.preSkew((float) Math.tan(Math.toRadians(m10)), 0.0f);
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n.equals("skewY")) {
                    fVar.w();
                    float m11 = fVar.m();
                    fVar.w();
                    if (!Float.isNaN(m11) && fVar.e(')')) {
                        matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(m11)));
                    } else {
                        throw new SAXException("Invalid transform list: " + str);
                    }
                } else if (n != null) {
                    throw new SAXException("Invalid transform list fn: " + n + SmallTailInfo.EMOTION_SUFFIX);
                }
                if (fVar.g()) {
                    break;
                }
                fVar.v();
            } else {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    public final void v(SVG.p pVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 15:
                    pVar.o = c0(trim);
                    break;
                case 16:
                    pVar.p = c0(trim);
                    break;
                case 17:
                    pVar.q = c0(trim);
                    break;
                case 18:
                    pVar.r = c0(trim);
                    break;
            }
        }
    }

    public final void w(SVG.k0 k0Var, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 15:
                    k0Var.m = c0(trim);
                    break;
                case 16:
                    k0Var.n = c0(trim);
                    break;
                case 17:
                    k0Var.o = c0(trim);
                    break;
                case 18:
                    k0Var.p = c0(trim);
                    break;
            }
        }
    }

    public final void x(SVG.q qVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 26:
                    qVar.q = c0(trim);
                    break;
                case 27:
                    qVar.r = c0(trim);
                    break;
                case 28:
                    SVG.o c0 = c0(trim);
                    qVar.s = c0;
                    if (c0.h()) {
                        throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    SVG.o c02 = c0(trim);
                    qVar.t = c02;
                    if (c02.h()) {
                        throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        qVar.p = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        qVar.p = true;
                        break;
                    } else {
                        throw new SAXException("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(trim)) {
                        qVar.u = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        qVar.u = Float.valueOf(T(trim));
                        break;
                    }
            }
        }
    }

    public final void x0(Attributes attributes) throws SAXException {
        d("<path>", new Object[0]);
        if (this.f30455b != null) {
            SVG.u uVar = new SVG.u();
            uVar.f30440a = this.f30454a;
            uVar.f30441b = this.f30455b;
            r(uVar, attributes);
            G(uVar, attributes);
            K(uVar, attributes);
            q(uVar, attributes);
            z(uVar, attributes);
            this.f30455b.i(uVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void y(SVG.r rVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                rVar.p = c0(trim);
            } else if (i3 == 2) {
                rVar.q = c0(trim);
            } else if (i3 == 3) {
                SVG.o c0 = c0(trim);
                rVar.r = c0;
                if (c0.h()) {
                    throw new SAXException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.o c02 = c0(trim);
                rVar.s = c02;
                if (c02.h()) {
                    throw new SAXException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i3 != 43) {
                if (i3 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    rVar.o = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    rVar.o = Boolean.TRUE;
                } else {
                    throw new SAXException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                rVar.n = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                rVar.n = Boolean.TRUE;
            } else {
                throw new SAXException("Invalid value for attribute maskUnits");
            }
        }
    }

    public final void y0(Attributes attributes) throws SAXException {
        d("<pattern>", new Object[0]);
        if (this.f30455b != null) {
            SVG.x xVar = new SVG.x();
            xVar.f30440a = this.f30454a;
            xVar.f30441b = this.f30455b;
            r(xVar, attributes);
            G(xVar, attributes);
            q(xVar, attributes);
            M(xVar, attributes);
            A(xVar, attributes);
            this.f30455b.i(xVar);
            this.f30455b = xVar;
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }

    public final void z(SVG.u uVar, Attributes attributes) throws SAXException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = a.f30468b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 8) {
                uVar.o = i0(trim);
            } else if (i3 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(T(trim));
                uVar.p = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    public final void z0(Attributes attributes) throws SAXException {
        d("<polygon>", new Object[0]);
        if (this.f30455b != null) {
            SVG.y zVar = new SVG.z();
            zVar.f30440a = this.f30454a;
            zVar.f30441b = this.f30455b;
            r(zVar, attributes);
            G(zVar, attributes);
            K(zVar, attributes);
            q(zVar, attributes);
            B(zVar, attributes, "polygon");
            this.f30455b.i(zVar);
            return;
        }
        throw new SAXException("Invalid document. Root element must be <svg>");
    }
}
