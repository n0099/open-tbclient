package com.google.android.exoplayer2.source.hls.playlist;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class HlsMasterPlaylist extends HlsPlaylist {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<HlsUrl> audios;
    public final Format muxedAudioFormat;
    public final List<Format> muxedCaptionFormats;
    public final List<HlsUrl> subtitles;
    public final List<HlsUrl> variants;

    /* loaded from: classes7.dex */
    public static final class HlsUrl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Format format;
        public final String url;

        public HlsUrl(String str, Format format) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, format};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
            this.format = format;
        }

        public static HlsUrl createMediaPlaylistHlsUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return new HlsUrl(str, Format.createContainerFormat("0", MimeTypes.APPLICATION_M3U8, null, null, -1, 0, null));
            }
            return (HlsUrl) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HlsMasterPlaylist(String str, List<String> list, List<HlsUrl> list2, List<HlsUrl> list3, List<HlsUrl> list4, Format format, List<Format> list5) {
        super(str, list);
        List<Format> list6;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, list2, list3, list4, format, list5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.variants = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.subtitles = Collections.unmodifiableList(list4);
        this.muxedAudioFormat = format;
        if (list5 != null) {
            list6 = Collections.unmodifiableList(list5);
        } else {
            list6 = null;
        }
        this.muxedCaptionFormats = list6;
    }

    public static List<HlsUrl> copyRenditionsList(List<HlsUrl> list, List<String> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, list2)) == null) {
            ArrayList arrayList = new ArrayList(list2.size());
            for (int i = 0; i < list.size(); i++) {
                HlsUrl hlsUrl = list.get(i);
                if (list2.contains(hlsUrl.url)) {
                    arrayList.add(hlsUrl);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static HlsMasterPlaylist createSingleVariantMasterPlaylist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            List singletonList = Collections.singletonList(HlsUrl.createMediaPlaylistHlsUrl(str));
            List emptyList = Collections.emptyList();
            return new HlsMasterPlaylist(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        }
        return (HlsMasterPlaylist) invokeL.objValue;
    }

    public HlsMasterPlaylist copy(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            return new HlsMasterPlaylist(this.baseUri, this.tags, copyRenditionsList(this.variants, list), copyRenditionsList(this.audios, list), copyRenditionsList(this.subtitles, list), this.muxedAudioFormat, this.muxedCaptionFormats);
        }
        return (HlsMasterPlaylist) invokeL.objValue;
    }
}
