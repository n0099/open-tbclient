package com.tachikoma.core.yoga.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaDirection;
import com.kwad.yoga.YogaDisplay;
import com.kwad.yoga.YogaEdge;
import com.kwad.yoga.YogaFlexDirection;
import com.kwad.yoga.YogaJustify;
import com.kwad.yoga.YogaMeasureFunction;
import com.kwad.yoga.YogaMeasureMode;
import com.kwad.yoga.YogaMeasureOutput;
import com.kwad.yoga.YogaNode;
import com.kwad.yoga.YogaNodeJNIFinalizer;
import com.kwad.yoga.YogaOverflow;
import com.kwad.yoga.YogaPositionType;
import com.kwad.yoga.YogaWrap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class YogaLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final YogaNode mYogaNode;
    public final Map<View, YogaNode> mYogaNodes;

    /* loaded from: classes7.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Float> numericAttributes;
        public SparseArray<String> stringAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i >= 0) {
                this.numericAttributes.put(55, Float.valueOf(i));
            }
            if (i2 >= 0) {
                this.numericAttributes.put(20, Float.valueOf(i2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            SparseArray sparseArray;
            float f;
            Object string;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0406e7, R.attr.obfuscated_res_0x7f0406e8, R.attr.obfuscated_res_0x7f0406e9, R.attr.obfuscated_res_0x7f0406ea, R.attr.obfuscated_res_0x7f0406eb, R.attr.obfuscated_res_0x7f0406ec, R.attr.obfuscated_res_0x7f0406ed, R.attr.obfuscated_res_0x7f0406ee, R.attr.obfuscated_res_0x7f0406ef, R.attr.obfuscated_res_0x7f0406f0, R.attr.obfuscated_res_0x7f0406f1, R.attr.obfuscated_res_0x7f0406f2, R.attr.obfuscated_res_0x7f0406f3, R.attr.obfuscated_res_0x7f0406f4, R.attr.obfuscated_res_0x7f0406f5, R.attr.obfuscated_res_0x7f0406f6, R.attr.obfuscated_res_0x7f0406f7, R.attr.obfuscated_res_0x7f0406f8, R.attr.obfuscated_res_0x7f0406f9, R.attr.obfuscated_res_0x7f0406fa, R.attr.obfuscated_res_0x7f0406fb, R.attr.obfuscated_res_0x7f0406fc, R.attr.obfuscated_res_0x7f0406fd, R.attr.obfuscated_res_0x7f0406fe, R.attr.obfuscated_res_0x7f0406ff, R.attr.obfuscated_res_0x7f040700, R.attr.obfuscated_res_0x7f040701, R.attr.obfuscated_res_0x7f040702, R.attr.obfuscated_res_0x7f040703, R.attr.obfuscated_res_0x7f040704, R.attr.obfuscated_res_0x7f040705, R.attr.obfuscated_res_0x7f040706, R.attr.obfuscated_res_0x7f040707, R.attr.obfuscated_res_0x7f040708, R.attr.obfuscated_res_0x7f040709, R.attr.obfuscated_res_0x7f04070a, R.attr.obfuscated_res_0x7f04070b, R.attr.obfuscated_res_0x7f04070c, R.attr.obfuscated_res_0x7f04070d, R.attr.obfuscated_res_0x7f04070e, R.attr.obfuscated_res_0x7f04070f, R.attr.obfuscated_res_0x7f040710, R.attr.obfuscated_res_0x7f040711, R.attr.obfuscated_res_0x7f040712, R.attr.obfuscated_res_0x7f040713, R.attr.obfuscated_res_0x7f040714, R.attr.obfuscated_res_0x7f040715, R.attr.obfuscated_res_0x7f040716, R.attr.obfuscated_res_0x7f040717, R.attr.obfuscated_res_0x7f040718, R.attr.obfuscated_res_0x7f040719, R.attr.obfuscated_res_0x7f04071a, R.attr.obfuscated_res_0x7f04071b, R.attr.obfuscated_res_0x7f04071c, R.attr.obfuscated_res_0x7f04071d, R.attr.obfuscated_res_0x7f04071e, R.attr.obfuscated_res_0x7f04071f});
            int i3 = ((ViewGroup.LayoutParams) this).width;
            if (i3 >= 0) {
                this.numericAttributes.put(55, Float.valueOf(i3));
            }
            int i4 = ((ViewGroup.LayoutParams) this).height;
            if (i4 >= 0) {
                this.numericAttributes.put(20, Float.valueOf(i4));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                int i6 = typedValue.type;
                if (i6 == 5) {
                    sparseArray = this.numericAttributes;
                    f = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (i6 == 3) {
                    sparseArray = this.stringAttributes;
                    string = obtainStyledAttributes.getString(index);
                    sparseArray.put(index, string);
                } else {
                    sparseArray = this.numericAttributes;
                    f = obtainStyledAttributes.getFloat(index, 0.0f);
                }
                string = Float.valueOf(f);
                sparseArray.put(index, string);
            }
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.numericAttributes = layoutParams2.numericAttributes.clone();
                this.stringAttributes = layoutParams2.stringAttributes.clone();
                return;
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(55, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(20, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class ViewMeasureFunction implements YogaMeasureFunction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewMeasureFunction() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode yogaMeasureMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, yogaMeasureMode)) == null) {
                if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                    return Integer.MIN_VALUE;
                }
                return yogaMeasureMode == YogaMeasureMode.EXACTLY ? 1073741824 : 0;
            }
            return invokeL.intValue;
        }

        @Override // com.kwad.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{yogaNode, Float.valueOf(f), yogaMeasureMode, Float.valueOf(f2), yogaMeasureMode2})) == null) {
                View view2 = (View) yogaNode.getData();
                if (view2 == null || (view2 instanceof YogaLayout)) {
                    return YogaMeasureOutput.make(0, 0);
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec((int) f, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
                return YogaMeasureOutput.make(view2.getMeasuredWidth(), view2.getMeasuredHeight());
            }
            return invokeCommon.longValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YogaLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mYogaNode = new YogaNodeJNIFinalizer();
        this.mYogaNodes = new HashMap();
        this.mYogaNode.setData(this);
        this.mYogaNode.setMeasureFunction(new ViewMeasureFunction());
        applyLayoutParams(attributeSet != null ? new LayoutParams(context, attributeSet) : (LayoutParams) generateDefaultLayoutParams(), this.mYogaNode, this);
    }

    public static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view2) {
        int i;
        YogaEdge yogaEdge;
        YogaEdge yogaEdge2;
        YogaEdge yogaEdge3;
        YogaEdge yogaEdge4;
        YogaEdge yogaEdge5;
        YogaEdge yogaEdge6;
        YogaEdge yogaEdge7;
        YogaEdge yogaEdge8;
        YogaEdge yogaEdge9;
        YogaEdge yogaEdge10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, layoutParams, yogaNode, view2) == null) {
            int i2 = 1;
            if (Build.VERSION.SDK_INT >= 17 && view2.getResources().getConfiguration().getLayoutDirection() == 1) {
                yogaNode.setDirection(YogaDirection.RTL);
            }
            Drawable background = view2.getBackground();
            if (background != null) {
                Rect rect = new Rect();
                if (background.getPadding(rect)) {
                    yogaNode.setPadding(YogaEdge.LEFT, rect.left);
                    yogaNode.setPadding(YogaEdge.TOP, rect.top);
                    yogaNode.setPadding(YogaEdge.RIGHT, rect.right);
                    yogaNode.setPadding(YogaEdge.BOTTOM, rect.bottom);
                }
            }
            int i3 = 0;
            while (true) {
                i = 16;
                if (i3 >= layoutParams.numericAttributes.size()) {
                    break;
                }
                int keyAt = layoutParams.numericAttributes.keyAt(i3);
                float floatValue = layoutParams.numericAttributes.valueAt(i3).floatValue();
                if (keyAt == 0) {
                    yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == i2) {
                    yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == 2) {
                    yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == 3) {
                    yogaNode.setAspectRatio(floatValue);
                } else {
                    if (keyAt == 8) {
                        yogaEdge10 = YogaEdge.LEFT;
                    } else if (keyAt == 11) {
                        yogaEdge10 = YogaEdge.TOP;
                    } else if (keyAt == 9) {
                        yogaEdge10 = YogaEdge.RIGHT;
                    } else if (keyAt == 5) {
                        yogaEdge10 = YogaEdge.BOTTOM;
                    } else if (keyAt == 10) {
                        yogaEdge10 = YogaEdge.START;
                    } else if (keyAt == 6) {
                        yogaEdge10 = YogaEdge.END;
                    } else if (keyAt == 7) {
                        yogaEdge10 = YogaEdge.HORIZONTAL;
                    } else if (keyAt == 12) {
                        yogaEdge10 = YogaEdge.VERTICAL;
                    } else if (keyAt == 4) {
                        yogaEdge10 = YogaEdge.ALL;
                    } else if (keyAt == 13) {
                        yogaNode.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
                    } else if (keyAt == 14) {
                        yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
                    } else if (keyAt == 15) {
                        yogaNode.setFlex(floatValue);
                    } else if (keyAt == 16) {
                        yogaNode.setFlexBasis(floatValue);
                    } else if (keyAt == 17) {
                        yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
                    } else if (keyAt == 18) {
                        yogaNode.setFlexGrow(floatValue);
                    } else if (keyAt == 19) {
                        yogaNode.setFlexShrink(floatValue);
                    } else if (keyAt == 20) {
                        yogaNode.setHeight(floatValue);
                    } else {
                        if (keyAt == 26) {
                            yogaEdge9 = YogaEdge.LEFT;
                        } else if (keyAt == 21) {
                            yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
                        } else if (keyAt == 29) {
                            yogaEdge9 = YogaEdge.TOP;
                        } else if (keyAt == 27) {
                            yogaEdge9 = YogaEdge.RIGHT;
                        } else if (keyAt == 23) {
                            yogaEdge9 = YogaEdge.BOTTOM;
                        } else if (keyAt == 28) {
                            yogaEdge9 = YogaEdge.START;
                        } else if (keyAt == 24) {
                            yogaEdge9 = YogaEdge.END;
                        } else if (keyAt == 25) {
                            yogaEdge9 = YogaEdge.HORIZONTAL;
                        } else if (keyAt == 30) {
                            yogaEdge9 = YogaEdge.VERTICAL;
                        } else if (keyAt == 22) {
                            yogaEdge9 = YogaEdge.ALL;
                        } else if (keyAt == 31) {
                            yogaNode.setMaxHeight(floatValue);
                        } else if (keyAt == 32) {
                            yogaNode.setMaxWidth(floatValue);
                        } else if (keyAt == 33) {
                            yogaNode.setMinHeight(floatValue);
                        } else if (keyAt == 34) {
                            yogaNode.setMinWidth(floatValue);
                        } else if (keyAt == 35) {
                            yogaNode.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
                        } else {
                            if (keyAt == 40) {
                                yogaEdge8 = YogaEdge.LEFT;
                            } else if (keyAt == 43) {
                                yogaEdge8 = YogaEdge.TOP;
                            } else if (keyAt == 41) {
                                yogaEdge8 = YogaEdge.RIGHT;
                            } else if (keyAt == 37) {
                                yogaEdge8 = YogaEdge.BOTTOM;
                            } else if (keyAt == 42) {
                                yogaEdge8 = YogaEdge.START;
                            } else if (keyAt == 38) {
                                yogaEdge8 = YogaEdge.END;
                            } else if (keyAt == 39) {
                                yogaEdge8 = YogaEdge.HORIZONTAL;
                            } else if (keyAt == 44) {
                                yogaEdge8 = YogaEdge.VERTICAL;
                            } else if (keyAt == 36) {
                                yogaEdge8 = YogaEdge.ALL;
                            } else {
                                if (keyAt == 49) {
                                    yogaEdge7 = YogaEdge.LEFT;
                                } else if (keyAt == 52) {
                                    yogaEdge7 = YogaEdge.TOP;
                                } else if (keyAt == 50) {
                                    yogaEdge7 = YogaEdge.RIGHT;
                                } else if (keyAt == 46) {
                                    yogaEdge7 = YogaEdge.BOTTOM;
                                } else if (keyAt == 51) {
                                    yogaEdge7 = YogaEdge.START;
                                } else if (keyAt == 47) {
                                    yogaEdge7 = YogaEdge.END;
                                } else if (keyAt == 48) {
                                    yogaEdge7 = YogaEdge.HORIZONTAL;
                                } else if (keyAt == 54) {
                                    yogaEdge7 = YogaEdge.VERTICAL;
                                } else if (keyAt == 45) {
                                    yogaEdge7 = YogaEdge.ALL;
                                } else if (keyAt == 53) {
                                    yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
                                } else if (keyAt == 55) {
                                    yogaNode.setWidth(floatValue);
                                } else if (keyAt == 56) {
                                    yogaNode.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
                                }
                                yogaNode.setPosition(yogaEdge7, floatValue);
                            }
                            yogaNode.setPadding(yogaEdge8, floatValue);
                        }
                        yogaNode.setMargin(yogaEdge9, floatValue);
                    }
                    yogaNode.setBorder(yogaEdge10, floatValue);
                }
                i3++;
                i2 = 1;
            }
            int i4 = 0;
            while (i4 < layoutParams.stringAttributes.size()) {
                int keyAt2 = layoutParams.stringAttributes.keyAt(i4);
                String valueAt = layoutParams.stringAttributes.valueAt(i4);
                if (valueAt.equals("auto")) {
                    if (keyAt2 == 26) {
                        yogaEdge6 = YogaEdge.LEFT;
                    } else if (keyAt2 == 29) {
                        yogaEdge6 = YogaEdge.TOP;
                    } else if (keyAt2 == 27) {
                        yogaEdge6 = YogaEdge.RIGHT;
                    } else if (keyAt2 == 23) {
                        yogaEdge6 = YogaEdge.BOTTOM;
                    } else if (keyAt2 == 28) {
                        yogaEdge6 = YogaEdge.START;
                    } else if (keyAt2 == 24) {
                        yogaEdge6 = YogaEdge.END;
                    } else if (keyAt2 == 25) {
                        yogaEdge6 = YogaEdge.HORIZONTAL;
                    } else if (keyAt2 == 30) {
                        yogaEdge6 = YogaEdge.VERTICAL;
                    } else if (keyAt2 == 22) {
                        yogaEdge6 = YogaEdge.ALL;
                    }
                    yogaNode.setMarginAuto(yogaEdge6);
                }
                if (valueAt.endsWith("%")) {
                    float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                    if (keyAt2 == i) {
                        yogaNode.setFlexBasisPercent(parseFloat);
                    } else if (keyAt2 == 20) {
                        yogaNode.setHeightPercent(parseFloat);
                    } else {
                        if (keyAt2 == 26) {
                            yogaEdge5 = YogaEdge.LEFT;
                        } else if (keyAt2 == 29) {
                            yogaEdge5 = YogaEdge.TOP;
                        } else if (keyAt2 == 27) {
                            yogaEdge5 = YogaEdge.RIGHT;
                        } else if (keyAt2 == 23) {
                            yogaEdge5 = YogaEdge.BOTTOM;
                        } else if (keyAt2 == 28) {
                            yogaEdge5 = YogaEdge.START;
                        } else if (keyAt2 == 24) {
                            yogaEdge5 = YogaEdge.END;
                        } else if (keyAt2 == 25) {
                            yogaEdge5 = YogaEdge.HORIZONTAL;
                        } else {
                            if (keyAt2 == 30) {
                                yogaEdge4 = YogaEdge.VERTICAL;
                            } else if (keyAt2 == 22) {
                                yogaEdge4 = YogaEdge.ALL;
                            } else if (keyAt2 == 31) {
                                yogaNode.setMaxHeightPercent(parseFloat);
                            } else if (keyAt2 == 32) {
                                yogaNode.setMaxWidthPercent(parseFloat);
                            } else if (keyAt2 == 33) {
                                yogaNode.setMinHeightPercent(parseFloat);
                            } else if (keyAt2 == 34) {
                                yogaNode.setMinWidthPercent(parseFloat);
                            } else {
                                if (keyAt2 == 40) {
                                    yogaEdge3 = YogaEdge.LEFT;
                                } else if (keyAt2 == 43) {
                                    yogaEdge3 = YogaEdge.TOP;
                                } else if (keyAt2 == 41) {
                                    yogaEdge3 = YogaEdge.RIGHT;
                                } else if (keyAt2 == 37) {
                                    yogaEdge3 = YogaEdge.BOTTOM;
                                } else {
                                    if (keyAt2 == 42) {
                                        yogaEdge2 = YogaEdge.START;
                                    } else if (keyAt2 == 38) {
                                        yogaEdge2 = YogaEdge.END;
                                    } else if (keyAt2 == 39) {
                                        yogaEdge2 = YogaEdge.HORIZONTAL;
                                    } else if (keyAt2 == 44) {
                                        yogaEdge2 = YogaEdge.VERTICAL;
                                    } else if (keyAt2 == 36) {
                                        yogaEdge2 = YogaEdge.ALL;
                                    } else {
                                        if (keyAt2 == 49) {
                                            yogaEdge = YogaEdge.LEFT;
                                        } else if (keyAt2 == 52) {
                                            yogaEdge = YogaEdge.TOP;
                                        } else if (keyAt2 == 50) {
                                            yogaEdge = YogaEdge.RIGHT;
                                        } else if (keyAt2 == 46) {
                                            yogaEdge = YogaEdge.BOTTOM;
                                        } else if (keyAt2 == 51) {
                                            yogaEdge = YogaEdge.START;
                                        } else if (keyAt2 == 47) {
                                            yogaEdge = YogaEdge.END;
                                        } else if (keyAt2 == 48) {
                                            yogaEdge = YogaEdge.HORIZONTAL;
                                        } else if (keyAt2 == 54) {
                                            yogaEdge = YogaEdge.VERTICAL;
                                        } else if (keyAt2 == 45) {
                                            yogaEdge = YogaEdge.ALL;
                                        } else if (keyAt2 == 55) {
                                            yogaNode.setWidthPercent(parseFloat);
                                        }
                                        yogaNode.setPositionPercent(yogaEdge, parseFloat);
                                    }
                                    yogaNode.setPaddingPercent(yogaEdge2, parseFloat);
                                }
                                yogaNode.setPaddingPercent(yogaEdge3, parseFloat);
                            }
                            yogaNode.setMarginPercent(yogaEdge4, parseFloat);
                        }
                        yogaNode.setMarginPercent(yogaEdge5, parseFloat);
                    }
                }
                i4++;
                i = 16;
            }
        }
    }

    private void applyLayoutRecursive(YogaNode yogaNode, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{yogaNode, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            View view2 = (View) yogaNode.getData();
            if (view2 != null && view2 != this) {
                if (view2.getVisibility() == 8) {
                    return;
                }
                int round = Math.round(yogaNode.getLayoutX() + f);
                int round2 = Math.round(yogaNode.getLayoutY() + f2);
                view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
                view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
            }
            int childCount = yogaNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (equals(view2)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i), f, f2);
                } else if (!(view2 instanceof YogaLayout)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i), yogaNode.getLayoutX() + f, yogaNode.getLayoutY() + f2);
                }
            }
        }
    }

    private void createLayout(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65541, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == 1073741824) {
                this.mYogaNode.setHeight(size2);
            }
            if (mode == 1073741824) {
                this.mYogaNode.setWidth(size);
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.mYogaNode.setMaxHeight(size2);
            }
            if (mode == Integer.MIN_VALUE) {
                this.mYogaNode.setMaxWidth(size);
            }
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    private void removeViewFromYogaTree(View view2, boolean z) {
        YogaNode yogaNode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65542, this, view2, z) == null) || (yogaNode = this.mYogaNodes.get(view2)) == null) {
            return;
        }
        YogaNode owner = yogaNode.getOwner();
        int i = 0;
        while (true) {
            if (i >= owner.getChildCount()) {
                break;
            } else if (owner.getChildAt(i).equals(yogaNode)) {
                owner.removeChildAt(i);
                break;
            } else {
                i++;
            }
        }
        yogaNode.setData(null);
        this.mYogaNodes.remove(view2);
        if (z) {
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        YogaNode yogaNodeJNIFinalizer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            this.mYogaNode.setMeasureFunction(null);
            if (view2 instanceof VirtualYogaLayout) {
                VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view2;
                virtualYogaLayout.transferChildren(this);
                YogaNode yogaNode = virtualYogaLayout.getYogaNode();
                YogaNode yogaNode2 = this.mYogaNode;
                yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
                return;
            }
            super.addView(view2, i, layoutParams);
            if (this.mYogaNodes.containsKey(view2)) {
                return;
            }
            if (view2 instanceof YogaLayout) {
                yogaNodeJNIFinalizer = ((YogaLayout) view2).getYogaNode();
            } else {
                yogaNodeJNIFinalizer = this.mYogaNodes.containsKey(view2) ? this.mYogaNodes.get(view2) : new YogaNodeJNIFinalizer();
                yogaNodeJNIFinalizer.setData(view2);
                yogaNodeJNIFinalizer.setMeasureFunction(new ViewMeasureFunction());
            }
            applyLayoutParams((LayoutParams) view2.getLayoutParams(), yogaNodeJNIFinalizer, view2);
            this.mYogaNodes.put(view2, yogaNodeJNIFinalizer);
            YogaNode yogaNode3 = this.mYogaNode;
            yogaNode3.addChildAt(yogaNodeJNIFinalizer, yogaNode3.getChildCount());
        }
    }

    public void addView(View view2, YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yogaNode) == null) {
            this.mYogaNodes.put(view2, yogaNode);
            addView(view2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LayoutParams(-1, -1) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public YogaNode getYogaNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mYogaNode : (YogaNode) invokeV.objValue;
    }

    public YogaNode getYogaNodeForView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) ? this.mYogaNodes.get(view2) : (YogaNode) invokeL.objValue;
    }

    public void invalidate(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (this.mYogaNodes.containsKey(view2)) {
                this.mYogaNodes.get(view2).dirty();
                return;
            }
            int childCount = this.mYogaNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                YogaNode childAt = this.mYogaNode.getChildAt(i);
                if (childAt.getData() instanceof YogaLayout) {
                    ((YogaLayout) childAt.getData()).invalidate(view2);
                }
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!(getParent() instanceof YogaLayout)) {
                createLayout(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
            }
            applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            if (!(getParent() instanceof YogaLayout)) {
                createLayout(i, i2);
            }
            setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                removeViewFromYogaTree(getChildAt(i), false);
            }
            super.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                removeViewFromYogaTree(getChildAt(i), true);
            }
            super.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            removeViewFromYogaTree(view2, false);
            super.removeView(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            removeViewFromYogaTree(getChildAt(i), false);
            super.removeViewAt(i);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            removeViewFromYogaTree(view2, true);
            super.removeViewInLayout(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                removeViewFromYogaTree(getChildAt(i3), false);
            }
            super.removeViews(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                removeViewFromYogaTree(getChildAt(i3), true);
            }
            super.removeViewsInLayout(i, i2);
        }
    }
}
