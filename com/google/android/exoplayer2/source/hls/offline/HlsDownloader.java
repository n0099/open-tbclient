package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public final class HlsDownloader extends SegmentDownloader<HlsMasterPlaylist, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HlsDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
        super(uri, downloaderConstructorHelper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, downloaderConstructorHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Uri) objArr2[0], (DownloaderConstructorHelper) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void addSegment(ArrayList<SegmentDownloader.Segment> arrayList, HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment, HashSet<Uri> hashSet) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, arrayList, hlsMediaPlaylist, segment, hashSet) == null) {
            long j = hlsMediaPlaylist.startTimeUs + segment.relativeStartTimeUs;
            String str = segment.fullSegmentEncryptionKeyUri;
            if (str != null) {
                Uri resolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
                if (hashSet.add(resolveToUri)) {
                    arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(resolveToUri)));
                }
            }
            arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null)));
        }
    }

    public static void extractUrls(List<HlsMasterPlaylist.HlsUrl> list, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, list, arrayList) == null) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).url);
            }
        }
    }

    private HlsPlaylist loadManifest(DataSource dataSource, Uri uri) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, dataSource, uri)) == null) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, new DataSpec(uri, 3), 4, new HlsPlaylistParser());
            parsingLoadable.load();
            return (HlsPlaylist) parsingLoadable.getResult();
        }
        return (HlsPlaylist) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getAllSegments(DataSource dataSource, HlsMasterPlaylist hlsMasterPlaylist, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, dataSource, hlsMasterPlaylist, z)) == null) {
            ArrayList arrayList = new ArrayList();
            extractUrls(hlsMasterPlaylist.variants, arrayList);
            extractUrls(hlsMasterPlaylist.audios, arrayList);
            extractUrls(hlsMasterPlaylist.subtitles, arrayList);
            return getSegments(dataSource, hlsMasterPlaylist, (String[]) arrayList.toArray(new String[arrayList.size()]), z);
        }
        return (List) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public HlsMasterPlaylist getManifest(DataSource dataSource, Uri uri) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataSource, uri)) == null) {
            HlsPlaylist loadManifest = loadManifest(dataSource, uri);
            if (loadManifest instanceof HlsMasterPlaylist) {
                return (HlsMasterPlaylist) loadManifest;
            }
            return HlsMasterPlaylist.createSingleVariantMasterPlaylist(loadManifest.baseUri);
        }
        return (HlsMasterPlaylist) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, HlsMasterPlaylist hlsMasterPlaylist, String[] strArr, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{dataSource, hlsMasterPlaylist, strArr, Boolean.valueOf(z)})) == null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                HlsMediaPlaylist hlsMediaPlaylist = null;
                Uri resolveToUri = UriUtil.resolveToUri(hlsMasterPlaylist.baseUri, str);
                try {
                    hlsMediaPlaylist = (HlsMediaPlaylist) loadManifest(dataSource, resolveToUri);
                } catch (IOException e) {
                    if (!z) {
                        throw e;
                    }
                }
                arrayList.add(new SegmentDownloader.Segment(hlsMediaPlaylist != null ? hlsMediaPlaylist.startTimeUs : Long.MIN_VALUE, new DataSpec(resolveToUri)));
                if (hlsMediaPlaylist != null) {
                    HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.initializationSegment;
                    if (segment != null) {
                        addSegment(arrayList, hlsMediaPlaylist, segment, hashSet);
                    }
                    List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
                    for (int i = 0; i < list.size(); i++) {
                        addSegment(arrayList, hlsMediaPlaylist, list.get(i), hashSet);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }
}
