package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.BaseDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.BaseDialogModel;
/* loaded from: classes9.dex */
public class BaseAdapter extends WalletDialog.Adapter<BaseHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseDialogModel f69575a;

    /* loaded from: classes9.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BaseDialogBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseHolder(BaseAdapter baseAdapter, BaseDialogBinding baseDialogBinding) {
            super(baseDialogBinding.rootView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdapter, baseDialogBinding};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.binding = baseDialogBinding;
        }
    }

    public BaseAdapter(BaseDialogModel baseDialogModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseDialogModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69575a = baseDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.dxmpay.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseHolder) == null) {
            baseHolder.binding.setViewModel(this.f69575a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.dxmpay.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new BaseHolder(this, new BaseDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_common_dialog"), (ViewGroup) null))) : (BaseHolder) invokeL.objValue;
    }
}
