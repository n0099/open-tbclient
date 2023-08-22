package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Builder BUILDER;
    public static final Parcelable.Creator<DataHolder> CREATOR;
    public static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    public transient /* synthetic */ FieldHolder $fh;
    public String[] columns;
    public Bundle columnsBundle;
    public CursorWindow[] cursorWindows;
    public int dataCount;
    public boolean isInstance;
    public boolean mClosed;
    public Bundle metadata;
    public int[] perCursorCounts;
    public int statusCode;
    public int version;

    /* renamed from: com.huawei.hms.common.data.DataHolder$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] builderColumns;
        public final ArrayList<HashMap<String, Object>> dataCollectionList;
        public final String type;
        public final HashMap<Object, Integer> typeAndDataCollectionCountMapping;

        public Builder(String[] strArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.builderColumns = strArr;
            this.dataCollectionList = new ArrayList<>();
            this.type = str;
            this.typeAndDataCollectionCountMapping = new HashMap<>();
        }

        public /* synthetic */ Builder(String[] strArr, String str, AnonymousClass1 anonymousClass1) {
            this(strArr, str);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, str, dataHolderBuilderCreator};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String[]) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public DataHolder build(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return new DataHolder(this, i, (Bundle) null, (AnonymousClass1) null);
            }
            return (DataHolder) invokeI.objValue;
        }

        public DataHolder build(int i, Bundle bundle) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bundle)) == null) {
                return new DataHolder(this, i, bundle, -1, (AnonymousClass1) null);
            }
            return (DataHolder) invokeIL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder setDataForContentValuesHashMap(HashMap<String, Object> hashMap) {
            InterceptResult invokeL;
            int i;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
                Preconditions.checkNotNull(hashMap, "contentValuesHashMap cannot be null");
                String str = this.type;
                boolean z = false;
                if (str != null && (obj = hashMap.get(str)) != null) {
                    Integer num = this.typeAndDataCollectionCountMapping.get(obj);
                    if (num != null) {
                        i = num.intValue();
                        z = true;
                        if (!z) {
                            this.dataCollectionList.remove(i);
                            this.dataCollectionList.add(i, hashMap);
                        } else {
                            this.dataCollectionList.add(hashMap);
                        }
                        return this;
                    }
                    this.typeAndDataCollectionCountMapping.put(obj, Integer.valueOf(this.dataCollectionList.size()));
                }
                i = 0;
                if (!z) {
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder withRow(ContentValues contentValues) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, contentValues)) == null) {
                Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
                HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
                return setDataForContentValuesHashMap(hashMap);
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class DataHolderException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DataHolderException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(292692245, "Lcom/huawei/hms/common/data/DataHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(292692245, "Lcom/huawei/hms/common/data/DataHolder;");
                return;
            }
        }
        CREATOR = new DataHolderCreator();
        BUILDER = new DataHolderBuilderCreator(new String[0], null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.mClosed) {
                    for (CursorWindow cursorWindow : this.cursorWindows) {
                        cursorWindow.close();
                    }
                    this.mClosed = true;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
                close();
            }
            super.finalize();
        }
    }

    public final int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.dataCount;
        }
        return invokeV.intValue;
    }

    public final Bundle getMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.metadata;
        }
        return (Bundle) invokeV.objValue;
    }

    public final int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.statusCode;
        }
        return invokeV.intValue;
    }

    public final synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                z = this.mClosed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), strArr, cursorWindowArr, Integer.valueOf(i2), bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor, Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((HMSCursorWrapper) objArr2[0], ((Integer) objArr2[1]).intValue(), (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, hMSCursorWrapper, i, i2)) == null) {
            ArrayList<CursorWindow> arrayList = new ArrayList<>();
            while (i < i2 && hMSCursorWrapper.moveToPosition(i)) {
                CursorWindow window = hMSCursorWrapper.getWindow();
                if (window == null) {
                    window = new CursorWindow((String) null);
                    window.setStartPosition(i);
                    hMSCursorWrapper.fillWindow(i, window);
                } else {
                    window.acquireReference();
                    hMSCursorWrapper.setWindow(null);
                }
                if (window.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window);
                i = window.getNumRows() + window.getStartPosition();
            }
            return arrayList;
        }
        return (ArrayList) invokeLII.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.builderColumns, getCursorWindows(builder, -1), i, (Bundle) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], (CursorWindow[]) objArr2[1], ((Integer) objArr2[2]).intValue(), (Bundle) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.builderColumns, getCursorWindows(builder, -1), i, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Integer.valueOf(i), bundle, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], (CursorWindow[]) objArr2[1], ((Integer) objArr2[2]).intValue(), (Bundle) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, int i2, AnonymousClass1 anonymousClass1) {
        this(builder, i, bundle, i2);
    }

    public /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, AnonymousClass1 anonymousClass1) {
        this(builder, i, bundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataHolder(HMSCursorWrapper hMSCursorWrapper, int i, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hMSCursorWrapper, Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], (CursorWindow[]) objArr2[1], ((Integer) objArr2[2]).intValue(), (Bundle) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, cursorWindowArr, Integer.valueOf(i), bundle};
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public static Builder builder(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, strArr)) == null) {
            return new Builder(strArr, (String) null, (AnonymousClass1) null);
        }
        return (Builder) invokeL.objValue;
    }

    public static DataHolder empty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            return new DataHolder(BUILDER, i, (Bundle) null);
        }
        return (DataHolder) invokeI.objValue;
    }

    public final boolean hasColumn(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.columnsBundle.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    private void checkAvailable(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, str, i) == null) {
            Bundle bundle = this.columnsBundle;
            if (bundle != null && bundle.containsKey(str)) {
                if (isClosed()) {
                    str2 = "buffer has been closed";
                } else if (i >= 0 && i < this.dataCount) {
                    str2 = "";
                } else {
                    str2 = "row is out of index:" + i;
                }
            } else {
                str2 = "cannot find column: " + str;
            }
            Preconditions.checkArgument(str2.isEmpty(), str2);
        }
    }

    public static CursorWindow[] getCursorWindows(Builder builder, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, builder, i)) == null) {
            if (builder.builderColumns.length == 0) {
                return new CursorWindow[0];
            }
            if (i < 0 || i >= builder.dataCollectionList.size()) {
                i = builder.dataCollectionList.size();
            }
            ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder, i, builder.dataCollectionList.subList(0, i));
            return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
        }
        return (CursorWindow[]) invokeLI.objValue;
    }

    public static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, hMSCursorWrapper)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                int count = hMSCursorWrapper.getCount();
                CursorWindow window = hMSCursorWrapper.getWindow();
                if (window != null && window.getStartPosition() == 0) {
                    window.acquireReference();
                    hMSCursorWrapper.setWindow(null);
                    arrayList.add(window);
                    i = window.getNumRows();
                } else {
                    i = 0;
                }
                arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i, count));
                return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
            } catch (Throwable th) {
                try {
                    HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                    return new CursorWindow[0];
                } finally {
                    hMSCursorWrapper.close();
                }
            }
        }
        return (CursorWindow[]) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i, List list) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65550, null, builder, i, list)) == null) {
            ArrayList<CursorWindow> arrayList = new ArrayList<>();
            CursorWindow cursorWindow = new CursorWindow((String) null);
            cursorWindow.setNumColumns(builder.builderColumns.length);
            arrayList.add(cursorWindow);
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                try {
                    if (!cursorWindow.allocRow()) {
                        HMSLog.d(TAG, "Failed to allocate a row");
                        cursorWindow = new CursorWindow((String) null);
                        cursorWindow.setStartPosition(i2);
                        cursorWindow.setNumColumns(builder.builderColumns.length);
                        if (!cursorWindow.allocRow()) {
                            HMSLog.e(TAG, "Failed to retry to allocate a row");
                            return arrayList;
                        }
                        arrayList.add(cursorWindow);
                    }
                    HashMap hashMap = (HashMap) list.get(i2);
                    boolean z = true;
                    for (int i3 = 0; i3 < builder.builderColumns.length && (z = putValue(cursorWindow, hashMap.get(builder.builderColumns[i3]), i2, i3)); i3++) {
                    }
                    if (!z) {
                        HMSLog.d(TAG, "fail to put data for row " + i2);
                        cursorWindow.freeLastRow();
                        CursorWindow cursorWindow2 = new CursorWindow((String) null);
                        cursorWindow2.setStartPosition(i2);
                        cursorWindow2.setNumColumns(builder.builderColumns.length);
                        arrayList.add(cursorWindow2);
                        break;
                    }
                    i2++;
                } catch (RuntimeException e) {
                    Iterator<CursorWindow> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().close();
                    }
                    throw e;
                }
            }
        } else {
            return (ArrayList) invokeLIL.objValue;
        }
    }

    public static boolean putValue(CursorWindow cursorWindow, Object obj, int i, int i2) throws IllegalArgumentException {
        InterceptResult invokeLLII;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65552, null, cursorWindow, obj, i, i2)) == null) {
            if (obj == null) {
                return cursorWindow.putNull(i, i2);
            }
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    j = 1;
                } else {
                    j = 0;
                }
                return cursorWindow.putLong(j, i, i2);
            } else if (obj instanceof Integer) {
                return cursorWindow.putLong(((Integer) obj).intValue(), i, i2);
            } else {
                if (obj instanceof Long) {
                    return cursorWindow.putLong(((Long) obj).longValue(), i, i2);
                }
                if (obj instanceof Float) {
                    return cursorWindow.putDouble(((Float) obj).floatValue(), i, i2);
                }
                if (obj instanceof Double) {
                    return cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
                }
                if (obj instanceof String) {
                    return cursorWindow.putString((String) obj, i, i2);
                }
                if (obj instanceof byte[]) {
                    return cursorWindow.putBlob((byte[]) obj, i, i2);
                }
                throw new IllegalArgumentException("unsupported type for column: " + obj);
            }
        }
        return invokeLLII.booleanValue;
    }

    public final void collectColumsAndCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.columnsBundle = new Bundle();
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = this.columns;
                if (i2 >= strArr.length) {
                    break;
                }
                this.columnsBundle.putInt(strArr[i2], i2);
                i2++;
            }
            this.perCursorCounts = new int[this.cursorWindows.length];
            int i3 = 0;
            while (true) {
                CursorWindow[] cursorWindowArr = this.cursorWindows;
                if (i < cursorWindowArr.length) {
                    this.perCursorCounts[i] = i3;
                    i3 = cursorWindowArr[i].getStartPosition() + this.cursorWindows[i].getNumRows();
                    i++;
                } else {
                    this.dataCount = i3;
                    return;
                }
            }
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), charArrayBuffer}) == null) {
            checkAvailable(str, i);
            this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Object getValue(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            boolean z = true;
            switch (str2.hashCode()) {
                case -1092271849:
                    if (str2.equals(TYPE_FLOAT)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -870070237:
                    if (str2.equals(TYPE_BOOLEAN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -675993238:
                    if (str2.equals(TYPE_INT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 445002870:
                    if (str2.equals(TYPE_DOUBLE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 519136353:
                    if (str2.equals(TYPE_LONG)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 878975158:
                    if (str2.equals(TYPE_STRING)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1300508295:
                    if (str2.equals(TYPE_BYTE_ARRAY)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    checkAvailable(str, i);
                    return Integer.valueOf(this.cursorWindows[i2].getInt(i, this.columnsBundle.getInt(str)));
                case 1:
                    checkAvailable(str, i);
                    return Long.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)));
                case 2:
                    checkAvailable(str, i);
                    return this.cursorWindows[i2].getString(i, this.columnsBundle.getInt(str));
                case 3:
                    checkAvailable(str, i);
                    if (this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)) != 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 4:
                    checkAvailable(str, i);
                    return Float.valueOf(this.cursorWindows[i2].getFloat(i, this.columnsBundle.getInt(str)));
                case 5:
                    checkAvailable(str, i);
                    return Double.valueOf(this.cursorWindows[i2].getDouble(i, this.columnsBundle.getInt(str)));
                case 6:
                    checkAvailable(str, i);
                    return this.cursorWindows[i2].getBlob(i, this.columnsBundle.getInt(str));
                default:
                    return null;
            }
        }
        return invokeCommon.objValue;
    }

    public final int getWindowIndex(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int i2 = 0;
            if (i < 0 && i >= this.dataCount) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "rowIndex is out of index:" + i);
            while (true) {
                int[] iArr = this.perCursorCounts;
                if (i2 >= iArr.length) {
                    break;
                } else if (i < iArr[i2]) {
                    i2--;
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == this.perCursorCounts.length) {
                return i2 - 1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final boolean hasNull(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048586, this, str, i, i2)) == null) {
            checkAvailable(str, i);
            if (this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0) {
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, parcel, i) == null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
            SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
            SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
            SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
            SafeParcelWriter.writeInt(parcel, 1000, this.version);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            if ((i & 1) != 0) {
                close();
            }
        }
    }
}
