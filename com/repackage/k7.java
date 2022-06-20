package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class k7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public k7 a;
    public Locale b;
    public w7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964037031, "Lcom/repackage/k7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964037031, "Lcom/repackage/k7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public k7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(j3 j3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, j3Var)) == null) {
            try {
                j3Var.m().close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static k7 b(j3 j3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, j3Var, locale)) == null) ? d(j3Var, locale, "UTF-8") : (k7) invokeLL.objValue;
    }

    public static k7 c(j3 j3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, j3Var, locale, str)) == null) ? d(j3Var, locale, str) : (k7) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.j() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static k7 d(j3 j3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        k7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, j3Var, locale, str)) == null) {
            k7 k7Var = null;
            if (j3Var == null || locale == null || str == null) {
                throw null;
            }
            Locale locale2 = locale;
            do {
                List<Locale> e2 = e(locale2);
                j = j(j3Var, str, e2, 0, k7Var);
                if (j != null) {
                    Locale g = j.g();
                    boolean equals = g.equals(d);
                    if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                        break;
                    } else if (equals && k7Var == null) {
                        k7Var = j;
                    }
                }
                locale2 = f(locale2);
            } while (locale2 != null);
            return j;
        }
        return (k7) invokeLLL.objValue;
    }

    public static List<Locale> e(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, locale)) == null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            ArrayList arrayList = new ArrayList(4);
            if (variant.length() > 0) {
                arrayList.add(locale);
            }
            if (country.length() > 0) {
                arrayList.add(arrayList.isEmpty() ? locale : new Locale(language, country));
            }
            if (language.length() > 0) {
                if (!arrayList.isEmpty()) {
                    locale = new Locale(language);
                }
                arrayList.add(locale);
            }
            arrayList.add(d);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Locale f(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) {
            Locale locale2 = Locale.getDefault();
            if (locale.equals(locale2)) {
                return null;
            }
            return locale2;
        }
        return (Locale) invokeL.objValue;
    }

    public static k7 i(j3 j3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        k7 k7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, j3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    j3 l = l(j3Var, locale);
                    if (a(l)) {
                        k7Var = new k7();
                        reader = l.r(str);
                        k7Var.h(reader);
                    } else {
                        k7Var = null;
                    }
                    if (k7Var != null) {
                        k7Var.k(locale);
                    }
                    return k7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                i8.a(reader);
            }
        }
        return (k7) invokeLLL.objValue;
    }

    public static k7 j(j3 j3Var, String str, List<Locale> list, int i, k7 k7Var) {
        InterceptResult invokeCommon;
        k7 k7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{j3Var, str, list, Integer.valueOf(i), k7Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                k7Var2 = j(j3Var, str, list, i + 1, k7Var);
            } else if (k7Var != null && locale.equals(d)) {
                return k7Var;
            } else {
                k7Var2 = null;
            }
            k7 i2 = i(j3Var, str, locale);
            if (i2 != null) {
                i2.a = k7Var2;
                return i2;
            }
            return k7Var2;
        }
        return (k7) invokeCommon.objValue;
    }

    public static j3 l(j3 j3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, j3Var, locale)) == null) {
            j8 j8Var = new j8(j3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    j8Var.a('_');
                    if (!equals3) {
                        j8Var.n(language);
                        j8Var.a('_');
                        j8Var.n(country);
                        j8Var.a('_');
                        j8Var.n(variant);
                    } else if (!equals2) {
                        j8Var.n(language);
                        j8Var.a('_');
                        j8Var.n(country);
                    } else {
                        j8Var.n(language);
                    }
                }
            }
            j8Var.n(".properties");
            return j3Var.s(j8Var.toString());
        }
        return (j3) invokeLL.objValue;
    }

    public Locale g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Locale) invokeV.objValue;
    }

    public void h(Reader reader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader) == null) {
            w7<String, String> w7Var = new w7<>();
            this.c = w7Var;
            b8.a(w7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new k8(locale, !e);
        }
    }
}
