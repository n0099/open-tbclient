package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.SdpPrefer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.KsMediaMeta;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class KsMediaFormat implements IMediaFormat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_KS_BIT_RATE_UI = "ks-bit-rate-ui";
    public static final String KEY_KS_CHANNEL_UI = "ks-channel-ui";
    public static final String KEY_KS_CODEC_LONG_NAME_UI = "ks-codec-long-name-ui";
    public static final String KEY_KS_CODEC_PIXEL_FORMAT_UI = "ks-pixel-format-ui";
    public static final String KEY_KS_CODEC_PROFILE_LEVEL_UI = "ks-profile-level-ui";
    public static final String KEY_KS_FRAME_RATE_UI = "ks-frame-rate-ui";
    public static final String KEY_KS_RESOLUTION_UI = "ks-resolution-ui";
    public static final String KEY_KS_SAMPLE_RATE_UI = "ks-sample-rate-ui";
    public static final Map<String, Formatter> sFormatterMap;
    public transient /* synthetic */ FieldHolder $fh;
    public final KsMediaMeta.KSYStreamMeta mMediaFormat;

    /* loaded from: classes7.dex */
    public static abstract class Formatter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Formatter() {
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

        public abstract String doFormat(KsMediaFormat ksMediaFormat);

        public String format(KsMediaFormat ksMediaFormat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksMediaFormat)) == null) {
                String doFormat = doFormat(ksMediaFormat);
                return TextUtils.isEmpty(doFormat) ? getDefaultString() : doFormat;
            }
            return (String) invokeL.objValue;
        }

        public String getDefaultString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "N/A" : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1075061518, "Lcom/kwai/video/player/misc/KsMediaFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1075061518, "Lcom/kwai/video/player/misc/KsMediaFormat;");
                return;
            }
        }
        sFormatterMap = new HashMap();
    }

    public KsMediaFormat(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kSYStreamMeta};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        sFormatterMap.put(KEY_KS_CODEC_LONG_NAME_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) ? this.this$0.mMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_LONG_NAME) : (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_BIT_RATE_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_BITRATE);
                    if (integer <= 0) {
                        return null;
                    }
                    return integer < 1000 ? String.format(Locale.US, "%d bit/s", Integer.valueOf(integer)) : String.format(Locale.US, "%d kb/s", Integer.valueOf(integer / 1000));
                }
                return (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_CODEC_PROFILE_LEVEL_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    String string = ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_PROFILE);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    String string2 = ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_NAME);
                    if (!TextUtils.isEmpty(string2) && string2.equalsIgnoreCase(KsMediaFormat.CODEC_NAME_H264)) {
                        int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_CODEC_LEVEL);
                        if (integer < 10) {
                            return sb.toString();
                        }
                        sb.append(" Profile Level ");
                        sb.append((integer / 10) % 10);
                        int i4 = integer % 10;
                        if (i4 != 0) {
                            sb.append(".");
                            sb.append(i4);
                        }
                    }
                    return sb.toString();
                }
                return (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_CODEC_PIXEL_FORMAT_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) ? ksMediaFormat.getString(KsMediaMeta.KSM_KEY_CODEC_PIXEL_FORMAT) : (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_RESOLUTION_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    int integer = ksMediaFormat.getInteger("width");
                    int integer2 = ksMediaFormat.getInteger("height");
                    int integer3 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAR_NUM);
                    int integer4 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAR_DEN);
                    if (integer <= 0 || integer2 <= 0) {
                        return null;
                    }
                    return (integer3 <= 0 || integer4 <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(integer), Integer.valueOf(integer2)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4));
                }
                return (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_FRAME_RATE_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_FPS_NUM);
                    int integer2 = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_FPS_DEN);
                    if (integer <= 0 || integer2 <= 0) {
                        return null;
                    }
                    return String.valueOf(integer / integer2);
                }
                return (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_SAMPLE_RATE_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_SAMPLE_RATE);
                    if (integer <= 0) {
                        return null;
                    }
                    return String.format(Locale.US, "%d Hz", Integer.valueOf(integer));
                }
                return (String) invokeL.objValue;
            }
        });
        sFormatterMap.put(KEY_KS_CHANNEL_UI, new Formatter(this) { // from class: com.kwai.video.player.misc.KsMediaFormat.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsMediaFormat this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext2.callArgs[0];
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.player.misc.KsMediaFormat.Formatter
            public String doFormat(KsMediaFormat ksMediaFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ksMediaFormat)) == null) {
                    int integer = ksMediaFormat.getInteger(KsMediaMeta.KSM_KEY_CHANNEL_LAYOUT);
                    if (integer <= 0) {
                        return null;
                    }
                    long j = integer;
                    return j == 4 ? "mono" : j == 3 ? SdpPrefer.AUDIO_STEREO : String.format(Locale.US, "%x", Integer.valueOf(integer));
                }
                return (String) invokeL.objValue;
            }
        });
        this.mMediaFormat = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            KsMediaMeta.KSYStreamMeta kSYStreamMeta = this.mMediaFormat;
            if (kSYStreamMeta == null) {
                return 0;
            }
            return kSYStreamMeta.getInt(str);
        }
        return invokeL.intValue;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.mMediaFormat == null) {
                return null;
            }
            return sFormatterMap.containsKey(str) ? sFormatterMap.get(str).format(this) : this.mMediaFormat.getString(str);
        }
        return (String) invokeL.objValue;
    }
}
