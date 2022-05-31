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
import com.repackage.dq4;
import com.repackage.fq4;
import com.repackage.lh5;
import com.repackage.oh5;
import com.repackage.oq4;
import com.repackage.v25;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes5.dex */
public class dx7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public um A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public us4 J;
    public qg8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public oq4.e N;
    public boolean O;
    public final fq4.c P;
    public AbsVideoPbFragment a;
    public mq4 b;
    public oq4 c;
    public mq4 d;
    public dq4 e;
    public Dialog f;
    public Dialog g;
    public hq4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public mq4 q;
    public at4 r;
    public fq4 s;
    public AlertDialog t;
    public zs7 u;
    public lh5 v;
    public oh5 w;
    public kv7 x;
    public PbFragment.e3 y;
    public st7 z;

    /* loaded from: classes5.dex */
    public class a implements fq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public a(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.repackage.fq4.c
        public void a(fq4 fq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fq4Var, i, view2) == null) {
                if (fq4Var != null) {
                    fq4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        v25.a aVar = new v25.a();
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
                        dx7 dx7Var = this.a;
                        dx7Var.z = new st7(dx7Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ dx7 e;

        public a0(dx7 dx7Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dx7Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e56), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ea7);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea9);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea8);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.L0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091ea5));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public b(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.a.K2(dq4Var, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public b0(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log("c10025");
                dq4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dx7 c;

        public d(dx7 dx7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx7Var;
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
                if (!ji.A()) {
                    li.N(this.c.a.w(), R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.c.a.J2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(dx7 dx7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dx7 c;

        public f(dx7 dx7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx7Var;
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
                if (!ji.A()) {
                    li.N(this.c.a.w(), R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.c.a.J2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(dx7 dx7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class h implements lh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ dx7 b;

        public h(dx7 dx7Var, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = dq4Var;
        }

        @Override // com.repackage.lh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.K2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements oh5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ dx7 b;

        public i(dx7 dx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.oh5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.J2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ dx7 b;

        public j(dx7 dx7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = z;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e73), sparseArray.get(R.id.obfuscated_res_0x7f091e61), sparseArray.get(R.id.obfuscated_res_0x7f091e64), sparseArray.get(R.id.obfuscated_res_0x7f091e62), sparseArray.get(R.id.obfuscated_res_0x7f091e63)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public k(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            og.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements fq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public l(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.repackage.fq4.c
        public void a(fq4 fq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fq4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    dx7 dx7Var = this.a;
                    dx7Var.H = dx7Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new tr7(this.a.a.v().h2(), this.a.H, "1").start();
                    fq4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    dx7 dx7Var2 = this.a;
                    dx7Var2.H = dx7Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new tr7(this.a.a.v().h2(), this.a.H, "2").start();
                    fq4Var.e();
                } else if (i == 2) {
                    dx7 dx7Var3 = this.a;
                    dx7Var3.H = dx7Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    fq4Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ dx7 c;

        public m(dx7 dx7Var, mq4 mq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, mq4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx7Var;
            this.a = mq4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.v().e2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.oq4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            boolean G3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, oq4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.v().e2() != 1 || i != 1) {
                if (this.c.a.v().e2() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.v().e2() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916fe ? 1 : 0).param("obj_type", i2));
                if (this.c.a.v().P1().f != null && this.c.a.v().P1().f.size() > i) {
                    i = this.c.a.v().P1().f.get(i).sort_type.intValue();
                }
                G3 = this.c.a.v().G3(i);
                this.b.setTag(Integer.valueOf(this.c.a.v().d2()));
                if (G3) {
                    return;
                }
                this.c.a.x4(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916fe ? 1 : 0).param("obj_type", i2));
            if (this.c.a.v().P1().f != null) {
                i = this.c.a.v().P1().f.get(i).sort_type.intValue();
            }
            G3 = this.c.a.v().G3(i);
            this.b.setTag(Integer.valueOf(this.c.a.v().d2()));
            if (G3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(dx7 dx7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, metaData};
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ dx7 b;

        public o(dx7 dx7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = metaData;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                dq4Var.dismiss();
                if (this.b.a.T2() != null) {
                    this.b.a.T2().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.v().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ dx7 b;

        public q(dx7 dx7Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq4.c a;
        public final /* synthetic */ dx7 b;

        public s(dx7 dx7Var, fq4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx7Var;
            this.a = cVar;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public t(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
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

    /* loaded from: classes5.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public u(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public v(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                og.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.e3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public w(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ji.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.v().P1().l().getId(), this.a.a.v().P1().l().getName(), this.a.a.v().P1().O().getId(), String.valueOf(this.a.a.v().P1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public x(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091675);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091674);
                        this.a.n0(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091677);
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.n0(view5);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091677);
                        this.a.n0(view6);
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                            return;
                        }
                        agreeView2.getImgAgree().performClick();
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                            return;
                        }
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            v25.a aVar = new v25.a();
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
                            dx7 dx7Var = this.a;
                            dx7Var.z = new st7(dx7Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.n());
                        this.a.A = null;
                        this.a.B = null;
                        return;
                    case 3:
                        PostData postData = this.a.G;
                        if (postData != null) {
                            postData.o0();
                            this.a.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.a.checkUpIsLogin()) {
                            this.a.d0(view2);
                            if (this.a.a.v().P1().O() == null || this.a.a.v().P1().O().getAuthor() == null || this.a.a.v().P1().O().getAuthor().getUserId() == null || this.a.a.g3() == null) {
                                return;
                            }
                            dx7 dx7Var2 = this.a;
                            int S = dx7Var2.S(dx7Var2.a.v().P1());
                            ThreadData O = this.a.a.v().P1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.v().h2()).param("obj_locate", 2).param("obj_id", this.a.a.v().P1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.g3().e()).param("obj_source", S).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ji.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
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
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e67, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e50, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e58) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e56) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e73) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e57)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e73)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e68)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.a.a;
                            if (absVideoPbFragment == null || absVideoPbFragment.w() == null) {
                                return;
                            }
                            boolean isHost = this.a.a.w().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e56), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e56), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ji.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e97)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e95)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e67, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e50, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e50, 2);
                            }
                            this.a.l0(view2);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54);
                            if (postData2.q() == null) {
                                return;
                            }
                            z65 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                            if (findPageExtraByView != null) {
                                postData2.q().objSource = findPageExtraByView.a();
                            }
                            this.a.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.v() == null || this.a.a.v().P1() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.w() == null) {
                            return;
                        }
                        this.a.a.w().showBlockDialog(zn8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ dx7 d;

        public y(dx7 dx7Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dx7Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                if (dq4Var != null) {
                    dq4Var.dismiss();
                }
                this.d.a.L2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e56), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755751954, "Lcom/repackage/dx7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755751954, "Lcom/repackage/dx7;");
        }
    }

    public dx7(AbsVideoPbFragment absVideoPbFragment) {
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
        kv7 kv7Var = new kv7(this.a.getContext());
        this.x = kv7Var;
        kv7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        dq4 dq4Var = new dq4(this.a.getActivity());
        dq4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a90));
        dq4Var.setTitleShowCenter(true);
        dq4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a91));
        dq4Var.setMessageShowCenter(true);
        dq4Var.setCancelable(false);
        dq4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a92), new n(this, metaData));
        dq4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a93), new o(this, metaData));
        dq4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = jg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = jg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.r == null) {
                this.r = new at4(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new us4();
        }
        if (this.K == null) {
            qg8 qg8Var = new qg8();
            this.K = qg8Var;
            qg8Var.a = this.a.getUniqueId();
        }
        um4 um4Var = new um4();
        um4Var.b = 5;
        um4Var.h = 8;
        um4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.v() != null) {
            um4Var.f = this.a.v().O1();
        }
        um4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                um4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.v() == null || this.a.v().P1() == null) {
                    return;
                }
                this.J.b(this.a.w(), um4Var, agreeData, this.a.v().P1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            um4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            um4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, nh5 nh5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), nh5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new oh5(this.a.getPageContext(), this.a.getView(), nh5Var, userData);
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
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.getString(R.string.obfuscated_res_0x7f0f04b9), this.a.getString(R.string.obfuscated_res_0x7f0f04ba), this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.getString(R.string.obfuscated_res_0x7f0f04bc)});
        this.w.D(lo4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, li.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            dq4 dq4Var = new dq4(this.a.getPageContext().getPageActivity());
            dq4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b2e));
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new b0(this));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new c0(this));
            dq4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<kq4> b2;
        kq4 kq4Var;
        kq4 kq4Var2;
        kq4 kq4Var3;
        kq4 kq4Var4;
        kq4 kq4Var5;
        um umVar;
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8b) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8b) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8b);
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
                        F0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54);
            this.G = postData;
            if (postData == null || this.a.g3() == null) {
                return true;
            }
            boolean z5 = this.a.g3().e() && this.G.I() != null && this.G.I().equals(this.a.v().K1());
            boolean z6 = this.a.v().P1() != null && this.a.v().P1().g0();
            if (this.c == null) {
                oq4 oq4Var = new oq4(this.a.getContext());
                this.c = oq4Var;
                oq4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (umVar = this.A) == null || umVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e64) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e64) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new kq4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1096), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new kq4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1097), this.c));
            }
            if (!z7 && !z8) {
                kq4 kq4Var6 = new kq4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f044a), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e54, this.G);
                kq4Var6.d.setTag(sparseArray3);
                arrayList.add(kq4Var6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    kq4Var5 = new kq4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fad), this.c);
                } else {
                    kq4Var5 = new kq4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a8e), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e54, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, Boolean.FALSE);
                kq4Var5.d.setTag(sparseArray4);
                arrayList.add(kq4Var5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    kq4 kq4Var7 = new kq4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b2f), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    kq4Var7.d.setTag(sparseArray5);
                    arrayList.add(kq4Var7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        kq4 kq4Var8 = new kq4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fd0), this.c);
                        kq4Var8.d.setTag(str);
                        arrayList.add(kq4Var8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e64, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                        if (z4) {
                            kq4 kq4Var9 = new kq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4), this.c);
                            kq4Var9.d.setTag(sparseArray6);
                            kq4Var4 = kq4Var9;
                            kq4Var = new kq4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                            kq4Var.d.setTag(sparseArray6);
                            kq4Var2 = kq4Var4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                    }
                    kq4Var4 = null;
                    kq4Var = new kq4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                    kq4Var.d.setTag(sparseArray6);
                    kq4Var2 = kq4Var4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    if (this.a.v().P1().V() == 1002 && !booleanValue2) {
                        kq4Var3 = new kq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fd0), this.c);
                    } else {
                        kq4Var3 = new kq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4), this.c);
                    }
                    kq4Var3.d.setTag(sparseArray7);
                    kq4Var2 = kq4Var3;
                    kq4Var = null;
                } else {
                    kq4Var = null;
                    kq4Var2 = null;
                }
                if (kq4Var2 != null) {
                    arrayList.add(kq4Var2);
                }
                if (kq4Var != null) {
                    arrayList.add(kq4Var);
                }
                ev7.a(arrayList, this.c, this.G, this.a.v());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = ev7.c(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                b2 = ev7.b(arrayList, this.G.q(), sparseArray, this.c);
            }
            ev7.k(b2, this.O);
            ev7.e(b2);
            this.c.o(ev7.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(b2, false);
            } else {
                this.c.k(b2, true);
            }
            mq4 mq4Var = new mq4(this.a.getPageContext(), this.c);
            this.b = mq4Var;
            mq4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.v().h2()).param("fid", this.a.v().getForumId()).param("uid", this.a.v().P1().O().getAuthor().getUserId()).param("post_id", this.a.v().A()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea6) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer)) {
            mq4 mq4Var = this.b;
            if (mq4Var != null && mq4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea4);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                oq4 oq4Var = new oq4(this.a.getBaseFragmentActivity());
                oq4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e50)).intValue() : -1) == 1) {
                    arrayList.add(new kq4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a4), oq4Var));
                }
                if (z2) {
                    arrayList.add(new kq4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14a3), oq4Var));
                } else {
                    arrayList.add(new kq4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b2b), oq4Var));
                }
                oq4Var.j(arrayList);
                mq4 mq4Var2 = new mq4(this.a.getPageContext(), oq4Var);
                this.b = mq4Var2;
                mq4Var2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.t3();
            mq4 mq4Var = this.b;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            this.a.u3();
            K();
        }
    }

    public void F0(fq4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            mq4 mq4Var = this.d;
            if (mq4Var != null) {
                mq4Var.dismiss();
                this.d = null;
            }
            oq4 oq4Var = new oq4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.v().P1() != null && this.a.v().P1().O() != null && !this.a.v().P1().O().isBjh()) {
                arrayList.add(new kq4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1096), oq4Var));
            }
            if (!z2) {
                arrayList.add(new kq4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1097), oq4Var));
            }
            oq4Var.j(arrayList);
            oq4Var.n(new s(this, cVar));
            mq4 mq4Var2 = new mq4(this.a.getPageContext(), oq4Var);
            this.d = mq4Var2;
            mq4Var2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.t3();
            mq4 mq4Var = this.b;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            hq4 hq4Var = this.h;
            if (hq4Var != null) {
                hq4Var.d();
                this.h = null;
            }
            if (this.a.v() == null) {
                return;
            }
            ArrayList<qq4> arrayList = new ArrayList<>();
            arrayList.add(new qq4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f026a), "", this.a.v().Y1() == 1, Integer.toString(1)));
            arrayList.add(new qq4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3c), "", this.a.v().Y1() == 2, Integer.toString(5)));
            arrayList.add(new qq4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b38), "", this.a.v().Y1() == 3, Integer.toString(6)));
            arrayList.add(new qq4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", this.a.v().Y1() == 4, Integer.toString(7)));
            hq4 hq4Var2 = new hq4(this.a.getPageContext());
            hq4Var2.l(R.string.obfuscated_res_0x7f0f0dd7);
            this.h = hq4Var2;
            hq4Var2.k(arrayList, onItemClickListener);
            hq4Var2.c();
            this.h.n();
        }
    }

    public void H() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (mq4Var = this.b) == null) {
            return;
        }
        mq4Var.dismiss();
    }

    public void H0(at7 at7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, at7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new zs7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        og.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = li.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.u());
        this.u.M(at7Var == null ? false : at7Var.a);
        this.u.z(at7Var == null ? false : at7Var.n);
        this.u.B(at7Var == null ? false : at7Var.e);
        this.u.G(at7Var == null ? false : at7Var.i);
        this.u.C(at7Var == null ? false : at7Var.f);
        this.u.O(at7Var != null ? at7Var.c : true);
        this.u.L(at7Var == null ? false : at7Var.k);
        this.u.D(at7Var == null ? false : at7Var.l, at7Var.t);
        if (at7Var == null) {
            this.u.I(false, false);
            this.u.H(false, false);
        } else {
            this.u.I(at7Var.g, at7Var.s);
            this.u.H(at7Var.h, at7Var.r);
        }
        boolean z2 = at7Var == null ? false : at7Var.q;
        boolean z3 = at7Var == null ? false : at7Var.o;
        boolean z4 = at7Var == null ? false : at7Var.d;
        boolean z5 = at7Var == null ? false : at7Var.b;
        boolean z6 = at7Var == null ? false : at7Var.p;
        boolean z7 = at7Var == null ? false : at7Var.j;
        boolean z8 = at7Var == null ? false : at7Var.m;
        this.u.E(z4, z3);
        this.u.N(z5, z2);
        this.u.K(z7, z6);
        this.u.Q(z8);
        if (at7Var != null) {
            zs7 zs7Var = this.u;
            boolean z9 = at7Var.u;
            zs7Var.w = z9;
            if (z9) {
                zs7Var.h().setText(R.string.obfuscated_res_0x7f0f0fd0);
                this.u.C(false);
            }
        }
        this.u.A(at7Var != null ? at7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().Q() != null && this.a.v().P1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.e().setText(R.string.obfuscated_res_0x7f0f0821);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            mg.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(dq4 dq4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, dq4Var, i2) == null) || (absVideoPbFragment = this.a) == null || dq4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new lh5(this.a.getPageContext(), this.a.getView());
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
        lo4 lo4Var = new lo4();
        lo4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04b8), this.a.getString(R.string.obfuscated_res_0x7f0f04b9), this.a.getString(R.string.obfuscated_res_0x7f0f04ba), this.a.getString(R.string.obfuscated_res_0x7f0f04bb), this.a.getString(R.string.obfuscated_res_0x7f0f04bc)});
        this.v.x(lo4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, dq4Var));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        og.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null) {
            return;
        }
        mq4 mq4Var = new mq4(this.a.getPageContext());
        if (this.a.v().P1().f == null || this.a.v().P1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11c0), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11c1)};
        } else {
            strArr = new String[this.a.v().P1().f.size()];
            for (int i2 = 0; i2 < this.a.v().P1().f.size(); i2++) {
                strArr[i2] = this.a.v().P1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11be);
            }
        }
        mq4Var.j(null, strArr, new m(this, mq4Var, view2));
        mq4Var.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            dq4 dq4Var = this.e;
            if (dq4Var != null) {
                dq4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                og.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                og.b(dialog2, this.a.getPageContext());
            }
            mq4 mq4Var = this.q;
            if (mq4Var != null) {
                mq4Var.dismiss();
            }
        }
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            dq4 dq4Var = new dq4(this.a.getPageContext().getPageActivity());
            dq4Var.setMessage(str);
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f098e, new p(this));
            dq4Var.create(this.a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.v() == null || this.a.v().P1() == null) {
                return null;
            }
            return this.a.v().P1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void L0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                B0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            dq4 dq4Var = new dq4(this.a.getBaseFragmentActivity());
            if (ki.isEmpty(str)) {
                dq4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0317, str3));
            } else {
                dq4Var.setMessage(str);
            }
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new q(this, userMuteAddAndDelCustomMessage));
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new r(this));
            dq4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f090784);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.v().h2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(ev7.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        zs7 zs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (zs7Var = this.u) == null) {
            return;
        }
        zs7Var.y();
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public zs7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (zs7) invokeV.objValue;
    }

    public fq4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (fq4) invokeV.objValue;
    }

    public int S(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null) {
                return 0;
            }
            if (kp7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (kp7Var.O().getThreadType() == 54) {
                return 2;
            }
            return kp7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea7) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea9) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea8) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea4) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea4) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea5) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.v().h2(), str);
                ThreadData O = this.a.v().P1().O();
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
        at4 at4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (at4Var = this.r) == null) {
            return;
        }
        at4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new fq4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f036b), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11ba), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c8)};
            fq4 fq4Var = this.s;
            fq4Var.j(strArr, new l(this));
            fq4Var.g(fq4.b.obfuscated_res_0x7f1003a4);
            fq4Var.h(17);
            fq4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? ev7.h(this.a.v()) : invokeV.booleanValue;
    }

    public boolean Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.v().P1().U() != null && (forumToolAuth = this.a.v().P1().U().getForumToolAuth()) != null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z2)) == null) {
            if (this.a.v() != null && this.a.v().P1() != null) {
                return ((this.a.v().P1().V() != 0) || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null || TextUtils.equals(this.a.v().P1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.I() != null && postData.I().equals(this.a.v().K1())) {
            z2 = true;
        }
        MarkData J1 = this.a.v().J1(postData);
        if (this.a.v().P1() != null && this.a.v().P1().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData Y2 = absVideoPbFragment.Y2(absVideoPbFragment.v().P1());
            if (Y2 != null) {
                J1 = this.a.v().J1(Y2);
            }
        }
        if (J1 == null) {
            return;
        }
        this.a.D4();
        if (this.a.g3() != null) {
            this.a.g3().i(J1);
            if (!z2) {
                this.a.g3().a();
            } else {
                this.a.g3().d();
            }
        }
    }

    public void f0(ArrayList<bo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e4, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090c90);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090c8f);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090783);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090784);
                this.k = textView2;
                textView2.setOnClickListener(this.a.d3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13d6));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    bo4 bo4Var = arrayList.get(i2);
                    if (bo4Var != null && !TextUtils.isEmpty(bo4Var.b()) && bo4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(bo4Var.a()), bo4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = li.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = li.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = li.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            og.j(this.g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0499 : R.string.obfuscated_res_0x7f0f0fcd;
            int i5 = R.string.obfuscated_res_0x7f0f0436;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f049d;
                    i4 = R.string.obfuscated_res_0x7f0f049e;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fd1;
                }
            }
            this.e = new dq4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04ea, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray, i5, i4);
            } else if (z2) {
                v0(sparseArray, i5, i4);
            } else if (q0()) {
                nh5 nh5Var = new nh5(this.a.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.v().P1().o().has_forum_rule.intValue());
                nh5Var.i(this.a.v().P1().l().getId(), this.a.v().P1().l().getName());
                nh5Var.h(this.a.v().P1().l().getImage_url());
                nh5Var.j(this.a.v().P1().l().getUser_level());
                C0(sparseArray, i2, nh5Var, this.a.v().P1().U(), false);
            } else {
                I0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        kq4 kq4Var;
        kq4 kq4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            oq4 oq4Var = new oq4(this.a.getContext());
            oq4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02db));
            oq4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e50) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e50)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e56)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e58) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue() : -1) == 0) {
                    kq4Var2 = new kq4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04af), oq4Var);
                } else {
                    kq4Var2 = new kq4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), oq4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                kq4Var2.d.setTag(sparseArray2);
                arrayList.add(kq4Var2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e61)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e62))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                kq4 kq4Var3 = new kq4(11, this.a.getString(R.string.obfuscated_res_0x7f0f064c), oq4Var);
                kq4Var3.d.setTag(sparseArray3);
                arrayList.add(kq4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea4, sparseArray.get(R.id.obfuscated_res_0x7f091ea4));
                if (z2) {
                    kq4Var = new kq4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14a3), oq4Var);
                } else {
                    kq4Var = new kq4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b2b), oq4Var);
                }
                kq4Var.d.setTag(sparseArray4);
                arrayList.add(kq4Var);
            }
            oq4Var.j(arrayList);
            mq4 mq4Var = this.q;
            if (mq4Var == null) {
                this.q = new mq4(this.a.getPageContext(), oq4Var);
            } else {
                mq4Var.i(oq4Var);
            }
            this.q.m();
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        kp7 P1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null || this.a.v().P1() == null || (O = (P1 = this.a.v().P1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.t3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        at7 at7Var = new at7();
        int V = this.a.v().P1().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            at7Var.g = false;
        } else {
            at7Var.g = true;
            at7Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            at7Var.h = true;
            at7Var.r = O.getIs_good() == 1;
        } else {
            at7Var.h = false;
        }
        if (V == 1002 && !equals) {
            at7Var.u = true;
        }
        at7Var.n = y0(O.isBlocked(), P1.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        at7Var.e = u0(equals, P1.i0());
        at7Var.i = z0();
        at7Var.f = x0(equals);
        at7Var.k = equals && P1.U() != null && P1.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            at7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        at7Var.t = equals;
        at7Var.q = this.a.v().f2();
        at7Var.b = true;
        at7Var.a = b0(equals);
        at7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        at7Var.j = true;
        at7Var.o = this.a.v().s1();
        at7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            at7Var.c = true;
        } else {
            at7Var.c = false;
        }
        if (P1.g0()) {
            at7Var.b = false;
            at7Var.d = false;
            at7Var.c = false;
            at7Var.g = false;
            at7Var.h = false;
        }
        at7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !P1.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.Y2(absVideoPbFragment2.v().P1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            at7Var.w = absVideoPbFragment3.Y2(absVideoPbFragment3.v().P1()).Q;
        }
        if (O.isBlocked()) {
            at7Var.n = false;
            at7Var.g = false;
            at7Var.h = false;
        }
        H0(at7Var);
    }

    public final void n0(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09170c, Integer.valueOf(this.O ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public void o0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.O = z2;
        }
    }

    public void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.v().P1().l().getDeletedReasonInfo() == null || 1 != this.a.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6a, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1187, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rq4 rq4Var = new rq4(this.a.w());
        rq4Var.u(R.string.obfuscated_res_0x7f0f0b27);
        rq4Var.l(R.string.obfuscated_res_0x7f0f0b28);
        rq4Var.n(true);
        rq4Var.r(aVar2, aVar);
        rq4Var.i(false);
        androidx.appcompat.app.AlertDialog x2 = rq4Var.x();
        aVar.a(new f(this, x2, sparseArray));
        aVar2.a(new g(this, x2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6a, Boolean.TRUE);
        }
        nh5 nh5Var = new nh5(this.a.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.v().P1().o().has_forum_rule.intValue());
        nh5Var.i(this.a.v().P1().l().getId(), this.a.v().P1().l().getName());
        nh5Var.h(this.a.v().P1().l().getImage_url());
        nh5Var.j(this.a.v().P1().l().getUser_level());
        C0(sparseArray, i2, nh5Var, this.a.v().P1().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            ev7.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        tn4 tn4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.v() == null || this.a.v().P1() == null) {
                return false;
            }
            kp7 P1 = this.a.v().P1();
            ThreadData O = P1.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !rc6.isOn()) || this.a.v().G() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (P1.l() == null || !P1.l().isBlockBawuDelete) {
                if (P1.O() == null || !P1.O().isBlocked()) {
                    if (P1.V() != 0) {
                        return P1.V() != 3;
                    }
                    List<np4> p2 = P1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (np4 np4Var : p2) {
                            if (np4Var != null && (tn4Var = np4Var.g) != null && tn4Var.a && !tn4Var.c && ((i2 = tn4Var.b) == 1 || i2 == 2)) {
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

    public final void v0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048636, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04a4, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rq4 rq4Var = new rq4(this.a.w());
        rq4Var.u(i2);
        rq4Var.l(i3);
        rq4Var.n(true);
        rq4Var.r(aVar2, aVar);
        rq4Var.i(false);
        androidx.appcompat.app.AlertDialog x2 = rq4Var.x();
        aVar.a(new d(this, x2, sparseArray));
        aVar2.a(new e(this, x2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        kq4 kq4Var;
        kq4 kq4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e54)) == null) {
            return;
        }
        if (this.c == null) {
            oq4 oq4Var = new oq4(this.a.getContext());
            this.c = oq4Var;
            oq4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.v().P1() != null && this.a.v().P1().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e57) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            kq4 kq4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e64) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e64) : null;
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
                kq4 kq4Var4 = new kq4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e54, postData);
                kq4Var4.d.setTag(sparseArray2);
                arrayList.add(kq4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    kq4 kq4Var5 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b2f), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    kq4Var5.d.setTag(sparseArray3);
                    arrayList.add(kq4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        kq4 kq4Var6 = new kq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.c);
                        kq4Var6.d.setTag(str);
                        arrayList.add(kq4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e61, sparseArray.get(R.id.obfuscated_res_0x7f091e61));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e64, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                        kq4 kq4Var7 = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.c);
                        kq4Var7.d.setTag(sparseArray4);
                        kq4Var3 = kq4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                    }
                    kq4 kq4Var8 = new kq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                    kq4Var8.d.setTag(sparseArray4);
                    kq4Var2 = kq4Var8;
                    kq4Var = kq4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e73, sparseArray.get(R.id.obfuscated_res_0x7f091e73));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    if (this.a.v().P1().V() == 1002 && !booleanValue) {
                        kq4Var = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fd0), this.c);
                    } else {
                        kq4Var = new kq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.c);
                    }
                    kq4Var.d.setTag(sparseArray5);
                    kq4Var2 = null;
                } else {
                    kq4Var = null;
                    kq4Var2 = null;
                }
                if (kq4Var != null) {
                    arrayList.add(kq4Var);
                }
                if (kq4Var2 != null) {
                    arrayList.add(kq4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new kq4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0318), this.c));
                }
            }
            this.c.j(arrayList);
            mq4 mq4Var = new mq4(this.a.getPageContext(), this.c);
            this.b = mq4Var;
            mq4Var.m();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null || this.a.v().P1() == null || (this.a.v().P1().l() != null && this.a.v().P1().l().isBlockBawuDelete)) {
                return false;
            }
            kp7 P1 = this.a.v().P1();
            if ((P1.O() == null || P1.O().getAuthor() == null || !P1.O().getAuthor().isForumBusinessAccount() || rc6.isOn()) && !this.a.v().G()) {
                return ((P1.O() != null && P1.O().isBlocked()) || this.a.v().P1().V() == 0 || this.a.v().P1().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean y0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
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

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.v() == null || !this.a.v().f2()) {
                return false;
            }
            return this.a.v().N1() == null || this.a.v().N1().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
