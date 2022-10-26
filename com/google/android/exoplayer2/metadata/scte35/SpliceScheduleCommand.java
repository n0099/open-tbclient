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
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final List events;

    /* loaded from: classes7.dex */
    public final class ComponentSplice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int componentTag;
        public final long utcSpliceTime;

        public ComponentSplice(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentTag = i;
            this.utcSpliceTime = j;
        }

        public static ComponentSplice createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parcel)) == null) {
                return new ComponentSplice(parcel.readInt(), parcel.readLong());
            }
            return (ComponentSplice) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, this, parcel) == null) {
                parcel.writeInt(this.componentTag);
                parcel.writeLong(this.utcSpliceTime);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class Event {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        public Event(long j, boolean z, boolean z2, boolean z3, List list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), list, Long.valueOf(j2), Boolean.valueOf(z4), Long.valueOf(j3), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.spliceEventId = j;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j2;
            this.autoReturn = z4;
            this.breakDurationUs = j3;
            this.uniqueProgramId = i;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        public Event(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.spliceEventId = parcel.readLong();
            if (parcel.readByte() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.spliceEventCancelIndicator = z;
            if (parcel.readByte() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.outOfNetworkIndicator = z2;
            if (parcel.readByte() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.programSpliceFlag = z3;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
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

        public static Event createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, parcel)) == null) {
                return new Event(parcel);
            }
            return (Event) invokeL.objValue;
        }

        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            InterceptResult invokeL;
            boolean z;
            ArrayList arrayList;
            boolean z2;
            long j;
            boolean z3;
            long j2;
            int i;
            int i2;
            int i3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            long j3;
            boolean z8;
            long j4;
            boolean z9;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, parsableByteArray)) == null) {
                long readUnsignedInt = parsableByteArray.readUnsignedInt();
                if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                ArrayList arrayList2 = new ArrayList();
                if (!z) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    if ((readUnsignedByte & 128) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if ((readUnsignedByte & 64) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if ((readUnsignedByte & 32) != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z6) {
                        j3 = parsableByteArray.readUnsignedInt();
                    } else {
                        j3 = C.TIME_UNSET;
                    }
                    if (!z6) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                            arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z7) {
                        long readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        if ((128 & readUnsignedByte3) != 0) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        j4 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                        z8 = z9;
                    } else {
                        z8 = false;
                        j4 = C.TIME_UNSET;
                    }
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                    z4 = z6;
                    i3 = parsableByteArray.readUnsignedByte();
                    j2 = j4;
                    arrayList = arrayList2;
                    long j5 = j3;
                    i = readUnsignedShort;
                    i2 = readUnsignedByte4;
                    j = j5;
                    boolean z10 = z5;
                    z3 = z8;
                    z2 = z10;
                } else {
                    arrayList = arrayList2;
                    z2 = false;
                    j = C.TIME_UNSET;
                    z3 = false;
                    j2 = C.TIME_UNSET;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    z4 = false;
                }
                return new Event(readUnsignedInt, z, z2, z4, arrayList, j, z3, j2, i, i2, i3);
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
                for (int i = 0; i < size; i++) {
                    ((ComponentSplice) this.componentSpliceList.get(i)).writeToParcel(parcel);
                }
                parcel.writeLong(this.utcSpliceTime);
                parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
                parcel.writeLong(this.breakDurationUs);
                parcel.writeInt(this.uniqueProgramId);
                parcel.writeInt(this.availNum);
                parcel.writeInt(this.availsExpected);
            }
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
        CREATOR = new Parcelable.Creator() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SpliceScheduleCommand createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new SpliceScheduleCommand(parcel);
                }
                return (SpliceScheduleCommand) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SpliceScheduleCommand[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new SpliceScheduleCommand[i];
                }
                return (SpliceScheduleCommand[]) invokeI.objValue;
            }
        };
    }

    public SpliceScheduleCommand(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int size = this.events.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                ((Event) this.events.get(i2)).writeToParcel(parcel);
            }
        }
    }

    public SpliceScheduleCommand(List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.events = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            ArrayList arrayList = new ArrayList(readUnsignedByte);
            for (int i = 0; i < readUnsignedByte; i++) {
                arrayList.add(Event.parseFromSection(parsableByteArray));
            }
            return new SpliceScheduleCommand(arrayList);
        }
        return (SpliceScheduleCommand) invokeL.objValue;
    }
}
