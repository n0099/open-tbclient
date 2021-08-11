package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.TipDialogModel;
/* loaded from: classes9.dex */
public class TipDialogBinding extends BaseBinding<TipDialogModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f69369a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f69370b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f69371c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipDialogBinding(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.f69369a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f69370b = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.f69371c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.viewModel;
            if (((TipDialogModel) t).btnTextId != 0) {
                this.f69370b.setText(((TipDialogModel) t).btnTextId);
            } else if (!TextUtils.isEmpty(((TipDialogModel) t).btnText)) {
                this.f69370b.setText(((TipDialogModel) this.viewModel).btnText);
            }
            T t2 = this.viewModel;
            if (((TipDialogModel) t2).titleId != 0) {
                this.f69369a.setText(((TipDialogModel) t2).titleId);
            } else if (!TextUtils.isEmpty(((TipDialogModel) t2).titleText)) {
                this.f69369a.setText(((TipDialogModel) this.viewModel).titleText);
            }
            TextPaint paint = this.f69370b.getPaint();
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
            this.f69370b.setOnClickListener(((TipDialogModel) this.viewModel).defaultClickListener);
            T t3 = this.viewModel;
            if (((TipDialogModel) t3).messageId != 0) {
                this.f69371c.setText(((TipDialogModel) t3).messageId);
            } else if (TextUtils.isEmpty(((TipDialogModel) t3).message)) {
            } else {
                this.f69371c.setText(((TipDialogModel) this.viewModel).message);
            }
        }
    }
}
