package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;
/* loaded from: classes4.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char BOM_UTF16_BE = 65279;
    public static final char BOM_UTF16_LE = 65534;
    public static final int DEFAULT_COLOR = -1;
    public static final int DEFAULT_FONT_FACE = 0;
    public static final String DEFAULT_FONT_FAMILY = "sans-serif";
    public static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    public static final int FONT_FACE_BOLD = 1;
    public static final int FONT_FACE_ITALIC = 2;
    public static final int FONT_FACE_UNDERLINE = 4;
    public static final int SIZE_ATOM_HEADER = 8;
    public static final int SIZE_BOM_UTF16 = 2;
    public static final int SIZE_SHORT = 2;
    public static final int SIZE_STYLE_RECORD = 12;
    public static final int SPAN_PRIORITY_HIGH = 0;
    public static final int SPAN_PRIORITY_LOW = 16711680;
    public static final String TX3G_SERIF = "Serif";
    public static final int TYPE_STYL;
    public static final int TYPE_TBOX;
    public transient /* synthetic */ FieldHolder $fh;
    public int calculatedVideoTrackHeight;
    public boolean customVerticalPlacement;
    public int defaultColorRgba;
    public int defaultFontFace;
    public String defaultFontFamily;
    public float defaultVerticalPlacement;
    public final ParsableByteArray parsableByteArray;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1121190306, "Lcom/google/android/exoplayer2/text/tx3g/Tx3gDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1121190306, "Lcom/google/android/exoplayer2/text/tx3g/Tx3gDecoder;");
                return;
            }
        }
        TYPE_STYL = Util.getIntegerCodeForString("styl");
        TYPE_TBOX = Util.getIntegerCodeForString("tbox");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
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
        this.parsableByteArray = new ParsableByteArray();
        decodeInitializationData(list);
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, parsableByteArray, spannableStringBuilder) == null) {
            assertTrue(parsableByteArray.bytesLeft() >= 12);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(2);
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            parsableByteArray.skipBytes(1);
            int readInt = parsableByteArray.readInt();
            attachFontFace(spannableStringBuilder, readUnsignedByte, this.defaultFontFace, readUnsignedShort, readUnsignedShort2, 0);
            attachColor(spannableStringBuilder, readInt, this.defaultColorRgba, readUnsignedShort, readUnsignedShort2, 0);
        }
    }

    public static void assertTrue(boolean z) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && !z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void attachColor(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i == i2) {
            return;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
    }

    public static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i == i2) {
            return;
        }
        int i6 = i5 | 33;
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) != 0;
        if (z) {
            if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
            } else {
                spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
            }
        } else if (z2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
        }
        boolean z3 = (i & 4) != 0;
        if (z3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
        }
        if (z3 || z || z2) {
            return;
        }
        spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
    }

    public static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{spannableStringBuilder, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || str == str2) {
            return;
        }
        spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
    }

    private void decodeInitializationData(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, list) == null) {
            if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
                byte[] bArr = list.get(0);
                this.defaultFontFace = bArr[24];
                this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
                this.defaultFontFamily = TX3G_SERIF.equals(new String(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : "sans-serif";
                this.calculatedVideoTrackHeight = bArr[25] * 20;
                boolean z = (bArr[0] & 32) != 0;
                this.customVerticalPlacement = z;
                if (z) {
                    float f = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.calculatedVideoTrackHeight;
                    this.defaultVerticalPlacement = f;
                    this.defaultVerticalPlacement = Util.constrainValue(f, 0.0f, 0.95f);
                    return;
                }
                this.defaultVerticalPlacement = 0.85f;
                return;
            }
            this.defaultFontFace = 0;
            this.defaultColorRgba = -1;
            this.defaultFontFamily = "sans-serif";
            this.customVerticalPlacement = false;
            this.defaultVerticalPlacement = 0.85f;
        }
    }

    public static String readSubtitleText(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        InterceptResult invokeL;
        char peekChar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, parsableByteArray)) == null) {
            assertTrue(parsableByteArray.bytesLeft() >= 2);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort == 0) {
                return "";
            }
            if (parsableByteArray.bytesLeft() >= 2 && ((peekChar = parsableByteArray.peekChar()) == 65279 || peekChar == 65534)) {
                return parsableByteArray.readString(readUnsignedShort, Charset.forName("UTF-16"));
            }
            return parsableByteArray.readString(readUnsignedShort, Charset.forName("UTF-8"));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.parsableByteArray.reset(bArr, i);
            String readSubtitleText = readSubtitleText(this.parsableByteArray);
            if (readSubtitleText.isEmpty()) {
                return Tx3gSubtitle.EMPTY;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readSubtitleText);
            attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), 16711680);
            attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), 16711680);
            attachFontFamily(spannableStringBuilder, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
            float f = this.defaultVerticalPlacement;
            while (this.parsableByteArray.bytesLeft() >= 8) {
                int position = this.parsableByteArray.getPosition();
                int readInt = this.parsableByteArray.readInt();
                int readInt2 = this.parsableByteArray.readInt();
                if (readInt2 == TYPE_STYL) {
                    assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                    int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
                    for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                        applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                    }
                } else if (readInt2 == TYPE_TBOX && this.customVerticalPlacement) {
                    assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                    f = Util.constrainValue(this.parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, 0.0f, 0.95f);
                }
                this.parsableByteArray.setPosition(position + readInt);
            }
            return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
        }
        return (Subtitle) invokeCommon.objValue;
    }
}
