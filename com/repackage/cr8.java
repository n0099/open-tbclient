package com.repackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cr8 implements br8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq8 a;
    public yq8 b;
    public TbPageContext<?> c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ cr8 b;

        public a(cr8 cr8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cr8Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ai.a(this.a.w);
                li.O(this.b.c.getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f044d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr8 a;

        public b(cr8 cr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.h();
            }
        }
    }

    public cr8(TbPageContext<?> tbPageContext, yq8 yq8Var, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yq8Var, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = tbPageContext;
        this.b = yq8Var;
        ar8 ar8Var = new ar8();
        this.a = ar8Var;
        ar8Var.b(intent);
        this.a.e(tbPageContext.getUniqueId());
    }

    @Override // com.repackage.br8
    public void a() {
        yq8 yq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (yq8Var = this.b) == null) {
            return;
        }
        yq8Var.showErrorView();
    }

    @Override // com.repackage.br8
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.c.getPageActivity())) {
            i();
        }
    }

    @Override // com.repackage.br8
    public void c() {
        zq8 zq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (zq8Var = this.a) == null) {
            return;
        }
        ys4.k().u(ys4.o(zq8Var.c()), false);
    }

    @Override // com.repackage.br8
    public void d() {
        zq8 zq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zq8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.rePlayVideo(zq8Var.getVideoUrl());
    }

    @Override // com.repackage.br8
    public void e() {
        yq8 yq8Var;
        zq8 zq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (yq8Var = this.b) == null || (zq8Var = this.a) == null) {
            return;
        }
        yq8Var.showDialog(zq8Var.a(), this.a.g());
    }

    public final void h() {
        zq8 zq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (zq8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.startPlayVideo(zq8Var.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || this.c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.u = this.a.d();
        shareItem.v = this.a.i();
        shareItem.w = this.a.f();
        shareItem.x = this.a.f();
        if (!ki.isEmpty(this.a.h())) {
            shareItem.y = Uri.parse(this.a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new b(this));
        this.c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // com.repackage.br8
    public void onClose() {
        yq8 yq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (yq8Var = this.b) == null) {
            return;
        }
        yq8Var.finishActivity();
    }

    @Override // com.repackage.br8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.repackage.br8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.repackage.br8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}
