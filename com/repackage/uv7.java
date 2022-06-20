package com.repackage;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public NewWriteModel b;
    public LocationModel c;
    public k25 d;
    public NewWriteModel.e e;
    public GetEmotionPidModel f;
    public EmotionImageData g;
    public PbModel h;
    public rq7 i;
    public final NewWriteModel.e j;

    /* loaded from: classes7.dex */
    public class a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;
        public final /* synthetic */ PbModel b;
        public final /* synthetic */ rq7 c;
        public final /* synthetic */ uv7 d;

        public a(uv7 uv7Var, EmotionImageData emotionImageData, PbModel pbModel, rq7 rq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, emotionImageData, pbModel, rq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uv7Var;
            this.a = emotionImageData;
            this.b = pbModel;
            this.c = rq7Var;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(n35 n35Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, n35Var) == null) || n35Var == null || TextUtils.isEmpty(n35Var.a)) {
                return;
            }
            this.a.setPicId(n35Var.a);
            this.d.l(this.a, this.b, this.c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || this.d.e == null) {
                return;
            }
            this.d.e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        public b(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.b.T();
                }
                if (z) {
                    this.a.j();
                } else if (writeData != null && hx4Var != null && !TextUtils.isEmpty(hx4Var.d())) {
                    writeData.setVcodeMD5(hx4Var.b());
                    writeData.setVcodeUrl(hx4Var.c());
                    writeData.setVcodeExtra(hx4Var.a());
                    if (sd5.b(hx4Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, false, hx4Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.a.e != null) {
                    this.a.e.callback(z, postWriteCallBackData, hx4Var, writeData, antiData);
                }
            }
        }
    }

    public uv7(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new b(this);
        this.a = baseFragmentActivity;
        this.b = new NewWriteModel(baseFragmentActivity);
        this.c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f;
            if (getEmotionPidModel != null) {
                getEmotionPidModel.cancelLoadData();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return "@" + str + " ";
        }
        return (String) invokeL.objValue;
    }

    public void i(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) && i2 == -1) {
            if (i != 25017) {
                if (i == 11042) {
                    k(this.g, this.h, this.i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.b;
                WriteData T = newWriteModel != null ? newWriteModel.T() : null;
                j();
                NewWriteModel.e eVar = this.e;
                if (eVar != null) {
                    eVar.callback(true, null, null, T, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g = null;
            this.i = null;
            this.h = null;
            NewWriteModel newWriteModel = this.b;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, emotionImageData, pbModel, rq7Var) == null) || emotionImageData == null || rq7Var == null) {
            return;
        }
        this.g = emotionImageData;
        this.h = pbModel;
        this.i = rq7Var;
        if (!ni.z()) {
            this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
        } else if (g(this.a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f == null) {
                    this.f = new GetEmotionPidModel();
                }
                k25 k25Var = this.d;
                if (k25Var != null) {
                    k25Var.a();
                }
                this.f.A(emotionImageData.getPicUrl(), new a(this, emotionImageData, pbModel, rq7Var));
                return;
            }
            k25 k25Var2 = this.d;
            if (k25Var2 != null) {
                k25Var2.a();
            }
            l(emotionImageData, pbModel, rq7Var);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, emotionImageData, pbModel, rq7Var) == null) || emotionImageData == null || rq7Var == null) {
            return;
        }
        if (this.b.T() == null && pbModel != null) {
            this.b.setWriteData(pbModel.G(null));
        }
        if (this.b.T() == null) {
            return;
        }
        boolean z = true;
        if (rq7Var.O().isMutiForumThread()) {
            this.b.T().setCanNoForum(true);
            if (rq7Var.l() != null) {
                this.b.T().setVForumId(rq7Var.l().getId());
                this.b.T().setVForumName(rq7Var.l().getName());
            }
        } else {
            this.b.T().setCanNoForum(false);
            this.b.T().setVForumId("");
            this.b.T().setVForumName("");
        }
        WriteData T = this.b.T();
        LocationModel locationModel = this.c;
        T.setHasLocationData((locationModel == null || !locationModel.C()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + vi.c(sb.toString() + UploadedImageInfo.MD5_KEY).toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.b.T().setContent(str);
        } else {
            this.b.T().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.b.T().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.b.T().setMemeText(emotionImageData.getMemeText());
        }
        this.b.c0(this.j);
        if (!this.b.f0()) {
        }
    }

    public void m(NewWriteModel.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.e = eVar;
        }
    }

    public void n(k25 k25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k25Var) == null) {
            this.d = k25Var;
        }
    }
}
