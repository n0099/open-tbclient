package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.VorbisUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class VorbisReader extends StreamReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VorbisUtil.CommentHeader commentHeader;
    public int previousPacketBlockSize;
    public boolean seenFirstAudioPacket;
    public VorbisUtil.VorbisIdHeader vorbisIdHeader;
    public VorbisSetup vorbisSetup;

    public static int readBits(byte b, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Byte.valueOf(b), Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? (b >> i2) & (255 >>> (8 - i)) : invokeCommon.intValue;
    }

    /* loaded from: classes7.dex */
    public final class VorbisSetup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisUtil.VorbisIdHeader idHeader;
        public final VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vorbisIdHeader, commentHeader, bArr, modeArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.idHeader = vorbisIdHeader;
            this.commentHeader = commentHeader;
            this.setupHeaderData = bArr;
            this.modes = modeArr;
            this.iLogModes = i;
        }
    }

    public VorbisReader() {
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

    public static void appendNumberOfSamples(ParsableByteArray parsableByteArray, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, null, parsableByteArray, j) == null) {
            parsableByteArray.setLimit(parsableByteArray.limit() + 4);
            parsableByteArray.data[parsableByteArray.limit() - 4] = (byte) (j & 255);
            parsableByteArray.data[parsableByteArray.limit() - 3] = (byte) ((j >>> 8) & 255);
            parsableByteArray.data[parsableByteArray.limit() - 2] = (byte) ((j >>> 16) & 255);
            parsableByteArray.data[parsableByteArray.limit() - 1] = (byte) ((j >>> 24) & 255);
        }
    }

    public static int decodeBlockSize(byte b, VorbisSetup vorbisSetup) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b), vorbisSetup})) == null) {
            if (!vorbisSetup.modes[readBits(b, vorbisSetup.iLogModes, 1)].blockFlag) {
                return vorbisSetup.idHeader.blockSize0;
            }
            return vorbisSetup.idHeader.blockSize1;
        }
        return invokeCommon.intValue;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            try {
                return VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
            } catch (ParserException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void onSeekEnd(long j) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            super.onSeekEnd(j);
            int i = 0;
            if (j != 0) {
                z = true;
            } else {
                z = false;
            }
            this.seenFirstAudioPacket = z;
            VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisIdHeader;
            if (vorbisIdHeader != null) {
                i = vorbisIdHeader.blockSize0;
            }
            this.previousPacketBlockSize = i;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.reset(z);
            if (z) {
                this.vorbisSetup = null;
                this.vorbisIdHeader = null;
                this.commentHeader = null;
            }
            this.previousPacketBlockSize = 0;
            this.seenFirstAudioPacket = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parsableByteArray)) == null) {
            byte[] bArr = parsableByteArray.data;
            int i = 0;
            if ((bArr[0] & 1) == 1) {
                return -1L;
            }
            int decodeBlockSize = decodeBlockSize(bArr[0], this.vorbisSetup);
            if (this.seenFirstAudioPacket) {
                i = (this.previousPacketBlockSize + decodeBlockSize) / 4;
            }
            long j = i;
            appendNumberOfSamples(parsableByteArray, j);
            this.seenFirstAudioPacket = true;
            this.previousPacketBlockSize = decodeBlockSize;
            return j;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{parsableByteArray, Long.valueOf(j), setupData})) == null) {
            if (this.vorbisSetup != null) {
                return false;
            }
            VorbisSetup readSetupHeaders = readSetupHeaders(parsableByteArray);
            this.vorbisSetup = readSetupHeaders;
            if (readSetupHeaders == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.vorbisSetup.idHeader.data);
            arrayList.add(this.vorbisSetup.setupHeaderData);
            VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisSetup.idHeader;
            setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_VORBIS, null, vorbisIdHeader.bitrateNominal, -1, vorbisIdHeader.channels, (int) vorbisIdHeader.sampleRate, arrayList, null, 0, null);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public VorbisSetup readSetupHeaders(ParsableByteArray parsableByteArray) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, parsableByteArray)) == null) {
            if (this.vorbisIdHeader == null) {
                this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
                return null;
            } else if (this.commentHeader == null) {
                this.commentHeader = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
                return null;
            } else {
                byte[] bArr = new byte[parsableByteArray.limit()];
                System.arraycopy(parsableByteArray.data, 0, bArr, 0, parsableByteArray.limit());
                VorbisUtil.Mode[] readVorbisModes = VorbisUtil.readVorbisModes(parsableByteArray, this.vorbisIdHeader.channels);
                return new VorbisSetup(this.vorbisIdHeader, this.commentHeader, bArr, readVorbisModes, VorbisUtil.iLog(readVorbisModes.length - 1));
            }
        }
        return (VorbisSetup) invokeL.objValue;
    }
}
