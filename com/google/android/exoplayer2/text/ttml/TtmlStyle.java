package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes7.dex */
public final class TtmlStyle {
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
    public String id;
    public TtmlStyle inheritableStyle;
    public int italic;
    public int linethrough;
    public Layout.Alignment textAlign;
    public int underline;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface FontSizeUnit {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface StyleFlags {
    }

    public TtmlStyle() {
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
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.hasBackgroundColor) {
                return this.backgroundColor;
            }
            throw new IllegalStateException("Background color has not been defined.");
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
            throw new IllegalStateException("Font color has not been defined.");
        }
        return invokeV.intValue;
    }

    public String getFontFamily() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fontFamily;
        }
        return (String) invokeV.objValue;
    }

    public float getFontSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.fontSize;
        }
        return invokeV.floatValue;
    }

    public int getFontSizeUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.fontSizeUnit;
        }
        return invokeV.intValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public int getStyle() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.bold == -1 && this.italic == -1) {
                return -1;
            }
            int i2 = 0;
            if (this.bold == 1) {
                i = 1;
            } else {
                i = 0;
            }
            if (this.italic == 1) {
                i2 = 2;
            }
            return i | i2;
        }
        return invokeV.intValue;
    }

    public Layout.Alignment getTextAlign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.textAlign;
        }
        return (Layout.Alignment) invokeV.objValue;
    }

    public boolean hasBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.hasBackgroundColor;
        }
        return invokeV.booleanValue;
    }

    public boolean hasFontColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.hasFontColor;
        }
        return invokeV.booleanValue;
    }

    public boolean isLinethrough() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.linethrough == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isUnderline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.underline == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, ttmlStyle, z)) == null) {
            if (ttmlStyle != null) {
                if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                    setFontColor(ttmlStyle.fontColor);
                }
                if (this.bold == -1) {
                    this.bold = ttmlStyle.bold;
                }
                if (this.italic == -1) {
                    this.italic = ttmlStyle.italic;
                }
                if (this.fontFamily == null) {
                    this.fontFamily = ttmlStyle.fontFamily;
                }
                if (this.linethrough == -1) {
                    this.linethrough = ttmlStyle.linethrough;
                }
                if (this.underline == -1) {
                    this.underline = ttmlStyle.underline;
                }
                if (this.textAlign == null) {
                    this.textAlign = ttmlStyle.textAlign;
                }
                if (this.fontSizeUnit == -1) {
                    this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                    this.fontSize = ttmlStyle.fontSize;
                }
                if (z && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                    setBackgroundColor(ttmlStyle.backgroundColor);
                }
            }
            return this;
        }
        return (TtmlStyle) invokeLZ.objValue;
    }

    public TtmlStyle chain(TtmlStyle ttmlStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ttmlStyle)) == null) {
            return inherit(ttmlStyle, true);
        }
        return (TtmlStyle) invokeL.objValue;
    }

    public TtmlStyle inherit(TtmlStyle ttmlStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ttmlStyle)) == null) {
            return inherit(ttmlStyle, false);
        }
        return (TtmlStyle) invokeL.objValue;
    }

    public TtmlStyle setBackgroundColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.backgroundColor = i;
            this.hasBackgroundColor = true;
            return this;
        }
        return (TtmlStyle) invokeI.objValue;
    }

    public TtmlStyle setBold(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.inheritableStyle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.bold = z ? 1 : 0;
            return this;
        }
        return (TtmlStyle) invokeZ.objValue;
    }

    public TtmlStyle setFontColor(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.inheritableStyle == null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            this.fontColor = i;
            this.hasFontColor = true;
            return this;
        }
        return (TtmlStyle) invokeI.objValue;
    }

    public TtmlStyle setFontFamily(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (this.inheritableStyle == null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            this.fontFamily = str;
            return this;
        }
        return (TtmlStyle) invokeL.objValue;
    }

    public TtmlStyle setFontSize(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f)) == null) {
            this.fontSize = f;
            return this;
        }
        return (TtmlStyle) invokeF.objValue;
    }

    public TtmlStyle setFontSizeUnit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.fontSizeUnit = i;
            return this;
        }
        return (TtmlStyle) invokeI.objValue;
    }

    public TtmlStyle setId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.id = str;
            return this;
        }
        return (TtmlStyle) invokeL.objValue;
    }

    public TtmlStyle setItalic(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (this.inheritableStyle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.italic = z ? 1 : 0;
            return this;
        }
        return (TtmlStyle) invokeZ.objValue;
    }

    public TtmlStyle setLinethrough(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            if (this.inheritableStyle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.linethrough = z ? 1 : 0;
            return this;
        }
        return (TtmlStyle) invokeZ.objValue;
    }

    public TtmlStyle setTextAlign(Layout.Alignment alignment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, alignment)) == null) {
            this.textAlign = alignment;
            return this;
        }
        return (TtmlStyle) invokeL.objValue;
    }

    public TtmlStyle setUnderline(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            if (this.inheritableStyle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkState(z2);
            this.underline = z ? 1 : 0;
            return this;
        }
        return (TtmlStyle) invokeZ.objValue;
    }
}
