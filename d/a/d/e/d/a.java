package d.a.d.e.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends c<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f41594h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.d.a.k.b bVar, String str) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.d.a.k.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41594h = str;
    }

    @Override // d.a.d.e.d.c
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                this.f41595a.f().delete(this.f41596b, "m_ns = ?", new String[]{str});
                return true;
            } catch (Throwable th) {
                d.a.d.a.k.b bVar = this.f41595a;
                bVar.i(th, "failed to clear from " + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.d.e.d.c
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [T, byte[]] */
    @Override // d.a.d.e.d.c
    public g<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) != null) {
            return (g) invokeLL.objValue;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.f41596b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    d.a.d.e.m.a.a(rawQuery);
                    return null;
                }
                g<byte[]> gVar = new g<>();
                gVar.f41609a = rawQuery.getString(0);
                gVar.f41611c = rawQuery.getString(1);
                gVar.f41612d = rawQuery.getLong(2);
                gVar.f41613e = rawQuery.getLong(3);
                gVar.f41614f = rawQuery.getLong(4);
                gVar.f41610b = rawQuery.getBlob(5);
                d.a.d.e.m.a.a(rawQuery);
                return gVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                d.a.d.e.m.a.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // d.a.d.e.d.c
    public void k(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i2, i3) == null) {
        }
    }

    @Override // d.a.d.e.d.c
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f41595a.d("CREATE TABLE IF NOT EXISTS " + this.f41594h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
            this.f41595a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.f41594h + "(m_ns)");
            return this.f41594h;
        }
        return (String) invokeL.objValue;
    }

    @Override // d.a.d.e.d.c
    public ContentValues p(g<byte[]> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", gVar.f41609a);
            contentValues.put("m_ns", gVar.f41611c);
            contentValues.put("m_value", gVar.f41610b);
            contentValues.put("saveTime", Long.valueOf(gVar.f41612d));
            contentValues.put("lastHitTime", Long.valueOf(gVar.f41613e));
            contentValues.put("timeToExpire", Long.valueOf(gVar.f41614f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // d.a.d.e.d.c
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.f41596b + " where m_ns = ?", new String[]{str});
        }
        return (Cursor) invokeLL.objValue;
    }
}
