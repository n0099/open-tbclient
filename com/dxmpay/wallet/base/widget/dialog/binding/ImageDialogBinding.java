package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ImageDialogModel;
/* loaded from: classes9.dex */
public class ImageDialogBinding extends BaseBinding<ImageDialogModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f69558a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f69559b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f69560c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f69561d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f69562e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageDialogBinding(View view) {
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
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.f69562e = textView;
        textView.setVisibility(8);
        this.f69558a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.f69559b = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.f69560c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f69561d = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.viewModel;
            if (((ImageDialogModel) t).messageId != 0) {
                this.f69558a.setText(((ImageDialogModel) t).messageId);
            } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
                this.f69558a.setText(((ImageDialogModel) this.viewModel).message);
            }
            T t2 = this.viewModel;
            if (((ImageDialogModel) t2).messageTempId != 0) {
                this.f69562e.setVisibility(0);
                this.f69562e.setText(((ImageDialogModel) this.viewModel).messageTempId);
            } else if (((ImageDialogModel) t2).messageTemp != null) {
                this.f69562e.setVisibility(0);
                this.f69562e.setText(((ImageDialogModel) this.viewModel).messageTemp);
            }
            T t3 = this.viewModel;
            if (((ImageDialogModel) t3).buttonTextId != 0) {
                this.f69561d.setText(((ImageDialogModel) t3).buttonTextId);
            } else if (((ImageDialogModel) t3).buttonText != null) {
                this.f69561d.setText(((ImageDialogModel) t3).buttonText);
            }
            T t4 = this.viewModel;
            if (((ImageDialogModel) t4).imageId != 0) {
                this.f69559b.setImageResource(((ImageDialogModel) t4).imageId);
            } else if (((ImageDialogModel) t4).imageDrawable != null) {
                this.f69559b.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
            }
            T t5 = this.viewModel;
            if (((ImageDialogModel) t5).titleTextId != 0) {
                this.f69560c.setText(((ImageDialogModel) t5).titleTextId);
            } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
                this.f69560c.setText(((ImageDialogModel) this.viewModel).titleText);
            }
            TextPaint paint = this.f69561d.getPaint();
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
            this.f69561d.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
        }
    }
}
