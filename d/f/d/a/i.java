package d.f.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f71275a;

    /* loaded from: classes8.dex */
    public class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f71276b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f71277c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, i iVar2, String str) {
            super(iVar2, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, iVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((i) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71277c = iVar;
            this.f71276b = str;
        }

        @Override // d.f.d.a.i
        public CharSequence h(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj == null ? this.f71276b : this.f71277c.h(obj) : (CharSequence) invokeL.objValue;
        }

        @Override // d.f.d.a.i
        public i i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
            return (i) invokeL.objValue;
        }
    }

    public /* synthetic */ i(i iVar, a aVar) {
        this(iVar);
    }

    public static i f(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) ? new i(String.valueOf(c2)) : (i) invokeCommon.objValue;
    }

    public static i g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new i(str) : (i) invokeL.objValue;
    }

    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a2, it)) == null) {
            n.p(a2);
            if (it.hasNext()) {
                a2.append(h(it.next()));
                while (it.hasNext()) {
                    a2.append(this.f71275a);
                    a2.append(h(it.next()));
                }
            }
            return a2;
        }
        return (A) invokeLL.objValue;
    }

    public final StringBuilder b(StringBuilder sb, Iterator<?> it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb, it)) == null) {
            try {
                a(sb, it);
                return sb;
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
        return (StringBuilder) invokeLL.objValue;
    }

    public final String c(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) ? d(iterable.iterator()) : (String) invokeL.objValue;
    }

    public final String d(Iterator<?> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, it)) == null) {
            StringBuilder sb = new StringBuilder();
            b(sb, it);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final String e(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) ? c(Arrays.asList(objArr)) : (String) invokeL.objValue;
    }

    public CharSequence h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            n.p(obj);
            return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
        }
        return (CharSequence) invokeL.objValue;
    }

    public i i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            n.p(str);
            return new a(this, this, str);
        }
        return (i) invokeL.objValue;
    }

    public i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        n.p(str);
        this.f71275a = str;
    }

    public i(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71275a = iVar.f71275a;
    }
}
