package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobstat.Config;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: am */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: IW */
        public Format[] newArray(int i) {
            return new Format[i];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public static Format a(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List<byte[]> list, int i4) {
        return new Format(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, OFFSET_SAMPLE_RELATIVE, list, null, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData) {
        return a(str, str2, str3, i, i2, i3, i4, f, list, i5, f2, (byte[]) null, -1, (ColorInfo) null, drmInitData);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, OFFSET_SAMPLE_RELATIVE, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, OFFSET_SAMPLE_RELATIVE, list, null, null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, int i5, String str4) {
        return a(str, str2, str3, i, i2, i3, i4, -1, list, drmInitData, i5, str4);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return a(str, str2, str3, i, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str4, (Metadata) null);
    }

    public static Format a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, OFFSET_SAMPLE_RELATIVE, list, drmInitData, metadata);
    }

    public static Format d(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return a(str, str2, str3, str4, i, i2, str5, -1);
    }

    public static Format a(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, OFFSET_SAMPLE_RELATIVE, null, null, null);
    }

    public static Format a(String str, String str2, int i, String str3) {
        return a(str, str2, i, str3, (DrmInitData) null);
    }

    public static Format a(String str, String str2, int i, String str3, DrmInitData drmInitData) {
        return a(str, str2, (String) null, -1, i, str3, -1, drmInitData, (long) OFFSET_SAMPLE_RELATIVE, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData) {
        return a(str, str2, str3, i, i2, str4, i3, drmInitData, (long) OFFSET_SAMPLE_RELATIVE, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData, long j) {
        return a(str, str2, str3, i, i2, str4, -1, drmInitData, j, Collections.emptyList());
    }

    public static Format a(String str, String str2, String str3, int i, int i2, String str4, int i3, DrmInitData drmInitData, long j, List<byte[]> list) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j, list, drmInitData, null);
    }

    public static Format a(String str, String str2, String str3, int i, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, OFFSET_SAMPLE_RELATIVE, list, drmInitData, null);
    }

    public static Format e(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new Format(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, OFFSET_SAMPLE_RELATIVE, null, null, null);
    }

    public static Format i(String str, String str2, long j) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    public static Format a(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, OFFSET_SAMPLE_RELATIVE, null, drmInitData, null);
    }

    Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i;
        this.maxInputSize = i2;
        this.width = i3;
        this.height = i4;
        this.frameRate = f;
        this.rotationDegrees = i5;
        this.pixelWidthHeightRatio = f2;
        this.projectionData = bArr;
        this.stereoMode = i6;
        this.colorInfo = colorInfo;
        this.channelCount = i7;
        this.sampleRate = i8;
        this.pcmEncoding = i9;
        this.encoderDelay = i10;
        this.encoderPadding = i11;
        this.selectionFlags = i12;
        this.language = str5;
        this.accessibilityChannel = i13;
        this.subsampleOffsetUs = j;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public Format IV(int i) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format fx(long j) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format a(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        return new Format(str, this.containerMimeType, this.sampleMimeType, str2, i, this.maxInputSize, i2, i3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i4, str3, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format c(Format format) {
        if (this == format) {
            return this;
        }
        return new Format(format.id, this.containerMimeType, this.sampleMimeType, this.codecs == null ? format.codecs : this.codecs, this.bitrate == -1 ? format.bitrate : this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate == -1.0f ? format.frameRate : this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags | format.selectionFlags, this.language == null ? format.language : this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, format.drmInitData != null ? b(format.drmInitData) : this.drmInitData, this.metadata);
    }

    public Format dF(int i, int i2) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i, i2, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format a(DrmInitData drmInitData) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
    }

    public Format b(Metadata metadata) {
        return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata);
    }

    public int dty() {
        if (this.width == -1 || this.height == -1) {
            return -1;
        }
        return this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat dtz() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, this.sampleMimeType);
        a(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.language);
        a(mediaFormat, "max-input-size", this.maxInputSize);
        a(mediaFormat, "width", this.width);
        a(mediaFormat, "height", this.height);
        a(mediaFormat, "frame-rate", this.frameRate);
        a(mediaFormat, "rotation-degrees", this.rotationDegrees);
        a(mediaFormat, "channel-count", this.channelCount);
        a(mediaFormat, "sample-rate", this.sampleRate);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.initializationData.size()) {
                mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(this.initializationData.get(i2)));
                i = i2 + 1;
            } else {
                a(mediaFormat, this.colorInfo);
                return mediaFormat;
            }
        }
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (((this.drmInitData == null ? 0 : this.drmInitData.hashCode()) + (((((this.language == null ? 0 : this.language.hashCode()) + (((((((((((((this.codecs == null ? 0 : this.codecs.hashCode()) + (((this.sampleMimeType == null ? 0 : this.sampleMimeType.hashCode()) + (((this.containerMimeType == null ? 0 : this.containerMimeType.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31)) * 31) + this.accessibilityChannel) * 31)) * 31) + (this.metadata != null ? this.metadata.hashCode() : 0);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && com.google.android.exoplayer2.util.v.h(this.id, format.id) && com.google.android.exoplayer2.util.v.h(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && com.google.android.exoplayer2.util.v.h(this.containerMimeType, format.containerMimeType) && com.google.android.exoplayer2.util.v.h(this.sampleMimeType, format.sampleMimeType) && com.google.android.exoplayer2.util.v.h(this.codecs, format.codecs) && com.google.android.exoplayer2.util.v.h(this.drmInitData, format.drmInitData) && com.google.android.exoplayer2.util.v.h(this.metadata, format.metadata) && com.google.android.exoplayer2.util.v.h(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && this.initializationData.size() == format.initializationData.size()) {
            for (int i = 0; i < this.initializationData.size(); i++) {
                if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @TargetApi(24)
    private static void a(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            a(mediaFormat, "color-standard", colorInfo.colorSpace);
            a(mediaFormat, "color-range", colorInfo.colorRange);
            a(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static String d(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(format.id).append(", mimeType=").append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=").append(format.bitrate);
        }
        if (format.width != -1 && format.height != -1) {
            sb.append(", res=").append(format.width).append(Config.EVENT_HEAT_X).append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=").append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=").append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=").append(format.language);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        parcel.writeInt(this.projectionData != null ? 1 : 0);
        if (this.projectionData != null) {
            parcel.writeByteArray(this.projectionData);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeInt(this.accessibilityChannel);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeParcelable(this.metadata, 0);
    }

    private DrmInitData b(DrmInitData drmInitData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData Jr = drmInitData.Jr(i);
            if (Jr.hasData()) {
                arrayList.add(Jr);
            } else {
                arrayList2.add(Jr);
            }
        }
        if (!arrayList2.isEmpty()) {
            if (this.drmInitData == null) {
                return null;
            }
            int size = arrayList2.size();
            for (int i2 = 0; i2 < this.drmInitData.schemeDataCount; i2++) {
                DrmInitData.SchemeData Jr2 = this.drmInitData.Jr(i2);
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        if (!Jr2.a((DrmInitData.SchemeData) arrayList2.get(i3))) {
                            i3++;
                        } else {
                            arrayList.add(Jr2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            return arrayList.isEmpty() ? null : new DrmInitData(drmInitData.schemeType, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[arrayList.size()]));
        }
        return drmInitData;
    }
}
