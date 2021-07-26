package d.a.q0.a4.j;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.t.c.k0;
import d.a.q0.h3.q0.m;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b f54707a;

    /* renamed from: b  reason: collision with root package name */
    public final NewWriteModel f54708b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54709c;

    /* renamed from: d  reason: collision with root package name */
    public final NewWriteModel.g f54710d;

    /* renamed from: d.a.q0.a4.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1273a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f54711a;

        public C1273a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54711a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) || this.f54711a.f54707a == null || this.f54711a.f54708b == null || this.f54711a.f54708b.X() == null) {
                return;
            }
            this.f54711a.f54707a.p(false);
            if (writeData == null) {
                writeData = this.f54711a.f54708b.X();
            }
            WriteData writeData2 = writeData;
            if (z) {
                this.f54711a.f54709c = true;
                if (writeData2.getType() != 0 || writeData2.isUserFeedback()) {
                    if (postWriteCallBackData == null) {
                        m.b(this.f54711a.f54707a.g().getActivity(), this.f54711a.f54707a.g().getResources().getString(R.string.send_success), null, null);
                    } else {
                        m.b(this.f54711a.f54707a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                BaseActivity g2 = this.f54711a.f54707a.g();
                this.f54711a.f54707a.g();
                g2.setResult(-1, intent);
                this.f54711a.f54707a.g().finish();
            } else if (writeData2 != null && k0Var != null && !TextUtils.isEmpty(k0Var.d())) {
                writeData2.setVcodeMD5(k0Var.b());
                writeData2.setVcodeUrl(k0Var.c());
                writeData2.setVcodeExtra(k0Var.a());
                this.f54711a.f54707a.g().setVisible(false);
                if (d.a.p0.c1.a.b(k0Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f54711a.f54707a.g().getActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData2, false, k0Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f54711a.f54707a.g().getActivity(), writeData2, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                }
            } else if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                if (postWriteCallBackData != null) {
                    m.b(this.f54711a.f54707a.g().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    BaseActivity g3 = this.f54711a.f54707a.g();
                    this.f54711a.f54707a.g();
                    g3.setResult(0, null);
                }
                this.f54711a.f54707a.g().finish();
            } else {
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity g4 = this.f54711a.f54707a.g();
                this.f54711a.f54707a.g();
                g4.setResult(0, intent2);
                this.f54711a.f54707a.g().finish();
            }
        }
    }

    public a(b bVar, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1273a c1273a = new C1273a(this);
        this.f54710d = c1273a;
        this.f54707a = bVar;
        this.f54708b = newWriteModel;
        newWriteModel.h0(c1273a);
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f54707a) == null) {
            return;
        }
        bVar.s(500);
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f54707a) == null) {
            return;
        }
        bVar.p(false);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f54707a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_CANCEL)) {
                this.f54707a.g().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_INPUT_FOCUS)) {
                this.f54707a.o(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.f54707a.h() != this.f54707a.i()) {
                    b bVar = this.f54707a;
                    bVar.n(bVar.h());
                    this.f54707a.t();
                }
                this.f54707a.j().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_VALID_SUCCESS)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTP) || str.equals(AccountAccessActivity.ACCOUNT_ACCESS_FEEDBACK_HTTPS)) {
                this.f54707a.g().finish();
                UrlManager.getInstance().dealOneLink(this.f54707a.g().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f54707a == null || this.f54708b == null) {
            return;
        }
        if (!l.D()) {
            this.f54707a.g().showToast(R.string.neterror);
            this.f54707a.g().finish();
            return;
        }
        this.f54707a.p(true);
        this.f54708b.l0();
    }

    public void h(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (bVar = this.f54707a) == null) {
            return;
        }
        bVar.q(true);
        this.f54707a.r(false);
        this.f54707a.j().loadUrl(str);
    }
}
