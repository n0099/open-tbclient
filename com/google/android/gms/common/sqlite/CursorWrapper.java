package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractWindowedCursor zza;

    @Override // android.database.CursorWrapper
    @NonNull
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.zza;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @KeepForSdk
    public CursorWrapper(@NonNull Cursor cursor) {
        super(cursor);
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Cursor) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        for (int i3 = 0; i3 < 10 && (cursor instanceof android.database.CursorWrapper); i3++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor.getClass().getName());
            if (valueOf.length() != 0) {
                str = "Unknown type: ".concat(valueOf);
            } else {
                str = new String("Unknown type: ");
            }
            throw new IllegalArgumentException(str);
        }
        this.zza = (AbstractWindowedCursor) cursor;
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, @NonNull CursorWindow cursorWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, cursorWindow) == null) {
            this.zza.fillWindow(i, cursorWindow);
        }
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return this.zza.onMove(i, i2);
        }
        return invokeII.booleanValue;
    }

    @Override // android.database.CrossProcessCursor
    @Nullable
    @KeepForSdk
    public CursorWindow getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.zza.getWindow();
        }
        return (CursorWindow) invokeV.objValue;
    }

    @KeepForSdk
    public void setWindow(@Nullable CursorWindow cursorWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cursorWindow) == null) {
            this.zza.setWindow(cursorWindow);
        }
    }
}
