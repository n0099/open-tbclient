package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c> events;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<SpliceScheduleCommand> {
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
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SpliceScheduleCommand(parcel, null) : (SpliceScheduleCommand) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpliceScheduleCommand[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SpliceScheduleCommand[i2] : (SpliceScheduleCommand[]) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32737a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32738b;

        public /* synthetic */ b(int i2, long j, a aVar) {
            this(i2, j);
        }

        public static b c(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, parcel)) == null) ? new b(parcel.readInt(), parcel.readLong()) : (b) invokeL.objValue;
        }

        public final void d(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, parcel) == null) {
                parcel.writeInt(this.f32737a);
                parcel.writeLong(this.f32738b);
            }
        }

        public b(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32737a = i2;
            this.f32738b = j;
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
        CREATOR = new a();
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceScheduleCommand parseFromSection(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, lVar)) == null) {
            int x = lVar.x();
            ArrayList arrayList = new ArrayList(x);
            for (int i2 = 0; i2 < x; i2++) {
                arrayList.add(c.e(lVar));
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
                this.events.get(i3).f(parcel);
            }
        }
    }

    public SpliceScheduleCommand(List<c> list) {
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
            arrayList.add(c.d(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f32739a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32740b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32741c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f32742d;

        /* renamed from: e  reason: collision with root package name */
        public final long f32743e;

        /* renamed from: f  reason: collision with root package name */
        public final List<b> f32744f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f32745g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32746h;

        /* renamed from: i  reason: collision with root package name */
        public final int f32747i;
        public final int j;
        public final int k;

        public c(long j, boolean z, boolean z2, boolean z3, List<b> list, long j2, boolean z4, long j3, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), list, Long.valueOf(j2), Boolean.valueOf(z4), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32739a = j;
            this.f32740b = z;
            this.f32741c = z2;
            this.f32742d = z3;
            this.f32744f = Collections.unmodifiableList(list);
            this.f32743e = j2;
            this.f32745g = z4;
            this.f32746h = j3;
            this.f32747i = i2;
            this.j = i3;
            this.k = i4;
        }

        public static c d(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, parcel)) == null) ? new c(parcel) : (c) invokeL.objValue;
        }

        public static c e(l lVar) {
            InterceptResult invokeL;
            ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i2;
            int i3;
            int i4;
            boolean z3;
            boolean z4;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, lVar)) == null) {
                long z5 = lVar.z();
                boolean z6 = (lVar.x() & 128) != 0;
                ArrayList arrayList2 = new ArrayList();
                if (z6) {
                    arrayList = arrayList2;
                    z = false;
                    j = -9223372036854775807L;
                    z2 = false;
                    j2 = -9223372036854775807L;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    z3 = false;
                } else {
                    int x = lVar.x();
                    boolean z7 = (x & 128) != 0;
                    boolean z8 = (x & 64) != 0;
                    boolean z9 = (x & 32) != 0;
                    long z10 = z8 ? lVar.z() : -9223372036854775807L;
                    if (!z8) {
                        int x2 = lVar.x();
                        ArrayList arrayList3 = new ArrayList(x2);
                        for (int i5 = 0; i5 < x2; i5++) {
                            arrayList3.add(new b(lVar.x(), lVar.z(), null));
                        }
                        arrayList2 = arrayList3;
                    }
                    if (z9) {
                        long x3 = lVar.x();
                        boolean z11 = (128 & x3) != 0;
                        j3 = ((((x3 & 1) << 32) | lVar.z()) * 1000) / 90;
                        z4 = z11;
                    } else {
                        z4 = false;
                        j3 = -9223372036854775807L;
                    }
                    int D = lVar.D();
                    int x4 = lVar.x();
                    z3 = z8;
                    i4 = lVar.x();
                    j2 = j3;
                    arrayList = arrayList2;
                    long j4 = z10;
                    i2 = D;
                    i3 = x4;
                    j = j4;
                    boolean z12 = z7;
                    z2 = z4;
                    z = z12;
                }
                return new c(z5, z6, z, z3, arrayList, j, z2, j2, i2, i3, i4);
            }
            return (c) invokeL.objValue;
        }

        public final void f(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, parcel) == null) {
                parcel.writeLong(this.f32739a);
                parcel.writeByte(this.f32740b ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f32741c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f32742d ? (byte) 1 : (byte) 0);
                int size = this.f32744f.size();
                parcel.writeInt(size);
                for (int i2 = 0; i2 < size; i2++) {
                    this.f32744f.get(i2).d(parcel);
                }
                parcel.writeLong(this.f32743e);
                parcel.writeByte(this.f32745g ? (byte) 1 : (byte) 0);
                parcel.writeLong(this.f32746h);
                parcel.writeInt(this.f32747i);
                parcel.writeInt(this.j);
                parcel.writeInt(this.k);
            }
        }

        public c(Parcel parcel) {
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
            this.f32739a = parcel.readLong();
            this.f32740b = parcel.readByte() == 1;
            this.f32741c = parcel.readByte() == 1;
            this.f32742d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                arrayList.add(b.c(parcel));
            }
            this.f32744f = Collections.unmodifiableList(arrayList);
            this.f32743e = parcel.readLong();
            this.f32745g = parcel.readByte() == 1;
            this.f32746h = parcel.readLong();
            this.f32747i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }
}
