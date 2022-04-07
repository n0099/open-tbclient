package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public final class Cea708Decoder extends CeaDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CC_VALID_FLAG = 4;
    public static final int CHARACTER_BIG_CARONS = 42;
    public static final int CHARACTER_BIG_OE = 44;
    public static final int CHARACTER_BOLD_BULLET = 53;
    public static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    public static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    public static final int CHARACTER_DIAERESIS_Y = 63;
    public static final int CHARACTER_ELLIPSIS = 37;
    public static final int CHARACTER_FIVE_EIGHTHS = 120;
    public static final int CHARACTER_HORIZONTAL_BORDER = 125;
    public static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    public static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    public static final int CHARACTER_MN = 127;
    public static final int CHARACTER_NBTSP = 33;
    public static final int CHARACTER_ONE_EIGHTH = 118;
    public static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    public static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    public static final int CHARACTER_SEVEN_EIGHTHS = 121;
    public static final int CHARACTER_SM = 61;
    public static final int CHARACTER_SMALL_CARONS = 58;
    public static final int CHARACTER_SMALL_OE = 60;
    public static final int CHARACTER_SOLID_BLOCK = 48;
    public static final int CHARACTER_THREE_EIGHTHS = 119;
    public static final int CHARACTER_TM = 57;
    public static final int CHARACTER_TSP = 32;
    public static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    public static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    public static final int CHARACTER_VERTICAL_BORDER = 122;
    public static final int COMMAND_BS = 8;
    public static final int COMMAND_CLW = 136;
    public static final int COMMAND_CR = 13;
    public static final int COMMAND_CW0 = 128;
    public static final int COMMAND_CW1 = 129;
    public static final int COMMAND_CW2 = 130;
    public static final int COMMAND_CW3 = 131;
    public static final int COMMAND_CW4 = 132;
    public static final int COMMAND_CW5 = 133;
    public static final int COMMAND_CW6 = 134;
    public static final int COMMAND_CW7 = 135;
    public static final int COMMAND_DF0 = 152;
    public static final int COMMAND_DF1 = 153;
    public static final int COMMAND_DF2 = 154;
    public static final int COMMAND_DF3 = 155;
    public static final int COMMAND_DF5 = 157;
    public static final int COMMAND_DF6 = 158;
    public static final int COMMAND_DF7 = 159;
    public static final int COMMAND_DLC = 142;
    public static final int COMMAND_DLW = 140;
    public static final int COMMAND_DLY = 141;
    public static final int COMMAND_DS4 = 156;
    public static final int COMMAND_DSW = 137;
    public static final int COMMAND_ETX = 3;
    public static final int COMMAND_EXT1 = 16;
    public static final int COMMAND_EXT1_END = 23;
    public static final int COMMAND_EXT1_START = 17;
    public static final int COMMAND_FF = 12;
    public static final int COMMAND_HCR = 14;
    public static final int COMMAND_HDW = 138;
    public static final int COMMAND_NUL = 0;
    public static final int COMMAND_P16_END = 31;
    public static final int COMMAND_P16_START = 24;
    public static final int COMMAND_RST = 143;
    public static final int COMMAND_SPA = 144;
    public static final int COMMAND_SPC = 145;
    public static final int COMMAND_SPL = 146;
    public static final int COMMAND_SWA = 151;
    public static final int COMMAND_TGW = 139;
    public static final int DTVCC_PACKET_DATA = 2;
    public static final int DTVCC_PACKET_START = 3;
    public static final int GROUP_C0_END = 31;
    public static final int GROUP_C1_END = 159;
    public static final int GROUP_C2_END = 31;
    public static final int GROUP_C3_END = 159;
    public static final int GROUP_G0_END = 127;
    public static final int GROUP_G1_END = 255;
    public static final int GROUP_G2_END = 127;
    public static final int GROUP_G3_END = 255;
    public static final int NUM_WINDOWS = 8;
    public static final String TAG = "Cea708Decoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final ParsableByteArray ccData;
    public final CueBuilder[] cueBuilders;
    public List<Cue> cues;
    public CueBuilder currentCueBuilder;
    public DtvCcPacket currentDtvCcPacket;
    public int currentWindow;
    public List<Cue> lastCues;
    public final int selectedServiceNumber;
    public final ParsableBitArray serviceBlockPacket;

    /* loaded from: classes4.dex */
    public static final class CueBuilder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        public static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE;
        public static final int COLOR_TRANSPARENT;
        public static final int DEFAULT_PRIORITY = 4;
        public static final int DIRECTION_BOTTOM_TO_TOP = 3;
        public static final int DIRECTION_LEFT_TO_RIGHT = 0;
        public static final int DIRECTION_RIGHT_TO_LEFT = 1;
        public static final int DIRECTION_TOP_TO_BOTTOM = 2;
        public static final int HORIZONTAL_SIZE = 209;
        public static final int JUSTIFICATION_CENTER = 2;
        public static final int JUSTIFICATION_FULL = 3;
        public static final int JUSTIFICATION_LEFT = 0;
        public static final int JUSTIFICATION_RIGHT = 1;
        public static final int MAXIMUM_ROW_COUNT = 15;
        public static final int PEN_FONT_STYLE_DEFAULT = 0;
        public static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        public static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        public static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        public static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        public static final int PEN_OFFSET_NORMAL = 1;
        public static final int PEN_SIZE_STANDARD = 1;
        public static final int[] PEN_STYLE_BACKGROUND;
        public static final int[] PEN_STYLE_EDGE_TYPE;
        public static final int[] PEN_STYLE_FONT_STYLE;
        public static final int RELATIVE_CUE_SIZE = 99;
        public static final int VERTICAL_SIZE = 74;
        public static final int[] WINDOW_STYLE_FILL;
        public static final int[] WINDOW_STYLE_JUSTIFICATION;
        public static final int[] WINDOW_STYLE_PRINT_DIRECTION;
        public static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
        public static final boolean[] WINDOW_STYLE_WORD_WRAP;
        public transient /* synthetic */ FieldHolder $fh;
        public int anchorId;
        public int backgroundColor;
        public int backgroundColorStartPosition;
        public final SpannableStringBuilder captionStringBuilder;
        public boolean defined;
        public int foregroundColor;
        public int foregroundColorStartPosition;
        public int horizontalAnchor;
        public int italicsStartPosition;
        public int justification;
        public int penStyleId;
        public int priority;
        public boolean relativePositioning;
        public final List<SpannableString> rolledUpCaptions;
        public int row;
        public int rowCount;
        public boolean rowLock;
        public int underlineStartPosition;
        public int verticalAnchor;
        public boolean visible;
        public int windowFillColor;
        public int windowStyleId;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2004381921, "Lcom/google/android/exoplayer2/text/cea/Cea708Decoder$CueBuilder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2004381921, "Lcom/google/android/exoplayer2/text/cea/Cea708Decoder$CueBuilder;");
                    return;
                }
            }
            COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
            COLOR_SOLID_BLACK = getArgbColorFromCeaColor(0, 0, 0, 0);
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 3);
            COLOR_TRANSPARENT = argbColorFromCeaColor;
            WINDOW_STYLE_JUSTIFICATION = new int[]{0, 0, 0, 0, 0, 2, 0};
            WINDOW_STYLE_PRINT_DIRECTION = new int[]{0, 0, 0, 0, 0, 0, 2};
            WINDOW_STYLE_SCROLL_DIRECTION = new int[]{3, 3, 3, 3, 3, 3, 1};
            WINDOW_STYLE_WORD_WRAP = new boolean[]{false, false, false, true, true, true, false};
            int i = COLOR_SOLID_BLACK;
            WINDOW_STYLE_FILL = new int[]{i, argbColorFromCeaColor, i, i, argbColorFromCeaColor, i, i};
            PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            PEN_STYLE_BACKGROUND = new int[]{i, i, i, i, i, argbColorFromCeaColor, argbColorFromCeaColor};
        }

        public CueBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.rolledUpCaptions = new LinkedList();
            this.captionStringBuilder = new SpannableStringBuilder();
            reset();
        }

        public static int getArgbColorFromCeaColor(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) ? getArgbColorFromCeaColor(i, i2, i3, 0) : invokeIII.intValue;
        }

        public void append(char c) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c)}) != null) {
                return;
            }
            if (c == '\n') {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((!this.rowLock || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        return;
                    }
                    this.rolledUpCaptions.remove(0);
                }
            } else {
                this.captionStringBuilder.append(c);
            }
        }

        public void backspace() {
            int length;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (length = this.captionStringBuilder.length()) <= 0) {
                return;
            }
            this.captionStringBuilder.delete(length - 1, length);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Cea708Cue build() {
            InterceptResult invokeV;
            Layout.Alignment alignment;
            float f;
            float f2;
            int i;
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (isEmpty()) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i5 = 0; i5 < this.rolledUpCaptions.size(); i5++) {
                    spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i5));
                    spannableStringBuilder.append('\n');
                }
                spannableStringBuilder.append((CharSequence) buildSpannableString());
                int i6 = this.justification;
                if (i6 != 0) {
                    if (i6 == 1) {
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else if (i6 == 2) {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    } else if (i6 != 3) {
                        throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
                    }
                    Layout.Alignment alignment2 = alignment;
                    if (!this.relativePositioning) {
                        f = this.horizontalAnchor / 99.0f;
                        f2 = this.verticalAnchor / 99.0f;
                    } else {
                        f = this.horizontalAnchor / 209.0f;
                        f2 = this.verticalAnchor / 74.0f;
                    }
                    float f3 = (f * 0.9f) + 0.05f;
                    float f4 = (f2 * 0.9f) + 0.05f;
                    i = this.anchorId;
                    if (i % 3 != 0) {
                        i2 = 0;
                    } else {
                        i2 = i % 3 == 1 ? 1 : 2;
                    }
                    i3 = this.anchorId;
                    if (i3 / 3 != 0) {
                        i4 = 0;
                    } else {
                        i4 = i3 / 3 == 1 ? 1 : 2;
                    }
                    return new Cea708Cue(spannableStringBuilder, alignment2, f4, 0, i2, f3, i4, Float.MIN_VALUE, this.windowFillColor != COLOR_SOLID_BLACK, this.windowFillColor, this.priority);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
                Layout.Alignment alignment22 = alignment;
                if (!this.relativePositioning) {
                }
                float f32 = (f * 0.9f) + 0.05f;
                float f42 = (f2 * 0.9f) + 0.05f;
                i = this.anchorId;
                if (i % 3 != 0) {
                }
                i3 = this.anchorId;
                if (i3 / 3 != 0) {
                }
                return new Cea708Cue(spannableStringBuilder, alignment22, f42, 0, i2, f32, i4, Float.MIN_VALUE, this.windowFillColor != COLOR_SOLID_BLACK, this.windowFillColor, this.priority);
            }
            return (Cea708Cue) invokeV.objValue;
        }

        public SpannableString buildSpannableString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
                int length = spannableStringBuilder.length();
                if (length > 0) {
                    if (this.italicsStartPosition != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                    }
                    if (this.underlineStartPosition != -1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                    }
                    if (this.foregroundColorStartPosition != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                    }
                    if (this.backgroundColorStartPosition != -1) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                    }
                }
                return new SpannableString(spannableStringBuilder);
            }
            return (SpannableString) invokeV.objValue;
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.rolledUpCaptions.clear();
                this.captionStringBuilder.clear();
                this.italicsStartPosition = -1;
                this.underlineStartPosition = -1;
                this.foregroundColorStartPosition = -1;
                this.backgroundColorStartPosition = -1;
                this.row = 0;
            }
        }

        public void defineWindow(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                this.defined = true;
                this.visible = z;
                this.rowLock = z2;
                this.priority = i;
                this.relativePositioning = z4;
                this.verticalAnchor = i2;
                this.horizontalAnchor = i3;
                this.anchorId = i6;
                int i9 = i4 + 1;
                if (this.rowCount != i9) {
                    this.rowCount = i9;
                    while (true) {
                        if ((!z2 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                            break;
                        }
                        this.rolledUpCaptions.remove(0);
                    }
                }
                if (i7 != 0 && this.windowStyleId != i7) {
                    this.windowStyleId = i7;
                    int i10 = i7 - 1;
                    setWindowAttributes(WINDOW_STYLE_FILL[i10], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i10], 0, WINDOW_STYLE_PRINT_DIRECTION[i10], WINDOW_STYLE_SCROLL_DIRECTION[i10], WINDOW_STYLE_JUSTIFICATION[i10]);
                }
                if (i8 == 0 || this.penStyleId == i8) {
                    return;
                }
                this.penStyleId = i8;
                int i11 = i8 - 1;
                setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i11], PEN_STYLE_FONT_STYLE[i11]);
                setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i11], COLOR_SOLID_BLACK);
            }
        }

        public boolean isDefined() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.defined : invokeV.booleanValue;
        }

        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !isDefined() || (this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0) : invokeV.booleanValue;
        }

        public boolean isVisible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.visible : invokeV.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                clear();
                this.defined = false;
                this.visible = false;
                this.priority = 4;
                this.relativePositioning = false;
                this.verticalAnchor = 0;
                this.horizontalAnchor = 0;
                this.anchorId = 0;
                this.rowCount = 15;
                this.rowLock = true;
                this.justification = 0;
                this.windowStyleId = 0;
                this.penStyleId = 0;
                int i = COLOR_SOLID_BLACK;
                this.windowFillColor = i;
                this.foregroundColor = COLOR_SOLID_WHITE;
                this.backgroundColor = i;
            }
        }

        public void setPenAttributes(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                if (this.italicsStartPosition != -1) {
                    if (!z) {
                        this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                        this.italicsStartPosition = -1;
                    }
                } else if (z) {
                    this.italicsStartPosition = this.captionStringBuilder.length();
                }
                if (this.underlineStartPosition == -1) {
                    if (z2) {
                        this.underlineStartPosition = this.captionStringBuilder.length();
                    }
                } else if (z2) {
                } else {
                    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                    this.underlineStartPosition = -1;
                }
            }
        }

        public void setPenColor(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) {
                if (this.foregroundColorStartPosition != -1 && this.foregroundColor != i) {
                    this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
                }
                if (i != COLOR_SOLID_WHITE) {
                    this.foregroundColorStartPosition = this.captionStringBuilder.length();
                    this.foregroundColor = i;
                }
                if (this.backgroundColorStartPosition != -1 && this.backgroundColor != i2) {
                    this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
                }
                if (i2 != COLOR_SOLID_BLACK) {
                    this.backgroundColorStartPosition = this.captionStringBuilder.length();
                    this.backgroundColor = i2;
                }
            }
        }

        public void setPenLocation(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
                if (this.row != i) {
                    append('\n');
                }
                this.row = i;
            }
        }

        public void setVisibility(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                this.visible = z;
            }
        }

        public void setWindowAttributes(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                this.windowFillColor = i;
                this.justification = i6;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getArgbColorFromCeaColor(int i, int i2, int i3, int i4) {
            InterceptResult invokeIIII;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i, i2, i3, i4)) == null) {
                Assertions.checkIndex(i, 0, 4);
                Assertions.checkIndex(i2, 0, 4);
                Assertions.checkIndex(i3, 0, 4);
                Assertions.checkIndex(i4, 0, 4);
                if (i4 != 0 && i4 != 1) {
                    if (i4 == 2) {
                        i5 = 127;
                    } else if (i4 == 3) {
                        i5 = 0;
                    }
                    return Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
                }
                i5 = 255;
                return Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
            }
            return invokeIIII.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class DtvCcPacket {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentIndex;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.sequenceNumber = i;
            this.packetSize = i2;
            this.packetData = new byte[(i2 * 2) - 1];
            this.currentIndex = 0;
        }
    }

    public Cea708Decoder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ccData = new ParsableByteArray();
        this.serviceBlockPacket = new ParsableBitArray();
        this.selectedServiceNumber = i == -1 ? 1 : i;
        this.cueBuilders = new CueBuilder[8];
        for (int i4 = 0; i4 < 8; i4++) {
            this.cueBuilders[i4] = new CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
    }

    private void finalizeCurrentPacket() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.currentDtvCcPacket == null) {
            return;
        }
        processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    private List<Cue> getDisplayCues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 8; i++) {
                if (!this.cueBuilders[i].isEmpty() && this.cueBuilders[i].isVisible()) {
                    arrayList.add(this.cueBuilders[i].build());
                }
            }
            Collections.sort(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeV.objValue;
    }

    private void handleC0Command(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i) == null) || i == 0) {
            return;
        }
        if (i == 3) {
            this.cues = getDisplayCues();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    resetCueBuilders();
                    return;
                case 13:
                    this.currentCueBuilder.append('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        Log.w(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.serviceBlockPacket.skipBits(8);
                        return;
                    } else if (i >= 24 && i <= 31) {
                        Log.w(TAG, "Currently unsupported COMMAND_P16 Command: " + i);
                        this.serviceBlockPacket.skipBits(16);
                        return;
                    } else {
                        Log.w(TAG, "Invalid C0 command: " + i);
                        return;
                    }
            }
        } else {
            this.currentCueBuilder.backspace();
        }
    }

    private void handleC1Command(int i) {
        CueBuilder cueBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            int i2 = 1;
            switch (i) {
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                    int i3 = i - 128;
                    if (this.currentWindow != i3) {
                        this.currentWindow = i3;
                        this.currentCueBuilder = this.cueBuilders[i3];
                        return;
                    }
                    return;
                case 136:
                    while (i2 <= 8) {
                        if (this.serviceBlockPacket.readBit()) {
                            this.cueBuilders[8 - i2].clear();
                        }
                        i2++;
                    }
                    return;
                case COMMAND_DSW /* 137 */:
                    for (int i4 = 1; i4 <= 8; i4++) {
                        if (this.serviceBlockPacket.readBit()) {
                            this.cueBuilders[8 - i4].setVisibility(true);
                        }
                    }
                    return;
                case 138:
                    while (i2 <= 8) {
                        if (this.serviceBlockPacket.readBit()) {
                            this.cueBuilders[8 - i2].setVisibility(false);
                        }
                        i2++;
                    }
                    return;
                case 139:
                    for (int i5 = 1; i5 <= 8; i5++) {
                        if (this.serviceBlockPacket.readBit()) {
                            this.cueBuilders[8 - i5].setVisibility(!cueBuilder.isVisible());
                        }
                    }
                    return;
                case 140:
                    while (i2 <= 8) {
                        if (this.serviceBlockPacket.readBit()) {
                            this.cueBuilders[8 - i2].reset();
                        }
                        i2++;
                    }
                    return;
                case COMMAND_DLY /* 141 */:
                    this.serviceBlockPacket.skipBits(8);
                    return;
                case COMMAND_DLC /* 142 */:
                    return;
                case 143:
                    resetCueBuilders();
                    return;
                case COMMAND_SPA /* 144 */:
                    if (!this.currentCueBuilder.isDefined()) {
                        this.serviceBlockPacket.skipBits(16);
                        return;
                    } else {
                        handleSetPenAttributes();
                        return;
                    }
                case 145:
                    if (!this.currentCueBuilder.isDefined()) {
                        this.serviceBlockPacket.skipBits(24);
                        return;
                    } else {
                        handleSetPenColor();
                        return;
                    }
                case COMMAND_SPL /* 146 */:
                    if (!this.currentCueBuilder.isDefined()) {
                        this.serviceBlockPacket.skipBits(16);
                        return;
                    } else {
                        handleSetPenLocation();
                        return;
                    }
                case 147:
                case w0.I /* 148 */:
                case 149:
                case 150:
                default:
                    Log.w(TAG, "Invalid C1 command: " + i);
                    return;
                case COMMAND_SWA /* 151 */:
                    if (!this.currentCueBuilder.isDefined()) {
                        this.serviceBlockPacket.skipBits(32);
                        return;
                    } else {
                        handleSetWindowAttributes();
                        return;
                    }
                case COMMAND_DF0 /* 152 */:
                case 153:
                case COMMAND_DF2 /* 154 */:
                case 155:
                case COMMAND_DS4 /* 156 */:
                case 157:
                case 158:
                case 159:
                    int i6 = i - 152;
                    handleDefineWindow(i6);
                    if (this.currentWindow != i6) {
                        this.currentWindow = i6;
                        this.currentCueBuilder = this.cueBuilders[i6];
                        return;
                    }
                    return;
            }
        }
    }

    private void handleC2Command(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, this, i) == null) || i <= 7) {
            return;
        }
        if (i <= 15) {
            this.serviceBlockPacket.skipBits(8);
        } else if (i <= 23) {
            this.serviceBlockPacket.skipBits(16);
        } else if (i <= 31) {
            this.serviceBlockPacket.skipBits(24);
        }
    }

    private void handleC3Command(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            if (i <= 135) {
                this.serviceBlockPacket.skipBits(32);
            } else if (i <= 143) {
                this.serviceBlockPacket.skipBits(40);
            } else if (i <= 159) {
                this.serviceBlockPacket.skipBits(2);
                this.serviceBlockPacket.skipBits(this.serviceBlockPacket.readBits(6) * 8);
            }
        }
    }

    private void handleDefineWindow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            CueBuilder cueBuilder = this.cueBuilders[i];
            this.serviceBlockPacket.skipBits(2);
            boolean readBit = this.serviceBlockPacket.readBit();
            boolean readBit2 = this.serviceBlockPacket.readBit();
            boolean readBit3 = this.serviceBlockPacket.readBit();
            int readBits = this.serviceBlockPacket.readBits(3);
            boolean readBit4 = this.serviceBlockPacket.readBit();
            int readBits2 = this.serviceBlockPacket.readBits(7);
            int readBits3 = this.serviceBlockPacket.readBits(8);
            int readBits4 = this.serviceBlockPacket.readBits(4);
            int readBits5 = this.serviceBlockPacket.readBits(4);
            this.serviceBlockPacket.skipBits(2);
            int readBits6 = this.serviceBlockPacket.readBits(6);
            this.serviceBlockPacket.skipBits(2);
            cueBuilder.defineWindow(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
        }
    }

    private void handleG0Character(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            if (i == 127) {
                this.currentCueBuilder.append((char) 9835);
            } else {
                this.currentCueBuilder.append((char) (i & 255));
            }
        }
    }

    private void handleG1Character(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            this.currentCueBuilder.append((char) (i & 255));
        }
    }

    private void handleG2Character(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i) == null) {
            if (i == 32) {
                this.currentCueBuilder.append(WebvttCueParser.CHAR_SPACE);
            } else if (i == 33) {
                this.currentCueBuilder.append(Typography.nbsp);
            } else if (i == 37) {
                this.currentCueBuilder.append(Typography.ellipsis);
            } else if (i == 42) {
                this.currentCueBuilder.append((char) 352);
            } else if (i == 44) {
                this.currentCueBuilder.append((char) 338);
            } else if (i == 63) {
                this.currentCueBuilder.append((char) 376);
            } else if (i == 57) {
                this.currentCueBuilder.append(Typography.tm);
            } else if (i == 58) {
                this.currentCueBuilder.append((char) 353);
            } else if (i == 60) {
                this.currentCueBuilder.append((char) 339);
            } else if (i != 61) {
                switch (i) {
                    case 48:
                        this.currentCueBuilder.append((char) 9608);
                        return;
                    case 49:
                        this.currentCueBuilder.append(Typography.leftSingleQuote);
                        return;
                    case 50:
                        this.currentCueBuilder.append(Typography.rightSingleQuote);
                        return;
                    case 51:
                        this.currentCueBuilder.append(Typography.leftDoubleQuote);
                        return;
                    case 52:
                        this.currentCueBuilder.append(Typography.rightDoubleQuote);
                        return;
                    case 53:
                        this.currentCueBuilder.append(Typography.bullet);
                        return;
                    default:
                        switch (i) {
                            case 118:
                                this.currentCueBuilder.append((char) 8539);
                                return;
                            case 119:
                                this.currentCueBuilder.append((char) 8540);
                                return;
                            case 120:
                                this.currentCueBuilder.append((char) 8541);
                                return;
                            case 121:
                                this.currentCueBuilder.append((char) 8542);
                                return;
                            case 122:
                                this.currentCueBuilder.append((char) 9474);
                                return;
                            case 123:
                                this.currentCueBuilder.append((char) 9488);
                                return;
                            case 124:
                                this.currentCueBuilder.append((char) 9492);
                                return;
                            case 125:
                                this.currentCueBuilder.append((char) 9472);
                                return;
                            case 126:
                                this.currentCueBuilder.append((char) 9496);
                                return;
                            case 127:
                                this.currentCueBuilder.append((char) 9484);
                                return;
                            default:
                                Log.w(TAG, "Invalid G2 character: " + i);
                                return;
                        }
                }
            } else {
                this.currentCueBuilder.append((char) 8480);
            }
        }
    }

    private void handleG3Character(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i) == null) {
            if (i == 160) {
                this.currentCueBuilder.append((char) 13252);
                return;
            }
            Log.w(TAG, "Invalid G3 character: " + i);
            this.currentCueBuilder.append('_');
        }
    }

    private void handleSetPenAttributes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.currentCueBuilder.setPenAttributes(this.serviceBlockPacket.readBits(4), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
        }
    }

    private void handleSetPenColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
            int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
            this.serviceBlockPacket.skipBits(2);
            this.currentCueBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2)));
        }
    }

    private void handleSetPenLocation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.serviceBlockPacket.skipBits(4);
            int readBits = this.serviceBlockPacket.readBits(4);
            this.serviceBlockPacket.skipBits(2);
            this.currentCueBuilder.setPenLocation(readBits, this.serviceBlockPacket.readBits(6));
        }
    }

    private void handleSetWindowAttributes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
            int readBits = this.serviceBlockPacket.readBits(2);
            int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
            if (this.serviceBlockPacket.readBit()) {
                readBits |= 4;
            }
            boolean readBit = this.serviceBlockPacket.readBit();
            int readBits2 = this.serviceBlockPacket.readBits(2);
            int readBits3 = this.serviceBlockPacket.readBits(2);
            int readBits4 = this.serviceBlockPacket.readBits(2);
            this.serviceBlockPacket.skipBits(8);
            this.currentCueBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, readBit, readBits, readBits2, readBits3, readBits4);
        }
    }

    private void processCurrentPacket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
            int i = dtvCcPacket.currentIndex;
            if (i != (dtvCcPacket.packetSize * 2) - 1) {
                Log.w(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
                return;
            }
            this.serviceBlockPacket.reset(dtvCcPacket.packetData, i);
            int readBits = this.serviceBlockPacket.readBits(3);
            int readBits2 = this.serviceBlockPacket.readBits(5);
            if (readBits == 7) {
                this.serviceBlockPacket.skipBits(2);
                readBits += this.serviceBlockPacket.readBits(6);
            }
            if (readBits2 == 0) {
                if (readBits != 0) {
                    Log.w(TAG, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
                }
            } else if (readBits != this.selectedServiceNumber) {
            } else {
                boolean z = false;
                while (this.serviceBlockPacket.bitsLeft() > 0) {
                    int readBits3 = this.serviceBlockPacket.readBits(8);
                    if (readBits3 == 16) {
                        int readBits4 = this.serviceBlockPacket.readBits(8);
                        if (readBits4 <= 31) {
                            handleC2Command(readBits4);
                        } else {
                            if (readBits4 <= 127) {
                                handleG2Character(readBits4);
                            } else if (readBits4 <= 159) {
                                handleC3Command(readBits4);
                            } else if (readBits4 <= 255) {
                                handleG3Character(readBits4);
                            } else {
                                Log.w(TAG, "Invalid extended command: " + readBits4);
                            }
                            z = true;
                        }
                    } else if (readBits3 <= 31) {
                        handleC0Command(readBits3);
                    } else {
                        if (readBits3 <= 127) {
                            handleG0Character(readBits3);
                        } else if (readBits3 <= 159) {
                            handleC1Command(readBits3);
                        } else if (readBits3 <= 255) {
                            handleG1Character(readBits3);
                        } else {
                            Log.w(TAG, "Invalid base command: " + readBits3);
                        }
                        z = true;
                    }
                }
                if (z) {
                    this.cues = getDisplayCues();
                }
            }
        }
    }

    private void resetCueBuilders() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            for (int i = 0; i < 8; i++) {
                this.cueBuilders[i].reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<Cue> list = this.cues;
            this.lastCues = list;
            return new CeaSubtitle(list);
        }
        return (Subtitle) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subtitleInputBuffer) == null) {
            this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
            while (this.ccData.bytesLeft() >= 3) {
                int readUnsignedByte = this.ccData.readUnsignedByte() & 7;
                int i = readUnsignedByte & 3;
                boolean z = (readUnsignedByte & 4) == 4;
                byte readUnsignedByte2 = (byte) this.ccData.readUnsignedByte();
                byte readUnsignedByte3 = (byte) this.ccData.readUnsignedByte();
                if (i == 2 || i == 3) {
                    if (z) {
                        if (i == 3) {
                            finalizeCurrentPacket();
                            int i2 = (readUnsignedByte2 & 192) >> 6;
                            int i3 = readUnsignedByte2 & 63;
                            if (i3 == 0) {
                                i3 = 64;
                            }
                            DtvCcPacket dtvCcPacket = new DtvCcPacket(i2, i3);
                            this.currentDtvCcPacket = dtvCcPacket;
                            byte[] bArr = dtvCcPacket.packetData;
                            int i4 = dtvCcPacket.currentIndex;
                            dtvCcPacket.currentIndex = i4 + 1;
                            bArr[i4] = readUnsignedByte3;
                        } else {
                            Assertions.checkArgument(i == 2);
                            DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                            if (dtvCcPacket2 == null) {
                                Log.e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                            } else {
                                byte[] bArr2 = dtvCcPacket2.packetData;
                                int i5 = dtvCcPacket2.currentIndex;
                                int i6 = i5 + 1;
                                dtvCcPacket2.currentIndex = i6;
                                bArr2[i5] = readUnsignedByte2;
                                dtvCcPacket2.currentIndex = i6 + 1;
                                bArr2[i6] = readUnsignedByte3;
                            }
                        }
                        DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                        if (dtvCcPacket3.currentIndex == (dtvCcPacket3.packetSize * 2) - 1) {
                            finalizeCurrentPacket();
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.flush();
            this.cues = null;
            this.lastCues = null;
            this.currentWindow = 0;
            this.currentCueBuilder = this.cueBuilders[0];
            resetCueBuilders();
            this.currentDtvCcPacket = null;
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cues != this.lastCues : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }
}
