package com.kwai.filedownloader.d;

import android.content.ContentValues;
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
import com.kwai.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public class c implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<c> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f74485a;

    /* renamed from: b  reason: collision with root package name */
    public String f74486b;

    /* renamed from: c  reason: collision with root package name */
    public String f74487c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74488d;

    /* renamed from: e  reason: collision with root package name */
    public String f74489e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f74490f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f74491g;

    /* renamed from: h  reason: collision with root package name */
    public long f74492h;

    /* renamed from: i  reason: collision with root package name */
    public String f74493i;

    /* renamed from: j  reason: collision with root package name */
    public String f74494j;
    public int k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185710464, "Lcom/kwai/filedownloader/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185710464, "Lcom/kwai/filedownloader/d/c;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.d.c.1
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
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new c(parcel) : (c) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new c[i2] : (c[]) invokeI.objValue;
            }
        };
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74491g = new AtomicLong();
        this.f74490f = new AtomicInteger();
    }

    public c(Parcel parcel) {
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
        this.f74485a = parcel.readInt();
        this.f74486b = parcel.readString();
        this.f74487c = parcel.readString();
        this.f74488d = parcel.readByte() != 0;
        this.f74489e = parcel.readString();
        this.f74490f = new AtomicInteger(parcel.readByte());
        this.f74491g = new AtomicLong(parcel.readLong());
        this.f74492h = parcel.readLong();
        this.f74493i = parcel.readString();
        this.f74494j = parcel.readString();
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74485a : invokeV.intValue;
    }

    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) {
            this.f74490f.set(b2);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f74485a = i2;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f74491g.set(j2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f74486b = str;
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            this.f74487c = str;
            this.f74488d = z;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74486b : (String) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.k = i2;
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.f74491g.addAndGet(j2);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f74494j = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f74487c : (String) invokeV.objValue;
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.l = j2 > 2147483647L;
            this.f74492h = j2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f74493i = str;
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? f.a(c(), l(), m()) : (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f74489e = str;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (d() == null) {
                return null;
            }
            return f.d(d());
        }
        return (String) invokeV.objValue;
    }

    public byte f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (byte) this.f74490f.get() : invokeV.byteValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f74491g.get() : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f74492h : invokeV.longValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f74492h == -1 : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f74494j : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f74493i : (String) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f74488d : invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f74489e : (String) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k : invokeV.intValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.k = 1;
        }
    }

    public ContentValues p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(a()));
            contentValues.put("url", b());
            contentValues.put("path", c());
            contentValues.put("status", Byte.valueOf(f()));
            contentValues.put("sofar", Long.valueOf(g()));
            contentValues.put("total", Long.valueOf(h()));
            contentValues.put("errMsg", k());
            contentValues.put("etag", j());
            contentValues.put("connectionCount", Integer.valueOf(n()));
            contentValues.put("pathAsDirectory", Boolean.valueOf(l()));
            if (l() && m() != null) {
                contentValues.put("filename", m());
            }
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f74485a), this.f74486b, this.f74487c, Integer.valueOf(this.f74490f.get()), this.f74491g, Long.valueOf(this.f74492h), this.f74494j, super.toString()) : (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, parcel, i2) == null) {
            parcel.writeInt(this.f74485a);
            parcel.writeString(this.f74486b);
            parcel.writeString(this.f74487c);
            parcel.writeByte(this.f74488d ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f74489e);
            parcel.writeByte((byte) this.f74490f.get());
            parcel.writeLong(this.f74491g.get());
            parcel.writeLong(this.f74492h);
            parcel.writeString(this.f74493i);
            parcel.writeString(this.f74494j);
            parcel.writeInt(this.k);
            parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        }
    }
}
