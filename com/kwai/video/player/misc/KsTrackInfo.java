package com.kwai.video.player.misc;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.KsMediaMeta;
/* loaded from: classes7.dex */
public class KsTrackInfo implements ITrackInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsMediaMeta.KSYStreamMeta mStreamMeta;
    public int mTrackType;

    public KsTrackInfo(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kSYStreamMeta};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTrackType = 0;
        this.mStreamMeta = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new KsMediaFormat(this.mStreamMeta) : (IMediaFormat) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getInfoInline() {
        InterceptResult invokeV;
        String resolutionInline;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            int i2 = this.mTrackType;
            if (i2 == 1) {
                sb.append(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mStreamMeta.getCodecShortNameInline());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mStreamMeta.getBitrateInline());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                resolutionInline = this.mStreamMeta.getResolutionInline();
            } else if (i2 != 2) {
                resolutionInline = i2 != 3 ? i2 != 4 ? RomUtils.UNKNOWN : "SUBTITLE" : "TIMEDTEXT";
            } else {
                sb.append("AUDIO");
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mStreamMeta.getCodecShortNameInline());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.mStreamMeta.getBitrateInline());
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                resolutionInline = this.mStreamMeta.getSampleRateInline();
            }
            sb.append(resolutionInline);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            KsMediaMeta.KSYStreamMeta kSYStreamMeta = this.mStreamMeta;
            return (kSYStreamMeta == null || TextUtils.isEmpty(kSYStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public int getTrackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTrackType : invokeV.intValue;
    }

    public void setMediaMeta(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kSYStreamMeta) == null) {
            this.mStreamMeta = kSYStreamMeta;
        }
    }

    public void setTrackType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mTrackType = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return KsTrackInfo.class.getSimpleName() + '{' + getInfoInline() + "}";
        }
        return (String) invokeV.objValue;
    }
}
