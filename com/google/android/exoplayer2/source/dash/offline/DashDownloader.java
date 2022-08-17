package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.offline.DownloadException;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.RepresentationKey;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest, RepresentationKey> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
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

    public static void addSegment(ArrayList<SegmentDownloader.Segment> arrayList, long j, String str, RangedUri rangedUri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{arrayList, Long.valueOf(j), str, rangedUri}) == null) {
            arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, null)));
        }
    }

    private DashSegmentIndex getSegmentIndex(DataSource dataSource, DashManifest dashManifest, RepresentationKey representationKey) throws IOException, InterruptedException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, dataSource, dashManifest, representationKey)) == null) {
            AdaptationSet adaptationSet = dashManifest.getPeriod(representationKey.periodIndex).adaptationSets.get(representationKey.adaptationSetIndex);
            Representation representation = adaptationSet.representations.get(representationKey.representationIndex);
            DashSegmentIndex index = representation.getIndex();
            if (index != null) {
                return index;
            }
            ChunkIndex loadChunkIndex = DashUtil.loadChunkIndex(dataSource, adaptationSet.type, representation);
            if (loadChunkIndex == null) {
                return null;
            }
            return new DashWrappingSegmentIndex(loadChunkIndex);
        }
        return (DashSegmentIndex) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getAllSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, dataSource, dashManifest, z)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < dashManifest.getPeriodCount(); i++) {
                List<AdaptationSet> list = dashManifest.getPeriod(i).adaptationSets;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    int size = list.get(i2).representations.size();
                    RepresentationKey[] representationKeyArr = new RepresentationKey[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        representationKeyArr[i3] = new RepresentationKey(i, i2, i3);
                    }
                    arrayList.addAll(getSegments(dataSource, dashManifest, representationKeyArr, z));
                }
            }
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public DashManifest getManifest(DataSource dataSource, Uri uri) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataSource, uri)) == null) ? DashUtil.loadManifest(dataSource, uri) : (DashManifest) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, RepresentationKey[] representationKeyArr, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        DashSegmentIndex segmentIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{dataSource, dashManifest, representationKeyArr, Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            for (RepresentationKey representationKey : representationKeyArr) {
                try {
                    segmentIndex = getSegmentIndex(dataSource, dashManifest, representationKey);
                } catch (IOException e) {
                    if (!z) {
                        throw e;
                    }
                }
                if (segmentIndex != null) {
                    int segmentCount = segmentIndex.getSegmentCount(C.TIME_UNSET);
                    if (segmentCount != -1) {
                        Period period = dashManifest.getPeriod(representationKey.periodIndex);
                        Representation representation = period.adaptationSets.get(representationKey.adaptationSetIndex).representations.get(representationKey.representationIndex);
                        long msToUs = C.msToUs(period.startMs);
                        String str = representation.baseUrl;
                        RangedUri initializationUri = representation.getInitializationUri();
                        if (initializationUri != null) {
                            addSegment(arrayList, msToUs, str, initializationUri);
                        }
                        RangedUri indexUri = representation.getIndexUri();
                        if (indexUri != null) {
                            addSegment(arrayList, msToUs, str, indexUri);
                        }
                        int firstSegmentNum = segmentIndex.getFirstSegmentNum();
                        int i = (segmentCount + firstSegmentNum) - 1;
                        while (firstSegmentNum <= i) {
                            addSegment(arrayList, segmentIndex.getTimeUs(firstSegmentNum) + msToUs, str, segmentIndex.getSegmentUrl(firstSegmentNum));
                            firstSegmentNum++;
                        }
                    } else {
                        throw new DownloadException("Unbounded index for representation: " + representationKey);
                    }
                } else {
                    throw new DownloadException("No index for representation: " + representationKey);
                    break;
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }
}
