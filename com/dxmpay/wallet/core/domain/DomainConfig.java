package com.dxmpay.wallet.core.domain;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.f.a.b.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DomainConfig implements c.f.a.b.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.f.a.b.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.f.a.b.b.a f52654b;

    /* renamed from: c  reason: collision with root package name */
    public c.f.a.b.b.a f52655c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class DomainStrategyType {
        public static final /* synthetic */ DomainStrategyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DomainStrategyType ONLINE;
        public static final DomainStrategyType QA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(801106871, "Lcom/dxmpay/wallet/core/domain/DomainConfig$DomainStrategyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(801106871, "Lcom/dxmpay/wallet/core/domain/DomainConfig$DomainStrategyType;");
                    return;
                }
            }
            ONLINE = new DomainStrategyType("ONLINE", 0);
            DomainStrategyType domainStrategyType = new DomainStrategyType("QA", 1);
            QA = domainStrategyType;
            $VALUES = new DomainStrategyType[]{ONLINE, domainStrategyType};
        }

        public DomainStrategyType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DomainStrategyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DomainStrategyType) Enum.valueOf(DomainStrategyType.class, str) : (DomainStrategyType) invokeL.objValue;
        }

        public static DomainStrategyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DomainStrategyType[]) $VALUES.clone() : (DomainStrategyType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-660344147, "Lcom/dxmpay/wallet/core/domain/DomainConfig$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-660344147, "Lcom/dxmpay/wallet/core/domain/DomainConfig$a;");
                    return;
                }
            }
            int[] iArr = new int[DomainStrategyType.values().length];
            a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DomainStrategyType.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final DomainConfig a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-660344116, "Lcom/dxmpay/wallet/core/domain/DomainConfig$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-660344116, "Lcom/dxmpay/wallet/core/domain/DomainConfig$b;");
                    return;
                }
            }
            a = new DomainConfig(null);
        }
    }

    public /* synthetic */ DomainConfig(a aVar) {
        this();
    }

    public static DomainConfig getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (DomainConfig) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getAppHost() : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getAppPayHost() : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getInitHost() : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getRtcHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.getRtcHost(str) : (String) invokeL.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getSpareInitHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getSpareInitHost() : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getZhiFuHost() : (String) invokeV.objValue;
    }

    @Override // c.f.a.b.b.a
    public void setDomainConfig(String str) {
        c.f.a.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.setDomainConfig(str);
    }

    @Override // c.f.a.b.b.a
    public void setDxmPayContext(Context context) {
        c.f.a.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, context) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.setDxmPayContext(context);
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, domainStrategyType) == null) {
            int i2 = a.a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.a = this.f52655c;
            } else if (i2 != 2) {
            } else {
                this.a = this.f52654b;
            }
        }
    }

    public DomainConfig() {
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
        this.f52654b = new c.f.a.b.b.b();
        this.f52655c = c.a();
        this.a = this.f52654b;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, domainStrategyType, str) == null) {
            int i2 = a.a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.a = this.f52655c;
            } else if (i2 == 2) {
                this.a = this.f52654b;
            }
            this.a.setDomainConfig(str);
        }
    }
}
