package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
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
/* loaded from: classes6.dex */
public final class DashUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DashUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Representation getFirstRepresentation(Period period, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, period, i)) == null) {
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
        return (Representation) invokeLI.objValue;
    }

    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, dataSource, i, representation)) == null) {
            ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, true);
            if (loadInitializationData == null) {
                return null;
            }
            return (ChunkIndex) loadInitializationData.getSeekMap();
        }
        return (ChunkIndex) invokeLIL.objValue;
    }

    public static DrmInitData loadDrmInitData(DataSource dataSource, Period period) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dataSource, period)) == null) {
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
        return (DrmInitData) invokeLL.objValue;
    }

    public static ChunkExtractorWrapper loadInitializationData(DataSource dataSource, int i, Representation representation, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dataSource, Integer.valueOf(i), representation, Boolean.valueOf(z)})) == null) {
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
        return (ChunkExtractorWrapper) invokeCommon.objValue;
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, dataSource, uri)) == null) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, new DataSpec(uri, 3), 4, new DashManifestParser());
            parsingLoadable.load();
            return (DashManifest) parsingLoadable.getResult();
        }
        return (DashManifest) invokeLL.objValue;
    }

    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, dataSource, i, representation)) == null) {
            ChunkExtractorWrapper loadInitializationData = loadInitializationData(dataSource, i, representation, false);
            if (loadInitializationData == null) {
                return null;
            }
            return loadInitializationData.getSampleFormats()[0];
        }
        return (Format) invokeLIL.objValue;
    }

    public static ChunkExtractorWrapper newWrappedExtractor(int i, Format format) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, format)) == null) {
            String str = format.containerMimeType;
            return new ChunkExtractorWrapper(str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), i, format);
        }
        return (ChunkExtractorWrapper) invokeIL.objValue;
    }

    public static void loadInitializationData(DataSource dataSource, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, RangedUri rangedUri) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, dataSource, representation, chunkExtractorWrapper, rangedUri) == null) {
            new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(representation.baseUrl), rangedUri.start, rangedUri.length, representation.getCacheKey()), representation.format, 0, null, chunkExtractorWrapper).load();
        }
    }
}
