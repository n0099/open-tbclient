package d.a.q0.w3.d;

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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class b implements d.a.q0.w3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.w3.c.a f66763a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.w3.b f66764b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f66765c;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f66766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f66767f;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66767f = bVar;
            this.f66766e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.d.e.p.a.a(this.f66766e.t);
                l.M(this.f66767f.f66765c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: d.a.q0.w3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterface$OnDismissListenerC1842b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66768e;

        public DialogInterface$OnDismissListenerC1842b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66768e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f66768e.h();
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, d.a.q0.w3.b bVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66765c = tbPageContext;
        this.f66764b = bVar;
        d.a.q0.w3.c.b bVar2 = new d.a.q0.w3.c.b();
        this.f66763a = bVar2;
        bVar2.b(intent);
        this.f66763a.e(tbPageContext.getUniqueId());
    }

    @Override // d.a.q0.w3.d.a
    public void a() {
        d.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f66764b) == null) {
            return;
        }
        bVar.showErrorView();
    }

    @Override // d.a.q0.w3.d.a
    public void b() {
        d.a.q0.w3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f66763a) == null) {
            return;
        }
        d.a.p0.s.d0.b.j().t(d.a.p0.s.d0.b.n(aVar.c()), false);
    }

    @Override // d.a.q0.w3.d.a
    public void c() {
        d.a.q0.w3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f66763a) == null || this.f66764b == null) {
            return;
        }
        this.f66764b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // d.a.q0.w3.d.a
    public void d() {
        d.a.q0.w3.b bVar;
        d.a.q0.w3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f66764b) == null || (aVar = this.f66763a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f66763a.g());
    }

    @Override // d.a.q0.w3.d.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f66765c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f66765c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        d.a.q0.w3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f66763a) == null || this.f66764b == null) {
            return;
        }
        this.f66764b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f66763a == null || this.f66765c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f66763a.d();
        shareItem.s = this.f66763a.i();
        shareItem.t = this.f66763a.f();
        shareItem.u = this.f66763a.f();
        if (!k.isEmpty(this.f66763a.h())) {
            shareItem.v = Uri.parse(this.f66763a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f66765c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1842b(this));
        this.f66765c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // d.a.q0.w3.d.a
    public void onClose() {
        d.a.q0.w3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.f66764b) == null) {
            return;
        }
        bVar.finishActivity();
    }

    @Override // d.a.q0.w3.d.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // d.a.q0.w3.d.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // d.a.q0.w3.d.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}
