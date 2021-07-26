package d.f.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class b implements o<Character> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static abstract class a extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.f.d.a.o
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* renamed from: d.f.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1997b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final char f71271e;

        /* renamed from: f  reason: collision with root package name */
        public final char f71272f;

        public C1997b(char c2, char c3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c2), Character.valueOf(c3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.d(c3 >= c2);
            this.f71271e = c2;
            this.f71272f = c3;
        }

        @Override // d.f.d.a.b
        public boolean f(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)})) == null) ? this.f71271e <= c2 && c2 <= this.f71272f : invokeCommon.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CharMatcher.inRange('" + b.g(this.f71271e) + "', '" + b.g(this.f71272f) + "')";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final char f71273e;

        public c(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71273e = c2;
        }

        @Override // d.f.d.a.b
        public boolean f(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)})) == null) ? c2 == this.f71273e : invokeCommon.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CharMatcher.is('" + b.g(this.f71273e) + "')";
            }
            return (String) invokeV.objValue;
        }
    }

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
            }
        }
    }

    public static b c(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) ? new C1997b(c2, c3) : (b) invokeCommon.objValue;
    }

    public static b e(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? new c(c2) : (b) invokeCommon.objValue;
    }

    public static String g(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Character.valueOf(c2)})) == null) {
            char[] cArr = {'\\', 'u', 0, 0, 0, 0};
            for (int i2 = 0; i2 < 4; i2++) {
                cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
                c2 = (char) (c2 >> 4);
            }
            return String.copyValueOf(cArr);
        }
        return (String) invokeCommon.objValue;
    }

    @Deprecated
    public boolean b(Character ch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ch)) == null) ? f(ch.charValue()) : invokeL.booleanValue;
    }

    public int d(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2)) == null) {
            int length = charSequence.length();
            n.t(i2, length);
            while (i2 < length) {
                if (f(charSequence.charAt(i2))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public abstract boolean f(char c2);
}
