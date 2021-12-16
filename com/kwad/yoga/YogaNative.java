package com.kwad.yoga;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes3.dex */
public class YogaNative {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1786271707, "Lcom/kwad/yoga/YogaNative;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1786271707, "Lcom/kwad/yoga/YogaNative;");
                return;
            }
        }
        System.loadLibrary("kwad-yoga");
    }

    public YogaNative() {
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

    public static native void jni_YGConfigFree(long j2);

    public static native long jni_YGConfigNew();

    public static native void jni_YGConfigSetExperimentalFeatureEnabled(long j2, int i2, boolean z);

    public static native void jni_YGConfigSetLogger(long j2, Object obj);

    public static native void jni_YGConfigSetPointScaleFactor(long j2, float f2);

    public static native void jni_YGConfigSetPrintTreeFlag(long j2, boolean z);

    public static native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(long j2, boolean z);

    public static native void jni_YGConfigSetUseLegacyStretchBehaviour(long j2, boolean z);

    public static native void jni_YGConfigSetUseWebDefaults(long j2, boolean z);

    public static native void jni_YGNodeCalculateLayout(long j2, float f2, float f3, long[] jArr, YogaNodeJNIBase[] yogaNodeJNIBaseArr);

    public static native void jni_YGNodeClearChildren(long j2);

    public static native long jni_YGNodeClone(long j2);

    public static native void jni_YGNodeCopyStyle(long j2, long j3);

    public static native void jni_YGNodeFree(long j2);

    public static native void jni_YGNodeInsertChild(long j2, long j3, int i2);

    public static native boolean jni_YGNodeIsDirty(long j2);

    public static native boolean jni_YGNodeIsReferenceBaseline(long j2);

    public static native void jni_YGNodeMarkDirty(long j2);

    public static native void jni_YGNodeMarkDirtyAndPropogateToDescendants(long j2);

    public static native long jni_YGNodeNew();

    public static native long jni_YGNodeNewWithConfig(long j2);

    public static native void jni_YGNodePrint(long j2);

    public static native void jni_YGNodeRemoveChild(long j2, long j3);

    public static native void jni_YGNodeReset(long j2);

    public static native void jni_YGNodeSetHasBaselineFunc(long j2, boolean z);

    public static native void jni_YGNodeSetHasMeasureFunc(long j2, boolean z);

    public static native void jni_YGNodeSetIsReferenceBaseline(long j2, boolean z);

    public static native void jni_YGNodeSetStyleInputs(long j2, float[] fArr, int i2);

    public static native int jni_YGNodeStyleGetAlignContent(long j2);

    public static native int jni_YGNodeStyleGetAlignItems(long j2);

    public static native int jni_YGNodeStyleGetAlignSelf(long j2);

    public static native float jni_YGNodeStyleGetAspectRatio(long j2);

    public static native float jni_YGNodeStyleGetBorder(long j2, int i2);

    public static native int jni_YGNodeStyleGetDirection(long j2);

    public static native int jni_YGNodeStyleGetDisplay(long j2);

    public static native float jni_YGNodeStyleGetFlex(long j2);

    public static native long jni_YGNodeStyleGetFlexBasis(long j2);

    public static native int jni_YGNodeStyleGetFlexDirection(long j2);

    public static native float jni_YGNodeStyleGetFlexGrow(long j2);

    public static native float jni_YGNodeStyleGetFlexShrink(long j2);

    public static native int jni_YGNodeStyleGetFlexWrap(long j2);

    public static native long jni_YGNodeStyleGetHeight(long j2);

    public static native int jni_YGNodeStyleGetJustifyContent(long j2);

    public static native long jni_YGNodeStyleGetMargin(long j2, int i2);

    public static native long jni_YGNodeStyleGetMaxHeight(long j2);

    public static native long jni_YGNodeStyleGetMaxWidth(long j2);

    public static native long jni_YGNodeStyleGetMinHeight(long j2);

    public static native long jni_YGNodeStyleGetMinWidth(long j2);

    public static native int jni_YGNodeStyleGetOverflow(long j2);

    public static native long jni_YGNodeStyleGetPadding(long j2, int i2);

    public static native long jni_YGNodeStyleGetPosition(long j2, int i2);

    public static native int jni_YGNodeStyleGetPositionType(long j2);

    public static native long jni_YGNodeStyleGetWidth(long j2);

    public static native void jni_YGNodeStyleSetAlignContent(long j2, int i2);

    public static native void jni_YGNodeStyleSetAlignItems(long j2, int i2);

    public static native void jni_YGNodeStyleSetAlignSelf(long j2, int i2);

    public static native void jni_YGNodeStyleSetAspectRatio(long j2, float f2);

    public static native void jni_YGNodeStyleSetBorder(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetDirection(long j2, int i2);

    public static native void jni_YGNodeStyleSetDisplay(long j2, int i2);

    public static native void jni_YGNodeStyleSetFlex(long j2, float f2);

    public static native void jni_YGNodeStyleSetFlexBasis(long j2, float f2);

    public static native void jni_YGNodeStyleSetFlexBasisAuto(long j2);

    public static native void jni_YGNodeStyleSetFlexBasisPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetFlexDirection(long j2, int i2);

    public static native void jni_YGNodeStyleSetFlexGrow(long j2, float f2);

    public static native void jni_YGNodeStyleSetFlexShrink(long j2, float f2);

    public static native void jni_YGNodeStyleSetFlexWrap(long j2, int i2);

    public static native void jni_YGNodeStyleSetHeight(long j2, float f2);

    public static native void jni_YGNodeStyleSetHeightAuto(long j2);

    public static native void jni_YGNodeStyleSetHeightPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetJustifyContent(long j2, int i2);

    public static native void jni_YGNodeStyleSetMargin(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetMarginAuto(long j2, int i2);

    public static native void jni_YGNodeStyleSetMarginPercent(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetMaxHeight(long j2, float f2);

    public static native void jni_YGNodeStyleSetMaxHeightPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetMaxWidth(long j2, float f2);

    public static native void jni_YGNodeStyleSetMaxWidthPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetMinHeight(long j2, float f2);

    public static native void jni_YGNodeStyleSetMinHeightPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetMinWidth(long j2, float f2);

    public static native void jni_YGNodeStyleSetMinWidthPercent(long j2, float f2);

    public static native void jni_YGNodeStyleSetOverflow(long j2, int i2);

    public static native void jni_YGNodeStyleSetPadding(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetPaddingPercent(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetPosition(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetPositionPercent(long j2, int i2, float f2);

    public static native void jni_YGNodeStyleSetPositionType(long j2, int i2);

    public static native void jni_YGNodeStyleSetWidth(long j2, float f2);

    public static native void jni_YGNodeStyleSetWidthAuto(long j2);

    public static native void jni_YGNodeStyleSetWidthPercent(long j2, float f2);
}
