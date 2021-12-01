package com.kwad.sdk.core.report;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CommercialAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class TKDownloadMsg extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FAIL = 2;
        public static final int START = 0;
        public static final int SUCCESS = 1;
        public static final long serialVersionUID = -8872909341685100922L;
        public transient /* synthetic */ FieldHolder $fh;
        public int downloadState;
        public long downloadTime;
        public String errorReason;
        public int preload;
        public String templateId;
        public String versionCode;

        public TKDownloadMsg() {
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

        public TKDownloadMsg setDownloadState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.downloadState = i2;
                return this;
            }
            return (TKDownloadMsg) invokeI.objValue;
        }

        public TKDownloadMsg setDownloadTime(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.downloadTime = j2;
                return this;
            }
            return (TKDownloadMsg) invokeJ.objValue;
        }

        public TKDownloadMsg setErrorReason(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.errorReason = str;
                return this;
            }
            return (TKDownloadMsg) invokeL.objValue;
        }

        public TKDownloadMsg setPreload(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.preload = i2;
                return this;
            }
            return (TKDownloadMsg) invokeI.objValue;
        }

        public TKDownloadMsg setTemplateId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.templateId = str;
                return this;
            }
            return (TKDownloadMsg) invokeL.objValue;
        }

        public TKDownloadMsg setVersionCode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.versionCode = str;
                return this;
            }
            return (TKDownloadMsg) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class TKPerformMsg extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int OTHER_FAIL = 3;
        public static final int PAGE_STATUS_FAIL = 2;
        public static final int START = 0;
        public static final int SUCCESS = 1;
        public static final long serialVersionUID = -5293371882532982729L;
        public transient /* synthetic */ FieldHolder $fh;
        public String errorReason;
        public int renderState;
        public long renderTime;
        public int source;
        public String templateId;
        public String versionCode;

        public TKPerformMsg() {
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
            setSource(2);
        }

        public TKPerformMsg setErrorReason(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.errorReason = str;
                return this;
            }
            return (TKPerformMsg) invokeL.objValue;
        }

        public TKPerformMsg setRenderState(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                this.renderState = i2;
                return this;
            }
            return (TKPerformMsg) invokeI.objValue;
        }

        public TKPerformMsg setRenderTime(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.renderTime = j2;
                return this;
            }
            return (TKPerformMsg) invokeJ.objValue;
        }

        public TKPerformMsg setSource(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.source = i2;
                return this;
            }
            return (TKPerformMsg) invokeI.objValue;
        }

        public TKPerformMsg setTemplateId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.templateId = str;
                return this;
            }
            return (TKPerformMsg) invokeL.objValue;
        }

        public TKPerformMsg setVersionCode(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.versionCode = str;
                return this;
            }
            return (TKPerformMsg) invokeL.objValue;
        }
    }
}
