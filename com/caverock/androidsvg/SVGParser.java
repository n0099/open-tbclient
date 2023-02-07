package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.Xml;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.jz9;
import com.baidu.tieba.kz9;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.coremedia.iso.boxes.TrackReferenceBox;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
import org.aspectj.runtime.reflect.SignatureImpl;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes7.dex */
public class SVGParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SVG a;
    public SVG.h0 b;
    public boolean c;
    public int d;
    public boolean e;
    public SVGElem f;
    public StringBuilder g;
    public boolean h;
    public StringBuilder i;

    public static float t(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 < 0.0f) {
                f4 += 6.0f;
            }
            if (f4 >= 6.0f) {
                f4 -= 6.0f;
            }
            if (f4 < 1.0f) {
                f5 = (f3 - f2) * f4;
            } else if (f4 < 3.0f) {
                return f3;
            } else {
                if (f4 >= 4.0f) {
                    return f2;
                }
                f5 = (f3 - f2) * (4.0f - f4);
            }
            return f5 + f2;
        }
        return invokeCommon.floatValue;
    }

    public final void l(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, str, objArr) == null) {
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SVGAttr {
        public static final /* synthetic */ SVGAttr[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SVGAttr CLASS;
        public static final SVGAttr UNSUPPORTED;
        public static final Map<String, SVGAttr> cache;
        public static final SVGAttr clip;
        public static final SVGAttr clipPathUnits;
        public static final SVGAttr clip_path;
        public static final SVGAttr clip_rule;
        public static final SVGAttr color;
        public static final SVGAttr cx;
        public static final SVGAttr cy;
        public static final SVGAttr d;
        public static final SVGAttr direction;
        public static final SVGAttr display;
        public static final SVGAttr dx;
        public static final SVGAttr dy;
        public static final SVGAttr fill;
        public static final SVGAttr fill_opacity;
        public static final SVGAttr fill_rule;
        public static final SVGAttr font;
        public static final SVGAttr font_family;
        public static final SVGAttr font_size;
        public static final SVGAttr font_style;
        public static final SVGAttr font_weight;
        public static final SVGAttr fx;
        public static final SVGAttr fy;
        public static final SVGAttr gradientTransform;
        public static final SVGAttr gradientUnits;
        public static final SVGAttr height;
        public static final SVGAttr href;
        public static final SVGAttr image_rendering;
        public static final SVGAttr marker;
        public static final SVGAttr markerHeight;
        public static final SVGAttr markerUnits;
        public static final SVGAttr markerWidth;
        public static final SVGAttr marker_end;
        public static final SVGAttr marker_mid;
        public static final SVGAttr marker_start;
        public static final SVGAttr mask;
        public static final SVGAttr maskContentUnits;
        public static final SVGAttr maskUnits;
        public static final SVGAttr media;
        public static final SVGAttr offset;
        public static final SVGAttr opacity;
        public static final SVGAttr orient;
        public static final SVGAttr overflow;
        public static final SVGAttr pathLength;
        public static final SVGAttr patternContentUnits;
        public static final SVGAttr patternTransform;
        public static final SVGAttr patternUnits;
        public static final SVGAttr points;
        public static final SVGAttr preserveAspectRatio;
        public static final SVGAttr r;
        public static final SVGAttr refX;
        public static final SVGAttr refY;
        public static final SVGAttr requiredExtensions;
        public static final SVGAttr requiredFeatures;
        public static final SVGAttr requiredFonts;
        public static final SVGAttr requiredFormats;

        /* renamed from: rx  reason: collision with root package name */
        public static final SVGAttr f1092rx;
        public static final SVGAttr ry;
        public static final SVGAttr solid_color;
        public static final SVGAttr solid_opacity;
        public static final SVGAttr spreadMethod;
        public static final SVGAttr startOffset;
        public static final SVGAttr stop_color;
        public static final SVGAttr stop_opacity;
        public static final SVGAttr stroke;
        public static final SVGAttr stroke_dasharray;
        public static final SVGAttr stroke_dashoffset;
        public static final SVGAttr stroke_linecap;
        public static final SVGAttr stroke_linejoin;
        public static final SVGAttr stroke_miterlimit;
        public static final SVGAttr stroke_opacity;
        public static final SVGAttr stroke_width;
        public static final SVGAttr style;
        public static final SVGAttr systemLanguage;
        public static final SVGAttr text_anchor;
        public static final SVGAttr text_decoration;
        public static final SVGAttr transform;
        public static final SVGAttr type;
        public static final SVGAttr vector_effect;
        public static final SVGAttr version;
        public static final SVGAttr viewBox;
        public static final SVGAttr viewport_fill;
        public static final SVGAttr viewport_fill_opacity;
        public static final SVGAttr visibility;
        public static final SVGAttr width;
        public static final SVGAttr x;
        public static final SVGAttr x1;
        public static final SVGAttr x2;
        public static final SVGAttr y;
        public static final SVGAttr y1;
        public static final SVGAttr y2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            SVGAttr[] values;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386467330, "Lcom/caverock/androidsvg/SVGParser$SVGAttr;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1386467330, "Lcom/caverock/androidsvg/SVGParser$SVGAttr;");
                    return;
                }
            }
            CLASS = new SVGAttr("CLASS", 0);
            clip = new SVGAttr("clip", 1);
            clip_path = new SVGAttr("clip_path", 2);
            clipPathUnits = new SVGAttr("clipPathUnits", 3);
            clip_rule = new SVGAttr("clip_rule", 4);
            color = new SVGAttr("color", 5);
            cx = new SVGAttr("cx", 6);
            cy = new SVGAttr("cy", 7);
            direction = new SVGAttr("direction", 8);
            dx = new SVGAttr("dx", 9);
            dy = new SVGAttr("dy", 10);
            fx = new SVGAttr("fx", 11);
            fy = new SVGAttr("fy", 12);
            d = new SVGAttr("d", 13);
            display = new SVGAttr(CriusAttrConstants.DISPLAY, 14);
            fill = new SVGAttr("fill", 15);
            fill_rule = new SVGAttr("fill_rule", 16);
            fill_opacity = new SVGAttr("fill_opacity", 17);
            font = new SVGAttr("font", 18);
            font_family = new SVGAttr("font_family", 19);
            font_size = new SVGAttr("font_size", 20);
            font_weight = new SVGAttr(FontsContractCompat.Columns.WEIGHT, 21);
            font_style = new SVGAttr("font_style", 22);
            gradientTransform = new SVGAttr("gradientTransform", 23);
            gradientUnits = new SVGAttr("gradientUnits", 24);
            height = new SVGAttr("height", 25);
            href = new SVGAttr(NativeConstants.HREF, 26);
            image_rendering = new SVGAttr("image_rendering", 27);
            marker = new SVGAttr("marker", 28);
            marker_start = new SVGAttr("marker_start", 29);
            marker_mid = new SVGAttr("marker_mid", 30);
            marker_end = new SVGAttr("marker_end", 31);
            markerHeight = new SVGAttr("markerHeight", 32);
            markerUnits = new SVGAttr("markerUnits", 33);
            markerWidth = new SVGAttr("markerWidth", 34);
            mask = new SVGAttr("mask", 35);
            maskContentUnits = new SVGAttr("maskContentUnits", 36);
            maskUnits = new SVGAttr("maskUnits", 37);
            media = new SVGAttr("media", 38);
            offset = new SVGAttr("offset", 39);
            opacity = new SVGAttr(NativeConstants.OPACITY, 40);
            orient = new SVGAttr("orient", 41);
            overflow = new SVGAttr("overflow", 42);
            pathLength = new SVGAttr("pathLength", 43);
            patternContentUnits = new SVGAttr("patternContentUnits", 44);
            patternTransform = new SVGAttr("patternTransform", 45);
            patternUnits = new SVGAttr("patternUnits", 46);
            points = new SVGAttr("points", 47);
            preserveAspectRatio = new SVGAttr("preserveAspectRatio", 48);
            r = new SVGAttr("r", 49);
            refX = new SVGAttr("refX", 50);
            refY = new SVGAttr("refY", 51);
            requiredFeatures = new SVGAttr("requiredFeatures", 52);
            requiredExtensions = new SVGAttr("requiredExtensions", 53);
            requiredFormats = new SVGAttr("requiredFormats", 54);
            requiredFonts = new SVGAttr("requiredFonts", 55);
            f1092rx = new SVGAttr("rx", 56);
            ry = new SVGAttr("ry", 57);
            solid_color = new SVGAttr("solid_color", 58);
            solid_opacity = new SVGAttr("solid_opacity", 59);
            spreadMethod = new SVGAttr("spreadMethod", 60);
            startOffset = new SVGAttr("startOffset", 61);
            stop_color = new SVGAttr("stop_color", 62);
            stop_opacity = new SVGAttr("stop_opacity", 63);
            stroke = new SVGAttr("stroke", 64);
            stroke_dasharray = new SVGAttr("stroke_dasharray", 65);
            stroke_dashoffset = new SVGAttr("stroke_dashoffset", 66);
            stroke_linecap = new SVGAttr("stroke_linecap", 67);
            stroke_linejoin = new SVGAttr("stroke_linejoin", 68);
            stroke_miterlimit = new SVGAttr("stroke_miterlimit", 69);
            stroke_opacity = new SVGAttr("stroke_opacity", 70);
            stroke_width = new SVGAttr("stroke_width", 71);
            style = new SVGAttr("style", 72);
            systemLanguage = new SVGAttr("systemLanguage", 73);
            text_anchor = new SVGAttr("text_anchor", 74);
            text_decoration = new SVGAttr("text_decoration", 75);
            transform = new SVGAttr("transform", 76);
            type = new SVGAttr("type", 77);
            vector_effect = new SVGAttr("vector_effect", 78);
            version = new SVGAttr("version", 79);
            viewBox = new SVGAttr("viewBox", 80);
            width = new SVGAttr("width", 81);
            x = new SVGAttr("x", 82);
            y = new SVGAttr("y", 83);
            x1 = new SVGAttr(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1, 84);
            y1 = new SVGAttr(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1, 85);
            x2 = new SVGAttr(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2, 86);
            y2 = new SVGAttr(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2, 87);
            viewport_fill = new SVGAttr("viewport_fill", 88);
            viewport_fill_opacity = new SVGAttr("viewport_fill_opacity", 89);
            visibility = new SVGAttr("visibility", 90);
            SVGAttr sVGAttr = new SVGAttr("UNSUPPORTED", 91);
            UNSUPPORTED = sVGAttr;
            $VALUES = new SVGAttr[]{CLASS, clip, clip_path, clipPathUnits, clip_rule, color, cx, cy, direction, dx, dy, fx, fy, d, display, fill, fill_rule, fill_opacity, font, font_family, font_size, font_weight, font_style, gradientTransform, gradientUnits, height, href, image_rendering, marker, marker_start, marker_mid, marker_end, markerHeight, markerUnits, markerWidth, mask, maskContentUnits, maskUnits, media, offset, opacity, orient, overflow, pathLength, patternContentUnits, patternTransform, patternUnits, points, preserveAspectRatio, r, refX, refY, requiredFeatures, requiredExtensions, requiredFormats, requiredFonts, f1092rx, ry, solid_color, solid_opacity, spreadMethod, startOffset, stop_color, stop_opacity, stroke, stroke_dasharray, stroke_dashoffset, stroke_linecap, stroke_linejoin, stroke_miterlimit, stroke_opacity, stroke_width, style, systemLanguage, text_anchor, text_decoration, transform, type, vector_effect, version, viewBox, width, x, y, x1, y1, x2, y2, viewport_fill, viewport_fill_opacity, visibility, sVGAttr};
            cache = new HashMap();
            for (SVGAttr sVGAttr2 : values()) {
                if (sVGAttr2 == CLASS) {
                    cache.put(DealIntentService.KEY_CLASS, sVGAttr2);
                } else if (sVGAttr2 != UNSUPPORTED) {
                    cache.put(sVGAttr2.name().replace('_', SignatureImpl.SEP), sVGAttr2);
                }
            }
        }

        public SVGAttr(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                SVGAttr sVGAttr = cache.get(str);
                if (sVGAttr != null) {
                    return sVGAttr;
                }
                return UNSUPPORTED;
            }
            return (SVGAttr) invokeL.objValue;
        }

        public static SVGAttr valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SVGAttr) Enum.valueOf(SVGAttr.class, str);
            }
            return (SVGAttr) invokeL.objValue;
        }

        public static SVGAttr[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SVGAttr[]) $VALUES.clone();
            }
            return (SVGAttr[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class SVGElem {
        public static final /* synthetic */ SVGElem[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SVGElem SWITCH;
        public static final SVGElem UNSUPPORTED;
        public static final SVGElem a;
        public static final Map<String, SVGElem> cache;
        public static final SVGElem circle;
        public static final SVGElem clipPath;
        public static final SVGElem defs;
        public static final SVGElem desc;
        public static final SVGElem ellipse;
        public static final SVGElem g;
        public static final SVGElem image;
        public static final SVGElem line;
        public static final SVGElem linearGradient;
        public static final SVGElem marker;
        public static final SVGElem mask;
        public static final SVGElem path;
        public static final SVGElem pattern;
        public static final SVGElem polygon;
        public static final SVGElem polyline;
        public static final SVGElem radialGradient;
        public static final SVGElem rect;
        public static final SVGElem solidColor;
        public static final SVGElem stop;
        public static final SVGElem style;
        public static final SVGElem svg;
        public static final SVGElem symbol;
        public static final SVGElem text;
        public static final SVGElem textPath;
        public static final SVGElem title;
        public static final SVGElem tref;
        public static final SVGElem tspan;
        public static final SVGElem use;

        /* renamed from: view  reason: collision with root package name */
        public static final SVGElem f1093view;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            SVGElem[] values;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1383026144, "Lcom/caverock/androidsvg/SVGParser$SVGElem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1383026144, "Lcom/caverock/androidsvg/SVGParser$SVGElem;");
                    return;
                }
            }
            svg = new SVGElem("svg", 0);
            a = new SVGElem("a", 1);
            circle = new SVGElem(Config.TRACE_CIRCLE, 2);
            clipPath = new SVGElem("clipPath", 3);
            defs = new SVGElem("defs", 4);
            desc = new SVGElem("desc", 5);
            ellipse = new SVGElem("ellipse", 6);
            g = new SVGElem("g", 7);
            image = new SVGElem("image", 8);
            line = new SVGElem("line", 9);
            linearGradient = new SVGElem("linearGradient", 10);
            marker = new SVGElem("marker", 11);
            mask = new SVGElem("mask", 12);
            path = new SVGElem("path", 13);
            pattern = new SVGElem("pattern", 14);
            polygon = new SVGElem("polygon", 15);
            polyline = new SVGElem("polyline", 16);
            radialGradient = new SVGElem("radialGradient", 17);
            rect = new SVGElem("rect", 18);
            solidColor = new SVGElem("solidColor", 19);
            stop = new SVGElem("stop", 20);
            style = new SVGElem("style", 21);
            SWITCH = new SVGElem("SWITCH", 22);
            symbol = new SVGElem("symbol", 23);
            text = new SVGElem("text", 24);
            textPath = new SVGElem("textPath", 25);
            title = new SVGElem("title", 26);
            tref = new SVGElem(TrackReferenceBox.TYPE, 27);
            tspan = new SVGElem("tspan", 28);
            use = new SVGElem(TbConfig.ST_TYPE_USE, 29);
            f1093view = new SVGElem(NativeConstants.TYPE_VIEW, 30);
            SVGElem sVGElem = new SVGElem("UNSUPPORTED", 31);
            UNSUPPORTED = sVGElem;
            $VALUES = new SVGElem[]{svg, a, circle, clipPath, defs, desc, ellipse, g, image, line, linearGradient, marker, mask, path, pattern, polygon, polyline, radialGradient, rect, solidColor, stop, style, SWITCH, symbol, text, textPath, title, tref, tspan, use, f1093view, sVGElem};
            cache = new HashMap();
            for (SVGElem sVGElem2 : values()) {
                if (sVGElem2 == SWITCH) {
                    cache.put(SetImageWatermarkTypeReqMsg.SWITCH, sVGElem2);
                } else if (sVGElem2 != UNSUPPORTED) {
                    cache.put(sVGElem2.name(), sVGElem2);
                }
            }
        }

        public SVGElem(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SVGElem fromString(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                SVGElem sVGElem = cache.get(str);
                if (sVGElem != null) {
                    return sVGElem;
                }
                return UNSUPPORTED;
            }
            return (SVGElem) invokeL.objValue;
        }

        public static SVGElem valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SVGElem) Enum.valueOf(SVGElem.class, str);
            }
            return (SVGElem) invokeL.objValue;
        }

        public static SVGElem[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SVGElem[]) $VALUES.clone();
            }
            return (SVGElem[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205142386, "Lcom/caverock/androidsvg/SVGParser$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205142386, "Lcom/caverock/androidsvg/SVGParser$a;");
                    return;
                }
            }
            int[] iArr = new int[SVGAttr.values().length];
            b = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[SVGAttr.f1092rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                b[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                b[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                b[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                b[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                b[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                b[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                b[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                b[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                b[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                b[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                b[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                b[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                b[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                b[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                b[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                b[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                b[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                b[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                b[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                b[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                b[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                b[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                b[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                b[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                b[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                b[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                b[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                b[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                b[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                b[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                b[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                b[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                b[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                b[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                b[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                b[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                b[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                b[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                b[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                b[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                b[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                b[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                b[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                b[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                b[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                b[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                b[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                b[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                b[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                b[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                b[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                b[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                b[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                b[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                b[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                b[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                b[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                b[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                b[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                b[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                b[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                b[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                b[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                b[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                b[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                b[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            a = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                a[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                a[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                a[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                a[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                a[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                a[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                a[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                a[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                a[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                a[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                a[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                a[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                a[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                a[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                a[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                a[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                a[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                a[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                a[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                a[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                a[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                a[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                a[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                a[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                a[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                a[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                a[SVGElem.f1093view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                a[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                a[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                a[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<String, PreserveAspectRatio.Alignment> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205142417, "Lcom/caverock/androidsvg/SVGParser$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205142417, "Lcom/caverock/androidsvg/SVGParser$b;");
                    return;
                }
            }
            HashMap hashMap = new HashMap(10);
            a = hashMap;
            hashMap.put("none", PreserveAspectRatio.Alignment.none);
            a.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            a.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            a.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            a.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            a.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            a.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            a.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            a.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            a.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        public static PreserveAspectRatio.Alignment a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return a.get(str);
            }
            return (PreserveAspectRatio.Alignment) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<String, Integer> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205142448, "Lcom/caverock/androidsvg/SVGParser$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205142448, "Lcom/caverock/androidsvg/SVGParser$c;");
                    return;
                }
            }
            HashMap hashMap = new HashMap(47);
            a = hashMap;
            hashMap.put("aliceblue", -984833);
            a.put("antiquewhite", -332841);
            a.put("aqua", -16711681);
            a.put("aquamarine", -8388652);
            a.put("azure", -983041);
            a.put("beige", -657956);
            a.put("bisque", -6972);
            a.put("black", -16777216);
            a.put("blanchedalmond", -5171);
            a.put("blue", -16776961);
            a.put("blueviolet", -7722014);
            a.put("brown", -5952982);
            a.put("burlywood", -2180985);
            a.put("cadetblue", -10510688);
            a.put("chartreuse", -8388864);
            a.put("chocolate", -2987746);
            a.put("coral", -32944);
            a.put("cornflowerblue", -10185235);
            a.put("cornsilk", -1828);
            a.put("crimson", -2354116);
            a.put("cyan", -16711681);
            a.put("darkblue", -16777077);
            a.put("darkcyan", -16741493);
            a.put("darkgoldenrod", -4684277);
            a.put("darkgray", -5658199);
            a.put("darkgreen", -16751616);
            a.put("darkgrey", -5658199);
            a.put("darkkhaki", -4343957);
            a.put("darkmagenta", -7667573);
            a.put("darkolivegreen", -11179217);
            a.put("darkorange", -29696);
            a.put("darkorchid", -6737204);
            a.put("darkred", -7667712);
            a.put("darksalmon", -1468806);
            a.put("darkseagreen", -7357297);
            a.put("darkslateblue", -12042869);
            a.put("darkslategray", -13676721);
            a.put("darkslategrey", -13676721);
            a.put("darkturquoise", -16724271);
            a.put("darkviolet", -7077677);
            a.put("deeppink", -60269);
            a.put("deepskyblue", -16728065);
            a.put("dimgray", -9868951);
            a.put("dimgrey", -9868951);
            a.put("dodgerblue", -14774017);
            a.put("firebrick", -5103070);
            a.put("floralwhite", -1296);
            a.put("forestgreen", -14513374);
            a.put("fuchsia", -65281);
            a.put("gainsboro", -2302756);
            a.put("ghostwhite", -460545);
            a.put("gold", -10496);
            a.put("goldenrod", -2448096);
            a.put(ShareLoginStat.GetShareListStat.KEY_GRAY, -8355712);
            a.put("green", -16744448);
            a.put("greenyellow", -5374161);
            a.put("grey", -8355712);
            a.put("honeydew", -983056);
            a.put("hotpink", -38476);
            a.put("indianred", -3318692);
            a.put("indigo", -11861886);
            a.put("ivory", -16);
            a.put("khaki", -989556);
            a.put("lavender", -1644806);
            a.put("lavenderblush", -3851);
            a.put("lawngreen", -8586240);
            a.put("lemonchiffon", -1331);
            a.put("lightblue", -5383962);
            a.put("lightcoral", -1015680);
            a.put("lightcyan", -2031617);
            a.put("lightgoldenrodyellow", -329006);
            a.put("lightgray", -2894893);
            a.put("lightgreen", -7278960);
            a.put("lightgrey", -2894893);
            a.put("lightpink", -18751);
            a.put("lightsalmon", -24454);
            a.put("lightseagreen", -14634326);
            a.put("lightskyblue", -7876870);
            a.put("lightslategray", -8943463);
            a.put("lightslategrey", -8943463);
            a.put("lightsteelblue", -5192482);
            a.put("lightyellow", -32);
            a.put("lime", Integer.valueOf((int) DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK));
            a.put("limegreen", -13447886);
            a.put("linen", -331546);
            a.put("magenta", -65281);
            a.put("maroon", -8388608);
            a.put("mediumaquamarine", -10039894);
            a.put("mediumblue", -16777011);
            a.put("mediumorchid", -4565549);
            a.put("mediumpurple", -7114533);
            a.put("mediumseagreen", -12799119);
            a.put("mediumslateblue", -8689426);
            a.put("mediumspringgreen", -16713062);
            a.put("mediumturquoise", -12004916);
            a.put("mediumvioletred", -3730043);
            a.put("midnightblue", -15132304);
            a.put("mintcream", -655366);
            a.put("mistyrose", -6943);
            a.put("moccasin", -6987);
            a.put("navajowhite", -8531);
            a.put("navy", -16777088);
            a.put("oldlace", -133658);
            a.put("olive", -8355840);
            a.put("olivedrab", -9728477);
            a.put("orange", -23296);
            a.put("orangered", -47872);
            a.put("orchid", -2461482);
            a.put("palegoldenrod", -1120086);
            a.put("palegreen", -6751336);
            a.put("paleturquoise", -5247250);
            a.put("palevioletred", -2396013);
            a.put("papayawhip", -4139);
            a.put("peachpuff", -9543);
            a.put("peru", -3308225);
            a.put("pink", -16181);
            a.put("plum", -2252579);
            a.put("powderblue", -5185306);
            a.put("purple", -8388480);
            a.put("rebeccapurple", -10079335);
            a.put("red", -65536);
            a.put("rosybrown", -4419697);
            a.put("royalblue", -12490271);
            a.put("saddlebrown", -7650029);
            a.put("salmon", -360334);
            a.put("sandybrown", -744352);
            a.put("seagreen", -13726889);
            a.put("seashell", -2578);
            a.put("sienna", -6270419);
            a.put("silver", -4144960);
            a.put("skyblue", -7876885);
            a.put("slateblue", -9807155);
            a.put("slategray", -9404272);
            a.put("slategrey", -9404272);
            a.put("snow", -1286);
            a.put("springgreen", -16711809);
            a.put("steelblue", -12156236);
            a.put("tan", -2968436);
            a.put("teal", -16744320);
            a.put("thistle", -2572328);
            a.put("tomato", -40121);
            a.put("turquoise", -12525360);
            a.put("violet", -1146130);
            a.put("wheat", -663885);
            a.put("white", -1);
            a.put("whitesmoke", Integer.valueOf((int) BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT));
            a.put("yellow", -256);
            a.put("yellowgreen", -6632142);
            a.put("transparent", 0);
        }

        public static Integer a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return a.get(str);
            }
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<String, SVG.o> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205142479, "Lcom/caverock/androidsvg/SVGParser$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205142479, "Lcom/caverock/androidsvg/SVGParser$d;");
                    return;
                }
            }
            HashMap hashMap = new HashMap(9);
            a = hashMap;
            hashMap.put("xx-small", new SVG.o(0.694f, SVG.Unit.pt));
            a.put("x-small", new SVG.o(0.833f, SVG.Unit.pt));
            a.put("small", new SVG.o(10.0f, SVG.Unit.pt));
            a.put("medium", new SVG.o(12.0f, SVG.Unit.pt));
            a.put("large", new SVG.o(14.4f, SVG.Unit.pt));
            a.put("x-large", new SVG.o(17.3f, SVG.Unit.pt));
            a.put("xx-large", new SVG.o(20.7f, SVG.Unit.pt));
            a.put("smaller", new SVG.o(83.33f, SVG.Unit.percent));
            a.put("larger", new SVG.o(120.0f, SVG.Unit.percent));
        }

        public static SVG.o a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return a.get(str);
            }
            return (SVG.o) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final Map<String, Integer> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205142510, "Lcom/caverock/androidsvg/SVGParser$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(205142510, "Lcom/caverock/androidsvg/SVGParser$e;");
                    return;
                }
            }
            HashMap hashMap = new HashMap(13);
            a = hashMap;
            hashMap.put("normal", 400);
            a.put("bold", 700);
            a.put("bolder", 1);
            a.put("lighter", -1);
            a.put("100", 100);
            a.put(BasicPushStatus.SUCCESS_CODE, 200);
            a.put(CloudControlRequest.DEFAULT_TIME, 300);
            a.put(FontParser.sFontWeightDefault, 400);
            a.put("500", 500);
            a.put("600", 600);
            a.put("700", 700);
            a.put("800", 800);
            a.put("900", 900);
        }

        public static Integer a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return a.get(str);
            }
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends DefaultHandler2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SVGParser a;

        public f(SVGParser sVGParser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGParser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVGParser;
        }

        public /* synthetic */ f(SVGParser sVGParser, a aVar) {
            this(sVGParser);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
                this.a.r(str, this.a.x0(new g(str2)));
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLII(1048576, this, cArr, i, i2) != null) {
                return;
            }
            this.a.c1(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) != null) {
                return;
            }
            this.a.p(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.W0();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLLL(1048581, this, str, str2, str3, attributes) != null) {
                return;
            }
            this.a.X0(str, str2, str3, attributes);
        }
    }

    /* loaded from: classes7.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public kz9 d;

        public boolean j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? i == 10 || i == 13 : invokeI.booleanValue;
        }

        public boolean k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? i == 32 || i == 10 || i == 13 || i == 9 : invokeI.booleanValue;
        }

        public g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 0;
            this.c = 0;
            this.d = new kz9();
            String trim = str.trim();
            this.a = trim;
            this.c = trim.length();
        }

        public boolean f(char c) {
            InterceptResult invokeCommon;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Character.valueOf(c)})) == null) {
                int i = this.b;
                if (i < this.c && this.a.charAt(i) == c) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.b++;
                }
                return z;
            }
            return invokeCommon.booleanValue;
        }

        public boolean g(String str) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                int length = str.length();
                int i = this.b;
                if (i <= this.c - length && this.a.substring(i, i + length).equals(str)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.b += length;
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                int i = this.b;
                if (i < this.c && k(this.a.charAt(i))) {
                    this.b++;
                } else {
                    return;
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.b;
                int i2 = this.c;
                if (i == i2) {
                    return -1;
                }
                int i3 = i + 1;
                this.b = i3;
                if (i3 >= i2) {
                    return -1;
                }
                return this.a.charAt(i3);
            }
            return invokeV.intValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.b == this.c) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i = this.b;
                if (i == this.c) {
                    return false;
                }
                char charAt = this.a.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public Integer l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                int i = this.b;
                if (i == this.c) {
                    return null;
                }
                String str = this.a;
                this.b = i + 1;
                return Integer.valueOf(str.charAt(i));
            }
            return (Integer) invokeV.objValue;
        }

        public float n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                float b = this.d.b(this.a, this.b, this.c);
                if (!Float.isNaN(b)) {
                    this.b = this.d.a();
                }
                return b;
            }
            return invokeV.floatValue;
        }

        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return t(WebvttCueParser.CHAR_SPACE, false);
            }
            return (String) invokeV.objValue;
        }

        public float x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                z();
                float b = this.d.b(this.a, this.b, this.c);
                if (!Float.isNaN(b)) {
                    this.b = this.d.a();
                }
                return b;
            }
            return invokeV.floatValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                this.b = this.c;
                return this.a.substring(i);
            }
            return (String) invokeV.objValue;
        }

        public boolean z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                A();
                int i = this.b;
                if (i == this.c || this.a.charAt(i) != ',') {
                    return false;
                }
                this.b++;
                A();
                return true;
            }
            return invokeV.booleanValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.b;
                while (!h() && !k(this.a.charAt(this.b))) {
                    this.b++;
                }
                String substring = this.a.substring(i, this.b);
                this.b = i;
                return substring;
            }
            return (String) invokeV.objValue;
        }

        public Boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                int i = this.b;
                if (i == this.c) {
                    return null;
                }
                char charAt = this.a.charAt(i);
                if (charAt != '0' && charAt != '1') {
                    return null;
                }
                boolean z = true;
                this.b++;
                if (charAt != '1') {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeV.objValue;
        }

        public SVG.o p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                float n = n();
                if (Float.isNaN(n)) {
                    return null;
                }
                SVG.Unit v = v();
                if (v == null) {
                    return new SVG.o(n, SVG.Unit.px);
                }
                return new SVG.o(n, v);
            }
            return (SVG.o) invokeV.objValue;
        }

        public Boolean c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj == null) {
                    return null;
                }
                z();
                return m();
            }
            return (Boolean) invokeL.objValue;
        }

        public float d(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
                if (Float.isNaN(f)) {
                    return Float.NaN;
                }
                z();
                return n();
            }
            return invokeF.floatValue;
        }

        public float e(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bool)) == null) {
                if (bool == null) {
                    return Float.NaN;
                }
                z();
                return n();
            }
            return invokeL.floatValue;
        }

        public String s(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Character.valueOf(c)})) == null) {
                return t(c, false);
            }
            return (String) invokeCommon.objValue;
        }

        public String u(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Character.valueOf(c)})) == null) {
                return t(c, true);
            }
            return (String) invokeCommon.objValue;
        }

        public String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                int charAt = this.a.charAt(i);
                while (true) {
                    if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                        break;
                    }
                    charAt = a();
                }
                int i2 = this.b;
                while (k(charAt)) {
                    charAt = a();
                }
                if (charAt == 40) {
                    this.b++;
                    return this.a.substring(i, i2);
                }
                this.b = i;
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                char charAt = this.a.charAt(i);
                if (charAt != '\'' && charAt != '\"') {
                    return null;
                }
                int a = a();
                while (a != -1 && a != charAt) {
                    a = a();
                }
                if (a == -1) {
                    this.b = i;
                    return null;
                }
                int i2 = this.b + 1;
                this.b = i2;
                return this.a.substring(i + 1, i2 - 1);
            }
            return (String) invokeV.objValue;
        }

        public SVG.Unit v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                if (h()) {
                    return null;
                }
                if (this.a.charAt(this.b) == '%') {
                    this.b++;
                    return SVG.Unit.percent;
                }
                int i = this.b;
                if (i > this.c - 2) {
                    return null;
                }
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.a.substring(i, i + 2).toLowerCase(Locale.US));
                    this.b += 2;
                    return valueOf;
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            return (SVG.Unit) invokeV.objValue;
        }

        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (h()) {
                    return null;
                }
                int i = this.b;
                char charAt = this.a.charAt(i);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    int a = a();
                    while (true) {
                        if ((a < 65 || a > 90) && (a < 97 || a > 122)) {
                            break;
                        }
                        a = a();
                    }
                    return this.a.substring(i, this.b);
                }
                this.b = i;
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String t(char c, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Character.valueOf(c), Boolean.valueOf(z)})) == null) {
                if (h()) {
                    return null;
                }
                char charAt = this.a.charAt(this.b);
                if ((!z && k(charAt)) || charAt == c) {
                    return null;
                }
                int i = this.b;
                int a = a();
                while (a != -1 && a != c && (z || !k(a))) {
                    a = a();
                }
                return this.a.substring(i, this.b);
            }
            return (String) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Attributes {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public XmlPullParser a;

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                return -1;
            }
            return invokeLL.intValue;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return null;
            }
            return (String) invokeI.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
                return null;
            }
            return (String) invokeLL.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
                return null;
            }
            return (String) invokeLL.objValue;
        }

        public h(SVGParser sVGParser, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVGParser, xmlPullParser};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.getAttributeCount();
            }
            return invokeV.intValue;
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.a.getAttributeName(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                return this.a.getAttributeNamespace(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                return this.a.getAttributeValue(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                String attributeName = this.a.getAttributeName(i);
                if (this.a.getAttributePrefix(i) != null) {
                    return this.a.getAttributePrefix(i) + ':' + attributeName;
                }
                return attributeName;
            }
            return (String) invokeI.objValue;
        }
    }

    public SVGParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
    }

    public static Set<String> A0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            g gVar = new g(str);
            HashSet hashSet = new HashSet();
            while (!gVar.h()) {
                hashSet.add(gVar.r());
                gVar.A();
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static SVG.Style.FillRule e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if ("nonzero".equals(str)) {
                return SVG.Style.FillRule.NonZero;
            }
            if ("evenodd".equals(str)) {
                return SVG.Style.FillRule.EvenOdd;
            }
            return null;
        }
        return (SVG.Style.FillRule) invokeL.objValue;
    }

    public static float f0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            int length = str.length();
            if (length != 0) {
                return g0(str, 0, length);
            }
            throw new SVGParseException("Invalid float value (empty string)");
        }
        return invokeL.floatValue;
    }

    public static int j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65565, null, f2)) == null) {
            if (f2 < 0.0f) {
                return 0;
            }
            if (f2 > 255.0f) {
                return 255;
            }
            return Math.round(f2);
        }
        return invokeF.intValue;
    }

    public static SVG.o j0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                SVG.o a2 = d.a(str);
                if (a2 == null) {
                    return o0(str);
                }
                return a2;
            } catch (SVGParseException unused) {
                return null;
            }
        }
        return (SVG.o) invokeL.objValue;
    }

    public static Integer l0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            return e.a(str);
        }
        return (Integer) invokeL.objValue;
    }

    public static SVG.o q0(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, gVar)) == null) {
            if (gVar.g("auto")) {
                return new SVG.o(0.0f);
            }
            return gVar.p();
        }
        return (SVG.o) invokeL.objValue;
    }

    public static Float r0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            try {
                float f0 = f0(str);
                if (f0 < 0.0f) {
                    f0 = 0.0f;
                } else if (f0 > 1.0f) {
                    f0 = 1.0f;
                }
                return Float.valueOf(f0);
            } catch (SVGParseException unused) {
                return null;
            }
        }
        return (Float) invokeL.objValue;
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.a.a(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).d(str));
        }
    }

    public static SVG.o[] B0(String str) {
        InterceptResult invokeL;
        SVG.o p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            g gVar = new g(str);
            gVar.A();
            if (gVar.h() || (p = gVar.p()) == null || p.g()) {
                return null;
            }
            float a2 = p.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(p);
            while (!gVar.h()) {
                gVar.z();
                SVG.o p2 = gVar.p();
                if (p2 == null || p2.g()) {
                    return null;
                }
                arrayList.add(p2);
                a2 += p2.a();
            }
            if (a2 == 0.0f) {
                return null;
            }
            return (SVG.o[]) arrayList.toArray(new SVG.o[arrayList.size()]);
        }
        return (SVG.o[]) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SVG.Style.TextDecoration H0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            switch (str.hashCode()) {
                case -1171789332:
                    if (str.equals(NativeConstants.LINETHROUGH)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1026963764:
                    if (str.equals("underline")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93826908:
                    if (str.equals("blink")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 529818312:
                    if (str.equals("overline")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                return null;
                            }
                            return SVG.Style.TextDecoration.Blink;
                        }
                        return SVG.Style.TextDecoration.LineThrough;
                    }
                    return SVG.Style.TextDecoration.Overline;
                }
                return SVG.Style.TextDecoration.Underline;
            }
            return SVG.Style.TextDecoration.None;
        }
        return (SVG.Style.TextDecoration) invokeL.objValue;
    }

    public static SVG.b N0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            g gVar = new g(str);
            gVar.A();
            float n = gVar.n();
            gVar.z();
            float n2 = gVar.n();
            gVar.z();
            float n3 = gVar.n();
            gVar.z();
            float n4 = gVar.n();
            if (!Float.isNaN(n) && !Float.isNaN(n2) && !Float.isNaN(n3) && !Float.isNaN(n4)) {
                if (n3 >= 0.0f) {
                    if (n4 >= 0.0f) {
                        return new SVG.b(n, n2, n3, n4);
                    }
                    throw new SVGParseException("Invalid viewBox. height cannot be negative");
                }
                throw new SVGParseException("Invalid viewBox. width cannot be negative");
            }
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        return (SVG.b) invokeL.objValue;
    }

    public static SVG.c a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if ("auto".equals(str) || !str.startsWith("rect(")) {
                return null;
            }
            g gVar = new g(str.substring(5));
            gVar.A();
            SVG.o q0 = q0(gVar);
            gVar.z();
            SVG.o q02 = q0(gVar);
            gVar.z();
            SVG.o q03 = q0(gVar);
            gVar.z();
            SVG.o q04 = q0(gVar);
            gVar.A();
            if (!gVar.f(')') && !gVar.h()) {
                return null;
            }
            return new SVG.c(q0, q02, q03, q04);
        }
        return (SVG.c) invokeL.objValue;
    }

    public static List<SVG.o> p0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (str.length() != 0) {
                ArrayList arrayList = new ArrayList(1);
                g gVar = new g(str);
                gVar.A();
                while (!gVar.h()) {
                    float n = gVar.n();
                    if (!Float.isNaN(n)) {
                        SVG.Unit v = gVar.v();
                        if (v == null) {
                            v = SVG.Unit.px;
                        }
                        arrayList.add(new SVG.o(n, v));
                        gVar.z();
                    } else {
                        throw new SVGParseException("Invalid length list value: " + gVar.b());
                    }
                }
                return arrayList;
            }
            throw new SVGParseException("Invalid length list (empty string)");
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean s0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            switch (str.hashCode()) {
                case -1217487446:
                    if (str.equals("hidden")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -907680051:
                    if (str.equals("scroll")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 466743410:
                    if (str.equals(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0 && c2 != 1) {
                if (c2 != 2 && c2 != 3) {
                    return null;
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static PreserveAspectRatio v0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            g gVar = new g(str);
            gVar.A();
            String r = gVar.r();
            if ("defer".equals(r)) {
                gVar.A();
                r = gVar.r();
            }
            PreserveAspectRatio.Alignment a2 = b.a(r);
            PreserveAspectRatio.Scale scale = null;
            gVar.A();
            if (!gVar.h()) {
                String r2 = gVar.r();
                char c2 = 65535;
                int hashCode = r2.hashCode();
                if (hashCode != 3347527) {
                    if (hashCode == 109526418 && r2.equals("slice")) {
                        c2 = 1;
                    }
                } else if (r2.equals("meet")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        scale = PreserveAspectRatio.Scale.slice;
                    } else {
                        throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
                    }
                } else {
                    scale = PreserveAspectRatio.Scale.meet;
                }
            }
            return new PreserveAspectRatio(a2, scale);
        }
        return (PreserveAspectRatio) invokeL.objValue;
    }

    public final void Z0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, attributes) == null) {
            l("<style>", new Object[0]);
            if (this.b != null) {
                String str = "all";
                boolean z = true;
                for (int i = 0; i < attributes.getLength(); i++) {
                    String trim = attributes.getValue(i).trim();
                    int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                    if (i2 != 88) {
                        if (i2 == 89) {
                            str = trim;
                        }
                    } else {
                        z = trim.equals("text/css");
                    }
                }
                if (z && CSSParser.b(str, CSSParser.MediaType.screen)) {
                    this.h = true;
                    return;
                }
                this.c = true;
                this.d = 1;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void h1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, attributes) == null) {
            l("<tspan>", new Object[0]);
            SVG.h0 h0Var = this.b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.w0) {
                    SVG.t0 t0Var = new SVG.t0();
                    t0Var.a = this.a;
                    t0Var.b = this.b;
                    D(t0Var, attributes);
                    S(t0Var, attributes);
                    C(t0Var, attributes);
                    V(t0Var, attributes);
                    this.b.i(t0Var);
                    this.b = t0Var;
                    SVG.h0 h0Var2 = t0Var.b;
                    if (h0Var2 instanceof SVG.z0) {
                        t0Var.o((SVG.z0) h0Var2);
                        return;
                    } else {
                        t0Var.o(((SVG.v0) h0Var2).c());
                        return;
                    }
                }
                throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final Float n0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (str.length() != 0) {
                int length = str.length();
                boolean z = true;
                if (str.charAt(str.length() - 1) == '%') {
                    length--;
                } else {
                    z = false;
                }
                try {
                    float g0 = g0(str, 0, length);
                    float f2 = 100.0f;
                    if (z) {
                        g0 /= 100.0f;
                    }
                    if (g0 < 0.0f) {
                        f2 = 0.0f;
                    } else if (g0 <= 100.0f) {
                        f2 = g0;
                    }
                    return Float.valueOf(f2);
                } catch (NumberFormatException e2) {
                    throw new SVGParseException("Invalid offset value in <stop>: " + str, e2);
                }
            }
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        return (Float) invokeL.objValue;
    }

    public static SVG.Style.LineCap C0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if ("butt".equals(str)) {
                return SVG.Style.LineCap.Butt;
            }
            if ("round".equals(str)) {
                return SVG.Style.LineCap.Round;
            }
            if ("square".equals(str)) {
                return SVG.Style.LineCap.Square;
            }
            return null;
        }
        return (SVG.Style.LineCap) invokeL.objValue;
    }

    public static SVG.Style.LineJoin D0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if ("miter".equals(str)) {
                return SVG.Style.LineJoin.Miter;
            }
            if ("round".equals(str)) {
                return SVG.Style.LineJoin.Round;
            }
            if ("bevel".equals(str)) {
                return SVG.Style.LineJoin.Bevel;
            }
            return null;
        }
        return (SVG.Style.LineJoin) invokeL.objValue;
    }

    public static SVG.Style.TextDirection I0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 107498) {
                if (hashCode == 113258 && str.equals("rtl")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("ltr")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return SVG.Style.TextDirection.RTL;
            }
            return SVG.Style.TextDirection.LTR;
        }
        return (SVG.Style.TextDirection) invokeL.objValue;
    }

    public static SVG.Style.VectorEffect M0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 3387192) {
                if (hashCode == 1629199934 && str.equals("non-scaling-stroke")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("none")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return SVG.Style.VectorEffect.NonScalingStroke;
            }
            return SVG.Style.VectorEffect.None;
        }
        return (SVG.Style.VectorEffect) invokeL.objValue;
    }

    public static SVG.f c0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            Integer a2 = c.a(str);
            if (a2 != null) {
                return new SVG.f(a2.intValue());
            }
            throw new SVGParseException("Invalid colour keyword: " + str);
        }
        return (SVG.f) invokeL.objValue;
    }

    public static List<String> i0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            g gVar = new g(str);
            ArrayList arrayList = null;
            do {
                String q = gVar.q();
                if (q == null) {
                    q = gVar.u(',');
                }
                if (q == null) {
                    break;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(q);
                gVar.z();
            } while (!gVar.h());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Set<String> z0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            g gVar = new g(str);
            HashSet hashSet = new HashSet();
            while (!gVar.h()) {
                String r = gVar.r();
                if (r.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                    hashSet.add(r.substring(35));
                } else {
                    hashSet.add("UNSUPPORTED");
                }
                gVar.A();
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public final void O0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, attributes) == null) {
            l("<path>", new Object[0]);
            if (this.b != null) {
                SVG.u uVar = new SVG.u();
                uVar.a = this.a;
                uVar.b = this.b;
                D(uVar, attributes);
                S(uVar, attributes);
                W(uVar, attributes);
                C(uVar, attributes);
                L(uVar, attributes);
                this.b.i(uVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void T0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, attributes) == null) {
            l("<radialGradient>", new Object[0]);
            if (this.b != null) {
                SVG.o0 o0Var = new SVG.o0();
                o0Var.a = this.a;
                o0Var.b = this.b;
                D(o0Var, attributes);
                S(o0Var, attributes);
                F(o0Var, attributes);
                O(o0Var, attributes);
                this.b.i(o0Var);
                this.b = o0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void U0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, attributes) == null) {
            l("<rect>", new Object[0]);
            if (this.b != null) {
                SVG.a0 a0Var = new SVG.a0();
                a0Var.a = this.a;
                a0Var.b = this.b;
                D(a0Var, attributes);
                S(a0Var, attributes);
                W(a0Var, attributes);
                C(a0Var, attributes);
                P(a0Var, attributes);
                this.b.i(a0Var);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void V0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, attributes) == null) {
            l("<solidColor>", new Object[0]);
            if (this.b != null) {
                SVG.b0 b0Var = new SVG.b0();
                b0Var.a = this.a;
                b0Var.b = this.b;
                D(b0Var, attributes);
                S(b0Var, attributes);
                this.b.i(b0Var);
                this.b = b0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void a1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, attributes) == null) {
            l("<svg>", new Object[0]);
            SVG.d0 d0Var = new SVG.d0();
            d0Var.a = this.a;
            d0Var.b = this.b;
            D(d0Var, attributes);
            S(d0Var, attributes);
            C(d0Var, attributes);
            Y(d0Var, attributes);
            Q(d0Var, attributes);
            SVG.h0 h0Var = this.b;
            if (h0Var == null) {
                this.a.r(d0Var);
            } else {
                h0Var.i(d0Var);
            }
            this.b = d0Var;
        }
    }

    public final void b1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, attributes) == null) {
            l("<symbol>", new Object[0]);
            if (this.b != null) {
                SVG.p0 r0Var = new SVG.r0();
                r0Var.a = this.a;
                r0Var.b = this.b;
                D(r0Var, attributes);
                S(r0Var, attributes);
                C(r0Var, attributes);
                Y(r0Var, attributes);
                this.b.i(r0Var);
                this.b = r0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void i(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, attributes) == null) {
            l("<circle>", new Object[0]);
            if (this.b != null) {
                SVG.d dVar = new SVG.d();
                dVar.a = this.a;
                dVar.b = this.b;
                D(dVar, attributes);
                S(dVar, attributes);
                W(dVar, attributes);
                C(dVar, attributes);
                A(dVar, attributes);
                this.b.i(dVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void j1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, attributes) == null) {
            l("<view>", new Object[0]);
            if (this.b != null) {
                SVG.p0 c1Var = new SVG.c1();
                c1Var.a = this.a;
                c1Var.b = this.b;
                D(c1Var, attributes);
                C(c1Var, attributes);
                Y(c1Var, attributes);
                this.b.i(c1Var);
                this.b = c1Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void k1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, attributes) == null) {
            l("<switch>", new Object[0]);
            if (this.b != null) {
                SVG.q0 q0Var = new SVG.q0();
                q0Var.a = this.a;
                q0Var.b = this.b;
                D(q0Var, attributes);
                S(q0Var, attributes);
                W(q0Var, attributes);
                C(q0Var, attributes);
                this.b.i(q0Var);
                this.b = q0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void m(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, attributes) == null) {
            l("<defs>", new Object[0]);
            if (this.b != null) {
                SVG.h hVar = new SVG.h();
                hVar.a = this.a;
                hVar.b = this.b;
                D(hVar, attributes);
                S(hVar, attributes);
                W(hVar, attributes);
                this.b.i(hVar);
                this.b = hVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void n(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, attributes) == null) {
            l("<ellipse>", new Object[0]);
            if (this.b != null) {
                SVG.i iVar = new SVG.i();
                iVar.a = this.a;
                iVar.b = this.b;
                D(iVar, attributes);
                S(iVar, attributes);
                W(iVar, attributes);
                C(iVar, attributes);
                E(iVar, attributes);
                this.b.i(iVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void q(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, attributes) == null) {
            l("<g>", new Object[0]);
            if (this.b != null) {
                SVG.l lVar = new SVG.l();
                lVar.a = this.a;
                lVar.b = this.b;
                D(lVar, attributes);
                S(lVar, attributes);
                W(lVar, attributes);
                C(lVar, attributes);
                this.b.i(lVar);
                this.b = lVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void v(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, attributes) == null) {
            l("<line>", new Object[0]);
            if (this.b != null) {
                SVG.p pVar = new SVG.p();
                pVar.a = this.a;
                pVar.b = this.b;
                D(pVar, attributes);
                S(pVar, attributes);
                W(pVar, attributes);
                C(pVar, attributes);
                H(pVar, attributes);
                this.b.i(pVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void w(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, attributes) == null) {
            l("<linearGradient>", new Object[0]);
            if (this.b != null) {
                SVG.k0 k0Var = new SVG.k0();
                k0Var.a = this.a;
                k0Var.b = this.b;
                D(k0Var, attributes);
                S(k0Var, attributes);
                F(k0Var, attributes);
                I(k0Var, attributes);
                this.b.i(k0Var);
                this.b = k0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final Map<String, String> x0(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, gVar)) == null) {
            HashMap hashMap = new HashMap();
            gVar.A();
            String s = gVar.s(com.alipay.sdk.encrypt.a.h);
            while (s != null) {
                gVar.f(com.alipay.sdk.encrypt.a.h);
                hashMap.put(s, gVar.q());
                gVar.A();
                s = gVar.s(com.alipay.sdk.encrypt.a.h);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void y(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, attributes) == null) {
            l("<mask>", new Object[0]);
            if (this.b != null) {
                SVG.r rVar = new SVG.r();
                rVar.a = this.a;
                rVar.b = this.b;
                D(rVar, attributes);
                S(rVar, attributes);
                C(rVar, attributes);
                K(rVar, attributes);
                this.b.i(rVar);
                this.b = rVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public static void E0(SVG.j0 j0Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, j0Var, str) == null) {
            g gVar = new g(str.replaceAll("/\\*.*?\\*/", ""));
            while (true) {
                String s = gVar.s(':');
                gVar.A();
                if (gVar.f(':')) {
                    gVar.A();
                    String u = gVar.u(WebvttCueParser.CHAR_SEMI_COLON);
                    if (u == null) {
                        return;
                    }
                    gVar.A();
                    if (gVar.h() || gVar.f(WebvttCueParser.CHAR_SEMI_COLON)) {
                        if (j0Var.f == null) {
                            j0Var.f = new SVG.Style();
                        }
                        S0(j0Var.f, s, u);
                        gVar.A();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static String m0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, str, str2)) == null) {
            if (str.equals("none") || !str.startsWith("url(")) {
                return null;
            }
            if (str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                return str.substring(4, str.length() - 1).trim();
            }
            return str.substring(4).trim();
        }
        return (String) invokeLL.objValue;
    }

    public final void A(SVG.d dVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 12:
                        dVar.o = o0(trim);
                        break;
                    case 13:
                        dVar.p = o0(trim);
                        break;
                    case 14:
                        SVG.o o0 = o0(trim);
                        dVar.q = o0;
                        if (o0.g()) {
                            throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                        }
                        break;
                }
            }
        }
    }

    public final void B(SVG.e eVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                    if ("objectBoundingBox".equals(trim)) {
                        eVar.o = Boolean.FALSE;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        eVar.o = Boolean.TRUE;
                    } else {
                        throw new SVGParseException("Invalid value for attribute clipPathUnits");
                    }
                }
            }
        }
    }

    public final void H(SVG.p pVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 15:
                        pVar.o = o0(trim);
                        break;
                    case 16:
                        pVar.p = o0(trim);
                        break;
                    case 17:
                        pVar.q = o0(trim);
                        break;
                    case 18:
                        pVar.r = o0(trim);
                        break;
                }
            }
        }
    }

    public final void I(SVG.k0 k0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 15:
                        k0Var.m = o0(trim);
                        break;
                    case 16:
                        k0Var.n = o0(trim);
                        break;
                    case 17:
                        k0Var.o = o0(trim);
                        break;
                    case 18:
                        k0Var.p = o0(trim);
                        break;
                }
            }
        }
    }

    public final void L(SVG.u uVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, uVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 8) {
                    if (i2 != 9) {
                        continue;
                    } else {
                        Float valueOf = Float.valueOf(f0(trim));
                        uVar.p = valueOf;
                        if (valueOf.floatValue() < 0.0f) {
                            throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                        }
                    }
                } else {
                    uVar.o = u0(trim);
                }
            }
        }
    }

    public final void T(SVG.s0 s0Var, Attributes attributes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, s0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                    s0Var.n = trim;
                }
            }
        }
    }

    public final void U(SVG.x0 x0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, x0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 6) {
                    if (i2 == 39) {
                        x0Var.o = o0(trim);
                    }
                } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                    x0Var.n = trim;
                }
            }
        }
    }

    public final void V(SVG.y0 y0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, y0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 19) {
                            if (i2 == 20) {
                                y0Var.q = p0(trim);
                            }
                        } else {
                            y0Var.p = p0(trim);
                        }
                    } else {
                        y0Var.o = p0(trim);
                    }
                } else {
                    y0Var.n = p0(trim);
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE] complete} */
    public SVG z(InputStream inputStream, boolean z) throws SVGParseException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048644, this, inputStream, z)) == null) {
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            try {
                inputStream.mark(3);
                int read = inputStream.read() + (inputStream.read() << 8);
                inputStream.reset();
                if (read == 35615) {
                    inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
                }
            } catch (IOException unused) {
            }
            try {
                inputStream.mark(4096);
                L0(inputStream, z);
                return this.a;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    Log.e("SVGParser", "Exception thrown closing input stream");
                }
            }
        }
        return (SVG) invokeLZ.objValue;
    }

    public static Set<String> F0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            g gVar = new g(str);
            HashSet hashSet = new HashSet();
            while (!gVar.h()) {
                String r = gVar.r();
                int indexOf = r.indexOf(45);
                if (indexOf != -1) {
                    r = r.substring(0, indexOf);
                }
                hashSet.add(new Locale(r, "", "").getLanguage());
                gVar.A();
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static SVG.Style.TextAnchor G0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1074341483) {
                if (hashCode != 100571) {
                    if (hashCode == 109757538 && str.equals("start")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("end")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals(NativeConstants.MIDDLE)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return null;
                    }
                    return SVG.Style.TextAnchor.End;
                }
                return SVG.Style.TextAnchor.Middle;
            }
            return SVG.Style.TextAnchor.Start;
        }
        return (SVG.Style.TextAnchor) invokeL.objValue;
    }

    public static SVG.m0 d0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 3387192) {
                if (hashCode == 1442907498 && str.equals("currentColor")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("none")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    try {
                        return b0(str);
                    } catch (SVGParseException unused) {
                        return null;
                    }
                }
                return SVG.g.a();
            }
            return SVG.f.c;
        }
        return (SVG.m0) invokeL.objValue;
    }

    public static SVG.Style.FontStyle k0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1657669071) {
                if (hashCode != -1178781136) {
                    if (hashCode == -1039745817 && str.equals("normal")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("italic")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals("oblique")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return null;
                    }
                    return SVG.Style.FontStyle.Oblique;
                }
                return SVG.Style.FontStyle.Normal;
            }
            return SVG.Style.FontStyle.Italic;
        }
        return (SVG.Style.FontStyle) invokeL.objValue;
    }

    public static SVG.m0 t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            if (str.startsWith("url(")) {
                int indexOf = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
                SVG.m0 m0Var = null;
                if (indexOf != -1) {
                    String trim = str.substring(4, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1).trim();
                    if (trim2.length() > 0) {
                        m0Var = d0(trim2);
                    }
                    return new SVG.t(trim, m0Var);
                }
                return new SVG.t(str.substring(4).trim(), null);
            }
            return d0(str);
        }
        return (SVG.m0) invokeL.objValue;
    }

    public static SVG.Style.RenderQuality y0(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -933002398) {
                if (hashCode != 3005871) {
                    if (hashCode == 362741610 && str.equals("optimizeSpeed")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("auto")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals("optimizeQuality")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return null;
                    }
                    return SVG.Style.RenderQuality.optimizeSpeed;
                }
                return SVG.Style.RenderQuality.optimizeQuality;
            }
            return SVG.Style.RenderQuality.auto;
        }
        return (SVG.Style.RenderQuality) invokeL.objValue;
    }

    public final void K0(InputStream inputStream) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, inputStream) == null) {
            Log.d("SVGParser", "Falling back to SAX parser");
            try {
                SAXParserFactory newInstance = SAXParserFactory.newInstance();
                newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
                newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
                XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
                f fVar = new f(this, null);
                xMLReader.setContentHandler(fVar);
                xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", fVar);
                xMLReader.parse(new InputSource(inputStream));
            } catch (IOException e2) {
                throw new SVGParseException("Stream error", e2);
            } catch (ParserConfigurationException e3) {
                throw new SVGParseException("XML parser problem", e3);
            } catch (SAXException e4) {
                throw new SVGParseException("SVG parse error", e4);
            }
        }
    }

    public final void P0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, attributes) == null) {
            l("<pattern>", new Object[0]);
            if (this.b != null) {
                SVG.x xVar = new SVG.x();
                xVar.a = this.a;
                xVar.b = this.b;
                D(xVar, attributes);
                S(xVar, attributes);
                C(xVar, attributes);
                Y(xVar, attributes);
                M(xVar, attributes);
                this.b.i(xVar);
                this.b = xVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void Q0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, attributes) == null) {
            l("<polygon>", new Object[0]);
            if (this.b != null) {
                SVG.y zVar = new SVG.z();
                zVar.a = this.a;
                zVar.b = this.b;
                D(zVar, attributes);
                S(zVar, attributes);
                W(zVar, attributes);
                C(zVar, attributes);
                N(zVar, attributes, "polygon");
                this.b.i(zVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void R0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, attributes) == null) {
            l("<polyline>", new Object[0]);
            if (this.b != null) {
                SVG.y yVar = new SVG.y();
                yVar.a = this.a;
                yVar.b = this.b;
                D(yVar, attributes);
                S(yVar, attributes);
                W(yVar, attributes);
                C(yVar, attributes);
                N(yVar, attributes, "polyline");
                this.b.i(yVar);
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void Y0(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, attributes) == null) {
            l("<stop>", new Object[0]);
            SVG.h0 h0Var = this.b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.j) {
                    SVG.c0 c0Var = new SVG.c0();
                    c0Var.a = this.a;
                    c0Var.b = this.b;
                    D(c0Var, attributes);
                    S(c0Var, attributes);
                    R(c0Var, attributes);
                    this.b.i(c0Var);
                    this.b = c0Var;
                    return;
                }
                throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void c1(String str) throws SVGParseException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, str) != null) || this.c) {
            return;
        }
        if (this.e) {
            if (this.g == null) {
                this.g = new StringBuilder(str.length());
            }
            this.g.append(str);
        } else if (this.h) {
            if (this.i == null) {
                this.i = new StringBuilder(str.length());
            }
            this.i.append(str);
        } else if (this.b instanceof SVG.w0) {
            h(str);
        }
    }

    public final void d1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, attributes) == null) {
            l("<text>", new Object[0]);
            if (this.b != null) {
                SVG.u0 u0Var = new SVG.u0();
                u0Var.a = this.a;
                u0Var.b = this.b;
                D(u0Var, attributes);
                S(u0Var, attributes);
                W(u0Var, attributes);
                C(u0Var, attributes);
                V(u0Var, attributes);
                this.b.i(u0Var);
                this.b = u0Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void f1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, attributes) == null) {
            l("<textPath>", new Object[0]);
            if (this.b != null) {
                SVG.x0 x0Var = new SVG.x0();
                x0Var.a = this.a;
                x0Var.b = this.b;
                D(x0Var, attributes);
                S(x0Var, attributes);
                C(x0Var, attributes);
                U(x0Var, attributes);
                this.b.i(x0Var);
                this.b = x0Var;
                SVG.h0 h0Var = x0Var.b;
                if (h0Var instanceof SVG.z0) {
                    x0Var.o((SVG.z0) h0Var);
                    return;
                } else {
                    x0Var.o(((SVG.v0) h0Var).c());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void g1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, attributes) == null) {
            l("<tref>", new Object[0]);
            SVG.h0 h0Var = this.b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.w0) {
                    SVG.s0 s0Var = new SVG.s0();
                    s0Var.a = this.a;
                    s0Var.b = this.b;
                    D(s0Var, attributes);
                    S(s0Var, attributes);
                    C(s0Var, attributes);
                    T(s0Var, attributes);
                    this.b.i(s0Var);
                    SVG.h0 h0Var2 = s0Var.b;
                    if (h0Var2 instanceof SVG.z0) {
                        s0Var.o((SVG.z0) h0Var2);
                        return;
                    } else {
                        s0Var.o(((SVG.v0) h0Var2).c());
                        return;
                    }
                }
                throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void h(String str) throws SVGParseException {
        SVG.l0 l0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            SVG.f0 f0Var = (SVG.f0) this.b;
            int size = f0Var.i.size();
            if (size == 0) {
                l0Var = null;
            } else {
                l0Var = f0Var.i.get(size - 1);
            }
            if (l0Var instanceof SVG.a1) {
                StringBuilder sb = new StringBuilder();
                SVG.a1 a1Var = (SVG.a1) l0Var;
                sb.append(a1Var.c);
                sb.append(str);
                a1Var.c = sb.toString();
                return;
            }
            this.b.i(new SVG.a1(str));
        }
    }

    public final void i1(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, attributes) == null) {
            l("<use>", new Object[0]);
            if (this.b != null) {
                SVG.b1 b1Var = new SVG.b1();
                b1Var.a = this.a;
                b1Var.b = this.b;
                D(b1Var, attributes);
                S(b1Var, attributes);
                W(b1Var, attributes);
                C(b1Var, attributes);
                X(b1Var, attributes);
                this.b.i(b1Var);
                this.b = b1Var;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void k(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, attributes) == null) {
            l("<clipPath>", new Object[0]);
            if (this.b != null) {
                SVG.e eVar = new SVG.e();
                eVar.a = this.a;
                eVar.b = this.b;
                D(eVar, attributes);
                S(eVar, attributes);
                W(eVar, attributes);
                C(eVar, attributes);
                B(eVar, attributes);
                this.b.i(eVar);
                this.b = eVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void u(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, attributes) == null) {
            l("<image>", new Object[0]);
            if (this.b != null) {
                SVG.n nVar = new SVG.n();
                nVar.a = this.a;
                nVar.b = this.b;
                D(nVar, attributes);
                S(nVar, attributes);
                W(nVar, attributes);
                C(nVar, attributes);
                G(nVar, attributes);
                this.b.i(nVar);
                this.b = nVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public final void x(Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, attributes) == null) {
            l("<marker>", new Object[0]);
            if (this.b != null) {
                SVG.q qVar = new SVG.q();
                qVar.a = this.a;
                qVar.b = this.b;
                D(qVar, attributes);
                S(qVar, attributes);
                C(qVar, attributes);
                Y(qVar, attributes);
                J(qVar, attributes);
                this.b.i(qVar);
                this.b = qVar;
                return;
            }
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
    }

    public static void S0(SVG.Style style, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65548, null, style, str, str2) != null) || str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (a.b[SVGAttr.fromString(str).ordinal()]) {
                case 47:
                    SVG.m0 t0 = t0(str2);
                    style.b = t0;
                    if (t0 != null) {
                        style.a |= 1;
                        return;
                    }
                    return;
                case 48:
                    SVG.Style.FillRule e0 = e0(str2);
                    style.c = e0;
                    if (e0 != null) {
                        style.a |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float r0 = r0(str2);
                    style.d = r0;
                    if (r0 != null) {
                        style.a |= 4;
                        return;
                    }
                    return;
                case 50:
                    SVG.m0 t02 = t0(str2);
                    style.e = t02;
                    if (t02 != null) {
                        style.a |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float r02 = r0(str2);
                    style.f = r02;
                    if (r02 != null) {
                        style.a |= 16;
                        return;
                    }
                    return;
                case 52:
                    style.g = o0(str2);
                    style.a |= 32;
                    break;
                case 53:
                    SVG.Style.LineCap C0 = C0(str2);
                    style.h = C0;
                    if (C0 != null) {
                        style.a |= 64;
                        return;
                    }
                    return;
                case 54:
                    SVG.Style.LineJoin D0 = D0(str2);
                    style.i = D0;
                    if (D0 != null) {
                        style.a |= 128;
                        return;
                    }
                    return;
                case 55:
                    style.j = Float.valueOf(f0(str2));
                    style.a |= 256;
                    break;
                case 56:
                    if ("none".equals(str2)) {
                        style.k = null;
                        style.a |= 512;
                        return;
                    }
                    SVG.o[] B0 = B0(str2);
                    style.k = B0;
                    if (B0 != null) {
                        style.a |= 512;
                        return;
                    }
                    return;
                case 57:
                    style.l = o0(str2);
                    style.a |= 1024;
                    break;
                case 58:
                    style.m = r0(str2);
                    style.a |= 2048;
                    return;
                case 59:
                    style.n = b0(str2);
                    style.a |= 4096;
                    break;
                case 60:
                    h0(style, str2);
                    return;
                case 61:
                    List<String> i0 = i0(str2);
                    style.o = i0;
                    if (i0 != null) {
                        style.a |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        return;
                    }
                    return;
                case 62:
                    SVG.o j0 = j0(str2);
                    style.p = j0;
                    if (j0 != null) {
                        style.a |= 16384;
                        return;
                    }
                    return;
                case 63:
                    Integer l0 = l0(str2);
                    style.q = l0;
                    if (l0 != null) {
                        style.a |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        return;
                    }
                    return;
                case 64:
                    SVG.Style.FontStyle k0 = k0(str2);
                    style.r = k0;
                    if (k0 != null) {
                        style.a |= 65536;
                        return;
                    }
                    return;
                case 65:
                    SVG.Style.TextDecoration H0 = H0(str2);
                    style.s = H0;
                    if (H0 != null) {
                        style.a |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        return;
                    }
                    return;
                case 66:
                    SVG.Style.TextDirection I0 = I0(str2);
                    style.t = I0;
                    if (I0 != null) {
                        style.a |= 68719476736L;
                        return;
                    }
                    return;
                case 67:
                    SVG.Style.TextAnchor G0 = G0(str2);
                    style.u = G0;
                    if (G0 != null) {
                        style.a |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean s0 = s0(str2);
                    style.v = s0;
                    if (s0 != null) {
                        style.a |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        return;
                    }
                    return;
                case 69:
                    String m0 = m0(str2, str);
                    style.x = m0;
                    style.y = m0;
                    style.z = m0;
                    style.a |= 14680064;
                    return;
                case 70:
                    style.x = m0(str2, str);
                    style.a |= 2097152;
                    return;
                case 71:
                    style.y = m0(str2, str);
                    style.a |= 4194304;
                    return;
                case 72:
                    style.z = m0(str2, str);
                    style.a |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                            style.A = Boolean.valueOf(!str2.equals("none"));
                            style.a |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                            style.B = Boolean.valueOf(str2.equals(MapBundleKey.MapObjKey.OBJ_SL_VISI));
                            style.a |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals("currentColor")) {
                        style.C = SVG.g.a();
                    } else {
                        try {
                            style.C = b0(str2);
                        } catch (SVGParseException e2) {
                            Log.w("SVGParser", e2.getMessage());
                            return;
                        }
                    }
                    style.a |= 67108864;
                    return;
                case 76:
                    style.D = r0(str2);
                    style.a |= 134217728;
                    return;
                case 77:
                    SVG.c a0 = a0(str2);
                    style.w = a0;
                    if (a0 != null) {
                        style.a |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    style.E = m0(str2, str);
                    style.a |= AccountConstants.TYPE_MODIFY_NICKNAME;
                    return;
                case 79:
                    style.F = e0(str2);
                    style.a |= 536870912;
                    return;
                case 80:
                    style.G = m0(str2, str);
                    style.a |= 1073741824;
                    return;
                case 81:
                    if (str2.equals("currentColor")) {
                        style.H = SVG.g.a();
                    } else {
                        try {
                            style.H = b0(str2);
                        } catch (SVGParseException e3) {
                            Log.w("SVGParser", e3.getMessage());
                            return;
                        }
                    }
                    style.a |= 2147483648L;
                    return;
                case 82:
                    style.I = r0(str2);
                    style.a |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        style.J = SVG.g.a();
                    } else {
                        try {
                            style.J = b0(str2);
                        } catch (SVGParseException e4) {
                            Log.w("SVGParser", e4.getMessage());
                            return;
                        }
                    }
                    style.a |= 8589934592L;
                    return;
                case 84:
                    style.K = r0(str2);
                    style.a |= 17179869184L;
                    return;
                case 85:
                    SVG.Style.VectorEffect M0 = M0(str2);
                    style.L = M0;
                    if (M0 != null) {
                        style.a |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    SVG.Style.RenderQuality y0 = y0(str2);
                    style.M = y0;
                    if (y0 != null) {
                        style.a |= 137438953472L;
                        return;
                    }
                    return;
                default:
            }
        } catch (SVGParseException unused) {
        }
    }

    public static SVG.f b0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            int i = 5;
            if (str.charAt(0) == '#') {
                jz9 b2 = jz9.b(str, 1, str.length());
                if (b2 != null) {
                    int a2 = b2.a();
                    if (a2 != 4) {
                        if (a2 != 5) {
                            if (a2 != 7) {
                                if (a2 == 9) {
                                    return new SVG.f((b2.d() >>> 8) | (b2.d() << 24));
                                }
                                throw new SVGParseException("Bad hex colour value: " + str);
                            }
                            return new SVG.f(b2.d() | (-16777216));
                        }
                        int d2 = b2.d();
                        int i2 = 61440 & d2;
                        int i3 = d2 & 3840;
                        int i4 = d2 & 240;
                        int i5 = d2 & 15;
                        return new SVG.f((i5 << 24) | (i5 << 28) | (i2 << 8) | (i2 << 4) | (i3 << 4) | i3 | i4 | (i4 >> 4));
                    }
                    int d3 = b2.d();
                    int i6 = d3 & 3840;
                    int i7 = d3 & 240;
                    int i8 = d3 & 15;
                    return new SVG.f(i8 | (i6 << 8) | (-16777216) | (i6 << 12) | (i7 << 8) | (i7 << 4) | (i8 << 4));
                }
                throw new SVGParseException("Bad hex colour value: " + str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            boolean startsWith = lowerCase.startsWith("rgba(");
            if (!startsWith && !lowerCase.startsWith("rgb(")) {
                boolean startsWith2 = lowerCase.startsWith("hsla(");
                if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                    return c0(lowerCase);
                }
                if (!startsWith2) {
                    i = 4;
                }
                g gVar = new g(str.substring(i));
                gVar.A();
                float n = gVar.n();
                float d4 = gVar.d(n);
                if (!Float.isNaN(d4)) {
                    gVar.f('%');
                }
                float d5 = gVar.d(d4);
                if (!Float.isNaN(d5)) {
                    gVar.f('%');
                }
                if (startsWith2) {
                    float d6 = gVar.d(d5);
                    gVar.A();
                    if (!Float.isNaN(d6) && gVar.f(')')) {
                        return new SVG.f((j(d6 * 256.0f) << 24) | s(n, d4, d5));
                    }
                    throw new SVGParseException("Bad hsla() colour value: " + str);
                }
                gVar.A();
                if (!Float.isNaN(d5) && gVar.f(')')) {
                    return new SVG.f(s(n, d4, d5) | (-16777216));
                }
                throw new SVGParseException("Bad hsl() colour value: " + str);
            }
            if (!startsWith) {
                i = 4;
            }
            g gVar2 = new g(str.substring(i));
            gVar2.A();
            float n2 = gVar2.n();
            if (!Float.isNaN(n2) && gVar2.f('%')) {
                n2 = (n2 * 256.0f) / 100.0f;
            }
            float d7 = gVar2.d(n2);
            if (!Float.isNaN(d7) && gVar2.f('%')) {
                d7 = (d7 * 256.0f) / 100.0f;
            }
            float d8 = gVar2.d(d7);
            if (!Float.isNaN(d8) && gVar2.f('%')) {
                d8 = (d8 * 256.0f) / 100.0f;
            }
            if (startsWith) {
                float d9 = gVar2.d(d8);
                gVar2.A();
                if (!Float.isNaN(d9) && gVar2.f(')')) {
                    return new SVG.f((j(d9 * 256.0f) << 24) | (j(n2) << 16) | (j(d7) << 8) | j(d8));
                }
                throw new SVGParseException("Bad rgba() colour value: " + str);
            }
            gVar2.A();
            if (!Float.isNaN(d8) && gVar2.f(')')) {
                return new SVG.f((j(n2) << 16) | (-16777216) | (j(d7) << 8) | j(d8));
            }
            throw new SVGParseException("Bad rgb() colour value: " + str);
        }
        return (SVG.f) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02aa, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SVG.v u0(String str) {
        InterceptResult invokeL;
        float d2;
        float d3;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            g gVar = new g(str);
            SVG.v vVar = new SVG.v();
            if (gVar.h()) {
                return vVar;
            }
            int intValue = gVar.l().intValue();
            int i = 109;
            if (intValue != 77 && intValue != 109) {
                return vVar;
            }
            int i2 = intValue;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            while (true) {
                gVar.A();
                int i3 = 108;
                switch (i2) {
                    case 65:
                    case 97:
                        float n = gVar.n();
                        float d4 = gVar.d(n);
                        float d5 = gVar.d(d4);
                        Boolean c2 = gVar.c(Float.valueOf(d5));
                        Boolean c3 = gVar.c(c2);
                        float e2 = gVar.e(c3);
                        float d6 = gVar.d(e2);
                        if (!Float.isNaN(d6) && n >= 0.0f && d4 >= 0.0f) {
                            if (i2 == 97) {
                                e2 += f4;
                                d6 += f6;
                            }
                            vVar.e(n, d4, d5, c2.booleanValue(), c3.booleanValue(), e2, d6);
                            f4 = e2;
                            f5 = f4;
                            f6 = d6;
                            f7 = f6;
                            break;
                        }
                        break;
                    case 67:
                    case 99:
                        float n2 = gVar.n();
                        float d7 = gVar.d(n2);
                        float d8 = gVar.d(d7);
                        float d9 = gVar.d(d8);
                        d2 = gVar.d(d9);
                        d3 = gVar.d(d2);
                        if (Float.isNaN(d3)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 99) {
                            d2 += f4;
                            d3 += f6;
                            n2 += f4;
                            d7 += f6;
                            d8 += f4;
                            d9 += f6;
                        }
                        f2 = d8;
                        f3 = d9;
                        vVar.d(n2, d7, f2, f3, d2, d3);
                        f5 = f2;
                        f4 = d2;
                        f7 = f3;
                        f6 = d3;
                        break;
                    case 72:
                    case 104:
                        float n3 = gVar.n();
                        if (Float.isNaN(n3)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 104) {
                            n3 += f4;
                        }
                        f4 = n3;
                        vVar.b(f4, f6);
                        f5 = f4;
                        break;
                    case 76:
                    case 108:
                        float n4 = gVar.n();
                        float d10 = gVar.d(n4);
                        if (Float.isNaN(d10)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 108) {
                            n4 += f4;
                            d10 += f6;
                        }
                        f4 = n4;
                        f6 = d10;
                        vVar.b(f4, f6);
                        f5 = f4;
                        f7 = f6;
                        break;
                    case 77:
                    case 109:
                        float n5 = gVar.n();
                        float d11 = gVar.d(n5);
                        if (Float.isNaN(d11)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == i && !vVar.i()) {
                            n5 += f4;
                            d11 += f6;
                        }
                        f4 = n5;
                        f6 = d11;
                        vVar.a(f4, f6);
                        if (i2 != i) {
                            i3 = 76;
                        }
                        f5 = f4;
                        f8 = f5;
                        f7 = f6;
                        f9 = f7;
                        i2 = i3;
                        break;
                    case 81:
                    case 113:
                        f5 = gVar.n();
                        f7 = gVar.d(f5);
                        float d12 = gVar.d(f7);
                        float d13 = gVar.d(d12);
                        if (Float.isNaN(d13)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 113) {
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
                        float n6 = gVar.n();
                        float d14 = gVar.d(n6);
                        d2 = gVar.d(d14);
                        d3 = gVar.d(d2);
                        if (Float.isNaN(d3)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 115) {
                            d2 += f4;
                            d3 += f6;
                            n6 += f4;
                            d14 += f6;
                        }
                        f2 = n6;
                        f3 = d14;
                        vVar.d(f10, f11, f2, f3, d2, d3);
                        f5 = f2;
                        f4 = d2;
                        f7 = f3;
                        f6 = d3;
                        break;
                    case 84:
                    case 116:
                        f5 = (f4 * 2.0f) - f5;
                        f7 = (2.0f * f6) - f7;
                        float n7 = gVar.n();
                        float d15 = gVar.d(n7);
                        if (Float.isNaN(d15)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 116) {
                            n7 += f4;
                            d15 += f6;
                        }
                        f4 = n7;
                        f6 = d15;
                        vVar.c(f5, f7, f4, f6);
                        break;
                    case 86:
                    case 118:
                        float n8 = gVar.n();
                        if (Float.isNaN(n8)) {
                            Log.e("SVGParser", "Bad path coords for " + ((char) i2) + " path segment");
                            return vVar;
                        }
                        if (i2 == 118) {
                            n8 += f6;
                        }
                        f6 = n8;
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
                gVar.z();
                if (gVar.h()) {
                    return vVar;
                }
                if (gVar.i()) {
                    i2 = gVar.l().intValue();
                }
                i = 109;
            }
        } else {
            return (SVG.v) invokeL.objValue;
        }
    }

    public final Matrix J0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Matrix matrix = new Matrix();
            g gVar = new g(str);
            gVar.A();
            while (!gVar.h()) {
                String o = gVar.o();
                if (o != null) {
                    char c2 = 65535;
                    switch (o.hashCode()) {
                        case -1081239615:
                            if (o.equals("matrix")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -925180581:
                            if (o.equals("rotate")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 109250890:
                            if (o.equals("scale")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 109493390:
                            if (o.equals("skewX")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 109493391:
                            if (o.equals("skewY")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1052832078:
                            if (o.equals("translate")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 != 3) {
                                    if (c2 != 4) {
                                        if (c2 == 5) {
                                            gVar.A();
                                            float n = gVar.n();
                                            gVar.A();
                                            if (!Float.isNaN(n) && gVar.f(')')) {
                                                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(n)));
                                            } else {
                                                throw new SVGParseException("Invalid transform list: " + str);
                                            }
                                        } else {
                                            throw new SVGParseException("Invalid transform list fn: " + o + SmallTailInfo.EMOTION_SUFFIX);
                                        }
                                    } else {
                                        gVar.A();
                                        float n2 = gVar.n();
                                        gVar.A();
                                        if (!Float.isNaN(n2) && gVar.f(')')) {
                                            matrix.preSkew((float) Math.tan(Math.toRadians(n2)), 0.0f);
                                        } else {
                                            throw new SVGParseException("Invalid transform list: " + str);
                                        }
                                    }
                                } else {
                                    gVar.A();
                                    float n3 = gVar.n();
                                    float x = gVar.x();
                                    float x2 = gVar.x();
                                    gVar.A();
                                    if (!Float.isNaN(n3) && gVar.f(')')) {
                                        if (Float.isNaN(x)) {
                                            matrix.preRotate(n3);
                                        } else if (!Float.isNaN(x2)) {
                                            matrix.preRotate(n3, x, x2);
                                        } else {
                                            throw new SVGParseException("Invalid transform list: " + str);
                                        }
                                    } else {
                                        throw new SVGParseException("Invalid transform list: " + str);
                                    }
                                }
                            } else {
                                gVar.A();
                                float n4 = gVar.n();
                                float x3 = gVar.x();
                                gVar.A();
                                if (!Float.isNaN(n4) && gVar.f(')')) {
                                    if (Float.isNaN(x3)) {
                                        matrix.preScale(n4, n4);
                                    } else {
                                        matrix.preScale(n4, x3);
                                    }
                                } else {
                                    throw new SVGParseException("Invalid transform list: " + str);
                                }
                            }
                        } else {
                            gVar.A();
                            float n5 = gVar.n();
                            float x4 = gVar.x();
                            gVar.A();
                            if (!Float.isNaN(n5) && gVar.f(')')) {
                                if (Float.isNaN(x4)) {
                                    matrix.preTranslate(n5, 0.0f);
                                } else {
                                    matrix.preTranslate(n5, x4);
                                }
                            } else {
                                throw new SVGParseException("Invalid transform list: " + str);
                            }
                        }
                    } else {
                        gVar.A();
                        float n6 = gVar.n();
                        gVar.z();
                        float n7 = gVar.n();
                        gVar.z();
                        float n8 = gVar.n();
                        gVar.z();
                        float n9 = gVar.n();
                        gVar.z();
                        float n10 = gVar.n();
                        gVar.z();
                        float n11 = gVar.n();
                        gVar.A();
                        if (!Float.isNaN(n11) && gVar.f(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{n6, n8, n10, n7, n9, n11, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    }
                    if (!gVar.h()) {
                        gVar.z();
                    } else {
                        return matrix;
                    }
                } else {
                    throw new SVGParseException("Bad transform function encountered in transform list: " + str);
                }
            }
            return matrix;
        }
        return (Matrix) invokeL.objValue;
    }

    public static void w0(SVG.n0 n0Var, String str) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65580, null, n0Var, str) == null) {
            n0Var.n = v0(str);
        }
    }

    public final void W(SVG.m mVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, mVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                    mVar.l(J0(attributes.getValue(i)));
                }
            }
        }
    }

    public static float g0(String str, int i, int i2) throws SVGParseException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, null, str, i, i2)) == null) {
            float b2 = new kz9().b(str, i, i2);
            if (!Float.isNaN(b2)) {
                return b2;
            }
            throw new SVGParseException("Invalid float value: " + str);
        }
        return invokeLII.floatValue;
    }

    public static void h0(SVG.Style style, String str) {
        String s;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, style, str) == null) {
            if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
                return;
            }
            g gVar = new g(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                s = gVar.s(WebvttCueParser.CHAR_SLASH);
                gVar.A();
                if (s == null) {
                    return;
                }
                if (num != null && fontStyle != null) {
                    break;
                } else if (!s.equals("normal") && (num != null || (num = e.a(s)) == null)) {
                    if (fontStyle != null || (fontStyle = k0(s)) == null) {
                        if (str2 != null || !s.equals("small-caps")) {
                            break;
                        }
                        str2 = s;
                    }
                }
            }
            SVG.o j0 = j0(s);
            if (gVar.f(WebvttCueParser.CHAR_SLASH)) {
                gVar.A();
                String r = gVar.r();
                if (r != null) {
                    try {
                        o0(r);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                gVar.A();
            }
            style.o = i0(gVar.y());
            style.p = j0;
            if (num == null) {
                intValue = 400;
            } else {
                intValue = num.intValue();
            }
            style.q = Integer.valueOf(intValue);
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.r = fontStyle;
            style.a |= 122880;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(SVG.j jVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 6) {
                    switch (i2) {
                        case 32:
                            if ("objectBoundingBox".equals(trim)) {
                                jVar.i = Boolean.FALSE;
                                continue;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                jVar.i = Boolean.TRUE;
                                break;
                            } else {
                                throw new SVGParseException("Invalid value for attribute gradientUnits");
                            }
                        case 33:
                            jVar.j = J0(trim);
                            continue;
                        case 34:
                            try {
                                jVar.k = SVG.GradientSpread.valueOf(trim);
                                continue;
                            } catch (IllegalArgumentException unused) {
                                throw new SVGParseException("Invalid spreadMethod attribute. \"" + trim + "\" is not a valid value.");
                            }
                    }
                } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                    jVar.l = trim;
                }
            }
        }
    }

    public final void G(SVG.n nVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, nVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 6) {
                                    if (i2 == 7) {
                                        w0(nVar, trim);
                                    }
                                } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                                    nVar.o = trim;
                                }
                            } else {
                                SVG.o o0 = o0(trim);
                                nVar.s = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o02 = o0(trim);
                            nVar.r = o02;
                            if (o02.g()) {
                                throw new SVGParseException("Invalid <use> element. width cannot be negative");
                            }
                        }
                    } else {
                        nVar.q = o0(trim);
                    }
                } else {
                    nVar.p = o0(trim);
                }
            }
        }
    }

    public final void J(SVG.q qVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, qVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 26:
                        qVar.q = o0(trim);
                        break;
                    case 27:
                        qVar.r = o0(trim);
                        break;
                    case 28:
                        SVG.o o0 = o0(trim);
                        qVar.s = o0;
                        if (o0.g()) {
                            throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                        }
                        break;
                    case 29:
                        SVG.o o02 = o0(trim);
                        qVar.t = o02;
                        if (o02.g()) {
                            throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
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
                            throw new SVGParseException("Invalid value for attribute markerUnits");
                        }
                    case 31:
                        if ("auto".equals(trim)) {
                            qVar.u = Float.valueOf(Float.NaN);
                            break;
                        } else {
                            qVar.u = Float.valueOf(f0(trim));
                            break;
                        }
                }
            }
        }
    }

    public final void K(SVG.r rVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, rVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 43) {
                                    if (i2 != 44) {
                                        continue;
                                    } else if ("objectBoundingBox".equals(trim)) {
                                        rVar.o = Boolean.FALSE;
                                    } else if ("userSpaceOnUse".equals(trim)) {
                                        rVar.o = Boolean.TRUE;
                                    } else {
                                        throw new SVGParseException("Invalid value for attribute maskContentUnits");
                                    }
                                } else if ("objectBoundingBox".equals(trim)) {
                                    rVar.n = Boolean.FALSE;
                                } else if ("userSpaceOnUse".equals(trim)) {
                                    rVar.n = Boolean.TRUE;
                                } else {
                                    throw new SVGParseException("Invalid value for attribute maskUnits");
                                }
                            } else {
                                SVG.o o0 = o0(trim);
                                rVar.s = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o02 = o0(trim);
                            rVar.r = o02;
                            if (o02.g()) {
                                throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                            }
                        }
                    } else {
                        rVar.q = o0(trim);
                    }
                } else {
                    rVar.p = o0(trim);
                }
            }
        }
    }

    public final void P(SVG.a0 a0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, a0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 10) {
                                    if (i2 != 11) {
                                        continue;
                                    } else {
                                        SVG.o o0 = o0(trim);
                                        a0Var.t = o0;
                                        if (o0.g()) {
                                            throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                                        }
                                    }
                                } else {
                                    SVG.o o02 = o0(trim);
                                    a0Var.s = o02;
                                    if (o02.g()) {
                                        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                                    }
                                }
                            } else {
                                SVG.o o03 = o0(trim);
                                a0Var.r = o03;
                                if (o03.g()) {
                                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o04 = o0(trim);
                            a0Var.q = o04;
                            if (o04.g()) {
                                throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                            }
                        }
                    } else {
                        a0Var.p = o0(trim);
                    }
                } else {
                    a0Var.o = o0(trim);
                }
            }
        }
    }

    public final void r(String str, Map<String, String> map) {
        String str2;
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048637, this, str, map) == null) && str.equals("xml-stylesheet") && SVG.g() != null) {
            if (map.get("type") != null && !"text/css".equals(map.get("type"))) {
                return;
            }
            if ((map.get("alternate") != null && !"no".equals(map.get("alternate"))) || (str2 = map.get(NativeConstants.HREF)) == null || (b2 = SVG.g().b(str2)) == null) {
                return;
            }
            String str3 = map.get("media");
            if (str3 != null && !"all".equals(str3.trim())) {
                b2 = "@media " + str3 + " { " + b2 + "}";
            }
            Z(b2);
        }
    }

    public static SVG.o o0(String str) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
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
                        throw new SVGParseException("Invalid length unit specifier: " + str);
                    }
                }
                try {
                    return new SVG.o(g0(str, 0, length), unit);
                } catch (NumberFormatException e2) {
                    throw new SVGParseException("Invalid length value: " + str, e2);
                }
            }
            throw new SVGParseException("Invalid length value (empty string)");
        }
        return (SVG.o) invokeL.objValue;
    }

    public static int s(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f6 = 0.0f;
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            float f7 = f2 % 360.0f;
            if (i < 0) {
                f7 += 360.0f;
            }
            float f8 = f7 / 60.0f;
            float f9 = f3 / 100.0f;
            float f10 = f4 / 100.0f;
            if (f9 < 0.0f) {
                f9 = 0.0f;
            } else if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            if (f10 >= 0.0f) {
                if (f10 > 1.0f) {
                    f6 = 1.0f;
                } else {
                    f6 = f10;
                }
            }
            if (f6 <= 0.5f) {
                f5 = (f9 + 1.0f) * f6;
            } else {
                f5 = (f6 + f9) - (f9 * f6);
            }
            float f11 = (f6 * 2.0f) - f5;
            return j(t(f11, f5, f8 - 2.0f) * 256.0f) | (j(t(f11, f5, f8 + 2.0f) * 256.0f) << 16) | (j(t(f11, f5, f8) * 256.0f) << 8);
        }
        return invokeCommon.intValue;
    }

    public final void N(SVG.y yVar, Attributes attributes, String str) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, yVar, attributes, str) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                    g gVar = new g(attributes.getValue(i));
                    ArrayList<Float> arrayList = new ArrayList();
                    gVar.A();
                    while (!gVar.h()) {
                        float n = gVar.n();
                        if (!Float.isNaN(n)) {
                            gVar.z();
                            float n2 = gVar.n();
                            if (!Float.isNaN(n2)) {
                                gVar.z();
                                arrayList.add(Float.valueOf(n));
                                arrayList.add(Float.valueOf(n2));
                            } else {
                                throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                            }
                        } else {
                            throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                        }
                    }
                    yVar.o = new float[arrayList.size()];
                    int i2 = 0;
                    for (Float f2 : arrayList) {
                        yVar.o[i2] = f2.floatValue();
                        i2++;
                    }
                }
            }
        }
    }

    public final void p(String str, String str2, String str3) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, str, str2, str3) == null) {
            if (this.c) {
                int i = this.d - 1;
                this.d = i;
                if (i == 0) {
                    this.c = false;
                    return;
                }
            }
            if (!"http://www.w3.org/2000/svg".equals(str) && !"".equals(str)) {
                return;
            }
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i2 = a.a[SVGElem.fromString(str2).ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 5 && i2 != 13 && i2 != 14) {
                switch (i2) {
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
                        this.e = false;
                        StringBuilder sb = this.g;
                        if (sb != null) {
                            SVGElem sVGElem = this.f;
                            if (sVGElem == SVGElem.title) {
                                this.a.s(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.a.q(sb.toString());
                            }
                            this.g.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb2 = this.i;
                        if (sb2 != null) {
                            this.h = false;
                            Z(sb2.toString());
                            this.i.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.b = ((SVG.l0) this.b).b;
        }
    }

    public final void C(SVG.e0 e0Var, Attributes attributes) throws SVGParseException {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, e0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 21:
                        e0Var.g(z0(trim));
                        break;
                    case 22:
                        e0Var.k(trim);
                        break;
                    case 23:
                        e0Var.d(F0(trim));
                        break;
                    case 24:
                        e0Var.j(A0(trim));
                        break;
                    case 25:
                        List<String> i0 = i0(trim);
                        if (i0 != null) {
                            hashSet = new HashSet(i0);
                        } else {
                            hashSet = new HashSet(0);
                        }
                        e0Var.b(hashSet);
                        break;
                }
            }
        }
    }

    public final void D(SVG.j0 j0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, j0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String qName = attributes.getQName(i);
                if (!qName.equals("id") && !qName.equals("xml:id")) {
                    if (qName.equals("xml:space")) {
                        String trim = attributes.getValue(i).trim();
                        if ("default".equals(trim)) {
                            j0Var.d = Boolean.FALSE;
                            return;
                        } else if ("preserve".equals(trim)) {
                            j0Var.d = Boolean.TRUE;
                            return;
                        } else {
                            throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                        }
                    }
                } else {
                    j0Var.c = attributes.getValue(i).trim();
                    return;
                }
            }
        }
    }

    public final void E(SVG.i iVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                switch (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                    case 10:
                        SVG.o o0 = o0(trim);
                        iVar.q = o0;
                        if (o0.g()) {
                            throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                        }
                        break;
                    case 11:
                        SVG.o o02 = o0(trim);
                        iVar.r = o02;
                        if (o02.g()) {
                            throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                        }
                        break;
                    case 12:
                        iVar.o = o0(trim);
                        break;
                    case 13:
                        iVar.p = o0(trim);
                        break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O(SVG.o0 o0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, o0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 35) {
                    if (i2 != 36) {
                        switch (i2) {
                            case 12:
                                o0Var.m = o0(trim);
                                continue;
                            case 13:
                                o0Var.n = o0(trim);
                                continue;
                            case 14:
                                SVG.o o0 = o0(trim);
                                o0Var.o = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                                }
                                continue;
                        }
                    } else {
                        o0Var.q = o0(trim);
                    }
                } else {
                    o0Var.p = o0(trim);
                }
            }
        }
    }

    public final void Q(SVG.d0 d0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, d0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5) {
                                    d0Var.t = trim;
                                }
                            } else {
                                SVG.o o0 = o0(trim);
                                d0Var.s = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o02 = o0(trim);
                            d0Var.r = o02;
                            if (o02.g()) {
                                throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                            }
                        }
                    } else {
                        d0Var.q = o0(trim);
                    }
                } else {
                    d0Var.p = o0(trim);
                }
            }
        }
    }

    public final void S(SVG.j0 j0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, j0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                if (trim.length() != 0) {
                    int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                    if (i2 != 45) {
                        if (i2 != 46) {
                            if (j0Var.e == null) {
                                j0Var.e = new SVG.Style();
                            }
                            S0(j0Var.e, attributes.getLocalName(i), attributes.getValue(i).trim());
                        } else {
                            j0Var.g = CSSParser.f(trim);
                        }
                    } else {
                        E0(j0Var, trim);
                    }
                }
            }
        }
    }

    public final void X(SVG.b1 b1Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, b1Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                                    b1Var.o = trim;
                                }
                            } else {
                                SVG.o o0 = o0(trim);
                                b1Var.s = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o02 = o0(trim);
                            b1Var.r = o02;
                            if (o02.g()) {
                                throw new SVGParseException("Invalid <use> element. width cannot be negative");
                            }
                        }
                    } else {
                        b1Var.q = o0(trim);
                    }
                } else {
                    b1Var.p = o0(trim);
                }
            }
        }
    }

    public final void L0(InputStream inputStream, boolean z) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, inputStream, z) == null) {
            try {
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    h hVar = new h(this, newPullParser);
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(inputStream, null);
                    for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                        if (eventType != 0) {
                            if (eventType != 8) {
                                if (eventType != 10) {
                                    if (eventType != 2) {
                                        if (eventType != 3) {
                                            if (eventType != 4) {
                                                if (eventType == 5) {
                                                    c1(newPullParser.getText());
                                                }
                                            } else {
                                                int[] iArr = new int[2];
                                                e1(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                                            }
                                        } else {
                                            String name = newPullParser.getName();
                                            if (newPullParser.getPrefix() != null) {
                                                name = newPullParser.getPrefix() + ':' + name;
                                            }
                                            p(newPullParser.getNamespace(), newPullParser.getName(), name);
                                        }
                                    } else {
                                        String name2 = newPullParser.getName();
                                        if (newPullParser.getPrefix() != null) {
                                            name2 = newPullParser.getPrefix() + ':' + name2;
                                        }
                                        X0(newPullParser.getNamespace(), newPullParser.getName(), name2, hVar);
                                    }
                                } else if (z && this.a.l() == null && newPullParser.getText().contains("<!ENTITY ")) {
                                    try {
                                        Log.d("SVGParser", "Switching to SAX parser to process entities");
                                        inputStream.reset();
                                        K0(inputStream);
                                        return;
                                    } catch (IOException unused) {
                                        Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                        return;
                                    }
                                }
                            } else {
                                Log.d("SVGParser", "PROC INSTR: " + newPullParser.getText());
                                g gVar = new g(newPullParser.getText());
                                r(gVar.r(), x0(gVar));
                            }
                        } else {
                            W0();
                        }
                    }
                    o();
                } catch (XmlPullParserException e2) {
                    throw new SVGParseException("XML parser problem", e2);
                }
            } catch (IOException e3) {
                throw new SVGParseException("Stream error", e3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d3, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M(SVG.x xVar, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, xVar, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 6) {
                                    switch (i2) {
                                        case 40:
                                            if ("objectBoundingBox".equals(trim)) {
                                                xVar.p = Boolean.FALSE;
                                                continue;
                                            } else if ("userSpaceOnUse".equals(trim)) {
                                                xVar.p = Boolean.TRUE;
                                                break;
                                            } else {
                                                throw new SVGParseException("Invalid value for attribute patternUnits");
                                            }
                                        case 41:
                                            if ("objectBoundingBox".equals(trim)) {
                                                xVar.q = Boolean.FALSE;
                                                continue;
                                            } else if ("userSpaceOnUse".equals(trim)) {
                                                xVar.q = Boolean.TRUE;
                                                break;
                                            } else {
                                                throw new SVGParseException("Invalid value for attribute patternContentUnits");
                                            }
                                        case 42:
                                            xVar.r = J0(trim);
                                            continue;
                                    }
                                } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                                    xVar.w = trim;
                                }
                            } else {
                                SVG.o o0 = o0(trim);
                                xVar.v = o0;
                                if (o0.g()) {
                                    throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                                }
                            }
                        } else {
                            SVG.o o02 = o0(trim);
                            xVar.u = o02;
                            if (o02.g()) {
                                throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                            }
                        }
                    } else {
                        xVar.t = o0(trim);
                    }
                } else {
                    xVar.s = o0(trim);
                }
            }
        }
    }

    public final void R(SVG.c0 c0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, c0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                if (a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 37) {
                    c0Var.h = n0(trim);
                }
            }
        }
    }

    public final void Y(SVG.p0 p0Var, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, p0Var, attributes) == null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String trim = attributes.getValue(i).trim();
                int i2 = a.b[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 != 7) {
                    if (i2 == 87) {
                        p0Var.o = N0(trim);
                    }
                } else {
                    w0(p0Var, trim);
                }
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.a = new SVG();
        }
    }

    public final void X0(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048611, this, str, str2, str3, attributes) == null) {
            if (this.c) {
                this.d++;
            } else if (!"http://www.w3.org/2000/svg".equals(str) && !"".equals(str)) {
            } else {
                if (str2.length() <= 0) {
                    str2 = str3;
                }
                SVGElem fromString = SVGElem.fromString(str2);
                switch (a.a[fromString.ordinal()]) {
                    case 1:
                        a1(attributes);
                        return;
                    case 2:
                    case 3:
                        q(attributes);
                        return;
                    case 4:
                        m(attributes);
                        return;
                    case 5:
                        i1(attributes);
                        return;
                    case 6:
                        O0(attributes);
                        return;
                    case 7:
                        U0(attributes);
                        return;
                    case 8:
                        i(attributes);
                        return;
                    case 9:
                        n(attributes);
                        return;
                    case 10:
                        v(attributes);
                        return;
                    case 11:
                        R0(attributes);
                        return;
                    case 12:
                        Q0(attributes);
                        return;
                    case 13:
                        d1(attributes);
                        return;
                    case 14:
                        h1(attributes);
                        return;
                    case 15:
                        g1(attributes);
                        return;
                    case 16:
                        k1(attributes);
                        return;
                    case 17:
                        b1(attributes);
                        return;
                    case 18:
                        x(attributes);
                        return;
                    case 19:
                        w(attributes);
                        return;
                    case 20:
                        T0(attributes);
                        return;
                    case 21:
                        Y0(attributes);
                        return;
                    case 22:
                    case 23:
                        this.e = true;
                        this.f = fromString;
                        return;
                    case 24:
                        k(attributes);
                        return;
                    case 25:
                        f1(attributes);
                        return;
                    case 26:
                        P0(attributes);
                        return;
                    case 27:
                        u(attributes);
                        return;
                    case 28:
                        j1(attributes);
                        return;
                    case 29:
                        y(attributes);
                        return;
                    case 30:
                        Z0(attributes);
                        return;
                    case 31:
                        V0(attributes);
                        return;
                    default:
                        this.c = true;
                        this.d = 1;
                        return;
                }
            }
        }
    }

    public final void e1(char[] cArr, int i, int i2) throws SVGParseException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048620, this, cArr, i, i2) != null) || this.c) {
            return;
        }
        if (this.e) {
            if (this.g == null) {
                this.g = new StringBuilder(i2);
            }
            this.g.append(cArr, i, i2);
        } else if (this.h) {
            if (this.i == null) {
                this.i = new StringBuilder(i2);
            }
            this.i.append(cArr, i, i2);
        } else if (this.b instanceof SVG.w0) {
            h(new String(cArr, i, i2));
        }
    }
}
