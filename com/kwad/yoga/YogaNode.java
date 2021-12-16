package com.kwad.yoga;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class YogaNode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public YogaNode() {
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

    public static YogaNode create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new YogaNodeJNIFinalizer() : (YogaNode) invokeV.objValue;
    }

    public static YogaNode create(YogaConfig yogaConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yogaConfig)) == null) ? new YogaNodeJNIFinalizer(yogaConfig) : (YogaNode) invokeL.objValue;
    }

    public abstract void addChildAt(YogaNode yogaNode, int i2);

    public abstract void calculateLayout(float f2, float f3);

    public abstract YogaNode cloneWithoutChildren();

    public abstract void copyStyle(YogaNode yogaNode);

    public abstract void dirty();

    public abstract YogaAlign getAlignContent();

    public abstract YogaAlign getAlignItems();

    public abstract YogaAlign getAlignSelf();

    public abstract float getAspectRatio();

    public abstract float getBorder(YogaEdge yogaEdge);

    public abstract YogaNode getChildAt(int i2);

    public abstract int getChildCount();

    @Nullable
    public abstract Object getData();

    public abstract YogaDisplay getDisplay();

    public abstract float getFlex();

    public abstract YogaValue getFlexBasis();

    public abstract YogaFlexDirection getFlexDirection();

    public abstract float getFlexGrow();

    public abstract float getFlexShrink();

    public abstract YogaValue getHeight();

    public abstract YogaJustify getJustifyContent();

    public abstract float getLayoutBorder(YogaEdge yogaEdge);

    public abstract YogaDirection getLayoutDirection();

    public abstract float getLayoutHeight();

    public abstract float getLayoutMargin(YogaEdge yogaEdge);

    public abstract float getLayoutPadding(YogaEdge yogaEdge);

    public abstract float getLayoutWidth();

    public abstract float getLayoutX();

    public abstract float getLayoutY();

    public abstract YogaValue getMargin(YogaEdge yogaEdge);

    public abstract YogaValue getMaxHeight();

    public abstract YogaValue getMaxWidth();

    public abstract YogaValue getMinHeight();

    public abstract YogaValue getMinWidth();

    public abstract YogaOverflow getOverflow();

    @Nullable
    public abstract YogaNode getOwner();

    public abstract YogaValue getPadding(YogaEdge yogaEdge);

    @Nullable
    @Deprecated
    public abstract YogaNode getParent();

    public abstract YogaValue getPosition(YogaEdge yogaEdge);

    public abstract YogaPositionType getPositionType();

    public abstract YogaDirection getStyleDirection();

    public abstract YogaValue getWidth();

    public abstract YogaWrap getWrap();

    public abstract boolean hasNewLayout();

    public abstract int indexOf(YogaNode yogaNode);

    public abstract boolean isBaselineDefined();

    public abstract boolean isDirty();

    public abstract boolean isMeasureDefined();

    public abstract boolean isReferenceBaseline();

    public abstract void markLayoutSeen();

    public abstract void print();

    public abstract YogaNode removeChildAt(int i2);

    public abstract void reset();

    public abstract void setAlignContent(YogaAlign yogaAlign);

    public abstract void setAlignItems(YogaAlign yogaAlign);

    public abstract void setAlignSelf(YogaAlign yogaAlign);

    public abstract void setAspectRatio(float f2);

    public abstract void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    public abstract void setBorder(YogaEdge yogaEdge, float f2);

    public abstract void setData(Object obj);

    public abstract void setDirection(YogaDirection yogaDirection);

    public abstract void setDisplay(YogaDisplay yogaDisplay);

    public abstract void setFlex(float f2);

    public abstract void setFlexBasis(float f2);

    public abstract void setFlexBasisAuto();

    public abstract void setFlexBasisPercent(float f2);

    public abstract void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    public abstract void setFlexGrow(float f2);

    public abstract void setFlexShrink(float f2);

    public abstract void setHeight(float f2);

    public abstract void setHeightAuto();

    public abstract void setHeightPercent(float f2);

    public abstract void setIsReferenceBaseline(boolean z);

    public abstract void setJustifyContent(YogaJustify yogaJustify);

    public abstract void setMargin(YogaEdge yogaEdge, float f2);

    public abstract void setMarginAuto(YogaEdge yogaEdge);

    public abstract void setMarginPercent(YogaEdge yogaEdge, float f2);

    public abstract void setMaxHeight(float f2);

    public abstract void setMaxHeightPercent(float f2);

    public abstract void setMaxWidth(float f2);

    public abstract void setMaxWidthPercent(float f2);

    public abstract void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction);

    public abstract void setMinHeight(float f2);

    public abstract void setMinHeightPercent(float f2);

    public abstract void setMinWidth(float f2);

    public abstract void setMinWidthPercent(float f2);

    public abstract void setOverflow(YogaOverflow yogaOverflow);

    public abstract void setPadding(YogaEdge yogaEdge, float f2);

    public abstract void setPaddingPercent(YogaEdge yogaEdge, float f2);

    public abstract void setPosition(YogaEdge yogaEdge, float f2);

    public abstract void setPositionPercent(YogaEdge yogaEdge, float f2);

    public abstract void setPositionType(YogaPositionType yogaPositionType);

    public abstract void setStyleInputs(float[] fArr, int i2);

    public abstract void setWidth(float f2);

    public abstract void setWidthAuto();

    public abstract void setWidthPercent(float f2);

    public abstract void setWrap(YogaWrap yogaWrap);
}
