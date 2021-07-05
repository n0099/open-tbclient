package d.a.q0.a.j0.b;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Uri f48983a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_behavior(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,launch_type INT NOT NULL,source varchar(100),ext TEXT,time BIGINT);");
            } catch (Exception e2) {
                d.a.q0.a.e0.d.c("SwanLaunchBehaviorTable", "createTable", e2);
            }
        }
    }

    @NonNull
    public static synchronized Uri b() {
        InterceptResult invokeV;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (d.class) {
                if (f48983a == null) {
                    f48983a = b.f48981c.buildUpon().appendPath("user_behavior").build();
                }
                uri = f48983a;
            }
            return uri;
        }
        return (Uri) invokeV.objValue;
    }
}
