package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k65 extends a65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public EMTextView b;
    public EMTextView c;
    public TBSpecificationBtn d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k65(Context context) {
        super(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d054a, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view2 = this.attachedView) == null) {
            return;
        }
        this.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091415);
        EMTextView eMTextView = (EMTextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091416);
        this.b = eMTextView;
        eMTextView.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0a57));
        EMTextView eMTextView2 = (EMTextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091414);
        this.c = eMTextView2;
        eMTextView2.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0a56));
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09140b);
        this.d = tBSpecificationBtn;
        tBSpecificationBtn.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0980));
        this.d.setTextSize(R.dimen.T_X05);
        this.d.setConfig(new ov4());
    }

    public void b(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || (tBSpecificationBtn = this.d) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ms4 d = ms4.d(this.b);
            d.z(R.dimen.T_X06);
            d.v(R.color.CAM_X0107);
            ms4 d2 = ms4.d(this.c);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0108);
            WebPManager.setMaskDrawable(this.a, R.drawable.obfuscated_res_0x7f080e2e, null);
            TBSpecificationBtn tBSpecificationBtn = this.d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // com.repackage.a65
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }
}
