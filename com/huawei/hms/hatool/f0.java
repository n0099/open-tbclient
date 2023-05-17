package com.huawei.hms.hatool;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes9.dex */
public class f0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public volatile boolean b;
    public a c;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public long c;
        public final /* synthetic */ f0 d;

        public a(f0 f0Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f0Var;
            this.a = UUID.randomUUID().toString().replace("-", "");
            this.a += "_" + j;
            this.c = j;
            this.b = true;
            f0Var.b = false;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (this.d.b) {
                    this.d.b = false;
                    b(j);
                } else if (b(this.c, j) || a(this.c, j)) {
                    b(j);
                } else {
                    this.c = j;
                    this.b = false;
                }
            }
        }

        public final boolean a(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(j2);
                return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
            }
            return invokeCommon.booleanValue;
        }

        public final void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                y.c("hmsSdk", "getNewSession() session is flush!");
                String uuid = UUID.randomUUID().toString();
                this.a = uuid;
                this.a = uuid.replace("-", "");
                this.a += "_" + j;
                this.c = j;
                this.b = true;
            }
        }

        public final boolean b(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j2 - j >= this.d.a : invokeCommon.booleanValue;
        }
    }

    public f0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1800000L;
        this.b = false;
        this.c = null;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = this.c;
            if (aVar == null) {
                y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
                return "";
            }
            return aVar.a;
        }
        return (String) invokeV.objValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(j);
                return;
            }
            y.c("hmsSdk", "Session is first flush");
            this.c = new a(this, j);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a aVar = this.c;
            if (aVar == null) {
                y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
                return false;
            }
            return aVar.b;
        }
        return invokeV.booleanValue;
    }
}
