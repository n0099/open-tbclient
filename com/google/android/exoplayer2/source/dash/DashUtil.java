package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;
/* loaded from: classes9.dex */
public final class DashUtil {
    public static Representation getFirstRepresentation(Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static DrmInitData loadDrmInitData(DataSource dataSource, Period period) throws IOException, InterruptedException {
        int i = 2;
        Representation firstRepresentation = getFirstRepresentation(period, 2);
        if (firstRepresentation == null) {
            i = 1;
            firstRepresentation = getFirstRepresentation(period, 1);
            if (firstRepresentation == null) {
                return null;
            }
        }
        DrmInitData drmInitData = firstRepresentation.format.drmInitData;
        if (drmInitData != null) {
            return drmInitData;
        }
        Format loadSampleFormat = loadSampleFormat(dataSource, i, firstRepresentation);
        if (loadSampleFormat == null) {
            return null;
        }
        return loadSampleFormat.drmInitData;
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, new DataSpec(uri, 3), 4, new DashManifestParser());
        parsingLoadable.load();
        return (DashManifest) parsingLoadable.getResult();
    }

    public static ChunkExtractorWrapper newWrappedExtractor(int i, Format format) {
        boolean z;
        Extractor fragmentedMp4Extractor;
        String str = format.containerMimeType;
        if (!str.startsWith(MimeTypes.VIDEO_WEBM) && !str.startsWith(MimeTypes.AUDIO_WEBM)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            fragmentedMp4Extractor = new MatroskaExtractor();
        } else {
            fragmentedMp4Extractor = new FragmentedMp4Extractor();
        }
        return new ChunkExtractorWrapper(fragmentedMp4Extractor, i, format);
    }

    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, true);
        if (loadInitializationData == null) {
            return null;
        }
        return (ChunkIndex) loadInitializationData.getSeekMap();
    }

    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, false);
        if (loadInitializationData == null) {
            return null;
        }
        return loadInitializationData.getSampleFormats()[0];
    }

    public static ChunkExtractorWrapper loadInitializationData(DataSource dataSource, int i, Representation representation, boolean z) throws IOException, InterruptedException {
        RangedUri initializationUri = representation.getInitializationUri();
        if (initializationUri == null) {
            return null;
        }
        ChunkExtractorWrapper newWrappedExtractor = newWrappedExtractor(i, representation.format);
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return null;
            }
            RangedUri attemptMerge = initializationUri.attemptMerge(indexUri, representation.baseUrl);
            if (attemptMerge == null) {
                loadInitializationData(dataSource, representation, newWrappedExtractor, initializationUri);
                initializationUri = indexUri;
            } else {
                initializationUri = attemptMerge;
            }
        }
        loadInitializationData(dataSource, representation, newWrappedExtractor, initializationUri);
        return newWrappedExtractor;
    }

    public static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, RangedUri rangedUri) throws IOException, InterruptedException {
        new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(representation.baseUrl), rangedUri.start, rangedUri.length, representation.getCacheKey()), representation.format, 0, null, chunkExtractorWrapper).load();
    }
}
