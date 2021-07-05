package d.a.s0.h2.k.e.b1.f;

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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.c.e.p.j;
import d.a.c.e.p.q;
import d.a.r0.s.c.i0;
import d.a.r0.w.w.c;
import d.a.s0.h2.h.e;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f60380a;

    /* renamed from: b  reason: collision with root package name */
    public NewWriteModel f60381b;

    /* renamed from: c  reason: collision with root package name */
    public LocationModel f60382c;

    /* renamed from: d  reason: collision with root package name */
    public c f60383d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel.g f60384e;

    /* renamed from: f  reason: collision with root package name */
    public GetEmotionPidModel f60385f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionImageData f60386g;

    /* renamed from: h  reason: collision with root package name */
    public PbModel f60387h;

    /* renamed from: i  reason: collision with root package name */
    public e f60388i;
    public final NewWriteModel.g j;

    /* renamed from: d.a.s0.h2.k.e.b1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1459a implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f60389a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f60390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f60391c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f60392d;

        public C1459a(a aVar, EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, emotionImageData, pbModel, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60392d = aVar;
            this.f60389a = emotionImageData;
            this.f60390b = pbModel;
            this.f60391c = eVar;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.r0.b0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f54827a)) {
                return;
            }
            this.f60389a.setPicId(cVar.f54827a);
            this.f60392d.l(this.f60389a, this.f60390b, this.f60391c);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f60392d.f60384e == null) {
                return;
            }
            this.f60392d.f60384e.callback(false, null, null, null, null);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60393a;

        public b(a aVar) {
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
            this.f60393a = aVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f60393a.f60381b.X();
                }
                if (z) {
                    this.f60393a.j();
                } else if (writeData != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                    writeData.setVcodeMD5(i0Var.b());
                    writeData.setVcodeUrl(i0Var.c());
                    writeData.setVcodeExtra(i0Var.a());
                    if (d.a.r0.a1.a.b(i0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f60393a.f60380a.getPageContext().getPageActivity(), 25017, writeData, false, i0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f60393a.f60380a.getPageContext().getPageActivity(), writeData, 25017)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f60393a.f60380a.getPageContext().getPageActivity(), 25017, writeData, postWriteCallBackData.getAccessState())));
                }
                if (this.f60393a.f60384e != null) {
                    this.f60393a.f60384e.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
            }
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new b(this);
        this.f60380a = baseFragmentActivity;
        this.f60381b = new NewWriteModel(baseFragmentActivity);
        this.f60382c = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GetEmotionPidModel getEmotionPidModel = this.f60385f;
            if (getEmotionPidModel != null) {
                getEmotionPidModel.cancelLoadData();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
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
            return TNCManager.TNC_PROBE_HEADER_SECEPTOR + str + " ";
        }
        return (String) invokeL.objValue;
    }

    public void i(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i3 == -1) {
            if (i2 != 25017) {
                if (i2 == 11042) {
                    k(this.f60386g, this.f60387h, this.f60388i);
                }
            } else if (intent == null) {
            } else {
                NewWriteModel newWriteModel = this.f60381b;
                WriteData X = newWriteModel != null ? newWriteModel.X() : null;
                j();
                NewWriteModel.g gVar = this.f60384e;
                if (gVar != null) {
                    gVar.callback(true, null, null, X, null);
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f60386g = null;
            this.f60388i = null;
            this.f60387h = null;
            NewWriteModel newWriteModel = this.f60381b;
            if (newWriteModel != null) {
                newWriteModel.j0(null);
            }
        }
    }

    public void k(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, emotionImageData, pbModel, eVar) == null) || emotionImageData == null || eVar == null) {
            return;
        }
        this.f60386g = emotionImageData;
        this.f60387h = pbModel;
        this.f60388i = eVar;
        if (!j.z()) {
            this.f60380a.showToast(R.string.neterror);
        } else if (g(this.f60380a.getPageContext(), 11042)) {
            if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                if (TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                    return;
                }
                if (this.f60385f == null) {
                    this.f60385f = new GetEmotionPidModel();
                }
                c cVar = this.f60383d;
                if (cVar != null) {
                    cVar.a();
                }
                this.f60385f.x(emotionImageData.getPicUrl(), new C1459a(this, emotionImageData, pbModel, eVar));
                return;
            }
            c cVar2 = this.f60383d;
            if (cVar2 != null) {
                cVar2.a();
            }
            l(emotionImageData, pbModel, eVar);
        }
    }

    public final void l(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, emotionImageData, pbModel, eVar) == null) || emotionImageData == null || eVar == null) {
            return;
        }
        if (this.f60381b.X() == null && pbModel != null) {
            this.f60381b.j0(pbModel.x(null));
        }
        if (this.f60381b.X() == null) {
            return;
        }
        boolean z = true;
        if (eVar.N().b2()) {
            this.f60381b.X().setCanNoForum(true);
            if (eVar.m() != null) {
                this.f60381b.X().setVForumId(eVar.m().getId());
                this.f60381b.X().setVForumName(eVar.m().getName());
            }
        } else {
            this.f60381b.X().setCanNoForum(false);
            this.f60381b.X().setVForumId("");
            this.f60381b.X().setVForumName("");
        }
        WriteData X = this.f60381b.X();
        LocationModel locationModel = this.f60382c;
        X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
        StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String str = SmallTailInfo.EMOTION_PREFIX + sb.toString() + q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
        if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
            this.f60381b.X().setContent(str);
        } else {
            this.f60381b.X().setContent(h(emotionImageData.getAuthorNameShow()) + str);
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
            this.f60381b.X().setMemeContSign(emotionImageData.getMemeContSign());
        }
        if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
            this.f60381b.X().setMemeText(emotionImageData.getMemeText());
        }
        this.f60381b.h0(this.j);
        if (!this.f60381b.m0()) {
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f60384e = gVar;
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f60383d = cVar;
        }
    }
}
