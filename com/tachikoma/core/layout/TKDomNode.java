package com.tachikoma.core.layout;

import android.os.SystemClock;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.yoga.YogaNode;
import com.kwad.yoga.YogaNodeJNIFinalizer;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.yoga.layout.YogaLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class TKDomNode<T extends View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap domAttr;
    public HashMap domStyle;
    public TKBase<T> linkView;
    public String nodeID;
    public YogaNode yogaNode;

    public TKDomNode(TKBase<T> tKBase, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKBase, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.linkView = tKBase;
        getYogaNode();
        this.domAttr = new HashMap();
        this.domStyle = new HashMap();
        this.nodeID = str == null ? createViewID() : str;
    }

    private void bindLayoutWithStyle(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, hashMap) == null) || hashMap == null) {
            return;
        }
        YogaNode yogaNode = getYogaNode();
        TKYogaConfig.applyLayoutBackgroudParams(yogaNode, this.linkView);
        if (yogaNode != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String obj = entry.getKey().toString();
                Object value = entry.getValue();
                if (!(value instanceof HashMap)) {
                    setLayoutNodeStyle(obj, value, yogaNode);
                }
            }
        }
    }

    private void configureLayout(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, hashMap) == null) || hashMap == null) {
            return;
        }
        bindLayoutWithStyle(hashMap);
    }

    private String createViewID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String valueOf = String.valueOf(SystemClock.uptimeMillis());
            return "_" + valueOf;
        }
        return (String) invokeV.objValue;
    }

    public static <T extends View> TKDomNode nodeForView(View view, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, strArr)) == null) {
            return new TKDomNode(null, strArr.length > 0 ? strArr[0] : null);
        }
        return (TKDomNode) invokeLL.objValue;
    }

    public static <T extends View> TKDomNode nodeForView(TKBase<T> tKBase, @Nullable List<Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, tKBase, list)) == null) ? new TKDomNode(tKBase, null) : (TKDomNode) invokeLL.objValue;
    }

    private void setLayoutNodeStyle(String str, Object obj, YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, this, str, obj, yogaNode) == null) || obj == null || str == null || yogaNode == null) {
            return;
        }
        TKYogaConfig.applyLayoutParams(yogaNode, str, obj);
    }

    private YogaLayout superview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.linkView.getView() instanceof YogaLayout) {
                return (YogaLayout) this.linkView.getView();
            }
            return null;
        }
        return (YogaLayout) invokeV.objValue;
    }

    public void addSubview(View view, YogaNode yogaNode) {
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, yogaNode) == null) || view == null || yogaNode == null || (superview = superview()) == null) {
            return;
        }
        int childCount = this.yogaNode.getChildCount();
        superview.addView(view, yogaNode);
        this.yogaNode.addChildAt(yogaNode, childCount);
    }

    public void addSubview(TKBase tKBase) {
        TKDomNode domNode;
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKBase) == null) || tKBase == null || (domNode = tKBase.getDomNode()) == null || (superview = superview()) == null) {
            return;
        }
        int childCount = this.yogaNode.getChildCount();
        YogaNode yogaNode = domNode.getYogaNode();
        superview.addView(tKBase.getView(), yogaNode);
        this.yogaNode.addChildAt(yogaNode, childCount);
    }

    public YogaNode getYogaNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.yogaNode == null) {
                if (this.linkView.getView() instanceof YogaLayout) {
                    this.yogaNode = ((YogaLayout) this.linkView.getView()).getYogaNode();
                } else {
                    YogaNodeJNIFinalizer yogaNodeJNIFinalizer = new YogaNodeJNIFinalizer();
                    this.yogaNode = yogaNodeJNIFinalizer;
                    yogaNodeJNIFinalizer.setData(this.linkView.getView());
                    this.yogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
                }
            }
            return this.yogaNode;
        }
        return (YogaNode) invokeV.objValue;
    }

    public void insertBefore(TKBase tKBase, TKBase tKBase2) {
        TKDomNode domNode;
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, tKBase, tKBase2) == null) || tKBase == null || (domNode = tKBase.getDomNode()) == null || (superview = superview()) == null) {
            return;
        }
        superview.addView(tKBase.getView(), domNode.getYogaNode());
        this.yogaNode.addChildAt(domNode.getYogaNode(), superview.indexOfChild(tKBase2.getView()));
    }

    public void layoutSubviews() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || superview() == null) {
            return;
        }
        this.yogaNode.calculateLayout(0.0f, 0.0f);
    }

    public void removeAllSubviews() {
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (superview = superview()) == null) {
            return;
        }
        superview.removeAllViews();
    }

    public void removeSubview(TKBase tKBase) {
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, tKBase) == null) || tKBase == null || tKBase.getDomNode() == null || (superview = superview()) == null) {
            return;
        }
        superview.removeView(tKBase.getView());
    }

    public void replaceSubview(TKBase tKBase, TKBase tKBase2) {
        TKDomNode domNode;
        YogaLayout superview;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, tKBase, tKBase2) == null) || tKBase == null || tKBase2 == null || (domNode = tKBase.getDomNode()) == null || (superview = superview()) == null) {
            return;
        }
        int indexOfChild = superview.indexOfChild(tKBase2.getView());
        removeSubview(tKBase2);
        superview.addView(tKBase.getView(), domNode.getYogaNode());
        this.yogaNode.addChildAt(domNode.getYogaNode(), indexOfChild);
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.domAttr.clear();
            this.domStyle.clear();
            YogaNode yogaNode = this.yogaNode;
            if (yogaNode != null) {
                yogaNode.setData(null);
                this.yogaNode = null;
            }
            this.nodeID = null;
            this.domStyle = null;
            this.domAttr = null;
            this.linkView = null;
        }
    }

    public void setDomStyle(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) || hashMap == null) {
            return;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String obj = entry.getKey().toString();
            (TKYogaConfig.defaultConfig().ygPropertyWithCSSStyle(obj) == Integer.MAX_VALUE ? this.domAttr : this.domStyle).put(obj, entry.getValue());
        }
        configureLayout(this.domStyle);
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(this.domAttr);
        hashMap2.putAll(this.domStyle);
        if (hashMap.equals(hashMap2)) {
            return;
        }
        this.linkView.getView().requestLayout();
    }

    public void setYogaNode(YogaNode yogaNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yogaNode) == null) {
            this.yogaNode = yogaNode;
        }
    }
}
