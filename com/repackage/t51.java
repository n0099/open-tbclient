package com.repackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mn0;
/* loaded from: classes7.dex */
public class t51 extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final b a;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t51 a;

        public a(t51 t51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t51Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a.a(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t51(Context context, @NonNull AdBaseModel adBaseModel, @NonNull b bVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c(adBaseModel);
        this.a = bVar;
    }

    public final void b(AdBaseModel adBaseModel) {
        mn0 mn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            mn0.b bVar = (adBaseModel == null || (mn0Var = adBaseModel.p) == null) ? null : mn0Var.f;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f8, (ViewGroup) null);
            String string = (bVar == null || TextUtils.isEmpty(bVar.a)) ? getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bde) : bVar.a;
            String string2 = (bVar == null || TextUtils.isEmpty(bVar.b)) ? getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bdd) : bVar.b;
            String string3 = (bVar == null || TextUtils.isEmpty(bVar.c)) ? getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bdc) : bVar.c;
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915e6)).setText(string);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915e7);
            textView.setText(string2);
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915e5);
            textView2.setText(string3);
            textView2.setOnClickListener(this);
            setContentView(inflate);
            setOnDismissListener(new a(this));
        }
    }

    public final void c(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            Window window = getWindow();
            window.requestFeature(1);
            b(adBaseModel);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = R.style.obfuscated_res_0x7f1003c1;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0915e7) {
                this.a.a(false);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0915e5) {
                this.a.a(true);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Window window = getWindow();
            if (window == null) {
                super.show();
                return;
            }
            window.setFlags(8, 8);
            super.show();
            e11.a(window);
            window.clearFlags(8);
        }
    }
}
