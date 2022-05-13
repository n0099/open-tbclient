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
public class au8 implements zt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xt8 a;
    public wt8 b;
    public TbPageContext<?> c;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ au8 b;

        public a(au8 au8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = au8Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bi.a(this.a.v);
                mi.N(this.b.c.getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0447));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au8 a;

        public b(au8 au8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.h();
            }
        }
    }

    public au8(TbPageContext<?> tbPageContext, wt8 wt8Var, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wt8Var, intent};
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
        this.b = wt8Var;
        yt8 yt8Var = new yt8();
        this.a = yt8Var;
        yt8Var.b(intent);
        this.a.e(tbPageContext.getUniqueId());
    }

    @Override // com.repackage.zt8
    public void a() {
        wt8 wt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (wt8Var = this.b) == null) {
            return;
        }
        wt8Var.showErrorView();
    }

    @Override // com.repackage.zt8
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.c.getPageActivity())) {
            i();
        }
    }

    @Override // com.repackage.zt8
    public void c() {
        xt8 xt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (xt8Var = this.a) == null) {
            return;
        }
        iu4.k().u(iu4.o(xt8Var.c()), false);
    }

    @Override // com.repackage.zt8
    public void d() {
        xt8 xt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xt8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.rePlayVideo(xt8Var.getVideoUrl());
    }

    @Override // com.repackage.zt8
    public void e() {
        wt8 wt8Var;
        xt8 xt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (wt8Var = this.b) == null || (xt8Var = this.a) == null) {
            return;
        }
        wt8Var.showDialog(xt8Var.a(), this.a.g());
    }

    public final void h() {
        xt8 xt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xt8Var = this.a) == null || this.b == null) {
            return;
        }
        this.b.startPlayVideo(xt8Var.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || this.c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.t = this.a.d();
        shareItem.u = this.a.i();
        shareItem.v = this.a.f();
        shareItem.w = this.a.f();
        if (!li.isEmpty(this.a.h())) {
            shareItem.x = Uri.parse(this.a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new b(this));
        this.c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // com.repackage.zt8
    public void onClose() {
        wt8 wt8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wt8Var = this.b) == null) {
            return;
        }
        wt8Var.finishActivity();
    }

    @Override // com.repackage.zt8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.repackage.zt8
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.repackage.zt8
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}
