package com.kwai.video.ksvodplayerkit;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class raw {
        public static /* synthetic */ Interceptable $ic;
        public static final int kwaiplayer_fragment_shader;
        public static final int kwaiplayer_vertex_shader;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(161256205, "Lcom/kwai/video/ksvodplayerkit/R$raw;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(161256205, "Lcom/kwai/video/ksvodplayerkit/R$raw;");
                    return;
                }
            }
            kwaiplayer_fragment_shader = com.kwad.sdk.R.raw.kwaiplayer_fragment_shader;
            kwaiplayer_vertex_shader = com.kwad.sdk.R.raw.kwaiplayer_vertex_shader;
        }

        public raw() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic;
        public static final int a_cache;
        public static final int a_delay;
        public static final int aenc_init;
        public static final int after_first_frame_decode;
        public static final int aout_info;
        public static final int app_name;
        public static final int audio_codec;
        public static final int basic_info;
        public static final int cache_buffer_ds_info;
        public static final int cache_enabled;
        public static final int cache_http_connect_ms;
        public static final int cache_total_room;
        public static final int cache_type_info;
        public static final int cached_total;
        public static final int comment;
        public static final int connect_time;
        public static final int current_read_uri;
        public static final int current_state;
        public static final int default_na_value;
        public static final int dns_analyze_time;
        public static final int dropped_duration;
        public static final int find_stream_info;
        public static final int first_frame_render;
        public static final int first_screen_time;
        public static final int fps;
        public static final int host;
        public static final int host_info;
        public static final int http_1st_pkt_time;
        public static final int isLiveAdaptive;
        public static final int is_playing;
        public static final int last_error;
        public static final int liveAEncInit;
        public static final int liveAudioBufLen;
        public static final int liveAudioBufTime;
        public static final int liveAudioTotalBytes;
        public static final int liveBandwidth;
        public static final int liveComment;
        public static final int liveDroppedTotal;
        public static final int liveE2EDelay;
        public static final int liveFirstScreenTimeCodecOpen;
        public static final int liveFirstScreenTimeDecode;
        public static final int liveFirstScreenTimeDnsAnalyze;
        public static final int liveFirstScreenTimeDroppedDuration;
        public static final int liveFirstScreenTimeHttpConnect;
        public static final int liveFirstScreenTimeInputOpen;
        public static final int liveFirstScreenTimePktRecv;
        public static final int liveFirstScreenTimePreDecode;
        public static final int liveFirstScreenTimeRender;
        public static final int liveFirstScreenTimeStreamFind;
        public static final int liveFirstScreenTimeTotal;
        public static final int liveFirstScreenTimeWaitForPlay;
        public static final int liveHostInfo;
        public static final int livePlayingBitrate;
        public static final int liveVEncDynamic;
        public static final int liveVEncInit;
        public static final int liveVideoBufLen;
        public static final int liveVideoBufTime;
        public static final int liveVideoTotalBytes;
        public static final int open_decoder;
        public static final int open_input;
        public static final int player_config_info;
        public static final int pre_first_frame_decode;
        public static final int pre_load_finish;
        public static final int reopen_count;
        public static final int section_cache_not_used;
        public static final int section_cache_used;
        public static final int server_ip;
        public static final int use_pre_load;
        public static final int v_cache;
        public static final int v_delay;
        public static final int vdec;
        public static final int venc_dynamic;
        public static final int venc_init;
        public static final int video_codec;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-656481776, "Lcom/kwai/video/ksvodplayerkit/R$string;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-656481776, "Lcom/kwai/video/ksvodplayerkit/R$string;");
                    return;
                }
            }
            a_cache = com.kwad.sdk.R.string.a_cache;
            a_delay = com.kwad.sdk.R.string.a_delay;
            aenc_init = com.kwad.sdk.R.string.aenc_init;
            after_first_frame_decode = com.kwad.sdk.R.string.after_first_frame_decode;
            aout_info = com.kwad.sdk.R.string.aout_info;
            app_name = com.kwad.sdk.R.string.app_name;
            audio_codec = com.kwad.sdk.R.string.audio_codec;
            basic_info = com.kwad.sdk.R.string.basic_info;
            cache_buffer_ds_info = com.kwad.sdk.R.string.cache_buffer_ds_info;
            cache_enabled = com.kwad.sdk.R.string.cache_enabled;
            cache_http_connect_ms = com.kwad.sdk.R.string.cache_http_connect_ms;
            cache_total_room = com.kwad.sdk.R.string.cache_total_room;
            cache_type_info = com.kwad.sdk.R.string.cache_type_info;
            cached_total = com.kwad.sdk.R.string.cached_total;
            comment = com.kwad.sdk.R.string.comment;
            connect_time = com.kwad.sdk.R.string.connect_time;
            current_read_uri = com.kwad.sdk.R.string.current_read_uri;
            current_state = com.kwad.sdk.R.string.current_state;
            default_na_value = com.kwad.sdk.R.string.default_na_value;
            dns_analyze_time = com.kwad.sdk.R.string.dns_analyze_time;
            dropped_duration = com.kwad.sdk.R.string.dropped_duration;
            find_stream_info = com.kwad.sdk.R.string.find_stream_info;
            first_frame_render = com.kwad.sdk.R.string.first_frame_render;
            first_screen_time = com.kwad.sdk.R.string.first_screen_time;
            fps = com.kwad.sdk.R.string.fps;
            host = com.kwad.sdk.R.string.host;
            host_info = com.kwad.sdk.R.string.host_info;
            http_1st_pkt_time = com.kwad.sdk.R.string.http_1st_pkt_time;
            isLiveAdaptive = com.kwad.sdk.R.string.isLiveAdaptive;
            is_playing = com.kwad.sdk.R.string.is_playing;
            last_error = com.kwad.sdk.R.string.last_error;
            liveAEncInit = com.kwad.sdk.R.string.liveAEncInit;
            liveAudioBufLen = com.kwad.sdk.R.string.liveAudioBufLen;
            liveAudioBufTime = com.kwad.sdk.R.string.liveAudioBufTime;
            liveAudioTotalBytes = com.kwad.sdk.R.string.liveAudioTotalBytes;
            liveBandwidth = com.kwad.sdk.R.string.liveBandwidth;
            liveComment = com.kwad.sdk.R.string.liveComment;
            liveDroppedTotal = com.kwad.sdk.R.string.liveDroppedTotal;
            liveE2EDelay = com.kwad.sdk.R.string.liveE2EDelay;
            liveFirstScreenTimeCodecOpen = com.kwad.sdk.R.string.liveFirstScreenTimeCodecOpen;
            liveFirstScreenTimeDecode = com.kwad.sdk.R.string.liveFirstScreenTimeDecode;
            liveFirstScreenTimeDnsAnalyze = com.kwad.sdk.R.string.liveFirstScreenTimeDnsAnalyze;
            liveFirstScreenTimeDroppedDuration = com.kwad.sdk.R.string.liveFirstScreenTimeDroppedDuration;
            liveFirstScreenTimeHttpConnect = com.kwad.sdk.R.string.liveFirstScreenTimeHttpConnect;
            liveFirstScreenTimeInputOpen = com.kwad.sdk.R.string.liveFirstScreenTimeInputOpen;
            liveFirstScreenTimePktRecv = com.kwad.sdk.R.string.liveFirstScreenTimePktRecv;
            liveFirstScreenTimePreDecode = com.kwad.sdk.R.string.liveFirstScreenTimePreDecode;
            liveFirstScreenTimeRender = com.kwad.sdk.R.string.liveFirstScreenTimeRender;
            liveFirstScreenTimeStreamFind = com.kwad.sdk.R.string.liveFirstScreenTimeStreamFind;
            liveFirstScreenTimeTotal = com.kwad.sdk.R.string.liveFirstScreenTimeTotal;
            liveFirstScreenTimeWaitForPlay = com.kwad.sdk.R.string.liveFirstScreenTimeWaitForPlay;
            liveHostInfo = com.kwad.sdk.R.string.liveHostInfo;
            livePlayingBitrate = com.kwad.sdk.R.string.livePlayingBitrate;
            liveVEncDynamic = com.kwad.sdk.R.string.liveVEncDynamic;
            liveVEncInit = com.kwad.sdk.R.string.liveVEncInit;
            liveVideoBufLen = com.kwad.sdk.R.string.liveVideoBufLen;
            liveVideoBufTime = com.kwad.sdk.R.string.liveVideoBufTime;
            liveVideoTotalBytes = com.kwad.sdk.R.string.liveVideoTotalBytes;
            open_decoder = com.kwad.sdk.R.string.open_decoder;
            open_input = com.kwad.sdk.R.string.open_input;
            player_config_info = com.kwad.sdk.R.string.player_config_info;
            pre_first_frame_decode = com.kwad.sdk.R.string.pre_first_frame_decode;
            pre_load_finish = com.kwad.sdk.R.string.pre_load_finish;
            reopen_count = com.kwad.sdk.R.string.reopen_count;
            section_cache_not_used = com.kwad.sdk.R.string.section_cache_not_used;
            section_cache_used = com.kwad.sdk.R.string.section_cache_used;
            server_ip = com.kwad.sdk.R.string.server_ip;
            use_pre_load = com.kwad.sdk.R.string.use_pre_load;
            v_cache = com.kwad.sdk.R.string.v_cache;
            v_delay = com.kwad.sdk.R.string.v_delay;
            vdec = com.kwad.sdk.R.string.vdec;
            venc_dynamic = com.kwad.sdk.R.string.venc_dynamic;
            venc_init = com.kwad.sdk.R.string.venc_init;
            video_codec = com.kwad.sdk.R.string.video_codec;
        }

        public string() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public R() {
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
}
