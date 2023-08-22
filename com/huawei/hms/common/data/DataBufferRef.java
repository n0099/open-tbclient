package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
/* loaded from: classes10.dex */
public class DataBufferRef {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataHolder mDataHolder;
    public int mDataRow;
    public int windowIndex;

    public DataBufferRef(DataHolder dataHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataHolder, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i);
    }

    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, charArrayBuffer) == null) {
            this.mDataHolder.copyToBuffer(str, this.mDataRow, this.windowIndex, charArrayBuffer);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof DataBufferRef)) {
                return false;
            }
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (dataBufferRef.mDataRow != this.mDataRow || dataBufferRef.windowIndex != this.windowIndex || dataBufferRef.mDataHolder != this.mDataHolder) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean getBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BOOLEAN);
            if (value != null) {
                return ((Boolean) value).booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public byte[] getByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_BYTE_ARRAY);
            if (value != null) {
                return (byte[]) value;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public double getDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_DOUBLE);
            if (value != null) {
                return ((Double) value).doubleValue();
            }
            return -1.0d;
        }
        return invokeL.doubleValue;
    }

    public float getFloat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_FLOAT);
            if (value != null) {
                return ((Float) value).floatValue();
            }
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    public int getInteger(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_INT);
            if (value != null) {
                return ((Integer) value).intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_LONG);
            if (value != null) {
                return ((Long) value).longValue();
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
            if (value != null) {
                return (String) value;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void getWindowIndex(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i >= 0 && i < this.mDataHolder.getCount()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "rowNum is out of index");
            this.mDataRow = i;
            this.windowIndex = this.mDataHolder.getWindowIndex(i);
        }
    }

    public boolean hasColumn(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return this.mDataHolder.hasColumn(str);
        }
        return invokeL.booleanValue;
    }

    public boolean hasNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return this.mDataHolder.hasNull(str, this.mDataRow, this.windowIndex);
        }
        return invokeL.booleanValue;
    }

    public Uri parseUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, DataHolder.TYPE_STRING);
            if (str2 == null) {
                return null;
            }
            return Uri.parse(str2);
        }
        return (Uri) invokeL.objValue;
    }

    public int getDataRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDataRow;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.windowIndex), this.mDataHolder);
        }
        return invokeV.intValue;
    }

    public boolean isDataValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return !this.mDataHolder.isClosed();
        }
        return invokeV.booleanValue;
    }
}
