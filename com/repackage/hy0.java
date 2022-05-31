package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.sweetsqlite.BooleanColumn;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class hy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, Class<?>... clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, clsArr) == null) {
            for (Class<?> cls : clsArr) {
                if (cls == obj.getClass()) {
                    return;
                }
            }
            throw new IllegalArgumentException("Expected " + Arrays.toString(clsArr) + ", but got" + obj.getClass().getName());
        }
    }

    public static ContentValues b(Column[] columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, columnArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (Column column : columnArr) {
                if (column.isAssignedValue) {
                    int type = column.type();
                    if (type == 1) {
                        contentValues.put(column.field.b, Integer.valueOf(((BooleanColumn) column).getValue() ? 1 : 0));
                    } else if (type == 2) {
                        contentValues.put(column.field.b, Integer.valueOf(((IntegerColumn) column).getValue()));
                    } else if (type == 3) {
                        contentValues.put(column.field.b, Long.valueOf(((LongColumn) column).getValue()));
                    } else if (type == 4) {
                        contentValues.put(column.field.b, ((StringColumn) column).getValue());
                    } else {
                        throw new IllegalStateException("Unsupported type:" + column.type());
                    }
                }
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static ContentValues c(by0[] by0VarArr, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, by0VarArr, objArr)) == null) {
            if (by0VarArr.length == objArr.length) {
                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < by0VarArr.length; i++) {
                    by0 by0Var = by0VarArr[i];
                    Object obj = objArr[i];
                    int i2 = by0Var.a;
                    if (i2 == 1) {
                        a(obj, Boolean.class);
                        contentValues.put(by0Var.b, Boolean.valueOf(((Boolean) obj).booleanValue()));
                    } else if (i2 == 2) {
                        a(obj, Integer.class, Short.class, Byte.class);
                        contentValues.put(by0Var.b, Integer.valueOf(((Integer) obj).intValue()));
                    } else if (i2 == 3) {
                        a(obj, Long.class, Integer.class, Short.class, Byte.class);
                        contentValues.put(by0Var.b, Long.valueOf(((Long) obj).longValue()));
                    } else if (i2 == 4) {
                        a(obj, String.class, CharSequence.class);
                        contentValues.put(by0Var.b, (String) obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported field type.");
                    }
                }
                return contentValues;
            }
            throw new IllegalArgumentException("invalid columns & values pair.");
        }
        return (ContentValues) invokeLL.objValue;
    }

    public static Column[] d(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ky0Var, by0VarArr)) == null) {
            Column[] columnArr = new Column[by0VarArr.length];
            for (int i = 0; i < by0VarArr.length; i++) {
                columnArr[i] = ky0Var.b().c()[ay0.a(ky0Var.b().d(), by0VarArr[i])];
            }
            return columnArr;
        }
        return (Column[]) invokeLL.objValue;
    }

    public static ContentValues e(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, columnArr)) == null) {
            ContentValues contentValues = new ContentValues(columnArr.length);
            for (Column column : columnArr) {
                if (column.isAssignedValue) {
                    int type = column.type();
                    if (type == 1) {
                        contentValues.put(column.field.b, Integer.valueOf(by0.a(column) ? 1 : 0));
                    } else if (type == 2) {
                        contentValues.put(column.field.b, Integer.valueOf(by0.b(column)));
                    } else if (type == 3) {
                        contentValues.put(column.field.b, Long.valueOf(by0.c(column)));
                    } else if (type == 4) {
                        contentValues.put(column.field.b, by0.d(column));
                    } else {
                        throw new IllegalArgumentException("Unsupported column type.");
                    }
                } else {
                    throw new IllegalArgumentException("All columns must be initialized.");
                }
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static void f(Column column, Column column2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, column, column2) == null) && column.type() == column2.type()) {
            column2.isAssignedValue = column.isAssignedValue;
            int type = column.type();
            if (type == 1) {
                ((BooleanColumn) column2).value = ((BooleanColumn) column).value;
            } else if (type == 2) {
                ((IntegerColumn) column2).value = ((IntegerColumn) column).value;
            } else if (type == 3) {
                ((LongColumn) column2).value = ((LongColumn) column).value;
            } else if (type == 4) {
                ((StringColumn) column2).value = ((StringColumn) column).value;
            } else {
                throw new IllegalStateException("Unsupported type:" + column.type());
            }
        }
    }

    public static boolean g(BooleanColumn booleanColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, booleanColumn, cursor, i)) == null) {
            boolean z = i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i);
            if (z) {
                booleanColumn.setValue(cursor.getInt(i) > 0);
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static void h(Column column, Cursor cursor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, column, cursor, i) == null) {
            int type = column.type();
            if (type == 1) {
                g((BooleanColumn) column, cursor, i);
            } else if (type == 2) {
                i((IntegerColumn) column, cursor, i);
            } else if (type == 3) {
                j((LongColumn) column, cursor, i);
            } else if (type == 4) {
                k((StringColumn) column, cursor, i);
            } else {
                throw new IllegalStateException("Unsupported type:" + column.type());
            }
        }
    }

    public static boolean i(IntegerColumn integerColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, integerColumn, cursor, i)) == null) {
            boolean z = i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i);
            if (z) {
                integerColumn.setValue(cursor.getInt(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean j(LongColumn longColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, longColumn, cursor, i)) == null) {
            boolean z = i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i);
            if (z) {
                longColumn.setValue(cursor.getLong(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean k(StringColumn stringColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, stringColumn, cursor, i)) == null) {
            boolean z = i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i);
            if (z) {
                stringColumn.setValue(cursor.getString(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean l(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, column)) == null) ? column != null && column.field.d == 3 : invokeL.booleanValue;
    }
}
