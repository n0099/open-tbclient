package d.a.q0.z3;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends TimePickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f67413e;

    /* renamed from: f  reason: collision with root package name */
    public int f67414f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67415g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z) {
        super(context, onTimeSetListener, i2, i3, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onTimeSetListener, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (TimePickerDialog.OnTimeSetListener) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67413e = -1;
        this.f67414f = -1;
        this.f67415g = false;
        this.f67413e = i2;
        this.f67414f = i3;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
            if (i2 == -1) {
                this.f67415g = true;
            } else {
                int i4 = this.f67413e;
                if (i4 >= 0 && (i3 = this.f67414f) >= 0) {
                    updateTime(i4, i3);
                }
            }
            super.onClick(dialogInterface, i2);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            updateTime(0, 0);
            this.f67413e = bundle.getInt("hour_key");
            int i2 = bundle.getInt("min_key");
            this.f67414f = i2;
            updateTime(this.f67413e, i2);
        }
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                bundle = super.onSaveInstanceState();
            } catch (Exception unused) {
                bundle = null;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("hour_key", this.f67413e);
            bundle.putInt("min_key", this.f67414f);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f67415g) {
                updateTime(this.f67413e, this.f67414f);
            }
            super.onStop();
        }
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.updateTime(i2, i3);
            this.f67413e = i2;
            this.f67414f = i3;
            this.f67415g = false;
        }
    }
}
