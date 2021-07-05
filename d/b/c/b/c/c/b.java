package d.b.c.b.c.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.HostTB;
import d.b.c.b.l;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b extends a<d.b.c.b.c.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("duplicatelog");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.c.b.c.c.a
    public HashMap<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("path", "TEXT");
            hashMap.put(HostTB.INSERTTIME, "INTEGER");
            hashMap.put("ext1", "TEXT");
            hashMap.put("ext2", "TEXT");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.b.c.c.a
    /* renamed from: e */
    public ContentValues a(d.b.c.b.c.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", aVar.f71834a);
            contentValues.put(HostTB.INSERTTIME, Long.valueOf(aVar.f71835b));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public void f(SQLiteDatabase sQLiteDatabase, d.b.c.b.c.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, sQLiteDatabase, aVar) == null) || aVar == null || g(sQLiteDatabase, aVar.f71834a)) {
            return;
        }
        super.d(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f71839a + " where _id in (select _id from " + this.f71839a + " order by " + HostTB.INSERTTIME + " desc limit 1000 offset 500" + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        int i2;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, sQLiteDatabase, str)) == null) {
            if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                query = sQLiteDatabase.query(this.f71839a, null, "path=?", new String[]{str}, null, null, null);
                i2 = query.getCount();
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
            }
            try {
                query.close();
            } catch (Exception e3) {
                e = e3;
                l.k.c(e);
                if (i2 <= 0) {
                }
            }
            return i2 <= 0;
        }
        return invokeLL.booleanValue;
    }
}
