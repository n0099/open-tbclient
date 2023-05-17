package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
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
/* loaded from: classes9.dex */
public final class HlsDownloader extends SegmentDownloader<HlsMasterPlaylist, String> {
    public HlsDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
        super(uri, downloaderConstructorHelper);
    }

    public static void extractUrls(List<HlsMasterPlaylist.HlsUrl> list, ArrayList<String> arrayList) {
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).url);
        }
    }

    private HlsPlaylist loadManifest(DataSource dataSource, Uri uri) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, new DataSpec(uri, 3), 4, new HlsPlaylistParser());
        parsingLoadable.load();
        return (HlsPlaylist) parsingLoadable.getResult();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public HlsMasterPlaylist getManifest(DataSource dataSource, Uri uri) throws IOException {
        HlsPlaylist loadManifest = loadManifest(dataSource, uri);
        if (loadManifest instanceof HlsMasterPlaylist) {
            return (HlsMasterPlaylist) loadManifest;
        }
        return HlsMasterPlaylist.createSingleVariantMasterPlaylist(loadManifest.baseUri);
    }

    public static void addSegment(ArrayList<SegmentDownloader.Segment> arrayList, HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment, HashSet<Uri> hashSet) throws IOException, InterruptedException {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getAllSegments(DataSource dataSource, HlsMasterPlaylist hlsMasterPlaylist, boolean z) throws InterruptedException, IOException {
        ArrayList arrayList = new ArrayList();
        extractUrls(hlsMasterPlaylist.variants, arrayList);
        extractUrls(hlsMasterPlaylist.audios, arrayList);
        extractUrls(hlsMasterPlaylist.subtitles, arrayList);
        return getSegments(dataSource, hlsMasterPlaylist, (String[]) arrayList.toArray(new String[arrayList.size()]), z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public List<SegmentDownloader.Segment> getSegments(DataSource dataSource, HlsMasterPlaylist hlsMasterPlaylist, String[] strArr, boolean z) throws InterruptedException, IOException {
        long j;
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
            if (hlsMediaPlaylist != null) {
                j = hlsMediaPlaylist.startTimeUs;
            } else {
                j = Long.MIN_VALUE;
            }
            arrayList.add(new SegmentDownloader.Segment(j, new DataSpec(resolveToUri)));
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
}
