package com.repackage;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes7.dex */
public class q61 extends Resources {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q61(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration, Resources resources) {
        super(assetManager, displayMetrics, configuration);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {assetManager, displayMetrics, configuration, resources};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            try {
                return super.getAnimation(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getAnimation(i);
            }
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            try {
                return super.getBoolean(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getBoolean(i);
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            try {
                return super.getColor(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getColor(i);
            }
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            try {
                return super.getColorStateList(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getColorStateList(i);
            }
        }
        return (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return super.getConfiguration();
            } catch (Resources.NotFoundException unused) {
                return this.a.getConfiguration();
            }
        }
        return (Configuration) invokeV.objValue;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            try {
                return super.getDimension(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDimension(i);
            }
        }
        return invokeI.floatValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            try {
                return super.getDimensionPixelOffset(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDimensionPixelOffset(i);
            }
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            try {
                return super.getDimensionPixelSize(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDimensionPixelSize(i);
            }
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return super.getDisplayMetrics();
            } catch (Resources.NotFoundException unused) {
                return this.a.getDisplayMetrics();
            }
        }
        return (DisplayMetrics) invokeV.objValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            try {
                return super.getDrawable(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDrawable(i);
            }
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            try {
                return super.getDrawableForDensity(i, i2);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDrawableForDensity(i, i2);
            }
        }
        return (Drawable) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(29)
    public float getFloat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            try {
                return super.getFloat(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getFloat(i);
            }
        }
        return invokeI.floatValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(26)
    public Typeface getFont(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            try {
                return super.getFont(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getFont(i);
            }
        }
        return (Typeface) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048593, this, i, i2, i3)) == null) {
            try {
                return super.getFraction(i, i2, i3);
            } catch (Resources.NotFoundException unused) {
                return this.a.getFraction(i, i2, i3);
            }
        }
        return invokeIII.floatValue;
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, str2, str3)) == null) {
            try {
                return super.getIdentifier(str, str2, str3);
            } catch (Resources.NotFoundException unused) {
                return this.a.getIdentifier(str, str2, str3);
            }
        }
        return invokeLLL.intValue;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            try {
                return super.getIntArray(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getIntArray(i);
            }
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            try {
                return super.getInteger(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getInteger(i);
            }
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            try {
                return super.getLayout(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getLayout(i);
            }
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            try {
                return super.getMovie(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getMovie(i);
            }
        }
        return (Movie) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048600, this, i, i2, objArr)) == null) {
            try {
                return super.getQuantityString(i, i2, objArr);
            } catch (Resources.NotFoundException unused) {
                return this.a.getQuantityString(i, i2, objArr);
            }
        }
        return (String) invokeIIL.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i, i2)) == null) {
            try {
                return super.getQuantityText(i, i2);
            } catch (Resources.NotFoundException unused) {
                return this.a.getQuantityText(i, i2);
            }
        }
        return (CharSequence) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            try {
                return super.getResourceEntryName(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getResourceEntryName(i);
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            try {
                return super.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getResourceName(i);
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            try {
                return super.getResourcePackageName(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getResourcePackageName(i);
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            try {
                return super.getResourceTypeName(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getResourceTypeName(i);
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            try {
                return super.getString(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getString(i);
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            try {
                return super.getStringArray(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getStringArray(i);
            }
        }
        return (String[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            try {
                return super.getText(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getText(i);
            }
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            try {
                return super.getTextArray(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getTextArray(i);
            }
        }
        return (CharSequence[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048613, this, str, typedValue, z) == null) {
            try {
                super.getValue(str, typedValue, z);
            } catch (Resources.NotFoundException unused) {
                this.a.getValue(str, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), typedValue, Boolean.valueOf(z)}) == null) {
            try {
                super.getValueForDensity(i, i2, typedValue, z);
            } catch (Resources.NotFoundException unused) {
                this.a.getValueForDensity(i, i2, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            try {
                return super.getXml(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.getXml(i);
            }
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, attributeSet, iArr)) == null) {
            try {
                return super.obtainAttributes(attributeSet, iArr);
            } catch (Resources.NotFoundException unused) {
                return this.a.obtainAttributes(attributeSet, iArr);
            }
        }
        return (TypedArray) invokeLL.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            try {
                return super.obtainTypedArray(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.obtainTypedArray(i);
            }
        }
        return (TypedArray) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i)) == null) {
            try {
                return super.openRawResource(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.openRawResource(i);
            }
        }
        return (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            try {
                return super.openRawResourceFd(i);
            } catch (Resources.NotFoundException unused) {
                return this.a.openRawResourceFd(i);
            }
        }
        return (AssetFileDescriptor) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, str, attributeSet, bundle) == null) {
            try {
                super.parseBundleExtra(str, attributeSet, bundle);
            } catch (Resources.NotFoundException unused) {
                this.a.parseBundleExtra(str, attributeSet, bundle);
            }
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws IOException, XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, xmlResourceParser, bundle) == null) {
            try {
                super.parseBundleExtras(xmlResourceParser, bundle);
            } catch (Resources.NotFoundException unused) {
                this.a.parseBundleExtras(xmlResourceParser, bundle);
            }
        }
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, configuration, displayMetrics) == null) {
            try {
                super.updateConfiguration(configuration, displayMetrics);
            } catch (Resources.NotFoundException unused) {
                this.a.updateConfiguration(configuration, displayMetrics);
            }
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, theme)) == null) {
            try {
                return super.getColor(i, theme);
            } catch (Resources.NotFoundException unused) {
                return this.a.getColor(i, theme);
            }
        }
        return invokeIL.intValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, theme)) == null) {
            try {
                return super.getColorStateList(i, theme);
            } catch (Resources.NotFoundException unused) {
                return this.a.getColorStateList(i, theme);
            }
        }
        return (ColorStateList) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, theme)) == null) {
            try {
                return super.getDrawable(i, theme);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDrawable(i, theme);
            }
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i, i2, theme)) == null) {
            try {
                return super.getDrawableForDensity(i, i2, theme);
            } catch (Resources.NotFoundException unused) {
                return this.a.getDrawableForDensity(i, i2, theme);
            }
        }
        return (Drawable) invokeIIL.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048599, this, i, i2)) == null) {
            try {
                return super.getQuantityString(i, i2);
            } catch (Resources.NotFoundException unused) {
                return this.a.getQuantityString(i, i2);
            }
        }
        return (String) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i, objArr)) == null) {
            try {
                return super.getString(i, objArr);
            } catch (Resources.NotFoundException unused) {
                return this.a.getString(i, objArr);
            }
        }
        return (String) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i, charSequence)) == null) {
            try {
                return super.getText(i, charSequence);
            } catch (Resources.NotFoundException unused) {
                return this.a.getText(i, charSequence);
            }
        }
        return (CharSequence) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), typedValue, Boolean.valueOf(z)}) == null) {
            try {
                super.getValue(i, typedValue, z);
            } catch (Resources.NotFoundException unused) {
                this.a.getValue(i, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048619, this, i, typedValue)) == null) {
            try {
                return super.openRawResource(i, typedValue);
            } catch (Resources.NotFoundException unused) {
                return this.a.openRawResource(i, typedValue);
            }
        }
        return (InputStream) invokeIL.objValue;
    }
}
