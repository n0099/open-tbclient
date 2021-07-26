package d.a.o0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends b<d.a.o0.n.h.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // d.a.o0.n.g.c.b
    public List<d.a.o0.n.h.d> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return arrayList;
            }
            do {
                d.a.o0.n.h.d dVar = new d.a.o0.n.h.d();
                if (b(cursor, dVar)) {
                    arrayList.add(dVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(d.a.o0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) ? a(dVar) : (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.g.c.b
    /* renamed from: g */
    public d.a.o0.n.h.d d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            d.a.o0.n.h.d dVar = new d.a.o0.n.h.d();
            if (b(cursor, dVar)) {
                return dVar;
            }
            return null;
        }
        return (d.a.o0.n.h.d) invokeL.objValue;
    }
}
