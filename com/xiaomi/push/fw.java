package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.io.PrintWriter;
/* loaded from: classes10.dex */
public class fw extends Exception {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public gf f77484a;

    /* renamed from: a  reason: collision with other field name */
    public gg f420a;

    /* renamed from: a  reason: collision with other field name */
    public Throwable f421a;

    public fw() {
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
        this.f77484a = null;
        this.f420a = null;
        this.f421a = null;
    }

    public fw(gf gfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gfVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f77484a = null;
        this.f420a = null;
        this.f421a = null;
        this.f77484a = gfVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f77484a = null;
        this.f420a = null;
        this.f421a = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw(String str, Throwable th) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, th};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f77484a = null;
        this.f420a = null;
        this.f421a = null;
        this.f421a = th;
    }

    public fw(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {th};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f77484a = null;
        this.f420a = null;
        this.f421a = null;
        this.f421a = th;
    }

    public Throwable a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f421a : (Throwable) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        gf gfVar;
        gg ggVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String message = super.getMessage();
            return (message != null || (ggVar = this.f420a) == null) ? (message != null || (gfVar = this.f77484a) == null) ? message : gfVar.toString() : ggVar.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            printStackTrace(System.err);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, printStream) == null) {
            super.printStackTrace(printStream);
            if (this.f421a != null) {
                printStream.println("Nested Exception: ");
                this.f421a.printStackTrace(printStream);
            }
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, printWriter) == null) {
            super.printStackTrace(printWriter);
            if (this.f421a != null) {
                printWriter.println("Nested Exception: ");
                this.f421a.printStackTrace(printWriter);
            }
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String message = super.getMessage();
            if (message != null) {
                sb.append(message);
                sb.append(": ");
            }
            gg ggVar = this.f420a;
            if (ggVar != null) {
                sb.append(ggVar);
            }
            gf gfVar = this.f77484a;
            if (gfVar != null) {
                sb.append(gfVar);
            }
            if (this.f421a != null) {
                sb.append("\n  -- caused by: ");
                sb.append(this.f421a);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
