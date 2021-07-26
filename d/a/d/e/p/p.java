package d.a.d.e.p;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<l.b<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(l.b<?> bVar, l.b<?> bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) {
                long j = bVar.f41628c;
                long j2 = bVar2.f41628c;
                if (j == j2) {
                    return 0;
                }
                return j > j2 ? -1 : 1;
            }
            return invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, byte[]] */
    public static List<l.b<byte[]>> a(d.a.d.e.d.l<byte[]> lVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(lVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    l.b bVar = new l.b();
                    bVar.f41626a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.f41628c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.f41627b = cursor.getBlob(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        d.a.d.e.m.a.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        d.a.d.e.m.a.a(cursor);
                    }
                }
            }
            d.a.d.e.m.a.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.String] */
    public static List<l.b<String>> b(d.a.d.e.d.l<String> lVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(lVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    l.b bVar = new l.b();
                    bVar.f41626a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.f41628c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.f41627b = cursor.getString(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        d.a.d.e.m.a.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        d.a.d.e.m.a.a(cursor);
                    }
                }
            }
            d.a.d.e.m.a.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static Cursor c(d.a.d.e.d.l<?> lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            if (lVar != null && (lVar instanceof l.c)) {
                l.c cVar = (l.c) lVar;
                if (cVar.c() instanceof d.a.d.e.d.j) {
                    d.a.d.e.d.c n = ((d.a.d.e.d.j) cVar.c()).n();
                    return n.q(n.h().f(), cVar.j());
                }
                return null;
            }
            return null;
        }
        return (Cursor) invokeL.objValue;
    }
}
