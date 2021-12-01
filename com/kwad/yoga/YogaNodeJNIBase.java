package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte BORDER = 4;
    public static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    public static final byte HAS_NEW_LAYOUT = 16;
    public static final byte LAYOUT_BORDER_START_INDEX = 14;
    public static final byte LAYOUT_DIRECTION_INDEX = 5;
    public static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    public static final byte LAYOUT_HEIGHT_INDEX = 2;
    public static final byte LAYOUT_LEFT_INDEX = 3;
    public static final byte LAYOUT_MARGIN_START_INDEX = 6;
    public static final byte LAYOUT_PADDING_START_INDEX = 10;
    public static final byte LAYOUT_TOP_INDEX = 4;
    public static final byte LAYOUT_WIDTH_INDEX = 1;
    public static final byte MARGIN = 1;
    public static final byte PADDING = 2;
    public transient /* synthetic */ FieldHolder $fh;
    @DoNotStrip
    @Nullable
    public float[] arr;
    @Nullable
    public YogaBaselineFunction mBaselineFunction;
    @Nullable
    public List<YogaNodeJNIBase> mChildren;
    @Nullable
    public Object mData;
    public boolean mHasNewLayout;
    @DoNotStrip
    public int mLayoutDirection;
    @Nullable
    public YogaMeasureFunction mMeasureFunction;
    public long mNativePointer;
    @Nullable
    public YogaNodeJNIBase mOwner;

    /* renamed from: com.kwad.yoga.YogaNodeJNIBase$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$yoga$YogaEdge;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1378496413, "Lcom/kwad/yoga/YogaNodeJNIBase$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1378496413, "Lcom/kwad/yoga/YogaNodeJNIBase$1;");
                    return;
                }
            }
            int[] iArr = new int[YogaEdge.values().length];
            $SwitchMap$com$kwad$yoga$YogaEdge = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$yoga$YogaEdge[YogaEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$yoga$YogaEdge[YogaEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$yoga$YogaEdge[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$yoga$YogaEdge[YogaEdge.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$kwad$yoga$YogaEdge[YogaEdge.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNew());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public YogaNodeJNIBase(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j2 == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.mNativePointer = j2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YogaNodeJNIBase(YogaConfig yogaConfig) {
        this(YogaNative.jni_YGNodeNewWithConfig(yogaConfig.mNativePointer));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yogaConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void clearChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mChildren = null;
            YogaNative.jni_YGNodeClearChildren(this.mNativePointer);
        }
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, yogaNodeJNIBase, i2)) == null) {
            List<YogaNodeJNIBase> list = this.mChildren;
            if (list != null) {
                list.remove(i2);
                this.mChildren.add(i2, yogaNodeJNIBase);
                yogaNodeJNIBase.mOwner = this;
                return yogaNodeJNIBase.mNativePointer;
            }
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        return invokeLI.longValue;
    }

    public static YogaValue valueFromLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) ? new YogaValue(Float.intBitsToFloat((int) j2), (int) (j2 >> 32)) : (YogaValue) invokeJ.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void addChildAt(YogaNode yogaNode, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, yogaNode, i2) == null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            if (yogaNodeJNIBase.mOwner != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.mChildren == null) {
                this.mChildren = new ArrayList(4);
            }
            this.mChildren.add(i2, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            YogaNative.jni_YGNodeInsertChild(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i2);
        }
    }

    @DoNotStrip
    public final float baseline(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.mBaselineFunction.baseline(this, f2, f3) : invokeCommon.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void calculateLayout(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i2)).mChildren;
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
            YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
            long[] jArr = new long[yogaNodeJNIBaseArr.length];
            for (int i3 = 0; i3 < yogaNodeJNIBaseArr.length; i3++) {
                jArr[i3] = yogaNodeJNIBaseArr[i3].mNativePointer;
            }
            YogaNative.jni_YGNodeCalculateLayout(this.mNativePointer, f2, f3, jArr, yogaNodeJNIBaseArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.yoga.YogaNode
    public YogaNodeJNIBase cloneWithoutChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
                long jni_YGNodeClone = YogaNative.jni_YGNodeClone(this.mNativePointer);
                yogaNodeJNIBase.mOwner = null;
                yogaNodeJNIBase.mNativePointer = jni_YGNodeClone;
                yogaNodeJNIBase.clearChildren();
                return yogaNodeJNIBase;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (YogaNodeJNIBase) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void copyStyle(YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yogaNode) == null) {
            YogaNative.jni_YGNodeCopyStyle(this.mNativePointer, ((YogaNodeJNIBase) yogaNode).mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void dirty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            YogaNative.jni_YGNodeMarkDirty(this.mNativePointer);
        }
    }

    public void dirtyAllDescendants() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaAlign getAlignContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContent(this.mNativePointer)) : (YogaAlign) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaAlign getAlignItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItems(this.mNativePointer)) : (YogaAlign) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaAlign getAlignSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelf(this.mNativePointer)) : (YogaAlign) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getAspectRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? YogaNative.jni_YGNodeStyleGetAspectRatio(this.mNativePointer) : invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getBorder(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, yogaEdge)) == null) ? YogaNative.jni_YGNodeStyleGetBorder(this.mNativePointer, yogaEdge.intValue()) : invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.yoga.YogaNode
    public YogaNodeJNIBase getChildAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            List<YogaNodeJNIBase> list = this.mChildren;
            if (list != null) {
                return list.get(i2);
            }
            throw new IllegalStateException("YogaNode does not have children");
        }
        return (YogaNodeJNIBase) invokeI.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            List<YogaNodeJNIBase> list = this.mChildren;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.yoga.YogaNode
    @Nullable
    public Object getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mData : invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaDisplay getDisplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplay(this.mNativePointer)) : (YogaDisplay) invokeV.objValue;
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            float[] fArr = this.arr;
            return fArr != null && (((int) fArr[0]) & 8) == 8;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getFlex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? YogaNative.jni_YGNodeStyleGetFlex(this.mNativePointer) : invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getFlexBasis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasis(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaFlexDirection getFlexDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirection(this.mNativePointer)) : (YogaFlexDirection) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getFlexGrow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? YogaNative.jni_YGNodeStyleGetFlexGrow(this.mNativePointer) : invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getFlexShrink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? YogaNative.jni_YGNodeStyleGetFlexShrink(this.mNativePointer) : invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetHeight(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaJustify getJustifyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContent(this.mNativePointer)) : (YogaJustify) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutBorder(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, yogaEdge)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                if ((((int) fArr[0]) & 4) == 4) {
                    int i2 = (14 - ((((int) fArr[0]) & 1) == 1 ? 0 : 4)) - ((((int) this.arr[0]) & 2) != 2 ? 4 : 0);
                    switch (AnonymousClass1.$SwitchMap$com$kwad$yoga$YogaEdge[yogaEdge.ordinal()]) {
                        case 1:
                            return this.arr[i2];
                        case 2:
                            return this.arr[i2 + 1];
                        case 3:
                            return this.arr[i2 + 2];
                        case 4:
                            return this.arr[i2 + 3];
                        case 5:
                            return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2 + 2] : this.arr[i2];
                        case 6:
                            return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2] : this.arr[i2 + 2];
                        default:
                            throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
                    }
                }
                return 0.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            float[] fArr = this.arr;
            return YogaDirection.fromInt(fArr != null ? (int) fArr[5] : this.mLayoutDirection);
        }
        return (YogaDirection) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                return fArr[2];
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutMargin(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, yogaEdge)) == null) {
            float[] fArr = this.arr;
            if (fArr == null || (((int) fArr[0]) & 1) != 1) {
                return 0.0f;
            }
            switch (AnonymousClass1.$SwitchMap$com$kwad$yoga$YogaEdge[yogaEdge.ordinal()]) {
                case 1:
                    return this.arr[6];
                case 2:
                    return this.arr[7];
                case 3:
                    return this.arr[8];
                case 4:
                    return this.arr[9];
                case 5:
                    return getLayoutDirection() == YogaDirection.RTL ? this.arr[8] : this.arr[6];
                case 6:
                    return getLayoutDirection() == YogaDirection.RTL ? this.arr[6] : this.arr[8];
                default:
                    throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
            }
        }
        return invokeL.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutPadding(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, yogaEdge)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                if ((((int) fArr[0]) & 2) == 2) {
                    int i2 = 10 - ((((int) fArr[0]) & 1) != 1 ? 4 : 0);
                    switch (AnonymousClass1.$SwitchMap$com$kwad$yoga$YogaEdge[yogaEdge.ordinal()]) {
                        case 1:
                            return this.arr[i2];
                        case 2:
                            return this.arr[i2 + 1];
                        case 3:
                            return this.arr[i2 + 2];
                        case 4:
                            return this.arr[i2 + 3];
                        case 5:
                            return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2 + 2] : this.arr[i2];
                        case 6:
                            return getLayoutDirection() == YogaDirection.RTL ? this.arr[i2] : this.arr[i2 + 2];
                        default:
                            throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
                    }
                }
                return 0.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                return fArr[1];
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                return fArr[3];
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public float getLayoutY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                return fArr[4];
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getMargin(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, yogaEdge)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetMargin(this.mNativePointer, yogaEdge.intValue())) : (YogaValue) invokeL.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeight(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidth(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeight(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidth(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaOverflow getOverflow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflow(this.mNativePointer)) : (YogaOverflow) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.yoga.YogaNode
    @Nullable
    public YogaNodeJNIBase getOwner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mOwner : (YogaNodeJNIBase) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getPadding(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, yogaEdge)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetPadding(this.mNativePointer, yogaEdge.intValue())) : (YogaValue) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.yoga.YogaNode
    @Nullable
    @Deprecated
    public YogaNodeJNIBase getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? getOwner() : (YogaNodeJNIBase) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getPosition(YogaEdge yogaEdge) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, yogaEdge)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetPosition(this.mNativePointer, yogaEdge.intValue())) : (YogaValue) invokeL.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaPositionType getPositionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionType(this.mNativePointer)) : (YogaPositionType) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaDirection getStyleDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirection(this.mNativePointer)) : (YogaDirection) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaValue getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? valueFromLong(YogaNative.jni_YGNodeStyleGetWidth(this.mNativePointer)) : (YogaValue) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public YogaWrap getWrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrap(this.mNativePointer)) : (YogaWrap) invokeV.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public boolean hasNewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            float[] fArr = this.arr;
            return fArr != null ? (((int) fArr[0]) & 16) == 16 : this.mHasNewLayout;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public int indexOf(YogaNode yogaNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, yogaNode)) == null) {
            List<YogaNodeJNIBase> list = this.mChildren;
            if (list == null) {
                return -1;
            }
            return list.indexOf(yogaNode);
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public boolean isBaselineDefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mBaselineFunction != null : invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public boolean isDirty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? YogaNative.jni_YGNodeIsDirty(this.mNativePointer) : invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public boolean isMeasureDefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mMeasureFunction != null : invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public boolean isReferenceBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? YogaNative.jni_YGNodeIsReferenceBaseline(this.mNativePointer) : invokeV.booleanValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void markLayoutSeen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            float[] fArr = this.arr;
            if (fArr != null) {
                fArr[0] = ((int) fArr[0]) & (-17);
            }
            this.mHasNewLayout = false;
        }
    }

    @DoNotStrip
    public final long measure(float f2, int i2, float f3, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(i3)})) == null) {
            if (isMeasureDefined()) {
                return this.mMeasureFunction.measure(this, f2, YogaMeasureMode.fromInt(i2), f3, YogaMeasureMode.fromInt(i3));
            }
            throw new RuntimeException("Measure function isn't defined!");
        }
        return invokeCommon.longValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void print() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            YogaNative.jni_YGNodePrint(this.mNativePointer);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.yoga.YogaNode
    public YogaNodeJNIBase removeChildAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            List<YogaNodeJNIBase> list = this.mChildren;
            if (list != null) {
                YogaNodeJNIBase remove = list.remove(i2);
                remove.mOwner = null;
                YogaNative.jni_YGNodeRemoveChild(this.mNativePointer, remove.mNativePointer);
                return remove;
            }
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        return (YogaNodeJNIBase) invokeI.objValue;
    }

    @Override // com.kwad.yoga.YogaNode
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.mMeasureFunction = null;
            this.mBaselineFunction = null;
            this.mData = null;
            this.arr = null;
            this.mHasNewLayout = true;
            this.mLayoutDirection = 0;
            YogaNative.jni_YGNodeReset(this.mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setAlignContent(YogaAlign yogaAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, yogaAlign) == null) {
            YogaNative.jni_YGNodeStyleSetAlignContent(this.mNativePointer, yogaAlign.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setAlignItems(YogaAlign yogaAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yogaAlign) == null) {
            YogaNative.jni_YGNodeStyleSetAlignItems(this.mNativePointer, yogaAlign.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setAlignSelf(YogaAlign yogaAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, yogaAlign) == null) {
            YogaNative.jni_YGNodeStyleSetAlignSelf(this.mNativePointer, yogaAlign.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setAspectRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048641, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetAspectRatio(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, yogaBaselineFunction) == null) {
            this.mBaselineFunction = yogaBaselineFunction;
            YogaNative.jni_YGNodeSetHasBaselineFunc(this.mNativePointer, yogaBaselineFunction != null);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setBorder(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048643, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetBorder(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setData(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, obj) == null) {
            this.mData = obj;
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setDirection(YogaDirection yogaDirection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, yogaDirection) == null) {
            YogaNative.jni_YGNodeStyleSetDirection(this.mNativePointer, yogaDirection.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setDisplay(YogaDisplay yogaDisplay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, yogaDisplay) == null) {
            YogaNative.jni_YGNodeStyleSetDisplay(this.mNativePointer, yogaDisplay.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlex(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048647, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetFlex(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexBasis(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048648, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetFlexBasis(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexBasisAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            YogaNative.jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexBasisPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, yogaFlexDirection) == null) {
            YogaNative.jni_YGNodeStyleSetFlexDirection(this.mNativePointer, yogaFlexDirection.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexGrow(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048652, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetFlexGrow(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setFlexShrink(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048653, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetFlexShrink(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetHeight(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setHeightAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            YogaNative.jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setHeightPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048656, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetHeightPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setIsReferenceBaseline(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            YogaNative.jni_YGNodeSetIsReferenceBaseline(this.mNativePointer, z);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setJustifyContent(YogaJustify yogaJustify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, yogaJustify) == null) {
            YogaNative.jni_YGNodeStyleSetJustifyContent(this.mNativePointer, yogaJustify.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMargin(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048659, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMargin(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMarginAuto(YogaEdge yogaEdge) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, yogaEdge) == null) {
            YogaNative.jni_YGNodeStyleSetMarginAuto(this.mNativePointer, yogaEdge.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMarginPercent(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048661, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMarginPercent(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMaxHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048662, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMaxHeight(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMaxHeightPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048663, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMaxWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048664, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMaxWidth(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMaxWidthPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048665, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, yogaMeasureFunction) == null) {
            this.mMeasureFunction = yogaMeasureFunction;
            YogaNative.jni_YGNodeSetHasMeasureFunc(this.mNativePointer, yogaMeasureFunction != null);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMinHeight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048667, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMinHeight(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMinHeightPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048668, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMinWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048669, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMinWidth(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setMinWidthPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048670, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setOverflow(YogaOverflow yogaOverflow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, yogaOverflow) == null) {
            YogaNative.jni_YGNodeStyleSetOverflow(this.mNativePointer, yogaOverflow.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setPadding(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048672, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetPadding(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setPaddingPercent(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048673, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setPosition(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048674, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetPosition(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setPositionPercent(YogaEdge yogaEdge, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048675, this, yogaEdge, f2) == null) {
            YogaNative.jni_YGNodeStyleSetPositionPercent(this.mNativePointer, yogaEdge.intValue(), f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setPositionType(YogaPositionType yogaPositionType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, yogaPositionType) == null) {
            YogaNative.jni_YGNodeStyleSetPositionType(this.mNativePointer, yogaPositionType.intValue());
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setStyleInputs(float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048677, this, fArr, i2) == null) {
            YogaNative.jni_YGNodeSetStyleInputs(this.mNativePointer, fArr, i2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048678, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetWidth(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setWidthAuto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            YogaNative.jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setWidthPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048680, this, f2) == null) {
            YogaNative.jni_YGNodeStyleSetWidthPercent(this.mNativePointer, f2);
        }
    }

    @Override // com.kwad.yoga.YogaNode
    public void setWrap(YogaWrap yogaWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, yogaWrap) == null) {
            YogaNative.jni_YGNodeStyleSetFlexWrap(this.mNativePointer, yogaWrap.intValue());
        }
    }
}
