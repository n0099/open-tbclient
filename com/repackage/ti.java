package com.repackage;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qe;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class ti {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<qe.b<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(qe.b<?> bVar, qe.b<?> bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) {
                long j = bVar.c;
                long j2 = bVar2.c;
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
    public static List<qe.b<byte[]>> a(qe<byte[]> qeVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qeVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(qeVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    qe.b bVar = new qe.b();
                    bVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.b = cursor.getBlob(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        lg.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        lg.a(cursor);
                    }
                }
            }
            lg.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.String] */
    public static List<qe.b<String>> b(qe<String> qeVar) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qeVar)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = c(qeVar);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                return null;
            }
            while (cursor.moveToNext()) {
                try {
                    qe.b bVar = new qe.b();
                    bVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                    bVar.c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    bVar.b = cursor.getString(cursor.getColumnIndex("m_value"));
                    linkedList.add(bVar);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        BdLog.e(th);
                        lg.a(cursor);
                        Collections.sort(linkedList, new b(null));
                        return linkedList;
                    } finally {
                        lg.a(cursor);
                    }
                }
            }
            lg.a(cursor);
            Collections.sort(linkedList, new b(null));
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static Cursor c(qe<?> qeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qeVar)) == null) {
            if (qeVar != null && (qeVar instanceof qe.c)) {
                qe.c cVar = (qe.c) qeVar;
                if (cVar.c() instanceof oe) {
                    he n = ((oe) cVar.c()).n();
                    return n.q(n.h().f(), cVar.j());
                }
                return null;
            }
            return null;
        }
        return (Cursor) invokeL.objValue;
    }
}
