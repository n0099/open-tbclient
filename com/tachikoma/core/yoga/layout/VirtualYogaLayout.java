package com.tachikoma.core.yoga.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNode;
import com.kwad.yoga.YogaNodeJNIFinalizer;
import com.tachikoma.core.yoga.layout.YogaLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class VirtualYogaLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<View> mChildren;
    public final YogaNode mYogaNode;
    public final Map<View, YogaNode> mYogaNodes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualYogaLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = new YogaNodeJNIFinalizer();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualYogaLayout(Context context, AttributeSet attributeSet) {
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
    public VirtualYogaLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = new YogaNodeJNIFinalizer();
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(context, attributeSet), this.mYogaNode, this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            if (view2 instanceof VirtualYogaLayout) {
                VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view2;
                virtualYogaLayout.transferChildren(this);
                YogaNode yogaNode = virtualYogaLayout.getYogaNode();
                YogaNode yogaNode2 = this.mYogaNode;
                yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
                return;
            }
            YogaNodeJNIFinalizer yogaNodeJNIFinalizer = new YogaNodeJNIFinalizer();
            YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(layoutParams), yogaNodeJNIFinalizer, view2);
            yogaNodeJNIFinalizer.setData(view2);
            yogaNodeJNIFinalizer.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
            YogaNode yogaNode3 = this.mYogaNode;
            yogaNode3.addChildAt(yogaNodeJNIFinalizer, yogaNode3.getChildCount());
            addView(view2, yogaNodeJNIFinalizer);
        }
    }

    public void addView(View view2, YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yogaNode) == null) {
            this.mChildren.add(view2);
            this.mYogaNodes.put(view2, yogaNode);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof YogaLayout.LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new YogaLayout.LayoutParams(-1, -1) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, attributeSet)) == null) ? new YogaLayout.LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) ? new YogaLayout.LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public YogaNode getYogaNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mYogaNode : (YogaNode) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
        }
    }

    public void transferChildren(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            if (viewGroup instanceof VirtualYogaLayout) {
                for (View view2 : this.mChildren) {
                    ((VirtualYogaLayout) viewGroup).addView(view2, this.mYogaNodes.get(view2));
                }
            } else if (!(viewGroup instanceof YogaLayout)) {
                throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
            } else {
                for (View view3 : this.mChildren) {
                    ((YogaLayout) viewGroup).addView(view3, this.mYogaNodes.get(view3));
                }
            }
            this.mChildren.clear();
        }
    }
}
