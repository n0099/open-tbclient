package com.tachikoma.core.component.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class FontManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] EXTENSIONS;
    public static final String[] FILE_EXTENSIONS;
    public static final String FONTS_ASSET_PATH = "fonts/";
    public static FontManager sFontManagerInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, FontFamily> mFontCache;

    /* renamed from: com.tachikoma.core.component.text.FontManager$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class FontFamily {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Typeface> mTypefaceSparseArray;

        public FontFamily() {
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
            this.mTypefaceSparseArray = new SparseArray<>(4);
        }

        public /* synthetic */ FontFamily(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Typeface getTypeface(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.mTypefaceSparseArray.get(i) : (Typeface) invokeI.objValue;
        }

        public void setTypeface(int i, Typeface typeface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, typeface) == null) {
                this.mTypefaceSparseArray.put(i, typeface);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1019328649, "Lcom/tachikoma/core/component/text/FontManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1019328649, "Lcom/tachikoma/core/component/text/FontManager;");
                return;
            }
        }
        EXTENSIONS = new String[]{"", "_bold", "_italic", "_bold_italic"};
        FILE_EXTENSIONS = new String[]{".ttf", ".otf"};
    }

    public FontManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFontCache = new HashMap();
    }

    public static Typeface createTypeface(String str, int i, AssetManager assetManager, String str2) {
        InterceptResult invokeLILL;
        Typeface createFromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, str, i, assetManager, str2)) == null) {
            try {
                return Typeface.createFromAsset(assetManager, FONTS_ASSET_PATH + str);
            } catch (RuntimeException unused) {
                return (TextUtils.isEmpty(str2) || !new File(str2).exists() || (createFromFile = Typeface.createFromFile(str2)) == null) ? Typeface.create(str, i) : createFromFile;
            }
        }
        return (Typeface) invokeLILL.objValue;
    }

    public static FontManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sFontManagerInstance == null) {
                sFontManagerInstance = new FontManager();
            }
            return sFontManagerInstance;
        }
        return (FontManager) invokeV.objValue;
    }

    public Typeface getTypeface(String str, int i, AssetManager assetManager, String str2) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, str, i, assetManager, str2)) == null) {
            FontFamily fontFamily = this.mFontCache.get(str);
            if (fontFamily == null) {
                fontFamily = new FontFamily(null);
                this.mFontCache.put(str, fontFamily);
            }
            Typeface typeface = fontFamily.getTypeface(i);
            if (typeface == null && (typeface = createTypeface(str, i, assetManager, str2)) != null) {
                fontFamily.setTypeface(i, typeface);
            }
            return typeface;
        }
        return (Typeface) invokeLILL.objValue;
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, typeface) == null) || typeface == null) {
            return;
        }
        FontFamily fontFamily = this.mFontCache.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily(null);
            this.mFontCache.put(str, fontFamily);
        }
        fontFamily.setTypeface(i, typeface);
    }
}
