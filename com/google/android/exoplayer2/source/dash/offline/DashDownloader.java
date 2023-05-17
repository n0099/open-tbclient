package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
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
/* loaded from: classes9.dex */
public final class DashDownloader extends SegmentDownloader<DashManifest, RepresentationKey> {
    public DashDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
        super(uri, downloaderConstructorHelper);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public DashManifest getManifest(DataSource dataSource, Uri uri) throws IOException {
        return DashUtil.loadManifest(dataSource, uri);
    }

    public static void addSegment(ArrayList<SegmentDownloader.Segment> arrayList, long j, String str, RangedUri rangedUri) {
        arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(rangedUri.resolveUri(str), rangedUri.start, rangedUri.length, null)));
    }

    private DashSegmentIndex getSegmentIndex(DataSource dataSource, DashManifest dashManifest, RepresentationKey representationKey) throws IOException, InterruptedException {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getAllSegments(DataSource dataSource, DashManifest dashManifest, boolean z) throws InterruptedException, IOException {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, DashManifest dashManifest, RepresentationKey[] representationKeyArr, boolean z) throws InterruptedException, IOException {
        DashSegmentIndex segmentIndex;
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
}
