package d.a.q0.s.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.e.p.m;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f62604a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (h.class) {
                m.b(f62604a);
            }
        }
    }

    public static synchronized SQLiteDatabase b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (h.class) {
                try {
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                if (f62604a != null && f62604a.isOpen()) {
                    return f62604a;
                }
                f62604a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                return f62604a;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
