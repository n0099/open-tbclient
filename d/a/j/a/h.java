package d.a.j.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class h extends Resources {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, d.a.j.a.k.e<String, Integer>> f43044d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Resources f43045a;

    /* renamed from: b  reason: collision with root package name */
    public String f43046b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f43047c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1553900597, "Ld/a/j/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1553900597, "Ld/a/j/a/h;");
                return;
            }
        }
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
        f43044d = new HashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, assetManager, displayMetrics, configuration};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (DisplayMetrics) objArr2[1], (Configuration) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43047c = resources;
        new HashMap();
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (!TextUtils.isEmpty(this.f43046b) && !this.f43046b.equals("com.baidu.browser.theme.default")) {
                try {
                    String resourceEntryName = this.f43047c.getResourceEntryName(i2);
                    String resourceTypeName = this.f43047c.getResourceTypeName(i2);
                    d.a.j.a.k.e<String, Integer> eVar = f43044d.get(resourceTypeName);
                    if (eVar == null) {
                        eVar = new d.a.j.a.k.e<>(100);
                        f43044d.put(resourceTypeName, eVar);
                    }
                    Integer c2 = eVar.c(resourceEntryName);
                    if (c2 == null) {
                        c2 = Integer.valueOf(this.f43045a.getIdentifier(resourceEntryName, resourceTypeName, this.f43046b));
                        if (c2.intValue() != 0) {
                            eVar.d(resourceEntryName, c2);
                        }
                    }
                    return c2.intValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getAnimation(a2);
            }
            return this.f43047c.getAnimation(i2);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f43047c.getBoolean(i2) : invokeI.booleanValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? getColor(i2, null) : invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? getColorStateList(i2, null) : (ColorStateList) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43047c.getConfiguration() : (Configuration) invokeV.objValue;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDimension(a2);
            }
            return this.f43047c.getDimension(i2);
        }
        return invokeI.floatValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDimensionPixelOffset(a2);
            }
            return this.f43047c.getDimensionPixelOffset(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDimensionPixelSize(a2);
            }
            return this.f43047c.getDimensionPixelSize(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDrawable(a2);
            }
            return this.f43047c.getDrawable(i2);
        }
        return (Drawable) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDrawableForDensity(a2, i3);
            }
            return this.f43047c.getDrawableForDensity(i2, i3);
        }
        return (Drawable) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048590, this, i2, i3, i4)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getFraction(a2, i3, i4);
            }
            return this.f43047c.getFraction(i2, i3, i4);
        }
        return invokeIII.floatValue;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getIntArray(a2);
            }
            return this.f43047c.getIntArray(i2);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getInteger(a2);
            }
            return this.f43047c.getInteger(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getLayout(a2);
            }
            return this.f43047c.getLayout(i2);
        }
        return (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getMovie(a2);
            }
            return this.f43047c.getMovie(i2);
        }
        return (Movie) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getQuantityString(a2, i3);
            }
            return this.f43047c.getQuantityString(i2, i3);
        }
        return (String) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i2, i3)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getQuantityText(a2, i3);
            }
            return this.f43047c.getQuantityText(i2, i3);
        }
        return (CharSequence) invokeII.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.f43047c.getResourceEntryName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.f43047c.getResourceName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) ? this.f43047c.getResourcePackageName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? this.f43047c.getResourceTypeName(i2) : (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getString(a2);
            }
            return this.f43047c.getString(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getStringArray(a2);
            }
            return this.f43047c.getStringArray(i2);
        }
        return (String[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getText(a2);
            }
            return this.f43047c.getText(i2);
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getTextArray(a2);
            }
            return this.f43047c.getTextArray(i2);
        }
        return (CharSequence[]) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), typedValue, Boolean.valueOf(z)}) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                this.f43045a.getValue(a2, typedValue, z);
            } else {
                this.f43047c.getValue(i2, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), typedValue, Boolean.valueOf(z)}) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                this.f43045a.getValueForDensity(a2, i3, typedValue, z);
            } else {
                this.f43047c.getValueForDensity(i2, i3, typedValue, z);
            }
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) ? this.f43047c.getXml(i2) : (XmlResourceParser) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, attributeSet, iArr)) == null) ? this.f43047c.obtainAttributes(attributeSet, iArr) : (TypedArray) invokeLL.objValue;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? this.f43047c.obtainTypedArray(i2) : (TypedArray) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0 && (resources = this.f43045a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a2);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f43047c.openRawResource(i2);
        }
        return (InputStream) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        InterceptResult invokeI;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 != 0 && (resources = this.f43045a) != null) {
                try {
                    AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a2);
                    if (openRawResourceFd != null) {
                        return openRawResourceFd;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f43047c.openRawResourceFd(i2);
        }
        return (AssetFileDescriptor) invokeI.objValue;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, theme)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getColor(a2);
            }
            return this.f43047c.getColor(i2);
        }
        return invokeIL.intValue;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, theme)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getColorStateList(a2);
            }
            return this.f43047c.getColorStateList(i2);
        }
        return (ColorStateList) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, theme)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getDrawable(a2, null);
            }
            return this.f43047c.getDrawable(i2, theme);
        }
        return (Drawable) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i2, i3, objArr)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getQuantityString(a2, i3, objArr);
            }
            return this.f43047c.getQuantityString(i2, i3, objArr);
        }
        return (String) invokeIIL.objValue;
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048603, this, i2, objArr)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getString(a2, objArr);
            }
            return this.f43047c.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, charSequence)) == null) {
            int a2 = a(i2);
            if (a2 != 0) {
                return this.f43045a.getText(a2, charSequence);
            }
            return this.f43047c.getText(i2, charSequence);
        }
        return (CharSequence) invokeIL.objValue;
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048609, this, str, typedValue, z) == null) {
            this.f43047c.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        InterceptResult invokeIL;
        Resources resources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, typedValue)) == null) {
            int a2 = a(i2);
            if (a2 != 0 && (resources = this.f43045a) != null) {
                try {
                    InputStream openRawResource = resources.openRawResource(a2, typedValue);
                    if (openRawResource != null) {
                        return openRawResource;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f43047c.openRawResource(i2, typedValue);
        }
        return (InputStream) invokeIL.objValue;
    }
}
