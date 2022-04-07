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
public class i7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public i7 a;
    public Locale b;
    public u7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964038953, "Lcom/repackage/i7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964038953, "Lcom/repackage/i7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public i7() {
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

    public static boolean a(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h3Var)) == null) {
            try {
                h3Var.m().close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static i7 b(h3 h3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, h3Var, locale)) == null) ? d(h3Var, locale, "UTF-8") : (i7) invokeLL.objValue;
    }

    public static i7 c(h3 h3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, h3Var, locale, str)) == null) ? d(h3Var, locale, str) : (i7) invokeLLL.objValue;
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
    public static i7 d(h3 h3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        i7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, h3Var, locale, str)) == null) {
            i7 i7Var = null;
            if (h3Var == null || locale == null || str == null) {
                throw null;
            }
            Locale locale2 = locale;
            do {
                List<Locale> e2 = e(locale2);
                j = j(h3Var, str, e2, 0, i7Var);
                if (j != null) {
                    Locale g = j.g();
                    boolean equals = g.equals(d);
                    if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                        break;
                    } else if (equals && i7Var == null) {
                        i7Var = j;
                    }
                }
                locale2 = f(locale2);
            } while (locale2 != null);
            return j;
        }
        return (i7) invokeLLL.objValue;
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

    public static i7 i(h3 h3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        i7 i7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, h3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    h3 l = l(h3Var, locale);
                    if (a(l)) {
                        i7Var = new i7();
                        reader = l.r(str);
                        i7Var.h(reader);
                    } else {
                        i7Var = null;
                    }
                    if (i7Var != null) {
                        i7Var.k(locale);
                    }
                    return i7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                g8.a(reader);
            }
        }
        return (i7) invokeLLL.objValue;
    }

    public static i7 j(h3 h3Var, String str, List<Locale> list, int i, i7 i7Var) {
        InterceptResult invokeCommon;
        i7 i7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{h3Var, str, list, Integer.valueOf(i), i7Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                i7Var2 = j(h3Var, str, list, i + 1, i7Var);
            } else if (i7Var != null && locale.equals(d)) {
                return i7Var;
            } else {
                i7Var2 = null;
            }
            i7 i2 = i(h3Var, str, locale);
            if (i2 != null) {
                i2.a = i7Var2;
                return i2;
            }
            return i7Var2;
        }
        return (i7) invokeCommon.objValue;
    }

    public static h3 l(h3 h3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, h3Var, locale)) == null) {
            h8 h8Var = new h8(h3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    h8Var.a('_');
                    if (!equals3) {
                        h8Var.n(language);
                        h8Var.a('_');
                        h8Var.n(country);
                        h8Var.a('_');
                        h8Var.n(variant);
                    } else if (!equals2) {
                        h8Var.n(language);
                        h8Var.a('_');
                        h8Var.n(country);
                    } else {
                        h8Var.n(language);
                    }
                }
            }
            h8Var.n(".properties");
            return h3Var.s(h8Var.toString());
        }
        return (h3) invokeLL.objValue;
    }

    public Locale g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Locale) invokeV.objValue;
    }

    public void h(Reader reader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader) == null) {
            u7<String, String> u7Var = new u7<>();
            this.c = u7Var;
            z7.a(u7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new i8(locale, !e);
        }
    }
}
