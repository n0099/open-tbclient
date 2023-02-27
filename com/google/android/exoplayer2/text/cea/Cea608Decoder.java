package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class Cea608Decoder extends CeaDecoder {
    public static final int CC_FIELD_FLAG = 1;
    public static final byte CC_IMPLICIT_DATA_HEADER = -4;
    public static final int CC_MODE_PAINT_ON = 3;
    public static final int CC_MODE_POP_ON = 2;
    public static final int CC_MODE_ROLL_UP = 1;
    public static final int CC_MODE_UNKNOWN = 0;
    public static final int CC_TYPE_FLAG = 2;
    public static final int CC_VALID_608_ID = 4;
    public static final int CC_VALID_FLAG = 4;
    public static final byte CTRL_BACKSPACE = 33;
    public static final byte CTRL_CARRIAGE_RETURN = 45;
    public static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    public static final byte CTRL_END_OF_CAPTION = 47;
    public static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    public static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    public static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    public static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    public static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    public static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    public static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    public static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    public static final int NTSC_CC_FIELD_1 = 0;
    public static final int NTSC_CC_FIELD_2 = 1;
    public int captionMode;
    public int captionRowCount;
    public List<Cue> cues;
    public List<Cue> lastCues;
    public final int packetLength;
    public byte repeatableControlCc1;
    public byte repeatableControlCc2;
    public boolean repeatableControlSet;
    public final int selectedField;
    public static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] COLORS = {-1, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, GDiffPatcher.DATA_USHORT, 209, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 9632};
    public static final int[] SPECIAL_CHARACTER_SET = {MatroskaExtractor.ID_TRACK_ENTRY, MatroskaExtractor.ID_PIXEL_WIDTH, PsExtractor.PRIVATE_STREAM_1, 191, 8482, BDLocation.TypeServerDecryptError, MatroskaExtractor.ID_SIMPLE_BLOCK, 9834, 224, 32, 232, Constants.METHOD_MEDIA_NOTIFY, 234, 238, GDiffPatcher.COPY_UBYTE_UBYTE, 251};
    public static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, PassFaceRecogManager.j, GDiffPatcher.COPY_INT_UBYTE, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG, 200, 202, 203, 235, 206, 207, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, MatroskaExtractor.ID_CUE_POINT};
    public static final int[] SPECIAL_PT_DE_CHARACTER_SET = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, Constants.METHOD_IM_CONSULT_NOTIFY_MSG, 210, 242, 213, GDiffPatcher.COPY_UBYTE_USHORT, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, JfifUtil.MARKER_SOI, GDiffPatcher.DATA_INT, 9484, 9488, 9492, 9496};
    public final ParsableByteArray ccData = new ParsableByteArray();
    public final LinkedList<CueBuilder> cueBuilders = new LinkedList<>();
    public CueBuilder currentCueBuilder = new CueBuilder(0, 4);

    public static boolean isMidrowCtrlCode(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    public static boolean isMiscCode(byte b, byte b2) {
        return (b & 247) == 20 && (b2 & 240) == 32;
    }

    public static boolean isPreambleAddressCode(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & ExifInterface.MARKER_SOF0) == 64;
    }

    public static boolean isRepeatable(byte b) {
        return (b & 240) == 16;
    }

    public static boolean isTabCtrlCode(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    /* loaded from: classes7.dex */
    public static class CueBuilder {
        public static final int BASE_ROW = 15;
        public static final int POSITION_UNSET = -1;
        public static final int SCREEN_CHARWIDTH = 32;
        public int captionMode;
        public int captionRowCount;
        public int indent;
        public int row;
        public int tabOffset;
        public int underlineStartPosition;
        public final List<CharacterStyle> preambleStyles = new ArrayList();
        public final List<CueStyle> midrowStyles = new ArrayList();
        public final List<SpannableString> rolledUpCaptions = new LinkedList();
        public final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();

        /* loaded from: classes7.dex */
        public static class CueStyle {
            public final int nextStyleIncrement;
            public final int start;
            public final CharacterStyle style;

            public CueStyle(CharacterStyle characterStyle, int i, int i2) {
                this.style = characterStyle;
                this.start = i;
                this.nextStyleIncrement = i2;
            }
        }

        public CueBuilder(int i, int i2) {
            reset(i, i2);
        }

        public void reset(int i, int i2) {
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
            this.captionMode = i;
            this.captionRowCount = i2;
            this.underlineStartPosition = -1;
        }

        public void setMidrowStyle(CharacterStyle characterStyle, int i) {
            this.midrowStyles.add(new CueStyle(characterStyle, this.captionStringBuilder.length(), i));
        }

        public void append(char c) {
            this.captionStringBuilder.append(c);
        }

        public void setIndent(int i) {
            this.indent = i;
        }

        public void setPreambleStyle(CharacterStyle characterStyle) {
            this.preambleStyles.add(characterStyle);
        }

        public void setRow(int i) {
            this.row = i;
        }

        public void setTab(int i) {
            this.tabOffset = i;
        }

        public void setUnderline(boolean z) {
            if (z) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            } else if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public boolean isEmpty() {
            if (this.preambleStyles.isEmpty() && this.midrowStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.captionStringBuilder.toString();
        }

        public Cue build() {
            int length;
            float f;
            int i;
            int i2;
            int i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.rolledUpCaptions.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.indent + this.tabOffset;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.captionMode == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.captionMode == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.captionMode != 1 && (i2 = this.row) <= 7) {
                i3 = 0;
            } else {
                i2 = (this.row - 15) - 2;
                i3 = 2;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public SpannableString buildSpannableString() {
            int i;
            int length = this.captionStringBuilder.length();
            for (int i2 = 0; i2 < this.preambleStyles.size(); i2++) {
                this.captionStringBuilder.setSpan(this.preambleStyles.get(i2), 0, length, 33);
            }
            for (int i3 = 0; i3 < this.midrowStyles.size(); i3++) {
                CueStyle cueStyle = this.midrowStyles.get(i3);
                int size = this.midrowStyles.size();
                int i4 = cueStyle.nextStyleIncrement;
                if (i3 < size - i4) {
                    i = this.midrowStyles.get(i4 + i3).start;
                } else {
                    i = length;
                }
                this.captionStringBuilder.setSpan(cueStyle.style, cueStyle.start, i, 33);
            }
            if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
            }
            return new SpannableString(this.captionStringBuilder);
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.clear();
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.underlineStartPosition = -1;
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }
    }

    public Cea608Decoder(String str, int i) {
        int i2;
        if (MimeTypes.APPLICATION_MP4CEA608.equals(str)) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        this.packetLength = i2;
        if (i != 3 && i != 4) {
            this.selectedField = 1;
        } else {
            this.selectedField = 2;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    public static char getChar(byte b) {
        return (char) BASIC_CHARACTER_SET[(b & ByteCompanionObject.MAX_VALUE) - 32];
    }

    public static char getExtendedEsFrChar(byte b) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b & 31];
    }

    public static char getExtendedPtDeChar(byte b) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b & 31];
    }

    public static char getSpecialChar(byte b) {
        return (char) SPECIAL_CHARACTER_SET[b & 15];
    }

    private void setCaptionMode(int i) {
        int i2 = this.captionMode;
        if (i2 == i) {
            return;
        }
        this.captionMode = i;
        resetCueBuilders();
        if (i2 == 3 || i == 1 || i == 0) {
            this.cues = null;
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.cueBuilders.size(); i++) {
            Cue build = this.cueBuilders.get(i).build();
            if (build != null) {
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode, this.captionRowCount);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
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
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        resetCueBuilders();
        this.captionRowCount = 4;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        if (this.cues != this.lastCues) {
            return true;
        }
        return false;
    }

    private boolean handleCtrl(byte b, byte b2) {
        boolean isRepeatable = isRepeatable(b);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b && this.repeatableControlCc2 == b2) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b;
            this.repeatableControlCc2 = b2;
        }
        if (isMidrowCtrlCode(b, b2)) {
            handleMidrowCtrl(b2);
        } else if (isPreambleAddressCode(b, b2)) {
            handlePreambleAddressCode(b, b2);
        } else if (isTabCtrlCode(b, b2)) {
            this.currentCueBuilder.setTab(b2 - 32);
        } else if (isMiscCode(b, b2)) {
            handleMiscCode(b2);
        }
        return isRepeatable;
    }

    private void handleMidrowCtrl(byte b) {
        boolean z;
        if ((b & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.currentCueBuilder.setUnderline(z);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.currentCueBuilder.setMidrowStyle(new StyleSpan(2), 2);
            this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void handleMiscCode(byte b) {
        if (b != 32) {
            if (b != 41) {
                switch (b) {
                    case 37:
                        this.captionRowCount = 2;
                        setCaptionMode(1);
                        return;
                    case 38:
                        this.captionRowCount = 3;
                        setCaptionMode(1);
                        return;
                    case 39:
                        this.captionRowCount = 4;
                        setCaptionMode(1);
                        return;
                    default:
                        int i = this.captionMode;
                        if (i == 0) {
                            return;
                        }
                        if (b != 33) {
                            switch (b) {
                                case 44:
                                    this.cues = null;
                                    if (i == 1 || i == 3) {
                                        resetCueBuilders();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        return;
                                    }
                                    return;
                                case 46:
                                    resetCueBuilders();
                                    return;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.currentCueBuilder.backspace();
                        return;
                }
            }
            setCaptionMode(3);
            return;
        }
        setCaptionMode(2);
    }

    private void handlePreambleAddressCode(byte b, byte b2) {
        boolean z;
        int i = ROW_INDICES[b & 7];
        if ((b2 & 32) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i++;
        }
        if (i != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            this.currentCueBuilder.setRow(i);
        }
        if ((b2 & 1) == 1) {
            this.currentCueBuilder.setPreambleStyle(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.currentCueBuilder.setPreambleStyle(new StyleSpan(2));
                this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(-1));
                return;
            }
            this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.currentCueBuilder.setIndent(COLUMN_INDICES[i2 & 7]);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte readUnsignedByte;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int bytesLeft = this.ccData.bytesLeft();
            int i = this.packetLength;
            if (bytesLeft < i) {
                break;
            }
            if (i == 2) {
                readUnsignedByte = -4;
            } else {
                readUnsignedByte = (byte) this.ccData.readUnsignedByte();
            }
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.ccData.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.selectedField != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.selectedField != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.currentCueBuilder.append(getSpecialChar(readUnsignedByte3));
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.currentCueBuilder.backspace();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.currentCueBuilder.append(getExtendedEsFrChar(readUnsignedByte3));
                            } else {
                                this.currentCueBuilder.append(getExtendedPtDeChar(readUnsignedByte3));
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z2 = handleCtrl(readUnsignedByte2, readUnsignedByte3);
                        } else {
                            this.currentCueBuilder.append(getChar(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.currentCueBuilder.append(getChar(readUnsignedByte3));
                            }
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            if (!z2) {
                this.repeatableControlSet = false;
            }
            int i2 = this.captionMode;
            if (i2 == 1 || i2 == 3) {
                this.cues = getDisplayCues();
            }
        }
    }
}
