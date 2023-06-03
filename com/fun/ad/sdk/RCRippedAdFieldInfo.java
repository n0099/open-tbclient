package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class RCRippedAdFieldInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<String> rcClkUrlSet;
    public final Set<String> rcCopSet;
    public final Set<String> rcPkgSet;
    public final Set<String> rcTilSet;

    /* loaded from: classes9.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<String> a;
        public Set<String> b;
        public Set<String> c;
        public Set<String> d;

        public Builder() {
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
            this.a = new HashSet();
            this.b = new HashSet();
            this.c = new HashSet();
            this.d = new HashSet();
        }

        public RCRippedAdFieldInfo build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new RCRippedAdFieldInfo(this.a, this.b, this.c, this.d) : (RCRippedAdFieldInfo) invokeV.objValue;
        }

        public Builder setRcAdUrl(Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
                if (set != null) {
                    this.b = set;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRcCompany(Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set)) == null) {
                if (set != null) {
                    this.d = set;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRcPkg(Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, set)) == null) {
                if (set != null) {
                    this.a = set;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRcTitle(Set<String> set) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, set)) == null) {
                if (set != null) {
                    this.c = set;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public RCRippedAdFieldInfo(Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, set2, set3, set4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rcPkgSet = Collections.unmodifiableSet(set);
        this.rcClkUrlSet = Collections.unmodifiableSet(set2);
        this.rcTilSet = Collections.unmodifiableSet(set3);
        this.rcCopSet = Collections.unmodifiableSet(set4);
    }
}
