package com.tachikoma.core.layout;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.mirror.Frame;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaDirection;
import com.kwad.yoga.YogaDisplay;
import com.kwad.yoga.YogaEdge;
import com.kwad.yoga.YogaFlexDirection;
import com.kwad.yoga.YogaJustify;
import com.kwad.yoga.YogaNode;
import com.kwad.yoga.YogaOverflow;
import com.kwad.yoga.YogaPositionType;
import com.kwad.yoga.YogaWrap;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.utility.TKConverter;
import com.tachikoma.core.utility.TKFlexible;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class TKYogaConfig {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> NON_DP_CONVERT_KEYS;
    public static final Map alignMap;
    public static final Map directionMap;
    public static final Map displayMap;
    public static final Map flexDirectMap;
    public static final Map justifyMap;
    public static final Map overflowMap;
    public static final Map positionTypeMap;
    public static final Map<String, Pattern> sPatternMapCache;
    public static final Map styleMap;
    public static final Map wrapMap;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap yogaConfig;

    /* loaded from: classes8.dex */
    public static class TKYogaConfigHolder {
        public static /* synthetic */ Interceptable $ic;
        public static TKYogaConfig instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-985268070, "Lcom/tachikoma/core/layout/TKYogaConfig$TKYogaConfigHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-985268070, "Lcom/tachikoma/core/layout/TKYogaConfig$TKYogaConfigHolder;");
                    return;
                }
            }
            instance = new TKYogaConfig();
        }

        public TKYogaConfigHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(302302243, "Lcom/tachikoma/core/layout/TKYogaConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(302302243, "Lcom/tachikoma/core/layout/TKYogaConfig;");
                return;
            }
        }
        sPatternMapCache = new ConcurrentHashMap();
        flexDirectMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(Frame.COLUMN, Integer.valueOf(YogaFlexDirection.COLUMN.ordinal()));
                put("column-reverse", Integer.valueOf(YogaFlexDirection.COLUMN_REVERSE.ordinal()));
                put("row", Integer.valueOf(YogaFlexDirection.ROW.ordinal()));
                put("row-reverse", Integer.valueOf(YogaFlexDirection.ROW_REVERSE.ordinal()));
            }
        };
        overflowMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(TKBase.VISIBILITY_HIDDEN, Integer.valueOf(YogaOverflow.HIDDEN.ordinal()));
                put("scroll", Integer.valueOf(YogaOverflow.SCROLL.ordinal()));
                put(TKBase.VISIBILITY_VISIBLE, Integer.valueOf(YogaOverflow.VISIBLE.ordinal()));
            }
        };
        wrapMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("wrap", Integer.valueOf(YogaWrap.WRAP.ordinal()));
                put("wrap-reverse", Integer.valueOf(YogaWrap.WRAP_REVERSE.ordinal()));
                put("nowrap", Integer.valueOf(YogaWrap.NO_WRAP.ordinal()));
            }
        };
        directionMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("left", Integer.valueOf(YogaDirection.LTR.ordinal()));
                put("right", Integer.valueOf(YogaDirection.RTL.ordinal()));
                put("inherit", Integer.valueOf(YogaDirection.INHERIT.ordinal()));
            }
        };
        justifyMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("flex-start", Integer.valueOf(YogaJustify.FLEX_START.ordinal()));
                put("center", Integer.valueOf(YogaJustify.CENTER.ordinal()));
                put("flex-end", Integer.valueOf(YogaJustify.FLEX_END.ordinal()));
                put("space-between", Integer.valueOf(YogaJustify.SPACE_BETWEEN.ordinal()));
                put("space-around", Integer.valueOf(YogaJustify.SPACE_AROUND.ordinal()));
            }
        };
        positionTypeMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("absolute", Integer.valueOf(YogaPositionType.ABSOLUTE.ordinal()));
                put("relative", Integer.valueOf(YogaPositionType.RELATIVE.ordinal()));
                put("static", Integer.valueOf(YogaPositionType.RELATIVE.ordinal()));
            }
        };
        alignMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("auto", Integer.valueOf(YogaAlign.AUTO.ordinal()));
                put("flex-start", Integer.valueOf(YogaAlign.FLEX_START.ordinal()));
                put("center", Integer.valueOf(YogaAlign.CENTER.ordinal()));
                put("flex-end", Integer.valueOf(YogaAlign.FLEX_END.ordinal()));
                put("stretch", Integer.valueOf(YogaAlign.STRETCH.ordinal()));
                put("baseline", Integer.valueOf(YogaAlign.BASELINE.ordinal()));
                put("space-between", Integer.valueOf(YogaAlign.SPACE_BETWEEN.ordinal()));
                put("space-around", Integer.valueOf(YogaAlign.SPACE_AROUND.ordinal()));
            }
        };
        displayMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("flex", Integer.valueOf(YogaDisplay.FLEX.ordinal()));
                put("none", Integer.valueOf(YogaDisplay.NONE.ordinal()));
            }
        };
        styleMap = new HashMap() { // from class: com.tachikoma.core.layout.TKYogaConfig.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("alignContent", 0);
                put("alignItems", 1);
                put("alignSelf", 2);
                put("aspectRatio", 3);
                put("borderAll", 4);
                put("borderBottom", 5);
                put("borderEnd", 6);
                put("borderHorizontal", 7);
                put("borderLeft", 8);
                put("borderRight", 9);
                put("borderStart", 10);
                put("borderTop", 11);
                put("borderVertical", 12);
                put("direction", 13);
                put("display", 14);
                put("flex", 15);
                put("flexBasis", 16);
                put("flexDirection", 17);
                put("flexGrow", 18);
                put("flexShrink", 19);
                put("height", 20);
                put("justifyContent", 21);
                put("marginAll", 22);
                put(AnimationProperty.MARGIN, 22);
                put(AnimationProperty.MARGIN_BOTTOM, 23);
                put("marginEnd", 24);
                put("marginHorizontal", 25);
                put(AnimationProperty.MARGIN_LEFT, 26);
                put(AnimationProperty.MARGIN_RIGHT, 27);
                put("marginStart", 28);
                put(AnimationProperty.MARGIN_TOP, 29);
                put("marginVertical", 30);
                put("maxHeight", 31);
                put("maxWidth", 32);
                put("minHeight", 33);
                put("minWidth", 34);
                put("overflow", 35);
                put("paddingAll", 36);
                put("paddingBottom", 37);
                put("paddingEnd", 38);
                put("paddingHorizontal", 39);
                put("paddingLeft", 40);
                put("paddingRight", 41);
                put("paddingStart", 42);
                put("paddingTop", 43);
                put("paddingVertical", 44);
                put("positionAll", 45);
                put("positionBottom", 46);
                put("positionEnd", 47);
                put("positionHorizontal", 48);
                put("positionLeft", 49);
                put("positionRight", 50);
                put("positionStart", 51);
                put("positionTop", 52);
                put("bottom", 46);
                put("end", 47);
                put("left", 49);
                put("right", 50);
                put("start", 51);
                put("top", 52);
                put("positionType", 53);
                put("position", 53);
                put("positionVertical", 54);
                put("width", 55);
                put("flexWrap", 56);
            }
        };
        NON_DP_CONVERT_KEYS = new ArrayList<String>() { // from class: com.tachikoma.core.layout.TKYogaConfig.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("opacity");
                add("maxLength");
                add("textLineClamp");
                add(Frame.COLUMN);
            }
        };
    }

    public TKYogaConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.yogaConfig = new HashMap();
    }

    public static void applyLayoutBackgroudParams(YogaNode yogaNode, TKBase tKBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, yogaNode, tKBase) == null) {
            if (Build.VERSION.SDK_INT >= 17 && tKBase.getView().getResources().getConfiguration().getLayoutDirection() == 1) {
                yogaNode.setDirection(YogaDirection.RTL);
            }
            Drawable background = tKBase.getView().getBackground();
            if (background != null) {
                Rect rect = new Rect();
                if (background.getPadding(rect)) {
                    yogaNode.setPadding(YogaEdge.LEFT, rect.left);
                    yogaNode.setPadding(YogaEdge.TOP, rect.top);
                    yogaNode.setPadding(YogaEdge.RIGHT, rect.right);
                    yogaNode.setPadding(YogaEdge.BOTTOM, rect.bottom);
                }
            }
        }
    }

    public static void applyLayoutParams(YogaNode yogaNode, String str, Object obj) {
        int ygPropertyWithCSSStyle;
        YogaEdge yogaEdge;
        YogaEdge yogaEdge2;
        YogaEdge yogaEdge3;
        YogaEdge yogaEdge4;
        YogaEdge yogaEdge5;
        YogaEdge yogaEdge6;
        YogaEdge yogaEdge7;
        YogaEdge yogaEdge8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yogaNode, str, obj) == null) || (ygPropertyWithCSSStyle = defaultConfig().ygPropertyWithCSSStyle(str)) == Integer.MAX_VALUE) {
            return;
        }
        float formatNumber = formatNumber(ygPropertyWithCSSStyle, obj);
        boolean isPercentageNumeric = isPercentageNumeric(obj);
        boolean isAutoNumeric = isAutoNumeric(obj);
        if (formatNumber == 2.1474836E9f) {
            return;
        }
        if (!isPercentageNumeric && !isAutoNumeric) {
            if (ygPropertyWithCSSStyle == 0) {
                yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(formatNumber)));
            } else if (ygPropertyWithCSSStyle == 1) {
                yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(formatNumber)));
            } else if (ygPropertyWithCSSStyle == 2) {
                yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(formatNumber)));
            } else if (ygPropertyWithCSSStyle == 3) {
                yogaNode.setAspectRatio(formatNumber);
            } else {
                if (ygPropertyWithCSSStyle == 8) {
                    yogaEdge8 = YogaEdge.LEFT;
                } else if (ygPropertyWithCSSStyle == 11) {
                    yogaEdge8 = YogaEdge.TOP;
                } else if (ygPropertyWithCSSStyle == 9) {
                    yogaEdge8 = YogaEdge.RIGHT;
                } else if (ygPropertyWithCSSStyle == 5) {
                    yogaEdge8 = YogaEdge.BOTTOM;
                } else if (ygPropertyWithCSSStyle == 10) {
                    yogaEdge8 = YogaEdge.START;
                } else if (ygPropertyWithCSSStyle == 6) {
                    yogaEdge8 = YogaEdge.END;
                } else if (ygPropertyWithCSSStyle == 7) {
                    yogaEdge8 = YogaEdge.HORIZONTAL;
                } else if (ygPropertyWithCSSStyle == 12) {
                    yogaEdge8 = YogaEdge.VERTICAL;
                } else if (ygPropertyWithCSSStyle == 4) {
                    yogaEdge8 = YogaEdge.ALL;
                } else if (ygPropertyWithCSSStyle == 13) {
                    yogaNode.setDirection(YogaDirection.fromInt(Math.round(formatNumber)));
                } else if (ygPropertyWithCSSStyle == 14) {
                    yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(formatNumber)));
                } else if (ygPropertyWithCSSStyle == 15) {
                    yogaNode.setFlex(formatNumber);
                } else if (ygPropertyWithCSSStyle == 16) {
                    yogaNode.setFlexBasis(formatNumber);
                } else if (ygPropertyWithCSSStyle == 17) {
                    yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(formatNumber)));
                } else if (ygPropertyWithCSSStyle == 18) {
                    yogaNode.setFlexGrow(formatNumber);
                } else if (ygPropertyWithCSSStyle == 19) {
                    yogaNode.setFlexShrink(formatNumber);
                } else if (ygPropertyWithCSSStyle == 20) {
                    yogaNode.setHeight(formatNumber);
                } else {
                    if (ygPropertyWithCSSStyle == 26) {
                        yogaEdge7 = YogaEdge.LEFT;
                    } else if (ygPropertyWithCSSStyle == 21) {
                        yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(formatNumber)));
                    } else if (ygPropertyWithCSSStyle == 29) {
                        yogaEdge7 = YogaEdge.TOP;
                    } else if (ygPropertyWithCSSStyle == 27) {
                        yogaEdge7 = YogaEdge.RIGHT;
                    } else if (ygPropertyWithCSSStyle == 23) {
                        yogaEdge7 = YogaEdge.BOTTOM;
                    } else if (ygPropertyWithCSSStyle == 28) {
                        yogaEdge7 = YogaEdge.START;
                    } else if (ygPropertyWithCSSStyle == 24) {
                        yogaEdge7 = YogaEdge.END;
                    } else if (ygPropertyWithCSSStyle == 25) {
                        yogaEdge7 = YogaEdge.HORIZONTAL;
                    } else if (ygPropertyWithCSSStyle == 30) {
                        yogaEdge7 = YogaEdge.VERTICAL;
                    } else if (ygPropertyWithCSSStyle == 22) {
                        yogaEdge7 = YogaEdge.ALL;
                    } else if (ygPropertyWithCSSStyle == 31) {
                        yogaNode.setMaxHeight(formatNumber);
                    } else if (ygPropertyWithCSSStyle == 32) {
                        yogaNode.setMaxWidth(formatNumber);
                    } else if (ygPropertyWithCSSStyle == 33) {
                        yogaNode.setMinHeight(formatNumber);
                    } else if (ygPropertyWithCSSStyle == 34) {
                        yogaNode.setMinWidth(formatNumber);
                    } else {
                        if (ygPropertyWithCSSStyle == 40) {
                            yogaEdge6 = YogaEdge.LEFT;
                        } else if (ygPropertyWithCSSStyle == 43) {
                            yogaEdge6 = YogaEdge.TOP;
                        } else if (ygPropertyWithCSSStyle == 41) {
                            yogaEdge6 = YogaEdge.RIGHT;
                        } else if (ygPropertyWithCSSStyle == 37) {
                            yogaEdge6 = YogaEdge.BOTTOM;
                        } else if (ygPropertyWithCSSStyle == 42) {
                            yogaEdge6 = YogaEdge.START;
                        } else if (ygPropertyWithCSSStyle == 38) {
                            yogaEdge6 = YogaEdge.END;
                        } else if (ygPropertyWithCSSStyle == 39) {
                            yogaEdge6 = YogaEdge.HORIZONTAL;
                        } else if (ygPropertyWithCSSStyle == 44) {
                            yogaEdge6 = YogaEdge.VERTICAL;
                        } else if (ygPropertyWithCSSStyle == 36) {
                            yogaEdge6 = YogaEdge.ALL;
                        } else {
                            if (ygPropertyWithCSSStyle == 49) {
                                yogaEdge5 = YogaEdge.LEFT;
                            } else if (ygPropertyWithCSSStyle == 52) {
                                yogaEdge5 = YogaEdge.TOP;
                            } else if (ygPropertyWithCSSStyle == 50) {
                                yogaEdge5 = YogaEdge.RIGHT;
                            } else if (ygPropertyWithCSSStyle == 46) {
                                yogaEdge5 = YogaEdge.BOTTOM;
                            } else if (ygPropertyWithCSSStyle == 51) {
                                yogaEdge5 = YogaEdge.START;
                            } else if (ygPropertyWithCSSStyle == 47) {
                                yogaEdge5 = YogaEdge.END;
                            } else if (ygPropertyWithCSSStyle == 48) {
                                yogaEdge5 = YogaEdge.HORIZONTAL;
                            } else if (ygPropertyWithCSSStyle == 54) {
                                yogaEdge5 = YogaEdge.VERTICAL;
                            } else if (ygPropertyWithCSSStyle == 45) {
                                yogaEdge5 = YogaEdge.ALL;
                            } else if (ygPropertyWithCSSStyle == 53) {
                                yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(formatNumber)));
                            } else if (ygPropertyWithCSSStyle == 55) {
                                yogaNode.setWidth(formatNumber);
                            } else if (ygPropertyWithCSSStyle == 56) {
                                yogaNode.setWrap(YogaWrap.fromInt(Math.round(formatNumber)));
                            }
                            yogaNode.setPosition(yogaEdge5, formatNumber);
                        }
                        yogaNode.setPadding(yogaEdge6, formatNumber);
                    }
                    yogaNode.setMargin(yogaEdge7, formatNumber);
                }
                yogaNode.setBorder(yogaEdge8, formatNumber);
            }
        }
        if (isAutoNumeric) {
            if (ygPropertyWithCSSStyle == 16) {
                yogaNode.setFlexBasisAuto();
            } else if (ygPropertyWithCSSStyle == 20) {
                yogaNode.setHeightAuto();
            } else {
                if (ygPropertyWithCSSStyle == 26) {
                    yogaEdge4 = YogaEdge.LEFT;
                } else if (ygPropertyWithCSSStyle == 29) {
                    yogaEdge4 = YogaEdge.TOP;
                } else if (ygPropertyWithCSSStyle == 27) {
                    yogaEdge4 = YogaEdge.RIGHT;
                } else if (ygPropertyWithCSSStyle == 23) {
                    yogaEdge4 = YogaEdge.BOTTOM;
                } else if (ygPropertyWithCSSStyle == 28) {
                    yogaEdge4 = YogaEdge.START;
                } else if (ygPropertyWithCSSStyle == 24) {
                    yogaEdge4 = YogaEdge.END;
                } else if (ygPropertyWithCSSStyle == 25) {
                    yogaEdge4 = YogaEdge.HORIZONTAL;
                } else if (ygPropertyWithCSSStyle == 30) {
                    yogaEdge4 = YogaEdge.VERTICAL;
                } else if (ygPropertyWithCSSStyle == 22) {
                    yogaEdge4 = YogaEdge.ALL;
                } else if (ygPropertyWithCSSStyle == 55) {
                    yogaNode.setWidthAuto();
                }
                yogaNode.setMarginAuto(yogaEdge4);
            }
        }
        if (isPercentageNumeric) {
            if (ygPropertyWithCSSStyle == 16) {
                yogaNode.setFlexBasisPercent(formatNumber);
            } else if (ygPropertyWithCSSStyle == 20) {
                yogaNode.setHeightPercent(formatNumber);
            } else {
                if (ygPropertyWithCSSStyle == 26) {
                    yogaEdge3 = YogaEdge.LEFT;
                } else if (ygPropertyWithCSSStyle == 29) {
                    yogaEdge3 = YogaEdge.TOP;
                } else if (ygPropertyWithCSSStyle == 27) {
                    yogaEdge3 = YogaEdge.RIGHT;
                } else if (ygPropertyWithCSSStyle == 23) {
                    yogaEdge3 = YogaEdge.BOTTOM;
                } else if (ygPropertyWithCSSStyle == 28) {
                    yogaEdge3 = YogaEdge.START;
                } else if (ygPropertyWithCSSStyle == 24) {
                    yogaEdge3 = YogaEdge.END;
                } else if (ygPropertyWithCSSStyle == 25) {
                    yogaEdge3 = YogaEdge.HORIZONTAL;
                } else if (ygPropertyWithCSSStyle == 30) {
                    yogaEdge3 = YogaEdge.VERTICAL;
                } else if (ygPropertyWithCSSStyle != 22) {
                    if (ygPropertyWithCSSStyle == 55) {
                        yogaNode.setWidthPercent(formatNumber);
                        return;
                    } else if (ygPropertyWithCSSStyle == 31) {
                        yogaNode.setMaxHeightPercent(formatNumber);
                        return;
                    } else if (ygPropertyWithCSSStyle == 32) {
                        yogaNode.setMaxWidthPercent(formatNumber);
                        return;
                    } else if (ygPropertyWithCSSStyle == 33) {
                        yogaNode.setMinHeightPercent(formatNumber);
                        return;
                    } else if (ygPropertyWithCSSStyle == 34) {
                        yogaNode.setMinWidthPercent(formatNumber);
                        return;
                    } else {
                        if (ygPropertyWithCSSStyle == 40) {
                            yogaEdge2 = YogaEdge.LEFT;
                        } else if (ygPropertyWithCSSStyle == 43) {
                            yogaEdge2 = YogaEdge.TOP;
                        } else if (ygPropertyWithCSSStyle == 41) {
                            yogaEdge2 = YogaEdge.RIGHT;
                        } else if (ygPropertyWithCSSStyle == 37) {
                            yogaEdge2 = YogaEdge.BOTTOM;
                        } else if (ygPropertyWithCSSStyle == 42) {
                            yogaEdge2 = YogaEdge.START;
                        } else if (ygPropertyWithCSSStyle == 38) {
                            yogaEdge2 = YogaEdge.END;
                        } else if (ygPropertyWithCSSStyle == 39) {
                            yogaEdge2 = YogaEdge.HORIZONTAL;
                        } else if (ygPropertyWithCSSStyle == 44) {
                            yogaEdge2 = YogaEdge.VERTICAL;
                        } else if (ygPropertyWithCSSStyle != 36) {
                            if (ygPropertyWithCSSStyle == 49) {
                                yogaEdge = YogaEdge.LEFT;
                            } else if (ygPropertyWithCSSStyle == 52) {
                                yogaEdge = YogaEdge.TOP;
                            } else if (ygPropertyWithCSSStyle == 50) {
                                yogaEdge = YogaEdge.RIGHT;
                            } else if (ygPropertyWithCSSStyle == 46) {
                                yogaEdge = YogaEdge.BOTTOM;
                            } else if (ygPropertyWithCSSStyle == 51) {
                                yogaEdge = YogaEdge.START;
                            } else if (ygPropertyWithCSSStyle == 47) {
                                yogaEdge = YogaEdge.END;
                            } else if (ygPropertyWithCSSStyle == 48) {
                                yogaEdge = YogaEdge.HORIZONTAL;
                            } else if (ygPropertyWithCSSStyle == 54) {
                                yogaEdge = YogaEdge.VERTICAL;
                            } else if (ygPropertyWithCSSStyle != 45) {
                                return;
                            } else {
                                yogaEdge = YogaEdge.ALL;
                            }
                            yogaNode.setPositionPercent(yogaEdge, formatNumber);
                            return;
                        } else {
                            yogaEdge2 = YogaEdge.ALL;
                        }
                        yogaNode.setPaddingPercent(yogaEdge2, formatNumber);
                        return;
                    }
                } else {
                    yogaEdge3 = YogaEdge.ALL;
                }
                yogaNode.setMarginPercent(yogaEdge3, formatNumber);
            }
        }
    }

    public static TKYogaConfig defaultConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? TKYogaConfigHolder.instance : (TKYogaConfig) invokeV.objValue;
    }

    public static float formatNumber(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i2, obj)) == null) {
            if (obj instanceof Number) {
                return TKConverter.dp2px(Tachikoma.sApplication, ((Number) obj).floatValue());
            }
            if (obj instanceof String) {
                Matcher matcher = getPattern("^(-?\\d+(\\.\\d+)?)(px|%)?$").matcher((String) obj);
                if (matcher.matches()) {
                    if (matcher.groupCount() >= 3) {
                        String group = matcher.group(3);
                        String group2 = matcher.group(1);
                        return group == null ? TKConverter.dp2px(Tachikoma.sApplication, Float.parseFloat(group2)) : "px".equals(group) ? TKFlexible.rem2px(Float.parseFloat(group2)) : Float.parseFloat(group2);
                    }
                    return 0.0f;
                }
                return defaultConfig().ygStyleValueIsString(i2, obj);
            }
            return 0.0f;
        }
        return invokeIL.floatValue;
    }

    public static Pattern getPattern(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Pattern pattern = sPatternMapCache.get(str);
            if (pattern == null) {
                Pattern compile = Pattern.compile(str);
                sPatternMapCache.put(str, compile);
                return compile;
            }
            return pattern;
        }
        return (Pattern) invokeL.objValue;
    }

    public static boolean isAutoNumeric(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            if (obj instanceof String) {
                return ((String) obj).equals("auto");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? getPattern("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isColor24(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? getPattern("^#([0-9a-fA-F]{6})$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isColor32(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? getPattern("^#([0-9a-fA-F]{8})$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isLinearGradientColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? getPattern("^linear-gradient\\(\\d+deg(\\s+#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})){2}\\)$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isNeedDPConvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? !NON_DP_CONVERT_KEYS.contains(str) : invokeL.booleanValue;
    }

    public static boolean isNumeric(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? getPattern("^-?\\d+(\\.\\d+)?$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isPercentageNumeric(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) {
            if (obj instanceof String) {
                return getPattern("^-?\\d+(\\.\\d+)?%$").matcher((String) obj).matches();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPxNumeric(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? getPattern("^-?\\d+(\\.\\d+)?px$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static int[] parseLinearGradientColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            String[] split = str.replace("linear-gradient(", "").replace("deg", "").replace(SmallTailInfo.EMOTION_SUFFIX, "").trim().split("\\s+");
            int length = split.length;
            int[] iArr = new int[length];
            iArr[0] = Integer.parseInt(split[0]) % 360;
            for (int i2 = 1; i2 < length; i2++) {
                iArr[i2] = rgba2argb(Color.parseColor(split[i2]));
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int rgba2argb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? ((i2 >> 8) & 16777215) | (i2 << 24) : invokeI.intValue;
    }

    private int ygStyleValueIsString(int i2, Object obj) {
        InterceptResult invokeIL;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65555, this, i2, obj)) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                if (alignMap.containsKey(obj)) {
                    map = alignMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 13) {
                if (directionMap.containsKey(obj)) {
                    map = directionMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 14) {
                if (displayMap.containsKey(obj)) {
                    map = displayMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 17) {
                if (flexDirectMap.containsKey(obj)) {
                    map = flexDirectMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 21) {
                if (justifyMap.containsKey(obj)) {
                    map = justifyMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 35) {
                if (overflowMap.containsKey(obj)) {
                    map = overflowMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else if (i2 == 53) {
                if (positionTypeMap.containsKey(obj)) {
                    map = positionTypeMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            } else {
                if (i2 == 56 && wrapMap.containsKey(obj)) {
                    map = wrapMap;
                    return ((Integer) map.get(obj)).intValue();
                }
                return Integer.MAX_VALUE;
            }
        }
        return invokeIL.intValue;
    }

    public int ygPropertyWithCSSStyle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (styleMap.containsKey(str)) {
                return ((Integer) styleMap.get(str)).intValue();
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }

    public Array yogaProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Array) invokeV.objValue;
    }
}
