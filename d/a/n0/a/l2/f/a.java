package d.a.n0.a.l2.f;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f46049a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f46050b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f46051c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.l2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0804a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-369555018, "Ld/a/n0/a/l2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-369555018, "Ld/a/n0/a/l2/f/a;");
                return;
            }
        }
        f46049a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f46050b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
        SparseIntArray sparseIntArray = new SparseIntArray();
        f46051c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f46051c.put(d("feb"), 1);
        f46051c.put(d("mar"), 2);
        f46051c.put(d("apr"), 3);
        f46051c.put(d("may"), 4);
        f46051c.put(d("jun"), 5);
        f46051c.put(d("jul"), 6);
        f46051c.put(d("aug"), 7);
        f46051c.put(d("sep"), 8);
        f46051c.put(d("oct"), 9);
        f46051c.put(d("nov"), 10);
        f46051c.put(d("dec"), 11);
    }

    public static int a(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, matcher, i2)) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    return ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                }
                return group.charAt(0) - '0';
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int b(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, matcher, i2)) == null) {
            try {
                return f46051c.get(d(matcher.group(i2)), -1);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int c(@NonNull Matcher matcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, matcher, i2)) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return -1;
                }
                if (group.length() == 2) {
                    int charAt = ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                    return charAt >= 70 ? charAt + FeatureCodes.SKY_SEG : charAt + 2000;
                } else if (group.length() == 3) {
                    return ((group.charAt(0) - '0') * 100) + ((group.charAt(1) - '0') * 10) + (group.charAt(2) - '0') + FeatureCodes.SKY_SEG;
                } else {
                    if (group.length() == 4) {
                        return ((group.charAt(0) - '0') * 1000) + ((group.charAt(1) - '0') * 100) + ((group.charAt(2) - '0') * 10) + (group.charAt(3) - '0');
                    }
                    return 1970;
                }
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeLI.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int i2 = -1;
            if (!TextUtils.isEmpty(str) && str.length() >= 3) {
                for (int i3 = 0; i3 < 3; i3++) {
                    i2 += Character.toLowerCase(str.charAt(i3)) - 'a';
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static long e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            b bVar = new b(null);
            Matcher matcher = f46049a.matcher(str);
            if (matcher.find()) {
                bVar.f46054c = a(matcher, 1);
                bVar.f46053b = b(matcher, 2);
                bVar.f46052a = c(matcher, 3);
                f(bVar, matcher, 4);
            } else {
                Matcher matcher2 = f46050b.matcher(str);
                if (!matcher2.find()) {
                    return -1L;
                }
                bVar.f46053b = b(matcher2, 1);
                bVar.f46054c = a(matcher2, 2);
                f(bVar, matcher2, 3);
                bVar.f46052a = c(matcher2, 4);
            }
            if (bVar.a()) {
                return -1L;
            }
            if (bVar.f46052a >= 2038) {
                bVar.f46052a = 2038;
                bVar.f46053b = 0;
                bVar.f46054c = 1;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.set(bVar.f46052a, bVar.f46053b, bVar.f46054c, bVar.f46055d, bVar.f46056e, bVar.f46057f);
            return gregorianCalendar.getTimeInMillis();
        }
        return invokeL.longValue;
    }

    public static void f(@NonNull b bVar, @NonNull Matcher matcher, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, bVar, matcher, i2) == null) {
            try {
                String group = matcher.group(i2);
                if (TextUtils.isEmpty(group)) {
                    return;
                }
                int charAt = group.charAt(0) - '0';
                if (group.charAt(1) != ':') {
                    i3 = 2;
                    charAt = (charAt * 10) + (group.charAt(1) - '0');
                } else {
                    i3 = 1;
                }
                bVar.f46055d = charAt;
                bVar.f46056e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
                int i6 = i3 + 1 + 1 + 1 + 1;
                bVar.f46057f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46052a;

        /* renamed from: b  reason: collision with root package name */
        public int f46053b;

        /* renamed from: c  reason: collision with root package name */
        public int f46054c;

        /* renamed from: d  reason: collision with root package name */
        public int f46055d;

        /* renamed from: e  reason: collision with root package name */
        public int f46056e;

        /* renamed from: f  reason: collision with root package name */
        public int f46057f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46052a = -1;
            this.f46053b = -1;
            this.f46054c = -1;
            this.f46055d = -1;
            this.f46056e = -1;
            this.f46057f = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46052a == -1 || this.f46053b == -1 || this.f46054c == -1 || this.f46055d == -1 || this.f46056e == -1 || this.f46057f == -1 : invokeV.booleanValue;
        }

        public /* synthetic */ b(C0804a c0804a) {
            this();
        }
    }
}
