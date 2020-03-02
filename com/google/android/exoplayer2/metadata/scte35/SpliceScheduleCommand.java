package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aF */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Kw */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    };
    public final List<b> events;

    /* loaded from: classes6.dex */
    public static final class b {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<a> componentSpliceList;
        public final long mqB;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;

        private b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.spliceEventId = j;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.mqB = j2;
            this.autoReturn = z4;
            this.breakDurationUs = j3;
            this.uniqueProgramId = i;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        private b(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(a.aG(parcel));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.mqB = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b R(l lVar) {
            long j;
            boolean z;
            boolean z2;
            long j2;
            ArrayList arrayList;
            long readUnsignedInt = lVar.readUnsignedInt();
            boolean z3 = (lVar.readUnsignedByte() & 128) != 0;
            boolean z4 = false;
            long j3 = -9223372036854775807L;
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            boolean z5 = false;
            long j4 = -9223372036854775807L;
            if (z3) {
                j = -9223372036854775807L;
                z = false;
                z2 = false;
            } else {
                int readUnsignedByte = lVar.readUnsignedByte();
                boolean z6 = (readUnsignedByte & 128) != 0;
                boolean z7 = (readUnsignedByte & 64) != 0;
                boolean z8 = (readUnsignedByte & 32) != 0;
                if (!z7) {
                    j2 = -9223372036854775807L;
                } else {
                    j2 = lVar.readUnsignedInt();
                }
                if (z7) {
                    arrayList = arrayList2;
                } else {
                    int readUnsignedByte2 = lVar.readUnsignedByte();
                    arrayList = new ArrayList(readUnsignedByte2);
                    for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                        arrayList.add(new a(lVar.readUnsignedByte(), lVar.readUnsignedInt()));
                    }
                }
                if (z8) {
                    long readUnsignedByte3 = lVar.readUnsignedByte();
                    z5 = (128 & readUnsignedByte3) != 0;
                    j4 = ((((readUnsignedByte3 & 1) << 32) | lVar.readUnsignedInt()) * 1000) / 90;
                }
                i = lVar.readUnsignedShort();
                i2 = lVar.readUnsignedByte();
                i3 = lVar.readUnsignedByte();
                arrayList2 = arrayList;
                z4 = z7;
                j3 = j2;
                j = j4;
                z2 = z5;
                z = z6;
            }
            return new b(readUnsignedInt, z3, z, z4, arrayList2, j3, z2, j, i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aC(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte((byte) (this.spliceEventCancelIndicator ? 1 : 0));
            parcel.writeByte((byte) (this.outOfNetworkIndicator ? 1 : 0));
            parcel.writeByte((byte) (this.programSpliceFlag ? 1 : 0));
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.componentSpliceList.get(i).aC(parcel);
            }
            parcel.writeLong(this.mqB);
            parcel.writeByte((byte) (this.autoReturn ? 1 : 0));
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b aI(Parcel parcel) {
            return new b(parcel);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final long mqB;
        public final int mqy;

        private a(int i, long j) {
            this.mqy = i;
            this.mqB = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a aG(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aC(Parcel parcel) {
            parcel.writeInt(this.mqy);
            parcel.writeLong(this.mqB);
        }
    }

    private SpliceScheduleCommand(List<b> list) {
        this.events = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(b.aI(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceScheduleCommand Q(l lVar) {
        int readUnsignedByte = lVar.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(b.R(lVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.events.get(i2).aC(parcel);
        }
    }
}
