package com.huawei.hms.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class Api<O extends ApiOptions> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mApiName;
    public List<ConnectionPostProcessor> mConnetctPostList;
    public final Options<O> mOption;

    /* loaded from: classes10.dex */
    public interface ApiOptions {

        /* loaded from: classes10.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: classes10.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: classes10.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        /* loaded from: classes10.dex */
        public static final class NoOptions implements NotRequiredOptions {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public NoOptions() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class Options<O> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Options() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public List<PermissionInfo> getPermissionInfoList(O o) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeL.objValue;
        }

        public List<Scope> getScopeList(O o) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeL.objValue;
        }
    }

    public Api(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mApiName = str;
        this.mOption = null;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.mConnetctPostList = list;
        }
    }

    public Api(String str, Options<O> options) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, options};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mApiName = str;
        this.mOption = options;
    }

    public String getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mApiName;
        }
        return (String) invokeV.objValue;
    }

    public Options<O> getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mOption;
        }
        return (Options) invokeV.objValue;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mConnetctPostList;
        }
        return (List) invokeV.objValue;
    }
}
