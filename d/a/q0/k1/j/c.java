package d.a.q0.k1.j;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import d.a.p0.t.c.k0;
import d.a.p0.x.m;
import d.a.p0.x.n;
import d.a.p0.x.v.d.b;
import d.a.q0.h2.k.e.v0;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59936a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f59937b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.k1.j.b f59938c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.k1.j.a f59939d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.k1.j.a f59940e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.k1.j.a f59941f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f59942g;

    /* renamed from: h  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f59943h;

    /* renamed from: i  reason: collision with root package name */
    public int f59944i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public v0 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public d.a.p0.x.w.b r;
    public final NewWriteModel.g s;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59945e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59945e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f59945e.j)) {
                return;
            }
            l.M(this.f59945e.f59936a.getPageActivity(), this.f59945e.j);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.x.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59946a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59946a = cVar;
        }

        @Override // d.a.p0.x.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f59946a.k == null) {
                    return false;
                }
                c cVar = this.f59946a;
                if (cVar.o != null) {
                    d.a.q0.a4.c e2 = cVar.k.isFirstPost ? this.f59946a.o.e() : this.f59946a.o.g();
                    if (e2 != null && e2.d()) {
                        this.f59946a.f59936a.showToast(e2.c());
                        if (this.f59946a.f59939d != null && (this.f59946a.f59939d.C() || this.f59946a.f59939d.E())) {
                            this.f59946a.f59939d.A(false, this.f59946a.o.h());
                        }
                        if (this.f59946a.k.isFirstPost) {
                            this.f59946a.o.a(true);
                        } else {
                            this.f59946a.o.b(true);
                        }
                        return true;
                    }
                }
                return !this.f59946a.p.showToastForPrivacy(this.f59946a.f59944i);
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: d.a.q0.k1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1514c implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59947a;

        /* renamed from: d.a.q0.k1.j.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(C1514c c1514c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1514c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* renamed from: d.a.q0.k1.j.c$c$b */
        /* loaded from: classes8.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1514c f59948e;

            public b(C1514c c1514c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1514c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59948e = c1514c;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f59948e.f59947a.f59936a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f59948e.f59947a.f59936a.getPageActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public C1514c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59947a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                    i2 = -1;
                }
                if (z) {
                    this.f59947a.k();
                    if (this.f59947a.f59936a != null && (this.f59947a.f59936a.getPageActivity() instanceof BaseActivity)) {
                        ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                        showReplyInPbEvent.writeData = postWriteCallBackData;
                        showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                        ((BaseActivity) this.f59947a.f59936a.getPageActivity()).publishEvent(showReplyInPbEvent);
                    }
                    if (postWriteCallBackData != null) {
                        TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                    }
                } else if (i2 == 220015) {
                    this.f59947a.f59936a.showToast(str);
                    if (this.f59947a.f59939d != null && (this.f59947a.f59939d.C() || this.f59947a.f59939d.E())) {
                        this.f59947a.f59939d.A(false, postWriteCallBackData);
                        this.f59947a.k();
                    }
                    if (this.f59947a.k.isFirstPost) {
                        this.f59947a.o.k(postWriteCallBackData);
                    } else {
                        this.f59947a.o.l(postWriteCallBackData);
                    }
                } else if (i2 == 238010) {
                    if (!k.isEmpty(str)) {
                        this.f59947a.f59936a.showToast(str);
                    } else {
                        this.f59947a.f59936a.showToast(R.string.message_privacy_fans_can_reply);
                    }
                    this.f59947a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (!k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f59947a.f59936a.getPageActivity(), postWriteCallBackData.getErrorString(), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f59947a.f59936a.getPageActivity(), this.f59947a.f59936a.getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f59947a.f59936a.getPageActivity());
                    if (k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f59947a.f59936a.getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b(this));
                    aVar.create(this.f59947a.f59936a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (d.a.q0.r3.a.c(i2)) {
                    this.f59947a.k();
                } else if (k0Var != null || i2 == 227001) {
                } else {
                    this.f59947a.t(i2, str);
                    this.f59947a.k();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59949e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59949e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return true;
                }
                this.f59949e.k();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.InterfaceC1249b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59950a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59950a = cVar;
        }

        @Override // d.a.p0.x.v.d.b.InterfaceC1249b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f59950a.f59940e.a().f13040f.o();
                } else {
                    this.f59950a.f59940e.a().f13040f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements b.InterfaceC1249b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59951a;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59951a = cVar;
        }

        @Override // d.a.p0.x.v.d.b.InterfaceC1249b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f59951a.f59941f.a().f13040f.o();
                } else {
                    this.f59951a.f59941f.a().f13040f.setVisibility(0);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new C1514c(this);
        this.f59936a = tbPageContext;
        this.f59937b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.f59937b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i2, Intent intent) {
        n nVar;
        d.a.q0.k1.j.a aVar;
        n nVar2;
        d.a.q0.k1.j.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intent) == null) {
            if (i2 == 0 && (aVar2 = this.f59939d) != null) {
                aVar2.a().q();
            } else {
                k();
            }
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                int editorType = pbEditorData.getEditorType();
                if (editorType != 0) {
                    if (editorType == 1 && (aVar = this.f59941f) != null) {
                        aVar.H(writeData);
                        this.f59941f.u0(pbEditorData.getVoiceModel());
                        m n = this.f59941f.a().n(6);
                        if (n != null && (nVar2 = n.k) != null) {
                            nVar2.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i2 == -1) {
                            this.f59941f.M(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                d.a.q0.k1.j.a aVar3 = this.f59940e;
                if (aVar3 != null) {
                    aVar3.T();
                    this.f59940e.u0(pbEditorData.getVoiceModel());
                    this.f59940e.H(writeData);
                    m n2 = this.f59940e.a().n(6);
                    if (n2 != null && (nVar = n2.k) != null) {
                        nVar.onAction(new d.a.p0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.f59940e.M(null, null);
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.k1.j.a aVar = this.f59939d;
            if (aVar != null && aVar.a() != null) {
                this.f59939d.a().o();
            }
            l.x(this.f59936a.getPageActivity(), this.f59937b);
            this.f59937b.setVisibility(8);
        }
    }

    public void l(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            this.m = true;
            d.a.q0.k1.j.a aVar = this.f59939d;
            if (aVar != null) {
                if (i2 == 25035) {
                    j(i3, intent);
                    k();
                    return;
                }
                aVar.I(i2, i3, intent);
            }
        }
    }

    public void m(int i2) {
        d.a.q0.k1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f59939d) == null) {
            return;
        }
        aVar.a().w(i2);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (this.f59942g != null) {
                d.a.p0.x.v.d.b.c(this.f59936a.getPageActivity(), this.f59942g);
            }
            if (this.f59943h != null) {
                d.a.p0.x.v.d.b.c(this.f59936a.getPageActivity(), this.f59943h);
            }
        }
    }

    public void o() {
        d.a.q0.k1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || (aVar = this.f59939d) == null) {
            return;
        }
        aVar.V(this.k.threadId + "");
    }

    public void p() {
        d.a.q0.k1.j.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k == null || (aVar = this.f59939d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        aVar.l();
        d.a.q0.k1.j.a aVar2 = this.f59939d;
        aVar2.t(this.k.threadId + "");
        this.f59939d.a().q();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019d A[Catch: Exception -> 0x01a6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a6, blocks: (B:48:0x0195, B:50:0x019d), top: B:88:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, d.a.q0.k1.c cVar) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        d.a.p0.x.h m;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, cVar) == null) || imageUrlData == null || cVar == null) {
            return;
        }
        if (this.f59938c == null) {
            d.a.q0.k1.j.b bVar = new d.a.q0.k1.j.b();
            this.f59938c = bVar;
            bVar.j(imageUrlData.forumName, imageUrlData.forumId);
        }
        if (imageUrlData.isFirstPost && this.f59940e == null) {
            d.a.q0.k1.j.b bVar2 = this.f59938c;
            bVar2.f59933d = false;
            this.f59940e = (d.a.q0.k1.j.a) bVar2.a(this.f59936a.getPageActivity());
            this.f59942g = d.a.p0.x.v.d.b.b(this.f59936a.getPageActivity(), this.f59940e.a().f13040f, new g(this));
        } else if (!imageUrlData.isFirstPost && this.f59941f == null) {
            d.a.q0.k1.j.b bVar3 = this.f59938c;
            bVar3.f59933d = true;
            this.f59941f = (d.a.q0.k1.j.a) bVar3.a(this.f59936a.getPageActivity());
            this.f59943h = d.a.p0.x.v.d.b.b(this.f59936a.getPageActivity(), this.f59941f.a().f13040f, new h(this));
        } else {
            z = false;
            d.a.q0.k1.j.a aVar = !imageUrlData.isFirstPost ? this.f59940e : this.f59941f;
            this.f59939d = aVar;
            jSONArray = null;
            if (z) {
                aVar.f0(this.f59936a);
                this.f59939d.o0(this.s);
                this.f59939d.e0(this.r);
                this.f59939d.G(this.f59936a, null);
                this.f59939d.O(cVar.P, null);
                this.f59939d.i0(cVar.O);
                this.f59939d.F();
                d.a.q0.k1.j.a aVar2 = this.f59939d;
                aVar2.Q = this.l;
                MetaData metaData = cVar.M;
                if (metaData == null) {
                    aVar2.t0(imageUrlData.threadId + "");
                } else {
                    aVar2.P(metaData, imageUrlData.threadId + "", cVar.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.f59939d.Q();
                }
                this.f59939d.a().f13039e.setPadding(0, 0, 0, 0);
                this.f59939d.a().A(new d.a.p0.x.a(45, 27, null));
                this.f59939d.a().w(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    d.a.q0.k1.j.a aVar3 = this.f59939d;
                    aVar3.V(this.k.threadId + "");
                }
                this.f59939d.l();
                this.f59939d.T();
                d.a.q0.k1.j.a aVar4 = this.f59939d;
                aVar4.N = !imageUrlData.isFirstPost;
                aVar4.O = imageUrlData.postId + "";
                d.a.q0.k1.j.a aVar5 = this.f59939d;
                aVar5.P = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && aVar5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f59939d.a().A(new d.a.p0.x.a(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.T(this.f59936a.getPageActivity(), jSONArray, false).toString())));
                }
                this.f59944i = cVar.L;
                this.j = cVar.K;
                if (this.f59939d.a() != null && !StringUtils.isNull(this.j) && (m = this.f59939d.a().m(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) m).setOnClickListener(this.q);
                }
                d.a.q0.k1.j.a aVar6 = this.f59939d;
                aVar6.t(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.f59939d.a() != null) {
                    this.f59937b.removeAllViews();
                    this.f59937b.addView(this.f59939d.a());
                }
                if (this.o == null) {
                    this.o = new v0();
                }
                if (this.f59939d.w() != null) {
                    this.o.m(this.f59939d.w().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.f59939d = aVar;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.f59939d.l();
        this.f59939d.T();
        d.a.q0.k1.j.a aVar42 = this.f59939d;
        aVar42.N = !imageUrlData.isFirstPost;
        aVar42.O = imageUrlData.postId + "";
        d.a.q0.k1.j.a aVar52 = this.f59939d;
        aVar52.P = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.f59939d.a().A(new d.a.p0.x.a(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.T(this.f59936a.getPageActivity(), jSONArray, false).toString())));
        }
        this.f59944i = cVar.L;
        this.j = cVar.K;
        if (this.f59939d.a() != null) {
            ((View) m).setOnClickListener(this.q);
        }
        d.a.q0.k1.j.a aVar62 = this.f59939d;
        aVar62.t(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.f59939d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.f59939d.w() != null) {
        }
        this.k = imageUrlData;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.n = i2;
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            if (AntiHelper.m(i2, str)) {
                AntiHelper.w(this.f59936a.getPageActivity(), str, i2, new e(this));
            } else if (i2 == 230277) {
                v(str);
            } else {
                this.f59936a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, d.a.q0.k1.c cVar) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, imageUrlData, cVar) == null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || cVar == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(cVar.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.f59939d == null) {
            q(imageUrlData, cVar);
        }
        d.a.q0.k1.j.a aVar = this.f59939d;
        if (aVar != null) {
            if (!aVar.C() && !this.f59939d.E()) {
                this.f59937b.setVisibility(0);
                if (this.f59939d.a() != null) {
                    this.f59939d.a().j();
                    this.f59939d.a().q();
                    return;
                }
                return;
            }
            this.f59939d.A(false, null);
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbPageContext tbPageContext = this.f59936a;
            if (tbPageContext == null) {
                return;
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new f(this));
            aVar.create(this.f59936a).show();
        }
    }
}
