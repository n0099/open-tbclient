package com.google.android.exoplayer2.extractor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class GaplessInfoHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GAPLESS_COMMENT_ID = "iTunSMPB";
    public static final Pattern GAPLESS_COMMENT_PATTERN;
    public static final Id3Decoder.FramePredicate GAPLESS_INFO_ID3_FRAME_PREDICATE;
    public transient /* synthetic */ FieldHolder $fh;
    public int encoderDelay;
    public int encoderPadding;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937961317, "Lcom/google/android/exoplayer2/extractor/GaplessInfoHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1937961317, "Lcom/google/android/exoplayer2/extractor/GaplessInfoHolder;");
                return;
            }
        }
        GAPLESS_INFO_ID3_FRAME_PREDICATE = new Id3Decoder.FramePredicate() { // from class: com.google.android.exoplayer2.extractor.GaplessInfoHolder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
            public boolean evaluate(int i2, int i3, int i4, int i5, int i6) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2) : invokeCommon.booleanValue;
            }
        };
        GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    }

    public GaplessInfoHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.encoderDelay = -1;
        this.encoderPadding = -1;
    }

    private boolean setFromComment(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (GAPLESS_COMMENT_ID.equals(str)) {
                Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str2);
                if (matcher.find()) {
                    try {
                        int parseInt = Integer.parseInt(matcher.group(1), 16);
                        int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                        if (parseInt > 0 || parseInt2 > 0) {
                            this.encoderDelay = parseInt;
                            this.encoderPadding = parseInt2;
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean hasGaplessInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.encoderDelay == -1 || this.encoderPadding == -1) ? false : true : invokeV.booleanValue;
    }

    public boolean setFromMetadata(Metadata metadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metadata)) == null) {
            for (int i2 = 0; i2 < metadata.length(); i2++) {
                Metadata.Entry entry = metadata.get(i2);
                if (entry instanceof CommentFrame) {
                    CommentFrame commentFrame = (CommentFrame) entry;
                    if (setFromComment(commentFrame.description, commentFrame.text)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean setFromXingHeaderValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = i2 >> 12;
            int i4 = i2 & 4095;
            if (i3 > 0 || i4 > 0) {
                this.encoderDelay = i3;
                this.encoderPadding = i4;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}
