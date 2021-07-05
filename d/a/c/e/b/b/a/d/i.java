package d.a.c.e.b.b.a.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes8.dex */
public class i implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Integer f44050a;

    public i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44050a = Integer.valueOf(i2);
    }

    @Override // d.a.c.e.b.b.a.d.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
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
                                            return Boolean.valueOf(this.f44050a.byteValue() == 0);
                                        } else if (a2 == String.class) {
                                            return String.valueOf(this.f44050a);
                                        } else {
                                            if (a2 == char[].class) {
                                                return String.valueOf(this.f44050a).toCharArray();
                                            }
                                            if (a2 == byte[].class) {
                                                try {
                                                    return d.a.c.e.p.c.e(String.valueOf(this.f44050a), 0);
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return null;
                                                }
                                            }
                                            return null;
                                        }
                                    }
                                    return Character.valueOf((char) this.f44050a.intValue());
                                }
                                return Double.valueOf(this.f44050a.doubleValue());
                            }
                            return Float.valueOf(this.f44050a.floatValue());
                        }
                        return Long.valueOf(this.f44050a.longValue());
                    }
                    return Integer.valueOf(this.f44050a.intValue());
                }
                return Short.valueOf(this.f44050a.shortValue());
            }
            return Byte.valueOf(this.f44050a.byteValue());
        }
        return invokeL.objValue;
    }
}
