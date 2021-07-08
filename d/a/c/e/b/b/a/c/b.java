package d.a.c.e.b.b.a.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes6.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Cursor f41049a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentValues f41050b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f41051c;

    public b(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41049a = cursor;
        this.f41050b = null;
        this.f41051c = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i4 = 0; i4 < columnCount; i4++) {
                String columnName = cursor.getColumnName(i4);
                if (columnName != null) {
                    this.f41051c.add(columnName);
                }
            }
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41051c : (Set) invokeV.objValue;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) || str == null) {
            return;
        }
        if (obj == null) {
            this.f41050b.putNull(str);
        } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
            if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                if (obj.getClass() == byte[].class) {
                    this.f41050b.put(str, (byte[]) obj);
                    return;
                } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                    if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                        if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                            if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                    if (obj.getClass() == String.class) {
                                        this.f41050b.put(str, (String) obj);
                                        return;
                                    }
                                    return;
                                }
                                this.f41050b.put(str, (Short) obj);
                                return;
                            }
                            this.f41050b.put(str, (Long) obj);
                            return;
                        }
                        this.f41050b.put(str, (Integer) obj);
                        return;
                    }
                    this.f41050b.put(str, (Float) obj);
                    return;
                } else {
                    this.f41050b.put(str, (Double) obj);
                    return;
                }
            }
            this.f41050b.put(str, (Byte) obj);
        } else {
            this.f41050b.put(str, (Boolean) obj);
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
                d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
                return a2 != null ? a2.a(cVar) : d2;
            }
            return d2;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int columnIndex = this.f41049a.getColumnIndex(str);
            Object obj = null;
            if (columnIndex <= 0 || columnIndex >= this.f41049a.getColumnCount()) {
                return null;
            }
            try {
                obj = Short.valueOf(this.f41049a.getShort(columnIndex));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (obj == null) {
                try {
                    obj = Integer.valueOf(this.f41049a.getInt(columnIndex));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Long.valueOf(this.f41049a.getLong(columnIndex));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Float.valueOf(this.f41049a.getFloat(columnIndex));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Double.valueOf(this.f41049a.getDouble(columnIndex));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = this.f41049a.getString(columnIndex);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    return this.f41049a.getBlob(columnIndex);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return obj;
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public b(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41050b = contentValues;
        this.f41051c = new TreeSet();
    }
}
