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
            float f2;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0406a1, R.attr.obfuscated_res_0x7f0406a2, R.attr.obfuscated_res_0x7f0406a3, R.attr.obfuscated_res_0x7f0406a4, R.attr.obfuscated_res_0x7f0406a5, R.attr.obfuscated_res_0x7f0406a6, R.attr.obfuscated_res_0x7f0406a7, R.attr.obfuscated_res_0x7f0406a8, R.attr.obfuscated_res_0x7f0406a9, R.attr.obfuscated_res_0x7f0406aa, R.attr.obfuscated_res_0x7f0406ab, R.attr.obfuscated_res_0x7f0406ac, R.attr.obfuscated_res_0x7f0406ad, R.attr.obfuscated_res_0x7f0406ae, R.attr.obfuscated_res_0x7f0406af, R.attr.obfuscated_res_0x7f0406b0, R.attr.obfuscated_res_0x7f0406b1, R.attr.obfuscated_res_0x7f0406b2, R.attr.obfuscated_res_0x7f0406b3, R.attr.obfuscated_res_0x7f0406b4, R.attr.obfuscated_res_0x7f0406b5, R.attr.obfuscated_res_0x7f0406b6, R.attr.obfuscated_res_0x7f0406b7, R.attr.obfuscated_res_0x7f0406b8, R.attr.obfuscated_res_0x7f0406b9, R.attr.obfuscated_res_0x7f0406ba, R.attr.obfuscated_res_0x7f0406bb, R.attr.obfuscated_res_0x7f0406bc, R.attr.obfuscated_res_0x7f0406bd, R.attr.obfuscated_res_0x7f0406be, R.attr.obfuscated_res_0x7f0406bf, R.attr.obfuscated_res_0x7f0406c0, R.attr.obfuscated_res_0x7f0406c1, R.attr.obfuscated_res_0x7f0406c2, R.attr.obfuscated_res_0x7f0406c3, R.attr.obfuscated_res_0x7f0406c4, R.attr.obfuscated_res_0x7f0406c5, R.attr.obfuscated_res_0x7f0406c6, R.attr.obfuscated_res_0x7f0406c7, R.attr.obfuscated_res_0x7f0406c8, R.attr.obfuscated_res_0x7f0406c9, R.attr.obfuscated_res_0x7f0406ca, R.attr.obfuscated_res_0x7f0406cb, R.attr.obfuscated_res_0x7f0406cc, R.attr.obfuscated_res_0x7f0406cd, R.attr.obfuscated_res_0x7f0406ce, R.attr.obfuscated_res_0x7f0406cf, R.attr.obfuscated_res_0x7f0406d0, R.attr.obfuscated_res_0x7f0406d1, R.attr.obfuscated_res_0x7f0406d2, R.attr.obfuscated_res_0x7f0406d3, R.attr.obfuscated_res_0x7f0406d4, R.attr.obfuscated_res_0x7f0406d5, R.attr.obfuscated_res_0x7f0406d6, R.attr.obfuscated_res_0x7f0406d7, R.attr.obfuscated_res_0x7f0406d8, R.attr.obfuscated_res_0x7f0406d9});
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
                    f2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (i6 == 3) {
                    sparseArray = this.stringAttributes;
                    string = obtainStyledAttributes.getString(index);
                    sparseArray.put(index, string);
                } else {
                    sparseArray = this.numericAttributes;
                    f2 = obtainStyledAttributes.getFloat(index, 0.0f);
                }
                string = Float.valueOf(f2);
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
        public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{yogaNode, Float.valueOf(f2), yogaMeasureMode, Float.valueOf(f3), yogaMeasureMode2})) == null) {
                View view = (View) yogaNode.getData();
                if (view == null || (view instanceof YogaLayout)) {
                    return YogaMeasureOutput.make(0, 0);
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((int) f2, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f3, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
                return YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
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

    public static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view) {
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
        if (interceptable == null || interceptable.invokeLLL(65539, null, layoutParams, yogaNode, view) == null) {
            int i2 = 1;
            if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
                yogaNode.setDirection(YogaDirection.RTL);
            }
            Drawable background = view.getBackground();
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

    private void applyLayoutRecursive(YogaNode yogaNode, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{yogaNode, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            View view = (View) yogaNode.getData();
            if (view != null && view != this) {
                if (view.getVisibility() == 8) {
                    return;
                }
                int round = Math.round(yogaNode.getLayoutX() + f2);
                int round2 = Math.round(yogaNode.getLayoutY() + f3);
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
                view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
            }
            int childCount = yogaNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (equals(view)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i), f2, f3);
                } else if (!(view instanceof YogaLayout)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i), yogaNode.getLayoutX() + f2, yogaNode.getLayoutY() + f3);
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

    private void removeViewFromYogaTree(View view, boolean z) {
        YogaNode yogaNode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65542, this, view, z) == null) || (yogaNode = this.mYogaNodes.get(view)) == null) {
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
        this.mYogaNodes.remove(view);
        if (z) {
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        YogaNode yogaNodeJNIFinalizer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i, layoutParams) == null) {
            this.mYogaNode.setMeasureFunction(null);
            if (view instanceof VirtualYogaLayout) {
                VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
                virtualYogaLayout.transferChildren(this);
                YogaNode yogaNode = virtualYogaLayout.getYogaNode();
                YogaNode yogaNode2 = this.mYogaNode;
                yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
                return;
            }
            super.addView(view, i, layoutParams);
            if (this.mYogaNodes.containsKey(view)) {
                return;
            }
            if (view instanceof YogaLayout) {
                yogaNodeJNIFinalizer = ((YogaLayout) view).getYogaNode();
            } else {
                yogaNodeJNIFinalizer = this.mYogaNodes.containsKey(view) ? this.mYogaNodes.get(view) : new YogaNodeJNIFinalizer();
                yogaNodeJNIFinalizer.setData(view);
                yogaNodeJNIFinalizer.setMeasureFunction(new ViewMeasureFunction());
            }
            applyLayoutParams((LayoutParams) view.getLayoutParams(), yogaNodeJNIFinalizer, view);
            this.mYogaNodes.put(view, yogaNodeJNIFinalizer);
            YogaNode yogaNode3 = this.mYogaNode;
            yogaNode3.addChildAt(yogaNodeJNIFinalizer, yogaNode3.getChildCount());
        }
    }

    public void addView(View view, YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, yogaNode) == null) {
            this.mYogaNodes.put(view, yogaNode);
            addView(view);
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

    public YogaNode getYogaNodeForView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) ? this.mYogaNodes.get(view) : (YogaNode) invokeL.objValue;
    }

    public void invalidate(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (this.mYogaNodes.containsKey(view)) {
                this.mYogaNodes.get(view).dirty();
                return;
            }
            int childCount = this.mYogaNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                YogaNode childAt = this.mYogaNode.getChildAt(i);
                if (childAt.getData() instanceof YogaLayout) {
                    ((YogaLayout) childAt.getData()).invalidate(view);
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
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            removeViewFromYogaTree(view, false);
            super.removeView(view);
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
    public void removeViewInLayout(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            removeViewFromYogaTree(view, true);
            super.removeViewInLayout(view);
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
