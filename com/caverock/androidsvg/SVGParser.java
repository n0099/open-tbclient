package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidubce.services.vod.VodClient;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.coremedia.iso.boxes.TrackReferenceBox;
import com.faceunity.gles.GeneratedTexture;
import com.kuaishou.weapon.un.w0;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.text.SpanItem;
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
/* loaded from: classes2.dex */
public class SVGParser extends DefaultHandler2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SVG a;

    /* renamed from: b  reason: collision with root package name */
    public SVG.h0 f53323b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53324c;

    /* renamed from: d  reason: collision with root package name */
    public int f53325d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53326e;

    /* renamed from: f  reason: collision with root package name */
    public SVGElem f53327f;

    /* renamed from: g  reason: collision with root package name */
    public StringBuilder f53328g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53329h;

    /* renamed from: i  reason: collision with root package name */
    public StringBuilder f53330i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        /* renamed from: d  reason: collision with root package name */
        public static final SVGAttr f53331d;
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
        public static final SVGAttr id;
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
        public static final SVGAttr f53332rx;
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
            f53331d = new SVGAttr("d", 13);
            display = new SVGAttr("display", 14);
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
            href = new SVGAttr("href", 26);
            id = new SVGAttr("id", 27);
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
            media = new SVGAttr(VodClient.PATH_MEDIA, 38);
            offset = new SVGAttr("offset", 39);
            opacity = new SVGAttr("opacity", 40);
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
            f53332rx = new SVGAttr("rx", 56);
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
            transform = new SVGAttr(AnimationProperty.TRANSFORM, 76);
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
            $VALUES = new SVGAttr[]{CLASS, clip, clip_path, clipPathUnits, clip_rule, color, cx, cy, direction, dx, dy, fx, fy, f53331d, display, fill, fill_rule, fill_opacity, font, font_family, font_size, font_weight, font_style, gradientTransform, gradientUnits, height, href, id, marker, marker_start, marker_mid, marker_end, markerHeight, markerUnits, markerWidth, mask, maskContentUnits, maskUnits, media, offset, opacity, orient, overflow, pathLength, patternContentUnits, patternTransform, patternUnits, points, preserveAspectRatio, r, refX, refY, requiredFeatures, requiredExtensions, requiredFormats, requiredFonts, f53332rx, ry, solid_color, solid_opacity, spreadMethod, startOffset, stop_color, stop_opacity, stroke, stroke_dasharray, stroke_dashoffset, stroke_linecap, stroke_linejoin, stroke_miterlimit, stroke_opacity, stroke_width, style, systemLanguage, text_anchor, text_decoration, transform, type, vector_effect, version, viewBox, width, x, y, x1, y1, x2, y2, viewport_fill, viewport_fill_opacity, visibility, sVGAttr};
            cache = new HashMap();
        }

        public SVGAttr(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (str.equals(DealIntentService.KEY_CLASS)) {
                    cache.put(str, CLASS);
                    return CLASS;
                } else if (str.indexOf(95) != -1) {
                    cache.put(str, UNSUPPORTED);
                    return UNSUPPORTED;
                } else {
                    try {
                        SVGAttr valueOf = valueOf(str.replace(SignatureImpl.SEP, '_'));
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
            return (SVGAttr) invokeL.objValue;
        }

        public static SVGAttr valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SVGAttr) Enum.valueOf(SVGAttr.class, str) : (SVGAttr) invokeL.objValue;
        }

        public static SVGAttr[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SVGAttr[]) $VALUES.clone() : (SVGAttr[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        /* renamed from: g  reason: collision with root package name */
        public static final SVGElem f53333g;
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
        public static final SVGElem view;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
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
            svg = new SVGElem(OvalActionButton.SVG, 0);
            a = new SVGElem("a", 1);
            circle = new SVGElem("circle", 2);
            clipPath = new SVGElem("clipPath", 3);
            defs = new SVGElem("defs", 4);
            desc = new SVGElem("desc", 5);
            ellipse = new SVGElem("ellipse", 6);
            f53333g = new SVGElem("g", 7);
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
            stop = new SVGElem(IntentConfig.STOP, 20);
            style = new SVGElem("style", 21);
            SWITCH = new SVGElem("SWITCH", 22);
            symbol = new SVGElem("symbol", 23);
            text = new SVGElem("text", 24);
            textPath = new SVGElem("textPath", 25);
            title = new SVGElem("title", 26);
            tref = new SVGElem(TrackReferenceBox.TYPE, 27);
            tspan = new SVGElem("tspan", 28);
            use = new SVGElem(TbConfig.ST_TYPE_USE, 29);
            view = new SVGElem("view", 30);
            SVGElem sVGElem = new SVGElem("UNSUPPORTED", 31);
            UNSUPPORTED = sVGElem;
            $VALUES = new SVGElem[]{svg, a, circle, clipPath, defs, desc, ellipse, f53333g, image, line, linearGradient, marker, mask, path, pattern, polygon, polyline, radialGradient, rect, solidColor, stop, style, SWITCH, symbol, text, textPath, title, tref, tspan, use, view, sVGElem};
            cache = new HashMap();
        }

        public SVGElem(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                } catch (IllegalArgumentException unused) {
                }
                cache.put(str, UNSUPPORTED);
                return UNSUPPORTED;
            }
            return (SVGElem) invokeL.objValue;
        }

        public static SVGElem valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SVGElem) Enum.valueOf(SVGElem.class, str) : (SVGElem) invokeL.objValue;
        }

        public static SVGElem[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SVGElem[]) $VALUES.clone() : (SVGElem[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f53334b;
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
            f53334b = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53334b[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f53334b[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f53334b[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f53334b[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f53334b[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f53334b[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f53334b[SVGAttr.f53331d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f53334b[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f53334b[SVGAttr.f53332rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f53334b[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f53334b[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f53334b[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f53334b[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f53334b[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f53334b[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f53334b[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f53334b[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f53334b[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f53334b[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f53334b[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f53334b[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f53334b[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f53334b[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f53334b[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f53334b[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f53334b[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f53334b[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f53334b[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f53334b[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f53334b[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f53334b[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f53334b[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f53334b[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f53334b[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f53334b[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f53334b[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f53334b[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f53334b[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f53334b[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f53334b[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f53334b[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f53334b[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f53334b[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f53334b[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f53334b[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f53334b[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f53334b[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f53334b[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f53334b[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f53334b[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f53334b[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f53334b[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f53334b[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f53334b[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f53334b[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f53334b[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f53334b[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f53334b[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f53334b[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f53334b[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f53334b[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f53334b[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f53334b[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f53334b[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f53334b[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f53334b[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f53334b[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f53334b[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f53334b[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f53334b[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f53334b[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f53334b[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f53334b[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f53334b[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f53334b[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f53334b[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f53334b[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f53334b[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f53334b[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f53334b[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f53334b[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f53334b[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f53334b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f53334b[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f53334b[SVGAttr.viewBox.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f53334b[SVGAttr.type.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f53334b[SVGAttr.media.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            a = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                a[SVGElem.f53333g.ordinal()] = 2;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                a[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                a[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                a[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                a[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                a[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                a[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                a[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                a[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                a[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                a[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                a[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                a[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                a[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                a[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                a[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                a[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                a[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                a[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                a[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                a[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                a[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                a[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                a[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                a[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                a[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                a[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                a[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                a[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                a[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused119) {
            }
        }
    }

    /* loaded from: classes2.dex */
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
            hashMap.put("none", PreserveAspectRatio.Alignment.None);
            a.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
            a.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
            a.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
            a.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
            a.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
            a.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
            a.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
            a.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
            a.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        }

        public static PreserveAspectRatio.Alignment a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.get(str) : (PreserveAspectRatio.Alignment) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
            hashMap.put("aliceblue", 15792383);
            a.put("antiquewhite", 16444375);
            a.put("aqua", 65535);
            a.put("aquamarine", 8388564);
            a.put("azure", 15794175);
            a.put("beige", 16119260);
            a.put("bisque", 16770244);
            a.put("black", 0);
            a.put("blanchedalmond", 16772045);
            a.put("blue", 255);
            a.put("blueviolet", 9055202);
            a.put("brown", 10824234);
            a.put("burlywood", 14596231);
            a.put("cadetblue", 6266528);
            a.put("chartreuse", 8388352);
            a.put("chocolate", 13789470);
            a.put("coral", 16744272);
            a.put("cornflowerblue", 6591981);
            a.put("cornsilk", 16775388);
            a.put("crimson", 14423100);
            a.put("cyan", 65535);
            a.put("darkblue", Integer.valueOf((int) w0.o));
            a.put("darkcyan", 35723);
            a.put("darkgoldenrod", 12092939);
            a.put("darkgray", 11119017);
            a.put("darkgreen", Integer.valueOf((int) LokiService.Constant.MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER));
            a.put("darkgrey", 11119017);
            a.put("darkkhaki", 12433259);
            a.put("darkmagenta", 9109643);
            a.put("darkolivegreen", 5597999);
            a.put("darkorange", 16747520);
            a.put("darkorchid", 10040012);
            a.put("darkred", 9109504);
            a.put("darksalmon", 15308410);
            a.put("darkseagreen", 9419919);
            a.put("darkslateblue", 4734347);
            a.put("darkslategray", 3100495);
            a.put("darkslategrey", 3100495);
            a.put("darkturquoise", 52945);
            a.put("darkviolet", 9699539);
            a.put("deeppink", 16716947);
            a.put("deepskyblue", 49151);
            a.put("dimgray", 6908265);
            a.put("dimgrey", 6908265);
            a.put("dodgerblue", 2003199);
            a.put("firebrick", 11674146);
            a.put("floralwhite", 16775920);
            a.put("forestgreen", 2263842);
            Map<String, Integer> map = a;
            Integer valueOf = Integer.valueOf((int) GeneratedTexture.MAGENTA);
            map.put("fuchsia", valueOf);
            a.put("gainsboro", 14474460);
            a.put("ghostwhite", 16316671);
            a.put("gold", 16766720);
            a.put("goldenrod", 14329120);
            a.put("gray", 8421504);
            a.put("green", 32768);
            a.put("greenyellow", 11403055);
            a.put("grey", 8421504);
            a.put("honeydew", 15794160);
            a.put("hotpink", 16738740);
            a.put("indianred", 13458524);
            a.put("indigo", 4915330);
            a.put("ivory", 16777200);
            a.put("khaki", 15787660);
            a.put("lavender", 15132410);
            a.put("lavenderblush", 16773365);
            a.put("lawngreen", 8190976);
            a.put("lemonchiffon", 16775885);
            a.put("lightblue", 11393254);
            a.put("lightcoral", 15761536);
            a.put("lightcyan", 14745599);
            a.put("lightgoldenrodyellow", 16448210);
            a.put("lightgray", 13882323);
            a.put("lightgreen", 9498256);
            a.put("lightgrey", 13882323);
            a.put("lightpink", 16758465);
            a.put("lightsalmon", 16752762);
            a.put("lightseagreen", 2142890);
            a.put("lightskyblue", 8900346);
            a.put("lightslategray", 7833753);
            a.put("lightslategrey", 7833753);
            a.put("lightsteelblue", 11584734);
            a.put("lightyellow", 16777184);
            a.put("lime", 65280);
            a.put("limegreen", 3329330);
            a.put("linen", 16445670);
            a.put("magenta", valueOf);
            a.put("maroon", 8388608);
            a.put("mediumaquamarine", 6737322);
            a.put("mediumblue", 205);
            a.put("mediumorchid", 12211667);
            a.put("mediumpurple", 9662683);
            a.put("mediumseagreen", 3978097);
            a.put("mediumslateblue", 8087790);
            a.put("mediumspringgreen", 64154);
            a.put("mediumturquoise", 4772300);
            a.put("mediumvioletred", 13047173);
            a.put("midnightblue", 1644912);
            a.put("mintcream", 16121850);
            a.put("mistyrose", 16770273);
            a.put("moccasin", 16770229);
            a.put("navajowhite", 16768685);
            a.put("navy", 128);
            a.put("oldlace", 16643558);
            a.put("olive", 8421376);
            a.put("olivedrab", 7048739);
            a.put("orange", 16753920);
            a.put("orangered", 16729344);
            a.put("orchid", 14315734);
            a.put("palegoldenrod", 15657130);
            a.put("palegreen", 10025880);
            a.put("paleturquoise", 11529966);
            a.put("palevioletred", 14381203);
            a.put("papayawhip", 16773077);
            a.put("peachpuff", 16767673);
            a.put("peru", 13468991);
            a.put("pink", 16761035);
            a.put("plum", 14524637);
            a.put("powderblue", 11591910);
            a.put("purple", 8388736);
            a.put("red", 16711680);
            a.put("rosybrown", 12357519);
            a.put("royalblue", 4286945);
            a.put("saddlebrown", 9127187);
            a.put("salmon", 16416882);
            a.put("sandybrown", 16032864);
            a.put("seagreen", 3050327);
            a.put("seashell", 16774638);
            a.put("sienna", 10506797);
            a.put("silver", 12632256);
            a.put("skyblue", 8900331);
            a.put("slateblue", 6970061);
            a.put("slategray", 7372944);
            a.put("slategrey", 7372944);
            a.put("snow", 16775930);
            a.put("springgreen", 65407);
            a.put("steelblue", 4620980);
            a.put("tan", 13808780);
            a.put("teal", 32896);
            a.put("thistle", 14204888);
            a.put("tomato", 16737095);
            a.put("turquoise", 4251856);
            a.put("violet", 15631086);
            a.put("wheat", 16113331);
            a.put("white", 16777215);
            a.put("whitesmoke", 16119285);
            a.put("yellow", Integer.valueOf((int) GeneratedTexture.CYAN));
            a.put("yellowgreen", 10145074);
        }

        public static Integer a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.get(str) : (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.get(str) : (SVG.o) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
            a.put(SpanItem.STYLE_BOLD, 700);
            a.put("bolder", 1);
            a.put("lighter", -1);
            a.put(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP, 100);
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.get(str) : (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f53335b;

        /* renamed from: c  reason: collision with root package name */
        public int f53336c;

        /* renamed from: d  reason: collision with root package name */
        public c.c.a.b f53337d;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53335b = 0;
            this.f53336c = 0;
            this.f53337d = new c.c.a.b();
            String trim = str.trim();
            this.a = trim;
            this.f53336c = trim.length();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f53335b;
                int i3 = this.f53336c;
                if (i2 == i3) {
                    return -1;
                }
                int i4 = i2 + 1;
                this.f53335b = i4;
                if (i4 < i3) {
                    return this.a.charAt(i4);
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f53335b;
                while (!g() && !j(this.a.charAt(this.f53335b))) {
                    this.f53335b++;
                }
                String substring = this.a.substring(i2, this.f53335b);
                this.f53335b = i2;
                return substring;
            }
            return (String) invokeV.objValue;
        }

        public Boolean c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj == null) {
                    return null;
                }
                v();
                return l();
            }
            return (Boolean) invokeL.objValue;
        }

        public float d(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
                if (Float.isNaN(f2)) {
                    return Float.NaN;
                }
                v();
                return m();
            }
            return invokeF.floatValue;
        }

        public boolean e(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Character.valueOf(c2)})) == null) {
                int i2 = this.f53335b;
                boolean z = i2 < this.f53336c && this.a.charAt(i2) == c2;
                if (z) {
                    this.f53335b++;
                }
                return z;
            }
            return invokeCommon.booleanValue;
        }

        public boolean f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                int length = str.length();
                int i2 = this.f53335b;
                boolean z = i2 <= this.f53336c - length && this.a.substring(i2, i2 + length).equals(str);
                if (z) {
                    this.f53335b += length;
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f53335b == this.f53336c : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i2 = this.f53335b;
                if (i2 == this.f53336c) {
                    return false;
                }
                char charAt = this.a.charAt(i2);
                return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
            }
            return invokeV.booleanValue;
        }

        public boolean i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 == 10 || i2 == 13 : invokeI.booleanValue;
        }

        public boolean j(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 == 32 || i2 == 10 || i2 == 13 || i2 == 9 : invokeI.booleanValue;
        }

        public Integer k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                int i2 = this.f53335b;
                if (i2 == this.f53336c) {
                    return null;
                }
                String str = this.a;
                this.f53335b = i2 + 1;
                return Integer.valueOf(str.charAt(i2));
            }
            return (Integer) invokeV.objValue;
        }

        public Boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = this.f53335b;
                if (i2 == this.f53336c) {
                    return null;
                }
                char charAt = this.a.charAt(i2);
                if (charAt == '0' || charAt == '1') {
                    this.f53335b++;
                    return Boolean.valueOf(charAt == '1');
                }
                return null;
            }
            return (Boolean) invokeV.objValue;
        }

        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                float b2 = this.f53337d.b(this.a, this.f53335b, this.f53336c);
                if (!Float.isNaN(b2)) {
                    this.f53335b = this.f53337d.a();
                }
                return b2;
            }
            return invokeV.floatValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (g()) {
                    return null;
                }
                int i2 = this.f53335b;
                int charAt = this.a.charAt(i2);
                while (true) {
                    if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                        break;
                    }
                    charAt = a();
                }
                int i3 = this.f53335b;
                while (j(charAt)) {
                    charAt = a();
                }
                if (charAt == 40) {
                    this.f53335b++;
                    return this.a.substring(i2, i3);
                }
                this.f53335b = i2;
                return null;
            }
            return (String) invokeV.objValue;
        }

        public SVG.o o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
            return (SVG.o) invokeV.objValue;
        }

        public String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (g()) {
                    return null;
                }
                int i2 = this.f53335b;
                char charAt = this.a.charAt(i2);
                if (charAt == '\'' || charAt == '\"') {
                    int a = a();
                    while (a != -1 && a != charAt) {
                        a = a();
                    }
                    if (a == -1) {
                        this.f53335b = i2;
                        return null;
                    }
                    int i3 = this.f53335b + 1;
                    this.f53335b = i3;
                    return this.a.substring(i2 + 1, i3 - 1);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        public String q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? r(' ') : (String) invokeV.objValue;
        }

        public String r(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Character.valueOf(c2)})) == null) {
                if (g()) {
                    return null;
                }
                char charAt = this.a.charAt(this.f53335b);
                if (j(charAt) || charAt == c2) {
                    return null;
                }
                int i2 = this.f53335b;
                int a = a();
                while (a != -1 && a != c2 && !j(a)) {
                    a = a();
                }
                return this.a.substring(i2, this.f53335b);
            }
            return (String) invokeCommon.objValue;
        }

        public SVG.Unit s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (g()) {
                    return null;
                }
                if (this.a.charAt(this.f53335b) == '%') {
                    this.f53335b++;
                    return SVG.Unit.percent;
                }
                int i2 = this.f53335b;
                if (i2 > this.f53336c - 2) {
                    return null;
                }
                try {
                    SVG.Unit valueOf = SVG.Unit.valueOf(this.a.substring(i2, i2 + 2).toLowerCase(Locale.US));
                    this.f53335b += 2;
                    return valueOf;
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            return (SVG.Unit) invokeV.objValue;
        }

        public float t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                v();
                float b2 = this.f53337d.b(this.a, this.f53335b, this.f53336c);
                if (!Float.isNaN(b2)) {
                    this.f53335b = this.f53337d.a();
                }
                return b2;
            }
            return invokeV.floatValue;
        }

        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if (g()) {
                    return null;
                }
                int i2 = this.f53335b;
                this.f53335b = this.f53336c;
                return this.a.substring(i2);
            }
            return (String) invokeV.objValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                w();
                int i2 = this.f53335b;
                if (i2 != this.f53336c && this.a.charAt(i2) == ',') {
                    this.f53335b++;
                    w();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void w() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048598, this) != null) {
                return;
            }
            while (true) {
                int i2 = this.f53335b;
                if (i2 >= this.f53336c || !j(this.a.charAt(i2))) {
                    return;
                }
                this.f53335b++;
            }
        }
    }

    public SVGParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f53323b = null;
        this.f53324c = false;
        this.f53326e = false;
        this.f53327f = null;
        this.f53328g = null;
        this.f53329h = false;
        this.f53330i = null;
    }

    public static void B0(SVG.Style style, String str, String str2) throws SAXException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, style, str, str2) == null) || str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        switch (a.f53334b[SVGAttr.fromString(str).ordinal()]) {
            case 47:
                style.f53283f = h0(str2, "fill");
                style.f53282e |= 1;
                return;
            case 48:
                style.f53284g = S(str2);
                style.f53282e |= 2;
                return;
            case 49:
                style.f53285h = Float.valueOf(f0(str2));
                style.f53282e |= 4;
                return;
            case 50:
                style.f53286i = h0(str2, "stroke");
                style.f53282e |= 8;
                return;
            case 51:
                style.f53287j = Float.valueOf(f0(str2));
                style.f53282e |= 16;
                return;
            case 52:
                style.k = c0(str2);
                style.f53282e |= 32;
                return;
            case 53:
                style.l = n0(str2);
                style.f53282e |= 64;
                return;
            case 54:
                style.m = o0(str2);
                style.f53282e |= 128;
                return;
            case 55:
                style.n = Float.valueOf(T(str2));
                style.f53282e |= 256;
                return;
            case 56:
                if ("none".equals(str2)) {
                    style.o = null;
                } else {
                    style.o = m0(str2);
                }
                style.f53282e |= 512;
                return;
            case 57:
                style.p = c0(str2);
                style.f53282e |= 1024;
                return;
            case 58:
                style.q = Float.valueOf(f0(str2));
                style.f53282e |= 2048;
                return;
            case 59:
                style.r = P(str2);
                style.f53282e |= 4096;
                return;
            case 60:
                V(style, str2);
                return;
            case 61:
                style.s = W(str2);
                style.f53282e |= 8192;
                return;
            case 62:
                style.t = X(str2);
                style.f53282e |= 16384;
                return;
            case 63:
                style.u = Z(str2);
                style.f53282e |= 32768;
                return;
            case 64:
                style.v = Y(str2);
                style.f53282e |= 65536;
                return;
            case 65:
                style.w = s0(str2);
                style.f53282e |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                return;
            case 66:
                style.x = t0(str2);
                style.f53282e |= 68719476736L;
                return;
            case 67:
                style.y = r0(str2);
                style.f53282e |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                return;
            case 68:
                style.z = g0(str2);
                style.f53282e |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                return;
            case 69:
                String a0 = a0(str2, str);
                style.B = a0;
                style.C = a0;
                style.D = a0;
                style.f53282e |= 14680064;
                return;
            case 70:
                style.B = a0(str2, str);
                style.f53282e |= 2097152;
                return;
            case 71:
                style.C = a0(str2, str);
                style.f53282e |= 4194304;
                return;
            case 72:
                style.D = a0(str2, str);
                style.f53282e |= 8388608;
                return;
            case 73:
                if (str2.indexOf(124) < 0) {
                    if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".indexOf('|' + str2 + '|') != -1) {
                        style.E = Boolean.valueOf(!str2.equals("none"));
                        style.f53282e |= 16777216;
                        return;
                    }
                }
                throw new SAXException("Invalid value for \"display\" attribute: " + str2);
            case 74:
                if (str2.indexOf(124) < 0) {
                    if ("|visible|hidden|collapse|".indexOf('|' + str2 + '|') != -1) {
                        style.F = Boolean.valueOf(str2.equals(TKBase.VISIBILITY_VISIBLE));
                        style.f53282e |= 33554432;
                        return;
                    }
                }
                throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
            case 75:
                if (str2.equals("currentColor")) {
                    style.G = SVG.g.a();
                } else {
                    style.G = P(str2);
                }
                style.f53282e |= 67108864;
                return;
            case 76:
                style.H = Float.valueOf(f0(str2));
                style.f53282e |= 134217728;
                return;
            case 77:
                style.A = O(str2);
                style.f53282e |= 1048576;
                return;
            case 78:
                style.I = a0(str2, str);
                style.f53282e |= AccountConstants.TYPE_MODIFY_NICKNAME;
                return;
            case 79:
                style.J = S(str2);
                style.f53282e |= 536870912;
                return;
            case 80:
                style.K = a0(str2, str);
                style.f53282e |= 1073741824;
                return;
            case 81:
                if (str2.equals("currentColor")) {
                    style.L = SVG.g.a();
                } else {
                    style.L = P(str2);
                }
                style.f53282e |= 2147483648L;
                return;
            case 82:
                style.M = Float.valueOf(f0(str2));
                style.f53282e |= 4294967296L;
                return;
            case 83:
                if (str2.equals("currentColor")) {
                    style.N = SVG.g.a();
                } else {
                    style.N = P(str2);
                }
                style.f53282e |= AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                return;
            case 84:
                style.O = Float.valueOf(f0(str2));
                style.f53282e |= 17179869184L;
                return;
            case 85:
                style.P = v0(str2);
                style.f53282e |= 34359738368L;
                return;
            default:
                return;
        }
    }

    public static SVG.c O(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("auto".equals(str)) {
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
        return (SVG.c) invokeL.objValue;
    }

    public static SVG.f P(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.charAt(0) == '#') {
                c.c.a.a b2 = c.c.a.a.b(str, 1, str.length());
                if (b2 != null) {
                    int a2 = b2.a();
                    if (a2 == 7) {
                        return new SVG.f(b2.c());
                    }
                    if (a2 == 4) {
                        int c2 = b2.c();
                        int i2 = c2 & 3840;
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
        return (SVG.f) invokeL.objValue;
    }

    public static SVG.f Q(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Integer a2 = c.a(str.toLowerCase(Locale.US));
            if (a2 != null) {
                return new SVG.f(a2.intValue());
            }
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return (SVG.f) invokeL.objValue;
    }

    public static SVG.m0 R(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str.equals("none")) {
                return null;
            }
            if (str.equals("currentColor")) {
                return SVG.g.a();
            }
            return P(str);
        }
        return (SVG.m0) invokeL.objValue;
    }

    public static SVG.Style.FillRule S(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if ("nonzero".equals(str)) {
                return SVG.Style.FillRule.NonZero;
            }
            if ("evenodd".equals(str)) {
                return SVG.Style.FillRule.EvenOdd;
            }
            throw new SAXException("Invalid fill-rule property: " + str);
        }
        return (SVG.Style.FillRule) invokeL.objValue;
    }

    public static float T(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            int length = str.length();
            if (length != 0) {
                return U(str, 0, length);
            }
            throw new SAXException("Invalid float value (empty string)");
        }
        return invokeL.floatValue;
    }

    public static float U(String str, int i2, int i3) throws SAXException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) {
            float b2 = new c.c.a.b().b(str, i2, i3);
            if (Float.isNaN(b2)) {
                throw new SAXException("Invalid float value: " + str);
            }
            return b2;
        }
        return invokeLII.floatValue;
    }

    public static void V(SVG.Style style, String str) throws SAXException {
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, style, str) == null) {
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
            style.f53282e |= 122880;
        }
    }

    public static List<String> W(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static SVG.o X(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            SVG.o a2 = d.a(str);
            return a2 == null ? c0(str) : a2;
        }
        return (SVG.o) invokeL.objValue;
    }

    public static SVG.Style.FontStyle Y(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            SVG.Style.FontStyle g2 = g(str);
            if (g2 != null) {
                return g2;
            }
            throw new SAXException("Invalid font-style property: " + str);
        }
        return (SVG.Style.FontStyle) invokeL.objValue;
    }

    public static Integer Z(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            Integer a2 = e.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new SAXException("Invalid font-weight property: " + str);
        }
        return (Integer) invokeL.objValue;
    }

    public static String a0(String str, String str2) throws SAXException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (str.equals("none")) {
                return null;
            }
            if (str.startsWith("url(") && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                return str.substring(4, str.length() - 1).trim();
            }
            throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
        }
        return (String) invokeLL.objValue;
    }

    public static int b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f2)) == null) {
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

    public static SVG.o c0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
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
        return (SVG.o) invokeL.objValue;
    }

    public static List<SVG.o> d0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static SVG.o e0(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, fVar)) == null) {
            if (fVar.f("auto")) {
                return new SVG.o(0.0f);
            }
            return fVar.o();
        }
        return (SVG.o) invokeL.objValue;
    }

    public static float f0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            float T = T(str);
            if (T < 0.0f) {
                return 0.0f;
            }
            if (T > 1.0f) {
                return 1.0f;
            }
            return T;
        }
        return invokeL.floatValue;
    }

    public static SVG.Style.FontStyle g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (SpanItem.STYLE_ITALIC.equals(str)) {
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
        return (SVG.Style.FontStyle) invokeL.objValue;
    }

    public static Boolean g0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (!TKBase.VISIBILITY_VISIBLE.equals(str) && !"auto".equals(str)) {
                if (!TKBase.VISIBILITY_HIDDEN.equals(str) && !"scroll".equals(str)) {
                    throw new SAXException("Invalid toverflow property: " + str);
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return (Boolean) invokeL.objValue;
    }

    public static SVG.m0 h0(String str, String str2) throws SAXException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, str2)) == null) {
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
        return (SVG.m0) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x028e, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SVG.v i0(String str) throws SAXException {
        InterceptResult invokeL;
        float t;
        float d2;
        float d3;
        float d4;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65559, null, str)) != null) {
            return (SVG.v) invokeL.objValue;
        }
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
                        d2 = Float.NaN;
                        t = Float.NaN;
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
                        String str2 = "Bad path coords for " + ((char) i3) + " path segment";
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
                    f6 = d4;
                    f7 = f3;
                    break;
                case 72:
                case 104:
                    float m3 = fVar.m();
                    if (Float.isNaN(m3)) {
                        String str3 = "Bad path coords for " + ((char) i3) + " path segment";
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
                        String str4 = "Bad path coords for " + ((char) i3) + " path segment";
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
                        String str5 = "Bad path coords for " + ((char) i3) + " path segment";
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
                    break;
                case 81:
                case 113:
                    f5 = fVar.m();
                    f7 = fVar.d(f5);
                    float d12 = fVar.d(f7);
                    float d13 = fVar.d(d12);
                    if (Float.isNaN(d13)) {
                        String str6 = "Bad path coords for " + ((char) i3) + " path segment";
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
                        String str7 = "Bad path coords for " + ((char) i3) + " path segment";
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
                    f6 = d4;
                    f7 = f3;
                    break;
                case 84:
                case 116:
                    f5 = (f4 * 2.0f) - f5;
                    f7 = (2.0f * f6) - f7;
                    float m7 = fVar.m();
                    float d15 = fVar.d(m7);
                    if (Float.isNaN(d15)) {
                        String str8 = "Bad path coords for " + ((char) i3) + " path segment";
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
                        String str9 = "Bad path coords for " + ((char) i3) + " path segment";
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, n0Var, str) == null) {
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
    }

    public static Set<String> k0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
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
        return (Set) invokeL.objValue;
    }

    public static Set<String> l0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            f fVar = new f(str);
            HashSet hashSet = new HashSet();
            while (!fVar.g()) {
                hashSet.add(fVar.q());
                fVar.w();
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static SVG.o[] m0(String str) throws SAXException {
        InterceptResult invokeL;
        SVG.o o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            f fVar = new f(str);
            fVar.w();
            if (fVar.g() || (o = fVar.o()) == null) {
                return null;
            }
            if (!o.h()) {
                float a2 = o.a();
                ArrayList arrayList = new ArrayList();
                arrayList.add(o);
                while (!fVar.g()) {
                    fVar.v();
                    SVG.o o2 = fVar.o();
                    if (o2 != null) {
                        if (!o2.h()) {
                            arrayList.add(o2);
                            a2 += o2.a();
                        } else {
                            throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
                        }
                    } else {
                        throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
                    }
                }
                if (a2 == 0.0f) {
                    return null;
                }
                return (SVG.o[]) arrayList.toArray(new SVG.o[arrayList.size()]);
            }
            throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
        }
        return (SVG.o[]) invokeL.objValue;
    }

    public static SVG.Style.LineCaps n0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
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
        return (SVG.Style.LineCaps) invokeL.objValue;
    }

    public static SVG.Style.LineJoin o0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
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
        return (SVG.Style.LineJoin) invokeL.objValue;
    }

    public static void p0(SVG.j0 j0Var, String str) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65566, null, j0Var, str) != null) {
            return;
        }
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
                if (j0Var.f53312f == null) {
                    j0Var.f53312f = new SVG.Style();
                }
                B0(j0Var.f53312f, r, r2);
                fVar.w();
            }
        }
    }

    public static Set<String> q0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
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
        return (Set) invokeL.objValue;
    }

    public static SVG.Style.TextAnchor r0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
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
        return (SVG.Style.TextAnchor) invokeL.objValue;
    }

    public static SVG.Style.TextDecoration s0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
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
        return (SVG.Style.TextDecoration) invokeL.objValue;
    }

    public static SVG.Style.TextDirection t0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if ("ltr".equals(str)) {
                return SVG.Style.TextDirection.LTR;
            }
            if ("rtl".equals(str)) {
                return SVG.Style.TextDirection.RTL;
            }
            throw new SAXException("Invalid direction property: " + str);
        }
        return (SVG.Style.TextDirection) invokeL.objValue;
    }

    public static SVG.Style.VectorEffect v0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if ("none".equals(str)) {
                return SVG.Style.VectorEffect.None;
            }
            if ("non-scaling-stroke".equals(str)) {
                return SVG.Style.VectorEffect.NonScalingStroke;
            }
            throw new SAXException("Invalid vector-effect property: " + str);
        }
        return (SVG.Style.VectorEffect) invokeL.objValue;
    }

    public static SVG.b w0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
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
        return (SVG.b) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c8, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(SVG.x xVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, xVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void A0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributes) == null) {
            d("<polyline>", new Object[0]);
            if (this.f53323b != null) {
                SVG.y yVar = new SVG.y();
                yVar.a = this.a;
                yVar.f53314b = this.f53323b;
                r(yVar, attributes);
                G(yVar, attributes);
                K(yVar, attributes);
                q(yVar, attributes);
                B(yVar, attributes, "polyline");
                this.f53323b.i(yVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void B(SVG.y yVar, Attributes attributes, String str) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, yVar, attributes, str) == null) {
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(SVG.o0 o0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, o0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void C0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributes) == null) {
            d("<radialGradient>", new Object[0]);
            if (this.f53323b != null) {
                SVG.o0 o0Var = new SVG.o0();
                o0Var.a = this.a;
                o0Var.f53314b = this.f53323b;
                r(o0Var, attributes);
                G(o0Var, attributes);
                t(o0Var, attributes);
                C(o0Var, attributes);
                this.f53323b.i(o0Var);
                this.f53323b = o0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void D(SVG.a0 a0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, a0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void D0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, attributes) == null) {
            d("<rect>", new Object[0]);
            if (this.f53323b != null) {
                SVG.a0 a0Var = new SVG.a0();
                a0Var.a = this.a;
                a0Var.f53314b = this.f53323b;
                r(a0Var, attributes);
                G(a0Var, attributes);
                K(a0Var, attributes);
                q(a0Var, attributes);
                D(a0Var, attributes);
                this.f53323b.i(a0Var);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void E(SVG.d0 d0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, d0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void E0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributes) == null) {
            d("<solidColor>", new Object[0]);
            if (this.f53323b != null) {
                SVG.b0 b0Var = new SVG.b0();
                b0Var.a = this.a;
                b0Var.f53314b = this.f53323b;
                r(b0Var, attributes);
                G(b0Var, attributes);
                this.f53323b.i(b0Var);
                this.f53323b = b0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void F(SVG.c0 c0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, c0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                if (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 37) {
                    c0Var.f53297h = b0(trim);
                }
            }
        }
    }

    public final void F0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, attributes) == null) {
            d("<stop>", new Object[0]);
            SVG.h0 h0Var = this.f53323b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.j) {
                    SVG.c0 c0Var = new SVG.c0();
                    c0Var.a = this.a;
                    c0Var.f53314b = this.f53323b;
                    r(c0Var, attributes);
                    G(c0Var, attributes);
                    F(c0Var, attributes);
                    this.f53323b.i(c0Var);
                    this.f53323b = c0Var;
                    return;
                }
                throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void G(SVG.j0 j0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, j0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                if (trim.length() != 0) {
                    int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                    if (i3 == 45) {
                        p0(j0Var, trim);
                    } else if (i3 != 46) {
                        if (j0Var.f53311e == null) {
                            j0Var.f53311e = new SVG.Style();
                        }
                        B0(j0Var.f53311e, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                    } else {
                        j0Var.f53313g = CSSParser.f(trim);
                    }
                }
            }
        }
    }

    public final void G0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, attributes) == null) {
            d("<style>", new Object[0]);
            if (this.f53323b != null) {
                String str = "all";
                boolean z = true;
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    String trim = attributes.getValue(i2).trim();
                    int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                    if (i3 == 87) {
                        z = trim.equals("text/css");
                    } else if (i3 == 88) {
                        str = trim;
                    }
                }
                if (z && CSSParser.b(str, CSSParser.MediaType.screen)) {
                    this.f53329h = true;
                    return;
                }
                this.f53324c = true;
                this.f53325d = 1;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void H(SVG.s0 s0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, s0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                if (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 6 && "http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                    s0Var.n = trim;
                }
            }
        }
    }

    public final void H0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, attributes) == null) {
            d("<svg>", new Object[0]);
            SVG.d0 d0Var = new SVG.d0();
            d0Var.a = this.a;
            d0Var.f53314b = this.f53323b;
            r(d0Var, attributes);
            G(d0Var, attributes);
            q(d0Var, attributes);
            M(d0Var, attributes);
            E(d0Var, attributes);
            SVG.h0 h0Var = this.f53323b;
            if (h0Var == null) {
                this.a.p(d0Var);
            } else {
                h0Var.i(d0Var);
            }
            this.f53323b = d0Var;
        }
    }

    public final void I(SVG.x0 x0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, x0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 != 6) {
                    if (i3 == 39) {
                        x0Var.o = c0(trim);
                    }
                } else if ("http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                    x0Var.n = trim;
                }
            }
        }
    }

    public final void I0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, attributes) == null) {
            d("<symbol>", new Object[0]);
            if (this.f53323b != null) {
                SVG.p0 r0Var = new SVG.r0();
                r0Var.a = this.a;
                r0Var.f53314b = this.f53323b;
                r(r0Var, attributes);
                G(r0Var, attributes);
                q(r0Var, attributes);
                M(r0Var, attributes);
                this.f53323b.i(r0Var);
                this.f53323b = r0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void J(SVG.y0 y0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, y0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void J0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, attributes) == null) {
            d("<text>", new Object[0]);
            if (this.f53323b != null) {
                SVG.u0 u0Var = new SVG.u0();
                u0Var.a = this.a;
                u0Var.f53314b = this.f53323b;
                r(u0Var, attributes);
                G(u0Var, attributes);
                K(u0Var, attributes);
                q(u0Var, attributes);
                J(u0Var, attributes);
                this.f53323b.i(u0Var);
                this.f53323b = u0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void K(SVG.m mVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, mVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.transform) {
                    mVar.l(u0(attributes.getValue(i2)));
                }
            }
        }
    }

    public final void K0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, attributes) == null) {
            d("<textPath>", new Object[0]);
            if (this.f53323b != null) {
                SVG.x0 x0Var = new SVG.x0();
                x0Var.a = this.a;
                x0Var.f53314b = this.f53323b;
                r(x0Var, attributes);
                G(x0Var, attributes);
                q(x0Var, attributes);
                I(x0Var, attributes);
                this.f53323b.i(x0Var);
                this.f53323b = x0Var;
                SVG.h0 h0Var = x0Var.f53314b;
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
    }

    public final void L(SVG.b1 b1Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, b1Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void L0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, attributes) == null) {
            d("<tref>", new Object[0]);
            SVG.h0 h0Var = this.f53323b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.w0) {
                    SVG.s0 s0Var = new SVG.s0();
                    s0Var.a = this.a;
                    s0Var.f53314b = this.f53323b;
                    r(s0Var, attributes);
                    G(s0Var, attributes);
                    q(s0Var, attributes);
                    H(s0Var, attributes);
                    this.f53323b.i(s0Var);
                    SVG.h0 h0Var2 = s0Var.f53314b;
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
    }

    public final void M(SVG.p0 p0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, p0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 7) {
                    j0(p0Var, trim);
                } else if (i3 == 86) {
                    p0Var.o = w0(trim);
                }
            }
        }
    }

    public final void M0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, attributes) == null) {
            d("<tspan>", new Object[0]);
            SVG.h0 h0Var = this.f53323b;
            if (h0Var != null) {
                if (h0Var instanceof SVG.w0) {
                    SVG.t0 t0Var = new SVG.t0();
                    t0Var.a = this.a;
                    t0Var.f53314b = this.f53323b;
                    r(t0Var, attributes);
                    G(t0Var, attributes);
                    q(t0Var, attributes);
                    J(t0Var, attributes);
                    this.f53323b.i(t0Var);
                    this.f53323b = t0Var;
                    SVG.h0 h0Var2 = t0Var.f53314b;
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
    }

    public final void N(String str) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.a.a(new CSSParser(CSSParser.MediaType.screen).d(str));
        }
    }

    public final void N0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, attributes) == null) {
            d("<use>", new Object[0]);
            if (this.f53323b != null) {
                SVG.b1 b1Var = new SVG.b1();
                b1Var.a = this.a;
                b1Var.f53314b = this.f53323b;
                r(b1Var, attributes);
                G(b1Var, attributes);
                K(b1Var, attributes);
                q(b1Var, attributes);
                L(b1Var, attributes);
                this.f53323b.i(b1Var);
                this.f53323b = b1Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void O0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, attributes) == null) {
            d("<view>", new Object[0]);
            if (this.f53323b != null) {
                SVG.p0 c1Var = new SVG.c1();
                c1Var.a = this.a;
                c1Var.f53314b = this.f53323b;
                r(c1Var, attributes);
                q(c1Var, attributes);
                M(c1Var, attributes);
                this.f53323b.i(c1Var);
                this.f53323b = c1Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void P0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, attributes) == null) {
            d("<switch>", new Object[0]);
            if (this.f53323b != null) {
                SVG.q0 q0Var = new SVG.q0();
                q0Var.a = this.a;
                q0Var.f53314b = this.f53323b;
                r(q0Var, attributes);
                G(q0Var, attributes);
                K(q0Var, attributes);
                q(q0Var, attributes);
                this.f53323b.i(q0Var);
                this.f53323b = q0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void a(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, attributes) == null) {
            d("<circle>", new Object[0]);
            if (this.f53323b != null) {
                SVG.d dVar = new SVG.d();
                dVar.a = this.a;
                dVar.f53314b = this.f53323b;
                r(dVar, attributes);
                G(dVar, attributes);
                K(dVar, attributes);
                q(dVar, attributes);
                o(dVar, attributes);
                this.f53323b.i(dVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final Float b0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
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
        return (Float) invokeL.objValue;
    }

    public final void c(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, attributes) == null) {
            d("<clipPath>", new Object[0]);
            if (this.f53323b != null) {
                SVG.e eVar = new SVG.e();
                eVar.a = this.a;
                eVar.f53314b = this.f53323b;
                r(eVar, attributes);
                G(eVar, attributes);
                K(eVar, attributes);
                q(eVar, attributes);
                p(eVar, attributes);
                this.f53323b.i(eVar);
                this.f53323b = eVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) throws SAXException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048608, this, cArr, i2, i3) == null) || this.f53324c) {
            return;
        }
        if (this.f53326e) {
            if (this.f53328g == null) {
                this.f53328g = new StringBuilder(i3);
            }
            this.f53328g.append(cArr, i2, i3);
        } else if (this.f53329h) {
            if (this.f53330i == null) {
                this.f53330i = new StringBuilder(i3);
            }
            this.f53330i.append(cArr, i2, i3);
        } else {
            SVG.h0 h0Var = this.f53323b;
            if (h0Var instanceof SVG.w0) {
                SVG.f0 f0Var = (SVG.f0) h0Var;
                int size = f0Var.f53300i.size();
                SVG.l0 l0Var = size == 0 ? null : f0Var.f53300i.get(size - 1);
                if (l0Var instanceof SVG.a1) {
                    StringBuilder sb = new StringBuilder();
                    SVG.a1 a1Var = (SVG.a1) l0Var;
                    sb.append(a1Var.f53288c);
                    sb.append(new String(cArr, i2, i3));
                    a1Var.f53288c = sb.toString();
                    return;
                }
                ((SVG.f0) this.f53323b).i(new SVG.a1(new String(cArr, i2, i3)));
            }
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i2, int i3) throws SAXException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048609, this, cArr, i2, i3) == null) && !this.f53324c && this.f53329h) {
            if (this.f53330i == null) {
                this.f53330i = new StringBuilder(i3);
            }
            this.f53330i.append(cArr, i2, i3);
        }
    }

    public final void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, str, objArr) == null) {
        }
    }

    public final void e(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, attributes) == null) {
            d("<defs>", new Object[0]);
            if (this.f53323b != null) {
                SVG.h hVar = new SVG.h();
                hVar.a = this.a;
                hVar.f53314b = this.f53323b;
                r(hVar, attributes);
                G(hVar, attributes);
                K(hVar, attributes);
                this.f53323b.i(hVar);
                this.f53323b = hVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, str, str2, str3) == null) {
            if (this.f53324c) {
                int i2 = this.f53325d - 1;
                this.f53325d = i2;
                if (i2 == 0) {
                    this.f53324c = false;
                    return;
                }
            }
            if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
                int i3 = a.a[SVGElem.fromString(str2).ordinal()];
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
                            this.f53326e = false;
                            SVGElem sVGElem = this.f53327f;
                            if (sVGElem == SVGElem.title) {
                                this.a.q(this.f53328g.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.a.o(this.f53328g.toString());
                            }
                            this.f53328g.setLength(0);
                            return;
                        case 30:
                            StringBuilder sb = this.f53330i;
                            if (sb != null) {
                                this.f53329h = false;
                                N(sb.toString());
                                this.f53330i.setLength(0);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                this.f53323b = ((SVG.l0) this.f53323b).f53314b;
            }
        }
    }

    public final void f(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, attributes) == null) {
            d("<ellipse>", new Object[0]);
            if (this.f53323b != null) {
                SVG.i iVar = new SVG.i();
                iVar.a = this.a;
                iVar.f53314b = this.f53323b;
                r(iVar, attributes);
                G(iVar, attributes);
                K(iVar, attributes);
                q(iVar, attributes);
                s(iVar, attributes);
                this.f53323b.i(iVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void h(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, attributes) == null) {
            d("<g>", new Object[0]);
            if (this.f53323b != null) {
                SVG.l lVar = new SVG.l();
                lVar.a = this.a;
                lVar.f53314b = this.f53323b;
                r(lVar, attributes);
                G(lVar, attributes);
                K(lVar, attributes);
                q(lVar, attributes);
                this.f53323b.i(lVar);
                this.f53323b = lVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void i(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, attributes) == null) {
            d("<image>", new Object[0]);
            if (this.f53323b != null) {
                SVG.n nVar = new SVG.n();
                nVar.a = this.a;
                nVar.f53314b = this.f53323b;
                r(nVar, attributes);
                G(nVar, attributes);
                K(nVar, attributes);
                q(nVar, attributes);
                u(nVar, attributes);
                this.f53323b.i(nVar);
                this.f53323b = nVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void j(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, attributes) == null) {
            d("<line>", new Object[0]);
            if (this.f53323b != null) {
                SVG.p pVar = new SVG.p();
                pVar.a = this.a;
                pVar.f53314b = this.f53323b;
                r(pVar, attributes);
                G(pVar, attributes);
                K(pVar, attributes);
                q(pVar, attributes);
                v(pVar, attributes);
                this.f53323b.i(pVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void k(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, attributes) == null) {
            d("<linearGradiant>", new Object[0]);
            if (this.f53323b != null) {
                SVG.k0 k0Var = new SVG.k0();
                k0Var.a = this.a;
                k0Var.f53314b = this.f53323b;
                r(k0Var, attributes);
                G(k0Var, attributes);
                t(k0Var, attributes);
                w(k0Var, attributes);
                this.f53323b.i(k0Var);
                this.f53323b = k0Var;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void l(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, attributes) == null) {
            d("<marker>", new Object[0]);
            if (this.f53323b != null) {
                SVG.q qVar = new SVG.q();
                qVar.a = this.a;
                qVar.f53314b = this.f53323b;
                r(qVar, attributes);
                G(qVar, attributes);
                q(qVar, attributes);
                M(qVar, attributes);
                x(qVar, attributes);
                this.f53323b.i(qVar);
                this.f53323b = qVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void m(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, attributes) == null) {
            d("<mask>", new Object[0]);
            if (this.f53323b != null) {
                SVG.r rVar = new SVG.r();
                rVar.a = this.a;
                rVar.f53314b = this.f53323b;
                r(rVar, attributes);
                G(rVar, attributes);
                q(rVar, attributes);
                y(rVar, attributes);
                this.f53323b.i(rVar);
                this.f53323b = rVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public SVG n(InputStream inputStream) throws SVGParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, inputStream)) == null) {
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
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this);
                    xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                    xMLReader.parse(new InputSource(inputStream));
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                    return this.a;
                } catch (IOException e2) {
                    throw new SVGParseException("File error", e2);
                } catch (ParserConfigurationException e3) {
                    throw new SVGParseException("XML Parser problem", e3);
                } catch (SAXException e4) {
                    throw new SVGParseException("SVG parse error: " + e4.getMessage(), e4);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
        return (SVG) invokeL.objValue;
    }

    public final void o(SVG.d dVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, dVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
    }

    public final void p(SVG.e eVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, eVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                if (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 38) {
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
    }

    public final void q(SVG.e0 e0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, e0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
    }

    public final void r(SVG.j0 j0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, j0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String qName = attributes.getQName(i2);
                if (!qName.equals("id") && !qName.equals("xml:id")) {
                    if (qName.equals("xml:space")) {
                        String trim = attributes.getValue(i2).trim();
                        if ("default".equals(trim)) {
                            j0Var.f53310d = Boolean.FALSE;
                            return;
                        } else if ("preserve".equals(trim)) {
                            j0Var.f53310d = Boolean.TRUE;
                            return;
                        } else {
                            throw new SAXException("Invalid value for \"xml:space\" attribute: " + trim);
                        }
                    }
                } else {
                    j0Var.f53309c = attributes.getValue(i2).trim();
                    return;
                }
            }
        }
    }

    public final void s(SVG.i iVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, iVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.a = new SVG();
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048628, this, str, str2, str3, attributes) == null) {
            if (this.f53324c) {
                this.f53325d++;
            } else if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
                SVGElem fromString = SVGElem.fromString(str2);
                switch (a.a[fromString.ordinal()]) {
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
                        this.f53326e = true;
                        this.f53327f = fromString;
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
                        this.f53324c = true;
                        this.f53325d = 1;
                        return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(SVG.j jVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, jVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 != 6) {
                    switch (i3) {
                        case 32:
                            if ("objectBoundingBox".equals(trim)) {
                                jVar.f53307i = Boolean.FALSE;
                                continue;
                            } else if ("userSpaceOnUse".equals(trim)) {
                                jVar.f53307i = Boolean.TRUE;
                                break;
                            } else {
                                throw new SAXException("Invalid value for attribute gradientUnits");
                            }
                        case 33:
                            jVar.f53308j = u0(trim);
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
    }

    public final void u(SVG.n nVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, nVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final Matrix u0(String str) throws SAXException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
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
                    } else if (n.equals(AnimationProperty.TRANSLATE)) {
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
                    } else if (n.equals(AnimationProperty.SCALE)) {
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
                    } else if (n.equals(AnimationProperty.ROTATE)) {
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
        return (Matrix) invokeL.objValue;
    }

    public final void v(SVG.p pVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, pVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
    }

    public final void w(SVG.k0 k0Var, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, k0Var, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
    }

    public final void x(SVG.q qVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, qVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                switch (a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
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
                        if ("auto".equals(trim)) {
                            qVar.u = Float.valueOf(Float.NaN);
                            break;
                        } else {
                            qVar.u = Float.valueOf(T(trim));
                            break;
                        }
                }
            }
        }
    }

    public final void x0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, attributes) == null) {
            d("<path>", new Object[0]);
            if (this.f53323b != null) {
                SVG.u uVar = new SVG.u();
                uVar.a = this.a;
                uVar.f53314b = this.f53323b;
                r(uVar, attributes);
                G(uVar, attributes);
                K(uVar, attributes);
                q(uVar, attributes);
                z(uVar, attributes);
                this.f53323b.i(uVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void y(SVG.r rVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, rVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void y0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, attributes) == null) {
            d("<pattern>", new Object[0]);
            if (this.f53323b != null) {
                SVG.x xVar = new SVG.x();
                xVar.a = this.a;
                xVar.f53314b = this.f53323b;
                r(xVar, attributes);
                G(xVar, attributes);
                q(xVar, attributes);
                M(xVar, attributes);
                A(xVar, attributes);
                this.f53323b.i(xVar);
                this.f53323b = xVar;
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }

    public final void z(SVG.u uVar, Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, uVar, attributes) == null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = a.f53334b[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
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
    }

    public final void z0(Attributes attributes) throws SAXException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, attributes) == null) {
            d("<polygon>", new Object[0]);
            if (this.f53323b != null) {
                SVG.y zVar = new SVG.z();
                zVar.a = this.a;
                zVar.f53314b = this.f53323b;
                r(zVar, attributes);
                G(zVar, attributes);
                K(zVar, attributes);
                q(zVar, attributes);
                B(zVar, attributes, "polygon");
                this.f53323b.i(zVar);
                return;
            }
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
    }
}
