package com.tachikoma.core.component.text;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class SpanItem extends TKBase<View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String STYLE_BOLD = "bold";
    public static final String STYLE_BOLD_ITALIC = "bold_italic";
    public static final String STYLE_ITALIC = "italic";
    @Deprecated
    public static final String TYPE_ABSOLUTE_SIZE = "absoluteSize";
    public static final String TYPE_BACKGROUND_COLOR = "backgroundColor";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_FONT_FAMILY = "fontFamily";
    public static final String TYPE_FOREGROUND_COLOR = "foregroundColor";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_STRIKE_THROUGH = "strikeThrough";
    @Deprecated
    public static final String TYPE_TEXT_STYLE = "textStyle";
    public static final String TYPE_UNDERLINE = "underLine";
    public static final String TYPE_URL = "url";
    public transient /* synthetic */ FieldHolder $fh;
    public String color;
    public int end;
    public String fontFamily;
    public int imageHeight;
    public String imageUrl;
    public int imageWidth;
    public int index;
    public V8Function mV8Function;
    public float marginLeft;
    public float marginRight;
    public int offsetX;
    public float offsetY;
    public int size;
    public String spanType;
    public int start;
    public String textStyle;
    public String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpanItem(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public View createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public V8Function getV8Function() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mV8Function : (V8Function) invokeV.objValue;
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            V8Proxy.release(this.mV8Function);
            this.mV8Function = null;
        }
    }

    public void setColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.color = str;
        }
    }

    public void setSpanOnClickListener(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, v8Function) == null) && V8Proxy.isV8Valid(v8Function)) {
            this.mV8Function = v8Function.twin();
        }
    }
}
