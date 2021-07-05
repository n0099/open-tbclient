package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.os.Build;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AndroidTrackInfo implements ITrackInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaPlayer.TrackInfo mTrackInfo;

    public AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {trackInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTrackInfo = trackInfo;
    }

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mediaPlayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mediaPlayer)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return fromTrackInfo(mediaPlayer.getTrackInfo());
            }
            return null;
        }
        return (AndroidTrackInfo[]) invokeL.objValue;
    }

    public static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, trackInfoArr)) == null) {
            if (trackInfoArr == null) {
                return null;
            }
            AndroidTrackInfo[] androidTrackInfoArr = new AndroidTrackInfo[trackInfoArr.length];
            for (int i2 = 0; i2 < trackInfoArr.length; i2++) {
                androidTrackInfoArr[i2] = new AndroidTrackInfo(trackInfoArr[i2]);
            }
            return androidTrackInfoArr;
        }
        return (AndroidTrackInfo[]) invokeL.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    @TargetApi(19)
    public IMediaFormat getFormat() {
        InterceptResult invokeV;
        MediaFormat format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
            if (trackInfo == null || Build.VERSION.SDK_INT < 19 || (format = trackInfo.getFormat()) == null) {
                return null;
            }
            return new AndroidMediaFormat(format);
        }
        return (IMediaFormat) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    @TargetApi(16)
    public String getInfoInline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
            return trackInfo != null ? trackInfo.toString() : StringUtil.NULL_STRING;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    @TargetApi(16)
    public String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
            return trackInfo == null ? "und" : trackInfo.getLanguage();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    @TargetApi(16)
    public int getTrackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
            if (trackInfo == null) {
                return 0;
            }
            return trackInfo.getTrackType();
        }
        return invokeV.intValue;
    }

    @TargetApi(16)
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(AndroidTrackInfo.class.getSimpleName());
            sb.append('{');
            MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
            sb.append(trackInfo != null ? trackInfo.toString() : StringUtil.NULL_STRING);
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
