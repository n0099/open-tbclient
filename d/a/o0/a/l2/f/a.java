package d.a.o0.a.l2.f;

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
    public static final Pattern f46553a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f46554b;

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f46555c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.l2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C0813a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-240472299, "Ld/a/o0/a/l2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-240472299, "Ld/a/o0/a/l2/f/a;");
                return;
            }
        }
        f46553a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f46554b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
        SparseIntArray sparseIntArray = new SparseIntArray();
        f46555c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f46555c.put(d("feb"), 1);
        f46555c.put(d("mar"), 2);
        f46555c.put(d("apr"), 3);
        f46555c.put(d("may"), 4);
        f46555c.put(d("jun"), 5);
        f46555c.put(d("jul"), 6);
        f46555c.put(d("aug"), 7);
        f46555c.put(d("sep"), 8);
        f46555c.put(d("oct"), 9);
        f46555c.put(d("nov"), 10);
        f46555c.put(d("dec"), 11);
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
                return f46555c.get(d(matcher.group(i2)), -1);
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
            Matcher matcher = f46553a.matcher(str);
            if (matcher.find()) {
                bVar.f46558c = a(matcher, 1);
                bVar.f46557b = b(matcher, 2);
                bVar.f46556a = c(matcher, 3);
                f(bVar, matcher, 4);
            } else {
                Matcher matcher2 = f46554b.matcher(str);
                if (!matcher2.find()) {
                    return -1L;
                }
                bVar.f46557b = b(matcher2, 1);
                bVar.f46558c = a(matcher2, 2);
                f(bVar, matcher2, 3);
                bVar.f46556a = c(matcher2, 4);
            }
            if (bVar.a()) {
                return -1L;
            }
            if (bVar.f46556a >= 2038) {
                bVar.f46556a = 2038;
                bVar.f46557b = 0;
                bVar.f46558c = 1;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.set(bVar.f46556a, bVar.f46557b, bVar.f46558c, bVar.f46559d, bVar.f46560e, bVar.f46561f);
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
                bVar.f46559d = charAt;
                bVar.f46560e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
                int i6 = i3 + 1 + 1 + 1 + 1;
                bVar.f46561f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f46556a;

        /* renamed from: b  reason: collision with root package name */
        public int f46557b;

        /* renamed from: c  reason: collision with root package name */
        public int f46558c;

        /* renamed from: d  reason: collision with root package name */
        public int f46559d;

        /* renamed from: e  reason: collision with root package name */
        public int f46560e;

        /* renamed from: f  reason: collision with root package name */
        public int f46561f;

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
            this.f46556a = -1;
            this.f46557b = -1;
            this.f46558c = -1;
            this.f46559d = -1;
            this.f46560e = -1;
            this.f46561f = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46556a == -1 || this.f46557b == -1 || this.f46558c == -1 || this.f46559d == -1 || this.f46560e == -1 || this.f46561f == -1 : invokeV.booleanValue;
        }

        public /* synthetic */ b(C0813a c0813a) {
            this();
        }
    }
}
