package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ChunkExtractorWrapper implements ExtractorOutput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<BindingTrackOutput> bindingTrackOutputs;
    public final Extractor extractor;
    public boolean extractorInitialized;
    public final Format primaryTrackManifestFormat;
    public final int primaryTrackType;
    public Format[] sampleFormats;
    public SeekMap seekMap;
    public TrackOutputProvider trackOutputProvider;

    /* loaded from: classes7.dex */
    public interface TrackOutputProvider {
        TrackOutput track(int i, int i2);
    }

    /* loaded from: classes7.dex */
    public static final class BindingTrackOutput implements TrackOutput {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int id;
        public final Format manifestFormat;
        public Format sampleFormat;
        public TrackOutput trackOutput;
        public final int type;

        public BindingTrackOutput(int i, int i2, Format format) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), format};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i;
            this.type = i2;
            this.manifestFormat = format;
        }

        public void bind(TrackOutputProvider trackOutputProvider) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, trackOutputProvider) == null) {
                if (trackOutputProvider == null) {
                    this.trackOutput = new DummyTrackOutput();
                    return;
                }
                TrackOutput track = trackOutputProvider.track(this.id, this.type);
                this.trackOutput = track;
                Format format = this.sampleFormat;
                if (format != null) {
                    track.format(format);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format) == null) {
                Format format2 = this.manifestFormat;
                if (format2 != null) {
                    format = format.copyWithManifestFormatInfo(format2);
                }
                this.sampleFormat = format;
                this.trackOutput.format(format);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{extractorInput, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                return this.trackOutput.sampleData(extractorInput, i, z);
            }
            return invokeCommon.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, parsableByteArray, i) == null) {
                this.trackOutput.sampleData(parsableByteArray, i);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), cryptoData}) == null) {
                this.trackOutput.sampleMetadata(j, i, i2, i3, cryptoData);
            }
        }
    }

    public ChunkExtractorWrapper(Extractor extractor, int i, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {extractor, Integer.valueOf(i), format};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.extractor = extractor;
        this.primaryTrackType = i;
        this.primaryTrackManifestFormat = format;
        this.bindingTrackOutputs = new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
            for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
                formatArr[i] = this.bindingTrackOutputs.valueAt(i).sampleFormat;
            }
            this.sampleFormats = formatArr;
        }
    }

    public Format[] getSampleFormats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sampleFormats;
        }
        return (Format[]) invokeV.objValue;
    }

    public SeekMap getSeekMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.seekMap;
        }
        return (SeekMap) invokeV.objValue;
    }

    public void init(TrackOutputProvider trackOutputProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, trackOutputProvider) == null) {
            this.trackOutputProvider = trackOutputProvider;
            if (!this.extractorInitialized) {
                this.extractor.init(this);
                this.extractorInitialized = true;
                return;
            }
            this.extractor.seek(0L, 0L);
            for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
                this.bindingTrackOutputs.valueAt(i).bind(trackOutputProvider);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, seekMap) == null) {
            this.seekMap = seekMap;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        InterceptResult invokeII;
        boolean z;
        Format format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i);
            if (bindingTrackOutput == null) {
                if (this.sampleFormats == null) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                if (i2 == this.primaryTrackType) {
                    format = this.primaryTrackManifestFormat;
                } else {
                    format = null;
                }
                bindingTrackOutput = new BindingTrackOutput(i, i2, format);
                bindingTrackOutput.bind(this.trackOutputProvider);
                this.bindingTrackOutputs.put(i, bindingTrackOutput);
            }
            return bindingTrackOutput;
        }
        return (TrackOutput) invokeII.objValue;
    }
}
