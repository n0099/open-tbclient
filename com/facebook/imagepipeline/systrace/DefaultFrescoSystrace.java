package com.facebook.imagepipeline.systrace;

import android.os.Build;
import android.os.Trace;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes6.dex */
public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultFrescoSystrace() {
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

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? FrescoSystrace.NO_OP_ARGS_BUILDER : (FrescoSystrace.ArgsBuilder) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
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
            this.mStringBuilder = new StringBuilder(str);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, obj)) == null) {
                StringBuilder sb = this.mStringBuilder;
                sb.append(WebvttCueParser.CHAR_SEMI_COLON);
                sb.append(str);
                sb.append('=');
                sb.append(obj == null ? StringUtil.NULL_STRING : obj.toString());
                return this;
            }
            return (FrescoSystrace.ArgsBuilder) invokeLL.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.mStringBuilder.length() > 127) {
                    this.mStringBuilder.setLength(127);
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    Trace.beginSection(this.mStringBuilder.toString());
                }
            }
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
                StringBuilder sb = this.mStringBuilder;
                sb.append(WebvttCueParser.CHAR_SEMI_COLON);
                sb.append(str);
                sb.append('=');
                sb.append(Integer.toString(i));
                return this;
            }
            return (FrescoSystrace.ArgsBuilder) invokeLI.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
                StringBuilder sb = this.mStringBuilder;
                sb.append(WebvttCueParser.CHAR_SEMI_COLON);
                sb.append(str);
                sb.append('=');
                sb.append(Long.toString(j));
                return this;
            }
            return (FrescoSystrace.ArgsBuilder) invokeLJ.objValue;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
                StringBuilder sb = this.mStringBuilder;
                sb.append(WebvttCueParser.CHAR_SEMI_COLON);
                sb.append(str);
                sb.append('=');
                sb.append(Double.toString(d2));
                return this;
            }
            return (FrescoSystrace.ArgsBuilder) invokeCommon.objValue;
        }
    }
}
