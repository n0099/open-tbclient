package com.google.android.exoplayer2.text.webvtt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOX_HEADER_SIZE = 8;
    public static final int TYPE_payl;
    public static final int TYPE_sttg;
    public static final int TYPE_vttc;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebvttCue.Builder builder;
    public final ParsableByteArray sampleData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49482369, "Lcom/google/android/exoplayer2/text/webvtt/Mp4WebvttDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(49482369, "Lcom/google/android/exoplayer2/text/webvtt/Mp4WebvttDecoder;");
                return;
            }
        }
        TYPE_payl = Util.getIntegerCodeForString("payl");
        TYPE_sttg = Util.getIntegerCodeForString("sttg");
        TYPE_vttc = Util.getIntegerCodeForString("vttc");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sampleData = new ParsableByteArray();
        this.builder = new WebvttCue.Builder();
    }

    public static Cue parseVttCueBox(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, int i) throws SubtitleDecoderException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, parsableByteArray, builder, i)) == null) {
            builder.reset();
            while (i > 0) {
                if (i >= 8) {
                    int readInt = parsableByteArray.readInt();
                    int readInt2 = parsableByteArray.readInt();
                    int i2 = readInt - 8;
                    String str = new String(parsableByteArray.data, parsableByteArray.getPosition(), i2);
                    parsableByteArray.skipBytes(i2);
                    i = (i - 8) - i2;
                    if (readInt2 == TYPE_sttg) {
                        WebvttCueParser.parseCueSettingsList(str, builder);
                    } else if (readInt2 == TYPE_payl) {
                        WebvttCueParser.parseCueText(null, str.trim(), builder, Collections.emptyList());
                    }
                } else {
                    throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                }
            }
            return builder.build();
        }
        return (Cue) invokeLLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Mp4WebvttSubtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.sampleData.reset(bArr, i);
            ArrayList arrayList = new ArrayList();
            while (this.sampleData.bytesLeft() > 0) {
                if (this.sampleData.bytesLeft() >= 8) {
                    int readInt = this.sampleData.readInt();
                    if (this.sampleData.readInt() == TYPE_vttc) {
                        arrayList.add(parseVttCueBox(this.sampleData, this.builder, readInt - 8));
                    } else {
                        this.sampleData.skipBytes(readInt - 8);
                    }
                } else {
                    throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
                }
            }
            return new Mp4WebvttSubtitle(arrayList);
        }
        return (Mp4WebvttSubtitle) invokeCommon.objValue;
    }
}
