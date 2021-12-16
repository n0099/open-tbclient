package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.l;
import c.i.b.a.i0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<b> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SpliceInsertCommand> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SpliceInsertCommand(parcel, null) : (SpliceInsertCommand) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpliceInsertCommand[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SpliceInsertCommand[i2] : (SpliceInsertCommand[]) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f56402b;

        /* renamed from: c  reason: collision with root package name */
        public final long f56403c;

        public /* synthetic */ b(int i2, long j2, long j3, a aVar) {
            this(i2, j2, j3);
        }

        public static b a(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, parcel)) == null) ? new b(parcel.readInt(), parcel.readLong(), parcel.readLong()) : (b) invokeL.objValue;
        }

        public void b(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, parcel) == null) {
                parcel.writeInt(this.a);
                parcel.writeLong(this.f56402b);
                parcel.writeLong(this.f56403c);
            }
        }

        public b(int i2, long j2, long j3) {
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
            this.a = i2;
            this.f56402b = j2;
            this.f56403c = j3;
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
        CREATOR = new a();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceInsertCommand parseFromSection(l lVar, long j2, s sVar) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{lVar, Long.valueOf(j2), sVar})) == null) {
            long z6 = lVar.z();
            boolean z7 = (lVar.x() & 128) != 0;
            List emptyList = Collections.emptyList();
            if (z7) {
                list = emptyList;
                z = false;
                z2 = false;
                j3 = -9223372036854775807L;
                z3 = false;
                j4 = -9223372036854775807L;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                z4 = false;
            } else {
                int x = lVar.x();
                boolean z8 = (x & 128) != 0;
                boolean z9 = (x & 64) != 0;
                boolean z10 = (x & 32) != 0;
                boolean z11 = (x & 16) != 0;
                long parseSpliceTime = (!z9 || z11) ? -9223372036854775807L : TimeSignalCommand.parseSpliceTime(lVar, j2);
                if (!z9) {
                    int x2 = lVar.x();
                    ArrayList arrayList = new ArrayList(x2);
                    for (int i5 = 0; i5 < x2; i5++) {
                        int x3 = lVar.x();
                        long parseSpliceTime2 = !z11 ? TimeSignalCommand.parseSpliceTime(lVar, j2) : -9223372036854775807L;
                        arrayList.add(new b(x3, parseSpliceTime2, sVar.b(parseSpliceTime2), null));
                    }
                    emptyList = arrayList;
                }
                if (z10) {
                    long x4 = lVar.x();
                    boolean z12 = (128 & x4) != 0;
                    j5 = ((((x4 & 1) << 32) | lVar.z()) * 1000) / 90;
                    z5 = z12;
                } else {
                    z5 = false;
                    j5 = -9223372036854775807L;
                }
                i2 = lVar.D();
                z4 = z9;
                i3 = lVar.x();
                i4 = lVar.x();
                list = emptyList;
                long j6 = parseSpliceTime;
                z3 = z5;
                j4 = j5;
                z2 = z11;
                z = z8;
                j3 = j6;
            }
            return new SpliceInsertCommand(z6, z7, z, z4, z2, j3, sVar.b(j3), list, z3, j4, i2, i3, i4);
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
                this.componentSpliceList.get(i3).b(parcel);
            }
            parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }
    }

    public SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<b> list, boolean z5, long j5, int i2, int i3, int i4) {
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
            arrayList.add(b.a(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
