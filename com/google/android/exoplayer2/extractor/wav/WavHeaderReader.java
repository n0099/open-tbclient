package com.google.android.exoplayer2.extractor.wav;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class WavHeaderReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WavHeaderReader";
    public static final int TYPE_PCM = 1;
    public static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class ChunkHeader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SIZE_IN_BYTES = 8;
        public transient /* synthetic */ FieldHolder $fh;
        public final int id;
        public final long size;

        public ChunkHeader(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i;
            this.size = j;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException, InterruptedException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, extractorInput, parsableByteArray)) == null) {
                extractorInput.peekFully(parsableByteArray.data, 0, 8);
                parsableByteArray.setPosition(0);
                return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
            }
            return (ChunkHeader) invokeLL.objValue;
        }
    }

    public WavHeaderReader() {
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

    public static WavHeader peek(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, extractorInput)) == null) {
            Assertions.checkNotNull(extractorInput);
            ParsableByteArray parsableByteArray = new ParsableByteArray(16);
            if (ChunkHeader.peek(extractorInput, parsableByteArray).id != Util.getIntegerCodeForString("RIFF")) {
                return null;
            }
            extractorInput.peekFully(parsableByteArray.data, 0, 4);
            parsableByteArray.setPosition(0);
            int readInt = parsableByteArray.readInt();
            if (readInt != Util.getIntegerCodeForString("WAVE")) {
                Log.e(TAG, "Unsupported RIFF format: " + readInt);
                return null;
            }
            ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
            while (peek.id != Util.getIntegerCodeForString("fmt ")) {
                extractorInput.advancePeekPosition((int) peek.size);
                peek = ChunkHeader.peek(extractorInput, parsableByteArray);
            }
            if (peek.size >= 16) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            extractorInput.peekFully(parsableByteArray.data, 0, 16);
            parsableByteArray.setPosition(0);
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
            int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
            int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
            int i = (readLittleEndianUnsignedShort2 * readLittleEndianUnsignedShort4) / 8;
            if (readLittleEndianUnsignedShort3 == i) {
                int pcmEncoding = Util.getPcmEncoding(readLittleEndianUnsignedShort4);
                if (pcmEncoding == 0) {
                    Log.e(TAG, "Unsupported WAV bit depth: " + readLittleEndianUnsignedShort4);
                    return null;
                } else if (readLittleEndianUnsignedShort != 1 && readLittleEndianUnsignedShort != 65534) {
                    Log.e(TAG, "Unsupported WAV format type: " + readLittleEndianUnsignedShort);
                    return null;
                } else {
                    extractorInput.advancePeekPosition(((int) peek.size) - 16);
                    return new WavHeader(readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, pcmEncoding);
                }
            }
            throw new ParserException("Expected block alignment: " + i + "; got: " + readLittleEndianUnsignedShort3);
        }
        return (WavHeader) invokeL.objValue;
    }

    public static void skipToData(ExtractorInput extractorInput, WavHeader wavHeader) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, extractorInput, wavHeader) == null) {
            Assertions.checkNotNull(extractorInput);
            Assertions.checkNotNull(wavHeader);
            extractorInput.resetPeekPosition();
            ParsableByteArray parsableByteArray = new ParsableByteArray(8);
            ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
            while (peek.id != Util.getIntegerCodeForString("data")) {
                Log.w(TAG, "Ignoring unknown WAV chunk: " + peek.id);
                long j = peek.size + 8;
                if (peek.id == Util.getIntegerCodeForString("RIFF")) {
                    j = 12;
                }
                if (j <= 2147483647L) {
                    extractorInput.skipFully((int) j);
                    peek = ChunkHeader.peek(extractorInput, parsableByteArray);
                } else {
                    throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + peek.id);
                }
            }
            extractorInput.skipFully(8);
            wavHeader.setDataBounds(extractorInput.getPosition(), peek.size);
        }
    }
}
