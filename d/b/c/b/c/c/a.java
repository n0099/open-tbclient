package d.b.c.b.c.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.l;
import java.util.HashMap;
/* loaded from: classes10.dex */
public abstract class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f71839a;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71839a = str;
    }

    public abstract ContentValues a(T t);

    public abstract HashMap<String, String> b();

    public void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("CREATE TABLE ");
                sb.append(this.f71839a);
                sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
                HashMap<String, String> b2 = b();
                if (b2 != null) {
                    for (String str : b2.keySet()) {
                        sb.append(str);
                        sb.append(" ");
                        sb.append(b2.get(str));
                        sb.append(",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    sQLiteDatabase.execSQL(sb.toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(SQLiteDatabase sQLiteDatabase, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, sQLiteDatabase, t) == null) || sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f71839a, null, a(t));
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }
}
