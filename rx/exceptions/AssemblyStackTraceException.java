package rx.exceptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.r.c;
import java.util.HashSet;
/* loaded from: classes4.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2038859767182585852L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssemblyStackTraceException(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static AssemblyStackTraceException find(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            HashSet hashSet = new HashSet();
            while (!(th instanceof AssemblyStackTraceException)) {
                if (th == null || th.getCause() == null) {
                    return null;
                }
                th = th.getCause();
                if (!hashSet.add(th)) {
                    return null;
                }
            }
            return (AssemblyStackTraceException) th;
        }
        return (AssemblyStackTraceException) invokeL.objValue;
    }

    public void attachTo(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            HashSet hashSet = new HashSet();
            while (th.getCause() != null) {
                th = th.getCause();
                if (!hashSet.add(th)) {
                    c.j(this);
                    return;
                }
            }
            try {
                th.initCause(this);
            } catch (IllegalStateException unused) {
                c.j(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", th));
            }
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
            }
            return this;
        }
        return (Throwable) invokeV.objValue;
    }
}
