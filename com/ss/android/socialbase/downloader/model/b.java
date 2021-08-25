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
/* loaded from: classes10.dex */
public class b implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<b> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75808a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f75809b;

    /* renamed from: c  reason: collision with root package name */
    public long f75810c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicLong f75811d;

    /* renamed from: e  reason: collision with root package name */
    public long f75812e;

    /* renamed from: f  reason: collision with root package name */
    public long f75813f;

    /* renamed from: g  reason: collision with root package name */
    public int f75814g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f75815h;

    /* renamed from: i  reason: collision with root package name */
    public long f75816i;

    /* renamed from: j  reason: collision with root package name */
    public List<b> f75817j;
    public b k;
    public int l;
    public boolean m;
    public AtomicBoolean n;
    public c.p.a.e.b.k.b o;

    /* loaded from: classes10.dex */
    public static class a implements Parcelable.Creator<b> {
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
        public b createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new b(parcel) : (b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new b[i2] : (b[]) invokeI.objValue;
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2077b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f75818a;

        /* renamed from: b  reason: collision with root package name */
        public long f75819b;

        /* renamed from: c  reason: collision with root package name */
        public long f75820c;

        /* renamed from: d  reason: collision with root package name */
        public long f75821d;

        /* renamed from: e  reason: collision with root package name */
        public long f75822e;

        /* renamed from: f  reason: collision with root package name */
        public int f75823f;

        /* renamed from: g  reason: collision with root package name */
        public long f75824g;

        /* renamed from: h  reason: collision with root package name */
        public b f75825h;

        public C2077b(int i2) {
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
            this.f75818a = i2;
        }

        public C2077b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f75823f = i2;
                return this;
            }
            return (C2077b) invokeI.objValue;
        }

        public C2077b c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.f75819b = j2;
                return this;
            }
            return (C2077b) invokeJ.objValue;
        }

        public C2077b d(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.f75825h = bVar;
                return this;
            }
            return (C2077b) invokeL.objValue;
        }

        public b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this, null) : (b) invokeV.objValue;
        }

        public C2077b g(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                this.f75820c = j2;
                return this;
            }
            return (C2077b) invokeJ.objValue;
        }

        public C2077b i(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
                this.f75821d = j2;
                return this;
            }
            return (C2077b) invokeJ.objValue;
        }

        public C2077b k(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                this.f75822e = j2;
                return this;
            }
            return (C2077b) invokeJ.objValue;
        }

        public C2077b m(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                this.f75824g = j2;
                return this;
            }
            return (C2077b) invokeJ.objValue;
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
        f75808a = b.class.getSimpleName();
        CREATOR = new a();
    }

    public /* synthetic */ b(C2077b c2077b, a aVar) {
        this(c2077b);
    }

    public ContentValues a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(this.f75809b));
            contentValues.put("chunkIndex", Integer.valueOf(this.f75814g));
            contentValues.put("startOffset", Long.valueOf(this.f75810c));
            contentValues.put("curOffset", Long.valueOf(n()));
            contentValues.put("endOffset", Long.valueOf(this.f75812e));
            contentValues.put("chunkContentLen", Long.valueOf(this.f75813f));
            contentValues.put("hostChunkIndex", Integer.valueOf(b()));
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AtomicInteger atomicInteger = this.f75815h;
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
            List<b> list = this.f75817j;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public List<b> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f75817j : (List) invokeV.objValue;
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
            long j2 = this.f75810c;
            if (d()) {
                long j3 = this.f75816i;
                if (j3 > this.f75810c) {
                    j2 = j3;
                }
            }
            return n() - j2 >= this.f75813f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f75809b : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f75810c : invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AtomicLong atomicLong = this.f75811d;
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
                long j2 = 0;
                for (int i2 = 0; i2 < this.f75817j.size(); i2++) {
                    b bVar = this.f75817j.get(i2);
                    if (bVar != null) {
                        if (!bVar.i()) {
                            return bVar.m();
                        }
                        if (j2 < bVar.m()) {
                            j2 = bVar.m();
                        }
                    }
                }
                return j2;
            }
            return m();
        }
        return invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            long n = n() - this.f75810c;
            if (f()) {
                n = 0;
                for (int i2 = 0; i2 < this.f75817j.size(); i2++) {
                    b bVar = this.f75817j.get(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f75812e : invokeV.longValue;
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f75813f : invokeV.longValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f75816i = n();
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f75814g : invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, parcel, i2) == null) {
            parcel.writeInt(this.f75809b);
            parcel.writeLong(this.f75810c);
            AtomicLong atomicLong = this.f75811d;
            parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
            parcel.writeLong(this.f75812e);
            parcel.writeLong(this.f75813f);
            parcel.writeInt(this.f75814g);
            AtomicInteger atomicInteger = this.f75815h;
            parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
        }
    }

    public b(C2077b c2077b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2077b};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (c2077b == null) {
            return;
        }
        this.f75809b = c2077b.f75818a;
        this.f75810c = c2077b.f75819b;
        this.f75811d = new AtomicLong(c2077b.f75820c);
        this.f75812e = c2077b.f75821d;
        this.f75813f = c2077b.f75822e;
        this.f75814g = c2077b.f75823f;
        this.f75816i = c2077b.f75824g;
        this.f75815h = new AtomicInteger(-1);
        a(c2077b.f75825h);
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
            this.f75814g = i2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f75809b = i2;
        }
    }

    public long c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            long n = n();
            long j2 = this.f75813f;
            long j3 = this.f75816i;
            long j4 = j2 - (n - j3);
            if (!z && n == j3) {
                j4 = j2 - (n - this.f75810c);
            }
            c.p.a.e.b.c.a.g("DownloadChunk", "contentLength:" + this.f75813f + " curOffset:" + n() + " oldOffset:" + this.f75816i + " retainLen:" + j4);
            if (j4 < 0) {
                return 0L;
            }
            return j4;
        }
        return invokeZ.longValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            AtomicLong atomicLong = this.f75811d;
            if (atomicLong != null) {
                atomicLong.set(j2);
            } else {
                this.f75811d = new AtomicLong(j2);
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
        sQLiteStatement.bindLong(i2, this.f75809b);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f75814g);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, this.f75810c);
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, n());
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f75812e);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, this.f75813f);
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
        this.f75809b = cursor.getInt(cursor.getColumnIndex("_id"));
        this.f75814g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f75810c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f75811d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f75811d = new AtomicLong(0L);
        }
        this.f75812e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f75815h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f75815h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f75813f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            AtomicInteger atomicInteger = this.f75815h;
            if (atomicInteger == null) {
                this.f75815h = new AtomicInteger(i2);
            } else {
                atomicInteger.set(i2);
            }
        }
    }

    public void a(c.p.a.e.b.k.b bVar) {
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
        this.f75809b = parcel.readInt();
        this.f75810c = parcel.readLong();
        this.f75811d = new AtomicLong(parcel.readLong());
        this.f75812e = parcel.readLong();
        this.f75813f = parcel.readLong();
        this.f75814g = parcel.readInt();
        this.f75815h = new AtomicInteger(parcel.readInt());
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
            this.f75817j = list;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f75813f = j2;
        }
    }

    public List<b> a(int i2, long j2) {
        InterceptResult invokeCommon;
        b bVar;
        long p;
        long j3;
        long j4;
        long j5;
        long j6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            b bVar2 = this;
            int i3 = i2;
            if (!d() || f()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long m = m();
            long c2 = bVar2.c(true);
            long j7 = c2 / i3;
            c.p.a.e.b.c.a.g(f75808a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j7 + " current host downloadChunk index:" + bVar2.f75814g);
            int i4 = 0;
            while (i4 < i3) {
                if (i4 == 0) {
                    j4 = l();
                    j3 = (m + j7) - 1;
                } else {
                    int i5 = i3 - 1;
                    if (i4 == i5) {
                        long p2 = p();
                        j5 = p2 > m ? (p2 - m) + 1 : c2 - (i5 * j7);
                        j6 = p2;
                        j4 = m;
                        C2077b c2077b = new C2077b(bVar2.f75809b);
                        c2077b.b((-i4) - 1);
                        c2077b.c(j4);
                        c2077b.g(m);
                        c2077b.m(m);
                        long j8 = j6;
                        c2077b.i(j8);
                        c2077b.k(j5);
                        c2077b.d(bVar2);
                        b e2 = c2077b.e();
                        c.p.a.e.b.c.a.g(f75808a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m + " endOffset:" + j8 + " contentLen:" + j5);
                        arrayList.add(e2);
                        m += j7;
                        i4++;
                        bVar2 = this;
                        i3 = i2;
                        c2 = c2;
                    } else {
                        j3 = (m + j7) - 1;
                        j4 = m;
                    }
                }
                j5 = j7;
                j6 = j3;
                C2077b c2077b2 = new C2077b(bVar2.f75809b);
                c2077b2.b((-i4) - 1);
                c2077b2.c(j4);
                c2077b2.g(m);
                c2077b2.m(m);
                long j82 = j6;
                c2077b2.i(j82);
                c2077b2.k(j5);
                c2077b2.d(bVar2);
                b e22 = c2077b2.e();
                c.p.a.e.b.c.a.g(f75808a, "divide sub chunk : " + i4 + " startOffset:" + j4 + " curOffset:" + m + " endOffset:" + j82 + " contentLen:" + j5);
                arrayList.add(e22);
                m += j7;
                i4++;
                bVar2 = this;
                i3 = i2;
                c2 = c2;
            }
            long j9 = 0;
            for (int size = arrayList.size() - 1; size > 0; size--) {
                b bVar3 = arrayList.get(size);
                if (bVar3 != null) {
                    j9 += bVar3.q();
                }
            }
            c.p.a.e.b.c.a.g(f75808a, "reuseChunkContentLen:" + j9);
            b bVar4 = arrayList.get(0);
            if (bVar4 != null) {
                if (p() == 0) {
                    p = j2 - l();
                } else {
                    p = (p() - l()) + 1;
                }
                bVar4.a(p - j9);
                bVar = this;
                bVar4.c(bVar.f75814g);
                c.p.a.e.b.k.b bVar5 = bVar.o;
                if (bVar5 != null) {
                    bVar5.b(bVar4.p(), q() - j9);
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
