package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes5.dex */
public class LocaleUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage;
    public static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class SyncAvoid {
        public static /* synthetic */ Interceptable $ic;
        public static final List<Locale> AVAILABLE_LOCALE_LIST;
        public static final Set<Locale> AVAILABLE_LOCALE_SET;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1628290601, "Lorg/apache/commons/lang3/LocaleUtils$SyncAvoid;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1628290601, "Lorg/apache/commons/lang3/LocaleUtils$SyncAvoid;");
                    return;
                }
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
            AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(arrayList);
            AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet(arrayList));
        }

        public SyncAvoid() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677353535, "Lorg/apache/commons/lang3/LocaleUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(677353535, "Lorg/apache/commons/lang3/LocaleUtils;");
                return;
            }
        }
        cLanguagesByCountry = new ConcurrentHashMap();
        cCountriesByLanguage = new ConcurrentHashMap();
    }

    public LocaleUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<Locale> availableLocaleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SyncAvoid.AVAILABLE_LOCALE_LIST : (List) invokeV.objValue;
    }

    public static Set<Locale> availableLocaleSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SyncAvoid.AVAILABLE_LOCALE_SET : (Set) invokeV.objValue;
    }

    public static List<Locale> countriesByLanguage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return Collections.emptyList();
            }
            List<Locale> list = cCountriesByLanguage.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                List<Locale> availableLocaleList = availableLocaleList();
                for (int i2 = 0; i2 < availableLocaleList.size(); i2++) {
                    Locale locale = availableLocaleList.get(i2);
                    if (str.equals(locale.getLanguage()) && locale.getCountry().length() != 0 && locale.getVariant().isEmpty()) {
                        arrayList.add(locale);
                    }
                }
                cCountriesByLanguage.putIfAbsent(str, Collections.unmodifiableList(arrayList));
                return cCountriesByLanguage.get(str);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static boolean isAvailableLocale(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, locale)) == null) ? availableLocaleList().contains(locale) : invokeL.booleanValue;
    }

    public static List<Locale> languagesByCountry(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return Collections.emptyList();
            }
            List<Locale> list = cLanguagesByCountry.get(str);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                List<Locale> availableLocaleList = availableLocaleList();
                for (int i2 = 0; i2 < availableLocaleList.size(); i2++) {
                    Locale locale = availableLocaleList.get(i2);
                    if (str.equals(locale.getCountry()) && locale.getVariant().isEmpty()) {
                        arrayList.add(locale);
                    }
                }
                cLanguagesByCountry.putIfAbsent(str, Collections.unmodifiableList(arrayList));
                return cLanguagesByCountry.get(str);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static List<Locale> localeLookupList(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) ? localeLookupList(locale, locale) : (List) invokeL.objValue;
    }

    public static Locale toLocale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.isEmpty()) {
                return new Locale("", "");
            }
            if (!str.contains("#")) {
                int length = str.length();
                if (length >= 2) {
                    if (str.charAt(0) == '_') {
                        if (length >= 3) {
                            char charAt = str.charAt(1);
                            char charAt2 = str.charAt(2);
                            if (!Character.isUpperCase(charAt) || !Character.isUpperCase(charAt2)) {
                                throw new IllegalArgumentException("Invalid locale format: " + str);
                            } else if (length == 3) {
                                return new Locale("", str.substring(1, 3));
                            } else {
                                if (length >= 5) {
                                    if (str.charAt(3) == '_') {
                                        return new Locale("", str.substring(1, 3), str.substring(4));
                                    }
                                    throw new IllegalArgumentException("Invalid locale format: " + str);
                                }
                                throw new IllegalArgumentException("Invalid locale format: " + str);
                            }
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    }
                    String[] split = str.split("_", -1);
                    int length2 = split.length - 1;
                    if (length2 == 0) {
                        if (StringUtils.isAllLowerCase(str) && (length == 2 || length == 3)) {
                            return new Locale(str);
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    } else if (length2 != 1) {
                        if (length2 == 2 && StringUtils.isAllLowerCase(split[0]) && ((split[0].length() == 2 || split[0].length() == 3) && ((split[1].length() == 0 || (split[1].length() == 2 && StringUtils.isAllUpperCase(split[1]))) && split[2].length() > 0))) {
                            return new Locale(split[0], split[1], split[2]);
                        }
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    } else if (StringUtils.isAllLowerCase(split[0]) && ((split[0].length() == 2 || split[0].length() == 3) && split[1].length() == 2 && StringUtils.isAllUpperCase(split[1]))) {
                        return new Locale(split[0], split[1]);
                    } else {
                        throw new IllegalArgumentException("Invalid locale format: " + str);
                    }
                }
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        return (Locale) invokeL.objValue;
    }

    public static List<Locale> localeLookupList(Locale locale, Locale locale2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, locale, locale2)) == null) {
            ArrayList arrayList = new ArrayList(4);
            if (locale != null) {
                arrayList.add(locale);
                if (locale.getVariant().length() > 0) {
                    arrayList.add(new Locale(locale.getLanguage(), locale.getCountry()));
                }
                if (locale.getCountry().length() > 0) {
                    arrayList.add(new Locale(locale.getLanguage(), ""));
                }
                if (!arrayList.contains(locale2)) {
                    arrayList.add(locale2);
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLL.objValue;
    }
}
