package com.tachikoma.core.component.switchview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.event.TKEventProcess;
import com.tachikoma.core.event.base.IBaseEvent;
import com.tachikoma.core.event.view.TKSwitchEvent;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes3.dex */
public class TKSwitch extends TKBase<Switch> implements CompoundButton.OnCheckedChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean checked;
    @Nullable
    public Integer mOffTrackColor;
    @Nullable
    public Integer mOnTrackColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKSwitch(Context context, @Nullable List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setColor(Drawable drawable, @Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, drawable, num) == null) {
            if (num == null) {
                drawable.clearColorFilter();
            } else {
                drawable.setColorFilter(num.intValue(), PorterDuff.Mode.MULTIPLY);
            }
        }
    }

    private void setTrackColor(@Nullable Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, num) == null) {
            setColor(getView().getTrackDrawable(), num);
        }
    }

    private void setTrackColor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            setTrackColor(z ? this.mOnTrackColor : this.mOffTrackColor);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public Switch createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new Switch(context) : (Switch) invokeL.objValue;
    }

    public void doChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || getView().isChecked() == z) {
            return;
        }
        getView().setChecked(z);
        setTrackColor(z);
    }

    public boolean getChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.checked : invokeV.booleanValue;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, compoundButton, z) == null) {
            this.checked = z;
            setTrackColor(z);
            dispatchEvent("switch", new TKEventProcess.EventInterface(this, z) { // from class: com.tachikoma.core.component.switchview.TKSwitch.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TKSwitch this$0;
                public final /* synthetic */ boolean val$isChecked;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isChecked = z;
                }

                @Override // com.tachikoma.core.event.TKEventProcess.EventInterface
                public void callBackEvent(IBaseEvent iBaseEvent) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, iBaseEvent) == null) && (iBaseEvent instanceof TKSwitchEvent)) {
                        iBaseEvent.setType("switch");
                        ((TKSwitchEvent) iBaseEvent).setState(this.val$isChecked);
                    }
                }
            });
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCreate();
            getView().setOnCheckedChangeListener(this);
        }
    }

    @Override // com.tachikoma.core.component.TKBase, com.tachikoma.core.common.ILifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            if (getView() != null) {
                getView().setOnCheckedChangeListener(null);
            }
        }
    }

    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.checked = z;
            doChecked(z);
        }
    }

    public void setOffColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mOffTrackColor = Integer.valueOf(i2);
            if (getView().isChecked()) {
                return;
            }
            setTrackColor(Integer.valueOf(i2));
        }
    }

    public void setOnColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mOnTrackColor = Integer.valueOf(i2);
            if (getView().isChecked()) {
                setTrackColor(Integer.valueOf(i2));
            }
        }
    }

    public void setThumbColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            setColor(getView().getThumbDrawable(), Integer.valueOf(i2));
        }
    }
}
