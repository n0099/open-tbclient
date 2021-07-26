package d.a.d.e.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes7.dex */
public class e implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public char f41567a;

    public e(char c2) {
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
        this.f41567a = c2;
    }

    @Override // d.a.d.e.b.b.a.d.h
    public Object a(d.a.d.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Class<?> a2 = cVar.a();
            if (a2 != Byte.class && a2 != Byte.TYPE) {
                if (a2 != Short.class && a2 != Short.TYPE) {
                    if (a2 != Integer.class && a2 != Integer.TYPE) {
                        if (a2 != Long.class && a2 != Long.TYPE) {
                            if (a2 != Float.class && a2 != Float.TYPE) {
                                if (a2 != Double.class && a2 != Double.TYPE) {
                                    if (a2 != Character.class && a2 != Character.TYPE) {
                                        if (a2 == Boolean.class || a2 == Boolean.TYPE) {
                                            return Boolean.valueOf(((byte) this.f41567a) == 0);
                                        } else if (a2 == String.class) {
                                            return String.valueOf(this.f41567a);
                                        } else {
                                            if (a2 == char[].class) {
                                                return String.valueOf(this.f41567a).toCharArray();
                                            }
                                            if (a2 == byte[].class) {
                                                try {
                                                    return d.a.d.e.p.c.e(String.valueOf(this.f41567a), 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                    return Character.valueOf(this.f41567a);
                                }
                                return Double.valueOf(this.f41567a);
                            }
                            return Float.valueOf(this.f41567a);
                        }
                        return Long.valueOf(this.f41567a);
                    }
                    return Integer.valueOf(this.f41567a);
                }
                return Short.valueOf((short) this.f41567a);
            }
            return Byte.valueOf((byte) this.f41567a);
        }
        return invokeL.objValue;
    }
}
