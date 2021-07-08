package d.l.a.e.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface u {

    /* loaded from: classes8.dex */
    public static class a implements u {
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

        @Override // d.l.a.e.b.g.u
        public com.ss.android.socialbase.downloader.exception.g a(Throwable th, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, th, str)) == null) {
                return null;
            }
            return (com.ss.android.socialbase.downloader.exception.g) invokeLL.objValue;
        }

        @Override // d.l.a.e.b.g.u
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.l.a.e.b.g.u
        public boolean a(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.l.a.e.b.g.u
        public d.l.a.e.b.o.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.l.a.e.b.o.a) invokeV.objValue;
        }

        @Override // d.l.a.e.b.g.u
        public d.l.a.e.b.o.j c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (d.l.a.e.b.o.j) invokeV.objValue;
        }
    }

    com.ss.android.socialbase.downloader.exception.g a(Throwable th, String str);

    boolean a();

    boolean a(Throwable th);

    d.l.a.e.b.o.a b();

    d.l.a.e.b.o.j c();
}
