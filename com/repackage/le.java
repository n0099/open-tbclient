package com.repackage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ne;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class le<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j9 a;
    public String b;
    public ne.b c;
    public ne.a d;
    public int e;
    public LinkedList<String> f;
    public Object g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le a;

        public a(le leVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = leVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    public le(j9 j9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new LinkedList<>();
        this.g = new Object();
        this.a = j9Var;
    }

    public synchronized void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            synchronized (this) {
                synchronized (this.g) {
                    if (this.f.contains(str)) {
                        return;
                    }
                    this.f.addLast(str);
                    if (z) {
                        j();
                    }
                }
            }
        }
    }

    public void b(pe<T> peVar) {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, peVar) == null) {
            try {
                synchronized (this.g) {
                    this.f.remove(peVar.a);
                }
                ContentValues p = p(peVar);
                SQLiteDatabase f = this.a.f();
                if (f.update(this.b, p, "m_key = ?", new String[]{peVar.a}) == 0) {
                    f.insert(this.b, null, p);
                    if (this.d != null) {
                        j();
                    }
                }
                if (this.c == null || (d = this.c.d(peVar)) == null) {
                    return;
                }
                e(d);
            } catch (Throwable th) {
                this.a.i(th, "addOrUpdateTextCacheItem");
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.e = 0;
            synchronized (this.g) {
                this.f.clear();
            }
            if (d(str)) {
                BdCacheService.k().f().delete(str);
            }
        }
    }

    public abstract boolean d(String str);

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.a.f().delete(this.b, "m_key = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.i(th, "deleteCacheItem");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public pe<T> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return i(this.a.f(), str);
            } catch (Throwable th) {
                this.a.i(th, "get");
                return null;
            }
        }
        return (pe) invokeL.objValue;
    }

    public abstract int g();

    public j9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (j9) invokeV.objValue;
    }

    public abstract pe<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        ne.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.d) == null) {
            return;
        }
        this.e++;
        if (this.e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
            this.e = 0;
            ug.a().b(new a(this));
        }
    }

    public abstract void k(String str, String str2, int i, int i2);

    public abstract String l(String str);

    public void m() {
        String removeFirst;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f.isEmpty()) {
            return;
        }
        SQLiteDatabase f = this.a.f();
        f.beginTransaction();
        while (true) {
            try {
                synchronized (this.g) {
                    if (this.f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f.removeFirst();
                }
                f.delete(this.b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f.setTransactionSuccessful();
        this.e = 0;
    }

    @SuppressLint({"Range"})
    public void n(String str) {
        ne.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (aVar = this.d) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                pe<?> peVar = new pe<>();
                peVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                peVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                peVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                peVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h = this.d.h(peVar);
                if (h != null) {
                    a(h, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    @SuppressLint({"Range"})
    public void o(String str) {
        ne.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (bVar = this.c) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                pe<?> peVar = new pe<>();
                peVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                peVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                peVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                peVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g = this.c.g(peVar);
                if (g != null) {
                    a(g, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    public abstract ContentValues p(pe<T> peVar);

    public abstract Cursor q(SQLiteDatabase sQLiteDatabase, String str);

    public void r(ne neVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, neVar, str) == null) {
            this.b = str;
            if (neVar instanceof ne.b) {
                this.c = (ne.b) neVar;
            }
            if (neVar instanceof ne.a) {
                this.d = (ne.a) neVar;
            }
        }
    }
}
