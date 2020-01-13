package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aB */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Kp */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<a> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.spliceEventId = j;
        this.spliceEventCancelIndicator = z;
        this.outOfNetworkIndicator = z2;
        this.programSpliceFlag = z3;
        this.spliceImmediateFlag = z4;
        this.programSplicePts = j2;
        this.programSplicePlaybackPositionUs = j3;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z5;
        this.breakDurationUs = j4;
        this.uniqueProgramId = i;
        this.availNum = i2;
        this.availsExpected = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(a.aD(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand a(l lVar, long j, s sVar) {
        long j2;
        boolean z;
        long j3;
        boolean z2;
        long j4;
        long j5;
        boolean z3;
        long readUnsignedInt = lVar.readUnsignedInt();
        boolean z4 = (lVar.readUnsignedByte() & 128) != 0;
        boolean z5 = false;
        boolean z6 = false;
        List emptyList = Collections.emptyList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        if (z4) {
            j2 = -9223372036854775807L;
            z = false;
            j3 = -9223372036854775807L;
            z2 = false;
        } else {
            int readUnsignedByte = lVar.readUnsignedByte();
            boolean z7 = (readUnsignedByte & 128) != 0;
            boolean z8 = (readUnsignedByte & 64) != 0;
            boolean z9 = (readUnsignedByte & 32) != 0;
            boolean z10 = (readUnsignedByte & 16) != 0;
            if (!z8 || z10) {
                j4 = -9223372036854775807L;
            } else {
                j4 = TimeSignalCommand.e(lVar, j);
            }
            if (!z8) {
                int readUnsignedByte2 = lVar.readUnsignedByte();
                emptyList = new ArrayList(readUnsignedByte2);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= readUnsignedByte2) {
                        break;
                    }
                    int readUnsignedByte3 = lVar.readUnsignedByte();
                    long j6 = -9223372036854775807L;
                    if (!z10) {
                        j6 = TimeSignalCommand.e(lVar, j);
                    }
                    emptyList.add(new a(readUnsignedByte3, j6, sVar.gK(j6)));
                    i4 = i5 + 1;
                }
            }
            if (!z9) {
                j5 = -9223372036854775807L;
                z3 = false;
            } else {
                long readUnsignedByte4 = lVar.readUnsignedByte();
                boolean z11 = (128 & readUnsignedByte4) != 0;
                long readUnsignedInt2 = ((((readUnsignedByte4 & 1) << 32) | lVar.readUnsignedInt()) * 1000) / 90;
                z3 = z11;
                j5 = readUnsignedInt2;
            }
            i = lVar.readUnsignedShort();
            i2 = lVar.readUnsignedByte();
            i3 = lVar.readUnsignedByte();
            j3 = j4;
            z2 = z10;
            z6 = z8;
            z5 = z7;
            j2 = j5;
            z = z3;
        }
        return new SpliceInsertCommand(readUnsignedInt, z4, z5, z6, z2, j3, sVar.gK(j3), emptyList, z, j2, i, i2, i3);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public final int mpL;
        public final long mpM;
        public final long mpN;

        private a(int i, long j, long j2) {
            this.mpL = i;
            this.mpM = j;
            this.mpN = j2;
        }

        public void aC(Parcel parcel) {
            parcel.writeInt(this.mpL);
            parcel.writeLong(this.mpM);
            parcel.writeLong(this.mpN);
        }

        public static a aD(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte((byte) (this.spliceEventCancelIndicator ? 1 : 0));
        parcel.writeByte((byte) (this.outOfNetworkIndicator ? 1 : 0));
        parcel.writeByte((byte) (this.programSpliceFlag ? 1 : 0));
        parcel.writeByte((byte) (this.spliceImmediateFlag ? 1 : 0));
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.componentSpliceList.get(i2).aC(parcel);
        }
        parcel.writeByte((byte) (this.autoReturn ? 1 : 0));
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }
}
