package com.google.android.exoplayer2.source.smoothstreaming.offline;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.TrackKey;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class SsDownloader extends SegmentDownloader<SsManifest, TrackKey> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SsDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getAllSegments(DataSource dataSource, SsManifest ssManifest, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(1048576, this, dataSource, ssManifest, z)) != null) {
            return (List) invokeLLZ.objValue;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i >= streamElementArr.length) {
                return arrayList;
            }
            SsManifest.StreamElement streamElement = streamElementArr[i];
            for (int i2 = 0; i2 < streamElement.formats.length; i2++) {
                arrayList.addAll(getSegments(dataSource, ssManifest, new TrackKey[]{new TrackKey(i, i2)}, z));
            }
            i++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public SsManifest getManifest(DataSource dataSource, Uri uri) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataSource, uri)) == null) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, new DataSpec(uri, 3), 4, new SsManifestParser());
            parsingLoadable.load();
            return (SsManifest) parsingLoadable.getResult();
        }
        return (SsManifest) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, SsManifest ssManifest, TrackKey[] trackKeyArr, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{dataSource, ssManifest, trackKeyArr, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            for (TrackKey trackKey : trackKeyArr) {
                SsManifest.StreamElement streamElement = ssManifest.streamElements[trackKey.streamElementIndex];
                for (int i = 0; i < streamElement.chunkCount; i++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.getStartTimeUs(i), new DataSpec(streamElement.buildRequestUri(trackKey.trackIndex, i))));
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }
}
