package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    /* loaded from: classes7.dex */
    public static final class ComponentSplice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parcel)) == null) ? new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong()) : (ComponentSplice) invokeL.objValue;
        }

        public void writeToParcel(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, parcel) == null) {
                parcel.writeInt(this.componentTag);
                parcel.writeLong(this.componentSplicePts);
                parcel.writeLong(this.componentSplicePlaybackPositionUs);
            }
        }

        public ComponentSplice(int i2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentTag = i2;
            this.componentSplicePts = j2;
            this.componentSplicePlaybackPositionUs = j3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1888838351, "Lcom/google/android/exoplayer2/metadata/scte35/SpliceInsertCommand;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1888838351, "Lcom/google/android/exoplayer2/metadata/scte35/SpliceInsertCommand;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1
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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SpliceInsertCommand createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SpliceInsertCommand(parcel) : (SpliceInsertCommand) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SpliceInsertCommand[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SpliceInsertCommand[i2] : (SpliceInsertCommand[]) invokeI.objValue;
            }
        };
    }

    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j2, TimestampAdjuster timestampAdjuster) {
        InterceptResult invokeCommon;
        List list;
        boolean z;
        boolean z2;
        long j3;
        boolean z3;
        long j4;
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{parsableByteArray, Long.valueOf(j2), timestampAdjuster})) == null) {
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            boolean z6 = (parsableByteArray.readUnsignedByte() & 128) != 0;
            List emptyList = Collections.emptyList();
            if (z6) {
                list = emptyList;
                z = false;
                z2 = false;
                j3 = C.TIME_UNSET;
                z3 = false;
                j4 = C.TIME_UNSET;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                z4 = false;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                boolean z7 = (readUnsignedByte & 128) != 0;
                boolean z8 = (readUnsignedByte & 64) != 0;
                boolean z9 = (readUnsignedByte & 32) != 0;
                boolean z10 = (readUnsignedByte & 16) != 0;
                long parseSpliceTime = (!z8 || z10) ? C.TIME_UNSET : TimeSignalCommand.parseSpliceTime(parsableByteArray, j2);
                if (!z8) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList = new ArrayList(readUnsignedByte2);
                    for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        long parseSpliceTime2 = !z10 ? TimeSignalCommand.parseSpliceTime(parsableByteArray, j2) : C.TIME_UNSET;
                        arrayList.add(new ComponentSplice(readUnsignedByte3, parseSpliceTime2, timestampAdjuster.adjustTsTimestamp(parseSpliceTime2)));
                    }
                    emptyList = arrayList;
                }
                if (z9) {
                    long readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                    boolean z11 = (128 & readUnsignedByte4) != 0;
                    j5 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z5 = z11;
                } else {
                    z5 = false;
                    j5 = C.TIME_UNSET;
                }
                i2 = parsableByteArray.readUnsignedShort();
                z4 = z8;
                i3 = parsableByteArray.readUnsignedByte();
                i4 = parsableByteArray.readUnsignedByte();
                list = emptyList;
                long j6 = parseSpliceTime;
                z3 = z5;
                j4 = j5;
                z2 = z10;
                z = z7;
                j3 = j6;
            }
            return new SpliceInsertCommand(readUnsignedInt, z6, z, z4, z2, j3, timestampAdjuster.adjustTsTimestamp(j3), list, z3, j4, i2, i3, i4);
        }
        return (SpliceInsertCommand) invokeCommon.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.programSplicePts);
            parcel.writeLong(this.programSplicePlaybackPositionUs);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.componentSpliceList.get(i3).writeToParcel(parcel);
            }
            parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }
    }

    public SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<ComponentSplice> list, boolean z5, long j5, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Long.valueOf(j3), Long.valueOf(j4), list, Boolean.valueOf(z5), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.spliceEventId = j2;
        this.spliceEventCancelIndicator = z;
        this.outOfNetworkIndicator = z2;
        this.programSpliceFlag = z3;
        this.spliceImmediateFlag = z4;
        this.programSplicePts = j3;
        this.programSplicePlaybackPositionUs = j4;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z5;
        this.breakDurationUs = j5;
        this.uniqueProgramId = i2;
        this.availNum = i3;
        this.availsExpected = i4;
    }

    public SpliceInsertCommand(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
