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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Event> events;

    /* loaded from: classes7.dex */
    public static final class ComponentSplice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int componentTag;
        public final long utcSpliceTime;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parcel)) == null) ? new ComponentSplice(parcel.readInt(), parcel.readLong()) : (ComponentSplice) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, this, parcel) == null) {
                parcel.writeInt(this.componentTag);
                parcel.writeLong(this.utcSpliceTime);
            }
        }

        public ComponentSplice(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
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
            this.utcSpliceTime = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-787455187, "Lcom/google/android/exoplayer2/metadata/scte35/SpliceScheduleCommand;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-787455187, "Lcom/google/android/exoplayer2/metadata/scte35/SpliceScheduleCommand;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
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
            public SpliceScheduleCommand createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SpliceScheduleCommand(parcel) : (SpliceScheduleCommand) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SpliceScheduleCommand[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SpliceScheduleCommand[i2] : (SpliceScheduleCommand[]) invokeI.objValue;
            }
        };
    }

    public static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            ArrayList arrayList = new ArrayList(readUnsignedByte);
            for (int i2 = 0; i2 < readUnsignedByte; i2++) {
                arrayList.add(Event.parseFromSection(parsableByteArray));
            }
            return new SpliceScheduleCommand(arrayList);
        }
        return (SpliceScheduleCommand) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
            int size = this.events.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.events.get(i3).writeToParcel(parcel);
            }
        }
    }

    public SpliceScheduleCommand(List<Event> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.events = Collections.unmodifiableList(list);
    }

    public SpliceScheduleCommand(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes7.dex */
    public static final class Event {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        public Event(long j2, boolean z, boolean z2, boolean z3, List<ComponentSplice> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), list, Long.valueOf(j3), Boolean.valueOf(z4), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.spliceEventId = j2;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j3;
            this.autoReturn = z4;
            this.breakDurationUs = j4;
            this.uniqueProgramId = i2;
            this.availNum = i3;
            this.availsExpected = i4;
        }

        public static Event createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, parcel)) == null) ? new Event(parcel) : (Event) invokeL.objValue;
        }

        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            InterceptResult invokeL;
            ArrayList arrayList;
            boolean z;
            long j2;
            boolean z2;
            long j3;
            int i2;
            int i3;
            int i4;
            boolean z3;
            boolean z4;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, parsableByteArray)) == null) {
                long readUnsignedInt = parsableByteArray.readUnsignedInt();
                boolean z5 = (parsableByteArray.readUnsignedByte() & 128) != 0;
                ArrayList arrayList2 = new ArrayList();
                if (z5) {
                    arrayList = arrayList2;
                    z = false;
                    j2 = C.TIME_UNSET;
                    z2 = false;
                    j3 = C.TIME_UNSET;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    z3 = false;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    boolean z6 = (readUnsignedByte & 128) != 0;
                    boolean z7 = (readUnsignedByte & 64) != 0;
                    boolean z8 = (readUnsignedByte & 32) != 0;
                    long readUnsignedInt2 = z7 ? parsableByteArray.readUnsignedInt() : C.TIME_UNSET;
                    if (!z7) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                        for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                            arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z8) {
                        long readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        boolean z9 = (128 & readUnsignedByte3) != 0;
                        j4 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                        z4 = z9;
                    } else {
                        z4 = false;
                        j4 = C.TIME_UNSET;
                    }
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                    z3 = z7;
                    i4 = parsableByteArray.readUnsignedByte();
                    j3 = j4;
                    arrayList = arrayList2;
                    long j5 = readUnsignedInt2;
                    i2 = readUnsignedShort;
                    i3 = readUnsignedByte4;
                    j2 = j5;
                    boolean z10 = z6;
                    z2 = z4;
                    z = z10;
                }
                return new Event(readUnsignedInt, z5, z, z3, arrayList, j2, z2, j3, i2, i3, i4);
            }
            return (Event) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, this, parcel) == null) {
                parcel.writeLong(this.spliceEventId);
                parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
                int size = this.componentSpliceList.size();
                parcel.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    this.componentSpliceList.get(i2).writeToParcel(parcel);
                }
                parcel.writeLong(this.utcSpliceTime);
                parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
                parcel.writeLong(this.breakDurationUs);
                parcel.writeInt(this.uniqueProgramId);
                parcel.writeInt(this.availNum);
                parcel.writeInt(this.availsExpected);
            }
        }

        public Event(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
