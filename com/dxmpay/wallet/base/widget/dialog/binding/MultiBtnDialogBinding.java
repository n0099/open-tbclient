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
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;
/* loaded from: classes11.dex */
public class MultiBtnDialogBinding extends BaseBinding<MultiBtnDialogModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f62513a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f62514b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f62515c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f62516d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f62517e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiBtnDialogBinding(View view) {
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
        this.f62513a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f62514b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f62515c = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.f62516d = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.f62517e = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    @Override // com.dxmpay.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            T t = this.viewModel;
            if (((MultiBtnDialogModel) t).titleId != 0) {
                this.f62513a.setText(((MultiBtnDialogModel) t).titleId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
                this.f62513a.setText(((MultiBtnDialogModel) this.viewModel).titleText);
            }
            T t2 = this.viewModel;
            if (((MultiBtnDialogModel) t2).messageId != 0) {
                this.f62514b.setText(((MultiBtnDialogModel) t2).messageId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
                this.f62514b.setText(((MultiBtnDialogModel) this.viewModel).message);
            }
            this.f62515c.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            this.f62516d.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            this.f62517e.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
            T t3 = this.viewModel;
            if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
                this.f62515c.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
            }
            T t4 = this.viewModel;
            if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
                this.f62516d.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
            }
            T t5 = this.viewModel;
            if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
                this.f62517e.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
            }
            T t6 = this.viewModel;
            if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
                this.f62515c.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
                this.f62515c.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
            }
            T t7 = this.viewModel;
            if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
                this.f62516d.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
                this.f62516d.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
            }
            T t8 = this.viewModel;
            if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
                this.f62517e.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
            } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
                this.f62517e.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
            }
            if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f62515c.getPaint()) != null) {
                paint3.setFakeBoldText(true);
            }
            if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.f62516d.getPaint()) != null) {
                paint2.setFakeBoldText(true);
            }
            if (!((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold || (paint = this.f62517e.getPaint()) == null) {
                return;
            }
            paint.setFakeBoldText(true);
        }
    }
}
