package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class db7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9 a;
    public View b;
    public ImageView c;
    public TextView d;
    public TBSpecificationBtn e;
    public b f;
    public View.OnClickListener g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db7 a;

        public a(db7 db7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.e.getId()) {
                    gz4.d(this.a.a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                } else if (view2.getId() == this.a.c.getId()) {
                    iu4.k().x("key_im_open_notification_close_time", System.currentTimeMillis());
                    if (this.a.f != null) {
                        this.a.f.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onClose();
    }

    public db7(b9 b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.a = b9Var;
        View inflate = LayoutInflater.from(b9Var.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d063a, (ViewGroup) null);
        this.b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090eb1);
        this.c = imageView;
        imageView.setOnClickListener(this.g);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091619);
        this.e = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f09042b);
        this.e.setConfig(new yu4());
        this.e.setText(b9Var.getString(R.string.obfuscated_res_0x7f0f07bc));
        this.e.setOnClickListener(this.g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0206);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f080909, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f = bVar;
        }
    }
}
