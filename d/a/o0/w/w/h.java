package d.a.o0.w.w;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.s.a;
import d.a.o0.s.c.i0;
import d.a.p0.h3.y;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class h extends d.a.o0.w.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f53561f;

    /* renamed from: g  reason: collision with root package name */
    public j f53562g;

    /* renamed from: h  reason: collision with root package name */
    public String f53563h;

    /* renamed from: i  reason: collision with root package name */
    public String f53564i;
    public VoiceData$VoiceModel j;
    public NewWriteModel k;
    public SpanGroupManager l;
    public DataModel<?> m;
    public boolean n;
    public d.a.o0.w.w.c o;
    public d.a.o0.w.w.b p;
    public NewWriteModel.g q;
    public String r;
    public f s;
    public b2 t;
    public y.e u;
    public boolean v;
    public int w;
    public NewWriteModel.g x;
    public AntiHelper.k y;
    public View.OnClickListener z;

    /* loaded from: classes7.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f53565a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53565a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (this.f53565a.q != null) {
                    this.f53565a.q.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
                if (z) {
                    this.f53565a.f53562g = null;
                    this.f53565a.f53563h = null;
                    this.f53565a.I(true);
                    this.f53565a.p();
                }
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (z && this.f53565a.t != null) {
                    StatisticItem statisticItem = new StatisticItem("c13563");
                    statisticItem.param("tid", this.f53565a.t.c0());
                    statisticItem.param("fid", this.f53565a.t.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    d.a.o0.i0.c k = TbPageExtraHelper.k(this.f53565a.f53561f.getPageActivity());
                    if (k != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, k.a());
                    }
                    if (TbPageExtraHelper.m() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    WriteData X = this.f53565a.k.X();
                    this.f53565a.k.setWriteData(null);
                    this.f53565a.k.d0(false);
                    this.f53565a.j = null;
                    if (X == null || X == null || X.getType() != 2) {
                        return;
                    }
                    this.f53565a.m.y();
                } else if (i2 != 230277 && i2 != 230278 && i2 != 340016 && i2 != 1990032 && !AntiHelper.m(i2, str)) {
                    if (i0Var == null || writeData == null || StringUtils.isNull(i0Var.c())) {
                        if (postWriteCallBackData != null && i2 == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f53565a.f53561f.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else if (i2 == 238010 || d.a.p0.r3.a.c(i2)) {
                            return;
                        } else {
                            this.f53565a.r().showToast(str);
                            return;
                        }
                    }
                    writeData.setVcodeMD5(i0Var.b());
                    writeData.setVcodeUrl(i0Var.c());
                    writeData.setVcodeExtra(i0Var.a());
                    if (this.f53565a.t != null) {
                        writeData.setBaijiahaoData(this.f53565a.t.J());
                    }
                    if (d.a.o0.a1.a.b(i0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f53565a.r().getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, i0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f53565a.r().getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                } else {
                    this.f53565a.Z(i2, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements y.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f53566e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53566e = hVar;
        }

        @Override // d.a.p0.h3.y.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.f53566e.f53562g == null) {
                        this.f53566e.f53562g = new j();
                    }
                    this.f53566e.f53562g.f53574a = writeData.getContent();
                    this.f53566e.f53562g.f53575b = writeData.getSubPbReplyPrefix();
                    h hVar = this.f53566e;
                    hVar.J(hVar.f53562g);
                }
                if (this.f53566e.u != null) {
                    this.f53566e.u.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f53567e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53567e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f53567e.r)) {
                return;
            }
            l.M(this.f53567e.r().getPageActivity(), this.f53567e.r);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53563h = "";
        this.n = false;
        this.r = null;
        this.w = 0;
        this.x = new a(this);
        this.y = new b(this);
        this.z = new d(this);
    }

    public void A(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12006) {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.q;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.k.X(), null);
                    }
                }
            } else if (i2 == 12005) {
                if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                    return;
                }
                H(stringArrayListExtra);
            } else if (i2 != 12006) {
            } else {
                if (a() != null) {
                    a().o();
                }
                p();
                I(true);
                WriteData X = this.k.X();
                this.k.setWriteData(null);
                this.k.d0(false);
                if (X == null || X == null || X.getType() != 2) {
                    return;
                }
                this.m.y();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            G();
            this.k.cancelLoadData();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void D() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.k.X() == null) {
                DataModel<?> dataModel = this.m;
                WriteData x = dataModel.x(dataModel.w());
                if (x != null && (b2Var = this.t) != null) {
                    x.setBaijiahaoData(b2Var.J());
                }
                this.k.setWriteData(x);
            }
            if (this.k.X() == null) {
                return;
            }
            this.k.setSpanGroupManager(this.l);
            if (this.f53562g != null) {
                this.k.X().setContent(this.f53562g.f53574a);
                this.k.X().setSubPbReplyPrefix(this.f53562g.f53575b);
                if (this.t != null) {
                    this.k.X().setBaijiahaoData(this.t.J());
                }
            }
            this.k.X().setReplyId(this.f53563h);
            if (this.f53564i != null) {
                this.k.X().setRepostId(this.m.w());
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.j;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.k.X().setVoice(this.j.getId());
                    this.k.X().setVoiceDuringTime(this.j.duration);
                } else {
                    this.k.X().setVoice(null);
                    this.k.X().setVoiceDuringTime(-1);
                }
            } else {
                this.k.X().setVoice(null);
                this.k.X().setVoiceDuringTime(-1);
            }
            if (!this.k.U()) {
                r().showToast(R.string.write_img_limit);
                return;
            }
            d.a.o0.w.w.b bVar = this.p;
            if (bVar == null || !bVar.a()) {
                d.a.o0.w.w.c cVar = this.o;
                if (cVar != null) {
                    cVar.a();
                }
                q(this.k.X());
                if (!this.k.l0()) {
                }
            }
        }
    }

    public void E(AntiData antiData) {
        d.a.o0.w.h m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, antiData) == null) || antiData == null) {
            return;
        }
        String voice_message = antiData.getVoice_message();
        this.r = voice_message;
        if (StringUtils.isNull(voice_message) || a() == null || (m = a().m(6)) == null || TextUtils.isEmpty(this.r)) {
            return;
        }
        ((View) m).setOnClickListener(this.z);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.setWriteData(null);
            this.k.d0(false);
            this.j = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WriteData writeData = new WriteData(2);
            j jVar = this.f53562g;
            if (jVar != null) {
                writeData.setContent(jVar.f53574a);
                writeData.setSubPbReplyPrefix(this.f53562g.f53575b);
            }
            writeData.setReplyId(this.f53563h);
            writeData.setThreadId(this.f53564i);
            y.t(this.f53564i, writeData);
        }
    }

    public final void H(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(17, 27, arrayList));
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(9, -1, Boolean.valueOf(z)));
    }

    public final void J(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(6, 27, jVar));
    }

    public void K(d.a.o0.w.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void L(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.f53561f = tbPageContext;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.w = i2;
        }
    }

    public void N(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.q = gVar;
        }
    }

    public void O(y.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (this.f53562g == null) {
                this.f53562g = new j();
            }
            this.f53562g.f53574a = str;
        }
    }

    public void Q(d.a.o0.w.w.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
        j jVar = this.f53562g;
        if (jVar != null) {
            if (TextUtils.isEmpty(jVar.f53575b) && TextUtils.isEmpty(this.f53562g.f53574a)) {
                f0(str);
                return;
            } else if (!TextUtils.isEmpty(this.f53562g.f53575b) && this.f53562g.f53575b.equals(replace)) {
                b0(this.f53562g);
                return;
            } else {
                f0(str);
                return;
            }
        }
        f0(str);
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f53563h = str;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.n = z;
        }
    }

    public void U(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, spanGroupManager) == null) {
            this.l = spanGroupManager;
        }
    }

    public void V(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jVar) == null) {
            this.f53562g = jVar;
        }
    }

    public void W(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dataModel) == null) {
            this.m = dataModel;
            if (dataModel != null) {
                this.f53564i = dataModel.w();
            }
        }
    }

    public void X(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, b2Var) == null) {
            this.t = b2Var;
            if (a() == null || this.t == null) {
                return;
            }
            a().setFid(this.t.Q());
            a().setTid(this.t.n1());
        }
    }

    public void Y(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, voiceData$VoiceModel) == null) {
            this.j = voiceData$VoiceModel;
        }
    }

    public void Z(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(this.f53561f.getPageActivity(), str, i2, this.y) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i2 != 230277 && i2 != 230278) {
                r().showToast(str);
            } else {
                d0(str);
            }
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            T(true);
            a().j();
            a().x((View) a().m(5));
        }
    }

    public final void b0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, jVar) == null) {
            T(true);
            a().j();
            J(jVar);
            TiebaStatic.eventStat(r().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            T(true);
            a().j();
            a().x((View) a().m(2));
        }
    }

    public final void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(r().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new e(this));
            aVar.create(r()).show();
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            T(true);
            a().j();
        }
    }

    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            T(true);
            a().j();
            if (str != null && str.length() != 0) {
                String replace = r().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
                j jVar = new j();
                jVar.f53575b = replace;
                J(jVar);
            } else {
                j jVar2 = new j();
                jVar2.f53574a = "";
                J(jVar2);
            }
            TiebaStatic.eventStat(r().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || StringUtils.isNull(str) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(45, 27, str));
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            y.t(this.f53564i, null);
        }
    }

    public void q(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, writeData) == null) || writeData == null) {
            return;
        }
        int i2 = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i3 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i3++;
            }
            if (i3 > 0 && this.w > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", this.w);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i2++;
            }
        }
        if (i2 <= 0 || this.w <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i2);
        statisticItem2.param("obj_source", this.w);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public TbPageContext<?> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f53561f : (TbPageContext) invokeV.objValue;
    }

    public f s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.s == null && a() != null) {
                this.s = (f) a().n(27);
            }
            return this.s;
        }
        return (f) invokeV.objValue;
    }

    public void t(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            j jVar = this.f53562g;
            if (jVar != null) {
                pbEditorData.setContent(jVar.f53574a);
                pbEditorData.setSubPbReplyPrefix(this.f53562g.f53575b);
            }
            pbEditorData.setVoiceModel(this.j);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.r);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.f53561f.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            j jVar = this.f53562g;
            return (jVar == null || k.isEmpty(jVar.f53574a)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.j;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.j.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            T(false);
            a().o();
        }
    }

    public void x(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, tbPageContext) == null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.k = newWriteModel;
        newWriteModel.h0(this.x);
        y.l(this.m.w(), new c(this));
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void z(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, writeData) == null) || writeData == null) {
            return;
        }
        if (this.f53562g == null) {
            this.f53562g = new j();
        }
        this.f53562g.f53574a = writeData.getContent();
        this.f53562g.f53575b = writeData.getSubPbReplyPrefix();
        J(this.f53562g);
    }
}
