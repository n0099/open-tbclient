package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AndroidMediaFormat implements IMediaFormat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMediaFormat = mediaFormat;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            MediaFormat mediaFormat = this.mMediaFormat;
            if (mediaFormat == null) {
                return 0;
            }
            return mediaFormat.getInteger(str);
        }
        return invokeL.intValue;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            MediaFormat mediaFormat = this.mMediaFormat;
            if (mediaFormat == null) {
                return null;
            }
            return mediaFormat.getString(str);
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(16)
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(AndroidMediaFormat.class.getName());
            sb.append('{');
            MediaFormat mediaFormat = this.mMediaFormat;
            sb.append(mediaFormat != null ? mediaFormat.toString() : StringUtil.NULL_STRING);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
