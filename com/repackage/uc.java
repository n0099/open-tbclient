package com.repackage;

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
/* loaded from: classes7.dex */
public class uc implements vc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Cursor a;
    public final ContentValues b;
    public final Set<String> c;

    public uc(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cursor;
        this.b = null;
        this.c = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i3 = 0; i3 < columnCount; i3++) {
                String columnName = cursor.getColumnName(i3);
                if (columnName != null) {
                    this.c.add(columnName);
                }
            }
        }
    }

    @Override // com.repackage.vc
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) || str == null) {
            return;
        }
        if (obj == null) {
            this.b.putNull(str);
        } else if (obj.getClass() != Boolean.TYPE && obj.getClass() != Boolean.class) {
            if (obj.getClass() != Byte.TYPE && obj.getClass() != Byte.class) {
                if (obj.getClass() == byte[].class) {
                    this.b.put(str, (byte[]) obj);
                    return;
                } else if (obj.getClass() != Double.TYPE && obj.getClass() != Double.class) {
                    if (obj.getClass() != Float.TYPE && obj.getClass() != Float.class) {
                        if (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class) {
                            if (obj.getClass() != Long.TYPE && obj.getClass() != Long.class) {
                                if (obj.getClass() != Short.TYPE && obj.getClass() != Short.class) {
                                    if (obj.getClass() == String.class) {
                                        this.b.put(str, (String) obj);
                                        return;
                                    }
                                    return;
                                }
                                this.b.put(str, (Short) obj);
                                return;
                            }
                            this.b.put(str, (Long) obj);
                            return;
                        }
                        this.b.put(str, (Integer) obj);
                        return;
                    }
                    this.b.put(str, (Float) obj);
                    return;
                } else {
                    this.b.put(str, (Double) obj);
                    return;
                }
            }
            this.b.put(str, (Byte) obj);
        } else {
            this.b.put(str, (Boolean) obj);
        }
    }

    @Override // com.repackage.vc
    public Object b(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, type)) == null) {
            Object c = c(str);
            if (c != null) {
                yd ydVar = new yd(type);
                id a = ce.a(c);
                return a != null ? a.a(ydVar) : c;
            }
            return c;
        }
        return invokeLL.objValue;
    }

    public Object c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int columnIndex = this.a.getColumnIndex(str);
            Object obj = null;
            if (columnIndex <= 0 || columnIndex >= this.a.getColumnCount()) {
                return null;
            }
            try {
                obj = Short.valueOf(this.a.getShort(columnIndex));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (obj == null) {
                try {
                    obj = Integer.valueOf(this.a.getInt(columnIndex));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Long.valueOf(this.a.getLong(columnIndex));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Float.valueOf(this.a.getFloat(columnIndex));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = Double.valueOf(this.a.getDouble(columnIndex));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    obj = this.a.getString(columnIndex);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (obj == null) {
                try {
                    return this.a.getBlob(columnIndex);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return obj;
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    @Override // com.repackage.vc
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (Set) invokeV.objValue;
    }

    public uc(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = contentValues;
        this.c = new TreeSet();
    }
}
