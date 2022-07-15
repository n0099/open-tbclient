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
/* loaded from: classes6.dex */
public class nw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public NewWriteModel b;
    public LocationModel c;
    public l35 d;
    public NewWriteModel.e e;
    public GetEmotionPidModel f;
    public EmotionImageData g;
    public PbModel h;
    public jr7 i;
    public final NewWriteModel.e j;

    /* loaded from: classes6.dex */
    public class a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;
        public final /* synthetic */ PbModel b;
        public final /* synthetic */ jr7 c;
        public final /* synthetic */ nw7 d;

        public a(nw7 nw7Var, EmotionImageData emotionImageData, PbModel pbModel, jr7 jr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var, emotionImageData, pbModel, jr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nw7Var;
            this.a = emotionImageData;
            this.b = pbModel;
            this.c = jr7Var;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(p45 p45Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, p45Var) == null) || p45Var == null || TextUtils.isEmpty(p45Var.a)) {
                return;
            }
            this.a.setPicId(p45Var.a);
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

    /* loaded from: classes6.dex */
    public class b implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw7 a;

        public b(nw7 nw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nw7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, fy4 fy4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, fy4Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.b.V();
                }
                if (z) {
                    this.a.j();
                } else if (writeData != null && fy4Var != null && !TextUtils.isEmpty(fy4Var.d())) {
                    writeData.setVcodeMD5(fy4Var.b());
                    writeData.setVcodeUrl(fy4Var.c());
                    writeData.setVcodeExtra(fy4Var.a());
                    if (ve5.b(fy4Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, false, fy4Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.a.e != null) {
                    this.a.e.callback(z, postWriteCallBackData, fy4Var, writeData, antiData);
                }
            }
        }
    }

    public nw7(BaseFragmentActivity baseFragmentActivity) {
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
                WriteData V = newWriteModel != null ? newWriteModel.V() : null;
                j();
                NewWriteModel.e eVar = this.e;
                if (eVar != null) {
                    eVar.callback(true, null, null, V, null);
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

    public void k(EmotionImageData emotionImageData, PbModel pbModel, jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, emotionImageData, pbModel, jr7Var) == null) || emotionImageData == null || jr7Var == null) {
            return;
        }
        this.g = emotionImageData;
        this.h = pbModel;
        this.i = jr7Var;
        if (!ni.z()) {
            this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
        } else if (g(this.a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f == null) {
                    this.f = new GetEmotionPidModel();
                }
                l35 l35Var = this.d;
                if (l35Var != null) {
                    l35Var.a();
                }
                this.f.B(emotionImageData.getPicUrl(), new a(this, emotionImageData, pbModel, jr7Var));
                return;
            }
            l35 l35Var2 = this.d;
            if (l35Var2 != null) {
                l35Var2.a();
            }
            l(emotionImageData, pbModel, jr7Var);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, emotionImageData, pbModel, jr7Var) == null) || emotionImageData == null || jr7Var == null) {
            return;
        }
        if (this.b.V() == null && pbModel != null) {
            this.b.setWriteData(pbModel.H(null));
        }
        if (this.b.V() == null) {
            return;
        }
        boolean z = true;
        if (jr7Var.O().isMutiForumThread()) {
            this.b.V().setCanNoForum(true);
            if (jr7Var.l() != null) {
                this.b.V().setVForumId(jr7Var.l().getId());
                this.b.V().setVForumName(jr7Var.l().getName());
            }
        } else {
            this.b.V().setCanNoForum(false);
            this.b.V().setVForumId("");
            this.b.V().setVForumName("");
        }
        WriteData V = this.b.V();
        LocationModel locationModel = this.c;
        V.setHasLocationData((locationModel == null || !locationModel.D()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + vi.c(sb.toString() + UploadedImageInfo.MD5_KEY).toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.b.V().setContent(str);
        } else {
            this.b.V().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.b.V().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.b.V().setMemeText(emotionImageData.getMemeText());
        }
        this.b.e0(this.j);
        if (!this.b.h0()) {
        }
    }

    public void m(NewWriteModel.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.e = eVar;
        }
    }

    public void n(l35 l35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l35Var) == null) {
            this.d = l35Var;
        }
    }
}
