package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.l;
import d.f.b.a.i0.s;
/* loaded from: classes6.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final long playbackPositionUs;
    public final long ptsTime;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<TimeSignalCommand> {
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
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null) : (TimeSignalCommand) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeSignalCommand[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new TimeSignalCommand[i2] : (TimeSignalCommand[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2099047217, "Lcom/google/android/exoplayer2/metadata/scte35/TimeSignalCommand;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2099047217, "Lcom/google/android/exoplayer2/metadata/scte35/TimeSignalCommand;");
                return;
            }
        }
        CREATOR = new a();
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, a aVar) {
        this(j, j2);
    }

    public static TimeSignalCommand parseFromSection(l lVar, long j, s sVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{lVar, Long.valueOf(j), sVar})) == null) {
            long parseSpliceTime = parseSpliceTime(lVar, j);
            return new TimeSignalCommand(parseSpliceTime, sVar.b(parseSpliceTime));
        }
        return (TimeSignalCommand) invokeCommon.objValue;
    }

    public static long parseSpliceTime(l lVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65540, null, lVar, j)) == null) {
            long x = lVar.x();
            if ((128 & x) != 0) {
                return 8589934591L & ((((x & 1) << 32) | lVar.z()) + j);
            }
            return -9223372036854775807L;
        }
        return invokeLJ.longValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
            parcel.writeLong(this.ptsTime);
            parcel.writeLong(this.playbackPositionUs);
        }
    }

    public TimeSignalCommand(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.ptsTime = j;
        this.playbackPositionUs = j2;
    }
}
