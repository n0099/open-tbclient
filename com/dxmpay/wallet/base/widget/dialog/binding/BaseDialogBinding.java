package com.dxmpay.wallet.base.widget.dialog.binding;

import android.content.Context;
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
import com.dxmpay.wallet.base.widget.dialog.model.BaseDialogModel;
/* loaded from: classes2.dex */
public class BaseDialogBinding extends BaseBinding<BaseDialogModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View btnLayouts;
    public View btnLine;
    public Button negativeButton;
    public Button positiveButton;
    public TextView titleText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialogBinding(View view) {
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
        this.rootView = view;
        Context context = view.getContext();
        this.context = context;
        this.titleText = (TextView) view.findViewById(ResUtils.id(context, "dialog_title"));
        this.negativeButton = (Button) view.findViewById(ResUtils.id(this.context, "negative_btn"));
        this.positiveButton = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.btnLayouts = view.findViewById(ResUtils.id(this.context, "dialog_btns"));
        this.btnLine = view.findViewById(ResUtils.id(this.context, "btn_line"));
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.viewModel;
            if (((BaseDialogModel) t).dialogBackgound != 0) {
                this.rootView.setBackgroundColor(((BaseDialogModel) t).dialogBackgound);
            }
            T t2 = this.viewModel;
            if (((BaseDialogModel) t2).titleId != 0) {
                this.titleText.setText(((BaseDialogModel) t2).titleId);
            } else if (!TextUtils.isEmpty(((BaseDialogModel) t2).title)) {
                this.titleText.setText(((BaseDialogModel) this.viewModel).title);
            }
            T t3 = this.viewModel;
            if (((BaseDialogModel) t3).positiveBtnTextId != 0) {
                this.positiveButton.setText(((BaseDialogModel) t3).positiveBtnTextId);
            } else if (!TextUtils.isEmpty(((BaseDialogModel) t3).positiveBtnText)) {
                this.positiveButton.setText(((BaseDialogModel) this.viewModel).positiveBtnText);
            }
            T t4 = this.viewModel;
            if (((BaseDialogModel) t4).positiveBtnTextColor != 0) {
                this.positiveButton.setTextColor(((BaseDialogModel) t4).positiveBtnTextColor);
            }
            T t5 = this.viewModel;
            if (((BaseDialogModel) t5).positiveBtnTextSize != 0) {
                this.positiveButton.setTextSize(((BaseDialogModel) t5).positiveBtnTextSize);
            }
            T t6 = this.viewModel;
            if (((BaseDialogModel) t6).negativeBtnTextId != 0) {
                this.negativeButton.setText(((BaseDialogModel) t6).negativeBtnTextId);
            } else if (!TextUtils.isEmpty(((BaseDialogModel) t6).negativeBtnText)) {
                this.negativeButton.setText(((BaseDialogModel) this.viewModel).negativeBtnText);
            }
            T t7 = this.viewModel;
            if (((BaseDialogModel) t7).negativeBtnTextColor != 0) {
                this.positiveButton.setTextColor(((BaseDialogModel) t7).negativeBtnTextColor);
            }
            T t8 = this.viewModel;
            if (((BaseDialogModel) t8).negativeBtnTextSize != 0) {
                this.positiveButton.setTextSize(((BaseDialogModel) t8).negativeBtnTextSize);
            }
            this.positiveButton.setOnClickListener(((BaseDialogModel) this.viewModel).defaultListener);
            this.negativeButton.setOnClickListener(((BaseDialogModel) this.viewModel).defaultListener);
            T t9 = this.viewModel;
            if (((BaseDialogModel) t9).positiveBtnClickListener != null) {
                this.positiveButton.setOnClickListener(((BaseDialogModel) t9).positiveBtnClickListener);
            }
            T t10 = this.viewModel;
            if (((BaseDialogModel) t10).negativeBtnClickListener != null) {
                this.negativeButton.setOnClickListener(((BaseDialogModel) t10).negativeBtnClickListener);
            }
            int i2 = 8;
            this.btnLayouts.setVisibility(((BaseDialogModel) this.viewModel).hideButtons ? 8 : 0);
            this.positiveButton.setVisibility(((BaseDialogModel) this.viewModel).hidePositiveBtn ? 8 : 0);
            this.negativeButton.setVisibility(((BaseDialogModel) this.viewModel).hideNegativeBtn ? 8 : 0);
            this.titleText.setVisibility(((BaseDialogModel) this.viewModel).hideTitle ? 8 : 0);
            if (((BaseDialogModel) this.viewModel).positiveBtnTextBold && (paint2 = this.positiveButton.getPaint()) != null) {
                paint2.setFakeBoldText(true);
            }
            T t11 = this.viewModel;
            if (((BaseDialogModel) t11).hidePositiveBtn) {
                if (((BaseDialogModel) t11).negativeBtnTextBold && (paint = this.negativeButton.getPaint()) != null) {
                    paint.setFakeBoldText(true);
                }
                Button button = this.negativeButton;
                button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "dxm_wallet_base_dialog_btn_selector"));
            } else if (((BaseDialogModel) t11).hideNegativeBtn) {
                Button button2 = this.positiveButton;
                button2.setBackgroundDrawable(ResUtils.getDrawable(button2.getContext(), "dxm_wallet_base_dialog_btn_selector"));
            }
            View view = this.btnLine;
            T t12 = this.viewModel;
            if (!((BaseDialogModel) t12).hideNegativeBtn && !((BaseDialogModel) t12).hidePositiveBtn) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
    }
}
