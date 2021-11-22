package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class b implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<b> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    public static final String f70542a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f70543b;

    /* renamed from: c  reason: collision with root package name */
    public long f70544c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f70545d;

    /* renamed from: e  reason: collision with root package name */
    public long f70546e;

    /* renamed from: f  reason: collision with root package name */
    public long f70547f;

    /* renamed from: g  reason: collision with root package name */
    public int f70548g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f70549h;

    /* renamed from: i  reason: collision with root package name */
    public long f70550i;
    public List<b> j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public com.ss.android.socialbase.downloader.h.b o;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f70551a;

        /* renamed from: b  reason: collision with root package name */
        public long f70552b;

        /* renamed from: c  reason: collision with root package name */
        public long f70553c;

        /* renamed from: d  reason: collision with root package name */
        public long f70554d;

        /* renamed from: e  reason: collision with root package name */
        public long f70555e;

        /* renamed from: f  reason: collision with root package name */
        public int f70556f;

        /* renamed from: g  reason: collision with root package name */
        public long f70557g;

        /* renamed from: h  reason: collision with root package name */
        public b f70558h;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70551a = i2;
        }

        public a a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                this.f70552b = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                this.f70553c = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
                this.f70554d = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.f70555e = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                this.f70557g = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f70556f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.f70558h = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-486288163, "Lcom/ss/android/socialbase/downloader/model/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-486288163, "Lcom/ss/android/socialbase/downloader/model/b;");
                return;
            }
        }
        f70542a = b.class.getSimpleName();
        CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.model.b.1
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
            public b createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new b(parcel) : (b) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public b[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new b[i2] : (b[]) invokeI.objValue;
            }
        };
    }

    public ContentValues a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(this.f70543b));
            contentValues.put("chunkIndex", Integer.valueOf(this.f70548g));
            contentValues.put("startOffset", Long.valueOf(this.f70544c));
            contentValues.put("curOffset", Long.valueOf(n()));
            contentValues.put("endOffset", Long.valueOf(this.f70546e));
            contentValues.put("chunkContentLen", Long.valueOf(this.f70547f));
            contentValues.put("hostChunkIndex", Integer.valueOf(b()));
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AtomicInteger atomicInteger = this.f70549h;
            if (atomicInteger == null) {
                return -1;
            }
            return atomicInteger.get();
        }
        return invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AtomicBoolean atomicBoolean = this.n;
            if (atomicBoolean == null) {
                return false;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? b() == -1 : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b bVar = !d() ? this.k : this;
            if (bVar == null || !bVar.f()) {
                return null;
            }
            return bVar.g().get(0);
        }
        return (b) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            List<b> list = this.j;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public List<b> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.j : (List) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            b bVar = this.k;
            if (bVar == null) {
                return true;
            }
            if (bVar.f()) {
                for (int i2 = 0; i2 < this.k.g().size(); i2++) {
                    b bVar2 = this.k.g().get(i2);
                    if (bVar2 != null) {
                        int indexOf = this.k.g().indexOf(this);
                        if (indexOf > i2 && !bVar2.i()) {
                            return false;
                        }
                        if (indexOf == i2) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            long j = this.f70544c;
            if (d()) {
                long j2 = this.f70550i;
                if (j2 > this.f70544c) {
                    j = j2;
                }
            }
            return n() - j >= this.f70547f;
        }
        return invokeV.booleanValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b bVar = this.k;
            if (bVar != null && bVar.g() != null) {
                int indexOf = this.k.g().indexOf(this);
                boolean z = false;
                for (int i2 = 0; i2 < this.k.g().size(); i2++) {
                    b bVar2 = this.k.g().get(i2);
                    if (bVar2 != null) {
                        if (z) {
                            return bVar2.n();
                        }
                        if (indexOf == i2) {
                            z = true;
                        }
                    }
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f70543b : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f70544c : invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AtomicLong atomicLong = this.f70545d;
            if (atomicLong != null) {
                return atomicLong.get();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (d() && f()) {
                long j = 0;
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    b bVar = this.j.get(i2);
                    if (bVar != null) {
                        if (!bVar.i()) {
                            return bVar.m();
                        }
                        if (j < bVar.m()) {
                            j = bVar.m();
                        }
                    }
                }
                return j;
            }
            return m();
        }
        return invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            long n = n() - this.f70544c;
            if (f()) {
                n = 0;
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    b bVar = this.j.get(i2);
                    if (bVar != null) {
                        n += bVar.n() - bVar.l();
                    }
                }
            }
            return n;
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f70546e : invokeV.longValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f70547f : invokeV.longValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f70550i = n();
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f70548g : invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, parcel, i2) == null) {
            parcel.writeInt(this.f70543b);
            parcel.writeLong(this.f70544c);
            AtomicLong atomicLong = this.f70545d;
            parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
            parcel.writeLong(this.f70546e);
            parcel.writeLong(this.f70547f);
            parcel.writeInt(this.f70548g);
            AtomicInteger atomicInteger = this.f70549h;
            parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
        }
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (aVar == null) {
            return;
        }
        this.f70543b = aVar.f70551a;
        this.f70544c = aVar.f70552b;
        this.f70545d = new AtomicLong(aVar.f70553c);
        this.f70546e = aVar.f70554d;
        this.f70547f = aVar.f70555e;
        this.f70548g = aVar.f70556f;
        this.f70550i = aVar.f70557g;
        this.f70549h = new AtomicInteger(-1);
        a(aVar.f70558h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f70548g = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f70543b = i2;
        }
    }

    public long c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            long n = n();
            long j = this.f70547f;
            long j2 = this.f70550i;
            long j3 = j - (n - j2);
            if (!z && n == j2) {
                j3 = j - (n - this.f70544c);
            }
            com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f70547f + " curOffset:" + n() + " oldOffset:" + this.f70550i + " retainLen:" + j3);
            if (j3 < 0) {
                return 0L;
            }
            return j3;
        }
        return invokeZ.longValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            AtomicLong atomicLong = this.f70545d;
            if (atomicLong != null) {
                atomicLong.set(j);
            } else {
                this.f70545d = new AtomicLong(j);
            }
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, sQLiteStatement) == null) || sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.f70543b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f70548g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f70544c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, n());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f70546e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f70547f);
        int i8 = this.l + 1;
        this.l = i8;
        sQLiteStatement.bindLong(i8, b());
    }

    public b(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (cursor == null) {
            return;
        }
        this.f70543b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f70548g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f70544c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f70545d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f70545d = new AtomicLong(0L);
        }
        this.f70546e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f70549h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f70549h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f70547f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            AtomicInteger atomicInteger = this.f70549h;
            if (atomicInteger == null) {
                this.f70549h = new AtomicInteger(i2);
            } else {
                atomicInteger.set(i2);
            }
        }
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.o = bVar;
            r();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            AtomicBoolean atomicBoolean = this.n;
            if (atomicBoolean == null) {
                this.n = new AtomicBoolean(z);
            } else {
                atomicBoolean.set(z);
            }
            this.o = null;
        }
    }

    public b(Parcel parcel) {
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
        this.f70543b = parcel.readInt();
        this.f70544c = parcel.readLong();
        this.f70545d = new AtomicLong(parcel.readLong());
        this.f70546e = parcel.readLong();
        this.f70547f = parcel.readLong();
        this.f70548g = parcel.readInt();
        this.f70549h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.k = bVar;
            if (bVar != null) {
                a(bVar.s());
            }
        }
    }

    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.j = list;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f70547f = j;
        }
    }

    public List<b> a(int i2, long j) {
        InterceptResult invokeCommon;
        b bVar;
        long p;
        long j2;
        long j3;
        long j4;
        long j5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            b bVar2 = this;
            int i3 = i2;
            if (!d() || f()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long m = m();
            long c2 = bVar2.c(true);
            long j6 = c2 / i3;
            com.ss.android.socialbase.downloader.c.a.b(f70542a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + bVar2.f70548g);
            int i4 = 0;
            while (i4 < i3) {
                if (i4 == 0) {
                    j3 = l();
                    j2 = (m + j6) - 1;
                } else {
                    int i5 = i3 - 1;
                    if (i4 == i5) {
                        long p2 = p();
                        j4 = p2 > m ? (p2 - m) + 1 : c2 - (i5 * j6);
                        j5 = p2;
                        j3 = m;
                        long j7 = c2;
                        long j8 = j5;
                        b a2 = new a(bVar2.f70543b).a((-i4) - 1).a(j3).b(m).e(m).c(j8).d(j4).a(bVar2).a();
                        com.ss.android.socialbase.downloader.c.a.b(f70542a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + m + " endOffset:" + j8 + " contentLen:" + j4);
                        arrayList.add(a2);
                        m += j6;
                        i4++;
                        bVar2 = this;
                        i3 = i2;
                        c2 = j7;
                    } else {
                        j2 = (m + j6) - 1;
                        j3 = m;
                    }
                }
                j4 = j6;
                j5 = j2;
                long j72 = c2;
                long j82 = j5;
                b a22 = new a(bVar2.f70543b).a((-i4) - 1).a(j3).b(m).e(m).c(j82).d(j4).a(bVar2).a();
                com.ss.android.socialbase.downloader.c.a.b(f70542a, "divide sub chunk : " + i4 + " startOffset:" + j3 + " curOffset:" + m + " endOffset:" + j82 + " contentLen:" + j4);
                arrayList.add(a22);
                m += j6;
                i4++;
                bVar2 = this;
                i3 = i2;
                c2 = j72;
            }
            long j9 = 0;
            for (int size = arrayList.size() - 1; size > 0; size--) {
                b bVar3 = arrayList.get(size);
                if (bVar3 != null) {
                    j9 += bVar3.q();
                }
            }
            com.ss.android.socialbase.downloader.c.a.b(f70542a, "reuseChunkContentLen:" + j9);
            b bVar4 = arrayList.get(0);
            if (bVar4 != null) {
                if (p() == 0) {
                    p = j - l();
                } else {
                    p = (p() - l()) + 1;
                }
                bVar4.a(p - j9);
                bVar = this;
                bVar4.c(bVar.f70548g);
                com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
                if (bVar5 != null) {
                    bVar5.a(bVar4.p(), q() - j9);
                }
            } else {
                bVar = this;
            }
            bVar.a(arrayList);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }
}
