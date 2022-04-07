package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class WebvttCssStyle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int backgroundColor;
    public int bold;
    public int fontColor;
    public String fontFamily;
    public float fontSize;
    public int fontSizeUnit;
    public boolean hasBackgroundColor;
    public boolean hasFontColor;
    public int italic;
    public int linethrough;
    public List<String> targetClasses;
    public String targetId;
    public String targetTag;
    public String targetVoice;
    public Layout.Alignment textAlign;
    public int underline;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface FontSizeUnit {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface StyleFlags {
    }

    public WebvttCssStyle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        reset();
    }

    public static int updateScoreForMatch(int i, String str, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)})) == null) {
            if (str.isEmpty() || i == -1) {
                return i;
            }
            if (str.equals(str2)) {
                return i + i2;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public void cascadeFrom(WebvttCssStyle webvttCssStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webvttCssStyle) == null) {
            if (webvttCssStyle.hasFontColor) {
                setFontColor(webvttCssStyle.fontColor);
            }
            int i = webvttCssStyle.bold;
            if (i != -1) {
                this.bold = i;
            }
            int i2 = webvttCssStyle.italic;
            if (i2 != -1) {
                this.italic = i2;
            }
            String str = webvttCssStyle.fontFamily;
            if (str != null) {
                this.fontFamily = str;
            }
            if (this.linethrough == -1) {
                this.linethrough = webvttCssStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = webvttCssStyle.underline;
            }
            if (this.textAlign == null) {
                this.textAlign = webvttCssStyle.textAlign;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = webvttCssStyle.fontSizeUnit;
                this.fontSize = webvttCssStyle.fontSize;
            }
            if (webvttCssStyle.hasBackgroundColor) {
                setBackgroundColor(webvttCssStyle.backgroundColor);
            }
        }
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.hasBackgroundColor) {
                return this.backgroundColor;
            }
            throw new IllegalStateException("Background color not defined.");
        }
        return invokeV.intValue;
    }

    public int getFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.hasFontColor) {
                return this.fontColor;
            }
            throw new IllegalStateException("Font color not defined");
        }
        return invokeV.intValue;
    }

    public String getFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fontFamily : (String) invokeV.objValue;
    }

    public float getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fontSize : invokeV.floatValue;
    }

    public int getFontSizeUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.fontSizeUnit : invokeV.intValue;
    }

    public int getSpecificityScore(String str, String str2, String[] strArr, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, str, str2, strArr, str3)) == null) {
            if (this.targetId.isEmpty() && this.targetTag.isEmpty() && this.targetClasses.isEmpty() && this.targetVoice.isEmpty()) {
                return str2.isEmpty() ? 1 : 0;
            }
            int updateScoreForMatch = updateScoreForMatch(updateScoreForMatch(updateScoreForMatch(0, this.targetId, str, 1073741824), this.targetTag, str2, 2), this.targetVoice, str3, 4);
            if (updateScoreForMatch == -1 || !Arrays.asList(strArr).containsAll(this.targetClasses)) {
                return 0;
            }
            return updateScoreForMatch + (this.targetClasses.size() * 4);
        }
        return invokeLLLL.intValue;
    }

    public int getStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.bold == -1 && this.italic == -1) {
                return -1;
            }
            return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
        }
        return invokeV.intValue;
    }

    public Layout.Alignment getTextAlign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.textAlign : (Layout.Alignment) invokeV.objValue;
    }

    public boolean hasBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.hasBackgroundColor : invokeV.booleanValue;
    }

    public boolean hasFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.hasFontColor : invokeV.booleanValue;
    }

    public boolean isLinethrough() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.linethrough == 1 : invokeV.booleanValue;
    }

    public boolean isUnderline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.underline == 1 : invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.targetId = "";
            this.targetTag = "";
            this.targetClasses = Collections.emptyList();
            this.targetVoice = "";
            this.fontFamily = null;
            this.hasFontColor = false;
            this.hasBackgroundColor = false;
            this.linethrough = -1;
            this.underline = -1;
            this.bold = -1;
            this.italic = -1;
            this.fontSizeUnit = -1;
            this.textAlign = null;
        }
    }

    public WebvttCssStyle setBackgroundColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.backgroundColor = i;
            this.hasBackgroundColor = true;
            return this;
        }
        return (WebvttCssStyle) invokeI.objValue;
    }

    public WebvttCssStyle setBold(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.bold = z ? 1 : 0;
            return this;
        }
        return (WebvttCssStyle) invokeZ.objValue;
    }

    public WebvttCssStyle setFontColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.fontColor = i;
            this.hasFontColor = true;
            return this;
        }
        return (WebvttCssStyle) invokeI.objValue;
    }

    public WebvttCssStyle setFontFamily(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.fontFamily = Util.toLowerInvariant(str);
            return this;
        }
        return (WebvttCssStyle) invokeL.objValue;
    }

    public WebvttCssStyle setFontSize(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f)) == null) {
            this.fontSize = f;
            return this;
        }
        return (WebvttCssStyle) invokeF.objValue;
    }

    public WebvttCssStyle setFontSizeUnit(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Short.valueOf(s)})) == null) {
            this.fontSizeUnit = s;
            return this;
        }
        return (WebvttCssStyle) invokeCommon.objValue;
    }

    public WebvttCssStyle setItalic(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.italic = z ? 1 : 0;
            return this;
        }
        return (WebvttCssStyle) invokeZ.objValue;
    }

    public WebvttCssStyle setLinethrough(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            this.linethrough = z ? 1 : 0;
            return this;
        }
        return (WebvttCssStyle) invokeZ.objValue;
    }

    public void setTargetClasses(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, strArr) == null) {
            this.targetClasses = Arrays.asList(strArr);
        }
    }

    public void setTargetId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.targetId = str;
        }
    }

    public void setTargetTagName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.targetTag = str;
        }
    }

    public void setTargetVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.targetVoice = str;
        }
    }

    public WebvttCssStyle setTextAlign(Layout.Alignment alignment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, alignment)) == null) {
            this.textAlign = alignment;
            return this;
        }
        return (WebvttCssStyle) invokeL.objValue;
    }

    public WebvttCssStyle setUnderline(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            this.underline = z ? 1 : 0;
            return this;
        }
        return (WebvttCssStyle) invokeZ.objValue;
    }
}
