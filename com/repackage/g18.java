package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl5;
import com.repackage.fs4;
import com.repackage.j55;
import com.repackage.ur4;
import com.repackage.wr4;
import com.repackage.yk5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes6.dex */
public class g18 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public zm A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public nu4 J;
    public rk8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public fs4.e N;
    public boolean O;
    public final wr4.c P;
    public AbsVideoPbFragment a;
    public ds4 b;
    public fs4 c;
    public ds4 d;
    public ur4 e;
    public Dialog f;
    public Dialog g;
    public yr4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public ds4 q;
    public uu4 r;
    public wr4 s;
    public AlertDialog t;
    public uw7 u;
    public yk5 v;
    public bl5 w;
    public nz7 x;
    public PbFragment.h3 y;
    public rx7 z;

    /* loaded from: classes6.dex */
    public class a implements wr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public a(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (wr4Var != null) {
                    wr4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        j55.a aVar = new j55.a();
                        aVar.a = this.a.B;
                        String str = "";
                        if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.C.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.F == null) {
                        this.a.F = new PermissionJudgePolicy();
                    }
                    this.a.F.clearRequestPermissionList();
                    this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.z == null) {
                        g18 g18Var = this.a;
                        g18Var.z = new rx7(g18Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g18 e;

        public a0(g18 g18Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g18Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fea), ((Integer) this.a.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092041);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092043);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092042);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.M0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f09203f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public b(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.a.y3(ur4Var, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public b0(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log("c10025");
                ur4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
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

    /* loaded from: classes6.dex */
    public class c0 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ g18 c;

        public d(g18 g18Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g18Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!oi.A()) {
                    qi.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.c.a.x3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(g18 g18Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ g18 c;

        public f(g18 g18Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g18Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!oi.A()) {
                    qi.M(this.c.a.P(), R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.c.a.x3(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(g18 g18Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yk5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ g18 b;

        public h(g18 g18Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = ur4Var;
        }

        @Override // com.repackage.yk5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.y3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ g18 b;

        public i(g18 g18Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.x3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ g18 b;

        public j(g18 g18Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = z;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f092008), sparseArray.get(R.id.obfuscated_res_0x7f091ff5), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff6), sparseArray.get(R.id.obfuscated_res_0x7f091ff7)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092040), sparseArray);
                        return;
                    case 13:
                        AbsVideoPbFragment absVideoPbFragment = this.b.a;
                        if (absVideoPbFragment == null || absVideoPbFragment.K3() == null) {
                            return;
                        }
                        this.b.a.K3().m2(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public k(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            tg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes6.dex */
    public class l implements wr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public l(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    g18 g18Var = this.a;
                    g18Var.H = g18Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new pv7(this.a.a.K().m2(), this.a.H, "1").start();
                    wr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    g18 g18Var2 = this.a;
                    g18Var2.H = g18Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new pv7(this.a.a.K().m2(), this.a.H, "2").start();
                    wr4Var.e();
                } else if (i == 2) {
                    g18 g18Var3 = this.a;
                    g18Var3.H = g18Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    wr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ g18 c;

        public m(g18 g18Var, ds4 ds4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, ds4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g18Var;
            this.a = ds4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.K().j2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.fs4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i0(fs4 fs4Var, int i, View view2) {
            boolean L3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, fs4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.K().j2() != 1 || i != 1) {
                if (this.c.a.K().j2() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.K().j2() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091843 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.K().S1().f != null && this.c.a.K().S1().f.size() > i) {
                    i = this.c.a.K().S1().f.get(i).sort_type.intValue();
                }
                L3 = this.c.a.K().L3(i);
                this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
                if (L3) {
                    return;
                }
                this.c.a.l5(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091843 ? 1 : 0).param("obj_type", i2));
            if (this.c.a.K().S1().f != null) {
                i = this.c.a.K().S1().f.get(i).sort_type.intValue();
            }
            L3 = this.c.a.K().L3(i);
            this.b.setTag(Integer.valueOf(this.c.a.K().i2()));
            if (L3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(g18 g18Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = metaData;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ g18 b;

        public o(g18 g18Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = metaData;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                ur4Var.dismiss();
                if (this.b.a.H3() != null) {
                    this.b.a.H3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.K().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
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

    /* loaded from: classes6.dex */
    public class q implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ g18 b;

        public q(g18 g18Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.b.C0();
                MessageManager.getInstance().sendMessage(this.a);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
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

    /* loaded from: classes6.dex */
    public class s implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4.c a;
        public final /* synthetic */ g18 b;

        public s(g18 g18Var, wr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g18Var;
            this.a = cVar;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public t(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.n = (String) compoundButton.getTag();
                if (this.a.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.n != null && !str.equals(this.a.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public u(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public v(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                tg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public w(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!oi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.K().S1().l().getId(), this.a.a.K().S1().l().getName(), this.a.a.K().S1().O().getId(), String.valueOf(this.a.a.K().S1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g18 a;

        public x(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g18Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.N0(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b7);
                    this.a.n0(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b6);
                    this.a.n0(view4);
                    if (view4 != null) {
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    AgreeView agreeView = (AgreeView) view5;
                    this.a.n0(view5);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    this.a.n0(view6);
                    AgreeView agreeView2 = (AgreeView) view6;
                    if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                        return;
                    }
                    agreeView2.getImgAgree().performClick();
                } else if (i != 13) {
                    int i2 = 4;
                    switch (i) {
                        case 1:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.C == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                            } else {
                                j55.a aVar = new j55.a();
                                aVar.a = this.a.B;
                                String str = "";
                                if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.C.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 2:
                            if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                                return;
                            }
                            if (this.a.F == null) {
                                this.a.F = new PermissionJudgePolicy();
                            }
                            this.a.F.clearRequestPermissionList();
                            this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.z == null) {
                                g18 g18Var = this.a;
                                g18Var.z = new rx7(g18Var.a.getPageContext());
                            }
                            this.a.z.b(this.a.B, this.a.A.n());
                            this.a.A = null;
                            this.a.B = null;
                            return;
                        case 3:
                            PostData postData = this.a.G;
                            if (postData != null) {
                                postData.B0();
                                this.a.G = null;
                                return;
                            }
                            return;
                        case 4:
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            if (this.a.a.checkUpIsLogin()) {
                                this.a.d0(view2);
                                if (this.a.a.K().S1().O() == null || this.a.a.K().S1().O().getAuthor() == null || this.a.a.K().S1().O().getAuthor().getUserId() == null || this.a.a.U3() == null) {
                                    return;
                                }
                                g18 g18Var2 = this.a;
                                int S = g18Var2.S(g18Var2.a.K().S1());
                                ThreadData O = this.a.a.K().S1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.K().m2()).param("obj_locate", 2).param("obj_id", this.a.a.K().S1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.U3().e()).param("obj_source", S).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!oi.z()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                return;
                            }
                            Object tag = view2.getTag();
                            if (tag instanceof String) {
                                TiebaStatic.log(new StatisticItem("c13079"));
                                this.a.U((String) tag);
                                return;
                            } else if (tag instanceof SparseArray) {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                if ((sparseArray2.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                                    sparseArray2.put(R.id.obfuscated_res_0x7f091ffb, 0);
                                    sparseArray2.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                    this.a.B(sparseArray2);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                            if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091fea) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f092008) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                                int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092008)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ffc)).booleanValue();
                                AbsVideoPbFragment absVideoPbFragment = this.a.a;
                                if (absVideoPbFragment == null || absVideoPbFragment.P() == null) {
                                    return;
                                }
                                boolean E = this.a.a.P().E(TbadkCoreApplication.getCurrentAccount());
                                if (E) {
                                    if (!booleanValue2) {
                                        this.a.u0(sparseArray3, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue, null, E);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.u0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!oi.z()) {
                                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                return;
                            }
                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09202e)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092044)).booleanValue();
                            boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091ffb, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                this.a.B(sparseArray4);
                                return;
                            } else {
                                if (booleanValue6) {
                                    sparseArray4.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                }
                                sparseArray4.put(R.id.obfuscated_res_0x7f092009, Boolean.TRUE);
                                this.a.l0(view2);
                                return;
                            }
                        case 8:
                            if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                                if (postData2.q() == null) {
                                    return;
                                }
                                o95 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                if (findPageExtraByView != null) {
                                    postData2.q().objSource = findPageExtraByView.a();
                                }
                                this.a.C(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                            if (absVideoPbFragment2 == null || absVideoPbFragment2.K() == null || this.a.a.K().S1() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.P() == null) {
                                return;
                            }
                            this.a.a.P().o1(ur8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else {
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.a;
                    if (absVideoPbFragment3 == null || absVideoPbFragment3.K3() == null) {
                        return;
                    }
                    this.a.a.K3().m2(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ g18 d;

        public y(g18 g18Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = g18Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (ur4Var != null) {
                    ur4Var.dismiss();
                }
                this.d.a.z3(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fea), this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(g18 g18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g18Var};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755730781, "Lcom/repackage/g18;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755730781, "Lcom/repackage/g18;");
        }
    }

    public g18(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = UbsABTestHelper.showTrisectionAndFeedback();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        nz7 nz7Var = new nz7(this.a.getContext());
        this.x = nz7Var;
        nz7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public final boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || !this.a.K().k2()) {
                return false;
            }
            return this.a.K().Q1() == null || this.a.K().Q1().c() != 0;
        }
        return invokeV.booleanValue;
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            C0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = og.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = og.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092040), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) || metaData == null) {
            return;
        }
        ur4 ur4Var = new ur4(this.a.getActivity());
        ur4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a93));
        ur4Var.setTitleShowCenter(true);
        ur4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a94));
        ur4Var.setMessageShowCenter(true);
        ur4Var.setCancelable(false);
        ur4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a95), new n(this, metaData));
        ur4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a96), new o(this, metaData));
        ur4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new nu4();
        }
        if (this.K == null) {
            rk8 rk8Var = new rk8();
            this.K = rk8Var;
            rk8Var.a = this.a.getUniqueId();
        }
        lo4 lo4Var = new lo4();
        lo4Var.b = 5;
        lo4Var.h = 8;
        lo4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.K() != null) {
            lo4Var.f = this.a.K().R1();
        }
        lo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                lo4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                    return;
                }
                this.J.b(this.a.P(), lo4Var, agreeData, this.a.K().S1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            lo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            lo4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.r == null) {
                this.r = new uu4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, qi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void D0(SparseArray<Object> sparseArray, int i2, al5 al5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), al5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new bl5(this.a.getPageContext(), this.a.getView(), al5Var, userData);
        }
        this.w.C(z2);
        AntiData L = L();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04bf), this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.w.D(cq4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<bs4> c2;
        bs4 bs4Var;
        bs4 bs4Var2;
        bs4 bs4Var3;
        bs4 bs4Var4;
        bs4 bs4Var5;
        bs4 bs4Var6;
        zm zmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
                        } else {
                            this.C = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view2.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        G0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
            this.G = postData;
            if (postData == null || this.a.U3() == null) {
                return true;
            }
            boolean z5 = this.a.U3().e() && this.G.K() != null && this.G.K().equals(this.a.K().N1());
            boolean z6 = this.a.K().S1() != null && this.a.K().S1().i0();
            if (this.c == null) {
                fs4 fs4Var = new fs4(this.a.getContext());
                this.c = fs4Var;
                fs4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (zmVar = this.A) == null || zmVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092001) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092001)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
            boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092009) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092009)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new bs4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f108e), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new bs4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f108f), this.c));
            }
            if (!z7 && !z8) {
                bs4 bs4Var7 = new bs4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044d), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fe8, this.G);
                bs4Var7.d.setTag(sparseArray3);
                arrayList.add(bs4Var7);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    bs4Var6 = new bs4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fd2), this.c);
                } else {
                    bs4Var6 = new bs4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a91), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091fe8, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
                bs4Var6.d.setTag(sparseArray4);
                arrayList.add(bs4Var6);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    bs4 bs4Var8 = new bs4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b34), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray5.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    bs4Var8.d.setTag(sparseArray5);
                    arrayList.add(bs4Var8);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        bs4 bs4Var9 = new bs4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff7), this.c);
                        bs4Var9.d.setTag(str);
                        arrayList.add(bs4Var9);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ff8, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray6.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        if (z4) {
                            bs4Var5 = new bs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ab), this.c);
                            bs4Var5.d.setTag(sparseArray6);
                            bs4Var2 = new bs4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e3), this.c);
                            bs4Var2.d.setTag(sparseArray6);
                            bs4Var3 = bs4Var5;
                            bs4Var = null;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                    }
                    bs4Var5 = null;
                    bs4Var2 = new bs4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e3), this.c);
                    bs4Var2.d.setTag(sparseArray6);
                    bs4Var3 = bs4Var5;
                    bs4Var = null;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                    if (this.a.K().S1().W() == 1002 && !booleanValue2) {
                        bs4Var4 = new bs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff7), this.c);
                    } else {
                        bs4Var4 = new bs4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04ab), this.c);
                    }
                    bs4Var4.d.setTag(sparseArray7);
                    if (booleanValue8) {
                        bs4Var = new bs4(13, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b24), this.c);
                        bs4Var3 = bs4Var4;
                    } else {
                        bs4Var3 = bs4Var4;
                        bs4Var = null;
                    }
                    bs4Var2 = null;
                } else {
                    bs4Var = null;
                    bs4Var2 = null;
                    bs4Var3 = null;
                }
                if (bs4Var3 != null) {
                    arrayList.add(bs4Var3);
                }
                if (bs4Var != null) {
                    arrayList.add(bs4Var);
                }
                if (bs4Var2 != null) {
                    arrayList.add(bs4Var2);
                }
                ez7.b(arrayList, this.c, this.G, this.a.K());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = ez7.d(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                c2 = ez7.c(arrayList, this.G.q(), sparseArray, this.c);
            }
            ez7.l(c2, this.O);
            ez7.f(c2);
            this.c.o(ez7.g(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(c2, false);
            } else {
                this.c.k(c2, true);
            }
            ds4 ds4Var = new ds4(this.a.getPageContext(), this.c);
            this.b = ds4Var;
            ds4Var.k();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.K().m2()).param("fid", this.a.K().getForumId()).param("uid", this.a.K().S1().O().getAuthor().getUserId()).param("post_id", this.a.K().B()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ur4 ur4Var = new ur4(this.a.getPageContext().getPageActivity());
            ur4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b33));
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf6, new b0(this));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new c0(this));
            ur4Var.create(this.a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.h4();
            ds4 ds4Var = this.b;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            this.a.i4();
            K();
        }
    }

    public void F0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer)) {
            ds4 ds4Var = this.b;
            if (ds4Var != null && ds4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092040);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                fs4 fs4Var = new fs4(this.a.getBaseFragmentActivity());
                fs4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe4)).intValue() : -1) == 1) {
                    arrayList.add(new bs4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04ab), fs4Var));
                }
                if (z2) {
                    arrayList.add(new bs4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1499), fs4Var));
                } else {
                    arrayList.add(new bs4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b30), fs4Var));
                }
                fs4Var.j(arrayList);
                ds4 ds4Var2 = new ds4(this.a.getPageContext(), fs4Var);
                this.b = ds4Var2;
                ds4Var2.k();
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.h4();
            ds4 ds4Var = this.b;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            K();
        }
    }

    public void G0(wr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, cVar, z2) == null) {
            ds4 ds4Var = this.d;
            if (ds4Var != null) {
                ds4Var.dismiss();
                this.d = null;
            }
            fs4 fs4Var = new fs4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.K().S1() != null && this.a.K().S1().O() != null && !this.a.K().S1().O().isBjh()) {
                arrayList.add(new bs4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f108e), fs4Var));
            }
            if (!z2) {
                arrayList.add(new bs4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f108f), fs4Var));
            }
            fs4Var.j(arrayList);
            fs4Var.n(new s(this, cVar));
            ds4 ds4Var2 = new ds4(this.a.getPageContext(), fs4Var);
            this.d = ds4Var2;
            ds4Var2.k();
        }
    }

    public void H() {
        ds4 ds4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ds4Var = this.b) == null) {
            return;
        }
        ds4Var.dismiss();
    }

    public void H0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onItemClickListener) == null) {
            yr4 yr4Var = this.h;
            if (yr4Var != null) {
                yr4Var.d();
                this.h = null;
            }
            if (this.a.K() == null) {
                return;
            }
            ArrayList<hs4> arrayList = new ArrayList<>();
            arrayList.add(new hs4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0270), "", this.a.K().b2() == 1, Integer.toString(1)));
            arrayList.add(new hs4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b40), "", this.a.K().b2() == 2, Integer.toString(5)));
            arrayList.add(new hs4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3d), "", this.a.K().b2() == 3, Integer.toString(6)));
            arrayList.add(new hs4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b5b), "", this.a.K().b2() == 4, Integer.toString(7)));
            yr4 yr4Var2 = new yr4(this.a.getPageContext());
            yr4Var2.l(R.string.obfuscated_res_0x7f0f0de6);
            this.h = yr4Var2;
            yr4Var2.k(arrayList, onItemClickListener);
            yr4Var2.c();
            this.h.n();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            rg.a().postDelayed(this.I, 100L);
        }
    }

    public void I0(vw7 vw7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, vw7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new uw7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        tg.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = qi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f6);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.y());
        this.u.Q(vw7Var == null ? false : vw7Var.a);
        this.u.D(vw7Var == null ? false : vw7Var.n);
        this.u.F(vw7Var == null ? false : vw7Var.e);
        this.u.L(vw7Var == null ? false : vw7Var.i);
        this.u.G(vw7Var == null ? false : vw7Var.f);
        this.u.S(vw7Var != null ? vw7Var.c : true);
        this.u.P(vw7Var == null ? false : vw7Var.k);
        this.u.H(vw7Var == null ? false : vw7Var.l, vw7Var.t);
        if (vw7Var == null) {
            this.u.N(false, false);
            this.u.M(false, false);
        } else {
            this.u.N(vw7Var.g, vw7Var.s);
            this.u.M(vw7Var.h, vw7Var.r);
        }
        boolean z2 = vw7Var == null ? false : vw7Var.q;
        boolean z3 = vw7Var == null ? false : vw7Var.o;
        boolean z4 = vw7Var == null ? false : vw7Var.d;
        boolean z5 = vw7Var == null ? false : vw7Var.b;
        boolean z6 = vw7Var == null ? false : vw7Var.p;
        boolean z7 = vw7Var == null ? false : vw7Var.j;
        boolean z8 = vw7Var == null ? false : vw7Var.m;
        this.u.J(z4, z3);
        this.u.R(z5, z2);
        this.u.O(z7, z6);
        this.u.U(z8);
        if (vw7Var != null) {
            uw7 uw7Var = this.u;
            boolean z9 = vw7Var.u;
            uw7Var.w = z9;
            if (z9) {
                uw7Var.m().setText(R.string.obfuscated_res_0x7f0f0ff7);
                this.u.G(false);
            }
        }
        this.u.E(vw7Var != null ? vw7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().Q() != null && this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.k().setText(R.string.obfuscated_res_0x7f0f0837);
        }
        O0();
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        tg.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public final void J0(ur4 ur4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, ur4Var, i2) == null) || (absVideoPbFragment = this.a) == null || ur4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new yk5(this.a.getPageContext(), this.a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04bf), this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.v.x(cq4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, ur4Var));
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ur4 ur4Var = this.e;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                tg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                tg.b(dialog2, this.a.getPageContext());
            }
            ds4 ds4Var = this.q;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
        }
    }

    public void K0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null) {
            return;
        }
        ds4 ds4Var = new ds4(this.a.getPageContext());
        if (this.a.K().S1().f == null || this.a.K().S1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11b1), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11b2)};
        } else {
            strArr = new String[this.a.K().S1().f.size()];
            for (int i2 = 0; i2 < this.a.K().S1().f.size(); i2++) {
                strArr[i2] = this.a.K().S1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11af);
            }
        }
        ds4Var.i(null, strArr, new m(this, ds4Var, view2));
        ds4Var.k();
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.K() == null || this.a.K().S1() == null) {
                return null;
            }
            return this.a.K().S1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            ur4 ur4Var = new ur4(this.a.getPageContext().getPageActivity());
            ur4Var.setMessage(str);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a1, new p(this));
            ur4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a1);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                C0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            ur4 ur4Var = new ur4(this.a.getBaseFragmentActivity());
            if (pi.isEmpty(str)) {
                ur4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f031e, str3));
            } else {
                ur4Var.setMessage(str);
            }
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new q(this, userMuteAddAndDelCustomMessage));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new r(this));
            ur4Var.create(this.a.getPageContext()).show();
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(ez7.m(i2))));
        }
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public final void O0() {
        uw7 uw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (uw7Var = this.u) == null) {
            return;
        }
        uw7Var.C();
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public uw7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : (uw7) invokeV.objValue;
    }

    public wr4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s : (wr4) invokeV.objValue;
    }

    public int S(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null) {
                return 0;
            }
            if (et7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (et7Var.O().getThreadType() == 54) {
                return 2;
            }
            return et7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092042) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            M0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.K().m2(), str);
                ThreadData O = this.a.K().S1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (uu4Var = this.r) == null) {
            return;
        }
        uu4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.s == null) {
            this.s = new wr4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0365), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11ab), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c0)};
            wr4 wr4Var = this.s;
            wr4Var.j(strArr, new l(this));
            wr4Var.g(wr4.b.obfuscated_res_0x7f1003ac);
            wr4Var.h(17);
            wr4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? ez7.i(this.a.K()) : invokeV.booleanValue;
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.K().S1().V() != null && (forumToolAuth = this.a.K().S1().V().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z2)) == null) {
            if (this.a.K() != null && this.a.K().S1() != null) {
                return ((this.a.K().S1().W() != 0) || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null || TextUtils.equals(this.a.K().S1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.K() != null && postData.K().equals(this.a.K().N1())) {
            z2 = true;
        }
        MarkData M1 = this.a.K().M1(postData);
        if (this.a.K().S1() != null && this.a.K().S1().i0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData M3 = absVideoPbFragment.M3(absVideoPbFragment.K().S1());
            if (M3 != null) {
                M1 = this.a.K().M1(M3);
            }
        }
        if (M1 == null) {
            return;
        }
        this.a.r5();
        if (this.a.U3() != null) {
            this.a.U3().i(M1);
            if (!z2) {
                this.a.U3().a();
            } else {
                this.a.U3().d();
            }
        }
    }

    public void f0(ArrayList<sp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e2, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().k(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a7);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cc3);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cc2);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a0);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.k = textView2;
                textView2.setOnClickListener(this.a.R3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13ca));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    sp4 sp4Var = arrayList.get(i2);
                    if (sp4Var != null && !TextUtils.isEmpty(sp4Var.b()) && sp4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(sp4Var.a()), sp4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = qi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = qi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = qi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            tg.j(this.g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a0 : R.string.obfuscated_res_0x7f0f0ff4;
            int i5 = R.string.obfuscated_res_0x7f0f0439;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f04a4;
                    i4 = R.string.obfuscated_res_0x7f0f04a5;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0ff8;
                }
            }
            this.e = new ur4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                w0(sparseArray, i5, i4);
            } else if (z2) {
                w0(sparseArray, i5, i4);
            } else if (r0()) {
                al5 al5Var = new al5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
                al5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
                al5Var.h(this.a.K().S1().l().getImage_url());
                al5Var.j(this.a.K().S1().l().getUser_level());
                D0(sparseArray, i2, al5Var, this.a.K().S1().V(), false);
            } else {
                J0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                s0(sparseArray);
            } else {
                t0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        bs4 bs4Var;
        bs4 bs4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, sparseArray, z2) == null) {
            fs4 fs4Var = new fs4(this.a.getContext());
            fs4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e3));
            fs4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe4)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fea)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue() : -1) == 0) {
                    bs4Var2 = new bs4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04b6), fs4Var);
                } else {
                    bs4Var2 = new bs4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), fs4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray2.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                sparseArray2.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                bs4Var2.d.setTag(sparseArray2);
                arrayList.add(bs4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092009) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092009)).booleanValue()) {
                bs4 bs4Var3 = new bs4(13, this.a.getString(R.string.obfuscated_res_0x7f0f0b24), fs4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray3.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                sparseArray3.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                bs4Var3.d.setTag(sparseArray3);
                arrayList.add(bs4Var3);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff5)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff6))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                sparseArray4.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                bs4 bs4Var4 = new bs4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0654), fs4Var);
                bs4Var4.d.setTag(sparseArray4);
                arrayList.add(bs4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                if (z2) {
                    bs4Var = new bs4(12, this.a.getString(R.string.obfuscated_res_0x7f0f1499), fs4Var);
                } else {
                    bs4Var = new bs4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b30), fs4Var);
                }
                bs4Var.d.setTag(sparseArray5);
                arrayList.add(bs4Var);
            }
            ez7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                fs4Var.k(arrayList, false);
            } else {
                fs4Var.k(arrayList, true);
            }
            ds4 ds4Var = this.q;
            if (ds4Var == null) {
                this.q = new ds4(this.a.getPageContext(), fs4Var);
            } else {
                ds4Var.h(fs4Var);
            }
            this.q.k();
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        et7 S1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (O = (S1 = this.a.K().S1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.h4();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        vw7 vw7Var = new vw7();
        int W = this.a.K().S1().W();
        boolean z2 = true;
        if (W != 1 && W != 3) {
            vw7Var.g = false;
        } else {
            vw7Var.g = true;
            vw7Var.s = O.getIs_top() == 1;
        }
        if (Z(W)) {
            vw7Var.h = true;
            vw7Var.r = O.getIs_good() == 1;
        } else {
            vw7Var.h = false;
        }
        if (W == 1002 && !equals) {
            vw7Var.u = true;
        }
        vw7Var.n = z0(O.isBlocked(), S1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        vw7Var.e = v0(equals, S1.k0());
        vw7Var.i = A0();
        vw7Var.f = y0(equals);
        vw7Var.k = equals && S1.V() != null && S1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            vw7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        vw7Var.t = equals;
        vw7Var.q = this.a.K().k2();
        vw7Var.b = true;
        vw7Var.a = b0(equals);
        vw7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        vw7Var.j = true;
        vw7Var.o = this.a.K().v1();
        vw7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            vw7Var.c = true;
        } else {
            vw7Var.c = false;
        }
        if (S1.i0()) {
            vw7Var.b = false;
            vw7Var.d = false;
            vw7Var.c = false;
            vw7Var.g = false;
            vw7Var.h = false;
        }
        vw7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S1.i0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.M3(absVideoPbFragment2.K().S1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            vw7Var.w = absVideoPbFragment3.M3(absVideoPbFragment3.K().S1()).Q;
        }
        if (O.isBlocked()) {
            vw7Var.n = false;
            vw7Var.g = false;
            vw7Var.h = false;
        }
        I0(vw7Var);
    }

    public final void n0(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091852, Integer.valueOf(this.O ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.x.i();
        }
    }

    public void p0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            this.O = z2;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void s0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1174, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b2c);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b2d);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new f(this, w2, sparseArray));
        aVar2.a(new g(this, w2));
    }

    public final void t0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048635, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.TRUE);
        }
        al5 al5Var = new al5(this.a.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.K().S1().o().has_forum_rule.intValue());
        al5Var.i(this.a.K().S1().l().getId(), this.a.K().S1().l().getName());
        al5Var.h(this.a.K().S1().l().getImage_url());
        al5Var.j(this.a.K().S1().l().getUser_level());
        D0(sparseArray, i2, al5Var, this.a.K().S1().V(), true);
    }

    public final void u0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            ez7.e(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean v0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        kp4 kp4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.K() == null || this.a.K().S1() == null) {
                return false;
            }
            et7 S1 = this.a.K().S1();
            ThreadData O = S1.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !gg6.isOn()) || this.a.K().H() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (S1.l() == null || !S1.l().isBlockBawuDelete) {
                if (S1.O() == null || !S1.O().isBlocked()) {
                    if (S1.W() != 0) {
                        return S1.W() != 3;
                    }
                    List<er4> p2 = S1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (er4 er4Var : p2) {
                            if (er4Var != null && (kp4Var = er4Var.g) != null && kp4Var.a && !kp4Var.c && ((i2 = kp4Var.b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void w0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048638, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ab, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.P());
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        androidx.appcompat.app.AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new d(this, w2, sparseArray));
        aVar2.a(new e(this, w2));
    }

    public void x0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        bs4 bs4Var;
        bs4 bs4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null) {
            return;
        }
        if (this.c == null) {
            fs4 fs4Var = new fs4(this.a.getContext());
            this.c = fs4Var;
            fs4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.K().S1() != null && this.a.K().S1().i0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            bs4 bs4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z3 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0087;
                }
                bs4 bs4Var4 = new bs4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fe8, postData);
                bs4Var4.d.setTag(sparseArray2);
                arrayList.add(bs4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    bs4 bs4Var5 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b34), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    bs4Var5.d.setTag(sparseArray3);
                    arrayList.add(bs4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        bs4 bs4Var6 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ff7), this.c);
                        bs4Var6.d.setTag(str);
                        arrayList.add(bs4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        bs4 bs4Var7 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.c);
                        bs4Var7.d.setTag(sparseArray4);
                        bs4Var3 = bs4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                    }
                    bs4 bs4Var8 = new bs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e3), this.c);
                    bs4Var8.d.setTag(sparseArray4);
                    bs4Var2 = bs4Var8;
                    bs4Var = bs4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                    if (this.a.K().S1().W() == 1002 && !booleanValue) {
                        bs4Var = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ff7), this.c);
                    } else {
                        bs4Var = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.c);
                    }
                    bs4Var.d.setTag(sparseArray5);
                    bs4Var2 = null;
                } else {
                    bs4Var = null;
                    bs4Var2 = null;
                }
                if (bs4Var != null) {
                    arrayList.add(bs4Var);
                }
                if (bs4Var2 != null) {
                    arrayList.add(bs4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new bs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031f), this.c));
                }
            }
            this.c.j(arrayList);
            ds4 ds4Var = new ds4(this.a.getPageContext(), this.c);
            this.b = ds4Var;
            ds4Var.k();
        }
    }

    public final boolean y0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.K() == null || this.a.K().S1() == null || (this.a.K().S1().l() != null && this.a.K().S1().l().isBlockBawuDelete)) {
                return false;
            }
            et7 S1 = this.a.K().S1();
            if ((S1.O() == null || S1.O().getAuthor() == null || !S1.O().getAuthor().isForumBusinessAccount() || gg6.isOn()) && !this.a.K().H()) {
                return ((S1.O() != null && S1.O().isBlocked()) || this.a.K().S1().W() == 0 || this.a.K().S1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean z0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            return z3 && (z4 || a0(i2));
        }
        return invokeCommon.booleanValue;
    }
}
