package com.repackage;

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
import com.repackage.d45;
import com.repackage.ur4;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class cd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public bd7 c;
    public ad7 d;
    public ad7 e;
    public ad7 f;
    public ViewTreeObserver.OnGlobalLayoutListener g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public int i;
    public String j;
    public ImageUrlData k;
    public String l;
    public boolean m;
    public int n;
    public px7 o;
    public ReplyPrivacyCheckController p;
    public View.OnClickListener q;
    public h45 r;
    public final NewWriteModel.e s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        public a(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.j)) {
                return;
            }
            qi.N(this.a.a.getPageActivity(), this.a.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        public b(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.k == null) {
                    return false;
                }
                cd7 cd7Var = this.a;
                if (cd7Var.o != null) {
                    bz8 e = cd7Var.k.isFirstPost ? this.a.o.e() : this.a.o.g();
                    if (e != null && e.d()) {
                        this.a.a.showToast(e.c());
                        if (this.a.d != null && (this.a.d.B() || this.a.d.D())) {
                            this.a.d.z(false, this.a.o.h());
                        }
                        if (this.a.k.isFirstPost) {
                            this.a.o.a(true);
                        } else {
                            this.a.o.b(true);
                        }
                        return true;
                    }
                }
                return !this.a.p.showToastForPrivacy(this.a.i);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        /* loaded from: classes5.dex */
        public class a implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ur4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                    this.a.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.a.getPageActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public c(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                    i = -1;
                }
                if (z) {
                    this.a.k();
                    if (this.a.a != null && (this.a.a.getPageActivity() instanceof BaseActivity)) {
                        ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                        showReplyInPbEvent.writeData = postWriteCallBackData;
                        showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                        ((BaseActivity) this.a.a.getPageActivity()).publishEvent(showReplyInPbEvent);
                    }
                    if (postWriteCallBackData != null) {
                        TiebaStatic.log(new StatisticItem("c13970").param("tid", postWriteCallBackData.getThreadId()).param("fid", writeData.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", writeData.getType()));
                    }
                } else if (i == 220015) {
                    this.a.a.showToast(str);
                    if (this.a.d != null && (this.a.d.B() || this.a.d.D())) {
                        this.a.d.z(false, postWriteCallBackData);
                        this.a.k();
                    }
                    if (this.a.k.isFirstPost) {
                        this.a.o.k(postWriteCallBackData);
                    } else {
                        this.a.o.l(postWriteCallBackData);
                    }
                } else if (i == 238010) {
                    if (!pi.isEmpty(str)) {
                        this.a.a.showToast(str);
                    } else {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0acc);
                    }
                    this.a.k();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (!pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.a.getPageActivity(), postWriteCallBackData.getErrorString(), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    ur4 ur4Var = new ur4(this.a.a.getPageActivity());
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        ur4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f0cf4));
                    } else {
                        ur4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new a(this));
                    ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf6, new b(this));
                    ur4Var.create(this.a.a).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (ur8.d(i)) {
                    this.a.k();
                } else if (az4Var != null || i == 227001) {
                } else {
                    this.a.t(i, str);
                    this.a.k();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        public d(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 0) {
                    return true;
                }
                this.a.k();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements d45.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        public g(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // com.repackage.d45.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.e.a().b.o();
                } else {
                    this.a.e.a().b.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements d45.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd7 a;

        public h(cd7 cd7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd7Var;
        }

        @Override // com.repackage.d45.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.f.a().b.o();
                } else {
                    this.a.f.a().b.setVisibility(0);
                }
            }
        }
    }

    public cd7(TbPageContext tbPageContext, LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.a = tbPageContext;
        this.b = linearLayout;
        linearLayout.setOnTouchListener(new d(this));
        this.b.setVisibility(8);
        this.p = new ReplyPrivacyCheckController(tbPageContext);
    }

    public final void j(int i, Intent intent) {
        t25 t25Var;
        ad7 ad7Var;
        t25 t25Var2;
        ad7 ad7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, intent) == null) {
            if (i == 0 && (ad7Var2 = this.d) != null) {
                ad7Var2.a().q();
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
                    if (editorType == 1 && (ad7Var = this.f) != null) {
                        ad7Var.G(writeData);
                        this.f.w0(pbEditorData.getVoiceModel());
                        s25 n = this.f.a().n(6);
                        if (n != null && (t25Var2 = n.m) != null) {
                            t25Var2.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.f.M(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ad7 ad7Var3 = this.e;
                if (ad7Var3 != null) {
                    ad7Var3.T();
                    this.e.w0(pbEditorData.getVoiceModel());
                    this.e.G(writeData);
                    s25 n2 = this.e.a().n(6);
                    if (n2 != null && (t25Var = n2.m) != null) {
                        t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i == -1) {
                        this.e.M(null, null);
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ad7 ad7Var = this.d;
            if (ad7Var != null && ad7Var.a() != null) {
                this.d.a().o();
            }
            qi.x(this.a.getPageActivity(), this.b);
            this.b.setVisibility(8);
        }
    }

    public void l(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            this.m = true;
            ad7 ad7Var = this.d;
            if (ad7Var != null) {
                if (i == 25035) {
                    j(i2, intent);
                    k();
                    return;
                }
                ad7Var.H(i, i2, intent);
            }
        }
    }

    public void m(int i) {
        ad7 ad7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (ad7Var = this.d) == null) {
            return;
        }
        ad7Var.a().w(i);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReplyPrivacyCheckController replyPrivacyCheckController = this.p;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (this.g != null) {
                d45.c(this.a.getPageActivity(), this.g);
            }
            if (this.h != null) {
                d45.c(this.a.getPageActivity(), this.h);
            }
        }
    }

    public void o() {
        ad7 ad7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k == null || (ad7Var = this.d) == null) {
            return;
        }
        ad7Var.V(this.k.threadId + "");
    }

    public void p() {
        ad7 ad7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k == null || (ad7Var = this.d) == null) {
            return;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        ad7Var.l();
        ad7 ad7Var2 = this.d;
        ad7Var2.s(this.k.threadId + "");
        this.d.a().q();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a9 A[Catch: Exception -> 0x01b2, TRY_LEAVE, TryCatch #0 {Exception -> 0x01b2, blocks: (B:48:0x01a1, B:50:0x01a9), top: B:88:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ImageUrlData imageUrlData, tc7 tc7Var) {
        boolean z;
        JSONArray jSONArray;
        ImageUrlData imageUrlData2;
        o25 m;
        ImageUrlData imageUrlData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, imageUrlData, tc7Var) == null) || imageUrlData == null || tc7Var == null) {
            return;
        }
        if (this.c == null) {
            bd7 bd7Var = new bd7();
            this.c = bd7Var;
            bd7Var.k(imageUrlData.forumName, imageUrlData.forumId);
            this.c.l(String.valueOf(imageUrlData.threadId));
        }
        if (imageUrlData.isFirstPost && this.e == null) {
            bd7 bd7Var2 = this.c;
            bd7Var2.e = false;
            this.e = (ad7) bd7Var2.a(this.a.getPageActivity());
            this.g = d45.b(this.a.getPageActivity(), this.e.a().b, new g(this));
        } else if (!imageUrlData.isFirstPost && this.f == null) {
            bd7 bd7Var3 = this.c;
            bd7Var3.e = true;
            this.f = (ad7) bd7Var3.a(this.a.getPageActivity());
            this.h = d45.b(this.a.getPageActivity(), this.f.a().b, new h(this));
        } else {
            z = false;
            ad7 ad7Var = !imageUrlData.isFirstPost ? this.e : this.f;
            this.d = ad7Var;
            jSONArray = null;
            if (z) {
                ad7Var.f0(this.a);
                this.d.p0(this.s);
                this.d.e0(this.r);
                this.d.F(this.a, null);
                this.d.O(tc7Var.P, null);
                this.d.j0(tc7Var.O);
                this.d.E();
                ad7 ad7Var2 = this.d;
                ad7Var2.N = this.l;
                MetaData metaData = tc7Var.M;
                if (metaData == null) {
                    ad7Var2.v0(imageUrlData.threadId + "");
                } else {
                    ad7Var2.P(metaData, imageUrlData.threadId + "", tc7Var.N);
                }
                if (imageUrlData.isFirstPost) {
                    this.d.Q();
                }
                this.d.a().a.setPadding(0, 0, 0, 0);
                this.d.a().A(new h25(45, 27, null));
                this.d.a().w(this.n);
            }
            imageUrlData2 = this.k;
            if (imageUrlData2 != null || imageUrlData.postId != imageUrlData2.postId) {
                if (this.k != null) {
                    ad7 ad7Var3 = this.d;
                    ad7Var3.V(this.k.threadId + "");
                }
                this.d.l();
                this.d.T();
                ad7 ad7Var4 = this.d;
                ad7Var4.K = !imageUrlData.isFirstPost;
                ad7Var4.L = imageUrlData.postId + "";
                ad7 ad7Var5 = this.d;
                ad7Var5.M = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && ad7Var5.a() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fed);
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.d.a().A(new h25(45, 27, String.format(string, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.U(jSONArray, false).toString())));
                }
                this.i = tc7Var.L;
                this.j = tc7Var.K;
                if (this.d.a() != null && !StringUtils.isNull(this.j) && (m = this.d.a().m(6)) != null && !TextUtils.isEmpty(this.j)) {
                    ((View) m).setOnClickListener(this.q);
                }
                ad7 ad7Var6 = this.d;
                ad7Var6.s(imageUrlData.threadId + "");
            }
            imageUrlData3 = this.k;
            if (imageUrlData3 != null || imageUrlData3.isFirstPost != imageUrlData.isFirstPost) {
                if (this.d.a() != null) {
                    this.b.removeAllViews();
                    this.b.addView(this.d.a());
                }
                if (this.o == null) {
                    this.o = new px7();
                }
                if (this.d.v() != null) {
                    this.o.m(this.d.v().i());
                }
            }
            this.k = imageUrlData;
        }
        z = true;
        if (!imageUrlData.isFirstPost) {
        }
        this.d = ad7Var;
        jSONArray = null;
        if (z) {
        }
        imageUrlData2 = this.k;
        if (imageUrlData2 != null) {
        }
        if (this.k != null) {
        }
        this.d.l();
        this.d.T();
        ad7 ad7Var42 = this.d;
        ad7Var42.K = !imageUrlData.isFirstPost;
        ad7Var42.L = imageUrlData.postId + "";
        ad7 ad7Var52 = this.d;
        ad7Var52.M = imageUrlData.userId;
        if (!imageUrlData.isFirstPost) {
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fed);
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
            }
            this.d.a().A(new h25(45, 27, String.format(string2, imageUrlData.userNameShow, (jSONArray != null || jSONArray.length() <= 0) ? "" : TbRichTextView.U(jSONArray, false).toString())));
        }
        this.i = tc7Var.L;
        this.j = tc7Var.K;
        if (this.d.a() != null) {
            ((View) m).setOnClickListener(this.q);
        }
        ad7 ad7Var62 = this.d;
        ad7Var62.s(imageUrlData.threadId + "");
        imageUrlData3 = this.k;
        if (imageUrlData3 != null) {
        }
        if (this.d.a() != null) {
        }
        if (this.o == null) {
        }
        if (this.d.v() != null) {
        }
        this.k = imageUrlData;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = i;
        }
    }

    public final void t(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(this.a.getPageActivity(), str, i, new e(this));
            } else if (i == 230277) {
                v(str);
            } else {
                this.a.showToast(str);
            }
        }
    }

    public void u(ImageUrlData imageUrlData, tc7 tc7Var) {
        ReplyPrivacyCheckController replyPrivacyCheckController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, imageUrlData, tc7Var) == null) || (replyPrivacyCheckController = this.p) == null || imageUrlData == null || tc7Var == null || !replyPrivacyCheckController.checkPrivacyBeforeInvokeEditor(tc7Var.L)) {
            return;
        }
        ImageUrlData imageUrlData2 = this.k;
        if (imageUrlData2 == null || imageUrlData2.postId != imageUrlData.postId || this.d == null) {
            q(imageUrlData, tc7Var);
        }
        ad7 ad7Var = this.d;
        if (ad7Var != null) {
            if (!ad7Var.B() && !this.d.D()) {
                this.b.setVisibility(0);
                if (this.d.a() != null) {
                    this.d.a().j();
                    this.d.a().q();
                    return;
                }
                return;
            }
            this.d.z(false, null);
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                str = "";
            }
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return;
            }
            ur4 ur4Var = new ur4(tbPageContext.getPageActivity());
            ur4Var.setMessage(str);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a1, new f(this));
            ur4Var.create(this.a).show();
        }
    }
}
