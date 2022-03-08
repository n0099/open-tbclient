package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttCue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class WebvttDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COMMENT_START = "NOTE";
    public static final int EVENT_COMMENT = 1;
    public static final int EVENT_CUE = 3;
    public static final int EVENT_END_OF_FILE = 0;
    public static final int EVENT_NONE = -1;
    public static final int EVENT_STYLE_BLOCK = 2;
    public static final String STYLE_START = "STYLE";
    public transient /* synthetic */ FieldHolder $fh;
    public final CssParser cssParser;
    public final WebvttCueParser cueParser;
    public final List<WebvttCssStyle> definedStyles;
    public final ParsableByteArray parsableWebvttData;
    public final WebvttCue.Builder webvttCueBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebvttDecoder() {
        super("WebvttDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cueParser = new WebvttCueParser();
        this.parsableWebvttData = new ParsableByteArray();
        this.webvttCueBuilder = new WebvttCue.Builder();
        this.cssParser = new CssParser();
        this.definedStyles = new ArrayList();
    }

    public static int getNextEvent(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parsableByteArray)) == null) {
            int i2 = -1;
            int i3 = 0;
            while (i2 == -1) {
                i3 = parsableByteArray.getPosition();
                String readLine = parsableByteArray.readLine();
                if (readLine == null) {
                    i2 = 0;
                } else if (STYLE_START.equals(readLine)) {
                    i2 = 2;
                } else {
                    i2 = COMMENT_START.startsWith(readLine) ? 1 : 3;
                }
            }
            parsableByteArray.setPosition(i3);
            return i2;
        }
        return invokeL.intValue;
    }

    public static void skipComment(ParsableByteArray parsableByteArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, parsableByteArray) == null) {
            do {
            } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public WebvttSubtitle decode(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return (WebvttSubtitle) invokeCommon.objValue;
        }
        this.parsableWebvttData.reset(bArr, i2);
        this.webvttCueBuilder.reset();
        this.definedStyles.clear();
        WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
        do {
        } while (!TextUtils.isEmpty(this.parsableWebvttData.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int nextEvent = getNextEvent(this.parsableWebvttData);
            if (nextEvent == 0) {
                return new WebvttSubtitle(arrayList);
            }
            if (nextEvent == 1) {
                skipComment(this.parsableWebvttData);
            } else if (nextEvent == 2) {
                if (arrayList.isEmpty()) {
                    this.parsableWebvttData.readLine();
                    WebvttCssStyle parseBlock = this.cssParser.parseBlock(this.parsableWebvttData);
                    if (parseBlock != null) {
                        this.definedStyles.add(parseBlock);
                    }
                } else {
                    throw new SubtitleDecoderException("A style block was found after the first cue.");
                }
            } else if (nextEvent == 3 && this.cueParser.parseCue(this.parsableWebvttData, this.webvttCueBuilder, this.definedStyles)) {
                arrayList.add(this.webvttCueBuilder.build());
                this.webvttCueBuilder.reset();
            }
        }
    }
}
