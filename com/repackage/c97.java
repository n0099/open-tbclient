package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c97 extends y8<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public HeadImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ValidateActivity h;
    public ValidateItemData i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c97 a;

        public a(c97 c97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.onItemViewClick(this.a.g, 100, 0, 0L, this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c97 a;

        public b(c97 c97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.onItemViewClick(this.a.c, 101, 0, 0L, this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c97 a;

        public c(c97 c97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c97Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.h.onItemViewLongClick(this.a.b, 200, 0, 0L, this.a.i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c97(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.obfuscated_res_0x7f0d0862);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = validateActivity;
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091ade);
            this.b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f090fd1);
            this.c = headImageView;
            headImageView.setIsRound(false);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09220d);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921a0);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09216d);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090432);
            this.g = textView;
            textView.setOnClickListener(new a(this));
            this.c.setOnClickListener(new b(this));
            this.b.setOnLongClickListener(new c(this));
        }
    }

    public void m(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            n(validateItemData);
            refresh();
        }
    }

    public void n(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i == null) {
            return;
        }
        this.h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.h.getLayoutMode().j(this.b);
        String portrait = this.i.getPortrait();
        this.c.setTag(portrait);
        this.c.K(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.e;
            textView.setText(this.h.getPageContext().getString(R.string.obfuscated_res_0x7f0f14ba) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f;
            textView2.setText(this.h.getPageContext().getString(R.string.obfuscated_res_0x7f0f14bc) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.g.setEnabled(false);
            this.g.setText(this.h.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d3a));
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            this.g.setBackgroundDrawable(null);
        } else {
            this.g.setEnabled(true);
            this.g.setText(this.h.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d09));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.b, R.color.common_color_10178);
    }
}
