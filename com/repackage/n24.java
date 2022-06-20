package com.repackage;

import android.graphics.Color;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tachikoma.core.component.TKBase;
/* loaded from: classes6.dex */
public class n24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    @V8JavascriptField
    public String backgroundColor;
    @V8JavascriptField
    public String borderColor;
    @V8JavascriptField
    public double borderRadius;
    @V8JavascriptField
    public int borderWidth;
    @V8JavascriptField
    public String color;
    @V8JavascriptField
    public double fontSize;
    @V8JavascriptField
    public String fontWeight;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public boolean hidden;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int lineHeight;
    @V8JavascriptField
    public double opacity;
    @V8JavascriptField
    public String textAlign;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes6.dex */
    public interface a {
        void s();
    }

    public n24(@NonNull zr1 zr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fontSize = 16.0d;
        this.opacity = 1.0d;
        a(zr1Var);
    }

    public static int c(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            float f = (((-16777216) & i) >>> 24) / 255.0f;
            return f > 0.0f ? Color.argb(255, (int) ((((16711680 & i) >> 16) * f) + 0.5d), (int) ((((65280 & i) >> 8) * f) + 0.5d), (int) (((i & 255) * f) + 0.5d)) : i;
        }
        return invokeI.intValue;
    }

    public final void a(@NonNull zr1 zr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zr1Var) == null) {
            this.left = zr1Var.r("left", this.left);
            this.top = zr1Var.r("top", this.top);
            this.width = zr1Var.r("width", this.width);
            this.height = zr1Var.r("height", this.height);
            this.backgroundColor = zr1Var.C("backgroundColor", this.backgroundColor);
            this.borderColor = zr1Var.C("borderColor", this.borderColor);
            this.borderRadius = zr1Var.n("borderRadius", this.borderRadius);
            this.borderWidth = zr1Var.r("borderWidth", this.borderWidth);
            this.fontSize = zr1Var.n(TtmlNode.ATTR_TTS_FONT_SIZE, this.fontSize);
            this.lineHeight = zr1Var.r("lineHeight", this.lineHeight);
            this.textAlign = zr1Var.C(TtmlNode.ATTR_TTS_TEXT_ALIGN, this.textAlign);
            this.fontWeight = zr1Var.C(TtmlNode.ATTR_TTS_FONT_WEIGHT, this.fontWeight);
            this.hidden = zr1Var.m(TKBase.VISIBILITY_HIDDEN, this.hidden);
            this.opacity = zr1Var.n(NativeConstants.OPACITY, this.opacity);
            this.color = zr1Var.C("color", this.color);
            if (cg1.a) {
                Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.a = aVar;
        }
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (cg1.a) {
                Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
            }
            a aVar = this.a;
            if (aVar != null) {
                aVar.s();
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
        }
        return (String) invokeV.objValue;
    }
}
