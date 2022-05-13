package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.je;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class he<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h9 a;
    public String b;
    public je.b c;
    public je.a d;
    public int e;
    public LinkedList<String> f;
    public Object g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he a;

        public a(he heVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = heVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    public he(h9 h9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h9Var};
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
        this.a = h9Var;
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

    public void b(le<T> leVar) {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leVar) == null) {
            try {
                synchronized (this.g) {
                    this.f.remove(leVar.a);
                }
                ContentValues p = p(leVar);
                SQLiteDatabase f = this.a.f();
                if (f.update(this.b, p, "m_key = ?", new String[]{leVar.a}) == 0) {
                    f.insert(this.b, null, p);
                    if (this.d != null) {
                        j();
                    }
                }
                if (this.c == null || (d = this.c.d(leVar)) == null) {
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

    public le<T> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return i(this.a.f(), str);
            } catch (Throwable th) {
                this.a.i(th, SharedPreferenceManager.OPERATION_GET_PERFIX);
                return null;
            }
        }
        return (le) invokeL.objValue;
    }

    public abstract int g();

    public h9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (h9) invokeV.objValue;
    }

    public abstract le<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public void j() {
        je.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.d) == null) {
            return;
        }
        this.e++;
        if (this.e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
            this.e = 0;
            qg.a().b(new a(this));
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

    public void n(String str) {
        je.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (aVar = this.d) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                le<?> leVar = new le<>();
                leVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                leVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                leVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                leVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h = this.d.h(leVar);
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

    public void o(String str) {
        je.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (bVar = this.c) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                le<?> leVar = new le<>();
                leVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                leVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                leVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                leVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g = this.c.g(leVar);
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

    public abstract ContentValues p(le<T> leVar);

    public abstract Cursor q(SQLiteDatabase sQLiteDatabase, String str);

    public void r(je jeVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, jeVar, str) == null) {
            this.b = str;
            if (jeVar instanceof je.b) {
                this.c = (je.b) jeVar;
            }
            if (jeVar instanceof je.a) {
                this.d = (je.a) jeVar;
            }
        }
    }
}
