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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
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
/* loaded from: classes4.dex */
public class YogaLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final YogaNode mYogaNode;
    public final Map<View, YogaNode> mYogaNodes;

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Float> numericAttributes;
        public SparseArray<String> stringAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i2 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(i2));
            }
            if (i3 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(i3));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.yoga);
            int i4 = ((ViewGroup.LayoutParams) this).width;
            if (i4 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(i4));
            }
            int i5 = ((ViewGroup.LayoutParams) this).height;
            if (i5 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(i5));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = obtainStyledAttributes.getIndex(i6);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                int i7 = typedValue.type;
                if (i7 == 5) {
                    sparseArray = this.numericAttributes;
                    f2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (i7 == 3) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ViewMeasureFunction implements YogaMeasureFunction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewMeasureFunction() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YogaLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        YogaEdge yogaEdge;
        YogaEdge yogaEdge2;
        YogaEdge yogaEdge3;
        YogaEdge yogaEdge4;
        YogaEdge yogaEdge5;
        YogaEdge yogaEdge6;
        YogaEdge yogaEdge7;
        YogaEdge yogaEdge8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, layoutParams, yogaNode, view) == null) {
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
            for (int i2 = 0; i2 < layoutParams.numericAttributes.size(); i2++) {
                int keyAt = layoutParams.numericAttributes.keyAt(i2);
                float floatValue = layoutParams.numericAttributes.valueAt(i2).floatValue();
                if (keyAt == R.styleable.yoga_yg_alignContent) {
                    yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == R.styleable.yoga_yg_alignItems) {
                    yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == R.styleable.yoga_yg_alignSelf) {
                    yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
                } else if (keyAt == R.styleable.yoga_yg_aspectRatio) {
                    yogaNode.setAspectRatio(floatValue);
                } else {
                    if (keyAt == R.styleable.yoga_yg_borderLeft) {
                        yogaEdge8 = YogaEdge.LEFT;
                    } else if (keyAt == R.styleable.yoga_yg_borderTop) {
                        yogaEdge8 = YogaEdge.TOP;
                    } else if (keyAt == R.styleable.yoga_yg_borderRight) {
                        yogaEdge8 = YogaEdge.RIGHT;
                    } else if (keyAt == R.styleable.yoga_yg_borderBottom) {
                        yogaEdge8 = YogaEdge.BOTTOM;
                    } else if (keyAt == R.styleable.yoga_yg_borderStart) {
                        yogaEdge8 = YogaEdge.START;
                    } else if (keyAt == R.styleable.yoga_yg_borderEnd) {
                        yogaEdge8 = YogaEdge.END;
                    } else if (keyAt == R.styleable.yoga_yg_borderHorizontal) {
                        yogaEdge8 = YogaEdge.HORIZONTAL;
                    } else if (keyAt == R.styleable.yoga_yg_borderVertical) {
                        yogaEdge8 = YogaEdge.VERTICAL;
                    } else if (keyAt == R.styleable.yoga_yg_borderAll) {
                        yogaEdge8 = YogaEdge.ALL;
                    } else if (keyAt == R.styleable.yoga_yg_direction) {
                        yogaNode.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
                    } else if (keyAt == R.styleable.yoga_yg_display) {
                        yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
                    } else if (keyAt == R.styleable.yoga_yg_flex) {
                        yogaNode.setFlex(floatValue);
                    } else if (keyAt == R.styleable.yoga_yg_flexBasis) {
                        yogaNode.setFlexBasis(floatValue);
                    } else if (keyAt == R.styleable.yoga_yg_flexDirection) {
                        yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
                    } else if (keyAt == R.styleable.yoga_yg_flexGrow) {
                        yogaNode.setFlexGrow(floatValue);
                    } else if (keyAt == R.styleable.yoga_yg_flexShrink) {
                        yogaNode.setFlexShrink(floatValue);
                    } else if (keyAt == R.styleable.yoga_yg_height) {
                        yogaNode.setHeight(floatValue);
                    } else {
                        if (keyAt == R.styleable.yoga_yg_marginLeft) {
                            yogaEdge7 = YogaEdge.LEFT;
                        } else if (keyAt == R.styleable.yoga_yg_justifyContent) {
                            yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
                        } else if (keyAt == R.styleable.yoga_yg_marginTop) {
                            yogaEdge7 = YogaEdge.TOP;
                        } else if (keyAt == R.styleable.yoga_yg_marginRight) {
                            yogaEdge7 = YogaEdge.RIGHT;
                        } else if (keyAt == R.styleable.yoga_yg_marginBottom) {
                            yogaEdge7 = YogaEdge.BOTTOM;
                        } else if (keyAt == R.styleable.yoga_yg_marginStart) {
                            yogaEdge7 = YogaEdge.START;
                        } else if (keyAt == R.styleable.yoga_yg_marginEnd) {
                            yogaEdge7 = YogaEdge.END;
                        } else if (keyAt == R.styleable.yoga_yg_marginHorizontal) {
                            yogaEdge7 = YogaEdge.HORIZONTAL;
                        } else if (keyAt == R.styleable.yoga_yg_marginVertical) {
                            yogaEdge7 = YogaEdge.VERTICAL;
                        } else if (keyAt == R.styleable.yoga_yg_marginAll) {
                            yogaEdge7 = YogaEdge.ALL;
                        } else if (keyAt == R.styleable.yoga_yg_maxHeight) {
                            yogaNode.setMaxHeight(floatValue);
                        } else if (keyAt == R.styleable.yoga_yg_maxWidth) {
                            yogaNode.setMaxWidth(floatValue);
                        } else if (keyAt == R.styleable.yoga_yg_minHeight) {
                            yogaNode.setMinHeight(floatValue);
                        } else if (keyAt == R.styleable.yoga_yg_minWidth) {
                            yogaNode.setMinWidth(floatValue);
                        } else if (keyAt == R.styleable.yoga_yg_overflow) {
                            yogaNode.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
                        } else {
                            if (keyAt == R.styleable.yoga_yg_paddingLeft) {
                                yogaEdge6 = YogaEdge.LEFT;
                            } else if (keyAt == R.styleable.yoga_yg_paddingTop) {
                                yogaEdge6 = YogaEdge.TOP;
                            } else if (keyAt == R.styleable.yoga_yg_paddingRight) {
                                yogaEdge6 = YogaEdge.RIGHT;
                            } else if (keyAt == R.styleable.yoga_yg_paddingBottom) {
                                yogaEdge6 = YogaEdge.BOTTOM;
                            } else if (keyAt == R.styleable.yoga_yg_paddingStart) {
                                yogaEdge6 = YogaEdge.START;
                            } else if (keyAt == R.styleable.yoga_yg_paddingEnd) {
                                yogaEdge6 = YogaEdge.END;
                            } else if (keyAt == R.styleable.yoga_yg_paddingHorizontal) {
                                yogaEdge6 = YogaEdge.HORIZONTAL;
                            } else if (keyAt == R.styleable.yoga_yg_paddingVertical) {
                                yogaEdge6 = YogaEdge.VERTICAL;
                            } else if (keyAt == R.styleable.yoga_yg_paddingAll) {
                                yogaEdge6 = YogaEdge.ALL;
                            } else {
                                if (keyAt == R.styleable.yoga_yg_positionLeft) {
                                    yogaEdge5 = YogaEdge.LEFT;
                                } else if (keyAt == R.styleable.yoga_yg_positionTop) {
                                    yogaEdge5 = YogaEdge.TOP;
                                } else if (keyAt == R.styleable.yoga_yg_positionRight) {
                                    yogaEdge5 = YogaEdge.RIGHT;
                                } else if (keyAt == R.styleable.yoga_yg_positionBottom) {
                                    yogaEdge5 = YogaEdge.BOTTOM;
                                } else if (keyAt == R.styleable.yoga_yg_positionStart) {
                                    yogaEdge5 = YogaEdge.START;
                                } else if (keyAt == R.styleable.yoga_yg_positionEnd) {
                                    yogaEdge5 = YogaEdge.END;
                                } else if (keyAt == R.styleable.yoga_yg_positionHorizontal) {
                                    yogaEdge5 = YogaEdge.HORIZONTAL;
                                } else if (keyAt == R.styleable.yoga_yg_positionVertical) {
                                    yogaEdge5 = YogaEdge.VERTICAL;
                                } else if (keyAt == R.styleable.yoga_yg_positionAll) {
                                    yogaEdge5 = YogaEdge.ALL;
                                } else if (keyAt == R.styleable.yoga_yg_positionType) {
                                    yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
                                } else if (keyAt == R.styleable.yoga_yg_width) {
                                    yogaNode.setWidth(floatValue);
                                } else if (keyAt == R.styleable.yoga_yg_wrap) {
                                    yogaNode.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
                                }
                                yogaNode.setPosition(yogaEdge5, floatValue);
                            }
                            yogaNode.setPadding(yogaEdge6, floatValue);
                        }
                        yogaNode.setMargin(yogaEdge7, floatValue);
                    }
                    yogaNode.setBorder(yogaEdge8, floatValue);
                }
            }
            for (int i3 = 0; i3 < layoutParams.stringAttributes.size(); i3++) {
                int keyAt2 = layoutParams.stringAttributes.keyAt(i3);
                String valueAt = layoutParams.stringAttributes.valueAt(i3);
                if (valueAt.equals("auto")) {
                    if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                        yogaEdge4 = YogaEdge.LEFT;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                        yogaEdge4 = YogaEdge.TOP;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                        yogaEdge4 = YogaEdge.RIGHT;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                        yogaEdge4 = YogaEdge.BOTTOM;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                        yogaEdge4 = YogaEdge.START;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                        yogaEdge4 = YogaEdge.END;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                        yogaEdge4 = YogaEdge.HORIZONTAL;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                        yogaEdge4 = YogaEdge.VERTICAL;
                    } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                        yogaEdge4 = YogaEdge.ALL;
                    }
                    yogaNode.setMarginAuto(yogaEdge4);
                }
                if (valueAt.endsWith("%")) {
                    float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                    if (keyAt2 == R.styleable.yoga_yg_flexBasis) {
                        yogaNode.setFlexBasisPercent(parseFloat);
                    } else if (keyAt2 == R.styleable.yoga_yg_height) {
                        yogaNode.setHeightPercent(parseFloat);
                    } else {
                        if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                            yogaEdge3 = YogaEdge.LEFT;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                            yogaEdge3 = YogaEdge.TOP;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                            yogaEdge3 = YogaEdge.RIGHT;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                            yogaEdge3 = YogaEdge.BOTTOM;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                            yogaEdge3 = YogaEdge.START;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                            yogaEdge3 = YogaEdge.END;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                            yogaEdge3 = YogaEdge.HORIZONTAL;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                            yogaEdge3 = YogaEdge.VERTICAL;
                        } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                            yogaEdge3 = YogaEdge.ALL;
                        } else if (keyAt2 == R.styleable.yoga_yg_maxHeight) {
                            yogaNode.setMaxHeightPercent(parseFloat);
                        } else if (keyAt2 == R.styleable.yoga_yg_maxWidth) {
                            yogaNode.setMaxWidthPercent(parseFloat);
                        } else if (keyAt2 == R.styleable.yoga_yg_minHeight) {
                            yogaNode.setMinHeightPercent(parseFloat);
                        } else if (keyAt2 == R.styleable.yoga_yg_minWidth) {
                            yogaNode.setMinWidthPercent(parseFloat);
                        } else {
                            if (keyAt2 == R.styleable.yoga_yg_paddingLeft) {
                                yogaEdge2 = YogaEdge.LEFT;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingTop) {
                                yogaEdge2 = YogaEdge.TOP;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingRight) {
                                yogaEdge2 = YogaEdge.RIGHT;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingBottom) {
                                yogaEdge2 = YogaEdge.BOTTOM;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingStart) {
                                yogaEdge2 = YogaEdge.START;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingEnd) {
                                yogaEdge2 = YogaEdge.END;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingHorizontal) {
                                yogaEdge2 = YogaEdge.HORIZONTAL;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingVertical) {
                                yogaEdge2 = YogaEdge.VERTICAL;
                            } else if (keyAt2 == R.styleable.yoga_yg_paddingAll) {
                                yogaEdge2 = YogaEdge.ALL;
                            } else {
                                if (keyAt2 == R.styleable.yoga_yg_positionLeft) {
                                    yogaEdge = YogaEdge.LEFT;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionTop) {
                                    yogaEdge = YogaEdge.TOP;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionRight) {
                                    yogaEdge = YogaEdge.RIGHT;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionBottom) {
                                    yogaEdge = YogaEdge.BOTTOM;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionStart) {
                                    yogaEdge = YogaEdge.START;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionEnd) {
                                    yogaEdge = YogaEdge.END;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionHorizontal) {
                                    yogaEdge = YogaEdge.HORIZONTAL;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionVertical) {
                                    yogaEdge = YogaEdge.VERTICAL;
                                } else if (keyAt2 == R.styleable.yoga_yg_positionAll) {
                                    yogaEdge = YogaEdge.ALL;
                                } else if (keyAt2 == R.styleable.yoga_yg_width) {
                                    yogaNode.setWidthPercent(parseFloat);
                                }
                                yogaNode.setPositionPercent(yogaEdge, parseFloat);
                            }
                            yogaNode.setPaddingPercent(yogaEdge2, parseFloat);
                        }
                        yogaNode.setMarginPercent(yogaEdge3, parseFloat);
                    }
                }
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
            for (int i2 = 0; i2 < childCount; i2++) {
                if (equals(view)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i2), f2, f3);
                } else if (!(view instanceof YogaLayout)) {
                    applyLayoutRecursive(yogaNode.getChildAt(i2), yogaNode.getLayoutX() + f2, yogaNode.getLayoutY() + f3);
                }
            }
        }
    }

    private void createLayout(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65541, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
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
        int i2 = 0;
        while (true) {
            if (i2 >= owner.getChildCount()) {
                break;
            } else if (owner.getChildAt(i2).equals(yogaNode)) {
                owner.removeChildAt(i2);
                break;
            } else {
                i2++;
            }
        }
        yogaNode.setData(null);
        this.mYogaNodes.remove(view);
        if (z) {
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        YogaNode yogaNodeJNIFinalizer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, layoutParams) == null) {
            this.mYogaNode.setMeasureFunction(null);
            if (view instanceof VirtualYogaLayout) {
                VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
                virtualYogaLayout.transferChildren(this);
                YogaNode yogaNode = virtualYogaLayout.getYogaNode();
                YogaNode yogaNode2 = this.mYogaNode;
                yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
                return;
            }
            super.addView(view, i2, layoutParams);
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
            for (int i2 = 0; i2 < childCount; i2++) {
                YogaNode childAt = this.mYogaNode.getChildAt(i2);
                if (childAt.getData() instanceof YogaLayout) {
                    ((YogaLayout) childAt.getData()).invalidate(view);
                }
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (!(getParent() instanceof YogaLayout)) {
                createLayout(View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - i3, 1073741824));
            }
            applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (!(getParent() instanceof YogaLayout)) {
                createLayout(i2, i3);
            }
            setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                removeViewFromYogaTree(getChildAt(i2), false);
            }
            super.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                removeViewFromYogaTree(getChildAt(i2), true);
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
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            removeViewFromYogaTree(getChildAt(i2), false);
            super.removeViewAt(i2);
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
    public void removeViews(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                removeViewFromYogaTree(getChildAt(i4), false);
            }
            super.removeViews(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                removeViewFromYogaTree(getChildAt(i4), true);
            }
            super.removeViewsInLayout(i2, i3);
        }
    }
}
